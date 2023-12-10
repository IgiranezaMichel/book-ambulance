package com.bookambulance.GraphQlModels;
import lombok.Data;

@Data
public class locationInput {
private String id;
private String name;
private String type;
private long locationFk;
}

