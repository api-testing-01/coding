package org.fundacionjala.coding.ruben;

import org.junit.Test;


import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortInnerContentTest {

    class LogHandler extends Handler {
        private Level lastLevel = Level.WARNING;

        public Level  checkLevel() {
            return lastLevel;
        }

        public void publish(final LogRecord record) {
            lastLevel = record.getLevel();
        }

        public void flush() {
            // method used by the handler
        }

        public void close() {
            // method used by the handler
        }

    }

    @Test
    public void sentenceWithSpaceRegex() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr",
                Sort.validateSentence("sort the inner content in descending order", " "));
    }

    @Test
    public void sentenceWithAnotherRegex() {
        assertEquals("wiat-for-me", Sort.validateSentence("wait-for-me", "-"));
    }

    @Test
    public void sentenceIsNotEmpty() {
        assertTrue(Sort.validateSentence("sentence not empty", " "), true);
    }

    @Test
    public void warningDisplayedForShortSentence() {
        Logger logger = Logger.getLogger("Please enter a complete sentence");
        LogHandler handler = new LogHandler();
        handler.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        logger.setLevel(Level.WARNING);
        Sort.validateSentence("ab", " ");
        assertEquals("Please enter a complete sentence", logger.getName());
    }

    @Test
    public void sentenceMonosyllables() {
        assertEquals("I am",
                Sort.validateSentence("I am", " "));
    }
}
