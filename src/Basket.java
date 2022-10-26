import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Basket implements Serializable{
    protected String[] food;
    protected int[] price;
    protected int[] count;

    public Basket(String[] food, int[] price) {
        this.food = food;
        this.price = price;
        this.count = new int[price.length];
    }

    private Basket(String[] food, int[] price, int[] count) {
        this.food = food;
        this.price = price;
        this.count = count;
    }

    public void addToCart(int foodNumber, int foodCount) {
        count[foodNumber] += foodCount;
    }

    public void printCart() {
        System.out.println("Ваша корзина:");
        for (int i = 0; i < food.length; i++) {

            System.out.println(food[i] + ": " + count[i] + " шт. " + price[i]
                    + " руб/шт." + " В сумме: " + count[i] * price[i]);


        }


    }


    public void saveTxt(File textFile) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(textFile)) {
            for (String foodx : food) {
                out.print(foodx + " ");
            }
            out.println();
            for (int pricex : price) {
                out.print(pricex + " ");
            }
            out.println();
            for (int countx : count) {
                out.print(countx + " ");

            }
        }
    }


    public static Basket loadFromTxtFile(File textFile) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream(textFile))) {
            String[] food = scanner.nextLine().trim().split(" ");
            int[] price = Arrays.stream(scanner.nextLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] count = Arrays.stream(scanner.nextLine().trim().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return new Basket(food, price, count);

        }
    }
        public void saveBin(File binFile) throws IOException {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(binFile))) {
                out.writeObject(this);
            }
        }

public static Basket loadFromBinFile(File binFile) throws IOException,ClassNotFoundException {
           try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(binFile))){
            return (Basket) in.readObject();
         }
}
    }






