package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.j;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.g;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import h.a.b.h.f;
import java.util.List;

/* compiled from: EntryTitleItem.java */
/* loaded from: classes.dex */
public class EntryTitleItem extends h.a.b.h.a<EntryTitleItem.MyViewHolder> {

    private final int ADJUSTED_FINAL_SLIDE = 2;
    private final int ADJUSTED_FIRST_SLIDE = 0;
    private final int ADJUSTED_INBETWEEN_SLIDE = 1;
    private int currentPos = 0;
    private String id;
    private int lastPos = 0;
    boolean letGo = true;
    private int sidePixel;
    private int slideState = 0;
    private o3 tracker;
    private View view;
    private g viewPagerAdapter;
    private ViewPager viewPagerView;

    public static class MyViewHolder extends h.a.c.b {
        public MyViewHolder(View view, e eVar) {
            super(view, eVar);
        }
    }
    public EntryTitleItem(String str, View view, a0 a0Var, o3 o3Var, g0 g0Var) {
        super();
        this.id = str;
        this.view = view;
        this.tracker = o3Var;
        View viewById = view.findViewById(2131363549);
        this.viewPagerView = viewById;
        setupPager(viewById, a0Var, g0Var);
    }

    static /* synthetic */ int access$002(EntryTitleItem entryTitleItem, int i) {
        entryTitleItem.lastPos = i;
        return i;
    }

    static /* synthetic */ int access$100(EntryTitleItem entryTitleItem) {
        return entryTitleItem.currentPos;
    }

    static /* synthetic */ int access$102(EntryTitleItem entryTitleItem, int i) {
        entryTitleItem.currentPos = i;
        return i;
    }

    static /* synthetic */ g access$200(EntryTitleItem entryTitleItem) {
        return entryTitleItem.viewPagerAdapter;
    }

    static /* synthetic */ o3 access$300(EntryTitleItem entryTitleItem) {
        return entryTitleItem.tracker;
    }

    private void setupPager(ViewPager viewPager, a0 a0Var, g0 g0Var) {
        viewPager.setOffscreenPageLimit(3);
        g gVar = new app.dogo.com.dogo_android.util.recycle_views.g(g0Var, a0Var);
        this.viewPagerAdapter = gVar;
        viewPager.setAdapter(gVar);
        viewPager.setOnTouchListener(new EntryTitleItem.AnonymousClass1(this));
        viewPager.c(new EntryTitleItem.AnonymousClass2(this, g0Var));
    }

    @Override // h.a.b.h.a
    public void addCardItems(List<ChallengeModel> list) {
        this.viewPagerAdapter.t(list);
        this.viewPagerAdapter.j();
    }

    @Override // h.a.b.h.a
    public void checkAndSelectIfExists(ChallengeModel challengeModel) {
        final int i = this.viewPagerAdapter.w(challengeModel);
        if (i >= 0) {
            this.viewPagerView.setCurrentItem(i);
            this.viewPagerAdapter.D(i);
        }
    }

    @Override // h.a.b.h.a
    public boolean equals(Object object) {
        if (object instanceof EntryTitleItem) {
            return this.id.equals(object.id);
        }
        return false;
    }

    @Override // h.a.b.h.a
    public int getPosition() {
        return this.currentPos;
    }

    @Override // h.a.b.h.a
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override // h.a.b.h.a
    public void refreshItem(ChallengeModel challengeModel) {
        this.viewPagerAdapter.C(challengeModel);
    }

    @Override // h.a.b.h.a
    public void setPosition(int i) {
        if (this.viewPagerAdapter.y() > i) {
            boolean z = true;
            this.viewPagerView.N(i, z);
            this.viewPagerAdapter.D(i);
        }
    }

    @Override // h.a.b.h.a
    public void updateDataSet(List<ChallengeModel> list) {
        this.viewPagerAdapter.v();
        addCardItems(list);
    }

    @Override // h.a.b.h.a
    public void updateView() {
        this.viewPagerAdapter.E();
    }

    @Override // h.a.b.h.a
    public void bindViewHolder(h.a.b.b<f> bVar, EntryTitleItem.MyViewHolder myViewHolder, int i, List<Object> list) {
        super.unbindViewHolder(bVar, myViewHolder, i);
        this.viewPagerAdapter.E();
    }

    @Override // h.a.b.h.a
    public EntryTitleItem.MyViewHolder createViewHolder(View view, h.a.b.b<f> bVar) {
        return new EntryTitleItem.MyViewHolder(this.view, bVar);
    }

    @Override // h.a.b.h.a
    public void unbindViewHolder(h.a.b.b<f> bVar, EntryTitleItem.MyViewHolder myViewHolder, int i) {
        super.unbindViewHolder(bVar, myViewHolder, i);
    }

    @Override // h.a.b.h.a
    public void checkAndSelectIfExists(String str) {
        final int i = this.viewPagerAdapter.x(str);
        if (i >= 0) {
            this.viewPagerView.setCurrentItem(i);
            this.viewPagerAdapter.D(i);
        }
    }

    @Override // h.a.b.h.a
    public int getLayoutRes() {
        return R.layout.cell_entry_challenge_pager_item;
    }
}
