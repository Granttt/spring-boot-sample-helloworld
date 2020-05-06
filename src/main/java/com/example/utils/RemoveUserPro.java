package com.zdd.account.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class RemoveUserPro {
    public static void main(String[] args) {

        long userId = 22582;
//        long userId = 517177;
        Jedis jedis = null;
        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            String url = "jdbc:mysql://10.0.10.210:3306/zdd_api?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8&useSSL=false";
//            String u = "root";
//            String p = "Xltdb@2019!";
//            String url = "jdbc:mysql://10.0.10.230:3306/zdd_api?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8&useSSL=false";
//            String u = "zdd_admin";
//            String p = "Xlt@2019";
            String url = "jdbc:mysql://172.16.0.240:4000/zdd_api?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8&useSSL=false";
            String u = "root";
            String p = "Xlttidb@2019!";
            c = DriverManager.getConnection(url, u, p);
            c.setAutoCommit(false);
            String sql = "select user_id,phone,open_id from user_info where user_id = ?";

            sql = "delete from privilege_record where grade != 1 and user_id = ?";
            pst = c.prepareStatement(sql);
            pst.setLong(1,userId);
            int rst = pst.executeUpdate();
            System.out.println("删除了"+rst+"行");

            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(1);//设置最大连接数，默认为8
            config.setMaxIdle(1); //设置最大空闲连接数，默认为8
            config.setMinIdle(1); //设置最小空闲连接数，默认为0
//            JedisPool pool = new JedisPool(config, "10.0.10.213", 6379);
            JedisPool pool = new JedisPool(config, "172.16.0.71", 6379);
            jedis = pool.getResource();
            jedis.auth("Xltredis@2019");
            jedis.select(10);
            jedis.del("MEMBERSHIP:GOLD:USER:OIL_USER:"+userId);
            jedis.del("MEMBERSHIP:GOLD:USER:BLACK_USER:"+userId);
//            jedis.del("MEMBERSHIP:USER");
            //删除hash key下特定的元素
            jedis.hdel("MEMBERSHIP:USER",String.valueOf(userId));
            jedis.select(1);
            jedis.del("ACCOUNT:USER_INFO_ID:"+userId);
            c.commit();
        }catch (Exception e){
            try {
                if(null!=c) c.rollback();
            }catch (Exception ee){
                ee.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try{
                if(null!=c) c.close();
                if(null!=rs) rs.close();
                if(null!=pst) pst.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            if(null!=jedis) jedis.close();
            //跨库操作数据
            updateUser(userId);
        }
    }
    public static void updateUser(long userId){

        Jedis jedis = null;
        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://172.16.0.240:4000/chaos_account?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8&useSSL=false";
            String u = "root";
            String p = "Xlttidb@2019!";
//            String url = "jdbc:mysql://10.0.10.230:3306/account?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF8&useSSL=false";
//            String u = "zdd_admin";
//            String p = "Xlt@2019";
            c = DriverManager.getConnection(url, u, p);
            c.setAutoCommit(false);
            String sql = "update user_info set level = 1 where user_id = ? and level != 1";

            pst = c.prepareStatement(sql);
            pst.setLong(1,userId);
            int rst=pst.executeUpdate();//更新操作

            //redis集群
            Set<String> sentinels = new HashSet<>();
            String hostAndPort1 = "172.16.0.31:26379";
//            String hostAndPort2 = "172.16.0.32:26379";
//            String hostAndPort3 = "172.16.0.33:26379";
            sentinels.add(hostAndPort1);
//            sentinels.add(hostAndPort2);
//            sentinels.add(hostAndPort3);
            String clusterName = "mymaster17379" ;
            JedisSentinelPool redisSentinelJedisPool = new JedisSentinelPool(clusterName,sentinels);

            jedis = redisSentinelJedisPool.getResource();
            jedis.auth("Xltredis@2019");
            jedis.select(1);
            jedis.del("ACCOUNT:USER_INFO_ID:"+userId);

            //单个redis
//            JedisPool pool = new JedisPool(config, "172.16.0.71", 6379);
//            jedis = pool.getResource();
//            jedis.auth("Xltredis@2019");
//            jedis.select(1);
//            jedis.del("ACCOUNT:USER_INFO_ID:"+userId);


            //一定要commit 不然sql不会执行
            c.commit();
            System.out.println("改动了"+rst+"行");

        }catch (Exception e){
            try {
                if(null!=c) c.rollback();
            }catch (Exception ee){
                ee.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try{
                if(null!=c) c.close();
                if(null!=rs) rs.close();
                if(null!=pst) pst.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}