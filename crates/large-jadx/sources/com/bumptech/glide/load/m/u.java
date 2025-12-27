package com.bumptech.glide.load.m;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.h;
import java.io.File;
import java.io.InputStream;

/* compiled from: StringLoader.java */
/* loaded from: classes.dex */
public class u<Data> implements n<String, Data> {

    private final n<Uri, Data> a;

    public static final class a implements o<String, AssetFileDescriptor> {
        public n<String, AssetFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        public n<String, ParcelFileDescriptor> b(r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements o<String, InputStream> {
        public n<String, InputStream> b(r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }
    public u(n<Uri, Data> nVar) {
        super();
        this.a = nVar;
    }

    private static Uri e(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        char c = '/';
        if (str.charAt(0) == '/') {
            parse = u.f(str);
        } else {
            parse = Uri.parse(str);
            if (parse.getScheme() == null) {
                parse = u.f(str);
            } else {
            }
        }
        return parse;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    public n.a<Data> c(String str, int i, int i2, h hVar) {
        Uri uri = u.e(str);
        if (uri != null) {
            return this.a.b(uri, i, i2, hVar);
        }
        return null;
    }

    public boolean d(String str) {
        return true;
    }
}
