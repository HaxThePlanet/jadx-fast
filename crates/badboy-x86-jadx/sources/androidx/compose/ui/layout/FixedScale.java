package androidx.compose.ui.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\"\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0018", d2 = {"Landroidx/compose/ui/layout/FixedScale;", "Landroidx/compose/ui/layout/ContentScale;", "value", "", "(F)V", "getValue", "()F", "component1", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FixedScale implements androidx.compose.ui.layout.ContentScale {

    public static final int $stable;
    private final float value;
    static {
    }

    public FixedScale(float value) {
        super();
        this.value = value;
    }

    public static androidx.compose.ui.layout.FixedScale copy$default(androidx.compose.ui.layout.FixedScale fixedScale, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 1 != 0) {
            obj1 = fixedScale.value;
        }
        return fixedScale.copy(obj1);
    }

    @Override // androidx.compose.ui.layout.ContentScale
    public final float component1() {
        return this.value;
    }

    @Override // androidx.compose.ui.layout.ContentScale
    public long computeScaleFactor-H7hwNQA(long srcSize, long dstSize) {
        return ScaleFactorKt.ScaleFactor(this.value, this.value);
    }

    @Override // androidx.compose.ui.layout.ContentScale
    public final androidx.compose.ui.layout.FixedScale copy(float f) {
        FixedScale fixedScale = new FixedScale(f);
        return fixedScale;
    }

    @Override // androidx.compose.ui.layout.ContentScale
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FixedScale) {
            return i2;
        }
        if (Float.compare(this.value, obj.value) != 0) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.layout.ContentScale
    public final float getValue() {
        return this.value;
    }

    @Override // androidx.compose.ui.layout.ContentScale
    public int hashCode() {
        return Float.hashCode(this.value);
    }

    @Override // androidx.compose.ui.layout.ContentScale
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FixedScale(value=").append(this.value).append(')').toString();
    }
}
