import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineGraphForAnyPart extends JFrame{
	private static final long serialVersionUID = 1L;

	   public LineGraphForAnyPart(String applicationTitle, String chartTitle) {
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
		   double temp = 0;
		   double prob = 0;
		   
		   final XYSeries curve1 = new XYSeries("pair correlation function (T = 1000)");
		      
		   for (double i = 0; i <= 5; i=i+0.25) {
		    	  temp = i;
		    	  prob = FsFunctionForAnyPart.getProb(temp, 1000);
		    	  curve1.add(temp, prob);
		   }
		      
		     
  
final XYSeries curve2 = new XYSeries("pair correlation function for part regions (T = 1000)");
		      
		      for (double i = 0; i <= 5; i=i+0.25) {
		    	  temp = i;
		    	  prob = FsFunctionForAnyPart.getProb(temp, 1000);
		    	  curve2.add(temp, prob);
		      }
		      
		      

	      
	     
	      final XYSeriesCollection dataset = new XYSeriesCollection();
	      
	      dataset.addSeries(curve1);
	      dataset.addSeries(curve2);
	      
	      
	     
	     
	      return dataset;
	   }
	   
	   public static void main(String[] args) {
		      LineGraphForAnyPart chart = new LineGraphForAnyPart("F(s) function analysis for part regions", "F(s) functions with growing S");
		      chart.pack();
		      chart.setVisible(true);
		   }
}
