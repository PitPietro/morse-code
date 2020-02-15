# Morse code - *Beta version*
Morse code implemented in Java and Kotlin whit additional demos about the library used in the project. 

## What is Morse code

The Morse code translate all the 26 alphabet letters and numbers from 0 to 9 into dots and lines
are then received in the form of two different sounds: the dot's sound is shorter then the line once.

## How the project works
In this section is explained the working of <code>JMorse.java</code> class, <code>KMorse</code>
works in the same way.<br>The Morse alphabet is stored in a bi-dimensional array of **String**
where the 1st row is filled whit all the capital letters of the alphabet("A", "B", "C", ...) and
the second 2nd row is filled whit the correspondent Morse translation (".-", "-...", "-.-.", ...).
<br>So the <code>morse</code> variable is structured like the example below.

letters | Morse 
---- | ----
A | .-
B | -...
C | -.-.

So the elements will be accessed like below:<br>
<code>morse[0][0] = A</code><br><code>morse[0][1] = .-</code><br><code>morse[1][0] = B</code><br>
<code>morse[1][1] = -...</code><br><br>The user input is stored into <code>plaintext</code>, an **ArrayList** of
**String**. **ArrayList** is used instead of **String** because the <code>JMorse</code> method *getMorseFromChar(String c)*
needs to extrapolate each letter into a String and compare it with <code>morse</code>'s 1st row strings. To avoid having
to deal with upper case or lower case letters, *fillText(String c)*'s  first step is to make the user input uppercase before
saving its value in <code>plaintext</code>.<br>The method that prints the Morse code is *printMorse()*, which calls
*getMorseFromChar(String c)* foreach letter of <code>plaintext</code>. *getMorseFromChar(String c)* check if the letter
is equal to any **String** of the <code>morse</code> 1st row. In the affirmative, returns the corresponding String of the
2nd row.

### Prerequisites

I suggest you to use [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) before clone this repository.

### Installing
To install this project just type in the terminal.<br>
<code>git clone https://github.com/PitPietro/morse-code.git</code>


## Versioning

For the versions available, see the [tags on this repository](https://github.com/PitPietro/morse-code/tags). 

## Author

* **Pietro Poluzzi** - *Full work* - [PitPietro](https://github.com/PitPietro)

See also the list of [contributors](https://github.com/PitPietro/morse-code/contributors) who participated in this project.

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc