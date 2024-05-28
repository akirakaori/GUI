import java.awt.*;// Importing classes for graphical components and layout
import javax.swing.*;// Importing Swing classes for creating GUI components
import java.util.ArrayList;// Importing ArrayList to maintain a list of objects
import java.awt.event.*;  // Importing event handling classes       
import javax.swing.JFrame;  // Importing JFrame for creating application windows
import javax.swing.JLabel;  // Importing JLabel for displaying text labels
import javax.swing.JPanel;   // Importing JPanel for organizing components
import javax.swing.JComboBox;// Importing JComboBox for drop-down selection
import java.awt.event.ActionListener;// Importing ActionListener interface for handling events

public class Teacher_GUI implements ActionListener{
    // Frames for different sections of the application
    private JFrame  main_JF, submain_JF, lecturer_JF, tutor_JF;
    // Panels for organizing GUI components
    private JPanel main_JP, submain_JP, lecturer_JP, tutor_JP;
     // Labels for displaying text in various sections
    private JLabel main_LBL, main_LBLSUB, submain_LBLHEAD,submain_NOTE, lecturer_LBLHEAD, tutor_LBLHEAD,lecturer_teacherId, lecturer_teacherName, lecturer_address, lecturer_workingType, lecturer_employmentStatus, lecturer_department,lecturer_yearsOfExperience, lecturer_workingHours,
    tutor_teacherId, tutor_teacherName, tutor_address, tutor_workingType, tutor_employmentStatus, tutor_workingHours, tutor_salary, tutor_specialization, tutor_academicQualifications, tutor_performanceIndex;
    // Text fields for user input
    private JTextField lecturer_teacherId_TF, lecturer_teacherName_TF, lecturer_address_TF, lecturer_workingType_TF, lecturer_employmentStatus_TF, lecturer_department_TF, lecturer_yearsOfExperience_TF, lecturer_workingHours_TF;

    private JTextField tutor_teacherId_TF, tutor_teacherName_TF, tutor_address_TF, tutor_workingType_TF, tutor_employmentStatus_TF, tutor_workingHours_TF, tutor_salary_TF, tutor_specialization_TF, tutor_academicQualifications_TF, tutor_performanceIndex_TF;
      // Buttons for user interactions   
    private JButton main_EXIT, main_CONTINUE, submain_LECTURER, submain_TUTOR, submain_BACK, submain_EXIT;

    private JButton lecturer_ADD, lecturer_GRADE, lecturer_DISPLAY, lecturer_BACK, lecturer_CLEAR;

    private JButton tutor_ADD, tutor_SETSALARY, tutor_REMOVE, tutor_DISPLAY, tutor_BACK, tutor_CLEAR;
    // Combo boxes for drop-down selections
    private JComboBox lecturer_workingType_JCB , tutor_employmentStatus_JCB, tutor_workingType_JCB ,lecturer_employmentStatus_JCB;
    // List to store Teacher objects
    ArrayList<Teacher> teacher_arrayList = new ArrayList<Teacher>();
    // Constructor to initialize the GUI components and set up the frames
    public Teacher_GUI(){
        mainFrame();  // Initialize the main frame
        submainFrame();  // Initialize the sub-main frame
        lecturerFrame();  // Initialize the lecturer frame
        TutorFrame();    // Initialize the tutor frame
    }

