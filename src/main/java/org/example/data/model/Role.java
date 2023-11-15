package org.example.data.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public enum Role {
    MANAGER("value"),
    CEO("value"),
    SALESPERSON("value"),
    CLEANER("value");
    private final String value;

}
