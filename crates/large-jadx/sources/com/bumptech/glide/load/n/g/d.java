package com.bumptech.glide.load.n.g;

import android.util.Log;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.k;
import com.bumptech.glide.t.a;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder.java */
/* loaded from: classes.dex */
public class d implements k<c> {
    public c b(h hVar) {
        return c.SOURCE;
    }

    public boolean c(u<c> uVar, File file, h hVar) {
        boolean z = true;
        try {
            a.f((c)uVar.get().c(), file);
        } catch (java.io.IOException ioException) {
            file = 5;
            hVar = "GifEncoder";
            file = Log.isLoggable(hVar, file);
        }
        int i = 1;
        return z;
    }
}
