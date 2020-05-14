/*************************************************************************
 *  Compilation:  javac HeartTransplant.java
 *  Execution:    java HeartTransplant < data.txt
 *
 *  @author:
 *
 *************************************************************************/

public class HeartTransplant {

    /* ------ Instance variables  -------- */

    // Person array, each Person is read from the data file
    private Person[] listOfPatients;
    private int listOfPatientsCurrentSize;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge[] survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause[] survivabilityByCause;

    /* ------ Constructor  -------- */
    
    /*
     * Initializes all instance variables to null.
     */
    public HeartTransplant() {
        this.listOfPatients = null;
        this.listOfPatientsCurrentSize = 0;
        this.survivabilityByAge = null;
        this.survivabilityByCause = null;
    }

    /* ------ Methods  -------- */

    /*
     * Inserts Person p into listOfPatients
     * 
     * Returns:  0 if successfully inserts p into array, 
     *          -1 if there is not enough space to insert p into array
     */
    public int addPerson(Person p, int arrayIndex) {
        if (this.listOfPatients.length == this.listOfPatientsCurrentSize) {
            return -1;
        } else {
            for (int i = listOfPatients.length - 1; i > arrayIndex; i--) {
                this.listOfPatients[i] = this.listOfPatients[i-1];
            }
            this.listOfPatients[arrayIndex] = p;
            this.listOfPatientsCurrentSize++;
            return 0;
        }
    }

