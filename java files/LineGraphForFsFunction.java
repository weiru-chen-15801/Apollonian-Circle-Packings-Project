import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineGraphForFsFunction extends JFrame {
	
	private static final long serialVersionUID = 1L;

	   public LineGraphForFsFunction(String applicationTitle, String chartTitle) {
	        super(applicationTitle);

	        // based on the dataset we create the chart
	        JFreeChart pieChart = ChartFactory.createXYLineChart(chartTitle, "M", "Prob", createDataset(),PlotOrientation.VERTICAL, true, true, false);

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
		   
	     
	      final XYSeries curve = new XYSeries("pair correlation function (s = 100)");
	      
	      for (int i = 1; i <= 101; i++) {
	    	  temp = i;
	    	  prob = FsFunction.getProb(temp);
	    	  curve.add(temp, prob);
	      }
	      
	      for (int i = 101; i <= 501; i = i+10) {
	    	  temp = i;
	    	  prob = FsFunction.getProb(temp);
	    	  curve.add(temp, prob);
	      }
	      
	      for (int i = 501; i <= 2001; i = i+50) {
	    	  temp = i;
	    	  prob = FsFunction.getProb(temp);
	    	  curve.add(temp, prob);
	      }
	      
	      
	     
	      final XYSeriesCollection dataset = new XYSeriesCollection();
	      dataset.addSeries(curve);
	     
	      return dataset;
	     
	  }

	   public static void main(String[] args) {
	      LineGraphForFsFunction chart = new LineGraphForFsFunction("F(s) function analysis", "F(s) functions with growing M");
	      chart.pack();
	      chart.setVisible(true);
	   }

}
