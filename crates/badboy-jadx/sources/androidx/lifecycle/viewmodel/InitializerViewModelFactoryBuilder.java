package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders_jvmKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@ViewModelFactoryDsl
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J7\u0010\u0008\u001a\u00020\t\"\u0008\u0008\u0000\u0010\n*\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u00062\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\u0008\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R\"\u0010\u0004\u001a\u0016\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0006\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/lifecycle/viewmodel/InitializerViewModelFactoryBuilder;", "", "<init>", "()V", "initializers", "", "Lkotlin/reflect/KClass;", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "addInitializer", "", "T", "Landroidx/lifecycle/ViewModel;", "clazz", "initializer", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Lkotlin/ExtensionFunctionType;", "build", "Landroidx/lifecycle/ViewModelProvider$Factory;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InitializerViewModelFactoryBuilder {

    private final Map<KClass<?>, androidx.lifecycle.viewmodel.ViewModelInitializer<?>> initializers;
    public InitializerViewModelFactoryBuilder() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.initializers = (Map)linkedHashMap;
    }

    public final <T extends androidx.lifecycle.ViewModel> void addInitializer(KClass<T> clazz, Function1<? super androidx.lifecycle.viewmodel.CreationExtras, ? extends T> initializer) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        if (this.initializers.containsKey(clazz)) {
        } else {
            ViewModelInitializer viewModelInitializer = new ViewModelInitializer(clazz, initializer);
            this.initializers.put(clazz, viewModelInitializer);
        }
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("A `initializer` with the same `clazz` has already been added: ").append(ViewModelProviders_jvmKt.getCanonicalName(clazz)).append('.').toString().toString());
        throw illegalArgumentException;
    }

    public final ViewModelProvider.Factory build() {
        return ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel_release(this.initializers.values());
    }
}
