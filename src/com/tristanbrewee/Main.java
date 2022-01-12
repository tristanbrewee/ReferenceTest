package com.tristanbrewee;

public class Main {

    private static final String TEXT1 = "This program will prove that Java doesn't use pass-by-reference, " +
            "but pass-by-value for Objects as well. We will create a new Student (studentMain) inside our main method " +
            "with the name \"Original Name\".";
    private static final String TEXT2 = "When we print the name of \"studentMain\" we get: ";
    private static final String TEXT3 = "Now we will call the method \"changeStudentName()\". This should change the " +
            "name of \"studentMain\" into \"Changed Name\"";
    private static final String TEXT4 = "We're inside \"changeStudentName()\" and called \"setName()\" on the parameter " +
            "(studentAsParam). The name of \"studentAsParam\" now is: ";
    private static final String TEXT5 = "We're back in the main method now. The name of \"studentMain\" now is: ";
    private static final String TEXT6 = "So far, so good. But now comes the tricky part. We will try and assign a new " +
            "Student to \"studentMain\" inside a method. \n" +
            "If Student is truly pass-by-reference, then this should effect " +
            "both \"studentAsParam\" inside the method, as the \"studentMain\" in the main method.";
    private static final String TEXT7 = "We are now inside \"changeStudent()\" and assigned a \"new Student()\" to " +
            "\"studentAsParam\". The name of \"studentAsParam\" now is: ";
    private static final String TEXT8 = "We're back in the main method now. The name of \"studentMain\" is: ";
    private static final String EXPLANATION = "The fact that the name changed in both \"studentMain\" as " +
            "\"studentAsParam\" when we called \"changeName()\", proves that both the \"studentMain\" and " +
            "\"studentAsParam\" point to the same location in memory.\n" +
            "The fact that the name changed in \"studentAsParam\", but not in \"studentMain\" when we called " +
            "\"changeStudent()\", proves that \"studentMain\" and \"studentAsParam\" are not the same reference.\n" +
            "These \"references\" are called \"object handles\" and are passed-by-value. If you're interested, have a " +
            "quick Google-search on them.";

    public static void main(String[] args) {
        System.out.println(TEXT1);
        Student studentMain = new Student("Original Name");
        System.out.println(TEXT2 + studentMain.getName());

        System.out.println();

        System.out.println(TEXT3);
        changeStudentName(studentMain);
        System.out.println(TEXT5 + studentMain.getName());

        System.out.println();

        System.out.println(TEXT6);
        changeStudent(studentMain);
        System.out.println(TEXT8 + studentMain.getName());

        System.out.println();

        System.out.println(EXPLANATION);
    }

    private static void changeStudentName(Student studentAsParam){
        studentAsParam.setName("Changed Name");
        System.out.println(TEXT4 + studentAsParam.getName());
    }

    public static void changeStudent(Student studentAsParam){
        studentAsParam = new Student("New Student");
        System.out.println(TEXT7 + studentAsParam.getName());
    }
}
