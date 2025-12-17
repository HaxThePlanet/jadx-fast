package m.a.c.j;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0008\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\t\u001a\u00020\u00002\u000c\u0008\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0008\u0010\u0010\u001a\u00020\u0003H\u0016R\u0018\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0011", d2 = {"Lorg/koin/core/qualifier/StringQualifier;", "Lorg/koin/core/qualifier/Qualifier;", "value", "", "Lorg/koin/core/qualifier/QualifierValue;", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c implements m.a.c.j.a {

    private final String a;
    public c(String string) {
        n.f(string, "value");
        super();
        this.a = string;
    }

    @Override // m.a.c.j.a
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof c) {
            return i2;
        }
        if (!n.b(getValue(), (c)object.getValue())) {
            return i2;
        }
        return i;
    }

    @Override // m.a.c.j.a
    public String getValue() {
        return this.a;
    }

    @Override // m.a.c.j.a
    public int hashCode() {
        return getValue().hashCode();
    }

    @Override // m.a.c.j.a
    public String toString() {
        return getValue();
    }
}
