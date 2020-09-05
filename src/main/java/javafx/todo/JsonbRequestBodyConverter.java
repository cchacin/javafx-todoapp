package javafx.todo;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.json.bind.Jsonb;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

final class JsonbRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");

    private final Jsonb jsonb;
    private final Type type;

    JsonbRequestBodyConverter(
            Jsonb jsonb,
            Type type) {
        this.jsonb = jsonb;
        this.type = type;
    }

    @Override
    public RequestBody convert(
            T value) throws IOException {
        String json = this.jsonb.toJson(value, this.type);
        return RequestBody.create(MEDIA_TYPE, json.getBytes());
    }
}