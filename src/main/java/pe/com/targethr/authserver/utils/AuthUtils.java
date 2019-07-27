package pe.com.targethr.authserver.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

import pe.com.targethr.authserver.model.jwt.CustomClaims;

/**
 * AuthUtils
 */
public final class AuthUtils {

    public static CustomClaims getCustomClaims(Authentication auth, ObjectMapper mapper) {
        OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) auth.getDetails();
        return mapper.convertValue(oauthDetails.getDecodedDetails(), CustomClaims.class);
    }

}