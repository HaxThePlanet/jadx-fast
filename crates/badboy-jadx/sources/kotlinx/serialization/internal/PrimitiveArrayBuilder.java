package kotlinx.serialization.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0008!\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\t\u0008\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H ¢\u0006\u0002\u0008\u000cJ\u000f\u0010\r\u001a\u00028\u0000H ¢\u0006\u0004\u0008\u000e\u0010\u000fR\u0012\u0010\u0005\u001a\u00020\u0006X \u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0010", d2 = {"Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Array", "", "<init>", "()V", "position", "", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", "", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "build", "build$kotlinx_serialization_core", "()Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PrimitiveArrayBuilder<Array>  {
    public static void ensureCapacity$kotlinx_serialization_core$default(kotlinx.serialization.internal.PrimitiveArrayBuilder primitiveArrayBuilder, int i2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1++;
            }
            primitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
        throw obj0;
    }

    public abstract Array build$kotlinx_serialization_core();

    public abstract void ensureCapacity$kotlinx_serialization_core(int i);

    public abstract int getPosition$kotlinx_serialization_core();
}
