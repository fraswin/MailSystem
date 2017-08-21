package Structure;
import java.util.ArrayList;
import java.util.Calendar;

public class MailAccount {

	private String mailAccount;
	//mi creo le mail collegate all'account
	ArrayList<Email> messageList; 
	
	
	public MailAccount(String account)	{
		this.mailAccount = account;
		// mi creo tutti i messaggi ricevute ed inviate
		messageList =  new ArrayList<Email>();
	}
	
	public String getMailAccount()	{
		return mailAccount;
	}
	
	
	public ArrayList<Email> getMessageList()	{
		return messageList;
	}
	
}
