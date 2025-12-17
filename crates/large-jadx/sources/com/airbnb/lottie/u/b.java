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

/* loaded from: classes.dex */
public class b {

    private static final Object e;
    private final Context a = null;
    private String b;
    private b c;
    private final Map<String, g> d;
    static {
        Object object = new Object();
        b.e = object;
    }

    public b(Drawable.Callback drawable$Callback, String string2, b b3, Map<String, g> map4) {
        int i;
        String str;
        boolean obj4;
        super();
        this.b = string2;
        obj4 = this.b;
        i = 47;
        if (!TextUtils.isEmpty(string2) && obj4.charAt(length--) != i) {
            obj4 = this.b;
            i = 47;
            if (obj4.charAt(length--) != i) {
                obj4 = new StringBuilder();
                obj4.append(this.b);
                obj4.append(i);
                this.b = obj4.toString();
            }
        }
        if (callback instanceof View == null) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            HashMap obj3 = new HashMap();
            this.d = obj3;
            obj3 = 0;
        }
        this.a = (View)callback.getContext();
        this.d = map4;
        d(b3);
    }

    private Bitmap c(String string, Bitmap bitmap2) {
        final Object obj = b.e;
        (g)this.d.get(string).f(bitmap2);
        return bitmap2;
        synchronized (obj) {
            obj = b.e;
            (g)this.d.get(string).f(bitmap2);
            return bitmap2;
        }
    }

    public Bitmap a(String string) {
        boolean startsWith;
        Object obj = this.d.get(string);
        int i4 = 0;
        if ((g)obj == null) {
            return i4;
        }
        Bitmap bitmap3 = (g)obj.a();
        if (bitmap3 != null) {
            return bitmap3;
        }
        b bVar = this.c;
        Bitmap bitmap = bVar.a(obj);
        if (bVar != null && bitmap != null) {
            bitmap = bVar.a(obj);
            if (bitmap != null) {
                c(string, bitmap);
            }
            return bitmap;
        }
        String str3 = obj.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i7 = 1;
        options.inScaled = i7;
        options.inDensity = 160;
        if (str3.startsWith("data:") && str3.indexOf("base64,") > 0) {
            if (str3.indexOf("base64,") > 0) {
                int i5 = 0;
                byte[] decode = Base64.decode(str3.substring(indexOf += i7), i5);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, i5, decode.length, options);
                c(string, decodeByteArray);
                return decodeByteArray;
            }
        }
        if (TextUtils.isEmpty(this.b)) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append(str3);
            Bitmap bitmap2 = h.l(BitmapFactory.decodeStream(this.a.getAssets().open(stringBuilder.toString()), i4, options), obj.e(), obj.c());
            c(string, bitmap2);
            return bitmap2;
        }
        IllegalStateException obj8 = new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        throw obj8;
    }

    public boolean b(Context context) {
        Context context2;
        Object obj2;
        if (context == null) {
            if (this.a != null) {
                obj2 = this.a.equals(context) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public void d(b b) {
        this.c = b;
    }
}
