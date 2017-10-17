package GCPUApp;

import java.util.ArrayList;

public class Map {

    // Instance Variables
    Room[][][] rooms = new Room[2][4][4];
    Artifact sign, pen, exam, gazebo, weights, lunch, textbook, cuffs, pillow, orange, notebook, flyer, picture;
    SpecialArtifact paper, treadmill, lamp;
    ArrayList <Artifact> libraryArt, shuttleArt, jGardenArt, claArt, bscArt, classroomArt, roseArt, bricArt, olivosArt, storeArt, policeArt, canyonArt, villageArt, quadArt, farmArt, careerArt, kelloggArt;
    // Constructorf
    Map() {
        //Create rooms

        //First floor
        Room library = new Room("Library", new String[]{"e", "s", "up"}, "Sunlight is streaming in through the glass windows.");
        Room jpGarden = new Room("Japanese Garden", new String[]{"e", "w", "se"}, "There are a lot of fish in the pond.");
        Room cla = new Room("CLA Building", new String[]{"e", "s", "w"}, "There are a lot of people busy at work.");
        Room bsc = new Room("Bronco Student Center", new String[]{"w"}, "There are a lot of students buying food for lunch.");
        Room classroom = new Room("Classroom", new String[]{"n", "e"}, "You see an old table covered with papers near the front of the room.");
        Room rGarden = new Room("Rose Garden", new String[]{"w", "s"}, "You are standing in the middle of a beautiful rose garden.");
        Room bric = new Room("BRIC", new String[]{"n", "s", "nw"}, "There are a lot of broncos here working out.");
        Room mansion = new Room("Kellogg Mansion", new String[]{"e"}, "This is the former home of William Kellogg.");
        Room olivos = new Room("Los Olivos", new String[]{"w", "n"}, "The aroma of hamburgers and pizza wafts through the air.");
        Room store = new Room("Book Store", new String[]{"n", "e", "se"}, "The book store has a lot of new seasonal items.");
        Room police = new Room("Police Station", new String[]{"w", "s"}, "The officers are at work.");
        Room canyon = new Room("Box Canyon", new String[]{"n"}, "This looks like the Voorhis Ecological Reserve. \nA cavernous opening in the canyon wall lies just ahead of you.");
        Room village = new Room("Village", new String[]{"n", "nw"}, "The living room of an apartment has couches for people to relax on.");

        //Second floor
        Room farmStore = new Room("Farm Store", new String[]{"e", "s", "down"}, "The store is full of Cal Poly Pomona grown food.");
        Room quad = new Room("Quad", new String[]{"n", "ne"}, "The quad is buzzing with students.");
        Room career = new Room("Career Center", new String[]{"w", "sw", "e"}, "The career center is full of flyers advertising jobs and events");
        Room bus = new Room("Shuttle Stop", new String[]{"e"}, "The bus stop will take you somewhere random.");

        //Place rooms on map
        rooms[0][0][0] = library;
        rooms[0][0][1] = jpGarden;
        rooms[0][0][2] = cla;
        rooms[0][0][3] = bsc;
        rooms[0][1][0] = classroom;
        rooms[0][1][1] = rGarden;
        rooms[0][1][2] = bric;
        rooms[0][2][0] = mansion;
        rooms[0][2][1] = olivos;
        rooms[0][2][2] = store;
        rooms[0][2][3] = police;
        rooms[0][3][0] = canyon;
        rooms[0][3][3] = village;
        rooms[1][0][0] = farmStore;
        rooms[1][1][0] = quad;
        rooms[1][0][1] = career;
        rooms[1][0][2] = bus;

        //Create Artifacts
        sign = new Artifact("a sign", "The sign reads: 'No food or drinks in the library'.", "Touching the sign seems to do nothing.");
        pen = new Artifact("a pen", "Someone left a pen on the floor.", "The pen does nothing");
        exam = new Artifact("a graded exam sitting on the table", "The test reads CIS 234, we shouldn't read the rest...", "Touching the test does nothing.");
        gazebo = new Artifact("a gazebo", "The small plaque on the structure reads: Enjoy the garden.", "Touching the gazebo does nothing.");
        treadmill = new SpecialArtifact("a treadmill", "Broncos use the treadmill to workout.", false, "The treadmill is running.", "If you see this, it is an error.", "The treadmill starts running.", "The treadmill slows to a complete stop.");
        weights = new Artifact("lifting weights", "Broncos use the lifting weights to work out.", "Touching the weights do nothing.");
        lunch = new Artifact("a lunch", "The lunch seems to be a hamburger, fries, and a soda.", "Touching the lunch does nothing.");
        textbook = new Artifact("a textbook sits on the counter", "The textbook is a math textbook.", "Touching the textbook does nothing");
        cuffs = new Artifact("a pair of hand cuffs", "These are unlocked currently.", "Touching the cuffs do nothing.");
        paper = new SpecialArtifact("a sheet of paper", "The paper appears blank", false, "The paper reads: 'Welcome to the Great Cal Poly Underground!'", "If you see this, it is an error", "The paper begins to glow and you see mysterious writing", "The writing on the paper fades");
        lamp = new SpecialArtifact(" a lamp", "A lamp sits here untouched.",false, "The lamp is turned on", "If you see this it is an error", "The lamp brightens the room", "The lamp clicks and stops glowing" );
        pillow = new Artifact("a pillow", "A pillow used for sleeping.", "Touching the pillow does nothing");
        orange = new Artifact("an orange", "Orange you glad it isn't a banana. (hahahaha)", "Touching the orange does nothing");
        notebook = new Artifact("a notebook", "Someone dropped an old used notebook.", "Touching notebook does nothing");
        flyer = new Artifact("a flyer", "It advertises the Career Fair.", "The flyer does nothing");
        picture = new Artifact("a picture", "The picture bears an inscription that reads: W.K. Kellogg. He appears to be holding a box of Corn Flakes.", "Touching the picture does nothing");

        //Create two artifacts in one room
        libraryArt = new ArrayList <Artifact>();
        libraryArt.add(sign);
        library.artifacts = libraryArt;
        
        jGardenArt = new ArrayList <Artifact>();
        
        claArt = new ArrayList<Artifact>();
        
        bscArt = new ArrayList <Artifact>();
        bscArt.add(pen);
        bsc.artifacts = bscArt;

        classroomArt = new ArrayList <Artifact>();
        classroomArt.add(exam);
        classroom.artifacts = classroomArt;

        roseArt = new ArrayList <Artifact>();
        roseArt.add(gazebo);
        rGarden.artifacts = roseArt;

        bricArt = new ArrayList <Artifact>();
        bricArt.add(treadmill);
        bricArt.add(weights);
        bric.artifacts = bricArt;

        olivosArt = new ArrayList <Artifact>();
        olivosArt.add(lunch);
        olivos.artifacts = olivosArt;

        storeArt = new ArrayList <Artifact>();
        storeArt.add(textbook);
        store.artifacts = storeArt;

        policeArt = new ArrayList <Artifact>();
        policeArt.add(cuffs);
        police.artifacts = policeArt;

        canyonArt = new ArrayList <Artifact>();
        canyonArt.add(paper);
        canyon.artifacts = canyonArt;

        villageArt = new ArrayList <Artifact>();
        villageArt.add(lamp);
        villageArt.add(pillow);
        village.artifacts = villageArt;

        farmArt = new ArrayList <Artifact>();
        farmArt.add(orange);
        farmStore.artifacts = farmArt;

        quadArt = new ArrayList <Artifact>();
        quadArt.add(notebook);
        quad.artifacts = quadArt;

        careerArt = new ArrayList <Artifact>();
        careerArt.add(flyer);
        career.artifacts = careerArt;

        kelloggArt = new ArrayList <Artifact>();
        kelloggArt.add(picture);
        mansion.artifacts = kelloggArt;
        
        shuttleArt = new ArrayList <Artifact>();
        
    }
}
