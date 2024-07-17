package Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;

public class TestDb {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DataBaseUtility DbLib = new DataBaseUtility();
		DbLib.getDbConnection();
		
		ResultSet r=DbLib.executeConSelectQuery("select * from company");
		while (r.next()) {
			System.out.println(r.getString(1)+"\t"+r.getString(2)+"\t"+r.getString(3)+"\t"+r.getString(4)+"\t"+r.getString(5)+"\t"+r.getString(6));
		}
	DbLib.closeDbconnection();
		System.out.println("=============Close the Connection==============");
	}

	}


