package org.agoncal.training.javaee.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Antonio Goncalves
 *         Training - Beginning with The Java EE 7 Platform
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemTest extends AbstractPersistentTest {

    // ======================================
    // =              Methods               =
    // ======================================

    @Test
    public void shouldCreateAnItem() {

        // Creates an item
        Item item = new Item("Pencil", 2.35f, "A red pencil");

        // Persists the item
        tx.begin();
        em.persist(item);
        tx.commit();
        Long id = item.getId();

        // Finds the item by primary key
        item = em.find(Item.class, id);
        assertEquals("Pencil", item.getTitle());

        // Updates the item
        tx.begin();
        item.setTitle("Red pen");
        tx.commit();

        // Finds the item by primary key
        item = em.find(Item.class, id);
        assertEquals("Red pen", item.getTitle());

        // Deletes the item
        tx.begin();
        em.remove(item);
        tx.commit();

        // Checks the item has been deleted
        assertNull("Item should has been deleted", em.find(Item.class, id));
    }

    @Test(expected = Exception.class)
    public void shouldNotCreateAnItemWithANullTitle() {

        // Creates an item with null title
        Item item = new Item(null, 2.35f, "A red pencil");

        // Persists the item
        tx.begin();
        em.persist(item);
        tx.commit();
    }
}