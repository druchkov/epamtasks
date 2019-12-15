package webservice.application;

import kong.unirest.HttpResponse;
import kong.unirest.UnirestInstance;

public class ApplicationClient {

    private UnirestInstance httpClient;
    private String url;

    public ApplicationClient(UnirestInstance httpClient) {
        this.httpClient = httpClient;
        this.url = "http://52.202.21.1:8080/swagger-ui.html#";
    }

    public void createApplication(Application application) {
        httpClient.post(url).body(application).asEmpty();
    }

    public void updateApplicationName(Application application, String newName) {
        application.setName(newName);
        httpClient.put(url).body(application).asEmpty();
    }

    public void deleteApplicationName(Integer idApplication) {
        httpClient.delete(idApplication.toString());
    }


}
