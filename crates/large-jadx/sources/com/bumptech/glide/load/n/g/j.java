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
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public class j implements j<InputStream, com.bumptech.glide.load.n.g.c> {

    private final List<ImageHeaderParser> a;
    private final j<ByteBuffer, com.bumptech.glide.load.n.g.c> b;
    private final b c;
    public j(List<ImageHeaderParser> list, j<ByteBuffer, com.bumptech.glide.load.n.g.c> j2, b b3) {
        super();
        this.a = list;
        this.b = j2;
        this.c = b3;
    }

    private static byte[] e(InputStream inputStream) {
        String str2;
        int read;
        int i;
        int i2 = 16384;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        byte[] bArr = new byte[i2];
        read = inputStream.read(bArr);
        while (read != -1) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
        byteArrayOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return d((InputStream)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return c((InputStream)object, i2, i3, h4);
    }

    public u<com.bumptech.glide.load.n.g.c> c(InputStream inputStream, int i2, int i3, h h4) {
        byte[] obj2 = j.e(inputStream);
        if (obj2 == null) {
            return 0;
        }
        return this.b.b(ByteBuffer.wrap(obj2), i2, i3, h4);
    }

    @Override // com.bumptech.glide.load.j
    public boolean d(InputStream inputStream, h h2) {
        Object gVar;
        Object obj2;
        boolean obj3;
        if (!(Boolean)h2.c(i.b).booleanValue() && e.f(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF) {
            obj2 = e.f(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
