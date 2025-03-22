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

## 사용자 가이드
### 1️⃣Client 객체 초기화
```java
Configuration config = new Configuration();

config.addCredentials(new Credentials("KEY", "SECRET")); // 계좌 AppKey, AppSecret 등록

KisClient client = new KisClient(config);
```

#### 다중 계좌인 경우
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

### 3️⃣ WebSocket API 호출
```java
// 실시간 체결가(KRX)
H0STCNT0Api req = new H0STCNT0Api(code);
H0STCNT0Result resp = client.execute(req); // WebSocket API의 호출 반환값에는 데이터가 없고, 대신 addHandler 메서드를 통해 이후 수신받는 데이터에 접근 가능

resp.addHandler((response) -> {
    // do Something..
});

// resp.removeHandler(...) // 특정 handler 제거
// resp.unsubscribe() // 모든 handler를 제거하고 서버에게 구독 해제 요청을 보냄
```


## 개발자 가이드
### REST API 추가
한국투자증권에서 제공하는 모든 API를 본 라이브러리에서 지원하는 것이 목표이나, 현재 모든 API가 정의되어있지는 않습니다.

대신 아래와 같이 (라이브러리 사용자가 직접) API SPEC을 정의한 class를 만들어서 사용할 수 있도록 설계되었습니다.

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