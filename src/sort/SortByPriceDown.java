package sort;

import model.Product;

import java.util.Comparator;

public class SortByPriceDown implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() - o2.getPrice() < 0)
            return 1;
        else if (o1.getPrice() - o2.getPrice() == 0)
            return 0;
        else return -1;
    }
}
