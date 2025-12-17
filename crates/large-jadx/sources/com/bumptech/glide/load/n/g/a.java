package com.bumptech.glide.load.n.g;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import com.bumptech.glide.load.n.c;
import com.bumptech.glide.n.a;
import com.bumptech.glide.n.a.a;
import com.bumptech.glide.n.c;
import com.bumptech.glide.n.d;
import com.bumptech.glide.n.e;
import com.bumptech.glide.t.g;
import com.bumptech.glide.t.l;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public class a implements j<ByteBuffer, com.bumptech.glide.load.n.g.c> {

    private static final com.bumptech.glide.load.n.g.a.a f;
    private static final com.bumptech.glide.load.n.g.a.b g;
    private final Context a;
    private final List<ImageHeaderParser> b;
    private final com.bumptech.glide.load.n.g.a.b c;
    private final com.bumptech.glide.load.n.g.a.a d;
    private final com.bumptech.glide.load.n.g.b e;

    static class a {
        a a(a.a a$a, c c2, ByteBuffer byteBuffer3, int i4) {
            e eVar = new e(a, c2, byteBuffer3, i4);
            return eVar;
        }
    }

    static class b {

        private final Queue<d> a;
        b() {
            super();
            this.a = l.e(0);
        }

        d a(ByteBuffer byteBuffer) {
            Object dVar;
            synchronized (this) {
                try {
                    dVar = new d();
                    dVar.p(byteBuffer);
                    return dVar;
                    throw byteBuffer;
                }
            }
        }

        void b(d d) {
            d.a();
            this.a.offer(d);
            return;
            synchronized (this) {
                d.a();
                this.a.offer(d);
            }
        }
    }
    static {
        a.a aVar = new a.a();
        a.f = aVar;
        a.b bVar = new a.b();
        a.g = bVar;
    }

    public a(Context context, List<ImageHeaderParser> list2, e e3, b b4) {
        super(context, list2, e3, b4, a.g, a.f);
    }

    a(Context context, List<ImageHeaderParser> list2, e e3, b b4, com.bumptech.glide.load.n.g.a.b a$b5, com.bumptech.glide.load.n.g.a.a a$a6) {
        super();
        this.a = context.getApplicationContext();
        this.b = list2;
        this.d = a6;
        b obj1 = new b(e3, b4);
        this.e = obj1;
        this.c = b5;
    }

    private com.bumptech.glide.load.n.g.e c(ByteBuffer byteBuffer, int i2, int i3, d d4, h h5) {
        boolean loggable2;
        boolean loggable3;
        boolean loggable;
        String string;
        double d;
        long l;
        int stringBuilder;
        Bitmap.Config config;
        int i;
        final Object obj = this;
        final String str = "Decoded GIF from stream in ";
        final String str2 = "BufferGifDecoder";
        l = g.b();
        final int i4 = 2;
        c cVar = d4.c();
        final int i5 = 0;
        if (cVar.b() > 0) {
            if (cVar.c() != 0) {
            } else {
                config = h5.c(i.a) == b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                a aVar2 = obj.d.a(obj.e, cVar, byteBuffer, a.e(cVar, i2, i3));
                aVar2.e(config);
                aVar2.b();
                final android.graphics.Bitmap bitmap = aVar2.a();
                if (bitmap == null && Log.isLoggable(str2, i4)) {
                    if (Log.isLoggable(str2, i4)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str);
                        stringBuilder2.append(g.a(l));
                        Log.v(str2, stringBuilder2.toString());
                    }
                    return i5;
                }
                super(obj.a, aVar2, c.c(), i2, i3, bitmap);
                e eVar = new e(cVar2);
                if (Log.isLoggable(str2, i4)) {
                    try {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(str);
                        stringBuilder3.append(g.a(l));
                        Log.v(str2, stringBuilder3.toString());
                        return eVar;
                        if (Log.isLoggable(str2, i4)) {
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(str);
                        stringBuilder4.append(g.a(l));
                        Log.v(str2, stringBuilder4.toString());
                        return i5;
                        stringBuilder = Log.isLoggable(obj3, stringBuilder);
                        if (stringBuilder == null) {
                        } else {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(string);
                        d = g.a(d);
                        stringBuilder.append(d);
                        string = stringBuilder.toString();
                        Log.v(obj3, string);
                        throw th;
                    }
                }
            }
        }
    }

    private static int e(c c, int i2, int i3) {
        int highestOneBit;
        int stringBuilder;
        boolean loggable;
        String obj4;
        int obj5;
        int obj6;
        int i5 = Math.min(i /= i3, i7 /= i2);
        if (i5 == 0) {
            highestOneBit = 0;
        } else {
            highestOneBit = Integer.highestOneBit(i5);
        }
        stringBuilder = 1;
        int i6 = Math.max(stringBuilder, highestOneBit);
        final String str2 = "BufferGifDecoder";
        if (Log.isLoggable(str2, 2) && i6 > stringBuilder) {
            if (i6 > stringBuilder) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Downsampling GIF, sampleSize: ");
                stringBuilder.append(i6);
                stringBuilder.append(", target dimens: [");
                stringBuilder.append(i2);
                obj5 = "x";
                stringBuilder.append(obj5);
                stringBuilder.append(i3);
                stringBuilder.append("], actual dimens: [");
                stringBuilder.append(c.d());
                stringBuilder.append(obj5);
                stringBuilder.append(c.a());
                stringBuilder.append("]");
                Log.v(str2, stringBuilder.toString());
            }
        }
        return i6;
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(Object object, h h2) {
        return f((ByteBuffer)object, h2);
    }

    @Override // com.bumptech.glide.load.j
    public u b(Object object, int i2, int i3, h h4) {
        return d((ByteBuffer)object, i2, i3, h4);
    }

    @Override // com.bumptech.glide.load.j
    public com.bumptech.glide.load.n.g.e d(ByteBuffer byteBuffer, int i2, int i3, h h4) {
        d dVar = this.c.a(byteBuffer);
        this.c.b(dVar);
        return this.c(byteBuffer, i2, i3, dVar, h4);
    }

    @Override // com.bumptech.glide.load.j
    public boolean f(ByteBuffer byteBuffer, h h2) {
        Object obj2;
        boolean obj3;
        if (!(Boolean)h2.c(i.b).booleanValue() && e.g(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF) {
            obj2 = e.g(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF ? 1 : 0;
        } else {
        }
        return obj2;
    }
}
