import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This program is a tool for a student to track his grades. Sends alerts when the student is doing well
 * or badly taking into account his current grades.
 * @author Jose Merida
 * @version 1.0
 * @since 22-09-2023
 */

public class Main {
    /**
     * Main method used as Driver for the whole program
     * Displays menus and utilizes Student and Course methods to navigate
     * the program and display information
     */
    public static void main(String[] args) {
        /**
         * Creates a new Student and requests for 5 courses to be added to its ArrayList attribute
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Antes de iniciar, por favor ingrese su nombre");
        String currentStudentName = scanner.nextLine();
        Student currentStudent = new Student(currentStudentName);
        System.out.println("Para iniciar debe de ingresar 5 asignaturas que esta cursando y su promedio en cada una");
        for(int i = 0; i < 5; i++){
            try {
                System.out.println("Por favor ingrese el nombre de la asignatura");
                String currentCourseName = scanner.nextLine();
                System.out.println("Por favor ingrese su promedio actual de la asignatura (unicamente valores enteros");
                int currentCourseGrade = scanner.nextInt();
                scanner.nextLine();
                Course currentCourse = new Course(currentCourseGrade, currentCourseName);
                currentStudent.addCourse(currentCourse);
            } catch (InputMismatchException e){
                System.out.println("Entrada no valida, debe ingresar un valor entero para el promedio");
                scanner.nextLine();
                i--;
            }
        }
        /**
         * Main menu loop, used to navigate the main options inside of the program
         */
    while(true){
        System.out.println("Selecciona el numero de opcion a la que deseas ingresar:");
        System.out.println("1. Mostrar el promedio general");
        System.out.println("2. Mostrar la clase con la nota mas alta");
        System.out.println("3. Mostrar todas las asignaturas");
        System.out.println("4. Salir");
        /**
         * Displays alerts of the student has a grade under 10 on a course or has an average
         * grade above 90 in his courses.
         */
        if (currentStudent.getAverage() > 90){
            System.out.println("Felicidades, tu promedio general se encuentra por encima de 90");
        }
        ArrayList<Course> coursesUnder10 = currentStudent.getAlerts();
        if (coursesUnder10.size() <= 0){
            System.out.println("No tienes alertas por el momento");
        }
        else{
            System.out.println("Tiene " + coursesUnder10.size() + " cursos con un promedio menor a 10");
            for (int i = 0; i < coursesUnder10.size(); i++){
                Course currentCourse = coursesUnder10.get(i);
                System.out.println(currentCourse.getName());
            }
        }
        /**
         * Exception if the user enters a non-integer value
         */
        int mainSelect = 0;
        try {
            mainSelect = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e){
            System.out.println("Seleccion no valida");
            scanner.nextLine();
            continue;
        }
        /**
         * Switch case for main selection
         */
        switch (mainSelect){
            /**
             * Prints out current average across all Courses
             */
            case 1:
                System.out.println("Su promedio actual es de " + currentStudent.getAverage());
                break;
            /**
             * Prints out course name and current grade for the Course with the highest grade
             */
            case 2:
                System.out.println(currentStudent.getHighestGrade());
                break;
            /**
             * Gets courseList from current Student, prints out information of every course
             * as it moves through the ArrayList
             */
            case 3:
                ArrayList<Course> currentCourseList = currentStudent.getCourseList();
                for (int i = 0; i < currentCourseList.size(); i++){
                    Course currentCourse = currentCourseList.get(i);
                    System.out.println(currentCourse.getDetails());
                }
                break;
            /**
             * Exits the program
             */
            case 4:
                System.out.println("Saliendo del programa");
                System.exit(0);
                break;
            /**
             * Returns to main menu loop if the user's input is an integer not considered in the switch case
             */
            default:
                System.out.println("Seleccion no valida");
                break;
        }
    }

        }
    }