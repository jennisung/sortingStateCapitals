import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a 2D array of U.S states & their capitals.
        String[][] statesWithCaps = {
                {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"}, {"Arkansas", "Little Rock"},
                {"California", "Sacramento"}, {"Colorado", "Denver"}, {"Connecticut", "Hartford"}, {"Delaware", "Dover"},
                {"Florida", "Tallahassee"}, {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
                {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"}, {"Iowa", "Des Moines"}, {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"}, {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"}, {"Michigan", "Lansing"}, {"Minnesota", "St. Paul"}, {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"}, {"Montana", "Helena"}, {"Nebraska", "Lincoln"}, {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"}, {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"}, {"New York", "Albany"},
                {"North Carolina", "Raleigh"}, {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"}, {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"}, {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"}, {"Texas", "Austin"}, {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"}, {"Virginia", "Richmond"}, {"Washington", "Olympia"}, {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}
        };


        // Create a HashMap to store the pairs of each state and its capital
        Map<String, String> statesWithCapsHashmap = new HashMap<>();

      
        //Iterate through the 'statesWithCaps' array
        for(int i = 0; i < statesWithCaps.length; i++) {
            // Variable 'state' gets the current element of the array in index 0 which is states.
          
            String state = statesWithCaps[i][0];
            // Variable 'capital' gets the current element of the array in index 1 which is capital
          
            String capital = statesWithCaps[i][1];
            // Adds the state and capital to the 'statesWithCapsHashmap' hashmap
            statesWithCapsHashmap.put(state.toLowerCase(), capital); 
        }

        // Display the content of the HashMap
        System.out.println("State => Capital");
        for (String state : statesWithCapsHashmap.keySet()) {
            System.out.println(state + " ====> " + statesWithCapsHashmap.get(state));
        }

      
        // Create TreeMap to sort the map by state
        TreeMap<String, String> sortedStatesTreeMap = new TreeMap<>(statesWithCapsHashmap);

      
        // Initializing the scanner
        Scanner scanner = new Scanner(System.in);
      
        System.out.print("Enter a state and then the program will display the capital for the state: ");

      
        // Create a variable called 'userInput' which stores user input
        String userInput = scanner.nextLine();

        // Using the .get method, this line
        String capital = sortedStatesTreeMap.get(userInput);

      
        // Checks if capital exists in the hashmap and is not Null
        if(capital != null){
          // If user input and state exists, the user will get a prompt stating the capital
            System.out.println("For the state " + userInput + " the capital is " + capital);
         }else{
          // Else if the state does not exist, user will get a prompt stating error
            System.out.println("Error, please make sure that you're spelling the state correctly.");
        }

      
    }
};