package io;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteProduct {

    File file = new File("D:\\baitestm2\\baitestm2\\src\\data\\product.csv");

    public void write(ArrayList<Product> products) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,name,price,quantity,description");
            bufferedWriter.newLine();
            for (Product s : products) {
                bufferedWriter.write(s.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ghi file thành công");
    }

    public ArrayList<Product> read() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
               double price = Double.parseDouble(arr[2]);
               int quantity = Integer.parseInt(arr[3]);
                String description = arr[4];

                products.add(new Product(id, name, price, quantity, description));
            }

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Đọc file thành công");
        return products;
    }
}
