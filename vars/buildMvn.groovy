def call(script, jdkVar, mavenVar) {
    script.withMaven (
        maven: mavenVar,
        jdk: jdkVar) {
                sh 'mvn clean install'
    }
}