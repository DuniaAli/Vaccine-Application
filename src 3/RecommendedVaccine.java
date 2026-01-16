/*
 @author Dunia ALi
 @version 08/01/2024
 */


import java.util.HashMap; //to import HashMap library required for this class
import java.util.Map; //to import Map library required for this class

//a class to take user input of patient's allergy status and return the recommended vaccine for this patient
public class RecommendedVaccine {
    private Map<String, String> allergyVaccineMap;  //declares a map to store the allergies and corresponding vaccine data

    //method to initialise the allergies and vaccine data
    public RecommendedVaccine() {
        allergyVaccineMap = new HashMap<>(); //initialises the allergyVaccineMap as a new HashMap
        initializeData(); //calls the data to fill in the map
    }

    //method to add the vaccine and allergy data
    public void initializeData() {
        allergyVaccineMap.put("PEG", "AstraZeneca"); //adds the allergy PEG with its recommended vaccine to the map
        allergyVaccineMap.put("PS80", "AstraZeneca"); //adds the allergy PS80 with its recommended vaccine to the map
        allergyVaccineMap.put("Gelatin", "Pfizer"); //adds the allergy Gelatin with its recommended vaccine to the map
    }

    //method for user to input the patient's allergy, and return the recommended vaccine type
    public String getRecommendedVaccine(String allergy) {
        try {
            String vaccine = allergyVaccineMap.get(allergy); //calls the vaccine recommended for each allergy
            if (vaccine == null) { //checks whether the allergy entered has a corresponding vaccine in the map,
                throw new IllegalArgumentException("No vaccine recommendation available for the allergy: " + //throws an error if the allergy is not found
                        ". Enter one of three allergies 'PEG', 'PS80' or 'Gelatin'"); //prompts the user to enter one of 3 accepted allergies
            }
            return vaccine; //returns the recommended vaccine
        } catch (IllegalArgumentException e) { //catches an illegal exception and displays an error message
            System.out.println(e.getMessage()); //prints error message
            return null; //returns null

        }
    }

}




