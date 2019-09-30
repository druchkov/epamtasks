package classes.address;

public class Address {
    private String town;
    private String street;
    private int house;
    private int room;

    public Address() {
        createAddress();
    }

    public Address(String town, String street, int house, int room) {
        this.town = town;
        this.street = street;
        this.house = house;
        this.room = room;
    }

    public String getCity() {
        return town;
    }

    public void setSity(String city) {
        this.town = city;
    }

    public String getStreat() {
        return street;
    }

    public void setStreat(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "г." + town + " ул." + street + " д." + house + " кв." + room;
    }



    public void createAddress() {
        Street[] listStreets = Street.values();
        int city = (int) (Math.random() * 10);
        int addressNumber = (int) (Math.random() * listStreets.length);
        if (city > 3) {
            town = Towns.GOMEL.getTown();
        } else if (city == 0) {
            town = Towns.BREST.getTown();
        } else if (city == 1) {
            town = Towns.MOGILEV.getTown();
        } else if (city == 2) {
            town = Towns.MOZIR.getTown();
        } else {
            town = Towns.RECHICA.getTown();
        }
        street = listStreets[addressNumber].getStreet();
        house = (int) (Math.random()* 60 + 1);
        room = (int) (Math.random()*72 + 1);
    }
}
