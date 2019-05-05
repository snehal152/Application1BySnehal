package customExceptions;

public class ElementNotEnabledException extends RuntimeException{

	private String message;
	public ElementNotEnabledException(String message) {
		this.message = message;
	}
	
	public String toString()
	{
		return message;
	}

	public static void main(String[] args) {
		try{
			throw new ElementNotEnabledException("Element is not visibile");
		}catch(ElementNotEnabledException e)
		{
			System.out.println(e);
		}
	}
}
