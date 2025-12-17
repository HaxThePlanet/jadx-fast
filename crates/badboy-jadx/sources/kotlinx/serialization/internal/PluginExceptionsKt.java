package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b", d2 = {"throwMissingFieldException", "", "seen", "", "goldenMask", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "throwArrayMissingFieldException", "seenArray", "", "goldenMaskArray", "kotlinx-serialization-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PluginExceptionsKt {
    @InternalSerializationApi
    public static final void throwArrayMissingFieldException(int[] seenArray, int[] goldenMaskArray, SerialDescriptor descriptor) {
        int maskSlot;
        int missingFieldsBits;
        int i;
        int i2;
        String elementName;
        Intrinsics.checkNotNullParameter(seenArray, "seenArray");
        Intrinsics.checkNotNullParameter(goldenMaskArray, "goldenMaskArray");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        maskSlot = 0;
        while (maskSlot < goldenMaskArray.length) {
            if (i3 &= i != 0) {
            }
            maskSlot++;
            i = 0;
            while (i < 32) {
                if (missingFieldsBits & 1 != 0) {
                }
                missingFieldsBits >>>= 1;
                i++;
                (Collection)(List)arrayList.add(descriptor.getElementName(i5 += i));
            }
            if (missingFieldsBits & 1 != 0) {
            }
            missingFieldsBits >>>= 1;
            i++;
            (Collection)arrayList.add(descriptor.getElementName(i5 += i));
        }
        MissingFieldException maskSlot2 = new MissingFieldException(arrayList, descriptor.getSerialName());
        throw maskSlot2;
    }

    @InternalSerializationApi
    public static final void throwMissingFieldException(int seen, int goldenMask, SerialDescriptor descriptor) {
        int missingFieldsBits;
        int i;
        int i2;
        String elementName;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        i3 &= goldenMask;
        i = 0;
        while (i < 32) {
            if (missingFieldsBits & 1 != 0) {
            }
            missingFieldsBits >>>= 1;
            i++;
            (Collection)(List)arrayList.add(descriptor.getElementName(i));
        }
        MissingFieldException i4 = new MissingFieldException(arrayList, descriptor.getSerialName());
        throw i4;
    }
}
