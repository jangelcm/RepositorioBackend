package pe.com.targethr.authserver.config.filter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class JsonToUrlEncodedAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(JsonToUrlEncodedAuthenticationFilter.class);

    private ObjectMapper objectMapper;

    public JsonToUrlEncodedAuthenticationFilter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        log.debug("Entrando al filtro de conversion application/json -> application/x-www-form-urlencoded");
        log.debug("content-type: {}", request.getContentType());
        if ("application/json".equals(request.getContentType())) {
            InputStream is = request.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[] json = buffer.toByteArray();

            Map<String, String> result = objectMapper.readValue(json, new TypeReference<HashMap<String, String>>() {
            });
            Map<String, String[]> r = new HashMap<>();
            for (String key : result.keySet()) {
                String[] val = new String[1];
                val[0] = result.get(key);
                r.put(key, val);
            }

            String[] val = new String[1];
            val[0] = request.getMethod();
            r.put("_method", val);

            HttpServletRequest s = new CustomServletRequestWrapper(((HttpServletRequest) request), r);
            filterChain.doFilter(s, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }

}