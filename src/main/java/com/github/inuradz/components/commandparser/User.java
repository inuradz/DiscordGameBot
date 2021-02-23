package com.github.inuradz.components.commandparser;

import net.sourceforge.argparse4j.inf.Argument;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.ArgumentType;
import org.javacord.api.DiscordApi;
import org.javacord.api.util.DiscordRegexPattern;

import java.util.concurrent.ExecutionException;

public class User implements ArgumentType<org.javacord.api.entity.user.User>{

    private final DiscordApi api;

    public User(DiscordApi api){
        this.api = api;
    }

    /**
     * <p>
     * Converts {@code value} to appropriate type.
     * </p>
     * <p>
     * If the objects derived from {@link RuntimeException} are thrown in
     * conversion because of invalid input from command line, subclass must
     * catch these exceptions and wrap them in {@link ArgumentParserException}
     * and give simple error message to explain what happened briefly.
     * </p>
     *
     * @param parser The parser.
     * @param arg    The argument this type attached to.
     * @param value  The attribute value.
     * @return Converted object.
     * @throws ArgumentParserException If conversion fails.
     */
    @Override
    public org.javacord.api.entity.user.User convert(ArgumentParser parser, Argument arg, String value) throws ArgumentParserException {
        var matcher = DiscordRegexPattern.USER_MENTION.matcher(value);
        if (matcher.find()){
            var userId = matcher.group("id");
            try {
                return api.getUserById(userId).get();
            } catch (InterruptedException e) {
                throw new ArgumentParserException("interrupted exception",e,parser,arg);
            } catch (ExecutionException e) {
                throw new ArgumentParserException("Execution exception",e,parser,arg);
            }
        } else {
            //This needs to return an error because the id doesn't exist
            throw new ArgumentParserException("Invalid Argument",parser,arg);
        }
    }
}
