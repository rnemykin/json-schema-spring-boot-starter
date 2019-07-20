package ru.rnemykin.spring.boot.jsonschema;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(value = "json-schema.validation.enabled", havingValue = "true", matchIfMissing = true)
public class JsonSchemaAutoConfiguration {

}
