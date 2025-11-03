package com.example.seaprobe_tdd.controller;

import com.example.seaprobe_tdd.dto.ErrorResponse;
import com.example.seaprobe_tdd.dto.Probe;
import com.example.seaprobe_tdd.dto.ProbeRequestDTO;
import com.example.seaprobe_tdd.utils.Utils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProbeControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String baseUrl;

    @BeforeEach
    void setup(){
       this.baseUrl = "http://localhost:" + port;
    }

    @Test
    public void testOperateProbeSuccess() {
        ProbeRequestDTO request = Utils.convertJsonToObject("static/Controller/ProbeControllerRequest.json", ProbeRequestDTO.class);

        String url =  this.baseUrl +"/probe/operate";

        ResponseEntity<Probe> response = testRestTemplate.postForEntity(url, request, Probe.class);

        assertEquals(response.getStatusCode(),HttpStatus.OK);
        assertTrue(response.hasBody());
        Probe expectedResponse = Utils.convertJsonToObject("static/Controller/ProbeControllerResponse.json", Probe.class);

        Utils.compareProbes(expectedResponse, response.getBody());
    }

    @Test
    public void testOperateProbeObstacleFailure() {
        ProbeRequestDTO request = Utils.convertJsonToObject("static/Controller/Probe-obstacle-failure.request.json", ProbeRequestDTO.class);

        String url =  this.baseUrl +"/probe/operate";

        ResponseEntity<Probe> response = testRestTemplate.postForEntity(url, request, Probe.class);

        assertEquals(response.getStatusCode(),HttpStatus.BAD_REQUEST);
        ErrorResponse expectedResponse = Utils.convertJsonToObject("static/Controller/Probe-obstacle-failure.response.json", ErrorResponse.class);
        assertEquals("400", expectedResponse.getStatus());
        assertEquals("Invalid Request, Probe cannot be on obstacle", expectedResponse.getMessage());
    }

    @Test
    public void testOperateProbeOutOfGridFailure() {
        ProbeRequestDTO request = Utils.convertJsonToObject("static/Controller/operate-probes-out-of-grid-failure-request.json", ProbeRequestDTO.class);

        String url =  this.baseUrl +"/probe/operate";

        ResponseEntity<Probe> response = testRestTemplate.postForEntity(url, request, Probe.class);

        assertEquals(response.getStatusCode(),HttpStatus.BAD_REQUEST);
        ErrorResponse expectedResponse = Utils.convertJsonToObject("static/Controller/operate-probes-out-of-grid-failure-response.json", ErrorResponse.class);
        assertEquals("400", expectedResponse.getStatus());
        assertEquals("Invalid Request, Probe cannot be outside of the grid", expectedResponse.getMessage());
    }

}