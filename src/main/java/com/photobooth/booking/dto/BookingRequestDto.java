package com.photobooth.booking.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;

public class BookingRequestDto {

    @NotBlank
    private String customerName;

    @NotBlank
    @Pattern(regexp = "\\d{10}")
    private String phone;

    @Email
    private String email;

    @NotBlank
    private String eventType;

    @NotBlank
    private String boothType;

    @NotBlank
    private String packageName;

    @NotNull
    private LocalDate eventDate;

    @NotNull
    private LocalTime startTime;

    @Min(1)
    private int duration;

    @NotNull
    private BigDecimal totalPrice;

    @NotBlank
    private String location;

    // getters & setters
}
