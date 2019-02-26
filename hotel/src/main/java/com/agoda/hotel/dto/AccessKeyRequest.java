package com.agoda.hotel.dto;

import java.io.Serializable;
import java.util.Objects;

public class AccessKeyRequest implements Serializable {

    private String secretToken;

    public AccessKeyRequest() {
    }

    public AccessKeyRequest(String secretToken) {
        this.secretToken = secretToken;
    }

    public String getSecretToken() {
        return secretToken;
    }

    @Override
    public String toString() {
        return "AccessKeyRequest{" +
                "secretToken='" + secretToken + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessKeyRequest that = (AccessKeyRequest) o;
        return Objects.equals(secretToken, that.secretToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secretToken);
    }


}
