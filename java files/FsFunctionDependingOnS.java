import java.awt.geom.Point2D;

public class FsFunctionDependingOnS {
	
	public static double getDistance(Point2D.Double m, Point2D.Double n) {
    	double mx = m.x;
    	double my = m.y;
    	double nx = n.x;
    	double ny = n.y;
    	double distance = Math.sqrt(Math.pow(mx-nx, 2)+Math.pow(my-ny, 2));
    	return distance;
    	
    }
	
	public static int getNumberOfPoints(int newM) {
		int M = newM;
		double theta1 = 1.5712;
    	double theta2 = 5.0126;
    	
    	double minRadius = 1/ (double) M;
    	//when M = 1000
    	
    	
    	ComplexNum tangency1 = new ComplexNum();
		tangency1.setRez(Math.cos(theta1));
		tangency1.setImz(Math.sin(theta1));
		
		ComplexNum tangency2 = new ComplexNum();
		tangency2.setRez(Math.cos(theta2));
		tangency2.setImz(Math.sin(theta2));
		
		Circles oldOriginalCircle = new Circles(1.0, new ComplexNum(0.0, 0.0), Circles.zero);
		
        
        
        //reserve old values
        
        
		Circles oldCircle2 = new Circles();
		Circles oldCircle3 = new Circles();
        oldCircle2.setTangency(tangency1);
        oldCircle3.setTangency(tangency2);
        
        double radiusCircle1 = Circles.mobiousRadiusTransformation1(oldCircle2, oldCircle3, 1.0);
        ComplexNum centerCircle1 = Circles.mobiousCenterTransformation1(oldCircle2, oldCircle3, 1.0);
        
        Circles oldCircle1 = new Circles();
        oldCircle1.setRadius(radiusCircle1);
        oldCircle1.setCenter(centerCircle1);
        
        
        //set circle data
        
        ComplexNum center2 = new ComplexNum();
		center2.setRez(0.0);
		center2.setImz(0.5);
		
		ComplexNum center3 = new ComplexNum();
		center3.setRez(1.0);
		center3.setImz(0.5);
		
		
		double radiusCircle2 = Circles.mobiousRadiusTransformation2(oldCircle2, oldCircle3, center2, 0.5);
		ComplexNum centerCircle2 = Circles.mobiousCenterTransformation2(oldCircle2, oldCircle3, center2, 0.5);
		
		double radiusCircle3 = Circles.mobiousRadiusTransformation3(oldCircle2, oldCircle3, center3, 0.5);
		ComplexNum centerCircle3 = Circles.mobiousCenterTransformation3(oldCircle2, oldCircle3, center3, 0.5);
        
        oldCircle2.setRadius(radiusCircle2);
        oldCircle2.setCenter(centerCircle2);
		
		
        
        oldCircle3.setRadius(radiusCircle3);
        oldCircle3.setCenter(centerCircle3);
        
        
        
        Point2D.Double p1 = new Point2D.Double(0, 0);
		Point2D.Double p2 = new Point2D.Double(0, 0);
		Point2D.Double p3 = new Point2D.Double(0, 0);
		
		//inversion
		p1.x = oldCircle1.getCenter().getRez();
		p1.y = oldCircle1.getCenter().getImz();
		p2.x = oldCircle2.getCenter().getRez();
		p2.y = oldCircle2.getCenter().getImz();
		p3.x = oldCircle3.getCenter().getRez();
		p3.y = oldCircle3.getCenter().getImz();
		
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
		
		Circles inversedCircle3 = new Circles();
		inversedCircle3.setCenter(InverseCircle.getCenterOfInverseCircle(0, theta2));
		inversedCircle3.setRadius(InverseCircle.getRadiusOfInverseCircle(0, theta2));
		
		Circles inversedCircle4 = new Circles();
		inversedCircle4.setCenter(InverseCircle.getCenterOfInverseCircle(theta1, 0));
		inversedCircle4.setRadius(InverseCircle.getRadiusOfInverseCircle(theta1, 0));
		
		Circles testCircle1 = new Circles();
		testCircle1 = Inversion.circleInversion(oldOriginalCircle, inversedCircle1, 0.001);
		
		Circles testCircle2 = new Circles();
		testCircle2 = Inversion.circleInversion(oldCircle1, inversedCircle2, 0.01);
		
		Circles testCircle3 = new Circles();
		testCircle3 = Inversion.circleInversion(oldCircle2, inversedCircle3, 0.01);
		
		Circles testCircle4 = new Circles();
		testCircle4 = Inversion.circleInversion(oldCircle3, inversedCircle4, 0.01);
		
		
		Tree tCircle1 = new Tree(testCircle1, 1, null, null, null, null);
		Tree tCircle2 = new Tree(testCircle2, 2, null, null, null, null);
		Tree tCircle3 = new Tree(testCircle3, 3, null, null, null, null);
		Tree tCircle4 = new Tree(testCircle4, 4, null, null, null, null);
		
		//change into old values
		Tree.reproduction(tCircle1, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Tree.reproduction(tCircle2, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Tree.reproduction(tCircle3, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Tree.reproduction(tCircle4, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		
		Circles[] circlesList1 = Tree.putCirclesList1(tCircle1, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Circles[] circlesList2 = Tree.putCirclesList2(tCircle2, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Circles[] circlesList3 = Tree.putCirclesList3(tCircle3, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Circles[] circlesList4 = Tree.putCirclesList4(tCircle4, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		
	    
		int times = 0;
		//int or long
		
		
		Circles[] totalList = new Circles[circlesList1.length + circlesList2.length + 
		                                  circlesList3.length + circlesList4.length];
	    for (int i = 0; i < circlesList1.length; i++) {
	    	if (circlesList1[i] != null) {
	    		totalList[times] = new Circles(circlesList1[i]);
	    		times++;
	    	}
	    }
	    
	    for (int i = 0; i < circlesList2.length; i++) {
	    	if (circlesList2[i] != null) {
	    		totalList[times] = new Circles(circlesList2[i]);
	    		times++;
	    	}
	    }
	    
	    for (int i = 0; i < circlesList3.length; i++) {
	    	if (circlesList3[i] != null) {
	    		totalList[times] = new Circles(circlesList3[i]);
	    		times++;
	    	}
	    }
	    
	    for (int i = 0; i < circlesList4.length; i++) {
	    	if (circlesList4[i] != null) {
	    		totalList[times] = new Circles(circlesList4[i]);
	    		times++;
	    	}
	    }
	    
	    Tree.circlesList1 = new Circles[300000];
		Tree.circlesList2 = new Circles[300000];
		Tree.circlesList3 = new Circles[300000];
		Tree.circlesList4 = new Circles[300000];
		Tree.k = 0;
		
		int numberOfPoints = 0;
		
		for (int i = 0; i < totalList.length; i++) {
			if (totalList[i] != null){
				numberOfPoints++;
			}
		}
		
		return numberOfPoints;
	    
	}
	
public static double getProb(double newS, int newM) {
		
		//first: 2.0944
		//second: 1.5712
		
		double theta1 = 1.5712;
    	double theta2 = 5.0126;
    	double ro = 1.305688;
    	
    	int M = newM;
    	
    	double minRadius = 1/ (double) M;
    	//when M = 1000
    	
    	
    	//what is s value?
    	double s = newS;
    	
    	//have we checked its value?
    	
    	
    	ComplexNum tangency1 = new ComplexNum();
		tangency1.setRez(Math.cos(theta1));
		tangency1.setImz(Math.sin(theta1));
		
		ComplexNum tangency2 = new ComplexNum();
		tangency2.setRez(Math.cos(theta2));
		tangency2.setImz(Math.sin(theta2));
		
		Circles oldOriginalCircle = new Circles(1.0, new ComplexNum(0.0, 0.0), Circles.zero);
		
        
        
        //reserve old values
        
        
		Circles oldCircle2 = new Circles();
		Circles oldCircle3 = new Circles();
        oldCircle2.setTangency(tangency1);
        oldCircle3.setTangency(tangency2);
        
        double radiusCircle1 = Circles.mobiousRadiusTransformation1(oldCircle2, oldCircle3, 1.0);
        ComplexNum centerCircle1 = Circles.mobiousCenterTransformation1(oldCircle2, oldCircle3, 1.0);
        
        Circles oldCircle1 = new Circles();
        oldCircle1.setRadius(radiusCircle1);
        oldCircle1.setCenter(centerCircle1);
        
        
        //set circle data
        
        ComplexNum center2 = new ComplexNum();
		center2.setRez(0.0);
		center2.setImz(0.5);
		
		ComplexNum center3 = new ComplexNum();
		center3.setRez(1.0);
		center3.setImz(0.5);
		
		
		double radiusCircle2 = Circles.mobiousRadiusTransformation2(oldCircle2, oldCircle3, center2, 0.5);
		ComplexNum centerCircle2 = Circles.mobiousCenterTransformation2(oldCircle2, oldCircle3, center2, 0.5);
		
		double radiusCircle3 = Circles.mobiousRadiusTransformation3(oldCircle2, oldCircle3, center3, 0.5);
		ComplexNum centerCircle3 = Circles.mobiousCenterTransformation3(oldCircle2, oldCircle3, center3, 0.5);
        
        oldCircle2.setRadius(radiusCircle2);
        oldCircle2.setCenter(centerCircle2);
		
		
        
        oldCircle3.setRadius(radiusCircle3);
        oldCircle3.setCenter(centerCircle3);
        
        
        
        Point2D.Double p1 = new Point2D.Double(0, 0);
		Point2D.Double p2 = new Point2D.Double(0, 0);
		Point2D.Double p3 = new Point2D.Double(0, 0);
		
		//inversion
		p1.x = oldCircle1.getCenter().getRez();
		p1.y = oldCircle1.getCenter().getImz();
		p2.x = oldCircle2.getCenter().getRez();
		p2.y = oldCircle2.getCenter().getImz();
		p3.x = oldCircle3.getCenter().getRez();
		p3.y = oldCircle3.getCenter().getImz();
		
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
		
		Circles inversedCircle3 = new Circles();
		inversedCircle3.setCenter(InverseCircle.getCenterOfInverseCircle(0, theta2));
		inversedCircle3.setRadius(InverseCircle.getRadiusOfInverseCircle(0, theta2));
		
		Circles inversedCircle4 = new Circles();
		inversedCircle4.setCenter(InverseCircle.getCenterOfInverseCircle(theta1, 0));
		inversedCircle4.setRadius(InverseCircle.getRadiusOfInverseCircle(theta1, 0));
		
		Circles testCircle1 = new Circles();
		testCircle1 = Inversion.circleInversion(oldOriginalCircle, inversedCircle1, 0.001);
		
		Circles testCircle2 = new Circles();
		testCircle2 = Inversion.circleInversion(oldCircle1, inversedCircle2, 0.01);
		
		Circles testCircle3 = new Circles();
		testCircle3 = Inversion.circleInversion(oldCircle2, inversedCircle3, 0.01);
		
		Circles testCircle4 = new Circles();
		testCircle4 = Inversion.circleInversion(oldCircle3, inversedCircle4, 0.01);
		
		
		Tree tCircle1 = new Tree(testCircle1, 1, null, null, null, null);
		Tree tCircle2 = new Tree(testCircle2, 2, null, null, null, null);
		Tree tCircle3 = new Tree(testCircle3, 3, null, null, null, null);
		Tree tCircle4 = new Tree(testCircle4, 4, null, null, null, null);
		
		//change into old values
		Tree.reproduction(tCircle1, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Tree.reproduction(tCircle2, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Tree.reproduction(tCircle3, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Tree.reproduction(tCircle4, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		
		int numberOfPoints = getNumberOfPoints(newM);

		
		
		Circles[] circlesList1 = Tree.putCirclesList1(tCircle1, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Circles[] circlesList2 = Tree.putCirclesList2(tCircle2, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Circles[] circlesList3 = Tree.putCirclesList3(tCircle3, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		Circles[] circlesList4 = Tree.putCirclesList4(tCircle4, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		
		int times = 0;
		//int or long
		int number = 0;
		
		Circles[] totalList = new Circles[circlesList1.length + circlesList2.length + 
		                                  circlesList3.length + circlesList4.length];
	    for (int i = 0; i < circlesList1.length; i++) {
	    	if (circlesList1[i] != null) {
	    		totalList[times] = new Circles(circlesList1[i]);
	    		times++;
	    	}
	    }
	    
	    for (int i = 0; i < circlesList2.length; i++) {
	    	if (circlesList2[i] != null) {
	    		totalList[times] = new Circles(circlesList2[i]);
	    		times++;
	    	}
	    }
	    
	    for (int i = 0; i < circlesList3.length; i++) {
	    	if (circlesList3[i] != null) {
	    		totalList[times] = new Circles(circlesList3[i]);
	    		times++;
	    	}
	    }
	    
	    for (int i = 0; i < circlesList4.length; i++) {
	    	if (circlesList4[i] != null) {
	    		totalList[times] = new Circles(circlesList4[i]);
	    		times++;
	    	}
	    }
	    
	    Tree.circlesList1 = new Circles[300000];
		Tree.circlesList2 = new Circles[300000];
		Tree.circlesList3 = new Circles[300000];
		Tree.circlesList4 = new Circles[300000];
		Tree.k = 0;
	    
	    Point2D.Double zi;
	    Point2D.Double zj;
	    double distance;
	    double ratio;
		
        for (int i = 0; i < totalList.length-1; i++) {
        	if (totalList[i] != null) {
        		for (int j = i+1; j < totalList.length; j++) {
        			if (totalList[j] != null) {
        				zi = new Point2D.Double(totalList[i].getCenter().getRez(), 
        						totalList[i].getCenter().getImz());
        				zj = new Point2D.Double(totalList[j].getCenter().getRez(), 
        						totalList[j].getCenter().getImz());
        				distance = getDistance(zi, zj);
        				//divide or times
        				ratio = (double) (distance * M);
        				if (ratio < s)
        					number++;
        				
        			}
        		}
        	}
        }
        
        
        
        
 
        double prob = number / (double) (numberOfPoints);
        System.out.println("The probability is " + prob);
        
        return prob;
 
        
    }

public static double getProb2(double newS, int newM) {
	
	//first: 2.0944
	//second: 1.5712
	
	double theta1 = 2.0944;
	double theta2 = 5.0126;
	double ro = 1.305688;
	
	int M = newM;
	
	double minRadius = 1/ (double) M;
	//when M = 1000
	
	
	//what is s value?
	double s = newS;
	
	//have we checked its value?
	
	
	ComplexNum tangency1 = new ComplexNum();
	tangency1.setRez(Math.cos(theta1));
	tangency1.setImz(Math.sin(theta1));
	
	ComplexNum tangency2 = new ComplexNum();
	tangency2.setRez(Math.cos(theta2));
	tangency2.setImz(Math.sin(theta2));
	
	Circles oldOriginalCircle = new Circles(1.0, new ComplexNum(0.0, 0.0), Circles.zero);
	
    
    
    //reserve old values
    
    
	Circles oldCircle2 = new Circles();
	Circles oldCircle3 = new Circles();
    oldCircle2.setTangency(tangency1);
    oldCircle3.setTangency(tangency2);
    
    double radiusCircle1 = Circles.mobiousRadiusTransformation1(oldCircle2, oldCircle3, 1.0);
    ComplexNum centerCircle1 = Circles.mobiousCenterTransformation1(oldCircle2, oldCircle3, 1.0);
    
    Circles oldCircle1 = new Circles();
    oldCircle1.setRadius(radiusCircle1);
    oldCircle1.setCenter(centerCircle1);
    
    
    //set circle data
    
    ComplexNum center2 = new ComplexNum();
	center2.setRez(0.0);
	center2.setImz(0.5);
	
	ComplexNum center3 = new ComplexNum();
	center3.setRez(1.0);
	center3.setImz(0.5);
	
	
	double radiusCircle2 = Circles.mobiousRadiusTransformation2(oldCircle2, oldCircle3, center2, 0.5);
	ComplexNum centerCircle2 = Circles.mobiousCenterTransformation2(oldCircle2, oldCircle3, center2, 0.5);
	
	double radiusCircle3 = Circles.mobiousRadiusTransformation3(oldCircle2, oldCircle3, center3, 0.5);
	ComplexNum centerCircle3 = Circles.mobiousCenterTransformation3(oldCircle2, oldCircle3, center3, 0.5);
    
    oldCircle2.setRadius(radiusCircle2);
    oldCircle2.setCenter(centerCircle2);
	
	
    
    oldCircle3.setRadius(radiusCircle3);
    oldCircle3.setCenter(centerCircle3);
    
    
    
    Point2D.Double p1 = new Point2D.Double(0, 0);
	Point2D.Double p2 = new Point2D.Double(0, 0);
	Point2D.Double p3 = new Point2D.Double(0, 0);
	
	//inversion
	p1.x = oldCircle1.getCenter().getRez();
	p1.y = oldCircle1.getCenter().getImz();
	p2.x = oldCircle2.getCenter().getRez();
	p2.y = oldCircle2.getCenter().getImz();
	p3.x = oldCircle3.getCenter().getRez();
	p3.y = oldCircle3.getCenter().getImz();
	
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
	
	Circles inversedCircle3 = new Circles();
	inversedCircle3.setCenter(InverseCircle.getCenterOfInverseCircle(0, theta2));
	inversedCircle3.setRadius(InverseCircle.getRadiusOfInverseCircle(0, theta2));
	
	Circles inversedCircle4 = new Circles();
	inversedCircle4.setCenter(InverseCircle.getCenterOfInverseCircle(theta1, 0));
	inversedCircle4.setRadius(InverseCircle.getRadiusOfInverseCircle(theta1, 0));
	
	Circles testCircle1 = new Circles();
	testCircle1 = Inversion.circleInversion(oldOriginalCircle, inversedCircle1, 0.001);
	
	Circles testCircle2 = new Circles();
	testCircle2 = Inversion.circleInversion(oldCircle1, inversedCircle2, 0.01);
	
	Circles testCircle3 = new Circles();
	testCircle3 = Inversion.circleInversion(oldCircle2, inversedCircle3, 0.01);
	
	Circles testCircle4 = new Circles();
	testCircle4 = Inversion.circleInversion(oldCircle3, inversedCircle4, 0.01);
	
	
	Tree tCircle1 = new Tree(testCircle1, 1, null, null, null, null);
	Tree tCircle2 = new Tree(testCircle2, 2, null, null, null, null);
	Tree tCircle3 = new Tree(testCircle3, 3, null, null, null, null);
	Tree tCircle4 = new Tree(testCircle4, 4, null, null, null, null);
	
	//change into old values
	Tree.reproduction(tCircle1, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
	Tree.reproduction(tCircle2, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
	Tree.reproduction(tCircle3, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
	Tree.reproduction(tCircle4, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
	
	
	Circles[] circlesList1 = Tree.putCirclesList1(tCircle1, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
	Circles[] circlesList2 = Tree.putCirclesList2(tCircle2, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
	Circles[] circlesList3 = Tree.putCirclesList3(tCircle3, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
	Circles[] circlesList4 = Tree.putCirclesList4(tCircle4, minRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
	
	int times = 0;
	//int or long
	int number = 0;
	
	Circles[] totalList = new Circles[circlesList1.length + circlesList2.length + 
	                                  circlesList3.length + circlesList4.length];
    for (int i = 0; i < circlesList1.length; i++) {
    	if (circlesList1[i] != null) {
    		totalList[times] = new Circles(circlesList1[i]);
    		times++;
    	}
    }
    
    for (int i = 0; i < circlesList2.length; i++) {
    	if (circlesList2[i] != null) {
    		totalList[times] = new Circles(circlesList2[i]);
    		times++;
    	}
    }
    
    for (int i = 0; i < circlesList3.length; i++) {
    	if (circlesList3[i] != null) {
    		totalList[times] = new Circles(circlesList3[i]);
    		times++;
    	}
    }
    
    for (int i = 0; i < circlesList4.length; i++) {
    	if (circlesList4[i] != null) {
    		totalList[times] = new Circles(circlesList4[i]);
    		times++;
    	}
    }
    
    Tree.circlesList1 = new Circles[300000];
	Tree.circlesList2 = new Circles[300000];
	Tree.circlesList3 = new Circles[300000];
	Tree.circlesList4 = new Circles[300000];
	Tree.k = 0;
    
    Point2D.Double zi;
    Point2D.Double zj;
    double distance;
    double ratio;
	
    for (int i = 0; i < totalList.length-1; i++) {
    	if (totalList[i] != null) {
    		for (int j = i+1; j < totalList.length; j++) {
    			if (totalList[j] != null) {
    				zi = new Point2D.Double(totalList[i].getCenter().getRez(), 
    						totalList[i].getCenter().getImz());
    				zj = new Point2D.Double(totalList[j].getCenter().getRez(), 
    						totalList[j].getCenter().getImz());
    				distance = getDistance(zi, zj);
    				//divide or times
    				ratio = (double) (distance * M);
    				if (ratio < s)
    					number++;
    				
    			}
    		}
    	}
    }
    
    
    
    

    double prob = number / (double) (getNumberOfPoints(M));
    System.out.println("The probability is " + prob);
    
    return prob;

    
}
}
