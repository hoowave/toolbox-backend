#!/bin/bash

JAR_PATH="build/libs/toolbox-0.0.1-SNAPSHOT.jar"
LOG_FILE="app.log"
PID_FILE="app.pid"

echo "기존 애플리케이션 종료 중..."
if [ -f $PID_FILE ]; then
    pkill -F $PID_FILE
    rm $PID_FILE
    sleep 3
fi

echo "환경 변수 확인..."
echo "DB_URL: ${$DB_URL}"
echo "DB_USERNAME: ${$DB_USERNAME}"
echo "DB_PASSWORD: ${DB_PASSWORD:0:3}..."

echo "새 애플리케이션 실행..."
nohup java -jar $JAR_PATH > $LOG_FILE 2>&1 &
echo $! > $PID_FILE

sleep 10

echo "실행된 프로세스 확인:"
if ps -p $(cat $PID_FILE) > /dev/null; then
    echo "애플리케이션이 성공적으로 시작되었습니다. (PID: $(cat $PID_FILE))"
    ps aux | grep $JAR_PATH | grep -v grep
else
    echo "애플리케이션 시작 실패"
    exit 1
fi

echo "최근 로그 확인:"
tail -n 20 $LOG_FILE
