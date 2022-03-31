package ca.ntro.app;

import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.app.services.LocaleServiceJdk;
import ca.ntro.core.initialization.Ntro;
import javafx.application.Application;
import ntro.core.NtroFx;
import services.ExitServiceFx;

public interface NtroServerJdk {

	void registerMessages(MessageRegistrar registrar);
	void registerModels(ModelRegistrar registrar);
	void registerBackend(BackendRegistrar registrar);
	void registerServer(ServerRegistrarJdkImpl registrar);
	
    private static void checkJavaVersion() {
        String javaVersion = System.getProperty("java.version");
        if(!javaVersion.startsWith("11")) {
            System.err.println("[FATAL ERROR]: java-11 is required (provided: " + javaVersion + ")");
            System.exit(0);
        }
    }
	
    @SuppressWarnings("unchecked")
    public static void launch(String[] args) {
        initialize();
        
        Class<? extends NtroServerJdk> callerClass = (Class<? extends NtroServerJdk>) Ntro.stackAnalyzer().callerClass();
        
        launchImpl(callerClass, args);
    }

    private static void initialize() {
        checkJavaVersion();

        NtroApp.registerLocaleService(new LocaleServiceJdk());
        NtroApp.registerExitService(new ExitServiceFx());


        try {

        	NtroFx.initializer().executeBlocking();

        } catch (Throwable e) {

            throw new RuntimeException(e);
        }
    }

    public static void launch(Class<? extends NtroServerJdk> callerClass, String[] args) {

        initialize();
        
        launchImpl(callerClass, args);
    }

    private static void launchImpl(Class<? extends NtroServerJdk> serverClass, String[] args) {
    	
    	// Start a FX headless app
    	ServerWrapperFx.serverClass = serverClass;
    	Application.launch(ServerWrapperFx.class, args);
    	
    	
    	/*
		VertxOptions vertxOptions = new VertxOptions();
		Vertx vertx = Vertx.vertx(vertxOptions);

		vertx.exceptionHandler(exception -> {
			exception.printStackTrace();
		});

		EventBus eventBus = vertx.eventBus();
		eventBus.registerDefaultCodec(TextMessage.class,new TextMessageCodec());

		Router router = Router.router(vertx);

		SockJSHandlerOptions sockJSOptions = new SockJSHandlerOptions();

		sockJSOptions.setLocalWriteHandler(true);
		SockJSHandler sockJSHandler = SockJSHandler.create(vertx, sockJSOptions);
		

		router.mountSubRouter("/socket/messages", sockJSHandler.socketHandler(socket -> {
			
			socket.handler(messageBuffer -> {

				handleMessage(socket, messageBuffer);
			});
		}));

		router.route("/").handler(request -> {
			System.out.println("request: " + request.request().absoluteURI());
			
			request.end("bonjour");
		});

		router.errorHandler(500, rc -> {
		  Throwable failure = rc.failure();
		  if (failure != null) {
			failure.printStackTrace();
		  }
		});

		HttpServerOptions serverOptions = new HttpServerOptions();
		int port = 8080;

		HttpServer server = vertx.createHttpServer(serverOptions);
		server.requestHandler(router);

		server.listen(port);
		*/
    }

    /*
	static void handleMessage(SockJSSocket socket, Buffer messageBuffer) {
		System.out.println("message: " + messageBuffer.toString());
	}
	*/
	

}
