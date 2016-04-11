import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

public class IteratorPractice {

	public static void main(String[] args) {

	}

	public void printStrings(ArrayList<String> str, String oldStr) {
		for (int i = 0; i < str.size(); i++) {
			if (str.contains(oldStr)) {
				String table = str.get(i);
				System.out.println(table);
			}
		}
	}

	public void printStrins2(String str2, ArrayList<String> interator2) {

		Iterator<String> iterator = interator2.iterator();
		for (int i = 0; i < interator2.size(); i++) {
			if (interator2.contains(str2)) {
				System.out.println(interator2.get(i));
			}
		}
	}

	public static void removeRepetition(ArrayList<String> str) {
		Iterator<String> iter = str.iterator();
		int i = 0;
		while (iter.hasNext()) {
			i++;
			if (iter.next().equals(str.get(i))) {
				iter.remove();
			}
		}

	}

}
