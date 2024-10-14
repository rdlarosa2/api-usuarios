# api-usuarios

<b>RESTful API Usuarios con JWT</b>

This instructions are to execute this API in a Windows 10 or Windows 11 Operating System.   

## Prerequisites

The software that must be installed to run this API is: 

<ul>
  <li>java jdk version 17</li>
  <li>maven (apache-maven-3.9.6)</li>
  <li>git (version 2.45.0.windows.1)</li>
</ul>

These components must be configured to execute from the command line. 

## Building

1. The next goal is to build the API from the command line.

1a. Create the folder where the source code will be located. For instance, I will create the folder C:\wspace . 
To create this folder I execute the 'Command Prompt' application with the command: <b>mkdir C:\wspace </b><br>

1b. Make that the current directory be the folder just created. In my case, I will execute the command: <b>cd C:\wspace</b>

1c. Clone the directory of the project in the current directory with the command: <br> 
    ```batch
    git clone https://github.com/rdlarosa2/api-usuarios.git 
    ```  

1d. Make that the current directory be the folder C:\wspace\api-usuarios with the command: <b>cd api-usuarios</b>  

1e. To compile the project, please execute the command: <b>mvn install</b>   

1f. To execute the project, please execute the command: <b>mvn spring-boot:run</b>

2. Install the Postman App from https://www.postman.com/downloads/

3. Define a new collection and a set of requests to test endpoints.

3a. Add a new <b>Blank collection</b> and name it with <b>api-usuarios</b>

3b. Right clic on <b>api usuarios</b> then clic on the option <b>Add request</b>. Then rename the request from <b>New request</b> to <b>login</b>.   
   
<table>
  <tr>
    <th>Field</th>
    <th>Value</th>
  </tr>
  <tr>
    <th><b>
	Name of Request</b></th>
    <th>login</th>
  </tr>
  <tr>
    <th><b>URL</b></th>
    <th>http://localhost:8080/api/auth/login</th>
  </tr>
  <tr>
    <th><b>Authorization -> Auth Type</b></th>
    <th>Inherit auth from parent</th>
  </tr> 
  <tr>
    <th><b>Body –> raw –> JSON</b></th>
    <th>Inherit auth from parent</th>
  </tr>   
</table>
