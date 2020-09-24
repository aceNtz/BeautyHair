package beautyhair.main.dao;

import java.util.List;

import beautyhair.main.entity.Category;

public interface CategoryDAO {
	
	public List<Category> getCategoryList();
	
	public List<Category> getFourImportantCategories();
	
	public List<Category> getEightMostUsedCategories();
	
	public void saveCategory(Category category);
	
	public Category getCategory(int id);
	
	public void deleteCategory(int id);
	

}
