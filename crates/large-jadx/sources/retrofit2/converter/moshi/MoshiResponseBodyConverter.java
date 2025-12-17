package retrofit2.converter.moshi;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.i.b;
import l.h;
import l.i;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/* loaded from: classes3.dex */
final class MoshiResponseBodyConverter<T>  implements Converter<ResponseBody, T> {

    private static final i UTF8_BOM;
    private final f<T> adapter;
    static {
        MoshiResponseBodyConverter.UTF8_BOM = i.e("EFBBBF");
    }

    MoshiResponseBodyConverter(f<T> f) {
        super();
        this.adapter = f;
    }

    @Override // retrofit2.Converter
    public Object convert(Object object) {
        return convert((ResponseBody)object);
    }

    public T convert(ResponseBody responseBody) {
        boolean z;
        h source = responseBody.source();
        final i uTF8_BOM = MoshiResponseBodyConverter.UTF8_BOM;
        if (source.K0(0, obj2)) {
            source.skip((long)i2);
        }
        i iVar = i.x(source);
        if (iVar.E() != i.b.END_DOCUMENT) {
        } else {
            responseBody.close();
            return this.adapter.b(iVar);
        }
        JsonDataException jsonDataException = new JsonDataException("JSON document was not fully consumed.");
        throw jsonDataException;
    }
}
