node {
    def app

    stage('Clone repository') {
        /* Let's make sure we have the repository cloned to our workspace */

        checkout scm
    }

    stage('Build image') {
        dir('rancher-test') {
            sh 'pwd'

            app = docker.image("registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8").inside('-v $HOME/.m2:/root/.m2')
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