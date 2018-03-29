node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build artifact') {
        dir('rancher-test') {
            sh 'pwd'

            docker.build("demo/builder-img:${env.BUILD_ID}", "Dockerfile.build").inside('-v $HOME/.m2:/root/.m2')
        }
        /* This builds the actual image; synonymous to
         * docker build on the command line

        */
    }

    stage('Build image') {
            dir('rancher-test') {
                sh 'pwd'
                sh 'docker create --name builder-${env.BUILD_ID} builder-img:${env.BUILD_ID}'
                sh 'docker cp builde-${env.BUILD_ID}r:/usr/src/app/target ./target'
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