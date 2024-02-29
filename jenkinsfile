pipeline {
    agent any


   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "maven-pic"
      jdk 'JDK17'
   }

    stages {
        stage('Prepare') {
            steps {
            	script {
				    echo 'Prepare'
                    sh "mvn --version"
				}
            }
        }
        stage('Build') {
            steps {
            	script {
	                echo 'Building..'
	             }

            }
        }
        stage('Quality') {
            steps {
                echo 'Sonar Quality..'
            }
        }

         stage('CleanWorkspace') {
            steps {
                cleanWs()
            }
         }
    }
}