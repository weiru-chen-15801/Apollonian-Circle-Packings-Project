import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineGraphForElectrostaticEnergy extends JFrame {
	private static final long serialVersionUID = 1L;
	public LineGraphForElectrostaticEnergy(String applicationTitle, String chartTitle) {
        super(applicationTitle);

        // based on the dataset we create the chart
        JFreeChart pieChart = ChartFactory.createXYLineChart(chartTitle, "M", "Ratio", createDataset(),PlotOrientation.VERTICAL, true, true, false);

        // Adding chart into a chart panel
        ChartPanel chartPanel = new ChartPanel(pieChart);
      
        // settind default size
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 540));
      
        // add to contentPane
        setContentPane(chartPanel);
    }
  
   private XYDataset createDataset() {
	   int temp = 0;
	   double ratio = 0.0;
	   
	   
	   final XYSeries curve1 = new XYSeries("electronic static energy function related to M^(2*ro) (M = 4-2000) data1");
	     
	      for (int i = 4; i <= 500; i=i+2) {
	    	  temp = i;
	    	  ratio = ElectrostaticEnergy.getSigma(temp);
	    	  curve1.add(temp, ratio);
	      }
	      
	      for (int i = 500; i <= 1000; i=i+2) {
	    	  temp = i;
	    	  ratio = ElectrostaticEnergy.getSigma(temp);
	    	  curve1.add(temp, ratio);
	      }
	      
	      
	      
	     
	      

	      
    
	      
      
      
     
      final XYSeriesCollection dataset = new XYSeriesCollection();
      
      dataset.addSeries(curve1);
      
     
     
      
      
     
     
      return dataset;
     
  }

   public static void main(String[] args) {
	   LineGraphForElectrostaticEnergy chart = new LineGraphForElectrostaticEnergy("Electrostatic Energy Function", "Function with growing M");
	      chart.pack();
	      chart.setVisible(true);
	   } 
}
