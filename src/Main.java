import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        String[] food = {"Яблоко", "Банан", "Апельсин"};
        int[] price = {10, 15, 20};
        int[] count = new int[price.length];
        Basket basket;
        try {
            basket = Basket.loadFromTxtFile(new File("basket1.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Корзина не найдена. Создаю новую.");
            basket = new Basket(food, price);
        }


        Scanner numberQuantity = new Scanner(System.in);
        while (true) {
            System.out.println("Выберете товар и количество");

            String input = numberQuantity.nextLine();
            String[] parts = input.split(" ");
            if ("end".equals(input)) {
                break;
            }
            int foodNumber = Integer.parseInt(parts[0]) - 1;
            int foodCount = Integer.parseInt(parts[1]);
            basket.addToCart(foodNumber, foodCount);
            basket.saveTxt(new File("basket1.txt"));
        }
        basket.printCart();

    }


}


