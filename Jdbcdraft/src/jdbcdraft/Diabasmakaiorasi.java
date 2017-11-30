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
import java.time.LocalDate;
import java.sql.Date;
//import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
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

        //mporousa epeidi dein to pairnei na to kanw append me + sto input+  
        StringBuffer sb = new StringBuffer("");
        sb.append("CREATE TABLE birthday (Bday VARCHAR(20),Bday2 DATE ,id int(100) unsigned not null , Primary key (id),FOREIGN KEY (`id`) REFERENCES `members` (`id`));");
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

    public void dokimi() {
//Date kjm;
//import java.sql.Date;
        Scanner stdin = new Scanner(System.in);
        System.out.println("imerominia");
        String s = stdin.nextLine();
        String[] splited = s.split("-");
        try {
            Integer.valueOf(splited[0]);
            Integer.valueOf(splited[1]);
            Integer.valueOf(splited[2]);
            //if(splited[2]!=null)
            LocalDate kj = LocalDate.parse(s);
            //  kjm=Date.valueOf(kj);//.valueof(kj);
            System.out.println(kj.toString());
        } catch (NumberFormatException e) {
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

                boolean io = true;
                while (io) {

                    System.out.println("dwse mou ta stoixeia gia ton " + fname + " " + lname);
                    bday = stdin.nextLine();
                    // bday = bday.replaceAll("\\s+", "");
                    node.bday = bday;
                    System.out.println("imera  " + node.bday);

                    String[] splited = bday.toString().split("-");
                    try {
                        int s1 = Integer.valueOf(splited[0]);
                        int s2 =Integer.valueOf(splited[1]);
                        int s3=Integer.valueOf(splited[2]);
                        if (splited[0].length() == 4 && splited[1].length() == 2 && splited[2].length() == 2 && 
                              s1>0 && s2>0 && s3>0 && s1<2017 && s2<13 && s3<32) {
                            //if(splited[2]!=null)
                            LocalDate bdy = LocalDate.parse(bday.toString());
                            node.dt = Date.valueOf(bdy);
                            node.id = ida;//edw issos thelei na kanei ena elexno me mia sinartisi connect kai elennxos
                            bdays.add(node);
                            io = false;
                        } else {
                            System.out.println("wrong input");

                        }
                    } // LocalDate kj =LocalDate.parse(s);
                    //  kjm=Date.valueOf(kj);//.valueof(kj);
                    // System.out.println(kj.toString());
                    catch (NumberFormatException e) {
                        System.out.println("lathos input");

                    }
                }

            }

            if (k == 0) {
                System.out.println("den ipirxe o xristis");
            }
            rs.close();

            pstmt.close();
//            conn.close();

            StringBuffer sb2 = new StringBuffer("");
            sb2.append("INSERT INTO  birthday (Bday  ,id,Bday2) VALUES(?,?,?);");
            pstmt = conn.prepareStatement(sb2.toString());

            //System.out.println(lname);
            for (bdaystoixeia string : bdays) {
                System.out.println(sb2.toString());

                pstmt.setString(1, string.bday);
                pstmt.setDate(3, string.dt);

                System.out.println("exw   " + string.bday + "     kai     " + Integer.valueOf(string.id));
                if (!exist(string.id)) {
                    pstmt.setInt(2, string.id);

                    pstmt.execute();
                }
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

    public void join() {
        sind();

        Scanner stdin = new Scanner(System.in);
        System.out.println("dwse mou tin imerominia ");
        String bday = stdin.nextLine();
        LocalDate bdy = LocalDate.parse(bday);

        try {
            stmt = conn.createStatement();

            String query = "SELECT members.id,Fname, Lastname,Bday FROM catalog.members  inner join birthday  on members.id=birthday.id and birthday.Bday='" + bday + "';";
            ResultSet rs = stmt.executeQuery(query);
            int k = 0;
            while (rs.next()) {
                System.out.print(" to id einai " + rs.getInt(1));
                k++;
                System.out.print("Firstname : " + rs.getString(2));
                System.out.print(", LastName : " + rs.getString(3));
                System.out.println(", bday : " + rs.getString(4));
                // System.out.print(", Til2 : " + rs.getString(5));
                //System.out.print(" to id einai " + rs.getInt(1));

            }
            if (k < 1) {
                System.out.println("den brethike xristis");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean exist(int id) {
        try {
            Statement el = conn.createStatement();

            String query = "Select * from catalog.birthday where id = '" + id + "'";
            ResultSet rs = el.executeQuery(query);
            int k = 0;
            while (rs.next()) {
                k++;
            }
            if (k > 0) {
                rs.close();
                System.out.println("EXEIS IDI PANOGRAPSEI SE AUTON TON XRISTI");
                return true;
            } else {
                rs.close();
                return false;

            }

        } catch (SQLException ex) {
            Logger.getLogger(Diabasmakaiorasi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;

    }

    /*
    {SELECT Orders.OrderID, Customers.CustomerName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;
    }    
     */
}
