import java.util.Scanner;
import java.awt.geom.Point2D;


public class Trial{
	
	
	private static Scanner input;
	

	public static void main (String[] args) {
		
		
		input = new Scanner(System.in);
		System.out.println("Please enter the first theta: ");
		double theta1 = input.nextDouble();
		System.out.println("Please enter the second theta: ");
		double theta2 = input.nextDouble();
		
		Circles Circle1 = new Circles();
		Circles Circle2 = new Circles();
		Circles Circle3 = new Circles();
		
		ComplexNum tangency1 = new ComplexNum();
		tangency1.setRez(Math.cos(theta1));
		tangency1.setImz(Math.sin(theta1));
		Circle2.setTangency(tangency1);
		
		ComplexNum tangency2 = new ComplexNum();
		tangency2.setRez(Math.cos(theta2));
		tangency2.setImz(Math.sin(theta2));
		Circle3.setTangency(tangency2);
		
		Circles OriginalCircle = new Circles();
		OriginalCircle.setRadius(Circles.mobiousRadiusTransformation0(Circle2, Circle3, 0.0));
		OriginalCircle.setCenter(Circles.mobiousCenterTransformation0(Circle2, Circle3, 0.0));
		
		Circle1.setRadius(Circles.mobiousRadiusTransformation1(Circle2, Circle3, 1.0));
		Circle1.setCenter(Circles.mobiousCenterTransformation1(Circle2, Circle3, 1.0));
		
		ComplexNum center2 = new ComplexNum();
		center2.setRez(0.0);
		center2.setImz(0.5);
		
		ComplexNum center3 = new ComplexNum();
		center3.setRez(1.0);
		center3.setImz(0.5);
		
		Circle2.setRadius(Circles.mobiousRadiusTransformation2(Circle2, Circle3, center2, 0.5));
		Circle2.setCenter(Circles.mobiousCenterTransformation2(Circle2, Circle3, center2, 0.5));
		
		Circle3.setRadius(Circles.mobiousRadiusTransformation3(Circle2, Circle3, center3, 0.5));
		Circle3.setCenter(Circles.mobiousCenterTransformation3(Circle2, Circle3, center3, 0.5));
		
		Circles[] listOfCircles = new Circles[4];
		listOfCircles[0] = OriginalCircle;
		listOfCircles[1] = Circle1;
		listOfCircles[2] = Circle2;
		listOfCircles[3] = Circle3;
		
		Point2D.Double p1 = new Point2D.Double(0, 0);
		Point2D.Double p2 = new Point2D.Double(0, 0);
		Point2D.Double p3 = new Point2D.Double(0, 0);
		
		//inversion
		p1.x = Circle1.getCenter().getRez();
		p1.y = Circle1.getCenter().getImz();
		p2.x = Circle2.getCenter().getRez();
		p2.y = Circle2.getCenter().getImz();
		p3.x = Circle3.getCenter().getRez();
		p3.y = Circle3.getCenter().getImz();
		
		InscribedCircle triangle = new InscribedCircle(p1, p2, p3);
		Point2D.Double centerOfInversePoint = triangle.innerCenter();
		double radiusOfInverse = triangle.innerRadius();
		
		ComplexNum centerOfInverse = new ComplexNum();
		centerOfInverse.setRez(centerOfInversePoint.x);
		centerOfInverse.setImz(centerOfInversePoint.y);
		
		Circles inversedCircle1 = new Circles();
		inversedCircle1.setCenter(centerOfInverse);
		inversedCircle1.setRadius(radiusOfInverse);
		
		Circles inversedCircle2 = new Circles();
		inversedCircle2.setCenter(InverseCircle.getCenterOfInverseCircle(theta1, theta2));
		inversedCircle2.setRadius(InverseCircle.getRadiusOfInverseCircle(theta1, theta2));
		
		//theta1 = 0
		Circles inversedCircle3 = new Circles();
		inversedCircle3.setCenter(InverseCircle.getCenterOfInverseCircle(0, theta2));
		inversedCircle3.setRadius(InverseCircle.getRadiusOfInverseCircle(0, theta2));
		
		//theta2 = 0
		Circles inversedCircle4 = new Circles();
		inversedCircle4.setCenter(InverseCircle.getCenterOfInverseCircle(theta1, 0));
		inversedCircle4.setRadius(InverseCircle.getRadiusOfInverseCircle(theta1, 0));
		
		//tree code---not figured out yet
		Circles[] inversionList = new Circles[100];
		
		for (int i = 0; i < 100; i++) {
			inversionList[i] = new Circles();
		}
		
		int k = 0;
		
		int currentNumber = 0;
		
		
		int previousRandomNumber = 0;
		
		
		
		
		
		
		
		
		
	}
	
}	