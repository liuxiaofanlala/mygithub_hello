import com.westos.Haohan;
import com.westos.HaohanService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class HaohanServiceImpl extends HaohanService{
    //根据序号查询好汉
    @Override
    public Haohan findaHaohan(Integer xuhao) {
        return super.findaHaohan(xuhao);
    }

    //显示所有好汉
    @Override
    public List<Haohan> listHaohan() {
        return super.listHaohan();
    }

    //添加好汉
    @Override
    public Haohan addHaohan(Haohan haohan) {
        //获取数据库连接
        String driverName="com.mysql.jdbc.Driver";
        // jdbc:mysql://<数据库服务器Ip>:<数据库服务器端口>/<数据库名>
        String url="jdbc:mysql://localhost:3306/hero1?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";
        try{
            Class.forName(driverName);
            //使用DriverManager获取连接
            Connection conn = DriverManager.getConnection(url, username, password);
            //执行insert语句

            String sql="insert into heroinfo(xuhao,xingming) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,haohan.getXuhao());
            ps.setString(2,haohan.getXingming());
            ps.executeUpdate();
            //释放资源
            ps.close();

            //关闭连接
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("数据库连接获取异常"+ex);
        }

        //返回结果
        return haohan;
    }

    @Override
    public Haohan updateHaohan(Haohan haohan) {
        return super.updateHaohan(haohan);
    }

    @Override
    public Haohan removeHaohan(Integer xuhao) {
        return super.removeHaohan(xuhao);
    }
}
