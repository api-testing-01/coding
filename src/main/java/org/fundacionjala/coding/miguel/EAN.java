package org.fundacionjala.coding.miguel;

public class EAN {

    public int[] parse(final String num) {
        int[] nums = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            nums[i] = Character.getNumericValue(num.charAt(i));
        }
        return nums;
    }

    public boolean eanValidate(final String toValidate) {
        final int even = 3;
        int[] num = this.parse(toValidate);
        int checksum = 0;
        final int checksumLimit = 10;
        int count = 0;

        for (int i = 0; i < num.length - 1; i++) {
            count += num[i] % 2 == 0 ? num[i] : num[i] * even;
        }

        checksum = count % checksumLimit == 0 ? checksum : checksumLimit - (count % checksumLimit);
        return num[num.length - 1] == checksum;
    }
}
