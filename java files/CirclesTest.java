import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Point2D;

	import java.awt.Graphics;

	import java.awt.Graphics2D;

	import java.awt.RenderingHints;

	import java.awt.Toolkit;

	import java.awt.geom.Point2D;


	import javax.swing.JFrame;

	import javax.swing.JPanel;

	import javax.swing.SwingUtilities;

public class CirclesTest extends JPanel{
	private static final long serialVersionUID = 1L;

    private Circles oldOriginalCircle;
    private Circles oldCircle1;
    private Circles oldCircle2;
    private Circles oldCircle3;
    
    private Circles OriginalCircle;
    private Circles Circle1;
    private Circles Circle2;
    private Circles Circle3;
    
    
    
    private Circles inversedCircle1;
    private Circles inversedCircle2;
    private Circles inversedCircle3;
    private Circles inversedCircle4;
    
    private Circles testCircle1;
    private Circles testCircle2;
    private Circles testCircle3;
    private Circles testCircle4;
    private Circles testCircle5;
    private Circles testCircle6;
    private Circles testCircle7;
    private Circles testCircle8;
    private Circles testCircle9;
    private Circles testCircle10;
    private Circles testCircle11;
    private Circles testCircle12;
    private Circles testCircle13;
    private Circles testCircle14;
    private Circles testCircle15;
    private Circles testCircle16;

	

	


    public CirclesTest() {
    	
    	//the data of two thetas
    	double theta1 = 2.0944;
    	double theta2 = 4.1888;
    	
    	ComplexNum tangency1 = new ComplexNum();
		tangency1.setRez(Math.cos(theta1));
		tangency1.setImz(Math.sin(theta1));
		
		ComplexNum tangency2 = new ComplexNum();
		tangency2.setRez(Math.cos(theta2));
		tangency2.setImz(Math.sin(theta2));
		
		oldOriginalCircle = new Circles(1.0, new ComplexNum(0.0, 0.0), Circles.zero);
		
        OriginalCircle = new Circles(100.0, new ComplexNum(200.0, 200.0), Circles.zero);
        
        //reserve old values
        
        
        oldCircle2 = new Circles();
        oldCircle3 = new Circles();
        oldCircle2.setTangency(tangency1);
        oldCircle3.setTangency(tangency2);
        
        double radiusCircle1 = Circles.mobiousRadiusTransformation1(oldCircle2, oldCircle3, 1.0);
        ComplexNum centerCircle1 = Circles.mobiousCenterTransformation1(oldCircle2, oldCircle3, 1.0);
        
        oldCircle1 = new Circles();
        oldCircle1.setRadius(radiusCircle1);
        oldCircle1.setCenter(centerCircle1);
        
        Circle1 = new Circles(100.0*radiusCircle1, 
        		new ComplexNum(200.0+100.0*centerCircle1.getRez(), 200.0-100.0*centerCircle1.getImz()), 
        		new ComplexNum(1.0, 0.0));
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
		
		Circle2 = new Circles(100.0*radiusCircle2, 
        		new ComplexNum(200.0+100.0*centerCircle2.getRez(), 200.0-100.0*centerCircle2.getImz()), 
        		new ComplexNum(tangency1.getRez(), tangency1.getImz()));
        
        oldCircle3.setRadius(radiusCircle3);
        oldCircle3.setCenter(centerCircle3);
        
        Circle3 = new Circles(100.0*radiusCircle3, 
        		new ComplexNum(200.0+100.0*centerCircle3.getRez(), 200.0-100.0*centerCircle3.getImz()), 
        		new ComplexNum(tangency2.getRez(), tangency2.getImz()));
        
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
		
		inversedCircle1 = new Circles();
		inversedCircle1.setCenter(centerOfInverse);
		inversedCircle1.setRadius(radiusOfInverse);
		
		inversedCircle2 = new Circles();
		inversedCircle2.setCenter(InverseCircle.getCenterOfInverseCircle(theta1, theta2));
		inversedCircle2.setRadius(InverseCircle.getRadiusOfInverseCircle(theta1, theta2));
		
		inversedCircle3 = new Circles();
		inversedCircle3.setCenter(InverseCircle.getCenterOfInverseCircle(0, theta2));
		inversedCircle3.setRadius(InverseCircle.getRadiusOfInverseCircle(0, theta2));
		
		inversedCircle4 = new Circles();
		inversedCircle4.setCenter(InverseCircle.getCenterOfInverseCircle(theta1, 0));
		inversedCircle4.setRadius(InverseCircle.getRadiusOfInverseCircle(theta1, 0));
		
		testCircle1 = new Circles();
		testCircle1 = Inversion.circleInversion(oldOriginalCircle, inversedCircle1, 0.001);
		
		testCircle2 = new Circles();
		testCircle2 = Inversion.circleInversion(oldCircle1, inversedCircle2, 0.001);
		
		testCircle3 = new Circles();
		testCircle3 = Inversion.circleInversion(oldCircle2, inversedCircle3, 0.001);
		
		testCircle4 = new Circles();
		testCircle4 = Inversion.circleInversion(oldCircle3, inversedCircle4, 0.001);
		
		testCircle5 = new Circles();
		testCircle5 = Inversion.circleInversion(testCircle1, inversedCircle2, 0.001);
		
		testCircle6 = new Circles();
		testCircle6 = Inversion.circleInversion(testCircle1, inversedCircle3, 0.001);
		
		testCircle7 = new Circles();
		testCircle7 = Inversion.circleInversion(testCircle1, inversedCircle4, 0.001);
		
		testCircle8 = new Circles();
		testCircle8 = Inversion.circleInversion(testCircle2, inversedCircle1, 0.001);
		
		testCircle9 = new Circles();
		testCircle9 = Inversion.circleInversion(testCircle2, inversedCircle3, 0.001);
		
		testCircle10 = new Circles();
		testCircle10 = Inversion.circleInversion(testCircle2, inversedCircle4, 0.001);
		
		testCircle11= new Circles();
		testCircle11 = Inversion.circleInversion(testCircle3, inversedCircle1, 0.001);
		
		testCircle12 = new Circles();
		testCircle12 = Inversion.circleInversion(testCircle3, inversedCircle2, 0.001);
		
		testCircle13 = new Circles();
		testCircle13 = Inversion.circleInversion(testCircle3, inversedCircle4, 0.001);
		
		testCircle14 = new Circles();
		testCircle14 = Inversion.circleInversion(testCircle4, inversedCircle1, 0.001);
		
		testCircle15 = new Circles();
		testCircle15 = Inversion.circleInversion(testCircle4, inversedCircle2, 0.001);
		
		testCircle16 = new Circles();
		testCircle16 = Inversion.circleInversion(testCircle4, inversedCircle3, 0.001);
		
		
		
	//does it exist?
		inversedCircle1 = new Circles(100.0*inversedCircle1.getRadius(), 
        		new ComplexNum(200.0+100.0*inversedCircle1.getCenter().getRez(), 
        				200.0-100.0*inversedCircle1.getCenter().getImz()), Circles.zero);
		
		
		
		inversedCircle2 = new Circles(100.0*inversedCircle2.getRadius(), 
        		new ComplexNum(200.0+100.0*inversedCircle2.getCenter().getRez(), 
        				200.0-100.0*inversedCircle2.getCenter().getImz()), Circles.zero);
		
		//theta1 = 0
		
		
		inversedCircle3 = new Circles(100.0*inversedCircle3.getRadius(), 
        		new ComplexNum(200.0+100.0*inversedCircle3.getCenter().getRez(), 
        				200.0-100.0*inversedCircle3.getCenter().getImz()), Circles.zero);
		
		//theta2 = 0
		
		
		inversedCircle4 = new Circles(100.0*inversedCircle4.getRadius(), 
        		new ComplexNum(200.0+100.0*inversedCircle4.getCenter().getRez(), 
        				200.0-100.0*inversedCircle4.getCenter().getImz()), Circles.zero);
		
		testCircle1 = new Circles(100.0*testCircle1.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle1.getCenter().getRez(), 
        				200.0-100.0*testCircle1.getCenter().getImz()), Circles.zero);
		
