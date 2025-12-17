package com.bumptech.glide.load.m;

import android.util.Log;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.h;
import com.bumptech.glide.t.a;
import java.io.File;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c implements d<ByteBuffer> {
    @Override // com.bumptech.glide.load.d
    public boolean a(Object object, File file2, h h3) {
        return c((ByteBuffer)object, file2, h3);
    }

    @Override // com.bumptech.glide.load.d
    public boolean c(ByteBuffer byteBuffer, File file2, h h3) {
        int obj1;
        File obj2;
        String obj3;
        try {
            a.f(byteBuffer, file2);
            obj1 = 1;
            file2 = 3;
            h3 = "ByteBufferEncoder";
            file2 = Log.isLoggable(h3, file2);
            if (file2 != null) {
            }
            file2 = "Failed to write data";
            Log.d(h3, file2, byteBuffer);
        }
        return obj1;
    }
}
