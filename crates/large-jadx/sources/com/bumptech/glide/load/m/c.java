package com.bumptech.glide.load.m;

import android.util.Log;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferEncoder.java */
/* loaded from: classes.dex */
public class c implements d<ByteBuffer> {
    public boolean c(ByteBuffer byteBuffer, File file, h hVar) {
        boolean z = true;
        try {
            a.f(byteBuffer, file);
        } catch (java.io.IOException ioException) {
            file = 3;
            hVar = "ByteBufferEncoder";
            file = Log.isLoggable(hVar, file);
        }
        int i = 1;
        return z;
    }
}
