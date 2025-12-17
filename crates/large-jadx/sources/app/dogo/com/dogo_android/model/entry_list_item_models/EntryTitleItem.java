package app.dogo.com.dogo_android.model.entry_list_item_models;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.j;
import androidx.viewpager.widget.a;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.n0.e;
import app.dogo.com.dogo_android.util.n0.g;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import h.a.b.b;
import h.a.b.h.a;
import h.a.b.h.f;
import h.a.c.b;
import java.util.List;

/* loaded from: classes.dex */
public class EntryTitleItem extends a<app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem.MyViewHolder> {

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

    public static class MyViewHolder extends b {
        public MyViewHolder(View view, e e2) {
            super(view, e2);
        }
    }
    public EntryTitleItem(String string, View view2, a0 a03, o3 o34, g0 g05) {
        super();
        final int i = 0;
        final int i2 = 1;
        final int i3 = 2;
        this.id = string;
        this.view = view2;
        this.tracker = o34;
        View obj4 = view2.findViewById(2131363549);
        this.viewPagerView = (ViewPager)obj4;
        setupPager(obj4, a03, g05);
    }

    static int access$002(app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem entryTitleItem, int i2) {
        entryTitleItem.lastPos = i2;
        return i2;
    }

    static int access$100(app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem entryTitleItem) {
        return entryTitleItem.currentPos;
    }

    static int access$102(app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem entryTitleItem, int i2) {
        entryTitleItem.currentPos = i2;
        return i2;
    }

    static g access$200(app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem entryTitleItem) {
        return entryTitleItem.viewPagerAdapter;
    }

    static o3 access$300(app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem entryTitleItem) {
        return entryTitleItem.tracker;
    }

    private void setupPager(ViewPager viewPager, a0 a02, g0 g03) {
        viewPager.setOffscreenPageLimit(3);
        g gVar = new g(g03, a02);
        this.viewPagerAdapter = gVar;
        viewPager.setAdapter(gVar);
        EntryTitleItem.1 obj3 = new EntryTitleItem.1(this);
        viewPager.setOnTouchListener(obj3);
        obj3 = new EntryTitleItem.2(this, g03);
        viewPager.c(obj3);
    }

    public void addCardItems(List<ChallengeModel> list) {
        this.viewPagerAdapter.t(list);
        this.viewPagerAdapter.j();
    }

    @Override // h.a.b.h.a
    public void bindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3, List list4) {
        bindViewHolder(b, (EntryTitleItem.MyViewHolder)e02, i3, list4);
    }

    public void bindViewHolder(b<f> b, app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem.MyViewHolder entryTitleItem$MyViewHolder2, int i3, List<Object> list4) {
        super.unbindViewHolder(b, myViewHolder2, i3);
        this.viewPagerAdapter.E();
    }

    @Override // h.a.b.h.a
    public void checkAndSelectIfExists(ChallengeModel challengeModel) {
        g viewPagerAdapter;
        final int obj2 = this.viewPagerAdapter.w(challengeModel);
        if (obj2 >= 0) {
            this.viewPagerView.setCurrentItem(obj2);
            this.viewPagerAdapter.D(obj2);
        }
    }

    @Override // h.a.b.h.a
    public void checkAndSelectIfExists(String string) {
        g viewPagerAdapter;
        final int obj2 = this.viewPagerAdapter.x(string);
        if (obj2 >= 0) {
            this.viewPagerView.setCurrentItem(obj2);
            this.viewPagerAdapter.D(obj2);
        }
    }

    @Override // h.a.b.h.a
    public RecyclerView.e0 createViewHolder(View view, b b2) {
        return createViewHolder(view, b2);
    }

    public app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem.MyViewHolder createViewHolder(View view, b<f> b2) {
        EntryTitleItem.MyViewHolder obj2 = new EntryTitleItem.MyViewHolder(this.view, (e)b2);
        return obj2;
    }

    @Override // h.a.b.h.a
    public boolean equals(Object object) {
        if (object instanceof EntryTitleItem) {
            return this.id.equals(object.id);
        }
        return 0;
    }

    @Override // h.a.b.h.a
    public int getLayoutRes() {
        return 2131558484;
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
        int viewPagerAdapter;
        int i2;
        if (this.viewPagerAdapter.y() > i) {
            this.viewPagerView.N(i, true);
            this.viewPagerAdapter.D(i);
        }
    }

    @Override // h.a.b.h.a
    public void unbindViewHolder(b b, RecyclerView.e0 recyclerView$e02, int i3) {
        unbindViewHolder(b, (EntryTitleItem.MyViewHolder)e02, i3);
    }

    public void unbindViewHolder(b<f> b, app.dogo.com.dogo_android.model.entry_list_item_models.EntryTitleItem.MyViewHolder entryTitleItem$MyViewHolder2, int i3) {
        super.unbindViewHolder(b, myViewHolder2, i3);
    }

    public void updateDataSet(List<ChallengeModel> list) {
        this.viewPagerAdapter.v();
        addCardItems(list);
    }

    @Override // h.a.b.h.a
    public void updateView() {
        this.viewPagerAdapter.E();
    }
}
