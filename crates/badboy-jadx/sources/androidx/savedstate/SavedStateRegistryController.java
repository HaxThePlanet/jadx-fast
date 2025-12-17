package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0008\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u000c\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0007J\u0014\u0010\u0010\u001a\u00020\u000b2\n\u0010\u0011\u001a\u00060\u000ej\u0002`\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0013", d2 = {"Landroidx/savedstate/SavedStateRegistryController;", "", "impl", "Landroidx/savedstate/internal/SavedStateRegistryImpl;", "<init>", "(Landroidx/savedstate/internal/SavedStateRegistryImpl;)V", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "performAttach", "", "performRestore", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "performSave", "outBundle", "Companion", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateRegistryController {

    public static final androidx.savedstate.SavedStateRegistryController.Companion Companion;
    private final SavedStateRegistryImpl impl;
    private final androidx.savedstate.SavedStateRegistry savedStateRegistry;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\u0008", d2 = {"Landroidx/savedstate/SavedStateRegistryController$Companion;", "", "<init>", "()V", "create", "Landroidx/savedstate/SavedStateRegistryController;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public static Unit $r8$lambda$mYKAg7nh_JcP4XSEzfHJKM82YOw(androidx.savedstate.SavedStateRegistryOwner savedStateRegistryOwner) {
            return SavedStateRegistryController.Companion.create$lambda$0(savedStateRegistryOwner);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        private static final Unit create$lambda$0(androidx.savedstate.SavedStateRegistryOwner $owner) {
            Recreator recreator = new Recreator($owner);
            $owner.getLifecycle().addObserver((LifecycleObserver)recreator);
            return Unit.INSTANCE;
        }

        @JvmStatic
        public final androidx.savedstate.SavedStateRegistryController create(androidx.savedstate.SavedStateRegistryOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            SavedStateRegistryController.Companion$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SavedStateRegistryController.Companion$$ExternalSyntheticLambda0(owner);
            SavedStateRegistryImpl savedStateRegistryImpl = new SavedStateRegistryImpl(owner, externalSyntheticLambda0);
            SavedStateRegistryController savedStateRegistryController = new SavedStateRegistryController(savedStateRegistryImpl, 0);
            return savedStateRegistryController;
        }
    }
    static {
        SavedStateRegistryController.Companion companion = new SavedStateRegistryController.Companion(0);
        SavedStateRegistryController.Companion = companion;
    }

    private SavedStateRegistryController(SavedStateRegistryImpl impl) {
        super();
        this.impl = impl;
        SavedStateRegistry savedStateRegistry = new SavedStateRegistry(this.impl);
        this.savedStateRegistry = savedStateRegistry;
    }

    public SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl, DefaultConstructorMarker defaultConstructorMarker2) {
        super(savedStateRegistryImpl);
    }

    @JvmStatic
    public static final androidx.savedstate.SavedStateRegistryController create(androidx.savedstate.SavedStateRegistryOwner owner) {
        return SavedStateRegistryController.Companion.create(owner);
    }

    public final androidx.savedstate.SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistry;
    }

    public final void performAttach() {
        this.impl.performAttach();
    }

    public final void performRestore(Bundle savedState) {
        this.impl.performRestore$savedstate_release(savedState);
    }

    public final void performSave(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        this.impl.performSave$savedstate_release(outBundle);
    }
}
