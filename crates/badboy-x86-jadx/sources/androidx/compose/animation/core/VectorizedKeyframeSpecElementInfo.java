package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u000e\u0010\u0012\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u0016\u0010\u0014\u001a\u00020\u0008HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u000bJ7\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00028\u00002\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "vectorValue", "easing", "Landroidx/compose/animation/core/Easing;", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArcMode--9T-Mq4", "()I", "I", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getVectorValue", "()Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/AnimationVector;", "component1", "component2", "component3", "component3--9T-Mq4", "copy", "copy-2NF0KzA", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/Easing;I)Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "equals", "", "other", "hashCode", "", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorizedKeyframeSpecElementInfo<V extends androidx.compose.animation.core.AnimationVector>  {

    public static final int $stable;
    private final int arcMode;
    private final androidx.compose.animation.core.Easing easing;
    private final V vectorValue;
    static {
    }

    private VectorizedKeyframeSpecElementInfo(V vectorValue, androidx.compose.animation.core.Easing easing, int arcMode) {
        super();
        this.vectorValue = vectorValue;
        this.easing = easing;
        this.arcMode = arcMode;
    }

    public VectorizedKeyframeSpecElementInfo(androidx.compose.animation.core.AnimationVector animationVector, androidx.compose.animation.core.Easing easing2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(animationVector, easing2, i3);
    }

    public static androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo copy-2NF0KzA$default(androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo, androidx.compose.animation.core.AnimationVector animationVector2, androidx.compose.animation.core.Easing easing3, int i4, int i5, Object object6) {
        androidx.compose.animation.core.AnimationVector obj1;
        androidx.compose.animation.core.Easing obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = vectorizedKeyframeSpecElementInfo.vectorValue;
        }
        if (i5 & 2 != 0) {
            obj2 = vectorizedKeyframeSpecElementInfo.easing;
        }
        if (i5 &= 4 != 0) {
            obj3 = vectorizedKeyframeSpecElementInfo.arcMode;
        }
        return vectorizedKeyframeSpecElementInfo.copy-2NF0KzA(obj1, obj2, obj3);
    }

    public final V component1() {
        return this.vectorValue;
    }

    public final androidx.compose.animation.core.Easing component2() {
        return this.easing;
    }

    public final int component3--9T-Mq4() {
        return this.arcMode;
    }

    public final androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo<V> copy-2NF0KzA(V v, androidx.compose.animation.core.Easing easing2, int i3) {
        VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = new VectorizedKeyframeSpecElementInfo(v, easing2, i3, 0);
        return vectorizedKeyframeSpecElementInfo;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof VectorizedKeyframeSpecElementInfo) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.vectorValue, obj.vectorValue)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.easing, obj.easing)) {
            return i2;
        }
        if (!ArcMode.equals-impl0(this.arcMode, obj.arcMode)) {
            return i2;
        }
        return i;
    }

    public final int getArcMode--9T-Mq4() {
        return this.arcMode;
    }

    public final androidx.compose.animation.core.Easing getEasing() {
        return this.easing;
    }

    public final V getVectorValue() {
        return this.vectorValue;
    }

    public int hashCode() {
        return i2 += i7;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("VectorizedKeyframeSpecElementInfo(vectorValue=").append(this.vectorValue).append(", easing=").append(this.easing).append(", arcMode=").append(ArcMode.toString-impl(this.arcMode)).append(')').toString();
    }
}
