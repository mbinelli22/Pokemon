package HW4;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


public class DriverGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Pokemon pikachu = new Pikachu(40,20);
	Pokemon charmander = new Charmander(50,20);
	PokemonControlPanel controlPanel;
	Animations animate;
	File soundFile = new File("src//HW4//images//theme_song.wav");

	public DriverGUI() {
		setTitle("Pokemon Battle");
		setSize(382,425);
		setLayout(new GridLayout(2,1));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createContents();
		
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void createContents() {

		animate = new Animations(this);
		controlPanel = new PokemonControlPanel(pikachu,charmander,animate);
		add(animate);
		animate.update(getGraphics());
		add(controlPanel);
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			
			audioClip.open(audioStream);
			FloatControl gain = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
			gain.setValue(-20.0f);
			audioClip.start();
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new DriverGUI();
		
	}
	
}
