package jpabasic.reserve.main;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityTransaction;
import jpabasic.reserve.app.*;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalDateTime;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static NewUserService newUserService = new NewUserService();
    private static ChangeNameService changeNameService = new ChangeNameService();
    private static GetUserService getUserService = new GetUserService();
    private static RemoveUserService removeUserService = new RemoveUserService();

    public static void main(String[] args) throws IOException {
        EMF.init();
        //명령어 new, get, change name, remove, exit 을 이용하여 어플리케이션 완성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.print("명령어를 입력하세요 : ");
            String line = br.readLine();

            if(line.startsWith("new ")) {
                handleNew(line);
            } else if (line.startsWith("get ")) {
                handleGet(line);
            }else if (line.startsWith("change ")) {
                handleChangeName(line);
            } else if (line.startsWith("remove ")) {
                handleRemove(line);
            } else if (line.equals("exit")) {
                break;
            }
        }

    }

    private static void handleNew(String line) {
        String[] v = line.substring(4).split(" ");
        User u = new User(v[0], v[1], LocalDateTime.now());
        try {
            newUserService.saveNewUser(u);
            logger.info("새 사용자 저장: {}", u);
        } catch (EntityExistsException e) {
            logger.info("사용자가 이미 존재함: {}", u.getEmail());
        }
    }

    private static void handleGet(String line) {
        String[] v = line.substring(2).split(" ");
        String email = v[1];
        getUserService.getUser(email);
    }

    private static void handleChangeName(String line) {
        String[] v = line.substring(1).split(" ");
        String email = v[1];
        String newName = v[2];

        changeNameService.changeName(email, newName);
    }

    private static void handleRemove(String line) {
        String[] v = line.substring(2).split(" ");
        String email = v[1];
        removeUserService.removeUser(email);
    }
}
