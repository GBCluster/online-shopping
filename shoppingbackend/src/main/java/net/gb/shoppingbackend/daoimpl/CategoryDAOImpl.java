package net.gb.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.gb.shoppingbackend.dao.CategoryDAO;
import net.gb.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category=new Category();
		
		// adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some descrption for Television! ");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		
		// adding second category
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is some descrption for Television! ");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		// adding Third category
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is some descrption for Television! ");
		category.setImageURL("CAT_1.png");
		categories.add(category);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		
		//Enhanced for loop
		for(Category category : categories){
			if(category.getId() == id)
				return category;
		}
		return null;
	}

}
