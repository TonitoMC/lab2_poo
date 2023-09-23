public class Course {
    private int grade;
    private String name;

    public Course(int grade, String name){
        this.grade = grade;
        this.name = name;
    }
    public int getGrade(){
        return grade;
    }
public String getName(){
        return name;
}
public String getDetails(){
        return name + " - " + grade;
}
}
