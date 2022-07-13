package lesson12;

public class Main {
    public static void main(String[] args) {
        double[][] arr1 = {{1,-2,6,0,9},{5,2,-9,0,-3},{-4,-5,3,7,-1},{-7,8,-8,4,-6},{-7,3,-8,4,-6}};
        double[][] arr2 = {{2,4},{2,6},{3,5},{7,4},{2,5}};
        Matrix matrix1 = new Matrix(arr1);
        Matrix matrix2 = new Matrix(arr2);
//        for (int i=0;i<ind;i++){
//            for (int j=0;j<ind;j++){
//                matrix.setValueAt(i,j,(i+1)*(j+2));
//            }
//        }
//        matrix.fillMatrix(2.3);
        matrix1.printToConsole();
        System.out.println();
        matrix2.printToConsole();
        System.out.println();
//        matrix1.transpose().printToConsole();
        System.out.println(matrix1.determinant());
//        matrix1.add(matrix2).printToConsole();
// //       System.out.println();
//   //     matrix1.sub(matrix2).printToConsole();
//        matrix1.mul(matrix2).printToConsole();
//        System.out.println();
//        matrix1.mul(2).printToConsole();
    }
}
