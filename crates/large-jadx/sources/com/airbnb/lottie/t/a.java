package com.airbnb.lottie.t;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

/* loaded from: classes.dex */
public class a extends Paint {
    public a(int i) {
        super(i);
    }

    public a(int i, PorterDuff.Mode porterDuff$Mode2) {
        super(i);
        PorterDuffXfermode obj1 = new PorterDuffXfermode(mode2);
        setXfermode(obj1);
    }

    public a(PorterDuff.Mode porterDuff$Mode) {
        super();
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(mode);
        setXfermode(porterDuffXfermode);
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }
}
