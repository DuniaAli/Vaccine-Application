/* A project to enter, store, search through patient's data, vaccine types and allergies.

 @author Dunia ALi
 @version 08/01/2024
 */


import java.util.*; //importing java libraries required for this project
import java.util.stream.Collectors; //importing stream and collectors libraries for this project

//a class to hold patient's records and methods required to display patient data
public class PatientsRecord {

    private List<Patient> patientRecords = new ArrayList<>(); //an ArrayList to store patient's records

    //a constructor to initialise data to allow for testing for the method and classes
    public PatientsRecord() {
        initializeData();

    }

    //sample data of patients to be initialised when testing
    public void initializeData() {

        patientRecords.add(new Patient(1, "Gerogia", "Roberts", 23, "Gelatin", "Pfizer", "06/15/2021"));
        patientRecords.add(new Patient(2, "Charlie", "Smith", 40, "Gelatin", "Pfizer", "06/15/2021"));
        patientRecords.add(new Patient(3, "Mariam", "Dawson", 27, "Gelatin", "Pfizer", "06/17/2021"));
        patientRecords.add(new Patient(4, "Emmett", "Miller", 30, "Gelatin", "Pfizer", "06/20/2021"));
        patientRecords.add(new Patient(5, "Lily", "Taylor", 18, "PEG ", "AstraZeneca", "06/21/2021"));
        patientRecords.add(new Patient(6, "Bill", "Harely", 70, "PS80", "AstraZeneca", "07/21/2021"));
        patientRecords.add(new Patient(3, "Mariam", "Dawson", 27, "Gelatin", "Pfizer", "06/17/2021"));
        patientRecords.add(new Patient(4, "Emmett", "Miller", 30, "Gelatin", "Pfizer", "06/20/2021"));
        patientRecords.add(new Patient(3, "Mariam", "Dawson", 27, "Gelatin", "Pfizer", "06/17/2021"));

    }

    //method for user to input patient's data
    public void addPatient() {

        //scanner class to take user input
        Scanner scanner = new Scanner(System.in); //creates a new object of the scanner class
        System.out.println("Welcome to the Vaccine Manager Application. Please enter patient details as prompted."); //message to display to the user when starting the app

        System.out.print("Enter patient's ID number: "); //a message to prompt the user to enter patient's ID number
        int patientID = scanner.nextInt(); //to take in the patient's ID number from the user input
        scanner.nextLine();  //for the next part of the code to start on a new line

        System.out.print("Enter patient's first name: "); //a message to prompt the user to enter patient's first name
        String firstName = scanner.nextLine();//to take in the patient's first name number from the user input

        System.out.print("Enter patient's last name: "); //a message to prompt the user to enter patient's last name
        String lastName = scanner.nextLine();//to take in the patient's last name from the user input

        System.out.print("Enter patient's age: "); //a message to prompt the user to enter patient's age
        int age = scanner.nextInt();//to take in the patient's age from the user input
        scanner.nextLine(); //for the next part of the code to start on a new line

        System.out.print("Enter patient's allergy status: "); //a message to prompt the user to enter patient's allergy status
        String allergy = scanner.nextLine();//to take in the patient's allergy status from the user input

        System.out.print("Enter patient's vaccine Type: "); //a message to prompt the user to enter patient's vaccine type
        String vaccineType = scanner.nextLine();//to take in the patient's vaccine type from the user input

        System.out.print("Enter date of the last vaccine taken: "); //a message to prompt the user to enter the date the last vaccine was given to the patient
        String date = scanner.nextLine();//to take in the date of the last vaccine taken by the patient


        patientRecords.add(new Patient(patientID, firstName, lastName, age, allergy, vaccineType, date)); // Storing the patient information in the list


        System.out.println("The patient information has been stored. You may exit the application."); //message printed to the user allowing them to exit the application
    }


    // method to display all patient records in ascending order by patient's ID number
    public void displayPatients() {
        System.out.printf("%-12s %-12s %-15s %-5s %-12s %-15s %-10s%n", //using format print statement to format the line percentage to align the table
                "Patient ID", "First Name", "Last Name", "Age", "Allergy", "Vaccine Type", "Date"); //to print the headers of the table


        for (Patient patient : patientRecords) { // a loop to iterate over the list of patients to print every single patient's details stored in the ArrayList
            System.out.printf("%-12d %-12s %-15s %-5d %-12s %-15s %-10s%n", //using format print statement to format the line percentage to align the table
                    patient.patientID, patient.firstName, patient.lastName, //calling patient's details to be printed on the console and displayed to the user
                    patient.age, patient.allergy, patient.vaccineType, patient.date);
        }
    }

