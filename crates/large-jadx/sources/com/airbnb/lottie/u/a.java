package com.airbnb.lottie.u;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import com.airbnb.lottie.a;
import com.airbnb.lottie.v.i;
import com.airbnb.lottie.y.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a {

    private final i<String> a = new i<>();
    private final Map<i<String>, Typeface> b = new HashMap<>();
    private final Map<String, Typeface> c = new HashMap<>();
    private final AssetManager d = null;
    private a e;
    private String f = ".ttf";
    public a(Drawable.Callback callback, a aVar) {
        super();
        i iVar = new i();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            return;
        }
        this.d = callback.getContext().getAssets();
    }

    private Typeface a(String str) {
        Object value = this.c.get(str);
        if (value != null) {
            return value;
        }
        int i = 0;
        if (this.e != null) {
            this.e.a(str);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            if (this.e != null) {
                this.e.b(str);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "fonts/";
            str2 = str3 + str + this.f;
            Typeface fromAsset = Typeface.createFromAsset(this.d, str2);
            this.c.put(str, fromAsset);
            return fromAsset;
        }
    }

    private Typeface d(Typeface typeface, String str) {
        int i = 0;
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        if (!contains || !contains2) {
            if (contains) {
                i = 2;
            } else {
                str = contains2 ? 1 : 0;
            }
        } else {
            i = 3;
        }
        if (typeface.getStyle() == i) {
            return typeface;
        }
        return Typeface.create(typeface, i);
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Object value = this.b.get(this.a);
        if (value != null) {
            return value;
        }
        Typeface typeface2 = d(a(str), str2);
        this.b.put(this.a, typeface2);
        return typeface2;
    }

    public void c(a aVar) {
    }
}
