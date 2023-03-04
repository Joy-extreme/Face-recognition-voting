
package SoftwareMetricsCOde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Authors
 * Joy bhowmik(Ash1925012M) 
 * Nayeem Khan(Ash1925027M)
 * Md Redwan Hossain(Ash1925005M)
 */
public class CodeSizeFindingMetricsMeasurement 
{
    private int fileNumber = 0;
    private int totalNumberOfCharacters = 0, totalLinesOfCode = 0, totalCommentedLinesOfCode = 0, totalImportingLines = 0, totalStatements = 0, totalBlankLines = 0;
    private double totalFileSize = 0;
    
    public  void metricsMeasurement(File folder) throws FileNotFoundException, IOException
    { 
        for (File file : folder.listFiles())
        {
            if(file.isDirectory())
            {
                metricsMeasurement(file);
            }
            else
            {
                String extensionOfFile = file.getName().substring(file.getName().lastIndexOf('.') + 1);
                // Handling the java files only
                if (extensionOfFile.equals("java")) 
                {
                    int numberOfCharacters = 0, LinesOfCode = 0, commentedLinesOfCode = 0, importingLines = 0, statements = 0, blankLines = 0;
                    System.out.println("|-----------------------------Information---------------------------------------|");
                    fileNumber++;
                    System.out.println(" File number: "+fileNumber);
                    System.out.println(" File name: "+file.getName());
                    System.out.println(" Package name: "+folder.getName());
                    System.out.println(" ------------------------------------------------------------------------------ ");
                    System.out.println(" Size of file (kilo bytes): "+(double) file.length()/ 1024);
                    this.totalFileSize += (double) file.length()/ 1024;
                    System.out.println(" ------------------------------------------------------------------------------ ");
                    
                    FileReader filereader = new FileReader(file);
                    int character;
                    StringBuilder line = new StringBuilder();
                    while((character=filereader.read()) != -1)
                    {
                        if(character != 10)
                        {
                            line.append((char)character);
                        }
                        
                        else
                        {
                            if (isCommentedLine(line))
                            {
                                commentedLinesOfCode++;
                            }
                            
                            if(isImportingLine(line))
                            {
                                importingLines++;
                            }
                            
                            if(isStatement(line))
                            {
                                statements++;
                            }
                            
                            if (isBlankLine(line)) {
                                    blankLines++;
                                }    
                            line = new StringBuilder();
                            LinesOfCode++;
                        }
                        numberOfCharacters++;
                    }
                    System.out.println(" number of lines(with blank lines): "+LinesOfCode);
                    totalLinesOfCode += LinesOfCode;
                    System.out.println(" number of commented lines: "+commentedLinesOfCode);
                    totalCommentedLinesOfCode += commentedLinesOfCode; 
                    System.out.println(" number of non commented lines: "+(LinesOfCode - commentedLinesOfCode));
                    System.out.println(" number of blank lines: "+blankLines);
                    totalBlankLines += blankLines;
                    System.out.println(" Comment density: "+(double)commentedLinesOfCode / LinesOfCode);
                    System.out.println(" number of importing lines: "+importingLines);
                    totalImportingLines += importingLines;
                    System.out.println(" numbers of statements: "+statements);
                    totalStatements += statements;
                    System.out.println(" Number of characters: "+numberOfCharacters);
                    totalNumberOfCharacters += numberOfCharacters;
                    System.out.println(" Average number of characters per line: "+(double)(numberOfCharacters/LinesOfCode));
                    System.out.println(" ------------------------------------------------------------------------------ \n");
                    
                    
                }
            }
        }
    }
    
    public  boolean isCommentedLine(StringBuilder line)
    {
        return  (line.toString().contains("/**")|| line.toString().contains("*")|| line.toString().contains("*/")
                || line.toString().contains("//"));
    }
    
    
    public  boolean isImportingLine(StringBuilder line)
    {
        return  (line.toString().contains("import"));
    }
    
    public  boolean isStatement(StringBuilder line)
    {
        return  (line.toString().contains(";")|| line.toString().contains("if") ||
                line.toString().contains("else if")|| line.toString().contains("for") ||
                line.toString().contains("println") || line.toString().contains("print") );
    }
    
    public  boolean isBlankLine(StringBuilder line)
    {
        return  (line.toString().trim().isEmpty());
    }
    
    public int getTotalNumberOfCharacters()
    {
        return totalNumberOfCharacters;
    }
    
    public int getTotalLinesOfCode()
    {
        return totalLinesOfCode;
    }
    
    public int getTotalCommentedLinesOfCode()
    {
        return totalCommentedLinesOfCode;
    }
    
    public int getTotalImportingLines()
    {
        return totalImportingLines;
    }
    
    public int getTotalStatements()
    {
        return totalStatements;
    }
    
    public int getTotalBlankLines()
    {
        return totalBlankLines;
    }
    
    public int getTotalFileNumbers()
    {
        return this.fileNumber;
    }
    
    public double getTotalFileSize()
    {
        return this.totalFileSize;
    }
    
    
    
}
