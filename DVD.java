 
public class DVD extends CatalogItem //declares DVD class that is a subclass of CatalogItem
{
	//declares private variables that are attributes to DVD 
	private String director;
	private int year;
	private int dvdcode;
	private static double dvdDiscount = 0.8;
	
	public DVD(String title, double price, String director, int year, int dvdcode) //constructor for DVD
	{
		super(title, price); //calls superclass constructor
		this.director = director; //sets director to director
		this.year = year; //sets year to year
		this.dvdcode = dvdcode; //sets dvdcode to dvdcode
	}
	
	public String getDirector() //declares getDirector method and returns director
	{
		return director;
	}
	
	public int getYear() //declares getYear method and returns year
	{
		return year;
	}
	public double getDvdDiscount() 
	{
		return dvdDiscount;
	}
	@Override
	public double getPrice() 
	{
		return (getDvdDiscount() * super.getPrice());
	}
	public int getDvdCode() //declares getDvdCode method and returns dvdcode
	{
		return dvdcode;
	}
	
	@Override
	public String toString() //overrides toString method and returns string for DVD
	{
		return "Title: " + getTitle() + " | Director: " + getDirector() + " | Price " 
				+ getPrice() + " | Year: " + getYear() + " | DVD Code: " + getDvdCode();
	}
	
}
