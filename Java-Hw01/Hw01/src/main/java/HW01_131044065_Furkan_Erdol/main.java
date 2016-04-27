package HW01_131044065_Furkan_Erdol;

import java.util.ArrayList;

/**
 * Test main for course automation system
 * @author furkan
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //CREATES ADMINISTRATOR
        Administrator admin = new Administrator("Furkan Erdol", "furkanerdol", "458769");

        //CREATES TEACHERS
        Teacher teacherA = new Teacher("Erdogan Sevilgen", "esevilgen", "165432");
        Teacher teacherB = new Teacher("Yusuf Sinan Akgul", "ysakgul", "253156");
        Teacher teacherC = new Teacher("Yakup Genc", "ygenc", "859746");
        Teacher teacherD = new Teacher("Mehmet Gokturk", "mgokturk", "956328");
        Teacher teacherE = new Teacher("Hasari Celebi", "hcelebi", "784125");
        Teacher teacherF = new Teacher("Haci Ali Mantar", "hamantar", "382956");
        Teacher teacherG = new Teacher("Murat Seker", "mseker", "786495");

        //CREATES STUDENTS
        Student studentA = new Student("Sefa Nadir Yildiz", "snyildiz", "456879", "131044001");
        Student studentB = new Student("Salih Bektas", "sbektas", "132546", "131044002");
        Student studentC = new Student("Serhat Guzel", "sguzel", "458796", "131044003");
        Student studentD = new Student("Muhammed Selim Dursun", "msdursun", "632589", "131044004");
        Student studentE = new Student("Burak Gunduz", "bgunduz", "458796", "131044005");
        Student studentF = new Student("Ali Karasahin", "akarasahin", "986235", "131044006");
        Student studentG = new Student("Mehmet Onder", "monder", "257184", "131044007");

        //CREATES TUTORS
        Tutor tutorA = new Tutor("Furkan Tektas", "ftektas", "653241", "121044020");
        Tutor tutorB = new Tutor("Necmettin Carkaci", "ncarkaci", "852369", "121044021");
        Tutor tutorC = new Tutor("Abdullah Akay", "aakay", "954867", "121044022");
        Tutor tutorD = new Tutor("Mustafa Fatih Tunali", "mftunali", "658479", "121044023");
        Tutor tutorE = new Tutor("Egemen Kaleli", "ekaleli", "215487", "121044024");
        Tutor tutorF = new Tutor("Arzu Kakisim", "akakisim", "847125", "121044025");

        //CREATES COURSES
        Course courseA = new Course("CSE 122");
        Course courseB = new Course("CSE 222");
        Course courseC = new Course("CSE 322");
        Course courseD = new Course("CSE 422");
        Course courseE = new Course("CSE 522");

        //CREATES ASSIGNMENTS
        Assignment quizA = new Quiz("First quiz", "06 January 2016", "07 January 2016");
        Assignment quizB = new Quiz("Second quiz", "10 February 2016", "01 February 2016");
        Assignment quizC = new Quiz("Third quiz", "17 March 2016", "18 March 2016");
        Assignment homeworkA = new HomeWork("HW01", "16 March 2016", "17 March 2016");
        Assignment homeworkB = new HomeWork("HW02", "22 March 2016", "23 March 2016");
        Assignment homeworkC = new HomeWork("HW03", "10 April 2016", "11 April 2016");
        Assignment homeworkD = new HomeWork("HW04", "02 May 2016", "03 May 2016");
        Assignment homeworkE = new HomeWork("HW05", "25 June 2016", "26 June 2016");
        Assignment groupProjectA = new GroupProject("First group project", "26 April 2016", "27 April 2016");
        Assignment groupProjectB = new GroupProject("Second group project", "11 June 2016", "12 June 2016");
        Assignment groupProjectC = new GroupProject("Third group project", "22 April 2016", "23 April 2016");

        //CREATES DOCUMENTS
        Document fileA = new File("Lesson lectures I");
        Document fileB = new File("Lesson lectures II");
        Document fileC = new File("Lesson lectures III");
        Document slideA = new Slide("Lesson slides I");
        Document slideB = new Slide("Lesson slides II");
        Document slideC = new Slide("Lesson slides III");
        Document urlA = new Url("https://www.google.com.tr");
        Document urlB = new Url("http://www.ntvspor.net");
        Document urlC = new Url("http://www.pinterrail.com");
        Document bookA = new Book("Data Structers And Algorithms");
        Document bookB = new Book("Unix System Programming");
        Document bookC = new Book("Objective C");
        Document whiteBoardDescriptionA = new WhiteBoardDescriptions("White board description sample 1");
        Document whiteBoardDescriptionB = new WhiteBoardDescriptions("White board description sample 2");
        Document whiteBoardDescriptionC = new WhiteBoardDescriptions("White board description sample 3");

        //ADMINISTRATOR ADDING TEACHERS TO INSIDE COURSE AUTOMATION SYSTEM
        admin.addUser(teacherA);
        admin.addUser(teacherB);
        admin.addUser(teacherC);
        admin.addUser(teacherD);
        admin.addUser(teacherE);
        admin.addUser(teacherF);
        admin.addUser(teacherG);

        //ADMINISTRATOR ADDING STUDENTS TO INSIDE COURSE AUTOMATION SYSTEM
        admin.addUser(studentA);
        admin.addUser(studentB);
        admin.addUser(studentC);
        admin.addUser(studentD);
        admin.addUser(studentE);
        admin.addUser(studentF);
        admin.addUser(studentG);

        //ADMINISTRATOR ADDING TUTORS TO INSIDE COURSE AUTOMATION SYSTEM
        admin.addUser(tutorA);
        admin.addUser(tutorB);
        admin.addUser(tutorC);
        admin.addUser(tutorD);
        admin.addUser(tutorE);
        admin.addUser(tutorF);

        //ADMINISTRATOR ADDING COURSES TO INSIDE COURSE AUTOMATION SYSTEM
        admin.addCourse(courseA);
        admin.addCourse(courseB);
        admin.addCourse(courseC);
        admin.addCourse(courseD);
        admin.addCourse(courseE);

        //ADMINISTRATOR ADDING TEACHERS TO INSIDE COURSES
        admin.addUserToCourse(courseA, teacherA);
        admin.addUserToCourse(courseA, teacherB);
        admin.addUserToCourse(courseB, teacherC);
        admin.addUserToCourse(courseB, teacherD);
        admin.addUserToCourse(courseC, teacherE);
        admin.addUserToCourse(courseC, teacherF);
        admin.addUserToCourse(courseD, teacherG);
        admin.addUserToCourse(courseD, teacherA);
        admin.addUserToCourse(courseE, teacherB);
        admin.addUserToCourse(courseE, teacherC);

        //ADMINISTRATOR ADDING STUDENTS AND TUTORS TO INSIDE CSE 122 (courseA)
        admin.addUserToCourse(courseA, studentA);
        admin.addUserToCourse(courseA, studentB);
        admin.addUserToCourse(courseA, studentC);
        admin.addUserToCourse(courseA, studentD);
        admin.addUserToCourse(courseA, tutorA);
        admin.addUserToCourse(courseA, tutorB);

        //ADMINISTRATOR ADDING STUDENTS AND TUTORS TO INSIDE CSE 222 (courseB)
        admin.addUserToCourse(courseB, studentE);
        admin.addUserToCourse(courseB, studentF);
        admin.addUserToCourse(courseB, studentG);
        admin.addUserToCourse(courseB, tutorB);
        admin.addUserToCourse(courseB, tutorC);

        //ADMINISTRATOR ADDING STUDENTS AND TUTORS TO INSIDE CSE 322 (courseC)
        admin.addUserToCourse(courseC, studentF);
        admin.addUserToCourse(courseC, studentA);
        admin.addUserToCourse(courseC, studentD);
        admin.addUserToCourse(courseC, studentC);
        admin.addUserToCourse(courseC, tutorD);
        admin.addUserToCourse(courseC, tutorE);

        //ADMINISTRATOR ADDING STUDENTS AND TUTORS TO INSIDE CSE 422 (courseD)
        admin.addUserToCourse(courseD, studentB);
        admin.addUserToCourse(courseD, studentC);
        admin.addUserToCourse(courseD, studentG);
        admin.addUserToCourse(courseD, studentD);
        admin.addUserToCourse(courseD, tutorD);
        admin.addUserToCourse(courseD, tutorA);

        //ADMINISTRATOR ADDING STUDENTS AND TUTORS TO INSIDE CSE 522 (courseE)
        admin.addUserToCourse(courseE, studentD);
        admin.addUserToCourse(courseE, studentE);
        admin.addUserToCourse(courseE, studentG);
        admin.addUserToCourse(courseE, studentA);
        admin.addUserToCourse(courseE, studentC);
        admin.addUserToCourse(courseE, tutorA);
        admin.addUserToCourse(courseE, tutorD);
        admin.addUserToCourse(courseE, tutorE);

        //ADMINISTRATOR LOOKING REGISTERED USER IN COURSE AUTOMATION SYSTEM
        System.out.println("\n\n\n========== ADMINISTRATOR ADDS USERS AND COURSES TO COURSE AUTOMATION SYSTEM ==========");
        System.out.println("\n========== ADMINISTRATOR LOOKING REGISTERED USER IN COURSE AUTOMATION SYSTEM ==========");
        admin.showRegisteredUsers();

        //ADMINISTRATOR LOOKING REGISTERED COURSES IN COURSE AUTOMATION SYSTEM
        System.out.println("\n\n\n========== ADMINISTRATOR LOOKING REGISTERED COURSES IN COURSE AUTOMATION SYSTEM ==========");
        admin.showRegisteredCourses();

        //ADMINISTRATOR REMOVING CSE 422 (courseD) AND CSE 522 (courseE)
        admin.removeCourse(courseD);
        admin.removeCourse(courseE);
        System.out.println("\n\n\n========== ADMINISTRATOR REMOVING CSE 422 (courseD) AND CSE 522 (courseE) ==========");
        admin.showRegisteredCourses();

        //ERDOGAN SEVILGEN (teacherA) ADDING DOCUMENTS TO CSE 122 (courseA)
        System.out.println("\n\n\n========== ERDOGAN SEVILGEN (teacherA) ADDS DOCUMENTS TO CSE 122 (courseA) ==========");
        teacherA.addDocumentToCourse(courseA, fileA);
        teacherA.addDocumentToCourse(courseA, slideA);
        teacherA.addDocumentToCourse(courseA, bookA);
        teacherA.addDocumentToCourse(courseA, urlA);
        teacherA.addDocumentToCourse(courseA, whiteBoardDescriptionA);
        //ERDOGAN SEVILGEN (teacherA) ADDING ASSINGMENTS TO CSE 122 (courseA)
        System.out.println("\n========== ERDOGAN SEVILGEN (teacherA) ADDS ASSINGMENTS TO CSE 122 (courseA) ==========");
        teacherA.addAssignmentToCourse(courseA, quizA);
        teacherA.addAssignmentToCourse(courseA, homeworkA);
        teacherA.addAssignmentToCourse(courseA, groupProjectA);
        //ERDOGAN SEVILGEN (teacherA) LOOKING CSE 122 (courseA) CONTENT
        System.out.println("\n========== ERDOGAN SEVILGEN (teacherA) LOOKING CSE 122 (courseA) CONTENT ==========");
        teacherA.showCourseContent(courseA);

        //CREATES NEW STUDENTS
        Student studentH = new Student("Register Ahmet", "rahmet", "458769", "141044015");
        Student studentI = new Student("Register Mehmet", "rmehmet", "325614", "141044016");
        Student studentJ = new Student("Register Ayse", "rayse", "856923", "141044017");

        //STUDENTS REQUEST TO ADMINISTRATOR
        System.out.println("\n\n\n========== STUDENTS REQUEST TO ADMINISTRATOR ==========");
        studentH.requestForRegister();
        studentI.requestForRegister();
        studentJ.requestForRegister();

        //ADMINISTRATOR CONFIRMS REQUESTS
        System.out.println("\n========== ADMINISTRATOR CONFIRMS REQUESTS ==========");
        admin.confirmRequests();
        admin.showRegisteredUsers();

        //ADMINISTRATOR ADDING ABDULLAH AKAY (tutorC) TO CSE 122 AS A STUDENT
        System.out.println("\n\n\n========== ADMINISTRATOR ADDED ABDULLAH AKAY (tutorC) TO CSE 122 AS A STUDENT ==========");
        admin.addTutorADiffrentCourseAsAStudent(courseA, tutorC);
        admin.showRegisteredCourses();

        //SEFA NADIR YILDIZ UPLOAD ASSIGNMENT TO FIRST QUIZ (quizA), HW02 (homeworkb) AND THIRD GROUP PROJECT (groupProjectC)
        System.out.println("\n\n\n========== SEFA NADIR YILDIZ UPLOAD ASSIGNMENT TO FIRST QUIZ (quizA), HW02 (homeworkB) AND THIRD GROUP PROJECT (groupProjectC) ==========");
        studentA.uploadAssignment(quizA);
        studentA.uploadAssignment(homeworkA);
        studentA.uploadAssignment(groupProjectA);

        System.out.println("\n========== SEFA NADIR YILDIZ LOOKING HIS ASSIGNMENTS AND GRADES ==========");
        studentA.showGrades();

        //ERDOGAN SEVILGEN (teacherA) REMOVED DOCUMENTS AND ASSIGNMENTS FROM CSE 122 (courseA)
        System.out.println("\n========== ERDOGAN SEVILGEN (teacherA) REMOVED DOCUMENTS AND ASSIGNMENTS FROM CSE 122 (courseA) ==========");
        teacherA.removeDocumantFromCourse(courseA, fileA);
        teacherA.removeDocumantFromCourse(courseA, slideA);
        teacherA.removeDocumantFromCourse(courseA, bookA);
        teacherA.removeAssignmentFromCourse(courseA, groupProjectA);
        teacherA.removeAssignmentFromCourse(courseA, homeworkA);
        teacherA.showCourseContent(courseA);

        //ERDOGAN SEVILGEN (teacherA) REMOVED STUDENTS AND TUTORS FROM CSE 122 (courseA)
        System.out.println("\n\n\n========== ERDOGAN SEVILGEN (teacherA) REMOVED STUDENTS AND TUTORS FROM CSE 122 (courseA) ==========");
        teacherA.removeUserFromCourse(courseA, studentA);
        teacherA.removeUserFromCourse(courseA, studentB);
        teacherA.removeUserFromCourse(courseA, studentC);
        teacherA.removeUserFromCourse(courseA, studentD);
        teacherA.removeUserFromCourse(courseA, tutorA);
        teacherA.removeUserFromCourse(courseA, tutorB);
        teacherA.removeUserFromCourse(courseA, tutorC);
        teacherA.showRegisteredCourses();

        //ERDOGAN SEVILGEN (teacherA) LOOKING OLD COURSES
        System.out.println("\n\n\n========== ERDOGAN SEVILGEN (teacherA) LOOKING OLD COURSES ==========");
        teacherA.showOldCourses();

        //Furkan Tektas (tutorA) LOOKING OLD COURSES
        System.out.println("\n\n\n========== Furkan Tektas (tutorA) LOOKING OLD COURSES ==========");
        tutorA.showOldCourses();

    }

}
