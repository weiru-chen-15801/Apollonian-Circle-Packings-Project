import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineGraphForDerivative extends JFrame{
	
	private static final long serialVersionUID = 1L;

	   public LineGraphForDerivative(String applicationTitle, String chartTitle) {
	        super(applicationTitle);

	        // based on the dataset we create the chart
	        JFreeChart pieChart = ChartFactory.createXYLineChart(chartTitle, "S", "Derivative", createDataset(),PlotOrientation.VERTICAL, true, true, false);

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
		   double derivative = 0;
		   
		   final XYSeries curve1 = new XYSeries("pair correlation function (M = 325)");
		      
		   for (double i = 0; i <= 2; i=i+0.5) {
		    	  temp = i;
		    	  derivative = (FsFunctionForDerivative.getProb(temp+0.5, 325) - 
		    			  FsFunctionForDerivative.getProb(temp, 325))/(double) (0.5);
		    	  
		    	  curve1.add(temp, derivative);
		   }
		   
		   for (double i = 2; i <= 50; i=i+0.1) {
		    	  temp = i;
		    	  derivative = (FsFunctionForDerivative.getProb(temp+0.1, 325) - 
		    			  FsFunctionForDerivative.getProb(temp, 325))/(double) (0.1);
		    	  
		    	  curve1.add(temp, derivative);
		   }
		   
		   
		      
		     
		      
     





		      
		      
		      
     
     
     
		     
	      
	      
	     
	      
    

	    
	     
	      final XYSeriesCollection dataset = new XYSeriesCollection();
	      
	      dataset.addSeries(curve1);
	      
	      
	      
	      
	     
	     
	      return dataset;
	   }
	   
	   public static void main(String[] args) {
		      LineGraphForDerivative chart = new LineGraphForDerivative("F(s) function analysis for derivative", "F(s) functions with growing S");
		      chart.pack();
		      chart.setVisible(true);
		   }
	
}
