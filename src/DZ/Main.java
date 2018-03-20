package DZ;

import Classwork.ex2.NameUser;
import Classwork.ex2.User;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Name", "Surname@!");
        nameHandler(user);
        System.out.println(user);

    }
    public static void nameHandler (User user) throws IllegalAccessException {
        Class<? extends User> userClass = user.getClass();
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NameUser.class)) {
                String userName = (String) field.get(user);
                if (!userName.matches("\\W")) {
                    NameUser annotation = field.getAnnotation(NameUser.class);
                    String messege = annotation.messege();
                    System.out.println(messege);
                }
            }
        }

    }
}
