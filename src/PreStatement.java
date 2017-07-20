import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by raj on 19/7/17.
 */
public class PreStatement {
    Connection con=null;
    PreparedStatement pst=null;
    Scanner sc=new Scanner(System.in);

    PreStatement() throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.jdbc.Driver");
       con= DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCToday","root","raj");

    }

    void delete() throws SQLException {
        System.out.println("Enter id to delete row=");
        int id=sc.nextInt();

        System.out.println("Enter name");
        String name=sc.next();

        pst=con.prepareStatement("delete from mytab where id=? and name=?");
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.execute();

    }

    void insertData() throws SQLException {
        System.out.println("Enter details to insert into mytabs");
        System.out.println("Enter id:");
        int id=sc.nextInt();

        System.out.println("Enter name:");
        String name=sc.next();

        System.out.println("Enter city:");
        String city=sc.next();

        pst=con.prepareStatement("insert into mytab values(?,?,?)");
        pst.setInt(1,id);
        pst.setString(2,name);
        pst.setString(3,city);
        pst.execute();

        System.out.println("Data inserted successfully");
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PreStatement ps=new PreStatement();
//        ps.delete();
        ps.insertData();
    }
}
