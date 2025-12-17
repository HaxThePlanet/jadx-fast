package com.bumptech.glide.load.m;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.d.a;
import com.bumptech.glide.load.data.o.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.s.d;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class k implements com.bumptech.glide.load.m.n<Uri, File> {

    private final Context a;

    public static final class a implements com.bumptech.glide.load.m.o<Uri, File> {

        private final Context a;
        public a(Context context) {
            super();
            this.a = context;
        }

        public com.bumptech.glide.load.m.n<Uri, File> b(com.bumptech.glide.load.m.r r) {
            k obj2 = new k(this.a);
            return obj2;
        }
    }

    private static class b implements d<File> {

        private static final String[] c;
        private final Context a;
        private final Uri b;
        static {
            k.b.c = /* result */;
        }

        b(Context context, Uri uri2) {
            super();
            this.a = context;
            this.b = uri2;
        }

        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public a d() {
            return a.LOCAL;
        }

        public void e(h h, d.a<? super File> d$a2) {
            int string;
            Uri moveToFirst;
            Object obj7;
            obj7 = this.a.getContentResolver().query(this.b, k.b.c, 0, 0, 0);
            string = 0;
            if (obj7 != null && obj7.moveToFirst()) {
                if (obj7.moveToFirst()) {
                    string = obj7.getString(obj7.getColumnIndexOrThrow("_data"));
                }
                obj7.close();
            }
            if (TextUtils.isEmpty(string)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Failed to find file path for: ");
                stringBuilder.append(this.b);
                obj7 = new FileNotFoundException(stringBuilder.toString());
                a2.c(obj7);
            } else {
                obj7 = new File(string);
                a2.f(obj7);
            }
        }
    }
    public k(Context context) {
        super();
        this.a = context;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((Uri)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public com.bumptech.glide.load.m.n.a b(Object object, int i2, int i3, h h4) {
        return c((Uri)object, i2, i3, h4);
    }

    public com.bumptech.glide.load.m.n.a<File> c(Uri uri, int i2, int i3, h h4) {
        d obj4 = new d(uri);
        k.b obj5 = new k.b(this.a, uri);
        n.a obj3 = new n.a(obj4, obj5);
        return obj3;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(Uri uri) {
        return b.b(uri);
    }
}
