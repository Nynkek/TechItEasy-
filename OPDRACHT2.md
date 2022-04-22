Opdrachtbeschrijving Model/Repository
Inleiding
Je bent net begonnen als developer bij een bedrijf genaamd Tech It Easy, dat TV's verkoopt. Tijdens de cursus 
Spring Boot ga jij een backend applicatie voor hen programmeren. De winkel heeft een inventaris van televisies 
die moet worden bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen in de vorm van 
huiswerk. Zo krijgen we stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde 
van de cursus zullen we een werkende Tech It Easy backend hebben!

Recap van vorige opdracht
Je hebt de vorige les een begin gemaakt voor de applicatie voor je werkgever TechItEasy. Je hebt een controller 
aangemaakt met verschillende endpoints. Deze kunnen aangeroepen worden via een frontend. Jij maakt hiervoor gebruik 
van Postman. Omdat we niet weten of alles bestaat wat de gebruiker opvraagt heb je ook een exception controller gemaakt 
en een RecordNotFound exception. Na een nieuwe les Spring boot ben je klaar voor de volgende stap van het bouwen van 
je applicatie.

Randvoorwaarden
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Models;
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Repositories;
    [v] Het project bevat een Television in de map Models;
    [v] Het project bevat een TelevisionRepository;

Het project bevat de volgende dependencies:
        [v] Spring Web
        [v] Spring Data Jpa
        [v] PostgreSQL Driver
        [v] De Application.properties bevat de properties uit hoofdstuk 9.2 van de cursus Spring Boot(met aangepaste namen)
        [v] De TelevisionRepository extends JpaRepository met de juiste parameters

De Television bevat: -de attributen:
    [v] Long id (incl. annotaties id en generatedValue)
    [v] String type
    [v] String brand
    [v] String name
    [v] Double price
    [v] Double availableSize
    [v] Double refreshRate
    [v] String screenType
    [v] String screenQuality
    [v] Boolean smartTv
    [v] Boolean wifi
    [v] Boolean voiceControl
    [v] Boolean hdr
    [v] Boolean bluetooth
    [v] Boolean ambiLight
    [v] Integer originalStock
    [v] Integer sold
    [v] default constructor
    [v] constructor
    [v] alle getters en setters

Belangrijk
    Bij het inleveren van deze opdracht is deze applicatie nog niet functioneel, hier hebben we meer kennis over 
    andere technieken voor nodig.
    Laat de application.properties overeenkomen met de gegevens van PgAdmin

Je mag de volgende return fragmenten gebruiken:
    [] ResponseEntiteit.ok()
    [] ResponseEntiteit.created()
    [] ResponseEntiteit.noContent()

Door het gebruik van deze return fragmenten zul je de volgende foutmeldingen tegenkomen:

incompatible types found
created .... cannot be applied to () Deze mag je negeren tijdens het maken van deze opdracht.

Stappenplan
    Let op: het is uitdagender om jouw eigen stappenplan te maken. Mocht je niet zo goed weten waar je moet 
    beginnen, kun je onderstaand stappenplan volgen:

    [v] Voeg de benodigde dependencies toe aan je POM.xml en laat Maven deze instaleren
    [v] Voeg aan de application.properties de benodigde properties toe
    [v] Maak een nieuwe database aan in PgAdmin (zorg dat de naam overeenkomt met de properties in je 
        _application.properties)
    [v] Maak een nieuwe map aan in je project voor Models
    [v] Maak een nieuwe klasse genaamd Television
    [v] Voeg de annotatie @Entity toe aan de klasse
    [v] Voeg de juiste attributen toe aan de klasse
    [v] Voeg de beide constructors toe aan de klasse
    [v] Voeg alle getters & setters toe aan de klasse
    [v] Maak een nieuwe map aan in je project voor Repositories
    [v] Voeg aan deze map een nieuwe klasse toe genaamd TelevisionRepository
    [v] Extend de repository met de JpaRepository en geef de juiste attributen mee