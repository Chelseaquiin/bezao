package numbersInWords;


public class Conversion {

    public static final String[] units = {" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    public static final String[] tens = {" ", " ", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    public static String convertToWords(final int number) {

            if (number < 0) {
                return "Minus" + convertToWords(-number);
            } else if (number < 20) {
                return units[number];
            } else if (number < 100) {

                return tens[number / 10] + " " + units[number % 10];
            } else if (number < 1000) {
                return units[number / 100] + " Hundred" + " " + convertToWords(number % 100);
            } else if (number < 10000) {

                return units[number / 1000] + " Thousand" + " " + convertToWords(number % 1000);
            } else if (number < 100000) {

                return convertToWords(number / 10000) + " Thousand" + " " + convertToWords(number % 1000);
            }
            return convertToWords(number / 10000) + " Million" + " " + convertToWords(number % 10000);


        }


    }



