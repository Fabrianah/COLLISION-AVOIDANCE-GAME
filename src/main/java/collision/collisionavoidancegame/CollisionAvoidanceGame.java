package collision.collisionavoidancegame;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class CollisionAvoidanceGame extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Pane root = new Pane();

        Scene scene = new Scene(root, 800, 560);

        //background color
        scene.setFill(Color.BLACK);

        //setting clouds and plane to be visible in the scene on stage
        ImageView plane = Plane(scene);
        ImageView cloud1=Cloud1(scene);
        ImageView cloud2=Cloud2(scene);
        ImageView cloud3=Cloud3(scene);
        ImageView cloud4=Cloud4(scene);
        ImageView cloud5=Cloud5(scene);


        //placeholder of the game over text and styling
        Text txt=new Text();
        txt.setX(10.0f);
        txt.setY(50.0f);
        txt.setCache(true);
        txt.setText("");
        txt.setFill(Color.RED);
        txt.setFont(Font.font(null, FontWeight.BOLD,30));
        Reflection r=new Reflection();
        r.setFraction(0.7f);
        txt.setEffect(r);
        txt.setTranslateY(100);
        txt.setTranslateX(200);


        //putting objects on stage
        root.getChildren().addAll(plane, cloud1,cloud2,cloud3,cloud4,cloud5,txt);

        //plane movements up and down
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double y = plane.getY();

            switch (event.getCode()){
                case UP -> plane.setY(y - 5);
                case DOWN -> plane.setY(y +5);
            }

            if(     plane.getBoundsInParent().intersects(cloud1.getBoundsInParent()) ||
                    plane.getBoundsInParent().intersects(cloud2.getBoundsInParent()) ||
                    plane.getBoundsInParent().intersects(cloud4.getBoundsInParent()) ||
                    plane.getBoundsInParent().intersects(cloud4.getBoundsInParent()) ||
                    plane.getBoundsInParent().intersects(cloud5.getBoundsInParent())
            )

            {

                txt.setText("GAME OVER!");
                plane.setImage(new Image("explosion.png"));


                scene.addEventFilter(KeyEvent.KEY_PRESSED, event1 -> {
                    switch (event.getCode()){
                        case UP -> plane.setY(y - 0);
                        case DOWN -> plane.setY(y +0);
                    }
                });
            }
        });
        if (
                cloud2.getBoundsInParent().intersects(plane.getBoundsInParent())
                        ||cloud3.getBoundsInParent().intersects(plane.getBoundsInParent())
                        ||cloud4.getBoundsInParent().intersects(plane.getBoundsInParent())
                        ||cloud5.getBoundsInParent().intersects(plane.getBoundsInParent())

        ) {
            txt.setText("GAME OVER!");
            plane.setImage(new Image("explosion.png"));




        }


        //title of the game
        stage.setTitle("COLLISION DETECTION GAME");

        //icon of the game
        Image icon=new Image(getClass().getResourceAsStream("/icon.jpg"));

        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    //methods that will be used to call the objects created
    public ImageView Cloud1(Scene scene) {
        ImageView clouds1=new ImageView(new Image("cloud5.png"));

        clouds1.setFitHeight(150);
        clouds1.setFitWidth(150);
        clouds1.setY(scene.getHeight() - clouds1.getFitHeight());

        TranslateTransition translate=new TranslateTransition();
        translate.setNode(clouds1);
        translate.setDuration(Duration.millis(8000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(50);
        translate.setByY(0);
        translate.setByX(scene.getWidth());
        translate.setCycleCount(Integer.MAX_VALUE);
        translate.setAutoReverse(true);
        translate.play();

        return clouds1;

    }
    private ImageView Cloud2(Scene scene) {
        ImageView clouds2=new ImageView(new Image("cloud2.png"));
        clouds2.setFitHeight(100);
        clouds2.setFitWidth(100);

        TranslateTransition translate=new TranslateTransition();
        translate.setNode(clouds2);
        translate.setDuration(Duration.millis(6000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(300);
        translate.setByY(0);
        translate.setCycleCount(Integer.MAX_VALUE);
        translate.setAutoReverse(true);
        translate.play();

        return clouds2;

    }
    private ImageView Cloud3(Scene scene) {
        ImageView clouds3=new ImageView(new Image("cloud4.png"));
        clouds3.setFitHeight(150);
        clouds3.setFitWidth(150);

        TranslateTransition translate=new TranslateTransition();
        translate.setNode(clouds3);
        translate.setDuration(Duration.millis(10000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(10);
        translate.setByY(0);
        translate.setByX(scene.getWidth());
        translate.setCycleCount(Integer.MAX_VALUE);

        translate.setAutoReverse(true);
        translate.play();
        RotateTransition rotate=new RotateTransition();
        rotate.setNode(clouds3);
        rotate.setDuration(Duration.seconds(6));
        rotate.setCycleCount(RotateTransition.INDEFINITE);
        rotate.setByAngle(360);
        rotate.play();

        return clouds3;

    }
    private ImageView Cloud4(Scene scene) {
        ImageView clouds4=new ImageView(new Image("cloud3.png"));
        clouds4.setFitHeight(150);
        clouds4.setFitWidth(100);

        TranslateTransition translate=new TranslateTransition();
        translate.setNode(clouds4);
        translate.setDuration(Duration.millis(5000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(100);
        translate.setByY(0);
        translate.setByX(scene.getWidth());
        translate.setCycleCount(Integer.MAX_VALUE);
        translate.setAutoReverse(true);
        translate.play();

        return clouds4;

    }
    private ImageView Cloud5(Scene scene) {
        ImageView clouds5=new ImageView(new Image("cloud1.png"));
        clouds5.setFitHeight(150);
        clouds5.setFitWidth(100);

        TranslateTransition translate=new TranslateTransition();
        translate.setNode(clouds5);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(100);
        translate.setByY(0);
        translate.setByX(scene.getWidth());
        translate.setCycleCount(Integer.MAX_VALUE);
        translate.setAutoReverse(true);
        translate.play();

        return clouds5;


    }
    private ImageView Plane(Scene scene) {
        ImageView image = new ImageView(new Image("PLANE.gif"));
        image.setFitWidth(100);
        image.setFitHeight(100);
        image.setY(scene.getHeight() - image.getFitHeight());

        return image;
    }

    public static void main(String[] args)
    {
        launch();
    }
}