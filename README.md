---
title:  CourseLookr, a DB-based web app searching courses in A&M 
author: Shijin Tang, 523005303 
geometry: margin=2cm
---


## Project description


The URL of this app: http://165.227.22.37:8080/


### Background


This web application is designed to provide a course searching engine for A&M students, especially for the graduate students in the department of CSE. 


Normally, the section information for previous semesters, such as instructor, average GPA, etc. can be obtained on A&M registar report. However, it's inconvenient for us students to use, since it's organized by semester. If we want to check a course for last 3 years, we would need to download 9 PDF reports and search that course in each of them. It's not straightforward if we want to compare the results across different semesters. 


To solve this problem, this web application collect all course catalog data and section report data and stored them in database. It will show the information organized by each courses. It's easy to compare section information across different semesters , thus to help students choose the right course section for them. Meanwhile, students can search courses not only with the course ID or name, but also based on their degree programs.


At last, the registar reports don't have any other information like course full name, credit and description. This web application will provide such information to users for their convenience.


### Services


As mentioned, this web app provides two ways for users to get course information: keyword search and categorical search.


#### Keyword search


Users can search courses by entering any combination of "Department", "Number" and "Name", thus do fuzzy search. For example, if a user enters "CSCE" for "Department" and "608" for "Number", only one course "CSCE 608 Database Systems" will be presented. If the the searching criterion is "Name: database", CourseLookr will return a list of courses whose names consist of "database". "CSCE 608 Database Systems" will be in this list. Students can open the course detail page here for detailed information. The course information can be updated on this detail page.


#### Categorical search


For graduate students in the department of CSE, this web app provides categorical search. Student can click their degree program in the home page. It will list the required course packages and course packages based on interest. To fulfill their degree plan, students must pick a specified number of courses from each required package. Meanwhile, CourseLookr also provides course packages based on interest. Students can click their interested packages and check courses inside. Students will see a list of courses in the package page.  The course detail page can be accessed here. Users can also add or delete courses from packages to help this application better.


## Data collection


## E-R diagram of DB


## Table normalization


## User interface


### Home page


The home page consists of two blocks: course search and program category.


#### Search block


Users can search courses by entering any combination of 
#### Program category


### Search result page


### Course page


#### Course detail


#### Course update page


### Program page


### Package page


### Interest page


## Project source code


## Discussion