package com.king4cloud.common.core.utils;

import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
    /**
     *
     * @param host
     * @param port
     * @param existDbName
     * @param username
     * @param password
     * @param
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    public static void createDbAndDoSql(String host, String port, String existDbName, String newDbName, String username, String password, InputStream inputStream)
            throws ClassNotFoundException, SQLException, FileNotFoundException, UnsupportedEncodingException {
        Class.forName("com.mysql.jdbc.Driver");
        //一开始必须填一个已经存在的数据库
        String url = StrUtil.format("jdbc:mysql://{}:{}/{}?characterEncoding=utf-8&useSSL=false&autoReconnect=true&rewriteBatchedStatements=true", host, port, existDbName);
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stat = conn.createStatement();

        //创建数据库hello
        stat.executeUpdate("create database `" + newDbName + "` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci");

        //打开创建的数据库
        stat.close();
        conn.close();
        url = StrUtil.format("jdbc:mysql://{}:{}/{}?characterEncoding=utf-8&useSSL=false&autoReconnect=true&rewriteBatchedStatements=true", host, port, newDbName);
        conn = DriverManager.getConnection(url, username, password);

        conn.setAutoCommit(false);
        ScriptRunner runner = new ScriptRunner(conn);
        runner.setAutoCommit(false);
        runner.runScript(new InputStreamReader(inputStream, "UTF-8"));

        stat.close();
        conn.close();
    }
}
