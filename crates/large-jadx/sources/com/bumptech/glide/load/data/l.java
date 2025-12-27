package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: LocalUriFetcher.java */
/* loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    private final Uri a;
    private final ContentResolver b;
    private T c;
    public l(ContentResolver contentResolver, Uri uri) {
        super();
        this.b = contentResolver;
        this.a = uri;
    }

    public void b() {
        if (this.c != null) {
            try {
                c(this.c);
            } catch (java.io.IOException unused) {
                return;
            }
        }
    }

    public a d() {
        return a.LOCAL;
    }

    public final void e(h hVar, d.a<? super T> aVar) {
        String str2;
        try {
            Object obj = f(this.a, this.b);
            this.c = obj;
            aVar.f(obj);
        } catch (java.io.FileNotFoundException fileNotFound) {
            int str = 3;
            str2 = "LocalUriFetcher";
            str = Log.isLoggable(str2, str);
        }
    }

    protected abstract void c(T t);

    public void cancel() {
    }

    protected abstract T f(Uri uri, ContentResolver contentResolver);
}
