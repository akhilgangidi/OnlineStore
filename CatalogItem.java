public class CatalogItem //declares the CatalogItem superclass
{
	//defines private variables for CatalogItem class
	private String title;
	private double price;
	
	public CatalogItem(String title, double price) //CatalogItem constructor
	{
		this.title = title; //sets title to title
		this.price = price; //sets price to price
	}
	
	public String getTitle() //defines getTitle method and returns title
	{
		return title;
	}
	
	public double getPrice() //defines getPrice method and returns price
	{
		return price;
	}
}
