package futureMethod.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @ClassName: FutureUtil 
 * @Description:  异步调用工具类
 * @author 邓安
 * @date 2018年4月9日 下午5:35:22 
 *
 */
public class FutureUtil {
	
	private static final ThreadLocal<ExecutorService> excutor = new ThreadLocal<ExecutorService>();
	
	private static ExecutorService getExcutor() {
		if (excutor.get() == null) {
			excutor.set(Executors.newCachedThreadPool());
		} 
		return excutor.get();
	}
	
	private static void closeExcutor() {
		if (excutor.get() != null) {
			excutor.get().shutdown();
			excutor.remove();
		}
	}
	
	/**
	 * 
	 * @description: 执行具体的操作，并返回Future，需要真实数据时使用future.get()获取
	 * @return Future<T>
	 * @author 邓安
	 * @createTime 2018年4月9日 下午5:36:00
	 */
	public static <T> Future<T> submit(ImplementMethod<T> iMethod) throws InterruptedException, ExecutionException {
		ExecutorService executor = getExcutor();
		if (executor.isShutdown()) {
			excutor.remove();
			executor = getExcutor();
		}
		try {
			return executor.submit(new RealData<T>(iMethod));
		} finally {
			closeExcutor();
			executor.shutdown();
		}
	}

}
