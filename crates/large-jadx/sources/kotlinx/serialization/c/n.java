package kotlinx.serialization.c;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.a;
import kotlinx.serialization.descriptors.c;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000f\u001a\u00020\u0010H\u0002J\u0016\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0008H\u0016J\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0008H\u0016J\u0010\u0010\u0016\u001a\u00020\u00082\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0008H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0008H\u0016J\u0008\u0010\u001b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001c", d2 = {"Lkotlinx/serialization/internal/PrimitiveSerialDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialName", "", "kind", "Lkotlinx/serialization/descriptors/PrimitiveKind;", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/PrimitiveKind;)V", "elementsCount", "", "getElementsCount", "()I", "getKind", "()Lkotlinx/serialization/descriptors/PrimitiveKind;", "getSerialName", "()Ljava/lang/String;", "error", "", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "toString", "kotlinx-serialization-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n implements SerialDescriptor {

    private final String a;
    private final a b;
    public n(String string, a a2) {
        n.f(string, "serialName");
        n.f(a2, "kind");
        super();
        this.a = string;
        this.b = a2;
    }

    private final Void e() {
        IllegalStateException illegalStateException = new IllegalStateException("Primitive descriptor does not have elements");
        throw illegalStateException;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String a() {
        return this.a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int b() {
        return 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String c(int i) {
        e();
        throw 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor d(int i) {
        e();
        throw 0;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public c f() {
        return g();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public a g() {
        return this.b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PrimitiveDescriptor(");
        stringBuilder.append(a());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
