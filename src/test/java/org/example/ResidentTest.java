package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.addAll;
import static org.junit.jupiter.api.Assertions.*;

class ResidentTest {
    @Test
    public void constructorTest1() {
        Assertions.assertDoesNotThrow(() -> {
            new Resident(Gender.MEN, 28);
        });
    }

    @Test
    public void getAgeTest() {
        Resident tst = new Resident(Gender.MEN, 55);
        Assertions.assertEquals(55, tst.getAge());
    }
    @Test
    public void equalsTest(){
        Resident res1 = new Resident(Gender.MEN,88);
        Resident res2 = new Resident(Gender.MEN,88);
        Assertions.assertEquals(res2,res1);
    }
    @Test
    public void equalsTest1(){
        Resident res1 = new Resident(Gender.MEN,88);
        Resident res2 = new Resident(Gender.MEN,89);
        Resident res3 = new Resident(Gender.WOMAN,48);
        Resident res5 = new Resident(Gender.MEN,88);
        Resident res6 = new Resident(Gender.MEN,89);
        Resident res7 = new Resident(Gender.WOMAN,48);
        List<Resident> list = new ArrayList<>();
        Collections.addAll(list,res1,res2,res3);
        List<Resident> list2 = new ArrayList<>();
        List<Resident> list3 = new ArrayList<>();
        Collections.addAll(list3,res1,res5,res7);
        Collections.addAll(list2,res5,res6,res7);
        Assertions.assertIterableEquals(list,list2);
        Assertions.assertNotEquals(list,list3);
    }
    @Test
    public void getGenderTest(){
        Resident res = new Resident(Gender.MEN,25);
        assertSame(Gender.MEN, res.getGender());
    }

}