package androidx.activity;

import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\u0008\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\u0008ø\u0001\u0000\u001aF\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\u0008\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0010\u0008\n\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\u0010\u0008\n\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0087\u0008ø\u0001\u0000\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\n", d2 = {"viewModels", "Lkotlin/Lazy;", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/activity/ComponentActivity;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extrasProducer", "Landroidx/lifecycle/viewmodel/CreationExtras;", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActivityViewModelLazyKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by viewModels that takes a CreationExtras")
    public static final <VM extends androidx.lifecycle.ViewModel> Lazy<VM> viewModels(androidx.activity.ComponentActivity $this$viewModels, Function0<? extends ViewModelProvider.Factory> factoryProducer) {
        androidx.activity.ActivityViewModelLazyKt.viewModels.factoryPromise.1 anon;
        Intrinsics.checkNotNullParameter($this$viewModels, "<this>");
        int i = 0;
        if (factoryProducer == null) {
            anon = new ActivityViewModelLazyKt.viewModels.factoryPromise.1($this$viewModels);
        } else {
            anon = factoryProducer;
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        ActivityViewModelLazyKt.viewModels.1 anon2 = new ActivityViewModelLazyKt.viewModels.1($this$viewModels);
        ActivityViewModelLazyKt.viewModels.2 anon3 = new ActivityViewModelLazyKt.viewModels.2($this$viewModels);
        ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0)anon2, anon, (Function0)anon3);
        return (Lazy)viewModelLazy;
    }

    public static final <VM extends androidx.lifecycle.ViewModel> Lazy<VM> viewModels(androidx.activity.ComponentActivity $this$viewModels, Function0<? extends CreationExtras> extrasProducer, Function0<? extends ViewModelProvider.Factory> factoryProducer) {
        androidx.activity.ActivityViewModelLazyKt.viewModels.factoryPromise.2 anon;
        Intrinsics.checkNotNullParameter($this$viewModels, "<this>");
        int i = 0;
        if (factoryProducer == null) {
            anon = new ActivityViewModelLazyKt.viewModels.factoryPromise.2($this$viewModels);
        } else {
            anon = factoryProducer;
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        ActivityViewModelLazyKt.viewModels.3 anon2 = new ActivityViewModelLazyKt.viewModels.3($this$viewModels);
        ActivityViewModelLazyKt.viewModels.4 anon3 = new ActivityViewModelLazyKt.viewModels.4(extrasProducer, $this$viewModels);
        ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0)anon2, anon, (Function0)anon3);
        return (Lazy)viewModelLazy;
    }

    public static Lazy viewModels$default(androidx.activity.ComponentActivity $this$viewModels_u24default, Function0 factoryProducer, int i3, Object object4) {
        int obj5;
        androidx.activity.ActivityViewModelLazyKt.viewModels.factoryPromise.1 obj7;
        if (i3 &= 1 != 0) {
            obj5 = 0;
        }
        Intrinsics.checkNotNullParameter($this$viewModels_u24default, "<this>");
        int obj6 = 0;
        if (obj5 == null) {
            obj7 = new ActivityViewModelLazyKt.viewModels.factoryPromise.1($this$viewModels_u24default);
        } else {
            obj7 = obj5;
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        ActivityViewModelLazyKt.viewModels.1 anon = new ActivityViewModelLazyKt.viewModels.1($this$viewModels_u24default);
        ActivityViewModelLazyKt.viewModels.2 anon2 = new ActivityViewModelLazyKt.viewModels.2($this$viewModels_u24default);
        ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0)anon, obj7, (Function0)anon2);
        return (Lazy)viewModelLazy;
    }

    public static Lazy viewModels$default(androidx.activity.ComponentActivity $this$viewModels_u24default, Function0 extrasProducer, Function0 factoryProducer, int i4, Object object5) {
        int obj5;
        int obj6;
        int obj8;
        if (i4 & 1 != 0) {
            obj5 = 0;
        }
        if (i4 &= 2 != 0) {
            obj6 = 0;
        }
        Intrinsics.checkNotNullParameter($this$viewModels_u24default, "<this>");
        int obj7 = 0;
        if (obj6 == null) {
            obj8 = new ActivityViewModelLazyKt.viewModels.factoryPromise.2($this$viewModels_u24default);
        } else {
            obj8 = obj6;
        }
        Intrinsics.reifiedOperationMarker(4, "VM");
        ActivityViewModelLazyKt.viewModels.3 anon = new ActivityViewModelLazyKt.viewModels.3($this$viewModels_u24default);
        ActivityViewModelLazyKt.viewModels.4 anon2 = new ActivityViewModelLazyKt.viewModels.4(obj5, $this$viewModels_u24default);
        ViewModelLazy viewModelLazy = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ViewModel.class), (Function0)anon, obj8, (Function0)anon2);
        return (Lazy)viewModelLazy;
    }
}
