package br.pucpr.graph;

import java.util.Scanner;

public class Main {
    private static final int S1 = 0;
    private static final int S2 = 1;
    private static final int S3 = 2;
    private static final int S4 = 3;
    private static final int S5 = 4;
    private static final int S6 = 5;
    private static final int S7 = 6;
    private static final int S8 = 7;
    private static final int S9 = 8;
    private static final int S10 = 9;
    private static final int S11 = 10;
    private static final int S12 = 11;
    private static final int S13 = 12;
    private static final int S14 = 13;
    private static final int S15 = 14;
    private static final int S16 = 15;
    private static final int S17 = 16;
    private static final int S18 = 17;
    private static final int S19 = 18;
    private static final int S20 = 19;

    /**
     * Reads a train station from the console. Stops the program if enter is typed.
     * @param type Either source or destination
     * @param in The scanner to read
     * @return The read station
     */
    private static int readStation(String type, Scanner in) {
        while (true) {
            System.out.printf("%s:", type);
            var line = in.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Bye bye!");
                System.exit(0);
            }
            try {
                var station = Integer.parseInt(line);
                if (station >= 1 && station <= 20) return station-1;
            } catch (NumberFormatException _) {
            }
            System.out.println("Invalid station! Try again.");
        }
    }

    /**
     * Create the Graphland Subway System
     * (see subwaySystem.pdf file in extra folder)
     */
    private static Graph createGraph() {
        var subway = new Graph(20);
        //RED LINE
        subway.makeEdge(S1, S2, 16);
        subway.makeEdge(S2, S3, 14);
        subway.makeEdge(S3, S4, 12);
        subway.makeEdge(S4, S5, 12);
        subway.makeEdge(S5, S6, 14);

        //GREEN LINE
        subway.makeEdge(S7, S8, 15);
        subway.makeEdge(S8, S9, 11);
        subway.makeEdge(S9, S10, 13);
        subway.makeEdge(S10, S11, 16);
        subway.makeEdge(S11, S6, 15);

        //YELLOW LINE
        subway.makeEdge(S12, S8, 11);
        subway.makeEdge(S8, S2, 8);
        subway.makeEdge(S2, S15, 7);
        subway.makeEdge(S15, S16, 7);
        subway.makeEdge(S16, S17, 12);
        subway.makeEdge(S17, S18, 9);

        //BLUE LINE
        subway.makeEdge(S12, S9, 17);
        subway.makeEdge(S9, S13, 7);
        subway.makeEdge(S13, S14, 9);
        subway.makeEdge(S14, S5, 9);
        subway.makeEdge(S5, S17, 10);

        //PURPLE LINE
        subway.makeEdge(S10, S13, 11);
        subway.makeEdge(S13, S3, 13);
        subway.makeEdge(S3, S16, 11);
        subway.makeEdge(S16, S19, 13);
        subway.makeEdge(S19, S20, 12);
        return subway;
    }

    static void main() {
        var subway = createGraph();

        //Graphland Subway Terminal
        //-------------------------
        var in = new Scanner(System.in);
        System.out.println("Welcome to Graphland Subway System!");
        System.out.println("   built by Mayor Vinicius Godoy de Mendonca");
        System.out.println("   responsible engineer Henri Frederico Eberspacher");
        System.out.println("-------------------------------------------------------");

        while (true) {
            System.out.println("Please, enter your desired route. Leave the field blank to exit.");
            var source = readStation("Source", in);
            var destination = readStation("Destination", in);

            System.out.println("Fastest route:");
            subway.path(source, destination).forEach(station -> System.out.printf("%02d -> ", station+1));
            System.out.println("EXIT");
        }
    }


}
