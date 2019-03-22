public enum AirportCode {

    AAR("Aarhus", "Denmark"),
    ABZ("Aberdeen", "United Kingdom"),
    AUH("Abu Dhabi", "United Arab Emirates"),
    AMS("Amsterdam", "Netherlands"),
    ANR("Antwerp", "Belgium"),
    ATH("Athens", "Greece"),
    AKL("Auckland", "New Zealand"),
    BKK("Bangkok", "Thailand"),
    BCN("Barcelona", "Spain"),
    BSL("Basel", "Switzerland"),
    BHD("Belfast", "United Kingdom"),
    BER("Berlin", "Germany"),
    GLA("Glasgow", "United Kingdom"),
    EDI("Edinburgh", "United Kingdom");

    private final String city;
    private final String country;

    AirportCode(String city, String country){
        this.city = city;
        this.country = country;
    }

    public String getCity(){
        return this.city;
    }

    public String getCountry(){
        return this.country;
    }
}
