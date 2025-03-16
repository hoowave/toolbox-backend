#!/bin/bash

JAR_PATH="build/libs/toolbox-0.0.1-SNAPSHOT.jar"
LOG_FILE="app.log"

echo "기존 애플리케이션 종료 중..."
pkill -f $JAR_PATH
sleep 3

echo "새 애플리케이션 실행..."
nohup java -jar $JAR_PATH > $LOG_FILE 2>&1 &

sleep 5
echo "실행된 프로세스 확인:"
ps aux | grep $JAR_PATH | grep -v grep