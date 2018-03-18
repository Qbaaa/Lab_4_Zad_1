import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Month;
import java.time.Year;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Random;

public class Zad_1 {
    public static void main(String[] args) throws FileNotFoundException
    {

        String namefile = new String("imiona.txt");
        int N;

        N = countfilei(namefile);

        String[] imiona = new String[N];

        readfilei(namefile,imiona);

        N = countfilen(namefile);

        String[] nazwiska = new String[N];

        readfilen(namefile,nazwiska);


        System.out.print("Podaj iczbe z zakresu 1-100, aby wygenerowac dane personalne kobiet: ");
        Scanner in = new Scanner(System.in);

        int liczba = in.nextInt();

        if( liczba >= 1 && liczba <= 100)
        {
            writefile("szpieg.txt",liczba,imiona,nazwiska);
            System.out.println("Program zakonczyl sie pozytwnie");
        }
        else
        {
            System.out.println("Podana liczba jest NIEpoprawna.");
            System.out.println("Koniec programu.");
        }

    }




    public static int countfilei(String namefile) throws FileNotFoundException
    {
        File file = new File(namefile);
        Scanner in = new Scanner(file);

        int N = 0;
        while (in.hasNextLine())
        {
            String dane = in.nextLine();

            if( dane.charAt(dane.length()-1) == 'a' && !(dane.equals("Jarema")) )
            {
                N++;
            }
        }

        return N;
    }

    public static void readfilei(String namefile, String[] i) throws FileNotFoundException
    {
        File file = new File(namefile);
        Scanner in = new Scanner(file);
        int N=0;

        while(in.hasNextLine())
        {
            String imie = in.nextLine();

            if( imie.charAt(imie.length()-1) == 'a' && !(imie.equals("Jarema")) )
            {
                i[N] = imie;
                N++;
            }
        }
    }

    public static int countfilen(String namefile) throws FileNotFoundException
    {
        File file = new File("nazwiska.txt");
        Scanner in = new Scanner(file);
        int N = 0;

        while (in.hasNextLine())
        {
            String dane = in.nextLine();
            N++;
        }

        return N;
    }


    public static void readfilen(String namefile, String[] n) throws FileNotFoundException
    {
        File file = new File("nazwiska.txt");
        Scanner in = new Scanner(file);
        int N = 0;

        while(in.hasNextLine())
        {
            String dane = in.nextLine();
            StringTokenizer st = new StringTokenizer(dane);

            for(int j=0;st.hasMoreElements();j++)
            {
                if(j==1)
                {
                    n[N] = st.nextElement().toString();
                    N++;
                }

                st.nextElement();
            }
        }
    }

    public static void writefile(String namefile, int liczba, String[] imiona, String[] nazwiska) throws FileNotFoundException
    {
        PrintWriter write = new PrintWriter(namefile);
        Random gen = new Random();
        int N = 0;

        for (int i = 0; i < liczba; i++)
        {

            N = gen.nextInt(imiona.length);
            write.print(imiona[N] + " ");

            N = gen.nextInt(nazwiska.length);
            write.print(nazwiska[N] + " ");

            int year = gen.nextInt(1978) + 22;
            write.print(year%100);

            int month = gen.nextInt(11) + 1;

            write.printf("%02d", month);

            if (month == 1)
            {
                int day = gen.nextInt(Month.JANUARY.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 2)
            {
                int day;
                if (Year.isLeap(year))
                {
                    day = gen.nextInt(Month.FEBRUARY.maxLength())+1;
                }
                else
                {
                    day = gen.nextInt(Month.FEBRUARY.minLength())+1;
                }
                write.printf("%02d", day);
            }
            else if (month == 3)
            {
                int day = gen.nextInt(Month.MARCH.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 4)
            {
                int day = gen.nextInt(Month.APRIL.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 5)
            {
                int day = gen.nextInt(Month.MAY.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 6)
            {
                int day = gen.nextInt(Month.JUNE.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 7)
            {
                int day = gen.nextInt(Month.JULY.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 8)
            {
                int day = gen.nextInt(Month.AUGUST.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 9)
            {
                int day = gen.nextInt(Month.SEPTEMBER.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 10)
            {
                int day = gen.nextInt(Month.OCTOBER.maxLength())+1;
                write.printf("%02d", day);
            }
            else if (month == 11)
            {
                int day = gen.nextInt(Month.NOVEMBER.maxLength())+1;
                write.printf("%02d", day);
            }
            else
            {
                int day = gen.nextInt(Month.DECEMBER.maxLength())+1;
                write.printf("%02d", day);
            }

            int seria = gen.nextInt(399)+1;
            write.printf("%03d", seria);

            boolean spr = true;
            while(spr) {
                int plec = gen.nextInt(10);

                if (plec % 2 == 0)
                {
                    write.printf("%d", plec);
                    spr = false;
                }
            }

            int kontrolna = gen.nextInt(10);
            write.print(kontrolna);
            write.println();

        }
        write.close();
    }
}
