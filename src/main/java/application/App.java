package application;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {

        this.primaryStage = primaryStage;

        primaryStage.setTitle("JavaFX Application 2.0");
        primaryStage.setScene(SceneFactory.getLoginView());
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Called method stop()");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
