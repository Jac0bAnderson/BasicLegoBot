package bot.controller;

import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;
import bot.model.EV3Bot;

public class botController 
{
	private String message;
	private int xPosition, yPosition;
	private long waitTime;
	private EV3Bot sillyBot;
	
	public botController()
	{
		this.xPosition = 50;
		this.yPosition = 100;
		this.waitTime = 4000;
		this.message = "When Robots Die Nothing Happens";
		sillyBot = new EV3Bot();
	}
public void start()
{
	LCD.drawString(message,xPosition, yPosition);
	sillyBot.driveRoom();
	
}
public String getMessage() 
{
	return message;
}
public int getxPosition() 
{
	return xPosition;
}
public int getyPosition() 
{
	return yPosition;
}
public long getWaitTime() 
{
	return waitTime;
}
public void setMessage(String message) 
{
	this.message = message;
}
public void setxPosition(int xPosition) 
{
	this.xPosition = xPosition;
}
public void setyPosition(int yPosition) 
{
	this.yPosition = yPosition;
}
public void setWaitTime(long waitTime) 
{
	this.waitTime = waitTime;
}

}
