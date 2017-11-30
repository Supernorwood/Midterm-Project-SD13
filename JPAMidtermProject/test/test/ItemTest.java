package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Item;

public class ItemTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Item item;

	@Before
	public void setUp() throws Exception {
		this.emf = Persistence.createEntityManagerFactory("MidtermPU");
		this.em = emf.createEntityManager();
		item = em.find(Item.class, 1);

	}
	
	@Test
	public void test_getItemId() {
		assertEquals(1, item.getId());
	}
	
	@After
	public void tearDown() throws Exception {
		this.em.close();
		this.emf.close();
		item = null;
	}
}