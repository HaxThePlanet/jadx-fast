package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B9\u0008\u0016\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00080\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bBC\u0008\u0000\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0008\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u0006H\u0002J \u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,H\u0002J-\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J-\u00104\u001a\u00028\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00103J%\u00105\u001a\u0002062\u0006\u00100\u001a\u00028\u00002\u0006\u00101\u001a\u00028\u00002\u0006\u00102\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00107R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\u0006X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0017R\u0016\u0010\u0011\u001a\u00020\u0012X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0019R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010$\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00068", d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "timestamps", "Landroidx/collection/IntList;", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/animation/core/VectorizedKeyframeSpecElementInfo;", "defaultEasing", "initialArcMode", "Landroidx/compose/animation/core/ArcMode;", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IILandroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "arcSpline", "Landroidx/compose/animation/core/ArcSpline;", "getDelayMillis", "()I", "getDurationMillis", "I", "lastInitialValue", "Landroidx/compose/animation/core/AnimationVector;", "lastTargetValue", "modes", "", "posArray", "", "slopeArray", "times", "valueVector", "velocityVector", "findEntryForTimeMillis", "timeMillis", "getEasedTime", "", "getEasedTimeFromIndex", "index", "asFraction", "", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorizedKeyframesSpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> {

    public static final int $stable = 8;
    private androidx.compose.animation.core.ArcSpline arcSpline;
    private final androidx.compose.animation.core.Easing defaultEasing;
    private final int delayMillis;
    private final int durationMillis;
    private final int initialArcMode;
    private final IntObjectMap<androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo<V>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private int[] modes;
    private float[] posArray;
    private float[] slopeArray;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private V velocityVector;
    static {
        final int i = 8;
    }

    private VectorizedKeyframesSpec(IntList timestamps, IntObjectMap<androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo<V>> keyframes, int durationMillis, int delayMillis, androidx.compose.animation.core.Easing defaultEasing, int initialArcMode) {
        super();
        this.timestamps = timestamps;
        this.keyframes = keyframes;
        this.durationMillis = durationMillis;
        this.delayMillis = delayMillis;
        this.defaultEasing = defaultEasing;
        this.initialArcMode = initialArcMode;
    }

    public VectorizedKeyframesSpec(IntList intList, IntObjectMap intObjectMap2, int i3, int i4, androidx.compose.animation.core.Easing easing5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(intList, intObjectMap2, i3, i4, easing5, i6);
    }

    public VectorizedKeyframesSpec(Map<Integer, ? extends Pair<? extends V, ? extends androidx.compose.animation.core.Easing>> keyframes, int durationMillis, int delayMillis) {
        Object obj;
        Object next;
        int i2;
        int intValue;
        int i;
        Object next2;
        int i3;
        int intValue2;
        Object value;
        androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo;
        Object first;
        Object second;
        androidx.compose.animation.core.ArcMode.Companion companion;
        obj = keyframes;
        int i4 = 0;
        MutableIntList mutableIntList = new MutableIntList(size += 2);
        int i7 = 0;
        Iterator iterator = keyframes.entrySet().iterator();
        for (Map.Entry next : iterator) {
            i2 = 0;
            mutableIntList.add((Number)next.getKey().intValue());
        }
        int $this$forEach$iv = 0;
        if (!obj.containsKey(Integer.valueOf($this$forEach$iv))) {
            mutableIntList.add($this$forEach$iv, $this$forEach$iv);
        }
        if (!obj.containsKey(Integer.valueOf(durationMillis))) {
            mutableIntList.add(durationMillis);
        } else {
            i = durationMillis;
        }
        mutableIntList.sort();
        int i5 = 0;
        int i10 = 0;
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap($this$forEach$iv, 1, i10);
        int i9 = 0;
        Iterator iterator2 = keyframes.entrySet().iterator();
        for (Map.Entry next2 : iterator2) {
            i3 = 0;
            value = next2.getValue();
            vectorizedKeyframeSpecElementInfo = new VectorizedKeyframeSpecElementInfo((AnimationVector)(Pair)value.getFirst(), (Easing)value.getSecond(), ArcMode.Companion.getArcLinear--9T-Mq4(), i10);
            mutableIntObjectMap.set((Number)next2.getKey().intValue(), vectorizedKeyframeSpecElementInfo);
            obj = keyframes;
        }
        super((IntList)mutableIntList, (IntObjectMap)mutableIntObjectMap, i, delayMillis, EasingKt.getLinearEasing(), ArcMode.Companion.getArcLinear--9T-Mq4(), 0);
    }

    public VectorizedKeyframesSpec(Map map, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(map, i2, obj3);
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int i;
        final int obj7 = IntListExtensionKt.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, 0);
        i = obj7 < -1 ? -i3 : obj7;
        return i;
    }

    private final float getEasedTime(int timeMillis) {
        return getEasedTimeFromIndex(findEntryForTimeMillis(timeMillis), timeMillis, false);
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis, boolean asFraction) {
        androidx.compose.animation.core.Easing defaultEasing;
        final int i = 0;
        int this_$iv = 1000;
        if (index >= _size--) {
            return f4 /= f3;
        }
        int i3 = this.timestamps.get(index);
        if (timeMillis == i3) {
            return f5 /= f;
        }
        int i8 = i5 - i3;
        defaultEasing = this.keyframes.get(i3);
        if ((VectorizedKeyframeSpecElementInfo)defaultEasing != null) {
            if ((VectorizedKeyframeSpecElementInfo)defaultEasing.getEasing() == null) {
                defaultEasing = this.defaultEasing;
            }
        } else {
        }
        float transform = defaultEasing.transform(f6 /= f7);
        if (asFraction) {
            return transform;
        }
        return i12 /= f2;
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        int requiresArcSpline;
        androidx.compose.animation.core.ArcSpline arcSpline2;
        androidx.compose.animation.core.AnimationVector valueVector;
        androidx.compose.animation.core.ArcSpline arcSpline;
        androidx.compose.animation.core.AnimationVector lastInitialValue;
        androidx.compose.animation.core.AnimationVector lastTargetValue;
        int[] iArr;
        int i2;
        int i3;
        int modes;
        int initialArcMode;
        float times;
        int i;
        int i4;
        float[] fArr;
        int vectorValue;
        int i5;
        float f;
        arcSpline2 = 0;
        requiresArcSpline = this.arcSpline != null ? 1 : arcSpline2;
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(initialValue);
            this.velocityVector = AnimationVectorsKt.newInstance(initialVelocity);
            int size = this.timestamps.getSize();
            float[] fArr2 = new float[size];
            i3 = arcSpline2;
            while (i3 < size) {
                fArr2[i3] = f2 /= times;
                i3++;
            }
            this.times = fArr2;
            valueVector = this.timestamps.getSize();
            iArr = new int[valueVector];
            modes = arcSpline2;
            while (modes < valueVector) {
                Object obj = this.keyframes.get(this.timestamps.get(modes));
                if ((VectorizedKeyframeSpecElementInfo)obj != null) {
                } else {
                }
                initialArcMode = this.initialArcMode;
                if (!ArcMode.equals-impl0(initialArcMode, ArcMode.Companion.getArcLinear--9T-Mq4())) {
                }
                iArr[modes] = initialArcMode;
                modes++;
                requiresArcSpline = 1;
                initialArcMode = (VectorizedKeyframeSpecElementInfo)obj.getArcMode--9T-Mq4();
            }
            this.modes = iArr;
        }
        if (requiresArcSpline == 0) {
        }
        i2 = 0;
        if (this.arcSpline != null) {
            if (this.lastInitialValue == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastInitialValue");
                lastInitialValue = i2;
            }
            if (Intrinsics.areEqual(lastInitialValue, initialValue)) {
                if (this.lastTargetValue == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastTargetValue");
                    lastTargetValue = i2;
                }
                if (!Intrinsics.areEqual(lastTargetValue, targetValue)) {
                    this.lastInitialValue = initialValue;
                    this.lastTargetValue = targetValue;
                    i6 += size$animation_core_release2;
                    this.posArray = new float[arcSpline];
                    this.slopeArray = new float[arcSpline];
                    int size2 = this.timestamps.getSize();
                    initialArcMode = new float[size2];
                    i = arcSpline2;
                    while (i < size2) {
                        i4 = this.timestamps.get(i);
                        if (i4 == 0) {
                        } else {
                        }
                        if (i4 == getDurationMillis()) {
                        } else {
                        }
                        Object obj3 = this.keyframes.get(i4);
                        Intrinsics.checkNotNull(obj3);
                        i5 = arcSpline2;
                        while (i5 < arcSpline) {
                            new float[arcSpline][i5] = (VectorizedKeyframeSpecElementInfo)obj3.getVectorValue().get$animation_core_release(i5);
                            i5++;
                        }
                        initialArcMode[i] = fArr;
                        i++;
                        fArr[i5] = vectorValue.get$animation_core_release(i5);
                        i5++;
                        if (!this.keyframes.contains(i4)) {
                        } else {
                        }
                        Object obj4 = this.keyframes.get(i4);
                        Intrinsics.checkNotNull(obj4);
                        i5 = arcSpline2;
                        while (i5 < arcSpline) {
                            new float[arcSpline][i5] = (VectorizedKeyframeSpecElementInfo)obj4.getVectorValue().get$animation_core_release(i5);
                            i5++;
                        }
                        fArr[i5] = vectorValue.get$animation_core_release(i5);
                        i5++;
                        vectorValue = arcSpline2;
                        while (vectorValue < arcSpline) {
                            new float[arcSpline][vectorValue] = targetValue.get$animation_core_release(vectorValue);
                            vectorValue++;
                        }
                        fArr[vectorValue] = targetValue.get$animation_core_release(vectorValue);
                        vectorValue++;
                        if (!this.keyframes.contains(i4)) {
                        } else {
                        }
                        Object obj2 = this.keyframes.get(i4);
                        Intrinsics.checkNotNull(obj2);
                        i5 = arcSpline2;
                        while (i5 < arcSpline) {
                            new float[arcSpline][i5] = (VectorizedKeyframeSpecElementInfo)obj2.getVectorValue().get$animation_core_release(i5);
                            i5++;
                        }
                        fArr[i5] = vectorValue.get$animation_core_release(i5);
                        i5++;
                        vectorValue = arcSpline2;
                        while (vectorValue < arcSpline) {
                            new float[arcSpline][vectorValue] = initialValue.get$animation_core_release(vectorValue);
                            vectorValue++;
                        }
                        fArr[vectorValue] = initialValue.get$animation_core_release(vectorValue);
                        vectorValue++;
                    }
                    if (this.modes == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("modes");
                        modes = i2;
                    }
                    times = this.times;
                    if (times == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("times");
                    } else {
                        i2 = times;
                    }
                    arcSpline2 = new ArcSpline(modes, i2, initialArcMode);
                    this.arcSpline = arcSpline2;
                }
            } else {
            }
        } else {
        }
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.AnimationVector animationVector4;
        androidx.compose.animation.core.AnimationVector valueVector3;
        androidx.compose.animation.core.AnimationVector animationVector2;
        int i3;
        androidx.compose.animation.core.AnimationVector valueVector;
        androidx.compose.animation.core.AnimationVector animationVector;
        androidx.compose.animation.core.AnimationVector animationVector3;
        androidx.compose.animation.core.ArcSpline arcSpline;
        int i2;
        float[] posArray2;
        float[] posArray;
        androidx.compose.animation.core.AnimationVector vectorValue2;
        androidx.compose.animation.core.AnimationVector valueVector2;
        androidx.compose.animation.core.AnimationVector vectorValue;
        float f;
        float[] posArray3;
        int i4;
        int i;
        final Object obj = this;
        animationVector4 = targetValue;
        animationVector2 = initialVelocity;
        int i6 = (int)clampPlayTime;
        if (obj.keyframes.contains(i6)) {
            Object obj3 = obj.keyframes.get(i6);
            Intrinsics.checkNotNull(obj3);
            return (VectorizedKeyframeSpecElementInfo)obj3.getVectorValue();
        }
        if (i6 >= obj.getDurationMillis()) {
            return animationVector2;
        }
        if (i6 <= 0) {
            return animationVector4;
        }
        obj.init(animationVector4, animationVector2, obj23);
        final String str = "valueVector";
        if (obj.arcSpline != null && obj.arcSpline == null) {
            if (obj.arcSpline == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline = 0;
            }
            String str3 = "posArray";
            if (obj.posArray == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                posArray2 = 0;
            }
            arcSpline.getPos(obj.getEasedTime(i6), posArray2);
            i2 = 0;
            if (obj.posArray == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                posArray = 0;
            }
            while (i2 < posArray.length) {
                if (obj.valueVector == null) {
                }
                if (obj.posArray == null) {
                }
                valueVector2.set$animation_core_release(i2, posArray3[i2]);
                i2++;
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                posArray3 = 0;
                Intrinsics.throwUninitializedPropertyAccessException(str);
                valueVector2 = 0;
            }
            androidx.compose.animation.core.AnimationVector i8 = obj.valueVector;
            animationVector3 = i8 == null ? 0 : i8;
            return animationVector3;
        }
        int entryForTimeMillis = obj.findEntryForTimeMillis(i6);
        int i9 = obj.timestamps.get(entryForTimeMillis);
        if (obj.keyframes.contains(i9)) {
            Object obj4 = obj.keyframes.get(i9);
            Intrinsics.checkNotNull(obj4);
            vectorValue2 = (VectorizedKeyframeSpecElementInfo)obj4.getVectorValue();
        } else {
            vectorValue2 = animationVector4;
        }
        int i10 = obj.timestamps.get(entryForTimeMillis + 1);
        if (obj.keyframes.contains(i10)) {
            Object obj5 = obj.keyframes.get(i10);
            Intrinsics.checkNotNull(obj5);
            vectorValue = (VectorizedKeyframeSpecElementInfo)obj5.getVectorValue();
        } else {
            vectorValue = animationVector2;
        }
        i4 = 0;
        if (obj.valueVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str);
            valueVector = 0;
        }
        while (i4 < valueVector.getSize$animation_core_release()) {
            if (obj.valueVector == null) {
            }
            valueVector3.set$animation_core_release(i4, VectorConvertersKt.lerp(vectorValue2.get$animation_core_release(i4), vectorValue.get$animation_core_release(i4), obj.getEasedTimeFromIndex(entryForTimeMillis, i6, true)));
            i4++;
            animationVector4 = targetValue;
            animationVector2 = initialVelocity;
            i3 = i;
            Intrinsics.throwUninitializedPropertyAccessException(str);
            valueVector3 = 0;
        }
        int playTimeMillis = i3;
        androidx.compose.animation.core.AnimationVector valueVector4 = obj.valueVector;
        animationVector = valueVector4 == null ? 0 : valueVector4;
        return animationVector;
    }

    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.ArcSpline arcSpline;
        int i3;
        float[] slopeArray;
        float[] slopeArray2;
        int i2;
        androidx.compose.animation.core.AnimationVector velocityVector2;
        long clampPlayTime;
        int i;
        androidx.compose.animation.core.AnimationVector i4;
        androidx.compose.animation.core.AnimationVector velocityVector;
        float f;
        float[] slopeArray3;
        final Object obj = this;
        androidx.compose.animation.core.AnimationVector animationVector5 = obj21;
        clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime((VectorizedDurationBasedAnimationSpec)obj, playTimeNanos / i5);
        if (Long.compare(clampPlayTime, i6) < 0) {
            return animationVector5;
        }
        androidx.compose.animation.core.AnimationVector animationVector = targetValue;
        androidx.compose.animation.core.AnimationVector animationVector3 = initialVelocity;
        obj.init(animationVector, animationVector3, animationVector5);
        final String str2 = "velocityVector";
        i4 = 0;
        if (obj.arcSpline != null && obj.arcSpline == null) {
            if (obj.arcSpline == null) {
                Intrinsics.throwUninitializedPropertyAccessException("arcSpline");
                arcSpline = i4;
            }
            String str3 = "slopeArray";
            if (obj.slopeArray == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                slopeArray = i4;
            }
            arcSpline.getSlope(obj.getEasedTime((int)clampPlayTime), slopeArray);
            i3 = 0;
            if (obj.slopeArray == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                slopeArray2 = i4;
            }
            while (i3 < slopeArray2.length) {
                if (obj.velocityVector == null) {
                }
                if (obj.slopeArray == null) {
                }
                velocityVector.set$animation_core_release(i3, slopeArray3[i3]);
                i3++;
                Intrinsics.throwUninitializedPropertyAccessException(str3);
                slopeArray3 = i4;
                Intrinsics.throwUninitializedPropertyAccessException(str2);
                velocityVector = i4;
            }
            androidx.compose.animation.core.AnimationVector i8 = obj.velocityVector;
            if (i8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str2);
            } else {
                i4 = i8;
            }
            return i4;
        }
        androidx.compose.animation.core.AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis((VectorizedAnimationSpec)obj, clampPlayTime - i9, obj3, animationVector, animationVector3);
        i2 = 0;
        while (i2 < valueFromMillis2.getSize$animation_core_release()) {
            if (obj.velocityVector == null) {
            }
            velocityVector2.set$animation_core_release(i2, i13 *= i);
            i2++;
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            velocityVector2 = i4;
        }
        androidx.compose.animation.core.AnimationVector i11 = obj.velocityVector;
        if (i11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        } else {
            i4 = i11;
        }
        return i4;
    }
}
