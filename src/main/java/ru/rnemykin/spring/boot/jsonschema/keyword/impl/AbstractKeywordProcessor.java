package ru.rnemykin.spring.boot.jsonschema.keyword.impl;

import com.github.fge.jsonschema.keyword.validator.AbstractKeywordValidator;
import ru.rnemykin.spring.boot.jsonschema.keyword.KeywordProcessor;

public abstract class AbstractKeywordProcessor extends AbstractKeywordValidator implements KeywordProcessor {
    protected AbstractKeywordProcessor(String keyword) {
        super(keyword);
    }
}
