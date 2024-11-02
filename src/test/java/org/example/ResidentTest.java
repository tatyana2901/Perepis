package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static java.util.Collections.addAll;
import static org.junit.jupiter.api.Assertions.*;

class ResidentTest {
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
        Assertions.assertEquals(4, ResidentLoader.findOldManNum());
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
        Assertions.assertEquals(-1, ResidentLoader.findOldManNum());
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
        Assertions.assertEquals(2, ResidentLoader.findOldManNum());
    }
    @Test
    public void testFindOldManNum4() {
        ArrayList<Resident> residents = new ArrayList<>();
        Assertions.assertEquals(-1, ResidentLoader.findOldManNum());
    }

}