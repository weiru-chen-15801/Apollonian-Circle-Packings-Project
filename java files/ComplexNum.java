

public class ComplexNum {
	
	private double Rez;
	
	private double Imz;
	
	
	
	public double getRez() {
		return Rez;
	}
	
	public double getImz() {
		return Imz;
	}
	
	public void setRez(double rez) {
		Rez = rez;
	}
	
	public void setImz(double imz) {
		Imz = imz;
	}
	
	public ComplexNum() {
		
	}
	
	public ComplexNum(double rez, double imz) {
		super();
		this.Rez = rez;
		this.Imz = imz;
	}
	
	public static void display(ComplexNum a){
		StringBuffer sb = new StringBuffer();
		sb.append(a.getRez());
		if(a.getImz()>0){
			sb.append("+"+a.getImz()+"i");
		}else if(a.getImz()<0){
			sb.append(a.getImz()+"i");
		}
		System.out.println(sb.toString());
	}

	
	public static ComplexNum plus(ComplexNum a,ComplexNum b){
		ComplexNum temp = new ComplexNum();
		temp.setRez(a.getRez()+b.getRez());
		temp.setImz(a.getImz()+b.getImz());
		
		return temp;
	}
	
	public static ComplexNum minus(ComplexNum a,ComplexNum b){
		ComplexNum temp = new ComplexNum();
		temp.setRez(a.getRez()-b.getRez());
		temp.setImz(a.getImz()-b.getImz());
		
		return temp;
	}
	
	public static ComplexNum times(ComplexNum a, ComplexNum b) {
		ComplexNum temp = new ComplexNum();
		temp.setRez(a.getRez()*b.getRez()-a.getImz()*b.getImz());
		temp.setImz(a.getRez()*b.getImz()+a.getImz()*b.getRez());
		
		return temp;
	}
	
	public static ComplexNum divides(ComplexNum a, ComplexNum b) {
		 ComplexNum temp = new ComplexNum();
		 double m = a.getRez();
		 double n = a.getImz();
		 double x = b.getRez();
		 double y = b.getImz();
		 double real = (m*x + n*y) / (double) (x*x + y*y);
		 double imaginary = (n*x - m*y) / (double) (x*x + y*y);
		 temp.setRez(real);
		 temp.setImz(imaginary);
		 return temp;
	}
	
	public static ComplexNum squareRoot(ComplexNum s) {
		ComplexNum temp = new ComplexNum();
		double a = s.getRez();
		double b = s.getImz();
		double x = Math.sqrt(0.5*(a+Math.sqrt(a*a+b*b)));
		double y = b / (double) (2*x);
		temp.setRez(x);
		temp.setImz(y);
		return temp;
	}
	
	public static double absoluteValue(ComplexNum s) {
		double a = s.getRez();
		double b = s.getImz();
		double value = Math.sqrt(a*a+b*b);
		return value;
	}
	
	public static ComplexNum realTimes(double realNumber, ComplexNum s) {
		double a = s.getRez();
		double b = s.getImz();
		ComplexNum newNum = new ComplexNum();
		newNum.setRez(realNumber*a);
		newNum.setImz(realNumber*b);
		return newNum;
	}
	
	public static ComplexNum realDivides(double realNumber, ComplexNum s) {
		double a = s.getRez();
		double b = s.getImz();
		ComplexNum newNum = new ComplexNum();
		newNum.setRez(a / (double) (realNumber));
		newNum.setImz(b / (double) (realNumber));
		return newNum;
	}
}
