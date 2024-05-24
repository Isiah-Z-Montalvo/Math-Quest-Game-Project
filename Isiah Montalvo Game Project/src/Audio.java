import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Audio {

	public void playWin() {
		File file = new File("C:\\Users\\Swift\\Desktop\\Lucky!.mp3");
		Media media = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}
	
	public void playLoss() {
		File file = new File("C:\\Users\\Swift\\Desktop\\[Sound Effect] Knuckles - 'Oh No!'.mp3");
		Media media = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}
	
	public void playMusic() {
		File file = new File("C:\\Users\\Swift\\Desktop\\Paper Mario Music - File Select.mp3");
		Media media = new Media(file.toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
		mediaPlayer.setCycleCount(10);
	}
}