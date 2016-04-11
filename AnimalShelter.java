import java.util.*;
import java.io.*;

public class AnimalShelter {

	public static void main(String[] args) throws IOException {

	}

	public static Map<String, Set<String>> readShelterData(String filename)
			throws IOException {
		// COMPLETE CODE HERE
		Map<String, String> map = new TreeMap<String, String>();
		Set<String> sets = new HashSet<>();
		Scanner infile = new Scanner(new File(filename));
		// Read one line of the file at at time
		while (infile.hasNextLine()) {
			// COMPLETE CODE HERE
			// Read one token at a time
			String data = infile.nextLine();
			// Integer count = map.get(data);
			Scanner inLine = new Scanner(data);
			inLine.useDelimiter(";");
			String breed = inLine.next();
			// Integer count = map.get(breed);
			while (inLine.hasNext()) {
				String dogName = inLine.next();

				// COMPLETE CODE HERE
				map.put(breed, dogName);
				sets.add(dogName);
			}
			// COMPLETE CODE HERE
		}
		return null; // UPDATE CODE HERE
	}

	public static void printShelterData(Map<String, Set<String>> map) {

		// COMPLETE CODE HERE
		System.out.println("Here are the animals left at the shelter: ");
		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {

			System.out.println("Breed: " + entry.getKey() + "Name: "+ entry.getValue());
		}
	}

	public static void readAdoptions(Map<String, Set<String>> breedToNames,String fileName) throws IOException {

		Scanner infile = new Scanner(new File(fileName));
		infile.useDelimiter("[;\n]");

		while (infile.hasNextLine()) {
			String person = infile.next();
			String breed = infile.next();
			infile.nextLine();

			// COMPLETE CODE HERE
			// check for the if the breed exist and there are dogs availible
			if (breedToNames.containsKey(breed) || !breedToNames.isEmpty()) {
				// Iterator<String> it = breedToNames.
				// iterate through the keys in treemap and grab the breed
				// iterate through the set and grab the next name
				// after set.remove(new String(firstNameofDogBreed)

			}
			// the map contains the breed but no dogs are availible
			else if (breedToNames.containsKey(breed) || breedToNames.isEmpty()) {
				System.out.println(person+ " cannot adopt because there are no dogs availible with that breed.");
			}

			else {
				System.out.println(person+ " cannot adopt because there are no dogs of that breed.");
			}
		}
	}
}
