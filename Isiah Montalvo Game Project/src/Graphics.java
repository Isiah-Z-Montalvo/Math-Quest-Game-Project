import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.animation.*;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Graphics {
	
	public Image getImage(String img) {
		Image image = null;
		
		if (img == "start") {
			image = new Image("file:///C:/Users/Swift/Desktop/Start.png");
		}
		else if (img == "highscores") {
			image = new Image("file:///C:/Users/Swift/Desktop/High%20Scores.png");
		}
		else if (img == "exit") {
			image = new Image("file:///C:/Users/Swift/Desktop/Exit.png");
		}
		else if (img == "results") {
			image = new Image("file:///C:/Users/Swift/Desktop/Results.png");
		}	
		return image;
	}
	
	public Scene drawTitle(Button start, Button highScore, Button exit) {
		Image image = new Image("file:///C:/Users/Swift/Desktop/Title.png");
		ImageView title = new ImageView(image);
		Rectangle bg = new Rectangle(1920, 1080);
		bg.setFill(Color.SEAGREEN);
		Pane pane = new Pane(bg, title, start, highScore, exit);
		Scene scene = new Scene(pane, 1920, 1080);
		return scene;
	}
	
	public Scene drawGame(TilePane tile, Button results) {
		Rectangle sky = new Rectangle(1920, 540);
		sky.setFill(Color.LIGHTSKYBLUE);
		
		Rectangle ground = new Rectangle(0, 980, 1920, 100);
		ground.setFill(Color.BEIGE);
		
		Rectangle grass = new Rectangle(0, 540, 1920, 440);
		grass.setFill(Color.GREEN);
		
		Circle sun = new Circle(1920, 0, 300);
		sun.setFill(Color.ORANGE);
		
		Rectangle sqEnemy = new Rectangle(0, 780, 200, 200);
		sqEnemy.setFill(Color.RED);
		TranslateTransition move = new TranslateTransition();
		move.setDuration(Duration.millis(10000));
		move.setNode(sqEnemy);
		move.setByX(1920);
		move.setCycleCount(2);
		move.setAutoReverse(true);
		move.play();
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				results.setVisible(true); 
			}
		};
		move.setOnFinished(event);
		Group enemy = new Group(sqEnemy);
		
		Pane pane = new Pane(ground, grass, sky, sun, enemy, tile, results);
		Scene scene = new Scene(pane, 1920, 1080);
		return scene;
	}
}
