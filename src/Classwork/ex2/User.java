package Classwork.ex2;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class User {
    @NameUser (messege = "nope")
    private String surName;
    private String name;
}
