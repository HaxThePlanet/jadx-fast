package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.UIntArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.ExperimentalSerializationApi;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0010¢\u0006\u0002\u0008\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0010¢\u0006\u0004\u0008\u0017\u0010\u0018R\u0010\u0010\u0006\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t@RX\u0090\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0019", d2 = {"Lkotlinx/serialization/internal/UIntArrayBuilder;", "Lkotlinx/serialization/internal/PrimitiveArrayBuilder;", "Lkotlin/UIntArray;", "bufferWithData", "<init>", "([ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "buffer", "[I", "value", "", "position", "getPosition$kotlinx_serialization_core", "()I", "ensureCapacity", "", "requiredCapacity", "ensureCapacity$kotlinx_serialization_core", "append", "c", "Lkotlin/UInt;", "append-WZ4Q5Ns$kotlinx_serialization_core", "(I)V", "build", "build--hP7Qyg$kotlinx_serialization_core", "()[I", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@ExperimentalSerializationApi
public final class UIntArrayBuilder extends kotlinx.serialization.internal.PrimitiveArrayBuilder<UIntArray> {

    private int[] buffer;
    private int position;
    private UIntArrayBuilder(int[] bufferWithData) {
        Intrinsics.checkNotNullParameter(bufferWithData, "bufferWithData");
        super();
        this.buffer = bufferWithData;
        this.position = UIntArray.getSize-impl(bufferWithData);
        ensureCapacity$kotlinx_serialization_core(10);
    }

    public UIntArrayBuilder(int[] iArr, DefaultConstructorMarker defaultConstructorMarker2) {
        super(iArr);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public final void append-WZ4Q5Ns$kotlinx_serialization_core(int c) {
        PrimitiveArrayBuilder.ensureCapacity$kotlinx_serialization_core$default((PrimitiveArrayBuilder)this, 0, 1, 0);
        int position$kotlinx_serialization_core = getPosition$kotlinx_serialization_core();
        this.position = position$kotlinx_serialization_core + 1;
        UIntArray.set-VXSXFK8(this.buffer, position$kotlinx_serialization_core, c);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public Object build$kotlinx_serialization_core() {
        return UIntArray.box-impl(build--hP7Qyg$kotlinx_serialization_core());
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int[] build--hP7Qyg$kotlinx_serialization_core() {
        int[] copyOf = Arrays.copyOf(this.buffer, getPosition$kotlinx_serialization_core());
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return UIntArray.constructor-impl(copyOf);
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public void ensureCapacity$kotlinx_serialization_core(int requiredCapacity) {
        int constructor-impl;
        String str;
        if (UIntArray.getSize-impl(this.buffer) < requiredCapacity) {
            int[] copyOf = Arrays.copyOf(this.buffer, RangesKt.coerceAtLeast(requiredCapacity, size-impl *= 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
            this.buffer = UIntArray.constructor-impl(copyOf);
        }
    }

    @Override // kotlinx.serialization.internal.PrimitiveArrayBuilder
    public int getPosition$kotlinx_serialization_core() {
        return this.position;
    }
}
