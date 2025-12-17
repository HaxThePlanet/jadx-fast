package retrofit2.converter.moshi;

import com.squareup.moshi.f;
import com.squareup.moshi.o;
import l.f;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
final class MoshiRequestBodyConverter<T>  implements Converter<T, RequestBody> {

    private static final MediaType MEDIA_TYPE;
    private final f<T> adapter;
    static {
        MoshiRequestBodyConverter.MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    }

    MoshiRequestBodyConverter(f<T> f) {
        super();
        this.adapter = f;
    }

    @Override // retrofit2.Converter
    public Object convert(Object object) {
        return convert(object);
    }

    public RequestBody convert(T t) {
        f fVar = new f();
        this.adapter.i(o.o(fVar), t);
        return RequestBody.create(MoshiRequestBodyConverter.MEDIA_TYPE, fVar.Y0());
    }
}
