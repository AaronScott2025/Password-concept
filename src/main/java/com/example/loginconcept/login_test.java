package com.example.loginconcept;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class login_test {

    login l = new login("Aaron","Avocado");
    ArrayList<Integer> x = new ArrayList<>();
    @Test
    public void testGetName() {
        l.setUsername("Moaath Alrajab");
        assertEquals("Moaath Alrajab", l.getUsername());
    }
    @Test
    public void testencrypt2() {
        x.add(1);
        x.add(22);
        x.add(15);
        x.add(3);
        x.add(1);
        x.add(4);
        x.add(15);
        l.encryptlvl2(x,3);
    }
}
