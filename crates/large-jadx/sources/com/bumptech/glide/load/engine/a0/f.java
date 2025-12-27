package com.bumptech.glide.load.engine.a0;

import android.content.Context;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class f extends d {

    class a implements d.a {

        final /* synthetic */ Context a;
        final /* synthetic */ String b;
        a(Context context, String str) {
            this.a = context;
            this.b = str;
            super();
        }

        public File a() throws java.io.IOException {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            if (this.b != null) {
                return new File(cacheDir, this.b);
            }
            return cacheDir;
        }
    }
    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L, obj);
    }

    public f(Context context, long j) {
        this(context, "image_manager_disk_cache", j, r4);
    }

    public f(Context context, String str, long j) {
        super(new f.a(context, str), j, r5);
    }
}
