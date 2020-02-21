import java.awt.geom.Point2D;

public class Circles {
	
	private double radius;
	
	private ComplexNum center;
	
	private ComplexNum tangency;
	
	public double getRadius () {
		return this.radius;
	}
	
	public ComplexNum getCenter() {
		return this.center;
	}
	
	public ComplexNum getTangency() {
		return this.tangency;
	}
	
	public void setRadius (double r) {
		this.radius = r;
	}
	
	public void setCenter(ComplexNum c) {
		this.center = c;
	}
	
	public void setTangency(ComplexNum t) {
		this.tangency = t;
	}
	
	
    public static final ComplexNum setOneComplex(){
	    ComplexNum one = new ComplexNum();
    	one.setRez(1.0);
	    one.setImz(0.0);
	    return one;
    }
    
    public static final ComplexNum setZeroComplex() {
    	ComplexNum zero = new ComplexNum();
    	zero.setRez(0.0);
    	zero.setImz(0.0);
    	return zero;
    }
    
    public static final ComplexNum one = setOneComplex();
    
    public static final ComplexNum zero = setZeroComplex();
    
    public static ComplexNum getConjugate(ComplexNum a) {
    	ComplexNum temp = new ComplexNum();
    	temp.setRez(a.getRez());
    	temp.setImz(-a.getImz());
    	return temp;
    }
	
	public static ComplexNum getMatrixA(Circles a, Circles b) {
		ComplexNum c = ComplexNum.minus(b.tangency, one);
		ComplexNum d = ComplexNum.minus(a.tangency, one);
		ComplexNum e = ComplexNum.minus(b.tangency, a.tangency);
		ComplexNum f = ComplexNum.times(c, d);
		ComplexNum g = ComplexNum.divides(e, f);
		ComplexNum h = ComplexNum.squareRoot(g);
		return h;
	}
	
	public static ComplexNum getMatrixB(Circles a, Circles b) {
		ComplexNum c = a.tangency;
		ComplexNum d = ComplexNum.minus(b.tangency, one);
		ComplexNum e = ComplexNum.minus(a.tangency, one);
	    ComplexNum f = ComplexNum.minus(b.tangency, a.tangency);
	    ComplexNum g = ComplexNum.times(e, f);
	    ComplexNum h = ComplexNum.divides(d, g);
	    ComplexNum i = ComplexNum.squareRoot(h);
	    ComplexNum j = ComplexNum.times(c, i);
	    ComplexNum k = ComplexNum.minus(zero, j);
	    if (a.tangency.getRez()>0 && a.tangency.getRez()<1 && a.tangency.getImz()>0 && a.tangency.getImz() < 1)
	    	return k;
	    else {
	    	return j;
	    }
	}
	
	public static ComplexNum getMatrixC(Circles a, Circles b) {
		ComplexNum c = ComplexNum.minus(b.tangency, one);
		ComplexNum d = ComplexNum.minus(a.tangency, one);
		ComplexNum e = ComplexNum.minus(b.tangency, a.tangency);
		ComplexNum f = ComplexNum.times(c, d);
		ComplexNum g = ComplexNum.divides(e, f);
		ComplexNum h = ComplexNum.squareRoot(g);
		return h;
	}
	
	public static ComplexNum getMatrixD(Circles a, Circles b) {
		ComplexNum d = ComplexNum.minus(b.tangency, one);
		ComplexNum e = ComplexNum.minus(a.tangency, one);
	    ComplexNum f = ComplexNum.minus(b.tangency, a.tangency);
	    ComplexNum g = ComplexNum.times(e, f);
	    ComplexNum h = ComplexNum.divides(d, g);
	    ComplexNum i = ComplexNum.squareRoot(h);
	    ComplexNum j = ComplexNum.minus(zero, i);
	    if (a.tangency.getRez()>0 && a.tangency.getRez()<1 && a.tangency.getImz()>0 && a.tangency.getImz() < 1)
	    	return j;
	    else
	    	return i;
	}
	
	public Circles() {
		
	}
	
	public Circles(double r, ComplexNum c, ComplexNum t) {
		this.radius = r;
		this.center = c;
		this.tangency = t;
	}
	
	public Circles(Circles original) {
		
		this.radius = original.radius;
		this.center = original.center;
		this.tangency = original.tangency;
	}
	
