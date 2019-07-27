package pe.com.targethr.authserver.config;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import pe.com.targethr.authserver.config.filter.JsonToUrlEncodedAuthenticationFilter;
import pe.com.targethr.authserver.config.jwt.CustomAccessTokenConverter;
import pe.com.targethr.authserver.config.jwt.CustomTokenEnhancer;
import pe.com.targethr.authserver.dao.EmpleadoRepository;
import pe.com.targethr.authserver.dao.UsuarioRepository;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(AuthorizationServerConfiguration.class);

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomAccessTokenConverter customAccessTokenConverter;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${app.security.jwt.access-token-duration}")
    private int accessTokenDuration;

    @Value("${app.security.jwt.refresh-token-duration}")
    private int refreshTokenDuration;

    @Value("${app.security.jwt.signing-key}")
    private String signingKey;

    @Value("${app.security.browser-client-name}")
    private String browserClient;

    @Value("${app.security.browser-client-secret}")
    private String browserSecret;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.realm("Autorizacion de selfservice").tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("isAuthenticated()")
                .addTokenEndpointAuthenticationFilter(new JsonToUrlEncodedAuthenticationFilter(objectMapper));
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient(browserClient).secret(browserSecret)
                .authorizedGrantTypes("password", "refresh_token").scopes("read", "write", "update", "delete")
                .accessTokenValiditySeconds(accessTokenDuration).refreshTokenValiditySeconds(refreshTokenDuration);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        log.info("Entre a esta configuracion AuthorizationServerEndpointsConfigurer");
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), accessTokenConverter()));

        endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancerChain)
                .authenticationManager(authenticationManager).userDetailsService(userDetailsService);
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setAccessTokenConverter(customAccessTokenConverter);
        converter.setSigningKey(signingKey);
        return converter;
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer(usuarioRepository,empleadoRepository);
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }
}