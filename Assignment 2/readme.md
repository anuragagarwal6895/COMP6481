# Problem Statement

## Purpose

The purpose of this Problem is to allow you practice Array Lists and Linked Lists, as well as other previous object-oriented concepts.


## Problem


Cricket is a sport palyed beween two teams comprising of eleven players each. A game is played on a field with a twenty two yard pitch at the centre of it. This game involves both teams batting and scoring runs. The team scoring more runs in a given number of balls wins the game. The game is adjudicated by two umpiers on field and a third umpire who sits in a monitoring room helps the onfield umpires with the help of technology.
There is also a match refree who monitors the conduct of all the players and makes sure the game suns smoothly.
Twenty20 is a special format of the game where each team gets to play twenty overs.


A world cup event, organised by cricket’s goerning body, the International Cricket Council (ICC), is curently being held in Australia. Twelve teams are participating and are divided into two groups of six teams each.
In the first round, each team will play a game aginst all the other teams in their respective group. Top two teams from both groups will move on into the next round to play semi-finals. Qualification of a team for the second round will depend on number of points earned (each victory gives a team two pints, and a tied game gives a team one point) and net run rate in case two or more teams are tied on the basis of points.
As an example, if India has 8 points and are above four other teams, they will move into the next round on points basis. On the contrary if England, Australia and New Zealand all have 7 points each, two teams with a higher run rate will move into the next round.


In this problem, you will design and implement a tool which will determine if a team will qualify for the second round based on points table for the respective group.
You are given few samples, containing information about teams participating in the world cup, and some requests.
Each request contains one or more team names. Your program will have to get the input through scanner and must work for inputs other than the sample input as well.
You will input this information and will produce an outcome for each team prsent in request(s). The outcome for each request could be one of the below mentioned responses where X represents the team name.<br>


a) Team X qualifies for the second round as it has more points than four other teams.<br>
b) Team X qualifies for the second round as it has a higher net run rate.<br>
c) Team X can’t qualify for the second round as it doesn’t have enough points.<br>
d) Team X can’t qualify for the second round as it doesn’t have high enough run rate.<br>


You can assume that all the teams have finished all their games for the first round and all relevant information is made available.
The information given to you may not be in any specific order (information structure for each team will be same but order in which teams are entered will not be same).


I) Create an interface named Groupable which has a single parameter boolean method
called isInTheGroup (Team T) where T is an object of type Team described below.


II) The Team class, which must implement the Groupable interface, has the following attributes: a teamID (String type), a teamName (String type), a gamesPlayed (int type), a gamesWon (int type), a games lost (int type), a netRunRate (double type), a points (int type). It is assumed that team name is always recorded as a single word (_ is used to combine multiple words). It is also assumed that no two teams can have same teamID. You are required to write implementation of the Team class.
Besides the usual mutator and accessor methods (i.e. getTeamID(), setTeamName(), etc.) class must also have the following:<br>


a) Parameterized constructor that accepts seven values and initializes the teamID, teamName, gamesPlayed, gamesWon, games lost, netRunRate, and points to these passed values;<br>
b) Copy constructor, that takes in two parameters, a Team object and a String value. The newly created object will be assigned all the attributes of the passed object, with the exception of the teamID. teamID is assigned value passed as the second parameter to the constructor. It is always assumed that this value will correspond to the unique teamID rule;<br>
c) clone() method, that will prompt a user to enter a new teamID, then creates and returns a clone of the calling object with the exception of the teamID, which is assigned the value entered by the user;<br>
d) Additionally, class should have a toString() and an equals() methods. Two teams are equal if they have the same attributes, with the exception of the teamID, which could be different.<br>
e) This class needs to implement interface from part I. The method isInTheGroup that takes in another Team object T and should return true if T is from the same group as the current team object, or vise versa; otherwise it returns false.<br>


III) The TeamList class has the following:


(a) An inner class called TeamNode. This class has the following:<br> 
  i. Two private attributes: a team object and a pointer to a TeamNode object.<br>
  ii. A default constructor, which assigns both attributes to null.<br>
  iii. A parameterized constructor that accepts two parameters, a Team object and a TeamNode object, then initializes the attributes accordingly.<br>
  iv. A copy constructor.<br>
  v. A clone () method<br>
  vi. Other mutator and accessor methods.<br>
  
(b) A private attribute called head, which points to the first node in this TeamList.<br>
(c) A private attribute called size, which always indicates the current size of the list (how many nodes are in the list).<br>
(d) A default constructor, which creates an empty list.<br>
(e) A copy constructor, which accepts a TeamList object and creates a copy of it.<br>
(f) A method called addToStart(), which accepts one parameter, an object from Team class, creates a node with that passed object, and inserts this node at the head of the list.<br>
(g) A method called insertAtIndex(), which accepts two parameters, an object from the Team class, and an integer representing an index. If the index is not valid (a valid index must have a value between zero and size-1), then the method must throw a NoSuchElementException and terminates the program. If index is valid, then the method creates a node with passed Team object and inserts this node at the given index. The method must properly handle all special cases.<br>
(h) A method called deleteFromIndex(), which accepts one int parameter representing an index. If index is not valid, method must throw a NoSuchElementException and terminate the program. Otherwise, node pointed by that index is deleted from the list. The method must properly handle all special cases.<br>
(i) A method called deleteFromStart(), which deletes the first node in the list (the one pointed by head). All special cases must be properly handled.<br>
(j) A method called replaceAtIndex(), which accepts two parameters, an object from Team class, and an integer representing an index. If index is not valid, the method simply returns; otherwise, object in list at passed index must be replaced with the object passed.<br>
(k) A method called find(), which accepts one parameter of type String representing a teamID. Method then searches the list for a teamNode with that teamID. If such an object is found, then method returns a pointer to that teamNode; otherwise, method returns null. The method must keep track of how many iterations were made before the search finally finds the team or concludes that it is not in the list.<br>
(l) A method called contains (), which accepts a parameter of type String representing a teamID. Method returns true if a team with that teamID is in the list; otherwise, the method returns false.<br>
(m) A method called equals (), which accepts one parameter of type TeamList. Method returns true if the two lists contain similar teams; otherwise, the method returns false. Recall that two Team objects are equal if they have the same values except for the teamID, which can, and is expected to be, different.<br>


IV) Now, you are required to write a public class called TournamentResults. In main() method, you must do the following:


(a) Create at least two empty lists from TeamList class(needed for copy constructor III (e)). <br>
(b) Input team information as depicted in Figure 1 to initialize one of the TeamList objects you created above. You can use the addToStart() method to insert the TeamNode objects into the list. However, the list should not have any duplicate records, so if the input has duplicate entries, your code must handle this case so that each record is inserted in the list only once.<br>
(c) Input request information and create ArrayList from the contents then iterate through each of the teams. Process each of the teams and print the outcome whether the team will move to the next round or not. A sample output for a given input is mentioned below. Again, your program must ask for the input information through console as your program will be tested against similar input information.<br>
(d) Prompt the user to enter a few teamIDs and search the list that you created from the input for these values. Make sure to display number of iterations performed.<br>
(e) Following that, you must create enough objects to test each of the constructors/ methods of your classes. The details of this part are left as open to you. You can do whatever you wish if your methods are being tested including some of the special cases. You must also test the isInTheGroup () method.<br>

<c><b> Good Luck! </b></c>
