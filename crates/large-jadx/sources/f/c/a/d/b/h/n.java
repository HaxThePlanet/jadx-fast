package f.c.a.d.b.h;

import java.lang.annotation.Annotation;

/* loaded from: classes2.dex */
final class n implements f.c.a.d.b.h.s {

    private final int a;
    private final f.c.a.d.b.h.r b;
    n(int i, f.c.a.d.b.h.r r2) {
        super();
        this.a = i;
        this.b = r2;
    }

    public final Class<? extends Annotation> annotationType() {
        return s.class;
    }

    @Override // f.c.a.d.b.h.s
    public final boolean equals(Object object) {
        int i;
        Object obj5;
        final int i2 = 1;
        if (this == object) {
            return i2;
        }
        final int i3 = 0;
        if (!object instanceof s) {
            return i3;
        }
        if (this.a == (s)object.zza() && this.b.equals(object.zzb())) {
            if (this.b.equals(object.zzb())) {
                return i2;
            }
        }
        return i3;
    }

    @Override // f.c.a.d.b.h.s
    public final int hashCode() {
        return i2 += i6;
    }

    @Override // f.c.a.d.b.h.s
    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("@com.google.firebase.encoders.proto.Protobuf");
        stringBuilder.append("(tag=");
        stringBuilder.append(this.a);
        stringBuilder.append("intEncoding=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // f.c.a.d.b.h.s
    public final int zza() {
        return this.a;
    }

    @Override // f.c.a.d.b.h.s
    public final f.c.a.d.b.h.r zzb() {
        return this.b;
    }
}
