import java.io.FileInputStream;

// Jeg har benyttet xxd i commandline for å lese den binære filen testdata.dat, og jeg ser at informasjonen er lagret
// i 8 bit sekvenser, og lest på stackoverflow for å finne hensiktsmessige måter å lese inn binærdata.
// Jeg endte med å benytte FileInputStream siden dataen er lagret som binær, kombinert med byte klassen for å løse oppgaven.
// https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html

//Oblig3 oppgaveteksten presiserer at kun Dokumentasjon/ og Oblig3_261656.java skal inkluderes, og jeg har derfor ikke inkludert testdata.dat

class Oblig3 {  //Merk at det kun står beskrevet hva denne klassen skal hete i UML diagrammet i oblig3 oppgaveteksten, ikke i tekstform noe annet sted i oppgaveteksten.
//Derfor heter denne klassen Oblig3, likt som i UML Diagrammet.
  public static void main(String[] args) throws Exception {
    Matrise matrise1 = new Matrise("testdata.dat");
    matrise1.skrivUtMatrise();
    matrise1.finnMaksSumRader();
    System.out.println(
      "\nRaden med hoyest sum er rad nr " +
      matrise1.maksSumRadNr +
      " og har sum " +
      matrise1.maksSum +
      "."
    );
  }
}

class Matrise {

  //Atributter
  private Rad[] rader;
  public int maksSum;
  public int maksSumRadNr;

  //Konstruktor
  public Matrise(String filnavn) {
    this.rader = new Rad[8]; //erklærer antallet Rad objekter i arrayet
    this.fyllRaderFraFil(filnavn);
  }

  //Metoder
  /**
   * Denne metoden tar inn et filnavn, benytter seg av en try/catch. Dersom try'en feiler vil den printe stacktracen
   * av feilen til konsoll istedenfor.
   * 
   * Dersom FileInputStream objektinstansen "fis" lar seg generere, og det er en fil med samme filnavn som definert i
   * konstruktøren til Matrise objektet, genereres en objektinstans av klassen FileInputStream og kodeblokken etter kjøres.
   * Metoden readAllBytes() benyttes for å lese alle bytes i den definerte filen til en array av byte-objekter.
   * Denne arrayen av bytes kan leses, og en nested for-loop itererer over
   * en definert mengde kolonner og rader for å lagre verdiene i byte-arrayet til de riktige (Rad)radene og kolonnene i 
   * Matrise objektinstansen.
   * For å konvertere byte verdien til en heltallsverdi før den lagres i radene, benytter jeg meg av en bitwise AND 
   * operator når byte[] lagres i verdier[] i respektive rader.
   * @param filnavn tas inn som et parameter, og videreføres fra Matrise konstruktøren når objektinstanser genereres.
   * @return Denne metoden returnerer ingenting, og er avhengig av objektinstansens atributter når den kalles.
   */
  public void fyllRaderFraFil(String filnavn) {
    try (FileInputStream fis = new FileInputStream(filnavn)) {
      int rad = 8; //tenker endre disse så for loops er
      int lengde = 8; //avhengig av fil-input for mer generelt program
      int byteIndex = 0;
      byte[] bytes = fis.readAllBytes(); //Leser hele filen inn i et array av bytes
      for (int i = 0; i < rad; i++) {
        int[] verdier = new int[lengde];
        for (int j = 0; j < lengde; j++) {
          verdier[j] = bytes[byteIndex] & 0xFF; //konverterer byte til int
          byteIndex++;
        }
        rader[i] = new Rad(verdier); //setter arrayen av verdier inn i et Rad objekt
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Denne metoden printer det arrayet som fyllRaderFraFil metoden har lest inn til minne.
   * Ved å iterere over alle Rad objektene i objekt-arrayet, og alle int-verdier i hver Rad objekts verdier-array i
   * en nested for loop så printes alle heltallsverdier til en visuell representasjon av 8x8 arrayet på konsollen.
   * Etter den har printet alle heltallsverdiene i en Rad, printes en ny tom linje før heltallsverdiene i neste Rad printes.
   * @param void Denne metoden har ingen innargumenter, og er avhengig av objektinstansens atributter.
   * @return Denne metoden returnerer ingenting, og printer kun via statiske metoder og objektinstansens atributter til konsoll.
   */
  public void skrivUtMatrise() {
    System.out.println("Innlest array blir: \n");
    for (Rad rad : rader) { //for hvert Rad objekt i matrise Rad-arrayet
      for (int value : rad.verdier) { //for hver int verdi i rad-objekt atributt arrayet
        System.out.print(value + " "); //legger til mellomrom for lesbart array likt obligteksten
      }
      System.out.println();
    }
  }

  /**
   * Denne metoden itererer over alle Rad objektene i sitt array "rader" av Rad objekter, og kaller metoden beregnSum()
   * med en aritmetisk operator i en if statement for å iterativt sammenligne summen av hver Rad instans, og beholde den
   * som gir den høyeste verdien. Den setter så maksSumRadNr lik indeksen som returnerte den høyeste verdien, pluss 1
   * så radnummeret gir intuitivt mening i den printede NxM matrisen i konsollen.
   * @param void Denne metoden har ingen innargumenter, og er avhengig av objektinstansens atributter.
   * @return Denne metoden returnerer maksSum, men setter både maksSum og maksSumRadNr i objektinstansen uavhengig av 
   * denne return-statementen.
   */
  public int finnMaksSumRader() {
    int indeks = 0;
    this.maksSumRadNr = 0;
    this.maksSum = 0;
    for (Rad rad : rader) {
      int sum = rad.beregnSum();
      if (sum > this.maksSum) {
        this.maksSum = sum;
        this.maksSumRadNr = indeks + 1;
      }
      indeks = indeks + 1;
    }
    return maksSum;
  }
}

class Rad {

  //Atributter
  public int verdier[];
  public int sum;

  //Konstruktor
  public Rad(int[] verdier) {
    this.verdier = verdier;
  }

  //Metoder
  /**
   * Når metoden kalles, vil den beregne summen av alle heltallsverdiene lagret i alle indeksene i sitt array.
   * For å kunne brukes komparativt i senere kall returnerer den summen av raden som en intverdi, så aritmetiske
   * operatører i if statements fungerer. 
   * Videre setter metoden den lokale atributten sum i sin objektinstans av klassen Rad lik summen av arrayet sitt.
   * @param void Denne metoden har ingen innargumenter, og er avhengig av objektinstansens atributter.
   * @return Returnerer summen av int verdier i arrayet så den kan brukes med aritmetiske operatører, men setter også
   * sum atributt verdien i objektet til denne samme verdien.
   */
  public int beregnSum() {
    for (int value : this.verdier) {
      this.sum = sum + value;
    }
    return sum;
  }
}
