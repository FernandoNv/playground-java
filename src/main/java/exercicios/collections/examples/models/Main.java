package exercicios.collections.examples.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean stop = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o seu limite de cartão de crédito: ");
        double newLimit = scanner.nextDouble();

        CreditCard creditCard = new CreditCard(newLimit);

        while (!stop){
            System.out.print("Informe o nome do produto: ");
            String name = scanner.next();

            System.out.print("Informe o preço do produto: ");
            double price = scanner.nextDouble();

            Product product = new Product(name, price);

            if(creditCard.purchase(product)){
                System.out.println("Adicionado com sucesso...");
                System.out.println("Novo limite: " + creditCard.getBalance());
            }else{
                System.out.println("Sem saldo para a compra...");
                stop = true;
            }
        }

        Collections.sort(creditCard.getProducts());
        System.out.println(creditCard.getProducts());
    }
}
