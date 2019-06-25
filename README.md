# Tennis_Streaming

##############Pre-requisites for running the tests#############
           
	As the tests are written using java and maven as build tool
	 
	Please install java 8 , maven and system properties. Install git if you are cloning the project from git hub or else I've provided a zip file.
	
	Please use Eclipse or Intellij as IDE for debugging the code in detail.
	
	 
	


Cloning the project
Navigate to the below URL in the git hub
https://github.com/srikanth83/Tennis_Streaming

create a workspace directory in the C:\ folder using below command
C:\ mkdir workspace

Now clone the project with the http keys https://github.com/srikanth83/Tennis_Streaming.git  using the command provided below
C:\workspace>git clone https://github.com/srikanth83/Tennis_Streaming.git

Once the project is cloned cd in to the directory and run the below command to install the maven dependencies
C:\workspace\Tennis_Streaming\Eurosport_Tennis_Streaming>mvn clean install -DskipTests=true

                      The above command will download all the dependencies specfied in pom.xml

Now run the tests using the below command
C:\workspace\Tennis_Streaming\Eurosport_Tennis_Streaming>mvn clean test


In case the tests the failing due to chrome driver issues, please udpate the chrome driver or downgrade it.

C:\workspace\Tennis_Streaming\Eurosport_Tennis_Streaming\src\main\resources\chrome_driver
 
              The above command will run all the tests by default.

					  
					  
					  
					  