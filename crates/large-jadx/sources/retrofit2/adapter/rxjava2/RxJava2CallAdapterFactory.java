package retrofit2.adapter.rxjava2;

import i.b.z;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.CallAdapter;
import retrofit2.CallAdapter.Factory;
import retrofit2.Retrofit;

/* loaded from: classes3.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {

    private final boolean isAsync;
    private final z scheduler;
    private RxJava2CallAdapterFactory(z z, boolean z2) {
        super();
        this.scheduler = z;
        this.isAsync = z2;
    }

    public static retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory create() {
        RxJava2CallAdapterFactory rxJava2CallAdapterFactory = new RxJava2CallAdapterFactory(0, 0);
        return rxJava2CallAdapterFactory;
    }

    public static retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory createAsync() {
        RxJava2CallAdapterFactory rxJava2CallAdapterFactory = new RxJava2CallAdapterFactory(0, 1);
        return rxJava2CallAdapterFactory;
    }

    public static retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory createWithScheduler(z z) {
        Objects.requireNonNull(z, "scheduler == null");
        RxJava2CallAdapterFactory rxJava2CallAdapterFactory = new RxJava2CallAdapterFactory(z, 0);
        return rxJava2CallAdapterFactory;
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotation2Arr2, Retrofit retrofit3) {
        Type type2;
        int i2;
        int i4;
        int i3;
        int i;
        int i5;
        Type obj13;
        boolean obj14;
        Class<retrofit2.Response> obj15;
        obj14 = CallAdapter.Factory.getRawType(type);
        if (obj14 == b.class) {
            super(Void.class, this.scheduler, this.isAsync, 0, 1, 0, 0, 0, 1);
            return obj13;
        }
        int i6 = 1;
        int i7 = 0;
        i3 = obj14 == h.class ? i6 : i7;
        i = obj14 == a0.class ? i6 : i7;
        i5 = obj14 == l.class ? i6 : i7;
        if (obj14 != r.class && i3 == 0 && i == 0 && i5 == 0) {
            if (i3 == 0) {
                if (i == 0) {
                    if (i5 == 0) {
                        return 0;
                    }
                }
            }
        }
        if (!type instanceof ParameterizedType) {
            if (i3 == 0) {
                if (i == 0) {
                    obj13 = i5 != 0 ? "Maybe" : "Observable";
                } else {
                    obj13 = "Single";
                }
            } else {
                obj13 = "Flowable";
            }
            obj15 = new StringBuilder();
            obj15.append(obj13);
            obj15.append(" return type must be parameterized as ");
            obj15.append(obj13);
            obj15.append("<Foo> or ");
            obj15.append(obj13);
            obj15.append("<? extends Foo>");
            obj14 = new IllegalStateException(obj15.toString());
            throw obj14;
        }
        obj13 = CallAdapter.Factory.getParameterUpperBound(i7, (ParameterizedType)type);
        obj14 = CallAdapter.Factory.getRawType(obj13);
        if (obj14 == Response.class) {
            if (!obj13 instanceof ParameterizedType) {
            } else {
                type2 = obj13;
                i4 = i2;
                super(type2, this.scheduler, this.isAsync, i2, i4, i3, i, i5, 0);
                return obj13;
            }
            obj13 = new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            throw obj13;
        }
        if (obj14 == Result.class) {
            if (!obj13 instanceof ParameterizedType) {
            } else {
                type2 = obj13;
                i2 = i6;
                i4 = i7;
            }
            obj13 = new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            throw obj13;
        }
        type2 = obj13;
        i4 = i6;
        i2 = i7;
    }
}
