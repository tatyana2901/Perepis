package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class Resident {
    private Gender gender;
    private int age;
    //public static ArrayList<Resident> residents = new ArrayList<>();

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resident resident = (Resident) o;
        return age == resident.age && gender == resident.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, age);
    }

    public Gender getGender() {
        return gender;
    }

    public Resident(Gender gender, int age) {
        this.gender = gender;
        this.age = age;
        //residents.add(this);
    }

    @Override
    public String toString() {
        return "Resident{" +
                "gender=" + gender +
                ", age=" + age +
                '}';
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
