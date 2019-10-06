package org.fundacionjala.coding.rfalconi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * SortInnerContent
 * You have to sort the inner content of every word of a string in descending order.
 * The inner content is the content of a word without first and the last char.
 *
 * Some examples:
 *
 * "sort the inner content in descending order" -> "srot the inner ctonnet in dsnnieedcg oredr"
 */

public class SortInnerContentTest {

    @Test
    public void test(){
        assertEquals("Wcelmoe", new SortInnerContent().sortInnerContent("Welcome"));
        assertEquals("Bdeeiinnovs a la calse", new SortInnerContent().sortInnerContent("Bienvenidos a la clase"));
        assertEquals("How deos it wkor?", new SortInnerContent().sortInnerContent("How does it work?"));
    }

}
