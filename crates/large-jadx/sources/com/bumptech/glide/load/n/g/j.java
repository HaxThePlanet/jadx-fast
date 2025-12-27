package com.bumptech.glide.load.n.g;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class j implements j<InputStream, c> {

    private final List<ImageHeaderParser> a;
    private final j<ByteBuffer, c> b;
    private final b c;
    public j(List<ImageHeaderParser> list, j<ByteBuffer, c> jVar, b bVar) {
        super();
        this.a = list;
        this.b = jVar;
        this.c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        String str2;
        int i2 = 16384;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        try {
            byte[] bArr = new byte[i2];
            int bytesRead = inputStream.read(bArr);
            while (bytesRead != -1) {
                int i = 0;
                byteArrayOutputStream.write(bArr, i, bytesRead);
                bytesRead = inputStream.read(bArr);
            }
            byteArrayOutputStream.flush();
        } catch (java.io.IOException ioException) {
            int str = 5;
            str2 = "StreamGifDecoder";
            str = Log.isLoggable(str2, str);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public u<c> c(InputStream inputStream, int i, int i2, h hVar) {
        byte[] bArr = j.e(inputStream);
        if (bArr == null) {
            return null;
        }
        return this.b.b(ByteBuffer.wrap(bArr), i, i2, hVar);
    }

    public boolean d(InputStream inputStream, h hVar) {
        com.bumptech.glide.load.g gVar;
        boolean z = false;
        boolean booleanValue;
        if (!(Boolean)hVar.c(i.b).booleanValue()) {
            inputStream = e.f(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF ? 1 : 0;
        }
        return (e.f(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF ? 1 : 0);
    }
}
