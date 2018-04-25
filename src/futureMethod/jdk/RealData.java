package futureMethod.jdk;

import java.util.concurrent.Callable;

public class RealData<T> implements Callable<T> {
	
	private ImplementMethod<T> iMethod;
	
	public RealData(ImplementMethod<T> iMethod) {
		this.iMethod = iMethod;
	}
	
	@Override
	public T call() throws Exception {
		return iMethod.implementation();
	}

}
