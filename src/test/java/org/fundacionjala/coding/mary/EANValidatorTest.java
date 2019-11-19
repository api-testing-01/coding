package org.fundacionjala.coding.mary;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link EANValidator}.
 */
public class EANValidatorTest {

    /**
     * Validate a given EAN-Code.
     */
    @Test
    public void eanValidatorValidCodeTest() {
        assertTrue(EANValidator.validate("4003301018398"));
    }

    @Test
    public void eanValidatorInvalidCodeTest() {
        assertFalse(EANValidator.validate("4003301018392"));
    }

    @Test
    public void eanValidatorValidCodeWithChecksumZeroTest() {
        assertTrue(EANValidator.validate("4000000010210"));
    }
}
