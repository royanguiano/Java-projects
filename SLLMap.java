import java.security.Key;
import java.security.KeyStore.Entry;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * Implements the BasicMap interface using a sorted linked list.
 */
public class SLLMap<K extends Comparable<K>, V> implements BasicMap<K, V> {

	public Entry head;
	// LinkedList<Entry> newlist = new LinkedList<>();
	Entry newLink = new Entry();
	int count;

	public SLLMap() {
		head = null;
		count = 0;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public boolean containsKey(Object key) {

		Entry NL = head;

		while (NL != null) {
			if (newLink.key == key) {
				System.out.println("Found the key: ");
				return true;
			} else {
				NL = NL.next;
			}
		}

		System.out.println("Could not find the key: ");

		return false;
	}

	public V put(K key, V value) {
		// TODO Auto-generated method stub

		Entry NLL = new Entry(key, value);

		NLL.next = head;
		head = NLL;
		count++;

		System.out.println("Just added the value");
		return NLL.value;
	}

	public V get(Object key) {

		Entry nL = head;

		while (nL != null) {
			if (nL.key == key) {
				System.out.println("Got the key and it matched this value: ");
				return nL.value;
			} else {
				nL = nL.next;
			}
		}

		System.out.println("No key found: ");

		return null;
	}

	public V remove(Object key) {

		Entry TL = head;

		while (TL != null) {
			if (TL.key == key) {
				System.out.println("Found the key and removed the value: ");
				TL = TL.next;
				return TL.value;
			}
			TL = TL.next;
		}
		System.out.println("Nothing was found at the key: ");
		return null;
	}

	public Set<K> keySet() {

		Set<K> S = new HashSet<K>();
		Entry focusNode = head;

		while (focusNode != null) {
			S.add(focusNode.key);
			focusNode = focusNode.next;
		}

		return S;

	}

	public class Entry {
		public K key;
		public V value;
		public Entry next;

		public Entry() {

		}

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public Entry(K key, V value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}