package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jpabasic.reserve.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserUpdateMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            String newName = "변경된 이름";
            User user = entityManager.find(User.class, "이메일@이메일.com");
            user.changeName(newName);
            if(user == null) {
                System.out.println("없음");
            } else {
                System.out.printf("이메일 = %s, 이름 = %s", user.getEmail(), user.getName());
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
