#Slice Coding Challenge
##Pizzabot - (Java)
###Expected Input
pizzabot 'size' 'coordinate list' <br>
	Ex. `pizzabot "5x5" "(1, 3)" "(4, 4)"`

###Expected Output
`ENNNDEEEND` <br>

###How it works
Add coordinates to an array list and bubble sort by distance from origin. <br>
Iterate through coordinate pairs and print directions. <br>
	`N: Move north` <br>
	`S: Move south` <br>
	`E: Move east`	<br>
	`W: Move west` <br>
	`D: Drop pizza` <br>

###Classes
1. Pizzabot <br>
This is the driver class. It contains 'main' and implements the entire algorithm using many helper functions.

2. Coords <br>
This is the data structure for holding an x & y pair to form a coordinate. The Pizzabot class creates an array list of Coords.
