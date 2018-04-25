package factoryMethod.stative;


public class Test {

	public static void main(String[] args) {
		Sender sender = SendFactory.produceSms(); 
		sender.Send(); 
	}

}
