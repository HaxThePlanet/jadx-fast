package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
final class GsonResponseBodyConverter<T>  implements Converter<ResponseBody, T> {

    private final TypeAdapter<T> adapter;
    private final Gson gson;
    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter2) {
        super();
        this.gson = gson;
        this.adapter = typeAdapter2;
    }

    @Override // retrofit2.Converter
    public Object convert(Object object) {
        return convert((ResponseBody)object);
    }

    public T convert(ResponseBody responseBody) {
        JsonReader jsonReader = this.gson.newJsonReader(responseBody.charStream());
        if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
        } else {
            responseBody.close();
            return this.adapter.read(jsonReader);
        }
        JsonIOException jsonIOException = new JsonIOException("JSON document was not fully consumed.");
        throw jsonIOException;
    }
}
