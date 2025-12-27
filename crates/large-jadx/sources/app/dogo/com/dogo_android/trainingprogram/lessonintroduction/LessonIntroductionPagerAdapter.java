package app.dogo.com.dogo_android.y.v;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.c5;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction;
import app.dogo.com.dogo_android.util.d0.a;
import d.h.l.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LessonIntroductionPagerAdapter.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u0019\u001aB\u001b\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$ViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "lessonIntroductionList", "", "Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction;", "callback", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;)V", "getLessonIntroductionList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setupTouchListener", "view", "Landroid/view/View;", "PagerCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class LessonIntroductionPagerAdapter extends RecyclerView.h<d.b> implements a {

    /* renamed from: a, reason: from kotlin metadata */
    private final List<LessonIntroduction> callback;
    private final d.a b;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;", "", "onItemClicked", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        /* renamed from: f, reason: from kotlin metadata */
        void onItemClicked();
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$setupTouchListener$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends GestureDetector.SimpleOnGestureListener {

        final /* synthetic */ d a;
        c() {
            this.a = dVar;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            n.f(e, "e");
            this.a.b.onItemClicked();
            return true;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonIntroductionBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonIntroductionBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonIntroductionBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final c5 a;
        final /* synthetic */ d b;
        public b(c5 c5Var) {
            n.f(dVar, "this$0");
            n.f(c5Var, "binding");
            this.b = dVar;
            super(c5Var.w());
            this.a = c5Var;
            final View view2 = c5Var.w();
            n.e(view2, "binding.root");
            dVar.l(view2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final c5 a() {
            return this.a;
        }
    }
    public d(List<LessonIntroduction> list, d.a aVar) {
        n.f(list, "lessonIntroductionList");
        n.f(aVar, "callback");
        super();
        this.callback = list;
        this.b = aVar;
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ d.a setupTouchListener(d view) {
        return view.b;
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final /* synthetic */ void onBindViewHolder(d holder, View position) {
        holder.l(position);
    }

    private final void l(View view) {
        view.setOnTouchListener(new app.dogo.com.dogo_android.trainingprogram.lessonintroduction.b(new d(view.getContext(), new LessonIntroductionPagerAdapter_setupTouchListener_tapGestureDetector_1(this))));
    }

    private static final boolean m(d dVar, View view, MotionEvent motionEvent) {
        n.f(dVar, "$tapGestureDetector");
        n.f(view, "touchView");
        dVar.a(motionEvent);
        view.performClick();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.callback.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public void onCreateViewHolder(d.b parent, int viewType) {
        n.f(parent, "holder");
        parent.a().V((LessonIntroduction)this.callback.get(viewType));
        parent.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public d.b j(ViewGroup viewGroup, int i) {
        n.f(viewGroup, "parent");
        final c5 c5Var = c5.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(c5Var, "inflate(inflater, parent, false)");
        return new LessonIntroductionPagerAdapter_ViewHolder(this, c5Var);
    }

    public static /* synthetic */ boolean h(d dVar, View view, MotionEvent motionEvent) {
        return LessonIntroductionPagerAdapter.m(dVar, view, motionEvent);
    }
}
