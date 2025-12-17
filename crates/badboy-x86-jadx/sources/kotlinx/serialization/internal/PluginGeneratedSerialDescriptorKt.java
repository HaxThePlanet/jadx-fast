package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\u001aN\u0010\u0000\u001a\u00020\u0001\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\u0008ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\u000c\u001a\u00020\r*\u00020\u00032\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000fH\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u0011", d2 = {"equalsImpl", "", "SD", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "other", "", "typeParamsAreEqual", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "otherDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "hashCodeImpl", "", "typeParams", "", "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PluginGeneratedSerialDescriptorKt {
    public static final <SD extends SerialDescriptor> boolean equalsImpl(SD $this$equalsImpl, Object other, Function1<? super SD, Boolean> typeParamsAreEqual) {
        int index;
        boolean equal;
        kotlinx.serialization.descriptors.SerialKind kind;
        Intrinsics.checkNotNullParameter($this$equalsImpl, "<this>");
        Intrinsics.checkNotNullParameter(typeParamsAreEqual, "typeParamsAreEqual");
        int i = 0;
        final int i2 = 1;
        if ($this$equalsImpl == other) {
            return i2;
        }
        Intrinsics.reifiedOperationMarker(3, "SD");
        int i4 = 0;
        if (!other instanceof SerialDescriptor) {
            return i4;
        }
        if (!Intrinsics.areEqual($this$equalsImpl.getSerialName(), (SerialDescriptor)other.getSerialName())) {
            return i4;
        }
        if (!(Boolean)typeParamsAreEqual.invoke(other).booleanValue()) {
            return i4;
        }
        if ($this$equalsImpl.getElementsCount() != (SerialDescriptor)other.getElementsCount()) {
            return i4;
        }
        index = 0;
        while (index < $this$equalsImpl.getElementsCount()) {
            index++;
        }
        return i2;
    }

    public static final int hashCodeImpl(SerialDescriptor $this$hashCodeImpl, SerialDescriptor[] typeParams) {
        int accumulator$iv$iv2;
        int accumulator$iv$iv;
        Object next;
        int i3;
        int next2;
        Object obj;
        int i;
        int i5;
        String it;
        int i2;
        int i4;
        final Object obj2 = $this$hashCodeImpl;
        Intrinsics.checkNotNullParameter(obj2, "<this>");
        final Object obj3 = typeParams;
        Intrinsics.checkNotNullParameter(obj3, "typeParams");
        Iterable elementDescriptors = SerialDescriptorKt.getElementDescriptors(obj2);
        int i13 = 0;
        int i17 = 0;
        accumulator$iv$iv2 = i15;
        Iterator iterator = elementDescriptors.iterator();
        while (iterator.hasNext()) {
            i = 0;
            i2 = 0;
            it = (SerialDescriptor)iterator.next().getSerialName();
            if (it != null) {
            }
            accumulator$iv$iv2 = i5;
            i3 = it.hashCode();
        }
        int i14 = 0;
        int i18 = 0;
        accumulator$iv$iv = i16;
        Iterator iterator2 = elementDescriptors.iterator();
        while (iterator2.hasNext()) {
            i5 = 0;
            i4 = 0;
            kotlinx.serialization.descriptors.SerialKind it2 = (SerialDescriptor)iterator2.next().getKind();
            if (it2 != null) {
            } else {
            }
            i2 = i3;
            accumulator$iv$iv = it;
            i2 = it2.hashCode();
        }
        return result += accumulator$iv$iv;
    }
}
