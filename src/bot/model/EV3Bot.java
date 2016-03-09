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
	ultrasonicSamples = new float [distanceSensor.sampleSize()];
	distanceSensor.fetchSample(ultrasonicSamples, 0);
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

public void robotSing()
{
	
	Sound.playTone(1567, 1000);//G
	Sound.playTone(1396.91, 1000);//F
	Sound.playTone(1396, 1000);//F
	Sound.playTone(1318.51,1000);//E
	Sound.playTone(1244.51,1000);//D#
	Sound.playTone(1174.66,1000);//D
	Sound.playTone(932.33, 500);//A#
	Sound.playTone(932.33, 500);//A#
	Sound.playTone(1046.50, 1000);//C
	Sound.playTone(523.25,1000);//C
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
