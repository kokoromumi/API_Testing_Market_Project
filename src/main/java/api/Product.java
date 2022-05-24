package api;

import java.util.ArrayList;

public class Product {
	private Integer amount;
	private ArrayList<Category> categories;
	private Integer discount;
	private Boolean isVisible;
	private String name;
	private Integer percentDiscount;

	public Product(Integer amount, ArrayList<Category> categories, Integer discount, Boolean isVisible, String name, Integer percentDiscount) {
		this.amount = amount;
		this.categories = categories;
		this.discount = discount;
		this.isVisible = isVisible;
		this.name = name;
		this.percentDiscount = percentDiscount;
	}

	public String getName() {
		return name;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getDiscount() {
		return discount;
	}

	public Boolean getVisibility() {
		return isVisible;
	}

	public Integer getPercentDiscount() {
		return percentDiscount;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}
}
