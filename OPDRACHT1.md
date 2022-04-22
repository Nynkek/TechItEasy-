
Opdrachtbeschrijving
Je gaat via de Spring Boot Initialzr een project aanmaken, waarbij je gebruikmaakt van de volgende dependency:

Spring Web
Gedurende de cursus Spring Boot zal het langzamerhand duidelijk worden waarom je deze dependency nodig hebt.
Voor nu mag je dit gewoon van ons aannemen!

Randvoorwaarden
De opdracht moet voldoen aan de volgende voorwaarden:

    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Controllers;
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Exceptions;
    [v] Het project bevat een TelevisionsController;
    [v] Het project bevat een ExceptionController;
    [v] Het project bevat een RecordNotFoundException;

    [v] De TelevisionsController bevat:
    [v] een GET-request voor alle televisies
    [v] een GET-request voor 1 televisie
    [v] een POST-request voor 1 televisie
    [v] een PUT-request voor 1 televisie
    [v] een DELETE-request voor 1 televisie

De ExceptionController bevat:
    [v] een exceptionhandler

De RecordNotFoundException bevat:
    [v] een default exception
    [v] een exception met message
    
Belangrijk
    [v] Bij het inleveren van deze opdracht is de applicatie nog niet functioneel, 
        omdat we hier meer kennis over andere technieken voor nodig hebben die later in de cursus aan bod komt.

Je mag de volgende return fragmenten gebruiken:

    [v] ResponseEntiteit.ok()
    [v] ResponseEntiteit.created()
    [v] ResponseEntiteit.noContent()

Door het gebruik van deze return fragmenten zul je de volgende foutmeldingen tegenkomen:

incompatible types found
created .... cannot be applied to () Deze mag je negeren tijdens het maken van deze opdracht.
Stappenplan
Let op: het is uitdagender om jouw eigen stappenplan te maken. Mocht je niet zo goed weten waar je moet beginnen,
kun je onderstaand stappenplan volgen:

    [v] Zet een nieuw project op via Spring Boot Initialzr genaamd TechItEasy.
    [v] Maak een nieuwe map aan in je project genaamd Controllers.
    [v] Maak een nieuwe map aan in je project genaamd Exceptions.
    [v] Maak een nieuwe klasse aan in de map Controllers voor de TelevisionController.
    [v] Voorzie de klasse van de juiste annotatie.
    [v] Maak in de klasse de gevraagde requests aan met de juiste response entities.
    [v] Maak een nieuwe klasse aan in de map Controllers voor de ExceptionController.
    [v] Voorzie de klasse van de juiste annotatie.
    [v] maak in de klasse een exceptionHandler met de juiste notatie en response entitiy.
    [v] maak een nieuwe klasse aan in de map Exceptions.
    [v] Extent de klasse met de RunTimeException.
    [v] Vul de klasse aan aan de hand van het voorbeeld in hoofdstuk 5.11 van de cursus Spring Boot.