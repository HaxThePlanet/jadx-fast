package androidx.compose.ui.tooling.animation.states;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008\u0081@\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\u0008\u000c\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\u0008\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0015", d2 = {"Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "Landroidx/compose/ui/tooling/animation/states/ComposeAnimationState;", "value", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class AnimatedVisibilityState implements androidx.compose.ui.tooling.animation.states.ComposeAnimationState {

    public static final androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState.Companion Companion;
    private static final String Enter;
    private static final String Exit;
    private final String value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\n", d2 = {"Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState$Companion;", "", "()V", "Enter", "Landroidx/compose/ui/tooling/animation/states/AnimatedVisibilityState;", "getEnter-jXw82LU", "()Ljava/lang/String;", "Ljava/lang/String;", "Exit", "getExit-jXw82LU", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final String getEnter-jXw82LU() {
            return AnimatedVisibilityState.access$getEnter$cp();
        }

        public final String getExit-jXw82LU() {
            return AnimatedVisibilityState.access$getExit$cp();
        }
    }
    static {
        AnimatedVisibilityState.Companion companion = new AnimatedVisibilityState.Companion(0);
        AnimatedVisibilityState.Companion = companion;
        AnimatedVisibilityState.Enter = AnimatedVisibilityState.constructor-impl("Enter");
        AnimatedVisibilityState.Exit = AnimatedVisibilityState.constructor-impl("Exit");
    }

    private AnimatedVisibilityState(String value) {
        super();
        this.value = value;
    }

    public static final String access$getEnter$cp() {
        return AnimatedVisibilityState.Enter;
    }

    public static final String access$getExit$cp() {
        return AnimatedVisibilityState.Exit;
    }

    public static final androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState box-impl(String string) {
        AnimatedVisibilityState animatedVisibilityState = new AnimatedVisibilityState(string);
        return animatedVisibilityState;
    }

    private static String constructor-impl(String string) {
        return string;
    }

    public static boolean equals-impl(String string, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof AnimatedVisibilityState) {
            return i2;
        }
        if (!Intrinsics.areEqual(string, (AnimatedVisibilityState)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(String string, String string2) {
        return Intrinsics.areEqual(string, string2);
    }

    public static int hashCode-impl(String string) {
        return string.hashCode();
    }

    public static String toString-impl(String arg0) {
        return arg0;
    }

    @Override // androidx.compose.ui.tooling.animation.states.ComposeAnimationState
    public boolean equals(Object object) {
        return AnimatedVisibilityState.equals-impl(this.value, object);
    }

    @Override // androidx.compose.ui.tooling.animation.states.ComposeAnimationState
    public final String getValue() {
        return this.value;
    }

    @Override // androidx.compose.ui.tooling.animation.states.ComposeAnimationState
    public int hashCode() {
        return AnimatedVisibilityState.hashCode-impl(this.value);
    }

    @Override // androidx.compose.ui.tooling.animation.states.ComposeAnimationState
    public String toString() {
        return AnimatedVisibilityState.toString-impl(this.value);
    }

    @Override // androidx.compose.ui.tooling.animation.states.ComposeAnimationState
    public final String unbox-impl() {
        return this.value;
    }
}
