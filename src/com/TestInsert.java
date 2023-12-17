package com.Lin.tool.utils;

import java.sql.*;

public class TestInsert {
    public static void main(String[] args){
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            String sql = "";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行

            int i = preparedStatement.executeUpdate(sql);//执行
            if(i > 0){//有受影响的数据
                System.out.println("输入成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,null);
        }

    }
}
