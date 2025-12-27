package com.airbnb.lottie.t;

import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.LocaleList;

/* compiled from: LPaint.java */
/* loaded from: classes.dex */
public class a extends Paint {
    public a(int i) {
        super(i);
    }

    public a(PorterDuff.Mode mode) {
        super();
        setXfermode(new PorterDuffXfermode(mode));
    }

    public a(int i, PorterDuff.Mode mode) {
        super(i);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList list) {
    }
}
