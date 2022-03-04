package ca.ntro.app;

import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.core.NtroJdk;
import ca.ntro.core.initialization.Ntro;
import javafx.application.Application;
import ntro.core.NtroFx;

public interface NtroClientFx extends App<FrontendRegistrarFx> {
    
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
        
        Class<? extends NtroClientFx> callerClass = (Class<? extends NtroClientFx>) Ntro.stackAnalyzer().callerClass();
        
        launchImpl(callerClass, args);
    }

    private static void initialize() {
        checkJavaVersion();

        try {

        	NtroFx.initializer().executeBlocking();

        } catch (Throwable e) {

            throw new RuntimeException(e);
        }
    }

    public static void launch(Class<? extends NtroClientFx> callerClass, String[] args) {

        initialize();
        
        launchImpl(callerClass, args);
    }

    private static void launchImpl(Class<? extends NtroClientFx> callerClass, String[] args) {

        AppWrapperFx.appClass = callerClass;

        Application.launch(AppWrapperFx.class, args);
    }
}
