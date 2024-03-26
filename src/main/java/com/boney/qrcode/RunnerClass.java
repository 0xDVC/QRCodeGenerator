package com.boney.qrcode;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "bqr",
        version = "BoneyQR v1.0",
        mixinStandardHelpOptions = true,
        header = "Simple cli tool to create a QR code and render QR code to text.")
public class RunnerClass implements Callable<Integer> {

        @Option(names = { "-s", "--size" }, description = "Image size")
        String size;

        @Option(names = { "-f", "--format" }, description = "Image format")
        String format;

        @Option(names = { "-d", "--directory" }, description = "Output path")
        String path;

        @Parameters(index = "0", description = "Text to be encoded in the QR code")
        private String text;


        @Override
        public void call() {

        }

        public static void main(String[] args) {
            int exitCode = new CommandLine(new RunnerClass()).execute(args);
            System.exit(exitCode);
        }
}
