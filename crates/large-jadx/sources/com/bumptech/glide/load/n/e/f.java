package com.bumptech.glide.load.n.e;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.util.List;

/* compiled from: ResourceDrawableDecoder.java */
/* loaded from: classes.dex */
public class f implements j<Uri, Drawable> {

    private final Context a;
    public f(Context context) {
        super();
        this.a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.a.getPackageName())) {
            return this.a;
        }
        try {
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFound) {
            Context stringBuilder = this.a.getPackageName();
            str = str.contains(this.a);
        }
        return this.a.createPackageContext(str, 0);
    }

    private int e(Uri uri) {
        try {
        } catch (java.lang.NumberFormatException numberFormat) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Unrecognized Uri format: ";
            uri = str + uri;
            throw new IllegalArgumentException(uri, numberFormat);
        }
        return Integer.parseInt((String)uri.getPathSegments().get(0));
    }

    private int f(Context context, Uri uri) {
        int identifier;
        List pathSegments = uri.getPathSegments();
        Object item2 = pathSegments.get(0);
        Object item = pathSegments.get(1);
        if (context.getResources().getIdentifier(item, item2, uri.getAuthority()) == 0) {
            authority = "android";
            identifier = Resources.getSystem().getIdentifier(item, item2, authority);
        }
        if (identifier == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Failed to find resource id for: ";
            uri = str + uri;
            throw new IllegalArgumentException(uri);
        } else {
            return identifier;
        }
    }

    private int g(Context context, Uri uri) {
        List pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Unrecognized Uri format: ";
            uri = str + uri;
            throw new IllegalArgumentException(uri);
        } else {
            return e(uri);
        }
    }

    public u<Drawable> c(Uri uri, int i, int i2, h hVar) {
        Context context = d(uri, uri.getAuthority());
        return e.d(b.b(this.a, context, g(context, uri)));
    }

    public boolean h(Uri uri, h hVar) {
        return uri.getScheme().equals("android.resource");
    }
}
