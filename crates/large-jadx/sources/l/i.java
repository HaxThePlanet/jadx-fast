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

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\u0006\n\u0002\u0010\u0012\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0008\u0018\u0008\u0016\u0018\u0000 12\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\u0008\u0000\u0012\u0006\u0010=\u001a\u00020\"¢\u0006\u0004\u0008L\u0010MJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u000f\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\u0008\u0012\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\u0008\u0013\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000cH\u0010¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u0017\u0010\u000eJ\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\u0008\u0018\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0010¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0019H\u0087\u0002¢\u0006\u0004\u0008\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\u0019H\u0010¢\u0006\u0004\u0008 \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\u0008#\u0010$J\u000f\u0010%\u001a\u00020\"H\u0010¢\u0006\u0004\u0008%\u0010$J'\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0010¢\u0006\u0004\u0008*\u0010+J/\u0010/\u001a\u00020.2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0016¢\u0006\u0004\u0008/\u00100J/\u00101\u001a\u00020.2\u0006\u0010(\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u0019H\u0016¢\u0006\u0004\u00081\u00102J\u0015\u00104\u001a\u00020.2\u0006\u00103\u001a\u00020\u0000¢\u0006\u0004\u00084\u00105J\u001a\u00107\u001a\u00020.2\u0008\u0010,\u001a\u0004\u0018\u000106H\u0096\u0002¢\u0006\u0004\u00087\u00108J\u000f\u00109\u001a\u00020\u0019H\u0016¢\u0006\u0004\u00089\u0010!J\u0018\u0010:\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\u0008:\u0010;J\u000f\u0010<\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008<\u0010\u000eR\u001c\u0010=\u001a\u00020\"8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008=\u0010>\u001a\u0004\u0008?\u0010$R\u0013\u0010A\u001a\u00020\u00198G@\u0006¢\u0006\u0006\u001a\u0004\u0008@\u0010!R$\u0010G\u001a\u0004\u0018\u00010\u000c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008B\u0010C\u001a\u0004\u0008D\u0010\u000e\"\u0004\u0008E\u0010FR\"\u00109\u001a\u00020\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u0010H\u001a\u0004\u0008I\u0010!\"\u0004\u0008J\u0010K¨\u0006N", d2 = {"Ll/i;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "Lkotlin/w;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "E", "()Ljava/lang/String;", "a", "s", "()Ll/i;", "y", "z", "algorithm", "f", "(Ljava/lang/String;)Ll/i;", "p", "C", "", "pos", "", "r", "(I)B", "index", "j", "n", "()I", "", "D", "()[B", "q", "Ll/f;", "buffer", "offset", "byteCount", "F", "(Ll/f;II)V", "other", "otherOffset", "", "u", "(ILl/i;II)Z", "v", "(I[BII)Z", "prefix", "B", "(Ll/i;)Z", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "c", "(Ll/i;)I", "toString", "data", "[B", "k", "A", "size", "b", "Ljava/lang/String;", "o", "x", "(Ljava/lang/String;)V", "utf8", "I", "m", "w", "(I)V", "<init>", "([B)V", "okio"}, k = 1, mv = {1, 4, 1})
public class i implements Serializable, Comparable<l.i> {

    public static final l.i c = null;
    private static final long serialVersionUID = 1L;
    public static final l.i.a v;
    private transient int a;
    private transient String b;
    private final byte[] data;

    public static final class a {
        public a(g g) {
            super();
        }

        public static l.i g(l.i.a i$a, byte[] b2Arr2, int i3, int i4, int i5, Object object6) {
            int obj2;
            int obj3;
            if (i5 & 1 != 0) {
                obj2 = 0;
            }
            if (i5 &= 2 != 0) {
                obj3 = b2Arr2.length;
            }
            return a.f(b2Arr2, obj2, obj3);
        }

        public final l.i a(String string) {
            l.i iVar;
            n.f(string, "$this$decodeBase64");
            final byte[] obj2 = a.a(string);
            if (obj2 != null) {
                iVar = new i(obj2);
            } else {
                iVar = 0;
            }
            return iVar;
        }

