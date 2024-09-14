    COMS W4156 Advanced Software Engineering

    Mini Project 2024

    Name: Navinashok Swaminathan
    UserName: NavinColumbia
    UNI: ns3886
    email: ns3886@columbia.edu
    branch: main 
    Link: https://github.com/NavinColumbia/4156-Miniproject-2024-Students-Java.git


    Individual Assignment 2: Feature Implementation and Maintenance 
         
        Pre-Requisite:
            Please Follow Basic Instructions under 'Individual Assignment 1: Testing and Bug Fixing'  
            in README.md for setup and review
         
        0)Reminder of Required Documentation:
                a. honesty.txt and citations.txt can be found at root level of the repo

        1) Feature A Implementation:
            /retrieveCourses endpoint has been created.
                a. RouteController.java has the relevant method implementation
                b. RouteControllerTest.java has the relevant test for the same
                c. PostMan Testing Screenshot attached in pull request for the GET method

        2) Feature B Implementation:
            /enrollStudentInCourse endpoint has been created. 
                a. RouteController.java has the relevant method implementation
                b. RouteControllerTest.java has the relevant test for the same
                c.PostMan Testing Screenshot attached in pull request for the PATCH method


        3. Maintaining the Codebase:
            a. bugs.txt under "Further Robustness Improvements" discusses robustness enhancements.
            b. new tests have been written for the code changes
            c. style check have been done

        4.Submission:
            Submission Details:
                Assignment 2:
                Name: Navinashok Swaminathan
                UserName: NavinColumbia
                UNI: ns3886
                email: ns3886@columbia.edu
                branch: main
                Link: https://github.com/NavinColumbia/4156-Miniproject-2024-Students-Java.git
                Pull Request Has ScreenShots


                
                
                
            
    Individual Assignment 1: Testing and Bug Fixing 

        0)Set-up:
                if data.txt doesn't exist in IndividualProject:
                        ensure port 8080 is unoccupied
                        cd IndividualProject
                        mvn spring-boot:run -Dspring-boot.run.arguments="setup"
                wait till "System Setup" shows up
                cancel above/any applications running in port 8080 (press control+c)
                now data.txt must exist in IndividualProject


        1)Code Clean Up
                a. Run checkstyle:
                        cd IndividualProject
                        mvn checkstyle:check
                        check console output for errors/warnings/violations.
                b. Generate javadoc:
                        cd IndividualProject
                        mvn javadoc:javadoc
                        open in browser IndividualProject/target/site/apidocs/index.html


        2)Test Suite Creation
                a. Tests can be found under IndividualProject/src/test/java
                b. Executing tests:
                        cancel running application from step 0.
                        Ensure port 8080 isn't occupied. 
                        cd IndividualProject
                        mvn clean validate compile test package       
                c. Test Reports : find '.txt' files under 'IndividualProject/target/surefire-reports/' to view test results
                d. Jacoco Report : find file 'index.html' under 'IndividualProject/target/site/jacoco/' and open with any browser to view jacoco results


        3)Bug Fixing
                a. The identified bugs, and the fixes made are documented under 'bugs.txt' at the root directory
                b. PMD(mentioned in assignment) was the static analyzer used. Installing and running PMD:
                        1.Install brew (Package Manager for Mac): Refer https://brew.sh/
                        or do: 
                                /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD install.sh)" . 
                        2.Install pmd:
                                brew install pmd 
                        3.Run PMD: 
                                cd IndividualProject
                                pmd check -d src/main/java -R rulesets/java/quickstart.xml -f text -r "pmdres.txt" 
                                pmd check -d src/main/java -R rulesets/java/quickstart.xml -f html -r "pmdres.html"
                        4.Find file named pmdres.html inside folder 'IndividualProject' ,open the html with any browse. or check 'pmdres.txt'
                          An empty content in either of the file mean no further suggestions.
                c. Run the application and test using Postman:
                        cd IndividualProject
                        cancel any applications running in port 8080
                        mvn spring-boot:run 
                        wait till "Start up" shows up
                        Test the application using Postman (https://www.postman.com/)
                        say, set URL to http://localhost:8080/retrieveCourse?deptCode=IEOR&courseCode=2500
                        select relevant method "GET" in this case, click Send and notice the result.


        4. Academic Honesty Pledge
                a. "honesty.txt" containing my pledge can be found at the root directory of this project


        5. Submission
                a. "citations.txt" file in project root contains the links and descriptions of all the resources used during this assignment
                b. Submission :
                        Name: Navinashok Swaminathan
                        UserName: NavinColumbia
                        UNI: ns3886
                        email: ns3886@columbia.edu
                        branch: main 
                        Link: https://github.com/NavinColumbia/4156-Miniproject-2024-Students-Java.git







