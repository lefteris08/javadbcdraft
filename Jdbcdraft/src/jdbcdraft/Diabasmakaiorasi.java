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
import java.util.ArrayList;
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
    static Connection conn = null;
    static Statement stmt = null;
    static PreparedStatement pstmt = null;
    static ArrayList<bdaystoixeia> bdays = new ArrayList<bdaystoixeia>();

    public void sind() {

        System.out.println("Connecting to database...");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
//           
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {
            //Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (conn == null) {

            System.out.println("wtf");
        }
        // stmt = conn.createStatement();

// System.out.println("den paizei");
    }
//emfanizw tous xristes

    public void Diabasmakaiorasi() {
        sind();
        try {
            stmt = conn.createStatement();
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
//slect count (*)from members
            } catch (SQLException ex) {
                //   Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("egine");

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//bazw 5 times

    public void insertInt() {
        sind();
        try {
            String sql = "insert into members(Fname,LastName,tel1,tel2) values(\"lef\",\"mal\",\"2106464643\",\"2106464644\"),(\"lefteris\",\"malindretos\",\"2106464643\",\"2106464644\"),(\"efl\",\"alm\",\"1064646432\",\"1064646442\"),(\"fle\",\"lma\",\"0646464321\",\"0646464421\"),(\"ioannis\",\"dretos\",\"6464643210\",\"6464644210\"),(\"oannisi\",\"retosd\",\"4646432106\",\"4646442106\");";
//anti gia olli tin diadikasia \"\" mporousa apla na balw ''
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            //   Logger.getLogger(kodikas2.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//na dw to record me basi to string

    public void showrec() {
        Scanner stdin = new Scanner(System.in);
        String name = "";
        String lname = "";
        System.out.println("What is your name?");
        name = stdin.nextLine();
        name = name.replaceAll("\\s+", "");
        System.out.println("What is your surname?");
        lname = stdin.nextLine();
        lname = lname.replaceAll("\\s+", "");
        sind();
        try {

            System.out.println("Creating statement...");
            String sql;
            pstmt = conn.prepareStatement(
                    "Select* from members where Fname =? and LastName=?");
            pstmt.setString(1, name);
            pstmt.setString(2, lname);
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
            }
            System.out.println("egine");

            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
//alazw me basi to name

    public void changeN() {
        Scanner stdin = new Scanner(System.in);
        String number = "";
        String lname = "";
        System.out.println("What is your number?");
        number = stdin.nextLine();

        number = number.replaceAll("\\s+", "");
        System.out.println(number);
        System.out.println("What is your surname?");
        lname = stdin.nextLine();
        System.out.println(lname);
        lname = lname.replaceAll("\\s+", "");
        System.out.println(lname);
        sind();
        try {
            // TODO code application logic here

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException ex) {

            System.out.println("den egine sindesi");
        }

        if (conn == null) {

            System.out.println("wtf");
        }

        try {
            stmt = conn.createStatement();

            String sql;
            pstmt = conn.prepareStatement(" update members set  tel1= ? where  members.LastName =?");

            System.out.println(number);

            System.out.println(lname);

            pstmt.setString(
                    1, number);
            pstmt.setString(
                    2, lname);
            pstmt.execute();

            pstmt.close();

            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dimpin() {
        sind();
        StringBuffer sb = new StringBuffer("");
        sb.append("CREATE TABLE birthday (Bday VARCHAR(20) ,id int(100) unsigned not null , Primary key (id),FOREIGN KEY (`id`) REFERENCES `members` (`id`));");
        Scanner stdin = new Scanner(System.in);
        System.out.println("What the  name ");
        String name = stdin.nextLine();
        name = name.replaceAll("\\s+", "");

        try {
            pstmt = conn.prepareStatement(sb.toString());

            // pstmt.setString(1, name);
            pstmt.execute();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eisBirthday() {
        Scanner stdin = new Scanner(System.in);

        sind();
        StringBuffer sb = new StringBuffer("");
        sb.append("select  Fname,LastName,id  from catalog.members;");
        try {
            pstmt = conn.prepareStatement(sb.toString());
            int k = 0;
            ResultSet rs = pstmt.executeQuery();
            String fname = "";
            String lname = "";
            String bday = "";
            //bday = stdin.nextLine();
//System.out.println(rs);
            int ida = 0;
            while (rs.next()) {
                k++;
                bdaystoixeia node = new bdaystoixeia();
                fname = rs.getString(1);
                ida = rs.getInt(3);
                lname = rs.getString(2);
                System.out.println("dwse mou ta stoixeia gia ton " + fname + " " + lname);
                bday = stdin.nextLine();
                bday = bday.replaceAll("\\s+", "");
                node.bday = bday;
                node.id = ida;//edw issos thelei na kanei ena elexno me mia sinartisi connect kai elennxos
                bdays.add(node);
            }

            if (k == 0) {
                System.out.println("den ipirxe o xristis");
            }
            rs.close();

            pstmt.close();
//            conn.close();

            StringBuffer sb2 = new StringBuffer("");
            sb2.append("INSERT INTO  birthday (Bday  ,id) VALUES(?,?);");
            pstmt = conn.prepareStatement(sb2.toString());

            //System.out.println(lname);
            for (bdaystoixeia string : bdays) {
System.out.println(sb2.toString());
               
                pstmt.setString(1,string.bday);
                System.out.println("exw   "+string.bday+"     kai     " +Integer.valueOf(string.id));
                pstmt.setInt(2,string.id);
            
            pstmt.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
            // pstmt.setString(1, name);
        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
