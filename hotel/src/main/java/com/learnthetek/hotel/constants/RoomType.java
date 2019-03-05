package com.learnthetek.hotel.constants;
public enum RoomType {

    DELUXE("Deluxe"),
    SUPERIOR("Superior"),
    SWEETSUITE("Sweet Suite"),
    DEFAULT("General") ;

    private final String displayName;

    RoomType(final String display)
    {
        this.displayName = display;
    }

    @Override public String toString()
    {
        return this.displayName;
    }

    public static String getRoomType(String roomType){

        if(roomType.compareToIgnoreCase(DELUXE.toString()) == 0)
            return DELUXE.displayName;
        if(roomType.compareToIgnoreCase(SUPERIOR.toString()) == 0)
            return SUPERIOR.displayName;
        if(roomType.compareToIgnoreCase(SWEETSUITE.toString()) == 0)
            return SWEETSUITE.displayName;
        else
            return DEFAULT.displayName;

    }




}
