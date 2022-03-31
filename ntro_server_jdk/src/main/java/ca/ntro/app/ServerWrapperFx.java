package ca.ntro.app;

import java.io.IOException;

import ca.ntro.app.backend.BackendRegistrarNtro;
import ca.ntro.app.messages.MessageRegistrarNtro;
import ca.ntro.app.models.ModelRegistrarNtro;
import ca.ntro.core.initialization.Ntro;
import javafx.application.Application;
import javafx.stage.Stage;

public class ServerWrapperFx extends Application {
	
	public static Class<? extends NtroServerJdk> serverClass;
	
	private NtroServerJdk serverSpec;
	private WebSocketServerNtro webSocketServer;

    private MessageRegistrarNtro   messageRegistrar  = new MessageRegistrarNtro();
    private ModelRegistrarNtro     modelRegistrar    = new ModelRegistrarNtro();
    private BackendRegistrarNtro   backendRegistrar  = new BackendRegistrarNtro(modelRegistrar, messageRegistrar);
    private ServerRegistrarJdkImpl serverRegistrar   = new ServerRegistrarJdkImpl();

	public NtroServerJdk getServerSpec() {
		return serverSpec;
	}

	public void setServerSpec(NtroServerJdk serverSpec) {
		this.serverSpec = serverSpec;
	}

	public WebSocketServerNtro getWebSocketServer() {
		return webSocketServer;
	}

	public void setWebSocketServer(WebSocketServerNtro webSocketServer) {
		this.webSocketServer = webSocketServer;
	}

	public ServerWrapperFx() {
	}

	public ServerWrapperFx(NtroServerJdk serverSpec) {
		setServerSpec(serverSpec);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		serverSpec = Ntro.factory().newInstance(serverClass);
		
		serverSpec.registerMessages(messageRegistrar);
		serverSpec.registerModels(modelRegistrar);
		serverSpec.registerBackend(backendRegistrar);
		serverSpec.registerServer(serverRegistrar);

        System.out.println("\n\n\n");
        System.out.println("[INFO] Ntro version 1.0");
        System.out.println("[INFO] Locale: '" + NtroApp.currentLocale() + "'");
        
		backendRegistrar.prepareToExecuteTasks();
		modelRegistrar.watchModels();
		backendRegistrar.executeTasks();

    	webSocketServer = new WebSocketServerNtro(serverRegistrar.getServerName(), serverRegistrar.getPort());
    	webSocketServer.start();

        new Thread() {
            
            @Override
            public void run() {

                System.out.println("[INFO] Server running. Press Enter here to exit.\n\n");

                try {

                    System.in.read();
                    NtroApp.exit(() -> {
                    	onExit();
                    });

                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }.start();

	}

	public void onExit() {

        System.out.println("\n\n\n[GENERATING GRAPHS]\n\n\n");
        NtroApp.models().writeGraphs();
        
        if(!backendRegistrar.isRemoteBackend()) {
			backendRegistrar.writeGraph();
        }
		
	}


}
