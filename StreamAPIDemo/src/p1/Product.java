package p1;

public class Product {

	String productName;
    int cost;
    String category;
	public Product(String productName, int cost, String category) {
		super();
		this.productName = productName;
		this.cost = cost;
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", cost=" + cost + ", category=" + category + "]";
	}

    

}
