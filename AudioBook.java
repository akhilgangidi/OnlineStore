
public class AudioBook extends Book //defines AudioBook class and is a subclass of Book
{
	//defines private variable for runningTime
	private double runningTime;
	private static double audioBookDiscount = 0.5;
	
	
	public AudioBook(String title, double price, String author, int isbn, double runningTime) //AudioBook constructor
	{
		super(title, price, author, isbn); //calls superclass constructor
		this.runningTime = runningTime; //sets runningTime to runningTime
	}
	
	public double getRunningTime() //calls getRunningTime method and returns runningTime
	{
		return runningTime;
	}
	public double getAudioBookDiscount()
	{
		return audioBookDiscount;
	}
	
	@Override
	public double getPrice() //overrides getPrice and returns 90% of the price
	{
		return (getAudioBookDiscount() * (super.getPrice() / 0.9));
	}
	
	@Override
	public String toString() //overrides toString and returns audioBook string
	{
		return super.toString() + " | Running Time: " + getRunningTime();
	}
}
