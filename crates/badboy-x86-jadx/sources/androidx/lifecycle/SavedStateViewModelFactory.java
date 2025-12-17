package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\u0008\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004B\u001b\u0008\u0016\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0004\u0008\u0003\u0010\tB%\u0008\u0017\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\u0008\u0003\u0010\u000cJ-\u0010\u0012\u001a\u0002H\u0013\"\u0008\u0008\u0000\u0010\u0013*\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J-\u0010\u0012\u001a\u0002H\u0013\"\u0008\u0008\u0000\u0010\u0013*\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u001bJ+\u0010\u0012\u001a\u0002H\u0013\"\u0008\u0008\u0000\u0010\u0013*\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u001a¢\u0006\u0002\u0010\u001eJ%\u0010\u0012\u001a\u0002H\u0013\"\u0008\u0008\u0000\u0010\u0013*\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u001aH\u0016¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0017R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Landroidx/lifecycle/SavedStateViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "application", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;)V", "defaultArgs", "Landroid/os/Bundle;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "factory", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "onRequery", "", "viewModel", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateViewModelFactory extends androidx.lifecycle.ViewModelProvider.OnRequeryFactory implements androidx.lifecycle.ViewModelProvider.Factory {

    private Application application;
    private Bundle defaultArgs;
    private final androidx.lifecycle.ViewModelProvider.Factory factory;
    private androidx.lifecycle.Lifecycle lifecycle;
    private SavedStateRegistry savedStateRegistry;
    public SavedStateViewModelFactory() {
        super();
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        this.factory = (ViewModelProvider.Factory)androidViewModelFactory;
    }

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        super(application, owner, 0);
    }

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner owner, Bundle defaultArgs) {
        androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        Intrinsics.checkNotNullParameter(owner, "owner");
        super();
        this.savedStateRegistry = owner.getSavedStateRegistry();
        this.lifecycle = owner.getLifecycle();
        this.defaultArgs = defaultArgs;
        this.application = application;
        if (application != null) {
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.Companion.getInstance(application);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory();
        }
        this.factory = androidViewModelFactory;
    }

    public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
        } else {
            return create(canonicalName, modelClass);
        }
        IllegalArgumentException canonicalName2 = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        throw canonicalName2;
    }

    public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
        Object obj;
        Object create;
        boolean assignableFrom;
        java.lang.reflect.Constructor matchingConstructor;
        androidx.lifecycle.ViewModel instance;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Object obj2 = extras.get(ViewModelProvider.VIEW_MODEL_KEY);
        if ((String)obj2 == null) {
        } else {
            if (extras.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) != null && extras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
                if (extras.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
                    create = extras.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
                    assignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
                    if (assignableFrom && (Application)create != null) {
                        if ((Application)create != null) {
                            matchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(modelClass, SavedStateViewModelFactory_androidKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
                        } else {
                            matchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(modelClass, SavedStateViewModelFactory_androidKt.access$getVIEWMODEL_SIGNATURE$p());
                        }
                    } else {
                    }
                    if (matchingConstructor == null) {
                        return this.factory.create(modelClass, extras);
                    }
                    if (assignableFrom && (Application)create != null) {
                        if ((Application)create != null) {
                            instance = SavedStateViewModelFactory_androidKt.newInstance(modelClass, matchingConstructor, /* result */);
                        } else {
                            instance = SavedStateViewModelFactory_androidKt.newInstance(modelClass, matchingConstructor, /* result */);
                        }
                    } else {
                    }
                    return instance;
                } else {
                    if (this.lifecycle == null) {
                    } else {
                        instance = create;
                    }
                }
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
            throw illegalStateException;
        }
        IllegalStateException key = new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        throw key;
    }

    public final <T extends androidx.lifecycle.ViewModel> T create(String key, Class<T> modelClass) {
        Application application;
        java.lang.reflect.Constructor matchingConstructor;
        androidx.lifecycle.ViewModel create;
        androidx.lifecycle.ViewModel instance;
        Object defaultArgs;
        androidx.lifecycle.SavedStateHandle handle;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        androidx.lifecycle.Lifecycle lifecycle = this.lifecycle;
        if (lifecycle == null) {
        } else {
            boolean assignableFrom = AndroidViewModel.class.isAssignableFrom(modelClass);
            if (assignableFrom && this.application != null) {
                if (this.application != null) {
                    matchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(modelClass, SavedStateViewModelFactory_androidKt.access$getANDROID_VIEWMODEL_SIGNATURE$p());
                } else {
                    matchingConstructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(modelClass, SavedStateViewModelFactory_androidKt.access$getVIEWMODEL_SIGNATURE$p());
                }
            } else {
            }
            if (matchingConstructor == null) {
                if (this.application != null) {
                    create = this.factory.create(modelClass);
                } else {
                    create = ViewModelProvider.NewInstanceFactory.Companion.getInstance().create(modelClass);
                }
                return create;
            }
            SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
            Intrinsics.checkNotNull(savedStateRegistry);
            androidx.lifecycle.SavedStateHandleController create2 = LegacySavedStateHandleController.create(savedStateRegistry, lifecycle, key, this.defaultArgs);
            if (assignableFrom && this.application != null) {
                if (this.application != null) {
                    Application application3 = this.application;
                    Intrinsics.checkNotNull(application3);
                    instance = SavedStateViewModelFactory_androidKt.newInstance(modelClass, matchingConstructor, /* result */);
                } else {
                    instance = SavedStateViewModelFactory_androidKt.newInstance(modelClass, matchingConstructor, /* result */);
                }
            } else {
            }
            instance.addCloseable("androidx.lifecycle.savedstate.vm.tag", (AutoCloseable)create2);
            return instance;
        }
        UnsupportedOperationException lifecycle2 = new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        throw lifecycle2;
    }

    public <T extends androidx.lifecycle.ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return create(JvmClassMappingKt.getJavaClass(modelClass), extras);
    }

    @Override // androidx.lifecycle.ViewModelProvider$OnRequeryFactory
    public void onRequery(androidx.lifecycle.ViewModel viewModel) {
        Object savedStateRegistry;
        androidx.lifecycle.Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (this.lifecycle != null) {
            savedStateRegistry = this.savedStateRegistry;
            Intrinsics.checkNotNull(savedStateRegistry);
            lifecycle = this.lifecycle;
            Intrinsics.checkNotNull(lifecycle);
            LegacySavedStateHandleController.attachHandleIfNeeded(viewModel, savedStateRegistry, lifecycle);
        }
    }
}
