package app.dogo.com.dogo_android.dogcreation.j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.lifecycle.j0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.h.ib;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.h0.k1;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;

/* compiled from: DogCreationBreedSearchDialog.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001b2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0018H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationBreedSearchDialogBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchAppScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchAppScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchViewModel;", "viewModel$delegate", "onAddNewSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "onBreedItemSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSelect", "onViewCreated", "view", "saveBreedSelectionAndDismiss", "dogBreed", "saveBreedSelectionForSession", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public class DogCreationBreedSearchDialog extends d implements i.b {

    /* renamed from: a, reason: from kotlin metadata */
    private ib binding;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements kotlin.d0.c.a<g> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final g invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(DogCreationSharedViewModel.class), this.$parameters);
        }

        public a(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements kotlin.d0.c.a<m> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final m invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(DogCreationBreedSearchViewModel.class), this.$parameters);
        }

        public b(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public l() {
        super();
        final m.a.c.j.a aVar2 = null;
        this.b = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.dogcreation.breed.l.a(this, aVar2, aVar2));
        this.c = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.dogcreation.breed.l.b(this, aVar2, aVar2));
    }

    private final g C1() {
        return (DogCreationSharedViewModel)this.b.getValue();
    }

    private final m D1() {
        return (DogCreationBreedSearchViewModel)this.c.getValue();
    }

    /* renamed from: G1, reason: from kotlin metadata */
    private final void onAddNewSelected(DogBreed item) {
        String str;
        if (item.getId() == null) {
            str = "id_custom_breed";
        }
        D1().j(str);
        onBreedItemSelected(item);
    }

    private static final void H1(l lVar, View view) {
        n.f(lVar, "this$0");
        lVar.dismissAllowingStateLoss();
    }

    private static final void I1(l lVar, View view) {
        n.f(lVar, "this$0");
        if (lVar.binding == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            binding2.Q.setText("");
            return;
        }
    }

    /* renamed from: J1, reason: from kotlin metadata */
    private final void onBreedItemSelected(DogBreed item) {
        onSelect(item);
        dismissAllowingStateLoss();
    }

    /* renamed from: K1, reason: from kotlin metadata */
    private final void onSelect(DogBreed item) {
        C1().k().postValue(item);
    }

    @Override // androidx.fragment.app.d
    /* renamed from: A0, reason: from kotlin metadata */
    public void saveBreedSelectionAndDismiss(DogBreed dogBreed) {
        n.f(dogBreed, "item");
        onAddNewSelected(dogBreed);
    }

    @Override // androidx.fragment.app.d
    public final k B1() {
        return (DogCreationBreedSearchAppScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        n.f(inflater, "inflater");
        ib ibVar = ib.T(inflater, container, false);
        n.e(ibVar, "inflate(inflater, container, false)");
        this.binding = ibVar;
        int i = 0;
        String str3 = "binding";
        if (ibVar == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            ibVar.W(D1());
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.binding.V(this);
                if (this.binding == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.binding.M(getViewLifecycleOwner());
                    if (this.binding == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        return this.binding.w();
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle) throws h {
        int i = 0;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        view = B1().b().length() > 0 ? 1 : 0;
        int i2 = 0;
        String str3 = "binding";
        if (i != 0) {
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                binding23.Q.setText(B1().b());
            }
        }
        if (this.binding == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            binding2.R.setNavigationOnClickListener(new app.dogo.com.dogo_android.dogcreation.breed.g(this));
            if (this.binding == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                binding22.O.setOnClickListener(new app.dogo.com.dogo_android.dogcreation.breed.h(this));
                return;
            }
        }
    }

    @Override // androidx.fragment.app.d
    /* renamed from: y1, reason: from kotlin metadata */
    public void saveBreedSelectionForSession(DogBreed dogBreed) {
        n.f(dogBreed, "item");
        onAddNewSelected(dogBreed);
    }


    /* renamed from: E1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(l view, View savedInstanceState) {
        DogCreationBreedSearchDialog.H1(view, savedInstanceState);
    }

    public static /* synthetic */ void F1(l lVar, View view) {
        DogCreationBreedSearchDialog.I1(lVar, view);
    }
}
