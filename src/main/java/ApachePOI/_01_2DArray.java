package ApachePOI;

public class _01_2DArray {
    public static void main(String[] args) {

        String[][] zoo={{"Lion","3"},{"Tiger","2"},{"Zebra","1","23"},{"Bear","4"}};

        System.out.println("_____________");
        System.out.println(zoo[2][0]);
        System.out.println(zoo[2][1]);
        System.out.println("_____________");

        for (int i = 0; i < zoo.length; i++) {
            for (int j = 0; j < zoo[i].length; j++) {

                System.out.print(zoo[i][j]+" ");

            }
            System.out.println();

        }


    }
}
