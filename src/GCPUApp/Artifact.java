/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCPUApp;

/**
 *
 * @author dylan_000
 */
public class Artifact {
    //Instance variables

    String name, description, touchDescription;

    // Constructors
    Artifact(String name) {
        this.name = name;
    }

    Artifact(String name, String description, String touchDescription) {
        this(name);
        this.description = description;
        this.touchDescription = touchDescription;
    }

    // Example of behavior for examining an artifact
    String examine() {
        return description;
    }

    String touch() {
        return touchDescription;
    }
}
