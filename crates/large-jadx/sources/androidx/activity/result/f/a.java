package androidx.activity.result.f;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public abstract class a<I, O>  {

    public static final class a {

        private final T a;
        public a(T t) {
            super();
            this.a = t;
        }

        public T a() {
            return this.a;
        }
    }
    public abstract Intent a(Context context, I i2);

    public androidx.activity.result.f.a.a<O> b(Context context, I i2) {
        return 0;
    }

    public abstract O c(int i, Intent intent2);
}
