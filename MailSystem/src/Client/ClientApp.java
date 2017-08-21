package Client;

import java.io.IOException;
import java.net.UnknownHostException;


public class ClientApp {

	public ClientApp() throws UnknownHostException, IOException, InterruptedException, ClassNotFoundException {

		ClientModel myClientModel = new ClientModel();
		ClientView myClientView = new ClientView();
		ClientController myClientController = new ClientController();
		
		myClientModel.addObserver(myClientView);
		myClientController.addModel(myClientModel);
		myClientController.addView(myClientView);
		myClientView.addController(myClientController);
		myClientController.connectToServer();
	}

	public static void main(String[] args) throws UnknownHostException, ClassNotFoundException, IOException, InterruptedException {
		@SuppressWarnings("unused")
		ClientApp mainRunMVC = new ClientApp();

	}

}
