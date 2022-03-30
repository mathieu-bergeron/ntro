package ca.ntro.server;

import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import ca.ntro.core.NtroJdk;
import ca.ntro.core.initialization.Ntro;

public interface NtroServerJdk {

	void registerMessages(MessageRegistrar registrar);
	void registerModels(ModelRegistrar registrar);
	void registerBackend(BackendRegistrar registrar);
	void registerServer(ServerRegistrarJdk registrar);

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

        try {

        	NtroJdk.initializer().executeBlocking();

        } catch (Throwable e) {

            throw new RuntimeException(e);
        }
    }

    public static void launch(Class<? extends NtroServerJdk> callerClass, String[] args) {

        initialize();
        
        launchImpl(callerClass, args);
    }

    private static void launchImpl(Class<? extends NtroServerJdk> callerClass, String[] args) {
    	
    	WebSocketServerNtro webSocketServer = new WebSocketServerNtro(8080);
    	webSocketServer.start();
    	
    	
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
