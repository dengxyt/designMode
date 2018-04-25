package futureMethod.my;

public class FutureData<T> implements Data<T> {
	
	protected RealData<T> realData = null;
	protected boolean isReady = false;
	
	public synchronized void setRealData(RealData<T> realData) {
		if (isReady) {
			return;
		}
		this.realData = realData;
		isReady = true;
		notifyAll();
	}
	
	@Override
	public synchronized T getResult() {
		while (!isReady) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		return (T) realData.result;
	}

}
