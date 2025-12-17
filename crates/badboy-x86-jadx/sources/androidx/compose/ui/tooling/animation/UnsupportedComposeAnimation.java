package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\"\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0008\u0002\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u0015", d2 = {"Landroidx/compose/ui/tooling/animation/UnsupportedComposeAnimation;", "Landroidx/compose/animation/tooling/ComposeAnimation;", "label", "", "(Ljava/lang/String;)V", "animationObject", "", "getAnimationObject", "()Ljava/lang/Object;", "getLabel", "()Ljava/lang/String;", "states", "", "", "getStates", "()Ljava/util/Set;", "type", "Landroidx/compose/animation/tooling/ComposeAnimationType;", "getType", "()Landroidx/compose/animation/tooling/ComposeAnimationType;", "Companion", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UnsupportedComposeAnimation implements ComposeAnimation {

    public static final int $stable = 8;
    public static final androidx.compose.ui.tooling.animation.UnsupportedComposeAnimation.Companion Companion;
    private static boolean apiAvailable;
    private final Object animationObject;
    private final String label;
    private final Set<Integer> states;
    private final ComposeAnimationType type;

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000f", d2 = {"Landroidx/compose/ui/tooling/animation/UnsupportedComposeAnimation$Companion;", "", "()V", "<set-?>", "", "apiAvailable", "getApiAvailable", "()Z", "create", "Landroidx/compose/ui/tooling/animation/UnsupportedComposeAnimation;", "label", "", "testOverrideAvailability", "", "override", "ui-tooling_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.ui.tooling.animation.UnsupportedComposeAnimation create(String label) {
            boolean unsupportedComposeAnimation;
            int i;
            if (getApiAvailable()) {
                unsupportedComposeAnimation = new UnsupportedComposeAnimation(label, 0);
                i = unsupportedComposeAnimation;
            }
            return i;
        }

        public final boolean getApiAvailable() {
            return UnsupportedComposeAnimation.access$getApiAvailable$cp();
        }

        public final void testOverrideAvailability(boolean override) {
            UnsupportedComposeAnimation.access$setApiAvailable$cp(override);
        }
    }
    static {
        int i2;
        int i3;
        ComposeAnimationType composeAnimationType;
        boolean it;
        int i;
        String name;
        String str;
        UnsupportedComposeAnimation.Companion companion = new UnsupportedComposeAnimation.Companion(0);
        UnsupportedComposeAnimation.Companion = companion;
        int i4 = 8;
        ComposeAnimationType[] values = ComposeAnimationType.values();
        int i6 = 0;
        i3 = i2;
        while (i3 < values.length) {
            i = 0;
            i3++;
        }
        UnsupportedComposeAnimation.apiAvailable = i2;
    }

    private UnsupportedComposeAnimation(String label) {
        super();
        this.label = label;
        this.type = ComposeAnimationType.UNSUPPORTED;
        this.animationObject = 0;
        this.states = SetsKt.emptySet();
    }

    public UnsupportedComposeAnimation(String string, DefaultConstructorMarker defaultConstructorMarker2) {
        super(string);
    }

    public static final boolean access$getApiAvailable$cp() {
        return UnsupportedComposeAnimation.apiAvailable;
    }

    public static final void access$setApiAvailable$cp(boolean <set-?>) {
        UnsupportedComposeAnimation.apiAvailable = <set-?>;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public Object getAnimationObject() {
        return this.animationObject;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public String getLabel() {
        return this.label;
    }

    public Set<Integer> getStates() {
        return this.states;
    }

    @Override // androidx.compose.animation.tooling.ComposeAnimation
    public ComposeAnimationType getType() {
        return this.type;
    }
}
