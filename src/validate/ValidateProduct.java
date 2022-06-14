package validate;

import model.Product;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateProduct {
    Scanner scanner = new Scanner(System.in);

    public int validateID(List<Product> products) {
        while (true) {
            try {
                System.out.println("Nhập id sản phẩm:");
                int id = Integer.parseInt(scanner.nextLine());
                if (getIndexId(id,products) != -1) {
                    throw new Exception();
                }
                return id;
            } catch (Exception e) {
                System.err.println("Nhập sai id vui lòng nhập lại");
            }
        }
    }

    public int getIndexId(int id, List<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public String validateString(String string) {
        while (true) {
            try {
                System.out.println("Nhập " + string);
                String st = scanner.nextLine();

                Pattern pattern = Pattern.compile(".+");
                Matcher matcher = pattern.matcher(st);

                if (matcher.matches()) {
                    return string;
                } else {
                    throw new Exception();

                }
            } catch (Exception e) {
                System.err.println("Lỗi định dạng, xin mời nhập lại");
            }
        }
    }

    public double validatePrice() {
        while (true) {
            try {
                System.out.println("Nhập giá sản phẩm: ");
                String db = scanner.nextLine();

                Pattern pattern = Pattern.compile("[0-9]+\\.?[0-9]{0,2}");
                Matcher matcher = pattern.matcher(db);

                if (matcher.matches()) {
                    return Double.parseDouble(db);
                }
            } catch (Exception e) {
                System.out.println("Lỗi định dạng giá, xin mời nhập lại! ");
            }


        }
    }

    public int validateAmount() {
        while (true) {
            try {
                System.out.println("Nhập số lượng sản phẩm: ");
                String amount = scanner.nextLine();

                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(amount);
                if (matcher.matches()) {
                    return Integer.parseInt(amount);
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Lỗi định dạng số lượng, xin mời nhập lại! ");
            }
        }
    }

}

