package jpabasic.reserve.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;

public class GetUserService {

    public void getUser(String email) {
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            User user = entityManager.find(User.class, email);

            if(user == null) {
                System.out.println("사용자 없음");
            } else {
                System.out.printf("사용자 찾기 ::::::::::::::::: email = %s, name = %s, createDate = %s",user.getEmail(), user.getName(), user.getCreateDate());
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            EMF.close();
        }
    }
}
