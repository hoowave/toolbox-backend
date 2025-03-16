pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'develop', url: 'https://github.com/hoowave/toolbox-backend.git'
            }
        }
        stage('Build') {
            steps {
                script {
                    sh './gradlew clean build --refresh-dependencies'
                }
            }
        }
        stage('Stop Previous Application') {
            steps {
                script {
                    sh '''
                    PID=$(ps aux | grep 'toolbox-0.0.1-SNAPSHOT.jar' | grep -v grep | awk '{print $2}')
                    if [ -n "$PID" ]; then
                        echo "Killing previous process with PID: $PID"
                        kill $PID
                    else
                        echo "No previous process found"
                    fi
                    '''
                }
            }
        }
        stage('Run JAR') {
            steps {
                script {
                    sh 'nohup java -jar build/libs/toolbox-0.0.1-SNAPSHOT.jar > app.log 2>&1 &'
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