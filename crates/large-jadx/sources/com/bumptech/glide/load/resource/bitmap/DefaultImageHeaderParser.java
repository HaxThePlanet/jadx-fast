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

/* loaded from: classes.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {

    static final byte[] a;
    private static final int[] b;

    private interface Reader {
        public abstract int a();

        public abstract int b(byte[] bArr, int i2);

        public abstract short c();

        public abstract long skip(long l);
    }

    private static final class b {

        private final ByteBuffer a;
        b(byte[] bArr, int i2) {
            super();
            this.a = (ByteBuffer)ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        private boolean c(int i, int i2) {
            int obj2;
            obj2 = remaining -= i >= i2 ? 1 : 0;
            return obj2;
        }

        short a(int i) {
            ByteBuffer z;
            short obj2;
            if (c(i, 2)) {
                obj2 = this.a.getShort(i);
            } else {
                obj2 = -1;
            }
            return obj2;
        }

        int b(int i) {
            ByteBuffer z;
            int obj2;
            if (c(i, 4)) {
                obj2 = this.a.getInt(i);
            } else {
                obj2 = -1;
            }
            return obj2;
        }

        int d() {
            return this.a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }
    }

    private static final class a implements com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader {

        private final ByteBuffer a;
        a(ByteBuffer byteBuffer) {
            super();
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public int a() {
            return i |= s2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public int b(byte[] bArr, int i2) {
            final int obj4 = Math.min(i2, this.a.remaining());
            if (obj4 == null) {
                return -1;
            }
            this.a.get(bArr, 0, obj4);
            return obj4;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public short c() {
            if (this.a.remaining() < 1) {
            } else {
                return (short)i;
            }
            DefaultImageHeaderParser.Reader.EndOfFileException endOfFileException = new DefaultImageHeaderParser.Reader.EndOfFileException();
            throw endOfFileException;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public long skip(long l) {
            int obj3 = (int)obj3;
            final ByteBuffer obj4 = this.a;
            obj4.position(position += obj3);
            return (long)obj3;
        }
    }

    private static final class c implements com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader {

        private final InputStream a;
        c(InputStream inputStream) {
            super();
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public int a() {
            return i |= s2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public int b(byte[] bArr, int i2) {
            int i;
            int read;
            int i3;
            int i4;
            read = i;
            i3 = -1;
            while (i < i2) {
                read = this.a.read(bArr, i, i2 - i);
                if (read != i3) {
                }
                i += read;
                i3 = -1;
            }
            if (i == 0) {
                if (read == i3) {
                } else {
                }
                DefaultImageHeaderParser.Reader.EndOfFileException obj5 = new DefaultImageHeaderParser.Reader.EndOfFileException();
                throw obj5;
            }
            return i;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public short c() {
            int read = this.a.read();
            if (read == -1) {
            } else {
                return (short)read;
            }
            DefaultImageHeaderParser.Reader.EndOfFileException endOfFileException = new DefaultImageHeaderParser.Reader.EndOfFileException();
            throw endOfFileException;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader
        public long skip(long l) {
            int i;
            long skip;
            int read;
            int i2;
            int cmp;
            final int i3 = 0;
            if (Long.compare(l, i3) < 0) {
                return i3;
            }
            i = l;
            while (Long.compare(i, i3) > 0) {
                if (Long.compare(skip, i3) <= 0) {
                    break;
                } else {
                }
                if (this.a.read() == -1) {
                    break;
                } else {
                }
                skip = 1L;
                i -= skip;
            }
            return l -= i;
        }
    }
    static {
        DefaultImageHeaderParser.a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
        int[] iArr = new int[13];
        iArr = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
        DefaultImageHeaderParser.b = iArr;
    }

    private static int e(int i, int i2) {
        return obj0 += obj1;
    }

    private int f(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader defaultImageHeaderParser$Reader, b b2) {
        boolean obj6;
        String obj7;
        final int i = -1;
        int i2 = reader.a();
        final int i4 = 3;
        final String str = "DfltImageHeaderParser";
        if (!DefaultImageHeaderParser.h(i2) && Log.isLoggable(str, i4)) {
            try {
                if (Log.isLoggable(str, i4)) {
                }
                obj6 = new StringBuilder();
                obj6.append("Parser doesn't handle magic number: ");
                obj6.append(i2);
                Log.d(str, obj6.toString());
                return i;
                int i3 = j(reader);
                if (i3 == i && Log.isLoggable(str, i4)) {
                }
                if (Log.isLoggable(str, i4)) {
                }
                Log.d(str, "Failed to parse exif segment length, or exif segment not found");
                return i;
                Object obj2 = b2.e(i3, byte[].class);
                b2.d(obj2);
                return l(reader, (byte[])obj2, i3);
            } catch (Throwable th) {
            }
        }
    }

    private ImageHeaderParser.ImageType g(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader defaultImageHeaderParser$Reader) {
        ImageHeaderParser.ImageType obj6;
        try {
            int i = reader.a();
            if (i == 65496) {
            }
            return ImageHeaderParser.ImageType.JPEG;
            i2 |= s;
            if (i3 == 4671814) {
            }
            return ImageHeaderParser.ImageType.GIF;
            i4 |= s2;
            int i12 = -1991225785;
            if (i5 == i12) {
            }
            reader.skip(21);
            if (reader.c() >= 3) {
            } else {
            }
            obj6 = ImageHeaderParser.ImageType.PNG_A;
            obj6 = ImageHeaderParser.ImageType.PNG;
            return obj6;
            reader = ImageHeaderParser.ImageType.PNG;
            return reader;
            int i13 = 1380533830;
            if (i5 != i13) {
            }
            if (m(reader, i5)) {
            } else {
            }
            obj6 = ImageHeaderParser.ImageType.AVIF;
            obj6 = ImageHeaderParser.ImageType.UNKNOWN;
            return obj6;
            int i8 = 4;
            reader.skip(i8);
            if (i15 |= i21 != 1464156752) {
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
            i18 |= i23;
            if (i19 & -256 != 1448097792) {
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
            i19 &= 255;
            reader.skip(i8);
            obj6 = reader.c();
            if (i20 == 88 && obj6 & 2 != 0) {
            }
            reader.skip(i8);
            obj6 = reader.c();
            if (obj6 & 2 != 0) {
            }
            return ImageHeaderParser.ImageType.ANIMATED_WEBP;
            if (obj6 &= 16 != 0) {
            }
            return ImageHeaderParser.ImageType.WEBP_A;
            return ImageHeaderParser.ImageType.WEBP;
            if (i20 == 76) {
            }
            reader.skip(i8);
            if (obj6 &= 8 != 0) {
            } else {
            }
            obj6 = ImageHeaderParser.ImageType.WEBP_A;
            obj6 = ImageHeaderParser.ImageType.WEBP;
            return obj6;
            return ImageHeaderParser.ImageType.WEBP;
            reader = ImageHeaderParser.ImageType.UNKNOWN;
            return reader;
        } catch (com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException endOfFile) {
        }
    }

    private static boolean h(int i) {
        int i2;
        int obj2;
        i2 = 65496;
        if (i & i2 != i2 && i != 19789) {
            if (i != 19789) {
                if (i == 18761) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private boolean i(byte[] bArr, int i2) {
        int i;
        int length;
        byte[] bArr2;
        int length2;
        int obj6;
        i = 0;
        if (bArr != null && i2 > bArr3.length) {
            obj6 = i2 > bArr3.length ? 1 : i;
        } else {
        }
        if (obj6 != null) {
            length = i;
            bArr2 = DefaultImageHeaderParser.a;
            for (byte bArr2 : obj2) {
                bArr2 = DefaultImageHeaderParser.a;
            }
            i = obj6;
        } else {
        }
        return i;
    }

    private int j(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader defaultImageHeaderParser$Reader) {
        short str2;
        int str3;
        int str;
        boolean obj10;
        short s = reader.c();
        str = 3;
        final int i5 = -1;
        final String str5 = "DfltImageHeaderParser";
        while (s != 255) {
            str2 = reader.c();
            i3 += -2;
            long l = (long)i4;
            final long skip = reader.skip(l);
            s = reader.c();
            str = 3;
            i5 = -1;
            str5 = "DfltImageHeaderParser";
        }
        if (Log.isLoggable(str5, str)) {
            obj10 = new StringBuilder();
            obj10.append("Unknown segmentId=");
            obj10.append(s);
            Log.d(str5, obj10.toString());
        }
        return i5;
    }

    private static int k(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.b defaultImageHeaderParser$b) {
        short string;
        ByteOrder lITTLE_ENDIAN;
        boolean stringBuilder;
        int i;
        String loggable2;
        short str3;
        short stringBuilder2;
        int str4;
        int i2;
        boolean loggable;
        String str;
        String str2;
        int i3 = 6;
        string = b.a(i3);
        final int i7 = 3;
        final String str5 = "DfltImageHeaderParser";
        if (string != 18761) {
            if (string != 19789) {
                if (Log.isLoggable(str5, i7)) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown endianness = ");
                    stringBuilder.append(string);
                    Log.d(str5, stringBuilder.toString());
                }
                lITTLE_ENDIAN = ByteOrder.BIG_ENDIAN;
            } else {
                lITTLE_ENDIAN = ByteOrder.BIG_ENDIAN;
            }
        } else {
            lITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        }
        b.e(lITTLE_ENDIAN);
        i5 += i3;
        i = 0;
        while (i < b.a(i6)) {
            loggable2 = DefaultImageHeaderParser.e(i6, i);
            str3 = b.a(loggable2);
            stringBuilder2 = b.a(loggable2 + 2);
            if (Log.isLoggable(str5, i7)) {
            }
            i++;
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Got invalid format code = ");
            stringBuilder5.append(stringBuilder2);
            Log.d(str5, stringBuilder5.toString());
            str4 = b.b(loggable2 + 4);
            str = " tagType=";
            if (Log.isLoggable(str5, i7)) {
            }
            str4 += i10;
            loggable2 += 8;
            if (Log.isLoggable(str5, i7)) {
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Illegal tagValueOffset=");
            stringBuilder2.append(loggable2);
            stringBuilder2.append(str);
            stringBuilder2.append(str3);
            Log.d(str5, stringBuilder2.toString());
            if (Log.isLoggable(str5, i7)) {
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Illegal number of bytes for TI tag data tagType=");
            stringBuilder3.append(str3);
            Log.d(str5, stringBuilder3.toString());
            if (Log.isLoggable(str5, i7)) {
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Got byte count > 4, not orientation, continuing, formatCode=");
            stringBuilder4.append(stringBuilder2);
            Log.d(str5, stringBuilder4.toString());
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("Got tagIndex=");
            stringBuilder6.append(i);
            stringBuilder6.append(str);
            stringBuilder6.append(str3);
            stringBuilder6.append(" formatCode=");
            stringBuilder6.append(stringBuilder2);
            stringBuilder6.append(" componentCount=");
            stringBuilder6.append(str4);
            Log.d(str5, stringBuilder6.toString());
            if (Log.isLoggable(str5, i7)) {
            }
            Log.d(str5, "Negative tiff component count");
        }
        return -1;
    }

    private int l(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader defaultImageHeaderParser$Reader, byte[] b2Arr2, int i3) {
        int str;
        int obj4;
        boolean obj5;
        int obj6;
        obj4 = reader.b(b2Arr2, i3);
        final int i = -1;
        str = 3;
        final String str2 = "DfltImageHeaderParser";
        if (obj4 != i3 && Log.isLoggable(str2, str)) {
            if (Log.isLoggable(str2, str)) {
                obj5 = new StringBuilder();
                obj5.append("Unable to read exif segment data, length: ");
                obj5.append(i3);
                obj5.append(", actually read: ");
                obj5.append(obj4);
                Log.d(str2, obj5.toString());
            }
            return i;
        }
        if (i(b2Arr2, i3)) {
            obj4 = new DefaultImageHeaderParser.b(b2Arr2, i3);
            return DefaultImageHeaderParser.k(obj4);
        }
        if (Log.isLoggable(str2, str)) {
            Log.d(str2, "Missing jpeg exif preamble");
        }
        return i;
    }

    private boolean m(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader defaultImageHeaderParser$Reader, int i2) {
        int i5;
        int i4;
        int i;
        int i3;
        int obj9;
        int i14 = 0;
        if (i7 |= i13 != 1718909296) {
            return i14;
        }
        i10 |= i16;
        int i17 = 1635150182;
        final int i18 = 1;
        if (i11 != i17) {
            i4 = 1635150195;
            if (i11 == i4) {
            } else {
                reader.skip(4);
                if (obj9 % 4 != 0) {
                    return i14;
                }
                i5 = i14;
                while (i5 < 5) {
                    i21 |= i3;
                    i5++;
                    obj9 += -4;
                }
            }
            return i14;
        }
        return i18;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        k.d(byteBuffer);
        DefaultImageHeaderParser.a aVar = new DefaultImageHeaderParser.a((ByteBuffer)byteBuffer);
        return g(aVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(ByteBuffer byteBuffer, b b2) {
        k.d(byteBuffer);
        DefaultImageHeaderParser.a aVar = new DefaultImageHeaderParser.a((ByteBuffer)byteBuffer);
        k.d(b2);
        return f(aVar, (b)b2);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType c(InputStream inputStream) {
        k.d(inputStream);
        DefaultImageHeaderParser.c cVar = new DefaultImageHeaderParser.c((InputStream)inputStream);
        return g(cVar);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int d(InputStream inputStream, b b2) {
        k.d(inputStream);
        DefaultImageHeaderParser.c cVar = new DefaultImageHeaderParser.c((InputStream)inputStream);
        k.d(b2);
        return f(cVar, (b)b2);
    }
}
