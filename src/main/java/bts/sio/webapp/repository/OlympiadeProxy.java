package bts.sio.webapp.repository;
import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.Athlete;
import bts.sio.webapp.model.Olympiade;
import bts.sio.webapp.model.Sport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class OlympiadeProxy {
    @Autowired
    private CustomProperties props;

    /**
     * Get all Olympiade
     * @return An iterable of all Olympiade
     */
    public Iterable<Olympiade> getLesOlympiades() {

        String baseApiUrl = props.getApiUrl();
        String getOlympiadeUrl = baseApiUrl + "/olympiades";
        System.out.println("url=" + getOlympiadeUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Olympiade>> response = restTemplate.exchange(
                getOlympiadeUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Olympiade>>() {}
        );

        log.debug("Get Olympiades call " + response.getStatusCode().toString());

        return response.getBody();
    }
    public Olympiade getOlympiade(int id) {
        String baseApiUrl = props.getApiUrl();
        String getOlympiadeUrl = baseApiUrl + "/olympiade/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Olympiade> response = restTemplate.exchange(
                getOlympiadeUrl,
                HttpMethod.GET,
                null,
                Olympiade.class
        );

        log.debug("Get Sport call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Add a new sport
     * @param o A new olympiade (without an id)
     * @return The sport full filled (with an id)
     */
    public Olympiade createOlympiade(Olympiade o) {

        String baseApiUrl = props.getApiUrl();
        String createOlympiadeUrl = baseApiUrl + "/olympiade";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Olympiade> request = new HttpEntity<Olympiade>(o);
        ResponseEntity<Olympiade> response = restTemplate.exchange(
                createOlympiadeUrl,
                HttpMethod.POST,
                request,
                Olympiade.class);

        log.debug("Create Olympiade call " + response.getStatusCode().toString());

        return response.getBody();
    }
    /**
     * Update an olympiade - using the PUT HTTP Method.
     * @param o Existing olympiade to update
     */
    public Olympiade updateOlympiade(Olympiade o) {
        String baseApiUrl = props.getApiUrl();
        String updateOlympiadeUrl = baseApiUrl + "/olympiade/" + o.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Olympiade> request = new HttpEntity<Olympiade>(o);
        ResponseEntity<Olympiade> response = restTemplate.exchange(
                updateOlympiadeUrl,
                HttpMethod.PUT,
                request,
                Olympiade.class);

        log.debug("Update Olympiade call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /*
     * Delete an sport using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     * @param e The sport to delete
     */
    public void deleteOlympiade(int id) {
        String baseApiUrl = props.getApiUrl();
        String deleteOlympiadeUrl = baseApiUrl + "/olympiade/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteOlympiadeUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        log.debug("Delete Olympiade call " + response.getStatusCode().toString());
    }
}
