# cumass
eatmycimmies
Programmering

Vi skal fortsette med å utvide oppgaven vi lagde i Oblig 3. Du kan fortsette på din egen implementasjon, eller du kan starte fra løsningsforslaget som finnes her:

Oblig3_ProposedSolution.zip

Oblig3_ProposedSolution_InclBonus.zip

Klassediagram for det som ble laget i Oblig 3 kan finnes her: 
Kommer...

Vi skal nå se gjøre noen mindre forbedringer av koden vi har, i form av å gjøre noe abstrakt, samt implementere interface for å kunne sortere dataene våre på en fornuftig måte.

Deretter skal vi begynne på implementasjon av et webgrensesnitt til applikasjonen vår. 

 Du står fritt til å ta bort det som er av kode i Main.java (du kan altså begynne med "blanke ark" hvis du ønsker). Vi skal uansett hovedsakelig bruke Application.java.

Oppdaterte data finnes her: solar_system_data.txtPreview the documentForhåndsvis dokumentet

Oppgave 2.1 - Abstraksjon

Det er klasser vi har laget som det ikke er naturlig å lage konkrete objekter av. Hvilke er dette? Gjør så disse klassene abstrakte. 

Test at alt fortsatt fungerer etter dette.

Oppgave 2.2 - Sammenligning og sortering

Det er ofte naturlig å kunne sortere samlinger av objekter. Lag en naturlig sortering ved å implementere Comparable interfacet i klassene CelestialBody og PlanetSystem. Du velger selv hva du ser på som en naturlig sortering.

Test at du kan sortere listen med planeter du har i solsystemet vi tidligere har opprettet.

 
Grensesnitt

Dere skal nå begynne å lage kode tilpasset et webgrensesnitt. Til dette skal dere benytte rammeverket Javalin. Dere får ferdig front-end i form av .vue filer, og skal tilpasse back-end koden til denne. Dere kan tilpasse/style front end'en hvis dere ønsker, men dette er ikke nødvendig (du har ikke lov til å endre på verdiene som mottas eller lignende).

Oppgave 2.3 - Javalin og Gradle - Nytt prosjekt

 Først ønsker vi at vi skal kunne bygge prosjektet vårt ved hjelp av Gradle. Den enkleste måten å gjøre dette på er å lage ett nytt "Gradle"-prosjekt i IntelliJ. I Gradle så setter vi opp de biblioteken vi ønsker å benytte i prosjektet vårt, så legg til disse i build.gradle-filen. I dette tilfellet gjelder det javalin med tilhørende biblioteker.

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'

    compile 'io.javalin:javalin:3.7.0'
    compile 'com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9'
    compile 'org.slf4j:slf4j-simple:1.7.26'
    compile 'org.webjars.npm:vue:2.6.10'
}

Lag en fil Application.java og lag en HelloWorld versjon ved hjelp av Javalin.

Bygg og kjør prosjektet.

Oppgave 2.4 - Forberedelser

a) Lag en pakke kalt "model", og kopier inn alle .java-filene alle fra det gamle prosjektet over i det nye gradle-prosjektet (unntatt Main.java).

b) Kopier inn mappen "vue"-mappen som ligger ved her, inn under mappen "resources". Dette er front-end koden du skal lage en back-end kode i Java til.

vue_resources.zip

Se at du fortsatt kan kompilere prosjektet.

Oppgave 2.5 - Repository

Når vi henter data i en back-end, er dette ofte fra en database. Slik det er nå, har vi ingen database vi benytter, men vi ønsker fortsatt et lite abstraksjonslag mellom businesslogikken i programmet vårt, og hentingen av data.

Lag et interface som heter IUniverseRepository.java, her vil de metodene som er aktuelle for uthenting av data defineres. Lag i tillegg en klasse som heter UniverseRepository.java, som implementerer interfacet. Denne skal per nå opprette og holde på dataene vi benytte i applikasjonen vår. La denne filen ha en instansvariabel som er en ArrayList med PlanetSystem'er.

