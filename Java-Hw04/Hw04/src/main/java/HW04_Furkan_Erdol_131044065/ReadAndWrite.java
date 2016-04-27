package HW04_Furkan_Erdol_131044065;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads input infix expressions from input file and writes assembly code to output file 
 * @author Furkan
 */
public class ReadAndWrite {

    /**
     * Reads input infix expressions from input file
     * @param fileName input file name
     * @return infix expression list
     */
    public static ArrayList<String> readInfixExpressionFromFile(String fileName) {

        ArrayList<String> readFile = new ArrayList<>();

        try {

            FileReader newFileReader = new FileReader(fileName);
            BufferedReader newBufferedReader = new BufferedReader(newFileReader);

            String tempString;

            while ((tempString = newBufferedReader.readLine()) != null) {
                readFile.add(tempString);
            }

            newBufferedReader.close();
        } catch (IOException a) {
            System.err.println("File not found!");
        }

        return readFile;
    }

    /**
     * Writes assembly code to output file 
     * @param fileName output file name
     * @param assemblyStringList assembly code
     */
    public static void writeAssemblyCodeToFile(String fileName, ArrayList<String> assemblyStringList) {

        try {

            File assemblyFile = new File(fileName);
            if (!assemblyFile.exists()) {
                assemblyFile.createNewFile();
            }

            FileWriter newFileWriter = new FileWriter(fileName);
            BufferedWriter newBufferedWriter = new BufferedWriter(newFileWriter);

            for (int i = 0; i < assemblyStringList.size(); ++i) {
                newBufferedWriter.write(assemblyStringList.get(i));
                newBufferedWriter.newLine();
            }

            newBufferedWriter.close();

        } catch (IOException exception) {
            System.err.println("File couldn't be created!");
        }
    }
}
