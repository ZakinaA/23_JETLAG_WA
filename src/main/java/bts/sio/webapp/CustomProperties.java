package bts.sio.webapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="bts.sio.webapp")
public class CustomProperties {

	private String apiUrl;
	
}
