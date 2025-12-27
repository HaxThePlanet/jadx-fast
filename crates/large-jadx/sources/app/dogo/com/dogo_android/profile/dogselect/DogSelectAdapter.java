package app.dogo.com.dogo_android.q.q;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.q0;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.j1;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogSelectAdapter.kt */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001c\u001dB'\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u000c\u001a\u00020\u0007H\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "initialSelectedPosition", "", "callbacks", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;", "(Ljava/util/List;ILapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;)V", "lastSelectedPosition", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setupDogAvatar", "profile", "imageView", "Landroid/widget/ImageView;", "setupDogName", "nameTextView", "Landroid/widget/TextView;", "DogSelectCallback", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class DogSelectAdapter extends RecyclerView.h<f.b> {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<DogProfile> callbacks;
    /* renamed from: b, reason: from kotlin metadata */
    private final f.a lastSelectedPosition;
    /* renamed from: c, reason: from kotlin metadata */
    private int list;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H&¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;", "", "onAddDogClick", "", "userPremium", "", "onItemClick", "dogId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: J0, reason: from kotlin metadata */
        void onAddDogClick(String userPremium);

        /* renamed from: U0, reason: from kotlin metadata */
        void onItemClick(boolean dogId);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeDogSelectRowBinding;", "(Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter;Lapp/dogo/com/dogo_android/databinding/CellChallengeDogSelectRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellChallengeDogSelectRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final q0 a;
        final /* synthetic */ f b;
        public b(q0 q0Var) {
            n.f(fVar, "this$0");
            n.f(q0Var, "binding");
            this.b = fVar;
            super(q0Var.w());
            this.a = q0Var;
            q0Var.w().setOnClickListener(new app.dogo.com.dogo_android.profile.dogselect.a(fVar, this));
        }

        private static final void a(f fVar, f.b bVar, View view) {
            n.f(fVar, "this$0");
            n.f(bVar, "this$1");
            fVar.list = bVar.getAdapterPosition();
            fVar.notifyItemChanged(fVar.list);
            fVar.notifyItemChanged(bVar.getAdapterPosition());
            final app.dogo.com.dogo_android.q.q.f.a aVar = fVar.lastSelectedPosition;
            if (aVar != null) {
                aVar.onAddDogClick((DogProfile)fVar.callbacks.get(bVar.getAdapterPosition()).getId());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final q0 b() {
            return this.a;
        }

        public static /* synthetic */ void c(f fVar, f.b bVar, View view) {
            DogSelectAdapter_Holder.a(fVar, bVar, view);
        }
    }
    public f(List<DogProfile> list, int i, f.a aVar) {
        n.f(list, "list");
        super();
        this.callbacks = list;
        this.lastSelectedPosition = aVar;
        this.list = i;
    }

    public static final /* synthetic */ f.a f(f fVar) {
        return fVar.lastSelectedPosition;
    }

    public static final /* synthetic */ int g(f fVar) {
        return fVar.list;
    }

    public static final /* synthetic */ List h(f fVar) {
        return fVar.callbacks;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ void onBindViewHolder(f holder, int position) {
        holder.list = position;
    }

    /* renamed from: m, reason: from kotlin metadata */
    private final void onCreateViewHolder(DogProfile parent, ImageView viewType) throws android.content.res.Resources.NotFoundException {
        android.content.Context context = viewType.getContext();
        n.e(context, "imageView.context");
        str = "avatar.jpg";
        android.net.Uri uri = app.dogo.com.dogo_android.util.extensionfunction.i1.d(context, parent.getId(), str);
        if (uri != null) {
            MyAppGlideModule.e(uri, viewType);
        } else {
            viewType.setImageDrawable(viewType.getResources().getDrawable(2131231265, null));
        }
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void setupDogAvatar(DogProfile profile, TextView imageView) {
        final Resources resources = imageView.getResources();
        n.e(resources, "nameTextView.resources");
        imageView.setText(app.dogo.com.dogo_android.util.extensionfunction.j1.W0(profile.getName(), resources));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callbacks.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: j, reason: from kotlin metadata */
    public void setupDogName(f.b profile, int nameTextView) throws android.content.res.Resources.NotFoundException {
        n.f(profile, "holder");
        Object item = this.callbacks.get(nameTextView);
        q0 q0Var = profile.b();
        final android.content.res.Resources.Theme theme = null;
        if (nameTextView == this.list) {
            q0Var.O.setVisibility(0);
            int i = 2131100352;
            q0Var.Q.setTextColor(q0Var.w().getResources().getColor(i, theme));
        } else {
            q0Var.O.setVisibility(8);
            i = 2131099767;
            q0Var.Q.setTextColor(q0Var.w().getResources().getColor(i, theme));
        }
        n.e(q0Var.P, "binding.profileAvatar");
        onCreateViewHolder(item, q0Var.P);
        n.e(q0Var.Q, "binding.profileName");
        setupDogAvatar(item, q0Var.Q);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public f.b l(ViewGroup viewGroup, int i) {
        n.f(viewGroup, "parent");
        final q0 q0Var = q0.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(q0Var, "inflate(inflater, parent, false)");
        return new DogSelectAdapter_Holder(this, q0Var);
    }
}
