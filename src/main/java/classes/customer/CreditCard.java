package classes.customer;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CreditCard {
    private String number;
    private int cvv;
    private Calendar validThru;

    public CreditCard(String number, int cvv, Calendar validThru) {
        this.number = number;
        this.cvv = cvv;
        this.validThru = validThru;
    }

    public CreditCard() {
        generationCard();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Calendar getCvv() {
        return validThru;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public Calendar getValidThru() {
        return validThru;
    }

    public void setValidThru(Calendar validThru) {
        this.validThru = validThru;
    }

    @Override
    public String toString() {
        return " Номер карты: " + number
                + ". Действительна до " + (validThru.get(Calendar.MONTH) + 1) + "/" + validThru.get(Calendar.YEAR)
                + ". CVV:" + cvv;
    }

    private void generationCard() {
        validThru = new GregorianCalendar();
        cvv = (int) (Math.random() * 900) + 100;
        number = String.format("5555_%d_%d_%d", random(1000, 10_000), random(1000, 10_000), random(1000, 10_000));
        validThru.set(Calendar.YEAR, random(2020, 2025));
        validThru.set(Calendar.MONTH, random(0, 12));
    }

    private int random(int start, int finish) {
        return (int) (Math.random() * (finish - start) + start);
    }
}
