package com.bumptech.glide.load.engine.a0;

import android.util.Log;
import com.bumptech.glide.load.f;
import com.bumptech.glide.m.a;
import com.bumptech.glide.m.a.c;
import com.bumptech.glide.m.a.e;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class e implements com.bumptech.glide.load.engine.a0.a {

    private final com.bumptech.glide.load.engine.a0.j a;
    private final File b;
    private final long c;
    private final com.bumptech.glide.load.engine.a0.c d;
    private a e;
    @Deprecated
    protected e(File file, long l2) {
        super();
        c cVar = new c();
        this.d = cVar;
        this.b = file;
        this.c = l2;
        j obj2 = new j();
        this.a = obj2;
    }

    public static com.bumptech.glide.load.engine.a0.a c(File file, long l2) {
        e eVar = new e(file, l2, obj3);
        return eVar;
    }

    private a d() {
        a aVar;
        long l;
        int i;
        synchronized (this) {
            try {
                i = 1;
                this.e = a.K(this.b, i, i, this.c);
                return this.e;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.load.engine.a0.a
    public void a(f f, com.bumptech.glide.load.engine.a0.a.b a$b2) {
        boolean stringBuilder;
        String str;
        Object obj5;
        boolean obj6;
        final String str2 = "DiskLruCacheWrapper";
        String str3 = this.a.b(f);
        this.d.a(str3);
        if (Log.isLoggable(str2, 2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Put: Obtained: ");
            stringBuilder.append(str3);
            stringBuilder.append(" for for Key: ");
            stringBuilder.append(f);
            Log.v(str2, stringBuilder.toString());
        }
        obj5 = d();
        if (obj5.H(str3) != null) {
            this.d.b(str3);
        }
        obj5 = obj5.x(str3);
        if (obj5 == null) {
        } else {
            if (b2.a(obj5.f(0))) {
                obj5.e();
            }
            obj5.b();
            this.d.b(str3);
        }
        obj6 = new StringBuilder();
        obj6.append("Had two simultaneous puts for: ");
        obj6.append(str3);
        obj5 = new IllegalStateException(obj6.toString());
        throw obj5;
    }

    @Override // com.bumptech.glide.load.engine.a0.a
    public File b(f f) {
        a.e eVar;
        boolean stringBuilder;
        a aVar;
        String str;
        Object obj5;
        String str2 = this.a.b(f);
        final String str3 = "DiskLruCacheWrapper";
        if (Log.isLoggable(str3, 2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Get: Obtained: ");
            stringBuilder.append(str2);
            stringBuilder.append(" for for Key: ");
            stringBuilder.append(f);
            Log.v(str3, stringBuilder.toString());
        }
        obj5 = 0;
        eVar = d().H(str2);
        if (eVar != null) {
            obj5 = eVar.a(0);
        }
        return obj5;
    }
}
