package fr.djstechnologies.dal;

import fr.djstechnologies.business.User;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

public class DataBaseManager {
    private Connection conn = null;
    public DataBaseManager() {
        try
        {
            //étape 1: charger la classe de driver
            Class.forName("com.mysql.jdbc.Driver");
            //étape 2: créer l'objet de connexion

            this.conn = DriverManager.getConnection(BdParam.URL, BdParam.USER, BdParam.PASSWORD);

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public ResultSet executeSelect(String sql){
        ResultSet res = null;
        try{
            Statement stmt = conn.createStatement();
            res = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    private PreparedStatement addParametersToPreparedStatement(PreparedStatement preparedStatement, CoupleValue[] params){
        try{
            CoupleValue currentCouple;
            for (int i = 0 ; i < params.length ; i++){
                currentCouple = params[i];
                if (currentCouple.getType().equals("String")){
                    preparedStatement.setString(i+1,currentCouple.getValue().toString());
                }
                if (currentCouple.getType().equals("Int")){
                    preparedStatement.setInt(i+1,Integer.parseInt(currentCouple.getValue().toString()));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return preparedStatement;
    }

    public ResultSet executePreparedSelect(String sql, CoupleValue[] params){
        ResultSet res = null;
        try{
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement = this.addParametersToPreparedStatement(preparedStatement, params);
            res = preparedStatement.executeQuery();
        }catch(Exception e){
            System.out.println(e);
        }
        return res;
    }

    public int executePreparedQuery(String sql, CoupleValue[] params){
        int nbMaj = 0;
        try{
            PreparedStatement preparedStatement = this.conn.prepareStatement(sql);
            preparedStatement = this.addParametersToPreparedStatement(preparedStatement, params);
            nbMaj = preparedStatement.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
        return nbMaj;
    }

    public void closeConn(){
        try{
            this.conn.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
