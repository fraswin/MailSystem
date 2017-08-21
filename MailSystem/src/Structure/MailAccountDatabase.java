package Structure;
import java.util.ArrayList;

public class MailAccountDatabase {
	// mi creo gli array di account
	ArrayList<MailAccount> accountList = new ArrayList<MailAccount>();

	public ArrayList<MailAccount> getAccountList()	{
		return accountList;
	}
	//mi creo un singleton per l'unicità
	private static MailAccountDatabase instance = null;
	
	public static MailAccountDatabase getInstance() {
		if (instance == null) {
			instance = new MailAccountDatabase();
		}
		return instance; // vuole dare l'unicità
	}
	//costruzione per fare la multi risposta
	String[] arr1={
			"francesco.mazzuzzi@gmail.com"
			};
	String[] arr2={
			"silvia.ruffini@gmail.com"
			};
	String[] arr3={
			"riccardo.biggi@gmail.com"
			};
	String[] arr4={
			"mario.rossi@gmail.com"
			};
	String[] arr5={
			"alex.rossi@gmail.com"
			};
	
	
// creo gli account
	protected MailAccountDatabase() {
		
		MailAccount a1 = new MailAccount("francesco.mazzuzzi@gmail.com");
		MailAccount a2 = new MailAccount("silvia.ruffini@gmail.com");
		MailAccount a3 = new MailAccount("riccardo.biggi@gmail.com");
		MailAccount a4 = new MailAccount("mario.rossi@gmail.com");
		MailAccount a5 = new MailAccount("alex.rossi@gmail.com");
		

		a1.messageList.add(new Email("francesco.mazzuzzi@gmail.com","silvia.ruffini@gmail.com","IMPORTANTE!","Certo, che puoi rispondere",arr2));
		a1.messageList.add(new Email("riccardo.biggi@gmail.com","francesco.mazzuzzi@gmail.com","lavoro","Sono veramente contento di offrirti il lavoro",arr1));
		a1.messageList.add(new Email("francesco.mazzuzzi@gmail.com","mario.rossi@gmail.com","Viaggio","Biglietti prenotati, si parte a SF",arr4));
		
		a2.messageList.add(new Email("francesco.mazzuzzi@gmail.com","silvia.ruffini@gmail.com","IMPORTANTE!","Certo, che puoi rispondere",arr2));
		a2.messageList.add(new Email("silvia.ruffini@gmail.com","riccardo.biggi@gmail.com","Scene","Hai visto le scene?",arr3));
		a2.messageList.add(new Email("silvia.ruffini@gmail.com","alex.rossi@gmail.com","Mare","Il mare è blu",arr5));
		
		a3.messageList.add(new Email("silvia.ruffini@gmail.com","riccardo.biggi@gmail.com","Scene","Hai visto le scene?",arr3));
		a3.messageList.add(new Email("riccardo.biggi@gmail.com","francesco.mazzuzzi@gmail.com","lavoro","Sono veramente contento di offrirti il lavoro",arr1));
		a3.messageList.add(new Email("riccardo.biggi@gmail.com","mario.rossi@gmail.com","Eng","Do u see?",arr4));
		
		a4.messageList.add(new Email("mario.rossi@gmail.com","francesco.mazzuzzi@gmail.com","Viaggio!","Biglietti prenotati, si parte a SF",arr1));
		a4.messageList.add(new Email("riccardo.biggi@gmail.com","mario.rossi@gmail.com","Eng","Do u see?",arr4));
		
		a5.messageList.add(new Email("francesco.mazzuzzi@gmail.com","mario.rossi@gmail.com","Viaggio","Biglietti prenotati, si parte a SF",arr4));
		a5.messageList.add(new Email("silvia.ruffini@gmail.com","alex.rossi@gmail.com","Mare","Il mare è blu",arr5));
		
		
		// aggiungo gli account all'array di account
		accountList.add(a1);
		accountList.add(a2);
		accountList.add(a3);
		accountList.add(a4);
		accountList.add(a5);
		


	}
	
	
}
