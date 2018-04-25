package factoryMethod.multiple;


public class Test {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();  
		Sender sender = factory.produceSms(); 
		sender.Send(); 
	}

}
