package controller;

import io.ReadAndWriteProduct;
import model.Product;
import sort.SortByPriceDown;
import sort.SortByPriceUp;
import validate.ValidateProduct;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Product> products = new ArrayList<>();
    ValidateProduct validateProduct = new ValidateProduct();
    ReadAndWriteProduct readAndWriteProduct = new ReadAndWriteProduct();


    public void menu() {
        System.out.println("---Chương trình quản lý sản phẩm---");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhập");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp sếp");
        System.out.println("6.Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào  file");
        System.out.println("9. Thoát");
        System.out.println("Chọn chức năng");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                show();
                break;
            case 2:
                addProduct(createProduct());
                break;
            case 3:
                editProduct();
                break;
            case 4:
                deleteProduct();
                break;
            case 5:
                sort();
                break;
            case 6:
                findMaxPrice();
                break;
            case 7:
                readFile();
                break;
            case 8:
                writeFile();
                break;
            case 9:
                System.exit(0);
                break;
        }
    }

    public void show() {
        for (int i = 0; i < products.size(); i++) {
            if ((i + 1) % 5 == 0) {
                System.out.println(products.get(i));
                scanner.nextLine();
            } else {
                System.out.println(products.get(i));
            }
        }
    }

    public Product createProduct() {
        int id = validateProduct.validateID(products);
        String name = validateProduct.validateString("name:");
        double price = validateProduct.validatePrice();
        int quantity = validateProduct.validateAmount();
        String description = validateProduct.validateString("description:");

        return new Product(id, name, price, quantity, description);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void editProduct() {
        System.out.println("Nhập id cần sửa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(id, products);
        if (index != -1) {
            products.set(index, createProduct());
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập id cần xóa");
        int id = Integer.parseInt(scanner.nextLine());
        int index = validateProduct.getIndexId(id, products);
        if (index != -1) {
            products.remove(index);
        } else {
            System.err.println("id không tồn tại");
        }
    }

    public void readFile() {
        products = readAndWriteProduct.read();

    }

    public void writeFile() {
        readAndWriteProduct.write(products);
    }

    public Product findMaxPrice() {
        double maxPrice = products.get(0).getPrice();
        Product maxPriceProduct = products.get(0);
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPrice() > maxPrice) {
                maxPrice = products.get(i).getPrice();
                maxPriceProduct = products.get(i);
            }
        }
        return maxPriceProduct;
    }

    public void sort() {
        while (true) {
            System.out.println("1. Sắp xếp theo giá tăng");
            System.out.println("2. Sắp xếp theo giá giảm");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    products.sort(new SortByPriceUp());
                    show();
                    break;
                case 2:
                    products.sort(new SortByPriceDown());
                    show();
                    break;
                case 3:
                    menu();
                    break;
            }
        }
    }
}