package com.bumptech.glide.load.m;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.h;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes.dex */
public class u<Data>  implements com.bumptech.glide.load.m.n<String, Data> {

    private final com.bumptech.glide.load.m.n<Uri, Data> a;

    public static final class a implements com.bumptech.glide.load.m.o<String, AssetFileDescriptor> {
        public com.bumptech.glide.load.m.n<String, AssetFileDescriptor> b(com.bumptech.glide.load.m.r r) {
            u uVar = new u(r.d(Uri.class, AssetFileDescriptor.class));
            return uVar;
        }
    }

    public static class b implements com.bumptech.glide.load.m.o<String, ParcelFileDescriptor> {
        public com.bumptech.glide.load.m.n<String, ParcelFileDescriptor> b(com.bumptech.glide.load.m.r r) {
            u uVar = new u(r.d(Uri.class, ParcelFileDescriptor.class));
            return uVar;
        }
    }

    public static class c implements com.bumptech.glide.load.m.o<String, InputStream> {
        public com.bumptech.glide.load.m.n<String, InputStream> b(com.bumptech.glide.load.m.r r) {
            u uVar = new u(r.d(Uri.class, InputStream.class));
            return uVar;
        }
    }
    public u(com.bumptech.glide.load.m.n<Uri, Data> n) {
        super();
        this.a = n;
    }

    private static Uri e(String string) {
        char charAt;
        int scheme;
        Uri obj2;
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if (string.charAt(0) == 47) {
            obj2 = u.f(string);
        } else {
            charAt = Uri.parse(string);
            if (charAt.getScheme() == null) {
                obj2 = u.f(string);
            } else {
                obj2 = charAt;
            }
        }
        return obj2;
    }

    private static Uri f(String string) {
        File file = new File(string);
        return Uri.fromFile(file);
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return d((String)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public com.bumptech.glide.load.m.n.a b(Object object, int i2, int i3, h h4) {
        return c((String)object, i2, i3, h4);
    }

    public com.bumptech.glide.load.m.n.a<Data> c(String string, int i2, int i3, h h4) {
        boolean z;
        Uri obj2 = u.e(string);
        if (obj2 != null && !this.a.a(obj2)) {
            if (!this.a.a(obj2)) {
            }
            return this.a.b(obj2, i2, i3, h4);
        }
        return 0;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean d(String string) {
        return 1;
    }
}