I konstruktøren oppretter du minst et planetsystem med tilhørende stjerne og planeter, og legger til i denne listen.

Definer get-metoder i interfacet og lag selve implementasjonen i klassen (vi skal utvide med flere metoder her senere):

    Hente alle planetsystemer
    Hente ett spesifikt planetsystem

Oppgave 2.6 - PlanetSystemer

I frontend har vi forskjellige views som kan vise data på forskjellige måter. Vi starter med de som omhandler planetsystemer, som er:

    /planet-systems - Lister ut planetsystemer
    /planet-systems/:planet-system-id - Viser ett spesifikt planetsystem

a) Koble opp views

For å sette opp hvilke sider som skal vises når vi går til en spesiell URL-path, så må vi konfigurere dette ved hjelp av Javalin. Sett opp get-path'er i Application.java til å peke på disse Vue-komponentene.

b) Lage Controller

Koble opp view er ikke nok til å få data til front-enden, til dette må vi sette opp et API som gjør dataene vi har tilgjengelig i et .json format. 

Front-end'en er nå satt opp til å spørre API'et via visse URL'er:

    api/planet-systems - Gir en liste med planetsystemer i .json format
    api/planet-systems/:planet-system-id - Gir ett spesifikt planetsystem i .json format

For å få dette til å fungere må vi ha to elementer på plass - en definisjon av hvert av disse endepunktene, og en Controller som bestemmer hva som skal skje ved ett kall til dette (henter korrekt data).

Lag en PlanetSystemController (gjerne i en passende pakke), med to metoder. En for å hente alle planetsystemer, og en for å hente en spesifikk. PlanetSystemController'en trenger også en referanse til UniverseRepository.

c) Koble opp API og Controller

Sett opp get-path'er til å peke på disse API-punktene, og kalle korrekte metoder i PlanetSystemController.

 

Oppgave 2.7 - Planet

Gjør det samme som du gjorde i forrige oppgave for å også kunne vise planeter. Du må:

    Utvide UniverseRepository med metoder for å hente alle planeter, og en enkelt.
    Lage en PlanetController og metoder for å hente alle planeter, og en enkelt.
    Koble opp URL-punktet til viewet:
        /planet-systems/:planet-system-id/planets/:planet-id - Viser en spesifik planet
    Koble opp API URL-punktene til å kalle PlanetController:
        /api/planet-systems/:planet-system-id/planets - Henter alle planeter i et planetsystem i .json format
        /api/planet-systems/:planet-system-id/planets/:planet-id - Henter en planet i .json format

Oppgave 2.8 - Bilder

Vi ønsker å kunne vise bilder for hver av planetene og planetsystemene vi viser i frontend'en. Utvid modellene CelestialBody og PlanetSystem med instansvariabelen "pictureUrl". Gjør de nødvendige endringene i konstruktørene nedover i hierarkiet for å kunne sette denne verdien.

Legg til noen bildereferanser når du lager objektene i UniverseRepository.

Oppgave 2.9 - Sortering

Vi ønsker å kunne sortere planetene. Legg til nødvendig funksjonalitet i PlanetController for å kunne sortere.

Du kan få tak i sorteringsparameteren ved hjelp av:

context.queryParam("sort_by");

Sorteringsparameterne som er tilgjengelig og skal kunne sorteres på er:

    ikke definert (blir vist i den rekkefølgen planetene ble laget i)
    name
    mass
    radius

 
Bonusoppgaver

Bonusoppgave 3.1

Lek med interfacet og vue-filene. Hvordan endrer du hvilken data som vises? Kan du endre stilen på visningen?

Bonusoppgave 3.2

a) Legg til "Moon" model-klasse. Hvilke klasse skal den arve fra? Hvilke andre klasser har behov for en referanse til denne klassen? Lag også muligheten for å hente ut data fra repositoriet.

b) Legg til visning av månene i view'ene. Hvor vil du legge til denne visningen?
