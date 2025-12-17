package l;

import java.security.MessageDigest;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.i;
import l.g0.c;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\u0004\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u0015\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u0001B\u001f\u0008\u0000\u0012\u000c\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00160-\u0012\u0006\u00108\u001a\u000203¢\u0006\u0004\u00089\u0010:J\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0001H\u0016¢\u0006\u0004\u0008\u000b\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\u0007H\u0010¢\u0006\u0004\u0008\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0010¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J'\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0010¢\u0006\u0004\u0008\u001e\u0010\u001fJ/\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008#\u0010$J/\u0010%\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008%\u0010&J\u000f\u0010'\u001a\u00020\u0016H\u0010¢\u0006\u0004\u0008'\u0010\u0018J\u001a\u0010)\u001a\u00020\"2\u0008\u0010 \u001a\u0004\u0018\u00010(H\u0096\u0002¢\u0006\u0004\u0008)\u0010*J\u000f\u0010+\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008+\u0010\u0015J\u000f\u0010,\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008,\u0010\tR\"\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00160-8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008.\u0010/\u001a\u0004\u00080\u00101R\u001c\u00108\u001a\u0002038\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u00084\u00105\u001a\u0004\u00086\u00107¨\u0006;", d2 = {"Ll/a0;", "Ll/i;", "I", "()Ll/i;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "", "a", "()Ljava/lang/String;", "p", "C", "algorithm", "f", "(Ljava/lang/String;)Ll/i;", "", "pos", "", "r", "(I)B", "n", "()I", "", "D", "()[B", "Ll/f;", "buffer", "offset", "byteCount", "Lkotlin/w;", "F", "(Ll/f;II)V", "other", "otherOffset", "", "u", "(ILl/i;II)Z", "v", "(I[BII)Z", "q", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "", "w", "[[B", "H", "()[[B", "segments", "", "x", "[I", "G", "()[I", "directory", "<init>", "([[B[I)V", "okio"}, k = 1, mv = {1, 4, 1})
public final class a0 extends l.i {

    private final transient byte[][] w;
    private final transient int[] x;
    public a0(byte[][] bArrArr, int[] i2Arr2) {
        n.f(bArrArr, "segments");
        n.f(i2Arr2, "directory");
        super(i.c.k());
        this.w = bArrArr;
        this.x = i2Arr2;
    }

    private final l.i I() {
        i iVar = new i(D());
        return iVar;
    }

    private final Object writeReplace() {
        final l.i iVar = I();
        Objects.requireNonNull(iVar, "null cannot be cast to non-null type java.lang.Object");
        return iVar;
    }

    @Override // l.i
    public l.i C() {
        return I().C();
    }

    @Override // l.i
    public byte[] D() {
        int i4;
        int i6;
        int i5;
        int i;
        int i2;
        byte[] bArr;
        int i3;
        byte[] bArr2 = new byte[A()];
        int length = arr.length;
        i5 = i6;
        while (i4 < length) {
            i = G()[length + i4];
            i2 = G()[i4];
            int i8 = i2 - i6;
            i.e(H()[i4], bArr2, i5, i, i + i8);
            i5 += i8;
            i4++;
            i6 = i2;
        }
        return bArr2;
    }

    @Override // l.i
    public void F(l.f f, int i2, int i3) {
        int i8;
        l.y yVar;
        int i7;
        int i4;
        l.y yVar3;
        l.y yVar2;
        byte[] bArr;
        int i;
        int i6;
        int i5;
        int i9;
        int obj13;
        n.f(f, "buffer");
        int i10 = i2 + i3;
        i8 = c.b(this, i2);
        while (obj13 < i10) {
            if (i8 == 0) {
            } else {
            }
            i7 = G()[i8 + -1];
            i16 -= obj13;
            i = i17 + i12;
            super(H()[i8], i, i + i4, 1, 0);
            yVar3 = f.a;
            if (yVar3 == null) {
            } else {
            }
            n.d(yVar3);
            yVar3 = yVar3.g;
            n.d(yVar3);
            yVar3.c(yVar);
            obj13 += i4;
            i8++;
            yVar.g = yVar;
            yVar.f = yVar;
            f.a = yVar;
            i7 = 0;
        }
        f.T(size += obj13);
    }

