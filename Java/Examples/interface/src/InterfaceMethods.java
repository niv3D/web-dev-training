class Horse {
    public String identifyMyself() {
        return "I am a horse.";
    }
}

interface Flyer {
    default public String identifyMyself() {
        return "I am able to fly.";
    }
}

interface Mythical {
    default public String identifyMyself() {
        return "I am a mythical creature.";
    }
}

class InterfaceMethods extends Horse implements Flyer, Mythical {
	
    public static void main(String... args) {
 
        InterfaceMethods myApp = new InterfaceMethods();
        System.out.println(myApp.identifyMyself());
        
    }
}
