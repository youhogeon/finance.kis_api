package com.youhogeon.finance.kis_api.client;

import org.junit.jupiter.api.Test;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.ApiParser;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.annotation.Body;
// import com.youhogeon.finance.kis_api.api.annotation.BodyCredentialsRequired;
// import com.youhogeon.finance.kis_api.api.annotation.HeaderCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.RestApi;
import com.youhogeon.finance.kis_api.context.ApiData;

class SampleApiResponse implements ApiResult {

}

@RestApi(path = "/sample", method = RestApi.Method.POST)
// @BodyCredentialsRequired
class SampleApi implements Api<SampleApiResponse>{

    @Header("test-header")
    public String header = "testHeaderValue";

    @Parameter("test-param")
    public String param = "testParamValue";

    @Body("test-body")
    public String body = "testBodyValue";

    @Header("test-header2")
    public String header2 = "testHeaderValue2";

    @Parameter("test-param2")
    public String param2 = "testParamValue2";

    @Body("test-body2")
    public String body2 = "testBodyValue2";

}

public class ApiParserTest {

    @Test
    public void sampleApiTest() {
        ApiParser parser = new ApiParser(new SampleApi());
        ApiData data = parser.parse();

        assert(data.getUrlPath().equals("/sample"));
        assert(data.getMethod().equals("POST"));

        assert(data.getHeaders().size() == 2);
        assert(data.getHeaders().get("test-header").equals("testHeaderValue"));
        assert(data.getHeaders().get("test-header2").equals("testHeaderValue2"));

        assert(data.getParameters().size() == 2);
        assert(data.getParameters().get("test-param").equals("testParamValue"));
        assert(data.getParameters().get("test-param2").equals("testParamValue2"));

        assert(data.getBody().size() == 2);
        assert(data.getBody().get("test-body").equals("testBodyValue"));
        assert(data.getBody().get("test-body2").equals("testBodyValue2"));

        // assert(data.hasAnnotation(BodyCredentialsRequired.class));
        // assert(!data.hasAnnotation(HeaderCredentialsRequired.class));
    }

}
