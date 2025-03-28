package com.example.demo;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.transaction.annotation.Transactional; // Import this
import org.springframework.test.annotation.Commit;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE) // Tell Spring Boot not to replace the DataSource
@Transactional // Wrap each test in a transaction that is rolled back
@Commit
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testSaveItem() {
        Item item = new Item("Test Item", "A test item description");
        Item savedItem = itemRepository.save(item);

        assertNotNull(savedItem.getId());
        assertEquals("Test Item", savedItem.getName());
        assertEquals("A test item description", savedItem.getDescription());
    }

    @Test
    public void testFindAllItems() {
        // Create some items
        Item item1 = new Item("Item 3", "Description 3");
        Item item2 = new Item("Item 4", "Description 4");
        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> items = itemRepository.findAll();

        assertTrue(items.size() >= 3); // Should be at least 2, but might have more from other tests
        assertTrue(items.stream().anyMatch(i -> i.getName().equals("Item 3")));
        assertTrue(items.stream().anyMatch(i -> i.getName().equals("Item 4")));
    }

    @Test
    public void testDeleteItem() {
        Item item = new Item("Item to Delete", "Delete me!");
        Item savedItem = itemRepository.save(item);
   Long idToDelete = savedItem.getId();
       // int idToDelete = 16;

     itemRepository.deleteById(idToDelete);

   assertFalse(itemRepository.existsById(idToDelete));
    }
    
}