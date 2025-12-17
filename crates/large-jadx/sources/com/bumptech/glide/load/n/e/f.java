package com.bumptech.glide.load.n.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.util.List;

/* loaded from: classes.dex */
public class f implements j<Uri, Drawable> {

    private final Context a;
    public f(Context context) {
        super();
        this.a = context.getApplicationContext();
    }

    private Context d(Uri uri, String string2) {
        if (string2.equals(this.a.getPackageName())) {
            return this.a;
        }
        return this.a.createPackageContext(string2, 0);
    }

    private int e(Uri uri) {
        return Integer.parseInt((String)uri.getPathSegments().get(0));
    }

    private int f(Context context, Uri uri2) {
        String authority;
        int obj5;
        List pathSegments = uri2.getPathSegments();
        Object obj2 = pathSegments.get(0);
        Object obj = pathSegments.get(1);
        if (context.getResources().getIdentifier((String)obj, (String)obj2, uri2.getAuthority()) == 0) {
            obj5 = Resources.getSystem().getIdentifier(obj, obj2, "android");
        }
        if (obj5 == null) {
        } else {
            return obj5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to find resource id for: ");
        stringBuilder.append(uri2);
        obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    private int g(Context context, Uri uri2) {
        List pathSegments = uri2.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri2);
        }
        if (pathSegments.size() != 1) {
        } else {
            return e(uri2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unrecognized Uri format: ");
        stringBuilder.append(uri2);
        IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return h((Uri)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((Uri)object, i2, i3, h4);
    }

    public u<Drawable> c(Uri uri, int i2, int i3, h h4) {
        Context obj2 = d(uri, uri.getAuthority());
        return e.d(b.b(this.a, obj2, g(obj2, uri)));
    }

    @Override // com.bumptech.glide.load.j
    public boolean h(Uri uri, h h2) {
        return uri.getScheme().equals("android.resource");
    }
}
