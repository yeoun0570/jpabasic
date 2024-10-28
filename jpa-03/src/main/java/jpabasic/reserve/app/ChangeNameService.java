package jpabasic.reserve.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class ChangeNameService {

    public void changeName(String email, String newName) {
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            User user = entityManager.find(User.class, email);
            user.changeName(newName);
            System.out.printf("변경된 사용자 ::::::::::::::::: 이메일 = %s, 이름 = %s", user.getEmail(), user.getName());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            EMF.close();
        }
    }

    
}
