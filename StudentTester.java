
//Exceptions I have to import in order to throw them in the main file.
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class StudentTester {

   /*
    * Variables created in order to access my personal SQL database. Have to make
    * an API in the form of a URL in order to get the data retrieval started. And
    * have to make variables for my username and password.
    */
   static Connection connection = null;
   static String url = "jdbc:mysql://localhost:3306/studentinfo";

   static String username = "root";
   static String password = "new_password";

   // Must throw these exceptions which create compile errors if not done properly.
   public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException,
         ClassNotFoundException, FileNotFoundException {

      // Object created to access multiple functions within the Choice(String choice)
      // function of the Student class.
      Student main1 = new Student();
      main1.Choice("");

      // JSONObject obj = new JSONObject();
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "new_password");
      Statement st = connection.createStatement();
      ResultSet rs = st.executeQuery("SELECT * from students;");

      // Object created in order to retrieve more specific information about table
      // columns. In this case, it grabs the column count.
      ResultSetMetaData rsmd = rs.getMetaData();
      int colnos = rsmd.getColumnCount();

      // Loop created to let program know to read through table columns and output the
      // column data.
      while (rs.next()) {
         for (int i = 1; i < colnos; i++) {
            System.out.print(rs.getString(i) + " " + "\n\n");
            System.out.println(rs);
         }
      }

   }
}
