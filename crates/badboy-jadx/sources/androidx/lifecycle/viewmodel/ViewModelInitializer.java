package androidx.lifecycle.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B.\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0008\t¢\u0006\u0004\u0008\n\u0010\u000bB0\u0008\u0016\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000c\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0008\t¢\u0006\u0004\u0008\n\u0010\rR\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR%\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0008\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u0012", d2 = {"Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "T", "Landroidx/lifecycle/ViewModel;", "", "clazz", "Lkotlin/reflect/KClass;", "initializer", "Lkotlin/Function1;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Class;", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function1;)V", "getClazz$lifecycle_viewmodel_release", "()Lkotlin/reflect/KClass;", "getInitializer$lifecycle_viewmodel_release", "()Lkotlin/jvm/functions/Function1;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelInitializer<T extends androidx.lifecycle.ViewModel>  {

    private final KClass<T> clazz;
    private final Function1<androidx.lifecycle.viewmodel.CreationExtras, T> initializer;
    public ViewModelInitializer(Class<T> clazz, Function1<? super androidx.lifecycle.viewmodel.CreationExtras, ? extends T> initializer) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        super(JvmClassMappingKt.getKotlinClass(clazz), initializer);
    }

    public ViewModelInitializer(KClass<T> clazz, Function1<? super androidx.lifecycle.viewmodel.CreationExtras, ? extends T> initializer) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        super();
        this.clazz = clazz;
        this.initializer = initializer;
    }

    public final KClass<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final Function1<androidx.lifecycle.viewmodel.CreationExtras, T> getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
