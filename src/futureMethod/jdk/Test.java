package futureMethod.jdk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 该方法需要花费大概3秒
		Future<List<String>> submit = FutureUtil.submit(new ImplementMethod<List<String>>() {

			@Override
			public List<String> implementation() {
				List<String> result = new ArrayList<String>();
				for (int i = 0; i < 10; i++) {
					try {
						result.add(i + "");
						Thread.sleep(3000);
					} catch (Exception e) {
					}
				}
				return result;
			}
		});
		
		Future<String> submit2 = FutureUtil.submit(new ImplementMethod<String>() {

			@Override
			public String implementation() {
				String result = "";
				for (int i = 10; i < 100; i += 10) {
					try {
						result += i;
						Thread.sleep(5000);
					} catch (Exception e) {
					}
				}
				return result;
			}
		});
		//Thread.sleep(4000);
		for (int i = 10; i < 100; i += 10) {
			try {
				System.out.println(i);
			} catch (Exception e) {
			}
		}
		List<String> list = submit.get();
		for (int i = 100; i < 200; i += 20) {
			try {
				System.out.println(i);
			} catch (Exception e) {
			}
		}
		System.out.println(list);
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println(submit2.get());
		
	}

}
