	pipeline {
    agent any
    
	stages {
        stage('Checkout') {
           steps { 
				git url: 'https://github.com/habsh/microservice1.git', credentialsId: 'habsh', branch: 'master'
		   }
        }

        stage('Build') {
			steps {
				bat 'cd ./account-service'
				bat 'mvn clean install'
				
				
				}
			}       
		}
	}
	