import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.TilePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Random;

public class Game extends Application{
Graphics graphics = new Graphics();
Audio audio = new Audio();
Scene title, game, scoring;
Image pic;
Random rand = new Random();
RegexValidator v = new RegexValidator();
Score s = new Score();
int num1, num2;
int score = 0;
String name;

	public void start (Stage stage) {
		
		num1 = rand.nextInt(10) + 1;
		num2 = rand.nextInt(10) + 1;
		
		Label label3 = new Label("Name: ");
		TextField textField2 = new TextField();
		textField2.setAlignment(Pos.CENTER);
		EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {
				String n = textField2.getText();
				String validName = v.validateName(n);
				name = validName;
				textField2.clear();
			}			
		};
		textField2.setOnAction(event2);
		
		pic = graphics.getImage("results");
		Button results = new Button(null, new ImageView(pic));
		results.setLayoutX(350);
		results.setLayoutY(313);
		results.setVisible(false);
		results.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					s.writeScores(name, score);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				stage.setScene(title);
			}
		});
		
		Label label = new Label(num1 + "+" + num2);
		Label label2 = new Label("High Score: " + score);
		TextField textField = new TextField();
		textField.setAlignment(Pos.CENTER);
		TilePane tile = new TilePane();
		
		EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

			public void handle(ActionEvent e) {
				int answer = num1 + num2;
				String text = textField.getText();
				String validAnswer = v.validateText(text);
				int correct = Integer.parseInt(validAnswer);
				boolean visible = results.isVisible();
				if (visible == true) {
					return;
				}
					else if (correct == answer) {
					audio.playWin();
					score += 1;
					label2.setText("High Score: " + score);
				}
				else {
					audio.playLoss();
				}
				num1 = rand.nextInt(10) + 1;
				num2 = rand.nextInt(10) + 1;
				label.setText(num1 + "+" + num2);
				textField.clear();
			}	
		};
		textField.setOnAction(event);
		
		tile.getChildren().add(label);
		tile.getChildren().add(textField);
		tile.getChildren().add(label2);
		tile.getChildren().add(label3);
		tile.getChildren().add(textField2);
		
		pic = graphics.getImage("start");
		Button start = new Button(null, new ImageView(pic));
		start.setLayoutX(550);
		start.setLayoutY(400);
		start.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				score = 0;
				results.setVisible(false);
				game = graphics.drawGame(tile, results);
				stage.setScene(game);
			}
		});
		
		pic = graphics.getImage("highscores");
		Button highScore = new Button(null, new ImageView(pic));
		highScore.setLayoutX(250);
		highScore.setLayoutY(615);
		highScore.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					s.readScores();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}	
		});
		
		pic = graphics.getImage("exit");
		Button exit = new Button(null, new ImageView(pic));
		exit.setLayoutX(675);
		exit.setLayoutY(800);
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
			System.exit(0);
			}	
		});
		
		title = graphics.drawTitle(start, highScore, exit);
		audio.playMusic();
		
		stage.setScene(title);
		stage.setTitle("Math Quest");
		stage.show();
	}
}