		testCircle2 = new Circles(100.0*testCircle2.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle2.getCenter().getRez(), 
        				200.0-100.0*testCircle2.getCenter().getImz()), Circles.zero);
		
		testCircle3 = new Circles(100.0*testCircle3.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle3.getCenter().getRez(), 
        				200.0-100.0*testCircle3.getCenter().getImz()), Circles.zero);
		
		testCircle4 = new Circles(100.0*testCircle4.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle4.getCenter().getRez(), 
        				200.0-100.0*testCircle4.getCenter().getImz()), Circles.zero);
		
		testCircle5 = new Circles(100.0*testCircle5.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle5.getCenter().getRez(), 
        				200.0-100.0*testCircle5.getCenter().getImz()), Circles.zero);
		
		testCircle6 = new Circles(100.0*testCircle6.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle6.getCenter().getRez(), 
        				200.0-100.0*testCircle6.getCenter().getImz()), Circles.zero);
		
		testCircle7 = new Circles(100.0*testCircle7.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle7.getCenter().getRez(), 
        				200.0-100.0*testCircle7.getCenter().getImz()), Circles.zero);
		
		testCircle8 = new Circles(100.0*testCircle8.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle8.getCenter().getRez(), 
        				200.0-100.0*testCircle8.getCenter().getImz()), Circles.zero);
		
		
		testCircle9 = new Circles(100.0*testCircle9.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle9.getCenter().getRez(), 
        				200.0-100.0*testCircle9.getCenter().getImz()), Circles.zero);
		
		testCircle10 = new Circles(100.0*testCircle10.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle10.getCenter().getRez(), 
        				200.0-100.0*testCircle10.getCenter().getImz()), Circles.zero);
		
		testCircle11 = new Circles(100.0*testCircle11.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle11.getCenter().getRez(), 
        				200.0-100.0*testCircle11.getCenter().getImz()), Circles.zero);
		
		testCircle12 = new Circles(100.0*testCircle12.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle12.getCenter().getRez(), 
        				200.0-100.0*testCircle12.getCenter().getImz()), Circles.zero);
		
		testCircle13 = new Circles(100.0*testCircle13.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle13.getCenter().getRez(), 
        				200.0-100.0*testCircle13.getCenter().getImz()), Circles.zero);
		
		testCircle14 = new Circles(100.0*testCircle14.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle14.getCenter().getRez(), 
        				200.0-100.0*testCircle14.getCenter().getImz()), Circles.zero);
		
		testCircle15 = new Circles(100.0*testCircle15.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle15.getCenter().getRez(), 
        				200.0-100.0*testCircle15.getCenter().getImz()), Circles.zero);
		
		testCircle16 = new Circles(100.0*testCircle16.getRadius(), 
        		new ComplexNum(200.0+100.0*testCircle16.getCenter().getRez(), 
        				200.0-100.0*testCircle16.getCenter().getImz()), Circles.zero);
		
		
		
    }
    
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        


        // 内接圆

        double radius = OriginalCircle.getRadius();
        Point2D.Double center = InscribedCircle.get2DCenter(OriginalCircle);
        g.setColor(Color.BLACK);
        drawCircle(g, center, radius);
        
        radius = Circle1.getRadius();
        center = InscribedCircle.get2DCenter(Circle1);
        g.setColor(Color.BLACK);
        drawCircle(g, center, radius);
        
        radius = Circle2.getRadius();
        center = InscribedCircle.get2DCenter(Circle2);
        g.setColor(Color.BLACK);
        drawCircle(g, center, radius);
        
        radius = Circle3.getRadius();
        center = InscribedCircle.get2DCenter(Circle3);
        g.setColor(Color.BLACK);
        drawCircle(g, center, radius);
        
        radius = inversedCircle1.getRadius();
        center = InscribedCircle.get2DCenter(inversedCircle1);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = inversedCircle2.getRadius();
        center = InscribedCircle.get2DCenter(inversedCircle2);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = inversedCircle3.getRadius();
        center = InscribedCircle.get2DCenter(inversedCircle3);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = inversedCircle4.getRadius();
        center = InscribedCircle.get2DCenter(inversedCircle4);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle1.getRadius();
        center = InscribedCircle.get2DCenter(testCircle1);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle2.getRadius();
        center = InscribedCircle.get2DCenter(testCircle2);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle3.getRadius();
        center = InscribedCircle.get2DCenter(testCircle3);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle4.getRadius();
        center = InscribedCircle.get2DCenter(testCircle4);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle5.getRadius();
        center = InscribedCircle.get2DCenter(testCircle5);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle6.getRadius();
        center = InscribedCircle.get2DCenter(testCircle6);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle7.getRadius();
        center = InscribedCircle.get2DCenter(testCircle7);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle8.getRadius();
        center = InscribedCircle.get2DCenter(testCircle8);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle9.getRadius();
        center = InscribedCircle.get2DCenter(testCircle9);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle10.getRadius();
        center = InscribedCircle.get2DCenter(testCircle10);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle11.getRadius();
        center = InscribedCircle.get2DCenter(testCircle11);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle12.getRadius();
        center = InscribedCircle.get2DCenter(testCircle12);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle13.getRadius();
        center = InscribedCircle.get2DCenter(testCircle13);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle14.getRadius();
        center = InscribedCircle.get2DCenter(testCircle14);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle15.getRadius();
        center = InscribedCircle.get2DCenter(testCircle15);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        
        radius = testCircle16.getRadius();
        center = InscribedCircle.get2DCenter(testCircle16);
        g.setColor(Color.gray);
        drawCircle(g, center, radius);
        

    }
    
    protected void drawCircle(Graphics g, Point2D.Double center, double radius) {

        g.drawOval((int) (center.x - radius), (int) (center.y - radius), (int) (2 * radius),

            (int) (2 * radius));

    }


    


    private static void createGUIAndShow() {

        JFrame frame = new JFrame("Apollonian Circle Packings");


        JPanel contentPane = new CirclesTest();

        frame.setContentPane(contentPane);


        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();

        int w = 500;

        int h = 500;

        int x = (ss.width - w) / 2;

        int y = (ss.height - h) / 2;

        x = x > 0 ? x : 0;

        y = y > 0 ? y : 0;

        frame.setBounds(x, y, w, h);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override

            public void run() {

                createGUIAndShow();

            }

        });

    }


}
