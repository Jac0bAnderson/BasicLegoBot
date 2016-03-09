package bot.model;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import bot.controller.botController;

import java.util.ArrayList;

import lejos.robotics.navigation.MovePilot;

public class TwitterRobot 
{
	private botController baseController;
	private Twitter chatbotTwitter;
	private double travelDistance;
	private MovePilot botPilot;
	
	
	
	
	public TwitterRobot(botController baseController)
	{
		this.baseController = baseController;
		botPilot = baseController.getEV3().getPilot();
		chatbotTwitter = TwitterFactory.getSingleton();
	}
	public void sendTweet(String tweet)
	{
		if(botPilot.getMovement().getDistanceTraveled()<3350)
		{
			try 
			{
				chatbotTwitter.updateStatus("My robot is doing the long drive  @codyhenrichsen #LegoRobotTweeting");
			} 
			catch (TwitterException error) 
			{
		}
		
		}
		else
		{
		try 
		{
			chatbotTwitter.updateStatus("My robot is doing the short drive  @codyhenrichsen #LegoRobotTweeting");
		} 
		catch (TwitterException error) 
		{
	}
		}
}
	}
