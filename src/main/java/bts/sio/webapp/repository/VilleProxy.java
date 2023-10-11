package bts.sio.webapp.repository;

import bts.sio.webapp.CustomProperties;
import bts.sio.webapp.model.Olympiade;
import bts.sio.webapp.model.Sport;
import bts.sio.webapp.model.Ville;
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
public class VilleProxy {
    @Autowired
    private CustomProperties props;

    /**
     * Get all Olympiade
     * @return An iterable of all Olympiade
     */
    public Iterable<Ville> getVilles() {

        String baseApiUrl = props.getApiUrl();
        String getVillesUrl = baseApiUrl + "/villes";
        System.out.println("url=" + getVillesUrl);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Ville>> response = restTemplate.exchange(
                getVillesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Ville>>() {}
        );

        log.debug("Get Villes call " + response.getStatusCode().toString());

        return response.getBody();
    }


    public Ville getVille(int id) {
        String baseApiUrl = props.getApiUrl();
        String getVilleUrl = baseApiUrl + "/Ville/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Ville> response = restTemplate.exchange(
                getVilleUrl,
                HttpMethod.GET,
                null,
                Ville.class
        );

        log.debug("Get Ville call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Add a new sport
     * @param a A new sport (without an id)
     * @return The sport full filled (with an id)
     */


    /**
     * Update an sport - using the PUT HTTP Method.
     * @param e Existing sport to update
     */
    public Ville updateVille(Ville e) {
        String baseApiUrl = props.getApiUrl();
        String updateVilleUrl = baseApiUrl + "/Ville/" + e.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Ville> request = new HttpEntity<Ville>(e);
        ResponseEntity<Ville> response = restTemplate.exchange(
                updateVilleUrl,
                HttpMethod.PUT,
                request,
                Ville.class);

        log.debug("Update Ville call " + response.getStatusCode().toString());

        return response.getBody();
    }
}

