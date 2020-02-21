import java.awt.Color;

import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.Graphics2D;

import java.awt.RenderingHints;

import java.awt.Toolkit;

import java.awt.geom.Point2D;


import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.SwingUtilities;


public class TriangleDrawer extends JPanel {

    private static final long serialVersionUID = 1L;

    private InscribedCircle triangle;


    public TriangleDrawer() {

        triangle = new InscribedCircle(new Point2D.Double(100, 100), new Point2D.Double(207, 130),

            new Point2D.Double(220, 200));

    }


    @Override

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        // 绘制三角形

        drawLine(g, triangle.getP1(), triangle.getP2());

        drawLine(g, triangle.getP2(), triangle.getP3());

        drawLine(g, triangle.getP3(), triangle.getP1());


        // 内接圆

        double radius = triangle.innerRadius();

        Point2D.Double center = triangle.innerCenter();

        g.setColor(Color.BLUE);

        drawCircle(g, center, radius);


        // 外接圆

        radius = triangle.outerRadius();

        center = triangle.outerCenter();

        g.setColor(Color.RED);

        drawCircle(g, center, radius);

    }


    protected void drawLine(Graphics g, Point2D.Double startPoint, Point2D.Double endPoint) {

        g.drawLine((int) startPoint.x, (int) startPoint.y, (int) endPoint.x, (int) endPoint.y);

    }


    protected void drawCircle(Graphics g, Point2D.Double center, double radius) {

        g.drawOval((int) (center.x - radius), (int) (center.y - radius), (int) (2 * radius),

            (int) (2 * radius));

    }


    private static void createGUIAndShow() {

        JFrame frame = new JFrame("三角形");


        JPanel contentPane = new TriangleDrawer();

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

