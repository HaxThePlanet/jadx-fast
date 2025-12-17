package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002\u001a\u001a\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\u0008\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"EndTension", "", "Inflection", "P1", "P2", "StartTension", "computeSplineInfo", "", "splinePositions", "", "splineTimes", "nbSamples", "", "splineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "density", "Landroidx/compose/ui/unit/Density;", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SplineBasedDecayKt {

    private static final float EndTension = 1f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float StartTension = 0.5f;
    public static final void access$computeSplineInfo(float[] splinePositions, float[] splineTimes, int nbSamples) {
        SplineBasedDecayKt.computeSplineInfo(splinePositions, splineTimes, nbSamples);
    }

    private static final void computeSplineInfo(float[] splinePositions, float[] splineTimes, int nbSamples) {
        int xMin;
        int yMin;
        int i10;
        int yMax;
        int i11;
        int i2;
        int i6;
        int i12;
        int xMax;
        int x;
        int tx;
        int coef;
        int i5;
        int i9;
        int y;
        int i7;
        int i8;
        int i4;
        int i;
        long l;
        int dy;
        int i3;
        int i13;
        final int i14 = nbSamples;
        xMin = 0;
        yMin = 0;
        i10 = 0;
        while (i10 < i14) {
            f /= f3;
            xMax = 1065353216;
            x = 0;
            tx = 0;
            coef = 0;
            x = xMin + i26;
            coef = i28 * i36;
            i7 = 1043542835;
            i8 = 1051931444;
            tx = i32 + i40;
            i4 = i11;
            i = i6;
            l = 4532020583610935537L;
            while (Double.compare(d, l) >= 0) {
                if (Float.compare(tx, i) > 0) {
                } else {
                }
                xMin = x;
                i11 = i4;
                i6 = i;
                x = xMin + i26;
                coef = i28 * i36;
                i7 = 1043542835;
                i8 = 1051931444;
                tx = i32 + i40;
                i4 = i11;
                i = i6;
                l = 4532020583610935537L;
                xMax = x;
            }
            splinePositions[i10] = i19 += i35;
            yMax = 1065353216;
            y = 0;
            dy = 0;
            y = yMin + i42;
            coef = i43 * i48;
            dy = i47 + i13;
            while (Double.compare(d2, l) >= 0) {
                if (Float.compare(dy, i) > 0) {
                } else {
                }
                yMin = y;
                i12 = 1056964608;
                i5 = 1077936128;
                i9 = 1073741824;
                y = yMin + i42;
                coef = i43 * i48;
                dy = i47 + i13;
                yMax = y;
            }
            splineTimes[i10] = i24 += i5;
            i10++;
            if (Float.compare(dy, i) > 0) {
            } else {
            }
            yMin = y;
            i12 = 1056964608;
            i5 = 1077936128;
            i9 = 1073741824;
            yMax = y;
            if (Float.compare(tx, i) > 0) {
            } else {
            }
            xMin = x;
            i11 = i4;
            i6 = i;
            xMax = x;
        }
        splineTimes[i14] = 1065353216;
        splinePositions[i14] = splineTimes[i14];
    }

    public static final <T> DecayAnimationSpec<T> splineBasedDecay(Density density) {
        SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = new SplineBasedFloatDecayAnimationSpec(density);
        return DecayAnimationSpecKt.generateDecayAnimationSpec((FloatDecayAnimationSpec)splineBasedFloatDecayAnimationSpec);
    }
}
