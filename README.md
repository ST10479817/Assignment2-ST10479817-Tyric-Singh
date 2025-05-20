# Assignment2-ST10479817-Tyric-Singh

## The Project Overview
This Flashcard Quiz App is an Android application designed to test users' knowledge of historical facts. The app presents a series of true and false questions, that will also track their score and provide if they are correct or incorrect. At the end user's will be able to review their answers and exit the app.

## The Repository Link
https://github.com/ST10479817/Assignment2-ST10479817-Tyric-Singh.git

## The Youtube Video Demostration



## The Report

### 1. Purpose of the App
The Flashcard Quiz App is designed to offer users an engaging way to test their knowledge when studying.

### 2. Design Considerations

#### User Interface 
I made very easy to use with a clean and minimal layout to sit easy on the eyes.
With images that relate to each question displayed in the background.
With each button displayed with a colour to make each one stand out for the user to see.
On the middle of each flashcard there is the question and on the top right there is a score counter.
At the end of the app we can see the score that the user got out of five.
With that there is a Review Button that allows the user to see what questions they got correct or incorrect.

#### Quiz Logic
A list of true or false questions is looped through.
User responses are taken stored in a list.
After the last question, the score is calculated and shown.
At the end the user will have the opotion to press the review button, which show what they got correct or incorrect, with the question and the correct opition next to it.

### 3. Utilization of GitHub and GitHub Actions

#### GitHub Version Control 
I consistency committed my progress to GitHub, I have been following good practices and documenting any changes with meaningful commit messages.

#### GitHub Version Control
I managed to get the Action test to work. 

#### Workflow File:
name: Kotlin Build

on:
  push:
    branches: [main]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3

      - name: Set up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Make Gradle wrapper executable
        run: chmod +x ./gradlew
        working-directory: Assignment2TyricSinghST10479817

      - name: Build the project
        run: ./gradlew build
        working-directory: Assignment2TyricSinghST10479817


## Screenshots
### App images
![image](https://github.com/user-attachments/assets/729662e8-6017-4356-b730-c279ee75defa)
![image](https://github.com/user-attachments/assets/b5e9c437-8437-470a-add1-7473589457ff)
![image](https://github.com/user-attachments/assets/b2f14fe0-c75f-4524-bddf-9b3f90fadb80)
![image](https://github.com/user-attachments/assets/636479ca-0779-43a1-88aa-e0bdaabd37da)
![image](https://github.com/user-attachments/assets/6a393aa4-0060-4816-84aa-4e151a97edde)
![image](https://github.com/user-attachments/assets/e922533b-c394-4d9f-a58a-3cd3cd188eb5)
![image](https://github.com/user-attachments/assets/27e06fdc-f743-4f2d-a6a0-2f8c3ca9b7a8)






