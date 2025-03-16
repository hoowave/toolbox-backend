pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/hoowave/toolbox-backend.git'
            }
        }
        stage('Set Permissions') {
            steps {
                script {
                    sh 'sudo chmod -R 777 /var/lib/jenkins/workspace/toolbox-dev-cicd'
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    sh ''
                    sh 'sudo ./gradlew clean build --refresh-dependencies'
                }
            }
        }
        stage('Stop Previous Application') {
            steps {
                script {
                    sh 'pkill -f toolbox-0.0.1-SNAPSHOT.jar'
                }
            }
        }
        stage('Run JAR') {
            steps {
                script {
                    sh 'java -jar build/libs/toolbox-0.0.1-SNAPSHOT.jar > app.log 2>&1 &'
                }
            }
        }
    }
    post {
        success {
            echo '빌드 및 실행 성공'
        }

        failure {
            echo '빌드 또는 실행 실패'
        }
    }
}