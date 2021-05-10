# MLNum
Using machine learning (WEKA) for simple algebra. Cause why not.



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
		TrainModel tm1 = new TrainModel("addtrainingset.arff", "addtrainingset.model");
		TrainModel tm2 = new TrainModel("subtrainingset.arff", "subtrainingset.model");
		TrainModel tm3 = new TrainModel("divtrainingset.arff", "divtrainingset.model");
		TrainModel tm4 = new TrainModel("multrainingset.arff", "multrainingset.model");
		
		
// yes i know, that those classes above should be organized in the same way but it was just an experiment
// 		Above methods shows in console cross validation, 10 fold. Result is around those:
//			Adding = 100%;
//			Substracting = 100%;
//			Division = 4,99%
//			Multiplication = 92,59%
//		Therefore, do not use division! it needs a different model. Multiplication also but it's better.
		

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
