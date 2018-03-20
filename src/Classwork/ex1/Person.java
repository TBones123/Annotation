package Classwork.ex1;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Person {
    @EmailValidator()
    private int id;
    @EmailValidator(message = "User email error!")
    private String email;
    private String name;
}
