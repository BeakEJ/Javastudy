import javax.swing.JFrame;

public class Final_c extends JFrame {
	static String question = null;
	static String ex1 = null;
	static String ex2 = null;
	static String ex3 = null;
	static String ex4 = null;
	static int num = 0;
	static int score = 0;
	static int count;
	
	private int S(boolean a){
		if(a==true){
			score++;
		}
		return score;
	}
	public void ok(){
		count = (new Final()).c();
		count++;
		System.out.println(count);
	}
	public void nok(){
		count = (new Final()).c();
		count++;
		System.out.println(count);
	}
	public static int r(){
		return count;
	}
}