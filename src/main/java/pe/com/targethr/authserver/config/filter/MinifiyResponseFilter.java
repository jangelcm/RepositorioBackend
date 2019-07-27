package pe.com.targethr.authserver.config.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

public class MinifiyResponseFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(MinifiyResponseFilter.class);

    private ObjectMapper objectMapper;

    public MinifiyResponseFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingResponseWrapper wrapper = new ContentCachingResponseWrapper(response);
        filterChain.doFilter(request, wrapper);

        log.debug("Entrando al filtro de minificacion de respuesta de oauth/token");

        byte[] json = wrapper.getContentAsByteArray();
        JsonNode result = objectMapper.readValue(json, JsonNode.class);
        Map<String, Object> minifiedResult = new HashMap<>();

        minifiedResult.put("token_type", result.get("token_type").asText());
        minifiedResult.put("access_token", result.get("access_token").asText());
        minifiedResult.put("refresh_token", result.get("refresh_token").asText());
        minifiedResult.put("expires_in", result.get("expires_in").asInt());

        json = objectMapper.writeValueAsBytes(minifiedResult);

        wrapper.resetBuffer();
        ServletOutputStream outputStream = wrapper.getOutputStream();
        outputStream.write(json);
        outputStream.flush();
        outputStream.close();
        wrapper.copyBodyToResponse();
    }

}