package kotlinx.serialization.c;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.c;
import kotlinx.serialization.descriptors.d.b;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001B\u001f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0016\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u0008H\u0016J\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0008H\u0016J\u0010\u0010\u001d\u001a\u00020\u00082\u0006\u0010\u001e\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0008H\u0016J\u0008\u0010 \u001a\u00020\u0008H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0008H\u0016J\u0008\u0010\"\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\u0008X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000c\u0082\u0001\u0002#$¨\u0006%", d2 = {"Lkotlinx/serialization/internal/MapLikeDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "keyDescriptor", "valueDescriptor", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "elementsCount", "", "getElementsCount", "()I", "getKeyDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getSerialName", "()Ljava/lang/String;", "getValueDescriptor", "equals", "", "other", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "hashCode", "isElementOptional", "toString", "Lkotlinx/serialization/internal/LinkedHashMapClassDesc;", "Lkotlinx/serialization/internal/HashMapClassDesc;", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class g implements SerialDescriptor {

    private final String a;
    private final SerialDescriptor b;
    private final SerialDescriptor c;
    private final int d;
    private g(String string, SerialDescriptor serialDescriptor2, SerialDescriptor serialDescriptor3) {
        super();
        this.a = string;
        this.b = serialDescriptor2;
        this.c = serialDescriptor3;
        this.d = 2;
    }

    public g(String string, SerialDescriptor serialDescriptor2, SerialDescriptor serialDescriptor3, g g4) {
        super(string, serialDescriptor2, serialDescriptor3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String a() {
        return this.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int b() {
        return this.d;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String c(int i) {
        return String.valueOf(i);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor d(int i) {
        int i2;
        SerialDescriptor obj3;
        int i3 = 1;
        i2 = i >= 0 ? i3 : 0;
        if (i2 == 0) {
        } else {
            i %= 2;
            if (obj3 != null) {
                if (obj3 != i3) {
                } else {
                    obj3 = this.c;
                    return obj3;
                }
                obj3 = new IllegalStateException("Unreached".toString());
                throw obj3;
            }
            obj3 = this.b;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal index ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(a());
        stringBuilder.append(" expects only non-negative indices");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
        throw illegalArgumentException;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof g) {
            return i2;
        }
        if (!n.b(a(), (g)object.a())) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        return i;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public c f() {
        return d.b.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int hashCode() {
        return i4 += i7;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a());
        stringBuilder.append('(');
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
