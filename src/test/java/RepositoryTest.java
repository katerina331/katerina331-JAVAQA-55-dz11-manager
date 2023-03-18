import org.junit.jupiter.api.*;

public class RepositoryTest {
    Repository repo = new Repository();
    Product item1 = new Book(1, "Книга 1", 100, "А");
    Product item2 = new Book(2, "Книга 2", 200, "Б");
    Product item3 = new Book(3, "Книга 3", 300, "В");

    @Test
    public void delBadIdTryCatchTest() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.delId(-100);
        });
    }

    @Test
    public void delGoodIdTryCatchTest() {
        repo.add(item1);
        repo.add(item2);
        repo.add(item3);

        Product[] expected = {item1, item3};
        repo.delId(2);
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
