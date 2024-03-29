# simplified-monopoly
Simplified Monopoly is my first "big" Java project, done in University in the second semester of the first year. 

# Course Details
The course I attended to, in which we were asked to do a final project, was called Programming II and it teached us the basics of the Java language. 
I followed it after the Programming I course in the first semester which teached us the basics of C instead. 
I've learned the positive and negative sides of object-oriented programming, the differences between programming paradigms and how to achieve 
the best workflow for developing a personal project.

# Project Description
It's a simplifed version of the Monopoly game because this was initially a pure CLI project, which we were asked to turn into a GUI one once we learned 
how to use tools like GUI Designer and JFormDesigner, without changing the logic of the code we had previously written. 
I study in an Italian university, so I had to make some changes before sharing my project here on GitHub. First of all, the documentation was 
written entirely in Italian for the purpose of passing the exam in the rules we were told to follow, and I've translated it to English. 
Then, I've also made some changes to the UI by overhauling the way box looked and translated all the UI texts as well. 
I have two main goals by uploading this project. 
First, I'd like to have my own record of projects publicly available so that I can hopefully see my progress over the years, 
as I learn more programming languages and I become more expert and efficient in coding. 
Second, I'd love if what I've learned with this course can be of help to other students across the globe who are facing some difficulties 
in learning Java or programming as a whole, since it's not an easy subject and it requires patience and many attempts to get what you want done right.

# Build locally
Executable packages can be downloaded from [Releases](https://github.com/ShyVortex/simplified-monopoly/releases) or manually built instead.
In order to build the project from source, the following prerequisites are required:
- Open Java Development Kit (OpenJDK) 17 or above
- Apache Maven (at least version 3.6.3 is recommended)

Once you're in the project directory, type the following in a terminal to download the dependencies and compile all the classes:
 ```shell
 mvn clean install
 ```
Then, if you also want a runnable .jar archive, type:
 ```shell
 mvn package
 ```
With these commands, a new folder named 'target' is created containing the compiled project as well as the executable file.

# Build in container
Assuming you're on a Linux system, if you have docker and docker-compose installed and don't want to build the project locally, you can build and run it
in a container instead. Open a terminal window inside the project directory and type the following to build a container image:
 ```shell
 sudo docker compose build simplified-monopoly
 ```
This will build the image, download all necessary dependencies and setup all the required services.
After it's done building, type:
 ```shell
 sudo docker compose run simplified-monopoly
 ```
This should run the image and launch the application.

# Screenshots
![Screenshot_20231029_155155](https://github.com/ShyVortex/simplified-monopoly/assets/111277410/8977b57c-cfa5-4878-8d93-0045b746605f)
![Screenshot_20231102_103009](https://github.com/ShyVortex/simplified-monopoly/assets/111277410/cb08bed8-c87e-4293-aa2d-70636d2254b2)
![Screenshot_20231029_155950](https://github.com/ShyVortex/simplified-monopoly/assets/111277410/7a934b06-a476-4f73-ac15-dcf6f6d77c96)
![Screenshot_20231029_160038](https://github.com/ShyVortex/simplified-monopoly/assets/111277410/b78cec10-883d-4196-9a9e-4973d814c206)
![Screenshot_20231029_155627](https://github.com/ShyVortex/simplified-monopoly/assets/111277410/ec1fe832-3cac-4dbb-b56d-bed6837abc47)

# License
- This project is distributed under the [BSD-3-Clause License](https://github.com/ShyVortex/simplified-monopoly/blob/master/LICENSE.md).
- Copyright of [@ShyVortex](https://github.com/ShyVortex), 2022.
