package d.l.a;

import android.content.res.AssetManager.AssetInputStream;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.system.OsConstants;
import android.util.Log;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;
import com.facebook.e0.x.a;
import com.facebook.share.a.a;
import d.h.e.n;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class a {

    private static final byte[] A;
    private static final byte[] B;
    private static final byte[] C;
    private static final byte[] D;
    private static final byte[] E;
    private static final byte[] F;
    private static SimpleDateFormat G;
    private static SimpleDateFormat H;
    static final String[] I;
    static final int[] J;
    static final byte[] K;
    private static final d.l.a.a.d[] L;
    private static final d.l.a.a.d[] M;
    private static final d.l.a.a.d[] N;
    private static final d.l.a.a.d[] O;
    private static final d.l.a.a.d[] P;
    private static final d.l.a.a.d Q;
    private static final d.l.a.a.d[] R;
    private static final d.l.a.a.d[] S;
    private static final d.l.a.a.d[] T;
    private static final d.l.a.a.d[] U;
    static final d.l.a.a.d[][] V;
    private static final d.l.a.a.d[] W;
    private static final HashMap<Integer, d.l.a.a.d>[] X;
    private static final HashMap<String, d.l.a.a.d>[] Y;
    private static final HashSet<String> Z;
    private static final HashMap<Integer, Integer> a0;
    static final Charset b0;
    static final byte[] c0;
    private static final byte[] d0;
    private static final boolean o;
    private static final List<Integer> p;
    private static final List<Integer> q;
    public static final int[] r;
    public static final int[] s;
    static final byte[] t;
    private static final byte[] u;
    private static final byte[] v;
    private static final byte[] w;
    private static final byte[] x;
    private static final byte[] y;
    private static final byte[] z;
    private String a;
    private FileDescriptor b;
    private AssetManager.AssetInputStream c;
    private int d;
    private boolean e;
    private final HashMap<String, d.l.a.a.c>[] f;
    private Set<Integer> g;
    private ByteOrder h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    class a extends MediaDataSource {

        long a;
        final d.l.a.a.f b;
        a(d.l.a.a a, d.l.a.a.f a$f2) {
            this.b = f2;
            super();
        }

        @Override // android.media.MediaDataSource
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long l, byte[] b2Arr2, int i3, int i4) {
            int i;
            int cmp;
            long l2;
            int obj7;
            int obj11;
            if (obj11 == null) {
                return 0;
            }
            i = 0;
            final int i2 = -1;
            if (Long.compare(l, i) < 0) {
                return i2;
            }
            l2 = this.a;
            if (Long.compare(l2, l) != 0 && Long.compare(l2, i) >= 0 && Long.compare(l, l2) >= 0) {
                if (Long.compare(l2, i) >= 0) {
                    if (Long.compare(l, l2) >= 0) {
                        return i2;
                    }
                }
                this.b.i(l);
                this.a = l;
            }
            if (obj11 > this.b.available()) {
                obj11 = this.b.available();
            }
            obj7 = this.b.read(i3, i4, obj11);
            if (obj7 >= 0) {
                try {
                    this.a = obj8 += obj10;
                    return obj7;
                    this.a = -1;
                    return i2;
                }
            }
        }
    }

    private static class b extends InputStream implements DataInput {

        private static final ByteOrder w;
        private static final ByteOrder x;
        final DataInputStream a;
        private ByteOrder b;
        int c;
        private byte[] v;
        static {
            a.b.w = ByteOrder.LITTLE_ENDIAN;
            a.b.x = ByteOrder.BIG_ENDIAN;
        }

        b(InputStream inputStream) {
            super(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder2) {
            super();
            this.b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.a = dataInputStream;
            final int obj2 = 0;
            dataInputStream.mark(obj2);
            this.c = obj2;
            this.b = byteOrder2;
        }

        b(byte[] bArr) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            super(byteArrayInputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int a() {
            return this.c;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.a.available();
        }

        @Override // java.io.InputStream
        public long c() {
            return l &= l2;
        }

        @Override // java.io.InputStream
        public void e(ByteOrder byteOrder) {
            this.b = byteOrder;
        }

        @Override // java.io.InputStream
        public void f(int i) {
            int i2;
            int read;
            byte[] bArr;
            int i3;
            long skip;
            int i4 = 0;
            i2 = i4;
            while (i2 < i) {
                i3 = i - i2;
                i2 += read;
                int i6 = 8192;
                if (this.v == null) {
                }
                this.v = new byte[i6];
            }
            this.c = obj7 += i2;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("Mark is currently unsupported");
            throw obj2;
        }

        @Override // java.io.InputStream
        public int read() {
            this.c = i++;
            return this.a.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            final int obj2 = this.a.read(bArr, i2, i3);
            this.c = obj3 += obj2;
            return obj2;
        }

        @Override // java.io.InputStream
        public boolean readBoolean() {
            this.c = i++;
            return this.a.readBoolean();
        }

        @Override // java.io.InputStream
        public byte readByte() {
            this.c = i++;
            int read = this.a.read();
            if (read < 0) {
            } else {
                return (byte)read;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }

        @Override // java.io.InputStream
        public char readChar() {
            this.c = i += 2;
            return this.a.readChar();
        }

        @Override // java.io.InputStream
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.InputStream
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.InputStream
        public void readFully(byte[] bArr) {
            this.c = i += length;
            this.a.readFully(bArr);
        }

        @Override // java.io.InputStream
        public void readFully(byte[] bArr, int i2, int i3) {
            this.c = i += i3;
            this.a.readFully(bArr, i2, i3);
        }

        @Override // java.io.InputStream
        public int readInt() {
            this.c = i += 4;
            int read = this.a.read();
            int read2 = this.a.read();
            int read3 = this.a.read();
            int read4 = this.a.read();
            if (i16 |= read4 < 0) {
            } else {
                ByteOrder byteOrder2 = this.b;
                if (byteOrder2 == a.b.w) {
                    return i13 += read;
                }
                if (byteOrder2 != a.b.x) {
                } else {
                    return i5 += read4;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid byte order: ");
                stringBuilder.append(this.b);
                IOException iOException = new IOException(stringBuilder.toString());
                throw iOException;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }

        @Override // java.io.InputStream
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.InputStream
        public long readLong() {
            final Object obj = this;
            obj.c = i += i9;
            int read = obj.a.read();
            int read2 = obj.a.read();
            int read3 = obj.a.read();
            int read4 = obj.a.read();
            int read5 = obj.a.read();
            int read6 = obj.a.read();
            int read7 = obj.a.read();
            int read8 = obj.a.read();
            if (i34 |= read8 < 0) {
            } else {
                ByteOrder byteOrder3 = obj.b;
                final int i45 = 24;
                final int i46 = 32;
                final int i47 = 40;
                final int i48 = 48;
                final int i49 = 56;
                if (byteOrder3 == a.b.w) {
                    return i27 += l8;
                }
                if (byteOrder3 != a.b.x) {
                } else {
                    return i42 += l7;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid byte order: ");
                stringBuilder.append(obj.b);
                IOException iOException = new IOException(stringBuilder.toString());
                throw iOException;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }

        @Override // java.io.InputStream
        public short readShort() {
            this.c = i += 2;
            int read = this.a.read();
            int read2 = this.a.read();
            if (read | read2 < 0) {
            } else {
                ByteOrder byteOrder = this.b;
                if (byteOrder == a.b.w) {
                    return (short)i6;
                }
                if (byteOrder != a.b.x) {
                } else {
                    return (short)i4;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid byte order: ");
                stringBuilder.append(this.b);
                IOException iOException = new IOException(stringBuilder.toString());
                throw iOException;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }

        @Override // java.io.InputStream
        public String readUTF() {
            this.c = i += 2;
            return this.a.readUTF();
        }

        @Override // java.io.InputStream
        public int readUnsignedByte() {
            this.c = i++;
            return this.a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public int readUnsignedShort() {
            this.c = i += 2;
            int read = this.a.read();
            int read2 = this.a.read();
            if (read | read2 < 0) {
            } else {
                ByteOrder byteOrder = this.b;
                if (byteOrder == a.b.w) {
                    return i5 += read;
                }
                if (byteOrder != a.b.x) {
                } else {
                    return i3 += read2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid byte order: ");
                stringBuilder.append(this.b);
                IOException iOException = new IOException(stringBuilder.toString());
                throw iOException;
            }
            EOFException eOFException = new EOFException();
            throw eOFException;
        }

        @Override // java.io.InputStream
        public void reset() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Reset is currently unsupported");
            throw unsupportedOperationException;
        }

        @Override // java.io.InputStream
        public int skipBytes(int i) {
            UnsupportedOperationException obj2 = new UnsupportedOperationException("skipBytes is currently unsupported");
            throw obj2;
        }
    }

    private static class c {

        public final int a;
        public final int b;
        public final long c;
        public final byte[] d;
        c(int i, int i2, long l3, byte[] b4Arr4) {
            super();
            this.a = i;
            this.b = i2;
            this.c = l3;
            this.d = obj5;
        }

        c(int i, int i2, byte[] b3Arr3) {
            super(i, i2, -1, obj4, b3Arr3);
        }

        public static d.l.a.a.c a(String string) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append('\0');
            byte[] obj3 = stringBuilder.toString().getBytes(a.b0);
            a.c cVar = new a.c(2, obj3.length, obj3);
            return cVar;
        }

        public static d.l.a.a.c b(long l, ByteOrder byteOrder2) {
            long[] lArr = new long[1];
            return a.c.c(lArr, obj4);
        }

        public static d.l.a.a.c c(long[] lArr, ByteOrder byteOrder2) {
            int i2;
            int i;
            final int i5 = 4;
            ByteBuffer wrap = ByteBuffer.wrap(new byte[i3 *= length]);
            wrap.order(byteOrder2);
            i2 = 0;
            while (i2 < lArr.length) {
                wrap.putInt((int)l);
                i2++;
            }
            a.c obj6 = new a.c(i5, lArr.length, wrap.array());
            return obj6;
        }

        public static d.l.a.a.c d(d.l.a.a.e a$e, ByteOrder byteOrder2) {
            d.l.a.a.e[] arr = new a.e[1];
            return a.c.e(arr, byteOrder2);
        }

        public static d.l.a.a.c e(d.l.a.a.e[] a$eArr, ByteOrder byteOrder2) {
            int i;
            int i2;
            int i3;
            final int i6 = 5;
            ByteBuffer wrap = ByteBuffer.wrap(new byte[i4 *= length]);
            wrap.order(byteOrder2);
            i = 0;
            while (i < eArr.length) {
                Object obj = eArr[i];
                wrap.putInt((int)l2);
                wrap.putInt((int)l);
                i++;
            }
            a.c obj7 = new a.c(i6, eArr.length, wrap.array());
            return obj7;
        }

        public static d.l.a.a.c f(int i, ByteOrder byteOrder2) {
            int[] iArr = new int[1];
            return a.c.g(iArr, byteOrder2);
        }

        public static d.l.a.a.c g(int[] iArr, ByteOrder byteOrder2) {
            int i;
            short s;
            final int i4 = 3;
            ByteBuffer wrap = ByteBuffer.wrap(new byte[i2 *= length]);
            wrap.order(byteOrder2);
            i = 0;
            while (i < iArr.length) {
                wrap.putShort((short)i5);
                i++;
            }
            a.c obj5 = new a.c(i4, iArr.length, wrap.array());
            return obj5;
        }

        public double h(ByteOrder byteOrder) {
            Object obj5 = k(byteOrder);
            if (obj5 == null) {
            } else {
                if (obj5 instanceof String != null) {
                    return Double.parseDouble((String)obj5);
                }
                final int i = 0;
                final String str3 = "There are more than one component";
                final int i2 = 1;
                if (obj5 instanceof long[]) {
                    if (obj5.length != i2) {
                    } else {
                        return (double)l;
                    }
                    obj5 = new NumberFormatException(str3);
                    throw obj5;
                }
                if (obj5 instanceof int[]) {
                    if (obj5.length != i2) {
                    } else {
                        return (double)obj5;
                    }
                    obj5 = new NumberFormatException(str3);
                    throw obj5;
                }
                if (obj5 instanceof double[]) {
                    if (obj5.length != i2) {
                    } else {
                        return (double[])obj5[i];
                    }
                    obj5 = new NumberFormatException(str3);
                    throw obj5;
                }
                if (!obj5 instanceof a.e[]) {
                } else {
                    if (obj5.length != i2) {
                    } else {
                        return (a.e[])obj5[i].a();
                    }
                    obj5 = new NumberFormatException(str3);
                    throw obj5;
                }
                obj5 = new NumberFormatException("Couldn't find a double value");
                throw obj5;
            }
            obj5 = new NumberFormatException("NULL can't be converted to a double value");
            throw obj5;
        }

        public int i(ByteOrder byteOrder) {
            Object obj5 = k(byteOrder);
            if (obj5 == null) {
            } else {
                if (obj5 instanceof String != null) {
                    return Integer.parseInt((String)obj5);
                }
                final int i = 0;
                final String str3 = "There are more than one component";
                final int i2 = 1;
                if (obj5 instanceof long[]) {
                    if (obj5.length != i2) {
                    } else {
                        return (int)l;
                    }
                    obj5 = new NumberFormatException(str3);
                    throw obj5;
                }
                if (!obj5 instanceof int[]) {
                } else {
                    if (obj5.length != i2) {
                    } else {
                        return (int[])obj5[i];
                    }
                    obj5 = new NumberFormatException(str3);
                    throw obj5;
                }
                obj5 = new NumberFormatException("Couldn't find a integer value");
                throw obj5;
            }
            obj5 = new NumberFormatException("NULL can't be converted to a integer value");
            throw obj5;
        }

        public String j(ByteOrder byteOrder) {
            int length;
            int i;
            long l;
            Object obj8 = k(byteOrder);
            length = 0;
            if (obj8 == null) {
                return length;
            }
            if (obj8 instanceof String != null) {
                return (String)obj8;
            }
            StringBuilder stringBuilder = new StringBuilder();
            final String str = ",";
            i = 0;
            if (obj8 instanceof long[]) {
                while (i < obj8.length) {
                    stringBuilder.append((long[])obj8[i]);
                    if (i++ != obj8.length) {
                    }
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            }
            if (obj8 instanceof int[]) {
                while (i < obj8.length) {
                    stringBuilder.append((int[])obj8[i]);
                    if (i++ != obj8.length) {
                    }
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            }
            if (obj8 instanceof double[]) {
                while (i < obj8.length) {
                    stringBuilder.append((double[])obj8[i]);
                    if (i++ != obj8.length) {
                    }
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            }
            if (obj8 instanceof a.e[]) {
                while (i < obj8.length) {
                    stringBuilder.append(obj.a);
                    stringBuilder.append('/');
                    stringBuilder.append(obj2.b);
                    if (i++ != obj8.length) {
                    }
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            }
            return length;
        }

        Object k(ByteOrder byteOrder) {
            Throwable th2;
            int i2;
            Throwable th;
            String str;
            int unsignedShort;
            int i;
            int length3;
            int length2;
            int length;
            double double;
            long length4;
            byte b;
            byte[] obj11;
            final String str3 = "IOException occurred while closing InputStream";
            final String str4 = "ExifInterface";
            a.b bVar = new a.b(this.d);
            bVar.e(byteOrder);
            unsignedShort = 1;
            length3 = 0;
            switch (obj11) {
                case 1:
                    obj11 = this.d;
                    char[] cArr = new char[unsignedShort];
                    cArr[length3] = (char)i9;
                    obj11 = new String(cArr);
                    bVar.close();
                    return obj11;
                    obj11 = new String(this.d, a.b0);
                    bVar.close();
                    return obj11;
                case 2:
                    obj11 = length3;
                    length = a.K;
                    unsignedShort = length3;
                    obj11++;
                    length3 = length.length;
                    obj11 = new StringBuilder();
                    i = this.d[length3];
                    obj11.append((char)i);
                    obj11.append('?');
                    length3++;
                    bVar.close();
                    return obj11.toString();
                case 3:
                    obj11 = new int[this.b];
                    obj11[length3] = bVar.readUnsignedShort();
                    length3++;
                    bVar.close();
                    return obj11;
                case 4:
                    obj11 = new long[this.b];
                    obj11[length3] = bVar.c();
                    length3++;
                    bVar.close();
                    return obj11;
                case 5:
                    obj11 = new a.e[this.b];
                    unsignedShort = new a.e(bVar.c(), obj7, bVar.c(), obj9);
                    obj11[length3] = unsignedShort;
                    length3++;
                    bVar.close();
                    return obj11;
                case 6:
                    obj11 = new int[this.b];
                    obj11[length3] = bVar.readShort();
                    length3++;
                    bVar.close();
                    return obj11;
                case 7:
                    obj11 = new int[this.b];
                    obj11[length3] = bVar.readInt();
                    length3++;
                    bVar.close();
                    return obj11;
                case 8:
                    obj11 = new a.e[this.b];
                    unsignedShort = new a.e((long)int, obj7, (long)int2, obj9);
                    obj11[length3] = unsignedShort;
                    length3++;
                    bVar.close();
                    return obj11;
                case 9:
                    obj11 = new double[this.b];
                    obj11[length3] = (double)unsignedShort;
                    length3++;
                    bVar.close();
                    return obj11;
                case 10:
                    obj11 = new double[this.b];
                    obj11[length3] = bVar.readDouble();
                    length3++;
                    bVar.close();
                    return obj11;
                default:
                    bVar.close();
                    return null;
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(");
            stringBuilder.append(a.I[this.a]);
            stringBuilder.append(", data length:");
            stringBuilder.append(bArr.length);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static class d {

        public final int a;
        public final String b;
        public final int c;
        public final int d;
        d(String string, int i2, int i3) {
            super();
            this.b = string;
            this.a = i2;
            this.c = i3;
            this.d = -1;
        }

        d(String string, int i2, int i3, int i4) {
            super();
            this.b = string;
            this.a = i2;
            this.c = i3;
            this.d = i4;
        }

        boolean a(int i) {
            int i5;
            int i4;
            int i3;
            int i2;
            i5 = this.c;
            i4 = 7;
            final int i6 = 1;
            if (i5 != i4) {
                if (i == i4) {
                } else {
                    if (i5 != i) {
                        i4 = this.d;
                        if (i4 == i) {
                        } else {
                            i3 = 4;
                            if (i5 != i3) {
                                if (i4 == i3 && i == 3) {
                                    if (i == 3) {
                                        return i6;
                                    }
                                }
                            } else {
                            }
                            i2 = 9;
                            if (i5 != i2) {
                                if (i4 == i2 && i == 8) {
                                    if (i == 8) {
                                        return i6;
                                    }
                                }
                            } else {
                            }
                            int i7 = 12;
                            if (i5 != i7) {
                                if (i4 == i7 && i == 11) {
                                    if (i == 11) {
                                        return i6;
                                    }
                                }
                            } else {
                            }
                        }
                        return 0;
                    }
                }
            }
            return i6;
        }
    }

    private static class e {

        public final long a;
        public final long b = 1;
        e(long l, long l2) {
            super();
            final int i = 0;
            if (Long.compare(obj6, i) == 0) {
                this.a = i;
                final int obj4 = 1;
            }
            this.a = l;
            this.b = obj6;
        }

        public double a() {
            return d /= d2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("/");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }
    }

    private static class f extends d.l.a.a.b {
        f(InputStream inputStream) {
            super(inputStream);
            if (!inputStream.markSupported()) {
            } else {
                this.a.mark(Integer.MAX_VALUE);
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            throw obj2;
        }

        f(byte[] bArr) {
            super(bArr);
            this.a.mark(Integer.MAX_VALUE);
        }

        @Override // d.l.a.a$b
        public void i(long l) {
            DataInputStream inputStream;
            long obj4;
            int i = this.c;
            if (Long.compare(l2, l) > 0) {
                this.c = 0;
                this.a.reset();
            } else {
                l -= inputStream;
            }
            f((int)obj4);
        }
    }
    static {
        SimpleDateFormat simpleDateFormat;
        TimeZone timeZone;
        String str;
        String str2;
        String str4;
        String str3;
        int i;
        int i10 = 3;
        Integer valueOf2 = Integer.valueOf(i10);
        a.o = Log.isLoggable("ExifInterface", i10);
        int i3 = 4;
        Integer[] arr7 = new Integer[i3];
        int i73 = 1;
        final Integer valueOf8 = Integer.valueOf(i73);
        int i81 = 0;
        arr7[i81] = valueOf8;
        int i179 = 6;
        arr7[i73] = Integer.valueOf(i179);
        int i308 = 2;
        final Integer valueOf11 = Integer.valueOf(i308);
        arr7[i308] = valueOf2;
        int i349 = 8;
        Integer valueOf12 = Integer.valueOf(i349);
        arr7[i10] = valueOf12;
        a.p = Arrays.asList(arr7);
        Integer[] arr8 = new Integer[i3];
        arr8[i81] = valueOf11;
        Integer valueOf13 = 7;
        arr8[i73] = valueOf13;
        arr8[i308] = Integer.valueOf(i3);
        int i428 = 5;
        final Integer valueOf15 = Integer.valueOf(i428);
        arr8[i10] = valueOf15;
        a.q = Arrays.asList(arr8);
        int[] iArr = new int[i10];
        iArr = new int[]{8, 8, 8};
        a.r = iArr;
        int[] iArr2 = new int[i73];
        iArr2[i81] = i349;
        a.s = iArr2;
        byte[] bArr = new byte[i10];
        bArr = new byte[]{-1, -40, -1};
        a.t = bArr;
        byte[] bArr2 = new byte[i3];
        bArr2 = new byte[]{102, 116, 121, 112};
        a.u = bArr2;
        byte[] bArr3 = new byte[i3];
        bArr3 = new byte[]{109, 105, 102, 49};
        a.v = bArr3;
        byte[] bArr4 = new byte[i3];
        bArr4 = new byte[]{104, 101, 105, 99};
        a.w = bArr4;
        byte[] bArr5 = new byte[i179];
        bArr5 = new byte[]{79, 76, 89, 77, 80, 0};
        a.x = bArr5;
        byte[] bArr6 = new byte[10];
        bArr6 = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        a.y = bArr6;
        byte[] bArr7 = new byte[i349];
        bArr7 = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        a.z = bArr7;
        byte[] bArr8 = new byte[i3];
        bArr8 = new byte[]{101, 88, 73, 102};
        a.A = bArr8;
        byte[] bArr9 = new byte[i3];
        bArr9 = new byte[]{73, 72, 68, 82};
        a.B = bArr9;
        byte[] bArr10 = new byte[i3];
        bArr10 = new byte[]{73, 69, 78, 68};
        a.C = bArr10;
        byte[] bArr11 = new byte[i3];
        bArr11 = new byte[]{82, 73, 70, 70};
        a.D = bArr11;
        byte[] bArr12 = new byte[i3];
        bArr12 = new byte[]{87, 69, 66, 80};
        a.E = bArr12;
        byte[] bArr13 = new byte[i3];
        bArr13 = new byte[]{69, 88, 73, 70};
        a.F = bArr13;
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        a.I = /* result */;
        int[] iArr3 = new int[14];
        iArr3 = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        a.J = iArr3;
        byte[] bArr14 = new byte[i349];
        bArr14 = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        a.K = bArr14;
        d.l.a.a.d[] arr15 = new a.d[42];
        a.d dVar84 = new a.d("NewSubfileType", 254, i3);
        arr15[i81] = dVar84;
        a.d dVar85 = new a.d("SubfileType", 255, i3);
        arr15[i73] = dVar85;
        a.d dVar86 = new a.d("ImageWidth", 256, i10, i3);
        arr15[i308] = dVar86;
        a.d dVar87 = new a.d("ImageLength", 257, i10, i3);
        arr15[i10] = dVar87;
        a.d dVar88 = new a.d("BitsPerSample", 258, i10);
        arr15[i3] = dVar88;
        a.d dVar89 = new a.d("Compression", 259, i10);
        arr15[i428] = dVar89;
        a.d dVar90 = new a.d("PhotometricInterpretation", 262, i10);
        arr15[6] = dVar90;
        a.d dVar91 = new a.d("ImageDescription", 270, i308);
        arr15[7] = dVar91;
        a.d dVar92 = new a.d("Make", 271, i308);
        arr15[8] = dVar92;
        a.d dVar93 = new a.d("Model", 272, i308);
        arr15[9] = dVar93;
        a.d dVar94 = new a.d("StripOffsets", 273, i10, i3);
        arr15[10] = dVar94;
        a.d dVar95 = new a.d("Orientation", 274, i10);
        arr15[11] = dVar95;
        a.d dVar96 = new a.d("SamplesPerPixel", 277, i10);
        arr15[12] = dVar96;
        a.d dVar97 = new a.d("RowsPerStrip", 278, i10, i3);
        arr15[13] = dVar97;
        a.d dVar98 = new a.d("StripByteCounts", 279, i10, i3);
        arr15[14] = dVar98;
        a.d dVar99 = new a.d("XResolution", 282, i428);
        arr15[15] = dVar99;
        a.d dVar100 = new a.d("YResolution", 283, i428);
        arr15[16] = dVar100;
        a.d dVar101 = new a.d("PlanarConfiguration", 284, i10);
        arr15[17] = dVar101;
        a.d dVar102 = new a.d("ResolutionUnit", 296, i10);
        arr15[18] = dVar102;
        a.d dVar103 = new a.d("TransferFunction", 301, i10);
        arr15[19] = dVar103;
        a.d dVar104 = new a.d("Software", 305, i308);
        arr15[20] = dVar104;
        a.d dVar105 = new a.d("DateTime", 306, i308);
        arr15[21] = dVar105;
        a.d dVar106 = new a.d("Artist", 315, i308);
        arr15[22] = dVar106;
        a.d dVar107 = new a.d("WhitePoint", 318, i428);
        int i208 = 23;
        arr15[i208] = dVar107;
        a.d dVar108 = new a.d("PrimaryChromaticities", 319, i428);
        arr15[24] = dVar108;
        a.d dVar109 = new a.d("SubIFDPointer", 330, i3);
        arr15[25] = dVar109;
        a.d dVar110 = new a.d("JPEGInterchangeFormat", 513, i3);
        arr15[26] = dVar110;
        a.d dVar111 = new a.d("JPEGInterchangeFormatLength", 514, i3);
        arr15[27] = dVar111;
        a.d dVar112 = new a.d("YCbCrCoefficients", 529, i428);
        arr15[28] = dVar112;
        a.d dVar113 = new a.d("YCbCrSubSampling", 530, i10);
        arr15[29] = dVar113;
        a.d dVar114 = new a.d("YCbCrPositioning", 531, i10);
        arr15[30] = dVar114;
        a.d dVar115 = new a.d("ReferenceBlackWhite", 532, i428);
        arr15[31] = dVar115;
        a.d dVar116 = new a.d("Copyright", 33432, i308);
        arr15[32] = dVar116;
        a.d dVar117 = new a.d("ExifIFDPointer", 34665, i3);
        arr15[33] = dVar117;
        a.d dVar118 = new a.d("GPSInfoIFDPointer", 34853, i3);
        arr15[34] = dVar118;
        a.d dVar119 = new a.d("SensorTopBorder", i3, i3);
        arr15[35] = dVar119;
        a.d dVar120 = new a.d("SensorLeftBorder", i428, i3);
        arr15[36] = dVar120;
        a.d dVar121 = new a.d("SensorBottomBorder", 6, i3);
        arr15[37] = dVar121;
        int i374 = 7;
        a.d dVar122 = new a.d("SensorRightBorder", i374, i3);
        arr15[38] = dVar122;
        a.d dVar123 = new a.d("ISO", i208, i10);
        arr15[39] = dVar123;
        a.d dVar124 = new a.d("JpgFromRaw", 46, i374);
        arr15[40] = dVar124;
        a.d dVar125 = new a.d("Xmp", 700, i73);
        arr15[41] = dVar125;
        a.L = arr15;
        d.l.a.a.d[] arr9 = new a.d[74];
        a.d dVar192 = new a.d("ExposureTime", 33434, i428);
        arr9[0] = dVar192;
        a.d dVar193 = new a.d("FNumber", 33437, i428);
        arr9[i73] = dVar193;
        a.d dVar194 = new a.d("ExposureProgram", 34850, i10);
        arr9[i308] = dVar194;
        a.d dVar195 = new a.d("SpectralSensitivity", 34852, i308);
        arr9[i10] = dVar195;
        a.d dVar196 = new a.d("PhotographicSensitivity", 34855, i10);
        arr9[i3] = dVar196;
        int i74 = 7;
        a.d dVar197 = new a.d("OECF", 34856, i74);
        arr9[i428] = dVar197;
        a.d dVar198 = new a.d("SensitivityType", 34864, i10);
        arr9[6] = dVar198;
        a.d dVar199 = new a.d("StandardOutputSensitivity", 34865, i3);
        arr9[i74] = dVar199;
        a.d dVar126 = new a.d("RecommendedExposureIndex", 34866, i3);
        arr9[8] = dVar126;
        a.d dVar127 = new a.d("ISOSpeed", 34867, i3);
        arr9[9] = dVar127;
        a.d dVar128 = new a.d("ISOSpeedLatitudeyyy", 34868, i3);
        arr9[10] = dVar128;
        a.d dVar129 = new a.d("ISOSpeedLatitudezzz", 34869, i3);
        arr9[11] = dVar129;
        a.d dVar130 = new a.d("ExifVersion", 36864, i308);
        arr9[12] = dVar130;
        a.d dVar131 = new a.d("DateTimeOriginal", 36867, i308);
        arr9[13] = dVar131;
        a.d dVar132 = new a.d("DateTimeDigitized", 36868, i308);
        arr9[14] = dVar132;
        a.d dVar133 = new a.d("OffsetTime", 36880, i308);
        arr9[15] = dVar133;
        a.d dVar134 = new a.d("OffsetTimeOriginal", 36881, i308);
        arr9[16] = dVar134;
        a.d dVar135 = new a.d("OffsetTimeDigitized", 36882, i308);
        arr9[17] = dVar135;
        a.d dVar136 = new a.d("ComponentsConfiguration", 37121, 7);
        arr9[18] = dVar136;
        a.d dVar137 = new a.d("CompressedBitsPerPixel", 37122, i428);
        arr9[19] = dVar137;
        int i384 = 10;
        a.d dVar138 = new a.d("ShutterSpeedValue", 37377, i384);
        arr9[20] = dVar138;
        a.d dVar139 = new a.d("ApertureValue", 37378, i428);
        arr9[21] = dVar139;
        a.d dVar140 = new a.d("BrightnessValue", 37379, i384);
        arr9[22] = dVar140;
        a.d dVar141 = new a.d("ExposureBiasValue", 37380, i384);
        arr9[23] = dVar141;
        a.d dVar142 = new a.d("MaxApertureValue", 37381, i428);
        arr9[24] = dVar142;
        a.d dVar143 = new a.d("SubjectDistance", 37382, i428);
        arr9[25] = dVar143;
        a.d dVar144 = new a.d("MeteringMode", 37383, i10);
        arr9[26] = dVar144;
        a.d dVar145 = new a.d("LightSource", 37384, i10);
        arr9[27] = dVar145;
        a.d dVar146 = new a.d("Flash", 37385, i10);
        arr9[28] = dVar146;
        a.d dVar147 = new a.d("FocalLength", 37386, i428);
        arr9[29] = dVar147;
        a.d dVar148 = new a.d("SubjectArea", 37396, i10);
        arr9[30] = dVar148;
        int i385 = 7;
        a.d dVar149 = new a.d("MakerNote", 37500, i385);
        arr9[31] = dVar149;
        a.d dVar150 = new a.d("UserComment", 37510, i385);
        arr9[32] = dVar150;
        a.d dVar151 = new a.d("SubSecTime", 37520, i308);
        arr9[33] = dVar151;
        a.d dVar152 = new a.d("SubSecTimeOriginal", 37521, i308);
        arr9[34] = dVar152;
        a.d dVar153 = new a.d("SubSecTimeDigitized", 37522, i308);
        arr9[35] = dVar153;
        a.d dVar154 = new a.d("FlashpixVersion", 40960, 7);
        arr9[36] = dVar154;
        a.d dVar155 = new a.d("ColorSpace", 40961, i10);
        arr9[37] = dVar155;
        a.d dVar156 = new a.d("PixelXDimension", 40962, i10, i3);
        arr9[38] = dVar156;
        a.d dVar157 = new a.d("PixelYDimension", 40963, i10, i3);
        arr9[39] = dVar157;
        a.d dVar158 = new a.d("RelatedSoundFile", 40964, i308);
        arr9[40] = dVar158;
        a.d dVar159 = new a.d("InteroperabilityIFDPointer", 40965, i3);
        arr9[41] = dVar159;
        a.d dVar160 = new a.d("FlashEnergy", 41483, i428);
        arr9[42] = dVar160;
        a.d dVar161 = new a.d("SpatialFrequencyResponse", 41484, 7);
        arr9[43] = dVar161;
        a.d dVar162 = new a.d("FocalPlaneXResolution", 41486, i428);
        arr9[44] = dVar162;
        a.d dVar163 = new a.d("FocalPlaneYResolution", 41487, i428);
        arr9[45] = dVar163;
        a.d dVar164 = new a.d("FocalPlaneResolutionUnit", 41488, i10);
        arr9[46] = dVar164;
        a.d dVar165 = new a.d("SubjectLocation", 41492, i10);
        arr9[47] = dVar165;
        a.d dVar166 = new a.d("ExposureIndex", 41493, i428);
        arr9[48] = dVar166;
        a.d dVar167 = new a.d("SensingMethod", 41495, i10);
        arr9[49] = dVar167;
        int i388 = 7;
        a.d dVar168 = new a.d("FileSource", 41728, i388);
        arr9[50] = dVar168;
        a.d dVar169 = new a.d("SceneType", 41729, i388);
        arr9[51] = dVar169;
        a.d dVar170 = new a.d("CFAPattern", 41730, i388);
        arr9[52] = dVar170;
        a.d dVar171 = new a.d("CustomRendered", 41985, i10);
        arr9[53] = dVar171;
        a.d dVar172 = new a.d("ExposureMode", 41986, i10);
        arr9[54] = dVar172;
        a.d dVar173 = new a.d("WhiteBalance", 41987, i10);
        arr9[55] = dVar173;
        a.d dVar174 = new a.d("DigitalZoomRatio", 41988, i428);
        arr9[56] = dVar174;
        a.d dVar175 = new a.d("FocalLengthIn35mmFilm", 41989, i10);
        arr9[57] = dVar175;
        a.d dVar176 = new a.d("SceneCaptureType", 41990, i10);
        arr9[58] = dVar176;
        a.d dVar177 = new a.d("GainControl", 41991, i10);
        arr9[59] = dVar177;
        a.d dVar178 = new a.d("Contrast", 41992, i10);
        arr9[60] = dVar178;
        a.d dVar179 = new a.d("Saturation", 41993, i10);
        arr9[61] = dVar179;
        a.d dVar180 = new a.d("Sharpness", 41994, i10);
        arr9[62] = dVar180;
        a.d dVar181 = new a.d("DeviceSettingDescription", 41995, 7);
        arr9[63] = dVar181;
        a.d dVar182 = new a.d("SubjectDistanceRange", 41996, i10);
        arr9[64] = dVar182;
        a.d dVar183 = new a.d("ImageUniqueID", 42016, i308);
        arr9[65] = dVar183;
        a.d dVar184 = new a.d("CameraOwnerName", 42032, i308);
        arr9[66] = dVar184;
        a.d dVar185 = new a.d("BodySerialNumber", 42033, i308);
        arr9[67] = dVar185;
        a.d dVar186 = new a.d("LensSpecification", 42034, i428);
        arr9[68] = dVar186;
        a.d dVar187 = new a.d("LensMake", 42035, i308);
        arr9[69] = dVar187;
        a.d dVar188 = new a.d("LensModel", 42036, i308);
        arr9[70] = dVar188;
        a.d dVar189 = new a.d("Gamma", 42240, i428);
        arr9[71] = dVar189;
        a.d dVar190 = new a.d("DNGVersion", 50706, 1);
        arr9[72] = dVar190;
        a.d dVar191 = new a.d("DefaultCropSize", 50720, i10, i3);
        arr9[73] = dVar191;
        a.M = arr9;
        d.l.a.a.d[] arr10 = new a.d[32];
        int i4 = 1;
        int i391 = 0;
        a.d dVar200 = new a.d("GPSVersionID", i391, i4);
        arr10[i391] = dVar200;
        a.d dVar201 = new a.d("GPSLatitudeRef", i4, i308);
        arr10[i4] = dVar201;
        int i279 = 10;
        a.d dVar = new a.d("GPSLatitude", i308, i428, i279);
        arr10[i308] = dVar;
        a.d dVar2 = new a.d("GPSLongitudeRef", i10, i308);
        arr10[i10] = dVar2;
        int i392 = 4;
        a.d dVar3 = new a.d("GPSLongitude", i392, i428, i279);
        arr10[i392] = dVar3;
        a.d dVar4 = new a.d("GPSAltitudeRef", i428, 1);
        arr10[i428] = dVar4;
        int i281 = 6;
        a.d dVar5 = new a.d("GPSAltitude", i281, i428);
        arr10[i281] = dVar5;
        int i282 = 7;
        a.d dVar6 = new a.d("GPSTimeStamp", i282, i428);
        arr10[i282] = dVar6;
        int i283 = 8;
        a.d dVar7 = new a.d("GPSSatellites", i283, i308);
        arr10[i283] = dVar7;
        int i284 = 9;
        a.d dVar8 = new a.d("GPSStatus", i284, i308);
        arr10[i284] = dVar8;
        int i285 = 10;
        a.d dVar9 = new a.d("GPSMeasureMode", i285, i308);
        arr10[i285] = dVar9;
        int i286 = 11;
        a.d dVar10 = new a.d("GPSDOP", i286, i428);
        arr10[i286] = dVar10;
        int i287 = 12;
        a.d dVar11 = new a.d("GPSSpeedRef", i287, i308);
        arr10[i287] = dVar11;
        int i288 = 13;
        a.d dVar12 = new a.d("GPSSpeed", i288, i428);
        arr10[i288] = dVar12;
        int i289 = 14;
        a.d dVar13 = new a.d("GPSTrackRef", i289, i308);
        arr10[i289] = dVar13;
        int i290 = 15;
        a.d dVar14 = new a.d("GPSTrack", i290, i428);
        arr10[i290] = dVar14;
        int i291 = 16;
        a.d dVar15 = new a.d("GPSImgDirectionRef", i291, i308);
        arr10[i291] = dVar15;
        int i292 = 17;
        a.d dVar16 = new a.d("GPSImgDirection", i292, i428);
        arr10[i292] = dVar16;
        int i293 = 18;
        a.d dVar17 = new a.d("GPSMapDatum", i293, i308);
        arr10[i293] = dVar17;
        int i294 = 19;
        a.d dVar18 = new a.d("GPSDestLatitudeRef", i294, i308);
        arr10[i294] = dVar18;
        int i295 = 20;
        a.d dVar19 = new a.d("GPSDestLatitude", i295, i428);
        arr10[i295] = dVar19;
        a.d dVar20 = new a.d("GPSDestLongitudeRef", 21, i308);
        arr10[21] = dVar20;
        a.d dVar21 = new a.d("GPSDestLongitude", 22, i428);
        arr10[22] = dVar21;
        int i298 = 23;
        a.d dVar22 = new a.d("GPSDestBearingRef", i298, i308);
        arr10[i298] = dVar22;
        a.d dVar23 = new a.d("GPSDestBearing", 24, i428);
        arr10[24] = dVar23;
        a.d dVar24 = new a.d("GPSDestDistanceRef", 25, i308);
        arr10[25] = dVar24;
        a.d dVar25 = new a.d("GPSDestDistance", 26, i428);
        arr10[26] = dVar25;
        int i393 = 7;
        a.d dVar26 = new a.d("GPSProcessingMethod", 27, i393);
        arr10[27] = dVar26;
        a.d dVar27 = new a.d("GPSAreaInformation", 28, i393);
        arr10[28] = dVar27;
        a.d dVar28 = new a.d("GPSDateStamp", 29, i308);
        arr10[29] = dVar28;
        a.d dVar29 = new a.d("GPSDifferential", 30, i10);
        arr10[30] = dVar29;
        a.d dVar30 = new a.d("GPSHPositioningError", 31, i428);
        arr10[31] = dVar30;
        a.N = arr10;
        int i5 = 1;
        d.l.a.a.d[] arr11 = new a.d[i5];
        a.d dVar202 = new a.d("InteroperabilityIndex", i5, i308);
        int i6 = 0;
        arr11[i6] = dVar202;
        a.O = arr11;
        d.l.a.a.d[] arr12 = new a.d[38];
        int i11 = 4;
        a.d dVar205 = new a.d("NewSubfileType", 254, i11);
        arr12[i6] = dVar205;
        a.d dVar31 = new a.d("SubfileType", 255, i11);
        arr12[1] = dVar31;
        int i429 = 3;
        a.d dVar32 = new a.d("ThumbnailImageWidth", 256, i429, i11);
        arr12[2] = dVar32;
        a.d dVar33 = new a.d("ThumbnailImageLength", 257, i429, i11);
        arr12[i429] = dVar33;
        a.d dVar34 = new a.d("BitsPerSample", 258, i429);
        arr12[i11] = dVar34;
        a.d dVar35 = new a.d("Compression", 259, i429);
        arr12[5] = dVar35;
        a.d dVar36 = new a.d("PhotometricInterpretation", 262, i429);
        arr12[6] = dVar36;
        int i398 = 2;
        a.d dVar37 = new a.d("ImageDescription", 270, i398);
        arr12[7] = dVar37;
        a.d dVar38 = new a.d("Make", 271, i398);
        arr12[8] = dVar38;
        a.d dVar39 = new a.d("Model", 272, i398);
        arr12[9] = dVar39;
        int i430 = 3;
        a.d dVar40 = new a.d("StripOffsets", 273, i430, 4);
        arr12[10] = dVar40;
        a.d dVar41 = new a.d("ThumbnailOrientation", 274, i430);
        arr12[11] = dVar41;
        a.d dVar42 = new a.d("SamplesPerPixel", 277, i430);
        arr12[12] = dVar42;
        int i400 = 4;
        a.d dVar43 = new a.d("RowsPerStrip", 278, i430, i400);
        arr12[13] = dVar43;
        a.d dVar44 = new a.d("StripByteCounts", 279, i430, i400);
        arr12[14] = dVar44;
        int i401 = 5;
        a.d dVar45 = new a.d("XResolution", 282, i401);
        arr12[15] = dVar45;
        a.d dVar46 = new a.d("YResolution", 283, i401);
        arr12[16] = dVar46;
        int i402 = 3;
        a.d dVar47 = new a.d("PlanarConfiguration", 284, i402);
        arr12[17] = dVar47;
        a.d dVar48 = new a.d("ResolutionUnit", 296, i402);
        arr12[18] = dVar48;
        a.d dVar49 = new a.d("TransferFunction", 301, i402);
        arr12[19] = dVar49;
        int i403 = 2;
        a.d dVar50 = new a.d("Software", 305, i403);
        arr12[20] = dVar50;
        a.d dVar51 = new a.d("DateTime", 306, i403);
        arr12[21] = dVar51;
        a.d dVar52 = new a.d("Artist", 315, i403);
        arr12[22] = dVar52;
        int i404 = 5;
        a.d dVar53 = new a.d("WhitePoint", 318, i404);
        arr12[23] = dVar53;
        a.d dVar54 = new a.d("PrimaryChromaticities", 319, i404);
        arr12[24] = dVar54;
        int i405 = 4;
        a.d dVar55 = new a.d("SubIFDPointer", 330, i405);
        arr12[25] = dVar55;
        a.d dVar56 = new a.d("JPEGInterchangeFormat", 513, i405);
        arr12[26] = dVar56;
        a.d dVar57 = new a.d("JPEGInterchangeFormatLength", 514, i405);
        arr12[27] = dVar57;
        a.d dVar58 = new a.d("YCbCrCoefficients", 529, 5);
        arr12[28] = dVar58;
        int i407 = 3;
        a.d dVar59 = new a.d("YCbCrSubSampling", 530, i407);
        arr12[29] = dVar59;
        a.d dVar60 = new a.d("YCbCrPositioning", 531, i407);
        arr12[30] = dVar60;
        a.d dVar61 = new a.d("ReferenceBlackWhite", 532, 5);
        arr12[31] = dVar61;
        a.d dVar62 = new a.d("Xmp", 700, 1);
        arr12[32] = dVar62;
        a.d dVar63 = new a.d("Copyright", 33432, 2);
        arr12[33] = dVar63;
        int i411 = 4;
        a.d dVar64 = new a.d("ExifIFDPointer", 34665, i411);
        arr12[34] = dVar64;
        a.d dVar65 = new a.d("GPSInfoIFDPointer", 34853, i411);
        arr12[35] = dVar65;
        a.d dVar66 = new a.d("DNGVersion", 50706, 1);
        arr12[36] = dVar66;
        int i431 = 3;
        a.d dVar67 = new a.d("DefaultCropSize", 50720, i431, 4);
        arr12[37] = dVar67;
        a.P = arr12;
        a.d dVar68 = new a.d("StripOffsets", 273, i431);
        a.Q = dVar68;
        d.l.a.a.d[] arr = new a.d[i431];
        a.d dVar69 = new a.d("ThumbnailImage", 256, 7);
        arr[0] = dVar69;
        int i433 = 4;
        a.d dVar70 = new a.d("CameraSettingsIFDPointer", 8224, i433);
        arr[1] = dVar70;
        a.d dVar71 = new a.d("ImageProcessingIFDPointer", 8256, i433);
        int i348 = 2;
        arr[i348] = dVar71;
        a.R = arr;
        d.l.a.a.d[] arr6 = new a.d[i348];
        a.d dVar203 = new a.d("PreviewImageStart", 257, i433);
        arr6[0] = dVar203;
        a.d dVar204 = new a.d("PreviewImageLength", 258, i433);
        int i418 = 1;
        arr6[i418] = dVar204;
        a.S = arr6;
        d.l.a.a.d[] arr13 = new a.d[i418];
        int i427 = 3;
        a.d dVar206 = new a.d("AspectFrame", 4371, i427);
        arr13[0] = dVar206;
        a.T = arr13;
        d.l.a.a.d[] arr16 = new a.d[1];
        a.d dVar207 = new a.d("ColorSpace", 55, i427);
        int i47 = 0;
        arr16[i47] = dVar207;
        a.U = arr16;
        d.l.a.a.d[][] arr14 = new a.d[10];
        arr14[i47] = arr15;
        arr14[1] = arr9;
        arr14[2] = arr10;
        arr14[i427] = arr11;
        int i50 = 4;
        arr14[i50] = arr12;
        arr14[5] = arr15;
        int i67 = 6;
        arr14[i67] = arr;
        arr14[7] = arr6;
        arr14[8] = arr13;
        arr14[9] = arr16;
        a.V = arr14;
        d.l.a.a.d[] arr2 = new a.d[i67];
        a.d dVar72 = new a.d("SubIFDPointer", 330, i50);
        arr2[0] = dVar72;
        a.d dVar73 = new a.d("ExifIFDPointer", 34665, i50);
        arr2[1] = dVar73;
        a.d dVar74 = new a.d("GPSInfoIFDPointer", 34853, i50);
        arr2[2] = dVar74;
        a.d dVar75 = new a.d("InteroperabilityIFDPointer", 40965, i50);
        arr2[3] = dVar75;
        int i177 = 1;
        a.d dVar76 = new a.d("CameraSettingsIFDPointer", 8224, i177);
        arr2[i50] = dVar76;
        a.d dVar77 = new a.d("ImageProcessingIFDPointer", 8256, i177);
        arr2[5] = dVar77;
        a.W = arr2;
        a.X = new HashMap[arr14.length];
        a.Y = new HashMap[arr14.length];
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        a.Z = hashSet;
        HashMap hashMap = new HashMap();
        a.a0 = hashMap;
        Charset forName = Charset.forName("US-ASCII");
        a.b0 = forName;
        a.c0 = "Exif\u0000\u0000".getBytes(forName);
        a.d0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale uS = Locale.US;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", uS);
        a.G = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", uS);
        a.H = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        i = 0;
        d.l.a.a.d[][] arr5 = a.V;
        for (Object simpleDateFormat : i2) {
            HashMap hashMap2 = new HashMap();
            a.X[i] = hashMap2;
            HashMap hashMap3 = new HashMap();
            a.Y[i] = hashMap3;
            str = 0;
            while (str < simpleDateFormat.length) {
                str2 = simpleDateFormat[str];
                a.X[i].put(Integer.valueOf(str2.a), str2);
                a.Y[i].put(str2.b, str2);
                str++;
            }
            arr5 = a.V;
            str2 = simpleDateFormat[str];
            a.X[i].put(Integer.valueOf(str2.a), str2);
            a.Y[i].put(str2.b, str2);
            str++;
        }
        HashMap map = a.a0;
        d.l.a.a.d[] objArr = a.W;
        map.put(Integer.valueOf(dVar79.a), valueOf15);
        map.put(Integer.valueOf(dVar80.a), valueOf8);
        map.put(Integer.valueOf(dVar81.a), valueOf11);
        map.put(Integer.valueOf(dVar82.a), valueOf2);
        map.put(Integer.valueOf(dVar83.a), valueOf13);
        map.put(Integer.valueOf(dVar78.a), valueOf12);
        Pattern.compile(".*[1-9].*");
        Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    }

    public a(InputStream inputStream) {
        super(inputStream, 0);
    }

    public a(InputStream inputStream, int i2) {
        int i;
        int length;
        Object obj4;
        int obj5;
        super();
        d.l.a.a.d[][] arr = a.V;
        this.f = new HashMap[arr.length];
        HashSet hashSet = new HashSet(arr.length);
        this.g = hashSet;
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        int i3 = 0;
        this.a = i3;
        i = 1;
        obj5 = i2 == i ? i : 0;
        if (obj5 != null) {
            obj5 = new BufferedInputStream(inputStream, bArr.length);
            if (!a.r(obj5)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
            }
            this.e = i;
            this.c = i3;
            this.b = i3;
            obj4 = obj5;
        } else {
            if (inputStream instanceof AssetManager.AssetInputStream != null) {
                this.c = (AssetManager.AssetInputStream)inputStream;
                this.b = i3;
            } else {
                obj5 = inputStream;
                if (inputStream instanceof FileInputStream != null && a.y((FileInputStream)obj5.getFD()) != null) {
                    obj5 = inputStream;
                    if (a.y((FileInputStream)obj5.getFD()) != null) {
                        this.c = i3;
                        this.b = obj5.getFD();
                    } else {
                        this.c = i3;
                        this.b = i3;
                    }
                } else {
                }
            }
        }
        C(obj4);
    }

    public a(String string) {
        super();
        d.l.a.a.d[][] arr = a.V;
        this.f = new HashMap[arr.length];
        HashSet hashSet = new HashSet(arr.length);
        this.g = hashSet;
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(string, "filename cannot be null");
        q(string);
    }

    private boolean A(HashMap hashMap) {
        Object obj;
        String str;
        Object obj3;
        obj = hashMap.get("ImageLength");
        obj3 = hashMap.get("ImageWidth");
        str = 512;
        if (obj != null && obj3 != null && (a.c)obj.i(this.h) <= str && (a.c)obj3.i(this.h) <= str) {
            if (obj3 != null) {
                str = 512;
                if (obj.i(this.h) <= str) {
                    if (obj3.i(this.h) <= str) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private boolean B(byte[] bArr) {
        int i2;
        int i;
        byte b2;
        byte[] bArr2;
        byte b;
        int length;
        final int i3 = 0;
        i2 = i3;
        bArr2 = a.D;
        for (byte b2 : obj2) {
            bArr2 = a.D;
        }
        i = i3;
        byte[] bArr3 = a.E;
        for (byte bArr2 : obj2) {
            bArr3 = a.E;
        }
        return 1;
    }

    private void C(InputStream inputStream) {
        d.l.a.a.f fVar;
        String str2;
        int i;
        boolean bufferedInputStream;
        boolean z2;
        long bVar;
        String str;
        int length;
        HashMap hashMap;
        Object obj5;
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        fVar = 0;
        i = fVar;
        while (i < arr.length) {
            hashMap = new HashMap();
            this.f[i] = hashMap;
            i++;
        }
        if (!this.e) {
            bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.d = g(bufferedInputStream);
            obj5 = bufferedInputStream;
        }
        if (a.L(this.d)) {
            fVar = new a.f(obj5);
            if (this.e) {
                try {
                    m(fVar);
                    obj5 = this.d;
                    if (obj5 == 12) {
                    } else {
                    }
                    e(fVar);
                    if (obj5 == 7) {
                    } else {
                    }
                    h(fVar);
                    if (obj5 == 10) {
                    } else {
                    }
                    l(fVar);
                    k(fVar);
                    fVar.i((long)obj5);
                    K(fVar);
                    bVar = new a.b(obj5);
                    obj5 = this.d;
                    if (obj5 == 4) {
                    } else {
                    }
                    f(bVar, fVar, fVar);
                    if (obj5 == 13) {
                    } else {
                    }
                    i(bVar);
                    if (obj5 == 9) {
                    } else {
                    }
                    j(bVar);
                    if (obj5 == 14) {
                    }
                    n(bVar);
                    a();
                    if (a.o) {
                    }
                    boolean z = a.o;
                    if (z) {
                    }
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", inputStream);
                    a();
                    if (z) {
                    }
                    E();
                    a();
                    z = a.o;
                    if (!z) {
                    } else {
                    }
                    E();
                    throw inputStream;
                } catch (Throwable th) {
                }
            } else {
            }
        } else {
        }
    }

    private void D(d.l.a.a.b a$b) {
        int i2;
        int i;
        ByteOrder byteOrder = F(b);
        this.h = byteOrder;
        b.e(byteOrder);
        int unsignedShort = b.readUnsignedShort();
        i2 = this.d;
        if (i2 != 7 && i2 != 10) {
            if (i2 != 10) {
                if (unsignedShort != 42) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid start code: ");
                stringBuilder2.append(Integer.toHexString(unsignedShort));
                IOException obj4 = new IOException(stringBuilder2.toString());
                throw obj4;
            }
        }
        int int = b.readInt();
        if (int < 8) {
        } else {
            int += -8;
            if (i3 > 0) {
                b.f(i3);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid first Ifd offset: ");
        stringBuilder.append(int);
        obj4 = new IOException(stringBuilder.toString());
        throw obj4;
    }

    private void E() {
        int i;
        Iterator iterator;
        String str;
        boolean string;
        Object value;
        StringBuilder stringBuilder;
        String str2;
        i = 0;
        for (Object map : obj1) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("The size of tag group[");
            stringBuilder2.append(i);
            stringBuilder2.append("]: ");
            stringBuilder2.append(this.f[i].size());
            str = "ExifInterface";
            Log.d(str, stringBuilder2.toString());
            iterator = map.entrySet().iterator();
            for (Map.Entry next : iterator) {
                value = next.getValue();
                stringBuilder = new StringBuilder();
                stringBuilder.append("tagName: ");
                stringBuilder.append((String)next.getKey());
                stringBuilder.append(", tagType: ");
                stringBuilder.append((a.c)value.toString());
                stringBuilder.append(", tagValue: '");
                stringBuilder.append(value.j(this.h));
                stringBuilder.append("'");
                Log.d(str, stringBuilder.toString());
            }
            Object next = iterator.next();
            value = (Map.Entry)next.getValue();
            stringBuilder = new StringBuilder();
            stringBuilder.append("tagName: ");
            stringBuilder.append((String)next.getKey());
            stringBuilder.append(", tagType: ");
            stringBuilder.append((a.c)value.toString());
            stringBuilder.append(", tagValue: '");
            stringBuilder.append(value.j(this.h));
            stringBuilder.append("'");
            Log.d(str, stringBuilder.toString());
        }
    }

    private ByteOrder F(d.l.a.a.b a$b) {
        boolean obj4;
        obj4 = b.readShort();
        String str = "ExifInterface";
        if (obj4 != 18761) {
            if (obj4 != 19789) {
            } else {
                if (a.o) {
                    Log.d(str, "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid byte order: ");
            stringBuilder.append(Integer.toHexString(obj4));
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }
        if (a.o) {
            Log.d(str, "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void G(byte[] bArr, int i2) {
        a.f fVar = new a.f(bArr);
        D(fVar);
        H(fVar, i2);
    }

    private void H(d.l.a.a.f a$f, int i2) {
        Object string;
        int empty;
        short intValue;
        boolean equals;
        int contains;
        boolean str7;
        boolean string3;
        int format;
        int string4;
        int str;
        int unsignedShort2;
        int i4;
        String cVar2;
        String str6;
        int string2;
        int stringBuilder;
        int cmp2;
        Object valueOf;
        int contains2;
        String valueOf2;
        String str4;
        String str3;
        String equals2;
        String str5;
        int valueOf3;
        String str8;
        int length;
        Object obj;
        int unsignedShort3;
        int unsignedShort;
        d.l.a.a.c cVar;
        int int;
        int i8;
        long l;
        int i6;
        byte[] bArr;
        int i5;
        int i9;
        int i;
        Integer valueOf4;
        String str2;
        int i3;
        short cmp;
        int i7;
        final Object obj2 = this;
        string = f;
        int i10 = i2;
        obj2.g.add(Integer.valueOf(string.c));
        intValue = f.readShort();
        if (a.o) {
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append("numberOfDirectoryEntry: ");
            stringBuilder7.append(intValue);
            Log.d("ExifInterface", stringBuilder7.toString());
        }
        if (intValue <= 0) {
        }
        string2 = format;
        valueOf2 = 5;
        while (string2 < intValue) {
            unsignedShort3 = f.readUnsignedShort();
            unsignedShort = f.readUnsignedShort();
            int = f.readInt();
            i6 = 4;
            l6 += i6;
            obj = a.X[i10].get(Integer.valueOf(unsignedShort3));
            cVar = a.o;
            if (cVar) {
            }
            if ((a.d)obj == null) {
            } else {
            }
            if (unsignedShort > 0) {
            } else {
            }
            i3 = string2;
            if (cVar) {
            }
            str = 0;
            stringBuilder = 0;
            if (stringBuilder == null) {
            } else {
            }
            valueOf2 = "Compression";
            if (Long.compare(str, i6) > 0) {
            } else {
            }
            cmp = intValue;
            i7 = str3;
            str2 = str8;
            i6 = int;
            intValue = a.a0.get(Integer.valueOf(unsignedShort3));
            if (cVar) {
            } else {
            }
            str4 = str2;
            stringBuilder = 8;
            if ((Integer)intValue != null) {
            } else {
            }
            str5 = i7;
            byte[] bArr2 = new byte[(int)str];
            string.readFully(bArr2);
            super(unsignedShort, i6, (long)i12, i6, bArr2);
            obj2.f[i10].put(obj.b, cVar2);
            if ("DNGVersion".equals(obj.b)) {
            }
            if (!"Make".equals(obj.b)) {
            } else {
            }
            if (!cVar2.j(obj2.h).contains("PENTAX")) {
            } else {
            }
            obj2.d = stringBuilder;
            if (Long.compare(l2, str5) != 0) {
            }
            string2 = (short)i21;
            cVar2 = str4;
            intValue = cmp;
            format = 0;
            valueOf2 = 5;
            string.i(str5);
            if (valueOf2.equals(obj.b) && cVar2.i(obj2.h) == 65535) {
            }
            if (cVar2.i(obj2.h) == 65535) {
            }
            if ("Model".equals(obj.b)) {
            } else {
            }
            obj2.d = 3;
            str = -1;
            if (unsignedShort != 3) {
            } else {
            }
            unsignedShort2 = f.readUnsignedShort();
            str = (long)unsignedShort2;
            if (cVar) {
            }
            if (Long.compare(str, i19) > 0) {
            } else {
            }
            if (cVar) {
            }
            string.i(i7);
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Skip jump into the IFD since its offset is invalid: ");
            stringBuilder5.append(str);
            Log.d(str4, stringBuilder5.toString());
            if (!obj2.g.contains(Integer.valueOf((int)str))) {
            } else {
            }
            if (cVar) {
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Skip jump into the IFD since it has already been read: IfdType ");
            stringBuilder.append((Integer)intValue);
            stringBuilder.append(" (at ");
            stringBuilder.append(str);
            stringBuilder.append(")");
            Log.d(str4, stringBuilder.toString());
            string.i(str);
            obj2.H(string, intValue.intValue());
            Object[] arr2 = new Object[2];
            Log.d(str4, String.format("Offset: %d, tagName: %s", Long.valueOf(str), obj.b));
            if (unsignedShort != 4) {
            } else {
            }
            str = f.c();
            if (unsignedShort != stringBuilder) {
            } else {
            }
            unsignedShort2 = f.readShort();
            if (unsignedShort != 9 && unsignedShort != 13) {
            } else {
            }
            unsignedShort2 = f.readInt();
            if (unsignedShort != 13) {
            } else {
            }
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder9.append("nextIfdType: ");
            stringBuilder9.append(intValue);
            stringBuilder9.append(" byteCount: ");
            stringBuilder9.append(str);
            Log.d(str2, stringBuilder9.toString());
            cmp2 = f.readInt();
            cmp = intValue;
            if (cVar) {
            } else {
            }
            i7 = str3;
            if (obj2.d == 7) {
            } else {
            }
            str2 = str8;
            i6 = int;
            string.i((long)cmp2);
            if ("MakerNote".equals(obj.b)) {
            } else {
            }
            intValue = 6;
            str5 = "ThumbnailImage";
            if (i10 == intValue && str5.equals(obj.b)) {
            } else {
            }
            str5 = "ThumbnailImage";
            if (str5.equals(obj.b)) {
            } else {
            }
            obj2.m = cmp2;
            obj2.n = int;
            i6 = int;
            str2 = str8;
            int = 4;
            obj2.f[int].put(valueOf2, a.c.f(intValue, obj2.h));
            obj2.f[int].put("JPEGInterchangeFormat", a.c.b((long)i23, str5));
            obj2.f[int].put("JPEGInterchangeFormatLength", a.c.b((long)i24, str8));
            obj2.l = cmp2;
            StringBuilder stringBuilder4 = new StringBuilder();
            i7 = str3;
            stringBuilder4.append("seek to data offset: ");
            stringBuilder4.append(cmp2);
            Log.d(str8, stringBuilder4.toString());
            string.i(str3);
            cmp = intValue;
            str4 = str8;
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("Skip the tag entry since data format is invalid: ");
            stringBuilder6.append(unsignedShort);
            Log.d(cVar2, stringBuilder6.toString());
            valueOf2 = a.J;
            if (unsignedShort >= valueOf2.length) {
            } else {
            }
            if ((a.d)obj.a(unsignedShort) == 0) {
            } else {
            }
            if (unsignedShort == 7) {
            }
            i3 = string2;
            l3 *= l5;
            if (Long.compare(str, string2) >= 0) {
            } else {
            }
            if (cVar) {
            }
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append("Skip the tag entry since the number of components is invalid: ");
            stringBuilder8.append(int);
            Log.d(cVar2, stringBuilder8.toString());
            if (Long.compare(str, i18) > 0) {
            } else {
            }
            stringBuilder = 1;
            unsignedShort = obj.c;
            if (cVar) {
            }
            str8 = cVar2;
            i3 = string2;
            StringBuilder stringBuilder11 = new StringBuilder();
            stringBuilder11.append("Skip the tag entry since data format (");
            stringBuilder11.append(a.I[unsignedShort]);
            stringBuilder11.append(") is unexpected for tag: ");
            stringBuilder11.append(obj.b);
            Log.d(cVar2, stringBuilder11.toString());
            if (cVar) {
            }
            StringBuilder stringBuilder10 = new StringBuilder();
            stringBuilder10.append("Skip the tag entry since tag number is not defined: ");
            stringBuilder10.append(unsignedShort3);
            Log.d(cVar2, stringBuilder10.toString());
            valueOf2 = new Object[valueOf2];
            valueOf2[format] = Integer.valueOf(i2);
            valueOf2[1] = Integer.valueOf(unsignedShort3);
            if (obj != null) {
            } else {
            }
            i4 = 0;
            valueOf2[2] = i4;
            valueOf2[3] = Integer.valueOf(unsignedShort);
            valueOf2[4] = Integer.valueOf(int);
            Log.d(cVar2, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", valueOf2));
            i4 = obj.b;
        }
        String str24 = cVar2;
        empty = f.readInt();
        str7 = a.o;
        if (str7 != null) {
            Object[] arr = new Object[1];
            Log.d(str24, String.format("nextIfdOffset: %d", Integer.valueOf(empty)));
        }
        long l4 = (long)empty;
        if (Long.compare(l4, valueOf3) > 0) {
            if (!obj2.g.contains(Integer.valueOf(empty))) {
                string.i(l4);
                str7 = 4;
                if (obj2.f[str7].isEmpty()) {
                    obj2.H(string, str7);
                } else {
                    if (obj2.f[valueOf2].isEmpty()) {
                        obj2.H(string, valueOf2);
                    }
                }
            } else {
                if (str7 != null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
                    stringBuilder3.append(empty);
                    Log.d(str24, stringBuilder3.toString());
                }
            }
        } else {
            if (str7 != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Stop reading file since a wrong offset may cause an infinite loop: ");
                stringBuilder2.append(empty);
                Log.d(str24, stringBuilder2.toString());
            }
        }
    }

    private void I(int i, String string2, String string3) {
        boolean empty;
        HashMap map;
        int obj3;
        Object obj5;
        if (!this.f[i].isEmpty() && this.f[i].get(string2) != null) {
            if (this.f[i].get(string2) != null) {
                HashMap[] objArr3 = this.f;
                objArr3[i].put(string3, objArr3[i].get(string2));
                this.f[i].remove(string2);
            }
        }
    }

    private void J(d.l.a.a.f a$f, int i2) {
        Object bArr;
        Object obj;
        String str;
        d.l.a.a.b obj5;
        if ((a.c)this.f[i2].get("ImageLength") != null) {
            bArr = this.f[i2].get("JPEGInterchangeFormat");
            if ((a.c)this.f[i2].get("ImageWidth") == null && (a.c)bArr != null && (a.c)this.f[i2].get("JPEGInterchangeFormatLength") != null) {
                bArr = this.f[i2].get("JPEGInterchangeFormat");
                if ((a.c)(a.c)bArr != null) {
                    if ((a.c)this.f[i2].get("JPEGInterchangeFormatLength") != null) {
                        obj = (a.c)(a.c)bArr.i(this.h);
                        f.i((long)obj);
                        bArr = new byte[bArr.i(this.h)];
                        f.read(bArr);
                        obj5 = new a.b(bArr);
                        f(obj5, obj, i2);
                    }
                }
            }
        } else {
        }
    }

    private void K(d.l.a.a.b a$b) {
        boolean obj;
        int i2;
        int i;
        HashMap map = this.f[4];
        obj = map.get("Compression");
        i2 = 6;
        if ((a.c)obj != null) {
            obj = (a.c)obj.i(this.h);
            this.j = obj;
            if (obj != 1) {
                if (obj != i2) {
                    if (obj != 7) {
                    } else {
                        if (z(map)) {
                            p(b, map);
                        }
                    }
                } else {
                    o(b, map);
                }
            } else {
            }
        } else {
            this.j = i2;
            o(b, map);
        }
    }

    private static boolean L(int i) {
        int i2;
        if (i != 4 && i != 9 && i != 13 && i == 14) {
            if (i != 9) {
                if (i != 13) {
                    if (i == 14) {
                    }
                    return 1;
                }
            }
        }
        return 0;
    }

    private void M(int i, int i2) {
        boolean empty;
        Object obj3;
        String str;
        Object obj;
        Object obj2;
        boolean obj7;
        str = "ExifInterface";
        if (!this.f[i].isEmpty()) {
            if (this.f[i2].isEmpty()) {
            } else {
                String str2 = "ImageLength";
                obj3 = this.f[i].get(str2);
                String str3 = "ImageWidth";
                obj2 = this.f[i].get(str3);
                obj = this.f[i2].get(str2);
                Object obj4 = this.f[i2].get(str3);
                if ((a.c)obj3 != null) {
                    if ((a.c)obj2 == null) {
                        if (a.o) {
                            Log.d(str, "First image does not contain valid size information");
                        }
                    } else {
                        if ((a.c)obj != null) {
                            if ((a.c)obj4 == null) {
                                if (a.o) {
                                    Log.d(str, "Second image does not contain valid size information");
                                }
                            } else {
                                if ((a.c)obj3.i(this.h) < (a.c)obj.i(this.h) && (a.c)obj2.i(this.h) < (a.c)obj4.i(this.h)) {
                                    if ((a.c)obj2.i(this.h) < (a.c)obj4.i(this.h)) {
                                        obj3 = this.f;
                                        obj3[i] = obj3[i2];
                                        obj3[i2] = obj3[i];
                                    }
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
        }
        if (a.o) {
            Log.d(str, "Cannot perform swap since only one image data exists");
        }
    }

    private void N(d.l.a.a.f a$f, int i2) {
        d.l.a.a.c cVar;
        Object length;
        ByteOrder byteOrder;
        HashMap obj;
        int obj4;
        int obj3;
        int obj2;
        String str;
        String str2;
        d.l.a.a.c obj10;
        HashMap obj11;
        length = this.f[i2].get("DefaultCropSize");
        obj = this.f[i2].get("SensorTopBorder");
        obj4 = this.f[i2].get("SensorLeftBorder");
        obj3 = this.f[i2].get("SensorBottomBorder");
        obj2 = this.f[i2].get("SensorRightBorder");
        String str8 = "ImageLength";
        final String str9 = "ImageWidth";
        obj4 = 1;
        obj3 = 0;
        obj2 = 2;
        str = "Invalid crop size values. cropSize=";
        str2 = "ExifInterface";
        obj10 = (a.c)length.k(this.h);
        if (length != null && length.a == 5 && (a.e[])obj10 != null && obj10.length != obj2) {
            obj4 = 1;
            obj3 = 0;
            obj2 = 2;
            str = "Invalid crop size values. cropSize=";
            str2 = "ExifInterface";
            if (length.a == 5) {
                obj10 = length.k(this.h);
                if ((a.e[])(a.e[])obj10 != null) {
                    if (obj10.length != obj2) {
                    }
                    cVar = a.c.d((a.e[])(a.e[])obj10[obj3], this.h);
                    obj10 = a.c.d(obj10[obj4], this.h);
                    this.f[i2].put(str9, cVar);
                    this.f[i2].put(str8, obj10);
                }
                obj11 = new StringBuilder();
                obj11.append(str);
                obj11.append(Arrays.toString(obj10));
                Log.w(str2, obj11.toString());
            }
            obj10 = length.k(this.h);
            if ((int[])obj10 != null && obj10.length != obj2) {
                if (obj10.length != obj2) {
                }
                cVar = a.c.f((int[])obj10[obj3], this.h);
                obj10 = a.c.f(obj10[obj4], this.h);
            }
            obj11 = new StringBuilder();
            obj11.append(str);
            obj11.append(Arrays.toString(obj10));
            Log.w(str2, obj11.toString());
        }
        if ((a.c)obj != null && (a.c)obj4 != null && (a.c)obj3 != null && (a.c)obj2 != null) {
            if ((a.c)obj4 != null) {
                if ((a.c)obj3 != null) {
                    if ((a.c)obj2 != null) {
                        obj10 = (a.c)obj.i(this.h);
                        length = (a.c)obj3.i(this.h);
                        obj = (a.c)obj2.i(this.h);
                        obj4 = (a.c)obj4.i(this.h);
                        if (length > obj10 && obj > obj4) {
                            if (obj > obj4) {
                                this.f[i2].put(str8, a.c.f(length -= obj10, this.h));
                                this.f[i2].put(str9, a.c.f(obj -= obj4, this.h));
                            }
                        }
                    } else {
                        J(f, i2);
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    private void O() {
        Object obj;
        boolean empty;
        boolean str;
        Object hashMap;
        HashMap map;
        final int i = 0;
        final int i2 = 5;
        M(i, i2);
        final int i3 = 4;
        M(i, i3);
        M(i2, i3);
        int i4 = 1;
        obj = this.f[i4].get("PixelXDimension");
        hashMap = this.f[i4].get("PixelYDimension");
        String str6 = "ImageLength";
        final String str7 = "ImageWidth";
        if ((a.c)obj != null && (a.c)hashMap != null) {
            if ((a.c)hashMap != null) {
                this.f[i].put(str7, (a.c)obj);
                this.f[i].put(str6, (a.c)hashMap);
            }
        }
        if (this.f[i3].isEmpty() && A(this.f[i2])) {
            if (A(this.f[i2])) {
                empty = this.f;
                empty[i3] = empty[i2];
                hashMap = new HashMap();
                empty[i2] = hashMap;
            }
        }
        if (!A(this.f[i3])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        String str2 = "ThumbnailOrientation";
        String str3 = "Orientation";
        I(i, str2, str3);
        String str8 = "ThumbnailImageLength";
        I(i, str8, str6);
        final String str9 = "ThumbnailImageWidth";
        I(i, str9, str7);
        I(i2, str2, str3);
        I(i2, str8, str6);
        I(i2, str9, str7);
        I(i3, str3, str2);
        I(i3, str6, str8);
        I(i3, str7, str9);
    }

    private void a() {
        Object str6;
        int i;
        Object str4;
        String str2;
        Object str;
        Object str3;
        Object str5;
        Object obj;
        d.l.a.a.c cVar;
        str6 = b("DateTimeOriginal");
        i = 0;
        str2 = "DateTime";
        if (str6 != null && b(str2) == null) {
            str2 = "DateTime";
            if (b(str2) == null) {
                this.f[i].put(str2, a.c.a(str6));
            }
        }
        String str8 = "ImageWidth";
        int i3 = 0;
        if (b(str8) == null) {
            this.f[i].put(str8, a.c.b(i3, obj4));
        }
        String str9 = "ImageLength";
        if (b(str9) == null) {
            this.f[i].put(str9, a.c.b(i3, obj4));
        }
        String str10 = "Orientation";
        if (b(str10) == null) {
            this.f[i].put(str10, a.c.b(i3, obj4));
        }
        String str11 = "LightSource";
        if (b(str11) == null) {
            this.f[1].put(str11, a.c.b(i3, obj4));
        }
    }

    private d.l.a.a.c d(String string) {
        boolean equals;
        int i;
        Object obj;
        boolean obj3;
        Objects.requireNonNull(string, "tag shouldn't be null");
        if ("ISOSpeedRatings".equals(string) && a.o) {
            if (a.o) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            obj3 = "PhotographicSensitivity";
        }
        i = 0;
        for (Object map : obj1) {
            obj = map.get(obj3);
        }
        return null;
    }

    private void e(d.l.a.a.f a$f) {
        int metadata;
        String stringBuilder;
        String metadata3;
        int metadata2;
        int metadata4;
        HashMap map;
        int bArr;
        String bArr2;
        int i;
        d.l.a.a.c read;
        ByteOrder str;
        int i2;
        ByteOrder byteOrder;
        d.l.a.a.f obj13;
        String str3 = "yes";
        if (Build.VERSION.SDK_INT < 28) {
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            a.a aVar = new a.a(this, f);
            b.b.a(mediaMetadataRetriever, aVar);
            stringBuilder = mediaMetadataRetriever.extractMetadata(33);
            metadata3 = mediaMetadataRetriever.extractMetadata(34);
            if (str3.equals(mediaMetadataRetriever.extractMetadata(26))) {
                metadata4 = mediaMetadataRetriever.extractMetadata(29);
                metadata = mediaMetadataRetriever.extractMetadata(30);
                metadata2 = mediaMetadataRetriever.extractMetadata(31);
            } else {
                if (str3.equals(mediaMetadataRetriever.extractMetadata(17))) {
                    metadata4 = mediaMetadataRetriever.extractMetadata(18);
                    metadata = mediaMetadataRetriever.extractMetadata(19);
                    metadata2 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    metadata2 = metadata;
                }
            }
            int i14 = 0;
            if (metadata4 != 0) {
                this.f[i14].put("ImageWidth", a.c.f(Integer.parseInt(metadata4), this.h));
            }
            if (metadata != null) {
                this.f[i14].put("ImageLength", a.c.f(Integer.parseInt(metadata), this.h));
            }
            bArr = 6;
            if (metadata2 != 0) {
                i = 1;
                int int4 = Integer.parseInt(metadata2);
                if (int4 != 90) {
                    if (int4 != 180) {
                        try {
                            if (int4 != 270) {
                            } else {
                            }
                            i = 8;
                            i = 3;
                            i = bArr;
                            this.f[i14].put("Orientation", a.c.f(i, this.h));
                            if (stringBuilder != null && metadata3 != null) {
                            }
                            if (metadata3 != null) {
                            }
                            int int = Integer.parseInt(stringBuilder);
                            int int2 = Integer.parseInt(metadata3);
                            if (int2 <= bArr) {
                            } else {
                            }
                            f.i((long)int);
                            bArr2 = new byte[bArr];
                            if (f.read(bArr2) != bArr) {
                            } else {
                            }
                            int2 += -6;
                            if (!Arrays.equals(bArr2, a.c0)) {
                            } else {
                            }
                            bArr = new byte[metadata3];
                            if (f.read(bArr) != metadata3) {
                            } else {
                            }
                            this.k = int += bArr;
                            G(bArr, i14);
                            obj13 = new IOException("Can't read exif");
                            throw obj13;
                            obj13 = new IOException("Invalid identifier");
                            throw obj13;
                            obj13 = new IOException("Can't read identifier");
                            throw obj13;
                            obj13 = new IOException("Invalid exif length");
                            throw obj13;
                            if (a.o) {
                            }
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Heif meta: ");
                            stringBuilder.append(metadata4);
                            stringBuilder.append("x");
                            stringBuilder.append(metadata);
                            stringBuilder.append(", rotation ");
                            stringBuilder.append(metadata2);
                            Log.d("ExifInterface", stringBuilder.toString());
                            mediaMetadataRetriever.release();
                            f = new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
                            throw f;
                            obj1.release();
                            throw f;
                            obj13 = new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
                            throw obj13;
                        } catch (Throwable th) {
                        }
                    } else {
                    }
                } else {
                }
            }
        }
    }

    private void f(d.l.a.a.b a$b, int i2, int i3) {
        boolean string2;
        int i4;
        String str2;
        String str5;
        int i6;
        int bVar;
        int i7;
        byte copyOfRange;
        int bArr;
        String str3;
        boolean string;
        int length2;
        int i5;
        int hexString;
        String str4;
        int i9;
        long length;
        int i;
        int i8;
        long l;
        byte[] bArr2;
        String str;
        final Object obj = this;
        Object obj2 = b;
        int i10 = i3;
        if (a.o) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("getJpegAttributes starting with: ");
            stringBuilder4.append(obj2);
            Log.d("ExifInterface", stringBuilder4.toString());
        }
        obj2.e(ByteOrder.BIG_ENDIAN);
        byte byte = b.readByte();
        String str8 = "Invalid marker: ";
        if (byte != -1) {
        } else {
            if (b.readByte() != -40) {
            } else {
                i6 = i4;
                byte byte2 = b.readByte();
                while (byte2 == i7) {
                    copyOfRange = 1;
                    bArr = b.readByte();
                    string = a.o;
                    if (string != null) {
                    }
                    unsignedShort -= i4;
                    i15 += i4;
                    if (string != null) {
                    }
                    str3 = "Invalid length";
                    i9 = 0;
                    copyOfRange = new byte[length2];
                    obj2.readFully(copyOfRange);
                    hexString = a.c0;
                    if (b.d(copyOfRange, hexString)) {
                    } else {
                    }
                    hexString = a.d0;
                    copyOfRange = Arrays.copyOfRange(copyOfRange, hexString.length, length2);
                    length2 = "Xmp";
                    if (b.d(copyOfRange, hexString) && obj.b(length2) == null) {
                    } else {
                    }
                    str = str2;
                    bVar = bArr;
                    length2 = i9;
                    obj2.f(length2);
                    bVar += length2;
                    str2 = str;
                    i4 = 2;
                    i7 = -1;
                    byte2 = b.readByte();
                    copyOfRange = Arrays.copyOfRange(copyOfRange, hexString.length, length2);
                    length2 = "Xmp";
                    if (obj.b(length2) == null) {
                    } else {
                    }
                    str = str2;
                    super(1, copyOfRange.length, (long)bVar, obj17, copyOfRange);
                    obj.f[i9].put(length2, cVar);
                    copyOfRange = Arrays.copyOfRange(copyOfRange, hexString.length, length2);
                    obj.k = i16 += length2;
                    obj.G(copyOfRange, i10);
                    bVar = new a.b(copyOfRange);
                    obj.K(bVar);
                    bArr = new byte[length2];
                    length2 = "UserComment";
                    if (obj.b(length2) == null) {
                    }
                    str = str2;
                    hexString = new String(bArr, a.b0);
                    obj.f[copyOfRange].put(length2, a.c.a(hexString));
                    if (/* condition */) {
                    } else {
                    }
                    if (/* condition */) {
                    } else {
                    }
                    if (/* condition */) {
                    } else {
                    }
                    if (/* condition */) {
                    }
                    str = str2;
                    obj2.f(copyOfRange);
                    int i18 = 4;
                    if (i10 != i18) {
                    } else {
                    }
                    str4 = "ThumbnailImageLength";
                    i9 = a.c.b((long)unsignedShort3, length);
                    obj.f[i10].put(str4, i9);
                    if (i10 != i18) {
                    } else {
                    }
                    bArr = "ThumbnailImageWidth";
                    obj.f[i10].put(bArr, a.c.b((long)unsignedShort2, i9));
                    length2 += -5;
                    bArr = "ImageWidth";
                    str4 = "ImageLength";
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append("JPEG segment: ");
                    stringBuilder5.append(Integer.toHexString(bArr & 255));
                    stringBuilder5.append(" (length: ");
                    stringBuilder5.append(length2 + 2);
                    stringBuilder5.append(")");
                    Log.d(str2, stringBuilder5.toString());
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append("Found JPEG segment indicator: ");
                    stringBuilder6.append(Integer.toHexString(bArr & 255));
                    Log.d(str2, stringBuilder6.toString());
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid marker:");
                stringBuilder2.append(Integer.toHexString(byte2 & 255));
                IOException iOException5 = new IOException(stringBuilder2.toString());
                throw iOException5;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str8);
            stringBuilder.append(Integer.toHexString(byte &= 255));
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str8);
        stringBuilder3.append(Integer.toHexString(byte &= 255));
        IOException iOException6 = new IOException(stringBuilder3.toString());
        throw iOException6;
    }

    private int g(BufferedInputStream bufferedInputStream) {
        int i = 5000;
        bufferedInputStream.mark(i);
        byte[] bArr = new byte[i];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (a.t(bArr)) {
            return 4;
        }
        if (w(bArr)) {
            return 9;
        }
        if (s(bArr)) {
            return 12;
        }
        if (u(bArr)) {
            return 7;
        }
        if (x(bArr)) {
            return 10;
        }
        if (v(bArr)) {
            return 13;
        }
        if (B(bArr)) {
            return 14;
        }
        return 0;
    }

    private void h(d.l.a.a.f a$f) {
        int str2;
        ByteOrder length;
        int i2;
        String str3;
        byte[] bArr2;
        String str;
        int i;
        byte[] bArr;
        byte[] bArr3;
        int i3;
        boolean obj7;
        k(f);
        str2 = 1;
        obj7 = this.f[str2].get("MakerNote");
        if ((a.c)obj7 != null) {
            a.f fVar = new a.f(obj7.d);
            fVar.e(this.h);
            obj7 = a.x;
            bArr2 = new byte[obj7.length];
            fVar.readFully(bArr2);
            fVar.i(0);
            bArr = a.y;
            bArr3 = new byte[bArr.length];
            fVar.readFully(bArr3);
            if (Arrays.equals(bArr2, obj7)) {
                fVar.i(8);
            } else {
                if (Arrays.equals(bArr3, bArr)) {
                    fVar.i(12);
                }
            }
            H(fVar, 6);
            int i4 = 7;
            obj7 = this.f[i4].get("PreviewImageStart");
            Object obj = this.f[i4].get("PreviewImageLength");
            if ((a.c)obj7 != null && (a.c)obj != null) {
                if ((a.c)obj != null) {
                    bArr = 5;
                    this.f[bArr].put("JPEGInterchangeFormat", (a.c)obj7);
                    this.f[bArr].put("JPEGInterchangeFormatLength", (a.c)obj);
                }
            }
            obj7 = this.f[8].get("AspectFrame");
            if ((a.c)obj7 != null) {
                obj7 = (a.c)obj7.k(this.h);
                if ((int[])obj7 != null) {
                    if (obj7.length != 4) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid aspect frame values. frame=");
                        stringBuilder.append(Arrays.toString((int[])obj7));
                        Log.w("ExifInterface", stringBuilder.toString());
                    } else {
                        str3 = 2;
                        bArr = 0;
                        str = 3;
                        i7 += str2;
                        i10 += str2;
                        if (obj7[str3] > obj7[bArr] && obj7[str] > obj7[str2] && i2 < i) {
                            str = 3;
                            if (obj7[str] > obj7[str2]) {
                                i7 += str2;
                                i10 += str2;
                                if (i2 < i) {
                                    i2 += i;
                                    i8 -= i;
                                }
                                this.f[bArr].put("ImageWidth", a.c.f(i2, this.h));
                                this.f[bArr].put("ImageLength", a.c.f(i, this.h));
                            }
                        }
                    }
                } else {
                }
            }
        }
    }

    private void i(d.l.a.a.b a$b) {
        boolean string;
        int i2;
        String str;
        int i;
        int int;
        boolean equals;
        int equals2;
        boolean bArr;
        byte[] bArr2;
        int read;
        Object obj7;
        if (a.o) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getPngAttributes starting with: ");
            stringBuilder.append(b);
            Log.d("ExifInterface", stringBuilder.toString());
        }
        b.e(ByteOrder.BIG_ENDIAN);
        byte[] bArr3 = a.z;
        b.f(bArr3.length);
        int i5 = 0;
        length += i5;
        int = b.readInt();
        int i6 = 4;
        bArr2 = new byte[i6];
        while (b.read(bArr2) == i6) {
            i3 += i6;
            int += 4;
            b.f(i);
            i4 += i;
            int = b.readInt();
            i6 = 4;
            bArr2 = new byte[i6];
        }
        obj7 = new IOException("Encountered invalid length while parsing PNG chunktype");
        throw obj7;
    }

    private void j(d.l.a.a.b a$b) {
        boolean string;
        boolean stringBuilder;
        String string2;
        short short;
        String str3;
        int str2;
        int i;
        String str;
        int unsignedShort2;
        d.l.a.a.b unsignedShort;
        int i2;
        short obj8;
        string = a.o;
        final String str4 = "ExifInterface";
        if (string != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("getRafAttributes starting with: ");
            stringBuilder3.append(b);
            Log.d(str4, stringBuilder3.toString());
        }
        b.f(84);
        int i5 = 4;
        byte[] bArr2 = new byte[i5];
        byte[] bArr3 = new byte[i5];
        byte[] bArr = new byte[i5];
        b.read(bArr2);
        b.read(bArr3);
        b.read(bArr);
        int int3 = ByteBuffer.wrap(bArr2).getInt();
        byte[] bArr4 = new byte[ByteBuffer.wrap(bArr3).getInt()];
        b.f(int3 - i7);
        b.read(bArr4);
        unsignedShort = new a.b(bArr4);
        f(unsignedShort, int3, 5);
        b.f(int -= str2);
        b.e(ByteOrder.BIG_ENDIAN);
        int int2 = b.readInt();
        if (string != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("numberOfDirectoryEntry: ");
            stringBuilder2.append(int2);
            Log.d(str4, stringBuilder2.toString());
        }
        int i3 = 0;
        i = i3;
        while (i < int2) {
            b.f(b.readUnsignedShort());
            i++;
        }
    }

    private void k(d.l.a.a.f a$f) {
        int i;
        String str;
        HashMap[] objArr;
        int obj4;
        D(f);
        int i2 = 0;
        H(f, i2);
        N(f, i2);
        N(f, 5);
        N(f, 4);
        O();
        i = 1;
        obj4 = this.f[i].get("MakerNote");
        a.f fVar = new a.f(obj4.d);
        fVar.e(this.h);
        fVar.f(6);
        obj4 = 9;
        H(fVar, obj4);
        str = "ColorSpace";
        obj4 = this.f[obj4].get(str);
        if (this.d == 8 && (a.c)obj4 != null && (a.c)obj4 != null) {
            i = 1;
            obj4 = this.f[i].get("MakerNote");
            if ((a.c)(a.c)obj4 != null) {
                fVar = new a.f(obj4.d);
                fVar.e(this.h);
                fVar.f(6);
                obj4 = 9;
                H(fVar, obj4);
                str = "ColorSpace";
                obj4 = this.f[obj4].get(str);
                if ((a.c)(a.c)obj4 != null) {
                    this.f[i].put(str, (a.c)(a.c)obj4);
                }
            }
        }
    }

    private void l(d.l.a.a.f a$f) {
        boolean string;
        Object obj;
        String str;
        Object bVar;
        int i;
        Object obj5;
        if (a.o) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getRw2Attributes starting with: ");
            stringBuilder.append(f);
            Log.d("ExifInterface", stringBuilder.toString());
        }
        k(f);
        int i2 = 0;
        obj5 = this.f[i2].get("JpgFromRaw");
        if ((a.c)obj5 != null) {
            bVar = new a.b(obj5.d);
            f(bVar, (int)l, 5);
        }
        obj5 = this.f[i2].get("ISO");
        int i3 = 1;
        String str4 = "PhotographicSensitivity";
        if ((a.c)obj5 != null && (a.c)this.f[i3].get(str4) == null) {
            if ((a.c)this.f[i3].get(str4) == null) {
                this.f[i3].put(str4, (a.c)obj5);
            }
        }
    }

    private void m(d.l.a.a.f a$f) {
        final byte[] bArr = a.c0;
        f.f(bArr.length);
        byte[] bArr2 = new byte[f.available()];
        f.readFully(bArr2);
        this.k = bArr.length;
        G(bArr2, 0);
    }

    private void n(d.l.a.a.b a$b) {
        boolean string;
        byte[] bArr;
        String str;
        int i;
        int length;
        int bArr2;
        int int;
        Object obj6;
        if (a.o) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getWebpAttributes starting with: ");
            stringBuilder.append(b);
            Log.d("ExifInterface", stringBuilder.toString());
        }
        b.e(ByteOrder.LITTLE_ENDIAN);
        b.f(bArr3.length);
        int2 += 8;
        byte[] bArr4 = a.E;
        b.f(bArr4.length);
        length3 += 8;
        int i3 = 4;
        bArr2 = new byte[i3];
        while (b.read(bArr2) == i3) {
            int = b.readInt();
            i2 += i3;
            if (int % 2 == 1) {
            }
            i += int;
            b.f(int);
            i3 = 4;
            bArr2 = new byte[i3];
            int++;
        }
        obj6 = new IOException("Encountered invalid length while parsing WebP chunktype");
        throw obj6;
    }

    private void o(d.l.a.a.b a$b, HashMap hashMap2) {
        int str;
        int bArr;
        int i;
        boolean obj5;
        Object obj6;
        str = hashMap2.get("JPEGInterchangeFormat");
        obj6 = hashMap2.get("JPEGInterchangeFormatLength");
        obj6 = (a.c)obj6.i(this.h);
        if (str != null && obj6 != null && this.d == 7) {
            if (obj6 != null) {
                obj6 = obj6.i(this.h);
                if (this.d == 7) {
                    str += bArr;
                }
                if (str > 0 && obj6 > 0 && this.a == null && this.c == null && this.b == null) {
                    if (obj6 > 0) {
                        if (this.a == null) {
                            if (this.c == null) {
                                if (this.b == null) {
                                    b.skip((long)str);
                                    b.read(new byte[obj6]);
                                }
                            }
                        }
                    }
                }
                if (a.o) {
                    obj5 = new StringBuilder();
                    obj5.append("Setting thumbnail attributes with offset: ");
                    obj5.append(str);
                    obj5.append(", length: ");
                    obj5.append(obj6);
                    Log.d("ExifInterface", obj5.toString());
                }
            }
        }
    }

    private void p(d.l.a.a.b a$b, HashMap hashMap2) {
        boolean str;
        Object obj2;
        Object obj;
        String str2;
        int i7;
        int bArr2;
        int i5;
        int i;
        int i6;
        int i8;
        int i4;
        int i3;
        int bArr;
        int i2;
        int read;
        int cmp;
        String str3;
        long skip;
        final Object obj3 = this;
        str = b;
        Object obj4 = hashMap2;
        obj = obj4.get("StripOffsets");
        obj2 = obj4.get("StripByteCounts");
        obj = b.c((a.c)obj.k(obj3.h));
        obj2 = b.c((a.c)obj2.k(obj3.h));
        str2 = "ExifInterface";
        if (obj != null && obj2 != null && obj != null) {
            if (obj2 != null) {
                obj = b.c(obj.k(obj3.h));
                obj2 = b.c(obj2.k(obj3.h));
                str2 = "ExifInterface";
                if (obj != null) {
                    if (obj.length == 0) {
                    } else {
                        if (obj2 != null) {
                            if (obj2.length == 0) {
                            } else {
                                if (obj.length != obj2.length) {
                                    Log.w(str2, "stripOffsets and stripByteCounts should have same length.");
                                }
                                i7 = 0;
                                i6 = 0;
                                i8 = i6;
                                while (i8 < obj2.length) {
                                    i7 += i3;
                                    i8++;
                                }
                                i5 = 1;
                                obj3.i = i5;
                                i3 = i4;
                                while (i < obj.length) {
                                    int i11 = (int)l;
                                    i2 = (int)l2;
                                    if (i < length4 -= i5 && Long.compare(l4, skip) != 0) {
                                    }
                                    i11 -= i4;
                                    long l3 = (long)i12;
                                    str3 = " bytes.";
                                    bArr = new byte[i2];
                                    i10 += i2;
                                    System.arraycopy(bArr, i6, new byte[(int)i7], i3, i2);
                                    i3 += i2;
                                    i++;
                                    if (Long.compare(l4, skip) != 0) {
                                    }
                                    obj3.i = i6;
                                }
                            }
                            if (obj3.i) {
                                str = obj[i6];
                            }
                        }
                    }
                    Log.w(str2, "stripByteCounts should not be null or have zero length.");
                }
                Log.w(str2, "stripOffsets should not be null or have zero length.");
            }
        }
    }

    private void q(String string) {
        FileDescriptor obj3;
        Objects.requireNonNull(string, "filename cannot be null");
        int i = 0;
        this.c = i;
        this.a = string;
        FileInputStream fileInputStream = new FileInputStream(string);
        if (a.y(fileInputStream.getFD()) != null) {
            this.b = fileInputStream.getFD();
        } else {
            this.b = i;
        }
        C(fileInputStream);
        b.b(fileInputStream);
    }

    private static boolean r(BufferedInputStream bufferedInputStream) {
        int i;
        byte b2;
        byte b;
        byte[] bArr = a.c0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int obj4 = 0;
        i = obj4;
        byte[] bArr3 = a.c0;
        for (byte b2 : obj2) {
            bArr3 = a.c0;
        }
        return 1;
    }

    private boolean s(byte[] bArr) {
        boolean z;
        int i;
        boolean str;
        d.l.a.a.b bVar;
        String str2;
        long long;
        int i3;
        int cmp;
        int i4;
        int i6;
        int i2;
        int i5;
        int equals;
        long l;
        byte[] obj15;
        final int i7 = 0;
        int i8 = 0;
        bVar = new a.b(bArr);
        i = 4;
        byte[] bArr2 = new byte[i];
        bVar.read(bArr2);
        if (!Arrays.equals(bArr2, a.u)) {
            bVar.close();
            return i7;
        }
        try {
            int i9 = 1;
            int i10 = 8;
            if (Long.compare(long, i9) == 0) {
            } else {
            }
            if (Long.compare(long, i6) < 0) {
            }
            bVar.close();
            return i7;
            i6 = i10;
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
        try {
            long = (long)obj15;
            long -= i6;
            if (Long.compare(i3, i10) < 0) {
            }
            bVar.close();
            return i7;
            obj15 = new byte[i];
            i4 = 0;
            i5 = i2;
            while (Long.compare(i4, i12) < 0) {
                l = 1;
                if (Arrays.equals(obj15, a.v)) {
                } else {
                }
                if (Arrays.equals(obj15, a.w)) {
                }
                i4 += i9;
                i5 = l;
                i2 = l;
            }
            if (bVar.read(obj15) != i) {
            } else {
            }
            bVar.close();
            return i7;
            if (Long.compare(i4, i9) == 0) {
            } else {
            }
            l = 1;
            if (Arrays.equals(obj15, a.v)) {
            } else {
            }
            i2 = l;
            if (Arrays.equals(obj15, a.w)) {
            }
            i5 = l;
            if (i2 != 0) {
            } else {
            }
            if (i5 != 0) {
            } else {
            }
            bVar.close();
            return l;
            i4 += i9;
        }
        bVar.close();
        return i7;
    }

    private static boolean t(byte[] bArr) {
        int i;
        byte b2;
        byte b;
        final int i2 = 0;
        i = i2;
        byte[] bArr2 = a.t;
        for (byte b2 : obj2) {
            bArr2 = a.t;
        }
        return 1;
    }

    private boolean u(byte[] bArr) {
        int i2;
        Object obj;
        int i;
        i2 = 0;
        int i3 = 0;
        a.b bVar = new a.b(bArr);
        ByteOrder obj4 = F(bVar);
        this.h = obj4;
        bVar.e(obj4);
        obj4 = bVar.readShort();
        if (obj4 != 20306) {
            if (obj4 == 21330) {
                try {
                    i2 = 1;
                    bVar.close();
                    return i2;
                    obj = obj2;
                    obj = obj2;
                } catch (Exception e) {
                } catch (Throwable th1) {
                }
                try {
                    if (obj == null) {
                    } else {
                    }
                    obj.close();
                    throw bArr;
                    if (obj != null) {
                    }
                    obj.close();
                    return obj0;
                }
            }
        } else {
        }
    }

    private boolean v(byte[] bArr) {
        int i;
        byte b;
        byte b2;
        final int i2 = 0;
        i = i2;
        byte[] bArr2 = a.z;
        for (byte b : obj2) {
            bArr2 = a.z;
        }
        return 1;
    }

    private boolean w(byte[] bArr) {
        int i;
        byte b;
        byte b2;
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i2 = 0;
        i = i2;
        for (byte b2 : obj0) {
        }
        return 1;
    }

    private boolean x(byte[] bArr) {
        int i;
        Object obj;
        i = 0;
        int i2 = 0;
        a.b bVar = new a.b(bArr);
        ByteOrder obj4 = F(bVar);
        this.h = obj4;
        bVar.e(obj4);
        if (bVar.readShort() == 85) {
            i = 1;
        }
        try {
            bVar.close();
            return i;
            obj = obj2;
            obj = obj2;
        } catch (Exception e) {
        } catch (Throwable th1) {
        }
        if (obj != null) {
            obj.close();
        }
        return obj0;
    }

    private static boolean y(FileDescriptor fileDescriptor) {
        int sDK_INT;
        boolean obj4;
        if (Build.VERSION.SDK_INT >= 21) {
            b.a.c(fileDescriptor, 0, obj3);
            return 1;
        }
        return 0;
    }

    private boolean z(HashMap hashMap) {
        Object str;
        int[] iArr;
        int equals;
        int i;
        int i2;
        Object obj6;
        str = hashMap.get("BitsPerSample");
        str = (a.c)str.k(this.h);
        iArr = a.r;
        i = 1;
        if (str != null && Arrays.equals(iArr, (int[])str)) {
            str = str.k(this.h);
            iArr = a.r;
            i = 1;
            if (Arrays.equals(iArr, (int[])str)) {
                return i;
            }
            obj6 = hashMap.get("PhotometricInterpretation");
            if (this.d == 3 && (a.c)obj6 != null) {
                obj6 = hashMap.get("PhotometricInterpretation");
                if ((a.c)(a.c)obj6 != null) {
                    obj6 = (a.c)(a.c)obj6.i(this.h);
                    if (obj6 == i) {
                        if (!Arrays.equals(str, a.s) && obj6 == 6 && Arrays.equals(str, iArr)) {
                            if (obj6 == 6) {
                                if (Arrays.equals(str, iArr)) {
                                }
                            }
                        }
                        return i;
                    } else {
                    }
                }
            }
        }
        if (a.o) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
        return 0;
    }

    public String b(String string) {
        d.l.a.a.c length;
        int i;
        Objects.requireNonNull(string, "tag shouldn't be null");
        length = d(string);
        int i3 = 0;
        if (length != null && !a.Z.contains(string)) {
            if (!a.Z.contains(string)) {
                return length.j(this.h);
            }
            int obj6 = length.a;
            String str5 = "ExifInterface";
            if (string.equals("GPSTimeStamp") && obj6 != 5 && obj6 != 10) {
                obj6 = length.a;
                str5 = "ExifInterface";
                if (obj6 != 5) {
                    if (obj6 != 10) {
                        obj6 = new StringBuilder();
                        obj6.append("GPS Timestamp format is not rational. format=");
                        obj6.append(length.a);
                        Log.w(str5, obj6.toString());
                        return i3;
                    }
                }
                obj6 = length.k(this.h);
                i = 3;
                if ((a.e[])obj6 != null && obj6.length != i) {
                    i = 3;
                    if (obj6.length != i) {
                    }
                    Object[] arr = new Object[i];
                    int i4 = 0;
                    arr[i4] = Integer.valueOf((int)i7);
                    int i5 = 1;
                    arr[i5] = Integer.valueOf((int)i9);
                    int i6 = 2;
                    arr[i6] = Integer.valueOf((int)i11);
                    return String.format("%02d:%02d:%02d", arr);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid GPS Timestamp array. array=");
                stringBuilder.append(Arrays.toString(obj6));
                Log.w(str5, stringBuilder.toString());
                return i3;
            }
            return Double.toString(length.h(this.h));
        }
        return i3;
    }

    public int c(String string, int i2) {
        Objects.requireNonNull(string, "tag shouldn't be null");
        d.l.a.a.c obj2 = d(string);
        if (obj2 == null) {
            return i2;
        }
        return obj2.i(this.h);
    }
}
