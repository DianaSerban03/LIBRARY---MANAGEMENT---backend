package com.mylibrary.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRole {
    @JsonProperty("LIBRARIAN")
    LIBRARIAN,
    @JsonProperty("ABONAT")
    ABONAT
}
