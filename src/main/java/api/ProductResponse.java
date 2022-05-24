package api;

import java.util.ArrayList;

public class ProductResponse {
	private String id;
	private String productName;
	private ArrayList<Category> categories;
	private Integer amount;
	private Integer discount;
	private Integer percentDiscount;
	private Boolean isVisible;
	private String created;
	private String modified;

	public ProductResponse(String id, String productName, ArrayList<Category> categories, Integer amount, Integer discount, Integer percentDiscount, Boolean isVisible, String created, String modified) {
		this.id = id;
		this.productName = productName;
		this.categories = categories;
		this.amount = amount;
		this.discount = discount;
		this.percentDiscount = percentDiscount;
		this.isVisible = isVisible;
		this.created = created;
		this.modified = modified;
	}

	public String getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public Integer getAmount() {
		return amount;
	}

	public Integer getDiscount() {
		return discount;
	}

	public Integer getPercentDiscount() {
		return percentDiscount;
	}

	public Boolean getVisibility() {
		return isVisible;
	}

	public String getCreated() {
		return created;
	}

	public String getModified() {
		return modified;
	}
}
