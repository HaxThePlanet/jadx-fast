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

/* loaded from: classes.dex */
public class a {

    private final i<String> a;
    private final Map<i<String>, Typeface> b;
    private final Map<String, Typeface> c;
    private final AssetManager d = null;
    private a e;
    private String f;
    public a(Drawable.Callback drawable$Callback, a a2) {
        super();
        i obj2 = new i();
        this.a = obj2;
        obj2 = new HashMap();
        this.b = obj2;
        obj2 = new HashMap();
        this.c = obj2;
        this.f = ".ttf";
        if (callback instanceof View == null) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            int obj1 = 0;
        }
        this.d = (View)callback.getContext().getAssets();
    }

    private Typeface a(String string) {
        Object obj = this.c.get(string);
        if ((Typeface)obj != null) {
            return (Typeface)obj;
        }
        a aVar = this.e;
        int i = 0;
        if (aVar != null) {
        } else {
            if (aVar != null) {
                aVar.b(string);
                throw i;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fonts/");
            stringBuilder.append(string);
            stringBuilder.append(this.f);
            Typeface fromAsset = Typeface.createFromAsset(this.d, stringBuilder.toString());
            this.c.put(string, fromAsset);
            return fromAsset;
        }
        aVar.a(string);
        throw i;
    }

    private Typeface d(Typeface typeface, String string2) {
        int obj4;
        boolean contains = string2.contains("Italic");
        obj4 = string2.contains("Bold");
        if (contains && obj4 != null) {
            obj4 = obj4 != null ? 3 : contains ? 2 : obj4 != null ? 1 : 0;
        } else {
        }
        if (typeface.getStyle() == obj4) {
            return typeface;
        }
        return Typeface.create(typeface, obj4);
    }

    public Typeface b(String string, String string2) {
        this.a.b(string, string2);
        Object obj = this.b.get(this.a);
        if ((Typeface)obj != null) {
            return (Typeface)obj;
        }
        Typeface obj3 = d(a(string), string2);
        this.b.put(this.a, obj3);
        return obj3;
    }

    public void c(a a) {
    }
}