    /*
     * 1) Creates the listOfPatients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file.
     *    File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
     *    Each line refers to one Person.
     * 
     * 3) Inserts each person from file into listOfPatients
     *    Hint: uses addPerson() method
     * 
     * Returns the number of patients read from file
     */
    public int readPersonsFromFile(int numberOfLines) {
        this.listOfPatients = new Person[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {

            Person p = new Person(StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            addPerson(p, i);
        }
        return numberOfLines;
    }

    /*
     * 1) Creates the survivabilityByAge array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     * 3) Inserts each rate from file into the survivabilityByAge array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {
        this.survivabilityByAge = new SurvivabilityByAge[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {

            SurvivabilityByAge surv = new SurvivabilityByAge(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
            this.survivabilityByAge[i] = surv;
        }
        return numberOfLines;
    }

    /*
     * 1) Creates the survivabilityByCause array with numberOfLines length.
     * 
     * 2) Reads from the command line file.
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     * 3) Inserts each rate from file into the survivabilityByCause array
     * 
     * Returns the number of survivabilities rates read from file
     */
    public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {
        this.survivabilityByCause = new SurvivabilityByCause[numberOfLines];
        for (int i = 0; i < numberOfLines; i++) {

            SurvivabilityByCause surv = new SurvivabilityByCause(StdIn.readInt(), StdIn.readInt(), StdIn.readDouble());
            this.survivabilityByCause[i] = surv;
        }
        return numberOfLines;
    }
    
    /*
     * Returns listOfPatients
     */
    public Person[] getListOfPatients() {
        return listOfPatients;
    } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge[] getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause[] getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * Returns a Person array in which with every Person that has 
     * age above the parameter age from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with age above the parameter age.
     * 
     * Return null if there is no Person with age above the 
     * parameter age.
     */ 
    public Person[] getPatientsWithAgeAbove(int age) {
        Person[] newList = new Person[this.listOfPatients.length];
        int i = 0;
        for (int j = 0; j < this.listOfPatients.length; j++) {
            if (this.listOfPatients[j].getAge() >= age) {
                newList[i] = this.listOfPatients[j];
                i++;
            }
        }
        if (newList[0] == null) {
            return null;
        } else {
            Person[] foundPatients = new Person[i];
            for (int j = 0; j < foundPatients.length; j++) {
                foundPatients[j] = newList[j];
            }
            return foundPatients;
        }
    }
    
    /*
     * Returns a Person array with every Person that has the state of health 
     * equal to the parameter state from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the state of health equal to the parameter state.
     * 
     * Return null if there is no Person with the state of health 
     * equal to the parameter state.
     */ 
    public Person[] getPatientsByStateOfHealth(int state) {
        Person[] newList = new Person[this.listOfPatients.length];
        int i = 0;
        for (int j = 0; j < this.listOfPatients.length; j++) {
            if (this.listOfPatients[j].getStateOfHealth() == state) {
                newList[i] = this.listOfPatients[j];
                i++;
            }
        }
        if (newList[0] == null) {
            return null;
        } else {
            Person[] foundPatients = new Person[i];
            for (int j = 0; j < foundPatients.length; j++) {
                foundPatients[j] = newList[j];
            }
            return foundPatients;
        }
    }

    /*
     * Returns a Person array with every person that has the heart 
     * condition cause equal to the parameter cause from the listOfPatients array.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of persons with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Person with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Person[] getPatientsByHeartConditionCause(int cause) {
        Person[] newList = new Person[this.listOfPatients.length];
        int i = 0;
        for (int j = 0; j < this.listOfPatients.length; j++) {
            if (this.listOfPatients[j].getCause() == cause) {
                newList[i] = this.listOfPatients[j];
                i++;
            }
        }
        if (newList[0] == null) {
            return null;
        } else {
            Person[] foundPatients = new Person[i];
            for (int j = 0; j < foundPatients.length; j++) {
                foundPatients[j] = newList[j];
            }
            return foundPatients;
        }
    }

    /*
     * Assume there are numberOfHearts available for transplantation surgery.
     * Also assume that the hearts are of the same blood type as the
     * persons on the listOfPatients.
     * This method finds a set of persons to be the recepients of these
     * hearts.
     * 
     * The method returns a Person array from the listOfPatients
     * array that have the highest potential for survivability after
     * the transplant. The array size is numberOfHearts.
     * 
     * If numberOfHeartsAvailable is greater than listOfPatients
     * array size all Persons will receive a transplant.
     * 
     * If numberOfHeartsAvailable is smaller than listOfPatients
     * array size find the set of people with the highest
     * potential for survivability.
     * 
     * There is no correct solution, you may come up with any set of
     * persons from the listOfPatients array.
     */ 
    public Person[] match(int numberOfHearts) {
        if (numberOfHearts > this.listOfPatientsCurrentSize) {
            return listOfPatients;
        }

        int currLength = this.listOfPatients.length;
        int currPerson = 0;
        Person[] luckies = new Person[numberOfHearts];

        for (int i = 0; i < currLength; i++) {
            if (currPerson == numberOfHearts) {
                break;
            }
            luckies[i] = this.listOfPatients[i];
            currPerson++;
        }

        return luckies;
    }

    /*
     * Client to test the methods you write
     */
    public static void main (String[] args) {

        HeartTransplant ht = new HeartTransplant();

        // read persons from file
        int numberOfLines = StdIn.readInt();
        int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " patients read from file.");
 
        // read survivability by age from file
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");

        // read survivability by heart condition cause from file        
        numberOfLines = StdIn.readInt();
        numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
        StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");

        /*

        // list all patients
        for (Person p : ht.getListOfPatients()) {
            StdOut.println(p);
        }

        // list survivability by age rates
        for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()) {
            StdOut.println(rate);
        }

        // list survivability by cause rates
        for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()) {
            StdOut.println(rate);
        }

        System.out.println(ht.getPatientsWithAgeAbove(9));
        */

        boolean doTest0 = true;
        int ageToCheck = 70;
        boolean doTest1 = true;
        int stateToCheck = 5;
        boolean doTest2 = true;
        int causeToCheck = 2;

        if (doTest0) {
            Person[] test0 = ht.getPatientsWithAgeAbove(ageToCheck);
            System.out.println("ageAbove "+ageToCheck);
            for (Person person : test0) {
                if (person.getAge() == 0) {
                    System.out.print("NULL");
                }
                else {
                    if (person.getAge() < ageToCheck) {
                        System.out.println("ERROR BELOW MIN");
                    } else {
                        System.out.print(person.getAge()+" ");
                    }
                    
                }
            }
            System.out.println("\narrayLength: "+test0.length);
        }
       
        if (doTest1) {
            Person[] test1 = ht.getPatientsByStateOfHealth(stateToCheck);
            System.out.println("healthState: "+stateToCheck);
            for (Person person : test1) {
                if (person.getStateOfHealth() == 0) {
                    System.out.print("NULL");
                }
                else {
                    System.out.print(person.getStateOfHealth());
                }
            }
            System.out.println("\narrayLength: "+test1.length);    
        }
        
        if (doTest2) {
            Person[] test2 = ht.getPatientsByHeartConditionCause(causeToCheck);
            System.out.println("heartConditionCause: "+causeToCheck);
            for (Person person : test2) {
                if (person.getCause() == 0) {
                    System.out.print("NULL");
                }
                else {
                    System.out.print(person.getCause());
                }
            }
            System.out.println("\narrayLength: "+test2.length);
        }   
    }
}
