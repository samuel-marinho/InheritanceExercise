package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        for (int x=1; x<=n; x++){
            System.out.println("Product #"+ x + " data:");

            System.out.print("Common, used or imported (c/u/i)? ");
            char ans = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.next();
            System.out.print("Price: ");
            double price = sc.nextDouble();

            switch (ans){
                case 'i':
                    System.out.print("Customs fee: ");
                    double customsFee = sc.nextDouble();
                    list.add(new ImportedProduct(name, price, customsFee));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYY): ");
                    Date mDate = sdf.parse(sc.next());
                    list.add(new UsedProduct(name, price, mDate));
                    break;
                case 'c':
                    list.add(new Product(name, price));
                    break;
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");

        for (Product product : list){
            System.out.println(product.priceTag());
        }
        sc.close();
    }
}
