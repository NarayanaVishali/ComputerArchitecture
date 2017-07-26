import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RecursiveMips {
	static int numberOfLines = 0;

	public static void main(final String[] args) throws IOException {
		String[] bits;

		if (args.length != 5) {
			System.out.println("Invalid number of inputs. Please provide valid fileName and line number.");
			System.exit(0);
		}
		System.out.println("Enter the line numbers\n");
		List<Integer> numbers = new ArrayList<Integer>();
		Scanner stdin = new Scanner(System.in);
		int number = stdin.nextInt();
		while (number != 0) {
			numbers.add(number);
			number = stdin.nextInt();
		}
		final String inputFile = args[0];
		if (inputFile == null || inputFile.isEmpty()) {
			System.out.println("File name cannot be null/empty. Please provide valid file name.");
			System.exit(0);
		}

		try (BufferedReader brr = new BufferedReader(new FileReader(inputFile))) {
			String lines;
			int countLines = 0;
			while ((lines = brr.readLine()) != null) {
				countLines += 1;
			}
			System.out.println("Number of Lines in the input file:" + countLines);
			String option = args[1];
			float errorrate = Float.parseFloat(args[2]);
			int cluster = Integer.parseInt(args[3]);
			int numberOfBitsToBeFlipped = ((int) Math.ceil(((countLines * 32 * errorrate) / 100)));
			System.out.println("Number of Bits to be flipped:" + numberOfBitsToBeFlipped);
			// final int lineNumber1 = Integer.parseInt(args[1]);

			BufferedWriter bw = new BufferedWriter(new FileWriter(args[4]));
			int opcodeFlippedBits = (int) (Math.floor(cluster * numberOfBitsToBeFlipped) / 100);
			int fieldFlippedBits = numberOfBitsToBeFlipped - opcodeFlippedBits;
			switch (option) {
			case "R":
				System.out.println("RELIABILITY TEST:");
				System.out.println("Bits flipped are");
				try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
					String line;
					int countLine = 0;
					while ((line = br.readLine()) != null) {
						// process the line.
						countLine += 1;
						for (int n = 0; n < numbers.size(); n++) {
							if (countLine == numbers.get(n)) {
								bits = line.split("");
								for (int j = 0; j < numberOfBitsToBeFlipped; j++) {

									int Rrandom = new Random().nextInt((31 - 6) + 1) + 6;
									System.out.println(Rrandom);
									if (bits[Rrandom].equalsIgnoreCase("1")) {
										bits[Rrandom] = "0";
									} else {
										bits[Rrandom] = "1";
									}
								}
								StringBuilder strBuilder = new StringBuilder();
								for (int i = 0; i < bits.length; i++) {
									strBuilder.append(bits[i]);
								}
								String flippedLine = strBuilder.toString();

								bw.write(flippedLine);
								bw.write("\n");
								bw.flush();

							} else {
								bw.write(line);
								bw.write("\n");
								bw.flush();
							}
						}
					}

				} catch (final FileNotFoundException e) {
					System.out.println("Unable to find the file: \"" + inputFile + "\". Please provide valid file.");
					System.exit(0);
				} catch (final IOException e) {
					System.out
							.println("Unable to write to the file: \"" + inputFile + "\". Please provide valid file.");
					System.exit(0);
				} finally {
					bw.close();
				}
				break;
			case "I":
				System.out.println("INSECURITY TEST:");
				System.out.println("Bits flipped are");
				try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
					String line;
					int countLine = 0;
					while ((line = br.readLine()) != null) {
						// process the line.
						countLine += 1;
						for (int n = 0; n < numbers.size(); n++) {
							if (countLine == numbers.get(n)) {
								bits = line.split("");
								for (int j = 0; j < numberOfBitsToBeFlipped; j++) {

									int Srandom = new Random().nextInt((5 - 0) + 1) + 0;
									System.out.println(Srandom);
									if (bits[Srandom].equalsIgnoreCase("1")) {
										bits[Srandom] = "0";
									} else {
										bits[Srandom] = "1";
									}
								}
								StringBuilder strBuilder = new StringBuilder();
								for (int i = 0; i < bits.length; i++) {
									strBuilder.append(bits[i]);
								}
								String flippedLine = strBuilder.toString();

								bw.write(flippedLine);
								bw.write("\n");
								bw.flush();

							} else {
								bw.write(line);
								bw.write("\n");
								bw.flush();
							}
						}
					}

				} catch (final FileNotFoundException e) {
					System.out.println("Unable to find the file: \"" + inputFile + "\". Please provide valid file.");
					System.exit(0);
				} catch (final IOException e) {
					System.out
							.println("Unable to write to the file: \"" + inputFile + "\". Please provide valid file.");
					System.exit(0);
				} finally {
					bw.close();
				}
				break;
			case "UI":
				System.out.println("UNRELIABILITY AND INSECURTIY TEST:");
				System.out.println("Bits flipped are");
				try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
					String line;
					int countLine = 0;
					while ((line = br.readLine()) != null) {
						// process the line.
						countLine += 1;
						for (int n = 0; n < numbers.size(); n++) {
							if (countLine == numbers.get(n)) {
								bits = line.split("");
								for (int j = 0; j < opcodeFlippedBits; j++) {

									int RSrandom = new Random().nextInt((5 - 0) + 1) + 0;
									System.out.println(RSrandom);
									if (bits[RSrandom].equalsIgnoreCase("1")) {
										bits[RSrandom] = "0";
									} else {
										bits[RSrandom] = "1";
									}
								}
								StringBuilder strBuilder = new StringBuilder();
								for (int i = 0; i < bits.length; i++) {
									strBuilder.append(bits[i]);
								}
								String flippedLine = strBuilder.toString();

								bw.write(flippedLine);
								bw.write("\n");
								bw.flush();
								for (int j = 0; j < fieldFlippedBits; j++) {

									int RSrandom = new Random().nextInt((31 -6 ) + 1) + 6;
									System.out.println(RSrandom);
									if (bits[RSrandom].equalsIgnoreCase("1")) {
										bits[RSrandom] = "0";
									} else {
										bits[RSrandom] = "1";
									}
								}
								StringBuilder strBuilders = new StringBuilder();
								for (int i = 0; i < bits.length; i++) {
									strBuilders.append(bits[i]);
								}
								String flippedLines = strBuilders.toString();

								bw.write(flippedLines);
								bw.write("\n");
								bw.flush();

							} else {
								bw.write(line);
								bw.write("\n");
								bw.flush();
							}
						}
					}

				} catch (final FileNotFoundException e) {
					System.out.println("Unable to find the file: \"" + inputFile + "\". Please provide valid file.");
					System.exit(0);
				} catch (final IOException e) {
					System.out
							.println("Unable to write to the file: \"" + inputFile + "\". Please provide valid file.");
					System.exit(0);
				} finally {
					bw.close();
				}
				break;

			}
		}
	}
}