# Lab 10 - Race Track

## Introduction
In this lab, you will develop a simple race simulation game using threads.

## Exercise 1
Execute the Semaphore application and observe how a thread is created and started.

![Image](/docs/semaphor.png)

## Exercise 2
Examine the CarRace class and determine what is missing and which instructions need to be added in order to initiate a race for four cars that are created and ready to compete.

![Image](/docs/race.png)

## Exercise 3
Integrate Semaphore and CarRace so that the race begins when the semaphore turns green (i.e., when the Semaphore thread finishes execution). To implement this exercise, you will utilize the join() method.

Starting with this exercise, work within the raceapp package. Copy the classes from the racedemo package into the raceapp package and make any necessary modifications.

## Exercise 4
Modify the application from Exercise 3 so that a sound starts playing when the cars begin racing and stops when all cars have finished. Project incorporate a sample audio file you can play and an example PlaySound class playing a sound.

## Exercise 6
Incorporate a mechanism to detect and display (in text or graphical mode) the standings after the race has concluded and the race duration for each car.

## Exercise 7
Develop a thread that increments a timer (long variable) every 10 milliseconds. This thread will start when the race begins and stop when the race ends. Once the timer is stopped, display the measured time.





