package androidx.compose.material3.carousel;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JO\u0010\u0019\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\u00072\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00072\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0008\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\r¨\u0006 ", d2 = {"Landroidx/compose/material3/carousel/Keyline;", "", "size", "", "offset", "unadjustedOffset", "isFocal", "", "isAnchor", "isPivot", "cutoff", "(FFFZZZF)V", "getCutoff", "()F", "()Z", "getOffset", "getSize", "getUnadjustedOffset", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Keyline {

    public static final int $stable;
    private final float cutoff;
    private final boolean isAnchor;
    private final boolean isFocal;
    private final boolean isPivot;
    private final float offset;
    private final float size;
    private final float unadjustedOffset;
    static {
    }

    public Keyline(float size, float offset, float unadjustedOffset, boolean isFocal, boolean isAnchor, boolean isPivot, float cutoff) {
        super();
        this.size = size;
        this.offset = offset;
        this.unadjustedOffset = unadjustedOffset;
        this.isFocal = isFocal;
        this.isAnchor = isAnchor;
        this.isPivot = isPivot;
        this.cutoff = cutoff;
    }

    public static androidx.compose.material3.carousel.Keyline copy$default(androidx.compose.material3.carousel.Keyline keyline, float f2, float f3, float f4, boolean z5, boolean z6, boolean z7, float f8, int i9, Object object10) {
        float obj1;
        float obj2;
        float obj3;
        boolean obj4;
        boolean obj5;
        boolean obj6;
        float obj7;
        if (i9 & 1 != 0) {
            obj1 = keyline.size;
        }
        if (i9 & 2 != 0) {
            obj2 = keyline.offset;
        }
        if (i9 & 4 != 0) {
            obj3 = keyline.unadjustedOffset;
        }
        if (i9 & 8 != 0) {
            obj4 = keyline.isFocal;
        }
        if (i9 & 16 != 0) {
            obj5 = keyline.isAnchor;
        }
        if (i9 & 32 != 0) {
            obj6 = keyline.isPivot;
        }
        if (i9 &= 64 != 0) {
            obj7 = keyline.cutoff;
        }
        return keyline.copy(obj1, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public final float component1() {
        return this.size;
    }

    public final float component2() {
        return this.offset;
    }

    public final float component3() {
        return this.unadjustedOffset;
    }

    public final boolean component4() {
        return this.isFocal;
    }

    public final boolean component5() {
        return this.isAnchor;
    }

    public final boolean component6() {
        return this.isPivot;
    }

    public final float component7() {
        return this.cutoff;
    }

    public final androidx.compose.material3.carousel.Keyline copy(float f, float f2, float f3, boolean z4, boolean z5, boolean z6, float f7) {
        Keyline keyline = new Keyline(f, f2, f3, z4, z5, z6, f7);
        return keyline;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof Keyline) {
            return i2;
        }
        Object obj = object;
        if (Float.compare(this.size, obj.size) != 0) {
            return i2;
        }
        if (Float.compare(this.offset, obj.offset) != 0) {
            return i2;
        }
        if (Float.compare(this.unadjustedOffset, obj.unadjustedOffset) != 0) {
            return i2;
        }
        if (this.isFocal != obj.isFocal) {
            return i2;
        }
        if (this.isAnchor != obj.isAnchor) {
            return i2;
        }
        if (this.isPivot != obj.isPivot) {
            return i2;
        }
        if (Float.compare(this.cutoff, obj.cutoff) != 0) {
            return i2;
        }
        return i;
    }

    public final float getCutoff() {
        return this.cutoff;
    }

    public final float getOffset() {
        return this.offset;
    }

    public final float getSize() {
        return this.size;
    }

    public final float getUnadjustedOffset() {
        return this.unadjustedOffset;
    }

    public int hashCode() {
        return i6 += i19;
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public final boolean isFocal() {
        return this.isFocal;
    }

    public final boolean isPivot() {
        return this.isPivot;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Keyline(size=").append(this.size).append(", offset=").append(this.offset).append(", unadjustedOffset=").append(this.unadjustedOffset).append(", isFocal=").append(this.isFocal).append(", isAnchor=").append(this.isAnchor).append(", isPivot=").append(this.isPivot).append(", cutoff=").append(this.cutoff).append(')').toString();
    }
}
