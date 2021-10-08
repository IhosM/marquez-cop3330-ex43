/*
 *  UCF COP3330 Fall 2021 Assignment 43 Solution
 *  Copyright 2021 Ihosvany Marquez
 */

package Exercise43;

import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;


public class Solution43
{
    public static void main(String[] arg)
    {

        char javascript, css;
        String fileLocations, author, name;

        Scanner scan = new Scanner(System.in);

        System.out.print("Site name: ");
        name = scan.nextLine();

        System.out.print("Author: ");
        author = scan.nextLine();

        System.out.print("Do you want a folder for JavaScript? ");
        javascript = scan.next().charAt(0);
        System.out.print("Do you want a folder for CSS? ");
        css = scan.next().charAt(0);

        fileLocations = System.getProperty("user.dir");
        fileLocations += "\\"+ name;

        File website = new File(fileLocations);
        boolean fileCheck = website.mkdir();

        if(fileCheck)
        {
            System.out.println("Created " + fileLocations);

            try
            {
                FileWriter writer = new FileWriter(fileLocations + "\\index.html");
                writer.write("<\t!DOCTYPE html>\n<html lang=\"en\">\n<head>\n");
                writer.write("\t<meta name=\"" + author + "\">\n");
                writer.write("\t<title>" + website + "</title>\n");
                writer.write("<head>\n</html>");
                writer.close();

                System.out.println("Created " + fileLocations + "\\index.html");
                if(javascript == 'Y' || javascript == 'y')
                {
                    File javascriptFile = new File(fileLocations + "\\js");
                    boolean javascriptFileCheck = javascriptFile.mkdir();

                    if(javascriptFileCheck)
                    {
                        System.out.println("Created " + javascriptFile + "\\");
                    }

                }
                if(css == 'Y' || css == 'y')
                {
                    File cssFile = new File(fileLocations + "\\css");
                    boolean cssFileCheck = cssFile.mkdir();

                    if(cssFileCheck)
                    {
                        System.out.println("Created " + cssFile + "\\");
                    }
                }
            }
            catch (IOException ex)
            {
                System.out.println("no index.html generated.");
            }
        }
        else
            {
            System.out.println("ERROR");
            }
        scan.close();
    }
}