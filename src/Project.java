import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Project {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://127.0.0.1:3306/databasetest?serverTimezone=UTC";

		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "1234");
			
			/*---------------------------------------------------------------1번----------------------------------------------------------------------*/				
			Statement sz = con.createStatement();
			String abc = "CREATE TABLE `databasetest`.`addressbook` (`id` INT NOT NULL, `name` VARCHAR(45) NULL, `tel` VARCHAR(45) NULL,"
					+ " `email` VARCHAR(60) NULL, `address` VARCHAR(60) NULL, PRIMARY KEY (`id`));";	/* ******	PRIMARY KEY추가 했습니다!.	******* */
			sz.executeUpdate(abc);				
			/*---------------------------------------------------------------------------------------------------------------------------------------*/
										
			

			
			
			/*---------------------------------------------------------------2번----------------------------------------------------------------------*/					
			PreparedStatement st = con.prepareStatement("insert into databasetest.addressbook values(?,?,?,?,?)");			
			st.setInt(1, 1);
			st.setString(2, "Ha Seongjun");
			st.setString(3, "010-5007-2728");
			st.setString(4, "junwojjang@gmail.com");
			st.setString(5, "Hwaseong-si Gyeonggi-do");	
			st.executeUpdate();
			
			String a = "(2,'Lee YS','010-1234-5678','yslee@gmail.com','Gwangju Metropolitan City')";
			PreparedStatement sa = con.prepareStatement("insert into databasetest.addressbook values" + a);
			sa.executeUpdate();
			
			String b = "(3,'Chae JH','010-1212-3434','jhchae@gmail.com','Seo-gu Incheon Metropolitan City ')";
			PreparedStatement sb = con.prepareStatement("insert into databasetest.addressbook values" + b);
			sb.executeUpdate();
			
			String c = "(4,'Kim JH','010-4545-6767','jhkim@gmail.com','Bucheon, Gyeonggi Province')";
			PreparedStatement sc = con.prepareStatement("insert into databasetest.addressbook values" + c);
			sc.executeUpdate();
			
			String d = "(5,'Park SW','010-7878-9090','swpark@gmail.com','Jindo Island in Jeolla-do')";
			PreparedStatement sd = con.prepareStatement("insert into databasetest.addressbook values" + d);
			sd.executeUpdate();			
			/*---------------------------------------------------------------------------------------------------------------------------------------*/
			
			
			
			
			
			/*---------------------------------------------------------------3번----------------------------------------------------------------------*/			
			Statement aa = con.createStatement();
			String aaa = "UPDATE `databasetest`.`addressbook` SET `email` = 'junwojjang@naver.com' WHERE (`id` = '1');";
			aa.executeUpdate(aaa);
			
			Statement bb = con.createStatement();
			String bbb = "UPDATE `databasetest`.`addressbook` SET `email` = 'yslee@naver.com' WHERE (`id` = '2');";
			bb.executeUpdate(bbb);
			
			Statement cc = con.createStatement();
			String ccc = "UPDATE `databasetest`.`addressbook` SET `email` = 'jhchae@naver.com' WHERE (`id` = '3');";
			cc.executeUpdate(ccc);
			
			Statement dd = con.createStatement();
			String ddd = "UPDATE `databasetest`.`addressbook` SET `email` = 'jhkim@naver.com' WHERE (`id` = '4');";
			dd.executeUpdate(ddd);
			
			Statement ee = con.createStatement();
			String eee = "UPDATE `databasetest`.`addressbook` SET `email` = 'swpark@naver.com' WHERE (`id` = '5');";
			ee.executeUpdate(eee);			
			/*---------------------------------------------------------------------------------------------------------------------------------------*/
			
			
			
			
			
			/*---------------------------------------------------------------4번----------------------------------------------------------------------*/
			Statement xx = con.createStatement();
			String xxx = "DELETE FROM `databasetest`.`addressbook` WHERE (`id` = '5');";
			xx.executeUpdate(xxx);
			
			Statement yy = con.createStatement();
			String yyy = "DELETE FROM `databasetest`.`addressbook` WHERE (`id` = '4');";
			yy.executeUpdate(yyy);
			/*---------------------------------------------------------------------------------------------------------------------------------------*/
			
			
			
			
			String sql = "SELECT * FROM databasetest.addressbook";
			ResultSet rs = sz.executeQuery(sql);		//select라는 조회 업무를 사용하기 때문에 executeUpdate(sql); 이 아니라 executeQuery(sql)사용!		
			
			while(rs.next()) {
				int id = rs.getInt("id"); 			
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String address = rs.getString("address");
				System.out.printf("id: %d, name: %s, tel: %s, email: %s, address: %s" + "\n", id, name, tel, email, address);
			}		

			rs.close();		sz.close();		sa.close();		sb.close();		sc.close();		sd.close();
			st.close();		aa.close();		bb.close();		cc.close();		dd.close();		ee.close();
			con.close();	xx.close();		yy.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}