package main;

import jakarta.persistence.*;
import jpabasic.reserve.domain.User;

import java.time.LocalDateTime;

public class UserSaveMain {
    public static void main(String[] args) {

        //엔티티 매니저를 생성할 수 있는 공장 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabegin");

        //엔티티 매니저 한명 생성
        EntityManager entityManager = emf.createEntityManager();
        // 트랜잭션을 관리할 수 있도록 엔티티 매니저에 권한 부여
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            User user = new User("yeoun@yeoun.com", "yeoun", LocalDateTime.now());
            entityManager.persist(user);
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
