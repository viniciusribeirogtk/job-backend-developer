
package br.com.intelipost.user.details.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

@Configuration
public class JobBackendDeveloperBeanConfig {

	
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(JacksonProperties jacksonProperties) {
        return jacksonObjectMapperBuilder -> {
            String dateFormatStr = jacksonProperties.getDateFormat();
            DateTimeFormatter formatter =
                    StringUtils.isNotBlank(dateFormatStr) ? DateTimeFormatter.ofPattern(dateFormatStr) : null;
            jacksonObjectMapperBuilder.modules(
                    new JavaTimeModule()
                            .addSerializer(LocalDate.class, new LocalDateSerializer(formatter))
                            .addSerializer(LocalTime.class, new LocalTimeSerializer(formatter))
                            .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter))
                            .addDeserializer(LocalDate.class, new LocalDateDeserializer(formatter))
                            .addDeserializer(LocalTime.class, new LocalTimeDeserializer(formatter))
                            .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter))
            );
        };
}	
}
