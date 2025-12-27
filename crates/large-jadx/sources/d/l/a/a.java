package d.l.a;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.res.AssetManager.AssetInputStream;
import android.database.Observable;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.system.OsConstants;
import android.util.Log;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;
import com.airbnb.lottie.e.a;
import com.appsflyer.R.styleable;
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

/* compiled from: ExifInterface.java */
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
    private static final a.d[] L;
    private static final a.d[] M;
    private static final a.d[] N;
    private static final a.d[] O;
    private static final a.d[] P;
    private static final a.d Q = new a$d("StripOffsets", 273, 3);
    private static final a.d[] R;
    private static final a.d[] S;
    private static final a.d[] T;
    private static final a.d[] U;
    static final a.d[][] V;
    private static final a.d[] W;
    private static final HashMap<Integer, a.d>[] X;
    private static final HashMap<String, a.d>[] Y;
    private static final HashSet<String> Z = new HashSet<>();
    private static final HashMap<Integer, Integer> a0 = new HashMap<>();
    static final Charset b0;
    static final byte[] c0;
    private static final byte[] d0;
    private static final boolean o = false;
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
    private final HashMap<String, a.c>[] f;
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
        final /* synthetic */ a.f b;
        a(a.f fVar) {
            this.b = fVar;
            super();
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            long l2;
            int available2;
            if (i2 == 0) {
                return 0;
            }
            long l = 0L;
            i = -1;
            if (j < l) {
                return i;
            }
            try {
                if (this.a != j) {
                    if (this.a >= l && j >= this.a) {
                        return i;
                    }
                    this.b.i(j);
                    this.a = j;
                }
                if (i2 > this.b.available()) {
                    available2 = this.b.available();
                }
                int read = this.b.read(bArr, i, available2);
                this.a += l6;
            } catch (java.io.IOException unused) {
                this.a = -1L;
                return i;
            }
            return read;
        }

        @Override // android.media.MediaDataSource
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1;
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

        b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
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
            return (long)readInt() & 4294967295L;
        }

        @Override // java.io.InputStream
        public void e(ByteOrder byteOrder) {
            this.b = byteOrder;
        }

        @Override // java.io.InputStream
        public void f(int i) throws EOFException, IOException {
            int i2;
            int bytesRead;
            int i3 = -1;
            long skipped;
            i2 = 0;
            while (i2 < i) {
                i3 = i - i2;
                bytesRead = (int)this.a.skip((long)i3);
                if ((int)this.a.skip((long)i3, obj) <= 0) {
                    int i4 = 8192;
                }
            }
            this.c += i2;
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.c++;
            return this.a.read();
        }

        @Override // java.io.InputStream
        public boolean readBoolean() throws IOException {
            this.c++;
            return this.a.readBoolean();
        }

        @Override // java.io.InputStream
        public byte readByte() throws IOException, EOFException {
            this.c++;
            int bytesRead = this.a.read();
            if (bytesRead < 0) {
                throw new EOFException();
            } else {
                return (byte)bytesRead;
            }
        }

        @Override // java.io.InputStream
        public char readChar() throws IOException {
            this.c += 2;
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
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            this.c += i2;
            this.a.readFully(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public int readInt() throws EOFException, IOException {
            this.c += 4;
            int bytesRead = this.a.read();
            int bytesRead2 = this.a.read();
            int bytesRead3 = this.a.read();
            int bytesRead4 = this.a.read();
            if ((bytesRead | bytesRead2) | bytesRead3 | bytesRead4 < 0) {
                throw new EOFException();
            } else {
                if (this.b == a.b.w) {
                    return (bytesRead4 << 24) + (bytesRead3 << 16) + (bytesRead2 << 8) + bytesRead;
                }
                if (this.b != a.b.x) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Invalid byte order: ";
                    r1 = str + this.b;
                    throw new IOException(r1);
                } else {
                    return (bytesRead << 24) + (bytesRead2 << 16) + (bytesRead3 << 8) + bytesRead4;
                }
            }
        }

        @Override // java.io.InputStream
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.InputStream
        public long readLong() throws EOFException, IOException {
            final Object obj = this;
            obj.c += 8;
            int bytesRead2 = obj.a.read();
            int bytesRead = obj.a.read();
            int bytesRead3 = obj.a.read();
            int bytesRead4 = obj.a.read();
            int bytesRead5 = obj.a.read();
            int bytesRead6 = obj.a.read();
            int bytesRead7 = obj.a.read();
            int bytesRead8 = obj.a.read();
            if ((bytesRead2 | bytesRead) | bytesRead3 | bytesRead4 | bytesRead5 | bytesRead6 | bytesRead7 | bytesRead8 < 0) {
                throw new EOFException();
            } else {
                final int i15 = 24;
                final int i16 = 32;
                final int i17 = 40;
                final int i18 = 48;
                final int i19 = 56;
                if (obj.b == a.b.w) {
                    return (long)bytesRead8 << 56L + (long)bytesRead7 << 48L + (long)bytesRead6 << 40L + (long)bytesRead5 << 32L + (long)bytesRead4 << 24L + (long)bytesRead3 << 16L + (long)bytesRead << 8L + (long)bytesRead2;
                }
                if (obj.b != a.b.x) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Invalid byte order: ";
                    r2 = str + obj.b;
                    throw new IOException(r2);
                } else {
                    return (long)bytesRead2 << 56L + (long)bytesRead << 48L + (long)bytesRead3 << 40L + (long)bytesRead4 << 32L + (long)bytesRead5 << 24L + (long)bytesRead6 << 16L + (long)bytesRead7 << 8L + (long)bytesRead8;
                }
            }
        }

        @Override // java.io.InputStream
        public short readShort() throws IOException, EOFException {
            this.c += 2;
            int bytesRead = this.a.read();
            int bytesRead2 = this.a.read();
            if (bytesRead | bytesRead2 < 0) {
                throw new EOFException();
            } else {
                if (this.b == a.b.w) {
                    return (short)(bytesRead2 << 8) + bytesRead;
                }
                if (this.b != a.b.x) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Invalid byte order: ";
                    r1 = str + this.b;
                    throw new IOException(r1);
                } else {
                    return (short)(bytesRead << 8) + bytesRead2;
                }
            }
        }

        @Override // java.io.InputStream
        public String readUTF() throws IOException {
            this.c += 2;
            return this.a.readUTF();
        }

        @Override // java.io.InputStream
        public int readUnsignedByte() throws IOException {
            this.c++;
            return this.a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public int readUnsignedShort() throws IOException, EOFException {
            this.c += 2;
            int bytesRead = this.a.read();
            int bytesRead2 = this.a.read();
            if (bytesRead | bytesRead2 < 0) {
                throw new EOFException();
            } else {
                if (this.b == a.b.w) {
                    return (bytesRead2 << 8) + bytesRead;
                }
                if (this.b != a.b.x) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Invalid byte order: ";
                    r1 = str + this.b;
                    throw new IOException(r1);
                } else {
                    return (bytesRead << 8) + bytesRead2;
                }
            }
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.InputStream
        public int skipBytes(int i) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            super();
            this.b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.a = dataInputStream;
            final int i = 0;
            dataInputStream.mark(i);
            this.c = i;
            this.b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            final int bytesRead = this.a.read(bArr, i, i2);
            this.c += bytesRead;
            return bytesRead;
        }

        @Override // java.io.InputStream
        public void readFully(byte[] bArr) throws IOException {
            this.c += length;
            this.a.readFully(bArr);
        }
    }

    private static class c {

        public final int a;
        public final int b;
        public final long c;
        public final byte[] d;
        c(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr, bArr);
        }

        public static a.c a(String str) throws java.io.UnsupportedEncodingException {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = str + 0;
            byte[] bytes = str2.getBytes(a.b0);
            return new a.c(2, bytes.length, bytes);
        }

        public static a.c b(long j, ByteOrder byteOrder) {
            long[] lArr = new long[1];
            return a.c.c(new long[] { j }, byteOrder);
        }

        public static a.c c(long[] jArr, ByteOrder byteOrder) {
            int i = 0;
            final int i5 = 4;
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.J[i5] * jArr.length]);
            wrap.order(byteOrder);
            i = 0;
            for (long l : jArr) {
                i2 = (int)l;
                wrap.putInt(i2);
            }
            return new a.c(i5, jArr.length, wrap.array());
        }

        public static a.c d(a.e eVar, ByteOrder byteOrder) {
            d.l.a.a.e[] arr = new a.e[1];
            return a.c.e(new a.e[] { eVar }, byteOrder);
        }

        public static a.c e(a.e[] eVarArr, ByteOrder byteOrder) {
            int i = 0;
            final int i6 = 5;
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.J[i6] * eVarArr.length]);
            wrap.order(byteOrder);
            i = 0;
            for (Object obj : eVarArr) {
                i3 = (int)obj.a;
                wrap.putInt(i3);
                i2 = (int)obj.b;
                wrap.putInt(i2);
            }
            return new a.c(i6, eVarArr.length, wrap.array());
        }

        public static a.c f(int i, ByteOrder byteOrder) {
            int[] iArr = new int[1];
            return a.c.g(new int[] { i }, byteOrder);
        }

        public static a.c g(int[] iArr, ByteOrder byteOrder) {
            int i = 0;
            final int i4 = 3;
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.J[i4] * iArr.length]);
            wrap.order(byteOrder);
            i = 0;
            for (int i5 : iArr) {
                s = (short)i5;
                wrap.putShort(s);
            }
            return new a.c(i4, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object obj = k(byteOrder);
            if (obj == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else {
                if (obj instanceof String) {
                    return Double.parseDouble(obj);
                }
                final int i = 0;
                final String str3 = "There are more than one component";
                final int i2 = 1;
                if (obj instanceof long[]) {
                    if (obj.length != i2) {
                        throw new NumberFormatException(str3);
                    } else {
                        return (double)obj[i];
                    }
                }
                if (obj instanceof int[]) {
                    if (obj.length != i2) {
                        throw new NumberFormatException(str3);
                    } else {
                        return (double)obj[i];
                    }
                }
                if (obj instanceof double[]) {
                    if (obj.length != i2) {
                        throw new NumberFormatException(str3);
                    } else {
                        return obj[i];
                    }
                }
                if (!(obj instanceof a.e[])) {
                    throw new NumberFormatException("Couldn't find a double value");
                } else {
                    if (obj.length != i2) {
                        throw new NumberFormatException(str3);
                    } else {
                        return obj[i].a();
                    }
                }
            }
        }

        public int i(ByteOrder byteOrder) {
            Object obj = k(byteOrder);
            if (obj == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else {
                if (obj instanceof String) {
                    return Integer.parseInt(obj);
                }
                final int i = 0;
                final String str3 = "There are more than one component";
                final int i2 = 1;
                if (obj instanceof long[]) {
                    if (obj.length != i2) {
                        throw new NumberFormatException(str3);
                    } else {
                        return (int)obj[i];
                    }
                }
                if (!(obj instanceof int[])) {
                    throw new NumberFormatException("Couldn't find a integer value");
                } else {
                    if (obj.length != i2) {
                        throw new NumberFormatException(str3);
                    } else {
                        return obj[i];
                    }
                }
            }
        }

        public String j(ByteOrder byteOrder) {
            int i = 0;
            Object obj4 = k(byteOrder);
            int length3 = 0;
            if (obj4 == null) {
                return null;
            }
            if (obj4 instanceof String) {
                return obj4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            final String str = ",";
            i = 0;
            if (obj4 instanceof long[]) {
                while (i < obj4.length) {
                    stringBuilder.append(obj4[i]);
                    i = i + 1;
                    length = obj4.length;
                }
                return stringBuilder.toString();
            }
            if (obj4 instanceof int[]) {
                while (i < obj4.length) {
                    stringBuilder.append(obj4[i]);
                    i = i + 1;
                    length2 = obj4.length;
                }
                return stringBuilder.toString();
            }
            if (obj4 instanceof double[]) {
                while (i < obj4.length) {
                    stringBuilder.append(obj4[i]);
                    i = i + 1;
                    length4 = obj4.length;
                }
                return stringBuilder.toString();
            }
            if (obj4 instanceof a.e[]) {
                while (i < obj4.length) {
                    stringBuilder.append(obj4[i].a);
                    stringBuilder.append('/');
                    stringBuilder.append(obj4[i].b);
                    i = i + 1;
                    length3 = obj4.length;
                }
                return stringBuilder.toString();
            }
            return length3;
        }

        Object k(ByteOrder byteOrder) {
            Throwable th;
            int unsignedShort = 1;
            int length = 0;
            int length2;
            int length4;
            byte b2;
            int i = 0;
            try {
                final d.l.a.a.b bVar = new a.b(this.d);
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
            try {
                bVar.e(th1);
                unsignedShort = 1;
                length = 0;
                double[] dArr2 = new double[this.b];
                dArr2[unsignedShort] = bVar.readDouble();
            } catch (java.io.IOException ioException) {
                Log.e(str3, str, ioException);
            }
            try {
                length3 = bArr.length;
                char[] cArr = new char[unsignedShort];
                cArr[length] = (char)(this.d[length] + 48);
            } catch (java.io.IOException ioException) {
                Log.e(str3, str, ioException);
            }
            return lArr;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "(";
            String str3 = a.I[this.a];
            String str4 = ", data length:";
            int length = this.d.length;
            String str5 = ")";
            str = str2 + str3 + str4 + length + str5;
            return str;
        }

        c(int i, int i2, long j, byte[] bArr) {
            super();
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = bArr;
        }
    }

    static class d {

        public final int a;
        public final String b;
        public final int c;
        public final int d;
        d(String str, int i, int i2) {
            super();
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = -1;
        }

        boolean a(int i) {
            int i3 = 7;
            final boolean z = true;
            return true;
        }

        d(String str, int i, int i2, int i3) {
            super();
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    private static class e {

        public final long a;
        public final long b = 1;
        e(long j, long j2) {
            super();
            final long l = 0L;
            if (j2 == l) {
                this.a = l;
                return;
            }
            this.a = j;
            this.b = j2;
        }

        public double a() {
            return (double)this.a / (double)this.b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "/";
            str = this.a + str2 + this.b;
            return str;
        }
    }

    private static class f extends a.b {
        f(byte[] bArr) {
            super(bArr);
            this.a.mark(Integer.MAX_VALUE);
        }

        @Override // d.l.a.a$b
        public void i(long j) {
            long l;
            long l3 = (long)i;
            if (l3 > j) {
                this.c = 0;
                this.a.reset();
            } else {
                l = j - (long)i;
            }
            f((int)l);
        }

        f(InputStream inputStream) {
            super(inputStream);
            if (!inputStream.markSupported()) {
                throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
            } else {
                this.a.mark(Integer.MAX_VALUE);
                return;
            }
        }
    }
    static {
        String str = null;
        String str2;
        String str3;
        String str4;
        int i = 0;
        int i9 = 3;
        Integer num = Integer.valueOf(i9);
        a.o = Log.isLoggable("ExifInterface", i9);
        int i2 = 4;
        Integer[] arr7 = new Integer[i2];
        int i73 = 1;
        final Integer num10 = Integer.valueOf(i73);
        int i81 = 0;
        arr7[i81] = num10;
        arr7[i73] = 6;
        int i308 = 2;
        final Integer num13 = Integer.valueOf(i308);
        arr7[i308] = num;
        int i349 = 8;
        Integer num2 = Integer.valueOf(i349);
        arr7[i9] = num2;
        a.p = Arrays.asList(arr7);
        Integer[] arr8 = new Integer[i2];
        arr8[i81] = num13;
        Integer num3 = 7;
        arr8[i73] = num3;
        arr8[i308] = Integer.valueOf(i2);
        int i428 = 5;
        final Integer num15 = Integer.valueOf(i428);
        arr8[i9] = num15;
        a.q = Arrays.asList(arr8);
        a.r = new int[] { 8, 8, 8 };
        int[] iArr2 = new int[i73];
        iArr2[i81] = i349;
        a.s = iArr2;
        a.t = new byte[] { -1, -40, -1 };
        a.u = new byte[] { 102, 116, 121, 112 };
        a.v = new byte[] { 109, 105, 102, 49 };
        a.w = new byte[] { 104, 101, 105, 99 };
        a.x = new byte[] { 79, 76, 89, 77, 80, 0 };
        a.y = new byte[] { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
        a.z = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
        a.A = new byte[] { 101, 88, 73, 102 };
        a.B = new byte[] { 73, 72, 68, 82 };
        a.C = new byte[] { 73, 69, 78, 68 };
        a.D = new byte[] { 82, 73, 70, 70 };
        a.E = new byte[] { 87, 69, 66, 80 };
        a.F = new byte[] { 69, 88, 73, 70 };
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        a.I = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
        a.J = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
        a.K = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
        d.l.a.a.d[] arr15 = new a.d[42];
        arr15[i81] = new a.d("NewSubfileType", 254, i2);
        arr15[i73] = new a.d("SubfileType", 255, i2);
        arr15[i308] = new a.d("ImageWidth", 256, i9, i2);
        arr15[i9] = new a.d("ImageLength", 257, i9, i2);
        arr15[i2] = new a.d("BitsPerSample", 258, i9);
        arr15[i428] = new a.d("Compression", 259, i9);
        arr15[6] = new a.d("PhotometricInterpretation", 262, i9);
        arr15[7] = new a.d("ImageDescription", 270, i308);
        arr15[8] = new a.d("Make", 271, i308);
        arr15[9] = new a.d("Model", 272, i308);
        arr15[10] = new a.d("StripOffsets", 273, i9, i2);
        arr15[11] = new a.d("Orientation", 274, i9);
        arr15[12] = new a.d("SamplesPerPixel", 277, i9);
        arr15[13] = new a.d("RowsPerStrip", 278, i9, i2);
        arr15[14] = new a.d("StripByteCounts", 279, i9, i2);
        arr15[15] = new a.d("XResolution", 282, i428);
        arr15[16] = new a.d("YResolution", 283, i428);
        arr15[17] = new a.d("PlanarConfiguration", 284, i9);
        arr15[18] = new a.d("ResolutionUnit", 296, i9);
        arr15[19] = new a.d("TransferFunction", 301, i9);
        arr15[20] = new a.d("Software", 305, i308);
        arr15[21] = new a.d("DateTime", 306, i308);
        arr15[22] = new a.d("Artist", 315, i308);
        int i208 = 23;
        arr15[i208] = new a.d("WhitePoint", 318, i428);
        arr15[24] = new a.d("PrimaryChromaticities", 319, i428);
        arr15[25] = new a.d("SubIFDPointer", 330, i2);
        arr15[26] = new a.d("JPEGInterchangeFormat", 513, i2);
        arr15[27] = new a.d("JPEGInterchangeFormatLength", 514, i2);
        arr15[28] = new a.d("YCbCrCoefficients", 529, i428);
        arr15[29] = new a.d("YCbCrSubSampling", 530, i9);
        arr15[30] = new a.d("YCbCrPositioning", 531, i9);
        arr15[31] = new a.d("ReferenceBlackWhite", 532, i428);
        arr15[32] = new a.d("Copyright", 33432, i308);
        arr15[33] = new a.d("ExifIFDPointer", 34665, i2);
        arr15[34] = new a.d("GPSInfoIFDPointer", 34853, i2);
        arr15[35] = new a.d("SensorTopBorder", i2, i2);
        arr15[36] = new a.d("SensorLeftBorder", i428, i2);
        arr15[37] = new a.d("SensorBottomBorder", 6, i2);
        int i374 = 7;
        arr15[38] = new a.d("SensorRightBorder", i374, i2);
        arr15[39] = new a.d("ISO", i208, i9);
        arr15[40] = new a.d("JpgFromRaw", 46, i374);
        arr15[41] = new a.d("Xmp", 700, i73);
        a.L = arr15;
        d.l.a.a.d[] arr9 = new a.d[74];
        arr9[0] = new a.d("ExposureTime", 33434, i428);
        arr9[i73] = new a.d("FNumber", 33437, i428);
        arr9[i308] = new a.d("ExposureProgram", 34850, i9);
        arr9[i9] = new a.d("SpectralSensitivity", 34852, i308);
        arr9[i2] = new a.d("PhotographicSensitivity", 34855, i9);
        int i74 = 7;
        arr9[i428] = new a.d("OECF", 34856, i74);
        arr9[6] = new a.d("SensitivityType", 34864, i9);
        arr9[i74] = new a.d("StandardOutputSensitivity", 34865, i2);
        arr9[8] = new a.d("RecommendedExposureIndex", 34866, i2);
        arr9[9] = new a.d("ISOSpeed", 34867, i2);
        arr9[10] = new a.d("ISOSpeedLatitudeyyy", 34868, i2);
        arr9[11] = new a.d("ISOSpeedLatitudezzz", 34869, i2);
        arr9[12] = new a.d("ExifVersion", 36864, i308);
        arr9[13] = new a.d("DateTimeOriginal", 36867, i308);
        arr9[14] = new a.d("DateTimeDigitized", 36868, i308);
        arr9[15] = new a.d("OffsetTime", 36880, i308);
        arr9[16] = new a.d("OffsetTimeOriginal", 36881, i308);
        arr9[17] = new a.d("OffsetTimeDigitized", 36882, i308);
        arr9[18] = new a.d("ComponentsConfiguration", 37121, 7);
        arr9[19] = new a.d("CompressedBitsPerPixel", 37122, i428);
        int i384 = 10;
        arr9[20] = new a.d("ShutterSpeedValue", 37377, i384);
        arr9[21] = new a.d("ApertureValue", 37378, i428);
        arr9[22] = new a.d("BrightnessValue", 37379, i384);
        arr9[23] = new a.d("ExposureBiasValue", 37380, i384);
        arr9[24] = new a.d("MaxApertureValue", 37381, i428);
        arr9[25] = new a.d("SubjectDistance", 37382, i428);
        arr9[26] = new a.d("MeteringMode", 37383, i9);
        arr9[27] = new a.d("LightSource", 37384, i9);
        arr9[28] = new a.d("Flash", 37385, i9);
        arr9[29] = new a.d("FocalLength", 37386, i428);
        arr9[30] = new a.d("SubjectArea", 37396, i9);
        int i385 = 7;
        arr9[31] = new a.d("MakerNote", 37500, i385);
        arr9[32] = new a.d("UserComment", 37510, i385);
        arr9[33] = new a.d("SubSecTime", 37520, i308);
        arr9[34] = new a.d("SubSecTimeOriginal", 37521, i308);
        arr9[35] = new a.d("SubSecTimeDigitized", 37522, i308);
        arr9[36] = new a.d("FlashpixVersion", 40960, 7);
        arr9[37] = new a.d("ColorSpace", 40961, i9);
        arr9[38] = new a.d("PixelXDimension", 40962, i9, i2);
        arr9[39] = new a.d("PixelYDimension", 40963, i9, i2);
        arr9[40] = new a.d("RelatedSoundFile", 40964, i308);
        arr9[41] = new a.d("InteroperabilityIFDPointer", 40965, i2);
        arr9[42] = new a.d("FlashEnergy", 41483, i428);
        arr9[43] = new a.d("SpatialFrequencyResponse", 41484, 7);
        arr9[44] = new a.d("FocalPlaneXResolution", 41486, i428);
        arr9[45] = new a.d("FocalPlaneYResolution", 41487, i428);
        arr9[46] = new a.d("FocalPlaneResolutionUnit", 41488, i9);
        arr9[47] = new a.d("SubjectLocation", 41492, i9);
        arr9[48] = new a.d("ExposureIndex", 41493, i428);
        arr9[49] = new a.d("SensingMethod", 41495, i9);
        int i388 = 7;
        arr9[50] = new a.d("FileSource", 41728, i388);
        arr9[51] = new a.d("SceneType", 41729, i388);
        arr9[52] = new a.d("CFAPattern", 41730, i388);
        arr9[53] = new a.d("CustomRendered", 41985, i9);
        arr9[54] = new a.d("ExposureMode", 41986, i9);
        arr9[55] = new a.d("WhiteBalance", 41987, i9);
        arr9[56] = new a.d("DigitalZoomRatio", 41988, i428);
        arr9[57] = new a.d("FocalLengthIn35mmFilm", 41989, i9);
        arr9[58] = new a.d("SceneCaptureType", 41990, i9);
        arr9[59] = new a.d("GainControl", 41991, i9);
        arr9[60] = new a.d("Contrast", 41992, i9);
        arr9[61] = new a.d("Saturation", 41993, i9);
        arr9[62] = new a.d("Sharpness", 41994, i9);
        arr9[63] = new a.d("DeviceSettingDescription", 41995, 7);
        arr9[64] = new a.d("SubjectDistanceRange", 41996, i9);
        arr9[65] = new a.d("ImageUniqueID", 42016, i308);
        arr9[66] = new a.d("CameraOwnerName", 42032, i308);
        arr9[67] = new a.d("BodySerialNumber", 42033, i308);
        arr9[68] = new a.d("LensSpecification", 42034, i428);
        arr9[69] = new a.d("LensMake", 42035, i308);
        arr9[70] = new a.d("LensModel", 42036, i308);
        arr9[71] = new a.d("Gamma", 42240, i428);
        arr9[72] = new a.d("DNGVersion", 50706, 1);
        arr9[73] = new a.d("DefaultCropSize", 50720, i9, i2);
        a.M = arr9;
        d.l.a.a.d[] arr10 = new a.d[32];
        int i3 = 1;
        int i391 = 0;
        arr10[i391] = new a.d("GPSVersionID", i391, i3);
        arr10[i3] = new a.d("GPSLatitudeRef", i3, i308);
        int i279 = 10;
        arr10[i308] = new a.d("GPSLatitude", i308, i428, i279);
        arr10[i9] = new a.d("GPSLongitudeRef", i9, i308);
        int i392 = 4;
        arr10[i392] = new a.d("GPSLongitude", i392, i428, i279);
        arr10[i428] = new a.d("GPSAltitudeRef", i428, 1);
        int i281 = 6;
        arr10[i281] = new a.d("GPSAltitude", i281, i428);
        int i282 = 7;
        arr10[i282] = new a.d("GPSTimeStamp", i282, i428);
        int i283 = 8;
        arr10[i283] = new a.d("GPSSatellites", i283, i308);
        int i284 = 9;
        arr10[i284] = new a.d("GPSStatus", i284, i308);
        int i285 = 10;
        arr10[i285] = new a.d("GPSMeasureMode", i285, i308);
        int i286 = 11;
        arr10[i286] = new a.d("GPSDOP", i286, i428);
        int i287 = 12;
        arr10[i287] = new a.d("GPSSpeedRef", i287, i308);
        int i288 = 13;
        arr10[i288] = new a.d("GPSSpeed", i288, i428);
        int i289 = 14;
        arr10[i289] = new a.d("GPSTrackRef", i289, i308);
        int i290 = 15;
        arr10[i290] = new a.d("GPSTrack", i290, i428);
        int i291 = 16;
        arr10[i291] = new a.d("GPSImgDirectionRef", i291, i308);
        int i292 = 17;
        arr10[i292] = new a.d("GPSImgDirection", i292, i428);
        int i293 = 18;
        arr10[i293] = new a.d("GPSMapDatum", i293, i308);
        int i294 = 19;
        arr10[i294] = new a.d("GPSDestLatitudeRef", i294, i308);
        int i295 = 20;
        arr10[i295] = new a.d("GPSDestLatitude", i295, i428);
        arr10[21] = new a.d("GPSDestLongitudeRef", 21, i308);
        arr10[22] = new a.d("GPSDestLongitude", 22, i428);
        int i298 = 23;
        arr10[i298] = new a.d("GPSDestBearingRef", i298, i308);
        arr10[24] = new a.d("GPSDestBearing", 24, i428);
        arr10[25] = new a.d("GPSDestDistanceRef", 25, i308);
        arr10[26] = new a.d("GPSDestDistance", 26, i428);
        int i393 = 7;
        arr10[27] = new a.d("GPSProcessingMethod", 27, i393);
        arr10[28] = new a.d("GPSAreaInformation", 28, i393);
        arr10[29] = new a.d("GPSDateStamp", 29, i308);
        arr10[30] = new a.d("GPSDifferential", 30, i9);
        arr10[31] = new a.d("GPSHPositioningError", 31, i428);
        a.N = arr10;
        int i4 = 1;
        d.l.a.a.d[] arr11 = new a.d[i4];
        int i5 = 0;
        arr11[i5] = new a.d("InteroperabilityIndex", i4, i308);
        a.O = arr11;
        d.l.a.a.d[] arr12 = new a.d[38];
        int i10 = 4;
        arr12[i5] = new a.d("NewSubfileType", 254, i10);
        arr12[1] = new a.d("SubfileType", 255, i10);
        int i429 = 3;
        arr12[2] = new a.d("ThumbnailImageWidth", 256, i429, i10);
        arr12[i429] = new a.d("ThumbnailImageLength", 257, i429, i10);
        arr12[i10] = new a.d("BitsPerSample", 258, i429);
        arr12[5] = new a.d("Compression", 259, i429);
        arr12[6] = new a.d("PhotometricInterpretation", 262, i429);
        int i398 = 2;
        arr12[7] = new a.d("ImageDescription", 270, i398);
        arr12[8] = new a.d("Make", 271, i398);
        arr12[9] = new a.d("Model", 272, i398);
        int i430 = 3;
        arr12[10] = new a.d("StripOffsets", 273, i430, 4);
        arr12[11] = new a.d("ThumbnailOrientation", 274, i430);
        arr12[12] = new a.d("SamplesPerPixel", 277, i430);
        int i400 = 4;
        arr12[13] = new a.d("RowsPerStrip", 278, i430, i400);
        arr12[14] = new a.d("StripByteCounts", 279, i430, i400);
        int i401 = 5;
        arr12[15] = new a.d("XResolution", 282, i401);
        arr12[16] = new a.d("YResolution", 283, i401);
        int i402 = 3;
        arr12[17] = new a.d("PlanarConfiguration", 284, i402);
        arr12[18] = new a.d("ResolutionUnit", 296, i402);
        arr12[19] = new a.d("TransferFunction", 301, i402);
        int i403 = 2;
        arr12[20] = new a.d("Software", 305, i403);
        arr12[21] = new a.d("DateTime", 306, i403);
        arr12[22] = new a.d("Artist", 315, i403);
        int i404 = 5;
        arr12[23] = new a.d("WhitePoint", 318, i404);
        arr12[24] = new a.d("PrimaryChromaticities", 319, i404);
        int i405 = 4;
        arr12[25] = new a.d("SubIFDPointer", 330, i405);
        arr12[26] = new a.d("JPEGInterchangeFormat", 513, i405);
        arr12[27] = new a.d("JPEGInterchangeFormatLength", 514, i405);
        arr12[28] = new a.d("YCbCrCoefficients", 529, 5);
        int i407 = 3;
        arr12[29] = new a.d("YCbCrSubSampling", 530, i407);
        arr12[30] = new a.d("YCbCrPositioning", 531, i407);
        arr12[31] = new a.d("ReferenceBlackWhite", 532, 5);
        arr12[32] = new a.d("Xmp", 700, 1);
        arr12[33] = new a.d("Copyright", 33432, 2);
        int i411 = 4;
        arr12[34] = new a.d("ExifIFDPointer", 34665, i411);
        arr12[35] = new a.d("GPSInfoIFDPointer", 34853, i411);
        arr12[36] = new a.d("DNGVersion", 50706, 1);
        int i431 = 3;
        arr12[37] = new a.d("DefaultCropSize", 50720, i431, 4);
        a.P = arr12;
        d.l.a.a.d[] arr = new a.d[i431];
        arr[0] = new a.d("ThumbnailImage", 256, 7);
        int i433 = 4;
        arr[1] = new a.d("CameraSettingsIFDPointer", 8224, i433);
        int i348 = 2;
        arr[i348] = new a.d("ImageProcessingIFDPointer", 8256, i433);
        a.R = arr;
        d.l.a.a.d[] arr6 = new a.d[i348];
        arr6[0] = new a.d("PreviewImageStart", 257, i433);
        int i418 = 1;
        arr6[i418] = new a.d("PreviewImageLength", 258, i433);
        a.S = arr6;
        d.l.a.a.d[] arr13 = new a.d[i418];
        int i427 = 3;
        arr13[0] = new a.d("AspectFrame", 4371, i427);
        a.T = arr13;
        d.l.a.a.d[] arr16 = new a.d[1];
        int i46 = 0;
        arr16[i46] = new a.d("ColorSpace", 55, i427);
        a.U = arr16;
        d.l.a.a.d[][] arr14 = new a.d[10];
        arr14[i46] = arr15;
        arr14[1] = arr9;
        arr14[2] = arr10;
        arr14[i427] = arr11;
        int i49 = 4;
        arr14[i49] = arr12;
        arr14[5] = arr15;
        int i67 = 6;
        arr14[i67] = arr;
        arr14[7] = arr6;
        arr14[8] = arr13;
        arr14[9] = arr16;
        a.V = arr14;
        d.l.a.a.d[] arr2 = new a.d[i67];
        arr2[0] = new a.d("SubIFDPointer", 330, i49);
        arr2[1] = new a.d("ExifIFDPointer", 34665, i49);
        arr2[2] = new a.d("GPSInfoIFDPointer", 34853, i49);
        arr2[3] = new a.d("InteroperabilityIFDPointer", 40965, i49);
        int i177 = 1;
        arr2[i49] = new a.d("CameraSettingsIFDPointer", 8224, i177);
        arr2[5] = new a.d("ImageProcessingIFDPointer", 8256, i177);
        a.W = arr2;
        a.X = new HashMap[arr14.length];
        a.Y = new HashMap[arr14.length];
        str2 = "ExposureTime";
        str3 = "SubjectDistance";
        str4 = "GPSTimeStamp";
        Charset cls = Charset.forName("US-ASCII");
        a.b0 = cls;
        a.c0 = "Exif\u0000\u0000".getBytes(cls);
        a.d0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(cls);
        Locale uS2 = Locale.US;
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", uS2);
        a.G = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        str = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, uS2);
        a.H = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        i = 0;
        d.l.a.a.d[][] arr5 = a.V;
        while (i < arr5.length) {
            a.X[i] = new HashMap();
            a.Y[i] = new HashMap();
            simpleDateFormat = a.V[i];
            timeZone = simpleDateFormat.length;
            int i62 = 0;
            for (String str2 : simpleDateFormat) {
                a.X[i].put(Integer.valueOf(str2.a), str2);
                a.Y[i].put(str2.b, str2);
            }
            i = i + 1;
            arr5 = a.V;
            str2 = simpleDateFormat[str];
            a.X[i].put(Integer.valueOf(str2.a), str2);
            a.Y[i].put(str2.b, str2);
            str = str + 1;
        }
        HashMap map = a.a0;
        d.l.a.a.d[] objArr = a.W;
        map.put(Integer.valueOf(objArr[0].a), num15);
        map.put(Integer.valueOf(objArr[1].a), num10);
        map.put(Integer.valueOf(objArr[2].a), num13);
        map.put(Integer.valueOf(objArr[3].a), num);
        map.put(Integer.valueOf(objArr[4].a), num3);
        map.put(Integer.valueOf(objArr[5].a), num2);
        Pattern.compile(".*[1-9].*");
        Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    }

    public a(String str) {
        super();
        d.l.a.a.d[][] arr = a.V;
        this.f = new HashMap[arr.length];
        this.g = new HashSet(arr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(str, "filename cannot be null");
        q(str);
    }

    private boolean A(HashMap map) {
        Object value = map.get("ImageLength");
        str = "ImageWidth";
        Object value2 = map.get(str);
        if (value != null && value2 != null) {
            int i2 = 512;
            if (value.i(this.h) <= i2 && value2.i(this.h) <= i2) {
                return true;
            }
        }
        return false;
    }

    private boolean B(byte[] bArr) {
        int i;
        i = 0;
        bArr2 = a.D;
        length = bArr2.length;
        while (i < a.D.length) {
            if (bArr[i] != a.D[i]) {
                return false;
            }
        }
        byte[] bArr3 = a.E;
        while (i < bArr3.length) {
            if (bArr[(a.D.length + i) + 4] != a.E[i]) {
                return false;
            }
        }
        return true;
    }

    private void C(InputStream inputStream) {
        d.l.a.a.f fVar = null;
        String str2;
        int i;
        long l;
        String str3;
        int length = 5000;
        Object obj;
        boolean z4;
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        i = 0;
        length = a.V.length;
        while (i < a.V.length) {
            this.f[i] = new HashMap();
            i = i + 1;
            try {
                length = a.V.length;
                while (i < a.V.length) {
                    this.f[i] = new HashMap();
                    i = i + 1;
                    try {
                        length = a.V.length;
                        while (i < a.V.length) {
                            this.f[i] = new HashMap();
                            i = i + 1;
                            try {
                                length = a.V.length;
                                while (i < a.V.length) {
                                    this.f[i] = new HashMap();
                                    i = i + 1;
                                    try {
                                        length = a.V.length;
                                        while (i < a.V.length) {
                                            this.f[i] = new HashMap();
                                            i = i + 1;
                                            try {
                                                length = a.V.length;
                                                while (i < a.V.length) {
                                                    this.f[i] = new HashMap();
                                                    i = i + 1;
                                                    try {
                                                        length = a.V.length;
                                                        while (i < a.V.length) {
                                                            this.f[i] = new HashMap();
                                                            i = i + 1;
                                                            try {
                                                                length = a.V.length;
                                                                while (i < a.V.length) {
                                                                    this.f[i] = new HashMap();
                                                                    i = i + 1;
                                                                    try {
                                                                        length = a.V.length;
                                                                        while (i < a.V.length) {
                                                                            this.f[i] = new HashMap();
                                                                            i = i + 1;
                                                                            try {
                                                                                length = a.V.length;
                                                                                while (i < a.V.length) {
                                                                                    this.f[i] = new HashMap();
                                                                                    i = i + 1;
                                                                                    try {
                                                                                        length = a.V.length;
                                                                                        while (i < a.V.length) {
                                                                                            this.f[i] = new HashMap();
                                                                                            i = i + 1;
                                                                                            try {
                                                                                                length = a.V.length;
                                                                                                while (i < a.V.length) {
                                                                                                    this.f[i] = new HashMap();
                                                                                                    i = i + 1;
                                                                                                    try {
                                                                                                        length = a.V.length;
                                                                                                        while (i < a.V.length) {
                                                                                                            this.f[i] = new HashMap();
                                                                                                            i = i + 1;
                                                                                                            try {
                                                                                                                length = a.V.length;
                                                                                                                while (i < a.V.length) {
                                                                                                                    this.f[i] = new HashMap();
                                                                                                                    i = i + 1;
                                                                                                                    try {
                                                                                                                        length = a.V.length;
                                                                                                                        while (i < a.V.length) {
                                                                                                                            this.f[i] = new HashMap();
                                                                                                                            i = i + 1;
                                                                                                                            try {
                                                                                                                                length = a.V.length;
                                                                                                                                while (i < a.V.length) {
                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                    i = i + 1;
                                                                                                                                    try {
                                                                                                                                        length = a.V.length;
                                                                                                                                        while (i < a.V.length) {
                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                            i = i + 1;
                                                                                                                                            try {
                                                                                                                                                length = a.V.length;
                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                    i = i + 1;
                                                                                                                                                    try {
                                                                                                                                                        length = a.V.length;
                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                            i = i + 1;
                                                                                                                                                            try {
                                                                                                                                                                length = a.V.length;
                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                    i = i + 1;
                                                                                                                                                                    try {
                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                            i = i + 1;
                                                                                                                                                                            try {
                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                    try {
                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                            try {
                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                    try {
                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                            try {
                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                                                                        length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                                                                        while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                                                                            this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                                                                            i = i + 1;
                                                                                                                                                                                                                                                                                                                                                                                                            try {
                                                                                                                                                                                                                                                                                                                                                                                                                length = a.V.length;
                                                                                                                                                                                                                                                                                                                                                                                                                while (i < a.V.length) {
                                                                                                                                                                                                                                                                                                                                                                                                                    this.f[i] = new HashMap();
                                                                                                                                                                                                                                                                                                                                                                                                                    i = i + 1;
                                                                                                                                                                                                                                                                                                                                                                                                                    try {
                                                                                                                                                                                                                                                                                                                                                                                                                        /* DEPTH_LIMIT_EXCEEDED: Region nesting too deep */
                                                                                                                                                                                                                                                                                                                                                                                                                        /* DEPTH_LIMIT_EXCEEDED: Region nesting too deep */
                                                                                                                                                                                                                                                                                                                                                                                                                        /* DEPTH_LIMIT_EXCEEDED: Region nesting too deep */
                                                                                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            } catch (Throwable th) {
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    } catch (Throwable th) {
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            } catch (Throwable th) {
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    } catch (Throwable th) {
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            } catch (Throwable th) {
                                                                                                                            }
                                                                                                                        }
                                                                                                                    } catch (Throwable th) {
                                                                                                                    }
                                                                                                                }
                                                                                                            } catch (Throwable th) {
                                                                                                            }
                                                                                                        }
                                                                                                    } catch (Throwable th) {
                                                                                                    }
                                                                                                }
                                                                                            } catch (Throwable th) {
                                                                                            }
                                                                                        }
                                                                                    } catch (Throwable th) {
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th) {
                                                                            }
                                                                        }
                                                                    } catch (Throwable th) {
                                                                    }
                                                                }
                                                            } catch (Throwable th) {
                                                            }
                                                        }
                                                    } catch (Throwable th) {
                                                    }
                                                }
                                            } catch (Throwable th) {
                                            }
                                        }
                                    } catch (Throwable th) {
                                    }
                                }
                            } catch (Throwable th) {
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    private void D(a.b bVar) throws IOException {
        ByteOrder byteOrder = F(bVar);
        this.h = byteOrder;
        bVar.e(byteOrder);
        int unsignedShort = bVar.readUnsignedShort();
        int i2 = 7;
        int _int = bVar.readInt();
        if (_int < 8) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Invalid first Ifd offset: ";
            r0 = str2 + _int;
            throw new IOException(r0);
        } else {
            _int -= 8;
            if (i3 > 0) {
                bVar.f(i3);
            }
            return;
        }
    }

    private void E() {
        int i = 0;
        boolean hasNext;
        Object value;
        StringBuilder stringBuilder;
        String str2;
        i = 0;
        while (i < this.f.length) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str4 = "The size of tag group[";
            String str5 = "]: ";
            int size = this.f[i].size();
            str3 = str4 + i + str5 + size;
            str = "ExifInterface";
            Log.d(str, str3);
            Iterator it = this.f[i].entrySet().iterator();
            while (it.hasNext()) {
                Object item = it.next();
                value = item.getValue();
                stringBuilder = new StringBuilder();
                str2 = "tagName: ";
                Object key = item.getKey();
                String str6 = ", tagType: ";
                String cVar = value.toString();
                String str7 = ", tagValue: '";
                String str8 = value.j(this.h);
                String str9 = "'";
                str10 = str2 + key + str6 + cVar + str7 + str8 + str9;
                Log.d(str, str10);
            }
            i = i + 1;
            item = it.next();
            value = item.getValue();
            stringBuilder = new StringBuilder();
            str2 = "tagName: ";
            key = item.getKey();
            str6 = ", tagType: ";
            cVar = value.toString();
            str7 = ", tagValue: '";
            str8 = value.j(this.h);
            str9 = "'";
            str10 = str2 + key + str6 + cVar + str7 + str8 + str9;
            Log.d(str, str10);
        }
    }

    private ByteOrder F(a.b bVar) throws IOException {
        short _short = bVar.readShort();
        String str = "ExifInterface";
        if (_short != 18761) {
            if (_short != 19789) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str2 = "Invalid byte order: ";
                String str5 = Integer.toHexString(_short);
                bVar = str2 + str5;
                throw new IOException(bVar);
            } else {
                if (a.o) {
                    Log.d(str, "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
        }
        if (a.o) {
            Log.d(str, "readExifSegment: Byte Align II");
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void G(byte[] bArr, int i) {
        final d.l.a.a.f fVar = new a.f(bArr);
        D(fVar);
        H(fVar, i);
    }

    private void H(a.f fVar, int i) {
        short _short;
        HashMap map;
        int i3;
        Object value;
        int i4 = 0;
        long l;
        int i7 = 65535;
        String str2;
        int unsignedShort;
        long l2 = -1;
        int i6 = 0;
        int i8 = 0;
        String str3;
        long l10;
        long l3 = 0;
        int i9 = 1;
        boolean contains2;
        int i10 = 5;
        int i11 = 3;
        Integer num2;
        String str5;
        int i12 = 7;
        String str8;
        d.l.a.a.c cVar2;
        long l4;
        int unsignedShort2;
        int unsignedShort3;
        d.l.a.a.c cVar;
        int i13;
        long l6;
        byte[] bArr;
        byte[] bArr2;
        int i14;
        int i15;
        int i16;
        Integer num3;
        int cmp3;
        final Object fVar3 = this;
        fVar2 = fVar;
        int i22 = i;
        fVar3.g.add(Integer.valueOf(fVar2.c));
        _short = fVar.readShort();
        str3 = "ExifInterface";
        if (a.o) {
            StringBuilder stringBuilder6 = new StringBuilder();
            str4 = "numberOfDirectoryEntry: ";
            str28 = str4 + _short;
            Log.d("ExifInterface", str28);
        }
        if (_short <= 0) {
            return;
        }
        i4 = 0;
        i10 = 5;
        while (i4 < fVar3.g) {
            unsignedShort2 = fVar.readUnsignedShort();
            unsignedShort3 = fVar.readUnsignedShort();
            unsignedShort3 = fVar.readInt();
            long l15 = 4L;
            l4 = (long)fVar.a() + l15;
            Object value2 = a.X[i22].get(Integer.valueOf(unsignedShort2));
            boolean z4 = a.o;
            int length = 3;
            i4 = (short)(i4 + 1);
            i4 = 0;
        }
        int _int = fVar.readInt();
        z = a.o;
        if (a.o) {
            Object[] arr = new Object[1];
            i4 = 0;
            arr[i4] = Integer.valueOf(_int);
            str3 = "nextIfdOffset: %d";
            Log.d(str3, String.format(str3, arr));
        }
        long l9 = (long)_int;
        long l5 = 0L;
        if (a.o > l5) {
            if (!fVar3.g.contains(Integer.valueOf(_int))) {
                fVar2.i(l9);
                int i21 = 4;
                if (fVar3.f[i21].isEmpty()) {
                    fVar3.H(fVar2, i21);
                } else {
                    if (fVar3.f[i10].isEmpty()) {
                        fVar3.H(fVar2, i10);
                    }
                }
            } else {
                if (a.o) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str22 = "Stop reading file since re-reading an IFD may cause an infinite loop: ";
                    str10 = str22 + _int;
                    Log.d(str3, str10);
                }
            }
        } else {
            if (a.o) {
                StringBuilder stringBuilder = new StringBuilder();
                String str21 = "Stop reading file since a wrong offset may cause an infinite loop: ";
                str9 = str21 + _int;
                Log.d(str3, str9);
            }
        }
    }

    private void I(int i, String str, String str2) {
        if (!this.f[i].isEmpty()) {
            if (this.f[i].get(str) != null) {
                objArr4[i].put(str2, objArr4[i].get(str));
                this.f[i].remove(str);
            }
        }
    }

    private void J(a.f fVar, int i) throws IOException {
        str = "ImageWidth";
        if ((a.c)this.f[i].get("ImageLength") == null || (a.c)this.f[i].get(str) == null) {
            Object value = this.f[i].get("JPEGInterchangeFormat");
            str = "JPEGInterchangeFormatLength";
            if (value != null && (a.c)this.f[i].get(str) != null) {
                int i3 = value.i(this.h);
                fVar.i((long)i3);
                byte[] bArr = new byte[value.i(this.h)];
                fVar.read(bArr);
                f(new a.b(bArr), i3, i);
            }
        }
    }

    private void K(a.b bVar) {
        int i = 6;
        HashMap map = this.f[4];
        Object value = map.get("Compression");
        i = 6;
        if (value == null) {
            this.j = i;
            o(bVar, map);
        } else {
            int i4 = value.i(this.h);
            this.j = i4;
            int i2 = 1;
            if (i4 == 1 || i4 != i) {
                if (z(map)) {
                    p(bVar, map);
                }
            }
        }
    }

    private void M(int i, int i2) {
        str = "ExifInterface";
        if (!this.f[i].isEmpty()) {
            if (!(this.f[i2].isEmpty())) {
                String str2 = "ImageLength";
                Object value = this.f[i].get(str2);
                String str3 = "ImageWidth";
                Object value3 = this.f[i].get(str3);
                Object value2 = this.f[i2].get(str2);
                Object value4 = this.f[i2].get(str3);
                if (!(value != null || value3 == null)) {
                    if (a.o) {
                        Log.d(str, "First image does not contain valid size information");
                    }
                }
            }
            return;
        }
        if (a.o) {
            Log.d(str, "Cannot perform swap since only one image data exists");
        }
    }

    private void N(a.f fVar, int i) {
        d.l.a.a.c cVar;
        d.l.a.a.c cVar2;
        Object value = this.f[i].get("DefaultCropSize");
        Object value2 = this.f[i].get("SensorTopBorder");
        Object value3 = this.f[i].get("SensorLeftBorder");
        Object value4 = this.f[i].get("SensorBottomBorder");
        Object value5 = this.f[i].get("SensorRightBorder");
        String str8 = "ImageLength";
        final String str9 = "ImageWidth";
        if (value != null) {
            i = 1;
            int i3 = 0;
            int i4 = 2;
            str = "Invalid crop size values. cropSize=";
            str2 = "ExifInterface";
            if (value.a == 5) {
                Object obj3 = value.k(this.h);
                if (obj3 != null) {
                    cVar = a.c.d(obj3[i3], this.h);
                    cVar2 = a.c.d(obj3[i], this.h);
                    this.f[i].put(str9, cVar);
                    this.f[i].put(str8, cVar2);
                    return;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                String str12 = Arrays.toString(obj3);
                str13 = "Invalid crop size values. cropSize=" + str12;
                Log.w(str2, str13);
                return;
            }
            Object obj2 = value.k(this.h);
            if (obj2 != null) {
                cVar = a.c.f(obj2[i3], this.h);
                cVar2 = a.c.f(obj2[i], this.h);
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str10 = Arrays.toString(obj2);
            str11 = "Invalid crop size values. cropSize=" + str10;
            Log.w(str2, str11);
            return;
        }
        if (value2 == null || value3 == null || value4 == null || value5 == null) {
            J(fVar, i);
        } else {
            int i13 = value2.i(this.h);
            int i6 = value4.i(this.h);
            int i9 = value5.i(this.h);
            i = value3.i(this.h);
            if (i6 > i13 && i9 > i) {
                this.f[i].put(str8, a.c.f(i6 - i13, this.h));
                this.f[i].put(str9, a.c.f(i9 - i, this.h));
            }
        }
    }

    private void O() {
        Object value2;
        final int i = 0;
        final int i2 = 5;
        M(i, i2);
        final int i3 = 4;
        M(i, i3);
        M(i2, i3);
        int i4 = 1;
        Object value = this.f[i4].get("PixelXDimension");
        value2 = this.f[i4].get("PixelYDimension");
        String str7 = "ImageLength";
        final String str8 = "ImageWidth";
        if (value != null && value2 != null) {
            this.f[i].put(str8, value);
            this.f[i].put(str7, value2);
        }
        if (this.f[i3].isEmpty() && this.A(this.f[i2])) {
            this.f[i3] = objArr5[i2];
            this.f[i2] = new HashMap();
        }
        if (!A(this.f[i3])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        String str2 = "ThumbnailOrientation";
        String str4 = "Orientation";
        I(i, str2, str4);
        String str9 = "ThumbnailImageLength";
        I(i, str9, str7);
        final String str10 = "ThumbnailImageWidth";
        I(i, str10, str8);
        I(i2, str2, str4);
        I(i2, str9, str7);
        I(i2, str10, str8);
        I(i3, str4, str2);
        I(i3, str7, str9);
        I(i3, str8, str10);
    }

    private void a() {
        String str6;
        d.l.a.a.c cVar;
        String str = b("DateTimeOriginal");
        int i = 0;
        if (str != null) {
            str3 = "DateTime";
            if (b(str3) == null) {
                this.f[i].put(str3, a.c.a(str));
            }
        }
        String str9 = "ImageWidth";
        int i3 = 0;
        if (b(str9) == null) {
            this.f[i].put(str9, a.c.b(i3, this.h));
        }
        String str10 = "ImageLength";
        if (b(str10) == null) {
            this.f[i].put(str10, a.c.b(i3, this.h));
        }
        String str11 = "Orientation";
        if (b(str11) == null) {
            this.f[i].put(str11, a.c.b(i3, this.h));
        }
        String str12 = "LightSource";
        if (b(str12) == null) {
            this.f[1].put(str12, a.c.b(i3, this.h));
        }
    }

    private a.c d(String str) {
        boolean equals;
        int i = 0;
        String str2;
        Objects.requireNonNull(str, "tag shouldn't be null");
        if ("ISOSpeedRatings".equals(str) && a.o) {
            Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            str2 = "PhotographicSensitivity";
        }
        i = 0;
        for (HashMap map : arr) {
            Object value = map.get(str2);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    private void e(a.f fVar) {
        String metadata;
        String metadata2;
        String metadata3;
        String metadata4;
        String metadata5 = null;
        HashMap map;
        String str;
        int i2 = 1;
        d.l.a.a.c cVar;
        ByteOrder byteOrder;
        String str3 = "yes";
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        } else {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                b.b.a(mediaMetadataRetriever, new a.a(this, fVar));
                metadata2 = mediaMetadataRetriever.extractMetadata(33);
                metadata3 = mediaMetadataRetriever.extractMetadata(34);
                if (str3.equals(mediaMetadataRetriever.extractMetadata(26))) {
                    metadata5 = mediaMetadataRetriever.extractMetadata(29);
                    metadata = mediaMetadataRetriever.extractMetadata(30);
                    metadata4 = mediaMetadataRetriever.extractMetadata(31);
                } else {
                    if (str3.equals(mediaMetadataRetriever.extractMetadata(17))) {
                        metadata5 = mediaMetadataRetriever.extractMetadata(18);
                        metadata = mediaMetadataRetriever.extractMetadata(19);
                        metadata4 = mediaMetadataRetriever.extractMetadata(24);
                    } else {
                    }
                }
                int i17 = 0;
                if (metadata5 != null) {
                    str = "ImageWidth";
                    this.f[i17].put(str, a.c.f(Integer.parseInt(metadata5), this.h));
                }
                if (metadata != null) {
                    str = "ImageLength";
                    this.f[i17].put(str, a.c.f(Integer.parseInt(metadata), this.h));
                }
                i2 = 1;
                int parsed3 = Integer.parseInt(metadata4);
                int i3 = 90;
                if (parsed3 == 90) {
                } else {
                    i3 = 180;
                    if (parsed3 == 180) {
                        i2 = 3;
                    } else {
                        i3 = 270;
                        if (parsed3 == 270) {
                            i2 = 8;
                        }
                    }
                }
                this.f[i17].put("Orientation", a.c.f(i2, this.h));
                if (metadata2 != null && metadata3 != null) {
                    int parsed = Integer.parseInt(metadata2);
                    int parsed2 = Integer.parseInt(metadata3);
                    if (parsed2 <= this.f[i17]) {
                        throw new IOException("Invalid exif length");
                    } else {
                        fVar.i((long)parsed);
                        byte[] bArr3 = new byte[i2];
                        if (fVar.read(bArr3) != this.f[i17]) {
                            throw new IOException("Can't read identifier");
                        } else {
                            parsed2 -= 6;
                            if (!Arrays.equals(bArr3, a.c0)) {
                                throw new IOException("Invalid identifier");
                            } else {
                                byte[] bArr2 = new byte[i12];
                                if (fVar.read(bArr2) != i12) {
                                    throw new IOException("Can't read exif");
                                } else {
                                    this.k = parsed + i2;
                                    G(bArr2, i17);
                                }
                            }
                        }
                    }
                }
                if (a.o) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str10 = "Heif meta: ";
                    metadata3 = "x";
                    String str5 = ", rotation ";
                    metadata = str10 + metadata5 + metadata3 + metadata + str5 + metadata4;
                    Log.d("ExifInterface", metadata);
                }
            } catch (Throwable th) {
            }
            mediaMetadataRetriever.release();
            return;
        }
    }

    private void f(a.b bVar, int i, int i2) throws IOException, java.io.UnsupportedEncodingException {
        long l;
        String str;
        int i4;
        d.l.a.a.b bVar3;
        byte b = -1;
        d.l.a.a.c cVar;
        int i5 = 1;
        byte[] bArr;
        byte _byte;
        byte[] bArr2;
        String str3;
        Object obj;
        byte b2;
        int length2;
        String str5;
        d.l.a.a.c cVar2;
        String str6;
        String string;
        String str7;
        HashMap map;
        byte[] bArr3;
        d.l.a.a.c cVar3 = null;
        long l2;
        ByteOrder byteOrder;
        int length3;
        ByteOrder byteOrder2;
        int i6 = 1;
        int length;
        final Object bVar4 = this;
        String bVar2 = bVar;
        int i32 = i2;
        str = "ExifInterface";
        if (a.o) {
            StringBuilder stringBuilder4 = new StringBuilder();
            str2 = "getJpegAttributes starting with: ";
            str13 = str2 + bVar2;
            Log.d("ExifInterface", str13);
        }
        bVar2.e(ByteOrder.BIG_ENDIAN);
        byte _byte2 = bVar.readByte();
        String str14 = "Invalid marker: ";
        b = (byte) -1;
        if (_byte2 != (byte) -1) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String str12 = Integer.toHexString(_byte2 & 255);
            r2 = str14 + str12;
            throw new IOException(r2);
        } else {
            b2 = (byte) -40;
            if (bVar.readByte() != (byte) -40) {
                StringBuilder stringBuilder = new StringBuilder();
                String str9 = Integer.toHexString(_byte2 & 255);
                r2 = str14 + str9;
                throw new IOException(r2);
            } else {
                i = 2;
                byte _byte3 = bVar.readByte();
                while (_byte3 == b) {
                    i5 = 1;
                    byte _byte4 = bVar.readByte();
                    z2 = a.o;
                    byte b3 = (byte) -38;
                    length2 = bVar.readUnsignedShort() - i;
                    i4 = i11 + i;
                    str4 = "Invalid length";
                    length2 = 0;
                    if (_byte4 != -31) {
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                String str10 = "Invalid marker:";
                String str11 = Integer.toHexString(_byte3 & 255);
                r2 = str10 + str11;
                throw new IOException(r2);
            }
        }
    }

    private int g(BufferedInputStream bufferedInputStream) throws IOException {
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

    private void h(a.f fVar) {
        int i2;
        String str2;
        int i3;
        byte[] bArr2;
        byte[] bArr3;
        k(fVar);
        int i = 1;
        str = "MakerNote";
        Object value = this.f[i].get(str);
        if (value != null) {
            d.l.a.a.f fVar2 = new a.f(value.d);
            fVar2.e(this.h);
            byte[] bArr5 = a.x;
            byte[] bArr = new byte[bArr5.length];
            fVar2.readFully(bArr);
            fVar2.i(0L);
            bArr2 = a.y;
            bArr3 = new byte[bArr2.length];
            fVar2.readFully(bArr3);
            if (Arrays.equals(bArr, bArr5)) {
                fVar2.i(8L);
            } else {
                if (Arrays.equals(bArr3, a.y)) {
                    fVar2.i(12L);
                }
            }
            H(fVar2, 6);
            int i5 = 7;
            Object value2 = this.f[i5].get("PreviewImageStart");
            str2 = "PreviewImageLength";
            Object value3 = this.f[i5].get(str2);
            if (value2 != null && value3 != null) {
                int i17 = 5;
                this.f[i17].put("JPEGInterchangeFormat", value2);
                str2 = "JPEGInterchangeFormatLength";
                this.f[i17].put(str2, value3);
            }
            str = "AspectFrame";
            value = this.f[8].get(str);
            if (value != null) {
                value = value.k(this.h);
                if (value != null) {
                    if (value.length != 4) {
                        StringBuilder stringBuilder = new StringBuilder();
                        str = "Invalid aspect frame values. frame=";
                        String str6 = Arrays.toString(value);
                        str7 = str + str6;
                        Log.w("ExifInterface", str7);
                    } else {
                        int i7 = 2;
                        int i18 = 0;
                        if (value[i7] > value[i18]) {
                            int i13 = 3;
                            if (value[i13] > value[i]) {
                                i2 = (value[i7] - value[i18]) + i;
                                i3 = (value[i13] - value[i]) + i;
                                if (this.h < this.f[i17]) {
                                    i2 += i3;
                                    i3 = i10 - i3;
                                    i2 = i10 - i3;
                                }
                                str2 = "ImageWidth";
                                this.f[i18].put(str2, a.c.f(i2, this.h));
                                str = "ImageLength";
                                this.f[i18].put(str, a.c.f(i3, this.h));
                            }
                        }
                    }
                }
            }
        }
    }

    private void i(a.b bVar) throws IOException {
        int i;
        if (a.o) {
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "getPngAttributes starting with: ";
            str3 = str6 + bVar;
            str = "ExifInterface";
            Log.d(str, str3);
        }
        bVar.e(ByteOrder.BIG_ENDIAN);
        byte[] bArr2 = a.z;
        bVar.f(bArr2.length);
        int i6 = 0;
        i = bArr2.length + i6;
        int _int = bVar.readInt();
        int i7 = 4;
        byte[] bArr = new byte[i7];
        while (bVar.read(bArr) == i7) {
            int i5 = (i + i7) + i7;
            int i3 = 16;
            if (Arrays.equals(bArr, a.A)) {
                byte[] bArr6 = new byte[_int];
            }
        }
        throw new IOException("Encountered invalid length while parsing PNG chunktype");
    }

    private void j(a.b bVar) throws IOException {
        int i;
        z = a.o;
        final String str5 = "ExifInterface";
        if (a.o) {
            StringBuilder stringBuilder3 = new StringBuilder();
            str2 = "getRafAttributes starting with: ";
            str = str2 + bVar;
            Log.d(str5, str);
        }
        bVar.f(84);
        int i5 = 4;
        byte[] bArr2 = new byte[i5];
        byte[] bArr3 = new byte[i5];
        byte[] bArr = new byte[i5];
        bVar.read(bArr2);
        bVar.read(bArr3);
        bVar.read(bArr);
        int _int3 = ByteBuffer.wrap(bArr2).getInt();
        byte[] bArr4 = new byte[ByteBuffer.wrap(bArr3).getInt()];
        bVar.f(_int3 - bVar.a());
        bVar.read(bArr4);
        int unsignedShort = 5;
        f(new a.b(bArr4), _int3, unsignedShort);
        bVar.f(ByteBuffer.wrap(bArr).getInt() - bVar.a());
        bVar.e(ByteOrder.BIG_ENDIAN);
        int _int2 = bVar.readInt();
        if (a.o) {
            StringBuilder stringBuilder = new StringBuilder();
            String str7 = "numberOfDirectoryEntry: ";
            str4 = str7 + _int2;
            Log.d(str5, str4);
        }
        i = 0;
        while (i < _int2) {
            if (bVar.readUnsignedShort() == a.Q.a) {
                short _short = bVar.readShort();
                short _short2 = bVar.readShort();
                this.f[i].put("ImageLength", a.c.f(_short, this.h));
                str3 = "ImageWidth";
                this.f[i].put(str3, a.c.f(_short2, this.h));
            }
        }
    }

    private void k(a.f fVar) {
        D(fVar);
        int i3 = 0;
        H(fVar, i3);
        N(fVar, i3);
        N(fVar, 5);
        N(fVar, 4);
        O();
        int i = 8;
        if (this.d == 8) {
            i = 1;
            str = "MakerNote";
            Object value = this.f[i].get(str);
            if (value != null) {
                d.l.a.a.f fVar2 = new a.f(value.d);
                fVar2.e(this.h);
                fVar2.f(6);
                int i7 = 9;
                H(fVar2, i7);
                str = "ColorSpace";
                Object value2 = this.f[i7].get(str);
                if (value2 != null) {
                    this.f[i].put(str, value2);
                }
            }
        }
    }

    private void l(a.f fVar) {
        if (a.o) {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "getRw2Attributes starting with: ";
            str4 = str5 + fVar;
            str = "ExifInterface";
            Log.d(str, str4);
        }
        k(fVar);
        int i2 = 0;
        str2 = "JpgFromRaw";
        Object value2 = this.f[i2].get(str2);
        if (value2 != null) {
            int i = 5;
            f(new a.b(value2.d), (int)value2.c, i);
        }
        Object value3 = this.f[i2].get("ISO");
        int i3 = 1;
        String str6 = "PhotographicSensitivity";
        if (value3 != null && (a.c)this.f[i3].get(str6) == null) {
            this.f[i3].put(str6, value3);
        }
    }

    private void m(a.f fVar) {
        final byte[] bArr = a.c0;
        fVar.f(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.k = bArr.length;
        G(bArr2, 0);
    }

    private void n(a.b bVar) throws IOException {
        int i;
        int _int;
        if (a.o) {
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "getWebpAttributes starting with: ";
            str3 = str6 + bVar;
            str = "ExifInterface";
            Log.d(str, str3);
        }
        bVar.e(ByteOrder.LITTLE_ENDIAN);
        bVar.f(a.D.length);
        int i3 = bVar.readInt() + 8;
        byte[] bArr4 = a.E;
        length = bArr4.length;
        bVar.f(length);
        i = bArr4.length + 8;
        while (/* condition */) {
            try {
                byte[] bArr2 = new byte[i5];
            } catch (java.io.EOFException unused) {
                bVar = new IOException("Encountered corrupt WebP file.");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) bVar;
            }
        }
    }

    private void o(a.b bVar, HashMap map) throws IOException {
        int i;
        int i2;
        int i3 = 7;
        Object value = map.get("JPEGInterchangeFormat");
        str = "JPEGInterchangeFormatLength";
        Object value2 = map.get(str);
        if (value != null && value2 != null) {
            int i4 = value2.i(this.h);
            i3 = 7;
            if (this.d == 7) {
                i = value.i(this.h) + this.l;
            }
            if (i > 0 && i4 > 0 && this.a == null && this.c == null && this.b == null) {
                bVar.skip((long)i);
                bVar.read(new byte[i4]);
            }
            if (a.o) {
                StringBuilder stringBuilder = new StringBuilder();
                str = "Setting thumbnail attributes with offset: ";
                String str3 = ", length: ";
                str5 = str + i + str3 + i4;
                Log.d("ExifInterface", str5);
            }
        }
    }

    private void p(a.b bVar, HashMap map) throws IOException {
        int i = 0;
        int length;
        int i2;
        int i3;
        int i4;
        int bytesRead;
        String str2;
        long skipped;
        final Object bVar3 = this;
        bVar2 = bVar;
        Object obj = map;
        Object value2 = obj.get("StripOffsets");
        str = "StripByteCounts";
        Object value = obj.get(str);
        if (value2 != null && value != null) {
            long[] lArr2 = b.c(value2.k(bVar3.h));
            long[] lArr = b.c(value.k(bVar3.h));
            str = "ExifInterface";
            if (lArr2 != null) {
                length = lArr2.length;
                if (lArr2.length != 0) {
                    if (lArr != null) {
                        length = lArr.length;
                        if (lArr.length != 0) {
                            if (lArr2.length != lArr.length) {
                                Log.w(str, "stripOffsets and stripByteCounts should have same length.");
                                return;
                            }
                            i = 0;
                            boolean z2 = false;
                            i3 = z2;
                            for (long l : lArr) {
                                i = i + l;
                            }
                            boolean z = true;
                            bVar3.i = z;
                            length2 = lArr2.length;
                            while (lArr.length < lArr2.length) {
                                int i7 = (int)lArr2[i2];
                                i4 = (int)lArr[i2];
                                cmp = lArr2.length - z;
                                i7 -= i2;
                                long l5 = (long)i8;
                                skipped = bVar2.skip(l5);
                                str2 = " bytes.";
                                byte[] bArr2 = new byte[i4];
                                if (bVar2.read(bArr2) != i4) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    String str9 = "Failed to read ";
                                    str4 = str9 + i4 + str2;
                                    Log.d(str, str4);
                                    return;
                                }
                            }
                        }
                        if (bVar3.i) {
                            long l2 = lArr2[z2];
                        }
                    }
                }
                Log.w(str, "stripByteCounts should not be null or have zero length.");
                return;
            }
            Log.w(str, "stripOffsets should not be null or have zero length.");
        }
    }

    private void q(String str) {
        Objects.requireNonNull(str, "filename cannot be null");
        AssetManager.AssetInputStream assetInputStream = null;
        this.c = assetInputStream;
        this.a = str;
        try {
            final FileInputStream fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
        }
        try {
            if (a.y(fileInputStream.getFD()) != null) {
                this.b = fileInputStream.getFD();
            } else {
                this.b = assetInputStream;
            }
            C(fileInputStream);
        } catch (Throwable th) {
        }
        b.b(fileInputStream);
    }

    private static boolean r(BufferedInputStream bufferedInputStream) throws IOException {
        int bufferedInputStream2;
        byte[] bArr = a.c0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        bufferedInputStream2 = 0;
        byte[] bArr3 = a.c0;
        while (bArr.length < bArr3.length) {
            if (bArr2[bufferedInputStream2] != a.c0[bufferedInputStream2]) {
                return false;
            }
        }
        return true;
    }

    private boolean s(byte[] bArr) {
        boolean str;
        String str2;
        long _long;
        int i3 = 0;
        long l2 = 16;
        int i;
        boolean equals;
        long l3;
        i = 0;
        try {
            d.l.a.a.b bVar = new a.b(bArr);
        } catch (Throwable th) {
        } catch (Exception e1) {
        }
        try {
            _long = (long)bVar.readInt();
            int i2 = 4;
            byte[] bArr3 = new byte[i2];
            bVar.read(bArr3);
        } catch (Throwable th) {
        } catch (Exception e1) {
        }
        if (!Arrays.equals(bArr3, a.u)) {
            bVar.close();
            return false;
        }
        long l4 = 1L;
        l2 = 16L;
        long l5 = 8L;
        if (_long == l4) {
            try {
                _long = bVar.readLong();
            } catch (Throwable th) {
            } catch (Exception e1) {
            }
            if (_long < l2) {
                bVar.close();
                return false;
            }
        } else {
            int i5 = l5;
        }
        try {
            l3 = (long)e1.length;
            length = e1.length;
        } catch (Throwable th) {
        } catch (Exception e1) {
        }
        l = _long - l2;
        if (l < l5) {
            bVar.close();
            return false;
        }
        try {
            byte[] bArr2 = new byte[i2];
            i3 = 0;
            long l6 = l / 4L;
        } catch (Throwable th) {
        } catch (Exception e1) {
        }
        bVar.close();
        return false;
    }

    private static boolean t(byte[] bArr) {
        int i;
        i = 0;
        byte[] bArr2 = a.t;
        while (i < bArr2.length) {
            if (bArr[i] != a.t[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean u(byte[] bArr) {
        boolean z2 = true;
        Object obj;
        short s = 20306;
        int i = 0;
        try {
            final d.l.a.a.b bVar = new a.b(bArr);
        } catch (Throwable th) {
            obj = obj2;
        } catch (Exception unused) {
            obj = obj2;
        }
        try {
            ByteOrder byteOrder = F(bVar);
            this.h = byteOrder;
            bVar.e(byteOrder);
            short _short = bVar.readShort();
        } catch (Throwable th) {
            obj = obj2;
        } catch (Exception unused) {
            obj = obj2;
        }
        s = (short) 20306;
        boolean z = 1;
        bVar.close();
        return true;
    }

    private boolean v(byte[] bArr) {
        int i;
        i = 0;
        byte[] bArr2 = a.z;
        while (i < bArr2.length) {
            if (bArr[i] != a.z[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean w(byte[] bArr) throws java.io.UnsupportedEncodingException {
        int i;
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        i = 0;
        while (i < bytes.length) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean x(byte[] bArr) {
        boolean z2 = false;
        Object obj;
        int i = 0;
        try {
            final d.l.a.a.b bVar = new a.b(bArr);
        } catch (Throwable th) {
            obj = obj2;
        } catch (Exception unused) {
            obj = obj2;
        }
        try {
            ByteOrder byteOrder = F(bVar);
            this.h = byteOrder;
            bVar.e(byteOrder);
        } catch (Throwable th) {
            obj = obj2;
        } catch (Exception unused) {
            obj = obj2;
        }
        if (bVar.readShort() == 85) {
            int i2 = 1;
        }
        bVar.close();
        return z2;
    }

    private static boolean y(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            } catch (Exception unused) {
                fileDescriptor = a.o;
            }
            return true;
        }
        return false;
    }

    private boolean z(HashMap map) {
        Object value;
        value = map.get("BitsPerSample");
        if (value != null) {
            value = value.k(this.h);
            iArr = a.r;
            int i2 = 1;
            if (Arrays.equals(iArr, value)) {
                return true;
            }
            int i3 = 3;
            if (this.d == 3 && value2 != null) {
                int i5 = value2.i(this.h);
                if (i5 == i2) {
                    return Arrays.equals(value, a.s) || i5 == 6 || Arrays.equals(value, a.r) ? i2 : i2;
                }
            }
        }
        if (a.o) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
        return false;
    }

    public String b(String str) {
        int i = 5;
        Objects.requireNonNull(str, "tag shouldn't be null");
        d.l.a.a.c cVar = d(str);
        int i3 = 0;
        if (cVar != null) {
            if (!a.Z.contains(str)) {
                return cVar.j(this.h);
            }
            if (str.equals("GPSTimeStamp")) {
                i = 5;
                String str6 = "ExifInterface";
                if (cVar.a != 5 && cVar.a != 10) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str5 = "GPS Timestamp format is not rational. format=";
                    str10 = str5 + cVar.a;
                    Log.w(str6, str10);
                    return null;
                }
                Object obj7 = cVar.k(this.h);
                if (obj7 != null) {
                    i = 3;
                    Object[] arr = new Object[i];
                    int i4 = 0;
                    arr[i4] = Integer.valueOf((int)(float)obj7[i4].a / (float)obj7[i4].b);
                    int i5 = 1;
                    arr[i5] = Integer.valueOf((int)(float)obj7[i5].a / (float)obj7[i5].b);
                    int i6 = 2;
                    arr[i6] = Integer.valueOf((int)(float)obj7[i6].a / (float)obj7[i6].b);
                    return String.format("%02d:%02d:%02d", arr);
                }
                StringBuilder stringBuilder = new StringBuilder();
                String str4 = "Invalid GPS Timestamp array. array=";
                String str7 = Arrays.toString(obj7);
                str8 = str4 + str7;
                Log.w(str6, str8);
                return i3;
            }
            try {
            } catch (java.lang.NumberFormatException unused) {
                return i3;
            }
            return Double.toString(cVar.h(this.h));
        }
    }

    public int c(String str, int i) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        d.l.a.a.c cVar = d(str);
        if (cVar == null) {
            return i;
        }
        try {
        } catch (java.lang.NumberFormatException unused) {
            return i;
        }
        return cVar.i(this.h);
    }

    public a(InputStream inputStream) {
        this(inputStream, 0);
    }

    public a(InputStream inputStream, int i) throws IOException {
        boolean z = true;
        Object obj;
        boolean z2;
        super();
        d.l.a.a.d[][] arr = a.V;
        this.f = new HashMap[arr.length];
        this.g = new HashSet(arr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        String str2 = null;
        this.a = str2;
        z = true;
        i = i == z ? z : 0;
        if (i != 0) {
            length = a.c0.length;
            BufferedInputStream i22 = new BufferedInputStream(inputStream, length);
            if (!a.r(i22)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.e = z;
            this.c = str2;
            this.b = str2;
        } else {
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.c = (AssetManager.AssetInputStream)inputStream;
                this.b = str2;
            } else {
                z2 = inputStream instanceof FileInputStream;
                if (inputStream instanceof FileInputStream) {
                    Object inputStream2 = inputStream;
                    if (a.y(inputStream2.getFD())) {
                        this.c = str2;
                        this.b = inputStream2.getFD();
                    } else {
                        this.c = str2;
                        this.b = str2;
                    }
                }
            }
        }
        C(obj);
    }

    private static boolean L(int i) {
        int i2 = 4;
        return false;
    }
}
