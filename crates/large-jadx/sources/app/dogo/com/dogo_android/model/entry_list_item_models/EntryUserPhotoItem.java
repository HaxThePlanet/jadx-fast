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
import h.a.b.h.a;
import h.a.b.h.f;
import java.util.List;

/* compiled from: EntryUserPhotoItem.java */
/* loaded from: classes.dex */
public class EntryUserPhotoItem extends EntryItem<EntryUserPhotoItem.ViewHolder, EntrySortingTabItem> implements PhotoEntryGroup {

    private String id;
    private boolean isPremium;
    private int lastPhotoPosition = 0;
    private ChallengeEntryModel model;

    public static final class ViewHolder extends EntryViewHolder {

        final int fanImagePaddingInPx;
        final int fanImageSizeInPx;
        private k2 holderBinding;
        private int lastSavedPosition;
        private Resources resources;
        private EntryUserPhotoObservable vm = new EntryUserPhotoObservable();
        public ViewHolder(View view, e eVar) throws android.content.res.Resources.NotFoundException {
            int i = 8;
            super(view, eVar);
            this.resources = view.getResources();
            this.holderBinding = k2.T(view);
            this.holderBinding.X(new EntryUserPhotoObservable());
            this.holderBinding.O.T(this.vm);
            this.holderBinding.W(eVar.l2());
            this.holderBinding.O.U(eVar.l2());
            i = 8;
            this.holderBinding.O.T.w().setVisibility(i);
            setupEntryCell(this.holderBinding, eVar);
            this.fanImageSizeInPx = Math.round(this.resources.getDimension(2131165952));
            this.fanImagePaddingInPx = Math.round(this.resources.getDimension(2131165897));
            createFanLineView();
            this.vm.setParentTag(eVar.d2().getTag());
            skVar4.g0.setOnClickListener(new t(this, skVar4.S, eVar));
            this.holderBinding.O.S.c(new EntryUserPhotoItem.ViewHolder.AnonymousClass1(this, eVar));
            i = App.q() ? 0 : i;
            this.holderBinding.O.V.setVisibility(i);
            this.holderBinding.O.V.setOnClickListener(new s(this));
        }

        static /* synthetic */ int access$000(EntryUserPhotoItem.ViewHolder viewHolder) {
            return viewHolder.lastSavedPosition;
        }

        static /* synthetic */ EntryUserPhotoObservable access$100(EntryUserPhotoItem.ViewHolder viewHolder) {
            return viewHolder.vm;
        }

        private void createFanLineView() throws android.content.res.Resources.NotFoundException {
            int childCount;
            int fanImagePaddingInPx2;
            int i = 2131886283;
            int i2 = 0;
            android.content.res.Resources.Theme theme = null;
            Object[] arr = new Object[1];
            i2 = 0;
            arr[i2] = "9999";
            i = 2131886283;
            holderBinding2.P.setText(this.resources.getString(i, arr));
            this.holderBinding.P.measure(i2, i2);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.holderBinding.V().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (holderBinding2.Q.getChildCount() == 0) {
                while (i2 < (displayMetrics.widthPixels - this.holderBinding.P.getMeasuredWidth()) / (this.fanImageSizeInPx + this.fanImagePaddingInPx)) {
                    ImageView imageView = new ImageView(holderBinding2.Q.getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fanImageSizeInPx22, fanImageSizeInPx22);
                    layoutParams.setMarginEnd(this.fanImagePaddingInPx);
                    imageView.setLayoutParams(layoutParams);
                    theme = null;
                    imageView.setBackground(this.resources.getDrawable(2131231300, theme));
                    i = 2131231265;
                    imageView.setImageDrawable(this.resources.getDrawable(i, theme));
                    holderBinding2.Q.addView(imageView);
                    i2 = i2 + 1;
                }
            }
        }

        private /* synthetic */ boolean d(int i, List list, int i2) {
            View childAt;
            o oVar;
            String avatar = null;
            g gVar;
            Resources resources2;
            i2 = 0;
            if (this.itemView.isAttachedToWindow()) {
                while (this.itemView < i) {
                    try {
                        childAt = this.holderBinding.Q.getChildAt(i2);
                        DogProfileModel dogProfile = (ChallengeEntryVoter)list.get(i2).getDogProfile();
                        m.a(this.holderBinding.Q.getContext()).D(avatar).X0(2131231265).p1(MyAppGlideModule.d(childAt.getContext())).R0(g.q0()).C0(childAt);
                    } catch (Exception e) {
                        this.vm.trackError("fanLineLength", e);
                    }
                    i2 = i2 + 1;
                }
            }
            return false;
        }

        private /* synthetic */ void f(ViewPager viewPager, e eVar, View view) {
            final androidx.viewpager.widget.a adapter = viewPager.getAdapter();
            z = adapter instanceof EntryImagePagerAdapter;
            if (adapter instanceof EntryImagePagerAdapter) {
                this.vm.callChallengeShareDialog(adapter.getImageViewAt(viewPager.getCurrentItem()), eVar.l2());
            }
        }

