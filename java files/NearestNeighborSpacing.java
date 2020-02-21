import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.InputStreamReader;

public class NearestNeighborSpacing {
public static double getProb(double s, int M) {
		
		double theta1 = 2.0944;
    	double theta2 = 5.0126;
    	double ro = 1.305688;
    	
    	
    	double minRadius = 1/ (double) M;
    	
    	int numpoints = 26990;
    	
    	//what is s value?
    	
    	
    	//have we checked its value for Cp?
    	
    	
    	int lessThanS = 0;
    	
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
		
		
		
	
		
		
		
		
       //what is the size of kdt
 
        KDTree kdt = new KDTree(numpoints*2);
        double x[] = new double[2];
        
       
        int times = 0;
        
        
        for (int i = 0; i < circlesList1.length; i++) {
        	if (circlesList1[i] != null) {
        		x[0] = circlesList1[i].getCenter().getRez();
        		x[1] = circlesList1[i].getCenter().getImz();
        		kdt.add(x);
        		times++;
        	}
        }
        
        for (int i = 0; i < circlesList2.length; i++) {
        	if (circlesList2[i] != null) {
        		x[0] = circlesList2[i].getCenter().getRez();
        		x[1] = circlesList2[i].getCenter().getImz();
        		kdt.add(x);
        		times++;
        	}
        }
        
        for (int i = 0; i < circlesList3.length; i++) {
        	if (circlesList3[i] != null) {
        		x[0] = circlesList3[i].getCenter().getRez();
        		x[1] = circlesList3[i].getCenter().getImz();
        		kdt.add(x);
        		times++;
        	}
        }
        
        for (int i = 0; i < circlesList4.length; i++) {
        	if (circlesList4[i] != null) {
        		x[0] = circlesList4[i].getCenter().getRez();
        		x[1] = circlesList4[i].getCenter().getImz();
        		kdt.add(x);
        		times++;
        	}
        }
        
        Point2D.Double[] checkList = new Point2D.Double[times];
        
        double sx = circlesList1[0].getCenter().getRez();
        double sy = circlesList1[0].getCenter().getImz();
        //or double s[]
        double[] sp = {sx, sy};
        Point2D.Double temp = new Point2D.Double(sx, sy);
        
        KDNode kdn = kdt.find_nearest(sp);
        double distance = kdt.nearestDistance(sp);
        if ((distance/(double) minRadius) < s) {
        	lessThanS++;
        	
        }
        
        for (int i = 1; i < circlesList1.length; i++) {
        	if (circlesList1[i] != null) {
        		sx = circlesList1[i].getCenter().getRez();
            	sy = circlesList1[i].getCenter().getImz();
            	sp[0] = sx;
            	sp[1] = sy;
                temp = new Point2D.Double(sx, sy);
                Point2D.Double temp2 = new Point2D.Double(sy, sx);
                
                kdn = kdt.find_nearest(sp);
                distance = kdt.nearestDistance(sp);
                
                	if ((distance/(double) minRadius) < s) {
                		lessThanS++;
                		checkList[lessThanS-1] = temp;
                	}
                
        	}
        	
            
        }
        
        for (int i = 0; i < circlesList2.length; i++) {
        	if (circlesList2[i] != null) {
        		sx = circlesList2[i].getCenter().getRez();
            	sy = circlesList2[i].getCenter().getImz();
            	sp[0] = sx;
            	sp[1] = sy;
                temp = new Point2D.Double(sx, sy);
                Point2D.Double temp2 = new Point2D.Double(sy, sx);
                
                kdn = kdt.find_nearest(sp);
                distance = kdt.nearestDistance(sp);
                
                	if ((distance/(double) minRadius) < s) {
                		lessThanS++;
                		checkList[lessThanS-1] = temp;
                	}
                
        	}
        	
            
        }
        
        for (int i = 0; i < circlesList3.length; i++) {
        	if (circlesList3[i] != null) {
        		sx = circlesList3[i].getCenter().getRez();
            	sy = circlesList3[i].getCenter().getImz();
            	sp[0] = sx;
            	sp[1] = sy;
                temp = new Point2D.Double(sx, sy);
                Point2D.Double temp2 = new Point2D.Double(sy, sx);
                
                kdn = kdt.find_nearest(sp);
                distance = kdt.nearestDistance(sp);
                
                	if ((distance/(double) minRadius) < s) {
                		lessThanS++;
                		checkList[lessThanS-1] = temp;
                	}
                
        	}
        	
        }
        
        for (int i = 0; i < circlesList4.length; i++) {
        	if (circlesList4[i] != null) {

            	sx = circlesList4[i].getCenter().getRez();
            	sy = circlesList4[i].getCenter().getImz();
            	sp[0] = sx;
            	sp[1] = sy;
                temp = new Point2D.Double(sx, sy);
                Point2D.Double temp2 = new Point2D.Double(sy, sx);
                
                kdn = kdt.find_nearest(sp);
                distance = kdt.nearestDistance(sp);
                
                	if ((distance/(double) minRadius) < s) {
                		lessThanS++;
                		checkList[lessThanS-1] = temp;
                	}
                
                
        	}
        	
        	
            
        }
        Tree.circlesList1 = new Circles[300000];
		Tree.circlesList2 = new Circles[300000];
		Tree.circlesList3 = new Circles[300000];
		Tree.circlesList4 = new Circles[300000];
		Tree.k = 0;
        
       
 
        double prob = lessThanS / (double) (M);
        
        System.out.println("The probability is " + prob);
 
        return prob;
    }
}
