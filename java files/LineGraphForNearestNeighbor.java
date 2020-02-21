import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineGraphForNearestNeighbor extends JFrame {
	private static final long serialVersionUID = 1L;

	   public LineGraphForNearestNeighbor(String applicationTitle, String chartTitle) {
	        super(applicationTitle);

	        // based on the dataset we create the chart
	        JFreeChart pieChart = ChartFactory.createXYLineChart(chartTitle, "S", "Prob", createDataset(),PlotOrientation.VERTICAL, true, true, false);

	        // Adding chart into a chart panel
	        ChartPanel chartPanel = new ChartPanel(pieChart);
	      
	        // settind default size
	        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 540));
	      
	        // add to contentPane
	        setContentPane(chartPanel);
	    }
	  
	   private XYDataset createDataset() {
		   int temp = 0;
		   double prob = 0;
		   
		   
		   final XYSeries curve1 = new XYSeries("gap distribution function (M = 500)");
		     
		      for (int i = 1; i <= 5; i=i+1) {
		    	  temp = i;
		    	  prob = NearestNeighborSpacing.getProb(temp, 500);
		    	  curve1.add(temp, prob);
		      }
		      
		      for (int i = 6; i <= 50; i=i+3) {
		    	  temp = i;
		    	  prob = NearestNeighborSpacing.getProb(temp, 500);
		    	  curve1.add(temp, prob);
		      }
        
final XYSeries curve2 = new XYSeries("pair correlation function (M = 1000)");

		      for (int i = 1; i <= 5; i=i+1) {
		    	  temp = i;
		    	  prob = NearestNeighborSpacing.getProb(temp, 1000);
		    	  curve2.add(temp, prob);
		      }
		      
		      for (int i = 6; i <= 50; i=i+3) {
		    	  temp = i;
		    	  prob = NearestNeighborSpacing.getProb(temp, 1000);
		    	  curve2.add(temp, prob);
		      }
		      
final XYSeries curve3 = new XYSeries("pair correlation function (M = 2000)");

		      for (int i = 1; i <= 5; i=i+1) {
		    	  temp = i;
		    	  prob = NearestNeighborSpacing.getProb(temp, 2000);
		    	  curve3.add(temp, prob);
		      }
		      
		      for (int i = 6; i <= 50; i=i+3) {
		    	  temp = i;
		    	  prob = NearestNeighborSpacing.getProb(temp, 2000);
		    	  curve3.add(temp, prob);
		      }
		      

		      
        
		      
	      
	      
	     
	      final XYSeriesCollection dataset = new XYSeriesCollection();
	      
	      dataset.addSeries(curve1);
	      dataset.addSeries(curve2);
	      dataset.addSeries(curve3);
	     
	     
	      
	      
	     
	     
	      return dataset;
	     
	  }

	   public static void main(String[] args) {
		   LineGraphForNearestNeighbor chart = new LineGraphForNearestNeighbor("F(s) function analysis", "F(s) functions with growing S");
		      chart.pack();
		      chart.setVisible(true);
		   } 
}
