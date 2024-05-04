package com.luke.fipecar.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record Vehicle(
        @JsonAlias("codigo") Integer code,
        @JsonAlias("nome") String name
) {
}
