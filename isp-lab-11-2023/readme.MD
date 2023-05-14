# Lambdas and Stream API. Solve the following exercises:

Useful documentation:<br>
https://www.w3schools.com/java/java_lambda.asp<br>
https://stackify.com/streams-guide-java-8/

1) Have a look at <b>ExampleLambdas</b>. Design a simple meaningful application that contains at least one functional interface.
   Implement these interface(s) by using lambda expressions.

2) Run the examples from <B>ExampleStreams</b>. Implement the two methods that are not yet implemented.
   Implement the unit tests for the methods 1 to 8 in <b>ExampleStreamsTest</b>.

Implement the code and unit tests for the following exercises:

3) Given a list of strings, write a Java program to find the length of the longest string using the Java Stream API.

4) Find the sum of all even numbers in a list of integers.

5) Convert a list of strings to uppercase.

6) Group a list of words by their first letter.

7) Count the number of occurrences of a word in a text file.
   This program should read in a text file and count the number of times a given word appears in the file.
   It should use the Stream API to read in the file and count the occurrences of the word using a lambda function.
   (hint: you can use <b>Files.lines() / Files.readAllLines()</b> - what's the difference between the two?)

8) Suppose we have a class called <b>Product</b> that has the fields <b>name</b>, <b>price</b>, and <b>category</b>. We want to filter a list of 
   Product objects to include only those that are in the "Electronics" category, and then sort them by price.
   (use method <b>sorted()</b> from Stream API)

9) Suppose we have a class called <b>Order</b> that has the fields <b>id</b>, <b>total</b>, and <b>status</b>.
   We want to calculate the total revenue of all completed orders.
   (use method <b>reduce()</b> from Stream API)
   
