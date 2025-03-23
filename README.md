# Slot Game
<br/>
<h2>How to use it</h2>
This is a slot game developed with openjdk23. Therefore, you must have JavaRE23 in order to run it. And at least JDK23 in order to compile. Bellow you can find the commands needed to do so:
<br/>

<b>Without Maven:</b>
javac SlotGame.java to compile.
java SlotGame.jar to run.
<br/>
<b>With Maven:</b>
mvn clean compile to compile.
mvn exec:java -Dexec.mainClass="SlotGame.jar" to run.
<br/>
<hr/>

## Introduction and theoretical approach
The idea is to build a 3x5 array containing up 04 different symbols, in our case 0 1 2 3 4, holding the same probability of ocupying the spots. Every row is a payline, same for diagonal and reverse diagonal. An win is achieved when at least 3 consecutive matching symbols are found in a payline. 
<br/>

### Assumption
1. In order to minimize mathematics, I will consider every row element independent, which is not true for the diagonals. 
2. Java random is a true random generator, without any bias.
<br/> 

### Theoretical calculation
<br/>

### The theoretical win probability is given by:
Probability of losing 5 times in a row =  Ploss;
<br/>
Pwin = 1- Ploss;
<br/>

### The theoretical win probability for one line:
Consider the following 5 spots:  __ __ __ __ __ 
<br/>
The total amount of arrangement with the 4 symbols we can get is calculated by: <u> 4 </u>x<u> 4 </u>x<u> 4 </u>x<u> 4 </u>x<u> 4</u>  = 1024
<br/>
However, we are only interested in the ones that have a sequence of at least 3.
<br/>
An easy way to think about it is by considering the sequence as a single symbol rather than 3 different:  __ __ __ 
<br/>
That simplify a lot, so we have as a result: 4 x 4 x 4 = 64 win situations. 
<br/>
Pwin_1Line = 64/1024 = 0.0625
<br/>

### The theoretical loss probability : 
Pline_loss= 1-0.625 = 0.9375
<br/>
Ploss = (Pline_loss)^5 = 0.724
<br/>

### Theoretical overall win probability: 
<b>Pwin%<b> = (1 - 0.724)*100 =  <b>27.50%<b>

<br/>
<br/>
<hr/>
 
### Sad Reality    <p>😞</p>
After running 10 000 times, the following results were found:
![image](https://github.com/user-attachments/assets/e8cc6235-8d30-41d4-b23a-9f4a06cf496d)

<b>RT<b> = gain/bets = 121.45%
<br/>
<b>Total wins<b>: 3127
<br/>
<b>Win%<b> = 31%

<br/>
<br/>

### Conclusion
The discrepancy observed can be explained by the assumptions considered. Thus, code issues, possibly creating some bias. 


