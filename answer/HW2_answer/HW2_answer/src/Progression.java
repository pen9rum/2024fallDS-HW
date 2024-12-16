public abstract class Progression<T> {
	protected T first;
	protected T curr;
	
	public Progression(T first) {
		this.first = first;
		this.curr = first;
	}
	
	//reset and return first value
	public T firstValue() {
		curr = first;
		return first;
	}
	
	public abstract T nextValue() throws Exception;
    
    public void printProgression(int n){
		String result = "";
		result += firstValue();
		for(int i = 0; i < n; i++) {
			try {
				result += " " + nextValue();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				break;
			}
		}
		
		System.out.println(result);
    }
}