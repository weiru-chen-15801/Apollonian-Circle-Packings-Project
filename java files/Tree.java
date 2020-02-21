
public class Tree {
	
	private Tree t1;
	private Tree t2;
	private Tree t3;
	private Tree t4;
	private Circles circle;
	private int currentTypeOfInversion;
	private static int typeOfInversion;
	
	public static int k = 0;
	public static Circles[] circlesList1 = new Circles[300000];
	public static Circles[] circlesList2 = new Circles[300000];
	public static Circles[] circlesList3 = new Circles[300000];
	public static Circles[] circlesList4 = new Circles[300000];
	
	public Tree() {
		
	}
	
	public Tree(Circles original, int num, Tree newt1, Tree newt2, Tree newt3, Tree newt4) {
		this.circle = original;
		this.currentTypeOfInversion = num;
		this.t1 = newt1;
		this.t2 = newt2;
		this.t3 = newt3;
		this.t4 = newt4;
		
	}
	
	public Circles getCircle() {
		return this.circle;
	}
	
	public int getCurrentTypeOfInversion() {
		return this.currentTypeOfInversion;
	}
	
	public Tree getInversion1() {
		return this.t1;
	}
	
	public Tree getInversion2() {
		return this.t2;
	}
	
	public Tree getInversion3() {
		return this.t3;
	}
	
	public Tree getInversion4() {
		return this.t4;
	}
	
	public static void childOfTree(Tree original, double minimumRadius, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		int currentNum = original.getCurrentTypeOfInversion();
		typeOfInversion = 1;
		if (typeOfInversion != currentNum) {
			Circles descendant = Inversion.circleInversion(original.getCircle(), inversedCircle1, 
					minimumRadius);
			if (descendant.getRadius() < minimumRadius)
				original.t1 = null;
			else {
				//is the circlesList null here?
				Tree child1 = new Tree(descendant, 
						1, null, null, null, null);
				original.t1 = child1;
				
			}
		}
		else if (typeOfInversion == currentNum)
			original.t1 = null;
		typeOfInversion = 2;
		
		if (typeOfInversion != currentNum) {
			Circles descendant = Inversion.circleInversion(original.getCircle(), inversedCircle2, 
					minimumRadius);
			if (descendant.getRadius() < minimumRadius)
				original.t2 = null;
			else {
				Tree child2 = new Tree(descendant, 
						2, null, null, null, null);
				original.t2 = child2;
				
			}
		}
		else if (typeOfInversion == currentNum)
			original.t2 = null;
		typeOfInversion = 3;
		
		if (typeOfInversion != currentNum) {
			Circles descendant = Inversion.circleInversion(original.getCircle(), inversedCircle3, 
					minimumRadius);
			if (descendant.getRadius() < minimumRadius)
				original.t3 = null;
			else {
			    Tree child3 = new Tree(descendant, 
			    		3, null, null, null, null);
			    original.t3 = child3;
			    
			}
		}
		else if (typeOfInversion == currentNum)
			original.t3 = null;
		typeOfInversion = 4;
		
		if (typeOfInversion != currentNum) {
			Circles descendant = Inversion.circleInversion(original.getCircle(), inversedCircle4, 
					minimumRadius);
			if (descendant.getRadius() < minimumRadius)
				original.t4 = null;
			else {
				Tree child4 = new Tree(descendant, 
						4, null, null, null, null);
				original.t4 = child4;
				
			}
		}
		else if (typeOfInversion == currentNum)
			original.t4 = null;
		
	
		
	}
	
