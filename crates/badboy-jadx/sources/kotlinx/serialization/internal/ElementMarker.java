package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\u0008\u0008\u0010\tJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0008\u0010\u0015\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lkotlinx/serialization/internal/ElementMarker;", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "readIfAbsent", "Lkotlin/Function2;", "", "", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function2;)V", "lowerMarks", "", "highMarksArray", "", "mark", "", "index", "nextUnmarkedIndex", "prepareHighMarksArray", "elementsCount", "markHigh", "nextUnmarkedHighIndex", "Companion", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@CoreFriendModuleApi
public final class ElementMarker {

    private static final kotlinx.serialization.internal.ElementMarker.Companion Companion;
    private static final long[] EMPTY_HIGH_MARKS;
    private final SerialDescriptor descriptor;
    private final long[] highMarksArray = -1;
    private long lowerMarks;
    private final Function2<SerialDescriptor, Integer, Boolean> readIfAbsent;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0016\n\u0000\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lkotlinx/serialization/internal/ElementMarker$Companion;", "", "<init>", "()V", "EMPTY_HIGH_MARKS", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        ElementMarker.Companion companion = new ElementMarker.Companion(0);
        ElementMarker.Companion = companion;
        ElementMarker.EMPTY_HIGH_MARKS = new long[0];
    }

    public ElementMarker(SerialDescriptor descriptor, Function2<? super SerialDescriptor, ? super Integer, Boolean> readIfAbsent) {
        int i;
        long[] prepareHighMarksArray;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(readIfAbsent, "readIfAbsent");
        super();
        this.descriptor = descriptor;
        this.readIfAbsent = readIfAbsent;
        int elementsCount = this.descriptor.getElementsCount();
        final int i3 = 64;
        if (elementsCount <= i3) {
            if (elementsCount == i3) {
            } else {
                i2 <<= elementsCount;
            }
            this.lowerMarks = i;
            prepareHighMarksArray = ElementMarker.EMPTY_HIGH_MARKS;
        } else {
            this.lowerMarks = 0;
            this.highMarksArray = prepareHighMarksArray(elementsCount);
        }
    }

    private final void markHigh(int index) {
        i--;
        this.highMarksArray[i2] = l |= i6;
    }

    private final int nextUnmarkedHighIndex() {
        int slot;
        int i;
        long slotMarks;
        long[] indexInSlot;
        long l;
        boolean booleanValue;
        SerialDescriptor descriptor;
        Integer valueOf;
        slot = 0;
        while (slot < highMarksArray.length) {
            slotMarks = this.highMarksArray[slot];
            while (Long.compare(slotMarks, i3) != 0) {
                indexInSlot = Long.numberOfTrailingZeros(~slotMarks);
                l = i + indexInSlot;
            }
            this.highMarksArray[slot] = slotMarks;
            slot++;
            indexInSlot = Long.numberOfTrailingZeros(~slotMarks);
            l = i + indexInSlot;
        }
        return -1;
    }

    private final long[] prepareHighMarksArray(int elementsCount) {
        int lastIndex;
        int i;
        final long[] lArr = new long[i2 >>>= 6];
        if (elementsCount & 63 != 0) {
            lArr[ArraysKt.getLastIndex(lArr)] = i5 <<= elementsCount;
        }
        return lArr;
    }

    public final void mark(int index) {
        int i;
        int i2;
        if (index < 64) {
            this.lowerMarks = lowerMarks |= i2;
        } else {
            markHigh(index);
        }
    }

    public final int nextUnmarkedIndex() {
        int numberOfTrailingZeros;
        long booleanValue;
        SerialDescriptor descriptor;
        Integer valueOf;
        while (Long.compare(lowerMarks, i4) != 0) {
            numberOfTrailingZeros = Long.numberOfTrailingZeros(~lowerMarks2);
            this.lowerMarks = lowerMarks3 |= i6;
        }
        if (this.descriptor.getElementsCount() > 64) {
            return nextUnmarkedHighIndex();
        }
        return -1;
    }
}
