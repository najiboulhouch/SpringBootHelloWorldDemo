def app_version = ''

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
                    app_version = sh script: 'mvn help:evaluate -Dexpression=project.version -q -DforceStdout', returnStdout: true
                    echo '============================'
                    echo "Version : ${app_version}"
                    echo "============================"
				}
            }
        }
        stage('Build') {
            steps {
            	script {
	                echo 'Building..'
	                 sh "mvn -Dmaven.test.failure.ignore=true -Dmaven.test.skip=true clean package"
                     app_version = "1.0.${currentBuild.number}-SNAPSHOT"
                     echo "Build number is ${currentBuild.number}"
                     sh "mvn release:update-versions -DdevelopmentVersion=${app_version}"
                   }
	             }          
        }
        stage('git push') {
            steps {
            withCredentials([usernameColonPassword(credentialsId: 'najibcompte', variable: 'USERPASS')]) {
                        sh 'git checkout -b main'
                        sh 'git add pom.xml'
                        sh "git diff-index --quiet HEAD || git commit -m 'Update pom.xml'"
                        sh "git push https://$USERPASS@github.com/najiboulhouch/SpringBootHelloWorldDemo.git"
                      }
            }
        }
        stage('Quality') {
            steps {
                echo 'Sonar Quality..'
            }
        }
}

//          stage('CleanWorkspace') {
//             steps {
//               //  cleanWs()
//             }
//          }    
}