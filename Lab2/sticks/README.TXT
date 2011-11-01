PROJECT TITLE: Sticks
PURPOSE OF PROJECT: Learning to code getters and setters and interacting with objects
VERSION or DATE: 1.0
HOW TO START THIS PROJECT: Run from BlueJ as it lacks a main driver
AUTHORS: Daniel Kvist, Martin Augustsson
USER INSTRUCTIONS: Play the game! You are allowed to take one or two sticks out of the pile. Have fun :D



Kommentarer till ändringar


Vi har genomfört de föreslagna ändringarna. Vi har dock några kommentarer kring dem:

1. Anledningen till att vi kommenterat bort sticks.newGame() var helt enkelt att den aldrig används. 
Naturligtvis skulle vi tagit bort den helt för att inte skräpa ner koden. 
Vi tyckte dock att det var konstigt att man skulle implementera den metoden utan att använda den.

2. Den strategi som föreslås är inte en optimal vinnande strategi. 
Enligt den föreslagna strategin så skall ComputerPlayer vid 5 pinnar kvar ta 2 st. 
Det medför att det är 3 kvar i högen och HumanPlayer kan då enkelt ta 2 pinnar för att 
tvingar ComputerPlayer att ta den sista. Om ComputerPlayer istället tar 1 pinne när det finns
5 kvar i högen så tvingas HumanPlayer att ta pinnar så att det efter HumanPlayers move() finns 2 
eller 3 pinnar kvar i högen. Då kan ComputerPlayer lätt vinna genom att ta 1 eller två pinnar beroende 
på om det är 2 eller 3 pinnar kvar.

Enligt den föreslagna strategin skall man även ta 2 pinnar när det bara finns en pinne kvar, 
det skapar ett specialfall.

Strategiproblematiken och specialfallet med en pinne kvar gjorde att uppgiften var svår att tolka och 
genomföra på det sätt ni önskar.

Hoppas dock att det är ok nu, vi räknar fortfarande upp specialfallet då det finns en pinne kvar 
men kör annars en "sticks.sticksLeft() % 2" lösning.
