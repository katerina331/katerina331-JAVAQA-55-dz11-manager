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

    public void delId(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }

        Product[] temp = new Product[items.length - 1];
        int i = 0;
        for (Product product : items) {
            if (product.id != id) {
                temp[i] = product;
                i++;
            }
        }
        items = temp;
    }

    public Product findById(int id) {
        for (Product product : items) {
            if (product.id == id) {
                return product;
            }
        }
        return null;
    }
}