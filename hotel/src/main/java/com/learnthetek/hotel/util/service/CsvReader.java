package com.learnthetek.hotel.util.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class CsvReader {

    public static BufferedReader initiateBufferReader(Path path) throws IOException
    {
        return Files.newBufferedReader(path, StandardCharsets.US_ASCII);
    }
}
