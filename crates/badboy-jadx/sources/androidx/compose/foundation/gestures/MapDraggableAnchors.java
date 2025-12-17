package androidx.compose.foundation.gestures;

import androidx.collection.ObjectFloatMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u000cH\u0016¢\u0006\u0002\u0010\rJ\u001f\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000f2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J@\u0010\u0014\u001a\u00020\u001526\u0010\u0016\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\u001a\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\u0018\u0012\u0008\u0008\u0019\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00150\u0017H\u0016J\u0015\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0008\u0010\u001e\u001a\u00020\u0007H\u0016J\u0008\u0010\u001f\u001a\u00020\u000cH\u0016J\u0008\u0010 \u001a\u00020\u000cH\u0016J\u0015\u0010!\u001a\u00020\u000c2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u0008\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006%", d2 = {"Landroidx/compose/foundation/gestures/MapDraggableAnchors;", "T", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "anchors", "Landroidx/collection/ObjectFloatMap;", "(Landroidx/collection/ObjectFloatMap;)V", "size", "", "getSize", "()I", "closestAnchor", "position", "", "(F)Ljava/lang/Object;", "searchUpwards", "", "(FZ)Ljava/lang/Object;", "equals", "other", "", "forEach", "", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "anchor", "hasAnchorFor", "value", "(Ljava/lang/Object;)Z", "hashCode", "maxAnchor", "minAnchor", "positionOf", "(Ljava/lang/Object;)F", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MapDraggableAnchors<T>  implements androidx.compose.foundation.gestures.DraggableAnchors<T> {

    private final ObjectFloatMap<T> anchors;
    public MapDraggableAnchors(ObjectFloatMap<T> anchors) {
        super();
        this.anchors = anchors;
    }

    public T closestAnchor(float position) {
        int bitCount$iv$iv;
        int minDistance;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i4;
        int i;
        int minAnchor;
        int minDistance2;
        long l;
        int i3;
        float f2;
        int i2;
        float f;
        int cmp;
        bitCount$iv$iv = 0;
        int i11 = 0;
        minDistance = 2139095040;
        final ObjectFloatMap anchors = obj.anchors;
        final int i12 = 0;
        final int i13 = 0;
        final long[] metadata = num.metadata;
        length += -2;
        if (0 <= i14) {
        } else {
            minAnchor = bitCount$iv$iv;
            minDistance2 = minDistance;
        }
        return minAnchor;
    }

    public T closestAnchor(float position, boolean searchUpwards) {
        int bitCount$iv$iv;
        int minDistance;
        int i$iv$iv;
        long slot$iv$iv;
        long j$iv$iv;
        int i6;
        int i5;
        int minAnchor;
        int minDistance2;
        long l;
        int i;
        float f;
        int i2;
        int i4;
        int i3;
        int cmp;
        bitCount$iv$iv = 0;
        int i13 = 0;
        minDistance = 2139095040;
        final ObjectFloatMap anchors = obj.anchors;
        final int i14 = 0;
        final int i15 = 0;
        final long[] metadata = num.metadata;
        length += -2;
        if (0 <= i16) {
        } else {
            minAnchor = bitCount$iv$iv;
            minDistance2 = minDistance;
        }
        return minAnchor;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (!other instanceof MapDraggableAnchors) {
            return 0;
        }
        return Intrinsics.areEqual(this.anchors, obj.anchors);
    }

    public void forEach(Function2<? super T, ? super Float, Unit> block) {
        int cmp;
        int anchors;
        int valueOf;
        Object k$iv;
        Object[] keys;
        Object k$iv2;
        int i$iv$iv;
        long slot$iv$iv;
        int j$iv$iv;
        int i;
        int i2;
        ObjectFloatMap this_$iv;
        long l;
        int i3;
        int i4;
        Object[] objArr;
        int $i$f$forEach;
        anchors = cmp.anchors;
        final int i12 = 0;
        final long[] metadata = num.metadata;
        length += -2;
        if (0 <= i13) {
        } else {
            this_$iv = anchors;
            $i$f$forEach = valueOf;
            objArr = keys;
            k$iv = block;
        }
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public int getSize() {
        return this.anchors.getSize();
    }

    public boolean hasAnchorFor(T value) {
        return this.anchors.containsKey(value);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public int hashCode() {
        return i *= 31;
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float maxAnchor() {
        return AnchoredDraggableKt.access$maxValueOrNaN(this.anchors);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public float minAnchor() {
        return AnchoredDraggableKt.access$minValueOrNaN(this.anchors);
    }

    public float positionOf(T value) {
        return this.anchors.getOrDefault(value, 2143289344);
    }

    @Override // androidx.compose.foundation.gestures.DraggableAnchors
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MapDraggableAnchors(").append(this.anchors).append(')').toString();
    }
}
