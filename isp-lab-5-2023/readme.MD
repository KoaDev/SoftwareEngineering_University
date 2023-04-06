# Implement the following exercises

In this lab you will create small Java applications by using as reference an UML class diagram. Please consider following general notes before start implementing:
- toString() method when required will return a string like *ClassName{attributeName1=attributeValue1,...,attributeNamen=attributeValuen}*.
- add any constructors, getter, setters or other methods you consider are required even if are not explicitly presented in the diagrams.
- Do not reuse (import) the same class in multiple exercises. **Each exercise is standalone and should be resolved in its package.**

## Lab instructions

For all bellow exercises:
1. Create Java application based on the provided UML class diagram
2. Create main method and create some objects to demonstrate the functionality 
3. Create a minimal unit test for testing the behavior of the created class.

## Exercise 1
![Exercise 1 image](docs/Ex1.jpg)

Given the UML class diagram above, implement the corresponding Java program.


## Exercise 2
![Exercise 2 image](docs/Ex2.jpg)

Given the UML class diagram above, implement the corresponding Java program.
The maximum battery level is 100.
Implement the logic of charging the devices. The 3 devices have different charging speeds.
E.g. A smartwatch is charged to 20% in 10 min.

## Exercise 3 
![Exercise 3 image](docs/Ex3.jpg)

Given the UML class diagram above, implement the corresponding Java program.

## Exercise 4
![Exercise 4 image](docs/tickets_app2.jpg)

Above picture presentes a high level concept of an event ticketing system. 
1. Create a class diagram to model minimal functionalities of event ticketing system. 
2. Create the minimal application based on the class diagram you have created.

**NOTE 1** In your implementation, use at least two of the following type definitions: enum, interface, abstract class.

**NOTE 2** No real impementaion is needed (no need to generate qr codes, integrate payment service, etc). The class diagram you create and the application will only simulate various features of the application by simply displaying messages. 
The focus will be in identifying main features of each of the components. Model each component as a class. Identify the relation (collaboration) between classes and try to model this interactions in the application.