        private /* synthetic */ void h(View view) {
            App.h().s0(this.vm.getModel().getDocumentId());
        }

        private /* synthetic */ void j(e eVar, DialogInterface dialogInterface, int i) {
            if (this.vm.onDeleteRequest(this.vm.getPagePosition())) {
                eVar.removeItem(getAdapterPosition());
            } else {
                eVar.notifyItemChanged(getAdapterPosition());
            }
        }

        private /* synthetic */ void l(e eVar, View view) {
            new b(view.getContext()).w(2131886269).D(2131886714, new q(this, eVar)).y(2131886744, null).o();
        }

        private void resetFanLine() {
            int i = 0;
            i = 0;
            while (i < this.holderBinding.Q.getChildCount()) {
                m.a(this.holderBinding.Q.getContext()).B(2131231265).R0(g.q0()).C0((ImageView)this.holderBinding.Q.getChildAt(i));
                i = i + 1;
            }
        }

        private void setupEntryCell(k2 k2Var, e eVar) {
            k2Var.O.f0.setOnClickListener(new r(this, eVar));
            updateFeaturedStarVisibility(this.vm, this.holderBinding.O);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void loadFans() throws android.content.res.Resources.NotFoundException {
            int childCount = this.holderBinding.Q.getChildCount();
            if (childCount < this.vm.getFanCount()) {
                int i = 2131886283;
                Object[] arr = new Object[1];
                int i2 = 0;
                arr[i2] = String.valueOf(this.vm.getFanCount() - childCount);
                this.holderBinding.P.setText(this.resources.getString(i, arr));
                this.vm.getFans(childCount, new u(this, childCount));
                this.holderBinding.R.setVisibility(i2);
            } else {
                this.holderBinding.R.setVisibility(8);
            }
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void setModel(ChallengeEntryModel challengeEntryModel, int i, boolean z) {
            this.vm.setModel(challengeEntryModel, z);
            this.vm.update();
            updateFeaturedStarVisibility(this.vm, this.holderBinding.O);
            resetFanLine();
            this.holderBinding.O.S.setAdapter(new EntryImagePagerAdapter(challengeEntryModel, challengeEntryModel.isPhotoUploading(System.currentTimeMillis())));
            this.holderBinding.O.S.setCurrentItem(i);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void updateView() {
            this.vm.notifyChangeAll();
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ boolean e(int i, List list, int i2) {
            return d(i, list, i2);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void g(ViewPager viewPager, e eVar, View view) {
            f(viewPager, eVar, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void i(View view) {
            h(view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void k(e eVar, DialogInterface dialogInterface, int i) {
            j(eVar, dialogInterface, i);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public /* synthetic */ void m(e eVar, View view) {
            l(eVar, view);
        }

        @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryViewHolder
        public void onUserView(boolean z) {
        }
    }
    public EntryUserPhotoItem(ChallengeEntryModel challengeEntryModel, String str, boolean z) {
        super(null);
        this.id = str;
        this.model = challengeEntryModel;
        this.isPremium = z;
        setSelectable(false);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void changeCommentCountBy(int i) {
        this.model.updateCommentCount(i);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean equals(Object object) {
        if (object instanceof EntryUserPhotoItem) {
            return this.id.equals(object.id);
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public String getId() {
        return this.id;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public ChallengeEntryModel getModel() {
        return this.model;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public boolean isItemOlderThen(EntryItem entryItem) {
        boolean z2 = false;
        int i = 0;
        z = entryItem instanceof EntryUserPhotoItem;
        int i2 = 0;
        if (entryItem instanceof EntryUserPhotoItem) {
            i = 0;
            if (this.model.getDate() != null) {
                long seconds2 = this.model.getDate().getSeconds();
            } else {
            }
            if (entryItem.model.getDate() != null) {
                long seconds = entryItem.model.getDate().getSeconds();
            }
            if (i < i) {
                int i3 = 1;
            }
        }
        return z2;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void setUploadFail(boolean z) {
        this.model.setUploadFailed(z);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void bindViewHolder(h.a.b.b bVar, EntryUserPhotoItem.ViewHolder viewHolder, int i, List list) {
        int value = 0;
        java.io.Serializable serializable = bVar.e2("position");
        if (serializable instanceof Integer) {
            value = serializable.intValue();
        } else {
            value = 0;
        }
        viewHolder.setModel(this.model, value, this.isPremium);
        viewHolder.loadFans();
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public EntryUserPhotoItem.ViewHolder createViewHolder(View view, h.a.b.b bVar) {
        return new EntryUserPhotoItem.ViewHolder(view, bVar);
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public void unbindViewHolder(h.a.b.b<f> bVar, EntryUserPhotoItem.ViewHolder viewHolder, int i) {
        super.unbindViewHolder(bVar, viewHolder, i);
        this.lastPhotoPosition = viewHolder.lastSavedPosition;
    }

    @Override // app.dogo.com.dogo_android.model.entry_list_item_models.EntryItem
    public int getLayoutRes() {
        return R.layout.cell_entry_user_photo_item;
    }
}
