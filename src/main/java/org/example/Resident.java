package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class Resident {
    private Gender gender;
    private int age;

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
    }
    @Override
    public String toString() {
        return "Resident{" +
                "gender=" + gender +
                ", age=" + age +
                '}';
    }

}
