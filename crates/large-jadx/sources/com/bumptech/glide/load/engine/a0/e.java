package com.bumptech.glide.load.engine.a0;

import android.util.Log;
import com.bumptech.glide.load.f;
import com.bumptech.glide.m.a;
import com.bumptech.glide.m.a.c;
import com.bumptech.glide.m.a.e;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    private final j a = new j();
    private final File b;
    private final long c;
    private final c d = new c();
    private a e;
    @Deprecated
    protected e(File file, long j) {
        super();
        final com.bumptech.glide.load.engine.a0.c cVar = new c();
        this.b = file;
        this.c = j;
        final com.bumptech.glide.load.engine.a0.j jVar = new j();
    }

    public static a c(File file, long j) {
        return new e(file, j, r3);
    }

    private synchronized a d() {
        if (this.e == null) {
            File file = 1;
            this.e = a.K(this.b, file, file, this.c);
        }
        return this.e;
    }

    public void a(f fVar, a.b bVar) {
        final String str4 = "DiskLruCacheWrapper";
        String str6 = this.a.b(fVar);
        this.d.a(str6);
        try {
            if (Log.isLoggable(str4, 2)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str8 = "Put: Obtained: ";
                str = " for for Key: ";
                str2 = str8 + str6 + str + fVar;
                Log.v(str4, str2);
            }
        } catch (java.io.IOException ioException) {
            bVar = 5;
        } finally {
            this.d.b(str5);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) ioException;
        }
        try {
            a aVar = d();
        } catch (java.io.IOException ioException) {
            bVar = 5;
        } finally {
            this.d.b(str5);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) ioException;
        }
        if (aVar.H(str6) != null) {
            this.d.b(str6);
            return;
        }
        try {
            a.c cVar2 = aVar.x(str6);
        } catch (java.io.IOException ioException) {
            bVar = 5;
        } finally {
            this.d.b(str5);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) ioException;
        }
        if (this.d == null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str7 = "Had two simultaneous puts for: ";
            bVar = str7 + str6;
            throw new IllegalStateException(bVar);
        } else {
            try {
                if (this.d.a(cVar2.f(0))) {
                    cVar2.e();
                }
            } catch (Throwable unused) {
            }
            try {
                cVar2.b();
                ioException.b();
                throw this.d;
            } catch (java.io.IOException ioException) {
                bVar = 5;
            } finally {
                this.d.b(str5);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) ioException;
            }
            this.d.b(str6);
            return;
        }
    }

    public File b(f fVar) {
        int i = 0;
        String str3 = this.a.b(fVar);
        final String str5 = "DiskLruCacheWrapper";
        if (Log.isLoggable(str5, 2)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str7 = "Get: Obtained: ";
            str = " for for Key: ";
            str2 = str7 + str3 + str + fVar;
            Log.v(str5, str2);
        }
        i = 0;
        try {
            a.e eVar = d().H(str3);
            File file = eVar.a(0);
        } catch (java.io.IOException ioException) {
            int str6 = 5;
            str6 = Log.isLoggable(str4, str6);
        }
        return i;
    }
}