        public final l.i b(String string) {
            int i;
            int i2;
            byte b;
            int i3;
            n.f(string, "$this$decodeHex");
            final int i6 = 1;
            i = length %= 2 == 0 ? i6 : i2;
            if (i == 0) {
            } else {
                length2 /= 2;
                final byte[] bArr = new byte[i5];
                while (i2 < i5) {
                    int i7 = i2 * 2;
                    bArr[i2] = (byte)i3;
                    i2++;
                }
                i obj7 = new i(bArr);
                return obj7;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected hex string: ");
            stringBuilder.append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException;
        }

        public final l.i c(String string, Charset charset2) {
            n.f(string, "$this$encode");
            n.f(charset2, "charset");
            final byte[] obj2 = string.getBytes(charset2);
            n.e(obj2, "(this as java.lang.String).getBytes(charset)");
            i iVar = new i(obj2);
            return iVar;
        }

        public final l.i d(String string) {
            n.f(string, "$this$encodeUtf8");
            i iVar = new i(b.a(string));
            iVar.x(string);
            return iVar;
        }

        public final l.i e(byte... bArr) {
            n.f(bArr, "data");
            final byte[] obj3 = Arrays.copyOf(bArr, bArr.length);
            n.e(obj3, "java.util.Arrays.copyOf(this, size)");
            i iVar = new i(obj3);
            return iVar;
        }

        public final l.i f(byte[] bArr, int i2, int i3) {
            n.f(bArr, "$this$toByteString");
            c.b((long)length, obj2, (long)i2);
            i iVar = new i(i.i(bArr, i2, i3 += i2));
            return iVar;
        }

        public final l.i h(InputStream inputStream, int i2) {
            int i;
            int i3;
            int read;
            int i4;
            n.f(inputStream, "$this$readByteString");
            i3 = i2 >= 0 ? 1 : i;
            if (i3 == 0) {
            } else {
                byte[] bArr = new byte[i2];
                while (i < i2) {
                    read = inputStream.read(bArr, i, i2 - i);
                    i += read;
                }
                i obj5 = new i(bArr);
                return obj5;
            }
            obj5 = new StringBuilder();
            obj5.append("byteCount < 0: ");
            obj5.append(i2);
            IllegalArgumentException obj6 = new IllegalArgumentException(obj5.toString().toString());
            throw obj6;
        }
    }
    static {
        i.a aVar = new i.a(0);
        i.v = aVar;
        i iVar = new i(new byte[0]);
        i.c = iVar;
    }

    public i(byte[] bArr) {
        n.f(bArr, "data");
        super();
        this.data = bArr;
    }

    public static final l.i e(String string) {
        return i.v.b(string);
    }

    public static final l.i i(String string) {
        return i.v.d(string);
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        Field declaredField = i.class.getDeclaredField("data");
        n.e(declaredField, "field");
        declaredField.setAccessible(true);
        declaredField.set(this, obj3.data);
    }

    public static final l.i t(byte... bArr) {
        return i.v.e(bArr);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(data.length);
        objectOutputStream.write(this.data);
    }

    @Override // java.io.Serializable
    public final int A() {
        return n();
    }

    @Override // java.io.Serializable
    public final boolean B(l.i i) {
        n.f(i, "prefix");
        final int i3 = 0;
        return u(i3, i, i3, i.A());
    }

    @Override // java.io.Serializable
    public l.i C() {
        int i2;
        l.i iVar;
        byte b3;
        int length;
        byte b;
        byte b2;
        byte[] copyOf;
        int i;
        i2 = 0;
        for (byte b3 : obj1) {
            b = (byte)i5;
            b2 = (byte)i6;
        }
        iVar = this;
        return iVar;
    }

