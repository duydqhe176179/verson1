/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.SkillMentor;

/**
 *
 * @author Admin
 */
public class AdminDAO extends DBContext{

    PreparedStatement stm;
    ResultSet rs;
    List<SkillMentor> listSkill = new ArrayList<>();

    public List<SkillMentor> listAllSkill() {
        try {
            String sql = "SELECT * FROM dbo.skill";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String image = rs.getString(3);
                String skillName = rs.getString(4);
                String Skill_description = rs.getString(5);
                String status = rs.getString(6);

                SkillMentor s = new SkillMentor(id, title, image, skillName, Skill_description, status);
                listSkill.add(s);
            }
        } catch (Exception e) {
            System.out.println("ko lay dc list skill");
        }
        return listSkill;

    }

    public SkillMentor getSkillById(int id) {
        try {
            String sql = "SELECT * FROM dbo.skill WHERE id=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                String title = rs.getString(2);
                String image = rs.getString(3);
                String name = rs.getString(4);
                String descrip = rs.getString(5);
                String status = rs.getString(6);
                SkillMentor s = new SkillMentor(id, title, image, name, descrip, status);

                return s;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean updateSkill(int id, String title, String image, String name, String description, String status) {
        try {
            String strUPDATE = "UPDATE dbo.skill \n"
                    + "SET title=?,image=?,skillName=?,skill_description=?,status=?\n"
                    + "WHERE id=?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, title);
            stm.setString(2, image);
            stm.setString(3, name);
            stm.setString(4, description);
            stm.setString(5, status);
            stm.setInt(6, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("loi, ko update dc");
            return false;
        }
    }

    public boolean activeSkill(String id) {
        AdminDAO admindao = new AdminDAO();
        SkillMentor skill = admindao.getSkillById(Integer.parseInt(id));
        try {
            String strUPDATE = "UPDATE dbo.skill \n"
                    + "SET status =?\n"
                    + "WHERE id=?";
            stm = connection.prepareStatement(strUPDATE);
            String status = "";
            if (skill.getStatus().equals("enable")) {
                status = "disable";
            } else {
                status = "enable";
            }
            stm.setString(1, status);
            stm.setString(2, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("loi, ko update dc");
            return false;
        }
    }

    public boolean addSkill(SkillMentor skill) {
        try {
            String strSelect = "INSERT INTO dbo.skill(title,image,skillName,skill_description)\n"
                    + "VALUES (?,?,?,?)";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, skill.getTiltle());
            stm.setString(2, skill.getImage());
            stm.setString(3, skill.getSkillName());
            stm.setString(4, skill.getSkill_description());

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        System.out.println(dao.activeSkill("1"));
    }
}
