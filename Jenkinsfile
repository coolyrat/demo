pipeline {
  agent {
    docker {
      image 'registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8'
      args '-v /root/.m2:/root/.m2'
    }
    
  }
  stages {
    stage('build') {
      steps {
        sh 'mvn --version'
      }
    }
  }
}