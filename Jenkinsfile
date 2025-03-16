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
                    sh './gradlew clean build --refresh-dependencies'
                }
            }
        }
        stage('Verify JAR') {
            steps {
                script {
                    sh 'ls -l build/libs'
                }
            }
        }
        stage('Stop Previous Application') {
            steps {
                script {
                    sh 'pkill -f toolbox-0.0.1-SNAPSHOT.jar || true'
                    sh 'sleep 3'  // 기존 프로세스 종료 대기
                }
            }
        }
        stage('Run JAR') {
            steps {
                script {
                    sh 'nohup java -jar build/libs/toolbox-0.0.1-SNAPSHOT.jar > app.log 2>&1 & disown'
                }
            }
        }
        stage('Check Running Process') {
            steps {
                script {
                    sh 'ps aux | grep toolbox-0.0.1-SNAPSHOT.jar'
                }
            }
        }
        stage('Check Logs') {
            steps {
                script {
                    sh 'tail -n 50 app.log'
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