package weka;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.Random;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;

import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;

/**
 * Trains a model based of a given training set. Cross evaluation in console.
 * Linear regression as classifier.
 * 
 *
 * @author Piotr Dymala p.dymala@gmail.com
 * @version 1.0
 * @since 2021-05-10
 */

public class TrainModel {
	
	public TrainModel() {
		
	}
	
	/**
	 * Trains a model based of a given training set. Linear regression.
	 * 
	 * @param inputTrainingSet Training set. ARFF file
	 * @param outputModel      Output trained model. .Model file type
	 */
	public void TrainModelLR(String inputTrainingSet, String outputModel) {

		try {

			BufferedReader breader = new BufferedReader(new FileReader(inputTrainingSet));
			Instances train = new Instances(breader);
			train.setClassIndex(train.numAttributes() - 1);
			breader.close(); // loading training data

			// Classifier cls = new J48(); //mainy for text/label instances
			Classifier cls = new LinearRegression(); /// dzia³a dobrze, wyznacza linie z punktów i predyktuje now¹. bo
														/// to proste operacje to jest

			cls.buildClassifier(train);

			Evaluation eval = new Evaluation(train);
			eval.crossValidateModel(cls, train, 10, new Random(1));
			System.out.println(eval.toSummaryString("\nResults\n======\n", false));

			// save the ML model for old versions of WEKA
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputModel));
			oos.writeObject(cls);
			oos.flush();
			oos.close();

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("dupa");

		}

	}
	

	/**
	 * Trains a model based of a given training set. Neural Network
	 * 
	 * @param inputTrainingSet Training set. ARFF file
	 * @param outputModel      Output trained model. .Model file type
	 */
	public void TrainModelNN(String inputTrainingSet, String outputModel) {

		try {

			BufferedReader breader = new BufferedReader(new FileReader(inputTrainingSet));
			Instances train = new Instances(breader);
			train.setClassIndex(train.numAttributes() - 1);
			breader.close(); // loading training data

			// Classifier cls = new J48(); //mainy for text/label instances
//			Classifier cls = new LinearRegression(); /// dzia³a dobrze, wyznacza linie z punktów i predyktuje now¹. bo
//														/// to proste operacje to jest
//
//			cls.buildClassifier(train);

			
			MultilayerPerceptron cls = new MultilayerPerceptron();
			//Setting Parameters
			cls.setLearningRate(0.1);
			cls.setMomentum(0.2);
			cls.setTrainingTime(2000);
			cls.setHiddenLayers("1");
			cls.buildClassifier(train);
			
			
			Evaluation eval = new Evaluation(train);
			eval.crossValidateModel(cls, train, 10, new Random(1));
			System.out.println(eval.toSummaryString("\nResults\n======\n", false));

			// save the ML model for old versions of WEKA
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputModel));
			oos.writeObject(cls);
			oos.flush();
			oos.close();

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("dupa");

		}

	}

}
