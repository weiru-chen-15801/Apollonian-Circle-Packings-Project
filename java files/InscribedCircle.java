import java.awt.geom.Point2D;

public class InscribedCircle {
	
	private Point2D.Double p1;
    private Point2D.Double p2;
    private Point2D.Double p3;

    private double dis12;
    private double dis23;
    private double dis31;

    public InscribedCircle(Point2D.Double p1, Point2D.Double p2, Point2D.Double p3) {
        
    	this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        dis12 = distenceOfPoints(p1, p2);
        dis23 = distenceOfPoints(p2, p3);
        dis31 = distenceOfPoints(p3, p1);
    }
    
    public static Point2D.Double get2DCenter (Circles temp) {
        //circle center
        double x1 = temp.getCenter().getRez();
        double y1 = temp.getCenter().getImz();
        Point2D.Double p = new Point2D.Double(x1, y1);
        return p;
    }

    public static double distenceOfPoints(Point2D.Double p1, Point2D.Double p2) {
        //distance between two points
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public Point2D.Double innerCenter() {
        //inscribed circle center
        double p = perimeter();
        double x = (p1.x * dis23 + p2.x * dis31 + p3.x * dis12) / p;
        double y = (p1.y * dis23 + p2.y * dis31 + p3.y * dis12) / p;
        return new Point2D.Double(x, y);
    }

    public Point2D.Double outerCenter() {
        //circumcircle center
        double x1 = p1.x;
        double x2 = p2.x;
        double x3 = p3.x;
        double y1 = p1.y;
        double y2 = p2.y;
        double y3 = p3.y;
        double x = ((y2 - y1) * (y3 * y3 - y1 * y1 + x3 * x3 - x1 * x1) - (y3 - y1)
                * (y2 * y2 - y1 * y1 + x2 * x2 - x1 * x1))
                / (2 * (x3 - x1) * (y2 - y1) - 2 * ((x2 - x1) * (y3 - y1)));
        double y = ((x2 - x1) * (x3 * x3 - x1 * x1 + y3 * y3 - y1 * y1) - (x3 - x1)
                * (x2 * x2 - x1 * x1 + y2 * y2 - y1 * y1))
                / (2 * (y3 - y1) * (x2 - x1) - 2 * ((y2 - y1) * (x3 - x1)));
        return new Point2D.Double(x, y);

    }

    public double innerRadius() {
       //inscribed circle radius
        return (2 * area()) / (dis12 + dis23 + dis31);

    }

    public double outerRadius() {
    	//circumcircle radius
        return (dis12 * dis23 * dis31) / (4 * area());

    }

    public double area() {
    	//the area of the triangle
        double p = 0.5 * perimeter();
        return Math.sqrt(p * (p - dis12) * (p - dis23) * (p - dis31));
    }

    public double perimeter() {
    	//perimeter of the triangle
        return dis12 + dis23 + dis31;

    }

    //get the three points of the triangle
    //x value is the real part of complex point, y value is the imaginary part
    public Point2D.Double getP1() {
        return (Point2D.Double) p1.clone();
    }

    public Point2D.Double getP2() {
        return (Point2D.Double) p2.clone();
    }

    public Point2D.Double getP3() {
        return (Point2D.Double) p3.clone();
    }


}
