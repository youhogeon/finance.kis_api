## 한국투자증권 API Java Wrapper
[한국투자증권 API](https://apiportal.koreainvestment.com/) 에 대한 Java Wrapper.

## 기능
* REST API 호출
    * 인증키(app token) 발급 및 관리
    * 유량 제어 (초당 호출 수 제한에 대한 제어)
* WebSocket API 호출
    * 인증키(approval_key) 발급 및 관리
    * 연결, 데이터 구독·해제 관리
* API 정의 작성만으로 API 호출 가능하도록 지원

## 설치(의존성 추가)
### Gradle (Groovy)
```groovy
dependencies {
    implementation group: 'com.youhogeon.finance', name: 'kis_client', version: '<latest version>'
    implementation group: 'com.youhogeon.finance', name: 'kis_api', version: '<latest version>'
}
```
latest version(release 목록)은 아래에서 확인 가능합니다.
* [kis_client](https://github.com/youhogeon/finance.kis_api/releases?q=kis_client)
* [kis_api](https://github.com/youhogeon/finance.kis_api/releases?q=kis_api)

kis_client와 kis_api가 나뉘어져있고 각기 다른 버전을 가짐에 주의하세요.
* kis_client : 코어 라이브러리 (필수)
* kis_api : `사전 정의된 API Definition`이 담긴 라이브러리 (대부분의 경우 필수)
    * `사전 정의된 API Definition`을 사용하지 않고 모든 API를 직접 정의(`사용자 정의 API Definition`)하여 사용하고자 하는 경우 `kis_api`는 불필요합니다.

## 라이브러리 사용 가이드
### 1️⃣ Client 객체 생성
```java
Configuration config = new Configuration();
config.addCredentials(new Credentials("KEY", "SECRET")); // 계좌 AppKey, AppSecret 등록

KisClient client = new KisClient(config);
```

#### (Optional) 다중 계좌인 경우
```java
Credentials c1 = new Credentials("KEY", "SECRET");
Credentials c2 = new Credentials("KEY", "SECRET");

Configuration config = new Configuration();

config.addCredentials(c1);
config.addCredentials(c2);

// 아래와 같이 Credentials에 이름 지정하여 등록 가능.
// 이 경우, API 호출 시 특정 이름을 가진 Credentials 로 API 호출 가능함.
// 그렇지 않으면, 이름을 지정하여 호출 불가능하고, 자동 선택에 맡겨야 함.
//
// config.addCredentials("firstAccount", c1);
// config.addCredentials("secondAccount", c2);

// 다중 계좌인 경우, 호출시 이름을 지정하지 않았을 때 CredentialsSelector 에 의해 Credentials가 자동 선택됨.
// 아래와 같이 사용할 CredentialsSelector 지정 가능. CredentialsSelector를 구현하는 custom 구현체를 작성하여 추가 가능
// 
// config.setCredentialsSelector(new SimpleCredentialsSelector()); // 1 (기본값)
// config.setCredentialsSelector(new RoundRobinCredentialsSelector()); // 또는 2

KisClient client = new KisClient(config);
```

### 2️⃣ REST API 호출
```java
// 주식현재가 시세
InquirePriceApi req = new InquirePriceApi("005930");
InquirePriceResult resp = client.execute(req);

// 다중 계좌인 경우 아래와 같이 이름 지정하여 호출 가능.
// 다중 계좌인데 이름 지정하지 않는 경우, CredentialsSelector 에 의해 어떤 Credentials 사용할 지 결정됨.
//
// InquirePriceResult resp = client.execute(req, "firstAccount");
```

#### (Advanced) 연속 조회
주식잔고조회(`InquireBalanceApi`)와 같이 한 번에 받아올 수 있는 데이터 수 제한이 있는 Api 경우, 연속 조회(다음 데이터 조회)가 필요합니다.\
`result.next()`를 호출함으로써 다음 데이터를 편리하게 받아올 수 있습니다.
```java
// 주식현재가 시세
InquireBalanceApi req = new InquireBalanceApi();
InquireBalanceResult balance = client.execute(req);

do {
    System.out.println(balance);

    balance = balance.next();
} while (balance != null);
```

### 3️⃣ WebSocket API 호출
```java
// 실시간 체결가(KRX)
H0STCNT0Api req = new H0STCNT0Api(code);
H0STCNT0Result resp = client.execute(req); // WebSocket API의 호출 반환값에는 데이터가 없고, 대신 addHandler 메서드를 통해 이후 수신받는 데이터에 접근 가능

resp.addHandler((response) -> {
    System.out.println(response); // 실시간 결과 수신
});

// resp.removeHandler(...) // 특정 handler 제거
// resp.unsubscribe() // 모든 handler를 제거하고 서버에게 구독 해제 요청을 보냄
```


## `사용자 정의 API Definition` 추가 가이드
### REST API 추가
한국투자증권에서 제공하는 모든 API를 본 라이브러리에서 지원하는 것이 목표이나, 현재 모든 API가 정의되어있지는 않습니다.

대신 아래와 같이 (라이브러리 사용자가 직접) API Definition을 정의한 class(`사용자 정의 API Definition`)를 만들어서 사용할 수 있도록 설계되었습니다.

Api Class, Api Result Class 두 개의 클래스 모두 작성해야 합니다.

1. API Class 생성
    ```java
    @RestApi(method = RestApi.Method.POST, path = "/uapi/...")
    @AllArgsConstructor
    public class SampleApi extends CommonRestApi<SampleApiResult> { // 아래에서 만들 Result Class를 Generic으로 지정

        // @Header Annotation이 붙은 필드는 요청 헤더에 추가됨.
        @Header("tr_id")
        private String trId = "FHKST01010100";

        // @Parameter Annotation이 붙은 필드는 URL Parameter에 추가됨.
        @Parameter("FID_COND_MRKT_DIV_CODE")
        private String marketCode = "UN";

        @Parameter("FID_INPUT_ISCD")
        private String code;

        // @Body Annotation이 붙은 필드는 요청 본문에 추가됨.
        @Body("body1")
        private String aaa = "...";

        @Body("body2")
        private String bbb = "...";

    }
    ```
1. API Result Class 생성
    ```java
    import lombok.Getter;

    @Getter
    public class SampleApiResult extends CommonResult {

        // @Header Annotation 을 사용해 응답 헤더에 있는 필드 정의.
        @Header("tr_id")
        private String trId;

        // 응답 본문에 있는 필드들 정의 (camelCase, snake_case 모두 지원)
        private String rtCd;
        private String msgCd;
        private String msg1;
        private Output output;

    }
    ```
1. API 호출
    ```java
    // 별다른 코드 필요 없이,  Class, Result Class만 잘 정의하면 바로 사용 가능
    SampleApi req = new SampleApi();
    SampleApiResult resp = client.execute(req);
    ```

### WebSocket API 추가
WebSocket API는 , Result Class 외에 Data Class(실시간 수신받는 데이터 정보)가 추가로 필요합니다.

`H0STCNT0Api`, `H0STCNT0Result`, `H0STCNT0Data`를 참고하십시오.


## 비고
### FAQ (아무도 물은적은 없지만.)
#### 초당 호출 수 제한을 설정하고 싶어요.
* Rest API
    * `Credentials` 별로 초당 호출 수 제한을 설정할 수 있습니다.
        ```
        Credentials credentials = new Credentials(...);

        credentials.setRestLimitPerSecond(10);
        ```
* 실시간 API
    * 초당 호출 수 제한은 없습니다. (따라서 해당 기능도 없습니다.)
    * 데이터 최대 수신 건수(기본 41건)를 초과한 요청 발생 시 예외 발생합니다.

#### 예외는 어떻게 처리해야 하나요?
* 모든 예외는 `KisClientException` (Unchecked Exception) 의 자식 타입입니다.
* 예외 처리 필요 시 try-catch 사용하시길 바랍니다.

#### Thread-safe 한가요?
* 네

### Roadmap (TODO List)
* 예외 타입 세분화
* 일관성있는 로깅
* 테스트 커버리지 확대