    //method to generate a vaccine report to display the number of patients who were given each vaccination type
    public void generateVaccineReport() {

        int astraZenecaCounter = 0; //declaring and initialising the astraZeneca vaccine counter to count the number of patients who had the AstraZeneca vaccine
        int pfizerCounter = 0; //declaring and initialising the Pfizer vaccine counter to count the number of patients who had the Pfizer vaccine

        for (int i = 0; i < patientRecords.size(); i++) { //loop to iterate through the patient's list to count the number of vaccines

            Patient patient = patientRecords.get(i); //accessing the element which is the vaccine
            if (patient.vaccineType.equals("AstraZeneca")) { //an if statement with a condition to find whether the accessed vaccine type matches the vaccine requested, if a match is found then +1 is added to the AstraZeneca counter
                astraZenecaCounter++; //a counter increasing the count of vaccine by 1 every time a match is found for AstraZeneca
            } else if (patient.vaccineType.equals("Pfizer")) { // else if statement which ensures if the vaccines type did not match AstraZeneca then it checks the condition against the new vaccine type, Pfizer. If a match is found then  +1 is added to the Pfizer counter
                pfizerCounter++; //a counter increasing the count of vaccine by 1 every time a match is found for Pfizer

            }

        }

        System.out.printf("%-15s %-10s%n", "Vaccine Type", "Count"); //a statement to print out the header of the table, printed with a formatted line percentage to align the table
        System.out.printf("%-15s %-10d%n", "Pfizer", pfizerCounter); //a statement to print and display the number of doses of Pfizer given to patients with a formatted percentage to align the table
        System.out.printf("%-15s %-10d%n", "AstraZeneca", astraZenecaCounter); //a statement to print and  display the number of doses of AstraZeneca given to patients with a formatted percentage to align the table

    }


    //method that sorts patients by last name among those who received a specified vaccine, based on user input for the vaccine type and displays the sorted list on the console
    public void sortPatientsByVaccineType() {
        Scanner scanner = new Scanner(System.in); //creating a new scanner object

        // Take user input for vaccine type
        System.out.print("Enter the choice of vaccine type (AstraZeneca/Pfizer): "); //statement to prompt the user to input the name of vaccine they want the data for
        String vaccineType = scanner.nextLine(); //to take in the name of the vaccine from the user input

        // Validate input
        if (!vaccineType.equalsIgnoreCase("AstraZeneca") && !vaccineType.equalsIgnoreCase("Pfizer")) { //conditional statement to ensure the user is input the correct name
            System.out.println("Invalid input. Please enter 'AstraZeneca' or 'Pfizer'. Try again."); //statement to display on the console informing the user they need to input one of the two options
            return; //exits the code of block
        }


        List<Patient> sortedPatients = patientRecords.stream() //starts the process to search through patient's record
                .filter(patient -> vaccineType.equalsIgnoreCase(patient.getVaccineType())) // filters the stream to only includes patients who have received the vaccine type requested by the user
                .sorted(Comparator.comparing(Patient::getLastName)) //sorts the filtered streams alphabetically by last name of the patient
                .collect(Collectors.toList()); //collects the result of the stream and stores it into a list

        // Print the sorted list of patients
        System.out.printf("%-12s %-12s %-15s %-5s %-12s %-15s %-10s%n", //using format print statement to format the line percentage to align the table
                "Patient ID", "First Name", "Last Name", "Age", "Allergy", "Vaccine Type", "Date"); //to print the headers of the table
        sortedPatients.stream().forEach(patient -> System.out.println(patient)); //prints and displays the sorted data into a table on the console

    }


    //method to sort and print out the patient's list in descending order according to age, to give preference to older patients
    public void sortByAgeDescending() {
        List<Patient> byAge = patientRecords.stream()//starts the process to search through patient's record
                .sorted(Comparator.comparing(Patient::getAge).reversed()) // filters the stream by age, and reverses the order by sorting the patient's list by age descending order
                .collect(Collectors.toList()); //collects the result of the stream and stores it into a list

        System.out.printf("%-12s %-12s %-15s %-5s %-12s %-15s %-10s%n", //using format print statement to format the line percentage to align the table
                "Patient ID", "First Name", "Last Name", "Age", "Allergy", "Vaccine Type", "Date"); //to print the headers of the table

        byAge.stream().forEach(patient -> System.out.println(patient));
    }

