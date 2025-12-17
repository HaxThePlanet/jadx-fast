package f.c.a.b.i;

import f.c.a.b.b;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i {

    private final b a;
    private final byte[] b;
    public i(b b, byte[] b2Arr2) {
        super();
        Objects.requireNonNull(b, "encoding is null");
        Objects.requireNonNull(b2Arr2, "bytes is null");
        this.a = b;
        this.b = b2Arr2;
    }

    public byte[] a() {
        return this.b;
    }

    public b b() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (!object instanceof i) {
            return i;
        }
        if (!this.a.equals(object.a)) {
            return i;
        }
        return Arrays.equals(this.b, object.b);
    }

    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EncodedPayload{encoding=");
        stringBuilder.append(this.a);
        stringBuilder.append(", bytes=[...]}");
        return stringBuilder.toString();
    }
}
