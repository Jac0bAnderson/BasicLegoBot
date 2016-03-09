package bot.model;
import lejos.hardware.Sound;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class EV3Bot 
{
	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	private float [] ultrasonicSamples;
	private float [] touchSamples;
	public double randomNumber ;
	private MovePilot botPilot;
	private EV3TouchSensor backTouch;
	private  EV3UltrasonicSensor distanceSensor;
	private TwitterRobot tweetSend;
	
	
	public EV3Bot()
	{
		this.botMessage = "https://youtu.be/YEjQMMhDkjU?t=1m17s";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		
		
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		backTouch = new EV3TouchSensor(LocalEV3.get().getPort("S2"));
		
		
		setupPilot();
		displayMessage();
	}
	
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 43.3).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 43.3).offset(72);
		WheeledChassis chassis = new WheeledChassis(new Wheel[]{leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		botPilot = new MovePilot(chassis);
	}
	
	
	private void displayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
	private void displayMessage(String message)
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}
public void driveRoom()
{
	//rotateLeft()
	//rotateRight()
	ultrasonicSamples = new float [distanceSensor.sampleSize()];
	distanceSensor.fetchSample(ultrasonicSamples, 0);
	//short side drive
	//shortDrive();
	robotSing();
	//if(ultrasonicSamples[0] < 30) 
	//{
		//shortDrive();
		//displayMessage("driveRoom");
	
	//}
	//else
	//{
		//longDrive();
		//displayMessage("driveRoom");
		//botPilot.travel(0);
	//}
	
}
/**
 * private static String[] notes = { "C3", "C#3", "Db3", "D3", "D#3", "Eb3",
        "E3", "F3", "F#3", "Gb3", "G3", "G#3", "Ab3", "A3", "A#3", "Bb3",
        "B3", "C4", "C#4", "Db4", "D4", "D#4", "Eb4", "E4", "F4", "F#4",
        "Gb4", "G4", "G#4", "Ab4", "A4", "A#4", "Bb4", "B4", "C5", "C#5",
        "Db5", "D5", "D#5", "Eb5", "E5", "F5", "F#5", "Gb5", "G5", "G#5",
        "Ab5", "A5", "A#5", "Bb5", "B5", "C6" };
  private static float[] frequency = { 130.81f, 138.59f, 138.59f, 146.83f,
        155.56f, 155.56f, 164.81f, 174.61f, 185.0f, 185.0f, 196.0f,
        207.65f, 207.65f, 220.0f, 233.08f, 233.08f, 246.94f, 261.63f,
        277.18f, 277.18f, 293.66f, 311.13f, 311.13f, 329.63f, 349.23f,
        369.99f, 369.99f, 392.0f, 415.3f, 415.3f, 440.0f, 466.16f, 466.16f,
        493.88f, 523.25f, 554.37f, 554.37f, 587.33f, 622.25f, 622.25f,
        659.26f, 698.46f, 739.99f, 739.99f, 783.99f, 830.61f, 830.61f,
        880.0f, 932.33f, 932.33f, 987.77f, 1046.5f };
 */
	

public void robotSing()
{
	Sound.playTone(739, 1000);//G
	Sound.playTone(698, 1000);//F
	Sound.playTone(698, 1000);//F
	Sound.playTone(659,1000);//E
	Sound.playTone(622,1000);//D#
	Sound.playTone(587,1000);//D
	Sound.playTone(466, 500);//A#
	Sound.playTone(466, 500);//A#
	Sound.playTone(523, 1000);//C
	Sound.playTone(261,1000);//C
}
private void shortDrive()
{
	LCD.drawString("Short", xPosition, yPosition);
	botPilot.travel(760.2);
	//tweetSend.sendTweet("Internet Me-Maws");
	botPilot.rotate(65);
	botPilot.travel(3320.2);
	botPilot.rotate(-65);
	botPilot.travel(5400.8);
	botPilot.rotate(65);
	botPilot.travel(3350.2);
}
private void longDrive()
{
	LCD.drawString("long", xPosition, yPosition);
	botPilot.travel(3350.2);
	//tweetSend.sendTweet("Internet Me-Maws");
	botPilot.rotate(-65);
	botPilot.travel(5500.8);
	botPilot.rotate(65);
	botPilot.travel(3320.2);
	botPilot.rotate(-65);
	botPilot.travel(760);
}

public MovePilot getPilot()
{
	return botPilot;
}

}