	public static void mobiusCircleTransformation0(Circles x, Circles y, double yValue) {
		//Circles x and y are the first two circles whose tangencies are theta1 and theta2
		//if the transformation is from line to circle, intersect at infinity
		Circles transformedCircle = new Circles();
		transformedCircle.radius = mobiousRadiusTransformation0(x, y, yValue);
		transformedCircle.center = mobiousCenterTransformation0(x, y, yValue);
	}
	
	public static double mobiousRadiusTransformation0(Circles x, Circles y, double yValue) {
		//if the transformation is from line to circle, intersect at infinity
		ComplexNum a = getMatrixA(x, y);
		ComplexNum b = getMatrixB(x, y);
		ComplexNum c = getMatrixC(x, y);
		ComplexNum d = getMatrixD(x, y);
		ComplexNum cConjugate = getConjugate(c);
		ComplexNum dConjugate = getConjugate(d);
		ComplexNum temp1 = new ComplexNum();
		temp1.setRez(yValue);
		ComplexNum temp2 = new ComplexNum();
		temp2.setRez(0.0);
		temp2.setImz(1.0);
		ComplexNum calculate1 = ComplexNum.times(ComplexNum.times(c, c), temp2);
		ComplexNum calculate2 = ComplexNum.realTimes(yValue, calculate1);
		ComplexNum calculate3 = ComplexNum.plus(calculate2, ComplexNum.divides(c, ComplexNum.realTimes(2, a)));
		double mod1 = ComplexNum.absoluteValue(calculate3);
		double newRadius = 1 / (double) (2 * mod1);
		System.out.println("Radius for original circle is " + newRadius);
		return newRadius;
	}
	
	public static ComplexNum mobiousCenterTransformation0(Circles x, Circles y, double yValue) {
		//if the transformation is from line to circle, intersect at infinity
		ComplexNum z = new ComplexNum();
		ComplexNum a = getMatrixA(x, y);
		ComplexNum b = getMatrixB(x, y);
		ComplexNum c = getMatrixC(x, y);
		ComplexNum d = getMatrixD(x, y);
		ComplexNum cConjugate = getConjugate(c);
		ComplexNum dConjugate = getConjugate(d);
		ComplexNum temp1 = new ComplexNum();
		temp1.setRez(yValue);
		temp1.setImz(0);
		ComplexNum temp2 = new ComplexNum();
		temp2.setRez(0.0);
		temp2.setImz(1.0);
		ComplexNum calculate1 = ComplexNum.times(c, temp2);
		ComplexNum calculate2 = ComplexNum.realTimes(yValue, calculate1);
		ComplexNum calculate0 = ComplexNum.divides(one, ComplexNum.realTimes(2, a));
		ComplexNum calculate00 = ComplexNum.plus(calculate0, calculate2);
		ComplexNum calculate4 = ComplexNum.times(calculate00, c);
		ComplexNum calculate5 = ComplexNum.realTimes(2.0, calculate4);
		ComplexNum calculate7 = ComplexNum.divides(one, calculate5);
		ComplexNum calculate6 = ComplexNum.divides(a, c);
		z = ComplexNum.minus(calculate6, calculate7);
		System.out.println("The center for original circle is " + z.getRez() + "+" + z.getImz() + "i");
		return z;
	}
	
	public static void mobiusCircleTransformation1(Circles x, Circles y, double yValue) {
		//Circles x and y are the first two circles whose tangencies are theta1 and theta2
		//if the transformation is from line to circle, intersect at infinity
		Circles transformedCircle = new Circles();
		transformedCircle.radius = mobiousRadiusTransformation1(x, y, yValue);
		transformedCircle.center = mobiousCenterTransformation1(x, y, yValue);
	}
	