    @Override // java.io.Serializable
    public byte[] D() {
        byte[] bArr = k();
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        n.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @Override // java.io.Serializable
    public String E() {
        String str;
        if (o() == null) {
            x(b.b(q()));
        }
        return str;
    }

    @Override // java.io.Serializable
    public void F(l.f f, int i2, int i3) {
        n.f(f, "buffer");
        b.d(this, f, i2, i3);
    }

    @Override // java.io.Serializable
    public String a() {
        final int i = 0;
        return a.c(k(), i, 1, i);
    }

    @Override // java.io.Serializable
    public int c(l.i i) {
        int i7;
        int i2;
        int i5;
        int i3;
        int i4;
        int i6;
        n.f(i, "other");
        int i8 = A();
        final int i9 = i.A();
        i2 = i7;
        while (i2 < Math.min(i8, i9)) {
            b &= 255;
            b2 &= 255;
            i2++;
        }
        if (i8 == i9) {
        } else {
            i7 = i8 < i9 ? i5 : i3;
        }
        return i7;
    }

    @Override // java.io.Serializable
    public int compareTo(Object object) {
        return c((i)object);
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int i;
        byte[] bArr;
        int length;
        boolean obj5;
        i = 1;
        final int i2 = 0;
        if (object == this) {
        } else {
            if (object instanceof i && (i)object.A() == bArr2.length && object.v(i2, k(), i2, bArr3.length)) {
                if ((i)object.A() == bArr2.length) {
                    if (object.v(i2, k(), i2, bArr3.length)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
        }
        return i;
    }

    @Override // java.io.Serializable
    public l.i f(String string) {
        n.f(string, "algorithm");
        MessageDigest obj4 = MessageDigest.getInstance(string);
        obj4.update(this.data, 0, A());
        obj4 = obj4.digest();
        n.e(obj4, "digestBytes");
        i iVar = new i(obj4);
        return iVar;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        int i;
        if (m() != 0) {
        } else {
            w(Arrays.hashCode(k()));
        }
        return i;
    }

    @Override // java.io.Serializable
    public final byte j(int i) {
        return r(i);
    }

    @Override // java.io.Serializable
    public final byte[] k() {
        return this.data;
    }

    @Override // java.io.Serializable
    public final int m() {
        return this.a;
    }

    @Override // java.io.Serializable
    public int n() {
        return bArr.length;
    }

    @Override // java.io.Serializable
    public final String o() {
        return this.b;
    }

    @Override // java.io.Serializable
    public String p() {
        int i3;
        int i4;
        char c;
        int i;
        char[] cArr;
        int i2;
        char[] cArr2 = new char[length *= 2];
        byte[] bArr2 = k();
        i4 = i3;
        while (i3 < bArr2.length) {
            byte b = bArr2[i3];
            i = i4 + 1;
            cArr2[i4] = b.f()[i7 &= 15];
            i4 = i + 1;
            cArr2[i] = b.f()[b &= 15];
            i3++;
        }
        String string = new String(cArr2);
        return string;
    }

    @Override // java.io.Serializable
    public byte[] q() {
        return k();
    }

    @Override // java.io.Serializable
    public byte r(int i) {
        return k()[i];
    }

    @Override // java.io.Serializable
    public final l.i s() {
        return f("MD5");
    }

    @Override // java.io.Serializable
    public String toString() {
        int i4;
        String string;
        int str9;
        l.i iVar;
        int i7;
        int str3;
        int length;
        String str;
        int i3;
        String str4;
        String str10;
        String str8;
        String str6;
        int i8;
        int i9;
        int i2;
        String str7;
        String str2;
        String str5;
        int i6;
        int i;
        int i5;
        i7 = 0;
        i4 = bArr.length == 0 ? str9 : i7;
        if (i4 != 0) {
            string = "[size=0]";
        } else {
            str3 = 64;
            int i10 = b.a(k(), str3);
            str = "…]";
            i3 = 93;
            str4 = "[size=";
            if (i10 == -1) {
                if (bArr3.length <= str3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("[hex=");
                    stringBuilder.append(p());
                    stringBuilder.append(i3);
                    string = stringBuilder.toString();
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str4);
                    stringBuilder2.append(bArr7.length);
                    stringBuilder2.append(" hex=");
                    if (str3 <= bArr8.length) {
                    } else {
                        str9 = i7;
                    }
                    if (str9 == null) {
                    } else {
                        if (str3 == bArr4.length) {
                            iVar = this;
                        } else {
                            iVar = new i(i.i(k(), i7, str3));
                        }
                        stringBuilder2.append(iVar.p());
                        stringBuilder2.append(str);
                        string = stringBuilder2.toString();
                    }
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("endIndex > length(");
                stringBuilder3.append(bArr5.length);
                stringBuilder3.append(')');
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder3.toString().toString());
                throw illegalArgumentException;
            }
            String str13 = E();
            Objects.requireNonNull(str13, "null cannot be cast to non-null type java.lang.String");
            String substring = str13.substring(i7, i10);
            n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            i8 = 0;
            i9 = 4;
            i2 = 0;
            i7 = l.G(l.G(l.G(substring, "\\", "\\\\", i8, i9, i2), "\n", "\\n", false, 4, 0), "\r", "\\r", i8, i9, i2);
            if (i10 < str13.length()) {
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(str4);
                stringBuilder4.append(bArr6.length);
                stringBuilder4.append(" text=");
                stringBuilder4.append(i7);
                stringBuilder4.append(str);
                string = stringBuilder4.toString();
            } else {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append("[text=");
                stringBuilder5.append(i7);
                stringBuilder5.append(i3);
                string = stringBuilder5.toString();
            }
        }
        return string;
    }

    @Override // java.io.Serializable
    public boolean u(int i, l.i i2, int i3, int i4) {
        n.f(i2, "other");
        return i2.v(i3, k(), i, i4);
    }

    @Override // java.io.Serializable
    public boolean v(int i, byte[] b2Arr2, int i3, int i4) {
        String str;
        int obj2;
        n.f(b2Arr2, "other");
        if (i >= 0 && i <= length -= i4 && i3 >= 0 && i3 <= length2 -= i4 && c.a(k(), i, b2Arr2, i3, i4)) {
            if (i <= length -= i4) {
                if (i3 >= 0) {
                    if (i3 <= length2 -= i4) {
                        obj2 = c.a(k(), i, b2Arr2, i3, i4) ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // java.io.Serializable
    public final void w(int i) {
        this.a = i;
    }

    @Override // java.io.Serializable
    public final void x(String string) {
        this.b = string;
    }

    @Override // java.io.Serializable
    public final l.i y() {
        return f("SHA-1");
    }

    @Override // java.io.Serializable
    public final l.i z() {
        return f("SHA-256");
    }
}
