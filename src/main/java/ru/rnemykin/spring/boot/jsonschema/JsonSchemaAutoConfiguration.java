package ru.rnemykin.spring.boot.jsonschema;

import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.library.DraftV4Library;
import com.github.fge.jsonschema.library.Library;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@ConditionalOnProperty(value = "json-schema.validation.enabled", havingValue = "true", matchIfMissing = true)
public class JsonSchemaAutoConfiguration {
    @Value("${json-schema.library.uri}")
    private String libraryUri;


    @Bean
    @ConditionalOnMissingBean
    public Library draftV4Library() {
        return DraftV4Library.get().thaw().freeze();
    }

    @Bean
    public JsonSchemaFactory jsonSchemaFactory(Library library) {
        return JsonSchemaFactory.newBuilder()
                .setValidationConfiguration(
                        ValidationConfiguration.newBuilder()
                                .setDefaultLibrary(libraryUri, library)
                                .freeze()
                )
                .freeze();
    }
}
