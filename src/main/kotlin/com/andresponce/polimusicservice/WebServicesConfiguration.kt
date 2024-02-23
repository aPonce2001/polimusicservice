package com.andresponce.polimusicservice

import com.andresponce.polimusicservice.webservices.SongsWebService
import jakarta.xml.ws.Endpoint
import org.apache.cxf.Bus
import org.apache.cxf.jaxws.EndpointImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WebServicesConfiguration {

    @Autowired
    private lateinit var bus: Bus

    @Bean
    public fun songsWebService(): SongsWebService {
        return SongsWebService()
    }

    @Bean
    public fun songsServiceEndpoint(): Endpoint {
        val endpoint = EndpointImpl(bus, songsWebService())
        endpoint.publish("/songs")
        return endpoint
    }
}