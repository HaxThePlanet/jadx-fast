package com.bumptech.glide.load.resource.bitmap;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.g.b;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class c0<T>  implements j<T, Bitmap> {

    public static final g<Long> d;
    public static final g<Integer> e;
    private static final com.bumptech.glide.load.resource.bitmap.c0.e f;
    private final com.bumptech.glide.load.resource.bitmap.c0.f<T> a;
    private final e b;
    private final com.bumptech.glide.load.resource.bitmap.c0.e c;

    static class e {
        public MediaMetadataRetriever a() {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            return mediaMetadataRetriever;
        }
    }

    interface f {
        public abstract void a(MediaMetadataRetriever mediaMetadataRetriever, T t2);
    }

    private static final class h extends RuntimeException {

        private static final long serialVersionUID = -2556382523004027815L;
        h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    class a implements g.b<Long> {

        private final ByteBuffer a;
        a() {
            super();
            this.a = ByteBuffer.allocate(8);
        }

        @Override // com.bumptech.glide.load.g$b
        public void a(byte[] bArr, Object object2, MessageDigest messageDigest3) {
            b(bArr, (Long)object2, messageDigest3);
        }

        @Override // com.bumptech.glide.load.g$b
        public void b(byte[] bArr, Long long2, MessageDigest messageDigest3) {
            messageDigest3.update(bArr);
            final ByteBuffer obj4 = this.a;
            this.a.position(0);
            messageDigest3.update(this.a.putLong(long2.longValue()).array());
            return;
            synchronized (obj4) {
                messageDigest3.update(bArr);
                obj4 = this.a;
                this.a.position(0);
                messageDigest3.update(this.a.putLong(long2.longValue()).array());
            }
        }
    }

    class b implements g.b<Integer> {

        private final ByteBuffer a;
        b() {
            super();
            this.a = ByteBuffer.allocate(4);
        }

        @Override // com.bumptech.glide.load.g$b
        public void a(byte[] bArr, Object object2, MessageDigest messageDigest3) {
            b(bArr, (Integer)object2, messageDigest3);
        }

        @Override // com.bumptech.glide.load.g$b
        public void b(byte[] bArr, Integer integer2, MessageDigest messageDigest3) {
            if (integer2 == null) {
            }
            messageDigest3.update(bArr);
            final ByteBuffer obj3 = this.a;
            this.a.position(0);
            messageDigest3.update(this.a.putInt(integer2.intValue()).array());
            return;
            synchronized (obj3) {
                messageDigest3.update(bArr);
                obj3 = this.a;
                this.a.position(0);
                messageDigest3.update(this.a.putInt(integer2.intValue()).array());
            }
        }
    }

    private static final class c implements com.bumptech.glide.load.resource.bitmap.c0.f<AssetFileDescriptor> {
        c(com.bumptech.glide.load.resource.bitmap.c0.a c0$a) {
            super();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c0$f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object object2) {
            b(mediaMetadataRetriever, (AssetFileDescriptor)object2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c0$f
        public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor2) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), obj3);
        }
    }

    static final class d implements com.bumptech.glide.load.resource.bitmap.c0.f<ByteBuffer> {
        @Override // com.bumptech.glide.load.resource.bitmap.c0$f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object object2) {
            b(mediaMetadataRetriever, (ByteBuffer)object2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c0$f
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer2) {
            c0.d.a aVar = new c0.d.a(this, byteBuffer2);
            mediaMetadataRetriever.setDataSource(aVar);
        }
    }

    static final class g implements com.bumptech.glide.load.resource.bitmap.c0.f<ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.resource.bitmap.c0$f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, Object object2) {
            b(mediaMetadataRetriever, (ParcelFileDescriptor)object2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.c0$f
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor2) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor2.getFileDescriptor());
        }
    }
    static {
        c0.a aVar = new c0.a();
        c0.d = g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), aVar);
        c0.b bVar = new c0.b();
        c0.e = g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, bVar);
        c0.e eVar = new c0.e();
        c0.f = eVar;
    }

    c0(e e, com.bumptech.glide.load.resource.bitmap.c0.f<T> c0$f2) {
        super(e, f2, c0.f);
    }

    c0(e e, com.bumptech.glide.load.resource.bitmap.c0.f<T> c0$f2, com.bumptech.glide.load.resource.bitmap.c0.e c0$e3) {
        super();
        this.b = e;
        this.a = f2;
        this.c = e3;
    }

    public static j<AssetFileDescriptor, Bitmap> c(e e) {
        c0.c cVar = new c0.c(0);
        c0 c0Var = new c0(e, cVar);
        return c0Var;
    }

    public static j<ByteBuffer, Bitmap> d(e e) {
        c0.d dVar = new c0.d();
        c0 c0Var = new c0(e, dVar);
        return c0Var;
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long l2, int i3, int i4, int i5, com.bumptech.glide.load.resource.bitmap.l l6) {
        int sDK_INT;
        int obj6;
        sDK_INT = Integer.MIN_VALUE;
        if (Build.VERSION.SDK_INT >= 27 && i5 != sDK_INT && l6 != sDK_INT && obj8 != l.d) {
            sDK_INT = Integer.MIN_VALUE;
            if (i5 != sDK_INT) {
                if (l6 != sDK_INT) {
                    if (obj8 != l.d) {
                        obj6 = c0.g(mediaMetadataRetriever, l2, i3, i4, i5, l6);
                    } else {
                        obj6 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (obj6 == null) {
            obj6 = c0.f(mediaMetadataRetriever, l2, i3);
        }
        if (obj6 == null) {
        } else {
            return obj6;
        }
        c0.h obj2 = new c0.h();
        throw obj2;
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long l2, int i3) {
        return mediaMetadataRetriever.getFrameAtTime(l2, i3);
    }

    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long l2, int i3, int i4, int i5, com.bumptech.glide.load.resource.bitmap.l l6) {
        int int;
        int int2;
        int i2;
        int i;
        int int3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
        if (int3 != 90) {
            if (int3 == 270) {
                try {
                    int2 = int;
                    int = i;
                    float obj13 = obj15.b(int, int2, i5, l6);
                    return mediaMetadataRetriever.getScaledFrameAtTime(l2, obj4, i4, Math.round(obj14 *= obj13));
                    l2 = 3;
                    i3 = "VideoDecoder";
                    l2 = Log.isLoggable(i3, l2);
                    if (l2 != 0) {
                    }
                    l2 = "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame";
                    Log.d(i3, l2, mediaMetadataRetriever);
                    mediaMetadataRetriever = null;
                    return mediaMetadataRetriever;
                }
            }
        } else {
        }
    }

    public static j<ParcelFileDescriptor, Bitmap> h(e e) {
        c0.g gVar = new c0.g();
        c0 c0Var = new c0(e, gVar);
        return c0Var;
    }

    public boolean a(T t, h h2) {
        return 1;
    }

    public u<Bitmap> b(T t, int i2, int i3, h h4) {
        int cmp;
        Object valueOf;
        Object obj13;
        final long longValue = (Long)h4.c(c0.d).longValue();
        if (Long.compare(longValue, i) < 0) {
            if (Long.compare(longValue, i4) != 0) {
            } else {
            }
            StringBuilder obj11 = new StringBuilder();
            obj11.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
            obj11.append(longValue);
            IllegalArgumentException obj10 = new IllegalArgumentException(obj11.toString());
            throw obj10;
        }
        if ((Integer)h4.c(c0.e) == null) {
            valueOf = 2;
        }
        if ((l)h4.c(l.f) == null) {
            obj13 = l.e;
        }
        obj13 = this.c.a();
        this.a.a(obj13, t);
        if (Build.VERSION.SDK_INT >= 29) {
            obj13.close();
        } else {
            obj13.release();
        }
        return e.d(c0.e(obj13, longValue, obj3, valueOf.intValue(), i2, i3), this.b);
    }
}
