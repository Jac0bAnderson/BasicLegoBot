package bot.model;
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
	
	
	public EV3Bot()
	{
		this.botMessage = "https://youtu.be/YEjQMMhDkjU?t=1m17s";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		randomNumber = 2.5;
		
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		backTouch = new EV3TouchSensor(LocalEV3.get().getPort("S2"));
		
		setupPilot();
		displayMessage();
	}
	
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 43.3).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 43.3).offset(-72);
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
	botPilot.travel(76.2);
	botPilot.rotateRight();
	botPilot.travel(330.2);
	botPilot.rotateLeft();
	botPilot.travel(558.8);
	botPilot.rotateRight();
	
	//if(ultrasonicSamples[0] < randomNumber) 
	//{
		//botPilot.travel(20.00);
	//}
	//else
	//{
	//	botPilot.travel(254.00);
	//}
	displayMessage("driveRoom");
}

}
