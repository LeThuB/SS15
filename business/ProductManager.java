package SS15.business;

import SS15.DAO;
import SS15.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static DAO productDao = new DAO();

    public static void displayProduct() {
        List<Product> list = productDao.getAll();
        if (list.isEmpty()) {
            System.out.println("Danh sach san pham trong");
            return;
        }
        System.out.println("========Danh sach san pham=====");
        for (Product p : list) {
            System.out.println(p);
        }
    }

//    public static void addProduct(Scanner scanner) {
//        System.out.println("=====THem Moi San Pham=====");
//        Product newProduct = new Product();
//        newProduct.inputData(scanner);
//    }
}
