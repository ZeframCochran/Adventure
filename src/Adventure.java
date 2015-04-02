/**
Template for the game programming assignment
Jerod Ewert
3/26/2015

Story based on The Wreck of the Charles Dexter Ward pt. 1  by  Elizabeth Bear and Sarah Monette
*/
public class Adventure{
  //Room descriptions
  String bedDescription = "You awaken in a place with hard metal floors, keenly aware that if you dont find a way to pay the oxygen tax on the space station, you will be ejected into the vacuum of space.\n You had better LOOK around.";

  String crawlSpaceDescription = "You appear to be in the station maintenance tunnels, which is good because you cant afford anything else.\nBelow you, an emergency ESCAPE POD hangs in the vacuum of space, a cylinder meant to contain a single human body
\nYou shudder to think of staying inside one on these unheated metal coffins for days or weeks on end, waiting for rescue.
\nYour earpiece speaks in a tinny voice: Today is your job interview. You had better go. The computer suggests you use the HALLWAY.";

  String hallwayDescription = "It stinks in here..like windex mixed with almonds. The stench of toves. Blind man-eating beetles the size of elizabeth-bears. You remind yourself that this was the only station that would take you, after you were caught experimenting..
\nNo time for that now. You are filthy from six weeks hiding in the maintenance shafts. 
\nWait...Is that?..COINS on the floor! GET them and go to the GALLEY for some clean clothes.";

  String galleyDescription = "The center of the cyllindrical space station. A vending MACHINE promises cheap paper clothes for the destitute. PUT the COINS in to make yourself appear less insane.";

  String hallwayTwoDescription = "This section of the station is an altar to the dead crew of another ship. Overrun with toves, the captain loaded the crew into escape pods and shot them into the void, towards farpoint station. There werent enough pods for everyone."
+"\nA dedication hung below her photograph:"
+"\n'Twas brillig, and the slithy toves"
+"Did gyre and gimble in the wabe;"
+"All mimsy were the borogoves,"
+"And the mome raths outgrabe."
+"-In memory of the valiant Sarah Monette";

  String hiringOfficeDescription = "The door opens to reveal a pale man with a cruel and disturbing smile, behind a desk. You sit.
\nYou pretend at negotiating for the job, but you both know it is either this for a vacuum nap.
\nHe is offering to let you do medical research again, probably something unethical
\nHe offers a modest salary and a free ride to another station when the job is done.
\nHe says the patient is a dead spaceship, made of flesh";
  
	//Items that can be LOOKed at
  String coinDesc = "";
  String machineDesc = "";

	//Variables to describe the results of actions
  
	//Variables to track the state of our hero/heroine

	//methods
	public static void main(String[] args){}

	//Take user input, trigger the doCommand method
	public static void getCommands(){}

	//Given a command from the user, call the correct function with the needed parameters
	public static void doCommand(String command){}

	//Given an X and Y position return which room the character is in.
	public static void getRoom(int xPos, int yPos){}

	//Move our character to an x and y position
	public static String move(int x, int y){}

	//Returns the description of the item you are LOOKing at
	public static void look(String item){}

	//Returns the description of the room
	public static void look(){}

	//
	public static void get(String item){}
}
