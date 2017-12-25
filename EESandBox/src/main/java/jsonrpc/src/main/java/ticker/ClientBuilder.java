package ticker;

import com.github.arteam.simplejsonrpc.client.JsonRpcClient;
import com.github.arteam.simplejsonrpc.client.Transport;
import com.google.common.net.MediaType;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ClientBuilder {

    private String url;

    public ClientBuilder(String url) {
        this.url = url;
    }

    public JsonRpcClient buildClient() {

        return new JsonRpcClient(new Transport() {

            CloseableHttpClient httpClient = HttpClients.createDefault();

            @NotNull
            @Override
            public String pass(@NotNull String request) throws IOException {
                HttpPost post = new HttpPost(url);
                post.setEntity(new StringEntity(request, Charsets.UTF_8));
                post.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.JSON_UTF_8.toString());
                try (CloseableHttpResponse httpResponse = httpClient.execute(post)) {
                    return EntityUtils.toString(httpResponse.getEntity(), Charsets.UTF_8);
                }
            }
        });
    }
}