    @Override // l.i
    public final int[] G() {
        return this.x;
    }

    @Override // l.i
    public final byte[][] H() {
        return this.w;
    }

    @Override // l.i
    public String a() {
        return I().a();
    }

    @Override // l.i
    public boolean equals(Object object) {
        int i2;
        int i;
        int i3;
        boolean obj5;
        i2 = 1;
        final int i4 = 0;
        if (object == this) {
        } else {
            if (object instanceof i && (i)object.A() == A() && u(i4, object, i4, A())) {
                if ((i)object.A() == A()) {
                    if (u(i4, object, i4, A())) {
                    } else {
                        i2 = i4;
                    }
                } else {
                }
            } else {
            }
        }
        return i2;
    }

    @Override // l.i
    public l.i f(String string) {
        int i4;
        int i2;
        int i;
        int i3;
        byte[] bArr;
        n.f(string, "algorithm");
        MessageDigest obj7 = MessageDigest.getInstance(string);
        int length = arr.length;
        i2 = i4;
        while (i4 < length) {
            i3 = G()[i4];
            obj7.update(H()[i4], G()[length + i4], i3 - i2);
            i4++;
            i2 = i3;
        }
        obj7 = obj7.digest();
        n.e(obj7, "digestBytes");
        i iVar = new i(obj7);
        return iVar;
    }

    @Override // l.i
    public int hashCode() {
        int i3;
        int i6;
        int i2;
        int i5;
        int i;
        int i4;
        byte[] bArr;
        byte b;
        if (m() != 0) {
        } else {
            int length = arr.length;
            i2 = 1;
            i5 = i6;
            while (i6 < length) {
                i4 = G()[i6];
                while (i < i8 += i) {
                    i7 += b;
                    i++;
                }
                i6++;
                i5 = i4;
                i7 += b;
                i++;
            }
            w(i2);
            i3 = i2;
        }
        return i3;
    }

    @Override // l.i
    public int n() {
        return G()[length--];
    }

    @Override // l.i
    public String p() {
        return I().p();
    }

    @Override // l.i
    public byte[] q() {
        return D();
    }

    @Override // l.i
    public byte r(int i) {
        int i2;
        long l;
        c.b((long)i3, obj2, (long)i);
        int i4 = c.b(this, i);
        if (i4 == 0) {
            i2 = 0;
        } else {
            i2 = G()[i4 + -1];
        }
        return H()[i4][obj8 += i6];
    }

    @Override // l.i
    public String toString() {
        return I().toString();
    }

    @Override // l.i
    public boolean u(int i, l.i i2, int i3, int i4) {
        int i8;
        int i7;
        boolean z;
        int i9;
        int i10;
        int i5;
        int i6;
        int obj7;
        int obj9;
        int obj10;
        n.f(i2, "other");
        if (i >= 0) {
            if (i > i11 -= i4) {
            } else {
                i4 += i;
                i7 = c.b(this, i);
                while (obj7 < obj10) {
                    if (i7 == 0) {
                    } else {
                    }
                    i9 = G()[i7 + -1];
                    i16 -= obj7;
                    obj9 += i10;
                    obj7 += i10;
                    i7++;
                    i9 = i8;
                }
                i8 = 1;
            }
        }
        return i8;
    }

    @Override // l.i
    public boolean v(int i, byte[] b2Arr2, int i3, int i4) {
        int i7;
        int i9;
        boolean z;
        int i2;
        int i6;
        int i5;
        int i8;
        int obj7;
        int obj9;
        int obj10;
        n.f(b2Arr2, "other");
        if (i >= 0 && i <= i10 -= i4 && i3 >= 0) {
            if (i <= i10 -= i4) {
                if (i3 >= 0) {
                    if (i3 > length -= i4) {
                    } else {
                        i4 += i;
                        i9 = c.b(this, i);
                        while (obj7 < obj10) {
                            if (i9 == 0) {
                            } else {
                            }
                            i2 = G()[i9 + -1];
                            i15 -= obj7;
                            obj9 += i6;
                            obj7 += i6;
                            i9++;
                            i2 = i7;
                        }
                        i7 = 1;
                    }
                }
            }
        }
        return i7;
    }
}
