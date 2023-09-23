import java.util.ArrayList;

/**
 * This class stores information related to a student, his current courses
 * and grades in each course
 * @author Jose Merida
 * @version 1.0
 * @since 22=09-2023
 */
public class Student {
    private String name;
    private ArrayList<Course> courseList;
    public Student(String name){
        this.name = name;
        this.courseList = new ArrayList<Course>();
    }
    public int getAverage(){
        int currentSum = 0;
        for (int i = 0; i < courseList.size(); i++){
            Course currentCourse = courseList.get(i);
            currentSum = currentSum + currentCourse.getGrade();
        }
        return currentSum / (courseList.size());
    }
public String getHighestGrade(){
        int highestGrade = 0;
        int highestGradeIndex = 0;
    for (int i = 0; i < courseList.size(); i++){
        Course currentCourse = courseList.get(i);
        int currentGrade = currentCourse.getGrade();
        if (currentGrade > highestGrade){
            highestGrade = currentGrade;
            highestGradeIndex = i;
        }
    }
    return "Su mejor clase es " + courseList.get(highestGradeIndex).getName() + " con una nota de " + highestGrade;
}
public ArrayList getCourseList(){
        return courseList;
}
public void addCourse(Course courseToAdd){
        courseList.add(courseToAdd);
}
public ArrayList getAlerts(){
        ArrayList<Course> coursesUnder10 = new ArrayList<Course>();
    for(int i = 0; i < courseList.size(); i++){
        Course currentCourse = courseList.get(i);
        if(currentCourse.getGrade()<10){
        coursesUnder10.add(currentCourse);
        }
    }
    return coursesUnder10;
}
}
