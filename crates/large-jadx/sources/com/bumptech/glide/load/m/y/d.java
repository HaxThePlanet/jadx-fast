package com.bumptech.glide.load.m.y;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.o.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.m.n;
import com.bumptech.glide.load.m.n.a;
import com.bumptech.glide.load.m.o;
import com.bumptech.glide.load.m.r;
import com.bumptech.glide.s.d;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class d<DataT>  implements n<Uri, DataT> {

    private final Context a;
    private final n<File, DataT> b;
    private final n<Uri, DataT> c;
    private final Class<DataT> d;

    private static abstract class a implements o<Uri, DataT> {

        private final Context a;
        private final Class<DataT> b;
        a(Context context, Class<DataT> class2) {
            super();
            this.a = context;
            this.b = class2;
        }

        public final n<Uri, DataT> b(r r) {
            d dVar = new d(this.a, r.d(File.class, this.b), r.d(Uri.class, this.b), this.b);
            return dVar;
        }
    }

    private static final class d implements d<DataT> {

        private static final String[] C;
        private volatile boolean A;
        private volatile d<DataT> B;
        private final Context a;
        private final n<File, DataT> b;
        private final n<Uri, DataT> c;
        private final Uri v;
        private final int w;
        private final int x;
        private final h y;
        private final Class<DataT> z;
        static {
            d.d.C = /* result */;
        }

        d(Context context, n<File, DataT> n2, n<Uri, DataT> n3, Uri uri4, int i5, int i6, h h7, Class<DataT> class8) {
            super();
            this.a = context.getApplicationContext();
            this.b = n2;
            this.c = n3;
            this.v = uri4;
            this.w = i5;
            this.x = i6;
            this.y = h7;
            this.z = class8;
        }

        private n.a<DataT> c() {
            Uri requireOriginal;
            if (Environment.isExternalStorageLegacy() != null) {
                return this.b.b(h(this.v), this.w, this.x, this.y);
            }
            if (g()) {
                requireOriginal = MediaStore.setRequireOriginal(this.v);
            } else {
                requireOriginal = this.v;
            }
            return this.c.b(requireOriginal, this.w, this.x, this.y);
        }

        private d<DataT> f() {
            d dVar;
            n.a aVar = c();
            dVar = aVar != null ? aVar.c : 0;
            return dVar;
        }

        private boolean g() {
            int i;
            i = this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0 ? 1 : 0;
            return i;
        }

        private File h(Uri uri) {
            Context moveToFirst;
            int i = 0;
            Cursor query = this.a.getContentResolver().query(uri, d.d.C, 0, 0, 0);
            if (query == null) {
            } else {
                try {
                    if (!query.moveToFirst()) {
                    } else {
                    }
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    if (TextUtils.isEmpty(string)) {
                    } else {
                    }
                    File obj9 = new File(string);
                    if (query != null) {
                    }
                    query.close();
                    return obj9;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("File path was empty in media store for: ");
                    stringBuilder2.append(uri);
                    FileNotFoundException fileNotFoundException2 = new FileNotFoundException(stringBuilder2.toString());
                    throw fileNotFoundException2;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to media store entry for: ");
                    stringBuilder.append(uri);
                    FileNotFoundException fileNotFoundException = new FileNotFoundException(stringBuilder.toString());
                    throw fileNotFoundException;
                    if (obj0 == null) {
                    } else {
                    }
                    obj0.close();
                    throw uri;
                }
            }
        }

        public Class<DataT> a() {
            return this.z;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            final d dVar = this.B;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.A = true;
            d dVar = this.B;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public a d() {
            return a.LOCAL;
        }

        public void e(h h, d.a<? super DataT> d$a2) {
            h obj3;
            try {
                d dVar = f();
                if (dVar == null) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to build fetcher for: ");
                stringBuilder.append(this.v);
                obj3 = new IllegalArgumentException(stringBuilder.toString());
                a2.c(obj3);
                this.B = dVar;
                if (this.A) {
                } else {
                }
                cancel();
                dVar.e(h, a2);
                a2.c(h);
            }
        }
    }

    public static final class b extends com.bumptech.glide.load.m.y.d.a<android.os.ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class c extends com.bumptech.glide.load.m.y.d.a<java.io.InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }
    d(Context context, n<File, DataT> n2, n<Uri, DataT> n3, Class<DataT> class4) {
        super();
        this.a = context.getApplicationContext();
        this.b = n2;
        this.c = n3;
        this.d = class4;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((Uri)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public n.a b(Object object, int i2, int i3, h h4) {
        return c((Uri)object, i2, i3, h4);
    }

    public n.a<DataT> c(Uri uri, int i2, int i3, h h4) {
        final Object obj = this;
        d dVar = new d(uri);
        super(obj.a, obj.b, obj.c, uri, i2, i3, h4, obj.d);
        n.a aVar = new n.a(dVar, dVar3);
        return aVar;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(Uri uri) {
        Uri obj3;
        if (Build.VERSION.SDK_INT >= 29 && b.b(uri)) {
            obj3 = b.b(uri) ? 1 : 0;
        } else {
        }
        return obj3;
    }
}
