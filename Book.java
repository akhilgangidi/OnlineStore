
public class Book extends CatalogItem //declares Book class 
{
	//declares private variables for Book object
	private String author;
	private int isbn;
	private static double bookDiscount = 0.9;
	
	
	public Book(String title, double price, String author, int isbn) //constructor for Book class
	{
		super(title, price); //calls the superclass constructor
		this.author = author; //sets author to author 
		this.isbn = isbn; //sets ISBN to ISBN
	}

	
	public String getAuthor() //defines getAuthor method and returns author
	{
		return author;
	}
	
	public int getIsbn() //defines getIsbn method and returns ISBN
	{
		return isbn;
	}
	public double getBookDiscount()
	{
		return bookDiscount;
	}
	public double getPrice()
	{
		return (getBookDiscount() * super.getPrice());
	}
	
	@Override
	public String toString() //overrides toString method and returns Book string
	{
		return "Title: " + getTitle() + " | Author: " + getAuthor() + " | Price: " + getPrice() + " | ISBN: " + getIsbn();
	}
}
