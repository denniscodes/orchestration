package com.bipedalprogrammer.model;

import java.time.LocalDate;

public record Customer(String customerReferenceId, String companyName, LocalDate establishedOn) {
}
