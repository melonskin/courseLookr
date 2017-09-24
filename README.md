---
title:  CourseLookr, a DB-based web app searching courses in A&M 
author: Shijin Tang, 523005303 
geometry: margin=2cm
---


## Project description


The URL of this app: http://165.227.22.37:8080/


### Background


This web application is designed to provide a course searching engine for A&M students, especially for the graduate students in the department of CSE. 


Normally, the section information for previous semesters, such as instructor, average GPA, etc. can be obtained on A&M registar report. However, it's inconvenient for us students to use, since it's organized by semester. If we want to check a course for last 3 years, we would need to download 9 PDF reports and search that course in each of them. It's not straightforward if we want to compare the results across different semesters. Usually, students spend hours collecting helpful data if they want enough information. Some of them may just give up and go with recent 1 or 2 grade reports since this process is quite tedious and time-consuming.


To solve this problem, this web application collect all course catalog data and section report data and stored them in database. It will show the information organized by each course. It is easy to compare section information across different semesters , thus to help students choose the right course section for them. 


Meanwhile, students can search courses not only with the course ID or name, but also based on their degree programs. This application implements some course related information in the graduate brochure for graduate students in the department of CSE. Students can check them using categorical search.


Furthermore, the registar reports don't have any other information like course full name, credit and description. This web application will provide such information to users for their convenience. Therefore, it is a complete and convenient tool for A&M students for choosing courses. 


### Services


As mentioned, this web app provides two ways for users to get course information: keyword search and categorical search.


#### Keyword search


Users can search courses by entering any combination of "Department", "Number" and "Name", thus do fuzzy search. For example, if a user enters "CSCE" for "Department" and "608" for "Number", only one course "CSCE 608 Database Systems" will be presented. If the the searching criterion is "Name: database", CourseLookr will return a list of courses whose names consist of "database". "CSCE 608 Database Systems" will be in this list. Students can open the course detail page here for detailed information. The course information can be updated by users on this detail page.


#### Categorical search


For graduate students in the department of CSE, this web app provides categorical search. Students can click their degree program on the home page. It will list the required course packages and course packages based on interest. To fulfill their degree plan, students must pick a specified number of courses from each required package. Meanwhile, CourseLookr also provides course packages based on interest. Students can click their interested packages and check courses inside. Students will see a list of courses in the package page.  The course detail page can be accessed here. Users can also add or delete courses from packages to help this application better.


## Data collection


The data used in this application was retrieved from three sources as below.


1. A&M course catalog
    - course ID, name, credit, description
    - URL: http://catalog.tamu.edu/
2. A&M registar report
    - previous section information
    - URL: https://web-as.tamu.edu/gradereport/
3. A&M CSE department graduate brochure
    - graduate degree program information
    - URL: https://engineering.tamu.edu/cse/academics/graduate-program


### Course catalog


The catalog information is relatively easy to retrieve since it's web-based and well structured. A web crawler built with python is used to get all information and save them in `csv` format. 5309 rows was retrieved. The source code can be found at https://github.com/melonskin/scrapeCourse.  


### Registar report


First, A web crawler is used to download those reports for 3-year period, which is in PDF-format. Then, a OCR API developed by google is implemented to convert those PDF into txt files. Those data is processed, cleaned and saved in `csv` format. 48491 rows were retrieved. The code is at  https://github.com/melonskin/scrapeCourse.


### CSE graduate brochure


The degree program and course package information are input manually, since it is relatively short and need some understanding.


## E-R diagram of DB


The E-R diagram is plotted as below.


![E-R diagram](./media/erd.png)



### Discussion


This database design has five entities: `Course`, `Section`, `Program`, `Package` and `Interest`. The relations between them are:


1. `Course` one to many `Section`
2. `Program` one to many `Package`
3. `Program` many to many `Interest`
4. `Package` many to many `Course`
5. `Interest` many to many `Course`


With the database design mentioned above, the E-R diagram can be generated. 


For the application, `Course`, `Section` are used to store the course information crawled online.  User do keyword search in `Course` table based on its attributes. For every course, we could query its sections to check.


`Program`, `Package` and `Interest` consist of degree plan information in the graduate brochure. They basically support the categorical search service. For example, `Package` and `Course` have a relationship between them, it represents a course package consists of several courses. Therefore, when user queries for the courses of a package, the application will return a list of courses. 


## Table normalization


Based on the E-R diagram, the database schema is constructed.


### Database schema


There are 8 tables in total. Five of them store five entities. Other 3 are tables consisting of two foreign keys columns handling many-to-many relations between those entities. They are `Interest_courseship`, `Package_courseship` and `Program_interestship`. 


The structures of tables are shown as below.


#### Course

| Field     |Key    |
|----------|---|
| id       |PRI |
| department| |
| number     | |
| name   | |
| credit  | |
| description | |


#### Section     


| Field     |Key    |
|----------|---|
|course_id  | PRI, FOR |
|number |PRI |
|instructor| |
|term   | PRI |
|year   | PRI |
|GPA    | |
|student    | |
|Grade A |  |
|Grade ... |  |


#### Program


| Field     |Key    |
|----------|---|
|id |PRI    |
|name   |
|acronym    |


#### Package


| Field     |Key    |
|----------|---|
|id | PRI |
|program_id | FOR |
|name   |   |
|no_required |  |


#### Interest


| Field     |Key    |
|----------|---|
|id |PRI    |
|name   | |


#### Package_courseship


Similarly for other "ship" tables.


| Field     |Key    |
|----------|---|
|package_id |PRI, FOR |
|course_id |PRI, FOR |  




### Discussion


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