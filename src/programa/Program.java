package programa;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {
    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("Informe os dados da conta");

        try {

            System.out.print("Number: ");
            int number = sc.nextInt();

            System.out.print("Name: ");
            sc.nextLine();
            String holder = sc.nextLine();

            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();

            System.out.print("Withdraw Limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");

            double amount = sc.nextDouble();
            account.withdraw(amount);

            System.out.printf("New Balance: %.2f%n", account.getBalance());

        } catch (DomainException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException c){
            System.out.println("Unexpected Error.");
        }

        sc.close();

    }
}
