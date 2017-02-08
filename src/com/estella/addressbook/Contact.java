package com.estella.addressbook;
/*TODO
1. If the name is in fact required, you shouldn’t allow for an invalid name.
You need to notify the user that they’ve done something illegal through an Exception.
2. The constraints you specify in the comments (no new lines, no three consecutive commas)
 could have been enforced in the code.
3. You might have considered trimming input before setting Contact fields.
 In your implementation, a Contact with name “Mike” won’t be considered equal
 to Contact with name “Mike “. Not sure if that’s intentional.
 */
public class Contact {
  private String name;
  private String addressStreet;
  private String addressCity;
  private String addressState;
  private String addressZIP;
  private String phoneNumber;
  private String email;
  private String note;

  public static class Builder {
    //required parameters
    private String name;

    //Optional parameters
    private String addressStreet = "";
    private String addressCity = "";
    private String addressState = "";
    private String addressZIP = "";
    private String phoneNumber = "";
    private String email = "";
    private String note = "";

    /**
     * Constructs a Builder object with one required property - name.
     *
     * Since the class Contact has many constructor parameters, we use Builder Pattern
     * to combines the safety of the telescoping constructor pattern with the readability
     * of the JavaBeans pattern.
     *
     * @param  name - name to be set, never use THREE CONSECUTIVE COMMAS in name,
     *               name can only be within ONE LINE, don't use line breaker.
     */
    public Builder(String name) {
      if(name != null && name.trim().length() != 0) {
        this.name = name;
      }
    }

    /**
     * Set address street - optional property of the contact
     *
     * @param  val - address street to be set, never use THREE CONSECUTIVE COMMAS in val,
     *               val can only be within ONE LINE, don't use line breaker.
     * @return a Builder instance whose address street has been set to be val
     */
    public Builder addressStreet(String val) {
      if(val != null && val.trim().length() != 0) {
        addressStreet = val;
      }
      return this;
    }

    /**
     * Set address city - optional property of the contact
     *
     * @param  val - address city to be set, never use THREE CONSECUTIVE COMMAS in val,
     *               val can only be within ONE LINE, don't use line breaker.
     * @return a Builder instance whose address city has been set to be val
     */
    public Builder addressCity(String val) {
      if(val != null && val.trim().length() != 0) {
        addressCity = val;
      }
      return this;
    }

    /**
     * Set address state - optional property of the contact
     *
     * @param  val - address state to be set, never use THREE CONSECUTIVE COMMAS in val,
     *               val can only be within ONE LINE, don't use line breaker.
     * @return a Builder instance whose address state has been set to be val
     */
    public Builder addressState(String val) {
      if(val != null && val.trim().length() != 0) {
        addressState = val;
      }
      return this;
    }

    /**
     * Set address zipcode - optional property of the contact
     *
     * @param  val - address zipcode to be set, never use THREE CONSECUTIVE COMMAS in val,
     *               val can only be within ONE LINE, don't use line breaker.
     * @return a Builder instance whose address zipcode has been set to be val
     */
    public Builder addressZIP(String val) {
      if(val != null && val.trim().length() != 0) {
        addressZIP = val;
      }
      return this;
    }

    /**
     * Set phone number - optional property of the contact
     *
     * @param  val - phone number to be set, never use THREE CONSECUTIVE COMMAS in val,
     *               val can only be within ONE LINE, don't use line breaker.
     * @return a Builder instance whose phone number has been set to be val
     */
    public Builder phoneNumber(String val) {
      if(val != null && val.trim().length() != 0) {
        phoneNumber = val;
      }
      return this;
    }

    /**
     * Set email - optional property of the contact
     *
     * @param  val - email to be set, never use THREE CONSECUTIVE COMMAS in val,
     *               val can only be within ONE LINE, don't use line breaker.
     * @return a Builder instance whose email has been set to be val
     */
    public Builder email(String val) {
      if(val != null && val.trim().length() != 0) {
        email = val;
      }
      return this;
    }

    /**
     * Set note - optional property of the contact
     *
     * @param  val - note to be set, never use THREE CONSECUTIVE COMMAS in val,
     *               val can only be within ONE LINE, don't use line breaker.
     * @return a Builder instance whose note has been set to be val
     */
    public Builder note(String val) {
      if(val != null && val.trim().length() != 0) {
        note = val;
      }
      return this;
    }

    /**
     * Construct a new Contact instance whose properties(e.g. name, addressStreet)
     * are the same as this Builder instance's
     *
     * @return a Contact instance - its every property is same, respectively, as this Builder
     *                              instance's.
     */
    public Contact build() {
      return new Contact(this);
    }
  }

  /**
   * Construct a new Contact instance.
   *
   * @param  builder - a Builder instance that has specific properties.
   */
  private Contact(Builder builder) {
    name = builder.name;
    addressStreet = builder.addressStreet;
    addressCity = builder.addressCity;
    addressState = builder.addressState;
    addressZIP = builder.addressZIP;
    phoneNumber = builder.phoneNumber;
    email = builder.email;
    note = builder.note;
  }

  /**
   * Set the name property of the contact
   *
   * @param  val - name to be set, never use THREE CONSECUTIVE COMMAS in val,
   *               val can only be within ONE LINE, don't use line breaker.
   */
  public void setName(String val) {
    if(val != null && val.trim().length() != 0) {
      this.name = val;
    }
  }

  /**
   * Set the address street property of the contact
   *
   * @param  val - address street to be set, never use THREE CONSECUTIVE COMMAS in val,
   *               val can only be within ONE LINE, don't use line breaker.
   */
  public void setAddressStreet(String val) {
    if(val != null && val.trim().length() != 0) {
      this.addressStreet = val;
    }
  }

