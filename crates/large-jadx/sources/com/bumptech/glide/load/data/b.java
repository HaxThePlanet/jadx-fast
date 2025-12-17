package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;

/* loaded from: classes.dex */
public abstract class b<T>  implements com.bumptech.glide.load.data.d<T> {

    private final String a;
    private final AssetManager b;
    private T c;
    public b(AssetManager assetManager, String string2) {
        super();
        this.b = assetManager;
        this.a = string2;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        final Object obj = this.c;
        if (obj == null) {
        }
        c(obj);
    }

    protected abstract void c(T t);

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public a d() {
        return a.LOCAL;
    }

    public void e(h h, com.bumptech.glide.load.data.d.a<? super T> d$a2) {
        String str3;
        String str;
        Object obj3;
        try {
            obj3 = f(this.b, this.a);
            this.c = obj3;
            a2.f(obj3);
            int str2 = 3;
            str = "AssetPathFetcher";
            str2 = Log.isLoggable(str, str2);
            if (str2 != null) {
            }
            str2 = "Failed to load data from asset manager";
            Log.d(str, str2, h);
            a2.c(h);
        }
    }

    protected abstract T f(AssetManager assetManager, String string2);
}
