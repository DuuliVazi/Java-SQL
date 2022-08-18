import java.util.Scanner;
import java.util.Vector;

public class Student {
    // All variables that will be used throughout program to add functionality.
    private int studentId;
    private String Name;
    private float qualExamMarks;
    private char resStatus;
    private int yearOfEng;
    private String teachername;
    // Vector used within DisplayDetails() function.
    Vector<String> vec = new Vector<String>();

    /*
     * Setter and getter functions created in order for variables to be used
     * throughout program to add functionality.
     */

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void setQualExamMarks(float qualExamMarks) {
        this.qualExamMarks = qualExamMarks;
    }

    public float getQualExamMarks() {
        return qualExamMarks;
    }

    public void setresStatus(char resStatus) {
        this.resStatus = resStatus;
    }

    public char getresStatus() {
        return resStatus;
    }

    public void setyearOfEng(int yearOfEng) {
        this.yearOfEng = yearOfEng;
    }

    public int getyearOfEng() {
        return yearOfEng;
    }

    /*
     * Function for intro to program. I could've simply output it in the main file.
     * But I will use it later to make a really cool intro.
     */
    public void Nathing() {
        System.out.println("CARPE DIEM. SIEZE THE DAY!!");
        return;
    }

    /*
     * This function is used to give option to teacher if he/she wants to see
     * student info. If they do, then it utilizes another function I made which is
     * Check(int passcode) So, if they choose to see their students' info, then they
     * must enter their admin password (lines 85-86) And they don't then it utilizes
     * the simple string output function which is Nathing() (lines 89-90). And
     * Nathing() breaks the program right after the output.
     */
    public void Choice(String choice) {

        Scanner check1 = new Scanner(System.in);

        System.out.println("HI PROFESSOR, PLEASE ENTER YOUR NAME TO THE SCREEN BELOW:");
        teachername = check1.nextLine();
        System.out.println('\n');

        System.out.println("--GREETINGS AND SALUTATIONS PROFESSOR " + teachername
                + "! IF YOU WOULD LIKE TO VIEW YOUR INCOMING STUDENTS FOR THE YEAR, TYPE Yes/yes AND IF NOT, YOU CAN PRESS ANY OTHER KEY.--\n");
        choice = check1.nextLine();

        if (choice.equals("Yes") || choice.equals("yes")) {
            Student ch = new Student();
            ch.Check(0);
        } else {
            System.out.println("OKAY, THEN. CLOSING SPREADSHEET...\n");
            Student breaks = new Student();
            breaks.Nathing();
            System.exit(resStatus);
        }
        check1.close();

    }

    // Function that is a password checker for teacher.
    public void Check(int passcode) {
        // Scanner created for user input.
        Scanner check = new Scanner(System.in);

        System.out.println("--WHAT IS YOUR 4 DIGIT TEACHER ADMIN CODE?--");
        // Must use check.nextInt() so program can understand to check whatever int
        // input will be entered on the next line.
        passcode = check.nextInt();
        if (passcode == 1234) {
            System.out.println("** ACCESS GRANTED **");
            System.out.println("LOADING SPREADSHEET  RIGHT NOW, GIVE IT A MINUTE OR TWO...\n");

            /*
             * Lines 64- are objects created which use the setter and getter methods for all
             * student info. So, I use set... to set int and String values to whatever and I
             * use get...to retrieve them.
             */

            Student test1 = new Student();
            test1.setStudentId(30);
            System.out.println("STUDENT ID: " + test1.getStudentId());

            Student test2 = new Student();
            test2.setName("Mike");
            System.out.println("STUDENT NAME: " + test2.getName());

            Student test3 = new Student();
            test3.setQualExamMarks(4);
            System.out.println("EXAM GRADES: " + test3.getQualExamMarks());

            Student test4 = new Student();
            test4.setresStatus('L');
            System.out.println("RESIDENTIAL STATUS: " + test4.getresStatus());

            Student test5 = new Student();
            test5.setyearOfEng(3);
            System.out.println("YEAR OF ENGLISH: " + test5.getyearOfEng());

            /*
             * Used to connect qualExamMarks and it's conditions. So, in this case using the
             * exam score of 4 places them in the ABOVE AVERAGE category.
             */
            DisplayDetails(4);

        } else {
            System.out.println("!! ACCESS DENIED !!\nIF YOU HAVE FURTHER TROUBLE PLEASE CONTACT THE HELP DESK.");
            System.exit(passcode);
        }
        check.close();
    }

    /*
     * Function created to place student into a category based on their exam scores.
     * It then adds their category string to the vector I created at beginning of
     * program. It is used in tandem with the Check(int passcode) function to put
     * next to the rest of the students' info.
     */
    public void DisplayDetails(float qualExamMarks) {
        if (qualExamMarks <= 2.5) {
            vec.add("BELOW AVERAGE");
            System.out.println("+= STUDY PLAN =+\n" + vec + '\n');
        } else if (qualExamMarks > 2.5 && qualExamMarks <= 3.5) {
            vec.add("AVERAGE");
            System.out.println("+= STUDY PLAN =+\n" + vec + '\n');
        } else if (qualExamMarks > 3.5 && qualExamMarks <= 4.5) {
            vec.add("ABOVE AVERAGE");
            System.out.println("+= STUDY PLAN =+\n" + vec + '\n');
        } else if (qualExamMarks > 4.5 && qualExamMarks <= 6) {
            vec.add("EXCEPTIONAL");
            System.out.println("+= STUDY PLAN =+\n" + vec + '\n');
        }

    }

}
