package com.motocart.library.common.types;

import lombok.Getter;

public class Profile {

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    public enum AddressType {
        HOME,
        WORK,
        OTHER
    }

    @Getter
    public enum Country {
        INDIA(0, "India"),
        UNITED_KINGDOM(1, "United Kingdom"),
        USA(2, "United States of America");

        private final int countryId;
        private final String displayName;

        Country(int countryId, String displayName) {
            this.countryId = countryId;
            this.displayName = displayName;
        }
    }
}
