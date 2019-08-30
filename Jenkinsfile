library(
  identifier: "shared-library@master",
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/sandeepds/SharedLibraries.git'
    ]
  )
)

//def mvnHome = tool 'M3'

node('master') {
  try{
    stage('Git-Checkout') {
        gitCheckout(this)
    }
    stage('Sonarqube-scan'){
      SonarQube(this)
    }
    stage('Build Stage'){
      //mvnHome = tool 'M3'
      //BuildWithM3(this, mvnHome)
      //BuildWithM3(this)
      //uncomment below one
      BuildWithM3(this, 'M3')
    }
    stage('Docker Image') { 
      PushDockerImage(this)
      //sh "sudo docker build -t sandeepds2002/petclinic ."
      //sh "sudo docker push sandeepds2002/petclinic"
    }

    input "Please confirm for Deployment?"
  
    stage("DockerCompose"){
      DockerComposeBuild(this)
    }
    
    stage("DeployThroughAnisble"){
      DeployWithAnsible(this)
      //sh "sudo docker-compose up -d --build"
    }

    stage('Notifications'){
      mail to: 'sandeepds2002@gmail.com', from: 'sandeepds2002@gmail.com',
                  subject: "Build: ${env.JOB_NAME} - Success", 
                  body: "Job Success - \"${env.JOB_NAME}\" build: ${env.BUILD_NUMBER}"
    }
   }
   catch(Exception e) {
      mail to: 'sandeepds2002@gmail.com', from: 'sandeepds2002@gmail.com',S
                  subject: "Build: ${env.JOB_NAME} - Failed", 
                  body: "Job Failed - \"${env.JOB_NAME}\" build: ${env.BUILD_NUMBER}"
    }
}
