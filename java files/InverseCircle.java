
public class InverseCircle {
	
	public static double getRadiusOfInverseCircle(double theta1, double theta2) {
		//the radius of the inverse circle to be mapped
		double numerator = Math.sin(theta2-theta1);
		double denominator = 1+Math.cos(theta2-theta1);
		double fraction = (double) numerator / denominator;
		if (fraction < 0)
			fraction = -fraction;
		return fraction;
	}
	
	public static ComplexNum getCenterOfInverseCircle(double theta1, double theta2) {
		//the center of the inverse circle to be mapped
		double real = (double) (Math.sin(theta2)-Math.sin(theta1)) / Math.sin(theta2-theta1);
		double imaginary = (double) (Math.cos(theta1)-Math.cos(theta2)) 
				/ Math.sin(theta2-theta1);
		ComplexNum center = new ComplexNum();
		center.setRez(real);
		center.setImz(imaginary);
		return center;
	}
}
