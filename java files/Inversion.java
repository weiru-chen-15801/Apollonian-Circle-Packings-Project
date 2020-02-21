
public class Inversion {
	
	public static ComplexNum centerInversion (Circles original, Circles into) {
		ComplexNum zNew = new ComplexNum();
		ComplexNum z = original.getCenter();
		double r = original.getRadius();
		ComplexNum z0 = into.getCenter();
		double r0 = into.getRadius();
		double mod1 = Math.pow(ComplexNum.absoluteValue(ComplexNum.minus(z, z0)), 2) - r*r;;
		double mod2 = Math.pow(r0, 2) / (double) (mod1);
		ComplexNum calculate1 = ComplexNum.minus(z, z0);
		ComplexNum calculate2 = ComplexNum.realTimes(mod2, calculate1);
		//plus or minus or no z0
		zNew = ComplexNum.plus(z0, calculate2);
		
		return zNew;
	}
	
	public static double radiusInversion(Circles original, Circles into) {
		double rNew;
		ComplexNum z = original.getCenter();
		ComplexNum z0 = into.getCenter();
		double r = original.getRadius();
		double r0 = into.getRadius();
		double mod0 = ComplexNum.absoluteValue(ComplexNum.minus(z, z0));
		double mod1 = Math.pow(ComplexNum.absoluteValue(ComplexNum.minus(z, z0)), 2) - r*r;
		//r or |z-z0|
		double mod2 = r0*r0*r / (double) (mod1);
		if (mod2 < 0)
			mod2 = -mod2;
		rNew = mod2;
		
		
		return rNew;
	}
	
	public static Circles circleInversion(Circles original, Circles into, double minRadius) {
		Circles inversedCircle = new Circles();
		inversedCircle.setCenter(centerInversion(original, into));
		inversedCircle.setRadius(radiusInversion(original, into));
		if (inversedCircle.getRadius() >= minRadius) {
			System.out.println("c: " + inversedCircle.getCenter().getRez() + 
					" + " + inversedCircle.getCenter().getImz() + "i; r: " +
					inversedCircle.getRadius());
			
		}
		return inversedCircle;
	}
	

	
}
