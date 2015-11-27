import com.spartaonline.learn.jpa.Item;
import com.spartaonline.learn.jpa.RandomNameGenerator;
import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by vladimir on 22.11.15.
 */
public class SomeTest {

    private EntityManagerFactory entityManagerFactory;

    private EntityManager entityManager;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("com.sparta-online.learn.jpa");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void shutdown() {
        entityManager.close();
    }

    @Test
    public void testItemCreation() {
        entityManager.getTransaction().begin();
        for(int i=0; i < 3; i++) {
            Item item = createItem();
            entityManager.persist(item);
        }
        entityManager.getTransaction().commit();
    }

    @Test
    public void testItemQuery() {
        TypedQuery<Item> query = entityManager.createQuery(
                "SELECT i FROM Item i" +
                        " where i.active=:active " +
                        " and i.price > :minPrice", Item.class);
        query.setParameter("active", true);
        query.setParameter("minPrice", 50.0);
        List<Item> items = query.getResultList();
        printItems(items);
    }

    private void printItem(Item item) {
        System.out.println(item);
    }

    private void printItems(Collection<Item> items) {
        for(Item item : items) {
            printItem(item);
        }
    }

    private Item createItem() {
        RandomNameGenerator nameGenerator = new RandomNameGenerator();
        Item item = new Item();
        item.setName(nameGenerator.createName());
        boolean isActive = Math.random() > 0.5;
        item.setActive(isActive);
        item.setPrice(Math.round(Math.random() * 100));
        return item;
    }


}
