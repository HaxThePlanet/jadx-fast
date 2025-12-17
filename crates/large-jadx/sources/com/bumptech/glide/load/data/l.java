package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;

/* loaded from: classes.dex */
public abstract class l<T>  implements com.bumptech.glide.load.data.d<T> {

    private final Uri a;
    private final ContentResolver b;
    private T c;
    public l(ContentResolver contentResolver, Uri uri2) {
        super();
        this.b = contentResolver;
        this.a = uri2;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        final Object obj = this.c;
        if (obj != null) {
            c(obj);
        }
    }

    protected abstract void c(T t);

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public a d() {
        return a.LOCAL;
    }

    public final void e(h h, com.bumptech.glide.load.data.d.a<? super T> d$a2) {
        ContentResolver contentResolver;
        String str;
        Object obj3;
        try {
            obj3 = f(this.a, this.b);
            this.c = obj3;
            a2.f(obj3);
            int str2 = 3;
            str = "LocalUriFetcher";
            str2 = Log.isLoggable(str, str2);
            if (str2 != null) {
            }
            str2 = "Failed to open Uri";
            Log.d(str, str2, h);
            a2.c(h);
        }
    }

    protected abstract T f(Uri uri, ContentResolver contentResolver2);
}
