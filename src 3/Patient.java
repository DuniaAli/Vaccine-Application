/*
 @author Dunia ALi
 @version 08/01/2024
 */

//a class to manage the data to be stored for a patient, with getter methods and override toString methods
public class Patient {

    int patientID; //instance variable to hold patient's ID
    String firstName; //instance variable to hold patient's first name
    String lastName; //instance variable to hold patient's last name
    int age; //instance variable to hold patient's age
    String allergy; //instance variable to hold patient's allergy status
    String vaccineType; //instance variable to hold patient's vaccine type
    String date; //instance variable to hold the date of the vaccine taken by the patient


    //a constructor to create a patient object, initialising the instance variable
    public Patient(int patientID, String firstName, String lastName, int age, String allergy, String vaccineType, String date) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.allergy = allergy;
        this.vaccineType = vaccineType;
        this.date = date;

    }

    //a getter method to retrieve patient's last name from the ArrayList
    public String getLastName() {
        return lastName; //calls and returns patent's last name
    }

    //a getter method to retrieve patient's age from the ArrayList
    public int getAge() {
        return age; //calls and returns patient's age
    }

    //a getter method to retrieve patient's ID from the ArrayList
    public int getPatientID() {
        return patientID; //calls and returns patient's ID number
    }


    //a getter method to retrieve patient's vaccine type
    public String getVaccineType() {
        return vaccineType; //calls and returns the vaccine type
    }


    //an override method to allow
    @Override
    public String toString() {
        return String.format("%-12d %-12s %-15s %-5d %-12s %-15s %-10s", //using format print statement to format the line percentage to align the table
                this.patientID, this.firstName, this.lastName, //calls and returns the desired data from the ArrayList
                this.age, this.allergy, this.vaccineType, this.date);
    }
}



