package com.googlecode.mp4parser.h;

import android.util.Log;

/* loaded from: classes2.dex */
public class a extends com.googlecode.mp4parser.h.f {

    String a;
    public a(String string) {
        super();
        this.a = string;
    }

    @Override // com.googlecode.mp4parser.h.f
    public void b(String string) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.a));
        stringBuilder.append(":");
        stringBuilder.append(string);
        Log.d("isoparser", stringBuilder.toString());
    }

    @Override // com.googlecode.mp4parser.h.f
    public void c(String string) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.a));
        stringBuilder.append(":");
        stringBuilder.append(string);
        Log.e("isoparser", stringBuilder.toString());
    }

    @Override // com.googlecode.mp4parser.h.f
    public void d(String string) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(this.a));
        stringBuilder.append(":");
        stringBuilder.append(string);
        Log.w("isoparser", stringBuilder.toString());
    }
}
