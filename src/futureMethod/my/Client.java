package futureMethod.my;

public class Client<T> {
	
	public Data<T> request(final ImplementMethod<T> iMethod) {
		final FutureData<T> future = new FutureData<T>();
		new Thread() {
			@Override
			public void run() {
				RealData<T> realData = new RealData<T>(iMethod);
				future.setRealData(realData);
			}
		}.start();
		return future;
	}

}
