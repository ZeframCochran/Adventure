/**
Template for the game programming assignment
Jerod Ewert
3/26/2015

Story based on The Wreck of the Charles Dexter Ward pt. 1  by  Elizabeth Bear and Sarah Monette
 */

import java.util.Scanner;

public class AdventureShell {
	public static Scanner kb = new Scanner(System.in);
	
	//These will be used to determine how much space is needed in the array.
	static final int NUMBER_OF_ROOMS = 2;
	static final int NUMBER_OF_ATTRIBUTES = 6;

	//Same here
	static final int NUMBER_OF_ITEMS = 1;
	static final int NUMBER_OF_PROPERTIES = 3;
	
	//Labels to use for our character's array
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
	
	
	//Labels for items
	static final int COINS = 0;
	
	//Labels for rooms
	static final int BEDROOM = 0;
	static final int HALLWAY = 1;
	
	//Labels for our character array
	static final int INVENTORY = 1;
	
	//For keeping track of our current position on the map.
	static String currentRoom = "bedroom";
	
	static boolean gameOver = false;
	static String introduction = "You wake in a place with hard metal floors, keenly aware that if you dont find a way to pay the oxygen tax on the space station, you will be ejected into the vacuum of space."
			+"\n You had better LOOK around.";
	
	//First we create the map in the computer memory, then prompt the user for input repeatedly to take in commands.
	public static void main(String[] args){
		createMap();
		
		System.out.println(introduction);
		while(!gameOver){
			getCommand();
		}
	}


	//Get commands as strings, I prompt the user with a ">"
	private static void getCommand() {
		System.out.print("> ");
		String command = kb.nextLine();
		//this only happens if they typed at least two words:
		if(command.contains(" ")){
			String[] input = command.split(" ");
			command = input[0];
			String target = input[1];
			
			doCommand(command, target);
		}
		else{
			doCommand(command);
		}
	}


	private static void createMap() {
		//Bedroom descriptions
		rooms[BEDROOM][NAME] = "bedroom";
		rooms[BEDROOM][DESCRIPTION] = "You appear to be in the station maintenance tunnels, which is good because you cant afford anything else.\n";
		rooms[BEDROOM][EXITS] = "Hallway";
		rooms[BEDROOM][ITEMS] = "";
		
		//Hallway Description
		rooms[HALLWAY][NAME] = "hallway";
		rooms[HALLWAY][DESCRIPTION] = "A boring hallway."
				+"\nWait...Is that?..COINS on the floor! GET them and go to the GALLEY for some clean clothes.";
		rooms[HALLWAY][EXITS] = "BEDROOM, GALLEY";
		rooms[HALLWAY][ITEMS] = "COINS";
	}

	//If they didnt type a target, pass a blank one.
	private static void doCommand(String command) {
		doCommand(command, "");
	}

	//Trigger the matching function.
	public static void doCommand(String command, String target){
		command = command.toLowerCase();
		target = target.toLowerCase();
		
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
			default:
				System.out.println("Sorry, that isnt a command.");
		}
	}
	
	//Move our character to a destination
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
		}
		
	}

	//Looks through the rooms and returns the index of our destination.
	private static int getRoomNumber(String destination) {
		return index;
	}


	//Prints the description of the item you are LOOKing at
	public static void look(String item){
		for(int itemNum = 0; itemNum < items.length ; itemNum++){
			if(item.equalsIgnoreCase(items[itemNum][NAME])){
				System.out.println(items[itemNum][DESCRIPTION]);
			}
		}
	}

	//Prints the description of the room, the items list, and the exits list.
	public static void look(){
		int CURRENT_ROOM_INDEX = getRoomNumber(currentRoom);
	}

	//Add the item to our inventory, if it is in the room.
	public static void get(String item){
	}
	
	//Remove the item from our inventory
	public static void put(String item){
	}
}
