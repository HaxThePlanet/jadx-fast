package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition.Segment;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001#JO\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112#\u0008\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H&ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJO\u0010\u001b\u001a\u00020\u00082\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00112#\u0008\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0016\u0012\u0008\u0008\u0017\u0012\u0004\u0008\u0008(\u0018\u0012\u0004\u0012\u00020\u00150\u0014H&ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020 *\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"H¦\u0004R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u0008*\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b\u0082\u0001\u0001$ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006%À\u0006\u0001", d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "getContentAlignment", "()Landroidx/compose/ui/Alignment;", "KeepUntilTransitionsFinished", "Landroidx/compose/animation/ExitTransition;", "Landroidx/compose/animation/ExitTransition$Companion;", "getKeepUntilTransitionsFinished", "(Landroidx/compose/animation/ExitTransition$Companion;)Landroidx/compose/animation/ExitTransition;", "slideIntoContainer", "Landroidx/compose/animation/EnterTransition;", "towards", "Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "initialOffset", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "offsetForFullSlide", "slideIntoContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/EnterTransition;", "slideOutOfContainer", "targetOffset", "slideOutOfContainer-mOhB8PU", "(ILandroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/animation/ExitTransition;", "using", "Landroidx/compose/animation/ContentTransform;", "sizeTransform", "Landroidx/compose/animation/SizeTransform;", "SlideDirection", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AnimatedContentTransitionScope<S>  extends Transition.Segment<S> {

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/animation/AnimatedContentTransitionScope$SlideDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class SlideDirection {

        public static final androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion Companion;
        private static final int Down;
        private static final int End;
        private static final int Left;
        private static final int Right;
        private static final int Start;
        private static final int Up;
        private final int value;
        static {
            AnimatedContentTransitionScope.SlideDirection.Companion companion = new AnimatedContentTransitionScope.SlideDirection.Companion(0);
            AnimatedContentTransitionScope.SlideDirection.Companion = companion;
            AnimatedContentTransitionScope.SlideDirection.Left = AnimatedContentTransitionScope.SlideDirection.constructor-impl(0);
            AnimatedContentTransitionScope.SlideDirection.Right = AnimatedContentTransitionScope.SlideDirection.constructor-impl(1);
            AnimatedContentTransitionScope.SlideDirection.Up = AnimatedContentTransitionScope.SlideDirection.constructor-impl(2);
            AnimatedContentTransitionScope.SlideDirection.Down = AnimatedContentTransitionScope.SlideDirection.constructor-impl(3);
            AnimatedContentTransitionScope.SlideDirection.Start = AnimatedContentTransitionScope.SlideDirection.constructor-impl(4);
            AnimatedContentTransitionScope.SlideDirection.End = AnimatedContentTransitionScope.SlideDirection.constructor-impl(5);
        }

        private SlideDirection(int value) {
            super();
            this.value = value;
        }

        public static final int access$getDown$cp() {
            return AnimatedContentTransitionScope.SlideDirection.Down;
        }

        public static final int access$getEnd$cp() {
            return AnimatedContentTransitionScope.SlideDirection.End;
        }

        public static final int access$getLeft$cp() {
            return AnimatedContentTransitionScope.SlideDirection.Left;
        }

        public static final int access$getRight$cp() {
            return AnimatedContentTransitionScope.SlideDirection.Right;
        }

        public static final int access$getStart$cp() {
            return AnimatedContentTransitionScope.SlideDirection.Start;
        }

        public static final int access$getUp$cp() {
            return AnimatedContentTransitionScope.SlideDirection.Up;
        }

        public static final androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection box-impl(int i) {
            AnimatedContentTransitionScope.SlideDirection slideDirection = new AnimatedContentTransitionScope.SlideDirection(i);
            return slideDirection;
        }

        public static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof AnimatedContentTransitionScope.SlideDirection) {
                return i3;
            }
            if (i != (AnimatedContentTransitionScope.SlideDirection)object2.unbox-impl()) {
                return i3;
            }
            return 1;
        }

        public static final boolean equals-impl0(int i, int i2) {
            int i3;
            i3 = i == i2 ? 1 : 0;
            return i3;
        }

        public static int hashCode-impl(int i) {
            return Integer.hashCode(i);
        }

        public static String toString-impl(int arg0) {
            String str;
            str = AnimatedContentTransitionScope.SlideDirection.equals-impl0(arg0, AnimatedContentTransitionScope.SlideDirection.Left) ? "Left" : equals-impl02 ? "Right" : equals-impl03 ? "Up" : equals-impl04 ? "Down" : equals-impl05 ? "Start" : equals-impl06 ? "End" : "Invalid";
            return str;
        }

        public boolean equals(Object object) {
            return AnimatedContentTransitionScope.SlideDirection.equals-impl(this.value, object);
        }

        public int hashCode() {
            return AnimatedContentTransitionScope.SlideDirection.hashCode-impl(this.value);
        }

        public String toString() {
            return AnimatedContentTransitionScope.SlideDirection.toString-impl(this.value);
        }

        public final int unbox-impl() {
            return this.value;
        }
    }
    public static androidx.compose.animation.EnterTransition slideIntoContainer-mOhB8PU$default(androidx.compose.animation.AnimatedContentTransitionScope animatedContentTransitionScope, int i2, FiniteAnimationSpec finiteAnimationSpec3, Function1 function14, int i5, Object object6) {
        int i;
        long l;
        androidx.compose.animation.core.SpringSpec obj4;
        androidx.compose.animation.AnimatedContentTransitionScope.slideIntoContainer.1 obj5;
        int obj7;
        if (object6 != null) {
        } else {
            if (i5 & 2 != 0) {
                l = 0;
                obj4 = AnimationSpecKt.spring$default(l, l, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, 0);
            }
            if (i5 &= 4 != 0) {
                obj5 = AnimatedContentTransitionScope.slideIntoContainer.1.INSTANCE;
            }
            return animatedContentTransitionScope.slideIntoContainer-mOhB8PU(i2, obj4, obj5);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideIntoContainer-mOhB8PU");
        throw obj2;
    }

    public static androidx.compose.animation.ExitTransition slideOutOfContainer-mOhB8PU$default(androidx.compose.animation.AnimatedContentTransitionScope animatedContentTransitionScope, int i2, FiniteAnimationSpec finiteAnimationSpec3, Function1 function14, int i5, Object object6) {
        int i;
        long l;
        androidx.compose.animation.core.SpringSpec obj4;
        androidx.compose.animation.AnimatedContentTransitionScope.slideOutOfContainer.1 obj5;
        int obj7;
        if (object6 != null) {
        } else {
            if (i5 & 2 != 0) {
                l = 0;
                obj4 = AnimationSpecKt.spring$default(l, l, IntOffset.box-impl(VisibilityThresholdsKt.getVisibilityThreshold(IntOffset.Companion)), 3, 0);
            }
            if (i5 &= 4 != 0) {
                obj5 = AnimatedContentTransitionScope.slideOutOfContainer.1.INSTANCE;
            }
            return animatedContentTransitionScope.slideOutOfContainer-mOhB8PU(i2, obj4, obj5);
        }
        UnsupportedOperationException obj2 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: slideOutOfContainer-mOhB8PU");
        throw obj2;
    }

    @Override // androidx.compose.animation.core.Transition$Segment
    public abstract Alignment getContentAlignment();

    @Override // androidx.compose.animation.core.Transition$Segment
    public androidx.compose.animation.ExitTransition getKeepUntilTransitionsFinished(androidx.compose.animation.ExitTransition.Companion $this$KeepUntilTransitionsFinished) {
        return $this$KeepUntilTransitionsFinished.getKeepUntilTransitionsFinished$animation_release();
    }

    public abstract androidx.compose.animation.EnterTransition slideIntoContainer-mOhB8PU(int i, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2, Function1<? super Integer, Integer> function13);

    public abstract androidx.compose.animation.ExitTransition slideOutOfContainer-mOhB8PU(int i, FiniteAnimationSpec<IntOffset> finiteAnimationSpec2, Function1<? super Integer, Integer> function13);

    @Override // androidx.compose.animation.core.Transition$Segment
    public abstract androidx.compose.animation.ContentTransform using(androidx.compose.animation.ContentTransform contentTransform, androidx.compose.animation.SizeTransform sizeTransform2);
}
