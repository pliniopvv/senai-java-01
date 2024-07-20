package br.pvv.senai.saude.security;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

import br.pvv.senai.saude.services.UsuarioDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Value("${jwt.public.key}")
	private RSAPublicKey pub;

	@Value("${jwt.private.key}")
	private RSAPrivateKey priv;

	@Autowired
	private UsuarioDetailsService usuarioService;

	@Bean
	public AuthenticationManager authenticationManager() {
		var auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioService);
		auth.setPasswordEncoder(BCryptPasswordEncoder());
		return new ProviderManager(auth);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth

				.requestMatchers("/admin/**", "/nutricionistas/**", "/consultas/**", "/pacientes/**",
						"/minhas-consultas/**")
				.hasRole("ADMIN")

				// NUTRICIONISTA
				.requestMatchers("/consultas/**").hasRole("NUTRICIONISTA")
				.requestMatchers(HttpMethod.GET, "/nutricionistas/**", "/consultas/**").hasRole("NUTRICIONISTA")
				.requestMatchers(HttpMethod.PUT, "/nutricionistas/**").hasRole("NUTRICIONISTA")

				// PACIENTE
				.requestMatchers("/pacientes/**").hasRole("PACIENTE")
				.requestMatchers(HttpMethod.GET, "/nutricionistas/**", "/pacientes/**").hasRole("PACIENTE")
				.requestMatchers(HttpMethod.PUT, "/nutricionistas/**").hasRole("PACIENTE")

				// CADASTRO
				.requestMatchers(HttpMethod.POST, "/cadastro", "/login").permitAll()

				.anyRequest().authenticated()).csrf(csrf -> csrf.disable())
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}

	@Bean
	UserDetailsService users() {
		return new InMemoryUserDetailsManager(
				User.withUsername("user").password("{noop}password").authorities("app").build());
	}

	@Bean
	JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(pub).privateKey(this.priv).build();
		JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwkSource);
	}

	@Bean
	JwtDecoder JwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(pub).build();
	}

	@Bean
	BCryptPasswordEncoder BCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
