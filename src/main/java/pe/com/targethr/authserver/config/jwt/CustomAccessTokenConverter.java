package pe.com.targethr.authserver.config.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.stereotype.Component;

@Component
public class CustomAccessTokenConverter extends DefaultAccessTokenConverter {

    @Override
    @SuppressWarnings("unchecked")
    public OAuth2Authentication extractAuthentication(Map<String, ?> claims) {
        Map<String, Object> procesedClaims = (Map<String, Object>) claims;
        List<String> authorities = new ArrayList<>();
        Map<String, Object> customClaims = (Map<String, Object>) procesedClaims.get("custom_info");
        String nivel = (String) customClaims.get("n");
        if ("1".equals(nivel)) {
            authorities.add("G1");
        }
        Boolean esJefe = (Boolean) customClaims.get("es_jefe");
        if (Boolean.TRUE.equals(esJefe)) {
            authorities.add("jefe");
        }
        procesedClaims.put(AccessTokenConverter.AUTHORITIES, authorities);
        OAuth2Authentication authentication = super.extractAuthentication(procesedClaims);
        authentication.setDetails(customClaims);
        return authentication;
    }
}