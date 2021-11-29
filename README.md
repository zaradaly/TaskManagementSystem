<div id="top"></div>

<!-- PROJECT LOGO -->
<div align="center">
    <h3 align="center">MohamedAli Zarraa</h3>
    <p align="center">
        Cognizant Condidature Test
    </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
    <summary>Table of Contents</summary>
    <ol>
        <li>
            <a href="#compile">How to Compile</a>
        </li>
        <li>
            <a href="#run">How to Run the project</a>
        </li>
        <li>
            <a href="#endpoints">Call the Endpoints</a>
        </li>
    </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Simplified "Tasks Management System" REST API built with JAVA using JDK11 and SpringBoot.

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

* [JDK11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Initializr](https://start.spring.io/)
* [Swagger](https://swagger.io/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

1. You need to install JDK11 and add it to your PATH variable. [https://www.javatpoint.com/how-to-set-path-in-java](https://www.javatpoint.com/how-to-set-path-in-java)
2. Clone the project file from the [GitHub repository](https://github.com/zaradaly/TaskManagementSystem.git)

```sh
git clone https://github.com/zaradaly/TaskManagementSystem.git
```

### Compile
1. Clean the project
```sh
mvnw clean
```
2. Compile the project
```sh
mvnw compile
```


### Run
1. This last command will run the application.
```sh
mvnw spring-boot:run
```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Endpoints

Examples of Endpoint Calls :
Localhost url : {hosturl} = "localhost:8080/api"

- Get all tasks :
You just need to send a GET request the the _{hosturl}/task_.
The result will be the list of all Tasks currently stored in the H2 database, as show in the picture below : 

![GET ALL TASKS](https://github.com/zaradaly/TaskManagementSystem/blob/main/screenshots/Get_tasks.jpg)

- Get Task by Id :
Send a GET request the the _{hosturl}/task/{id}_.
The result will be the Task under the Id specified in the url which is currently stored in the H2 database, as show in the picture below : 

![GET ALL TASKS](https://github.com/zaradaly/TaskManagementSystem/blob/main/screenshots/Get_task_byId.jpg)

- Terminate Task :
Send a GET request the the _{hosturl}/terminateTask/{id}_.
The result will be if the Task under the Id specified in the url was Terminated or Not Able to be Terminated, which means that it has Children tasks that are still being processed, as show in the picture below : 

![GET ALL TASKS](https://github.com/zaradaly/TaskManagementSystem/blob/main/screenshots/Terminate_task_byId.jpg)

_For more examples, please refer to the [Documentation](https://example.com)_

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - email@example.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)

<p align="right">(<a href="#top">back to top</a>)</p>