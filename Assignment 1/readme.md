# Problem Statement


## Information:



For this part, you are required to design and implement the Voter class according to the following specifications:<br>


 A Voter object has five attributes, namely, a voterID (long), voterName (String), voterAge (byte), voterEmail (String), and voterPcode (Char []).<br>

 Upon creation of a Voter object, the object must immediately be initialized with valid default values for all the attributes. (Hint: use constructors.).<br>

 The design must allow enough flexibility so that value of any of these attributes can be modified later except the voterID. For example, one should be able to create a Voter object with a given voterEmail and then change it later. The design should also allow a user to obtain value of any attributes. (Hint: use accessors & mutators.) <br>

 The design must also allow all information of an object to be displayed at once through the System.out.print() method. (Hint: use toString() method).<br>

 It is required to know how many Voter objects have been created so far at any time. For that, you must have a method called findNumberOfCreatedVoters(), in the Voter class. This method must return number of Voter objects prior to the time this method is called. The method would return 0 if no Voters have been created by the time the method is called. (Hint: use Static – You can add other attributes to the class.).<br>

 It is required to compare two Voter objects for equality. Two Voter objects are considered equal if they have the same voterID as well as voterPcode. (Hint: use equals() method).<br>

You are hired by a Parti Québécois to write a software application that helps their staff (users) in keeping track of the Voters in every neighborhood.
Write a driver program that will contain the main() method and will perform following: (Note: You can have the main method in a separate driver file, or in the same file)<br>
 Display a welcome message.<br>
 Prompt a user for maximum number of Voters (maxVoters) his/her neighborhood can contain. Create an empty array, called voterBase, that will have the potential of keeping track of all the created Voter objects.<br>
 Display a main menu (figure 1) with the following choices and keep prompting the user until they enter a number between 1 and 5 inclusive:<br>


What do you want to do?
1. Enter new voters (password required)
2. Change information of a voter (password required)
3. Display all voters by a specific voterPcode
4. Display all voters under a certain age.
5. Quit<br>
Please enter your choice > <br>

 When option 1 is entered:<br>
 Prompt the user for his/her password. (Make sure you have a constant variable containing the password “password” – do not use any other password as it will be easier for the marker to check your assignments). The user has a maximum of 3 attempts to enter the correct password. After the 3rd wrong attempt entry, the main menu in figure 1 is re-displayed. Additionally, after this is repeated 4 times (i.e., after total 12 consecutive failed attempts), the program must display following message:
“Program detected suspicious activities and will terminate immediately!”, then the program must exit.<br>
 If correct password is entered, ask the user how many Voters he/she wants to enter. Check to make sure that there is enough space in the voterBase (array of Voters) to add that many Voters. If so, add them; otherwise inform the user that he/she can only add the number of remaining places in the array. (How the Voter information will be inputted/entered by the user, is up to you).<br>


 When option 2 is entered:<br>
 Prompt the user for a password. (Make sure you have a constant containing the password “password” as a constant – do not use another password). Again, the user has 3 attempts to enter the correct password. However, after the 3rd wrong attempt, the main menu in figure 1 is simply re-displayed. (Notice the different behaviour in that case from the previous one above).<br>
 Once the correct password was entered, the user is asked which Voter he/she wishes to update. Voter will be identified by a voterID. If there is no Voter object with the specified voterID, display a message asking the user if he/she wishes to re-enter another Voter, or quit this operation and go back to the main menu.<br>



If the entered index has a valid Voter, display the current information of that Voter in the following format:<br>
Voter: # x (index of the Voter in the voterBase array) ID: voterID of the Voter<br>
Name: voterName of the Voter<br>
Age: voterAge of the Voter<br>
Email: voterEmail of the Voter PCode: voterPcode of the Voter<br>


Then ask the user which attribute they wish to change by displaying following menu.<br>


What information would you like to change?<br>
1. Name
2. Age
3. Email
4. PCode
5. Quit<br>
Enter your choice >


Once the user has entered a correct choice, make the changes to the attribute then display again all the attributes on the screen to show that the attribute has been changed. <br>Keep prompting the user for additional changes until choice 5 is selected. Each time the user is prompted for a choice make sure that a number from 1 to 5 is entered, otherwise keep prompting until a valid number is entered. (Ensure that the user can change any of the choice 1 to 4 on figure 2).<br>


 When option 3 (in the main menu shown in figure. 1) is entered, prompt the user to enter voterPcode. You then need to display the information of all Voters residing in that postal code. (Hint: You may use a static method called findVotersBy, which accepts a long for a voterPcode and then performs the needed search).<br>
 When option 4 (in the main menu shown in figure. 1) is entered, prompt the user to enter a value (representing age). You then need to display all the Voters who are younger than the entered value. (Hint: You may use a static method, for instance called findYoungerThan, which accepts a byte value, for an age, then performs the needed search).<br>
 When option 5 (in the main menu shown in figure. 1) is entered, display a closing message, and end the driver.<br>






