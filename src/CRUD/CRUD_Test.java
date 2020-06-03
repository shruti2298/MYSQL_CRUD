package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD_Test {

                public static void main(String[] args)
                {
                        CRUD_Test objTest=new CRUD_Test();
                       objTest.create_data("1", "shruti patolia" , "shruti220398@gmail.com");
                      objTest.create_data("2","manu jain", "manu.jain@yahoo.com");
                        objTest.create_data("3","tony pare","tony@gmail.com");
                       objTest.read_data("1");



                }

        public void create_data(String sl_no,String name, String email) {
                DB_Connection obj_DB_Connection = new DB_Connection();
                Connection connection = obj_DB_Connection.get_connection();
                PreparedStatement ps=null;
                try {
                        String query = "insert into user(sl_no,name,email) values(?,?,?)";
                        ps=connection.prepareStatement(query);
                        ps.setString(1,sl_no);
                        ps.setString(2,name);
                        ps.setString(3,email);
                     //   System.out.println(ps);
                        ps.executeUpdate();
                } catch (Exception e) {
                        System.out.println("Not created");
                }

        }
        public void read_data(String sl_no)
        {
                DB_Connection obj_DB_Connection= new DB_Connection();
                Connection connection=obj_DB_Connection.get_connection();
                PreparedStatement ps=null;
                ResultSet rs=null;
                try
                {
                        String query ="select * from user";
                        ps=connection.prepareStatement(query);
                      //  System.out.println(ps);
                        rs=ps.executeQuery();
                        while(rs.next())
                        {
                                System.out.println("Sl_No.-"+rs.getString("sl_no"));
                                System.out.println("Name-"+rs.getString("name"));
                                System.out.println("Email-"+rs.getString("email"));
                                System.out.println("----------------");
                        }
                }
                catch (Exception e)
                {
                        System.out.println("Not read");
                }
                
        }

        public void update_data(String sl_no,String new_sl_no,String name, String email)
        {
                DB_Connection obj_DB_Connection= new DB_Connection();
                Connection connection=obj_DB_Connection.get_connection();
                PreparedStatement ps=null;
               // ResultSet rs=null;
                try
                {
                        String query ="update user set sl_no=?,name=?,email=? where sl_no=?";
                        ps=connection.prepareStatement(query);
                        System.out.println(ps);
                       // rs=ps.executeQuery();
                        ps.setString(1,new_sl_no);
                        ps.setString(2,name);
                        ps.setString(3,email);
                        ps.setString(4,sl_no);
                        System.out.println(ps);
                        ps.executeUpdate();


                }
                catch (Exception e)
                {
                        System.out.println("Not updated");
                }

        }
        public void delete_data(String sl_no)
        {
                DB_Connection obj_DB_Connection= new DB_Connection();
                Connection connection=obj_DB_Connection.get_connection();
                PreparedStatement ps=null;
                // ResultSet rs=null;
                try
                {
                        String query ="delete from user where sl_no=?";
                        ps=connection.prepareStatement(query);
                        System.out.println(ps);
                        // rs=ps.executeQuery();
                        ps.setString(1,sl_no);
                    //    ps.setString(2,name);
                      //  ps.setString(3,email);
                        //ps.setString(4,sl_no);
                        System.out.println(ps);
                        ps.executeUpdate();


                }
                catch (Exception e)
                {
                        System.out.println("Not deleted");
                }

        }



}
