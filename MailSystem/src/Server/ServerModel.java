package Server;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

import Structure.Email;


public class ServerModel extends Observable implements Serializable{

	private String[] columnNames = { "Client N°", "Account", "Data" };
	private Object[][] data = new Object[5][3];

	public void setValue(Object[][] newData) {
		data = newData;
	}
	
	public Object[][] getData()	{
		return data;
	}

	public String[] getColumnNames() {
		return columnNames;
	}
	

}



