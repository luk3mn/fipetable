package com.luke.fipecar.service;

import java.util.List;

public interface IConvertData {
    <T> T getData(String json, Class<T> _class);

    <T> List<T> getList(String json, Class<T> _class);
}
