package br.com.elo7.controller;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.elo7.config.Application;
import br.com.elo7.dominio.Planalto;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class PlanaltoRestTest {

	@Value("${local.server.port}")
    private int port;
	
	@Before
    public void setUp() {
        RestAssured.port = port;
    }
	
	@Test
    public void deveCadastrarUmPlanalto() {
		Response response = given().contentType("application/json")
								.body(new Planalto(1, 1))
								.post("/planalto");
		Planalto planalto = response.as(Planalto.class);
		assertThat(planalto, is(notNullValue()));
		assertThat(planalto.getId(), is(notNullValue()));
		assertThat(response.getStatusCode(), is(equalTo(HttpStatus.SC_CREATED)));
    }
	
}
