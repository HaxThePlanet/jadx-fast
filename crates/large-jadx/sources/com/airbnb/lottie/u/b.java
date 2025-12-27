package com.airbnb.lottie.u;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.b;
import com.airbnb.lottie.g;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.h;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public class b {

    private static final Object e = new Object();
    private final Context a = null;
    private String b;
    private b c;
    private final Map<String, g> d = new HashMap<>();

    public b(Drawable.Callback callback, String str, b bVar, Map<String, g> map) {
        super();
        this.b = str;
        if (!TextUtils.isEmpty(str) && this.b.charAt(this.b.length() - 1) != c) {
            StringBuilder stringBuilder = new StringBuilder();
            str5 = this.b + c;
            this.b = str5;
        }
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            HashMap hashMap = new HashMap();
            return;
        }
        this.a = callback.getContext();
        this.d = map;
        d(bVar);
    }

    private Bitmap c(String str, Bitmap bitmap) {
        final Object obj2 = b.e;
        synchronized (obj2) {
            try {
                (g)this.d.get(str).f(bitmap);
                return bitmap;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public Bitmap a(String str) {
        Object value = this.d.get(str);
        android.graphics.Rect rect = null;
        if (value == null) {
            return rect;
        }
        Bitmap bitmap3 = value.a();
        if (bitmap3 != null) {
            return bitmap3;
        }
        if (this.c != null && bitmap != null) {
            c(str, bitmap);
            return bitmap;
        }
        String str4 = value.b();
        final BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z = true;
        options.inScaled = z;
        options.inDensity = 160;
        if (str4.startsWith("data:") && str4.indexOf("base64,") > 0) {
            try {
                int i5 = 0;
                byte[] decode = Base64.decode(str4.substring(str4.indexOf(44) + z), i5);
            } catch (java.io.IOException ioException) {
                String str2 = "Unable to open asset.";
                d.d(str2, ioException);
                return obj;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, i5, decode.length, options);
            c(ioException, decodeByteArray);
            return decodeByteArray;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            str5 = this.b + str4;
        } catch (java.io.IOException ioException) {
            str2 = "Unable to open asset.";
            d.d(str2, ioException);
            return obj;
        }
        try {
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (java.io.IOException ioException) {
            str2 = "Unable to open asset.";
            d.d(str2, ioException);
            return obj;
        }
    }

    public boolean b(Context context) {
        Context context2;
        boolean z = true;
        if (context != null || this.a != null) {
            context = this.a.equals(context) ? 1 : 0;
        }
        return (this.a.equals(context) ? 1 : 0);
    }

    public void d(b bVar) {
        this.c = bVar;
    }
}
