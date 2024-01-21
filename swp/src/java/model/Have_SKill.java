/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class Have_SKill {
    int idMentor;
    int idSkill;
    int score;
    int cost;
   String skillname;

    public Have_SKill() {
    }

    public Have_SKill(int idMentor, int idSkill, int score, int cost, String skillname) {
        this.idMentor = idMentor;
        this.idSkill = idSkill;
        this.score = score;
        this.cost = cost;
        this.skillname = skillname;
    }

    public Have_SKill(int idMentor, int idSkill) {
        this.idMentor = idMentor;
        this.idSkill = idSkill;
    }

    public Have_SKill(int idMentor, int idSkill, int score, int cost) {
        this.idMentor = idMentor;
        this.idSkill = idSkill;
        this.score = score;
        this.cost = cost;
    }

    public Have_SKill(int idMentor) {
        this.idMentor = idMentor;
    }

    
   

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getIdSkill() {
        return idSkill;
    }

    public void setIdSkill(int idSkill) {
        this.idSkill = idSkill;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Have_SKill{" + "idMentor=" + idMentor + ", idSkill=" + idSkill + ", score=" + score + ", cost=" + cost + ", skillname=" + skillname + '}';
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    
   
}