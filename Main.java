import java.util.*;

public class Main {
    public static void main (String [] args) {
        String[][] capitalCities = {
                {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},
                {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"}
        };
        System.out.println("===== WELCOME TO STATE CAPITAL PROGRAM =====");
        Scanner scanner = new Scanner(System.in);
      
        System.out.println("Please enter a state capital: ");
        String currentInput = scanner.nextLine();
        boolean match = false;
        String[] cities = capitalCities[1];
        for (String city:cities) {
            if (city.equalsIgnoreCase(currentInput)) {
                match = true;
                break;}
            }
        if (match) {
            System.out.println("Yes, that is correct! " + currentInput + " is a US state capital. Good job!");
        }
        else
            System.out.println("Sorry, " + currentInput + " is not a US state capital.");
        System.out.println("I am now going to print out the contents of my array of states and their capitals.");
        for (int i = 0; i < 50; i++) {
            System.out.println("The capital of " + capitalCities[0][i] + " is " + capitalCities[1][i] + ".");
        }
        System.out.println("Rearranging the array to be organized by Capital, alphabetically, instead of State.");
        System.out.println("NOTE: This has no impact on you, the user.");
        for (int j = 0; j < capitalCities[0].length; j++) {
            for (int i = j + 1; i < capitalCities[0].length; i++) {
                String tempCity;
                String tempState;
                if (capitalCities[1][i].compareTo(capitalCities[1][j]) < 0) {
                    tempCity = capitalCities[1][j];
                    capitalCities[1][j] = capitalCities[1][i];
                    capitalCities[1][i] = tempCity;
                    tempState = capitalCities[0][j];
                    capitalCities[0][j] = capitalCities[0][i];
                    capitalCities[0][i] = tempState;
                }
            }
        }
        System.out.println("Now that I've given you all the answers, I'm going to ask you to name as many state capitals as you can.");
        System.out.println("I'm not sure why we're doing it this way, but this order is specified in the project directions.");
        System.out.println("Please enter as many state capitals as you can. Be sure to hit enter between capitals.");
        System.out.println("Enter the command 'quit' when you're done.");
        boolean endLoop = false;
        Scanner loopScanner = new Scanner(System.in);
        ArrayList<String> userList = new ArrayList<>();
        while (!endLoop) {
            String loopInput = loopScanner.nextLine();
            if (loopInput.equalsIgnoreCase("quit")) {
                System.out.println("Moving on...");
                endLoop = true;
            }
            else {
                userList.add(loopInput);
            }
        }
        System.out.println("You submitted " + userList.size() + " answers! Let's see how many you got right!");
        int correctCounter = 0;
        for (String attempt : userList) {
            for (String city : cities) {
                if (attempt.equalsIgnoreCase(city))
                    correctCounter += 1;
            }
        }
        System.out.println("Out of " + userList.size() + " attempts, you got " + correctCounter + " correct!");




      
        System.out.println("Placing the arrays into a HashMap...");
        HashMap<String, String> capitalMap = new HashMap<>(capitalCities[0].length);
        for (int i = 0; i < capitalCities[0].length; i++) {
            capitalMap.put(capitalCities[0][i], capitalCities[1][i]);
        }


        System.out.println("I will now print the HashMap's " + capitalMap.size() + "key/value pairs. These will be unordered.");
        for (String key : capitalMap.keySet()) {
            System.out.println("The capital of " + key + " is " + capitalMap.get(key) + ".");
        }
        TreeMap<String, String> capitalsSorted = new TreeMap<>(capitalMap);
        System.out.println("Let's try something else!");
        System.out.println("You enter a state, and I'll tell you the capital of that state.");
        System.out.println("Enter the command 'quit' when you're done.");
        endLoop = false;
        while (!endLoop) {
            System.out.println("Please enter a state: ");
            String loopInput = loopScanner.nextLine();
            if (loopInput.equalsIgnoreCase("quit")) {
                System.out.println("Ending Program...");
                endLoop = true;
                continue;
            }
            if (capitalsSorted.containsKey(loopInput)) {
                System.out.println("The capital of " + loopInput + " is " + capitalsSorted.get(loopInput) + ".");
            }
            else {
                System.out.println("Sorry, I didn't recognize that state. Please try again, or type 'quit'.");
            }
        }
    }
}