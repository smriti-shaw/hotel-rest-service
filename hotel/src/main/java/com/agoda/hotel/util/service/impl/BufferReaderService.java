package com.agoda.hotel.util.service.impl;

import com.agoda.hotel.util.service.BufferReader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class BufferReaderService implements BufferReader {

    @Override
    public BufferedReader initiateBufferReader(String fileName) throws IOException
    {
        Path path = Paths.get(fileName);
        return Files.newBufferedReader(path, StandardCharsets.US_ASCII);
    }
}
