/* Maryfrances Umeora
   mumeora
   HW 12
   Lab Times: TR 11:05-12:20
   I did not collaborate with anyone on this assignment
*/

I answered all the questions in one class.


Question 1
This question was simply to create a button. When the button is clicked, I print out "Button 1 has been clicked."


Question 2
The next move is to add a JLabel that keeps track of the number of times the button I created earlier has been pressed. 
I did this by creating an integer called but1p (BUTton1Pressed) that increases by 1 everytime Button 1 has been pressed. 
Then, I set the label's text to the new number under the actionPerformed method.


Question 3
For this one, I created another JButton with text label “Off.” Everytime the second button, the text of the button changes to “On.” Once it's clicked again, it changes back to "Off.
I used the getText() commands to find out which state the button is currently in and setText() to change it's state.


Question 4
I created another text field. This one changes the text of the label I created earlier to whatever the user types.


Question 5
This questions asks to create a JSlider that implements and uses ChangeListener, and sets a label's text to the value of the slider.
I made my slider go up to 100 and I created another label that changes to the value of the slider using slider.getValue();
Add a JSlider to your GUI. JSlider uses the ChangeListener interface for its



Question 6
Finally, I had to add two JCheckBox controls to my GUI. I labeled them "yes" and "no".
Using the ItemListener to listen for events, I haditemStateChanged method print which checkbox was changed and what its current value (checked or unchecked) is.
