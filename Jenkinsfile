node {

    withMaven(maven:'maven') {

        stage('Checkout') {
            git url: 'https://github.com/rhmythili/CaseStudy', credentialsId: 'github', branch: 'main'
        }
        stage('Build') {
            mvn clean install

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }
             

    }

	}