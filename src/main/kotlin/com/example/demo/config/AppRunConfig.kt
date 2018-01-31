package com.example.demo.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import java.io.FileInputStream
import java.io.IOException
import java.util.*

@Configuration
class AppRunConfig {

    @Bean
    fun propertySourcesPlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer {
        val configurer = PropertySourcesPlaceholderConfigurer()
        val properties = Properties()
        loadPropertiesFromFile("./src/main/resources/demo.properties", properties)
        configurer.setProperties(properties)
        return configurer
    }


    fun loadPropertiesFromFile(path: String, properties: Properties) {
        try {
            FileInputStream(path).use({ file ->
                val loadProperties = Properties()
                loadProperties.load(file)
                file.close()
                properties.putAll(loadProperties)
            })
        } catch (e: IOException) {
            throw e
        } catch (e: Exception) {
            throw e
        }


    }
}