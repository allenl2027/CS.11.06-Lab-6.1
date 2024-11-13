import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer=challengeOne("inputOneTwo.txt");
        int challengeTwoAnswer=challengeTwo("inputOneTwo.txt");
        int challengeThreeAnswer=challengeThree("inputThreeFour.txt");
        int challengeFourAnswer=challengeFour("inputThreeFour.txt");
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int sum=0;
        int []tot=readFile("testInputOneTwo.txt");
        for(int i=0;i<tot.length-1;i++)
        {
            if(tot[i+1]>tot[i]) sum++;
        }
        return sum;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int sum=0;
        int []tot=readFile("testInputOneTwo.txt");
        for(int i=0;i<tot.length-3;i++){
            if(tot[i+3]>tot[i]) sum++;
        }
        return sum;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] commands=readFile2("testInputThreeFour.txt");
        int hPos=0;
        int depth=0;
        for(String c:commands){
            String[] parts = c.split(" ");
            int temp=Integer.parseInt(parts[1]);
            if(parts[0].equals("forward")) hPos+=temp;
            else if(parts[0].equals("up")) depth-=temp;
            else if(parts[0].equals("down")) depth+=temp;
        }
        return hPos*depth;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] commands=readFile2("testInputThreeFour.txt");
        int hPos=0;
        int depth=0;
        int aim=0;
        for(String c:commands) {
            String[] parts = c.split(" ");
            int temp=Integer.parseInt(parts[1]);
            if(parts[0].equals("up")) aim-=temp;
            else if(parts[0].equals("down")) aim+=temp;
            else if(parts[0].equals("forward")) {
                hPos+=temp;
                depth+=(temp*aim);
            }
        }
        return hPos*depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static String[] readFile2(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] commands = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            commands[index++] = scanner.nextLine();
        }
        scanner.close();
        return commands;
        }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }
}

