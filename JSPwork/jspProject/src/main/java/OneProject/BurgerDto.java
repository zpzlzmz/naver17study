package OneProject;

public class BurgerDto {
	private int id;
	private String name;
	private String description;
	private int price;
	private String imageUrl;
	private String category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	@Override	
	public String toString() {
        return "BurgerDto{id=" + id + ", name='" + name + "', description='" + description + "', price=" + price + ", imageUrl='" + imageUrl + "', category='" + category + "'}";
    }

}
