package brokenKeyboard;

public class Solver {

	//private String regex = "^[]+$";
	
	public static boolean matches(String input, String pattern){
		return input.matches(String.format("^[%s]+$", pattern));
	}
}
