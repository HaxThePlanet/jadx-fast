package com.bumptech.glide.load.m.y;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.o.b;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.r;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: QMediaStoreUriLoader.java */
/* loaded from: classes.dex */
public final class d<DataT> implements n<Uri, DataT> {

    private final Context a;
    private final n<File, DataT> b;
    private final n<Uri, DataT> c;
    private final Class<DataT> d;

    private static abstract class a<DataT> implements o<Uri, DataT> {

        private final Context a;
        private final Class<DataT> b;
        a(Context context, Class<DataT> cls) {
            super();
            this.a = context;
            this.b = cls;
        }

        public final n<Uri, DataT> b(r rVar) {
            return new d(this.a, rVar.d(File.class, this.b), rVar.d(Uri.class, this.b), this.b);
        }
    }

    private static final class d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        private static final String[] C;
        private volatile boolean A;
        private volatile com.bumptech.glide.load.data.d<DataT> B;
        private final Context a;
        private final n<File, DataT> b;
        private final n<Uri, DataT> c;
        private final Uri v;
        private final int w;
        private final int x;
        private final com.bumptech.glide.load.h y;
        private final Class<DataT> z;
        static {
            d.d.C = new String[] { "_data" };
        }

        d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i, int i2, com.bumptech.glide.load.h hVar, Class<DataT> cls) {
            super();
            this.a = context.getApplicationContext();
            this.b = nVar;
            this.c = nVar2;
            this.v = uri;
            this.w = i;
            this.x = i2;
            this.y = hVar;
            this.z = cls;
        }

        private n.a<DataT> c() {
            Uri requireOriginal;
            if (Environment.isExternalStorageLegacy()) {
                return this.b.b(h(this.v), this.w, this.x, this.y);
            }
            if (g()) {
                requireOriginal = MediaStore.setRequireOriginal(this.v);
            } else {
            }
            return this.c.b(requireOriginal, this.w, this.x, this.y);
        }

        private com.bumptech.glide.load.data.d<DataT> f() {
            com.bumptech.glide.load.data.d dVar = null;
            n.a aVar = c();
            com.bumptech.glide.load.data.d r0 = aVar != null ? aVar.c : 0;
            return (aVar != null ? aVar.c : 0);
        }

        private boolean g() {
            boolean z = true;
            int r0 = this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0 ? 1 : 0;
            return (this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0 ? 1 : 0);
        }

        private File h(Uri uri) {
            try {
                Cursor query = this.a.getContentResolver().query(uri, d.d.C, null, null, null);
                String string = query.getString(query.getColumnIndexOrThrow("_data"));
            } catch (Throwable th) {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            String str3 = "Failed to media store entry for: ";
            th = str3 + th;
            throw new FileNotFoundException(th);
        }

        public Class<DataT> a() {
            return this.z;
        }

        public void b() {
            if (this.B != null) {
                this.B.b();
            }
        }

        public void cancel() {
            this.A = true;
            if (this.B != null) {
                this.B.cancel();
            }
        }

        public a d() {
            return a.LOCAL;
        }

        public void e(com.bumptech.glide.h hVar, d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d dVar = f();
                if (dVar == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Failed to build fetcher for: ";
                    r0 = str + this.v;
                    aVar.c(new IllegalArgumentException(r0));
                    return;
                }
                this.B = dVar;
                cancel();
                dVar.e(hVar, aVar);
            } catch (java.io.FileNotFoundException fileNotFound) {
                aVar.c(fileNotFound);
            }
        }
    }

    public static final class b extends d.a<android.os.ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class c extends d.a<java.io.InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }
    d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        super();
        this.a = context.getApplicationContext();
        this.b = nVar;
        this.c = nVar2;
        this.d = cls;
    }

    public n.a<DataT> c(Uri uri, int i, int i2, com.bumptech.glide.load.h hVar) {
        final Object uri3 = this;
        d.d dVar = new d.d(uri3.a, uri3.b, uri3.c, uri, i, i2, hVar, uri3.d);
        return new n.a(new d(uri), dVar);
    }

    public boolean d(Uri uri) {
        boolean z2 = false;
        uri = Build.VERSION.SDK_INT >= 29 && b.b(uri) ? 1 : 0;
        return (Build.VERSION.SDK_INT >= 29 && b.b(uri) ? 1 : 0);
    }
}
