import java.util.Scanner;

/**
Template for the game programming assignment
Jerod Ewert
3/26/2015

Story based on The Wreck of the Charles Dexter Ward pt. 1  by  Elizabeth Bear and Sarah Monette
 */
public class Adventure{
	//These will be used to determine how much space is needed in the array.
	static final int NUMBER_OF_ROOMS = 5;
	static final int NUMBER_OF_ATTRIBUTES = 4;

	public static String[][] map = new String[NUMBER_OF_ROOMS][NUMBER_OF_ATTRIBUTES];

	//Constants to give us cleaner naming instead of using numbers to index our arrays
	static final int DESCRIPTION = 0;
	static final int EXITS = 1;
	static final int ITEMS = 2;
	static final int COORDINATES = 3;

	static int CURRENT_ROOM = 0;
	
	
	static boolean gameOver = false;
	static String introduction = "You awaken in a place with hard metal floors, keenly aware that if you dont find a way to pay the oxygen tax on the space station, you will be ejected into the vacuum of space."
			+"\n You had better LOOK around.";
	public static Scanner kb = new Scanner(System.in);
	
	//methods
	public static void main(String[] args){
		createMap();
		
		System.out.println(introduction);
		while(!gameOver){
			String command = kb.nextLine();
			if(command.contains(" ")){
				String target = command.substring(command.indexOf(" ") - 1, command.length());
				doCommand(command, target);
			}
			else{
				doCommand(command);
			}
		}
	}


	private static void createMap() {
		//Room descriptions
		final int BEDROOM = 0;	
		map[BEDROOM][DESCRIPTION] = "You appear to be in the station maintenance tunnels, which is good because you cant afford anything else.\nBelow you, an emergency ESCAPE POD hangs in the vacuum of space, a cylinder meant to contain a single human body"
				+"\nYou shudder to think of staying inside one on these unheated metal coffins for days or weeks on end, waiting for rescue."
				+"\nYour earpiece speaks in a tinny voice: Today is your job interview. You had better go. The computer suggests you MOVE into the HALLWAY.";
		map[BEDROOM][EXITS] = "Hallway";
		map[BEDROOM][ITEMS] = "";
		map[BEDROOM][COORDINATES] = "0,0";
		
		//Hallway Description
		final int HALLWAY = 1;
		map[HALLWAY][DESCRIPTION] = "It stinks in here..like windex mixed with almonds. The stench of toves. Blind man-eating beetles the size of elizabeth-bears. You remind yourself that this was the only station that would take you, after you were caught experimenting.."
				+"\nNo time for that now. You are filthy from six weeks hiding in the maintenance shafts. "
				+"\nWait...Is that?..COINS on the floor! GET them and go to the GALLEY for some clean clothes.";
		map[HALLWAY][EXITS] = "BEDROOM, GALLEY";
		map[HALLWAY][ITEMS] = "COINS";
		map[HALLWAY][COORDINATES] = "0,1";
		
		//Galley
		final int GALLEY = 2;
		map[GALLEY][DESCRIPTION] = "The center of the cyllindrical space station, A vending MACHINE promises cheap paper clothes for the destitute. "
				+"\nPUT the COINS in to make yourself appear less insane.";
		map[GALLEY][EXITS] = "HALLWAY, ELEVATOR";
		map[GALLEY][ITEMS] = "vending MACHINE";
		map[GALLEY][COORDINATES] = "0,2";

		//Elevator
		final int ELEVATOR = 3;
		map[ELEVATOR][DESCRIPTION] =  "In this elevator is an altar to the dead crew of another ship."
				+"\nOverrun with toves, the captain loaded the crew into escape pods and shot them into the void, towards farpoint station. There werent enough pods for everyone."
				+"\nA dedication is hung below her photograph:"
				+"\n\t'Twas brillig, and the slithy toves"
				+"\n\tDid gyre and gimble in the wabe;"
				+"\n\tAll mimsy were the borogoves,"
				+"\n\tAnd the mome raths outgrabe."
				+"-In memory of the valiant Sarah Monette";
		map[ELEVATOR][EXITS] = "GALLEY, OFFICE";
		map[ELEVATOR][ITEMS] = "PLAQUE";
		map[ELEVATOR][COORDINATES] = "";

		//Office
		final int OFFICE = 4;
		map[OFFICE][DESCRIPTION] = "The door opens to reveal a pale man with a cruel and disturbing smile, behind a desk. You sit."
				+"\nYou pretend at negotiating for the job, but you both know it is either this or the void."
				+"\nHe is offering to let you do medical research again, you reflect that it is probably something unethical, given your last job, you have gained an unfavourable reputation."
				+"\nHe offers a modest salary and a free ride to another station when the job is done, but you arent convinced yet."
				+"\nYou make your terms known: Nothing unethical. No research on sentient beings, no harm done to the living."
				+"\nHis smile is still disturbing. He says the patient is a dead spaceship, made of flesh."
				+"\nYou grew up on one of these, a boojem, but the ships live so long everyone thinks that they are immortal."
				+"\nYou are hired. You are saved. (You are doomed.)";
		map[OFFICE][EXITS] = "ELEVATOR";
		map[OFFICE][ITEMS] = "";
		map[OFFICE][COORDINATES] = "0,3";

		//Items that can be LOOKed at
		final int NUMBER_OF_ITEMS = 3;
		final int NUMBER_OF_PROPERTIES = 3;
		String [][] items = new String[NUMBER_OF_ITEMS][NUMBER_OF_PROPERTIES];
		
		//Labels
		final int COINS = 0;
		final int MACHINE = 1;
		items[COINS][DESCRIPTION] = "ugh, greasy station tokens. Worthless elsewhere. Someone probably dropped them rather than carry them.";
		items[MACHINE][DESCRIPTION] = "Cheap vending machine with dents and graffiti. A graphic well-groomed people in clean white outfits mocks you with their smiles. PUT the COINS in the machine so we can get out of here.";

	}

	
	//Take user input, trigger the doCommand method
	private static void doCommand(String command) {
		doCommand(command, "");
	}

	public static void doCommand(String command, String target){
		command = command.toLowerCase();
		target.toLowerCase();
		
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
	
	//Move our character to an x and y position
	public static void move(String destination){
		CURRENT_ROOM = getRoomNumber(destination);
	}

	private static int getRoomNumber(String destination) {
		// TODO Auto-generated method stub
		return 0;
	}


	//Prints the description of the item you are LOOKing at
	public static void look(String item){
		for(int itemNum = 0; itemNum < items.length() ; itemNum++){
			
		}
	}

	//Returns the description of the room
	public static void look(){
		System.out.println(map[CURRENT_ROOM][DESCRIPTION]);
		
		if(map[CURRENT_ROOM][ITEMS].length() > 0){
			System.out.println(map[CURRENT_ROOM][ITEMS]);
		}
		
		System.out.println("Exits: " + map[CURRENT_ROOM][EXITS]);
		
	}

	//
	public static void get(String item){
		
	}
}
