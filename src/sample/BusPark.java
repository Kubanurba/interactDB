package sample;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

/**
 * класс контейнера для хранения и обработки информации о водителях автобусов
 * @author nastyabaturkina
 *
 */
public class BusPark
{
    public ArrayList<BusDrivers> list = new ArrayList<BusDrivers>();
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    /**
     * функция для чтения данных из файла
     * @param fileName название файла для чтения
     * @throws MyException собственное исключение
     */
    public void Reader(String fileName) throws MyException, ClassNotFoundException, SQLException  {
        try {
            conn = null;
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + fileName);
            resSet = conn
                    .createStatement()
                    .executeQuery("SELECT * FROM busDrivers");
            while(resSet.next()) {
                list.add(new BusDrivers(resSet.getInt(1) , resSet.getString(2) , resSet.getString(3 ) ,
                        resSet.getString(4), resSet.getString(5) ,
                        resSet.getInt(6) , resSet.getInt(7)));

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * функция для записи данных в json файл
     * @param fileName название файла для записи
     * @throws MyException собственное исключение
     */
    public void JSONwriter(String fileName) throws MyException
    {

        try(FileWriter writer = new FileWriter(fileName))
        {
            String text = "[\n";
            for(int i = 0; i < list.size(); i++)
            {
                text = text + " {\n" + (list.get(i).toJson()) + "\n }";
                if(i != (list.size() - 1) )
                    text = text + ",";
                text = text + "\n";
            }
            text += "]";

            writer.write(text);
            writer.flush();
        }
        catch(IOException exc)
        {
            throw new MyException(exc.getLocalizedMessage());
        }
    }
}