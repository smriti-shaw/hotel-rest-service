package com.learnthetek.hotel.constants;

public enum SecretToken {

    GET_API_SECRET_TOKEN("hotel_get_secret_key");

    private final String displayName;

    SecretToken(final String display)
    {
        this.displayName = display;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
