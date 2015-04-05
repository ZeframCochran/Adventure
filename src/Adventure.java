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
	static final int NUMBER_OF_ATTRIBUTES = 6;

	//Same here
	static final int NUMBER_OF_ITEMS = 3;
	static final int NUMBER_OF_PROPERTIES = 3;
	
	//Labels to use for our character's status array
	static final int NUMBER_OF_CHARACTER_ATTRIBUTES = 2;
	//Our character
	public static String[] character = new String[NUMBER_OF_CHARACTER_ATTRIBUTES];
	
	//Our map, defined here outside of any method, so we can access it inside all of them.
	public static String[][] rooms = new String[NUMBER_OF_ROOMS][NUMBER_OF_ATTRIBUTES];

	//Items that can be LOOKed at otherwise interacted with.
	public static String[][] items = new String[NUMBER_OF_ITEMS][NUMBER_OF_PROPERTIES];


	//Constants to give us cleaner naming instead of using numbers to index our arrays
	static final int NAME = 0;
	static final int DESCRIPTION = 1;
	static final int EXITS = 2;
	static final int ITEMS = 3;
	static final int ROW = 4;
	static final int COLUMN = 5;
	
	
	//Labels for items
	static final int COINS = 0;
	static final int MACHINE = 1;
	
	//Labels for rooms
	static final int BEDROOM = 0;
	static final int HALLWAY = 1;
	static final int GALLEY = 2;
	static final int ELEVATOR = 3;
	static final int OFFICE = 4;
	
	//Labels for our character array
	static final int INVENTORY = 1;
	
	//For keeping track of our current position on the map.
	static String currentRoom = "bedroom";
	
	static boolean gameOver = false;
	static String introduction = "You awaken in a place with hard metal floors, keenly aware that if you dont find a way to pay the oxygen tax on the space station, you will be ejected into the vacuum of space."
			+"\n You had better LOOK around.";
	public static Scanner kb = new Scanner(System.in);
	
	//First we create the map in the computer memory, then prompt the user for input repeatedly to take in commands.
	public static void main(String[] args){
		createMap();
		
		System.out.println(introduction);
		while(!gameOver){
			String command = kb.nextLine();
			if(command.contains(" ")){
				String target = command.substring(command.indexOf(" ") + 1, command.length());
				command = command.substring(0, command.indexOf(" "));
				doCommand(command, target);
			}
			else{
				doCommand(command);
			}
		}
	}


	private static void createMap() {
		//Bedroom descriptions
		rooms[BEDROOM][NAME] = "bedroom";
		rooms[BEDROOM][DESCRIPTION] = "You appear to be in the station maintenance tunnels, which is good because you cant afford anything else.\nBelow you, an emergency ESCAPE POD hangs in the vacuum of space, a cylinder meant to contain a single human body"
				+"\nYou shudder to think of staying inside one on these unheated metal coffins for days or weeks on end, waiting for rescue."
				+"\nYour earpiece speaks in a tinny voice: Today is your job interview. You had better GO. The computer suggests you GO into the HALLWAY.";
		rooms[BEDROOM][EXITS] = "Hallway";
		rooms[BEDROOM][ITEMS] = "";
		rooms[BEDROOM][ROW] = "0";
		rooms[BEDROOM][COLUMN] = "0";
		
		//Hallway Description
		rooms[HALLWAY][NAME] = "hallway";
		rooms[HALLWAY][DESCRIPTION] = "It stinks in here..like windex mixed with almonds. The stench of toves. Blind man-eating beetles the size of elizabeth-bears. "
				+"\nYou remind yourself that this was the only station that would take you, after you were caught experimenting.."
				+"\nNo time for that now. You are filthy from six weeks hiding in the maintenance shafts. "
				+"\nWait...Is that?..COINS on the floor! GET them and go to the GALLEY for some clean clothes.";
		rooms[HALLWAY][EXITS] = "BEDROOM, GALLEY";
		rooms[HALLWAY][ITEMS] = "COINS";
		rooms[HALLWAY][ROW] = "0";
		rooms[HALLWAY][COLUMN] = "1";
		
		//Galley
		rooms[GALLEY][NAME] = "galley";
		rooms[GALLEY][DESCRIPTION] = "The center of the cyllindrical space station, A vending MACHINE promises cheap paper clothes for the destitute. "
				+"\nPUT the COINS in to make yourself appear less insane.";
		rooms[GALLEY][EXITS] = "HALLWAY, ELEVATOR";
		rooms[GALLEY][ITEMS] = "vending MACHINE";
		rooms[GALLEY][ROW] = "0";
		rooms[GALLEY][COLUMN] = "2";
		
		//Elevator
		rooms[ELEVATOR][NAME] = "elevator";
		rooms[ELEVATOR][DESCRIPTION] =  "In this elevator is an altar to the dead crew of another ship."
				+"\nOverrun with toves, the captain loaded the crew into escape pods and shot them into the void, towards farpoint station. There werent enough pods for everyone."
				+"\nA dedication is hung below her photograph:"
				+"\n\t'Twas brillig, and the slithy toves"
				+"\n\tDid gyre and gimble in the wabe;"
				+"\n\tAll mimsy were the borogoves,"
				+"\n\tAnd the mome raths outgrabe."
				+"-In memory of the valiant Sarah Monette";
		rooms[ELEVATOR][EXITS] = "GALLEY, OFFICE";
		rooms[ELEVATOR][ITEMS] = "PLAQUE";
		rooms[ELEVATOR][ROW] = "0";
		rooms[HALLWAY][COLUMN] = "3";

		//Office
		rooms[OFFICE][NAME] = "office";
		rooms[OFFICE][DESCRIPTION] = "The door opens to reveal a pale man with a cruel and disturbing smile, behind a desk. You sit."
				+"\nYou pretend at negotiating for the job, but you both know it is either this or the void."
				+"\nHe is offering to let you do medical research again, you reflect that it is probably something unethical, given your last job, you have gained an unfavourable reputation."
				+"\nHe offers a modest salary and a free ride to another station when the job is done, but you arent convinced yet."
				+"\nYou make your terms known: Nothing unethical. No research on sentient beings, no harm done to the living."
				+"\nHis smile is still disturbing. He says the patient is a dead spaceship, made of flesh."
				+"\nYou grew up on one of these, a boojem, but the ships live so long everyone thinks that they are immortal."
				+"\nYou are hired. You are saved. (You are doomed.)";
		rooms[OFFICE][EXITS] = "ELEVATOR";
		rooms[OFFICE][ITEMS] = "";
		rooms[OFFICE][ROW] = "0";
		rooms[OFFICE][COLUMN] = "4";

		
		items[COINS][NAME] = "coins";
		items[COINS][DESCRIPTION] = "ugh, greasy station tokens. Worthless elsewhere. Someone probably dropped them rather than carry them.";
		
		items[MACHINE][NAME] = "machine";
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
			case "get":
				if(target.length() > 0){
					get(target);
				}
				else{
					System.out.println("GET what?");
				}
				break;
			case "put":
				if(target.length() > 0){
					
				}
			default:
				System.out.println("Sorry, that isnt a command.");
		}
	}
	
	//Move our character to an x and y position
	public static void move(String destination){
		boolean found = false;
		for(int room = 0; room < rooms.length; room++){
			if(rooms[room][NAME].equalsIgnoreCase(destination)){
				currentRoom = destination;
				found = true;
			}
		}
		if(!found){
			System.out.println("Sorry, that room was not found:"+destination);
		}
		else{
			look();
		}
		
	}

	private static int getRoomNumber(String destination) {
		for(int roomNum = 0; roomNum < rooms.length ; roomNum++){
			if(destination.equalsIgnoreCase(rooms[roomNum][NAME])){
				return roomNum;
			}
		}
		System.out.println("Couldnt find that room.");
		return -1;
	}


	//Prints the description of the item you are LOOKing at
	public static void look(String item){
		for(int itemNum = 0; itemNum < items.length ; itemNum++){
			if(item.equalsIgnoreCase(items[itemNum][NAME])){
				System.out.println(items[itemNum][DESCRIPTION]);
			}
		}
	}

	//Returns the description of the room
	public static void look(){
		int CURRENT_ROOM_INDEX = getRoomNumber(currentRoom);
		System.out.println(rooms[CURRENT_ROOM_INDEX][DESCRIPTION]);
		
		if(rooms[CURRENT_ROOM_INDEX][ITEMS].length() > 0){
			System.out.println("Items: "+rooms[CURRENT_ROOM_INDEX][ITEMS]);
		}
		
		System.out.println("Exits: " + rooms[CURRENT_ROOM_INDEX][EXITS]);
		
	}

	//Add the item to our inventory, if it is in the room.
	public static void get(String item){
		character[INVENTORY] += ", "+item;
		System.out.println("Added "+item+" to the inventory.");
	}
	
	public static void put(String item){
		character[INVENTORY] = character[INVENTORY].replace(item, "");
		System.out.println("Removed " +item+" from the inventory");
	}
}
