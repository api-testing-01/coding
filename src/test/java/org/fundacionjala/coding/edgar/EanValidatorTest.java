package org.fundacionjala.coding.edgar;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EanValidatorTest {
    /**
     * First Code "9783815820865".
     */
    @Test
    public void test01() {
        assertTrue("Check EAN-Code \"9783815820865\"", EanValidator.validate("9783815820865"));
    }

    /**
     * Second code "9783815820864".
     */
    @Test
    public void test02() {
        assertFalse("Check EAN-Code \"9783815820864\"", EanValidator.validate("9783815820864"));
    }

    /**
     * Third code "9783827317100".
     */
    @Test
    public void test03() {
        assertTrue("Check EAN-Code \"9783827317100\"", EanValidator.validate("9783827317100"));
    }

    /**
     * Fourth code "4003301018398".
     */
    @Test
    public void test04() {
        assertTrue("Check EAN-Code \"4003301018398\"", EanValidator.validate("4003301018398"));
    }

    /**
     * Fifth code "9783827317101".
     */
    @Test
    public void test05() {
        assertFalse("Check EAN-Code \"9783827317101\"", EanValidator.validate("9783827317101"));
    }

    /**
     * Sixth code "4003301018392".
     */
    @Test
    public void test06() {
        assertFalse("Check EAN-Code \"4003301018392\"", EanValidator.validate("4003301018392"));
    }

    /**
     * Seventh code "0000000000017".
     */
    @Test
    public void test07() {
        assertTrue("Check EAN-Code \"0000000000017\"", EanValidator.validate("0000000000017"));
    }

    /**
     * Eighth code "0000000000010".
     */
    @Test
    public void test08() {
        assertFalse("Check EAN-Code \"0000000000010\"", EanValidator.validate("0000000000010"));
    }
}
