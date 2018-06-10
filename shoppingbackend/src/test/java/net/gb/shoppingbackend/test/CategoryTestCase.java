package net.gb.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.gb.shoppingbackend.dao.CategoryDAO;
import net.gb.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("net.gb.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory(){
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Laptop"); category.setDescription(
	 * "This is some descrption for Television! ");
	 * category.setImageURL("CAT_100.png");
	 * 
	 * assertEquals("Successfully Added a Category inside 	the Table"
	 * ,true,categoryDAO.add(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory(){
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * assertEquals("Successfully fetch a single Category from	the Table"
	 * ,"Laptop",category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory(){
	 * 
	 * category = categoryDAO.get(3);
	 * 
	 * category.setName("TV");
	 * 
	 * assertEquals("Successfully Updated a single Category in Table"
	 * ,true,categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory(){
	 * 
	 * category = categoryDAO.get(3); 
	  assertEquals("Successfully Deleted single Category in Table",true,categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory(){
	 
	 assertEquals("Successfully fetched list of Category from Table",2,categoryDAO.list().size());
	  
	 * }
	 */

	@Test
	public void testCRUDCategory() {
		//add operation
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is some descrption for Laptop! ");
		category.setImageURL("CAT_1.png");

		assertEquals("Successfully Added a Category inside 	the Table", true, categoryDAO.add(category));
		
		category = new Category();

		category.setName("Television");
		category.setDescription("This is some descrption for Laptop! ");
		category.setImageURL("CAT_2.png");

		assertEquals("Successfully Added a Category inside 	the Table", true, categoryDAO.add(category));

		//fetching and updating category
		category = categoryDAO.get(2);
		category.setName("TV");
		
		 assertEquals("Successfully Updated a single Category in Table",true,categoryDAO.update(category));
		 
		 //delete category
		 assertEquals("Successfully Deleted single Category in Table",true,categoryDAO.delete(category));
		 
		 //Fetching Active List of Category
		 
		 assertEquals("Successfully fetched list of Category from Table",1,categoryDAO.list().size());
		
	}

}
