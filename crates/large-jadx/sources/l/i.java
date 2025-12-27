package l;

import java.io.EOFException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.i;
import l.g0.b;

/* compiled from: ByteString.kt */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\u0006\n\u0002\u0010\u0012\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0008\u0018\u0008\u0016\u0018\u0000 12\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\u0008\u0000\u0012\u0006\u0010=\u001a\u00020\"¢\u0006\u0004\u0008L\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\u0008\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\u0008\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000cH\u0010¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\u0008\u0018\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0010¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0019H\u0087\u0002¢\u0006\u0004\u0008\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u0019H\u0010¢\u0006\u0004\u0008 \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\u0008#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0010¢\u0006\u0004\u0008%\u0010$J'\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0010¢\u0006\u0004\u0008*\u0010+J/\u0010/\u001a\u00020.2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0016¢\u0006\u0004\u0008/\u00100J/\u00101\u001a\u00020.2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0016¢\u0006\u0004\u00081\u00102J\u0015\u00104\u001a\u00020.2\u0006\u00103\u001a\u00020\u0000¢\u0006\u0004\u00084\u00105J\u001a\u00107\u001a\u00020.2\u0008\u0010,\u001a\u0004\u0018\u000106H\u0096\u0002¢\u0006\u0004\u00087\u00108J\u000f\u00109\u001a\u00020\u0019H\u0016¢\u0006\u0004\u00089\u0010!J\u0018\u0010:\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\u0008:\u0010;J\u000f\u0010<\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008<\u0010\u000eR\u001c\u0010=\u001a\u00020\"8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008=\u0010>\u001a\u0004\u0008?\u0010$R\u0013\u0010A\u001a\u00020\u00198G@\u0006¢\u0006\u0006\u001a\u0004\u0008@\u0010!R$\u0010G\u001a\u0004\u0018\u00010\u000c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008B\u0010C\u001a\u0004\u0008D\u0010\u000e\"\u0004\u0008E\u0010FR\"\u00109\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u0010H\u001a\u0004\u0008I\u0010!\"\u0004\u0008J\u0010K¨\u0006N", d2 = {"Ll/i;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "Lkotlin/w;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "E", "()Ljava/lang/String;", "a", "s", "()Ll/i;", "y", "z", "algorithm", "f", "(Ljava/lang/String;)Ll/i;", "p", "C", "", "pos", "", "r", "(I)B", "index", "j", "n", "()I", "", "D", "()[B", "q", "Ll/f;", "buffer", "offset", "byteCount", "F", "(Ll/f;II)V", "other", "otherOffset", "", "u", "(ILl/i;II)Z", "v", "(I[BII)Z", "prefix", "B", "(Ll/i;)Z", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "c", "(Ll/i;)I", "toString", "data", "[B", "k", "A", "size", "b", "Ljava/lang/String;", "o", "x", "(Ljava/lang/String;)V", "utf8", "I", "m", "w", "(I)V", "<init>", "([B)V", "okio"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public class i implements Serializable, Comparable<i> {

    public static final i c = null;
    private static final long serialVersionUID = 1L;
    /* renamed from: v, reason: from kotlin metadata */
    public static final i.a INSTANCE = new i$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private transient int hashCode;
    /* renamed from: b, reason: from kotlin metadata */
    private transient String utf8;
    private final byte[] data;

    public static final class a {
        private a() {
            super();
        }

        public final i a(String str) {
            l.i iVar = null;
            n.f(str, "$this$decodeBase64");
            final byte[] bArr = a.a(str);
            i r0 = bArr != null ? new i(bArr) : 0;
            return (bArr != null ? new i(bArr) : 0);
        }

        public final i b(String str) {
            int i;
            n.f(str, "$this$decodeHex");
            i = 0;
            i = 1;
            int r0 = str.length() % 2 == 0 ? i : 0;
            if (i == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Unexpected hex string: ";
                str4 = str3 + str;
                throw new IllegalArgumentException(str4.toString());
            } else {
                int i4 = str.length() / 2;
                final byte[] bArr = new byte[i4];
                while (i < i4) {
                    int i5 = i * 2;
                    i2 = (b.e(str.charAt(i5)) << 4) + (b.e(str.charAt(i5 + i)));
                    b = (byte)i2;
                    bArr[i] = b;
                    i = i + 1;
                }
                return new i(bArr);
            }
        }

        public final i c(String str, Charset charset) throws java.io.UnsupportedEncodingException {
            n.f(str, "$this$encode");
            n.f(charset, "charset");
            final byte[] bytes = str.getBytes(charset);
            n.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return new i(bytes);
        }

        public final i d(String str) {
            n.f(str, "$this$encodeUtf8");
            l.i iVar = new i(b.a(str));
            iVar.x(str);
            return iVar;
        }

        public final i e(byte... bArr) {
            n.f(bArr, "data");
            final byte[] copy = Arrays.copyOf(bArr, bArr.length);
            n.e(copy, "java.util.Arrays.copyOf(this, size)");
            return new i(copy);
        }

        public final i f(byte[] bArr, int i, int i2) {
            n.f(bArr, "$this$toByteString");
            c.b((long)bArr.length, (long)i, (long)i2);
            return new i(l.i(bArr, i, i2 + i));
        }

        public final i h(InputStream inputStream, int i) throws java.io.IOException, EOFException {
            n.f(inputStream, "$this$readByteString");
            i = 0;
            int r1 = i >= 0 ? 1 : 0;
            if (i == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String str2 = "byteCount < 0: ";
                str3 = str2 + i;
                throw new IllegalArgumentException(str3.toString());
            } else {
                byte[] bArr = new byte[i];
                while (i < i) {
                    int bytesRead = inputStream.read(bArr, i, i - i);
                    int i3 = -1;
                    if (bytesRead == -1) {
                        throw new EOFException();
                    }
                }
                return new i(bArr);
            }
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public static /* synthetic */ i g(i.a aVar, byte[] bArr, int i, int i2, int i3, Object object) {
            int length;
            if (i3 & 1 != 0) {
                i = 0;
            }
            if (i3 & 2 != 0) {
                length = bArr.length;
            }
            return aVar.f(bArr, i, length);
        }
    }
    static {
        i.c = new i(new byte[0]);
    }

    public i(byte[] bArr) {
        n.f(bArr, "data");
        super();
        this.data = bArr;
    }

    private final void readObject(ObjectInputStream objectInputStream) throws java.lang.NoSuchFieldException, java.lang.IllegalAccessException, java.io.IOException {
        Field declaredField = i.class.getDeclaredField("data");
        n.e(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, i.INSTANCE.h(objectInputStream, objectInputStream.readInt()).data);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* renamed from: A, reason: from kotlin metadata */
    public final int E() {
        return n();
    }

    /* renamed from: B, reason: from kotlin metadata */
    public final boolean r(i pos) {
        n.f(pos, "prefix");
        final int i2 = 0;
        return u(i2, pos, i2, pos.E());
    }

    public i C() {
        int i = 0;
        l.i iVar;
        byte b2;
        byte b3;
        int i2;
        i = 0;
        length = k().length;
        for (byte b : bArr) {
            b2 = (byte)65;
            if (b >= b2) {
                b3 = (byte)90;
            }
        }
        iVar = this;
        return iVar;
    }

    public byte[] D() {
        byte[] bArr = k();
        byte[] copy = Arrays.copyOf(bArr, bArr.length);
        n.e(copy, "java.util.Arrays.copyOf(this, size)");
        return copy;
    }

    public String E() {
        String str;
        if (o() == null) {
            x(b.b(q()));
        }
        return str;
    }

    public void F(f buffer, int offset, int byteCount) {
        n.f(buffer, "buffer");
        b.d(this, buffer, offset, byteCount);
    }

    public String a() {
        final byte[] bArr2 = null;
        return a.c(k(), bArr2, 1, bArr2);
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* operator */ public int j(i index) {
        int i = 0;
        int i2;
        int i3;
        n.f(index, "other");
        int i4 = E();
        final int i5 = index.E();
        i = 0;
        i = -1;
        i = 1;
        while (i < Math.min(i4, i5)) {
            i2 = j(i) & 255;
            i3 = index.j(i) & 255;
            if (i2 != i3) {
            }
        }
        if (i4 != i5) {
            int r3 = i4 < i5 ? -1 : 1;
        }
        return (i4 < i5 ? -1 : 1);
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        boolean z3 = true;
        boolean z;
        int length;
        boolean z2;
        int i2 = 1;
        final int i = 0;
        if (other != this) {
            z = other instanceof i;
            if (other instanceof i) {
                length = k().length;
                if (other.E() == this.k().length) {
                    length = k().length;
                    if (!(other.v(i, k(), i, length))) {
                    }
                }
            }
        }
        return z3;
    }

    public i f(String str) throws java.security.NoSuchAlgorithmException, java.security.DigestException {
        n.f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.data, 0, E());
        byte[] digest = messageDigest.digest();
        n.e(digest, "digestBytes");
        return new i(digest);
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        if (m() == 0) {
            w(Arrays.hashCode(k()));
        }
        return i;
    }

    public final byte j(int i) {
        return r(i);
    }

    public final byte[] k() {
        return this.data;
    }

    public final int m() {
        return this.hashCode;
    }

    public int n() {
        return k().length;
    }

    public final String o() {
        return this.utf8;
    }

    public String p() throws java.io.UnsupportedEncodingException {
        int i = 0;
        char[] cArr2 = new char[k().length * 2];
        byte[] bArr2 = k();
        i = 0;
        for (byte b : bArr2) {
            i2 = i + 1;
            i3 = (b >> 4) & 15;
            cArr2[i] = b.f()[i3];
            i = i2 + 1;
            cArr2[i2] = b.f()[b & 15];
        }
        return new String(cArr2);
    }

    public byte[] q() {
        return k();
    }

    public byte r(int i) {
        return k()[i];
    }

    public final i s() {
        return f("MD5");
    }

    @Override // java.lang.Object
    public String toString() {
        int i;
        String str;
        l.i iVar;
        byte[] bArr = null;
        byte[] bArr2;
        i = 1;
        i = 0;
        int r0 = k().length == 0 ? 1 : i;
        if (i == 0) {
            int i2 = 64;
            int i6 = b.c(k(), i2);
            int i3 = -1;
            str2 = "…]";
            char c = ']';
            str3 = "[size=";
            if (i6 == -1) {
                if (k().length <= i2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str11 = "[hex=";
                    String str12 = p();
                    str = str11 + str12 + c;
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str3);
                    stringBuilder2.append(k().length);
                    stringBuilder2.append(" hex=");
                    if (i2 > k().length) {
                    }
                    if (i != 0) {
                        if (i2 == k().length) {
                            iVar = this;
                        } else {
                            iVar = new i(l.i(k(), i, i2));
                        }
                        stringBuilder2.append(iVar.p());
                        stringBuilder2.append(str2);
                        str = stringBuilder2.toString();
                    }
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                String str14 = "endIndex > length(";
                int length4 = k().length;
                str10 = str14 + length4 + 41;
                throw new IllegalArgumentException(str10.toString());
            }
            String str15 = E();
            Objects.requireNonNull(str15, "null cannot be cast to non-null type java.lang.String");
            String substring = str15.substring(i, i6);
            n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            boolean z = false;
            int i4 = 4;
            Object obj = null;
            boolean z2 = false;
            int i5 = 4;
            Object obj2 = null;
            str8 = "\n";
            str9 = "\\n";
            str5 = "\r";
            str6 = "\\r";
            String str19 = u.G(u.G(u.G(substring, "\\", "\\\\", z, i4, obj), str8, str9, z2, i5, obj2), str5, str6, z, i4, obj);
            if (i6 < str15.length()) {
                StringBuilder stringBuilder4 = new StringBuilder();
                int length6 = k().length;
                String str16 = " text=";
                str = str3 + length6 + str16 + str19 + str2;
            } else {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str17 = "[text=";
                str = str17 + str19 + c;
            }
        } else {
            str = "[size=0]";
        }
        return str;
    }

    public boolean u(int offset, i other, int otherOffset, int byteCount) {
        n.f(other, "other");
        return other.v(otherOffset, k(), offset, byteCount);
    }

    public boolean v(int offset, byte[] other, int otherOffset, int byteCount) {
        String str;
        boolean z2 = false;
        str = "other";
        n.f(other, str);
        if (offset >= 0) {
            if (offset <= k().length - byteCount && otherOffset >= 0) {
                if (otherOffset <= other.length - byteCount) {
                    offset = c.a(k(), offset, other, otherOffset, byteCount) ? 1 : 0;
                }
            }
        }
        return (c.a(k(), offset, other, otherOffset, byteCount) ? 1 : 0);
    }

    public final void w(int i) {
        this.hashCode = i;
    }

    public final void x(String str) {
        this.utf8 = str;
    }

    public final i y() {
        return f("SHA-1");
    }

    public final i z() {
        return f("SHA-256");
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final i readObject(String in) {
        return i.INSTANCE.b(in);
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final i writeObject(String out) {
        return i.INSTANCE.d(out);
    }

    /* renamed from: t, reason: from kotlin metadata */
    public static final i f(byte... algorithm) {
        return i.INSTANCE.e(algorithm);
    }
}
