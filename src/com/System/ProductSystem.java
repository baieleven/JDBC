package com.System;

import com.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSystem {
    public static void insert(String name,double price){//对商品表的增加操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "insert into System(`name`,`price`) values (?,?)";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2, price);
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
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "delete from System where `p_id` = ?";
            String sql1 = "select * from o_order where `information` = ?;";
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement1 = connection.prepareStatement(sql1);//预编译，不执行
            preparedStatement.setInt(1,p_id);
            preparedStatement1.setInt(1,p_id);
            resultSet = preparedStatement1.executeQuery();//执行
            if(resultSet.next()){
                System.out.println("删除失败");
            }else{
                int i = preparedStatement.executeUpdate();//执行
                if(i > 0){//有受影响的数据
                    System.out.println("删除成功");
                }else{
                    System.out.println("删除失败");
                }
            }
            connection.commit();//关闭事务
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,preparedStatement1,resultSet);
        }
    }
    public static void update(int p_id,String name,double price){//对商品表的更新操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "update `System` set `name`=?,`price`=? where `p_id`=?";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement.setString(1,name);
            preparedStatement.setDouble(2,price);
            preparedStatement.setInt(3,p_id);
            int i = preparedStatement.executeUpdate();//执行
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

    public static void queryAll(){//对商品表的查询操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from System";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                System.out.println("p_id:" + resultSet.getInt("p_id") + "\tname:" + resultSet.getString("name") + "\tprice:" + resultSet.getDouble("price"));
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }

    public static void queryByPriceASC(){//价格升序查询
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from System order by price ASC";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                System.out.println("p_id:" + resultSet.getInt("p_id") + "\tname:" + resultSet.getString("name") + "\tprice:" + resultSet.getDouble("price"));
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }

    public static void queryByPriceDESC(){//价格降序查询
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from System order by price DESC";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                System.out.println("p_id:" + resultSet.getInt("p_id") + "\tname:" + resultSet.getString("name") + "\tprice:" + resultSet.getDouble("price"));
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }

    public static void queryByName(String name){//按名字查询
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        boolean key = false;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from System where `name` = ?";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement.setString(1,name);
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                key = true;
                System.out.println("p_id:" + resultSet.getInt("p_id") + "\tname:" + resultSet.getString("name") + "\tprice:" + resultSet.getDouble("price"));
            }
            if(!key){
                System.out.println("无此商品");
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }
}
