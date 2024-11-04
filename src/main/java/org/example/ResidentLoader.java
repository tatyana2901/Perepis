package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ResidentLoader {

    public static List<Resident> load(String fn) throws Exception {
        ArrayList<String> arr = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fn))) {
            while (sc.hasNextLine()) {
                arr.add(sc.nextLine());
            }
        }
        arr.removeFirst();
        try {
            return arr
                    .stream()
                    .map(s -> {
                String[] strings = s.split("\\s+");
                return new Resident(Gender.values()[Integer.parseInt(strings[1])], Integer.parseInt(strings[0]));
            })
                    .toList();
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Приведите файл " + fn + " к нужному формату");
            throw new Exception("Программа завершена");
        }
    }

    public static int findOldManNum(List <Resident> res) {
        try {
            return res.indexOf(res
                    .stream()
                    .filter(resident -> resident.getGender() == Gender.MEN)
                    .max(Comparator.comparingInt(Resident::getAge))
                    .get()) + 1;
        } catch (NoSuchElementException e) {
            return -1;
        }
    }
    public static void writeToFile(String fileName, int result) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(result+"");
        fw.close();

    }
}
