package com.product;

import com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSystem {
    public static void insert(int p_id,String name,double price){//对商品表的增加操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "insert into product(`p_id`,`name`,`price`) values (?,?,?)";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement.setInt(1, p_id);
            preparedStatement.setString(2,name);
            preparedStatement.setDouble(3, price);
            int i = preparedStatement.executeUpdate();//执行
            connection.commit();//关闭事务
            if(i > 0){//有受影响的数据
                System.out.println("输入成功");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,null);
        }
    }

    public static void drop(int p_id){//对商品表的删除操作
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        PreparedStatement preparedStatement2 = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql1 = "delete from product where `p_id` = ?";
            String sql2 = "select * from order";
            preparedStatement1 = connection.prepareStatement(sql1);//预编译，不执行
            preparedStatement2 = connection.prepareStatement(sql2);//预编译，不执行
            resultSet = preparedStatement2.executeQuery();
            while(resultSet.next()) {
                if (resultSet.getInt("information") == p_id){
                    throw new Exception();
                }
            }
            preparedStatement1.setInt(1,p_id);
            int i = preparedStatement1.executeUpdate();//执行
            connection.commit();//关闭事务
            if(i > 0){//有受影响的数据
                System.out.println("删除成功");
            }
        } catch (Exception e) {
            System.out.println("删除失败");
            //throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement1,resultSet);
        }
    }
    public static void update(int p_id,String name,double price){//对商品表的删除操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "update `product` set `name`=?,`price`=? where `c_id`=?";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement.setInt(1,p_id);
            preparedStatement.setString(2,name);
            preparedStatement.setDouble(3,price);
            int i = preparedStatement.executeUpdate(sql);//执行
            connection.commit();//关闭事务
            if(i > 0){//有受影响的数据
                System.out.println("更改成功");
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,null);
        }


    }
}
