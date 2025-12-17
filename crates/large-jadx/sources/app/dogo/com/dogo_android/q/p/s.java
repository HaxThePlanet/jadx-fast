package app.dogo.com.dogo_android.q.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.activity.ComponentActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.j0;
import app.dogo.com.dogo_android.dogcreation.j.i.b;
import app.dogo.com.dogo_android.h.cc;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import f.d.a.a;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.m;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0008\u0010\u001e\u001a\u00020\u0011H\u0016J\u001a\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00162\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\r¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentDogEditBreedBinding;", "screenKey", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedScreen;", "viewModel", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAddNewSelected", "", "item", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "onBreedItemSelected", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemSelected", "onResume", "onViewCreated", "view", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s extends Fragment implements i.b {

    private cc a;
    private final h b;

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a extends p implements a<app.dogo.com.dogo_android.q.p.u> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public a(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.q.p.u invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(u.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public s() {
        super();
        final int i = 0;
        s.a aVar = new s.a(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, aVar);
    }

    private final app.dogo.com.dogo_android.q.p.t B1() {
        return (t)k1.a(this);
    }

    private final app.dogo.com.dogo_android.q.p.u C1() {
        return (u)this.b.getValue();
    }

    public static void D1(app.dogo.com.dogo_android.q.p.s s, View view2) {
        s.H1(s, view2);
    }

    public static void E1(app.dogo.com.dogo_android.q.p.s s, View view2) {
        s.I1(s, view2);
    }

    public static void F1(app.dogo.com.dogo_android.q.p.s s, Boolean boolean2) {
        s.J1(s, boolean2);
    }

    private final void G1(DogBreed dogBreed) {
        String str;
        if (dogBreed.getId() == null) {
            str = "id_custom_breed";
        }
        C1().q(str);
        C1().o(dogBreed, B1().a().getId());
    }

    private static final void H1(app.dogo.com.dogo_android.q.p.s s, View view2) {
        n.f(s, "this$0");
        final androidx.fragment.app.e obj0 = s.getActivity();
        if (obj0 == null) {
        } else {
            obj0.onBackPressed();
        }
    }

    private static final void I1(app.dogo.com.dogo_android.q.p.s s, View view2) {
        n.f(s, "this$0");
        cc obj0 = s.a;
        if (obj0 == null) {
        } else {
            obj0.Q.setText("");
        }
        n.w("binding");
        throw 0;
    }

    private static final void J1(app.dogo.com.dogo_android.q.p.s s, Boolean boolean2) {
        Object activity;
        int i3;
        String str;
        int i2;
        int i4;
        int i;
        Object obj6;
        boolean obj7;
        n.f(s, "this$0");
        n.e(boolean2, "it");
        if (boolean2.booleanValue() && !s.C1().isUserSignedIn()) {
            if (!s.C1().isUserSignedIn()) {
                activity = s.getActivity();
                if (activity == null) {
                } else {
                    g1.H(activity, 0, "dog_edit", 0, 5, 0);
                }
            }
            obj6 = s.getActivity();
            if (obj6 == null) {
            } else {
                g1.O(obj6);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void A0(DogBreed dogBreed) {
        n.f(dogBreed, "item");
        G1(dogBreed);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        cc obj2 = cc.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.a = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(C1());
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
                        obj2 = obj2.w();
                        n.e(obj2, "binding.root");
                        return obj2;
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        androidx.fragment.app.e activity;
        super.onResume();
        if (activity instanceof a0) {
        } else {
            activity = 0;
        }
        if (activity == null) {
        } else {
            activity.F();
        }
    }

    @Override // androidx.fragment.app.Fragment
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
            d dVar = new d(this);
            obj3.R.setNavigationOnClickListener(dVar);
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj4 = new e(this);
                obj3.O.setOnClickListener(obj4);
                obj4 = getViewLifecycleOwner();
                n.e(obj4, "viewLifecycleOwner");
                f fVar = new f(this);
                C1().k().observe(obj4, fVar);
            }
            n.w(str3);
            throw obj4;
        }
        n.w(str3);
        throw obj4;
    }

    @Override // androidx.fragment.app.Fragment
    public void y1(DogBreed dogBreed) {
        n.f(dogBreed, "item");
        G1(dogBreed);
    }
}
