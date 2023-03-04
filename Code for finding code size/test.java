
package SoftwareMetricsCOde;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class test 
{
    public static void main(String[] args) throws IOException
    {
        CodeSizeFindingMetricsMeasurement obj = new CodeSizeFindingMetricsMeasurement();
        Scanner scanText = new Scanner(System.in);
        // Taking directory names as input
        System.out.print("Enter your directory : ");
        
        String directoryPath = scanText.nextLine();

        //file object using input path
        File newFile = new File(directoryPath);
        obj.metricsMeasurement(newFile);
        
        System.out.println("|-----------------------------Summary---------------------------------------------|");
        System.out.println(" Total File number: "+obj.getTotalFileNumbers());
        System.out.println(" Total File size(in kilo bytes): "+obj.getTotalFileSize());
        System.out.println(" ------------------------------------------------------------------------------ ");
        System.out.println(" Total number of lines(with blank lines): "+obj.getTotalLinesOfCode());
        System.out.println(" Total number of commented lines: "+obj.getTotalCommentedLinesOfCode());
        System.out.println(" Total number of non commented lines: "+(obj.getTotalLinesOfCode() - obj.getTotalCommentedLinesOfCode()));
        System.out.println(" Total number of blank lines: "+obj.getTotalBlankLines());
        System.out.println(" Total number of importing lines: "+obj.getTotalImportingLines());
        System.out.println(" Total numbers of statements: "+obj.getTotalStatements());
        System.out.println(" Total Number of characters: "+obj.getTotalNumberOfCharacters());
        System.out.println(" Number of characters per line: "+(obj.getTotalNumberOfCharacters()) / obj.getTotalLinesOfCode());
        System.out.println(" ------------------------------------------------------------------------------ ");
        
    }
   
}
