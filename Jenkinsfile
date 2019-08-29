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
}
