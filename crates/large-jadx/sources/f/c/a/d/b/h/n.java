package f.c.a.d.b.h;

import java.lang.annotation.Annotation;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
final class n implements s {

    private final int a;
    private final r b;
    @Override // java.lang.Object
    public final boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z3 = false;
        if (!(object instanceof s)) {
            return false;
        }
        if (this.a == object.zza()) {
            return this.b.equals(object.zzb()) ? z : z3;
        }
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return (this.a ^ 14552422) + (this.b.hashCode() ^ 2041407134);
    }

    @Override // java.lang.Object
    public final String toString() {
        String str2 = "@com.google.firebase.encoders.proto.Protobuf";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = "(tag=";
        String str4 = "intEncoding=";
        str = str2 + str3 + this.a + str4 + this.b + 41;
        return str;
    }

    n(int i, r rVar) {
        super();
        this.a = i;
        this.b = rVar;
    }

    public final Class<? extends Annotation> annotationType() {
        return s.class;
    }

    public final int zza() {
        return this.a;
    }

    public final r zzb() {
        return this.b;
    }
}
