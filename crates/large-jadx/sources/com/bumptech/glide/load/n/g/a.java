package com.bumptech.glide.load.n.g;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.n.a;
import com.bumptech.glide.n.a.a;
import com.bumptech.glide.n.d;
import com.bumptech.glide.t.g;
import com.bumptech.glide.t.l;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder.java */
/* loaded from: classes.dex */
public class a implements j<ByteBuffer, c> {

    private static final a.a f = new a$a();
    private static final a.b g = new a$b();
    private final Context a;
    private final List<ImageHeaderParser> b;
    private final a.b c;
    private final a.a d;
    private final b e;

    static class a {
        a() {
            super();
        }

        a a(a.a aVar, com.bumptech.glide.n.c cVar, ByteBuffer byteBuffer, int i) {
            return new e(aVar, cVar, byteBuffer, i);
        }
    }

    static class b {

        private final Queue<d> a;
        b() {
            super();
            this.a = l.e(0);
        }

        synchronized d a(ByteBuffer byteBuffer) {
            Object poll;
            if ((d)this.a.poll() == null) {
                d dVar = new d();
            }
            poll.p(byteBuffer);
            return poll;
        }

        synchronized void b(d dVar) {
            dVar.a();
            this.a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this(context, list, eVar, bVar, a.g, a.f);
    }

    private e c(ByteBuffer byteBuffer, int i, int i2, d dVar, h hVar) {
        String str4;
        double d;
        int stringBuilder4;
        Bitmap.Config config;
        final Object byteBuffer3 = this;
        final String str5 = "Decoded GIF from stream in ";
        final String str7 = "BufferGifDecoder";
        long l = g.b();
        final int i4 = 2;
        try {
            com.bumptech.glide.n.c cVar2 = dVar.c();
            final int i5 = 0;
            Bitmap.Config r7 = hVar.c(i.a) == b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
            a aVar2 = byteBuffer3.d.a(byteBuffer3.e, cVar2, byteBuffer, a.e(cVar2, i, i2));
            aVar2.e((hVar.c(i.a) == b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888));
            aVar2.b();
            final android.graphics.Bitmap bitmap = aVar2.a();
        } catch (Throwable th) {
            stringBuilder4 = Log.isLoggable(str6, stringBuilder4);
        }
        if (Log.isLoggable(str7, i4)) {
            StringBuilder stringBuilder3 = new StringBuilder();
            double d4 = g.a(l);
            str3 = str5 + d4;
            Log.v(str7, str3);
        }
        return i5;
    }

    private static int e(com.bumptech.glide.n.c cVar, int i, int i2) {
        int highestOneBit = 0;
        int min = Math.min(cVar.a() / i2, cVar.d() / i);
        if (min == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(min);
        }
        i = 1;
        int max = Math.max(i, highestOneBit);
        final String str5 = "BufferGifDecoder";
        if (Log.isLoggable(str5, 2) && max > i) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Downsampling GIF, sampleSize: ";
            String str4 = ", target dimens: [";
            str2 = "x";
            String str7 = "], actual dimens: [";
            int i4 = cVar.d();
            int i10 = cVar.a();
            String str6 = "]";
            str = str3 + max + str4 + i + str2 + i2 + str7 + i4 + str2 + i10 + str6;
            Log.v(str5, str);
        }
        return max;
    }

    public e d(ByteBuffer byteBuffer, int i, int i2, h hVar) {
        d dVar = this.c.a(byteBuffer);
        try {
        } finally {
            this.c.b(dVar2);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) byteBuffer;
        }
        this.c.b(dVar);
        return this.c(byteBuffer, i, i2, dVar, hVar);
    }

    public boolean f(ByteBuffer byteBuffer, h hVar) {
        boolean z = false;
        boolean booleanValue;
        if (!(Boolean)hVar.c(i.b).booleanValue()) {
            byteBuffer = e.g(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF ? 1 : 0;
        }
        return (e.g(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF ? 1 : 0);
    }

    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar, a.b bVar2, a.a aVar) {
        super();
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = aVar;
        this.e = new b(eVar, bVar);
        this.c = bVar2;
    }
}
