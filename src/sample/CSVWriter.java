package sample;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CSVWriter
{
    public static void main(String[] args)
    {
        String out = "CSV Demo";
        String filepath = "src/sample/csvfile.txt";

        submitRecord(out, filepath);
    }

    public static void submitRecord(String out, String filepath)
    {
        try
        {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(fw);

            pw.println(out);
            pw.flush();
            pw.close();
        }
        catch (Exception E)
        {
            return;
        }
    }
}
