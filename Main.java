import java.util.*;

public class Main {
    public static void main (String [] args) {
        // Generate 2-dimensional array of states & their capitals, ordered by state
        // Row 0 = States, Row 1 = Capitals, each column is a pair
        String[][] capitalCities = {
                {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"},
                {"Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento", "Denver", "Hartford", "Dover", "Tallahassee", "Atlanta", "Honolulu", "Boise", "Springfield", "Indianapolis", "Des Moines", "Topeka", "Frankfort", "Baton Rouge", "Augusta", "Annapolis", "Boston", "Lansing", "Saint Paul", "Jackson", "Jefferson City", "Helena", "Lincoln", "Carson City", "Concord", "Trenton", "Santa Fe", "Albany", "Raleigh", "Bismarck", "Columbus", "Oklahoma City", "Salem", "Harrisburg", "Providence", "Columbia", "Pierre", "Nashville", "Austin", "Salt Lake City", "Montpelier", "Richmond", "Olympia", "Charleston", "Madison", "Cheyenne"}
        };
        System.out.println("===== WELCOME TO STATE CAPITAL PROGRAM =====");
        // Initialize scanner
        Scanner scanner = new Scanner(System.in);
        // Prompt user for a state capital
        /* NOTE: This could be done in a loop, but the assignment only acknowledged asking for this once.
        As a result, this is implemented as a single interaction, rather that one that can be repeated by the user.
         */
        System.out.println("Please enter a state capital: ");
        String currentInput = scanner.nextLine();
        // Initialize variable to begin while loop
        boolean match = false;
        // Define a sub array of the capitals to check if the user input exists within that sub array
        String[] cities = capitalCities[1];
        // Iterate through the sub array to see if a capital city matches the user's input
        for (String city:cities) {
            if (city.equalsIgnoreCase(currentInput)) {
                match = true;
                break;}
            }
        // If match was found, notify the user that they got it right
        if (match) {
            System.out.println("Yes, that is correct! " + currentInput + " is a US state capital. Good job!");
        }
        // If not, let them know their input was not a state capital
        else
            System.out.println("Sorry, " + currentInput + " is not a US state capital.");
        // Assignment requires the contents of the 2-D array be printed out
        System.out.println("I am now going to print out the contents of my array of states and their capitals.");
        // Iterate through all 50 elements of each array, printing state (row 0) and capital (row 1)
        for (int i = 0; i < 50; i++) {
            System.out.println("The capital of " + capitalCities[0][i] + " is " + capitalCities[1][i] + ".");
        }
        // Assignment requires a bubble sort to organize the 2-D array by capital rather than state
        System.out.println("Rearranging the array to be organized by Capital, alphabetically, instead of State.");
        System.out.println("NOTE: This has no impact on you, the user.");
        // Iterate through two nested for loops to compare a given value to the next occurring value
        for (int j = 0; j < capitalCities[0].length; j++) {
            for (int i = j + 1; i < capitalCities[0].length; i++) {
                // Initialize variables for city and state to be cleared and reused each loop
                String tempCity;
                String tempState;
                // If next (i) capital is less than current (j) capital
                if (capitalCities[1][i].compareTo(capitalCities[1][j]) < 0) {
                    /* Then swap the values - place current capital into temporary variable, reassign next capital
                    to current, then reassign temp (previously current) value to next capital*/
                    tempCity = capitalCities[1][j];
                    capitalCities[1][j] = capitalCities[1][i];
                    capitalCities[1][i] = tempCity;
                    // Perform same operations on states, to maintain state/capital columns matching within the array
                    tempState = capitalCities[0][j];
                    capitalCities[0][j] = capitalCities[0][i];
                    capitalCities[0][i] = tempState;
                }
            }
        }
        // Explain instructions to user
        System.out.println("Now that I've given you all the answers, I'm going to ask you to name as many state capitals as you can.");
        System.out.println("I'm not sure why we're doing it this way, but this order is specified in the project directions.");
        System.out.println("Please enter as many state capitals as you can. Be sure to hit enter between capitals.");
        System.out.println("Enter the command 'quit' when you're done.");
        // Initialize Scanner, endLoop variable to launch loop, and ArrayList to contain user inputs
        boolean endLoop = false;
        Scanner loopScanner = new Scanner(System.in);
        ArrayList<String> userList = new ArrayList<>();
        /* In each loop, take user input and check if they've quit. If they have not, enter their input to the ArrayList to be checked later*/
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
        // Report number of answers provided by user
        System.out.println("You submitted " + userList.size() + " answers! Let's see how many you got right!");
        // Initialize counter for how many correct answers
        int correctCounter = 0;
        /* For each attempted answer, check the array of capitals to see if there is a match,
        and increment correctCounter by 1 on each correct match */
        for (String attempt : userList) {
            for (String city : cities) {
                if (attempt.equalsIgnoreCase(city))
                    correctCounter += 1;
            }
        }
        // Report number of correct answers to the user
        System.out.println("Out of " + userList.size() + " attempts, you got " + correctCounter + " correct!");




      
        System.out.println("Placing the arrays into a HashMap...");
        // Initialize a new HashMap, containing Key (state) and Value (capital) strings
        HashMap<String, String> capitalMap = new HashMap<>(capitalCities[0].length);
        // Iterate through all elements of the 2-D array, placing Row 0 (state) and Row 1 (capital) values into HashMap
        for (int i = 0; i < capitalCities[0].length; i++) {
            capitalMap.put(capitalCities[0][i], capitalCities[1][i]);
        }


      
        // Assignment requires the Hashmap be printed out
        System.out.println("I will now print the HashMap's " + capitalMap.size() + "key/value pairs. These will be unordered.");
        // Iterate through all keys, to print the key and its corresponding value
        for (String key : capitalMap.keySet()) {
            System.out.println("The capital of " + key + " is " + capitalMap.get(key) + ".");
        }
        // Use the TreeMap class to sort the map while storing it in a binary tree
        TreeMap<String, String> capitalsSorted = new TreeMap<>(capitalMap);
        // Ask the user for a state and then give them the state's capital
        System.out.println("Let's try something else!");
        System.out.println("You enter a state, and I'll tell you the capital of that state.");
        System.out.println("Enter the command 'quit' when you're done.");
        // Initialize variable to start the loop
        endLoop = false;
        while (!endLoop) {
            // Take user input, checking to see if the user has quit
            System.out.println("Please enter a state: ");
            String loopInput = loopScanner.nextLine();
            if (loopInput.equalsIgnoreCase("quit")) {
                System.out.println("Ending Program...");
                endLoop = true;
                continue;
            }
            // If the user does not quit, check if the input exists as a key in the TreeMap and provide associated value
            if (capitalsSorted.containsKey(loopInput)) {
                System.out.println("The capital of " + loopInput + " is " + capitalsSorted.get(loopInput) + ".");
            }
            else {
                System.out.println("Sorry, I didn't recognize that state. Please try again, or type 'quit'.");
            }
        }
    }
}