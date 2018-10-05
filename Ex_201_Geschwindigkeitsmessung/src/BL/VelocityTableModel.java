/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sabrina
 */
public class VelocityTableModel extends AbstractTableModel
{
    private String names[] = {"Datum", "Uhrzeit", "Kennzeichen", "Gemessen", "Erlaubt", "Übertreten"};
    private LinkedList<Measurement> list = new LinkedList<>();
    
    private static final DateTimeFormatter ldParse = DateTimeFormatter.ofPattern("d.M.yyyy");
    private static final DateTimeFormatter ltParse = DateTimeFormatter.ofPattern("H:m");
    
    
    private static final String filename = System.getProperty("user.dir")
            + File.separator + "src"
            + File.separator + "res"
            + File.separator + "measurementData.ser";
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Measurement m = list.get(rowIndex);
        return m;
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }
    
    public void add(Measurement m)
    {
        list.add(m);
        Collections.sort(list);
        fireTableRowsInserted(list.size()-1, list.size()-1);
    }
    
    
    public void saveToBinaryFile()
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for (Measurement measurement : list) 
            {
                oos.writeObject(measurement);
            }
            oos.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    
    public void loadFromBinaryFile()
    {
        ObjectInputStream ois = null;
        try
        {
            FileInputStream fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            
            try
            {
            while(true)
            {
            Object obj = ois.readObject();
            
            if(obj instanceof Measurement)
            {
                Measurement measurement = (Measurement)obj;
                list.add(measurement);
            }
            }
            }
            catch(IOException e)
            {
                System.out.println("binary read succes");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        finally
        {
            try
            {
                ois.close();
                
            }
            catch(IOException e)
            {
                System.out.println(e.toString());
            }
        }
    }
    
}
