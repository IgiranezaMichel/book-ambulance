package com.bookambulance.GraphQlModels;

import com.bookambulance.Model.User;

import lombok.Getter;
import lombok.Setter;
public class userInput extends User{
    @Getter @Setter
    private String identity;
}
