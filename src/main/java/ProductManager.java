public class ProductManager {
    Repository repo = new Repository();

    public void addProduct(Product product) {
        repo.add(product);
    }

    public Product[] findAll() {
        return repo.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        int i = 0;
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] temp = new Product[result.length + 1];
                if (result.length > 0) for (int j = 0; j < result.length; j++) {
                    temp[j] = result[j];
                }
                temp[temp.length - 1] = repo.items[i];
                result = temp;
            }
            i++;
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}