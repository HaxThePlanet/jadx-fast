package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H\u0090\u0002¢\u0006\u0002\u0008\u0014J\u0008\u0010\u0015\u001a\u00020\u0006H\u0016J\r\u0010\u0016\u001a\u00020\u0000H\u0010¢\u0006\u0002\u0008\u0017J\r\u0010\u0018\u001a\u00020\u0019H\u0010¢\u0006\u0002\u0008\u001aJ\u001e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0090\u0002¢\u0006\u0002\u0008\u001cJ\u0008\u0010\u001d\u001a\u00020\u001eH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0090D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R$\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u0004¨\u0006\u001f", d2 = {"Landroidx/compose/animation/core/AnimationVector1D;", "Landroidx/compose/animation/core/AnimationVector;", "initVal", "", "(F)V", "size", "", "getSize$animation_core_release", "()I", "<set-?>", "value", "getValue", "()F", "setValue$animation_core_release", "equals", "", "other", "", "get", "index", "get$animation_core_release", "hashCode", "newVector", "newVector$animation_core_release", "reset", "", "reset$animation_core_release", "set", "set$animation_core_release", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimationVector1D extends androidx.compose.animation.core.AnimationVector {

    public static final int $stable = 8;
    private final int size = 1;
    private float value;
    static {
        final int i = 8;
    }

    public AnimationVector1D(float initVal) {
        super(0);
        this.value = initVal;
        int i2 = 1;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public boolean equals(Object other) {
        int i;
        int i2;
        int i3;
        if (other instanceof AnimationVector1D) {
            i3 = 1;
            i = Float.compare(value, value2) == 0 ? i3 : i2;
            if (i != 0) {
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public float get$animation_core_release(int index) {
        if (index == 0) {
            return this.value;
        }
        return 0;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int getSize$animation_core_release() {
        return this.size;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final float getValue() {
        return this.value;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public int hashCode() {
        return Float.hashCode(this.value);
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public androidx.compose.animation.core.AnimationVector1D newVector$animation_core_release() {
        AnimationVector1D animationVector1D = new AnimationVector1D(0);
        return animationVector1D;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public androidx.compose.animation.core.AnimationVector newVector$animation_core_release() {
        return (AnimationVector)newVector$animation_core_release();
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void reset$animation_core_release() {
        this.value = 0;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public void set$animation_core_release(int index, float value) {
        if (index == 0) {
            this.value = value;
        }
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public final void setValue$animation_core_release(float <set-?>) {
        this.value = <set-?>;
    }

    @Override // androidx.compose.animation.core.AnimationVector
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AnimationVector1D: value = ").append(this.value).toString();
    }
}
