package com.bumptech.glide.load.engine.a0;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public final class f extends com.bumptech.glide.load.engine.a0.d {

    class a implements com.bumptech.glide.load.engine.a0.d.a {

        final Context a;
        final String b;
        a(Context context, String string2) {
            this.a = context;
            this.b = string2;
            super();
        }

        @Override // com.bumptech.glide.load.engine.a0.d$a
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            if (this.b != null) {
                File file = new File(cacheDir, this.b);
                return file;
            }
            return cacheDir;
        }
    }
    public f(Context context) {
        super(context, "image_manager_disk_cache", 262144000, obj2);
    }

    public f(Context context, long l2) {
        super(context, "image_manager_disk_cache", l2, obj4);
    }

    public f(Context context, String string2, long l3) {
        f.a aVar = new f.a(context, string2);
        super(aVar, l3, obj5);
    }
}