  /**
   * Set the address city property of the contact
   *
   * @param  val - address city to be set, never use THREE CONSECUTIVE COMMAS in val,
   *               val can only be within ONE LINE, don't use line breaker.
   */
  public void setAddressCity(String val) {
    if(val != null && val.trim().length() != 0) {
      this.addressCity = val;
    }
  }

  /**
   * Set the address state property of the contact
   *
   * @param  val - address state to be set, never use THREE CONSECUTIVE COMMAS in val,
   *               val can only be within ONE LINE, don't use line breaker.
   */
  public void setAddressState(String val) {
    if(val != null && val.trim().length() != 0) {
      this.addressState = val;
    }
  }

  /**
   * Set the address zipcode property of the contact
   *
   * @param  val - address zipcode to be set, never use THREE CONSECUTIVE COMMAS in val,
   *               val can only be within ONE LINE, don't use line breaker.
   */
  public void setAddressZIP(String val) {
    if(val != null && val.trim().length() != 0) {
      this.addressZIP = val;
    }
  }

  /**
   * Set the phone number property of the contact
   *
   * @param  val - phone number to be set, never use THREE CONSECUTIVE COMMAS in val,
   *               val can only be within ONE LINE, don't use line breaker.
   */
  public void setPhoneNumber(String val) {
    if(val != null && val.trim().length() != 0) {
      this.phoneNumber = val;
    }
  }

  /**
   * Set the email property of the contact
   *
   * @param  val - email to be set, never use THREE CONSECUTIVE COMMAS in val,
   *               val can only be within ONE LINE, don't use line breaker.
   */
  public void setEmail(String val) {
    if(val != null && val.trim().length() != 0) {
      this.email = val;
    }
  }

  /**
   * Set the note property of the contact
   *
   * @param  val - note to be set, never use THREE CONSECUTIVE COMMAS in val,
   *               val can only be within ONE LINE, don't use line breaker.
   */
  public void setNote(String val) {
    if(val != null && val.trim().length() != 0) {
      this.note = val;
    }
  }

  /**
   * get the name property of the contact
   *
   * @return  the value of name property
   */
  public String getName() {
    return name;
  }

  /**
   * get the address street property of the contact
   *
   * @return  the value of address street property
   */
  public String getAddressStreet() {
    return addressStreet;
  }

  /**
   * get the address city property of the contact
   *
   * @return  the value of address city property
   */
  public String getAddressCity() {
    return addressCity;
  }

  /**
   * get the address state property of the contact
   *
   * @return  the value of address state property
   */
  public String getAddressState() {
    return addressState;
  }

  /**
   * get the address zipcode property of the contact
   *
   * @return  the value of address zipcode property
   */
  public String getAddressZIP() {
    return addressZIP;
  }

  /**
   * get the phone number property of the contact
   *
   * @return  the value of phone number property
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * get the email property of the contact
   *
   * @return  the value of email property
   */
  public String getEmail() {
    return email;
  }

  /**
   * get the note property of the contact
   *
   * @return  the value of note property
   */
  public String getNote() {
    return note;
  }

  /**
   * Compares this Contact to the specified object. The result is true if and only if the argument
   * is not null and is a Contact object that has the same properties(e.g. name, email) as this
   * object.
   *
   * @param o - The object to compare this Contact against
   * @return  true if the given object represents a Contact equivalent to this Contact,
   *          false otherwise
   */
  @Override public boolean equals(Object o) {
    if(!(o instanceof Contact)) {
      return false;
    }
    Contact contact = (Contact) o;
    return  (name.equalsIgnoreCase(contact.name))
        &&  (addressStreet.equalsIgnoreCase(contact.addressStreet))
        &&  (addressCity.equalsIgnoreCase(contact.addressCity))
        &&  (addressState.equalsIgnoreCase(contact.addressState))
        &&  (addressZIP.equalsIgnoreCase(contact.addressZIP))
        &&  (phoneNumber.equalsIgnoreCase(contact.phoneNumber))
        &&  (email.equalsIgnoreCase(contact.email))
        &&  (note.equalsIgnoreCase(contact.note));
  }

  /**
   * Returns a hash code value for the Contact object
   *
   * @return  a hash code value for the Contact object
   */
  @Override public int hashCode() {
    int result = 17;
    result = 31 * result + (name == null ? 0 : name.hashCode());
    result = 31 * result + (addressStreet == null ? 0 : addressStreet.hashCode());
    result = 31 * result + (addressCity == null ? 0 : addressCity.hashCode());
    result = 31 * result + (addressState == null ? 0 : addressState.hashCode());
    result = 31 * result + (addressZIP == null ? 0 : addressZIP.hashCode());
    result = 31 * result + (phoneNumber == null ? 0 : phoneNumber.hashCode());
    result = 31 * result + (email == null ? 0 : email.hashCode());
    result = 31 * result + (note == null ? 0 : note.hashCode());
    return result;
  }

  /**
   * Returns a string representation of the Contact object.
   *
   * e.g. Name: Estella
   *      Street Address: som
   *      Address City: NYC
   *      Address State: NY
   *      Address ZIP: 10023
   *      Phone Number: 123
   *      Email: estellazhu23@gmail.com
   *      Note:
   *
   * @return a string representation of the Contact object.
   */
  @Override public String toString() {
    return "Name: " + name + '\n'
        +  "Street Address: " + addressStreet + '\n'
        +  "Address City: " + addressCity + '\n'
        +  "Address State: " + addressState + '\n'
        +  "Address ZIP: " + addressZIP + '\n'
        +  "Phone Number: " + phoneNumber + '\n'
        +  "Email: " + email + '\n'
        +  "Note: " + note + '\n';
  }
}
