package futureMethod.jdk;

/**
 * 
 * @ClassName: ImplementMethod 
 * @Description:  具体执行的方法，T为返回的结果类型
 * @author 邓安
 * @date 2018年4月9日 下午5:38:55 
 * 
 * @param <T>
 */
public interface ImplementMethod<T> {
	
	public T implementation();
	
}
