import org.junit.jupiter.api.*;

public class ProductManagerTest {
    ProductManager manager = new ProductManager();
    Product item1 = new Book(1, "Книга 1", 100, "А");
    Product item2 = new Book(2, "Книга 2", 200, "Б");
    Product item3 = new Book(3, "Книга 3", 300, "В");
    Product item4 = new Smartphone(4, "Телефон 1", 4000, "Г");
    Product item5 = new Smartphone(5, "Телефон 2", 5000, "Д");
    Product item6 = new Smartphone(6, "Телефон 3", 6000, "Ж");

    @BeforeEach
    public void setup() {
        manager.addProduct(item1);
        manager.addProduct(item2);
        manager.addProduct(item3);
        manager.addProduct(item4);
        manager.addProduct(item5);
    }

    @Test
    public void addProductFirstItemTest() {
        ProductManager manager = new ProductManager();

        Product[] expected = {item5};
        manager.addProduct(item5);
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductNewItemTest() {
        Product[] expected = {item1, item2, item3, item4, item5, item6};
        manager.addProduct(item6);
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void allFilmTest() {
        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findBookTest() {
        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.searchBy("Книга");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findTelTest() {
        Product[] expected = {item4, item5, item6};
        manager.addProduct(item6);
        Product[] actual = manager.searchBy("Тел");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findNumTest() {
        Product[] expected = {item1, item4};
        Product[] actual = manager.searchBy("1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findOneTest() {
        Product[] expected = {item5};
        Product[] actual = manager.searchBy("Телефон 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void delIdTest() {
        Product[] expected = {item1, item3, item4, item5};
        manager.repo.delId(2);
        Product[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}