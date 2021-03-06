package core;

import java.sql.*;
import java.util.logging.*;

public class DaoUrl
{
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_Name = "lanjut";
    public static final String DB_URL = "jdbc:mysql://localhost/"+DB_Name;

    public static final String USER = "root";
    public static final String PASS = "";
    public static final String tbl_url = "url";
    Connection conn = null;
    Statement stmt = null;

    public DaoUrl(){
        create_database();
        create_table_nasabah();
    }

    private void openConnection(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex){
            Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeConnection(){
        try{
            if(conn!=null)conn.close();
        }catch(SQLException ex){
            Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Url save(Url url){
        Url new_url = null;

        
        if(this.findByShortened(url) != null){
            return new_url;
        }
        
        if(this.findByReal(url) != null){
            return this.findByReal(url);
        }
        

        openConnection();
        try{
            if(conn==null){
                System.out.println("conn is null");
                return new_url;
            }

            stmt = conn.createStatement();
            String sql = "INSERT INTO " + tbl_url
                + " (`real`, shortened, password)"
                + "VALUES ("
                + "'" + url.getReal() + "'"
                + ", '" + url.getShortened() + "'"
                + ", '" + url.getPassword() + "'"
                + ")";
            stmt.executeUpdate(sql);
        }catch(SQLException ex){
            Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();

        new_url = this.findByReal(url);
        if(url.getShortened().equals("")){ 
            new_url.shorten();
            this.update(new_url.getId(), new_url);       
        }


        return new_url;

        
    }

    public void update(long id, Url url){
        openConnection();
        try{
            if(conn==null){
                System.out.println("conn is null");
                return;
            }
            stmt = conn.createStatement();
            String sql = "UPDATE " + tbl_url
                + " SET shortened = '" + url.getShortened() + "'"
                +" WHERE id=" + id;

            stmt.executeUpdate(sql);
        }catch (SQLException ex){
            Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
    }

    public void delete(long id){
        openConnection();
        try{
            if(conn==null){
                System.out.println("conn is null");
                return;
            }
            stmt = conn.createStatement();
            String sql = "DELETE FROM " + tbl_url
                + " WHERE id = " + id;
            stmt.executeUpdate(sql);
        } catch (SQLException ex){
            Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
    }

    public Url findByReal(Url url){
        Url new_url = null;
        openConnection();
        try{
            if(conn==null){
                System.out.println("conn is null");
                return null;
            }
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + tbl_url + " WHERE `real`='" + url.getReal()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.first()){
                long nid = rs.getLong("id");
                String real = rs.getString("real");
                String shortened = rs.getString("shortened");
                String password = rs.getString("password");
                new_url = new Url(nid, real, shortened);

                rs.close();
            }
        }catch(SQLException ex){
                Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
        return new_url;
    }

    public Url findByShortened(Url url){
        Url new_url = null;
        openConnection();
        try{
            if(conn==null){
                System.out.println("conn is null");
                return null;
            }
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + tbl_url + " WHERE shortened='" + url.getShortened()+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.first()){
                long nid = rs.getLong("id");
                String real = rs.getString("real");
                String shortened = rs.getString("shortened");
                String password = rs.getString("password");
                if(password.equals(url.getPassword()) || password.equals("")){
                    new_url = new Url(nid, real, shortened);
                }else{
                    new_url = new Url();
                    new_url.setShortened(url.getShortened());
                }

                rs.close();
            }
        }catch(SQLException ex){
                Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
        return new_url;
    }

    public Url findById(long id){
        Url url = null;
        openConnection();
        try{
            if(conn==null){
                System.out.println("conn is null");
                return null;
            }
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + tbl_url + " WHERE id=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.first()){
                long nid = rs.getLong("id");
                String real = rs.getString("real");
                String shortened = rs.getString("shortened");
                String password = rs.getString("password");
                url = new Url(nid, real, shortened);

                rs.close();
            }
        }catch(SQLException ex){
                Logger.getLogger(DaoUrl.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeConnection();
        return url;
    }

    private void create_database(){
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "");
            stmt = conn.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS " + DB_Name;
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch (SQLException se2){

            }
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    private void create_table_nasabah(){
        Connection conn = null;
        Statement stmt = null;

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS " + tbl_url + " "
                + "(id INTEGER NOT NULL AUTO_INCREMENT,"
                + " `real` VARCHAR(255), "
                + " shortened VARCHAR(255), "
                + " password VARCHAR(255), "
                + " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(stmt != null){
                    stmt.close();
                }
            }catch (SQLException se2){

            }
            try{
                if(conn != null){
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }

    }
}
