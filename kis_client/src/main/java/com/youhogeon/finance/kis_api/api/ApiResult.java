package com.youhogeon.finance.kis_api.api;

/**
 * 모든 API 결과 class의 부모 인터페이스.
 *
 * KisClient.execute(...) 메서드의 응답으로 본 인터페이스 구현체의 인스턴스가 반환됨.
 *
 * Class의 field는 응답 본문의 필드 값으로 채워짐.
 * {@code @Header} 어노테이션을 사용한 필드는, 헤더의 필드 값으로 채워짐.
 *
 * <p>예시</p>
 * {@see com.youhogeon.finance.kis_api.api.rest.InquireBalanceResult}
 */
public interface ApiResult {

}