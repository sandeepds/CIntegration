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
    stage('pull') {
        gitCheckout(this)
    }
}
