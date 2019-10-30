package org.fundacionjala.coding.luiscachi;

public class EANValidation {
    public boolean EANValidation(String EAN){
        String[] numbers = EAN.split("");
        int EANNumber = 0;
        int checkSum = 0;
        for (int i = 0; i <numbers.length-1 ; i++) {
            if(i%2 == 0){
                checkSum += (Integer.parseInt(numbers[i])*1);
            }else{
                checkSum += (Integer.parseInt(numbers[i])*3);
            }
        }
        if (checkSum%10 != 0 )
            EANNumber = 10 - (checkSum%10);
        if (numbers.length == 13 && EANNumber == Integer.parseInt(numbers[numbers.length-1]))
            return true;
        else return false;
    }
}
