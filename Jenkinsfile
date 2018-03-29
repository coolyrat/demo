node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build artifact') {
        dir('rancher-test') {
            sh 'pwd'
            sh 'echo ${PWD}'

            sh 'docker run --rm -v maven-repo:/root/.m2 -v ${PWD}:/usr/src/mymaven -w /usr/src/mymaven harbor.codework.tech:8090/library/maven:3.5.3-jdk-8-alpine mvn clean package'

        }
        /* This builds the actual image; synonymous to
         * docker build on the command line

        */
    }

    stage('Build image') {
            dir('rancher-test') {
                sh 'pwd'
                sh 'ls ./target'
                app = docker.build("demo/rancher-test")
            }
            /* This builds the actual image; synonymous to
             * docker build on the command line

            */
        }

    stage('Push image') {
        docker.withRegistry('https://harbor.codework.tech:8090', 'harbor-credential') {
                    app.push("${env.BUILD_NUMBER}")
                    app.push("latest")
                }
    }
}