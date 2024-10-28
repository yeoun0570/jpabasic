package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.domain.Grade;
import jpabasic.reserve.domain.Hotel;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

import static jpabasic.reserve.domain.Grade.S1;

public class Main04 {
    private static Logger logger = LoggerFactory.getLogger(Main04.class);

    public static void main(String[] args) {
        EMF.init();

        Hotel entity = new Hotel("H-01", "hotel_name", 2024, Grade.S7, LocalDateTime.now());

//        save(entity);
        Hotel hotel = read("H-01");
        logger.info("호텔 정보 : {}", hotel);

    }

    private static void save(Hotel entity) {
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            EMF.close();
        }
    }

    private static Hotel read(String id) {
        EntityManager entityManager = EMF.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Hotel hotel = new Hotel();

        try {
            transaction.begin();
            hotel = entityManager.find(Hotel.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            EMF.close();
        }

        return hotel;
    }
}
