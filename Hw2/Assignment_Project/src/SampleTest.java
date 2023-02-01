import Matrix.Matrix;

public class SampleTest {

    static void divide_line(char divide_char){
        String res = "";
        for (int numi = 0; numi < 30; numi++) res += divide_char;

        System.out.println(res);
    }

    public static void main(String[] args){
        // Sample tests for each task
        // Feel free to edit this file to make your own customized test cases
        // We will **not** evaluate this script.

        // Task 1.1
        Matrix myMatrix = new Matrix(3, 3, "[[1.0; [(0,0)];\n [2.11;\t [(0,  1);\r (1, 2)]]");

        // Task 1.2
        divide_line('=');
        System.out.println("Task 1.2");

        String myMatrix_print = myMatrix.print();
        String ref_res = "[1.00000,2.11000,0.00000;0.00000,0.00000,2.11000;0.00000,0.00000,0.00000]";

        System.out.println("myMatrix.print() result: "+myMatrix_print);
        System.out.println("reference result: "+ref_res);

        // Task 2.1
        divide_line('=');
        System.out.println("Task 2.1");

        Matrix otherMatrix = new Matrix(3, 3, "[[1.0; [(0,0)];\n [2.11;\t [(0,  1);\r (1, 2)]]");
        Matrix addResMatrix = myMatrix.add(otherMatrix);
        ref_res = "[2.00000,4.22000,0.00000;0.00000,0.00000,4.22000;0.00000,0.00000,0.00000]";

        System.out.println("myMatrix.add() result: "+addResMatrix.print());
        System.out.println("reference result: "+ref_res);

        Matrix otherMatrix2 = new Matrix(3, 3, "[[3.0; [(0,0)];\n [1.11;\t [(1,  0);\r (1, 2)]]");
        Matrix subResMatrix = myMatrix.sub(otherMatrix2);
        ref_res = "[-2.00000,2.11000,0.00000;-1.11000,0.00000,1.00000;0.00000,0.00000,0.00000]";

        System.out.println("myMatrix.sub() result: "+subResMatrix.print());
        System.out.println("reference result: "+ref_res);

        // Task 2.2
        divide_line('=');
        System.out.println("Task 2.2");

        myMatrix = new Matrix(3, 3, "[[1.0; [(0,0)];\n [2.11;\t [(0,  1);\r (1, 2)]]");
        otherMatrix = new Matrix(3, 3, "[[3.0; [(0,0)];\n [1.11;\t [(1,  0);\r (1, 2)]]");
        Matrix mulResMatrix = myMatrix.mul(otherMatrix);
        ref_res = "[5.34210,0.00000,2.34210;0.00000,0.00000,0.00000;0.00000,0.00000,0.00000]";

        System.out.println("myMatrix.mul() result: "+mulResMatrix.print());
        System.out.println("reference result: "+ref_res);

        double otherScalar = 2.3;
        Matrix mulResMatrix2 = myMatrix.mul(otherScalar);
        ref_res = "[2.30000,4.85300,0.00000;0.00000,0.00000,4.85300;0.00000,0.00000,0.00000]";

        System.out.println("myMatrix.mul() result: "+mulResMatrix2.print());
        System.out.println("reference result: "+ref_res);

        // Task 2.3
        divide_line('=');
        System.out.println("Task 2.3");

        otherScalar = 2.3;
        Matrix divResMatrix = myMatrix.div(otherScalar);
        ref_res = "[0.43478,0.91739,0.00000;0.00000,0.00000,0.91739;0.00000,0.00000,0.00000]";

        System.out.println("myMatrix.div() result: "+divResMatrix.print());
        System.out.println("reference result: "+ref_res);

        // Task 2.4
        divide_line('=');
        System.out.println("Task 2.4");
        myMatrix = new Matrix(3, 3, "[[1.0; [(0,0)];\n [2.11;\t [(0,  1);\r (1, 2)]]");

        System.out.println("myMatrix.eq() result: "+myMatrix.isEq(myMatrix));
        System.out.println("reference result: "+true);

        // Task 2.5
        divide_line('=');
        System.out.println("Task 2.5");

        myMatrix = new Matrix(3, 5, "[[1.0; [(0,0)];\n [2.11;\t [(0,  1);\r (1, 2)]]");
        Matrix myMatrix_transpose = myMatrix.transpose();
        ref_res = "[1.00000,0.00000,0.00000;2.11000,0.00000,0.00000;0.00000,2.11000,0.00000;0.00000,0.00000,0.00000;0.00000,0.00000,0.00000]";

        System.out.println("myMatrix.transpose() result: "+myMatrix_transpose.print());
        System.out.println("reference result: "+ref_res);

        // Task 3
        divide_line('=');
        System.out.println("Task 3");

        myMatrix = new Matrix(3, 5, "[[1.0; [(0,0)];\n [2.11;\t [(0,  1);\r (1, 2)]]");
        Matrix myMatrix_getElements1 = myMatrix.getElements(1);
        ref_res = "[0.00000,0.00000,2.11000]";

        System.out.println("myMatrix.getElements(int) result: "+myMatrix_getElements1.print());
        System.out.println("reference result: "+ref_res);

        String myMatrix_getElements2 = myMatrix.getElements(1,2);
        ref_res = "2.11000";

        System.out.println("myMatrix.getElements(int, int) result: "+myMatrix_getElements2);
        System.out.println("reference result: "+ref_res);

        myMatrix = new Matrix(3, 5, "[[1.0; [(0,0)];\n [2.11;\t [(0,  1);\r (1, 2)]]");
        otherMatrix = new Matrix(1, 5, "[[1.1; [(0, 1)]]; [2.2; [(0, 0)]]; [3.3; [(0, 2)]]]");
        myMatrix.setElements(1, otherMatrix);
        ref_res = "[1.00000,2.11000,0.00000,0.00000,0.00000;2.20000,1.10000,3.30000,0.00000,0.00000;0.00000,0.00000,0.00000,0.00000,0.00000]";

        System.out.println("myMatrix.setElements(int, other) result: "+myMatrix.print());
        System.out.println("reference result: "+ref_res);

        myMatrix = new Matrix(3, 5, "[[1.0; [(0,0)];\n [2.11;\t [(0,  1);\r (1, 2)]]");
        double other = 3.333;
        myMatrix.setElements(2, 3, other);
        ref_res = "[1.00000,2.11000,0.00000,0.00000,0.00000;0.00000,0.00000,2.11000,0.00000,0.00000;0.00000,0.00000,0.00000,3.33300,0.00000]";

        System.out.println("myMatrix.setElements(int, int, other) result: "+myMatrix.print());
        System.out.println("reference result: "+ref_res);

    }
}
