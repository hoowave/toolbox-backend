# Toolbox Backend

Toolbox 프로젝트의 백엔드 서버입니다.

## 기술 스택

- Java
- Spring Boot
- Gradle
- Jenkins (CI/CD)

## 아키텍처

이 프로젝트는 도메인 주도 개발(DDD)을 기반으로 한 헥사고날 아키텍처와 계층형 아키텍처를 적용하고 있습니다.

### 도메인 구조

프로젝트는 다음과 같은 도메인으로 구성되어 있습니다:

- **account**: 사용자 계정 관리
- **board**: 게시판 기능
- **boardcategory**: 게시판 카테고리 관리
- **cutUrl**: URL 단축 서비스
- **review**: 리뷰 시스템
- **apiTest**: API 테스트 기능

각 도메인은 다음과 같은 계층 구조를 가집니다:

```
com.tools.toolbox.{도메인명}/
├── application/        # 애플리케이션 서비스, 포트
├── domain/            # 도메인 모델, 서비스
├── infrastructure/    # 어댑터 구현체
└── presentation/      # REST API 컨트롤러
```

### 공통 모듈

- **common**: 공통 유틸리티 및 설정
- **config**: 전역 설정
- **utils**: 유틸리티 클래스

## 개발 환경 설정

### 필수 요구사항

- JDK 17 이상
- Gradle 8.x

### 설치 및 실행

1. 프로젝트 클론
```bash
git clone https://github.com/hoowave/toolbox-backend.git
cd toolbox-backend
```

2. 프로젝트 빌드
```bash
./gradlew build
```

3. 서버 실행
```bash
./gradlew bootRun
```

또는 `start.sh` 스크립트를 사용하여 실행할 수 있습니다:
```bash
./start.sh
```

## API 엔드포인트

- 개발 환경: https://api-dev.hoowave.org/
- 프로덕션 환경: https://api.hoowave.org/

## 연관 프로젝트

- 프론트엔드: [toolbox-frontend](https://github.com/hoowave/toolbox-frontend)

## CI/CD

Jenkins를 통한 자동화된 배포 파이프라인이 구성되어 있습니다.