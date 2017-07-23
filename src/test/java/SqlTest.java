import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.*;

/**
 * Created by caoqingguang on 2017/7/3.
 */
public class SqlTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url="jdbc:postgresql://192.168.221.153:5432/test";
        String user="tvm";
        String password="123456";
//        Class.forName("org.postgresql.Driver");
//
//        Connection connection = DriverManager.getConnection(url, user, password);
//        String sql="select * from mycell order by id";
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        while (resultSet.next()){
//            int id=resultSet.getInt(1);
//            String cname=resultSet.getString(2);
//            System.out.println(String.format("id:%s,\t cname:%s",id,cname));
//        }

        JdbcConnectionSource jdbcConnectionSource = new JdbcConnectionSource(url, user, password);
        Dao<MyCell, Integer> dao = DaoManager.createDao(jdbcConnectionSource, MyCell.class);
        MyCell myCell = dao.queryForId(1);
        System.out.println(myCell);
        myCell.setCname("444555tmp");
        dao.update(myCell);
        MyCell myCell1 = dao.queryForId(32);
        System.out.println(myCell1);
    }
}
