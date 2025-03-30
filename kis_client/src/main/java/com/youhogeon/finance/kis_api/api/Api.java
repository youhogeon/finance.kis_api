package com.youhogeon.finance.kis_api.api;

/**
 * 모든 API 클래스의 부모 인터페이스.
 *
 * KisClient.execute() 메서드에 본 인터페이스 구현체의 인스턴스를 전달하면
 * API 요청이 전송되고 응답이 {@code ApiResult} (Generic으로 전달한 타입)로 반환됨.
 *
 * <p>{@code @RestApi}, {@code @RealTimeApi} 어노테이션 중 한 개를 사용하여 API의 URL과 HTTP 메서드를 지정해야 함.</p>
 * <p>{@code @Header}, {@code @Parameter}, {@code @Body} 어노테이션을 사용하여 API 데이터 SPEC을 지정해야 함.</p>
 * <p>AppKey가 필요한 API의 경우 {@code @AppKeyRequired} 어노테이션을 사용해야 함. (별도 필드 생성 불필요)</p>
 * <p>AppSecret이 필요한 API의 경우 {@code @AppSecretRequired} 어노테이션을 사용해야 함. (별도 필드 생성 불필요)</p>
 * <p>AppToken이 필요한 API의 경우 {@code @AppTokenRequired} 어노테이션을 사용해야 함. (별도 필드 생성 불필요)</p>
 * <p>ApprovalKey가 필요한 API의 경우 {@code @ApprovalKeyRequired} 어노테이션을 사용해야 함. (별도 필드 생성 불필요)</p>
 * <p>계좌 정보가 필요한 API의 경우 {@code @AccountRequired} 어노테이션을 사용해야 함. (별도 필드 생성 불필요)</p>
 *
 * <p>예시:</p>
 * {@see com.youhogeon.finance.kis_api.api.rest.InquireBalanceApi}
 */
public interface Api<T extends ApiResult> {

}