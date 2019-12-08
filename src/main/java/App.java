import examples.Bank;
import examples.Rucksack;

public class App {
    public static void main(String[] args) {
        System.out.println(
                new StringBuilder()
                    .append("Minimum rucksack weight with maximum value which equals: ")
                    .append(
                            Rucksack.calculate(
                                    5,
                                    100)
                    )
        );
        System.out.println(
                new StringBuilder()
                        .append("Minimum amount of paper money needed to give ")
                        .append(20430)
                        .append(" is: ")
                        .append(
                                Bank.calculate(
                                        20430)
                        )
        );
    }
}
