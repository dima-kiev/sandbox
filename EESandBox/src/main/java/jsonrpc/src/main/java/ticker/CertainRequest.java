package ticker;

import com.github.arteam.simplejsonrpc.client.JsonRpcClient;

public class CertainRequest {

    private JsonRpcClient client;
    private String methName = "METH";

    public CertainRequest(JsonRpcClient client) {
        this.client = client;
    }


    public boolean setVarAndPerform(String variant) {

        ResponceEntity resp = client.createRequest()
                .method(methName)
                .id(methName)
                .param("passwcheck", variant)
                .param("timeParam", 20)
                .returnAs(ResponceEntity.class)
                .execute();

        return resp.getCode() == 0;
    }
}
