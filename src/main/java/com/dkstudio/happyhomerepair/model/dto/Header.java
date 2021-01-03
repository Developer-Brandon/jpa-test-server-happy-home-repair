package com.dkstudio.happyhomerepair.model.dto;

import javafx.scene.control.Pagination;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {
    private LocalDateTime transactionTime;
    private String resultCode;
    private String description;
    private T data;
    private Pagination pagination;

    public static <T> Header<T> SUCCESS() {
        return (Header<T>) null;
    }

    public static <T> Header<T> SUCCESS(T data) {
        return (Header<T>) null;
    }

    public static <T> Header<T> SUCCESS(T data, Pagination pagination) {
        return (Header<T>) null;
    }

    public static <T> Header<T> ERROR(String description) {
        return (Header<T>) null;
    }
}
