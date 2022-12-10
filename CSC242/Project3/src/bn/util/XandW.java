/** This class was created to be used with Likelihood Weighting **/
package bn.util;

public class XandW<A, D> {
	
	private final A X;	//the event (assignemnt) returned by weighted sample
	private final D W;	//the weight (double) returned by weighted sample
	
	public XandW(A newX, D newW) {
		this.X = newX;
		this.W = newW;
	}
	
	public A getX() {
		return this.X;
	}
	
	public D getW() {
		return this.W;
	}

}
