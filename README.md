# Json schema spring boot starter
 Auto configuration for [json-schema-validator](https://github.com/java-json-tools/json-schema-validator)

### How to use
1.  Dependency
```xml
<dependency>
    <groupId>ru.rnemykin.spring.boot</groupId>
    <artifactId>json-schema-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

2. Use default configuration or define your own
```java
@Bean
    public Library library(KeywordProcessor processor, ApplicationContext ctx) {
        LibraryBuilder builder = DraftV4Library.get().thaw();
        builder.addKeyword(
                Keyword.newBuilder(processor.keyword())
                        .withSyntaxChecker(...)
                        .withDigester(...)
                        .withValidatorFactory(new SpringAwareKeywordValidatorFactory(...)
                        .freeze()
        );
        return builder.freeze();
    }
```

3. Write custom keywordValidators 
```java
@ToString
@Component
public class EnumDbValueKeywordProcessor extends AbstractKeywordProcessor {
   .....
}
```

4. Do validation (see [example](https://github.com/rnemykin/spring-json-schema-validation))
```java
@Autowired
private JsonSchemaFactory jsonSchemaFactory;
//...
ProcessingReport report = jsonSchemaFactory.getValidator().validate(schema, entity);
```
