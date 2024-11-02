package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class ResidentLoader {
    String fileName;
    public static ArrayList<Resident> residents = new ArrayList<>();

    public static List <Resident> load(String fn) throws FileNotFoundException {
        ArrayList<String> arr = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fn))) {
            while (sc.hasNextLine()) {
                arr.add(sc.nextLine());
            }
        }
        arr.removeFirst();
        List <Resident> str = arr.stream().map(new Function<String, Resident>() {
            @Override
            public Resident apply(String s) {
                String[] strings = s.split("\\s+");
                return new Resident(Gender.values()[Integer.parseInt(strings[0])], Integer.parseInt(strings[1]));
            }
        }).toList();
        return str;
    }

    public static int findOldManNum() {
        try {
            return residents.indexOf(residents
                    .stream()
                    .filter(resident -> resident.getGender() == Gender.MEN)
                    .max(Comparator.comparingInt(Resident::getAge))
                    .get()) + 1;
        } catch (NoSuchElementException e) {
            return -1;
        }
    }

}
