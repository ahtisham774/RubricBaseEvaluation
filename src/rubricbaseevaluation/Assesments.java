/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricbaseevaluation;

import java.util.ArrayList;

/**
 *
 * @author Ahtisham Ul Haq
 */
public class Assesments {

    private String assessment_type;
    private String clos;

    public String getClos() {
        return clos;
    }

    public void setClos(String clos) {
        this.clos = clos;
    }
    private int total_marks;
    private ArrayList<String> rubrics = new ArrayList<>();
    private ArrayList<Integer> component_marks = new ArrayList<>();
    private String rubric;
    private int component_Marks;

    public String getAssessment_type() {
        return assessment_type;
    }

    public void setAssessment_type(String assessment_type) {
        this.assessment_type = assessment_type;
    }

    public int getTotal_marks() {
        return total_marks;
    }

    public void setTotal_marks(int total_marks) {
        this.total_marks = total_marks;
    }

    public ArrayList<String> getRubrics() {
        return this.rubrics;
    }

    public void addRubrics(String rubrics) {
        this.rubrics.add(rubrics);
    }

    public ArrayList<Integer> getComponent_marks() {
        return component_marks;
    }

    public void addComponent_marks(int component_marks) {
        this.component_marks.add(component_marks);
    }

    public String getRubric() {
        return rubric;
    }

    public void setRubric(String rubric) {
        this.rubric = rubric;
    }

    public int getComponent_Marks() {
        return component_Marks;
    }

    public void setComponent_Marks(int component_Marks) {
        this.component_Marks = component_Marks;
    }
}
