package androidx.compose.material3.carousel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016JT\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0012H\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ&\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0006J\u0008\u0010\u001f\u001a\u00020\u0004H\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0002J \u0010\"\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006$", d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl;", "Landroidx/compose/material3/carousel/KeylineListScope;", "()V", "firstFocalIndex", "", "focalItemSize", "", "pivotIndex", "pivotOffset", "tmpKeylines", "", "Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "add", "", "size", "isAnchor", "", "createKeylinesWithPivot", "", "Landroidx/compose/material3/carousel/Keyline;", "lastFocalIndex", "itemMainAxisSize", "carouselMainAxisSize", "itemSpacing", "createWithAlignment", "Landroidx/compose/material3/carousel/KeylineList;", "carouselAlignment", "Landroidx/compose/material3/carousel/CarouselAlignment;", "createWithAlignment-waks0t8", "(FFI)Landroidx/compose/material3/carousel/KeylineList;", "createWithPivot", "findLastFocalIndex", "isCutoffLeft", "offset", "isCutoffRight", "TmpKeyline", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class KeylineListScopeImpl implements androidx.compose.material3.carousel.KeylineListScope {

    private int firstFocalIndex = -1;
    private float focalItemSize;
    private int pivotIndex = -1;
    private float pivotOffset;
    private final List<androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline> tmpKeylines;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0013", d2 = {"Landroidx/compose/material3/carousel/KeylineListScopeImpl$TmpKeyline;", "", "size", "", "isAnchor", "", "(FZ)V", "()Z", "getSize", "()F", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class TmpKeyline {

        private final boolean isAnchor;
        private final float size;
        public TmpKeyline(float size, boolean isAnchor) {
            super();
            this.size = size;
            this.isAnchor = isAnchor;
        }

        public static androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline copy$default(androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline keylineListScopeImpl$TmpKeyline, float f2, boolean z3, int i4, Object object5) {
            float obj1;
            boolean obj2;
            if (i4 & 1 != 0) {
                obj1 = tmpKeyline.size;
            }
            if (i4 &= 2 != 0) {
                obj2 = tmpKeyline.isAnchor;
            }
            return tmpKeyline.copy(obj1, obj2);
        }

        public final float component1() {
            return this.size;
        }

        public final boolean component2() {
            return this.isAnchor;
        }

        public final androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline copy(float f, boolean z2) {
            KeylineListScopeImpl.TmpKeyline tmpKeyline = new KeylineListScopeImpl.TmpKeyline(f, z2);
            return tmpKeyline;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof KeylineListScopeImpl.TmpKeyline) {
                return i2;
            }
            Object obj = object;
            if (Float.compare(this.size, obj.size) != 0) {
                return i2;
            }
            if (this.isAnchor != obj.isAnchor) {
                return i2;
            }
            return i;
        }

        public final float getSize() {
            return this.size;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public final boolean isAnchor() {
            return this.isAnchor;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("TmpKeyline(size=").append(this.size).append(", isAnchor=").append(this.isAnchor).append(')').toString();
        }
    }
    public KeylineListScopeImpl() {
        super();
        int i = -1;
        ArrayList arrayList = new ArrayList();
        this.tmpKeylines = (List)arrayList;
    }

    private final List<androidx.compose.material3.carousel.Keyline> createKeylinesWithPivot(int pivotIndex, float pivotOffset, int firstFocalIndex, int lastFocalIndex, float itemMainAxisSize, float carouselMainAxisSize, float itemSpacing, List<androidx.compose.material3.carousel.KeylineListScopeImpl.TmpKeyline> tmpKeylines) {
        float f;
        int i8;
        int cutoffRight;
        int cutoffRight2;
        kotlin.ranges.IntProgression downTo;
        float cutoffLeft;
        int $this$forEach$iv;
        int offset;
        int unadjustedOffset2;
        int unadjustedOffset;
        float f2;
        int i5;
        int i9;
        int nextInt;
        boolean nextInt2;
        int i3;
        int i10;
        int i6;
        int i;
        Object obj;
        kotlin.ranges.IntProgression intProgression;
        kotlin.ranges.IntProgression keyline2;
        androidx.compose.material3.carousel.Keyline keyline;
        float size;
        int i7;
        int i4;
        int anchor2;
        boolean anchor;
        int i2;
        float f3;
        float f4;
        final Object obj2 = this;
        int i11 = pivotIndex;
        float f5 = pivotOffset;
        final int i40 = firstFocalIndex;
        final int i41 = lastFocalIndex;
        final float f7 = carouselMainAxisSize;
        final Object obj4 = tmpKeylines;
        final Object obj5 = obj3;
        ArrayList arrayList = new ArrayList();
        final ArrayList list = arrayList;
        final int i42 = 0;
        int i30 = 2;
        if (obj2.isCutoffLeft((KeylineListScopeImpl.TmpKeyline)obj5.getSize(), f5)) {
            i10 = cutoffRight2;
        } else {
            if (obj2.isCutoffRight(obj5.getSize(), f5, f7)) {
                i10 = cutoffRight2;
            } else {
                i10 = i42;
            }
        }
        final int i43 = 1;
        i5 = 0;
        if (i40 <= i11 && i11 <= i41) {
            if (i11 <= i41) {
                i9 = i5;
                i5 = i43;
            } else {
                i9 = i5;
            }
        } else {
        }
        i6 = i39;
        Keyline keyline4 = new Keyline(obj5.getSize(), f5, pivotOffset, i5, obj5.isAnchor(), 1, i10);
        (List)list.add(keyline4);
        int i23 = 0;
        f = (float)i12;
        i32 -= itemSpacing;
        int offset2 = 0;
        i35 -= itemSpacing;
        int i37 = 0;
        Iterator iterator = (Iterable)RangesKt.downTo(pivotIndex + -1, 0).iterator();
        while (iterator.hasNext()) {
            i3 = nextInt;
            i = 0;
            obj = obj4.get(i3);
            f4 = f;
            int i13 = offset - i46;
            if (obj2.isCutoffLeft(obj.getSize(), i13)) {
            } else {
            }
            f3 = i42;
            if (i40 <= i3 && i3 <= i41) {
            } else {
            }
            anchor2 = 0;
            keyline = new Keyline(obj.getSize(), i13, unadjustedOffset - i47, anchor2, obj.isAnchor(), 0, f3);
            list.add(0, keyline);
            offset -= i14;
            unadjustedOffset -= i15;
            downTo = intProgression;
            f = f4;
            if (i3 <= i41) {
            } else {
            }
            anchor2 = i43;
            f3 = cutoffLeft;
        }
        float f8 = f;
        keyline2 = downTo;
        $this$forEach$iv = 0;
        i17 += itemSpacing;
        i33 += itemSpacing;
        int i38 = 0;
        Iterator iterator2 = (Iterable)RangesKt.until(pivotIndex + 1, obj4.size()).iterator();
        while (iterator2.hasNext()) {
            i3 = nextInt2;
            i6 = 0;
            i = obj4.get(i3);
            int i27 = i8 + i44;
            if (obj2.isCutoffRight(i.getSize(), i27, f7)) {
            } else {
            }
            i2 = i42;
            if (i40 <= i3 && i3 <= i41) {
            } else {
            }
            i4 = 0;
            keyline2 = new Keyline(i.getSize(), i27, unadjustedOffset2 + i45, i4, i.isAnchor(), 0, i2);
            list.add(keyline2);
            i20 += obj;
            unadjustedOffset2 += i28;
            $this$forEach$iv = 0;
            if (i3 <= i41) {
            } else {
            }
            i4 = i43;
            i2 = cutoffRight;
        }
        return list;
    }

    private final int findLastFocalIndex() {
        int lastFocalIndex;
        int lastIndex;
        float focalItemSize;
        lastFocalIndex = this.firstFocalIndex;
        while (lastFocalIndex < CollectionsKt.getLastIndex(this.tmpKeylines)) {
            if (Float.compare(size, focalItemSize) == 0) {
            } else {
            }
            lastIndex = 0;
            if (lastIndex != 0) {
            }
            lastFocalIndex++;
            lastIndex = 1;
        }
        return lastFocalIndex;
    }

    private final boolean isCutoffLeft(float size, float offset) {
        float cmp;
        int i;
        cmp = (float)i2;
        final int i7 = 0;
        if (Float.compare(i6, i7) < 0 && Float.compare(i4, i7) > 0) {
            i = Float.compare(i4, i7) > 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean isCutoffRight(float size, float offset, float carouselMainAxisSize) {
        float cmp;
        int i;
        cmp = (float)i2;
        if (Float.compare(i6, carouselMainAxisSize) < 0 && Float.compare(i4, carouselMainAxisSize) > 0) {
            i = Float.compare(i4, carouselMainAxisSize) > 0 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.compose.material3.carousel.KeylineListScope
    public void add(float size, boolean isAnchor) {
        int lastIndex;
        KeylineListScopeImpl.TmpKeyline tmpKeyline = new KeylineListScopeImpl.TmpKeyline(size, isAnchor);
        this.tmpKeylines.add(tmpKeyline);
        if (Float.compare(size, focalItemSize) > 0) {
            this.firstFocalIndex = CollectionsKt.getLastIndex(this.tmpKeylines);
            this.focalItemSize = size;
        }
    }

    @Override // androidx.compose.material3.carousel.KeylineListScope
    public final androidx.compose.material3.carousel.KeylineList createWithAlignment-waks0t8(float carouselMainAxisSize, float itemSpacing, int carouselAlignment) {
        int focalItemSize;
        float f;
        int i3;
        int i2;
        int i4;
        int i;
        final int lastFocalIndex = findLastFocalIndex();
        final int i17 = lastFocalIndex - firstFocalIndex;
        this.pivotIndex = this.firstFocalIndex;
        int i6 = 2;
        if (CarouselAlignment.equals-impl0(carouselAlignment, CarouselAlignment.Companion.getCenter-NUL3oTo())) {
            i2 = Float.compare(itemSpacing, focalItemSize) == 0 ? 1 : 0;
            if (i2 == 0) {
                int i9 = i17 % 2;
                if (i9 += i4 == 0) {
                } else {
                    focalItemSize = itemSpacing / i5;
                }
            } else {
            }
            float f2 = (float)i6;
            i8 -= focalItemSize;
        } else {
            if (CarouselAlignment.equals-impl0(carouselAlignment, CarouselAlignment.Companion.getEnd-NUL3oTo())) {
                i3 = carouselMainAxisSize - focalItemSize;
            } else {
                i3 = focalItemSize / f;
            }
        }
        this.pivotOffset = i3;
        KeylineList obj12 = new KeylineList(this.createKeylinesWithPivot(this.pivotIndex, this.pivotOffset, this.firstFocalIndex, lastFocalIndex, this.focalItemSize, carouselMainAxisSize, itemSpacing, this.tmpKeylines));
        return obj12;
    }

    @Override // androidx.compose.material3.carousel.KeylineListScope
    public final androidx.compose.material3.carousel.KeylineList createWithPivot(float carouselMainAxisSize, float itemSpacing, int pivotIndex, float pivotOffset) {
        KeylineList obj11 = new KeylineList(this.createKeylinesWithPivot(pivotIndex, pivotOffset, this.firstFocalIndex, findLastFocalIndex(), this.focalItemSize, carouselMainAxisSize, itemSpacing, this.tmpKeylines));
        return obj11;
    }
}
