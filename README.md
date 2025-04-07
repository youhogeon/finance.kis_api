# 한국투자증권 Open API Library for Java
[한국투자증권 Open API](https://apiportal.koreainvestment.com/) (KIS Developers API)를 호출하기 위한 고수준 Java Library.

## ✨ 특징
* 딱 한 줄만으로 API 호출 가능 (설정 등 공통 요소 제외)\
    `client.execute( new InquirePriceApi("005930") )`
* Rest API, 실시간 API(WebSocket) 모두 지원
* 인증키(app token) 발급 및 관리를 지원.
    * 토큰 만료시각, 토큰발급 1분제한 등을 고려하지 않고 로직에 집중 가능
* 유량 제어 지원.
    * 초당 호출 수를 내부적으로 제어 가능.

## 📦 설치(의존성 추가)
### Gradle (Groovy)
```groovy
dependencies {
    implementation group: 'com.youhogeon.finance', name: 'kis_client', version: '<latest version>'
    implementation group: 'com.youhogeon.finance', name: 'kis_api', version: '<latest version>'
}
```

### 최신 버전 정보
* latest version(release 목록)은 아래에서 확인 가능합니다.
    * [kis_client](https://github.com/youhogeon/finance.kis_api/releases?q=kis_client)
    * [kis_api](https://github.com/youhogeon/finance.kis_api/releases?q=kis_api)

### Artifacts
* kis_client : 코어 라이브러리 (필수)
* kis_api : `API Definition`이 담긴 라이브러리 (대부분의 경우 필수)
    * 본 라이브러리에서 사전 정의한 `API Definition`을 사용하지 않고 모든 API를 직접 정의([`사용자 정의 API Definition`](#사용자-정의-api-definition-추가-가이드) 참고)하여 사용하고자 하는 고급 사용자의 경우, `kis_api` artifact는 불필요합니다.

### 버전 선택 가이드
* 더 유연한 업데이트를 위해 `kis_client`와 `kis_api` artifact는 각기 다른 버전을 가집니다.
* 버전(`ver. x.y.z`)의 첫 번째(`x`), 두 번째 자리(`y`)가 일치하는 경우에만 호환성이 보장됩니다.
    * (ex) `kis_client:0.3.0`과 `kis_api:0.3.11`은 호환됩니다.
    * (ex) `kis_client:0.2.1`과 `kis_api:0.3.7`은 호환되지 않습니다.


## 📖 라이브러리 사용 가이드
### 1️⃣ Client 객체 생성
```java
Credentials credentials = new Credentials(
    "APPKEY",
    "SECRET",
    "account(계좌 앞 8자리)",
    "accountProductCode(계좌 뒤 2자리. ex: 일반계좌는 01)"
); // 인증 정보 생성

// 주문 없이 조회 API만 사용하는 경우 계좌 AppKey, AppSecret만 등록해도 됨.
// Credentials credentials = new Credentials("APPKEY", "SECRET");

Configuration config = new Configuration();
config.addCredentials(credentials); 

KisClient client = new KisClient(config);
```

#### (Optional) 다중 계좌인 경우
```java
Credentials c1 = new Credentials("APPKEY", "SECRET");
Credentials c2 = new Credentials("APPKEY", "SECRET");

Configuration config = new Configuration();

config.addCredentials(c1);
config.addCredentials(c2);

// 아래와 같이 Credentials에 이름을 지정하여 등록 가능.
// config.addCredentials("firstAccount", c1);
// config.addCredentials("secondAccount", c2);
// 
// 이 경우, API 호출 시 특정 이름을 가진 Credentials 로 API 호출 가능함.
// client.execute("secondAccount", new InquirePriceApi("005930")); // secondAccount Credentials로 실행

// 호출시 이름을 지정하지 않으면 CredentialsSelector 에 의해 Credentials가 자동 선택됨.
//
// 아래와 같이 사용할 CredentialsSelector 지정 가능.
// 또는 CredentialsSelector를 구현하는 custom 구현체를 직접 작성하여 추가 가능.
// 
// config.setCredentialsSelector(new RoundRobinCredentialsSelector()); // 기본값

KisClient client = new KisClient(config);
```

### 2️⃣ REST API 호출
> 하나, Api객체를 만든다. 둘, client.execute에 전달한다. 셋, 결과값을 받는다.
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

## 🔌 API 목록
지원하는 API 목록은 [여기](https://javadoc.io/doc/com.youhogeon.finance/kis_api) 에서 확인할 수 있습니다.

지원하지 않는 API에 대해서는 아래 [사용자 정의 API Definition 추가 가이드](#optional-사용자-정의-api-definition-추가-가이드)를 참고하십시오.

## ⚙️ 주요 설정
* Configuration
    * httpTimeout : HTTP Timeout (기본값: 10초)
    * httpTimeoutMaxRetries : HTTP Timeout 재시도 횟수 (기본값: 5)
    * socketTimeout : Socket Timeout (기본값: 10초)
    * maskCredentials : 로그에 인증 키를 마스킹처리할지 여부 (기본값: true)
* Credentials
    * appKey: API 앱 키
    * appSecret: API 앱 시크릿 키
    * accountNo: 계좌번호 앞 8자리
    * accountProductCode: 계좌상품코드(계좌번호 뒤 2자리. ex: 일반 위탁 계좌의 경우 01)
    * appToken: 인증 토큰. 비워두면 자동 발급됨. (인증 토큰을 미리 알고있는 경우 사용)
    * appTokenExpiredAt: 인증 토큰 만료시간
    * approvalKey: 실시간 API 인증 토큰
    * restLimitPerSecond: RestAPI 유량(초당 호출 제한 수)

## 🎓 (Optional) `사용자 정의 API Definition` 추가 가이드
한국투자증권에서 제공하는 모든 API를 본 라이브러리에서 지원하는 것이 목표이나, 현재 모든 API가 정의되어있지는 않습니다.

대신 아래와 같이 (라이브러리 사용자가 직접) API Definition을 Java class로 정의(`사용자 정의 API Definition`)하여를 사용할 수 있도록 설계되었습니다.

### REST API 추가
Api Class, Api Result Class 두 개의 클래스 모두 작성해야 합니다.

1. API Class 생성
    ```java
    @RestApi(method = RestApi.Method.POST, path = "/uapi/...")
    @AllArgsConstructor
    public class SampleApi extends CommonRestApi<SampleApiResult> { // 아래에서 만들 Result Class를 Generic으로 지정

        // @Header Annotation이 붙은 필드는 요청 헤더에 추가됨.
        @Header
        private String trId = "FHKST01010100";

        // @Parameter Annotation이 붙은 필드는 URL Parameter에 추가됨.
        @Parameter
        private String fidCondMrktDivCode = "UN";

        @Parameter
        private String fidInputIscd;

        // @Body Annotation이 붙은 필드는 요청 본문에 추가됨.
        @Body
        private String body1 = "...";

        @Body
        private String body2 = "...";

    }
    ```
1. API Result Class 생성
    ```java
    import lombok.Getter;

    @Getter
    public class SampleApiResult extends CommonResult {

        // @Header Annotation 을 사용해 응답 헤더에 있는 필드 정의.
        @Header
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


## ❓ 자주 묻는 질문 (사실은 아직 아무도 묻지 않았음.)
### 초당 호출 수 제한을 설정하고 싶어요.
* Rest API
    * `Credentials` 별로 초당 호출 수 제한을 설정할 수 있습니다.
        ```
        Credentials credentials = new Credentials(...);

        credentials.setRestLimitPerSecond(10);
        ```
* 실시간 API
    * 초당 호출 수 제한은 없습니다. (따라서 해당 기능도 없습니다.)
    * 데이터 최대 수신 건수(기본 41건)를 초과한 요청 발생 시 예외 발생합니다.

### 예외는 어떻게 처리해야 하나요?
* 모든 예외는 `KisClientException` (Unchecked Exception) 의 자식 타입입니다.
* 예외 처리 필요 시 try-catch 사용하시길 바랍니다.

### Thread-safe 한가요?
* 네

## 🗺️ Roadmap (TODO List)
* 예외 타입 세분화
* 일관성있는 로깅
* 테스트 커버리지 확대

## ⚠️ 면책조항
본 라이브러리의 사용으로 인하여 발생한 손해(버그 등으로 인한)에 대한 책임은 라이브러리 사용자에게 귀속됩니다.\
라이브러리 사용 시 위 면책조항에 동의하는 것으로 간주합니다.