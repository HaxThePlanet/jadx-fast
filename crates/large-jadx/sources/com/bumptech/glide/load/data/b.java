package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    private final String a;
    private final AssetManager b;
    private T c;
    public b(AssetManager assetManager, String str) {
        super();
        this.b = assetManager;
        this.a = str;
    }

    public void b() {
        if (this.c == null) {
            return;
        }
        try {
            c(this.c);
        } catch (java.io.IOException unused) {
            return;
        }
    }

    public a d() {
        return a.LOCAL;
    }

    public void e(h hVar, d.a<? super T> aVar) {
        String str3;
        try {
            Object obj = f(this.b, this.a);
            this.c = obj;
            aVar.f(obj);
        } catch (java.io.IOException ioException) {
            int str2 = 3;
            str3 = "AssetPathFetcher";
            str2 = Log.isLoggable(str3, str2);
        }
    }

    protected abstract void c(T t);

    public void cancel() {
    }

    protected abstract T f(AssetManager assetManager, String str);
}
