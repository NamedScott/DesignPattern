package com.iotest;


import java.io.*;

/**
 * Created by scott on 2018/5/13.
 */
public class IoTest {


    public static void main(String[] args) throws FileNotFoundException {
        InputStream in = new FileInputStream(new File("/Users/scott/Downloads/new.txt"));
        InputStreamReader reader = new InputStreamReader(in);
        //reader.read()


    }

}
