Opdrachtbeschrijving
Inleiding
Je bent net begonnen als developer bij een bedrijf genaamd Tech It Easy, dat TV's verkoopt. Tijdens de cursus 
Spring Boot ga jij een backend applicatie programmeren voor het bedrijf. De winkel heeft een inventaris van televisies 
die moet worden bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen door middel van de
huiswerkopdrachten. Zo krijg je stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde 
van de cursus zullen we een werkende Tech It Easy backend applicatie hebben!

Recap van vorige opdracht
Je hebt in de vorige les de applicatie voor je werkgever TechItEasy uitgebreid met een Model en een Repository. 
Een Model is een Klasse in je project en bevat variabelen en constructors, en geven de mogelijkheid om meerdere 
objecten aan te maken in je database van deze Klasse. De Repository is verlengd met de JpaRepository, daardoor kan 
je de standaard find-functies uitvoeren in de Service die we in de komende les toevoegen aan het project. Naast de 
standaard query's die al staan in de JpaRepository kunnen we later eventueel nog query's schrijven in de Repository 
voor wat moeilijkere find functies. Maar hoe gaaf zou het zijn als het project zou kunnen draaien? Goed nieuws: na deze 
les werkt het project en geeft het de juiste response als we requests doen via Postman.

Randvoorwaarden

De opdracht moet voldoen aan de volgende voorwaarden:

    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Services;
    [v] De map Services bevat een klasse genaamd TelevisionService;
    De TelevisionService bevat:
        [v] de juiste annotatie
        [v] een private variabele TelevisionRepository
        [v] de connectie van de Service en de Repository door middel van een autowired
        [v] een functie voor het ophalen van alle Televisions
        [v] een functie voor het ophalen van 1 Television
        [v] een functie voor het verwijderen van 1 Television
        [v] een functie voor het updaten van 1 Television
    [v] De Controller is door middel van een autowired gelinkt aan de Service;
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Dtos;
    [v] De map Dtos bevat een TelevisionDto en een TelevisionInputDto;
    [v] De requestMappings in de Controller worden aangepast zodat deze de juiste response doorgeven via de Service;
    [v] De Service maakt gebruik van de gegevens die we via de Controller doorkrijgen van de Dtos;
    [v] Het project bevat de validator dependency uit paragraaf 8.1 van de cursus Spring Boot in Edhub.

Belangrijk

    [v] Na deze les moeten de requestMappings in de controller de juiste responses geven.
    [v] Na deze les is de applicatie voor het eerst functioneel.

Het is belangrijk om goed te begrijpen hoe de lagen in onze multi-tier application samenwerken:

    [v] De Controller ontvangt een verzoek op een endpoint, als er variable worden meegeven aan dit verzoek komen die 
        binnen via de TelevisionInputDto ->
    [v] De Controller geeft aan de hand van het verzoek en eventuele meegekregen variable dit door aan de Service ->
    [v] De Service spreekt aan de hand van de geschreven functie de Repository aan met de juiste find functie/query ->
    [v] De Repository gaat aan de hand van het bijbehorende Model zoeken naar de juiste gegevens en stuurt deze terug naar 
        de Service ->
    [v] De Service past de logica toe uit de functie en geeft de response aan de hand van de TelevisionDto terug aan de 
        Controller (De controller wordt vanuit de front-end of vanuit Postman aangesproken, en geeft ook het antwoord weer
        terug.)

Stappenplan

Let op: het is uitdagender om jouw eigen stappenplan te maken. Mocht je niet zo goed weten waar je moet beginnen, kun 
je onderstaand stappenplan volgen:

    [v] 1. Voeg de benodigde dependencies toe aan je POM.xml en laat Maven deze installeren.
    [v] 2. Maak een map genaamd Services aan in de map-structuur.
    [v] 3. Maak een klasse genaamd TelevisionService aan in de map Services.
    [v] 4. Voeg de Service annotatie boven de klasse toe.
    [v] 5. Maak in de TelevisionService een private variabele aan voor de TelevisionRepository.
    [v] 6. Voeg een @Autowired toe om de Repository in de TelevisionService te kunnen gebruiken.
    [v] 7. Maak in de TelevisionService de functie getTelevisions aan de hand van het voorbeeld in paragraaf 6.2 van de cursus
        Spring Boot cursus in Edhub.
    [v] 8. Doe dit ook voor de 
        [v] getTelevision, 
        [v] saveTelevision, 
        [v] updateTelevision en de 
        [v] deleteTelevision.
    [v] 9. Maak in de TelevisionController een @Autowired om de Service te kunnen gebruiken in de Controller.

    [v] 10. Maak in het project een map aan genaamd Dtos.
    [v] 11. Maak in deze map een klasse aan genaamd TelevisionDto.
    [v] 12. Definieer in deze klasse alle variabele die een Television object bevat (dezelfde als in het model gedefinieerd 
        staan).
    [v] 13. Maak daaronder een public static functie aan genaamd fromTelevision. Deze heeft als returnwaarde TelevisionDto en 
        als attribuut Television television.
    [v] 14. Maak in deze functie een var dto = new TelevisionDto();.
    [v] 15. Voeg in de functie voor iedere variable, die je boven deze functie hebt gedeclareerd een toewijzing naar de dto 
        variable (bijvoorbeeld: dto.name = television.getName(); ).
    [v] 16. Return als laatste stap in deze functie het dto object en sluit de functie af.
    [v] 17. Maak een klasse aan in de map Dtos genaamd TelevisionInputDto.
    [v] 18. Definieer ook in deze klasse alle variabelen die een Television object bevat.
    [v] 19. Maak een public functie genaamd toTelevision() met returnwaarde Television.
    [v] 20.Maak in deze functie een var television = new Television();.
    [v] 21. Voeg in de functie voor iedere variable, die je boven deze functie hebt gedeclareerd, een toewijzing naar de 
        television variabele (bijvoorbeeld: television.setName(name); ).
    [v] 22. Pas de RequestMappings in de TelevisionController, zodat de controller het verzoek doet aan de servicelaag en het
        response ook ontvangt van de servicelaag (dit is omdat we de Controller eigenlijk zo dom mogelijk willen houden).
    [v] 23. Pas de servicelaag zo aan dat deze gebruikmaakt van de gegevens die de controllerlaag doorgeeft. De Service moet
        hier dan de logica aan toepassen om met gebruik van de Dtos een returnwaarde terug te kunnen sturen naar de 
        controller.