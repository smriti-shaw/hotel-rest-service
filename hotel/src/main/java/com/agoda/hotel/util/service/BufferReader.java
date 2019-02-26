package com.agoda.hotel.util.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public interface BufferReader {

     BufferedReader initiateBufferReader(String fileName) throws IOException;

}
