# Drone Recon

Drone Recon is a simple application that simulates a users ability to be able to track
a drone in the sky. This application is not meant for commercial use, its just a simple
project meant to simulate what an actual tracking-like application could look like, sort 
of like a very early alpha application.

## Application Elevator Pitch

With drones quickly becoming all the rage in many different fields, It made sense to create an 
application that enabled a users ability to be able to track their drone. While many are simply 
content with watching a little drone fly around their backyard, many others use them for serious 
work that may span hundreds, even thousands of acres of land. Trying to follow a small drone with 
your naked eye, while possible, is simply not worth the time and energy when there is money on the line. 
Thus, Drone Recon aims to fix that issue by being able to track where your drone is remotely on the 
Drone Recon application in real time.

## Application intent

In this alpha stage, the area the drone covers is a square grid and always follows the same pattern.
The intent behind the creation of this application is that it can be used as a sort of jumping off point
for a more complex, robust application. Yes, what I have right now is rudementary. However, it can also
be used as a baseline for exactly what I described in the elevator pitch. Just by adding a couple
more features this small application has the potential to explode and make tracking one's drone a breeze.

## Application Specifics

This application is built on three distinct (but connected) moving parts. The first
part is the actual application code itself, which is written in JSP. JSP was chosen for
its great integration of both Java and HTML code, and for its ability to be able to create
dynamic applications with the need for anything more complex than a couple of for loops.
The second part is Apache Tomcat. To help all these moving parts... actually move,
I used Apache Tomcat since it very easily enables JSP code to run in a safe, reliable 
environment (in comparison to Jetty). The final part is the storage aspect of the application, 
which can honestly be interchanged for any RDBMS, thought for this particular project I
went with SQLite because, again, it was fairly easy and painless to integrate into the system.


## To any students reading this:
This is MY program on MY github, do not try and pass this off as your own work. It is not worth the risk being
caught, and you won't learn anything by simply copy/pasting. Seek help from professors or other sources other than
this one; being expelled by being lazy from an assignment stings a lot more than a C in a class.

##
All that being said, if anyone has any issue with this particular repo, please message me either on github or
send an email at emanueljose11@hotmail.com to work something out.


