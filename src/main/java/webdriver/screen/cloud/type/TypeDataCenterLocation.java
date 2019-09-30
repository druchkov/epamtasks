package webdriver.screen.cloud.type;

public enum TypeDataCenterLocation {
    IOWA(178),
    SOUTH_CAROLINA(179),
    NORTHEM_VIRGINIA(180),
    OREGON(181),
    LOS_ANGELES(182),
    BELGIUM(183),
    LONDON(184),
    FRANKFURT(185);

    int idTeg;

    TypeDataCenterLocation(int id) {
        idTeg = id;
    }

    public String getIdLocator() {
        return "select_option_" + idTeg;
    }
}
