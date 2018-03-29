node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build image') {
        dir('rancher-test') {
            sh 'pwd'
        }
        /* This builds the actual image; synonymous to
         * docker build on the command line

        app = docker.build("harbor.codework.tech:8090/demo/rancher-test:${env.BUILD_ID}").inside('-v $HOME/.m2:/root/.m2')*/
        sh 'pwd'
    }

}