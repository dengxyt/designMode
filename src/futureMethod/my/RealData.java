package futureMethod.my;

public class RealData<T> implements Data<T> {
	
	protected final T result;
	
	public RealData(ImplementMethod<T> iMethod) {
		result = iMethod.implementation();
	}

	@Override
	public T getResult() {
		return result;
	}

}
