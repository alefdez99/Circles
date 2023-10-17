package es.ieslosmontecillos.circle;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CirculoInnerClass extends Application
{
    //Creamos el circulo
    Circle circle = new Circle();

    @Override
    public void start(Stage primaryStage)
    {
        //Creamos el contenedor principal
        BorderPane root = new BorderPane();

        primaryStage.setTitle("Circle");

        //Asignamos la escena y ponemos root como contenedor principal
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);

        //Propiedades del circulo

        //Esto mantiene al círculo en el centro de la ventana, independientemente del tamaño de esta
        circle.centerXProperty().bind(scene.widthProperty().divide(2));
        circle.centerYProperty().bind(scene.heightProperty().divide(2));
        circle.setRadius(100);

        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);
        d1.bind(d2);


        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        //Añadimos el circulo a la escena
        root.getChildren().add(circle);

        //Creamos la hbox que contendrá los botones
        HBox hBox = new HBox(10);

        //Creamos los botones
        Button btn1 = new Button("Enlarge");

        Button btn2 = new Button("Shrink");

        //Añadimos los botones a la hbox
        hBox.getChildren().add(btn1);
        hBox.getChildren().add(btn2);

        //Añadimos la hbox a root
        root.setBottom(hBox);
        hBox.setAlignment(Pos.CENTER);

        btn1.setOnAction(new Enlarge());
        btn2.setOnAction(new Shrink());


        /*
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                circle.setRadius(circle.getRadius() + 10);
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                circle.setRadius(circle.getRadius() - 10);
            }
        });
        */

        //Mostramos la escena
        primaryStage.show();
    }

    class Enlarge implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            circle.setRadius(circle.getRadius() + 10);
        }
    }

    class Shrink implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            circle.setRadius(circle.getRadius() - 10);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}