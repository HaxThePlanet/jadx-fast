package l;

import java.security.MessageDigest;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.i;
import l.g0.c;

/* compiled from: SegmentedByteString.kt */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0005\n\u0002\u0008\u0004\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u0015\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u0001B\u001f\u0008\u0000\u0012\u000c\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00160-\u0012\u0006\u00108\u001a\u000203¢\u0006\u0004\u00089\u0010:J\u000f\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0001H\u0016¢\u0006\u0004\u0008\u000b\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00012\u0006\u0010\u000c\u001a\u00020\u0007H\u0010¢\u0006\u0004\u0008\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0010¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J'\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0010¢\u0006\u0004\u0008\u001e\u0010\u001fJ/\u0010#\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008#\u0010$J/\u0010%\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008%\u0010&J\u000f\u0010'\u001a\u00020\u0016H\u0010¢\u0006\u0004\u0008'\u0010\u0018J\u001a\u0010)\u001a\u00020\"2\u0008\u0010 \u001a\u0004\u0018\u00010(H\u0096\u0002¢\u0006\u0004\u0008)\u0010*J\u000f\u0010+\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008+\u0010\u0015J\u000f\u0010,\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008,\u0010\tR\"\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00160-8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008.\u0010/\u001a\u0004\u00080\u00101R\u001c\u00108\u001a\u0002038\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u00084\u00105\u001a\u0004\u00086\u00107¨\u0006;", d2 = {"Ll/a0;", "Ll/i;", "I", "()Ll/i;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "", "a", "()Ljava/lang/String;", "p", "C", "algorithm", "f", "(Ljava/lang/String;)Ll/i;", "", "pos", "", "r", "(I)B", "n", "()I", "", "D", "()[B", "Ll/f;", "buffer", "offset", "byteCount", "Lkotlin/w;", "F", "(Ll/f;II)V", "other", "otherOffset", "", "u", "(ILl/i;II)Z", "v", "(I[BII)Z", "q", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "", "w", "[[B", "H", "()[[B", "segments", "", "x", "[I", "G", "()[I", "directory", "<init>", "([[B[I)V", "okio"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class a0 extends i {

    /* renamed from: w, reason: from kotlin metadata */
    private final transient byte[][] segments;
    /* renamed from: x, reason: from kotlin metadata */
    private final transient int[] directory;
    public a0(byte[][] bArrArr, int[] iArr) {
        n.f(bArrArr, "segments");
        n.f(iArr, "directory");
        super(i.c.k());
        this.segments = bArrArr;
        this.directory = iArr;
    }

    private final i I() {
        return new i(D());
    }

    private final Object writeReplace() {
        final l.i iVar = I();
        Objects.requireNonNull(iVar, "null cannot be cast to non-null type java.lang.Object");
        return iVar;
    }

    @Override // l.i
    public i C() {
        return I().C();
    }

    @Override // l.i
    public byte[] D() {
        int i = 0;
        byte[] bArr2 = new byte[A()];
        int length = H().length;
        i = 0;
        while (i < length) {
            int i2 = G()[length + i];
            i = G()[i];
            int i5 = i - i;
            i3 = i2 + i5;
            l.e(H()[i], bArr2, i, i2, i3);
            i = i + i5;
            i = i + 1;
        }
        return bArr2;
    }

    @Override // l.i
    public void F(f buffer, int offset, int byteCount) {
        int i;
        int i2 = 0;
        int i3;
        l.y yVar2;
        int i6;
        n.f(buffer, "buffer");
        int i7 = offset + byteCount;
        i = c.b(this, offset);
        while (i6 < i7) {
            i3 = (Math.min(i7, (G()[i] - i2) + i2)) - i6;
            i4 = (G()[H().length + i]) + (i6 - i2);
            i5 = i4 + i3;
            boolean z = true;
            boolean z2 = false;
            y yVar = new y(H()[i], i4, i5, z, z2);
            i6 = i6 + i3;
            i = i + 1;
        }
        buffer.T(buffer.size() + (long)byteCount);
    }

    @Override // l.i
    public final int[] G() {
        return this.directory;
    }

    @Override // l.i
    public final byte[][] H() {
        return this.segments;
    }

    @Override // l.i
    public String a() {
        return I().a();
    }

    @Override // l.i
    /* operator */ public boolean equals(Object other) {
        boolean z3 = true;
        boolean z;
        int i3;
        boolean z2;
        int i4 = 1;
        final int i = 0;
        if (other != this) {
            z = other instanceof i;
            if (other instanceof i) {
                if (other.A() == A()) {
                    if (!(u(i, other, i, A()))) {
                    }
                }
            }
        }
        return z3;
    }

    @Override // l.i
    public i f(String algorithm) throws java.security.NoSuchAlgorithmException, java.security.DigestException {
        int i = 0;
        n.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = H().length;
        i = 0;
        while (i < length) {
            i = G()[i];
            messageDigest.update(H()[i], G()[length + i], i - i);
            i = i + 1;
        }
        byte[] digest = messageDigest.digest();
        n.e(digest, "digestBytes");
        return new i(digest);
    }

    @Override // l.i
    public int hashCode() {
        int i;
        int i2 = 0;
        int i3;
        byte[] bArr;
        byte b;
        if (m() == 0) {
            int length = H().length;
            i2 = 0;
            i = 1;
            while (i2 < length) {
                i2 = G()[i2];
                while (i3 < (i2 - i2) + (G()[length + i2])) {
                    i = (i * 31) + H()[i2][i3];
                    i3 = i3 + 1;
                }
                i2 = i2 + 1;
                i = (i * 31) + bArr[i3];
                i3 = i3 + 1;
            }
            w(i);
        }
        return i;
    }

    @Override // l.i
    public int n() {
        return G()[H().length - 1];
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
    public byte r(int pos) {
        int i = 0;
        c.b((long)(G()[H().length - 1]), (long)pos, 1L);
        int i4 = c.b(this, pos);
        if (i4 == 0) {
            i = 0;
        } else {
            i2 = i4 - 1;
            i = G()[i2];
        }
        return H()[i4][(pos - i) + (G()[H().length + i4])];
    }

    @Override // l.i
    public String toString() {
        return I().toString();
    }

    @Override // l.i
    public boolean u(int offset, i other, int otherOffset, int byteCount) {
        boolean z2 = false;
        int i2;
        boolean z;
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        n.f(other, "other");
        if (offset >= 0) {
            i2 = A() - byteCount;
            if (offset <= this.A() - byteCount) {
                i8 = byteCount + offset;
                i2 = c.b(this, offset);
                while (i6 < i8) {
                    i5 = H().length + i2;
                    i3 = (Math.min(i8, (G()[i2] - i) + i)) - i6;
                    i4 = G()[i5] + (i6 - i);
                    if (!other.v(i7, H()[i2], i4, i3)) {
                        break;
                    }
                }
                int i9 = 1;
            }
        }
        return z2;
    }

    @Override // l.i
    public boolean v(int offset, byte[] other, int otherOffset, int byteCount) {
        boolean z2 = false;
        int i2;
        boolean z;
        int i;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        n.f(other, "other");
        if (offset >= 0) {
            i2 = A() - byteCount;
            if (offset <= this.A() - byteCount && otherOffset >= 0) {
                i2 = other.length - byteCount;
                if (otherOffset <= other.length - byteCount) {
                    i8 = byteCount + offset;
                    i2 = c.b(this, offset);
                    while (i6 < i8) {
                        i5 = H().length + i2;
                        i3 = (Math.min(i8, (G()[i2] - i) + i)) - i6;
                        i4 = G()[i5] + (i6 - i);
                        if (!c.a(H()[i2], i4, other, i7, i3)) {
                            break;
                        }
                    }
                    int i9 = 1;
                }
            }
        }
        return z2;
    }
}
