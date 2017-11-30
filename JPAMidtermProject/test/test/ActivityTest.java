package test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Activity;

public class ActivityTest {
	private EntityManagerFactory emf;
	private EntityManager em;
	private Activity activity;

	@Before
	public void setUp() throws Exception {
		this.emf = Persistence.createEntityManagerFactory("MidtermPU");
		this.em = emf.createEntityManager();
		activity = em.find(Activity.class, 1);

	}
	
	@Test
	public void test_getActivityId() {
		assertEquals(1, activity.getId());
	}
	
	@Test
	public void test_activity_mapping() {
		assertEquals(1, activity.getBorrower());
		assertEquals(1, activity.getItem());
		assertEquals(1, activity.getDateLent());
		assertEquals(1, activity.getDueDate());
	}
	
	@After
	public void tearDown() throws Exception {
		this.em.close();
		this.emf.close();
		activity = null;
	}
}
