# API-RESTFUL-JAVA
Microservice that use H2 as database to run, JWT as security with email/password for tokens, and all responses in JSON format. It was built between Saturday and Sunday. 

## Contents
1. [Used versions](https://github.com/JoMiPeCa/API-RESTFUL-JAVA/edit/main/README.md#used-versions)
2. [What's included](https://github.com/JoMiPeCa/API-RESTFUL-JAVA/edit/main/README.md#whats-included)
3. [DataModeler images, first models.](https://github.com/JoMiPeCa/API-RESTFUL-JAVA/edit/main/README.md#datamodeler-images-first-models)
4. [How to run and what to expect](https://github.com/JoMiPeCa/API-RESTFUL-JAVA/edit/main/README.md#how-to-run-and-what-to-expect)
5. [Inside the code](https://github.com/JoMiPeCa/API-RESTFUL-JAVA/edit/main/README.md#inside-the-code)
6. [Thanks](https://github.com/JoMiPeCa/API-RESTFUL-JAVA/edit/main/README.md#thanks)

---

### Used Versions

I must clarify that Spring boot 3.0.0-SNAPSHOT is broken in gradle and not working properly at the time I wrote this project. JDK 17 has compabilities issues with Hibernate, JPA and H2 Database that made me desist and run back to JDK 1.8

- H2 as Database
- Gradle to build it
- Hibernate
- Spring Framework/Boot 2.6.6
- Tomcat Embedded
- Java 8 (Amazon)
- Github
- JUnit5
- io.jsonwebtoken 0.9.1

---

### What's included

In the main path of the project, you are going to find the Postman Collection which contains all the entries and endpoints that are used by this microservice. You can also find the script.sql (it was exported from the H2 database). There's also a PDF with the exercise. That's all the extra files from the project. Other files are from the project itselfs to run and work properly. 

---

### DataModeler images, first models.

My first step in this exercise was to do the logical and relational model of the database, but I missunderstand the instructions and figured out later that was not required. Anyway I uploaded the images just to get a better visual of how I saw it:
![image](https://user-images.githubusercontent.com/17886381/163795747-2bcc21b9-c037-456e-843f-f7588716c4c6.png)
![image](https://user-images.githubusercontent.com/17886381/163796066-63adf408-b2dd-41f1-950e-ec7a506c5ef0.png)

---

### How to run and what to expect

First, download the project. Unzip it to your desired location and then using your gradle tool, run it. After it, you can check the database at:

- URL: http://localhost:8080/h2-ui 
- User:  user
- PW: password

I recommend to use Postman Desktop (you wont be able to connect over cloud version) to use the Postman collection. Once you are inside Postman and you imported the collection called `Ernst & Young Exercise.postman_collection.json` then if you try to run any endpoint except token, you will get a forbidden error. Please refer to token endpoint, and use the email & password from the database you already got in the previous step. 
After using the credentials, you should be able to use token endpoint to get a new object which contains the JWT(Token). Please use it in each endpoint, or just go to your Collection and add it to your Authorization tab. 

Now you will be able to use the rest of endpoints. 

The available endpoints are: 
- GetAllUsers
- GetUsersByEmail
- postUser
- Token(no auth needed)
- Error(unuseful, it exist to handle errors)

---

### Inside the code 

I'm going to describe only the things that I failed to accomplish, or what I left between 50-99% done. Everything that is not mentioned here is already done over the code.

The code coverage of the full project is 60%. I'm afraid I couldn't handle the Security & Controller classes with JUnit. I tried. but at end I just added @Disabled annotation because it was impossible for me to add test classes on them. 

The password regex accepts 1 Uppercase, Lowercases and 2 numbers, in that exactly order. From my point of view this was the right path. but I'm clarifying that maybe I was wrong. 

Once again, I have not done any UML or diagram with the solution(except the initial data modeler). 

---

### Thanks 

I want to thank EY for the opportunity to develop the exercise. At first it seemed easy to me, then I realized that my knowledge was rusty, but thanks to you I was able to refresh several knowledge, and learn some others that I did not know.

Thank you!
