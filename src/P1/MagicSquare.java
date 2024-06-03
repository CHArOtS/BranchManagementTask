package P1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class MagicSquare {
    private static final int Size = 500;
    private static final int[][] square = new int[Size][Size];
    private static final boolean[] isAdded = new boolean[Size * Size + 1];

    /**
     * Given a relative path of file, and judge whether the matrix in targeted file is a Magic Square.
     *
     * @param fileName String, the relative paths of targeted matrix's txt file.
     * @return boolean: return true when matrix in the file is a "Magic Square"
     *                  return false when matrix is invalid and throw Error.
     */
    public static boolean isLegalMagicSquare(String fileName) throws IOException
    {
        // Read from file
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Arrays.fill(isAdded,false);

        // Verify the validity of Magic Square. m for line and n for column.
        int m = 0, n = 0, last_n = 0;
        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] nums = line.split("\t");
            n = nums.length;
            for (int i = 0; i < n; i++){
                if(!nums[i].trim().matches("[0-9]+")){
                    System.out.println("Error: Invalid number existed or Numbers not split by '\\t'");
                    System.out.println("(may be a minus number, non-Integer or contains other chars.)");
                    return false;
                }
                square[m][i] = Integer.parseInt(nums[i].trim());
                if(isAdded[square[m][i]]){
                    System.out.println("Error: Repetitive Integer Existed.");
                    return false;
                }
                else isAdded[square[m][i]] = true;
            }
            if(m != 0 && last_n != n){
                System.out.println("Error: Invalid Matrix - Void existed in certain lines or columns.");
                return false;
            }
            last_n = n;
            m++;
        }
        bufferedReader.close();

        if (m != n){
            System.out.println("Error: Invalid Matrix - column number not equal to line number.");
            return false;
        }

        // Start Calculation - Test if lines, columns or diagonals sum to a same constant.
        int sum1 = 0, sum2 = 0, std_sum, maxsize = m * n;
        for (int i = 0; i < n; i++) {
            sum1 = sum1 + square[i][i];
            sum2 = sum2 + square[n-1-i][i];
        }
        if(sum1 != sum2) {
            System.out.println("Error: Invalid Matrix - Not sum to the same constant.");
            System.out.println();
            return false;
        }
        else std_sum = sum1;

        for(int i = 0; i < m; i++) {
            sum1 = 0;
            sum2 = 0;
            for(int j = 0; j < n; j++)
            {
                sum1 = sum1 + square[i][j];
                sum2 = sum2 + square[j][i];
                // Judge whether an oversize value exist.
                if(square[i][j] > maxsize){
                    System.out.println("Error: Oversize Integer");
                    return false;
                }
            }
            if(sum1 != std_sum || sum2 != std_sum){
                System.out.println("Error: Invalid Matrix - Not sum to the same constant.");
                return false;
            }
        }
        return true;
    }

    /**
     * Given a size(number), and generate Magic Square of that size.
     * The Magic Square generated will be print to Terminal and File.
     *
     * @param n int, the size of Magic Square generated(n * n).
     *          n must be a positive odd number.
     * @return boolean: return true when Magic Square is generated and wrote in file.
     *                  return false when error exist and throw IOException.
     */
    public static boolean generateMagicSquare(int n) throws IOException
    {
        // 按照实验要求 撰写generateMagicSquare方法中代码的中文注释

        // 初始化：整型数组square 行row=0 列col=n/2
        int[][] square = new int[n][n];
        int row = 0, col = n / 2;

        /* 此方法依照法国人罗伯(do la loubere)的理论生成奇数阶幻方 具体过程是：
        1、将数字1放在首行中央的格子中(即square[0][n/2]的位置)
        2、向右上角斜行依次填入自然数2,3,4....
        3、在右上方出上边界时，以出框后的虚拟方格位置为基准将数字平移到底行对应的格中(即作row=n-1处理)
        4、与第三条同理，出右边界时，将数字平移至到左列对应的格子中(即作col=0处理)
        5、如果数字n右上方的格子已经被其他数字占据，则将n+1填写入n下方的格子中
            (在本算法中表现为每填入n个数字，row++，等效副对角线填满后下一个数字向当前格子下方填入)
        6、如果朝右上角出界，与上面重复的情况做同样的处理
        */
        for(int i = 1; i <= n * n; i++) {
            square[row][col] = i;
            if (i % n == 0) row++;
            else{
                if (row == 0) row = n - 1;
                else row --;
                if (col == n - 1) col = 0;
                else col++;
            }
        }
        // 向控制台打印生成的幻方
        for(int i = 0; i < n; i++) {
            for (int j = 0 ; j < n; j++)  System.out.print(square[i][j] + "\t");
            System.out.println();
        }
        // 借助PrintWriter对象向文件 "6.txt" 打印生成的幻方.
        PrintWriter printWriter = new PrintWriter(new File("src/P1/txt/6.txt"));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                printWriter.print(square[i][j] + "\t");
            }
            printWriter.println();
        }
        printWriter.close();
        return true;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(isLegalMagicSquare("src/P1/txt/1.txt"));
        System.out.println();
        System.out.println(isLegalMagicSquare("src/P1/txt/2.txt"));
        System.out.println();
        System.out.println(isLegalMagicSquare("src/P1/txt/3.txt"));
        System.out.println();
        System.out.println(isLegalMagicSquare("src/P1/txt/4.txt"));
        System.out.println();
        System.out.println(isLegalMagicSquare("src/P1/txt/5.txt"));
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input 'n' of generated Magic Square:");

        // Make sure n that user input is an odd number.
        int n = scanner.nextInt();
        while(n <= 0|| n % 2 == 0)
        {
            System.out.println("Wrong input: n below 0 or not an odd number.");
            System.out.print("Input again:");
            n = scanner.nextInt();
        }
        generateMagicSquare(n);
        System.out.println("Now judge matrix generated:");
        System.out.println(isLegalMagicSquare("src/P1/txt/6.txt"));
    }
}
