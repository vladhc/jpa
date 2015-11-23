import com.spartaonline.learn.jpa.Item;
import com.spartaonline.learn.jpa.RandomNameGenerator;
import org.junit.*;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by vladimir on 22.11.15.
 */
public class SomeTest {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("com.sparta-online.learn.jpa");
    }

    @Test
    public void displayNames() {
        for(int i=0; i < 1000; i++) {
            createItem();
        }
    }

    public void someTest() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }

    private void createItem() {
        RandomNameGenerator nameGenerator = new RandomNameGenerator();
        Item item = new Item();
        item.setName(nameGenerator.createName());
        item.setActive(true);
        System.out.println(item.getName());
    }


}
