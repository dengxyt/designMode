package futureMethod.my;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		final String string = "外面的字段";
		Data<List<String>> data = new Client<List<String>>().request(new ImplementMethod<List<String>>() {
			
			@Override
			public List<String> implementation() {
				List<String> tests = new ArrayList<>();
				tests.add("测试字段");
				tests.add(string);
				return tests;
			}
		});
		System.out.println("请求完毕");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println("数据 = " + data.getResult());
	}
	
}
