# Slot Game
<h2>How to use it</h2>
This is a slot game development developed with openjdk23. Therefore, you must have JavaRE23 in order to run it. And at least JDK23 in order to compile. Bellow you can find the commands needed to do so:

<b>Without Maven:</b>
javac MyProgram.java to compile.
java MyProgram to run.

<b>With Maven:</b>
mvn clean compile to compile.
mvn exec:java -Dexec.mainClass="com.example.MyProgram" to run.

<hr/>

## Introduction and theoretical approach
The idea is to build a 5x3 array with 04 different symbols, in our case 0 1 2 3 4, holding the same probability of ocupying the spots. Every row is a payline, same for diagonal and reverse diagonal. A win 
is achieved when at least 3 consecutive matching symbols are found in a payline. 


### Assumption
1. In order to minimaxe mathematics, I will consider every row element independent, which is not true for the diagonals. 

2. Java random is a true random generator, without any odds.
   

## Theoretical calculation
## The theoretic win probability is given by:

Probability to lose 5 times in a row =  Ploss;

Pwin = 1- Ploss;

## The theoretic win probability for one line:

Consider the following 5 spots:  __ __ __ __ __ 

The total amount of arrangement with the 4 symbols we can get is calculated by: <u> 4</u>x<u> 4</u>x<u> 4</u>x<u> 4</u>x<u> 4</u>  = 1024

However, we are only interested in the ones that have a sequence of at least 3.

An easy way to think about it is by considering the sequence as a single symbol rather than 3 different:  __ __ __ 

That simplify a lot, so we have as a result: 4 x 4 x 4 = 64 win situations. 

Pwin_1Line = 64/1024 = 0.0625

## The theoretic losing probability for one line: 

Pline_loss= 1-0.625 = 0.9375

Ploss = (Pline_loss)^5 = 0.724

## Theoretical win chances: 

✅<b>Pwin%<b> = (1 - 0.724)*100 =  <b>27.50%<b>
 
 <hr/>
 <hr/>

 
### Sad Reality    <p>😞</p>
After running 10 000 times, the following results were found:
![image](https://github.com/user-attachments/assets/e8cc6235-8d30-41d4-b23a-9f4a06cf496d)

<b>RT<b> = gain/bets = 121.45%
<hr/>
<b>Total wins<b>: 3127
<hr/>
<b>Win%<b> = 31%

### Conclusion
The discrepancy observed can be explained by the assumptions considered. Thus, code issues, possibly creating some bias. 


