package Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

import Structure.Email;

public class ClientModel extends Observable implements Serializable {

	String[] columnNames = { "Mittente", "Destinatario", "Oggetto", "Testo" };

	public ArrayList<Email> mailList = new ArrayList<Email>();
	Object[][] table;

	public String userEmailAccount = "";

	public ClientModel() {

	}

	public void setUserAccountValue(String account) {
		//System.out.println("Model sta cambiando nome della mail in: " + account);
		userEmailAccount = account;
		setChanged();
		notifyObservers(userEmailAccount);
	}
	// questa carica la mail list nella tabella
	// mi crea una tabella lunga quanto il numero di mail
	// questo viene inizializzato Email 
	public void setValue(ArrayList<Email> newMailList) {
		mailList = newMailList;
		table = new Object[mailList.size()][];
		for (int i = 0; i < mailList.size(); i++) {
			table[i] = mailList.get(i).toObjectArray(); 
		}
	}

	public int getMailListSize() {
		return mailList.size();
	}

	public ArrayList<Email> getMailList() {
		return mailList;
	}
}