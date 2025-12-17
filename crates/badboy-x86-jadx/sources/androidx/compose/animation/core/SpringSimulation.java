package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u0006\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003J\u0008\u0010\u0019\u001a\u00020\u001aH\u0002J-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\n\"\u0004\u0008\r\u0010\u0004R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0014\u0010\n\"\u0004\u0008\u0015\u0010\u0004\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006!", d2 = {"Landroidx/compose/animation/core/SpringSimulation;", "", "finalPosition", "", "(F)V", "dampedFreq", "", "value", "dampingRatio", "getDampingRatio", "()F", "setDampingRatio", "getFinalPosition", "setFinalPosition", "gammaMinus", "gammaPlus", "initialized", "", "naturalFreq", "stiffness", "getStiffness", "setStiffness", "getAcceleration", "lastDisplacement", "lastVelocity", "init", "", "updateValues", "Landroidx/compose/animation/core/Motion;", "timeElapsed", "", "updateValues-IJZedt4$animation_core_release", "(FFJ)J", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SpringSimulation {

    public static final int $stable = 8;
    private double dampedFreq;
    private float dampingRatio = 1f;
    private float finalPosition;
    private double gammaMinus;
    private double gammaPlus;
    private boolean initialized;
    private double naturalFreq;
    static {
        final int i = 8;
    }

    public SpringSimulation(float finalPosition) {
        super();
        this.finalPosition = finalPosition;
        this.naturalFreq = Math.sqrt(4632233691727265792L);
        int i = 1065353216;
    }

    private final void init() {
        int i2;
        int cmp;
        int i;
        int i3;
        int sqrt2;
        double sqrt;
        double sqrt3;
        if (this.initialized) {
        }
        int i5 = 1;
        i2 = Float.compare(finalPosition, uNSET) == 0 ? i5 : 0;
        if (i2 != 0) {
        } else {
            d *= d2;
            i = 1065353216;
            if (Float.compare(dampingRatio3, i) > 0) {
                double d6 = (double)i5;
                this.gammaPlus = i7 += i10;
                this.gammaMinus = i9 -= sqrt2;
            } else {
                if (Float.compare(dampingRatio6, i3) >= 0 && Float.compare(dampingRatio7, i) < 0) {
                    if (Float.compare(dampingRatio7, i) < 0) {
                        this.dampedFreq = naturalFreq *= sqrt2;
                    }
                }
            }
            this.initialized = i5;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        throw illegalStateException;
    }

    public final float getAcceleration(float lastDisplacement, float lastVelocity) {
        return (float)i5;
    }

    public final float getDampingRatio() {
        return this.dampingRatio;
    }

    public final float getFinalPosition() {
        return this.finalPosition;
    }

    public final float getStiffness() {
        return (float)i;
    }

    public final void setDampingRatio(float value) {
        if (Float.compare(value, i) < 0) {
        } else {
            this.dampingRatio = value;
            this.initialized = false;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Damping ratio must be non-negative");
        throw illegalArgumentException;
    }

    public final void setFinalPosition(float <set-?>) {
        this.finalPosition = <set-?>;
    }

    public final void setStiffness(float value) {
        int i2 = 0;
        if (Float.compare(stiffness, i2) <= 0) {
        } else {
            this.naturalFreq = Math.sqrt((double)value);
            this.initialized = false;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Spring stiffness constant must be positive.");
        throw illegalArgumentException;
    }

    public final long updateValues-IJZedt4$animation_core_release(float lastDisplacement, float lastVelocity, long timeElapsed) {
        int i;
        int i5;
        int cosCoeff;
        int i2;
        int i3;
        int i4;
        int i8;
        int i9;
        int deltaT;
        int i7;
        int i6;
        final Object obj = this;
        i = lastVelocity;
        obj.init();
        int i21 = lastDisplacement - finalPosition2;
        d15 /= l;
        i4 = 0;
        final int i53 = 0;
        final int i63 = 1065353216;
        if (Float.compare(dampingRatio5, i63) > 0) {
            d26 -= i72;
            int i77 = i27;
            i75 += i29;
            cosCoeff = i7 + i4;
            deltaT = i39;
            i3 = i21;
        } else {
            int i33 = 1;
            i5 = Float.compare(currentVelocity, i63) == 0 ? i33 : 0;
            if (i5 != 0) {
                int i23 = i21;
                deltaT = i39;
                d25 += i66;
                d30 *= i35;
                cosCoeff = i2;
                i3 = i21;
            } else {
                deltaT = i39;
                int i22 = i21;
                i34 *= i56;
                i3 = i21;
                cosCoeff = i;
            }
        }
        return SpringSimulationKt.Motion((float)i20, (float)cosCoeff);
    }
}
