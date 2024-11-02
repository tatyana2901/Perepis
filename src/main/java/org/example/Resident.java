package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Resident {
    private Gender gender;
    private int age;
    //public static ArrayList<Resident> residents = new ArrayList<>();

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Resident(Gender gender, int age) {
        this.gender = gender;
        this.age = age;
        //residents.add(this);
    }

   /* public static int findOldManNum() {
        try {
            return residents.indexOf(residents
                    .stream()
                    .filter(resident -> resident.getGender() == Gender.MEN)
                    .max(Comparator.comparingInt(Resident::getAge))
                    .get()) + 1;
        } catch (NoSuchElementException e) {
            return -1;
        }
    }*/
}
