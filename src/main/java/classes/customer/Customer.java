package classes.customer;

import classes.address.Address;
import classes.human.Human;

public class Customer extends Human implements  Comparable<Human>{
    private int id;
    private Address address;
    private CreditCard creditCardNumber;
    private String bankAccountNumber;

    public Customer(int id) {
        createHuman();
        this.id = id;
        address = new Address();
        creditCardNumber = new CreditCard();
        generationSimpleAccountBank();
    }

    public int getId() {
        return id;
    }

    public String getSecondName() {
        return super.getSecondName();
    }

    public void setSecondName(String secondName) {
        super.setSecondName(secondName);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getParentName() {
        return super.getParentName();
    }

    public void setParentName(String parentName) {
        super.setParentName(parentName);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CreditCard getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(CreditCard creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int compareTo(Human o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return super.toString() + " " + address.toString() + creditCardNumber.toString()
                + ". Номер банковского счета: " + bankAccountNumber;
    }

    public boolean isNumberCardSizeInterval(long start, long finish) {
        long card = Long.parseLong(creditCardNumber.getNumber().replaceAll("_", ""));
        if ( card >= start && card <= finish) {
            return true;
        }
        return false;
    }

    private void generationSimpleAccountBank() {
        bankAccountNumber = "" + 9000 + random();
    }

    private int random() {
        return (int) (Math.random() * 9_000 + 1_000);
    }
}
