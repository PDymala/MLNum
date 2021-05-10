package weka;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


/**
 * Class to generate a training set for division of two numbers. It generates a 100k random equations of number from 0 up to 10mln.
 * That is saved to a CSV file(Num1, Num2, Result)
 * 
 *
 * @author Piotr Dymala p.dymala@gmail.com
 * @version 1.0
 * @since 2021-05-10
 */
public class DivTrainingSet {

	public DivTrainingSet(String fileName) {
		
		
		int numberOfYesAndNoIterations = 100000;
		int range = 10000000;

		try (PrintWriter writer = new PrintWriter(new File(fileName))) {

			StringBuilder sb = new StringBuilder();

			
			sb.append("Num1");
			sb.append(',');
			sb.append("Num2");
			sb.append(',');
			sb.append("Result");
			sb.append('\n');

			for (int f = 0; f < numberOfYesAndNoIterations; f++) {


					Random newrandom = new Random();
					double one = newrandom.nextInt(range);
					double two = newrandom.nextInt(range);
					sb.append(one);
					sb.append(',');
					sb.append(two);
					sb.append(',');
					sb.append(one/two); /// important!
					sb.append('\n');
			}

			writer.write(sb.toString());
			writer.flush();
			writer.close();

	

		} catch (FileNotFoundException  e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
	}
	
	
	
	
}
