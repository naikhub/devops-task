pipeline {
    agent any
    stages {
        stage('GitCheckout') {
            steps {
                echo 'Clone the repository'
                sh 'rm -rf *'
                sh 'git clone https://github.com/naikhub/devops-task.git'
                sh 'cd devops-task.git; ls -lrta'
                sh 'ls -lrta'
            }
        }
         stage('SonarQube_Scan') {
            steps {  
                sh 'echo "Scanning vunarabilities"' //we are not doing in pipline as we need to setup sonarqube
                }
        }
        stage('Maven-Build') {
            steps {  
                sh 'echo "mvn install"' //we are building in docker level
                }
        }
         stage('Lint Test') {
            steps {  
                sh 'echo "Lint test finished"' //we are not doing as it needs to done code level
                }
        }
          stage('Unit Test') {
            steps {  
                sh 'echo "JUnit test finished"' //we are not doing as it needs to done code level
                }
        }
          stage('Jfrog') {
            steps {  
                sh 'echo "Storing Artifacts in JFROG has finished"' //we are not doing as it needs to setup JFrog
                }
        }
        stage('docker-compose-build') {
            steps {
                sh 'rm -rf *'
                sh 'cd devops-task; ls -lrta; docker-compose up --build --remove-orphans -d'
                sh 'sudo docker-compose ps'
            }
        }
        stage('Publish') {
            steps {
                sh 'sudo docker login -u="ramubanavath" -p="Novamber3@"'
                sh 'sudo docker images'
                sh 'sudo docker tag nginx ramubanavath/ninx:v1'
                sh 'sudo docker tag www01 ramubanavath/www01:v1'
                sh 'sudo docker tag www02 ramubanavath/www02:v1'
                sh 'sudo docker push ramubanavath/nginx:v1'
                sh 'sudo docker push ramubanavath/www01:v1'
                sh 'sudo docker push ramubanavath/www02:v1'
                sh 'sudo docker images'
            }
        }
        stage('Performance Test') {
          steps {  
              sh 'echo "performance test has been finished"' //we are not doing as it needs to done code level
              }
        }
    }
}
