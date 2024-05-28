

public class Lecturer extends Teacher
{//instance variables of Lecturer
    private String department;
    private int YearsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    
    //using the constructor
    public  Lecturer(int teacherId, String teacherName, String address, String workingType,String employmentStatus, String department, int YearsOfExperience, int workingHours){
     super(teacherId, teacherName, address, workingType, employmentStatus);//calling the super class and which containd the five parameter
     super.setworkingHours(workingHours);//calling the super class with a single parameter workingHours
     this.department = department;//Assigning the value into the instance variable department
     this.gradedScore = 0;//Assigining the value into the instance variable gradedScore
     this.YearsOfExperience = YearsOfExperience;//Assigining the value of instance variable YearsOfExperience
     this.hasGraded = false;
    }
    
    //using get method
    
    public String getdepartment(){
        return this.department; //returns the value stored in the instance variable department
    }
    public int getYearsOfExperience(){
        return this.YearsOfExperience;//returns the value store in the instance variable YearsOfExperience
    }
    public int getgradedScore(){
        return this.gradedScore;//returns the value stored in the instance variable gradedScore
    }
    public boolean gethasGraded(){
        return this.hasGraded;//returns the value stored in the instance variable hasGraded
    }
    
    //using setter method for gradedScore
    public void setgradedScore(int gradedScore){
        this.gradedScore = gradedScore;//set the value into the instance variable gradedScore
    }
    
    //creating a method name gradeAssignment
    public void gradeAssignment(int gradedScore, String department, int YearsOfExperience){
    if(YearsOfExperience>=5 && this.department == department){
                this.gradedScore = gradedScore; // Set the gradedScore to the given value

        if(gradedScore>=70){
            System.out.println("The score is A");//prints the score obtained by the students
            this.hasGraded = true;
        }else if(gradedScore>=60 && gradedScore < 70){
            System.out.println("The score is B");//prints the score obtained by the students
            this.hasGraded = true;
        }else if(gradedScore>50 && gradedScore < 60){
            System.out.println("The score is C");//prints the score obtained by the students
            this.hasGraded = true;
        }else if(gradedScore>40 && gradedScore < 50){
            System.out.println("The score is D");
            this.hasGraded = true;
        }else {
            System.out.println("The score is E");//prints the score obtained bt the students
            this.hasGraded = true;
        }
        
        this.hasGraded = true;
    }
    
}

//now using Display method
public void displayteacherdetail(){
    if(hasGraded == true){
    super.displayteacherdetail();  //recalling the super class which is a Teacher class 
    System.out.println("The department is" + this.department);//prints the value stored in department
    System.out.println("The YearsOfExperience is" + this.YearsOfExperience);//print the value stored in YearsOfExperience
    System.out.println("The gradedSore is" + this.gradedScore);//prints the value stored in gradedScore
    }else{
        System.out.println("The student has not been  graded yet");//print the statement if the statement is fals e
    
       }
        
    }
    
}





        


