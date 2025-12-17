package androidx.compose.material;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000c\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rJ\u001f\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u000f2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\u0015\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0008H\u0016J\u0008\u0010\u0018\u001a\u00020\u0005H\u0016J\u0008\u0010\u0019\u001a\u00020\u0005H\u0016J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0008\u0010\u001c\u001a\u00020\u001dH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\u001e", d2 = {"Landroidx/compose/material/MapDraggableAnchors;", "T", "Landroidx/compose/material/DraggableAnchors;", "anchors", "", "", "(Ljava/util/Map;)V", "size", "", "getSize", "()I", "closestAnchor", "position", "(F)Ljava/lang/Object;", "searchUpwards", "", "(FZ)Ljava/lang/Object;", "equals", "other", "", "hasAnchorFor", "value", "(Ljava/lang/Object;)Z", "hashCode", "maxAnchor", "minAnchor", "positionOf", "(Ljava/lang/Object;)F", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MapDraggableAnchors<T>  implements androidx.compose.material.DraggableAnchors<T> {

    private final Map<T, Float> anchors;
    public MapDraggableAnchors(Map<T, Float> anchors) {
        super();
        this.anchors = anchors;
    }

    public T closestAnchor(float position) {
        Object next;
        int key;
        boolean next2;
        int compare;
        float f;
        int i;
        float f2;
        Iterator iterator = (Iterable)this.anchors.entrySet().iterator();
        if (!iterator.hasNext()) {
            next = key;
        } else {
            if (iterator.hasNext()) {
                compare = 0;
                f = Math.abs(position - floatValue);
                Object next4 = iterator.next();
                i = 0;
                f2 = Math.abs(position - floatValue2);
                do {
                    next4 = iterator.next();
                    i = 0;
                    f2 = Math.abs(position - floatValue2);
                    if (iterator.hasNext()) {
                    }
                    next = next4;
                    f = f2;
                } while (Float.compare(f, f2) > 0);
            }
        }
        if ((Map.Entry)next != null) {
            key = (Map.Entry)next.getKey();
        }
        return key;
    }

    public T closestAnchor(float position, boolean searchUpwards) {
        int next;
        int key;
        boolean floatValue;
        int compare;
        int delta;
        int i2;
        int cmp;
        int i;
        int delta2;
        int cmp2;
        Iterator iterator = (Iterable)this.anchors.entrySet().iterator();
        if (!iterator.hasNext()) {
            next = key;
        } else {
            if (iterator.hasNext()) {
                compare = 0;
                floatValue = (Number)(Map.Entry)iterator.next().getValue().floatValue();
                delta = searchUpwards ? floatValue - position : position - floatValue;
                i2 = 0;
                i = 2139095040;
                if (Float.compare(delta, i2) < 0) {
                    delta = i;
                }
                Object next3 = iterator.next();
                cmp = 0;
                float floatValue2 = (Number)(Map.Entry)next3.getValue().floatValue();
                do {
                    next3 = iterator.next();
                    cmp = 0;
                    floatValue2 = (Number)(Map.Entry)next3.getValue().floatValue();
                    delta2 = position - floatValue2;
                    if (Float.compare(delta2, i2) < 0) {
                    }
                    if (Float.compare(delta, delta2) > 0) {
                    }
                    if (iterator.hasNext()) {
                    }
                    next = next3;
                    delta = delta2;
                    delta2 = i;
                    delta2 = floatValue2 - position;
                } while (searchUpwards);
            }
        }
        if ((Map.Entry)next != 0) {
            key = (Map.Entry)next.getKey();
        }
        return key;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (!other instanceof MapDraggableAnchors) {
            return 0;
        }
        return Intrinsics.areEqual(this.anchors, obj.anchors);
    }

    @Override // androidx.compose.material.DraggableAnchors
    public int getSize() {
        return this.anchors.size();
    }

    public boolean hasAnchorFor(T value) {
        return this.anchors.containsKey(value);
    }

    @Override // androidx.compose.material.DraggableAnchors
    public int hashCode() {
        return i *= 31;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float maxAnchor() {
        float floatValue;
        Float maxOrNull = CollectionsKt.maxOrNull((Iterable)this.anchors.values());
        if (maxOrNull != null) {
            floatValue = maxOrNull.floatValue();
        } else {
            floatValue = 2143289344;
        }
        return floatValue;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public float minAnchor() {
        float floatValue;
        Float minOrNull = CollectionsKt.minOrNull((Iterable)this.anchors.values());
        if (minOrNull != null) {
            floatValue = minOrNull.floatValue();
        } else {
            floatValue = 2143289344;
        }
        return floatValue;
    }

    public float positionOf(T value) {
        float floatValue;
        Object obj = this.anchors.get(value);
        if ((Float)obj != null) {
            floatValue = (Float)obj.floatValue();
        } else {
            floatValue = 2143289344;
        }
        return floatValue;
    }

    @Override // androidx.compose.material.DraggableAnchors
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("MapDraggableAnchors(").append(this.anchors).append(')').toString();
    }
}
