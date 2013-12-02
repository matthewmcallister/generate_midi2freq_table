/*
**  MIDI2freq_generator.java
**  
**  Simple program to generate frequencies for all MIDI note numbers 0-127
**
**  Matthew McAllister
**  
**  nov-29-2013 created
*/

import java.lang.Math;

public class MIDI2freq_generator {


    /* 
     * init, generate, and print matrix
     */

    public static void main(String[] args) {
    	int matrix[] = new int[128];
    	generate(matrix);
    	print_matrix(matrix, 12);
    }


    /* 
    **  Method to generate frequencies for MIDI note numbers
    **  from number 0 to 127
    */

    static void generate(int[] matrix) {
        
        double pow_i;

        /* 
        **  from formula: 
        **	f = 2 ^ [(p - 69) / 12] * 440 [Hz]
        **
        **	where p is the MIDI note number
        */

        for (int i = 0; i < matrix.length; i++) {
        	pow_i = (i - 69) / 12.0;
        	matrix[i] = (int) (Math.pow(2, pow_i) * 440.0);
        }
    }


    /*
    **  Method to print out matrix with specified number of columns
    */

    static void print_matrix(int[] matrix, int num_cols) {
        
        // Determine number of rows
        int num_rows = matrix.length/num_cols + 1;
        int index;

        // want to create matrix-like output
        for (int i = 0; i < num_rows; i++) {
        	
            for (int j = 0; j < num_cols; j++) {
        	
                // since matrix is actually 1-dimensional, compute index this way
                index = i * num_cols + j;
                
                System.out.print("\t" + matrix[index]);
                
                // break out of loop when last index of matrix is reached
                if (index + 1 >= matrix.length) {
                    break;
                }

                System.out.print(",");
        	}

        	System.out.println();
        }
    }
}


