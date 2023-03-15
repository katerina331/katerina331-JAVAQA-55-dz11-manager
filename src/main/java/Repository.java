public class Repository {
    Product[] items = new Product[0];

    public void add(Product item) {
        Product[] temp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        temp[temp.length - 1] = item;
        items = temp;
    }

    public Product[] findAll() {
        return items;
    }

    public void delId(int Id) {
        Product[] temp = new Product[items.length - 1];
        int i = 0;
        for (Product product : items) {
            if (product.id != Id) {
                temp[i] = product;
                i++;
            }
        }
        items = temp;
    }
}