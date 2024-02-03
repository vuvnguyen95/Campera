package src;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    
    public void writeToFile(String filename, String contents)
    {
        try
        {
            FileWriter fileWriter = new FileWriter(filename + ".txt");
            fileWriter.write(contents);
            fileWriter.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