    public void mainFrame() {
        // Initialize the main JFrame and set its properties
        main_JF = new JFrame();
        main_JF.setLayout(null);  // Disable default layout to allow custom placement of components
        main_JF.setTitle("Teacher Management System");
        main_JF.setBounds(0, 0, 1100, 750);  // Set position and size of the frame
        main_JF.setResizable(false);  // Prevent resizing of the frame

        // Create a new JPanel with background image
        main_JP = new JPanel() {
            private static final long serialVersionUID = 1L;  // Default serialVersionUID for serialization
            private Image backgroundImage = new ImageIcon("C:/Users/ashika/Desktop/23049341 Ashika kambang/Development/Resources/unibuilding.jpg").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);  // Call superclass method to ensure proper rendering
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        main_JP.setLayout(null);  // Allow custom placement of components
        main_JP.setBounds(0, 0, 1100, 750);   // Set the size and position of the JPanel
        main_JF.setContentPane(main_JP);   // Set the JPanel as the content pane for the frame

        // Create and configure the welcome label
        main_LBL = new JLabel("Welcome To Teacher Management System");
        main_LBL.setBounds(300, 122, 588, 36);
        main_LBL.setFont(new Font("Arial", Font.PLAIN, 30));
        main_LBL.setForeground(Color.WHITE); // Set text color to white for better visibility
        main_JP.add(main_LBL);// Add the label to the panel

        main_LBLSUB = new JLabel("Manage lecturers, tutors, and track their performance.");
        main_LBLSUB.setBounds(370, 180, 588, 36);
        main_LBLSUB.setFont(new Font("Arial", Font.PLAIN, 15));
        main_LBLSUB.setForeground(Color.WHITE); // Set text color to white for better visibility
        main_JP.add(main_LBLSUB);

        main_EXIT = new JButton("Exit");
        main_EXIT.setBounds(90, 600, 150, 50);
        main_EXIT.setFont(new Font("Arial", Font.PLAIN, 25));
        main_EXIT.setFocusable(false);  // Disable focusable (no dotted lines around text when selected)
        main_EXIT.addActionListener(this); // Set action listener for handling clicks

        main_JP.add(main_EXIT);

        main_CONTINUE = new JButton("Continue");
        main_CONTINUE.setBounds(887, 600, 150, 50);
        main_CONTINUE.setFont(new Font("Arial", Font.PLAIN, 25));
        main_CONTINUE.setFocusable(false);
        main_CONTINUE.addActionListener(this);
        main_JP.add(main_CONTINUE);

        main_JF.setVisible(true);
        main_JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void submainFrame() {
        // Initialize the sub-main frame with title and properties
        submain_JF = new JFrame();
        submain_JF.setTitle("Teacher Management System");
        submain_JF.setBounds(0, 0, 1100, 750);
        submain_JF.setResizable(false);
        submain_JF.getContentPane().setBackground(new Color(255, 255, 255));
        // Create and configure the main panel
        submain_JP = new JPanel();
        submain_JP.setLayout(null);
        submain_JP.setBounds(0, 0, 1100, 750);
        submain_JP.setBackground(new Color(245, 249, 249));
        submain_JF.add(submain_JP);
         // Create and configure the header label
        submain_LBLHEAD = new JLabel("Choose a teacher type to manage.");
        submain_LBLHEAD.setBounds(320, 79, 588, 44);
        submain_LBLHEAD.setFont(new Font("Arial", Font.PLAIN, 30));
        submain_JP.add(submain_LBLHEAD);

        submain_LECTURER = new JButton("LECTURER");
        submain_LECTURER.setBounds(246, 205, 250, 271);
        submain_LECTURER.setFont(new Font("Arial", Font.PLAIN, 25));
        submain_JP.add(submain_LECTURER);
        submain_LECTURER.addActionListener(this);
      
        submain_TUTOR = new JButton("TUTOR");
        submain_TUTOR.setBounds(583, 205, 250, 271);
        submain_TUTOR.setFont(new Font("Arial", Font.PLAIN, 25));
        submain_JP.add(submain_TUTOR);
        submain_TUTOR.addActionListener(this);
         // Create a label indicating the next step
        submain_NOTE = new JLabel("Choose any one to proceed.");
        submain_NOTE.setBounds(383, 518, 334, 36);
        submain_NOTE.setFont(new Font("Arial", Font.PLAIN, 25));
        submain_JP.add(submain_NOTE);
        // Create and configure the 'Back' button
        submain_BACK = new JButton("Back");
        submain_BACK.setBounds(90, 600, 150, 50);
        submain_BACK.setFont(new Font("Arial", Font.PLAIN, 25));
        submain_BACK.setFocusable(false);
        submain_BACK.addActionListener(this);
        submain_JP.add(submain_BACK);

        submain_EXIT = new JButton("Exit");
        submain_EXIT.setBounds(887, 600, 150, 50);
        submain_EXIT.setFont(new Font("Arial", Font.PLAIN, 25));
        submain_EXIT.setFocusable(false);
        submain_EXIT.addActionListener(this);
        submain_JP.add(submain_EXIT);

        submain_JF.setLayout(null);
        submain_JF.setVisible(false);
        submain_JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void lecturerFrame() {
         // Initialize the lecturer frame and set properties
        lecturer_JF = new JFrame();
        lecturer_JF.setResizable(false);
        lecturer_JF.setSize(1200, 800);
        lecturer_JF.setTitle("Lecturer");
        lecturer_JF.setBackground(new Color(245, 249, 249));

        lecturer_JP = new JPanel();
        lecturer_JP.setLayout(null);
        lecturer_JP.setSize(1200, 800);
        lecturer_JP.setBackground(new Color(245, 249, 249));
        lecturer_JF.add(lecturer_JP);

        lecturer_LBLHEAD = new JLabel("Lecturer");
        lecturer_LBLHEAD.setBounds(500, 40, 105, 44);
        lecturer_LBLHEAD.setFont(new Font("Arial", Font.PLAIN, 25));
        lecturer_JP.add(lecturer_LBLHEAD);

        lecturer_teacherId = new JLabel("Teacher ID:");
        lecturer_teacherId.setBounds(155, 125, 130, 30);
        lecturer_teacherId.setFont(new Font("Arial", Font.PLAIN, 20));
        lecturer_JP.add(lecturer_teacherId);

        lecturer_teacherId_TF = new JTextField();
        lecturer_teacherId_TF.setBounds(320, 120, 155, 45);
        lecturer_JP.add(lecturer_teacherId_TF);

        lecturer_teacherName = new JLabel("Teacher Name:");
        lecturer_teacherName.setBounds(155, 225, 150 , 30);
        lecturer_teacherName.setFont(new Font("Arial", Font.PLAIN, 20));
        lecturer_JP.add(lecturer_teacherName);

        lecturer_teacherName_TF = new JTextField();
        lecturer_teacherName_TF.setBounds(320, 220, 155, 45);
        lecturer_JP.add(lecturer_teacherName_TF);

        lecturer_address = new JLabel("Address:");
        lecturer_address.setBounds(155, 325, 130, 30);
        lecturer_address.setFont(new Font("Arial", Font.PLAIN, 20));
        lecturer_JP.add(lecturer_address);

        lecturer_address_TF = new JTextField();
        lecturer_address_TF.setBounds(320, 320, 155, 45);
        lecturer_JP.add(lecturer_address_TF);

        lecturer_workingType = new JLabel("Working Type:");
        lecturer_workingType.setBounds(155, 425, 130, 30);
        lecturer_workingType.setFont(new Font("Arial", Font.PLAIN, 20));
        lecturer_JP.add(lecturer_workingType);

        String[] workingTypes = {"Part Time", "Full Time"};
        lecturer_workingType_JCB = new JComboBox<>(workingTypes);
        lecturer_workingType_JCB.setBounds(320, 420, 155, 45);
        lecturer_JP.add(lecturer_workingType_JCB);

        lecturer_employmentStatus = new JLabel("employmentStatus:");
        lecturer_employmentStatus.setBounds(700, 125,215, 30);
        lecturer_employmentStatus.setFont(new Font("Arial", Font.PLAIN, 20));
        lecturer_JP.add(lecturer_employmentStatus);

        String[] employmentStatus = {"Contract Based ", "Project Based"};
        lecturer_employmentStatus_JCB = new JComboBox<>(employmentStatus);
        lecturer_employmentStatus_JCB.setBounds(910, 120, 155, 45);
        lecturer_JP.add(lecturer_employmentStatus_JCB);

        lecturer_department = new JLabel("Department:");
        lecturer_department.setBounds(700, 225,215, 30);
        lecturer_department.setFont(new Font("Arial", Font.PLAIN, 20));
        lecturer_JP.add(lecturer_department);

        lecturer_department_TF = new JTextField();
        lecturer_department_TF.setBounds(910, 220, 155, 45);
        lecturer_JP.add(lecturer_department_TF);

        lecturer_yearsOfExperience = new JLabel("Years of Experience:");
        lecturer_yearsOfExperience.setBounds(700, 325,215, 30);   ///
        lecturer_yearsOfExperience.setFont(new Font("Arial", Font.PLAIN, 20));
        lecturer_JP.add(lecturer_yearsOfExperience);

        lecturer_yearsOfExperience_TF = new JTextField();
        lecturer_yearsOfExperience_TF.setBounds(910, 320, 155, 45);
        lecturer_JP.add(lecturer_yearsOfExperience_TF);

        lecturer_workingHours = new JLabel("Working Hours:");
        lecturer_workingHours.setBounds(700, 425,215, 30);
        lecturer_workingHours.setFont(new Font("Arial", Font.PLAIN, 20));
        lecturer_JP.add(lecturer_workingHours);

        lecturer_workingHours_TF = new JTextField();
        lecturer_workingHours_TF.setBounds(910, 420, 155, 45);
        lecturer_JP.add(lecturer_workingHours_TF);

        lecturer_ADD = new JButton("Add Lecturer");
        lecturer_ADD.setBounds(101, 606, 259, 50);
        lecturer_ADD.setBackground(Color.black);
        lecturer_ADD.setOpaque(true);
        lecturer_ADD.setForeground(Color.white);
        lecturer_ADD.setBorder(BorderFactory.createLineBorder(Color.black));
        lecturer_ADD.addActionListener(this);
        lecturer_JP.add(lecturer_ADD);

        lecturer_GRADE = new JButton("Grade Assignment");
        lecturer_GRADE.setBounds(489, 606, 259, 50);
        lecturer_GRADE.addActionListener(this);
        lecturer_JP.add(lecturer_GRADE);

        lecturer_DISPLAY = new JButton("Display");
        lecturer_DISPLAY.setBounds(965, 606, 134, 50);
        lecturer_DISPLAY.addActionListener(this);
        lecturer_JP.add(lecturer_DISPLAY);

        lecturer_BACK = new JButton("Back");
        lecturer_BACK.setBounds(65, 700, 150, 50);
        lecturer_BACK.addActionListener(this);
        lecturer_JP.add(lecturer_BACK);

        lecturer_CLEAR = new JButton("Clear");
        lecturer_CLEAR.setBounds(1000, 700, 150, 50);
        lecturer_CLEAR.addActionListener(this);
        lecturer_JP.add(lecturer_CLEAR);

        lecturer_JF.setLayout(null);
        lecturer_JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lecturer_JF.setVisible(false);
    }

    public void TutorFrame() {
         // Initialize the tutor frame and set properties
        tutor_JF = new JFrame();
        tutor_JF.setTitle("Tutor");
        tutor_JF.setSize(1200, 800);
        tutor_JF.setResizable(false);
        tutor_JF.getContentPane().setBackground(new Color(255, 255, 255));

        tutor_JP = new JPanel();
        tutor_JP.setLayout(null);
        tutor_JP.setBounds(0, 0, 1200, 800);
        tutor_JP.setBackground(new Color(245, 249, 249));
        tutor_JF.add(tutor_JP);

        tutor_LBLHEAD = new JLabel("Tutor");
        tutor_LBLHEAD.setBounds(550, 40, 105, 44);
        tutor_LBLHEAD.setFont(new Font("Arial", Font.PLAIN, 25));
        tutor_JP.add(tutor_LBLHEAD);

        tutor_teacherId = new JLabel("Teacher Id:");
        tutor_teacherId.setBounds(155, 125, 130, 30);
        tutor_teacherId.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_teacherId);

        tutor_teacherId_TF = new JTextField();
        tutor_teacherId_TF.setBounds(320, 120, 155, 45);
        tutor_JP.add(tutor_teacherId_TF);

        tutor_teacherName = new JLabel("TeacherName:");
        tutor_teacherName.setBounds(155, 225, 140, 30);
        tutor_teacherName.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_teacherName);

        tutor_teacherName_TF = new JTextField();
        tutor_teacherName_TF.setBounds(320, 220, 155, 45);
        tutor_JP.add(tutor_teacherName_TF);

        tutor_address = new JLabel("Address:");
        tutor_address.setBounds(155, 325, 130, 30);
        tutor_address.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_address);

