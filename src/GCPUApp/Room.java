/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCPUApp;

import java.util.ArrayList;

/**
 *
 * @author dylan_000
 */
public class Room {

    //Instance Variable
    String name;
    String roomDescription;
    String[] exits = {"n", "e", "w", "s", "ne", "se", "nw", "sw", "up", "down"};
    String[] printExit = {"North", "East", "West", "South", "Northeast", "Northwest", "Southwest", "Southeast", "Upwards", "Downwards"};
    ArrayList <Artifact> artifacts;

    // Constructor
    Room(String name, String[] exits, String roomDescription) {
        this.name = name;
        this.exits = exits;
        this.roomDescription = roomDescription;
    }

    boolean isValidExit(String requestedExit) {
        boolean result = false;
        int i = 0;
        while (result == false && i < exits.length) {
            if (exits[i].equals(requestedExit)) {
                result = true;
            }
            i++;
        }
        return result;
    }

    String getExit(String exitCode) {
        if (exitCode.equalsIgnoreCase("n")) {
            return "north";
        } else if (exitCode.equalsIgnoreCase("e")) {
            return "east";
        } else if (exitCode.equalsIgnoreCase("w")) {
            return "west";
        } else if (exitCode.equalsIgnoreCase("s")) {
            return "south";
        } else if (exitCode.equalsIgnoreCase("ne")) {
            return "northeast";
        } else if (exitCode.equalsIgnoreCase("se")) {
            return "southeast";
        } else if (exitCode.equalsIgnoreCase("nw")) {
            return "northwest";
        } else if (exitCode.equalsIgnoreCase("sw")) {
            return "southwest";
        } else if (exitCode.equalsIgnoreCase("up")) {
            return "upstairs";
        } else if (exitCode.equalsIgnoreCase("down")) {
            return "downstairs";
        }
        return "";
    }

    String getExits() {
        String output = "";
        if (exits.length > 0) {
            output = getExit(exits[0]);
            for (int i = 1; i < exits.length; i++) {
                output = output + ", " + getExit(exits[i].toLowerCase());
            }
        }
        return output;
    }
}
