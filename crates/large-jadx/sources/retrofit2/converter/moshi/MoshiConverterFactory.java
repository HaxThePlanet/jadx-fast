package retrofit2.converter.moshi;

import com.squareup.moshi.f;
import com.squareup.moshi.r;
import com.squareup.moshi.r.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class MoshiConverterFactory extends Converter.Factory {

    private final boolean failOnUnknown;
    private final boolean lenient;
    private final r moshi;
    private final boolean serializeNulls;
    private MoshiConverterFactory(r r, boolean z2, boolean z3, boolean z4) {
        super();
        this.moshi = r;
        this.lenient = z2;
        this.failOnUnknown = z3;
        this.serializeNulls = z4;
    }

    public static retrofit2.converter.moshi.MoshiConverterFactory create() {
        r.a aVar = new r.a();
        return MoshiConverterFactory.create(aVar.b());
    }

    public static retrofit2.converter.moshi.MoshiConverterFactory create(r r) {
        Objects.requireNonNull(r, "moshi == null");
        final int i = 0;
        MoshiConverterFactory moshiConverterFactory = new MoshiConverterFactory(r, i, i, i);
        return moshiConverterFactory;
    }

    private static Set<? extends Annotation> jsonAnnotations(Annotation[] annotationArr) {
        int linkedHashSet;
        int i;
        Object obj;
        boolean annotationPresent;
        Class<com.squareup.moshi.h> obj2;
        Set obj6;
        linkedHashSet = 0;
        i = 0;
        while (i < annotationArr.length) {
            obj = annotationArr[i];
            if (obj.annotationType().isAnnotationPresent(h.class) && linkedHashSet == null) {
            }
            i++;
            if (linkedHashSet == null) {
            }
            linkedHashSet.add(obj);
            linkedHashSet = new LinkedHashSet();
        }
        if (linkedHashSet != null) {
            obj6 = Collections.unmodifiableSet(linkedHashSet);
        } else {
            obj6 = Collections.emptySet();
        }
        return obj6;
    }

    @Override // retrofit2.Converter$Factory
    public retrofit2.converter.moshi.MoshiConverterFactory asLenient() {
        MoshiConverterFactory moshiConverterFactory = new MoshiConverterFactory(this.moshi, 1, this.failOnUnknown, this.serializeNulls);
        return moshiConverterFactory;
    }

    @Override // retrofit2.Converter$Factory
    public retrofit2.converter.moshi.MoshiConverterFactory failOnUnknown() {
        MoshiConverterFactory moshiConverterFactory = new MoshiConverterFactory(this.moshi, this.lenient, 1, this.serializeNulls);
        return moshiConverterFactory;
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotation2Arr2, Annotation[] annotation3Arr3, Retrofit retrofit4) {
        f obj1;
        if (this.lenient) {
            obj1 = this.moshi.e(type, MoshiConverterFactory.jsonAnnotations(annotation2Arr2)).e();
        }
        if (this.failOnUnknown) {
            obj1 = obj1.a();
        }
        if (this.serializeNulls) {
            obj1 = obj1.g();
        }
        MoshiRequestBodyConverter obj2 = new MoshiRequestBodyConverter(obj1);
        return obj2;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotation2Arr2, Retrofit retrofit3) {
        f obj1;
        if (this.lenient) {
            obj1 = this.moshi.e(type, MoshiConverterFactory.jsonAnnotations(annotation2Arr2)).e();
        }
        if (this.failOnUnknown) {
            obj1 = obj1.a();
        }
        if (this.serializeNulls) {
            obj1 = obj1.g();
        }
        MoshiResponseBodyConverter obj2 = new MoshiResponseBodyConverter(obj1);
        return obj2;
    }

    @Override // retrofit2.Converter$Factory
    public retrofit2.converter.moshi.MoshiConverterFactory withNullSerialization() {
        MoshiConverterFactory moshiConverterFactory = new MoshiConverterFactory(this.moshi, this.lenient, this.failOnUnknown, 1);
        return moshiConverterFactory;
    }
}
