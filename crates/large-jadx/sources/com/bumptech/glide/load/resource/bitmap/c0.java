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

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class c0<T> implements j<T, Bitmap> {

    public static final g<Long> d;
    public static final g<Integer> e;
    private static final c0.e f = new c0$e();
    private final c0.f<T> a;
    private final e b;
    private final c0.e c;

    static class e {
        e() {
            super();
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
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

        public void b(byte[] bArr, Long long, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (byteBuffer3) {
                try {
                    this.a.position(0);
                    messageDigest.update(this.a.putLong(long.longValue()).array());
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
    }

    class b implements g.b<Integer> {

        private final ByteBuffer a;
        b() {
            super();
            this.a = ByteBuffer.allocate(4);
        }

        public void b(byte[] bArr, Integer integer, MessageDigest messageDigest) {
            if (integer == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (byteBuffer3) {
                try {
                    this.a.position(0);
                    messageDigest.update(this.a.putInt(integer.intValue()).array());
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
    }

    private static final class c implements c0.f<AssetFileDescriptor> {
        private c() {
            super();
        }

        public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(c0.a aVar) {
            this();
        }
    }

    static final class d implements c0.f<ByteBuffer> {
        d() {
            super();
        }

        public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new c0.d.a(this, byteBuffer));
        }
    }

    static final class g implements c0.f<ParcelFileDescriptor> {
        g() {
            super();
        }

        public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }
    static {
        c0.d = g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1L), new c0.a());
        c0.e = g.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new c0.b());
    }

    c0(e eVar, c0.f<T> fVar) {
        this(eVar, fVar, c0.f);
    }

    public static j<AssetFileDescriptor, Bitmap> c(e eVar) {
        return new c0(eVar, new c0.c(null));
    }

    public static j<ByteBuffer, Bitmap> d(e eVar) {
        return new c0(eVar, new c0.d());
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, l lVar) throws c0.h {
        int sDK_INT2 = -2147483648;
        if (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || lVar == l.d) {
            i = 0;
        } else {
            Bitmap bitmap2 = c0.g(mediaMetadataRetriever, j, i, i2, i3, lVar);
        }
        if (i == 0) {
            Bitmap bitmap = c0.f(mediaMetadataRetriever, j, i);
        }
        if (i == 0) {
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new c0.h();
        } else {
            return i;
        }
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, l lVar) {
        int parsed;
        try {
            int parsed2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            i = 90;
            if (parsed2 == 90 || parsed2 == 270) {
            }
            float f = lVar.b(parsed, parsed, i2, i3);
        } catch (Throwable th) {
            j = 3;
            r11 = "VideoDecoder";
            j = Log.isLoggable(r11, j);
        }
        return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round((float)parsed * f), Math.round(f * (float)parsed));
    }

    public static j<ParcelFileDescriptor, Bitmap> h(e eVar) {
        return new c0(eVar, new c0.g());
    }

    public u<Bitmap> b(T t, int i, int i2, h hVar) {
        Object obj;
        Object obj2;
        final long value = (Long)hVar.c(c0.d).longValue();
        if (value < 0) {
            if (value != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str = "Requested frame must be non-negative, or DEFAULT_FRAME, given: ";
                i = str + value;
                throw new IllegalArgumentException(i);
            }
        }
        if ((Integer)hVar.c(c0.e) == null) {
            Integer num = 2;
        }
        if ((l)hVar.c(l.f) == null) {
            com.bumptech.glide.load.resource.bitmap.l lVar2 = l.e;
        }
        MediaMetadataRetriever hVar42 = this.c.a();
        try {
            this.a.a(hVar42, t);
        } catch (Throwable th) {
            i = Build.VERSION.SDK_INT;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            hVar42.close();
        } else {
            hVar42.release();
        }
        return e.d(c0.e(hVar42, value, obj.intValue(), i, i2, obj2), this.b);
    }

    c0(e eVar, c0.f<T> fVar, c0.e eVar2) {
        super();
        this.b = eVar;
        this.a = fVar;
        this.c = eVar2;
    }

    public boolean a(T t, h hVar) {
        return true;
    }
}
