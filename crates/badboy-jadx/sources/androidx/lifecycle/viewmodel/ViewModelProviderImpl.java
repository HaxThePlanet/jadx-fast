package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelProvider.OnRequeryFactory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\u0008\u0008\u0010\tJ1\u0010\u000c\u001a\u0002H\r\"\u0008\u0008\u0000\u0010\r*\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\r0\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012H\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/lifecycle/viewmodel/ViewModelProviderImpl;", "", "store", "Landroidx/lifecycle/ViewModelStore;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "<init>", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "lock", "Landroidx/lifecycle/viewmodel/internal/SynchronizedObject;", "getViewModel", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "key", "", "getViewModel$lifecycle_viewmodel_release", "(Lkotlin/reflect/KClass;Ljava/lang/String;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelProviderImpl {

    private final androidx.lifecycle.viewmodel.CreationExtras defaultExtras;
    private final ViewModelProvider.Factory factory;
    private final SynchronizedObject lock;
    private final ViewModelStore store;
    public ViewModelProviderImpl(ViewModelStore store, ViewModelProvider.Factory factory, androidx.lifecycle.viewmodel.CreationExtras defaultExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultExtras, "defaultExtras");
        super();
        this.store = store;
        this.factory = factory;
        this.defaultExtras = defaultExtras;
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        this.lock = synchronizedObject;
    }

    public static final androidx.lifecycle.viewmodel.CreationExtras access$getDefaultExtras$p(androidx.lifecycle.viewmodel.ViewModelProviderImpl $this) {
        return $this.defaultExtras;
    }

    public static final ViewModelProvider.Factory access$getFactory$p(androidx.lifecycle.viewmodel.ViewModelProviderImpl $this) {
        return $this.factory;
    }

    public static final ViewModelStore access$getStore$p(androidx.lifecycle.viewmodel.ViewModelProviderImpl $this) {
        return $this.store;
    }

    public static ViewModel getViewModel$lifecycle_viewmodel_release$default(androidx.lifecycle.viewmodel.ViewModelProviderImpl viewModelProviderImpl, KClass kClass2, String string3, int i4, Object object5) {
        String obj2;
        if (i4 &= 2 != 0) {
            obj2 = ViewModelProviders.INSTANCE.getDefaultKey$lifecycle_viewmodel_release(kClass2);
        }
        return viewModelProviderImpl.getViewModel$lifecycle_viewmodel_release(kClass2, obj2);
    }

    public final <T extends ViewModel> T getViewModel$lifecycle_viewmodel_release(KClass<T> modelClass, String key) {
        ViewModel viewModel2;
        boolean z;
        Object mutableCreationExtras;
        ViewModel viewModel;
        ViewModel view2;
        int i;
        ViewModelStore view;
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(key, "key");
        SynchronizedObject lock = this.lock;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        viewModel2 = ViewModelProviderImpl.access$getStore$p(this).get(key);
        synchronized (lock) {
            if (factory instanceof ViewModelProvider.OnRequeryFactory != null) {
                Intrinsics.checkNotNull(viewModel2);
                (ViewModelProvider.OnRequeryFactory)ViewModelProviderImpl.access$getFactory$p(this).onRequery(viewModel2);
            }
            Intrinsics.checkNotNull(viewModel2, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
            return viewModel2;
        }
    }
}
