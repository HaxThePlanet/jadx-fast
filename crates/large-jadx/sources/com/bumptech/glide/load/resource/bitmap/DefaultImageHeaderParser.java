package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.t.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* compiled from: DefaultImageHeaderParser.java */
/* loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    static final byte[] a;
    private static final int[] b;

    private interface Reader {
        int a();

        int b(byte[] bArr, int i);

        short c();

        long skip(long j);
    }

    private static final class b {

        private final ByteBuffer a;
        b(byte[] bArr, int i) {
            super();
            this.a = (ByteBuffer)ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean c(int i, int i2) {
            boolean z = true;
            i = this.a.remaining() - i >= i2 ? 1 : 0;
            return (this.a.remaining() - i >= i2 ? 1 : 0);
        }

        short a(int i) {
            short _short = -1;
            if (c(i, 2)) {
                _short = this.a.getShort(i);
            } else {
                _short = (short) -1;
            }
            return _short;
        }

        int b(int i) {
            int _int = -1;
            if (c(i, 4)) {
                _int = this.a.getInt(i);
            } else {
                _int = -1;
            }
            return _int;
        }

        int d() {
            return this.a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }
    }

    private static final class a implements DefaultImageHeaderParser.Reader {

        private final ByteBuffer a;
        a(ByteBuffer byteBuffer) {
            super();
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public int a() {
            return (c() << 8) | c();
        }

        public int b(byte[] bArr, int i) {
            final int min = Math.min(i, this.a.remaining());
            if (min == 0) {
                return -1;
            }
            this.a.get(bArr, 0, min);
            return min;
        }

        public short c() throws DefaultImageHeaderParser.Reader.EndOfFileException {
            if (this.a.remaining() < 1) {
                throw new DefaultImageHeaderParser.Reader.EndOfFileException();
            } else {
                return (short)(this.a.get() & 255);
            }
        }

        public long skip(long j) {
            long j2 = Math.min((long)this.a.remaining(), j);
            this.a.position(this.a.position() + (int)j2);
            return j2;
        }
    }

    private static final class c implements DefaultImageHeaderParser.Reader {

        private final InputStream a;
        c(InputStream inputStream) {
            super();
            this.a = inputStream;
        }

        public int a() {
            return (c() << 8) | c();
        }

        public int b(byte[] bArr, int i) throws java.io.IOException, DefaultImageHeaderParser.Reader.EndOfFileException {
            int bytesRead = 0;
            int i3;
            bytesRead = 0;
            i = -1;
            while (bytesRead < i) {
                i3 = i - bytesRead;
                bytesRead = this.a.read(bArr, bytesRead, i3);
            }
            return bytesRead;
        }

        public short c() throws java.io.IOException, DefaultImageHeaderParser.Reader.EndOfFileException {
            int bytesRead = this.a.read();
            if (bytesRead == -1) {
                throw new DefaultImageHeaderParser.Reader.EndOfFileException();
            } else {
                return (short)bytesRead;
            }
        }

        public long skip(long j) throws java.io.IOException {
            long j2;
            long skipped = 1;
            int i;
            int cmp;
            final long l = 0L;
            if (j < l) {
                return l;
            }
            j2 = j;
            while (j2 > l) {
                skipped = this.a.skip(j2);
                if (skipped <= l) {
                    break;
                }
            }
            return j - j2;
        }
    }
    static {
        DefaultImageHeaderParser.a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
        DefaultImageHeaderParser.b = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
    }

    private int f(DefaultImageHeaderParser.Reader reader, b bVar) {
        final int i2 = -1;
        try {
            int i3 = reader.a();
        } catch (Throwable unused) {
        }
        final int i5 = 3;
        final String str2 = "DfltImageHeaderParser";
        if (!DefaultImageHeaderParser.h(i3) && Log.isLoggable(str2, i5)) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "Parser doesn't handle magic number: ";
            str3 = str + i3;
            Log.d(str2, str3);
            return i2;
        }
        int i4 = j(reader);
        if (i4 == i2 && Log.isLoggable(str2, i5)) {
            Log.d(str2, "Failed to parse exif segment length, or exif segment not found");
            return i2;
        }
        Object obj3 = bVar.e(i4, byte[].class);
        try {
        } catch (Throwable unused) {
        }
        try {
            bVar.d(obj3);
            return l(reader, obj3, i4);
        } finally {
            bVar.d(obj);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) reader;
        }
    }

    private ImageHeaderParser.ImageType g(DefaultImageHeaderParser.Reader reader) {
        ImageHeaderParser.ImageType pNG2;
        ImageHeaderParser.ImageType uNKNOWN2;
        ImageHeaderParser.ImageType wEBP_A2;
        try {
            int i = reader.a();
            if (i == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            return ImageHeaderParser.ImageType.GIF;
        } catch (com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException unused) {
        }
        int i12 = 1380533830;
        if (i5 != i12 && this.m(ImageHeaderParser.ImageType.JPEG, i5)) {
            uNKNOWN2 = ImageHeaderParser.ImageType.AVIF;
            return uNKNOWN2;
        }
        long l = 4L;
        reader.skip(l);
        if (((reader.a() << 16) | reader.a()) != 1464156752) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int i18 = (reader.a() << 16) | reader.a();
        if ((i18 & (-256)) != 1448097792) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        i18 &= 255;
        if (i19 == 88) {
            reader.skip(l);
            short s4 = reader.c();
            if (s4 & 2 != 0) {
                return ImageHeaderParser.ImageType.ANIMATED_WEBP;
            }
            if (s4 & 16 != 0) {
                return ImageHeaderParser.ImageType.WEBP_A;
            }
            return ImageHeaderParser.ImageType.WEBP;
        }
        if (i19 == 76) {
            reader.skip(l);
            reader = reader.c() & 8 != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            return (reader.c() & 8 != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP);
        }
        return ImageHeaderParser.ImageType.WEBP;
    }

    private boolean i(byte[] bArr, int i) {
        boolean z = false;
        int i22;
        byte[] bArr2;
        int length;
        i22 = 0;
        if (bArr != null) {
            i22 = DefaultImageHeaderParser.a.length;
            i = i > DefaultImageHeaderParser.a.length ? 1 : i22;
        }
        if (i22 != 0) {
            bArr2 = DefaultImageHeaderParser.a;
            length = bArr2.length;
            while (DefaultImageHeaderParser.a.length < DefaultImageHeaderParser.a.length) {
                if (bArr[i22] != DefaultImageHeaderParser.a[i22]) {
                    break;
                }
            }
        }
        return z;
    }

    private int j(DefaultImageHeaderParser.Reader reader) {
        short s3 = reader.c();
        short s2 = (short) 255;
        int i = 3;
        final int i6 = -1;
        final String str5 = "DfltImageHeaderParser";
        while (s3 != (short) 255) {
            short s = reader.c();
            int i5 = reader.a() - 2;
            long l = (long)i5;
            final long skip = reader.skip(l);
            if (skip != l && Log.isLoggable(str5, i)) {
            }
            s3 = reader.c();
            s2 = (short) 255;
            i = 3;
            i6 = -1;
            str5 = "DfltImageHeaderParser";
        }
        if (Log.isLoggable(str5, i)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Unknown segmentId=";
            str6 = str3 + s3;
            Log.d(str5, str6);
        }
        return i6;
    }

    private static int k(DefaultImageHeaderParser.b bVar) {
        ByteOrder lITTLE_ENDIAN2;
        boolean loggable;
        int i = 0;
        String str;
        short s3;
        int i2;
        short s4 = 274;
        int i3;
        short s5 = 1;
        int i4;
        String str2;
        String str3;
        int i5 = 6;
        short s = bVar.a(i5);
        short s2 = (short) 18761;
        final int i9 = 3;
        final String str5 = "DfltImageHeaderParser";
        if (s == (short) 18761) {
            lITTLE_ENDIAN2 = ByteOrder.LITTLE_ENDIAN;
        } else {
            s2 = (short) 19789;
            if (s != (short) 19789) {
                if (Log.isLoggable(str5, i9)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    str = "Unknown endianness = ";
                    str4 = str + s;
                    Log.d(str5, str4);
                }
                lITTLE_ENDIAN2 = ByteOrder.BIG_ENDIAN;
            } else {
                lITTLE_ENDIAN2 = ByteOrder.BIG_ENDIAN;
            }
        }
        bVar.e(lITTLE_ENDIAN2);
        int i8 = bVar.b(10) + i5;
        i = 0;
        while (i < bVar.a(i8)) {
            int i10 = DefaultImageHeaderParser.e(i8, i);
            s3 = bVar.a(i10);
            s4 = (short) 274;
            if (s3 == (short) 274) {
                s4 = bVar.a(i10 + 2);
                s5 = (short) 1;
            }
        }
        return -1;
    }

    private int l(DefaultImageHeaderParser.Reader reader, byte[] bArr, int i) {
        int i2 = reader.b(bArr, i);
        final int i4 = -1;
        i = 3;
        final String str3 = "DfltImageHeaderParser";
        if (i2 != i && Log.isLoggable(str3, i)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Unable to read exif segment data, length: ";
            str = ", actually read: ";
            str4 = str2 + i + str + i2;
            Log.d(str3, str4);
            return i4;
        }
        if (i(bArr, i)) {
            return DefaultImageHeaderParser.k(new DefaultImageHeaderParser.b(bArr, i));
        }
        if (Log.isLoggable(str3, i)) {
            Log.d(str3, "Missing jpeg exif preamble");
        }
        return i4;
    }

    private boolean m(DefaultImageHeaderParser.Reader reader, int i) {
        int i5;
        i = 0;
        if (((reader.a() << 16) | reader.a()) != 1718909296) {
            return false;
        }
        int i11 = (reader.a() << 16) | reader.a();
        int i16 = 1635150182;
        final boolean z = true;
        return true;
    }

    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        k.d(byteBuffer);
        return g(new DefaultImageHeaderParser.a(byteBuffer));
    }

    public int b(ByteBuffer byteBuffer, b bVar) {
        k.d(byteBuffer);
        k.d(bVar);
        return f(new DefaultImageHeaderParser.a(byteBuffer), bVar);
    }

    public ImageHeaderParser.ImageType c(InputStream inputStream) {
        k.d(inputStream);
        return g(new DefaultImageHeaderParser.c(inputStream));
    }

    public int d(InputStream inputStream, b bVar) {
        k.d(inputStream);
        k.d(bVar);
        return f(new DefaultImageHeaderParser.c(inputStream), bVar);
    }

    private static int e(int i, int i2) {
        return (i + 2) + (i2 * 12);
    }

    private static boolean h(int i) {
        int i2 = 65496;
        boolean z = false;
        i2 = 65496;
        if ((i & i2) == i2 || !(i == 19789 && i != 18761)) {
            int i5 = 1;
        }
        return z;
    }
}
