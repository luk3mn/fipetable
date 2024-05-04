package com.luke.fipecar.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Vehicle(
        @JsonAlias("codigo") String code,
        @JsonAlias("nome") String name
) {
}
