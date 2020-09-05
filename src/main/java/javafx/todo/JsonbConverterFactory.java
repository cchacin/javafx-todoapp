package javafx.todo;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;

public final class JsonbConverterFactory extends Converter.Factory {

    public static JsonbConverterFactory create() {
        return create(JsonbBuilder.create());
    }

    public static JsonbConverterFactory create(
            Jsonb jsonb) {
        Objects.requireNonNull(jsonb, "Jsonb instance can not be null");
        return new JsonbConverterFactory(jsonb);
    }

    private final Jsonb jsonb;

    private JsonbConverterFactory(
            Jsonb jsonb) {
        this.jsonb = jsonb;
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            Type type,
            Annotation[] annotations,
            Retrofit retrofit) {
        return new JsonbResponseBodyConverter<>(jsonb, type);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(
            Type type,
            Annotation[] parameterAnnotations,
            Annotation[] methodAnnotations,
            Retrofit retrofit) {
        return new JsonbRequestBodyConverter<>(jsonb, type);
    }
}