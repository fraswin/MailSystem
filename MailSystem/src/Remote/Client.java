package Remote;


public interface Client {

	String getClientName();
	
	public void showNewMessagePopUp(String sender,String title);
	public void showErrorMessage(String error);
}
