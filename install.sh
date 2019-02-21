sudo apt-get update

sudo apt-get install openjdk-8-jdk -y



sudo docker pull frameworkdevops/jenkins:latest 

sudo docker run -p 8080:8080 -d frameworkdevops/jenkins:latest


docker pull sonarqube

docker run -d --name sonarqube -p 9000:9000 sonarqube


docker pull sonatype/nexus3

docker run -d -p 8081:8081 --name nexus sonatype/nexus3


docker pull frameworkdevops/framework_1.0:tomcat

docker run -p 8090:8080 -d frameworkdevops/framework_1.0:tomcat
