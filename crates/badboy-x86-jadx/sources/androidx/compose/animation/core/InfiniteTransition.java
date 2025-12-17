package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u000b\u0008\u0007\u0018\u00002\u00020\u0001:\u0001'B\u000f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u001c\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0007R\u00020\u0000H\u0000¢\u0006\u0002\u0008\u001fJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001bH\u0002J!\u0010\"\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0007R\u00020\u0000H\u0000¢\u0006\u0002\u0008#J\u000f\u0010$\u001a\u00020\u001dH\u0001¢\u0006\u0004\u0008%\u0010&R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0007R\u00020\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0008\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u0007R\u00020\u00000\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R+\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000c\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0019\u0010\u0013\u001a\u0004\u0008\u0017\u0010\u000f\"\u0004\u0008\u0018\u0010\u0011R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006(", d2 = {"Landroidx/compose/animation/core/InfiniteTransition;", "", "label", "", "(Ljava/lang/String;)V", "_animations", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "animations", "", "getAnimations", "()Ljava/util/List;", "<set-?>", "", "isRunning", "()Z", "setRunning", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "getLabel", "()Ljava/lang/String;", "refreshChildNeeded", "getRefreshChildNeeded", "setRefreshChildNeeded", "refreshChildNeeded$delegate", "startTimeNanos", "", "addAnimation", "", "animation", "addAnimation$animation_core_release", "onFrame", "playTimeNanos", "removeAnimation", "removeAnimation$animation_core_release", "run", "run$animation_core_release", "(Landroidx/compose/runtime/Composer;I)V", "TransitionAnimationState", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InfiniteTransition {

    public static final int $stable = 8;
    private final MutableVector<androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState<?, ?>> _animations;
    private final MutableState isRunning$delegate;
    private final String label;
    private final MutableState refreshChildNeeded$delegate;
    private long startTimeNanos = Long.MIN_VALUE;

    @Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\n\u0008\u0086\u0004\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u0008\u0012\u0004\u0012\u0002H\u00010\u0004BA\u0008\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u00020%H\u0000¢\u0006\u0002\u00083J\r\u00104\u001a\u000201H\u0000¢\u0006\u0002\u00085J\r\u00106\u001a\u000201H\u0000¢\u0006\u0002\u00087J-\u00108\u001a\u0002012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00002\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\nH\u0000¢\u0006\u0004\u00089\u0010:R<\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R*\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\n2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\n@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u0011\u0010\u000b\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u00028\u0000X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\u0008'\u0010\u0018\"\u0004\u0008(\u0010\u001aR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010*R+\u0010+\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00008V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\u0008.\u0010/\u001a\u0004\u0008,\u0010\u0018\"\u0004\u0008-\u0010\u001a¨\u0006;", d2 = {"Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "targetValue", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "label", "", "(Landroidx/compose/animation/core/InfiniteTransition;Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/TwoWayConverter;Landroidx/compose/animation/core/AnimationSpec;Ljava/lang/String;)V", "<set-?>", "Landroidx/compose/animation/core/TargetBasedAnimation;", "animation", "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation$animation_core_release", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getInitialValue$animation_core_release", "()Ljava/lang/Object;", "setInitialValue$animation_core_release", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "isFinished", "", "isFinished$animation_core_release", "()Z", "setFinished$animation_core_release", "(Z)V", "getLabel", "()Ljava/lang/String;", "playTimeNanosOffset", "", "startOnTheNextFrame", "getTargetValue$animation_core_release", "setTargetValue$animation_core_release", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "value", "getValue", "setValue$animation_core_release", "value$delegate", "Landroidx/compose/runtime/MutableState;", "onPlayTimeChanged", "", "playTimeNanos", "onPlayTimeChanged$animation_core_release", "reset", "reset$animation_core_release", "skipToEnd", "skipToEnd$animation_core_release", "updateValues", "updateValues$animation_core_release", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class TransitionAnimationState implements State<T> {

        private androidx.compose.animation.core.TargetBasedAnimation<T, V> animation;
        private androidx.compose.animation.core.AnimationSpec<T> animationSpec;
        private T initialValue;
        private boolean isFinished;
        private final String label;
        private long playTimeNanosOffset;
        private boolean startOnTheNextFrame;
        private T targetValue;
        final androidx.compose.animation.core.InfiniteTransition this$0;
        private final androidx.compose.animation.core.TwoWayConverter<T, V> typeConverter;
        private final MutableState value$delegate;
        public TransitionAnimationState(androidx.compose.animation.core.InfiniteTransition this$0, Object initialValue, Object targetValue, androidx.compose.animation.core.TwoWayConverter typeConverter, androidx.compose.animation.core.AnimationSpec animationSpec, String label) {
            this.this$0 = this$0;
            super();
            this.initialValue = initialValue;
            this.targetValue = targetValue;
            this.typeConverter = typeConverter;
            this.label = label;
            int i = 0;
            this.value$delegate = SnapshotStateKt.mutableStateOf$default(this.initialValue, i, 2, i);
            this.animationSpec = animationSpec;
            TargetBasedAnimation targetBasedAnimation = new TargetBasedAnimation(this.animationSpec, this.typeConverter, this.initialValue, this.targetValue, 0, 16, 0);
            this.animation = targetBasedAnimation;
        }

        public final androidx.compose.animation.core.TargetBasedAnimation<T, V> getAnimation() {
            return this.animation;
        }

        public final androidx.compose.animation.core.AnimationSpec<T> getAnimationSpec() {
            return this.animationSpec;
        }

        public final T getInitialValue$animation_core_release() {
            return this.initialValue;
        }

        @Override // androidx.compose.runtime.State
        public final String getLabel() {
            return this.label;
        }

        public final T getTargetValue$animation_core_release() {
            return this.targetValue;
        }

        public final androidx.compose.animation.core.TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public T getValue() {
            final int i = 0;
            final int i2 = 0;
            return (State)this.value$delegate.getValue();
        }

        @Override // androidx.compose.runtime.State
        public final boolean isFinished$animation_core_release() {
            return this.isFinished;
        }

        @Override // androidx.compose.runtime.State
        public final void onPlayTimeChanged$animation_core_release(long playTimeNanos) {
            final int i2 = 0;
            InfiniteTransition.access$setRefreshChildNeeded(this.this$0, i2);
            if (this.startOnTheNextFrame) {
                this.startOnTheNextFrame = i2;
                this.playTimeNanosOffset = playTimeNanos;
            }
            int i = playTimeNanos - playTimeNanosOffset;
            setValue$animation_core_release(this.animation.getValueFromNanos(i));
            this.isFinished = this.animation.isFinishedFromNanos(i);
        }

        @Override // androidx.compose.runtime.State
        public final void reset$animation_core_release() {
            this.startOnTheNextFrame = true;
        }

        public final void setAnimation$animation_core_release(androidx.compose.animation.core.TargetBasedAnimation<T, V> <set-?>) {
            this.animation = <set-?>;
        }

        @Override // androidx.compose.runtime.State
        public final void setFinished$animation_core_release(boolean <set-?>) {
            this.isFinished = <set-?>;
        }

        public final void setInitialValue$animation_core_release(T <set-?>) {
            this.initialValue = <set-?>;
        }

        public final void setTargetValue$animation_core_release(T <set-?>) {
            this.targetValue = <set-?>;
        }

        public void setValue$animation_core_release(T <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.value$delegate.setValue(<set-?>);
        }

        @Override // androidx.compose.runtime.State
        public final void skipToEnd$animation_core_release() {
            setValue$animation_core_release(this.animation.getTargetValue());
            this.startOnTheNextFrame = true;
        }

        public final void updateValues$animation_core_release(T initialValue, T targetValue, androidx.compose.animation.core.AnimationSpec<T> animationSpec) {
            this.initialValue = initialValue;
            this.targetValue = targetValue;
            this.animationSpec = animationSpec;
            TargetBasedAnimation targetBasedAnimation = new TargetBasedAnimation(animationSpec, this.typeConverter, initialValue, targetValue, 0, 16, 0);
            this.animation = targetBasedAnimation;
            final int obj10 = 1;
            InfiniteTransition.access$setRefreshChildNeeded(this.this$0, obj10);
            this.isFinished = false;
            this.startOnTheNextFrame = obj10;
        }
    }
    static {
        final int i = 8;
    }

    public InfiniteTransition(String label) {
        super();
        this.label = label;
        int i = 0;
        int i5 = 0;
        final int i7 = 0;
        MutableVector mutableVector = new MutableVector(new InfiniteTransition.TransitionAnimationState[16], i7);
        this._animations = mutableVector;
        int i4 = 0;
        int i6 = 2;
        this.refreshChildNeeded$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i7), i4, i6, i4);
        long l = Long.MIN_VALUE;
        this.isRunning$delegate = SnapshotStateKt.mutableStateOf$default(true, i4, i6, i4);
    }

    public static final long access$getStartTimeNanos$p(androidx.compose.animation.core.InfiniteTransition $this) {
        return $this.startTimeNanos;
    }

    public static final MutableVector access$get_animations$p(androidx.compose.animation.core.InfiniteTransition $this) {
        return $this._animations;
    }

    public static final void access$onFrame(androidx.compose.animation.core.InfiniteTransition $this, long playTimeNanos) {
        $this.onFrame(playTimeNanos);
    }

    public static final void access$setRefreshChildNeeded(androidx.compose.animation.core.InfiniteTransition $this, boolean <set-?>) {
        $this.setRefreshChildNeeded(<set-?>);
    }

    public static final void access$setStartTimeNanos$p(androidx.compose.animation.core.InfiniteTransition $this, long <set-?>) {
        $this.startTimeNanos = <set-?>;
    }

    private final boolean getRefreshChildNeeded() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.refreshChildNeeded$delegate.getValue().booleanValue();
    }

    private final boolean isRunning() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isRunning$delegate.getValue().booleanValue();
    }

    private final void onFrame(long playTimeNanos) {
        int allFinished;
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        boolean finished$animation_core_release;
        int i2 = 0;
        allFinished = 1;
        MutableVector _animations = this._animations;
        final int i3 = 0;
        final int size = _animations.getSize();
        if (size > 0) {
            i$iv = 0;
            obj = _animations.getContent()[i$iv];
            i = 0;
            do {
                obj = content[i$iv];
                i = 0;
                if (!obj.isFinished$animation_core_release()) {
                }
                if (i$iv++ < size) {
                }
                allFinished = 0;
                obj.onPlayTimeChanged$animation_core_release(playTimeNanos);
            } while (!(InfiniteTransition.TransitionAnimationState)obj.isFinished$animation_core_release());
        }
        setRunning(allFinished ^ 1);
    }

    private final void setRefreshChildNeeded(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.refreshChildNeeded$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setRunning(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isRunning$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    public final void addAnimation$animation_core_release(androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState<?, ?> animation) {
        this._animations.add(animation);
        setRefreshChildNeeded(true);
    }

    public final List<androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations.asMutableList();
    }

    public final String getLabel() {
        return this.label;
    }

    public final void removeAnimation$animation_core_release(androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState<?, ?> animation) {
        this._animations.remove(animation);
    }

    public final void run$animation_core_release(Composer $composer, int $changed) {
        int invalid$iv;
        int $dirty;
        int i;
        int traceInProgress2;
        boolean traceInProgress;
        int i2;
        Object mutableStateOf$default;
        boolean refreshChildNeeded;
        String str;
        int rememberedValue;
        Object rememberedValue2;
        int empty2;
        int empty;
        int i3;
        invalid$iv = -318043801;
        final Composer obj11 = $composer.startRestartGroup(invalid$iv);
        ComposerKt.sourceInformation(obj11, "C(run)172@7001L67:InfiniteTransition.kt#pdpnli");
        refreshChildNeeded = 2;
        if ($changed & 6 == 0) {
            i = obj11.changedInstance(this) ? 4 : refreshChildNeeded;
            $dirty |= i;
        }
        if ($dirty & 3 == refreshChildNeeded) {
            if (!obj11.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(invalid$iv, $dirty, -1, "androidx.compose.animation.core.InfiniteTransition.run (InfiniteTransition.kt:171)");
                }
                String str3 = "CC(remember):InfiniteTransition.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(obj11, 748212685, str3);
                int i5 = 0;
                str = obj11;
                rememberedValue = 0;
                rememberedValue2 = str.rememberedValue();
                empty2 = 0;
                i3 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    str.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(i3, i3, refreshChildNeeded, i3));
                } else {
                    mutableStateOf$default = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                if (!isRunning()) {
                    if (getRefreshChildNeeded()) {
                        obj11.startReplaceGroup(1719915818);
                        ComposerKt.sourceInformation(obj11, "176@7149L1537,176@7128L1558");
                        ComposerKt.sourceInformationMarkerStart(obj11, 748218891, str3);
                        refreshChildNeeded = obj11;
                        str = 0;
                        rememberedValue = refreshChildNeeded.rememberedValue();
                        rememberedValue2 = 0;
                        if (!obj11.changedInstance(this)) {
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                empty2 = 0;
                                empty = new InfiniteTransition.run.1.1((MutableState)mutableStateOf$default, this, i3);
                                refreshChildNeeded.updateRememberedValue((Function2)empty);
                            } else {
                                empty = rememberedValue;
                            }
                        } else {
                        }
                        ComposerKt.sourceInformationMarkerEnd(obj11);
                        EffectsKt.LaunchedEffect(this, (Function2)empty, obj11, $dirty & 14);
                        obj11.endReplaceGroup();
                    } else {
                        obj11.startReplaceGroup(1721436120);
                        obj11.endReplaceGroup();
                    }
                } else {
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj11.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new InfiniteTransition.run.2(this, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }
}