	public static Circles getChildCircle1(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		childOfTree(original, minimum, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		if (original == null)
			return null;
		if ((original != null) && (original.t1 == null))
			return null;
		else
			return original.t1.circle;
	}
	
	public static Circles getChildCircle2(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		childOfTree(original, minimum, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		if (original == null)
			return null;
		if ((original != null) && (original.t2 == null))
			return null;
		else
			return original.t2.circle;
	}
	
	public static Circles getChildCircle3(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		childOfTree(original, minimum, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		if (original == null)
			return null;
		if ((original != null) && (original.t3 == null))
			return null;
		else
			return original.t3.circle;
	}
	
	public static Circles getChildCircle4(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		childOfTree(original, minimum, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		if (original == null)
			return null;
		if ((original != null) && (original.t4 == null))
			return null;
		else
			return original.t4.circle;
	}
	
	public static int numOfCircles(Tree original) {
		if (original == null)
			return 0;
		return 1 + numOfCircles(original.t1) + numOfCircles(original.t2) + 
				numOfCircles(original.t3) + numOfCircles(original.t4);
	}
	
	public static void reproduction(Tree original, double minimumRadius, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		if (original == null)
			return;
		
		
			
		childOfTree(original, minimumRadius, inversedCircle1, inversedCircle2, inversedCircle3, inversedCircle4);
		
		reproduction(original.t1, minimumRadius, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		
		reproduction(original.t2, minimumRadius, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		
		reproduction(original.t3, minimumRadius, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		
		reproduction(original.t4, minimumRadius, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
	}
	
	//put all circles of the tree from original into a list
	public static Circles[] putCirclesList1(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		if (original == null) {
			return null;
		}
		
		
		circlesList1[k] = new Circles(original.getCircle());
		//
		
		k++;
		putCirclesList1(original.t1, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList1(original.t2, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList1(original.t3, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList1(original.t4, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		return circlesList1;
		
	}
	
	
	public static Circles[] putCirclesList2(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		if (original == null) {
			return null;
		}
		
		
		circlesList2[k] = new Circles(original.getCircle());
		//
		
		k++;
		putCirclesList2(original.t1, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList2(original.t2, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList2(original.t3, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList2(original.t4, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		return circlesList2;
		
	}
	
	public static Circles[] putCirclesList3(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		if (original == null) {
			return null;
		}
		
		
		circlesList3[k] = new Circles(original.getCircle());
		//
		
		k++;
		putCirclesList3(original.t1, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList3(original.t2, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList3(original.t3, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList3(original.t4, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		return circlesList3;
		
	}
	
	public static Circles[] putCirclesList4(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		if (original == null) {
			return null;
		}
		
		
		circlesList4[k] = new Circles(original.getCircle());
		//
		System.out.println("The " + k + "th circle ");
		k++;
		putCirclesList4(original.t1, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList4(original.t2, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList4(original.t3, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		putCirclesList4(original.t4, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		return circlesList4;
		
	}
	
	
	public static Circles[] getCirclesList1(Tree original, double minimum, Circles inversedCircle1, Circles inversedCircle2, 
			Circles inversedCircle3, Circles inversedCircle4) {
		putCirclesList1(original, minimum, inversedCircle1, inversedCircle2, 
				inversedCircle3, inversedCircle4);
		return circlesList1;
	}
	
	//useless code
	public Circles[] getCirclesList1() {
		
		Circles[] circlesList1 = this.t1.getCirclesList1();
		Circles[] circlesList2 = this.t2.getCirclesList1();
		Circles[] circlesList3 = this.t3.getCirclesList1();
		Circles[] circlesList4 = this.t4.getCirclesList1();
		
		Circles[] totalList = new Circles[circlesList1.length + circlesList2.length + 
		                                  circlesList3.length + circlesList4.length];
		for (int i = 0; i < circlesList1.length; i++) {
			if (circlesList1[i].equals(null))
				totalList[i] = null;
			totalList[i] = new Circles(circlesList1[i]);
		}
		
		for (int i = circlesList1.length; i < circlesList1.length + circlesList2.length; i++) {
			if (circlesList2[i-circlesList1.length].equals(null))
				totalList[i] = null;
			totalList[i] = new Circles(circlesList2[i-circlesList1.length]);
		}
		
		for (int i = circlesList1.length + circlesList2.length; 
				i < circlesList1.length + circlesList2.length + circlesList3.length; i++) {
			
			if (circlesList3[i-circlesList1.length-circlesList2.length].equals(null))
				totalList[i] = null;
			
			totalList[i] = new Circles(circlesList3[i-circlesList1.length-circlesList2.length]);
		}
		
		for (int i = circlesList1.length + circlesList2.length + circlesList3.length; 
				i < circlesList1.length + circlesList2.length + circlesList3.length
				+ circlesList4.length; i++) {
			
			if (circlesList4[i-circlesList1.length-
                             circlesList2.length-circlesList3.length].equals(null))
				totalList[i] = null;
			
			totalList[i] = new Circles(circlesList4[i-circlesList1.length-
			                                        circlesList2.length-circlesList3.length]);
		}
		
		return totalList;
	}
}
