package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModelProvider.Factory;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a5\u0010\u0000\u001a\u0002H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0010\t¨\u0006\n", d2 = {"createViewModel", "VM", "Landroidx/lifecycle/ViewModel;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "modelClass", "Lkotlin/reflect/KClass;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelProvider$Factory;Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewModelProviderImpl_androidKt {
    public static final <VM extends androidx.lifecycle.ViewModel> VM createViewModel(ViewModelProvider.Factory factory, KClass<VM> modelClass, androidx.lifecycle.viewmodel.CreationExtras extras) {
        androidx.lifecycle.ViewModel create;
        Class e;
        Class create2;
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        Intrinsics.checkNotNullParameter(extras, "extras");
        create = factory.create(modelClass, extras);
        return create;
    }
}
