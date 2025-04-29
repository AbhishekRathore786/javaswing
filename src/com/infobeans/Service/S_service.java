package com.infobeans.Service;
import com.infobeans.model.*;
import com.infobeans.DAO.*;
import  java.sql.SQLException;
import java.util.List;
public class S_service {
				S_dao sdao;
				public S_service() {
					sdao = new S_dao();
				}
		public void getAdd(Student a) throws SQLException {
				sdao.getAdd(a);
		}
		//-----------------------------------------second functionalilty
		public List<Student>getAll() throws SQLException{
			return 
					sdao.getAll();
			
		} 
		//-----------------------------------------
		public List<Fianance>getbyfees(int s_id) throws SQLException{
			return 
					sdao.findbyfees(s_id);
		}
		public void getUpdate(int id,String name) throws SQLException{
			sdao.getupdate(id,name);
		}
		public void getDelete(int id) throws SQLException{
					sdao.getDelete(id);
		}
		public void getClass1(int cl) throws SQLException {
			sdao.getClass1(cl);
		}
		public List<Student>getbyt(int id) throws SQLException{
			return 
					sdao.getTeacher(id);
		}
		public List<Student>gett1() throws SQLException{
			return 
					sdao.getperform();
		}
		public List<Student>gett2(int day) throws SQLException{
			return 
					sdao.daycount(day);
		}
		public void addTeacher(Teacher t1) throws SQLException{
			sdao.addTeacher(t1);
		}
		public void getDeletet(int id) throws SQLException{
			sdao.getDeletet(id);
		}
		public List<Student>testper(int percent) throws SQLException{
			return 
					sdao.testper(percent);
		}
		public void feeMethod() throws SQLException{
			sdao.feeMethod();
		}
		public void getUpdateteacher(int old_id,int new_id) throws SQLException{
			sdao.getupdateteacher(old_id,new_id);
		}
		public List<Teacher>allteacher() throws SQLException{
			return 
					sdao.allteacher();
		}
		public void depositfee(Fianance a) throws SQLException {
			sdao.depositfee(a);
	}
}
