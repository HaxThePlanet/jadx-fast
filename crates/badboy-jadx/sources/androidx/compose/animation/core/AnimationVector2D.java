package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0016\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0007H\u0090\u0002¢\u0006\u0002\u0008\u0017J\u0008\u0010\u0018\u001a\u00020\u0007H\u0016J\r\u0010\u0019\u001a\u00020\u0000H\u0010¢\u0006\u0002\u0008\u001aJ\r\u0010\u001b\u001a\u00020\u001cH\u0010¢\u0006\u0002\u0008\u001dJ\u001e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0003H\u0090\u0002¢\u0006\u0002\u0008 J\u0008\u0010!\u001a\u00020\"H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0090D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u000c\"\u0004\u0008\u0010\u0010\u000e¨\u0006#", d2 = {"Landroidx/compose/animation/core/AnimationVector2D;", "Landroidx/compose/animation/core/AnimationVector;", "v1", "", "v2", "(FF)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "getV1", "()F", "setV1$animation_core_release", "(F)V", "getV2", "setV2$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "value", "set$animation_core_release", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimationVector2D extends androidx.compose.animation.core.AnimationVector {

    public static final int $stable = 8;
    private final int size = 2;
    private float v1;
    private float v2;
    static {
        final int i = 8;
    }

    public AnimationVector2D(float v1, float v2) {
        super(0);
        this.v1 = v1;
        this.v2 = v2;
        int i2 = 2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public boolean equals(Object other) {
        boolean z;
        int i;
        int i2;
        float f;
        i = 0;
        if (other instanceof AnimationVector2D) {
            i2 = 1;
            z = Float.compare(f2, f4) == 0 ? i2 : i;
            if (z != 0) {
                z = Float.compare(f3, f) == 0 ? i2 : i;
                if (z != 0) {
                    i = i2;
                }
            }
        }
        return i;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core_release(int index) {
        float f;
        switch (index) {
            case 0:
                f = this.v1;
                break;
            case 1:
                f = this.v2;
                break;
            default:
                f = 0;
        }
        return f;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core_release() {
        return this.size;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float getV1() {
        return this.v1;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float getV2() {
        return this.v2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public androidx.compose.animation.core.AnimationVector2D newVector$animation_core_release() {
        final int i = 0;
        AnimationVector2D animationVector2D = new AnimationVector2D(i, i);
        return animationVector2D;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public androidx.compose.animation.core.AnimationVector newVector$animation_core_release() {
        return (AnimationVector)newVector$animation_core_release();
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core_release() {
        final int i = 0;
        this.v1 = i;
        this.v2 = i;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core_release(int index, float value) {
        switch (index) {
            case 0:
                this.v1 = value;
                break;
            case 1:
                this.v2 = value;
                break;
            default:
        }
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void setV1$animation_core_release(float <set-?>) {
        this.v1 = <set-?>;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void setV2$animation_core_release(float <set-?>) {
        this.v2 = <set-?>;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AnimationVector2D: v1 = ").append(this.v1).append(", v2 = ").append(this.v2).toString();
    }
}
