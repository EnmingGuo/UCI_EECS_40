package Matrix;

public class Matrix {

    // self-defined attributes
    // feel free to define your self-defined attributes here
    private double [][] matrix;


    // self-defined utils functions
    // feel free to define and implement your self-defined utils functions/methods here



    // Task 1.1: Load the matrix in
    public Matrix(int m, int n, String expr) {
        matrix=new double[m][n];
        if(expr.length()==0)
            return ;
        String tmp= expr.replace(" ","");
        tmp=tmp.replace("\n","");
        tmp=tmp.replace("\r","");
        tmp=tmp.replace("\t","");
        tmp=tmp.substring(2);
        tmp=tmp.substring(0,tmp.length()-2);
        // System.out.println(tmp);
        String [] splitt=tmp.split("];\\[");
        for(int i=0;i< splitt.length;i++){
            String [] inner_split=splitt[i].split(";",2);
            double value=Double.valueOf(inner_split[0].toString());
            inner_split[1]=inner_split[1].replace("[","");
            inner_split[1]=inner_split[1].replace("]","");
            String [] pair=inner_split[1].split(";");
            for(int j=0;j<pair.length;j++){
                pair[j]=pair[j].replace("(","");
                pair[j]=pair[j].replace(")","");
                String [] pair_num=pair[j].split(",");
                matrix[Integer.parseInt(pair_num[0])][Integer.parseInt(pair_num[1])]=value;
            }
        }
        //System.out.println("hahah");
    }


    // Task 1.2: print the matrix out
    public String print() {
        String ans="[";
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                ans+=String.format("%.5f",matrix[i][j]);
                if(j==matrix[i].length-1){
                    if(i!=matrix.length-1)
                        ans+=";";
                }
                else
                    ans+=",";
            }
        }
        return ans+"]";
    }


    // Task 2.1 Matrix Addition and Subtraction
    public Matrix add(Matrix other){
        for(int i=0;i<other.matrix.length;i++){
            for(int j=0;j<other.matrix[i].length;j++){
                other.matrix[i][j]+=this.matrix[i][j];
            }
        }
        return other;
    }

    public Matrix sub(Matrix other){
        for(int i=0;i<other.matrix.length;i++){
            for(int j=0;j<other.matrix[i].length;j++){
                other.matrix[i][j]=this.matrix[i][j]-other.matrix[i][j];
            }
        }
        return other;

    }


    // Task 2.2: Matrix Multiplication
    public Matrix mul(Matrix other){
        Matrix tmpMatrix = new Matrix(this.matrix.length,other.matrix[0].length, "");
        for(int i=0;i<tmpMatrix.matrix.length;i++){
            for(int j=0;j<tmpMatrix.matrix[i].length;j++){
                for(int t=0;t<this.matrix[i].length;t++){
                    tmpMatrix.matrix[i][j]+=this.matrix[i][t]*other.matrix[t][j];
                }
            }

        }
        return tmpMatrix;
    }

    public Matrix mul(double other){
        Matrix tmpMatrix = new Matrix(this.matrix.length,this.matrix[0].length, "");
        for(int i=0;i<this.matrix.length;i++){
            for(int j=0;j<this.matrix[0].length;j++){
                tmpMatrix.matrix[i][j]=this.matrix[i][j]*other;
            }
        }
        return tmpMatrix;
    }


    // Task 2.3: Matrix Scalar Division
    public Matrix div(double other){
        Matrix tmpMatrix = new Matrix(this.matrix.length,this.matrix[0].length, "");
        for(int i=0;i<this.matrix.length;i++){
            for(int j=0;j<this.matrix[0].length;j++){
                tmpMatrix.matrix[i][j]=this.matrix[i][j]/other;
            }
        }
        return tmpMatrix;

    }


    // Task 2.4: Matrix Equalization
    public boolean isEq(Matrix other){
        boolean ans=true;
        for(int i=0;i<other.matrix.length;i++){
            for(int j=0;j<other.matrix[i].length;j++){
                if(this.matrix[i][j]!=other.matrix[i][j])
                    ans=false;
            }
        }
        return ans;
    }

    // Task 2.5: Matrix Transpose
    public Matrix transpose(){
        Matrix tmpMatrix = new Matrix(this.matrix[0].length,this.matrix.length, "");
        for(int i=0;i<this.matrix.length;i++){
            for(int j=0;j<this.matrix[0].length;j++){
                tmpMatrix.matrix[j][i]=this.matrix[i][j];
            }
        }
        return tmpMatrix;
    }


    // Task 3: Matrix indexing
    public Matrix getElements(int row_num) {
        Matrix tmpMatrix = new Matrix(1,this.matrix[0].length, "");
        for(int j=0;j<tmpMatrix.matrix[0].length;j++){
            tmpMatrix.matrix[0][j]=this.matrix[row_num][j];
        }
        return tmpMatrix;
    }

    public String getElements(int row_num, int col_num) {
        return String.format("%.5f",this.matrix[row_num][col_num]);
    }

    public void setElements(int row_num, Matrix other) {
        for(int i=0;i<this.matrix[row_num].length;i++){
            this.matrix[row_num][i]=other.matrix[0][i];
        }
    }

    public void setElements(int row_num, int col_num, double other){
        this.matrix[row_num][col_num]=other;
    }
}
