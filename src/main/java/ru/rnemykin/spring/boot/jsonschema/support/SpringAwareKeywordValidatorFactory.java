package ru.rnemykin.spring.boot.jsonschema.support;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.keyword.validator.KeywordValidator;
import com.github.fge.jsonschema.keyword.validator.KeywordValidatorFactory;
import org.springframework.context.ApplicationContext;

public class SpringAwareKeywordValidatorFactory implements KeywordValidatorFactory {
    private ApplicationContext springContext;
    private Class<? extends KeywordValidator> validatorClass;

    public SpringAwareKeywordValidatorFactory(ApplicationContext springContext, Class<? extends KeywordValidator> validatorClass) {
        this.springContext = springContext;
        this.validatorClass = validatorClass;
    }

    @Override
    public KeywordValidator getKeywordValidator(JsonNode node) {
        return springContext.getBean(validatorClass);
    }
}
