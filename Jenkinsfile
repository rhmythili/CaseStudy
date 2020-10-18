	pipeline {
    agent any
    
	stages {
        stage('Checkout') {
           steps { 
				git url: 'https://github.com/rhmythili/CaseStudy', credentialsId: 'git', branch: 'main'
		   }
        }

        stage('Build') {
			steps {
				bat 'mvn clean install'
				
				
				}
			}       
		}
	}
	