    //method to count the total number of patients with each allergy type
    public void numberOfPatientsWithEachAllergyType() {
        Map<String, Integer> allergyCounts = new HashMap<>();
        Set<Integer> countedPatientIds = new HashSet<>();

        for (Patient patient : patientRecords) {
            // Only count a patient if they haven't been counted before
            if (!countedPatientIds.contains(patient.patientID)) {
                String allergy = patient.allergy;
                allergyCounts.put(allergy, allergyCounts.getOrDefault(allergy, 0) + 1);
                countedPatientIds.add(patient.patientID); // Mark this patient as counted
            }
        }

        // Print the table header
        System.out.printf("%-12s %-12s %-15s %-5s %-12s %-15s %-10s%n", //using format print statement to format the line percentage to align the table
                "Patient ID", "First Name", "Last Name", "Age", "Allergy", "Vaccine Type", "Date"); //to print the headers of the table
        System.out.printf("%-15s %-30s%n", "Allergy Type", "Total number of patients");//to print the headers of the table

        // Print each allergy type and its count
        for (Map.Entry<String, Integer> entry : allergyCounts.entrySet()) {
            System.out.printf("%-15s %-30d%n", entry.getKey(), entry.getValue());
        }
    }


    //method to display a list of patients who have completed three doses of vaccine
    public void patientsCompletedThreeDoses() {

        Map<Integer, Long> patientsGroupedByDoses = patientRecords.stream()//a map to store the results where key is the patient ID and values is the count of the patient record which, equals to number of doses
                .collect(Collectors.groupingBy(Patient::getPatientID, Collectors.counting())); //collects the elements of the stream result, groups elements by patient ID, collects the count of the dose


        for (Map.Entry<Integer, Long> map : patientsGroupedByDoses.entrySet()) { //a loop to iterate through the map to find patients who received 3 vaccines doses by identifying patient IDs that appears 3 times in the record, using a set as it does not allow for duplicate elements
            Long dose = map.getValue(); //finds the number of doses for each patient
            Integer id = map.getKey(); //finds the patient's ID from the map entry
            if (dose == 3) { //conditional statement to check if the patient had 3 doses

                //find the patient using the patient id map key and matching it with the patient id in the patient record list (use a stream and a filter)
                Patient patientWithThreeDoses = patientRecords.stream() //starts a stream process from the patient record data
                        .filter(patientInTheList -> id == patientInTheList.patientID) //filters through the to find matching patient's ID
                        .findFirst() //returns patient's ID if found
                        .orElseThrow(); //throws an error where there are no matches

                System.out.println("Below is a list of patients who had 3 doses of vaccine.");
                System.out.printf("%-12s %-12s %-15s %-5s %-12s %-15s %-10s%n", //using format print statement to format the line percentage to align the table
                        "Patient ID", "First Name", "Last Name", "Age", "Allergy", "Vaccine Type", "Date"); //to print the headers of the table
                System.out.println(patientWithThreeDoses); //prints and displays the details of patients who have received three doses in a table format on the console


            }
        }

    }

    //Q7 method to display a list of elderly patients, 70 years and above, who were given fewer than 3 doses
    //I NEED TO DISPLAY THE NUMBER OF DOSES
    public void elderlyPatientsWithLessThanThreeDoses() {
        Map<Integer, Long> counts = patientRecords.stream() // Map to store patient ID and vaccine count, stream process to run thorough the patient's record
                .filter(patient -> patient.age >= 70) // filters through the map to only include patients who are 70 or above
                .collect(Collectors.groupingBy(Patient::getPatientID, Collectors.counting())); //collects the elements of the stream result, groups elements by patient ID, collects the count of the dose


        for (Map.Entry<Integer, Long> map : counts.entrySet()) { //a loop to iterate through the map to find patients who received 3 vaccines doses by identifying patient IDs that appears 3 times in the record
            Long doseCount = map.getValue(); //finds the number of doses for each patient
            Integer id = map.getKey(); //finds the patient's ID from the map entry


            if (doseCount < 3) { // conditional statement to check if the dose is fewer than 3

                Patient patient = patientRecords.stream() //finds the patient using the patient id map key and matching it with the patient id in the patient record list
                        .filter(patientInTheList -> id.equals(patientInTheList.patientID)) //filters patients by ID, finding the matching ID of the identified patients with fewer than 3 doses
                        .findFirst()  //returns patient's ID if found
                        .orElseThrow(); //throws an error where there are no matches


                System.out.printf("%-12s %-12s %-15s %-5s %-12s %-15s %-10s%n",//using format print statement to format the line percentage to align the table
                        "Patient ID", "First Name", "Last Name", "Age", "Allergy", "Vaccine Type", "Dose");//to print the headers of the table
                System.out.printf("%-12d %-12s %-15s %-5d %-12s %-15s %-10s%n", //using format print statement to format the line percentage to align the table
                        patient.patientID, patient.firstName, patient.lastName, //printing and displaying the required patient data on the console
                        patient.age, patient.allergy, patient.vaccineType, doseCount);
            }
        }
    }
}













