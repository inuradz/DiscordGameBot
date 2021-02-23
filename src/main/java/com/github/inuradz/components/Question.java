package com.github.inuradz.components;

import org.javacord.api.entity.user.User;

import java.util.List;

public abstract class Question {

    public abstract List<User> getCorrectAnswers();

}
