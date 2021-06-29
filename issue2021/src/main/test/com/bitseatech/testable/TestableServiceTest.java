package com.bitseatech.testable;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestableServiceTest {

    @Test
    public void doInnerTest() {
        TestableService p = new TestableService();
        String res = p.doInner("root");
        Assert.assertEquals(res,"abc");
    }
}