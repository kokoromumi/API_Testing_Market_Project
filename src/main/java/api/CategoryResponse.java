package api;

public class CategoryResponse {
	private String id;
	private String name;
	private String brand;
	private Boolean isVisible;
	private String created;
	private String modified;

	public CategoryResponse(String id, String name, String brand, Boolean isVisible, String created, String modified) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.isVisible = isVisible;
		this.created = created;
		this.modified = modified;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBrand() {
		return brand;
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
