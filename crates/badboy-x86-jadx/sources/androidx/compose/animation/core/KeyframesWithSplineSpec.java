package androidx.compose.animation.core;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0011B\u001f\u0008\u0016\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0008\u0008\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0008J,\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u000c\"\u0008\u0008\u0001\u0010\r*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\r0\u0010H\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/compose/animation/core/KeyframesWithSplineSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "periodicBias", "", "(Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;F)V", "(Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframesWithSplineSpecConfig", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyframesWithSplineSpec<T>  implements androidx.compose.animation.core.DurationBasedAnimationSpec<T> {

    public static final int $stable;
    private final androidx.compose.animation.core.KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T> config;
    private float periodicBias;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0006\u001a\u00028\u0001H\u0010¢\u0006\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "T", "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "()V", "createEntityFor", "value", "createEntityFor$animation_core_release", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class KeyframesWithSplineSpecConfig extends androidx.compose.animation.core.KeyframesSpecBaseConfig<T, androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T>> {

        public static final int $stable;
        static {
        }

        public KeyframesWithSplineSpecConfig() {
            super(0);
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public androidx.compose.animation.core.KeyframeBaseEntity createEntityFor$animation_core_release(Object value) {
            return (KeyframeBaseEntity)createEntityFor$animation_core_release(value);
        }

        public androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T> createEntityFor$animation_core_release(T value) {
            KeyframesSpec.KeyframeEntity keyframeEntity = new KeyframesSpec.KeyframeEntity(value, 0, 0, 6, 0);
            return keyframeEntity;
        }
    }
    static {
    }

    public KeyframesWithSplineSpec(androidx.compose.animation.core.KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T> config) {
        super();
        this.config = config;
        this.periodicBias = 2143289344;
    }

    public KeyframesWithSplineSpec(androidx.compose.animation.core.KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T> config, float periodicBias) {
        super(config);
        this.periodicBias = periodicBias;
    }

    public final androidx.compose.animation.core.KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T> getConfig() {
        return this.config;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedAnimationSpec)vectorize(converter);
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<T, V> converter) {
        int this_$iv;
        boolean durationMillis;
        int invoke;
        int[] easing$animation_core_release;
        int i$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i;
        int j$iv$iv;
        long l;
        int i5;
        int i3;
        long slot$iv$iv;
        long key;
        Object obj;
        MutableIntObjectMap this_$iv2;
        int i4;
        int i2;
        int[] iArr;
        final Object obj2 = this;
        MutableIntList mutableIntList = new MutableIntList(size += 2);
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(obj2.config.getKeyframes$animation_core_release().getSize());
        this_$iv = obj2.config.getKeyframes$animation_core_release();
        int i8 = 0;
        long[] metadata = map2.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
            this_$iv2 = this_$iv;
            i2 = invoke;
            iArr = easing$animation_core_release;
        }
        int i7 = 0;
        if (!obj2.config.getKeyframes$animation_core_release().contains(i7)) {
            mutableIntList.add(i7, i7);
        }
        if (!obj2.config.getKeyframes$animation_core_release().contains(obj2.config.getDurationMillis())) {
            mutableIntList.add(obj2.config.getDurationMillis());
        }
        mutableIntList.sort();
        VectorizedMonoSplineKeyframesSpec vectorizedMonoSplineKeyframesSpec = new VectorizedMonoSplineKeyframesSpec((IntList)mutableIntList, (IntObjectMap)mutableIntObjectMap, obj2.config.getDurationMillis(), obj2.config.getDelayMillis(), obj2.periodicBias);
        return (VectorizedDurationBasedAnimationSpec)vectorizedMonoSplineKeyframesSpec;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedFiniteAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedFiniteAnimationSpec)vectorize(converter);
    }
}
