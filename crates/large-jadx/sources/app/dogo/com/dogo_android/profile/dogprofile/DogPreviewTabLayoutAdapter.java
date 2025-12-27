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

/* compiled from: DogPreviewTabLayoutAdapter.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 \u00172\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0005\u0015\u0016\u0017\u0018\u0019B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000c\u001a\u00020\nH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$BaseViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callback", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "(Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "BaseViewHolder", "CardType", "Companion", "ProfileDetailsViewHolder", "TrainingStatsViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g0, reason: from kotlin metadata */
public final class DogPreviewTabLayoutAdapter extends RecyclerView.h<g0.a> implements a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final g0.c INSTANCE = new g0$c(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final v callback;
    /* renamed from: b, reason: from kotlin metadata */
    private ProfilePreview profilePreview;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$CardType;", "", "(Ljava/lang/String;I)V", "PROFILE_DETAILS", "TRAINING_STATS", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum b {

        PROFILE_DETAILS,
        TRAINING_STATS;
        private static final /* synthetic */ g0.b[] $values() {
            app.dogo.com.dogo_android.q.p.g0.b[] arr = new g0.b[2];
            return new g0.b[] { DogPreviewTabLayoutAdapter_CardType.PROFILE_DETAILS, DogPreviewTabLayoutAdapter_CardType.TRAINING_STATS };
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$Companion;", "", "()V", "NUMBER_OF_TABS", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        private c() {
            super();
        }

        public /* synthetic */ c(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class f {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DogPreviewTabLayoutAdapter_CardType.values().length];
            iArr[DogPreviewTabLayoutAdapter_CardType.PROFILE_DETAILS.ordinal()] = 1;
            iArr[DogPreviewTabLayoutAdapter_CardType.TRAINING_STATS.ordinal()] = 2;
            app.dogo.com.dogo_android.profile.dogprofile.g0.f.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0096\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public class a extends RecyclerView.e0 {
        public a(ViewDataBinding viewDataBinding) {
            n.f(g0Var, "this$0");
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$ProfileDetailsViewHolder;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$BaseViewHolder;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/LayoutDogProfileDetailsBinding;", "(Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;Lapp/dogo/com/dogo_android/databinding/LayoutDogProfileDetailsBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/LayoutDogProfileDetailsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends g0.a {

        private final qk a;
        public d(qk qkVar) {
            n.f(g0Var, "this$0");
            n.f(qkVar, "binding");
            super(g0Var, qkVar);
            this.a = qkVar;
        }

        @Override // app.dogo.com.dogo_android.q.p.g0$a
        public final qk a() {
            return this.a;
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$TrainingStatsViewHolder;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter$BaseViewHolder;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/LayoutTrainingStreakStatsBinding;", "(Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewTabLayoutAdapter;Lapp/dogo/com/dogo_android/databinding/LayoutTrainingStreakStatsBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/LayoutTrainingStreakStatsBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class e extends g0.a {

        private final gn a;
        public e(gn gnVar) {
            n.f(g0Var, "this$0");
            n.f(gnVar, "binding");
            super(g0Var, gnVar);
            this.a = gnVar;
        }

        @Override // app.dogo.com.dogo_android.q.p.g0$a
        public final gn a() {
            return this.a;
        }
    }
    public g0(v vVar, ProfilePreview profilePreview) {
        n.f(vVar, "callback");
        n.f(profilePreview, "profilePreview");
        super();
        this.callback = vVar;
        this.profilePreview = profilePreview;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: f, reason: from kotlin metadata */
    public void onBindViewHolder(g0.a holder, int position) {
        qk qkVar;
        n.f(holder, "holder");
        z = holder instanceof DogPreviewTabLayoutAdapter_ProfileDetailsViewHolder;
        if (holder instanceof DogPreviewTabLayoutAdapter_ProfileDetailsViewHolder) {
            Object holder2 = holder;
            holder2.a().V(this.callback);
            holder2.a().W(this.profilePreview);
            holder2.a().p();
        }
        z2 = holder instanceof DogPreviewTabLayoutAdapter_TrainingStatsViewHolder;
        if (holder instanceof DogPreviewTabLayoutAdapter_TrainingStatsViewHolder) {
            holder.a().V(this.profilePreview);
            holder.a().p();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public g0.a onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.q.p.g0.e dogPreviewTabLayoutAdapter_TrainingStatsViewHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = app.dogo.com.dogo_android.profile.dogprofile.g0.f.a[DogPreviewTabLayoutAdapter_CardType.values()[viewType].ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            } else {
                gn gnVar = gn.T(from, parent, z);
                n.e(gnVar, str2);
                dogPreviewTabLayoutAdapter_TrainingStatsViewHolder = new DogPreviewTabLayoutAdapter_TrainingStatsViewHolder(this, gnVar);
                return dogPreviewTabLayoutAdapter_TrainingStatsViewHolder;
            }
        }
        qk qkVar = qk.T(from, parent, z);
        n.e(qkVar, str2);
        app.dogo.com.dogo_android.q.p.g0.d dogPreviewTabLayoutAdapter_ProfileDetailsViewHolder = new DogPreviewTabLayoutAdapter_ProfileDetailsViewHolder(this, qkVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int position) {
        app.dogo.com.dogo_android.q.p.g0.b pROFILE_DETAILS2;
        position = position == 0 ? DogPreviewTabLayoutAdapter_CardType.PROFILE_DETAILS : DogPreviewTabLayoutAdapter_CardType.TRAINING_STATS;
        return (position == 0 ? DogPreviewTabLayoutAdapter_CardType.PROFILE_DETAILS : DogPreviewTabLayoutAdapter_CardType.TRAINING_STATS);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public final void updateData(ProfilePreview profilePreview) {
        n.f(profilePreview, "profilePreview");
        this.profilePreview = profilePreview;
        notifyItemChanged(0);
    }


    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return 2;
    }
}