        tutor_address_TF = new JTextField();
        tutor_address_TF.setBounds(320, 320, 155, 45);
        tutor_JP.add(tutor_address_TF);

        tutor_workingType = new JLabel("Working Type:");
        tutor_workingType.setBounds(155, 425, 130, 30);;
        tutor_workingType.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_workingType);

        String[] workingTypes = {"Part Time", "Full Time"};
        tutor_workingType_JCB = new JComboBox<>(workingTypes);
        tutor_workingType_JCB.setBounds(320, 420, 155, 45);
        tutor_JP.add(tutor_workingType_JCB);

        tutor_workingHours = new JLabel("workingHour:");
        tutor_workingHours.setBounds(155, 525, 130, 30);
        tutor_workingHours.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_workingHours);

        tutor_workingHours_TF = new JTextField();
        tutor_workingHours_TF.setBounds(320, 520, 155, 45);
        tutor_JP.add(tutor_workingHours_TF);

        tutor_employmentStatus = new JLabel("employmentStatus:");
        tutor_employmentStatus.setBounds(700, 125,215, 30);
        tutor_employmentStatus.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_employmentStatus);

        String[] employmentStatus = {"Contract Based ", "Project Based"};
        tutor_employmentStatus_JCB = new JComboBox<>(employmentStatus);
        tutor_employmentStatus_JCB.setBounds(910, 120, 155, 45);
        tutor_JP.add(tutor_employmentStatus_JCB);

        tutor_salary = new JLabel("Salary:");
        tutor_salary.setBounds(700, 225,215, 30);
        tutor_salary.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_salary);

        tutor_salary_TF = new JTextField();
        tutor_salary_TF.setBounds(910, 220, 155, 45);
        tutor_JP.add(tutor_salary_TF);

        tutor_specialization = new JLabel("Specialization:");
        tutor_specialization.setBounds(700, 325,215, 30);
        tutor_specialization.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_specialization);

        tutor_specialization_TF = new JTextField();
        tutor_specialization_TF.setBounds(910, 320, 155, 45);
        tutor_JP.add(tutor_specialization_TF);

        tutor_academicQualifications = new JLabel("academicQualification:");
        tutor_academicQualifications.setBounds(700, 425,215, 30);
        tutor_academicQualifications.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_academicQualifications);

        tutor_academicQualifications_TF = new JTextField();
        tutor_academicQualifications_TF.setBounds(910, 420, 155, 45);
        tutor_JP.add(tutor_academicQualifications_TF);

        tutor_performanceIndex = new JLabel("performanceIndex:");
        tutor_performanceIndex.setBounds(700, 525,200, 30);
        tutor_performanceIndex.setFont(new Font("Arial", Font.PLAIN, 20));
        tutor_JP.add(tutor_performanceIndex);

        tutor_performanceIndex_TF = new JTextField();
        tutor_performanceIndex_TF.setBounds(910, 520, 155, 45);
        tutor_JP.add(tutor_performanceIndex_TF);

        tutor_ADD = new JButton("Add tutor");
        tutor_ADD.setBounds(101, 606, 259, 50);
        tutor_ADD.setBackground(Color.black);
        tutor_ADD.setOpaque(true);
        tutor_ADD.setForeground(Color.white);
        tutor_ADD.setBorder(BorderFactory.createLineBorder(Color.black));
        tutor_ADD.addActionListener(this);
        tutor_JP.add(tutor_ADD);

        tutor_SETSALARY = new JButton("Set Salary");
        tutor_SETSALARY.setBounds(389, 606, 259, 50);
        tutor_SETSALARY.addActionListener(this);
        tutor_JP.add(tutor_SETSALARY);

        tutor_REMOVE = new JButton("Remove Tutor");
        tutor_REMOVE.setBounds(677, 606, 259, 50);
        tutor_JP.add(tutor_REMOVE);
        tutor_REMOVE.addActionListener(this);

        tutor_DISPLAY = new JButton("Display");
        tutor_DISPLAY.setBounds(965, 606, 134, 50);
        tutor_JP.add(tutor_DISPLAY);
        tutor_DISPLAY.addActionListener(this);

        tutor_BACK = new JButton("Back");
        tutor_BACK.setBounds(65, 700, 150, 50);
        tutor_JP.add(tutor_BACK);
        tutor_BACK.addActionListener(this);

        tutor_CLEAR = new JButton("Clear");
        tutor_CLEAR.setBounds(1000, 700, 150, 50);
        tutor_JP.add(tutor_CLEAR);
        tutor_CLEAR.addActionListener(this);

        tutor_JF.setLayout(null);
        tutor_JF.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
         /*
        This method handles various button click events in the Teacher Management System GUI.
        It checks which button triggered the event and performs the corresponding action.
        The possible events include adding or removing a tutor, displaying tutor information, 
        and managing frame transitions.
        */
       
        // When the "Continue" button on the main frame is clicked
        if (e.getSource() == main_CONTINUE){
            main_JF.dispose();// Close the main frame
            submain_JF.setVisible(true); // Open the sub-main frame
        }else if (e.getSource() == main_EXIT){// When the "Exit" button on the main frame is clicked
            main_JF.dispose();// Close the application
        }else if (e.getSource() == submain_LECTURER){// When the "LECTURER" button on the sub-main frame is clicked
            submain_JF.dispose();// Close the sub-main frame
            lecturer_JF.setVisible(true); // Open the lecturer frame
        }else if (e.getSource() == submain_TUTOR){// When the "TUTOR" button on the sub-main frame is clicked
            submain_JF.dispose();// Close the sub-main frame
            tutor_JF.setVisible(true);// Open the tutor frame
        }else if (e.getSource() == submain_BACK){ // When the "Back" button on the sub-main frame is clicked
            submain_JF.dispose();
            main_JF.setVisible(true);
        }else if (e.getSource() == submain_EXIT){ // When the "Exit" button on the sub-main frame is clicked
            submain_JF.dispose();
        }else if (e.getSource() == lecturer_ADD){// When the "Add Lecturer" button on the lecturer frame is clicked

            try{  
                 // Validate inputs for adding a new lecturer
                // Check if any of the required fields are empty
                if (lecturer_teacherId_TF.getText().trim().isEmpty() ||
                lecturer_teacherName_TF.getText().trim().isEmpty() ||
                lecturer_address_TF.getText().trim().isEmpty() ||
                lecturer_workingType_JCB.getSelectedItem() == null ||
                lecturer_employmentStatus_JCB.getSelectedItem()== null ||
                lecturer_department_TF.getText().trim().isEmpty() ||
                lecturer_yearsOfExperience_TF.getText().trim().isEmpty() ||
                lecturer_workingHours_TF.getText().trim().isEmpty()) {

                    // Inform the user about the empty fields and stop further processing
                    JOptionPane.showMessageDialog(lecturer_JP, "All fields must be filled in.");
                    return;  // Stop further processing
                }
                // Convert text fields to integer values

                int teacherId = Integer.parseInt(lecturer_teacherId_TF.getText());
                int yearsOfExperience = Integer.parseInt(lecturer_yearsOfExperience_TF.getText());
                int workingHours = Integer.parseInt(lecturer_workingHours_TF.getText());
                  // Ensure the values are positive
                if (teacherId < 1 || workingHours < 1 ||  yearsOfExperience< 1 ) {
                    JOptionPane.showMessageDialog(tutor_JP, "Values must be positive.");
                    return; // Exit if any value is negative or zero
                }// Check for duplicate teacher ID
                if (teacher_arrayList != null) {
                    for (Teacher t : teacher_arrayList) {
                        if (t.getteacherId() == teacherId) {
                            JOptionPane.showMessageDialog(tutor_JP, "Duplicate teacher ID. Please use a unique ID.");
                            return; // Exit if there's a duplicate
                        }
                    }
                }
                // Collect remaining data and create a new Lecturer instance
                String teacherName = lecturer_teacherName_TF.getText();
                String address = lecturer_address_TF.getText();
                String workingType = (String) lecturer_workingType_JCB.getSelectedItem();
                String employmentStatus =(String) lecturer_employmentStatus_JCB.getSelectedItem();
                String department = lecturer_department_TF.getText();

                Lecturer lecturer = new Lecturer(teacherId,teacherName,address,workingType,employmentStatus,department,yearsOfExperience,workingHours);
                teacher_arrayList.add(lecturer); // Add the new lecturer to the list
                // Show success message
                JOptionPane.showMessageDialog(lecturer_JP, "Lecturer added successfully.");
            }catch(NumberFormatException ex){
                // Handle cases where input conversion fails
                JOptionPane.showMessageDialog(lecturer_JP, "Invalid input. Please enter valid data");
            }
                 // When the "Grade Assignment" button on the lecturer frame is clicked
        }else if (e.getSource()== lecturer_GRADE){   try {
                  // Validate the necessary fields for grading
                String teacherIdStr = lecturer_teacherId_TF.getText().trim();
                String department = lecturer_department_TF.getText().trim();
                String yearsOfExperienceStr = lecturer_yearsOfExperience_TF.getText().trim();

                if (teacherIdStr.isEmpty() || department.isEmpty() || yearsOfExperienceStr.isEmpty()) {
                    JOptionPane.showMessageDialog(lecturer_JP, "Please fill in all the required fields.");
                    return;// Stop further processing
                }

                // Convert to numeric types with error handling
                int teacherId = Integer.parseInt(teacherIdStr);
                int yearsOfExperience = Integer.parseInt(yearsOfExperienceStr);

                // Prompt for a valid graded score with additional validation
                String gradedScoreStr = JOptionPane.showInputDialog("Enter graded Score:");
                if (gradedScoreStr == null || gradedScoreStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(lecturer_JP, "Please enter a valid graded score.");
                    return;
                }

                int gradedScore = Integer.parseInt(gradedScoreStr.trim());

                // Find the correct Lecturer and assign the graded score
                boolean teacherFound = false;
         
                for (Teacher teacher : teacher_arrayList) {
                    if (teacher instanceof Lecturer && teacher.getteacherId() == teacherId) {
                        teacherFound = true;
                        ((Lecturer) teacher).gradeAssignment(gradedScore, department, yearsOfExperience);
                        // Ensure the gradedScore is set correctly within the Lecturer instance
                        ((Lecturer) teacher).setgradedScore(gradedScore); // Set the graded score directly
                        JOptionPane.showMessageDialog(lecturer_JP, "Grading completed successfully.");
                        break;
                    }
                }

                if (!teacherFound) {
                    // If no matching Lecturer is found, show an error message
                    JOptionPane.showMessageDialog(lecturer_JP, "No Lecturer found with the given Teacher ID.");
                }
            } catch (NumberFormatException ex) {
                // Handle errors in data conversion
                JOptionPane.showMessageDialog(lecturer_JP, "Invalid input. Please enter valid numeric data.");
            }try {
                // Check for empty or invalid inputs
                String teacherIdStr = lecturer_teacherId_TF.getText().trim();
                String department = lecturer_department_TF.getText().trim();
                String yearsOfExperienceStr = lecturer_yearsOfExperience_TF.getText().trim();

                if (teacherIdStr.isEmpty() || department.isEmpty() || yearsOfExperienceStr.isEmpty()) {
                    JOptionPane.showMessageDialog(lecturer_JP, "Please fill in all the required fields.");
                    return;
                }

                // Parse integer values
                int teacherId = Integer.parseInt(teacherIdStr);
                int yearsOfExperience = Integer.parseInt(yearsOfExperienceStr);

                // Prompt for graded score with error handling
                String gradedScoreStr = JOptionPane.showInputDialog("Enter graded Score:");
                if (gradedScoreStr == null || gradedScoreStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(lecturer_JP, "Please enter a valid graded score.");
                    return;
                }

                int gradedScore = Integer.parseInt(gradedScoreStr);

                boolean teacherFound = false;

                for (Teacher teacher : teacher_arrayList) {
                    if (teacher instanceof Lecturer && teacher.getteacherId() == teacherId) {
                        teacherFound = true;
                        ((Lecturer) teacher).gradeAssignment(gradedScore, department, yearsOfExperience);
                        JOptionPane.showMessageDialog(lecturer_JP, "Grading completed successfully.");
                        break;
                    }
                }

                if (!teacherFound) {
                    JOptionPane.showMessageDialog(lecturer_JP, "No Lecturer found with the given Teacher ID.");
                }
            } catch (NumberFormatException ex) { // Handle errors in data conversion
                JOptionPane.showMessageDialog(lecturer_JP, "Invalid input. Please enter valid numeric data.");
            }
             // When the "Display" button on the lecturer frame is clicked
        }else if (e.getSource() == lecturer_DISPLAY){
            String displayMessage = "";

            for (Teacher teacher : teacher_arrayList){
                if(teacher instanceof Lecturer){
                    displayMessage += "Lecturer Id:" + teacher.getteacherId() + "\n";
                    displayMessage += "Name:" + teacher.getteacherName() + "\n";
                    displayMessage += "Address:" + teacher.getaddress() + "\n";
                    displayMessage += "Working Type:" + teacher.getworkingType() +"\n";
                    displayMessage += "Employment Status:" + teacher.getemploymentStatus() + "\n";
                    displayMessage += "Department:" + ((Lecturer)teacher).getdepartment() + "\n";
                    displayMessage += "Years of Experience:" + ((Lecturer)teacher).getYearsOfExperience()  +"\n";
                    displayMessage += "Working Hours:" + ((Lecturer)teacher).getworkingHours() + "\n";
                    displayMessage += "Graded Score:" + ((Lecturer)teacher).getgradedScore() + "\n";

                    /// has graded huncha ki nai d check 
                    displayMessage += "-------------------------------\n";}
            }
            if  (displayMessage.isEmpty()){
                // If no lecturers are found, show an error message
                JOptionPane.showMessageDialog(lecturer_JP , "No lecturer found.");

            }else {
                // Otherwise, display the accumulated message
                JOptionPane.showMessageDialog(lecturer_JP, displayMessage);}
              // When the "Back" button on the lecturer frame is clicked
        }else if (e.getSource() == lecturer_BACK){
            lecturer_JF.dispose();
            submain_JF.setVisible(true);
        }else if (e.getSource() == lecturer_CLEAR){ // When the "Clear" button on the lecturer frame is clicked
            // Clear all text fields in the lecturer frame
            lecturer_teacherId_TF.setText("");
            lecturer_teacherName_TF.setText("");
            lecturer_address_TF.setText("");
            lecturer_workingType_JCB.getSelectedItem();// Reset to the first option
            lecturer_employmentStatus_JCB.getSelectedItem();// Reset to the first option
            lecturer_department_TF.setText("");
            lecturer_yearsOfExperience_TF.setText("");
            lecturer_workingHours_TF.setText("");

        }else if (e.getSource() == tutor_ADD) {
            try {
                 // Validate if all required text fields are filled
                if (
                tutor_teacherId_TF.getText().trim().isEmpty() ||
                tutor_teacherName_TF.getText().trim().isEmpty() ||
                tutor_address_TF.getText().trim().isEmpty() ||
                tutor_workingType_JCB.getSelectedItem() == null ||
                tutor_workingHours_TF.getText().trim().isEmpty() ||
                tutor_salary_TF.getText().trim().isEmpty() ||
                tutor_specialization_TF.getText().trim().isEmpty() ||
                tutor_academicQualifications_TF.getText().trim().isEmpty() ||
                tutor_employmentStatus_JCB.getSelectedItem() == null ||
                tutor_performanceIndex_TF.getText().trim().isEmpty()
                ) {
                    JOptionPane.showMessageDialog(tutor_JP, "All fields must be filled in.");
                    return; // Exit if any field is empty
                }

                // Check for duplicate teacher IDs
                // Parse and validate numeric input values
                int teacherId = Integer.parseInt(tutor_teacherId_TF.getText().trim());
                int workingHours = Integer.parseInt(tutor_workingHours_TF.getText().trim());
                double salary = Double.parseDouble(tutor_salary_TF.getText().trim());
                int performanceIndex = Integer.parseInt(tutor_performanceIndex_TF.getText().trim());

                // Validate that values are positive
                if (teacherId < 1 || workingHours < 1 || salary < 1 || performanceIndex < 1) {
                    JOptionPane.showMessageDialog(tutor_JP, "Values must be positive.");
                    return; // Exit if any value is negative or zero
                }
                if (teacher_arrayList != null) {
                    for (Teacher t : teacher_arrayList) {
                        if (t.getteacherId() == teacherId) {
                            JOptionPane.showMessageDialog(tutor_JP, "Duplicate teacher ID. Please use a unique ID.");
                            return; // Exit if there's a duplicate
                        }
                    }
                }

                // Retrieve other input values
                String teacherName = tutor_teacherName_TF.getText().trim();
                String address = tutor_address_TF.getText().trim();
                String workingType = (String) tutor_workingType_JCB.getSelectedItem();
                String employmentStatus = (String) tutor_employmentStatus_JCB.getSelectedItem();
                String specialization = tutor_specialization_TF.getText().trim();
                String academicQualifications = tutor_academicQualifications_TF.getText().trim();

                // Create the Tutor object with validated data
                Tutor tutor = new Tutor(
                        teacherId, teacherName, address, workingType, employmentStatus,
                        workingHours, salary, specialization, academicQualifications, performanceIndex
                    );

                // Initialize the list if needed
                if (teacher_arrayList == null) {
                    teacher_arrayList = new ArrayList<>();
                }

                // Add the Tutor to the list
                teacher_arrayList.add(tutor);

                // Success message
                JOptionPane.showMessageDialog(tutor_JP, "Tutor added successfully.");
            } catch (NumberFormatException ex) {
                // Display an error message for incorrect data types
                JOptionPane.showMessageDialog(tutor_JP, "Invalid input. Please enter valid numeric data.");
            }
            // Handling the event when "Remove Tutor" button is clicked
        }else if (e.getSource() == tutor_REMOVE){
            try{
                // Get the Teacher ID for the tutor to be removed
                int teacherId = Integer.parseInt(tutor_teacherId_TF.getText());
                // Find the matching tutor and remove them from the list
                for(Teacher teacher : teacher_arrayList){
                    if (teacher instanceof Tutor && teacher.getteacherId() == teacherId){
                        ((Tutor)teacher).removeTutor();// Call the method to remove the tutor (if defined)
                        teacher_arrayList.remove(teacher);// Remove from the list
                        JOptionPane.showMessageDialog(tutor_JP, "Tutor removed successfully.");

                        break;
                    }
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(tutor_JP, "Invalid input.PLease enter a valid teacher Id.");
            }
              // Handling the event when "Display" button is clicked to show all tutors
        }else if (e.getSource() == tutor_DISPLAY){
              /*
            When the "Display" button is clicked, the system iterates through the teacher list to 
            collect information about all tutors. If no tutors are found, a message is displayed. 
            Otherwise, the system displays the collected tutor information in a dialog box.
            */
            StringBuilder displayMessage = new StringBuilder(); // Use StringBuilder for better performance
            // Loop through the teacher list and collect tutor information
            for (Teacher teacher : teacher_arrayList) {
                if (teacher instanceof Tutor) {
                    Tutor tutor = (Tutor) teacher; // Cast to Tutor type
                    displayMessage.append("Tutor Id: ").append(tutor.getteacherId()).append("\n"); // Corrected label and used StringBuilder
                    displayMessage.append("Name: ").append(tutor.getteacherName()).append("\n");
                    displayMessage.append("Address: ").append(tutor.getaddress()).append("\n");
                    displayMessage.append("Working Type: ").append(tutor.getworkingType()).append("\n");
                    displayMessage.append("Employment Status: ").append(tutor.getemploymentStatus()).append("\n");
                    displayMessage.append("Working Hours: ").append(tutor.getworkingHours()).append("\n");
                    displayMessage.append("Salary: ").append(tutor.getsalary()).append("\n");
                    displayMessage.append("Specialization: ").append(tutor.getspecialization()).append("\n");
                    displayMessage.append("Academic Qualifications: ").append(tutor.getacademicQualifications()).append("\n");
                    displayMessage.append("Performance Index: ").append(tutor.getperformanceIndex()).append("\n");
                    displayMessage.append("------------------------------\n");
                }
            }

            if (displayMessage.length() == 0) { // Check if nothing was added to the displayMessage
                JOptionPane.showMessageDialog(tutor_JP, "No tutors found.");
            } else {
                JOptionPane.showMessageDialog(tutor_JP, displayMessage.toString());
            }
        }else if (e.getSource() == tutor_BACK){
            tutor_JF.dispose();
            submain_JF.setVisible(true);

        }else if(e.getSource() == tutor_CLEAR){
            tutor_teacherId_TF.setText("");
            tutor_teacherName_TF.setText("");
            tutor_address_TF.setText("");
            tutor_workingHours_TF.setText("");
            tutor_employmentStatus_JCB.getSelectedItem();// Reset the combo box to the first option
            tutor_workingType_JCB.getSelectedItem();// Reset the combo box to the first option
            tutor_salary_TF.setText("");
            tutor_specialization_TF.setText("");
            tutor_academicQualifications_TF.setText("");
            tutor_performanceIndex_TF.setText("");
        }
    }

    public static void main(String[]args){
        Teacher_GUI teacher = new Teacher_GUI(); // Create an instance of Teacher_GUI to launch the GUI
    }
}

      
