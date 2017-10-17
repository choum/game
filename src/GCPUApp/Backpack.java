/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCPUApp;

import java.util.ArrayList;

/**
 *
 * @author Heather
 */
public class Backpack {
   private ArrayList <Artifact> contents = new ArrayList <Artifact>();
   private final int limit = 3; 
   
   public boolean setArtifact(Artifact anyArtifact) {
        if (contents.size() <= limit) {
            contents.add(anyArtifact);
            return true;
        }
        else {
            return false;
        }
   }
   public String getArtifact(int i) {
       return contents.get(i).name;
   }
   public String getContents() {
       String message = "";
       for (int i = 0; i < 3; i++) {
            if (contents.size() >= i + 1) {
                message += contents.get(i).name + ", ";
            }
       }
       return message;
   }
    public Artifact pop() {
        Artifact a = contents.get(contents.size() - 1);
        drop(a);
        return a;
    }

    public int getContentLength() {
        int length = contents.size() - 1;
        return length;
    }
   public void drop(Artifact anyArtifact) {
       contents.remove(anyArtifact);
   }
}

