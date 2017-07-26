SUBMITTED FILES

1. Calculator.s --> Calculator MIPS code
2. BinToHexFile.java --> Converts binary file to hexadecimal format file
3. RecursiveMips.java --> Error Injection file through bit flipping
4. FINAL_README --> This is the final updated readme

SOFTWARES USED

1. We have used MARS software to convert the MIPS code to binary format file
2. We have used an online converter to convert hexadecimal instructions to MIPS instructions
   Online Converter URL : https://www.eg.bucknell.edu/~csci320/mips_web/

EXECUTION STEPS

1. Load the Calculator.s MIPS code into the MARS Simulator.
2. Run the MIPS code and then assemble.
3. After succcessfull compilation, click on run symbol.
4. Enter the inputs as specified.
5. Check the output obtained.
6. Dump the binary text file of the loaded MIPS code into a file on your desktop.
7. This binary text file is given as input along with the type of distribution,error rate,cluster percentage and outputpath to the RecursiveMips.java program.
8. During runtime specify the lines where error should be injected and press 0 to continue with flipping.
9. This results in a Binary File with error injection in the given outputpath.
10. This Binary File should be given as input to the BinToHexFile.java which returns a hexadecimal text file.
11. Based on lines where error is injected, check for the change in instruction with online convertor.
   Online Converter URL : https://www.eg.bucknell.edu/~csci320/mips_web/
12.Make changes in the original MIPS and then run the program again as above following steps 1 to 5.
13.Check the output after error injection.
14.All the outputs of the different testcases are included in the report.