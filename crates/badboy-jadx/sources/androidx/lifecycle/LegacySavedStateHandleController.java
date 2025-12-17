package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistry.AutoRecreated;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u00052\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController;", "", "<init>", "()V", "TAG_SAVED_STATE_HANDLE_CONTROLLER", "", "create", "Landroidx/lifecycle/SavedStateHandleController;", "registry", "Landroidx/savedstate/SavedStateRegistry;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "key", "defaultArgs", "Landroid/os/Bundle;", "attachHandleIfNeeded", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "tryToAddRecreator", "OnRecreation", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LegacySavedStateHandleController {

    public static final androidx.lifecycle.LegacySavedStateHandleController INSTANCE = null;
    public static final String TAG_SAVED_STATE_HANDLE_CONTROLLER = "androidx.lifecycle.savedstate.vm.tag";

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"Landroidx/lifecycle/LegacySavedStateHandleController$OnRecreation;", "Landroidx/savedstate/SavedStateRegistry$AutoRecreated;", "<init>", "()V", "onRecreated", "", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OnRecreation implements SavedStateRegistry.AutoRecreated {
        @Override // androidx.savedstate.SavedStateRegistry$AutoRecreated
        public void onRecreated(SavedStateRegistryOwner owner) {
            boolean empty;
            Object next;
            androidx.lifecycle.ViewModel view;
            androidx.lifecycle.Lifecycle lifecycle;
            Intrinsics.checkNotNullParameter(owner, "owner");
            if (!owner instanceof ViewModelStoreOwner) {
            } else {
                androidx.lifecycle.ViewModelStore viewModelStore2 = (ViewModelStoreOwner)owner.getViewModelStore();
                SavedStateRegistry savedStateRegistry = owner.getSavedStateRegistry();
                Iterator iterator = viewModelStore2.keys().iterator();
                while (iterator.hasNext()) {
                    view = viewModelStore2.get((String)iterator.next());
                    if (view == null) {
                    } else {
                    }
                    LegacySavedStateHandleController.attachHandleIfNeeded(view, savedStateRegistry, owner.getLifecycle());
                }
                if (!(Collection)viewModelStore2.keys().isEmpty()) {
                    savedStateRegistry.runOnNextRecreation(LegacySavedStateHandleController.OnRecreation.class);
                }
            }
            int viewModelStore = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException $i$a$CheckLegacySavedStateHandleController$OnRecreation$onRecreated$1 = new IllegalStateException(stringBuilder.append("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: ").append(owner).toString().toString());
            throw $i$a$CheckLegacySavedStateHandleController$OnRecreation$onRecreated$1;
        }
    }
    static {
        LegacySavedStateHandleController legacySavedStateHandleController = new LegacySavedStateHandleController();
        LegacySavedStateHandleController.INSTANCE = legacySavedStateHandleController;
    }

    @JvmStatic
    public static final void attachHandleIfNeeded(androidx.lifecycle.ViewModel viewModel, SavedStateRegistry registry, androidx.lifecycle.Lifecycle lifecycle) {
        boolean iNSTANCE;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        java.lang.AutoCloseable closeable = viewModel.getCloseable("androidx.lifecycle.savedstate.vm.tag");
        if (closeable != null && !(SavedStateHandleController)closeable.isAttached()) {
            if (!closeable.isAttached()) {
                closeable.attachToLifecycle(registry, lifecycle);
                LegacySavedStateHandleController.INSTANCE.tryToAddRecreator(registry, lifecycle);
            }
        }
    }

    @JvmStatic
    public static final androidx.lifecycle.SavedStateHandleController create(SavedStateRegistry registry, androidx.lifecycle.Lifecycle lifecycle, String key, Bundle defaultArgs) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNull(key);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(key, SavedStateHandle.Companion.createHandle(registry.consumeRestoredStateForKey(key), defaultArgs));
        savedStateHandleController.attachToLifecycle(registry, lifecycle);
        LegacySavedStateHandleController.INSTANCE.tryToAddRecreator(registry, lifecycle);
        return savedStateHandleController;
    }

    private final void tryToAddRecreator(SavedStateRegistry registry, androidx.lifecycle.Lifecycle lifecycle) {
        androidx.lifecycle.LegacySavedStateHandleController.tryToAddRecreator.1 anon;
        androidx.lifecycle.Lifecycle.State iNITIALIZED;
        final androidx.lifecycle.Lifecycle.State currentState = lifecycle.getCurrentState();
        if (currentState != Lifecycle.State.INITIALIZED) {
            if (currentState.isAtLeast(Lifecycle.State.STARTED)) {
                registry.runOnNextRecreation(LegacySavedStateHandleController.OnRecreation.class);
            } else {
                anon = new LegacySavedStateHandleController.tryToAddRecreator.1(lifecycle, registry);
                lifecycle.addObserver((LifecycleObserver)anon);
            }
        } else {
        }
    }
}
