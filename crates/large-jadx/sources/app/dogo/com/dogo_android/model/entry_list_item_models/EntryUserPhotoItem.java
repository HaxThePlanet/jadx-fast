package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.c.a;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.viewpager.widget.ViewPager;
import app.dogo.com.dogo_android.h.k2;
import app.dogo.com.dogo_android.h.sk;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.m2;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.m;
import app.dogo.com.dogo_android.util.n0.d;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.l;
import app.dogo.com.dogo_android.util.o;
import app.dogo.com.dogo_android.util.p;
import com.bumptech.glide.j;
import com.bumptech.glide.r.g;
import com.google.firebase.Timestamp;
import f.c.a.e.s.b;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.f;
import java.util.List;

/* loaded from: classes.dex */
public class EntryUserPhotoItem extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem<app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder, app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem> implements app.dogo.com.dogo_android.model.entry_list_item_models.PhotoEntryGroup {

    private String id;
    private boolean isPremium;
    private int lastPhotoPosition = 0;
    private ChallengeEntryModel model;

    public static final class ViewHolder extends app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder {

        final int fanImagePaddingInPx;
        final int fanImageSizeInPx;
        private k2 holderBinding;
        private int lastSavedPosition;
        private Resources resources;
        private app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable vm;
        public ViewHolder(View view, e e2) {
            int i;
            super(view, e2);
            this.resources = view.getResources();
            this.holderBinding = k2.T(view);
            EntryUserPhotoObservable obj4 = new EntryUserPhotoObservable();
            this.vm = obj4;
            this.holderBinding.X(obj4);
            obj4.O.T(this.vm);
            this.holderBinding.W(e2.l2());
            obj4.O.U(e2.l2());
            obj4.T.w().setVisibility(8);
            setupEntryCell(this.holderBinding, e2);
            this.fanImageSizeInPx = Math.round(this.resources.getDimension(2131165952));
            this.fanImagePaddingInPx = Math.round(this.resources.getDimension(2131165897));
            createFanLineView();
            this.vm.setParentTag(e2.d2().getTag());
            obj4 = obj4.O;
            t tVar = new t(this, obj4.S, e2);
            obj4.g0.setOnClickListener(tVar);
            EntryUserPhotoItem.ViewHolder.1 anon = new EntryUserPhotoItem.ViewHolder.1(this, e2);
            obj4.S.c(anon);
            i = App.q() ? 0 : i;
            obj4.V.setVisibility(i);
            s obj5 = new s(this);
            obj4.V.setOnClickListener(obj5);
        }

        static int access$000(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder) {
            return viewHolder.lastSavedPosition;
        }

        static app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable access$100(app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder) {
            return viewHolder.vm;
        }

        private void createFanLineView() {
            int childCount;
            int fanImagePaddingInPx;
            int i;
            int i2;
            int i3;
            k2 holderBinding = this.holderBinding;
            final LinearLayout linearLayout = holderBinding.Q;
            Object[] arr = new Object[1];
            i2 = 0;
            arr[i2] = "9999";
            holderBinding.P.setText(this.resources.getString(2131886283, arr));
            holderBinding2.P.measure(i2, i2);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.holderBinding.V().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (linearLayout.getChildCount() == 0) {
            }
        }

        private boolean d(int i, List list2, int i3) {
            Object childAt;
            Object entryUserPhotoObservable;
            int avatar;
            Object str;
            Resources resources;
            boolean obj8;
            final int i2 = 0;
            if (this.itemView.isAttachedToWindow()) {
                obj8 = i2;
                while (obj8 < i) {
                    childAt = holderBinding.Q.getChildAt(obj8);
                    DogProfileModel dogProfile = (ChallengeEntryVoter)list2.get(obj8).getDogProfile();
                    if (dogProfile != null) {
                    } else {
                    }
                    avatar = 0;
                    m.a(holderBinding2.Q.getContext()).D(avatar).X0(2131231265).p1(MyAppGlideModule.d((ImageView)childAt.getContext())).R0(g.q0()).C0(childAt);
                    obj8++;
                    avatar = dogProfile.getAvatar(this.resources);
                    this.vm.trackError("fanLineLength", childAt);
                }
            }
            return i2;
        }

        private void f(ViewPager viewPager, e e2, View view3) {
            boolean z;
            ImageView obj2;
            app.dogo.com.dogo_android.util.e0.a0 obj3;
            final androidx.viewpager.widget.a obj4 = viewPager.getAdapter();
            if (obj4 instanceof l) {
                this.vm.callChallengeShareDialog((l)obj4.u(viewPager.getCurrentItem()), e2.l2());
            }
        }

        private void h(View view) {
            App.h().s0(this.vm.getModel().getDocumentId());
        }

