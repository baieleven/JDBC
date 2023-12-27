项目结构：{
C:.
├─.idea
│  └─libraries
├─lib//含有mysql驱动包
└─src
└─com
├─System//含有ProductSystem和OrderSystem两个类，分别对商品表和订单表进行增删改查
├─Test//测试类
├─utils//内含JdbcUtils工具类，方便连接数据库与资源释放
└─db.properties//资源配置文件
}
ProdectSystem:insert(String name,double price)实现对商品表的增加操作
drop(int p_id)对商品表的删除操作(已经在订单表中有的商品不会被删除)
update(int p_id,String name,double price)对商品表的更新操作
queryAll(){//对商品表的查询操作，显示商品表
queryByPriceASC()价格升序查询
queryByPriceDESC()价格降序查询
queryByName(String name)按名字查询
OrderSystem:insert(int information,double orderprice)对订单表的增加(商品表需要有此商品)
drop(int o_id){//对订单表的删除操作
update(int o_id,int information,double orderprice)对订单表的更新操作
queryAll(){//对订单表的查询
queryByPriceASC()按价格升序
queryByPriceDESC()按价格降序
queryByTimeASC()按时间升序
queryByTimeDESC()按时间降序
queryByDay(Date ordertime)按日期查询
JdbcUtils：getConnection()//与数据库连接
release(Connection c, Statement s, ResultSet r)//释放资源
release(Connection c, Statement s1, Statement s2 ,ResultSet r)//有两个statement对象时使用
项目亮点：无