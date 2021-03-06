README.md
Opdrachtbeschrijving
Inleiding
    Je bent net begonnen als developer bij een bedrijf dat TV's verkoopt: Tech It Easy. Tijdens de cursus Spring Boot ga 
    jij een backend applicatie programmeren voor het bedrijf. De winkel heeft een inventaris van televisies die moet worden 
    bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen door middel van de huiswerkopdrachten. 
    Zo krijg je stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde van de cursus zullen 
    we een werkende Tech It Easy backend applicatie hebben!

Recap van vorige opdracht
    Je hebt inmiddels je applicatie draaiende gekregen. Dit geeft je de mogelijkheid om in een database bij te houden 
    welke tv's er zijn in de inventaris van TechItEasy. Als je de benamingen hebt aangehouden die we tot nu toe hebben 
    gebruikt, kunnen we een data.sql gaan maken waardoor we gegevens in de database kunnen zetten. Dit is een soort van 
    pre-fill van je database.

Opdrachtbeschrijving
    In deze opdracht ga je aan de slag met het toevoegen van relaties aan je applicatie.

Randvoorwaarden
    De opdracht moet voldoen aan de volgende voorwaarden:

Het project bevat de volgende Models:

    [v] Television
    [v] RemoteController met de variables: 
        [v] -Long id 
        [v] -String compatibleWith 
        [v] -String batteryType 
        [v] -String name 
        [v] -String brand 
        [v] -Double price 
        [v] -Integer originalStock
    [v] CI-Module met de variables: 
        [v] -Long id 
        [v] -String name 
        [v] -String type 
        [v] -Double price
    [v] WallBracket met de variables: 
        [v] -Long id 
        [v] -String size 
        [v] -Boolean ajustable 
        [v] -String name 
        [v] -Double price 
    [v] Voor elk van deze modellen bevat je applicatie ook een 
        [v] Repository, 
        [v] Controller, 
        [v] Dto, 
        [v] InputDto
        [v] Service.

Daarnaast bevat het project:

    [v] Een OneToOne relatie tussen Television en RemoteController
    [v] Een OneToMany relatie tussen Television en CI-Module
    [v] Een ManyToMany relatie tussen Televisionen WallBracket

Belangrijk:

    [v] Je mag de constructors uit de modellen weglaten. Deze vult Spring Boot automatisch in als ze niet gedefinieerd 
        zijn. Ook uit de Television mogen de constructors verwijderd worden.

Stappenplan
    Let op: het is uitdagender om jouw eigen stappenplan te maken. Mocht je niet zo goed weten waar je moet beginnen, 
    kun je onderstaand stappenplan volgen:

    [v] 1. Maak in de map Models een klasse aan voor RemoteController, CI-Module en WallBracket (voeg de juiste annotatie,
        variables, getters&setters en constructors toe).
    [v] 2. Maak in de map Repositories voor elk model een Repository aan (die elk de JpaRepository extends bevat).
    [v] 3. Maak in de map Controllers voor elk model een Controller aan (met juiste annotatie, @Autowired en 
        requestMappings).
    [v] 4. Maak in de map Dtos voor elk model een Dto en InputDto aan (met juiste variables en toewijzingen).
    [v] 5. Maak in de map Services voor elk model een Service aan (met juiste annotatie, @Autowired en functions).
    [v] 6. Leg een OneToOne relatie tussen 
            [v] Television en RemoteController 
            [v] door in beide models @OneToOne toe te voegen, 
            [v] gevolgd door het model waar de relatie mee ligt in de vorm van Model object (bijvoorbeeld Television television) 
                op de volgende regel.
    [v] 7. Een OneToOne relatie heeft een eigenaar nodig. 
            [v] Maak de Television eigenaar door in RemoteController 
            [v] achter de @OneToOne mappedBy toe te voegen op deze manier _@OneToOne(mappedBy = "remotecontroller").
            [v] Dit zorgt ervoor dat in de Television tabel een kolom wordt toegevoegd met de naam remotecontroller_id. 
            [v] Vergeet niet de getter en setter toe te voegen na het leggen van de relatie in de modellen.
    [v] 8. Om deze kolom te vullen zal je in servicelaag ook een functie moeten maken die een koppeling maakt tussen de 
                Television en de RemoteController. Dit doe je in de TelevisionService.
    [v] 9.  [v] Voeg de functie "assignRemoteControllerToTelevision" toe in de TelevisionService. 
            [v] Zoals je ziet, herkent de TelevisionService de RemoteControllerRepository niet, dit komt omdat we deze 
                nog niet gekoppeld hebben met een @Autowired, gelukkig hoef je niet alles opnieuw te doen. 
            [v] Je kan bovenaan in de TelevisionService onder de private TelevisionRepository een private 
                RemoteControllerRepository declareren. 
            [v] En dan in de bestaande @Autowired deze toevoegen op dezelfde manier als de TelevisionRepository. 
            [v] Dit resulteert in: @Autowired public TelevisionService (TelevisionRepository televisionRepository, 
                RemoteControllerRepository remoteControllerRepository){ this.televisionRepository = televisionRepository;
                this.remoteControllerRepository = remoteControllerRepository;}
    [v] 10. [v] Om deze functie uit te kunnen voeren moet je in de TelevisionController een PutRequest maken 
            [v] met endpoint"/televisions/{id}/remotecontroller" om aan te spreken. 
                Voeg deze toe en 
                    [v] geef de televisionId mee als @PathVariable 
                    [v] en de remoteControllerId als @RequestBody 
                    [v] door middel van een IdInputDto input.
    [v] 11.Hiervoor missen we nog de IdInputDto. 
        [v] Maak in het mapje Dtos een nieuwe klasse aan voor de IdInputDto.
        [v] Declareer in deze dto een public Long id toe, meer hoeft er niet in.
    [v] 12.Gefeliciteerd, je hebt zo juist de eerste relatie gelegd in je applicatie!
    [v] 13.Alleen als je nu met een get alle Televisions ophaalt, zie je geen RemoteController. Dit komt omdat we in de
        TelevisionDto nog niks hebben verteld over de RemoteController. De makkelijkste manier om hier de connectie te 
        leggen is de 
        [v]public RemoteControllerDto remoteController; toe te voegen aan de variabele van de TelevisionDto
    [] 14.Test alle functies die je tot nu toe hebt gemaakt met Postman.
        [v] Get all request Werkt!
        [v] Find by id request Werkt!
        [v] Find by name request Werkt!
        [v] Update request Werkt!
        [v] Delete request Werkt!

        [v] Assign OneToOne relatie tussen Television en RemoteController request Werkt!
        [v] Assign OneToMany relatie tussen Television en CI-Module request Werkt!
        [] Assign ManyToMany relatie tussen Televisionen WallBracket request Werkt!

Bonusopdrachten
    In deze opdracht heb ik een relatie uitgelegd aan de hand van het stappenplan. 
    Als je hier makkelijk doorheen gaat, mag je ook de:

        [v] one to many relatie maken tussen Television en CIModule. 
        [v] Hierbij is het nodig dat meerdere tv's ????n ci-module kunnen hebben. 
        [v] Als zelfs de one to many redelijk eenvoudig voor je is, mag je een
            [v] many to many relatie leggen tussen Television en WallBracket. 
            [v] Dus meerdere tv's kunnen meerdere wallbrackets hebben en andersom.