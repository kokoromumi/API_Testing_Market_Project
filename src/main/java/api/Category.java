package api;

public class Category {
	private String brand;
	private Boolean isVisible;
	private String name;

	public Category(String name, String brand, Boolean isVisible) {
		this.name = name;
		this.brand = brand;
		this.isVisible = isVisible;
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
}
