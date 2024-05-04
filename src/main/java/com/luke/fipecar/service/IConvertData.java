package com.luke.fipecar.service;

public interface IConvertData {
    <T> T getData(String json, Class<T> _class);
}
