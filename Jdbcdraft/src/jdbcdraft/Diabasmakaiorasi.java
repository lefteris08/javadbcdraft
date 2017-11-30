/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdraft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lefte
 */
public class Diabasmakaiorasi {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/catalog";
    static final String USER = "root";
    static final String PASS = "admin";

    public void Diabasmakaiorasi() {
        try {
            // TODO code application logic here
            Connection conn = null;
            Statement stmt = null;

            System.out.println("Connecting to database...");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
//            Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException ex) {
                //Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if (conn == null) {

                    System.out.println("wtf");
                }
                stmt = conn.createStatement();
            } catch (SQLException ex) {
                // Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
// System.out.println("den paizei");

            System.out.println("Creating statement...");
            String sql;
            sql = "SELECT * From members";
            ResultSet rs;
            try {
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.print("First1: " + rs.getString(1));
                    System.out.print(", LastName : " + rs.getString(2));
                    System.out.print(", Til1 : " + rs.getString(4));
                    System.out.print(", Til2 : " + rs.getString(5));
                    System.out.println(", id" + rs.getInt(3));

                }

                rs.close();

            } catch (SQLException ex) {
                //   Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("egine");

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
//            Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertInt() {

        try {
            // TODO code application logic here
            Connection conn = null;
            PreparedStatement stmt = null;

            System.out.println("Connecting to database...");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
//            Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException ex) {
                //Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if (conn == null) {

                    System.out.println("wtf");
                }
                String sql;
                sql = "insert into members(Fname,LastName,tel1,tel2) values(\"lef\",\"mal\",\"2106464643\",\"2106464644\"),(\"lefteris\",\"malindretos\",\"2106464643\",\"2106464644\"),(\"efl\",\"alm\",\"1064646432\",\"1064646442\"),(\"fle\",\"lma\",\"0646464321\",\"0646464421\"),(\"ioannis\",\"dretos\",\"6464643210\",\"6464644210\"),(\"oannisi\",\"retosd\",\"4646432106\",\"4646442106\");";
//anti gia olli tin diadikasia \"\" mporousa apla na balw ''
                stmt = conn.prepareStatement(sql);
            } catch (SQLException ex) {
                // Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
// System.out.println("den paizei");

            System.out.println("Creating statement...");
            // ResultSet rs;
            try {
                stmt.executeUpdate();

            } catch (SQLException ex) {
                //   Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("egine");

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
//            Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void showrec() {
        Scanner stdin = new Scanner(System.in);
        String name = "";
        String lname = "";
        System.out.println("What is your name?");
        //String name = 
        name = stdin.nextLine();
        //  System.out.println("Hello " + Klasi.getName());

        name = name.replaceAll("\\s+", "");
        System.out.println("What is your surname?");
        lname = stdin.nextLine();
        System.out.println(lname);
        lname = lname.replaceAll("\\s+", "");
        System.out.println(lname);

        try {
            // TODO code application logic here
            Connection conn = null;
            Statement stmt = null;

            System.out.println("Connecting to database...");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("den brethike i klasi");
//            Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException ex) {

                System.out.println("den egine sindesi");
                //Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if (conn == null) {

                    System.out.println("wtf");
                }

                stmt = conn.createStatement();
            } catch (SQLException ex) {
                // Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
// System.out.println("den paizei");

            System.out.println("Creating statement...");
            String sql;
            PreparedStatement pstmt = conn.prepareStatement(
                    "Select* from members where Fname =? and LastName=?");
            pstmt.setString(1, name);
            pstmt.setString(2, lname);

            //sql = "Select* from members where Fname ='" + name + "' and LastName=" + lname+"";
            //System.out.println(sql);
            //System.out.println(stmt);
            ResultSet rs;
            int k = 0;
            try {
                rs = pstmt.executeQuery();
                System.out.println(rs);
                while (rs.next()) {
                    k++;
                    System.out.print("First1: " + rs.getString(1));
                    System.out.print(", LastName : " + rs.getString(2));
                    System.out.print(", Til1 : " + rs.getString(4));
                    System.out.print(", Til2 : " + rs.getString(5));
                    System.out.println(", id" + rs.getInt(3));

                }
                if (k == 0) {
                    System.out.println("den ipirxe o xristis");
                }
                rs.close();

            } catch (SQLException ex) {
                System.out.println("den ipirxe egrafi");
                //   Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("egine");

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
//            Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void changeN() {
        Scanner stdin = new Scanner(System.in);
        String number = "";
        String lname = "";
        System.out.println("What is your number?");
        //String name = 
        number = stdin.nextLine();
        //  System.out.println("Hello " + Klasi.getName());

        number = number.replaceAll("\\s+", "");
        System.out.println(number);
        System.out.println("What is your surname?");
        lname = stdin.nextLine();
        System.out.println(lname);
        lname = lname.replaceAll("\\s+", "");
        System.out.println(lname);

        try {
            // TODO code application logic here
            Connection conn = null;
            Statement stmt = null;

            System.out.println("Connecting to database...");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("den brethike i klasi");
//            Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException ex) {

                System.out.println("den egine sindesi");
                //Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if (conn == null) {

                    System.out.println("wtf");
                }

                stmt = conn.createStatement();
            } catch (SQLException ex) {
                // Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
// System.out.println("den paizei");

            System.out.println("Creating statement...");
            String sql;
            PreparedStatement pstmt = conn.prepareStatement(
                    " update members set  tel1= ? where  members.LastName =?");
            System.out.println(number);
            System.out.println(lname);
            pstmt.setString(1, number);
            pstmt.setString(2, lname);

            pstmt.execute();

            //sql = "Select* from members where Fname =" + name + " and LastName=" + lname+"";
            //System.out.println(sql);
            //System.out.println(stmt);
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
//            Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//String surname = 
    //Klasi.setsurname(stdin.nextLine());
    //System.out.println("What is your Fathers name?");
    //String Fname =
    //Klasi.setFname(stdin.nextLine());
}
