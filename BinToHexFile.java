import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BinToHexFile
   {

	public static void main(final String[] args) throws IOException
	{
		String[] bits;

		if (args.length != 2)
		{
			System.out.println("Invalid number of inputs. Please provide valid fileName and line number."); // Checking
			System.exit(0);
		}
		final String inputFile = args[0];
		if (inputFile == null || inputFile.isEmpty()) 
		{
			System.out.println("File name cannot be null/empty. Please provide valid file name."); // Checking
			System.exit(0);
		}
		BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));

		try (BufferedReader br = new BufferedReader(new FileReader(inputFile)))
		{
			String line;
			
			int digitNumber = 1;
			 int sum = 0;
			while ((line = br.readLine()) != null)
			{
				// process the line.
				
				for(int i = 0; i < line.length(); i++)
				{
				     if(digitNumber == 1)
				         sum+=Integer.parseInt(line.charAt(i) + "")*8;
				     else if(digitNumber == 2)
				         sum+=Integer.parseInt(line.charAt(i) + "")*4;
				     else if(digitNumber == 3)
				         sum+=Integer.parseInt(line.charAt(i) + "")*2;
				     else if(digitNumber == 4 || i < line.length()+1)
				     {
				         sum+=Integer.parseInt(line.charAt(i) + "")*1;
				         digitNumber = 0;
				         if(sum < 10)
				             System.out.print(sum);
				         else if(sum == 10)
				             System.out.print("A");
				         else if(sum == 11)
				             System.out.print("B");
				         else if(sum == 12)
				             System.out.print("C");
				         else if(sum == 13)
				             System.out.print("D");
				         else if(sum == 14)
				             System.out.print("E");
				         else if(sum == 15)
				             System.out.print("F");
				         sum=0;
				     }
				     digitNumber++;  
				}
System.out.println("\n");
			}
		}

		 catch (final FileNotFoundException e)
		{
			System.out.println("Unable to find the file: \"" + inputFile + "\". Please provide valid file.");
			System.exit(0);
		}
		catch (final IOException e)
		{
			System.out.println("Unable to write to the file: \"" + inputFile + "\". Please provide valid file.");
			System.exit(0);
		} 
		finally
		{
			bw.close();
		}
	}
   }
