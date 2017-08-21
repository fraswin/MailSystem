package Server;

import java.rmi.RemoteException;
import java.util.Observer;

public class ServerApp {
	
	private static ServerApp instance = null;

	private ServerApp() throws RemoteException, InterruptedException {

		ServerModel myServerModel = new ServerModel();
		ServerView myServerView = new ServerView();

		myServerModel.addObserver((Observer) myServerView);

		ServerController myServerController = new ServerController();
		myServerController.addModel(myServerModel);
		myServerController.addView(myServerView);
		myServerView.addController(myServerController);

	}

	public static ServerApp getInstance() throws RemoteException, InterruptedException {
		if (instance == null) {
			instance = new ServerApp();
		}
		return instance;
	}

	public static void main(String[] args) throws RemoteException, InterruptedException {

		getInstance();

	}

}
