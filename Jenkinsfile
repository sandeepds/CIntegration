library(
  identifier: "shared-library@master",
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/sandeepds/SharedLibraries.git'
    ]
  )
)

node('master') {
    stage('Git-Checkout') {
        gitCheckout(this)
    }
    stage('Sonarqube-scan'){
      SonarQube(this)
    }
    stage('Build Stage'){
      BuildWithM3(this)
    }
    stage('Docker Image') { 
      PushDockerImage(this)
        sh "sudo docker build -t sandeepds2002/petclinic ."
        sh "sudo docker push sandeepds2002/petclinic"
    }
    //stage("Docker compose"){
         //sh "sudo docker-compose up -d --build"
    //}  
}
