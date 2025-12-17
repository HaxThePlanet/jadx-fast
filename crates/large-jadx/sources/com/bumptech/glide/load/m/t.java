package com.bumptech.glide.load.m;

import android.util.Log;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class t implements d<InputStream> {

    private final b a;
    public t(b b) {
        super();
        this.a = b;
    }

    @Override // com.bumptech.glide.load.d
    public boolean a(Object object, File file2, h h3) {
        return c((InputStream)object, file2, h3);
    }

    @Override // com.bumptech.glide.load.d
    public boolean c(InputStream inputStream, File file2, h h3) {
        Object obj3;
        int i;
        Throwable obj5;
        File obj6;
        final String obj7 = "StreamEncoder";
        Object obj = this.a.e(65536, byte[].class);
        i = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        obj6 = inputStream.read((byte[])obj);
        while (obj6 != -1) {
            fileOutputStream.write(obj, 0, obj6);
            obj6 = inputStream.read(obj);
        }
        fileOutputStream.close();
        fileOutputStream.close();
        this.a.d(obj);
        return 1;
    }
}
