package factoryMethod.abstraction;

public class MailSender implements Sender {

	@Override
	public void Send() {
		System.out.println("this is mailsender!");  
		System.out.println(111);
	}

}
