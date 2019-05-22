
public class Validator implements Acceptable 
{

	@Override
	public boolean isNonEmptyString(String s) 
	{
		return !s.isEmpty();
	}
	
	@Override
	public boolean isPositive(double d) 
	{
		if (d>0)
			return true;
		else
			return false;
	}
	public boolean isPositive(int n)
	{
		if (n>0)
			return true;
		else
			return false;
	}
}
