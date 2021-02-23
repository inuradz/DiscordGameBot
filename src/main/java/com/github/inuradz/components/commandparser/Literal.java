package com.github.inuradz.components.commandparser;

public class Literal extends CommandComponent{

    private String matchString;

    public Literal(String matchString){
        this.matchString = matchString;
    }

}
