PROJECT TITLE: Sticks
PURPOSE OF PROJECT: Learning to code getters and setters and interacting with objects
VERSION or DATE: 1.0
HOW TO START THIS PROJECT: Run from BlueJ as it lacks a main driver
AUTHORS: Daniel Kvist, Martin Augustsson
USER INSTRUCTIONS: Play the game! You are allowed to take one or two sticks out of the pile. Have fun :D



Kommentarer till �ndringar


Vi har genomf�rt de f�reslagna �ndringarna. Vi har dock n�gra kommentarer kring dem:

1. Anledningen till att vi kommenterat bort sticks.newGame() var helt enkelt att den aldrig anv�nds. 
Naturligtvis skulle vi tagit bort den helt f�r att inte skr�pa ner koden. 
Vi tyckte dock att det var konstigt att man skulle implementera den metoden utan att anv�nda den.

2. Den strategi som f�resl�s �r inte en optimal vinnande strategi. 
Enligt den f�reslagna strategin s� skall ComputerPlayer vid 5 pinnar kvar ta 2 st. 
Det medf�r att det �r 3 kvar i h�gen och HumanPlayer kan d� enkelt ta 2 pinnar f�r att 
tvingar ComputerPlayer att ta den sista. Om ComputerPlayer ist�llet tar 1 pinne n�r det finns
5 kvar i h�gen s� tvingas HumanPlayer att ta pinnar s� att det efter HumanPlayers move() finns 2 
eller 3 pinnar kvar i h�gen. D� kan ComputerPlayer l�tt vinna genom att ta 1 eller tv� pinnar beroende 
p� om det �r 2 eller 3 pinnar kvar.

Enligt den f�reslagna strategin skall man �ven ta 2 pinnar n�r det bara finns en pinne kvar, 
det skapar ett specialfall.

Strategiproblematiken och specialfallet med en pinne kvar gjorde att uppgiften var sv�r att tolka och 
genomf�ra p� det s�tt ni �nskar.

Hoppas dock att det �r ok nu, vi r�knar fortfarande upp specialfallet d� det finns en pinne kvar 
men k�r annars en "sticks.sticksLeft() % 2" l�sning.
