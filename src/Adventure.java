/**
Template for the game programming assignment
Jerod Ewert
3/26/2015

Story based on The Wreck of the Charles Dexter Ward pt. 1  by  Elizabeth Bear and Sarah Monette
 */
public class Adventure{
	//These will be used to determine how much space is needed in the array.
	static final int NUMBER_OF_ROOMS = 8;
	static final int NUMBER_OF_ATTRIBUTES = 4;
	
	public static String[][] map = new String[NUMBER_OF_ROOMS][NUMBER_OF_ATTRIBUTES];
	
	//Variables to describe the results of actions

	//Variables to track the state of our hero/heroine

	//methods
	public static void main(String[] args){
		createMap();
		while(true){
			look("bed");
			getCommands("");
		}
	}

	private static void createMap() {
		//Constants to facilitate clean naming
		final int DESCRIPTION = 0;
		final int EXITS = 1;
		final int ITEMS = 2;
		final int COORDINATES = 3;
		
		//Room descriptions
		final int BEDROOM = 0;	
		String bedDescription = "You awaken in a place with hard metal floors, keenly aware that if you dont find a way to pay the oxygen tax on the space station, you will be ejected into the vacuum of space.\n You had better LOOK around.";
		String bedExits = "Hallway";
		String bedItems = "";
		String bedCoordinates = "0,0";
		
		map[BEDROOM][DESCRIPTION] = bedDescription;
		final int CRAWLSPACE = 2;
		String crawlSpaceDescription = "You appear to be in the station maintenance tunnels, which is good because you cant afford anything else.\nBelow you, an emergency ESCAPE POD hangs in the vacuum of space, a cylinder meant to contain a single human body"
				+"\nYou shudder to think of staying inside one on these unheated metal coffins for days or weeks on end, waiting for rescue."
				+"\nYour earpiece speaks in a tinny voice: Today is your job interview. You had better go. The computer suggests you use the HALLWAY.";

		String hallwayDescription = "It stinks in here..like windex mixed with almonds. The stench of toves. Blind man-eating beetles the size of elizabeth-bears. You remind yourself that this was the only station that would take you, after you were caught experimenting.."
				+"\nNo time for that now. You are filthy from six weeks hiding in the maintenance shafts. "
				+"\nWait...Is that?..COINS on the floor! GET them and go to the GALLEY for some clean clothes.";

		String galleyDescription = "The center of the cyllindrical space station. A vending MACHINE promises cheap paper clothes for the destitute. PUT the COINS in to make yourself appear less insane.";

		String hallwayTwoDescription = "This section of the station is an altar to the dead crew of another ship. Overrun with toves, the captain loaded the crew into escape pods and shot them into the void, towards farpoint station. There werent enough pods for everyone."
				+"\nA dedication hung below her photograph:"
				+"\n'Twas brillig, and the slithy toves"
				+"Did gyre and gimble in the wabe;"
				+"All mimsy were the borogoves,"
				+"And the mome raths outgrabe."
				+"-In memory of the valiant Sarah Monette";

		String hiringOfficeDescription = "The door opens to reveal a pale man with a cruel and disturbing smile, behind a desk. You sit."
				+"\nYou pretend at negotiating for the job, but you both know it is either this for a vacuum nap."
				+"\nHe is offering to let you do medical research again, probably something unethical"
				+"\nHe offers a modest salary and a free ride to another station when the job is done."
				+"\nHe says the patient is a dead spaceship, made of flesh";

		//Items that can be LOOKed at
		String coinDesc = "";
		String machineDesc = "";


	}

	//Take user input, trigger the doCommand method
	public static void getCommands(String command){
		String target="";
		int spaceIndex = command.indexOf(" ");
		if(spaceIndex > 0){
			command = command.substring(0 , spaceIndex);
			target = command.substring(spaceIndex+1,command.length());
		}
		command = command.toLowerCase();
		switch(command){
		case "look":
			if(target.length() > 0){
				look(target);
			}
			else{
				look();
			}
			break;
		case "go":
		if(target.length() > 0){
			move(target);
		}
		else{
			System.out.println("Where to?");
		}
		break;

		}
	}
	//String[] bedRoom = {"name", "Desc", "items", "exits"}
	//Move our character to an x and y position
	public static void move(String destination){}

	//Returns the description of the item you are LOOKing at
	public static void look(String item){}

	//Returns the description of the room
	public static void look(){}

	//
	public static void get(String item){}
}
