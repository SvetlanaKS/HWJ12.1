package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;


import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Product first = new Product(1, "first", 100);
    Product second = new Product(2, "second", 100);
    Product third = new Product(3, "third", 100);

    @Test
    public void shouldRemoveExistItem() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.removeById(2);
        Product[] expected = new Product[]{first, third};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotExistItem() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }
}