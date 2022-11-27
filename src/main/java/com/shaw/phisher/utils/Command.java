package com.shaw.phisher.utils;

import java.io.IOException;

public class Command {
    public static void execute(String command) throws IOException {
        Runtime.getRuntime().exec(new String[]{command});
    }
}
