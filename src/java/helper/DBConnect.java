
package helper;
import helper.EmailSend;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

 //?autoReconnect=true databse username and password on server "bb_admin" and password "ZAKIR!@#123"
public class DBConnect {
        private static final String URL="jdbc:mysql://localhost:3306/propertymanagement";
	private static final String USER="root";
	private static final String PASSWORD="root";
        public static Connection getDBConnection()
        {
            EmailSend  sending= new EmailSend();
            StringWriter errors = new StringWriter();
            Connection conn=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn=DriverManager.getConnection(URL,USER,PASSWORD);
            } 
            catch(ClassNotFoundException  ex)
            {
                ex.printStackTrace(new PrintWriter(errors));
                 sending.emailSending("ClassNotFoundException from  getDBConnection mthod in DBConnect Class"+errors.toString());
            }
            catch(SQLException e)
            {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("SQLException from  getDBConnection mthod in DBConnect Class"+errors.toString());
            }
            catch(Exception e)
            {
                e.printStackTrace(new PrintWriter(errors));
                sending.emailSending("Exception from  getDBConnection mthod in DBConnect Class"+errors.toString());
            }
            return conn;
        }
        public static void closeConnection(PreparedStatement pstmt, Connection conn)
	{
                EmailSend  sending= new EmailSend();
                StringWriter errors = new StringWriter();
		try 
		{
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("SQLException from closeConnection method from DBConnect method"+errors.toString());
		}
                catch(Exception e)
                {
                    e.printStackTrace(new PrintWriter(errors));
                    sending.emailSending("Exception from closeConnection method"+errors.toString());
                }

	}
        
}
