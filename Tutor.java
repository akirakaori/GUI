

public class Tutor extends Teacher
{//instance variable of Tutor
    private double salary;
    private String specialization;
    private String academicQualifications;
    private int performanceIndex;
    private boolean isCertified;
    
    //using the constructor
    public Tutor(int teacherId, String teacherName, String address, String workingType, String employmentStatus,int workingHours, double salary, String specialization, String academicQualifications ,int performanceIndex){
      super(teacherId, teacherName, address, workingType, employmentStatus); 
      super.setworkingHours(workingHours);      //call is made to the workingHour of super class
      this.academicQualifications = academicQualifications;//Assign the value in the instance variable in academicQualification
      this.salary = salary;//Assigining the vaule in th4e instance variable in salary
      this.specialization = specialization;//Assigining the vaule in th4e instance variable in specialization
      this.performanceIndex = performanceIndex;//Assigining the vaule in th4e instance variable in performanceIndex
      this.isCertified=false;
      
    }
      
      //using acessor method 
      
      public double getsalary(){
          return this.salary;//returns the value stored in the instance variable salary
      }
      public String getspecialization(){
          return this.specialization;//returns the value stored in the instance variable specialization
      }
      public String getacademicQualifications(){
          return this.academicQualifications;//returns the value stored in the instance variable academicQualification
        }
      public int getperformanceIndex(){
          return this.performanceIndex; //returns the value stored in the instance variable performanceIndex
      }
      public boolean getisCertified(){
          return this.isCertified; //returns the value stored in the instance variable isCertified
      }
      
      //mutator method is required in salary
      
      public void setsalary(double newSalary, int newPerformanceIndex){
          this.salary=newSalary; //Assigining the value in the instance variable newSalary
          this.performanceIndex= newPerformanceIndex; //Assigining the value of instance variable newPerformanceIndex 
          
          
          if(performanceIndex>5 && performanceIndex<=7 && super.getworkingHours() > 20){
              salary =newSalary+(0.05*newSalary);//calculating the salary
              this.isCertified=true;
        
           }else if (performanceIndex>7 || performanceIndex<=9 && super.getworkingHours() > 20){
                salary =newSalary+ (0.1*newSalary) ;//calculating the salary
                this.isCertified=true;
            
              }else if (performanceIndex ==10 && super.getworkingHours() > 20){
                    salary = newSalary + (0.2*newSalary);//calculating the salary
                    this.isCertified=true;
                    
           }else{
             System.out.println("workingHours is not greater than 20 so salary cannot be approved and calculated");//print the statement if the workinghOurs is not greater than 20
         }
           
      
               
    }
    //creating new method name removeTutor
     
    public void removeTutor(){
        this.salary = 0;//setting the value of salary to zero
        this.specialization = "0";//setting the value of salary to zero
        this.academicQualifications = "0";//setting the value of salary to zero
        this.performanceIndex =0;//setting the value of salary to zero
        this.isCertified = false;
        
    }
    
    //creating the display method
    
    public void displayteacherdetail(){
        if(this.isCertified == true){
            super.displayteacherdetail();     //call the display method of the super class
            System.out.println("The salary is"+ salary);//printing the value stored in salary
            System.out.println("The specialization is"+ specialization);//printing the value stored in specialization
            System.out.println("The academicQualifications is "+academicQualifications);//printing the value stored in academicQualificarion
            System.out.println("The isCertified is"+ isCertified);//printing the value stored in isCertified
            
            
        }else{
            super.displayteacherdetail();
        }
    }
}
     
          
    
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    
