package com.boney.qrcode;

import com.google.zxing.WriterException;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOError;
import java.io.IOException;
import java.io.WriteAbortedException;
import java.util.concurrent.Callable;

@Command(name = "bqr",
        version = "BoneyQR v1.0",
        mixinStandardHelpOptions = true,
        header = "Simple cli tool to create a QR code and render QR code to text.")
public class RunnerClass implements Callable<Integer> {
        @Option(names = {"-v", "--verbose"}, description = "More verbose output")
        private boolean verbose = false;

        @Option(names = { "-s", "--size" }, description = "Image size")
        String size;

        @Option(names = { "-f", "--format" }, description = "Image format")
        String format;

        @Option(names = { "-d", "--directory" }, description = "Output path")
        String path;

        @Parameters(index = "0", description = "Text to be encoded in the QR code")
        private String text;


        @Override
        public Integer call() throws WriterException, IOException {
                System.out.println("[+] Generating QR code.....");
                QRCodeGenerator qrCodeGenerator = new QRCodeGenerator(text, format, Integer.parseInt(size));

                if (verbose) {
                        System.out.println("[.] Params:");
                        System.out.println(qrCodeGenerator);
                }

                try {
                        qrCodeGenerator.generateQrCode();
                        System.out.println("[+] QR code generated. Output: " + outputFile);
                        return 0;
                } catch (WriterException e) {
                        throw new WriterException("[-] Error while generating QR code (" + e.getMessage() + ")");
                        return 1;
                } catch (IOException e) {
                        throw new IOException("[-] Error while generating file (" + e.getMessage() + ")");
                        return 2;
                }


        }

        public static void main(String[] args) {
            int exitCode = new CommandLine(new RunnerClass()).execute(args);
            System.exit(exitCode);
        }
}
