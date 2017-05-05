# campustore

## 환경 구성

- 클래스, 템플릿, 리소스들이 어플리케이션 재시작없이 리로드되어 빠르게 작업하도록 돕습니다.
- IDE 내부에서 실행 로그를 보지 못하고 별도 터미널에서 봐야한다는 단점(?)은 있음.
- 특히 JS 최신 기능 이용, SASS 컴파일, CSS의 벤더프리픽스 자동 추가를 위해 이런 작업을 함..
- Intellij 의 `Compiler` 옵션에서 `Build project automatically` 옵션 활성화할 것

1. 노드 디펜던시 설치

```js
sudo npm install
```

다음 명령어들을 실행하면서 에러가 발생하면 `./gradlew --stop` 명령 수행 후 다시 시도해볼 것

2. 새로운 터미널을 열고

```
# 어플리케이션을 실행한다.
./gradlew bootRun
```

3. 터미널 탭을 하나 더 열고

```text
# 리소스를 감시하며 전처리해 어플리케이션 output에 반영한다.
./gradlew processResources -t
```

여기까지 실행 후 작업하면 됩니다.

다음부터 작업할 때는 항상 2번부터 하면 됩니다.