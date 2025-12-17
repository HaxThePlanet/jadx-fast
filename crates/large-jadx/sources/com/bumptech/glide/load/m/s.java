package com.bumptech.glide.load.m;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.h;
import java.io.InputStream;

/* loaded from: classes.dex */
public class s<Data>  implements com.bumptech.glide.load.m.n<Integer, Data> {

    private final com.bumptech.glide.load.m.n<Uri, Data> a;
    private final Resources b;

    public static final class a implements com.bumptech.glide.load.m.o<Integer, AssetFileDescriptor> {

        private final Resources a;
        public a(Resources resources) {
            super();
            this.a = resources;
        }

        public com.bumptech.glide.load.m.n<Integer, AssetFileDescriptor> b(com.bumptech.glide.load.m.r r) {
            s sVar = new s(this.a, r.d(Uri.class, AssetFileDescriptor.class));
            return sVar;
        }
    }

    public static class b implements com.bumptech.glide.load.m.o<Integer, ParcelFileDescriptor> {

        private final Resources a;
        public b(Resources resources) {
            super();
            this.a = resources;
        }

        public com.bumptech.glide.load.m.n<Integer, ParcelFileDescriptor> b(com.bumptech.glide.load.m.r r) {
            s sVar = new s(this.a, r.d(Uri.class, ParcelFileDescriptor.class));
            return sVar;
        }
    }

    public static class c implements com.bumptech.glide.load.m.o<Integer, InputStream> {

        private final Resources a;
        public c(Resources resources) {
            super();
            this.a = resources;
        }

        public com.bumptech.glide.load.m.n<Integer, InputStream> b(com.bumptech.glide.load.m.r r) {
            s sVar = new s(this.a, r.d(Uri.class, InputStream.class));
            return sVar;
        }
    }

    public static class d implements com.bumptech.glide.load.m.o<Integer, Uri> {

        private final Resources a;
        public d(Resources resources) {
            super();
            this.a = resources;
        }

        public com.bumptech.glide.load.m.n<Integer, Uri> b(com.bumptech.glide.load.m.r r) {
            s obj3 = new s(this.a, v.c());
            return obj3;
        }
    }
    public s(Resources resources, com.bumptech.glide.load.m.n<Uri, Data> n2) {
        super();
        this.b = resources;
        this.a = n2;
    }

    private Uri d(Integer integer) {
        int stringBuilder;
        String str2;
        String str;
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("android.resource://");
            stringBuilder2.append(this.b.getResourcePackageName(integer.intValue()));
            int i = 47;
            stringBuilder2.append(i);
            stringBuilder2.append(this.b.getResourceTypeName(integer.intValue()));
            stringBuilder2.append(i);
            stringBuilder2.append(this.b.getResourceEntryName(integer.intValue()));
            return Uri.parse(stringBuilder2.toString());
            stringBuilder = 5;
            str2 = "ResourceLoader";
            stringBuilder = Log.isLoggable(str2, stringBuilder);
            if (stringBuilder != null) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Received invalid resource id: ");
            stringBuilder.append(integer);
            integer = stringBuilder.toString();
            Log.w(str2, integer, th);
            integer = null;
            return integer;
        }
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean a(Object object) {
        return e((Integer)object);
    }

    @Override // com.bumptech.glide.load.m.n
    public com.bumptech.glide.load.m.n.a b(Object object, int i2, int i3, h h4) {
        return c((Integer)object, i2, i3, h4);
    }

    public com.bumptech.glide.load.m.n.a<Data> c(Integer integer, int i2, int i3, h h4) {
        com.bumptech.glide.load.m.n nVar;
        int obj2;
        obj2 = d(integer);
        if (obj2 == null) {
            obj2 = 0;
        } else {
            obj2 = this.a.b(obj2, i2, i3, h4);
        }
        return obj2;
    }

    @Override // com.bumptech.glide.load.m.n
    public boolean e(Integer integer) {
        return 1;
    }
}
