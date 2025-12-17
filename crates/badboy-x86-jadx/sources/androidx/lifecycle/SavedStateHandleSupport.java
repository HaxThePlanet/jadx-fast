package androidx.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Key;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001f\u0010\u0003\u001a\u00020\u0004\"\u000c\u0008\u0000\u0010\u0005*\u00020\u0006*\u00020\u0007*\u0002H\u0005H\u0007¢\u0006\u0002\u0010\u0008\u001a0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00012\u000e\u0010\u000e\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010H\u0002\u001a\u000c\u0010\t\u001a\u00020\n*\u00020\u0011H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015\"\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019\"\u0016\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u001b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u001b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010\u001d\u001a\u000c\u0012\u0008\u0012\u00060\u000fj\u0002`\u00100\u001b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"VIEWMODEL_KEY", "", "SAVED_STATE_KEY", "enableSavedStateHandles", "", "T", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/savedstate/SavedStateRegistryOwner;)V", "createSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "savedStateRegistryOwner", "viewModelStoreOwner", "key", "defaultArgs", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "savedStateHandlesVM", "Landroidx/lifecycle/SavedStateHandlesVM;", "getSavedStateHandlesVM", "(Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/SavedStateHandlesVM;", "savedStateHandlesProvider", "Landroidx/lifecycle/SavedStateHandlesProvider;", "getSavedStateHandlesProvider", "(Landroidx/savedstate/SavedStateRegistryOwner;)Landroidx/lifecycle/SavedStateHandlesProvider;", "SAVED_STATE_REGISTRY_OWNER_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "VIEW_MODEL_STORE_OWNER_KEY", "DEFAULT_ARGS_KEY", "lifecycle-viewmodel-savedstate_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandleSupport {

    public static final CreationExtras.Key<Bundle> DEFAULT_ARGS_KEY = null;
    public static final String SAVED_STATE_KEY = "androidx.lifecycle.internal.SavedStateHandlesProvider";
    public static final CreationExtras.Key<SavedStateRegistryOwner> SAVED_STATE_REGISTRY_OWNER_KEY = null;
    public static final String VIEWMODEL_KEY = "androidx.lifecycle.internal.SavedStateHandlesVM";
    public static final CreationExtras.Key<androidx.lifecycle.ViewModelStoreOwner> VIEW_MODEL_STORE_OWNER_KEY;
    static {
        androidx.lifecycle.viewmodel.CreationExtras.Companion companion = CreationExtras.Companion;
        int i = 0;
        SavedStateHandleSupport.special$$inlined.Key.1 anon = new SavedStateHandleSupport.special$$inlined.Key.1();
        SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY = (CreationExtras.Key)anon;
        androidx.lifecycle.viewmodel.CreationExtras.Companion companion2 = CreationExtras.Companion;
        int i2 = 0;
        SavedStateHandleSupport.special$$inlined.Key.2 anon2 = new SavedStateHandleSupport.special$$inlined.Key.2();
        SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY = (CreationExtras.Key)anon2;
        androidx.lifecycle.viewmodel.CreationExtras.Companion companion3 = CreationExtras.Companion;
        int i3 = 0;
        SavedStateHandleSupport.special$$inlined.Key.3 anon3 = new SavedStateHandleSupport.special$$inlined.Key.3();
        SavedStateHandleSupport.DEFAULT_ARGS_KEY = (CreationExtras.Key)anon3;
    }

    public static final androidx.lifecycle.SavedStateHandle createSavedStateHandle(CreationExtras $this$createSavedStateHandle) {
        Intrinsics.checkNotNullParameter($this$createSavedStateHandle, "<this>");
        Object obj = $this$createSavedStateHandle.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY);
        if ((SavedStateRegistryOwner)obj == null) {
        } else {
            Object obj2 = $this$createSavedStateHandle.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY);
            if ((ViewModelStoreOwner)obj2 == null) {
            } else {
                Object obj4 = $this$createSavedStateHandle.get(ViewModelProvider.VIEW_MODEL_KEY);
                if ((String)obj4 == null) {
                } else {
                    return SavedStateHandleSupport.createSavedStateHandle((SavedStateRegistryOwner)obj, (ViewModelStoreOwner)obj2, (String)obj4, (Bundle)$this$createSavedStateHandle.get(SavedStateHandleSupport.DEFAULT_ARGS_KEY));
                }
                IllegalArgumentException key = new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
                throw key;
            }
            IllegalArgumentException viewModelStateRegistryOwner = new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
            throw viewModelStateRegistryOwner;
        }
        IllegalArgumentException savedStateRegistryOwner = new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        throw savedStateRegistryOwner;
    }

    private static final androidx.lifecycle.SavedStateHandle createSavedStateHandle(SavedStateRegistryOwner savedStateRegistryOwner, androidx.lifecycle.ViewModelStoreOwner viewModelStoreOwner, String key, Bundle defaultArgs) {
        Object handle;
        androidx.lifecycle.SavedStateHandle savedStateHandle;
        int i;
        Map handles;
        final androidx.lifecycle.SavedStateHandlesVM savedStateHandlesVM = SavedStateHandleSupport.getSavedStateHandlesVM(viewModelStoreOwner);
        if ((SavedStateHandle)savedStateHandlesVM.getHandles().get(key) == null) {
            i = 0;
            savedStateHandlesVM.getHandles().put(key, SavedStateHandle.Companion.createHandle(SavedStateHandleSupport.getSavedStateHandlesProvider(savedStateRegistryOwner).consumeRestoredStateForKey(key), defaultArgs));
        }
        return handle;
    }

    public static final <T extends SavedStateRegistryOwner & androidx.lifecycle.ViewModelStoreOwner> void enableSavedStateHandles(T $this$enableSavedStateHandles) {
        int i;
        androidx.savedstate.SavedStateRegistry.SavedStateProvider savedStateHandlesProvider2;
        androidx.lifecycle.Lifecycle.State iNITIALIZED;
        Object lifecycle;
        androidx.lifecycle.SavedStateHandleAttacher savedStateHandleAttacher;
        androidx.lifecycle.SavedStateHandlesProvider savedStateHandlesProvider;
        Intrinsics.checkNotNullParameter($this$enableSavedStateHandles, "<this>");
        androidx.lifecycle.Lifecycle.State currentState = (LifecycleOwner)$this$enableSavedStateHandles.getLifecycle().getCurrentState();
        if (currentState != Lifecycle.State.INITIALIZED) {
            if (currentState == Lifecycle.State.CREATED) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        if (i == 0) {
        } else {
            lifecycle = "androidx.lifecycle.internal.SavedStateHandlesProvider";
            if ($this$enableSavedStateHandles.getSavedStateRegistry().getSavedStateProvider(lifecycle) == null) {
                savedStateHandlesProvider2 = new SavedStateHandlesProvider($this$enableSavedStateHandles.getSavedStateRegistry(), (ViewModelStoreOwner)$this$enableSavedStateHandles);
                $this$enableSavedStateHandles.getSavedStateRegistry().registerSavedStateProvider(lifecycle, (SavedStateRegistry.SavedStateProvider)savedStateHandlesProvider2);
                savedStateHandleAttacher = new SavedStateHandleAttacher(savedStateHandlesProvider2);
                (LifecycleOwner)$this$enableSavedStateHandles.getLifecycle().addObserver((LifecycleObserver)savedStateHandleAttacher);
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Failed requirement.".toString());
        throw illegalArgumentException;
    }

    public static final androidx.lifecycle.SavedStateHandlesProvider getSavedStateHandlesProvider(SavedStateRegistryOwner $this$savedStateHandlesProvider) {
        androidx.savedstate.SavedStateRegistry.SavedStateProvider savedStateProvider;
        Intrinsics.checkNotNullParameter($this$savedStateHandlesProvider, "<this>");
        if (savedStateProvider instanceof SavedStateHandlesProvider != null) {
        } else {
            savedStateProvider = 0;
        }
        if (savedStateProvider == null) {
        } else {
            return savedStateProvider;
        }
        IllegalStateException illegalStateException = new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        throw illegalStateException;
    }

    public static final androidx.lifecycle.SavedStateHandlesVM getSavedStateHandlesVM(androidx.lifecycle.ViewModelStoreOwner $this$savedStateHandlesVM) {
        Intrinsics.checkNotNullParameter($this$savedStateHandlesVM, "<this>");
        SavedStateHandleSupport.savedStateHandlesVM.1 anon = new SavedStateHandleSupport.savedStateHandlesVM.1();
        return (SavedStateHandlesVM)ViewModelProvider.Companion.create$default(ViewModelProvider.Companion, $this$savedStateHandlesVM, (ViewModelProvider.Factory)anon, 0, 4, 0).get("androidx.lifecycle.internal.SavedStateHandlesVM", Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class));
    }
}
