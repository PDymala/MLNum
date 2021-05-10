package weka;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class CsvToArff {

	public CsvToArff(String fileName) throws IOException {
		
	//Changing CSV into ARFF type of file needed for WEKA machine learning.
		
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File(fileName + ".csv"));
		Instances data = loader.getDataSet();
		
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File(fileName+".arff"));
		saver.writeBatch();
		


}}
