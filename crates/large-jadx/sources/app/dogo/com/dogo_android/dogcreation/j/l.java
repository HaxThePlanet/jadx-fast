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
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001b2\u0008\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0018H\u0002J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006(", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchDialog;", "Landroidx/fragment/app/DialogFragment;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogCreationBreedSearchDialogBinding;", "screenKey", "Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchAppScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchAppScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/DogCreationSharedViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/dogcreation/breed/DogCreationBreedSearchViewModel;", "viewModel$delegate", "onAddNewSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "onBreedItemSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onSelect", "onViewCreated", "view", "saveBreedSelectionAndDismiss", "dogBreed", "saveBreedSelectionForSession", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class l extends d implements app.dogo.com.dogo_android.dogcreation.j.i.b {

    private ib a;
    private final h b;
    private final h c;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<g> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public a(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final g invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(g.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<app.dogo.com.dogo_android.dogcreation.j.m> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public b(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.dogcreation.j.m invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(m.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public l() {
        super();
        final int i = 0;
        l.a aVar = new l.a(this, i, i);
        this.b = j.a(m.NONE, aVar);
        l.b bVar = new l.b(this, i, i);
        this.c = j.a(m.SYNCHRONIZED, bVar);
    }

    private final g C1() {
        return (g)this.b.getValue();
    }

    private final app.dogo.com.dogo_android.dogcreation.j.m D1() {
        return (m)this.c.getValue();
    }

    public static void E1(app.dogo.com.dogo_android.dogcreation.j.l l, View view2) {
        l.H1(l, view2);
    }

    public static void F1(app.dogo.com.dogo_android.dogcreation.j.l l, View view2) {
        l.I1(l, view2);
    }

    private final void G1(DogBreed dogBreed) {
        String str;
        if (dogBreed.getId() == null) {
            str = "id_custom_breed";
        }
        D1().j(str);
        J1(dogBreed);
    }

    private static final void H1(app.dogo.com.dogo_android.dogcreation.j.l l, View view2) {
        n.f(l, "this$0");
        l.dismissAllowingStateLoss();
    }

    private static final void I1(app.dogo.com.dogo_android.dogcreation.j.l l, View view2) {
        n.f(l, "this$0");
        ib obj0 = l.a;
        if (obj0 == null) {
        } else {
            obj0.Q.setText("");
        }
        n.w("binding");
        throw 0;
    }

    private final void J1(DogBreed dogBreed) {
        K1(dogBreed);
        dismissAllowingStateLoss();
    }

    private final void K1(DogBreed dogBreed) {
        C1().k().postValue(dogBreed);
    }

    @Override // androidx.fragment.app.d
    public void A0(DogBreed dogBreed) {
        n.f(dogBreed, "item");
        G1(dogBreed);
    }

    @Override // androidx.fragment.app.d
    public final app.dogo.com.dogo_android.dogcreation.j.k B1() {
        return (k)k1.a(this);
    }

    @Override // androidx.fragment.app.d
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ib obj2 = ib.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(D1());
            obj2 = this.a;
            if (obj2 == null) {
            } else {
                obj2.V(this);
                obj2 = this.a;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.a;
                    if (obj2 == null) {
                    } else {
                        return obj2.w();
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // androidx.fragment.app.d
    public void onViewCreated(View view, Bundle bundle2) {
        String str;
        int obj3;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        obj3 = B1().b().length() > 0 ? 1 : 0;
        int obj4 = 0;
        String str3 = "binding";
        if (obj3 != null) {
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj3.Q.setText(B1().b());
            }
            n.w(str3);
            throw obj4;
        }
        obj3 = this.a;
        if (obj3 == null) {
        } else {
            g gVar = new g(this);
            obj3.R.setNavigationOnClickListener(gVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj4 = new h(this);
                obj3.O.setOnClickListener(obj4);
            }
            n.w(str3);
            throw obj4;
        }
        n.w(str3);
        throw obj4;
    }

    @Override // androidx.fragment.app.d
    public void y1(DogBreed dogBreed) {
        n.f(dogBreed, "item");
        G1(dogBreed);
    }
}
