package com.infobeans.DAO;
import com.infobeans.model.*;
import java.sql.*;

import java.sql.DriverManager;
import java.util.*;

import com.infobeans.Service.*;
public class S_dao {

	String  url ="jdbc:mysql://localhost:3306/test";
	String user ="root";
	String password="Abhi@2001";
	private Connection getCon() throws  SQLException{
		return
				DriverManager.getConnection(url, user, password);
	}
	//------------------------------------------------------first functionality
	
	public void getAdd(Student a) throws SQLException{
		Connection con = getCon();
		String query="insert into student(s_id,name,class,t_id)values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1,a.getS_id());
		pst.setString(2,a.getS_name());
		pst.setInt(3,a.getS_class());
		pst.setInt(4,a.getT_id());
		pst.executeUpdate();
		System.out.println("Inserted succuessfully");
	}
	//-----------------------------------------------------second functionality fetching
	public List<Student>getAll() throws SQLException{
		Connection con = getCon();
		String query ="select * from student order by name asc";
		PreparedStatement pst = con.prepareStatement(query);
		ResultSet rs = pst.executeQuery();
		List<Student> all = new ArrayList<Student>();
		while(rs.next()) {
			Student obj = new Student(
					rs.getInt("s_id"),
					rs.getString("name"),
					rs.getInt("class"),
					rs.getInt("t_id"));
			all.add(obj);
		}
		return all;
		
	}
	//------------------------------------------------------------------third functionality
	public List<Fianance>findbyfees(int s_id) throws SQLException{
		Connection con = getCon();
		String query ="select * from fees where s_id = '"+s_id+"' ";
		PreparedStatement pst = con.prepareStatement(query);
	//	pst.setInt(1,f_id);
		//pst.setInt(2,f_id);
		ResultSet rs = pst.executeQuery();
		List<Fianance> all1 = new ArrayList<Fianance>();
		while(rs.next()) {
			Fianance obj = new Fianance(
					rs.getInt("fee_id"),
					rs.getInt("s_id"),
					rs.getInt("fee")
					);
			all1.add(obj);
		}
		return all1;
	}
	//------------------------------------------------------------------------------ fourth functionality
		public void getupdate(int id,String name) throws SQLException{
			Connection con = getCon();
			String query ="update student set name = '"+name+"' where s_id ='"+id+"'";
			PreparedStatement pst = con.prepareStatement(query);
		//	pst.setString(1,name);
			//pst.setInt(2,id);
			int i =  pst.executeUpdate();
			if(i>0)
				System.out.println("Updated successfully");
			else {
				System.out.println("not updated ");
			}
			
		}
	// -------------------------------------------------------------------------fifth functioanlity
		public void getDelete(int id) throws SQLException{
			Connection con = getCon();
			String query ="delete from student where s_id='"+id+"'";
			PreparedStatement pst = con.prepareStatement(query);
			int i = pst.executeUpdate();
			if(i>=0)
				System.out.println("Deleted done");
			else
				System.out.println("Not deleted");
		}
	//----------------------------------------------------------------------------sixth functionality
		public void getClass1(int cl)throws  SQLException{
			Connection con = getCon();
			String query ="select  count(*) from student where class='"+cl+"' ";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			// List<Student> all = new ArrayList<Student>();
			while(rs.next())
				{
			//System.out.println(rs.getInt(1));
				//int c =rs.getInt("class");
				int cc = rs.getInt(1);
				if(cc>0)
					System.out.println(cc);
				else
					System.out.println("no class exixts");
			//	System.out.println("the class "+c +"  numberr of student "+cc);
				}
			
		}
		//------------------------------------------------------------------------seventh functionality
		public List<Student>getTeacher(int id)  throws SQLException{
			Connection con = getCon();
			String query ="select * from student where t_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
			List<Student> gett = new ArrayList<Student>();
			while(rs.next()) {
				Student obj = new Student(
						rs.getInt("s_id"),
						rs.getString("name"),
						rs.getInt("class"),
						rs.getInt("t_id"));
				gett.add(obj);
			}
			return gett;
		}
		
