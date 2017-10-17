package GCPUApp;
/*to do:
    formatting in backpack for getContents
    save & restore check according to class code
    extra credit 2
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class GCPUApp {

    public static void main(String[] args) {
        new GCPUApp();
    }
    // Declare Variables
    boolean loop = true;
    int row = 3;
    int column = 0;
    int floor = 0;
    String input2;
    boolean entered = true;
    Scanner keyboard = new Scanner(System.in);
    
    //Create an instance of the map
    Map map = new Map();
    Room room;
    Backpack backpack = new Backpack();

    GCPUApp() {

        //Begin dialog
        System.out.print("Welcome to the Great Cal Poly Underground! ");
        System.out.println("Version 2.0 \n");
        
        String input;
        while (loop) {
            //Add shortcut to make it easier 
            room = map.rooms[floor][row][column];
            
            //If enter a new room
            if (entered == true) {
                System.out.println("You have entered the " + room.name);
                System.out.println(room.roomDescription);

                //Print room openings
                if (room.exits.length > 1) {
                    System.out.print("You see openings to the ");
                    System.out.print(room.getExits().toLowerCase() + ".");
                    System.out.println(" ");
                } else if ((room.exits.length == 1) && room.isValidExit("w")) {
                    System.out.println("You see an opening to the west.");
                } else if ((room.exits.length == 1) && room.isValidExit("e")) {
                    System.out.println("You see an opening to the east.");
                } else if ((room.exits.length == 1) && room.isValidExit("n")) {
                    System.out.println("You see an opening to the north.");
                } else if ((room.exits.length == 1) && room.isValidExit("s")) {
                    System.out.println("You see an opening to the south.");
                }
            }

            //If you enter the Bus Stop
            if (room == map.rooms[1][0][2]) {
                Random rnd = new Random();

                int[] floorChoice = {0, 1};
                int[] rowAndColChoice = {0, 1, 2, 3};

                int randFloor = rnd.nextInt(floorChoice.length - 1);
                int randRow = rnd.nextInt(rowAndColChoice.length - 1);
                int randCol = rnd.nextInt(rowAndColChoice.length - 1);

                floor = randFloor;
                row = randRow;
                column = randCol;

                while (room == null) {
                    randFloor = rnd.nextInt(floorChoice.length - 1);
                    randRow = rnd.nextInt(rowAndColChoice.length - 1);
                    randCol = rnd.nextInt(rowAndColChoice.length - 1);

                    floor = randFloor;
                    row = randRow;
                    column = randCol;
                }
                System.out.println("You have been teleported to another room." + "\n");
                System.out.println("You have entered the " + room.name);
                System.out.println(room.roomDescription);
                //Print room openings
                if (room.exits.length> 1) {
                    System.out.print("You see openings to the ");
                    System.out.print(room.getExits().toLowerCase() + ".\n");
                } else if ((room.exits.length == 1) && room.isValidExit("w")) {
                    System.out.println("You see an opening to the west.");
                } else if ((room.exits.length == 1) && room.isValidExit("e")) {
                    System.out.println("You see an opening to the east.");
                } else if ((room.exits.length == 1) && room.isValidExit("n")) {
                    System.out.println("You see an opening to the north.");
                } else if ((room.exits.length == 1) && room.isValidExit("s")) {
                    System.out.println("You see an opening to the south.");
                }
            }

            //Get input
            System.out.println("");
            System.out.print("> ");
            input = keyboard.nextLine();
            //Check if directions are valid
            if (input.equalsIgnoreCase("e")) {
                if (room.isValidExit("e")) {
                    column++;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } else if (input.equalsIgnoreCase("w")) {
                if (room.isValidExit("w")) {
                    entered = true;
                    column--;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } else if (input.equalsIgnoreCase("s")) {
                if (room.isValidExit("s")) {
                    row++;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } else if (input.equalsIgnoreCase("n")) {
                if (room.isValidExit("n")) {
                    row--;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } else if (input.equalsIgnoreCase("sw")) {
                if (room.isValidExit("sw")) {
                    column--;
                    row++;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } else if (input.equalsIgnoreCase("nw")) {
                if (room.isValidExit("nw")) {
                    column--;
                    row--;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } else if (input.equalsIgnoreCase("se")) {
                if (room.isValidExit("se")) {
                    column++;
                    row++;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } else if (input.equalsIgnoreCase("ne")) {
                if (room.isValidExit("ne")) {
                    column--;
                    row--;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } else if (input.equalsIgnoreCase("up")) {
                if (room.isValidExit("up")) {
                    floor++;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }

            } else if (input.equalsIgnoreCase("down")) {
                if (room.isValidExit("down")) {
                    floor--;
                    entered = true;
                } else {
                    System.out.println("You cannot move in this direction.");
                    entered = false;
                }
            } //Look command
            else if (input.equalsIgnoreCase("look")) {
                //Print room name
                System.out.println(room.name);

                //Print room description
                System.out.println(room.roomDescription);

                //Print exits
                if (room.exits.length > 1) {
                    System.out.print("You see openings to the ");
                    System.out.print(room.getExits().toLowerCase() + ".");
                    System.out.print(" ");
                    entered = false;
                } else if ((room.exits.length == 1) && room.isValidExit("w")) {
                    System.out.print("You see an opening to the west.");
                    entered = false;
                } else if ((room.exits.length == 1) && room.isValidExit("e")) {
                    System.out.print("You see an opening to the east.");
                    entered = false;
                } else if ((room.exits.length == 1) && room.isValidExit("n")) {
                    System.out.print("You see an opening to the north.");
                    entered = false;
                } else if ((room.exits.length == 1) && room.isValidExit("s")) {
                    System.out.print("You see an opening to the south.");
                    entered = false;
                }

                //Print artifacts
                System.out.println("");
                if (room.artifacts != null) {
                    if (room.artifacts.size() == 5) {
                        System.out.print("You see ");
                        System.out.print(room.artifacts.get(0).name + "," + room.artifacts.get(1).name + "," +  room.artifacts.get(2).name  + "," + room.artifacts.get(3).name + ", and " + room.artifacts.get(4).name + ".");
                    } 
                    else if (room.artifacts.size() == 4) {
                        System.out.print("You see ");
                        System.out.print(room.artifacts.get(0).name + "," + room.artifacts.get(1).name + "," +  room.artifacts.get(2).name + ", and" + room.artifacts.get(3).name + ".");
                    }
                    else if (room.artifacts.size() == 3) {                        
                        System.out.print("You see ");
                        System.out.print(room.artifacts.get(0).name + "," + room.artifacts.get(1).name + ", and" +  room.artifacts.get(2).name + ".") ;
                        entered = false;
                    } else if (room.artifacts.size() == 2)  {
                        System.out.print("You see ");
                        System.out.print(room.artifacts.get(0).name + " and " + room.artifacts.get(1).name + ".");
                        entered = false;
                    }
                    else if (room.artifacts.size() == 1) {
                        System.out.println("You see " + room.artifacts.get(0).name + ".");
                        entered = false;
                    } else {
                        System.out.println("The room is empty.");
                        entered = false;
                    }
                } else {
                    System.out.println("The room is empty.");
                    entered = false;
                }

            } //Touch command
            else if (input.equalsIgnoreCase("touch")) {
                //If room is empty
                if (room.artifacts == null) {
                    System.out.println("There is nothing to touch in the room.");
                } //If more than two items
                else if (room.artifacts.size() > 1) {
                    System.out.println("Which artifact would you like to touch");
                    for (int i = 0; i < room.artifacts.size(); i++) {
                        int value1 = i + 1;
                        System.out.print(value1 + ". ");
                        System.out.print(room.artifacts.get(i).name + "\n");

                    }
                    System.out.println("Enter an integer listed above.");
                    //Get user's choice
                    int choice1 = 0;
                    boolean choice1Valid = false;
                    while (!choice1Valid) {
                        try {
                            choice1 = Integer.parseInt(keyboard.nextLine());
                            while (choice1 > room.artifacts.size() || choice1 < 1) {
                                System.out.println("You have entered an invalid input. Please try again.");
                                choice1 = Integer.parseInt(keyboard.nextLine());
                            }
                            choice1Valid = true;
                        } catch (Exception e) {
                            System.out.println("You have entered an invalid input. Please try again.");
                            System.out.print("> ");
                        }
                    }
                    int last1 = choice1 - 1;
                    System.out.println(room.artifacts.get(last1).touch());
                    entered = false;
                } //For rooms with one item
                else {
                    System.out.print(room.artifacts.get(0).touch());
                    entered = false;
                }
            } //Examine command
            else if (input.equalsIgnoreCase("examine")) {
                //If room is empty 
                if (room.artifacts == null) {
                    System.out.println("There is nothing to examine in the room.");
                } //For more than two items
                else if (room.artifacts.size() > 1) {
                    System.out.println("Which artifact would you like to examine");
                    for (int i = 0; i < room.artifacts.size(); i++) {
                        int value2 = i + 1;
                        System.out.print(value2 + ". ");
                        System.out.print(room.artifacts.get(i).name + "\n");

                    }
                    System.out.println("Enter an integer listed above.");

                    //Get what they want to examine
                    int choice2;
                    int last = 0;
                    boolean choice2Valid = false;
                    while (!choice2Valid) {
                        try {
                            choice2 = Integer.parseInt(keyboard.nextLine());
                            while (choice2 > room.artifacts.size() || choice2 < 0) {
                                System.out.println("You have entered an invalid input. Please try again.");
                                choice2 = Integer.parseInt(keyboard.nextLine());
                            }
                            last = choice2 - 1;
                            choice2Valid = true;
                        } catch (Exception e) {
                            System.out.println("You have entered an invalid input. Please try again.");
                            System.out.print("> ");
                        }
                        System.out.println(room.artifacts.get(last).examine());
                    } //For rooms with one item
                } else {
                    System.out.print(room.artifacts.get(0).examine());
                }
                entered = false;
            } //Exit the loop
            else if (input.equals("restore")) {
                restore();
            } else if (input.equals("save")) {
                save();
            } else if (input.equals("inventory")) {
                inventory();
            } else if (input.equals("take")) {
                take();
            } else if (input.equals("drop")) {
                drop();
            } else if (input.equals("print")) {
                print();
            }
            else if (input.equals("help")) {
                System.out.println("These are the commands you can use");
                System.out.println("1. Save (saves your progress)");
                System.out.println("2. Restore (restores the saved file)");
                System.out.println("3. Inventory (shows your whats in your inventory)");
                System.out.println("4. Drop (drop an item in your inventory)");
                System.out.println("5. Quit (leave the GCPU");
            } else if (input.equalsIgnoreCase("quit")) {
                System.out.print("Do you wish to leave the Cal Poly Underground? (Y/N) > ");
                input2 = keyboard.nextLine();
                //Want to exit
                if (input2.equalsIgnoreCase("y")) {
                    System.out.println("Thank you for visiting the Cal Poly Underground.");
                    loop = false;

                } //Want to continue
                else if (input2.equalsIgnoreCase("n")) {
                    loop = true;
                    entered = false;
                } //Invalid command
                else {
                    boolean endLoop = false;
                    while ((!input2.equalsIgnoreCase("n") && !input2.equalsIgnoreCase("y")) && endLoop == false) {
                        System.out.println("You have entered an invalid input. Please try again. ");
                        System.out.print("Do you wish to leave the Cal Poly Underground? (Y/N) > ");
                        input2 = keyboard.nextLine();

                        if (input2.equalsIgnoreCase("y")) {
                            System.out.println("Thank you for visiting the Cal Poly Underground.");
                            endLoop = true;
                            loop = false;
                        } else if (input2.equalsIgnoreCase("n")) {
                            loop = true;
                            endLoop = true;
                        }
                    }

                }
            } else {
                System.out.println("I do not understand " + "'" + input + "'");
                System.out.println("Please try again.");
                loop = true;
                entered = false;
            }
        }

        keyboard.close();

    }

    void restore() {
        // Declare variables
        String fileName;
        // Where is the file located?
        System.out.println("Where is the text file located?");
        fileName = keyboard.nextLine();

        try {
            // Open requested file
            File file = new File(fileName);
            FileReader reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);

            // Erase old artifacts from the map
            map.rooms[0][0][0].artifacts = null;
            map.rooms[0][0][1].artifacts = null;
            map.rooms[0][0][2].artifacts = null;
            map.rooms[0][0][3].artifacts = null;
            map.rooms[0][1][1].artifacts = null;
            map.rooms[0][1][2].artifacts = null;
            map.rooms[0][1][3].artifacts = null;
            map.rooms[0][2][1].artifacts = null;
            map.rooms[0][2][2].artifacts = null;
            map.rooms[0][2][3].artifacts = null;
            map.rooms[0][3][1].artifacts = null;
            map.rooms[0][3][2].artifacts = null;
            map.rooms[0][3][3].artifacts = null;
            map.rooms[1][0][0].artifacts = null;
            map.rooms[1][0][1].artifacts = null;
            map.rooms[1][0][2].artifacts = null;
            map.rooms[1][0][3].artifacts = null;
            map.rooms[1][1][0].artifacts = null;
            map.rooms[1][1][1].artifacts = null;
            map.rooms[1][1][2].artifacts = null;
            map.rooms[1][1][3].artifacts = null;
            map.rooms[1][2][0].artifacts = null;
            map.rooms[1][2][1].artifacts = null;
            map.rooms[1][2][2].artifacts = null;
            map.rooms[1][2][3].artifacts = null;
            map.rooms[1][3][0].artifacts = null;
            map.rooms[1][3][1].artifacts = null;
            map.rooms[1][3][2].artifacts = null;
            map.rooms[1][3][3].artifacts = null;

            // Begin file processing
            String line = buffer.readLine();
            while (line != null) {
                String[] data = line.split("=|,");
                String key = data[0];
                if (key.equals("StartLocation")) {
                    floor = Integer.parseInt(data[1]);
                    row = Integer.parseInt(data[2]);
                    column = Integer.parseInt(data[3]);
                } else if (key.equals("Artifact")) {
                    String name = data[1];
                    int aFloor = Integer.parseInt(data[2]);
                    int aRow = Integer.parseInt(data[3]);
                    int aCol = Integer.parseInt(data[4]);
                    if (name.equals("lamp")) {
                        
                    } else if (name.equals("pen")) {
                        
                    } else if (name.equals("exam")) {
                        
                    }

                    // continue adding code to process remaining artifacts
                }

                line = buffer.readLine();
            } // while

            buffer.close();
            reader.close();
            System.out.println(room.name);
        } catch (IOException error) {
            System.out.println(error.getLocalizedMessage());
        }
    }//restore

    void save() {
        //add safety feature as mentioned in class
        String filename = "c:/users/heather/desktop/";
        System.out.println("Where would you like to save?");
        //check if file exists first, if file exists ask if they want to save
        String userFileName = keyboard.nextLine();
        filename += userFileName;
        System.out.println(filename);
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);
            PrintWriter pw = new PrintWriter(buffer);
            
            //Save start location
            pw.print("StartLocation=");
            pw.print(floor + ",");
            pw.print(row + ",");
            pw.println(column);

            //Save artifacts locations on map
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[0][0][aCol].artifacts.isEmpty()) {
                    if (map.rooms[0][0][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[0][0][aCol].artifacts.size(); i++) {
                           pw.println("Artifact=" + map.rooms[0][0][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        pw.println("Artifact=" + map.rooms[0][0][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for col[0])
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[0][1][aCol].artifacts.isEmpty()) {
                    if (map.rooms[0][1][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[0][1][aCol].artifacts.size(); i++) {
                           pw.println("Artifact=" + map.rooms[0][1][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        pw.println("Artifact=" + map.rooms[0][1][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for col[1])            
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[0][2][aCol].artifacts.isEmpty()) {
                    if (map.rooms[0][2][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[0][2][aCol].artifacts.size(); i++) {
                           pw.println("Artifact=" + map.rooms[0][2][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        pw.println("Artifact=" + map.rooms[0][2][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for col[2])   
            
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[0][3][aCol].artifacts.isEmpty()) {
                    if (map.rooms[0][3][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[0][3][aCol].artifacts.size(); i++) {
                           pw.println("Artifact=" + map.rooms[0][3][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        pw.println("Artifact=" + map.rooms[0][3][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for col[3])  
                        for (int aCol=0; aCol < 3; aCol++) {
                if(map.rooms[1][0][aCol] != null) {
                    if (!map.rooms[1][0][aCol].artifacts.isEmpty()) {
                       for (int i = 0; i < map.rooms[1][0][aCol].artifacts.size(); i++) {
                           pw.println("Artifact=" + map.rooms[1][0][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        pw.println("Artifact=" + map.rooms[1][0][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for floor[1])
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[1][1][aCol].artifacts.isEmpty()) {
                    if (map.rooms[1][1][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[1][1][aCol].artifacts.size(); i++) {
                           pw.println("Artifact=" + map.rooms[1][1][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        pw.println("Artifact=" + map.rooms[1][1][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for floor[1])            
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[1][2][aCol].artifacts.isEmpty()) {
                    if (map.rooms[1][2][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[1][2][aCol].artifacts.size(); i++) {
                           pw.println("Artifact=" + map.rooms[1][2][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        pw.println("Artifact=" + map.rooms[1][2][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for floor[1])   
            
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[1][3][aCol].artifacts.isEmpty()) {
                    if (map.rooms[1][3][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[1][3][aCol].artifacts.size(); i++) {
                           pw.println("Artifact=" + map.rooms[1][3][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        pw.println("Artifact=" + map.rooms[1][3][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for floor[1])  
            
            //Save contents of the backpack
            //Save states of special artifacts
            
            //Close
            buffer.close();
            writer.close();
        } catch (Exception error) {
            System.out.println(error.getLocalizedMessage());
        }
    } //save
 
    void take() {
                if (backpack.getContentLength() == 2) {
                    System.out.println("Your bag is full you cannot pick up anymore items. You can use drop to drop the last item you picked up. \n");
                }
                else if (room.artifacts == null || room.artifacts.get(0) == null) {
                    System.out.println("The room is empty. You cannot take anything.");
                }
                else if (room.artifacts.size() > 1) {
                    System.out.println("Which artifact would you like to take?");
                    for (int i = 0; i < room.artifacts.size(); i++) {
                        int value1 = i + 1;
                        System.out.print(value1 + ". ");
                        System.out.print(room.artifacts.get(i).name + "\n");

                    }
                    System.out.println("Enter an integer listed above.");
                    int choiceTake = 0;
                    boolean choiceTakeValid = false;
                    while (!choiceTakeValid) {
                        try {
                            choiceTake = Integer.parseInt(keyboard.nextLine());
                            while (choiceTake > room.artifacts.size() || choiceTake < 1) {
                                System.out.println("You have entered an invalid input. Please try again.");
                                choiceTake = Integer.parseInt(keyboard.nextLine());
                            }
                            choiceTakeValid = true;
                        } catch (Exception e) {
                            System.out.println("You have entered an invalid input. Please try again.");
                            System.out.print("> ");
                        }
                    }
                    int lastTake = choiceTake - 1;
                    backpack.setArtifact(room.artifacts.get(lastTake));
                    System.out.println("[" + backpack.getArtifact(backpack.getContentLength()) + "] " + "taken");
                    room.artifacts.remove(lastTake);
                }
                else {
                    backpack.setArtifact(room.artifacts.get(0));
                    System.out.println("[" + backpack.getArtifact(backpack.getContentLength()) + "] " + "taken");
                    room.artifacts.remove(0);
                }
                entered = false;
    } //take
    void drop() {
        if (backpack.getContents().equals("")) {
            System.out.println("Your bag is empty. You cannot drop anything");
        }
        else if (room.artifacts.size() == 5) {
            System.out.println("The room is full. You cannot drop this item here");
        }
        else {
            System.out.println("[" + backpack.getArtifact(backpack.getContentLength()) + "] " + "dropped" );
            room.artifacts.add(backpack.pop());
            inventory();
        }
        entered = false;
    } //drop
    void inventory() {
        if (backpack.getContents().equals("")) {
            System.out.println("Your backpack is empty");
        }
        else {
            System.out.println("Your inventory is :" + backpack.getContents());
        }
        entered = false;
    } //inventory
    void print() {
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[0][0][aCol].artifacts.isEmpty() || map.rooms[0][0][aCol].artifacts != null) {
                    if (map.rooms[0][0][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[0][0][aCol].artifacts.size(); i++) {
                           System.out.println("Artifact=" + map.rooms[0][0][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        System.out.println("Artifact=" + map.rooms[0][0][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
                else {
                    
                }
            } //for (save for col[0])
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[0][1][aCol].artifacts.isEmpty() ||  map.rooms[0][1][aCol].artifacts != null) {
                    if (map.rooms[0][1][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[0][1][aCol].artifacts.size(); i++) {
                           System.out.println("Artifact=" + map.rooms[0][1][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        System.out.println("Artifact=" + map.rooms[0][1][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for col[1])            
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[0][2][aCol].artifacts.isEmpty() || map.rooms[0][2][aCol].artifacts != null) {
                    if (map.rooms[0][2][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[0][2][aCol].artifacts.size(); i++) {
                           System.out.println("Artifact=" + map.rooms[0][2][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        System.out.println("Artifact=" + map.rooms[0][2][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for col[2])   
            
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[0][3][aCol].artifacts.isEmpty() || map.rooms[0][3][aCol].artifacts != null) {
                    if (map.rooms[0][3][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[0][3][aCol].artifacts.size(); i++) {
                           System.out.println("Artifact=" + map.rooms[0][3][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        System.out.println("Artifact=" + map.rooms[0][3][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for col[3])  
                        for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[1][0][aCol].artifacts.isEmpty() || map.rooms[1][0][aCol].artifacts != null) {
                    if (map.rooms[1][0][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[1][0][aCol].artifacts.size(); i++) {
                           System.out.println("Artifact=" + map.rooms[1][0][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        System.out.println("Artifact=" + map.rooms[1][0][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for floor[1])
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[1][1][aCol].artifacts.isEmpty() || map.rooms[1][1][aCol].artifacts != null) {
                    if (map.rooms[1][1][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[1][1][aCol].artifacts.size(); i++) {
                           System.out.println("Artifact=" + map.rooms[1][1][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        System.out.println("Artifact=" + map.rooms[1][1][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for floor[1])            
            for (int aCol=0; aCol < 3; aCol++) {
                if(!map.rooms[1][2][aCol].artifacts.isEmpty() || map.rooms[1][2][aCol].artifacts != null) {
                    if (map.rooms[1][2][aCol].artifacts.size() > 1) {
                       for (int i = 0; i < map.rooms[1][2][aCol].artifacts.size(); i++) {
                           System.out.println("Artifact=" + map.rooms[1][2][aCol].artifacts.get(i).name + "," + "0" + "," + "0" + "," + aCol);
                       }
                    }
                    else {
                        System.out.println("Artifact=" + map.rooms[1][2][aCol].artifacts.get(0).name + "," + "0" + "," + "0" + "," + aCol);
                    }
                } 
            } //for (save for floor[1])   
    }
}