	public static double mobiousRadiusTransformation1(Circles x, Circles y, double yValue) {
		//if the transformation is from line to circle, intersect at infinity
		ComplexNum a = getMatrixA(x, y);
		ComplexNum b = getMatrixB(x, y);
		ComplexNum c = getMatrixC(x, y);
		ComplexNum d = getMatrixD(x, y);
		ComplexNum cConjugate = getConjugate(c);
		ComplexNum dConjugate = getConjugate(d);
		ComplexNum temp1 = new ComplexNum();
		temp1.setRez(yValue);
		ComplexNum temp2 = new ComplexNum();
		temp2.setRez(0.0);
		temp2.setImz(1.0);
		ComplexNum calculate1 = ComplexNum.times(ComplexNum.times(c, c), temp2);
		ComplexNum calculate2 = ComplexNum.realTimes(yValue, calculate1);
		ComplexNum calculate3 = ComplexNum.plus(calculate2, ComplexNum.divides(c, ComplexNum.realTimes(2, a)));
		double mod1 = ComplexNum.absoluteValue(calculate3);
		double newRadius = 1 / (double) (2 * mod1);
		System.out.println("Radius is " + newRadius);
		return newRadius;
	}
	
	public static ComplexNum mobiousCenterTransformation1(Circles x, Circles y, double yValue) {
		//if the transformation is from line to circle, intersect at infinity
		ComplexNum z = new ComplexNum();
		ComplexNum a = getMatrixA(x, y);
		ComplexNum b = getMatrixB(x, y);
		ComplexNum c = getMatrixC(x, y);
		ComplexNum d = getMatrixD(x, y);
		ComplexNum cConjugate = getConjugate(c);
		ComplexNum dConjugate = getConjugate(d);
		ComplexNum temp1 = new ComplexNum();
		temp1.setRez(yValue);
		temp1.setImz(0);
		ComplexNum temp2 = new ComplexNum();
		temp2.setRez(0.0);
		temp2.setImz(1.0);
		ComplexNum calculate1 = ComplexNum.times(c, temp2);
		ComplexNum calculate2 = ComplexNum.realTimes(yValue, calculate1);
		ComplexNum calculate0 = ComplexNum.divides(one, ComplexNum.realTimes(2, a));
		ComplexNum calculate00 = ComplexNum.plus(calculate0, calculate2);
		ComplexNum calculate4 = ComplexNum.times(calculate00, c);
		ComplexNum calculate5 = ComplexNum.realTimes(2.0, calculate4);
		ComplexNum calculate7 = ComplexNum.divides(one, calculate5);
		ComplexNum calculate6 = ComplexNum.divides(a, c);
		z = ComplexNum.minus(calculate6, calculate7);
		System.out.println("The center is " + z.getRez() + "+" + z.getImz() + "i");
		return z;
	}
	
	public static void mobiusCircleTransformation2(Circles x, Circles y, ComplexNum tCenter, double tRadius) {
		//if the transformation is from circle to circle, intersect at 0
		Circles transformedCircle = new Circles();
		transformedCircle.radius = mobiousRadiusTransformation2(x, y, tCenter, tRadius);
		transformedCircle.center = mobiousCenterTransformation2(x, y, tCenter, tRadius);
	}
	
    public static double mobiousRadiusTransformation2(Circles x, Circles y, ComplexNum tCenter, double tRadius) {
    	//if the transformation is from circle to circle, intersect at 0
    	ComplexNum a = getMatrixA(x, y);
		ComplexNum b = getMatrixB(x, y);
		ComplexNum c = getMatrixC(x, y);
		ComplexNum d = getMatrixD(x, y);
		if (c != zero) {
			double mod1 = ComplexNum.absoluteValue(ComplexNum.plus(d, ComplexNum.times(c, tCenter)));
			double mod2 = ComplexNum.absoluteValue(c);
			double mod3 = mod1*mod1-mod2*mod2*Math.pow(tRadius, 2);
			if (mod3 < 0)
				mod3 = -mod3;
			double newRadius1 = tRadius / (double) (mod3);
			System.out.println("Radius is " + newRadius1);
			return newRadius1;
		}
		else {
			double mod4 = ComplexNum.absoluteValue(d);
			double newRadius2 = tRadius / (double) (mod4*mod4);
			System.out.println("Radius is " + newRadius2);
			return newRadius2;
		}
	}
	
