package org.fundacionjala.coding.edgar.bankocr;

final class Digits {

    static final char[][] ZERO = new char[][]{
            {' ', '_', ' '},
            {'|', ' ', '|'},
            {'|', '_', '|'}
    };

    static final char[][] ONE = new char[][]{
            {' ', ' ', ' '},
            {' ', ' ', '|'},
            {' ', ' ', '|'},
    };

    static final char[][] TWO = new char[][]{
            {' ', '_', ' '},
            {' ', '_', '|'},
            {'|', '_', ' '},
    };

    static final char[][] THREE = new char[][]{
            {' ', '_', ' '},
            {' ', '_', '|'},
            {' ', '_', '|'},
    };

    static final char[][] FOUR = new char[][]{
            {' ', ' ', ' '},
            {'|', '_', '|'},
            {' ', ' ', '|'},
    };

    static final char[][] FIVE = new char[][]{
            {' ', '_', ' '},
            {'|', '_', ' '},
            {' ', '_', '|'},
    };

    static final char[][] SIX = new char[][]{
            {' ', '_', ' '},
            {'|', '_', ' '},
            {'|', '_', '|'},
    };

    static final char[][] SEVEN = new char[][]{
            {' ', '_', ' '},
            {' ', ' ', '|'},
            {' ', ' ', '|'},
    };

    static final char[][] EIGHT = new char[][]{
            {' ', '_', ' '},
            {'|', '_', '|'},
            {'|', '_', '|'},
    };

    static final char[][] NINE = new char[][]{
            {' ', '_', ' '},
            {'|', '_', '|'},
            {' ', '_', '|'},
    };

    private Digits() {
    }
}

