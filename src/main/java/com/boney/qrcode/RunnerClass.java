package com.boney.qrcode;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import com.google.zxing.WriterException;

import java.nio.file.Paths;
import java.util.concurrent.Callable;

@Command(name = "bqr",
        version = "BoneyQR v1.0",
        mixinStandardHelpOptions = true,
        header = "Simple cli tool to create a QR code and render QR code to text.")
public class RunnerClass implements Callable<Integer> {
        @Option(names = {"-v", "--verbose"}, description = "More verbose output")
        private boolean verbose = false;

        @Option(names = { "-s", "--size" }, description = "Image size")
        String dimension;

        @Option(names = { "-f", "--format" }, description = "Image format")
        String format;

        @Option(names = { "-d", "--directory" }, description = "Output path")
        String path;
        @Option(names = { "-o", "--output-name" }, description = "Output name")
        String outputFile;


        @Parameters(index = "0", description = "Text to be encoded in the QR code")
        private String text;

        @Override
        public Integer call() {
                int size;
                if (dimension != null) {
                        size = Integer.parseInt(dimension);
                } else {
                        size = 200;
                }



                System.out.println("[+] Generating QR code.....");
                QRCodeGenerator qrCodeGenerator = new QRCodeGenerator(text, format, size, path);

                if (verbose) {
                        System.out.println("[.] Params:");
                        System.out.println(qrCodeGenerator);
                }

                try {
                        qrCodeGenerator.generateQrCode();
                        System.out.println("[+] QR code generated. Output: " + outputFile);
                        return 0;
                } catch (WriterException e) {
                        System.err.println("[-] Error while generating QR code (" + e.getMessage() + ")");
                        return 1;
                } catch (IOException e) {
                        System.err.println("[-] Error while generating file (" + e.getMessage() + ")");
                        return 2;
                }


        }

        public static void main(String[] args) {
            int exitCode = new CommandLine(new RunnerClass()).execute(args);
            System.exit(exitCode);
        }
}
