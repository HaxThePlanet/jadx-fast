package f.c.a.b.i;

import f.c.a.b.b;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: EncodedPayload.java */
/* loaded from: classes.dex */
public final class i {

    private final b a;
    private final byte[] b;
    public i(b bVar, byte[] bArr) {
        super();
        Objects.requireNonNull(bVar, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.a = bVar;
        this.b = bArr;
    }

    public byte[] a() {
        return this.b;
    }

    public b b() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (!(object instanceof i)) {
            return false;
        }
        if (!this.a.equals(object.a)) {
            return false;
        }
        return Arrays.equals(this.b, object.b);
    }

    public int hashCode() {
        int i5 = 1000003;
        return (this.a.hashCode() ^ i5) * i5 ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "EncodedPayload{encoding=";
        String str3 = ", bytes=[...]}";
        str = str2 + this.a + str3;
        return str;
    }
}
