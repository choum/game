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
public class SpecialArtifact extends Artifact {

    boolean powerSwitch;
    String specialDescription;
    String touchDescriptionOn;
    String touchDescriptionOff;

    SpecialArtifact(String name) {
        super(name);
    }

    SpecialArtifact(String name, String description, boolean power, String specialDescription, String touchDescription, String touchDescriptionOff, String touchDescriptionOn) {
        super(name, description, touchDescription);
        this.specialDescription = specialDescription;
        this.touchDescriptionOn = touchDescriptionOn;
        this.touchDescriptionOff = touchDescriptionOff;
        powerSwitch = power;

    }

    //Instance Methods
    boolean power(boolean power) {
        if (power == true) {
            power = false;
        } else {
            power = true;
        }
        return power;
    }

    @Override
    String examine() {
        if (powerSwitch == true) {
            return specialDescription;
        } else {
            return description;
        }
    }

    @Override
    String touch() {
        if (powerSwitch == true) {
            powerSwitch = false;
            return touchDescriptionOn;
        } else {
            powerSwitch = true;
            return touchDescriptionOff;

        }
    }
}
