package com.youhogeon.finance.kis_api.client;

import org.junit.jupiter.api.Test;

import com.youhogeon.finance.kis_api.api.Api;
import com.youhogeon.finance.kis_api.api.ApiResult;
import com.youhogeon.finance.kis_api.api.annotation.Body;
import com.youhogeon.finance.kis_api.api.annotation.BodyCredentialsRequired;
import com.youhogeon.finance.kis_api.api.annotation.Header;
import com.youhogeon.finance.kis_api.api.annotation.Method;
import com.youhogeon.finance.kis_api.api.annotation.Parameter;
import com.youhogeon.finance.kis_api.api.annotation.URL;

class SampleApiResponse implements ApiResult {

}

@URL(path = "/sample", method = Method.POST)
@BodyCredentialsRequired
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

        assert(parser.getUrlPath().equals("/sample"));
        assert(parser.getMethod().equals("POST"));

        assert(parser.getHeaders().size() == 2);
        assert(parser.getHeaders().get("test-header").equals("testHeaderValue"));
        assert(parser.getHeaders().get("test-header2").equals("testHeaderValue2"));

        assert(parser.getParameters().size() == 2);
        assert(parser.getParameters().get("test-param").equals("testParamValue"));
        assert(parser.getParameters().get("test-param2").equals("testParamValue2"));

        assert(parser.getBody().size() == 2);
        assert(parser.getBody().get("test-body").equals("testBodyValue"));
        assert(parser.getBody().get("test-body2").equals("testBodyValue2"));

        assert(parser.isBodyCredentialsRequired());
        assert(!parser.isNoCredentialsRequired());
    }

}
