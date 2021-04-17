/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricbaseevaluation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahtisham Ul Haq
 */
public class Teacher {

    private static Teacher instance;
    private String course_ID;
    private String course_Title;

    public String getCourse_Title() {
        return course_Title;
    }

    public void setCourse_Title(String course_Title) {
        this.course_Title = course_Title;
    }

    public String getCourse_ID() {
        return course_ID;
    }

    public void setCourse_ID(String course_ID) {
        this.course_ID = course_ID;
    }
    private ArrayList<CLOs> closList;

    public ArrayList<CLOs> getClosList() {
        return closList;
    }

    public ArrayList<Students> getStudentList() {
        return studentList;
    }

    public ArrayList<Assesments> getAssessmentList() {
        return assessmentList;
    }
    private ArrayList<Students> studentList;
    private ArrayList<Assesments> assessmentList;
    private Assesments assessment;

    public Assesments getAssessment() {
        return assessment;
    }

    public void setAssessment(Assesments assessment) {
        this.assessment = assessment;
    }

    private Teacher() {

        closList = new ArrayList<>();
        studentList = new ArrayList<>();
        assessmentList = new ArrayList<>();
        assessment = new Assesments();

    }

    public static Teacher getInstance() {
        if (instance == null) {
            instance = new Teacher();
        }
        return instance;
    }
    private String teacher_Id;

    public String getTeacher_Id() {
        return teacher_Id;
    }

    public void setTeacher_Id(String teacher_Id) {
        this.teacher_Id = teacher_Id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }
    private String teacher_name;

    public void addClos(CLOs c) {

        closList.add(c);
    }

    public void addStudents(Students s) {
        studentList.add(s);
    }

    public void addAssessment(Assesments as) {
        assessmentList.add(as);
    }

    private int searchStudentId(String id) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (id.equals(studentList.get(i).getRegisterationNO())) {
                index = i;
            }
        }
        return index;
    }

    private int searchAssessmentId(String type) {
        int index = -1;
        for (int i = 0; i < assessmentList.size(); i++) {
            if (type.equals(assessmentList.get(i).getAssessment_type())) {
                index = i;
            }
        }
        return index;
    }

    public Assesments searchAssesment(String type) {
        int index = searchAssessmentId(type);
        if (index != -1) {
            return assessmentList.get(index);
        }
        return null;
    }

    public Students seearchStudent(String id) {
        int index = searchStudentId(id);
        if (index != -1) {
            return studentList.get(index);
        }
        return null;
    }

    public void deleteStudent(String id) {
        int index = searchStudentId(id);
        if (index != -1) {
            studentList.remove(index);
        }
    }

    public void saveCLOsData() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("clos.txt");
            for (int i = 0; i < closList.size(); i++) {

                fw.write(closList.get(i).getType() + ":" + closList.get(i).getDecription());
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void saveStudentData() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("student.txt");
            for (int i = 0; i < closList.size(); i++) {

                fw.write("Student Name : " + studentList.get(i).getStudent_name());
                fw.write("\n" + "Registration No :" + studentList.get(i).getRegisterationNO());
                fw.write("\n" + "Date Of Birth :" + studentList.get(i).getDate_Of_Birth());
                fw.write("\n" + "Category  :" + studentList.get(i).getCategory());
                fw.write("\n" + "Section:" + studentList.get(i).getSection());
                fw.write("\n" + "obtained marks:");
                for (int j = 0; j < studentList.get(i).getObtain_marks().size(); j++) {
                    fw.write(studentList.get(i).getObtain_marks().get(j) + " ");
                }
            }
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void loadCLOsData() {

        try {

            CLOs clos = new CLOs();
            FileReader fr = null;
            try {
                fr = new FileReader("clos.txt");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {

                String toks[] = line.split(":");
                clos.setType(toks[0]);
                clos.setDecription(toks[1]);
                closList.add(clos);
            }

            fr.close();

        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
