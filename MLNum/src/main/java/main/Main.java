package main;

import weka.AddTrainingSet;
import weka.CsvToArff;
import weka.DivTrainingSet;
import weka.MulTrainingSet;
import weka.SubTrainingSet;
import weka.TrainModel;
/**
 * Having fun with machine learning. Application for doing simple math but with use of machine learning instead of algebra.
 * Does not make any sense but why not.
 * 
 *
 * @author Piotr Dymala p.dymala@gmail.com
 * @version 1.0
 * @since 2021-05-10
 */
public class Main {

	public static void main(String[] args) throws Exception {


		// ------ PREPARATION -----
		
		//create trainingset
		AddTrainingSet ats = new AddTrainingSet("addtrainingset.csv");
		SubTrainingSet sts = new SubTrainingSet("subtrainingset.csv");
		DivTrainingSet dts = new DivTrainingSet("divtrainingset.csv");
		MulTrainingSet mts = new MulTrainingSet("multrainingset.csv");
		
		//change CSV to ARFF
		CsvToArff ca1 = new CsvToArff("addtrainingset");
		CsvToArff ca2 = new CsvToArff("subtrainingset");
		CsvToArff ca3 = new CsvToArff("divtrainingset");
		CsvToArff ca4 = new CsvToArff("multrainingset");
		
		//train and save model
		TrainModel tm1 = new TrainModel();
//		tm1.TrainModelNN("addtrainingset.arff", "addtrainingset.model");
		tm1.TrainModelLR("addtrainingset.arff", "addtrainingset.model");
		
		TrainModel tm2 = new TrainModel();
//		tm2.TrainModelNN("subtrainingset.arff", "subtrainingset.model");
		tm2.TrainModelLR("subtrainingset.arff", "subtrainingset.model");
//		
		TrainModel tm3 = new TrainModel();
		tm3.TrainModelNN("divtrainingset.arff", "divtrainingset.model");
////		tm3.TrainModelLR("divtrainingset.arff", "divtrainingset.model");
//		
		TrainModel tm4 = new TrainModel();
		tm4.TrainModelNN("multrainingset.arff", "multrainingset.model");
////		tm4.TrainModelLR("multrainingset.arff", "multrainingset.model");
		
		// yes i know, that those classes above should be organized in the same way but it was just an experiment
// 		Above methods shows in console cross validation, 10 fold. Result for LR is around those:
//			Adding = 100%;
//			Substracting = 100%;
//			Division = 4,99%
//			Multiplication = 92,59%
//		Therefore, do not use division! it needs a different model. Multiplication also but it's better.
		
//		Result for Neural Network
		
		
		
		
		
		
		
		
		

		// ------ USAGE -----

		//Remember to hard code names of ml models in MLNum class.
		
		//calculate 
		MLNum num = new MLNum();
		System.out.println(num.getValue());
		num.add(147.0);
		
		System.out.println(num.getValue());
		
		num.sub(100.0);
		num.sub(47.0);
		
		System.out.println(num.getValue());
		
		num.mul(1.0);
		
		System.out.println(num.getValue());
		
		num.div(10.0);
		
		
		System.out.println(num.getValue());
		
	}

}
