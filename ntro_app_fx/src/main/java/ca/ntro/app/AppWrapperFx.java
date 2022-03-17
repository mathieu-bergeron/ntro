package ca.ntro.app;

import java.io.IOException;


import ca.ntro.app.backend.BackendRegistrarNtro;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.frontend.WindowFx;
import ca.ntro.app.messages.MessageRegistrarNtro;
import ca.ntro.app.models.ModelRegistrarNtro;
import ca.ntro.app.services.ExitServiceJdk;
import ca.ntro.app.services.LocaleServiceJdk;
import ca.ntro.app.system.SystemTasksNtro;
import ca.ntro.core.initialization.Ntro;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppWrapperFx extends Application {
    
    static Class<? extends NtroClientFx> appClass;
    
    private static BackendRegistrarNtro backendRegistrar;
    private static FrontendRegistrarFx  frontendRegistrar;
    private static SystemTasksNtro      systemTasksNtro;
    
    private void onExit() {

        System.out.println("\n\n\n[GENERATING GRAPHS]\n\n\n");
        NtroApp.models().writeGraphs();

        backendRegistrar.writeGraph();
        frontendRegistrar.writeGraph();
        systemTasksNtro.writeGraph();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        NtroApp.registerLocaleService(new LocaleServiceJdk());
        NtroApp.registerExitService(new ExitServiceJdk());
        
        NtroClientFx app = Ntro.factory().newInstance(appClass);

        MessageRegistrarNtro messageRegistrar  = new MessageRegistrarNtro();
        ModelRegistrarNtro   modelRegistrar    = new ModelRegistrarNtro();
        backendRegistrar  = new BackendRegistrarNtro();
        frontendRegistrar = new FrontendRegistrarFx();
        systemTasksNtro   = new SystemTasksNtro();

        WindowFx window = new WindowFx(primaryStage);
        frontendRegistrar.setWindow(window);

        primaryStage.setOnCloseRequest(event -> {
            Platform.runLater(() -> {
                NtroApp.exit(() -> onExit());
            });
        });
        
        backendRegistrar.setMessageRegistrar(messageRegistrar);
        backendRegistrar.setModelRegistrar(modelRegistrar);

        frontendRegistrar.setMessageRegistrar(messageRegistrar);
        frontendRegistrar.setModelRegistrar(modelRegistrar);

        app.registerMessages(messageRegistrar);
        app.registerModels(modelRegistrar);
        app.registerBackend(backendRegistrar);
        app.registerFrontend(frontendRegistrar);

        System.out.println("\n\n\n");
        System.out.println("[INFO] Ntro version 0.8");
        System.out.println("[INFO] Locale: '" + NtroApp.currentLocale() + "'");

        // XXX: must first prepare every task graph
        //      (creates trace)
        backendRegistrar.prepareToExecuteTasks();
        frontendRegistrar.prepareToExecuteTasks();
        systemTasksNtro.prepareToExecuteTasks();
        
        modelRegistrar.watchModels();

        backendRegistrar.executeTasks();
        frontendRegistrar.executeTasks();
        systemTasksNtro.executeTasks();
        
        // FIXME: should define some Ntro.threadService
        new Thread() {
            
            @Override
            public void run() {

                System.out.println("[INFO] App running. Press Enter here to exit.");

                try {

                    System.in.read();
                    Platform.exit();
                    NtroApp.exit(() -> onExit());

                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }.start();

    }

}
