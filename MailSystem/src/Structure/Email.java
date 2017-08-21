package Structure;
import java.io.Serializable;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class Email implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int ID;
	private String sender;
	private String receiver;
	private String subject;
	private String text;
	private String[] allReceivers;  // questo mi serve per mettere tutte le persone che hanno ricevuto la mail
	private java.util.Date sendingDate;
	

	
	public Email(String sender , String receiver , String messageObject , String messageText, String[] receivers){
		
		ID = count.incrementAndGet(); //non lo utilizzo ma per correttezza lo implemento  
		this.sender = sender;
		this.receiver = receiver;
		subject = messageObject;
		text = messageText;
		allReceivers = receivers;
		sendingDate = Calendar.getInstance().getTime();
	}
	
	public int getID()	{
		return ID;
	}
	
	public String getSender ()	{
		return sender;
	}
	
	public String getReceiver()	{
		return receiver;
	}
	
	public String getEmailObject()	{
		return subject;
	}
	
	public String getEmailText()	{
		return text;
	}
	
	public java.util.Date getSendingDate()	{
		return sendingDate;
	}
	public String[] getAllReceivers()	{
		return allReceivers;
	}
	public String toString()	{
		return "Invio"+sender+"Ricezione:"+receiver+"Oggetto:"+subject+"Testo:"+text;
		
	}
	//serve a restituire un array di oggetti mi serve per
	public Object[] toObjectArray() {  
	    return new Object[] { 
	    		sender, receiver,subject,text
	    		};
	}
}
