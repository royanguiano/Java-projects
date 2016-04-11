package problemSet3;

import java.io.StringReader;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class Link {
	public String personName;
	public String personRel;
	int count;

	public Link next;

	// constructor
	public Link(String personName, String personRel, int count) {
		this.personName = personName;
		this.personRel = personRel;
		this.count = count;
	}

	//for printing the total list of people to visit, and 
	// displaying information about linklist
	public void display() {	
		
		System.out.print("name: "+personName +" \nRelationship: "+ personRel +" \ncount: "+ count);
	}

	public String toString() {
		return personName;
	}

	public static void main(String[] args) {
		//for starting such a list, 
		LinkList theLinkList = new LinkList();
		theLinkList.insertHead("roy1", "brother", 1);
		theLinkList.insertHead("roy2", "big brother", 1);
		theLinkList.insertHead("person3", "sister", 1);
		
		
		//displaying link list
		theLinkList.display();
		System.out.println("Removing one link below");
		theLinkList.removeLink("person5");
		theLinkList.display();
	}
}

class LinkList {
	public Link head;

	public LinkList() {
		// TODO Auto-generated constructor stub
		head = null;
	}

	//making the head of the list null (removing it)
	public boolean isEmpty() {
		return (head == null);
	}

	//for inserting a new person to the list, 
	public void insertHead(String personName, String personRel, int count) {

		// creating new object for the list
		//
		Link newLink = new Link(personName, personRel, count);
		
		newLink.next = head;
		head = newLink;
	}

	//remove head of the list 
	public Link remove() {
		Link linkreference = head;

		if (!isEmpty()) {
			head = head.next;
		} else {
			System.out.println("emptry link list");
		}
		return linkreference;
	}

	// cycling through the linklist
	public void display() {
		// start on the head of the list
		Link theLink = head;

		// get the reference stored in next for every link until next returns
		// null
		while (theLink != null) {
			theLink.display();
			System.out.println("\nNext Link: " + theLink.next);
			theLink = theLink.next;
			System.out.println();
		}
	}

	// for searching whether a given person is on your list, 
	// finding a link in the link list
	public Link find(String name) {
		// check the data for the head reference stored in the list
		Link theLink = head;

		// check if head is not empty
		if (!isEmpty()) {
			while (theLink.personName != name) {
				// if no match continue searching every reference stored in next
				// until next return null
				// if return null we are at the end of the list
				if (theLink.next == null) {
					return null;
				} else {
					// if we find a matching link
					theLink = theLink.next;
				}
			}
		} else {
			System.out.println("Empty link list ");
		}
		return theLink;
	}

	// for deleting a person from the list,
	// remove a specific link from the list
	public Link removeLink(String name) {

		Link currentLink = head;
		Link previousLink = head;
		// 1. cycle through all the list until there is a match
		while (currentLink.personName != name) {
			if (currentLink.next == null) {
				return null;
			} else {
				// 2. store next in head as head
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}

		// 3. if there is a match elsewhere, find the link thats next equals the
		// reference to remove
		if (currentLink == head) {
			// 4. get the reference name next in the link to remove and assign
			// it to the link abovew
			head = head.next;
		} else {
			previousLink.next = currentLink.next;
		}

		return currentLink;
	}

}