	public static ComplexNum mobiousCenterTransformation2(Circles x, Circles y, ComplexNum tCenter, double tRadius) {
		//if the transformation is from circle to circle, intersect at 0
		ComplexNum z = new ComplexNum();
		ComplexNum a = getMatrixA(x, y);
		ComplexNum b = getMatrixB(x, y);
		ComplexNum c = getMatrixC(x, y);
		ComplexNum d = getMatrixD(x, y);
		if (c != zero) {
			double mod1 = ComplexNum.absoluteValue(ComplexNum.plus(d, ComplexNum.times(c, tCenter)));
			double mod2 = ComplexNum.absoluteValue(c);
			double mod3 = mod1*mod1-mod2*mod2*Math.pow(tRadius, 2);
			double mod4 = mod1*mod1 / (double) (mod3);
			ComplexNum calculate1 = ComplexNum.plus(d, ComplexNum.times(c, tCenter));
			ComplexNum calculate2 = ComplexNum.divides(a, c);
			ComplexNum calculate3 = ComplexNum.divides(one, ComplexNum.times(c, calculate1));
			ComplexNum calculate4 = ComplexNum.realTimes(mod4, calculate3);
			z = ComplexNum.minus(calculate2, calculate4);
			System.out.println("The center is " + z.getRez() + "+" + z.getImz() + "i");
			return z;
		}
		else {
			ComplexNum calculate5 = ComplexNum.plus(b, ComplexNum.times(a, tCenter));
			z = ComplexNum.divides(calculate5, d);
			System.out.println("The center is " + z.getRez() + "+" + z.getImz() + "i");
			return z;
		}
	}
	
	public static void mobiusCircleTransformation3(Circles x, Circles y, ComplexNum tCenter, double tRadius) {
		//if the transformation is from circle to circle, intersect at 1
		Circles transformedCircle = new Circles();
		transformedCircle.radius = mobiousRadiusTransformation3(x, y, tCenter, tRadius);
		transformedCircle.center = mobiousCenterTransformation3(x, y, tCenter, tRadius);
	}
	
    public static double mobiousRadiusTransformation3(Circles x, Circles y, ComplexNum tCenter, double tRadius) {
    	//if the transformation is from circle to circle, intersect at 1
    	ComplexNum a = getMatrixA(x, y);
		ComplexNum b = getMatrixB(x, y);
		ComplexNum c = getMatrixC(x, y);
		ComplexNum d = getMatrixD(x, y);
		if (c != zero) {
			double mod1 = ComplexNum.absoluteValue(ComplexNum.plus(d, ComplexNum.times(c, tCenter)));
			double mod2 = ComplexNum.absoluteValue(c);
			double mod3 = mod1*mod1-mod2*mod2*Math.pow(tRadius, 2);
			if (mod3 < 0)
				mod3 = -mod3;
			double newRadius1 = tRadius / (double) (mod3);
			System.out.println("Radius is " + newRadius1);
			return newRadius1;
		}
		else {
			double mod4 = ComplexNum.absoluteValue(d);
			double newRadius2 = tRadius / (double) (mod4*mod4);
			System.out.println("Radius is " + newRadius2);
			return newRadius2;
		}
	}
	
	public static ComplexNum mobiousCenterTransformation3(Circles x, Circles y, ComplexNum tCenter, double tRadius) {
		//if the transformation is from circle to circle, intersect at 1
		ComplexNum z = new ComplexNum();
		ComplexNum a = getMatrixA(x, y);
		ComplexNum b = getMatrixB(x, y);
		ComplexNum c = getMatrixC(x, y);
		ComplexNum d = getMatrixD(x, y);
		if (c != zero) {
			double mod1 = ComplexNum.absoluteValue(ComplexNum.plus(d, ComplexNum.times(c, tCenter)));
			double mod2 = ComplexNum.absoluteValue(c);
			double mod3 = mod1*mod1-mod2*mod2*Math.pow(tRadius, 2);
			double mod4 = mod1*mod1 / (double) (mod3);
			ComplexNum calculate1 = ComplexNum.plus(d, ComplexNum.times(c, tCenter));
			ComplexNum calculate2 = ComplexNum.divides(a, c);
			ComplexNum calculate3 = ComplexNum.divides(one, ComplexNum.times(c, calculate1));
			ComplexNum calculate4 = ComplexNum.realTimes(mod4, calculate3);
			z = ComplexNum.minus(calculate2, calculate4);
			System.out.println("The center is " + z.getRez() + "+" + z.getImz() + "i");
			return z;
		}
		else {
			ComplexNum calculate5 = ComplexNum.plus(b, ComplexNum.times(a, tCenter));
			z = ComplexNum.divides(calculate5, d);
			System.out.println("The center is " + z.getRez() + "+" + z.getImz() + "i");
			return z;
		}
		
		
	}
	
	
}

