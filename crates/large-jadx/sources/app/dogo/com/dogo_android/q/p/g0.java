package app.dogo.com.dogo_android.q.p;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.gn;
import app.dogo.com.dogo_android.h.qk;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.util.d0.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 \u00172\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0005\u0015\u0016\u0017\u0018\u0019B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$BaseViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "(Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "BaseViewHolder", "CardType", "Companion", "ProfileDetailsViewHolder", "TrainingStatsViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g0 extends RecyclerView.h<app.dogo.com.dogo_android.q.p.g0.a> implements a {

    public static final app.dogo.com.dogo_android.q.p.g0.c Companion;
    private final app.dogo.com.dogo_android.q.p.v a;
    private ProfilePreview b;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$CardType;", "", "(Ljava/lang/String;I)V", "PROFILE_DETAILS", "TRAINING_STATS", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum b {

        PROFILE_DETAILS,
        TRAINING_STATS;
        private static final app.dogo.com.dogo_android.q.p.g0.b[] $values() {
            app.dogo.com.dogo_android.q.p.g0.b[] arr = new g0.b[2];
            return arr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$Companion;", "", "()V", "NUMBER_OF_TABS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        public c(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[g0.b.PROFILE_DETAILS.ordinal()] = 1;
            iArr[g0.b.TRAINING_STATS.ordinal()] = 2;
            g0.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public class a extends RecyclerView.e0 {
        public a(app.dogo.com.dogo_android.q.p.g0 g0, ViewDataBinding viewDataBinding2) {
            n.f(g0, "this$0");
            n.f(viewDataBinding2, "bind");
            super(viewDataBinding2.w());
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$ProfileDetailsViewHolder;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$BaseViewHolder;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/LayoutDogProfileDetailsBinding;", "(Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;Lapp/dogo/com/dogo_android/databinding/LayoutDogProfileDetailsBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/LayoutDogProfileDetailsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends app.dogo.com.dogo_android.q.p.g0.a {

        private final qk a;
        public d(app.dogo.com.dogo_android.q.p.g0 g0, qk qk2) {
            n.f(g0, "this$0");
            n.f(qk2, "binding");
            super(g0, qk2);
            this.a = qk2;
        }

        @Override // app.dogo.com.dogo_android.q.p.g0$a
        public final qk a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$TrainingStatsViewHolder;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$BaseViewHolder;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/LayoutTrainingStreakStatsBinding;", "(Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;Lapp/dogo/com/dogo_android/databinding/LayoutTrainingStreakStatsBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/LayoutTrainingStreakStatsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends app.dogo.com.dogo_android.q.p.g0.a {

        private final gn a;
        public e(app.dogo.com.dogo_android.q.p.g0 g0, gn gn2) {
            n.f(g0, "this$0");
            n.f(gn2, "binding");
            super(g0, gn2);
            this.a = gn2;
        }

        @Override // app.dogo.com.dogo_android.q.p.g0$a
        public final gn a() {
            return this.a;
        }
    }
    static {
        g0.c cVar = new g0.c(0);
        g0.Companion = cVar;
    }

    public g0(app.dogo.com.dogo_android.q.p.v v, ProfilePreview profilePreview2) {
        n.f(v, "callback");
        n.f(profilePreview2, "profilePreview");
        super();
        this.a = v;
        this.b = profilePreview2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void f(app.dogo.com.dogo_android.q.p.g0.a g0$a, int i2) {
        qk qkVar;
        ProfilePreview profilePreview;
        Object obj3;
        boolean obj4;
        n.f(a, "holder");
        if (a instanceof g0.d) {
            obj4 = a;
            (g0.d)obj4.a().V(this.a);
            obj4.a().W(this.b);
            obj4.a().p();
        }
        if (a instanceof g0.e) {
            (g0.e)a.a().V(this.b);
            a.a().p();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.q.p.g0.a g(ViewGroup viewGroup, int i2) {
        int i;
        ViewDataBinding obj5;
        app.dogo.com.dogo_android.q.p.g0.a obj6;
        n.f(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        obj6 = g0.f.a[g0.b.values()[i2].ordinal()];
        final String str2 = "inflate(inflater, parent, false)";
        final int i3 = 0;
        if (obj6 != 1) {
            if (obj6 != 2) {
            } else {
                obj5 = gn.T(from, viewGroup, i3);
                n.e(obj5, str2);
                obj6 = new g0.e(this, obj5);
                return obj6;
            }
            obj5 = new NoWhenBranchMatchedException();
            throw obj5;
        }
        obj5 = qk.T(from, viewGroup, i3);
        n.e(obj5, str2);
        obj6 = new g0.d(this, obj5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        app.dogo.com.dogo_android.q.p.g0.b obj1;
        obj1 = i == 0 ? g0.b.PROFILE_DETAILS : g0.b.TRAINING_STATS;
        return obj1.ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void h(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        this.b = profilePreview;
        notifyItemChanged(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        f((g0.a)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return g(viewGroup, i2);
    }
}
