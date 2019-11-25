package org.fundacionjala;

public class EanValidation {
    public EanValidation() {
    }

    public boolean validator(long ean) {
        boolean isEAN = false;
        int checksum = 0;
        int oddSum = oddSum(ean / 10);
        int evenSum = evenSum(ean / 10);
        int sum = oddSum + evenSum;

        if (sum % 10 != 0) {
            checksum = 10 - (sum % 10);
        }
        if (checksum == ean % 10) {
            isEAN = true;
        }
        return isEAN;
    }

    private long reverse(long n) {
        long rev = 0;
        while (n != 0) {
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        return rev;
    }

    public int oddSum(long number) {
        number = reverse(number);
        int sumOdd = 0;
        int c = 1;

        while (number != 0) {
            if (c % 2 != 0)
                sumOdd += number % 10;
            number /= 10;
            c++;
        }
        return sumOdd;
    }

    public int evenSum(long number) {
        number = reverse(number);
        int sumEven = 0;
        int c = 1;

        while (number != 0) {
            if (c % 2 == 0)
                sumEven += number % 10;
            number /= 10;
            c++;
        }
        sumEven = sumEven * 3;
        return sumEven;
    }
}