        private void j(e e, DialogInterface dialogInterface2, int i3) {
            int obj2;
            obj2 = this.vm;
            if (obj2.onDeleteRequest(obj2.getPagePosition())) {
                e.removeItem(getAdapterPosition());
            } else {
                e.notifyItemChanged(getAdapterPosition());
            }
        }

        private void l(e e, View view2) {
            b bVar = new b(view2.getContext());
            q qVar = new q(this, e);
            bVar.w(2131886269).D(2131886714, qVar).y(2131886744, 0).o();
        }

        private void resetFanLine() {
            int i;
            View childAt;
            o oVar;
            g gVar;
            i = 0;
            while (i < holderBinding.Q.getChildCount()) {
                m.a(holderBinding3.Q.getContext()).B(2131231265).R0(g.q0()).C0((ImageView)holderBinding2.Q.getChildAt(i));
                i++;
            }
        }

        private void setupEntryCell(k2 k2, e e2) {
            r rVar = new r(this, e2);
            obj2.f0.setOnClickListener(rVar);
            updateFeaturedStarVisibility(this.vm, obj3.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public boolean e(int i, List list2, int i3) {
            return d(i, list2, i3);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void g(ViewPager viewPager, e e2, View view3) {
            f(viewPager, e2, view3);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void i(View view) {
            h(view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void k(e e, DialogInterface dialogInterface2, int i3) {
            j(e, dialogInterface2, i3);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void loadFans() {
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout;
            app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable entryUserPhotoObservable;
            app.dogo.com.dogo_android.model.entry_list_item_models.u uVar;
            int i;
            Object[] arr;
            String valueOf;
            int i2;
            int childCount = holderBinding.Q.getChildCount();
            if (childCount < this.vm.getFanCount()) {
                arr = new Object[1];
                i2 = 0;
                arr[i2] = String.valueOf(fanCount2 -= childCount);
                holderBinding4.P.setText(this.resources.getString(2131886283, arr));
                uVar = new u(this, childCount);
                this.vm.getFans(childCount, uVar);
                holderBinding2.R.setVisibility(i2);
            } else {
                holderBinding3.R.setVisibility(8);
            }
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void m(e e, View view2) {
            l(e, view2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void setModel(ChallengeEntryModel challengeEntryModel, int i2, boolean z3) {
            this.vm.setModel(challengeEntryModel, z3);
            this.vm.update();
            updateFeaturedStarVisibility(this.vm, holderBinding.O);
            resetFanLine();
            l lVar = new l(challengeEntryModel, challengeEntryModel.isPhotoUploading(System.currentTimeMillis()));
            obj6.S.setAdapter(lVar);
            obj4.S.setCurrentItem(i2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.vm.notifyChangeAll();
        }
    }
    public EntryUserPhotoItem(ChallengeEntryModel challengeEntryModel, String string2, boolean z3) {
        super(0);
        this.id = string2;
        this.model = challengeEntryModel;
        this.isPremium = z3;
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (EntryUserPhotoItem.ViewHolder)e02, i3, list4);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(b b, app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder2, int i3, List list4) {
        int obj1;
        obj1 = (d)b.e2("position");
        if (obj1 instanceof Integer) {
            obj1 = (Integer)obj1.intValue();
        } else {
            obj1 = 0;
        }
        viewHolder2.setModel(this.model, obj1, this.isPremium);
        viewHolder2.loadFans();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeCommentCountBy(int i) {
        this.model.updateCommentCount(i);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder createViewHolder(View view, b b2) {
        EntryUserPhotoItem.ViewHolder viewHolder = new EntryUserPhotoItem.ViewHolder(view, (e)b2);
        return viewHolder;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof EntryUserPhotoItem) {
            return this.id.equals(object.id);
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return 2131558490;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public ChallengeEntryModel getModel() {
        return this.model;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isItemOlderThen(app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem entryItem) {
        Timestamp date;
        boolean date2;
        int i;
        int seconds2;
        int seconds;
        Object obj7;
        i = 0;
        if (entryItem instanceof EntryUserPhotoItem) {
            if (this.model.getDate() != null) {
                seconds = this.model.getDate().getSeconds();
            } else {
                seconds = seconds2;
            }
            if (entryItem.model.getDate() != null) {
                seconds2 = entryItem.model.getDate().getSeconds();
            }
            if (Long.compare(seconds, seconds2) < 0) {
                i = 1;
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setUploadFail(boolean z) {
        this.model.setUploadFailed(z);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void unbindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3) {
        unbindViewHolder(b, (EntryUserPhotoItem.ViewHolder)e02, i3);
    }

    public void unbindViewHolder(b<f> b, app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoItem.ViewHolder entryUserPhotoItem$ViewHolder2, int i3) {
        super.unbindViewHolder(b, viewHolder2, i3);
        this.lastPhotoPosition = EntryUserPhotoItem.ViewHolder.access$000(viewHolder2);
    }
}
