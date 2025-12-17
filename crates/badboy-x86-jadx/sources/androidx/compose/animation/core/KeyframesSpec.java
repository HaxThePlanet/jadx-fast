package androidx.compose.animation.core;

import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0002\u000e\u000fB\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J,\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\n0\t\"\u0008\u0008\u0001\u0010\n*\u00020\u000b2\u0012\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\rH\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0010", d2 = {"Landroidx/compose/animation/core/KeyframesSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "vectorize", "Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframeEntity", "KeyframesSpecConfig", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyframesSpec<T>  implements androidx.compose.animation.core.DurationBasedAnimationSpec<T> {

    public static final int $stable;
    private final androidx.compose.animation.core.KeyframesSpec.KeyframesSpecConfig<T> config;

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\"\u0010\u0006\u001a\u00020\u0007X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "T", "Landroidx/compose/animation/core/KeyframeBaseEntity;", "value", "easing", "Landroidx/compose/animation/core/Easing;", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "(Ljava/lang/Object;Landroidx/compose/animation/core/Easing;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getArcMode--9T-Mq4$animation_core_release", "()I", "setArcMode-Rur9ykg$animation_core_release", "(I)V", "I", "equals", "", "other", "", "hashCode", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class KeyframeEntity extends androidx.compose.animation.core.KeyframeBaseEntity<T> {

        public static final int $stable = 8;
        private int arcMode;
        static {
            final int i = 8;
        }

        private KeyframeEntity(T value, androidx.compose.animation.core.Easing easing, int arcMode) {
            super(value, easing, 0);
            this.arcMode = arcMode;
        }

        public KeyframeEntity(Object object, androidx.compose.animation.core.Easing easing2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
            androidx.compose.animation.core.Easing obj2;
            int obj3;
            if (i4 & 2 != 0) {
                obj2 = EasingKt.getLinearEasing();
            }
            if (i4 &= 4 != 0) {
                obj3 = ArcMode.Companion.getArcLinear--9T-Mq4();
            }
            super(object, obj2, obj3, 0);
        }

        public KeyframeEntity(Object object, androidx.compose.animation.core.Easing easing2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
            super(object, easing2, i3);
        }

        @Override // androidx.compose.animation.core.KeyframeBaseEntity
        public boolean equals(Object other) {
            int i;
            boolean equal;
            int value$animation_core_release;
            if (other == this) {
                return 1;
            }
            final int i2 = 0;
            if (!other instanceof KeyframesSpec.KeyframeEntity) {
                return i2;
            }
            if (Intrinsics.areEqual((KeyframesSpec.KeyframeEntity)other.getValue$animation_core_release(), getValue$animation_core_release()) && Intrinsics.areEqual((KeyframesSpec.KeyframeEntity)other.getEasing$animation_core_release(), getEasing$animation_core_release()) && ArcMode.equals-impl0(obj3.arcMode, this.arcMode)) {
                if (Intrinsics.areEqual((KeyframesSpec.KeyframeEntity)other.getEasing$animation_core_release(), getEasing$animation_core_release())) {
                    if (ArcMode.equals-impl0(obj3.arcMode, this.arcMode)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // androidx.compose.animation.core.KeyframeBaseEntity
        public final int getArcMode--9T-Mq4$animation_core_release() {
            return this.arcMode;
        }

        @Override // androidx.compose.animation.core.KeyframeBaseEntity
        public int hashCode() {
            int i;
            Object value$animation_core_release = getValue$animation_core_release();
            if (value$animation_core_release != null) {
                i = value$animation_core_release.hashCode();
            } else {
                i = 0;
            }
            return result += i6;
        }

        @Override // androidx.compose.animation.core.KeyframeBaseEntity
        public final void setArcMode-Rur9ykg$animation_core_release(int <set-?>) {
            this.arcMode = <set-?>;
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0006\u001a\u00028\u0001H\u0010¢\u0006\u0004\u0008\u0007\u0010\u0008J\"\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\u0008\u0008\u0001\u0010\n\u001a\u00020\u000bH\u0096\u0004¢\u0006\u0002\u0010\u000cJ\"\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0003*\u00028\u00012\u0008\u0008\u0001\u0010\u000e\u001a\u00020\u000fH\u0096\u0004¢\u0006\u0002\u0010\u0010J+\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0003*\u0008\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u0017*\u0008\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0004\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a", d2 = {"Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "T", "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "()V", "createEntityFor", "value", "createEntityFor$animation_core_release", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "at", "timeStamp", "", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "using", "arcMode", "Landroidx/compose/animation/core/ArcMode;", "using-ngzHuyU", "(Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;I)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "with", "", "easing", "Landroidx/compose/animation/core/Easing;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class KeyframesSpecConfig extends androidx.compose.animation.core.KeyframesSpecBaseConfig<T, androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T>> {

        public static final int $stable;
        static {
        }

        public KeyframesSpecConfig() {
            super(0);
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public androidx.compose.animation.core.KeyframeBaseEntity at(Object $this$at, int timeStamp) {
            return (KeyframeBaseEntity)at($this$at, timeStamp);
        }

        public androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T> at(T $this$at, int timeStamp) {
            KeyframesSpec.KeyframeEntity keyframeEntity = new KeyframesSpec.KeyframeEntity($this$at, 0, 0, 6, 0);
            int i2 = 0;
            getKeyframes$animation_core_release().set(timeStamp, keyframeEntity);
            return keyframeEntity;
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public androidx.compose.animation.core.KeyframeBaseEntity atFraction(Object $this$atFraction, float fraction) {
            return (KeyframeBaseEntity)atFraction($this$atFraction, fraction);
        }

        public androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T> atFraction(T $this$atFraction, float fraction) {
            final int i2 = 0;
            return at($this$atFraction, Math.round(f *= fraction));
        }

        @Override // androidx.compose.animation.core.KeyframesSpecBaseConfig
        public androidx.compose.animation.core.KeyframeBaseEntity createEntityFor$animation_core_release(Object value) {
            return (KeyframeBaseEntity)createEntityFor$animation_core_release(value);
        }

        public androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T> createEntityFor$animation_core_release(T value) {
            KeyframesSpec.KeyframeEntity keyframeEntity = new KeyframesSpec.KeyframeEntity(value, 0, 0, 6, 0);
            return keyframeEntity;
        }

        public final androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T> using-ngzHuyU(androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T> $this$using_u2dngzHuyU, int arcMode) {
            $this$using_u2dngzHuyU.setArcMode-Rur9ykg$animation_core_release(arcMode);
            return $this$using_u2dngzHuyU;
        }

        @Deprecated(message = "Use version that returns an instance of the entity so it can be re-used in other keyframe builders.", replaceWith = @ReplaceWith(...))
        public final void with(androidx.compose.animation.core.KeyframesSpec.KeyframeEntity<T> $this$with, androidx.compose.animation.core.Easing easing) {
            $this$with.setEasing$animation_core_release(easing);
        }
    }
    static {
    }

    public KeyframesSpec(androidx.compose.animation.core.KeyframesSpec.KeyframesSpecConfig<T> config) {
        super();
        this.config = config;
    }

    public final androidx.compose.animation.core.KeyframesSpec.KeyframesSpecConfig<T> getConfig() {
        return this.config;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedAnimationSpec)vectorize(converter);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedDurationBasedAnimationSpec)vectorize(converter);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedFiniteAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedFiniteAnimationSpec)vectorize(converter);
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedKeyframesSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<T, V> converter) {
        int this_$iv2;
        boolean durationMillis;
        int invoke;
        int[] easing$animation_core_release;
        Object[] arcMode--9T-Mq4$animation_core_release;
        MutableIntObjectMap this_$iv$iv;
        int i$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        int i3;
        int j$iv$iv;
        long l;
        int i4;
        int i2;
        long slot$iv$iv;
        long key;
        Object obj;
        MutableIntObjectMap this_$iv;
        int i5;
        int i;
        int[] iArr;
        Object[] objArr;
        MutableIntObjectMap map;
        final Object obj2 = this;
        MutableIntList mutableIntList = new MutableIntList(size += 2);
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(obj2.config.getKeyframes$animation_core_release().getSize());
        this_$iv2 = obj2.config.getKeyframes$animation_core_release();
        this_$iv$iv = this_$iv2;
        int i8 = 0;
        long[] metadata = this_$iv$iv.metadata;
        length += -2;
        if (0 <= i9) {
        } else {
            this_$iv = this_$iv2;
            i = invoke;
            iArr = easing$animation_core_release;
            objArr = arcMode--9T-Mq4$animation_core_release;
            map = this_$iv$iv;
        }
        int i7 = 0;
        if (!obj2.config.getKeyframes$animation_core_release().contains(i7)) {
            mutableIntList.add(i7, i7);
        }
        if (!obj2.config.getKeyframes$animation_core_release().contains(obj2.config.getDurationMillis())) {
            mutableIntList.add(obj2.config.getDurationMillis());
        }
        mutableIntList.sort();
        VectorizedKeyframesSpec vectorizedKeyframesSpec = new VectorizedKeyframesSpec((IntList)mutableIntList, (IntObjectMap)mutableIntObjectMap, obj2.config.getDurationMillis(), obj2.config.getDelayMillis(), EasingKt.getLinearEasing(), ArcMode.Companion.getArcLinear--9T-Mq4(), 0);
        return vectorizedKeyframesSpec;
    }
}