		//------------------------------------------------------------------Eight functionality
		public List<Student>getperform()  throws SQLException{
			Connection con = getCon();
			String query ="select * from student join performance on  student.s_id = performance.s_id having(performance.day>20)";
			PreparedStatement pst = con.prepareStatement(query);
			// pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
			List<Student> gett1 = new ArrayList<Student>();
			while(rs.next()) {
				Student obj = new Student(
						rs.getInt("s_id"),
						rs.getString("name"),
						rs.getInt("class"),
						rs.getInt("t_id"));
				gett1.add(obj);
			}
			return gett1;
		}
			//-------------------------------------------------------------ninth functionality 
			public List<Student>daycount(int day)  throws SQLException{
				Connection con = getCon();
				String query ="select * from student join performance on  student.s_id = performance.s_id having(performance.day> ?)";
				PreparedStatement pst = con.prepareStatement(query);
				 pst.setInt(1,day);
				ResultSet rs = pst.executeQuery();
				List<Student> gett2 = new ArrayList<Student>();
				while(rs.next()) {
					Student obj = new Student(
							rs.getInt("s_id"),
							rs.getString("name"),
							rs.getInt("class"),
							rs.getInt("t_id"));
					gett2.add(obj);
				}
				return gett2;
		}
			//-------------------------------------------------------------------10
			public void addTeacher(Teacher t1) throws SQLException{
				Connection con = getCon();
				String query = "insert into teacher(t_id,name,expert)values(?,?,?)";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1,t1.getT_id());
				pst.setString(2,t1.getT_name());
				pst.setString(3,t1.getExpert());
				pst.executeUpdate();
				System.out.println("enter successfully");
			}
		//-------------------------------------------------------------------------11
			public void getDeletet(int id) throws SQLException{
				Connection con = getCon();
				String query ="delete from teacher where t_id='"+id+"'";
				PreparedStatement pst = con.prepareStatement(query);
				int i = pst.executeUpdate();
				if(i>=0)
					System.out.println("Deleted done");
				else
					System.out.println("Not deleted");
			}
			//----------------------------------------------------------------12
			public List<Student>testper(int percent)  throws SQLException{
				Connection con = getCon();
				
				// String query1 ="select distinct  t_id,t_name from student where percent>?";
				// String query ="select distinct t_id from teacher join student on student.t_id=teacher.t_id having(student.percent>?)";
				String query ="select *  from student where percent >='"+percent+"'";
				PreparedStatement pst = con.prepareStatement(query);
				// pst.setInt(1,percent);
				ResultSet rs = pst.executeQuery();
				List<Student> gett2 = new ArrayList<Student>();
				while(rs.next()) {
					Student obj = new Student(
							rs.getInt("s_id"),
							rs.getString("name"),
							rs.getInt("class"),
							rs.getInt("t_id"));
					gett2.add(obj);
				}
				return gett2;
				//---------------------------problem
		}
			//---------------------------------13
			public void feeMethod()  throws SQLException{
				Connection con = getCon();
				String query ="select student.name,fees.fee from student join fees on student.s_id=fees.s_id;";
				PreparedStatement pst = con.prepareStatement(query);
				 
				ResultSet rs = pst.executeQuery();
				List<fee> gett2 = new ArrayList<fee>();
				/*while(rs.next()) {
					Student obj = new Student(
							rs.getInt("s_id"),s
							rs.getString("name"),
							rs.getInt("class"),
							rs.getInt("t_id"));
					gett2.add(obj);
				}
				return gett2; */
			//	List<Integer>getfee = new ArrayList<Integer>();
				
				while(rs.next()) {
					fee obj1 = new fee(
							rs.getString("name"),
							rs.getInt("fee"));
					gett2.add(obj1);
				}
				for(fee S:gett2) {
					System.out.print(S.getName()+"   ");
					System.out.print(S.getFees()+"   ");
					System.out.println();
				}
				
		}
			//-----------------------------------------------------14
			public void getupdateteacher(int old_id,int new_id) throws SQLException{
				Connection con = getCon();
				String query ="update teacher set t_id = '"+new_id+"' where t_id ='"+old_id+"'";
				PreparedStatement pst = con.prepareStatement(query);
			//	pst.setString(1,name);
				//pst.setInt(2,id);
				int i =  pst.executeUpdate();
				if(i>0)
					System.out.println("Updated successfully");
				else {
					System.out.println("not updated ");
				}
				
			}
			//--------------------------------------------------------16
			public List<Teacher>allteacher()  throws SQLException{
				Connection con = getCon();
				String query ="select * from teacher ";
				PreparedStatement pst = con.prepareStatement(query);
				//pst.setInt(1,id);
				ResultSet rs = pst.executeQuery();
				List<Teacher> gett = new ArrayList<Teacher>();
				while(rs.next()) {
					Teacher obj = new Teacher(
							rs.getInt("t_id"),
							rs.getString("t_name"),
							rs.getString("expert")
						);
					gett.add(obj);
				}
				return gett;
			}
		//-------------------------------------------------- deposting fees
			public void depositfee(Fianance a) throws SQLException{
				Connection con = getCon();
				String query="insert into fees(fee_id,s_id,fee)values(?,?,?)";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1,a.getS_id());
				pst.setInt(2,a.getS_id());
				pst.setInt(3,a.getFees());
				
				pst.executeUpdate();
				System.out.println("Inserted succuessfully");
			}
			
		
		
}
