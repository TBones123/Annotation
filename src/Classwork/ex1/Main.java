package Classwork.ex1;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
//    String email = "asdasd@gmail.com";
//        boolean matches = email.matches("[a-z0-9]{1,}@\\w{1,}\\.\\w{1,}");
//        System.out.println(matches);
        Person person = new Person(1, "Andrey", "asda,sd@asad.com");
        emailHandler(person);
        System.out.println(person);
    }
    public static void emailHandler (Person person) throws IllegalAccessException {
        Class<? extends Person> aClass = person.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(EmailValidator.class)) {
                String email = (String) field.get(person);
                if (!email.matches("[a-z0-9]{1,}@\\w{1,}\\.\\w{1,}")) {
                    EmailValidator annotation = field.getAnnotation(EmailValidator.class);
                    String message = annotation.message();
                    System.out.println(message);
                }
            }
        }
    }
}
