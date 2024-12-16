public class GeomProgression<T extends Number> extends Progression<T>{

	private T base;
	public GeomProgression(T first, T base) {
		super(first);
		this.base = base;
	}
	
	@SuppressWarnings("unchecked")
	private T multiply(T a, T b) {
		if(a instanceof Integer){
		    Integer erasedValue = a.intValue() * b.intValue();
		    return (T)erasedValue;
		} else if (a instanceof Double) {
			Double erasedValue = a.doubleValue() * b.doubleValue();
			return (T)erasedValue;
		} else {
			return null;
		}		
	}
	
	public T nextValue() throws Exception {
		curr = multiply(curr, base);
		
		if (curr instanceof Integer) {
			if ((int) curr < 0) {
				throw new Exception("IntegerOverflow");
			}
		} else if (curr instanceof Double) {
			if ((double) curr < 0) {
				throw new Exception("DoubleOverflow");
			}
		}
		return curr;
	}
}