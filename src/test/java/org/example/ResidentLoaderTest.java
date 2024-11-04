package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;
import static org.junit.jupiter.api.Assertions.*;

class ResidentLoaderTest {
    @Test
    public void loadTest1() throws Exception {
        String s = "src/main/resources/INPUT.TXT";
        List<Resident> actual = ResidentLoader.load(s);
        List<Resident> expected = new ArrayList<>();
        expected.add(new Resident(Gender.MEN, 25));
        expected.add(new Resident(Gender.MEN, 70));
        expected.add(new Resident(Gender.WOMAN, 100));
        expected.add(new Resident(Gender.MEN, 3));
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void loadTest2() throws Exception {
        String message = "Приведите файл src/main/resources/INPUTTED.txt к нужному формату";
        String s = "src/main/resources/INPUTTED.txt";
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("5\n 1,45\n 0,99\n,1,58\n 1,85");
        fileWriter.close();
        Assertions.assertThrows(Exception.class,() -> ResidentLoader.load(s), message);
        Files.delete(Path.of(s));
    }

    @Test
    public void loadTest3() throws Exception {
        String s = "src/main/resources/INPUTTED.txt";
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write(" ");
        fileWriter.close();
        Assertions.assertDoesNotThrow(() -> {
            ResidentLoader.load(s);
        });
        List<Resident> r = new ArrayList<>();
        Assertions.assertIterableEquals(r,ResidentLoader.load(s));
        Files.delete(Path.of(s));
    }
    @Test
    public void loadTest4() throws Exception {
        String s = "src/main/resources/INPUTTED.txt";
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("AAAAAAA $$$");
        fileWriter.close();
        Assertions.assertDoesNotThrow((Executable) () -> ResidentLoader.load(s));
                Files.delete(Path.of(s));
    }

    @Test
    public void testFindOldManNum1() {
        ArrayList<Resident> residents = new ArrayList<>();
        addAll(residents,
                new Resident(Gender.WOMAN, 55),
                new Resident(Gender.MEN, 30),
                new Resident(Gender.MEN, 88),
                new Resident(Gender.MEN, 100),
                new Resident(Gender.WOMAN, 120)
        );
        Assertions.assertEquals(4, ResidentLoader.findOldManNum(residents));
    }

    @Test
    public void testFindOldManNum2() {
        ArrayList<Resident> residents = new ArrayList<>();
        addAll(residents,
                new Resident(Gender.WOMAN, 55),
                new Resident(Gender.WOMAN, 30),
                new Resident(Gender.WOMAN, 88),
                new Resident(Gender.WOMAN, 100),
                new Resident(Gender.WOMAN, 120)
        );
        Assertions.assertEquals(-1, ResidentLoader.findOldManNum(residents));
    }

    @Test
    public void testFindOldManNum3() {
        ArrayList<Resident> residents = new ArrayList<>();
        addAll(residents,
                new Resident(Gender.WOMAN, 30),
                new Resident(Gender.MEN, 120),
                new Resident(Gender.WOMAN, 30),
                new Resident(Gender.MEN, 88),
                new Resident(Gender.WOMAN, 100),
                new Resident(Gender.MEN, 120),
                new Resident(Gender.WOMAN, 98)
        );
        Assertions.assertEquals(2, ResidentLoader.findOldManNum(residents));
    }

    @Test
    public void testFindOldManNum4() {
        ArrayList<Resident> residents = new ArrayList<>();
        Assertions.assertEquals(-1, ResidentLoader.findOldManNum(residents));
    }


}