package SS15.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.zip.DataFormatException;


public class GetInput {

    public static String getString(Scanner scanner, String suggestion, int minlenght, int maxlenght) {
        do {
            System.out.print(suggestion);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Vui long khong de trong ");
            } else if (input.length() >= minlenght && input.length() <= maxlenght) {
                return input;
            } else
                System.out.println("Do dai phai tu  " + minlenght + "den " + maxlenght);

        } while (true);
    }

    public static Float getFloat(Scanner scanner, String suggestion, float min, float max) {
        do {
            try {
                System.out.print(suggestion);
                Float number = Float.parseFloat(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Vui long nhap vao so thuc trong khoang tu " + min + "den" + max);
            } catch (Exception e) {
                System.out.println("Vui long nhap vao 1 so thuc ");
            }
        } while (true);
    }

    public static Integer getInt(Scanner scanner, String suggestion, int min, int max) {

        do {
            try {
                System.out.print(suggestion);
                int number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Vui long nhap vao 1 so nguyen trong khoang tu " + min + "den " + max);

            } catch (Exception e) {
                System.out.println("Vui long nhap vao 1 so nguyen");
            }
        } while (true);
    }

    public static LocalDate getDate(Scanner scanner, String suggestion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            try {
                System.out.print(suggestion);
                return LocalDate.parse(scanner.nextLine(), formatter);
            } catch (Exception e) {
                System.out.println("Vuilong nhap dinh dang ngay dd-MM-yyyy");
            }
        } while (true);


    }

    public static boolean getBoolean(Scanner scanner, String suggestion) {
        do {
            System.out.println(suggestion);
            String input = scanner.nextLine();
            if (input.equals("1")) {
                return true;
            }
            if (input.equals("0")) {
                return false;
            }
            System.out.println("Vui long nhap 1 - Active hoac 0 - Deactive");
        } while (true);
    }
//    public static LocalDate getLocalDate(Scanner scanner, String suggestion) {
//        do {
//            try {
//                System.out.print(suggestion);
//                return LocalDate.parse(scanner.nextLine());
//
//            } catch (Exception e) {
//                System.out.println(
//                        "Vui long nhap dung dinh dang yyyy-MM-dd"
//                );
//            }
//        } while (true);
//    }
}
