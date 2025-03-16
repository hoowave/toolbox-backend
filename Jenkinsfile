pipeline {
    agent any

    environment {
        JAR_NAME = "toolbox-0.0.1-SNAPSHOT.jar"
        BUILD_DIR = "build/libs"
        SCRIPT_NAME = "start.sh"
    }

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
                    sh "ls -l ${BUILD_DIR}/${JAR_NAME}"
                }
            }
        }

        stage('Deploy & Run') {
            steps {
                script {
                    sh 'source /etc/profile.d/datasource_env.sh'
                    sh 'chmod +x start.sh'
                    sh './start.sh'
                }
            }
        }
    }

    post {
        success {
            echo '빌드 및 배포 성공'
        }

        failure {
            echo '빌드 또는 실행 실패'
        }
    }
}