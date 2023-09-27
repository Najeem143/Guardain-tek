package tek.bdd.guardians.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	private static ReadYamlFiles readYamlFiles;

	private HashMap propertyMap;

	// Constructor: we create to load our yml file

	private ReadYamlFiles(String filepath) throws

	FileNotFoundException {

		FileInputStream fileInputStream = FileUtility.getFileInputStream(filepath);

		Yaml yaml = new Yaml();

		this.propertyMap = yaml.load(fileInputStream);

	}

	// This method will return an instance of the Read yaml File class

	public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {

		if (readYamlFiles == null)

			return new ReadYamlFiles(filePath);

		return readYamlFiles;

	}

	// We get the property from the yml file and store it in hash-map so that we call
	// this method

	// (getYamlProperty) we can pass the key and the method returns the value for us

	public HashMap getYamlProperty(String key) {

		return (HashMap) this.propertyMap.get(key);

	}

}