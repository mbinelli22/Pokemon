package HW4;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Animations extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon pikachu, charmander;
	JLabel left, right;
	URL urlPika1, urlChar1, urlPika2,urlChar2;
	Image pika2, pika1, char1, char2;
	DriverGUI ref;
	Clip hit_1;
	Clip potion;
	AudioInputStream audioStream, audioStream1;
	
	public Animations(DriverGUI Jref) {
		ref = Jref;
		
		this.setLayout(new GridLayout(1,2));
		File hitSound = new File("src//HW4//images//hit_1.wav");
		File potionSound = new File("src//HW4//images//potion.wav");
		try {
			
			audioStream = AudioSystem.getAudioInputStream(hitSound);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			hit_1 = (Clip) AudioSystem.getLine(info);
			hit_1.open(audioStream);
			
			audioStream1 = AudioSystem.getAudioInputStream(potionSound);
			potion = (Clip) AudioSystem.getLine(info);
			potion.open(audioStream1);
			
			
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		
		urlPika2 = this.getClass().getResource("Images\\Pikachu_lightning.gif");
		urlPika1 = this.getClass().getResource("Images\\Pikachu_standing.gif");
		urlChar1 = this.getClass().getResource("Images\\Charmander_standing.gif");
		urlChar2 = this.getClass().getResource("Images\\Charmander_hit.gif");
		
		
		ImageIcon ch1 = new ImageIcon(urlChar1);
		ImageIcon ch2 = new ImageIcon(urlChar2);
		ImageIcon pk1 = new ImageIcon(urlPika1);
		ImageIcon pk2 = new ImageIcon(urlPika2);
		
		
		pika1 = pk1.getImage();
		pika2 = pk2.getImage();
		char1 = ch1.getImage();
		char2 = ch2.getImage();
		
		pika2 = pika2.getScaledInstance(120, 120,  java.awt.Image.SCALE_DEFAULT);
		pika1 = pika1.getScaledInstance(120, 120,  java.awt.Image.SCALE_DEFAULT);

		char1 = char1.getScaledInstance(120, 120,  java.awt.Image.SCALE_DEFAULT);
		char2 = char2.getScaledInstance(120, 120,  java.awt.Image.SCALE_DEFAULT);
		
		pikachu = new ImageIcon(pika1);
		charmander = new ImageIcon(char1);
		
		left = new JLabel(pikachu);
		right = new JLabel(charmander);
		
		
		add(left);
		add(right);
	}
	
	

	
	
	public void pikaAttackAnim() {
		playClip(hit_1);
		pikachu.setImage(pika2);
		Timer timer = new Timer("Timer");
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				  pikachu.setImage(pika1);
				  ref.update(getGraphics());
			}};
		timer.schedule(task, 2000);
		ref.update(getGraphics());
	}
	
	public void charAttackAnim() {
		playClip(hit_1);
		charmander.setImage(char2);
		Timer timer = new Timer("Timer");
		TimerTask task2 = new TimerTask() {
			@Override
			public void run() {
				  charmander.setImage(char1);
				  ref.update(getGraphics());
			}};
		timer.schedule(task2, 1500);
		ref.update(getGraphics());
	}
	
	public void resetBoth(){
		playClip(potion);
		pikachu.setImage(pika1);
		charmander.setImage(char1);
		ref.update(getGraphics());
	}
	
	
	public void playClip(Clip clip) {
	 if(clip.isRunning())
     {
         clip.stop();
     }
     clip.setFramePosition( 0 );
     clip.start();
	
	}
}
