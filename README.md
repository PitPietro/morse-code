# Morse code
Morse code implemented in Java and Kotlin whit additional demos about the library used in the project.

## Table of Contents

- [What is Morse code](#what-is-morse-code)
- [Project working](#project-working)
  - [How the project worked in the CLI version](#how-the-project-worked-in-the-cli-version)
  - [GUI whit MVC](#gui-whit-mvc)
- [Used library](#used-library)
  - [ArrayList](#arraylist)
  - [File](#file)
  - [Pair](#pair)
  - [URL](#url)
- [Discussion](#discussion-about-this-project)
- [Prerequisites](#prerequisites)
- [Installing](#installing)
- [Versioning](#versioning)
- [Author](#author)

## What is Morse code

The Morse code translate all the 26 alphabet letters and numbers from 0 to 9 into dots and lines
are then received in the form of two different sounds: the dot's sound is shorter then the line once.

## Project working

### How the project worked in the CLI version 
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
2nd row and passes it as parameter to *getSoundFromMorse(String morseString)*. This method check if each character of the
string is a *line* or a *dot*, then play the right audio file. The audio files are in the *.wav* format, they are played
using <code>ClipAudioPlayer</code> class. It uses the <code>javax.sound.sampled.*</code> library as explained in
[Used library](#used-library) session.

### GUI whit MVC
After getting a lot of suggestion from the Reddit community, the project has been provided whit a Graphic User Interface
that implements the <i>ModelViewController</i> pattern. The list below show its structure:<br>
1. Model
   - MorseModel
   - SoundModel
2. View
   - MorseView
3. Controller
   - MorseController
   
Let's dive deep into the working of the GUI.<code>MorseModel</code> provide an ArrayList of Pair which couples all
the keyboard's <code>keyCode</code> whit the corresponding **Morse** code. <code>keyCode</code> is handled by the
<code>KeyListener</code> interface implemented by <code>MorseView</code> and linked to a JTextField by
<code>addKeyListener()</code> method.<code>keyCode</code> is an integer value associated with the
keyboard's key: all the keys have a different <code>keyCode</code>.<br><code>MorseController</code> has a couple of
<i>private</i> ArrayList that are set as text for a couple of label in <code>MorseView</code>. Every time a key is
pressed in the view, the model returns the **Pair** that stores the <code>keyCode</code> whit the corresponding Morse code,
then the controller stores the alphabetic value and the Morse value in the lists. The insertion is surrounded by
<code>isElement</code> method: it ignores keys like **Shift**, **Ctrl** and remove a element from the lists if the
pressed key is **Backspace**.<br><code>MorseView</code> has a couple of buttons which are provided with an **ActionListener**.
The *Open source!* button points to this **GitHub** repository by calling the <code>openProjectURL()</code> method from
the controller. The *Play morse* button calls the <code>playMorse()</code> method, which calls the *static* method
<code>playSound(String soundPath)</code> from <code>SoundModel</code>.


## Used library
The Oracle documentation is divided into different javadocs depending on the **SE** (Standard Edition) or the **JDK** (Java Development Kit) version.

### ArrayList
To use the ArrayList class, just add this line before the class declaration: <code>import java.util.ArrayList</code>. Most of the IDEs will automatically add it whenever you start implementing it in the code.
- [ArrayList - Java Platform SE 7](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)
- [ArrayList - Java Platform SE 8](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
- [ArrayList - Java Platform SE 9 & JDK 9](https://docs.oracle.com/javase/9/docs/api/java/util/ArrayList.html)

### File
The javadocs are available at:
- [File - SE 6](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)
- [File - SE 7](https://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html)
- [File - SE 8](https://docs.oracle.com/javase/8/docs/api/?java/io/File.html)

### Pair
The **Pair** class has been implemented in the *javafx* package since the version 2.2. The javadocs available are the following links:
- [Pair - JavaFX 2.2](https://docs.oracle.com/javafx/2/api/javafx/util/Pair.html)
- [Pair - JavaFX 8](https://docs.oracle.com/javase/8/javafx/api/javafx/util/Pair.html)
- [Pair - Java SE 9 & JDK 9](https://docs.oracle.com/javase/9/docs/api/javafx/util/Pair.html)
- [Pair - Java SE 10 & JDK 10](https://docs.oracle.com/javase/10/docs/api/javafx/util/Pair.html)

It is the **C++**'s [std::pair](https://docs.microsoft.com/en-us/dotnet/api/system.web.ui.pair?view=netframework-4.8)
equivalent: it simply keeps a pair of values together. 

### URL
The [URL - SE 7](https://docs.oracle.com/javase/7/docs/api/java/net/URL.html) class represents a Uniform Resource Locator,
a pointer to a "resource" on the World Wide Web. A resource can be a file or a directory, or it can be a reference to a
more complicated object, such as a query to a database or to a search engine.

## Discussion about this project
I shared this project in Reddit: [I just released on GitHub one of my first project ... !](https://www.reddit.com/r/java/comments/f55gj2/i_just_released_on_github_one_of_my_first_project/).
<br> The comments are very interesting, you may found a lot of inspiration.

## Prerequisites
I suggest you to install [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) before clone this repository.

## Installing
To install this project just type in the terminal.<br>
<code>git clone https://github.com/PitPietro/morse-code.git</code>

## Versioning
For the versions available, see the [tags on this repository](https://github.com/PitPietro/morse-code/tags). 

## Author
**Pietro Poluzzi** - [PitPietro](https://github.com/PitPietro)
<br>See also the list of [contributors](https://github.com/PitPietro/morse-code/contributors) who participated in this project.
