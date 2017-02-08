package com.estella.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.StringBuilder;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * @author      Estella
 * @version     0.0.1
 * @since       2015-10-14
 */
public class AddressBook {
  private List<Contact> contactList;

  /**
   * Constructs an empty address book.
   */
  public AddressBook() {
  	contactList = new ArrayList<Contact>();
  }

  /**
   * Appends the specific contact to the end of this address book.
   *
   * @param  c - contact to be appended to this address book
   * @return true if this address book appended the object to its end.
   */
  public boolean add(Contact c) {
  	return contactList.add(c);
  }

  /**
   * Inserts the specific contact at the specified position in this address book.
   *
   * @param index - index at which the specified contact is to be inserted,
   *                Please note, the K-th contact's index is (K-1).
   *        c - contact to be inserted
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
   */
  public void add(int index, Contact c) {
    contactList.add(index, c);
  }

  /**
   * Removes all of the contacts from this address book.
   * The address book will be empty after this call returns.
   */
  public void clear() {
    contactList.clear();
  }

  /**
	 * Removes the first occurrence of the specified contact from this address book,
	 * if it's present.
	 *
	 * If the address book does not contain the contact, it is unchanged.
	 * Returns true if this address book contained the specified contact (or equivalently, if this
	 * address book changed as a result of the call).
	 *
	 * @param  c - contact to be removed from this address book, if present
	 * @return true if this address book contained the specified contact
	 */
  public boolean remove(Contact c) {
    return contactList.remove(c);
  }

  /**
   * Removes the contact at the specified position in this address book. Shifts any subsequent
   * contacts to the left (subtracts one from their indices).
   *
   * @param  index - the index of the contact to be removed.
   *                 Please note, the K-th contact's index is (K-1).
   * @return the contact that was removed from the address book
   * @throws IndexOutOfBoundsException - if the index is out of range (index < 0 || index > size())
   */
  public Contact remove(int index) {
    return contactList.remove(index);
  }

  /**
   * Ignoring case, returns true if and only if String val contains the specified String keyword.
   *
   * It's case-insensitive to check whether String val contains String keyword.
   * e.g. containsIgnoreCase("Turing", "UR") will return true;
   * containsIgnoreCase("Turing", "rg") will return false.
   *
   * @param  val - the String that may contain;
   *         keyword - the String that may be contained.
   * @return Case-insensitively, returns true if and only if String val contains the specified
   *              String keyword.
   */
  /*
   * TODO AddressBook#containsIgnoreCase is an AddressBook-independent method,
   * so it’d make more sense in some library. Also, this method isn’t really necessary.
   * You could just use String#contains and String#toLowerCase which would work the same
   * but be more readable.
   */
  private boolean containsIgnoreCase(String val, String keyword) {
    return Pattern.compile(Pattern.quote(keyword), Pattern.CASE_INSENSITIVE).matcher(val).find();
  }

  /**
   * Case-insensitively, searches for the contact(s) that has or contains the specified keyword in
   * any of its property.
   *
   * When searching for contacts that has this keyword, it's CASE-INSENSITIVE. e.g. If a contact
   * has a address street property "Washington Blvd", and the keyword is "wash", then this contact
   * will be returned as one of the search results.
   *
   * @param  keyword - the specified keyword for searching.
   * @return a list of the contact(s) that has or contains, case-insensitively, the specified
   * keyword in any of its property.
   */
  /*
   * TODO Consider how much code you’d have to change if a field were added to a Contact
   * (how many lines would you need to change just in AddressBook#search?
   * How many in parseContact?).
   */
  public ArrayList<Contact> search(String keyword) {
    ArrayList<Contact> result = new ArrayList<>();
    String name;
    String street;
    String city;
    String state;
    String zip;
    String phone;
    String email;
    String note;
    for(Contact c : contactList) {
      name = c.getName();
      street = c.getAddressStreet();
      city = c.getAddressCity();
      state = c.getAddressState();
      zip = c.getAddressZIP();
      phone = c.getPhoneNumber();
      email = c.getEmail();
      note = c.getNote();

      if (containsIgnoreCase(name, keyword)
          || containsIgnoreCase(street, keyword)
          || containsIgnoreCase(city, keyword)
          || containsIgnoreCase(state, keyword)
          || containsIgnoreCase(zip, keyword)
          || containsIgnoreCase(phone, keyword)
          || containsIgnoreCase(email, keyword)
          || containsIgnoreCase(note, keyword)) {
        result.add(c);
      }
    }
    return result;
  }

  /**
   * Save this address book as a plain-text file to the specified path.
   *
   * @param  path - the specified URI to save this address book.
   * @throws FileNotFoundException - If the given path (URI) does not denote an existing,
   *         writable regular file and a new regular file of that name in the path
   *         cannot be created, or if some other error occurs while opening or
   *         creating the file.
   */
  /*
   * TODO
   * 1.You might have considered trimming input before setting Contact fields.
   * In your implementation, a Contact with name “Mike” won’t be considered equal
   * to Contact with name “Mike “. Not sure if that’s intentional.
   * 2. Initializing entry to the empty string in AddressBook#saveAsFile is redundant.
   * 3. StringBuilder would be better in saveAsFile.
   */
  public void saveAsFile(String path) throws FileNotFoundException {
  	PrintWriter writer = new PrintWriter(path);
  	String entry = "";
  	for(Contact c : contactList) {
  		entry = c.getName() + ",,,"
					+ c.getAddressStreet() + ",,,"
					+ c.getAddressCity() + ",,,"
					+ c.getAddressState() + ",,,"
					+ c.getAddressZIP() + ",,,"
					+ c.getPhoneNumber() + ",,,"
					+ c.getEmail() + ",,,"
					+ c.getNote() + ",,,";

  		writer.println(entry);
  	}
  	writer.close();
  }

  /**
   * Parses a contact entry in a single line.
   *
   * Every contact entry is supposed to stay within a single line, and we use the
   * delimiter - three consecutive commas - to split the properties(e.g. name, email).
   *
   * @param  line - one single String line represents a contact entry
   * @return a parsed Contact instance
   * @throws ArrayIndexOutOfBoundsException - the split array - tokens - has been accessed
   *         with an illegal index. The index is either negative or greater than or equal
   *         to the size of the array.
   */
  private Contact parseContact(String line) throws ArrayIndexOutOfBoundsException {
  	String name;
  	String street;
  	String city;
  	String state;
  	String zip;
  	String phone;
  	String email;
  	String note;

  	String delimiter =  ",,,";
  	String[] tokens = line.split(delimiter);
		name = tokens[0];
		street = tokens[1];
		city = tokens[2];
		state = tokens[3];
		zip = tokens[4];
		phone = tokens[5];
		email = tokens[6];
		note = tokens[7];

		return new Contact.Builder(name)
				.addressStreet(street)
				.addressCity(city)
				.addressState(state)
				.addressZIP(zip)
				.phoneNumber(phone)
				.email(email)
				.note(note)
				.build();
  }

  /**
   * Read the address book in a plain-text file. It clears all Contacts from this AddressBook
   * and populates it an new with the Contacts created from the file.
   *
   * @param  path - the specified URI to read this address book.
   * @throws IllegalArgumentException - if preconditions on the path
   *         parameter do not hold. The format of the URI is provider specific.
             FileSystemNotFoundException - The file system, identified by the URI,
             does not exist and cannot be created automatically, or the provider
             identified by the URI's scheme component is not installed
             SecurityException - if a security manager is installed and it denies
             an unspecified permission to access the file system
             NoSuchElementException - if no line was found
             IllegalStateException - if this scanner is closed
   */
  public void readFromFile(String path) throws Exception {
  	Scanner scanner = new Scanner(Paths.get(path));
  	String line = "";
  	Contact contact;
  	contactList.clear();
  	while(scanner.hasNextLine()) {
  	  line = scanner.nextLine();
  		if(line.trim().length() != 0) {
  		  contact = parseContact(line);
				contactList.add(contact);
  		}
  	}
  	scanner.close();
  }

  /**
   * Returns a string representation of the address book.
   *
   * @return a string representation of the address book.
   */
  @Override public String toString() {
  	StringBuilder sb = new StringBuilder();
  	String gapLine = "--------------------------------\n";
  	for(Contact contact : contactList) {
  		sb.append(contact.toString());
  		sb.append(gapLine);
  	}
  	return sb.toString();
  }
}
