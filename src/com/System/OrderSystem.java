package com.System;

import com.utils.JdbcUtils;
import java.util.Date;
import java.sql.*;

public class OrderSystem {
    public static void insert(int information,double orderprice){//对订单表的增加
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "insert into o_order(`information`,`orderprice`,`ordertime`) values (?,?,?)";
            String sql1 = "select * from product where `p_id` = ?;";
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement1 = connection.prepareStatement(sql1);//预编译，不执行
            preparedStatement.setInt(1,information);
            preparedStatement.setDouble(2,orderprice);
            preparedStatement.setDate(3,new java.sql.Date(new Date().getTime()));
            preparedStatement1.setInt(1,information);
            resultSet = preparedStatement1.executeQuery();//执行
            if(!resultSet.next()){
                System.out.println("无此商品，增加订单失败");
            }else{
                int i = preparedStatement.executeUpdate();//执行
                if(i > 0){//有受影响的数据
                    System.out.println("增加成功");
                }else{
                    System.out.println("增加失败");
                }
            }
            connection.commit();//关闭事务
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,preparedStatement1,resultSet);
        }
    }

    public static void drop(int o_id){//对订单表的删除操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "delete from o_order where o_id = ?";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement.setInt(1,o_id);
            int i = preparedStatement.executeUpdate();//执行
            connection.commit();//关闭事务
            if(i > 0){//有受影响的数据
                System.out.println("删除成功");
            }else{
                System.out.println("无此订单");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,null);
        }
    }

    public static void update(int o_id,int information,double orderprice){//对订单表的更新操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        PreparedStatement preparedStatement1 = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "update `o_order` set `information`=?,`orderprice`=?,`ordertime`=? where o_id=?";
            String sql1 = "select * from product where `p_id` = ?;";
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement1 = connection.prepareStatement(sql1);//预编译，不执行
            preparedStatement.setInt(1,information);
            preparedStatement.setDouble(2,orderprice);
            preparedStatement.setDate(3,new java.sql.Date(new Date().getTime()));
            preparedStatement.setInt(4,o_id);
            preparedStatement1.setInt(1,information);
            resultSet = preparedStatement1.executeQuery();//执行
            if(!resultSet.next()){
                System.out.println("无此商品，更新订单失败");
            }else{
                int i = preparedStatement.executeUpdate();//执行
                if(i > 0){//有受影响的数据
                    System.out.println("更新成功");
                }else{
                    System.out.println("更新失败");
                }
            }
            connection.commit();//关闭事务
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,preparedStatement1,resultSet);
        }
    }
    public static void queryAll(){//对订单表的查询
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from o_order";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                System.out.println("o_id:" + resultSet.getInt("o_id") + "\tinformation:" + resultSet.getInt("information") + "\torderprice:" + resultSet.getDouble("orderprice") + "\tordertime" + resultSet.getDate("ordertime"));
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }

    public static void queryByPriceASC(){//按价格升序
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from o_order order by orderprice ASC";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                System.out.println("o_id:" + resultSet.getInt("o_id") + "\tinformation:" + resultSet.getInt("information") + "\torderprice:" + resultSet.getDouble("orderprice") + "\tordertime" + resultSet.getDate("ordertime"));
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }

    public static void queryByPriceDESC(){//按价格降序
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from o_order order by orderprice DESC";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                System.out.println("o_id:" + resultSet.getInt("o_id") + "\tinformation:" + resultSet.getInt("information") + "\torderprice:" + resultSet.getDouble("orderprice") + "\tordertime" + resultSet.getDate("ordertime"));
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }

    public static void queryByTimeASC(){//按时间升序
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from o_order order by ordertime ASC";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                System.out.println("o_id:" + resultSet.getInt("o_id") + "\tinformation:" + resultSet.getInt("information") + "\torderprice:" + resultSet.getDouble("orderprice") + "\tordertime" + resultSet.getDate("ordertime"));
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }

    public static void queryByTimeDESC(){//按时间降序
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from o_order order by ordertime DESC";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                System.out.println("o_id:" + resultSet.getInt("o_id") + "\tinformation:" + resultSet.getInt("information") + "\torderprice:" + resultSet.getDouble("orderprice") + "\tordertime" + resultSet.getDate("ordertime"));
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }

    public static void queryByDay(Date ordertime){//按时间查询
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用PrepareStatement对象解决sql注入问题:把传递进来的参数当作字符
        ResultSet resultSet = null;
        boolean key = false;
        try {
            connection = JdbcUtils.getConnection();//获取数据库链接
            connection.setAutoCommit(false);//开启事务
            String sql = "select * from o_order where ordertime = ?";//使用？占位符代替参数
            preparedStatement = connection.prepareStatement(sql);//预编译，不执行
            preparedStatement.setDate(1, (java.sql.Date) ordertime);
            resultSet =  preparedStatement.executeQuery();//执行
            connection.commit();//关闭事务
            while(resultSet.next()){
                key = true;
                System.out.println("o_id:" + resultSet.getInt("o_id") + "\tinformation:" + resultSet.getInt("information") + "\torderprice:" + resultSet.getDouble("orderprice") + "\tordertime" + resultSet.getDate("ordertime"));
            }
            if(!key){
                System.out.println("无此订单");
            }
        } catch (//默认回滚
                SQLException e) {
            throw new RuntimeException(e);
        }finally{//释放
            JdbcUtils.release(connection,preparedStatement,resultSet);
        }
    }
}
