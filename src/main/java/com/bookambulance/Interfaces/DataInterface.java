package com.bookambulance.Interfaces;

import java.util.List;

public interface DataInterface <T>{
T saveOrUpdateData(T data);
void deleteDataById(T id);
List<T> getAllData();
}
