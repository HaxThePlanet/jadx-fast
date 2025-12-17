package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003BC\u0008\u0007\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007\u0012\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0007¢\u0006\u0004\u0008\r\u0010\u000eJ\u0008\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0014\u0010\u0011\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006\u0016", d2 = {"Landroidx/lifecycle/ViewModelLazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Lazy;", "viewModelClass", "Lkotlin/reflect/KClass;", "storeProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelStore;", "factoryProducer", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "<init>", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "cached", "Landroidx/lifecycle/ViewModel;", "value", "getValue", "()Landroidx/lifecycle/ViewModel;", "isInitialized", "", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewModelLazy<VM extends androidx.lifecycle.ViewModel>  implements Lazy<VM> {

    private VM cached;
    private final Function0<CreationExtras> extrasProducer;
    private final Function0<androidx.lifecycle.ViewModelProvider.Factory> factoryProducer;
    private final Function0<androidx.lifecycle.ViewModelStore> storeProducer;
    private final KClass<VM> viewModelClass;
    public static CreationExtras.Empty $r8$lambda$txeDNFL7l9V4IcuDdZnYYHEPYc0() {
        return ViewModelLazy._init_$lambda$0();
    }

    public ViewModelLazy(KClass<VM> viewModelClass, Function0<? extends androidx.lifecycle.ViewModelStore> storeProducer, Function0<? extends androidx.lifecycle.ViewModelProvider.Factory> factoryProducer) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(storeProducer, "storeProducer");
        Intrinsics.checkNotNullParameter(factoryProducer, "factoryProducer");
        super(viewModelClass, storeProducer, factoryProducer, 0, 8, 0);
    }

    public ViewModelLazy(KClass<VM> viewModelClass, Function0<? extends androidx.lifecycle.ViewModelStore> storeProducer, Function0<? extends androidx.lifecycle.ViewModelProvider.Factory> factoryProducer, Function0<? extends CreationExtras> extrasProducer) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(storeProducer, "storeProducer");
        Intrinsics.checkNotNullParameter(factoryProducer, "factoryProducer");
        Intrinsics.checkNotNullParameter(extrasProducer, "extrasProducer");
        super();
        this.viewModelClass = viewModelClass;
        this.storeProducer = storeProducer;
        this.factoryProducer = factoryProducer;
        this.extrasProducer = extrasProducer;
    }

    public ViewModelLazy(KClass kClass, Function0 function02, Function0 function03, Function0 function04, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        androidx.lifecycle.ViewModelLazy$$ExternalSyntheticLambda0 obj4;
        if (i5 &= 8 != 0) {
            obj4 = new ViewModelLazy$$ExternalSyntheticLambda0();
        }
        super(kClass, function02, function03, obj4);
    }

    private static final CreationExtras.Empty _init_$lambda$0() {
        return CreationExtras.Empty.INSTANCE;
    }

    public VM getValue() {
        Object invoke;
        Object invoke2;
        Object invoke3;
        androidx.lifecycle.ViewModel view2;
        androidx.lifecycle.ViewModel view;
        int i;
        final androidx.lifecycle.ViewModel cached = this.cached;
        if (cached == null) {
            i = 0;
            this.cached = ViewModelProvider.Companion.create((ViewModelStore)this.storeProducer.invoke(), (ViewModelProvider.Factory)this.factoryProducer.invoke(), (CreationExtras)this.extrasProducer.invoke()).get(this.viewModelClass);
        } else {
            view2 = cached;
        }
        return view2;
    }

    @Override // kotlin.Lazy
    public Object getValue() {
        return getValue();
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        int i;
        i = this.cached != null ? 1 : 0;
        return i;
    }
}
