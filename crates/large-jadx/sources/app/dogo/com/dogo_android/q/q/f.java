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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001c\u001dB'\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u000c\u001a\u00020\u0007H\u0016J\u001c\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$Holder;", "list", "", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "initialSelectedPosition", "", "callbacks", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;", "(Ljava/util/List;ILapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;)V", "lastSelectedPosition", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setupDogAvatar", "profile", "imageView", "Landroid/widget/ImageView;", "setupDogName", "nameTextView", "Landroid/widget/TextView;", "DogSelectCallback", "Holder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends RecyclerView.h<app.dogo.com.dogo_android.q.q.f.b> {

    private final List<DogProfile> a;
    private final app.dogo.com.dogo_android.q.q.f.a b;
    private int c;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H&¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;", "", "onAddDogClick", "", "userPremium", "", "onItemClick", "dogId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void J0(String string);

        public abstract void U0(boolean z);
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellChallengeDogSelectRowBinding;", "(Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter;Lapp/dogo/com/dogo_android/databinding/CellChallengeDogSelectRowBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellChallengeDogSelectRowBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final q0 a;
        final app.dogo.com.dogo_android.q.q.f b;
        public b(app.dogo.com.dogo_android.q.q.f f, q0 q02) {
            n.f(f, "this$0");
            n.f(q02, "binding");
            this.b = f;
            super(q02.w());
            this.a = q02;
            a aVar = new a(f, this);
            q02.w().setOnClickListener(aVar);
        }

        private static final void a(app.dogo.com.dogo_android.q.q.f f, app.dogo.com.dogo_android.q.q.f.b f$b2, View view3) {
            int obj3;
            n.f(f, "this$0");
            n.f(b2, "this$1");
            f.i(f, b2.getAdapterPosition());
            f.notifyItemChanged(f.g(f));
            f.notifyItemChanged(b2.getAdapterPosition());
            final app.dogo.com.dogo_android.q.q.f.a obj2 = f.f(f);
            if (obj2 == null) {
            } else {
                obj2.J0((DogProfile)f.h(f).get(b2.getAdapterPosition()).getId());
            }
        }

        public static void c(app.dogo.com.dogo_android.q.q.f f, app.dogo.com.dogo_android.q.q.f.b f$b2, View view3) {
            f.b.a(f, b2, view3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final q0 b() {
            return this.a;
        }
    }
    public f(List<DogProfile> list, int i2, app.dogo.com.dogo_android.q.q.f.a f$a3) {
        n.f(list, "list");
        super();
        this.a = list;
        this.b = a3;
        this.c = i2;
    }

    public static final app.dogo.com.dogo_android.q.q.f.a f(app.dogo.com.dogo_android.q.q.f f) {
        return f.b;
    }

    public static final int g(app.dogo.com.dogo_android.q.q.f f) {
        return f.c;
    }

    public static final List h(app.dogo.com.dogo_android.q.q.f f) {
        return f.a;
    }

    public static final void i(app.dogo.com.dogo_android.q.q.f f, int i2) {
        f.c = i2;
    }

    private final void m(DogProfile dogProfile, ImageView imageView2) {
        android.content.Context context;
        String str;
        Object obj3;
        context = imageView2.getContext();
        n.e(context, "imageView.context");
        obj3 = i1.d(context, dogProfile.getId(), "avatar.jpg");
        if (obj3 != null) {
            MyAppGlideModule.e(obj3, imageView2);
        } else {
            imageView2.setImageDrawable(imageView2.getResources().getDrawable(2131231265, 0));
        }
    }

    private final void n(DogProfile dogProfile, TextView textView2) {
        final Resources resources = textView2.getResources();
        n.e(resources, "nameTextView.resources");
        textView2.setText(j1.W0(dogProfile.getName(), resources));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void j(app.dogo.com.dogo_android.q.q.f.b f$b, int i2) {
        int color;
        int i;
        TextView obj6;
        n.f(b, "holder");
        Object obj = this.a.get(i2);
        q0 obj5 = b.b();
        final int i6 = 0;
        if (i2 == this.c) {
            obj5.O.setVisibility(0);
            obj5.Q.setTextColor(obj5.w().getResources().getColor(2131100352, i6));
        } else {
            obj5.O.setVisibility(8);
            obj5.Q.setTextColor(obj5.w().getResources().getColor(2131099767, i6));
        }
        obj6 = obj5.P;
        n.e(obj6, "binding.profileAvatar");
        m((DogProfile)obj, obj6);
        obj5 = obj5.Q;
        n.e(obj5, "binding.profileName");
        n(obj, obj5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.q.q.f.b l(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final q0 obj3 = q0.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj3, "inflate(inflater, parent, false)");
        f.b bVar = new f.b(this, obj3);
        return bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        j((f.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return l(viewGroup, i2);
    }
}
