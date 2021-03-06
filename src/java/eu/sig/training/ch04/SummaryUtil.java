package eu.sig.training.ch04;

public class SummaryUtil {

    public static int sum(String counterAccount) {
        int sum = 0;
        for (int i = 0; i < counterAccount.length(); i++) {
            char character = counterAccount.charAt(i);
            int characterValue = Character.getNumericValue(character);
            sum = sum + (9 - i) * characterValue;
        }

        return sum;
    }

    public static void addInterest(Money balance, float numbers) {
        Money interest = balance.multiply(numbers);
        if (interest.greaterThan(0)) {
            balance.add(interest);
        } else {
            balance.substract(interest);
        }
    }

}
