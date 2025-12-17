package androidx.compose.ui.graphics.vector;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010(\n\u0000\u0008\u0007\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00010\u0002Bw\u0008\u0000\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0006\u0012\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\u0010\u0011J\u0013\u0010\"\u001a\u00020#2\u0008\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\u0011\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u001dH\u0086\u0002J\u0008\u0010(\u001a\u00020\u001dH\u0016J\u000f\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00010*H\u0096\u0002R\u0014\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0008\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0017R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0017R\u0011\u0010\u000c\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0017¨\u0006+", d2 = {"Landroidx/compose/ui/graphics/vector/VectorGroup;", "Landroidx/compose/ui/graphics/vector/VectorNode;", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "children", "(Ljava/lang/String;FFFFFFFLjava/util/List;Ljava/util/List;)V", "getClipPathData", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getPivotX", "()F", "getPivotY", "getRotation", "getScaleX", "getScaleY", "size", "", "getSize", "()I", "getTranslationX", "getTranslationY", "equals", "", "other", "", "get", "index", "hashCode", "iterator", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorGroup extends androidx.compose.ui.graphics.vector.VectorNode implements Iterable<androidx.compose.ui.graphics.vector.VectorNode>, KMappedMarker {

    public static final int $stable;
    private final List<androidx.compose.ui.graphics.vector.VectorNode> children;
    private final List<androidx.compose.ui.graphics.vector.PathNode> clipPathData;
    private final String name;
    private final float pivotX;
    private final float pivotY;
    private final float rotation;
    private final float scaleX;
    private final float scaleY;
    private final float translationX;
    private final float translationY;
    static {
    }

    public VectorGroup() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023, 0);
    }

    public VectorGroup(String name, float rotation, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends androidx.compose.ui.graphics.vector.PathNode> clipPathData, List<? extends androidx.compose.ui.graphics.vector.VectorNode> children) {
        super(0);
        this.name = name;
        this.rotation = rotation;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
        this.scaleX = scaleX;
        this.scaleY = scaleY;
        this.translationX = translationX;
        this.translationY = translationY;
        this.clipPathData = clipPathData;
        this.children = children;
    }

    public VectorGroup(String string, float f2, float f3, float f4, float f5, float f6, float f7, float f8, List list9, List list10, int i11, DefaultConstructorMarker defaultConstructorMarker12) {
        String obj3;
        int obj4;
        int obj5;
        int obj6;
        int obj7;
        int obj8;
        int obj9;
        int obj10;
        List obj11;
        List obj12;
        List obj14;
        obj3 = i11 & 1 != 0 ? "" : obj3;
        final int i = 0;
        obj4 = i11 & 2 != 0 ? i : obj4;
        obj5 = i11 & 4 != 0 ? i : obj5;
        obj6 = i11 & 8 != 0 ? i : obj6;
        final int i2 = 1065353216;
        obj7 = i11 & 16 != 0 ? i2 : obj7;
        obj8 = i11 & 32 != 0 ? i2 : obj8;
        obj9 = i11 & 64 != 0 ? i : obj9;
        obj10 = i11 & 128 != 0 ? i : obj10;
        if (i11 & 256 != 0) {
            obj11 = VectorKt.getEmptyPath();
        }
        if (i11 &= 512 != 0) {
            obj14 = obj12;
        } else {
            obj14 = list10;
        }
        super(obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj14);
    }

    public static final List access$getChildren$p(androidx.compose.ui.graphics.vector.VectorGroup $this) {
        return $this.children;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public boolean equals(Object other) {
        int i6;
        int i4;
        int i5;
        int i3;
        int i;
        int i7;
        int i2;
        boolean z;
        final int i8 = 1;
        if (this == other) {
            return i8;
        }
        final int i9 = 0;
        if (other != null) {
            if (!other instanceof VectorGroup) {
            } else {
                if (!Intrinsics.areEqual(this.name, obj.name)) {
                    return i9;
                }
                i6 = Float.compare(rotation, rotation2) == 0 ? i8 : i9;
                if (i6 == 0) {
                    return i9;
                }
                i4 = Float.compare(pivotX, pivotX2) == 0 ? i8 : i9;
                if (i4 == 0) {
                    return i9;
                }
                i5 = Float.compare(pivotY, pivotY2) == 0 ? i8 : i9;
                if (i5 == 0) {
                    return i9;
                }
                i3 = Float.compare(scaleX, scaleX2) == 0 ? i8 : i9;
                if (i3 == 0) {
                    return i9;
                }
                i = Float.compare(scaleY, scaleY2) == 0 ? i8 : i9;
                if (i == 0) {
                    return i9;
                }
                i7 = Float.compare(translationX, translationX2) == 0 ? i8 : i9;
                if (i7 == 0) {
                    return i9;
                }
                i2 = Float.compare(translationY, translationY2) == 0 ? i8 : i9;
                if (i2 == 0) {
                    return i9;
                }
                if (!Intrinsics.areEqual(this.clipPathData, obj9.clipPathData)) {
                    return i9;
                }
                if (!Intrinsics.areEqual(this.children, obj10.children)) {
                    return i9;
                }
            }
            return i8;
        }
        return i9;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final androidx.compose.ui.graphics.vector.VectorNode get(int index) {
        return (VectorNode)this.children.get(index);
    }

    public final List<androidx.compose.ui.graphics.vector.PathNode> getClipPathData() {
        return this.clipPathData;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final String getName() {
        return this.name;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getPivotX() {
        return this.pivotX;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getPivotY() {
        return this.pivotY;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getRotation() {
        return this.rotation;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final int getSize() {
        return this.children.size();
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public final float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.vector.VectorNode
    public int hashCode() {
        return result8 += i20;
    }

    public Iterator<androidx.compose.ui.graphics.vector.VectorNode> iterator() {
        VectorGroup.iterator.1 anon = new VectorGroup.iterator.1(this);
        return (Iterator)anon;
    }
}
