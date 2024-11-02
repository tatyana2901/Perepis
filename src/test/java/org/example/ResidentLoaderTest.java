package org.example;

import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResidentLoaderTest {

    /* static void setupOkManySpaces() throws IOException {
        //Подготовить файлы и вообще окружение
        String s = "src/test/resources/ok3.txt";
        FileWriter fileWriter = new FileWriter(s);
        fileWriter.write("2 1\n");
        fileWriter.write("1  2\n");
        fileWriter.write("1         2\n");
        fileWriter.write("  3    4    \n");
        fileWriter.close();
    }

    @AfterAll
    static void tearDownManySpaces() throws IOException {
        //Важно!!! подчистить за собой, удалить файл
        Files.delete(Path.of("src/test/resources/ok3.txt"));
    }*/
//4
//25 1
//70 1
//100 0
//3 1

    public void loadTest1() throws FileNotFoundException {
        String s = "src/main/resources/INPUT.TXT";
        List<Resident> actual = ResidentLoader.load(s);
        List<Resident> expected = new ArrayList<>();
        expected.add(new Resident());
        Assertions.assertIterableEquals(expected, actual);


    }

}