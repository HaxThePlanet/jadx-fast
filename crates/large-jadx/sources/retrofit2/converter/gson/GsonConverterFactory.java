package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class GsonConverterFactory extends Converter.Factory {

    private final Gson gson;
    private GsonConverterFactory(Gson gson) {
        super();
        this.gson = gson;
    }

    public static retrofit2.converter.gson.GsonConverterFactory create() {
        Gson gson = new Gson();
        return GsonConverterFactory.create(gson);
    }

    public static retrofit2.converter.gson.GsonConverterFactory create(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        GsonConverterFactory gsonConverterFactory = new GsonConverterFactory(gson);
        return gsonConverterFactory;
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotation2Arr2, Annotation[] annotation3Arr3, Retrofit retrofit4) {
        GsonRequestBodyConverter obj2 = new GsonRequestBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
        return obj2;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotation2Arr2, Retrofit retrofit3) {
        GsonResponseBodyConverter obj2 = new GsonResponseBodyConverter(this.gson, this.gson.getAdapter(TypeToken.get(type)));
        return obj2;
    }
}
