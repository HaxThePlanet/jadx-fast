package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0008\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0013\u0010\r\u001a\u00020\t2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002R\u0014\u0010\u0008\u001a\u00020\tX\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\n¨\u0006\u0010", d2 = {"Lkotlinx/serialization/internal/InlineClassDescriptor;", "Lkotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "name", "", "generatedSerializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;)V", "isInline", "", "()Z", "hashCode", "", "equals", "other", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InlineClassDescriptor extends kotlinx.serialization.internal.PluginGeneratedSerialDescriptor {

    private final boolean isInline = true;
    public InlineClassDescriptor(String name, kotlinx.serialization.internal.GeneratedSerializer<?> generatedSerializer) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(generatedSerializer, "generatedSerializer");
        super(name, generatedSerializer, 1);
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object other) {
        int i;
        boolean otherDescriptor;
        int i2;
        int elementsCount;
        boolean inline;
        SerialDescriptor[] typeParameterDescriptors$kotlinx_serialization_core;
        final Object obj = this;
        final int i3 = 0;
        if ((SerialDescriptor)obj == other) {
        } else {
            i2 = 0;
            if (!other instanceof InlineClassDescriptor) {
                i = i2;
            } else {
                if (!Intrinsics.areEqual((SerialDescriptor)obj.getSerialName(), (SerialDescriptor)other.getSerialName())) {
                    i = i2;
                } else {
                    Object obj2 = other;
                    elementsCount = 0;
                    if ((InlineClassDescriptor)obj2.isInline() && Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), obj2.getTypeParameterDescriptors$kotlinx_serialization_core())) {
                        otherDescriptor = Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), obj2.getTypeParameterDescriptors$kotlinx_serialization_core()) ? i : i2;
                    } else {
                    }
                    if (otherDescriptor == 0) {
                        i = i2;
                    } else {
                        if (obj.getElementsCount() != (SerialDescriptor)other.getElementsCount()) {
                            i = i2;
                        } else {
                            otherDescriptor = 0;
                            while (otherDescriptor < obj.getElementsCount()) {
                                otherDescriptor++;
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        return i *= 31;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean isInline() {
        return this.isInline;
    }
}
