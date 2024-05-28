   

public class Teacher
{//instance variables of super class which is a teacher class
   private int teacherId; 
   private String teacherName;
   private String address;
   private String workingType;
   private String employmentStatus;
   private int workingHours;
   
   //creating constructor Teacher
   public Teacher(int teacherId, String teacherName, String address, String workingType, String employmentStatus){
       this.teacherId = teacherId;//call is made from superclass which is a parent class
       this.teacherName = teacherName;//Assigning the value into the instance variable teacherName
       this.address = address;//Assigining the value into instance variable address
       this.workingType = workingType;//Assigning the value into the instance variable workingType
       this.employmentStatus = employmentStatus;//Assigining the value into the instance variable employmentStatus
       
       
   }
   //using getter method
   public int getteacherId(){
       return this.teacherId;//get the teacherId from instance variable 
   }
   public String getteacherName(){
       return this.teacherName;//get the teacherName from instance variable
   }
   public String getaddress(){
       return this.address;//get the address from instance variable
   }
   public String getworkingType(){
       return this.workingType;//get the workingType from instance variable
   }
   public String getemploymentStatus(){
       return this.employmentStatus;//get the employmentStatus from instance variable
   }
   public int getworkingHours(){
       return this.workingHours;//get the workingHours from the instance variable
   }
   
   //using setter method on working hours
   
   public void setworkingHours(int workingHours){
     this.workingHours = workingHours; //set the value of instance variable workingHours
   }
   
   //creating the the display method
   
   public void displayteacherdetail(){
       System.out.println("This is teacher's Id " + this.teacherId);//print the values stored in teachersId
       System.out.println("This is teacher's teacherName " + this.teacherName);
       System.out.println("This is teacher's address " + this.address);
       System.out.println("This is teacher's workingType " + this.workingType);
       System.out.println("This is teacher's employmentStatus " + this.employmentStatus);
       if (workingHours>0){
       System.out.println("This is teacher's workingHours " + this.workingHours);//prints the value stored in workingHours
    }
    else{
        System.out.println("Assign the working hours"); //print this statement if the statement is false
    }
    
   
   
}
}