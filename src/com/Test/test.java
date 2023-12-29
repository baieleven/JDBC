package com.Test;

import com.System.OrderSystem;
import com.System.ProductSystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) throws ParseException {
        ProductSystem ps = new ProductSystem();
        OrderSystem os = new OrderSystem();
        //ps.insert("白酒",20);
        //ps.drop(1);
        //ps.drop(3);
        //ps.drop(100);
        //ps.update(8,"西瓜",30);
        //ps.queryAll();
        //ps.queryByPriceASC();
        //ps.queryByPriceDESC();
        //ps.queryByName("鸡蛋");
        //ps.queryByName("鹅蛋");

        //os.insert(1,2.0);
        //os.insert(100,2);
        //os.drop(3);
        //os.drop(20);
        //os.update(1,2,4.0);
        ///os.queryAll();
        //os.queryByPriceASC();
        //os.queryByPriceDESC();
        //os.queryByTimeASC();
        //os.queryByTimeDESC();
        /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2023-12-06");
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        os.queryByDay(date2);*/
    }
}
