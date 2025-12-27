package com.bumptech.glide.load.m;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.h;
import java.io.InputStream;

/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {

    private final n<Uri, Data> a;
    private final Resources b;

    public static final class a implements o<Integer, AssetFileDescriptor> {

        private final Resources a;
        public a(Resources resources) {
            super();
            this.a = resources;
        }

        public n<Integer, AssetFileDescriptor> b(r rVar) {
            return new s(this.a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        private final Resources a;
        public b(Resources resources) {
            super();
            this.a = resources;
        }

        public n<Integer, ParcelFileDescriptor> b(r rVar) {
            return new s(this.a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<Integer, InputStream> {

        private final Resources a;
        public c(Resources resources) {
            super();
            this.a = resources;
        }

        public n<Integer, InputStream> b(r rVar) {
            return new s(this.a, rVar.d(Uri.class, InputStream.class));
        }
    }

    public static class d implements o<Integer, Uri> {

        private final Resources a;
        public d(Resources resources) {
            super();
            this.a = resources;
        }

        public n<Integer, Uri> b(r rVar) {
            return new s(this.a, v.c());
        }
    }
    public s(Resources resources, n<Uri, Data> nVar) {
        super();
        this.b = resources;
        this.a = nVar;
    }

    private Uri d(Integer integer) {
        int stringBuilder2;
        String str3;
        String str4;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "android.resource://";
            String resourcePackageName = this.b.getResourcePackageName(integer.intValue());
            char c = '/';
            String resourceTypeName = this.b.getResourceTypeName(integer.intValue());
            String resourceEntryName = this.b.getResourceEntryName(integer.intValue());
            str = str2 + resourcePackageName + c + resourceTypeName + c + resourceEntryName;
        } catch (android.content.res.Resources.NotFoundException notFound) {
            stringBuilder2 = 5;
            str3 = "ResourceLoader";
            stringBuilder2 = Log.isLoggable(str3, stringBuilder2);
        }
        return Uri.parse(str);
    }

    public n.a<Data> c(Integer integer, int i, int i2, h hVar) {
        Uri uri = d(integer);
        if (uri == null) {
            i = 0;
        } else {
            com.bumptech.glide.load.m.n.a aVar = this.a.b(uri, i, i2, hVar);
        }
        return i;
    }

    public boolean e(Integer integer) {
        return true;
    }
}
