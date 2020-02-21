
public class TestForCp {
	public static void main(String[] args) {
		int numOfCircles = 3298;
		int M = 1000;
		
		double ro = 1.305688;
		double c_p = numOfCircles / (double) (Math.pow(M, ro));
		System.out.println("The value for Cp is " + c_p);
		
		int numOfCircles2 = 26990;
		int M2 = 5000;
		
		double ro2 = 1.305688;
		double c_p2 = numOfCircles2 / (double) (Math.pow(M2, ro2));
		System.out.println("The value for Cp is " + c_p2);
		
		int numOfCircles3 = 59634;
		int M3 = 10000;
		double c_p3 = numOfCircles3 / (double) (Math.pow(M3, ro));
		System.out.println("The value for Cp is " + c_p3);
		
		int numOfCircles4 = 164888;
		int M4 = 20000;
		double c_p4 = numOfCircles4 / (double) (Math.pow(M4, ro));
		System.out.println("The value for Cp is " + c_p4);
		
		int numOfCircles5 = 147558;
		int M5 = 20000;
		double c_p5 = numOfCircles5 / (double) (Math.pow(M5, ro));
		System.out.println("The value for Cp is " + c_p5);
	}
}
