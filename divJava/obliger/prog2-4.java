import java.util.Arrays;
import java.util.Random;

//pre-kode for oblgi4:
class Oblig4_261656 {

    public static void main(String[] args) {

        int radLengde = 8000;

        System.out.println("Antall datapunker totalt: " + radLengde + "*" + radLengde + " = " + radLengde * radLengde);
        //tid_start:        
        long startTidGenerering = System.nanoTime();
        Matrise matrise = new Matrise(radLengde);
        //tid_stopp:
        long sluttTidGenerering = System.nanoTime();
        //tid_totalt:
        long totalTidGenerering = (sluttTidGenerering - startTidGenerering)/(1000*1000);  //divide by 1000*1000 to get milliseconds.

        System.out.println("Generering av data: " + totalTidGenerering + "ms");
        System.out.println("Generering av data: " + totalTidGenerering / 1000.0 + "sek");

            //Sekvensiell del:
        long startTidSekvensiell = System.nanoTime();
        //denne skal ta alle rader = [0-7999], dersom radLengde=8000:
        int maksSumSekvensiell = matrise.finnMaksSumRad(matrise.rader, 0, radLengde);
        long sluttTimeSekvensiell = System.nanoTime();
        long totalTidSekvensiell = (sluttTimeSekvensiell - startTidSekvensiell) / (1000 * 1000);  //divide by 1000*1000 to get milliseconds.

        System.out.println("Sekvensiell algoritme tok: " + totalTidSekvensiell + "ms");
        System.out.println("Sekvensiell algoritme tok: " + totalTidSekvensiell / 1000.0 + "sek");

        System.out.println("Maks sum av rad (sekvensiell): " + maksSumSekvensiell);

        //Parallel del:

        System.out.println("Oblig4 start");

        int antallThreads = 8; //Definerer antall tråder vi skal bruke
        int[] maksRadSumArray = new int[antallThreads];
        ArbeiderTrad[] aThread = new ArbeiderTrad[antallThreads];
        Thread[] threads = new Thread[antallThreads];
        //tid_start:
        long startTidParallell = System.nanoTime();

        for (int i = 0; i < antallThreads; i++) {
            aThread[i] = new ArbeiderTrad(matrise, i * radLengde / antallThreads, (i + 1) * radLengde / antallThreads);
            threads[i] = new Thread(aThread[i]);
            threads[i].start();
        }

        for (int i = 0; i < antallThreads; i++) {

            maksRadSumArray[i] = aThread[i].maksSumRad;
            try {
                threads[i].join();
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
        //tid_stopp:
        long sluttTidParallell = System.nanoTime();
        //tid_totalt:
        long totalTidParallell = (sluttTidParallell - startTidParallell) / (1000 * 1000);  //divide by 1000*1000 to get milliseconds.

        System.out.println("Parallell algoritme tok: " + totalTidParallell + " ms");
        System.out.println("Parallell algoritme tok: " + totalTidParallell / 1000.0 + " sek");
        System.out.println("Maks sum av rad (parallell): " + finnBesteSumFraAlleTråder(maksRadSumArray, antallThreads));

        testResultatSekvensiellParallel(finnBesteSumFraAlleTråder(maksRadSumArray, antallThreads), maksSumSekvensiell);
        System.out.println("Oblig4 ferdig");

    }

    public static void testResultatSekvensiellParallel(int sekvensieltResultat, int paralleltResultat) {
        if (sekvensieltResultat == paralleltResultat) {
            System.out.println("Test OK");
        } else {
            System.out.println("Sekvensielt resultat er ikke det samme som parallelt resultat...");
        }
    }

    public static Integer finnBesteSumFraAlleTråder(int[] maksRadSumArray, int antallThreads) {

        Integer maksVerdi = Integer.MIN_VALUE;
        for (int i = 0; i < antallThreads; i++) {
            if (maksVerdi < maksRadSumArray[i]) {
                maksVerdi = maksRadSumArray[i];
            }
        }
        return maksVerdi;
    }
}

class ArbeiderTrad implements Runnable {

    int antallThreads;
    int start;
    int stop;
    int maksSumRad;
    Matrise matrise;

    public ArbeiderTrad(Matrise matrise, int start, int stop) {
        this.start = start;
        this.stop = stop;
        this.matrise = matrise;
        this.maksSumRad = Integer.MIN_VALUE;

    }

    @Override
    public void run() {
        this.maksSumRad = this.finnMaksSumRad(matrise.rader, start, stop);
    }

    int finnMaksSumRad(Rad[] rader, int start, int stop) {
        maksSumRad = Integer.MIN_VALUE;
        for (int indeks = start; indeks < stop; indeks++) {
            rader[indeks].behandleDataForSum();
            if (maksSumRad < rader[indeks].sum) {
                maksSumRad = rader[indeks].sum;
            }
        }
        return maksSumRad;
    }

}

class Matrise {

    Rad[] rader;
    int maksSum;
    int maksSumRadNr;

    Matrise(int radLengde){
        this.rader = fyllRaderRandomInt(radLengde);
    }

    public Rad[] fyllRaderRandomInt(int lengde) {
        rader = new Rad[lengde];

        Random random = new Random();

        for (int radNr = 0; radNr < lengde; radNr++)
        {

            int[] verdi = new int[lengde];
            for (int indeks = 0; indeks < lengde; indeks++)
            {
                verdi[indeks] = random.nextInt(16);
            }
            rader[radNr] = new Rad(verdi);
        }

        return rader;

    }

    void skrivUtVerdier(){
        for(int i = 0; i < rader.length; i++){
            for(int j = 0; j < rader[i].verdier.length; j++){
                System.out.print(rader[i].verdier[j] + " ");
            }
            System.out.println();
        }
    }


    int finnMaksSumRad(Rad[] rader, int start, int stop){
        int maksRadSum = Integer.MIN_VALUE;

        for(int indeks = start; indeks <stop; indeks++) {
            rader[indeks].behandleDataForSum();

            if(maksRadSum < rader[indeks].sum){
                maksRadSum = rader[indeks].sum;
            }
        }
        return maksRadSum;
    }
}

class Rad{
    int verdier[];
    int sum;

    Rad(int[] verdier){

        this.verdier = new int[verdier.length];

        for(int indeks = 0; indeks < verdier.length; indeks++){
            this.verdier[indeks] =verdier[indeks];
        }

        this.sum = beregnSum(verdier);

    }

    int beregnSum(int[] verdier){
        int sum = 0;
        for(int indeks = 0; indeks < verdier.length; indeks++){
            sum += verdier[indeks];
        }
        return sum;
    }

    public void behandleDataForSum(){
        //Her gjøres det egentlig bare en simulering av "arbeid", som gjør at tidsforbruket stiger...

        //Gjør litt "random" work:
        Arrays.sort(verdier);

        //Gjør litt mer "random" work:
        for(int i = 0 ; i < verdier.length; i++)
        {
            verdier[i] *= 2;
        }


        for(int i = 0 ; i < verdier.length; i++)
        {
            verdier[i] += 5;
        }


        for(int i = 0 ; i < verdier.length; i++)
        {
            verdier[i] -= 1;
        }


        for(int i = 0 ; i < verdier.length; i++)
        {
            verdier[i] /= 2;
        }

        for(int i = 0 ; i < verdier.length; i++)
        {
            verdier[i] += 8;
        }


        for(int i = 0 ; i < verdier.length; i++)
        {
            verdier[i] *= 3;
        }


        for(int i = 0 ; i < verdier.length; i++)
        {
            verdier[i] -= 1;
        }


        for(int i = 0 ; i < verdier.length; i++)
        {
            verdier[i] /= 3;
        }
    }
}
