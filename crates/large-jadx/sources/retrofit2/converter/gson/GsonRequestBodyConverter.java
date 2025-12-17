package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import l.f;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
final class GsonRequestBodyConverter<T>  implements Converter<T, RequestBody> {

    private static final MediaType MEDIA_TYPE;
    private static final Charset UTF_8;
    private final TypeAdapter<T> adapter;
    private final Gson gson;
    static {
        GsonRequestBodyConverter.MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
        GsonRequestBodyConverter.UTF_8 = Charset.forName("UTF-8");
    }

    GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter2) {
        super();
        this.gson = gson;
        this.adapter = typeAdapter2;
    }

    @Override // retrofit2.Converter
    public Object convert(Object object) {
        return convert(object);
    }

    public RequestBody convert(T t) {
        f fVar = new f();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fVar.b2(), GsonRequestBodyConverter.UTF_8);
        JsonWriter jsonWriter = this.gson.newJsonWriter(outputStreamWriter);
        this.adapter.write(jsonWriter, t);
        jsonWriter.close();
        return RequestBody.create(GsonRequestBodyConverter.MEDIA_TYPE, fVar.Y0());
    }
}
