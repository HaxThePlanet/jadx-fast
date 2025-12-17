package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J%\u0010\u0006\u001a\u00020\u0005\"\u0008\u0008\u0000\u0010\u0007*\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\u00070\nH\u0000¢\u0006\u0002\u0008\u000bJ\u0019\u0010\u000c\u001a\u0002H\r\"\u0008\u0008\u0000\u0010\r*\u00020\u0008H\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00140\u0013H\u0000¢\u0006\u0002\u0008\u0015J+\u0010\u0010\u001a\u00020\u00112\u001a\u0010\u0012\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00140\u0016\"\u0006\u0012\u0002\u0008\u00030\u0014H\u0000¢\u0006\u0004\u0008\u0015\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0008\u001bJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0008\u001eJK\u0010\u001f\u001a\u0002H\r\"\u0008\u0008\u0000\u0010\r*\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u0002H\r0\n2\u0006\u0010 \u001a\u00020\u001d2\u001a\u0010\u0012\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00140\u0016\"\u0006\u0012\u0002\u0008\u00030\u0014H\u0000¢\u0006\u0004\u0008!\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Landroidx/lifecycle/viewmodel/internal/ViewModelProviders;", "", "<init>", "()V", "VIEW_MODEL_PROVIDER_DEFAULT_KEY", "", "getDefaultKey", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "getDefaultKey$lifecycle_viewmodel_release", "unsupportedCreateViewModel", "VM", "unsupportedCreateViewModel$lifecycle_viewmodel_release", "()Landroidx/lifecycle/ViewModel;", "createInitializerFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initializers", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "createInitializerFactory$lifecycle_viewmodel_release", "", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultFactory", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "getDefaultFactory$lifecycle_viewmodel_release", "getDefaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getDefaultCreationExtras$lifecycle_viewmodel_release", "createViewModelFromInitializers", "extras", "createViewModelFromInitializers$lifecycle_viewmodel_release", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;[Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelProviders {

    public static final androidx.lifecycle.viewmodel.internal.ViewModelProviders INSTANCE = null;
    private static final String VIEW_MODEL_PROVIDER_DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    static {
        ViewModelProviders viewModelProviders = new ViewModelProviders();
        ViewModelProviders.INSTANCE = viewModelProviders;
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel_release(Collection<? extends ViewModelInitializer<?>> initializers) {
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        int i = 0;
        Object[] $this$toTypedArray$iv = initializers.toArray(new ViewModelInitializer[0]);
        InitializerViewModelFactory initializerViewModelFactory = new InitializerViewModelFactory((ViewModelInitializer[])Arrays.copyOf((ViewModelInitializer[])$this$toTypedArray$iv, $this$toTypedArray$iv.length));
        return (ViewModelProvider.Factory)initializerViewModelFactory;
    }

    public final ViewModelProvider.Factory createInitializerFactory$lifecycle_viewmodel_release(ViewModelInitializer<?>... initializers) {
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        InitializerViewModelFactory initializerViewModelFactory = new InitializerViewModelFactory((ViewModelInitializer[])Arrays.copyOf(initializers, initializers.length));
        return (ViewModelProvider.Factory)initializerViewModelFactory;
    }

    public final <VM extends androidx.lifecycle.ViewModel> VM createViewModelFromInitializers$lifecycle_viewmodel_release(KClass<VM> modelClass, CreationExtras extras, ViewModelInitializer<?>... initializers) {
        Object initializer$lifecycle_viewmodel_release;
        int i3;
        int i2;
        Object obj;
        boolean it;
        int i;
        KClass clazz$lifecycle_viewmodel_release;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        initializer$lifecycle_viewmodel_release = initializers;
        int i5 = 0;
        i3 = 0;
        while (i3 < initializer$lifecycle_viewmodel_release.length) {
            i = 0;
            i3++;
        }
        obj = i2;
        initializer$lifecycle_viewmodel_release = obj.getInitializer$lifecycle_viewmodel_release();
        if (obj != null && initializer$lifecycle_viewmodel_release != null) {
            initializer$lifecycle_viewmodel_release = obj.getInitializer$lifecycle_viewmodel_release();
            if (initializer$lifecycle_viewmodel_release != null) {
                i2 = initializer$lifecycle_viewmodel_release;
            }
        }
        if (i2 == 0) {
        } else {
            return i2;
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("No initializer set for given class ").append(ViewModelProviders_jvmKt.getCanonicalName(modelClass)).toString().toString());
        throw illegalArgumentException;
    }

    public final CreationExtras getDefaultCreationExtras$lifecycle_viewmodel_release(ViewModelStoreOwner owner) {
        CreationExtras defaultViewModelCreationExtras;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof HasDefaultViewModelProviderFactory != null) {
            defaultViewModelCreationExtras = (HasDefaultViewModelProviderFactory)owner.getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        return defaultViewModelCreationExtras;
    }

    public final ViewModelProvider.Factory getDefaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner owner) {
        ViewModelProvider.Factory defaultViewModelProviderFactory;
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof HasDefaultViewModelProviderFactory != null) {
            defaultViewModelProviderFactory = (HasDefaultViewModelProviderFactory)owner.getDefaultViewModelProviderFactory();
        } else {
            defaultViewModelProviderFactory = DefaultViewModelProviderFactory.INSTANCE;
        }
        return defaultViewModelProviderFactory;
    }

    public final <T extends androidx.lifecycle.ViewModel> String getDefaultKey$lifecycle_viewmodel_release(KClass<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = ViewModelProviders_jvmKt.getCanonicalName(modelClass);
        if (canonicalName == null) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("androidx.lifecycle.ViewModelProvider.DefaultKey:").append(canonicalName).toString();
        }
        int canonicalName2 = 0;
        IllegalArgumentException $i$a$RequireNotNullViewModelProviders$getDefaultKey$canonicalName$1 = new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
        throw $i$a$RequireNotNullViewModelProviders$getDefaultKey$canonicalName$1;
    }

    public final <VM extends androidx.lifecycle.ViewModel> VM unsupportedCreateViewModel$lifecycle_viewmodel_release() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
        throw unsupportedOperationException;
    }
}
