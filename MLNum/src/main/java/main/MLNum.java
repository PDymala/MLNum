package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.FastVector;
import weka.core.Instances;

/**
 * Instance of a number that uses machine learning for algebra
 * 
 *
 * @author Piotr Dymala p.dymala@gmail.com
 * @version 1.0
 * @since 2021-05-10
 */
public class MLNum {

	private double value = 0.0;
	public static String addModel = "addtrainingset.model";
	public static String subModel = "subtrainingset.model";
	public static String mulModel = "multrainingset.model";
	public static String divModel = "divtrainingset.model";

	/**
	 * Trains a model based of a given training set. Cross evaluation in console.
	 * Linear regression as classifier.
	 * 
	 * @return double get current value of your numer
	 */
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Creates a ML number with a certain initial value
	 * 
	 * @param initialvalue initial value as double
	 */
	public MLNum(double initialvalue) {

		initialvalue = value;
	}

	/**
	 * Creates a ml number with 0.0 as initial value
	 */
	public MLNum() {

	}
	/**
	 * Add a number to current value of ML num
	 * 
	 */
	public void add(double addValue) throws Exception {

		double newValue = predict(loadmodel(addModel), value, addValue);

		value = newValue;

	}
	/**
	 * Sub a number to current value of ML num
	 * 
	 */
	public void sub(double subValue) throws Exception {

		double newValue = predict(loadmodel(subModel), value, subValue);

		value = newValue;

	}
	/**
	 * Multiply your current number by a given one
	 * 
	 */
	public void mul(double mulValue) throws Exception {

		double newValue = predict(loadmodel(mulModel), value, mulValue);

		value = newValue;

	}
	/**
	 * Divide your current ml number by a given one
	 * 
	 */
	public void div(double divValue) throws Exception {

		double newValue = predict(loadmodel(divModel), value, divValue);

		value = newValue;

	}

	protected double predict(Classifier cls, double value1, double value2) throws Exception {

		// this method is deprecated, should use a newer one
		FastVector attss = new FastVector();
		attss.add(new Attribute("Add1"));
		attss.add(new Attribute("Add2"));
		attss.add(new Attribute("Result")); // not sure if this is needed. Just for having same number of values in
											// table

		Instances datatest = new Instances("ValueToBePredicted", attss, 0);

		double[] instanceValue1 = new double[datatest.numAttributes()];

		// tested value

		double[] value = { value1, value2, 0.0 }; // not sure if last value is needed- it's to be predicted. Just for
													// having same number of values in table

		for (int u = 0; u < value.length; u++) {
			double temp = value[u];
			instanceValue1[u] = temp;

		}

		datatest.add(new DenseInstance(1.0, instanceValue1));

		// without this, it shows exception
		// https://stackoverflow.com/questions/40318420/weka-core-unassignedclassexception-class-index-is-negative-not-set
		if (datatest.classIndex() == -1) {
			datatest.setClassIndex(datatest.numAttributes() - 1);
		}

		// PREDICTING !!!!
		double prediction = cls.classifyInstance(datatest.firstInstance());

		return prediction;
	}

	protected Classifier loadmodel(String trainingSet) {

		ObjectInputStream ois;

		try {
			ois = new ObjectInputStream(new FileInputStream(trainingSet));
			Classifier cls = (Classifier) ois.readObject();
			ois.close();
			return cls;
		} catch (IOException | ClassNotFoundException e) {

			e.printStackTrace();
			return null;
		}

	}

}
