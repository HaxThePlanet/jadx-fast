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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u000c\u0012\u0008\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u0019\u001aB\u001b\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000c\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$ViewHolder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "lessonIntroductionList", "", "Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction;", "callback", "Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;", "(Ljava/util/List;Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;)V", "getLessonIntroductionList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setupTouchListener", "view", "Landroid/view/View;", "PagerCallback", "ViewHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends RecyclerView.h<app.dogo.com.dogo_android.y.v.d.b> implements a {

    private final List<LessonIntroduction> a;
    private final app.dogo.com.dogo_android.y.v.d.a b;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$PagerCallback;", "", "onItemClicked", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface a {
        public abstract void f();
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$setupTouchListener$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends GestureDetector.SimpleOnGestureListener {

        final app.dogo.com.dogo_android.y.v.d a;
        c(app.dogo.com.dogo_android.y.v.d d) {
            this.a = d;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            n.f(motionEvent, "e");
            d.f(this.a).f();
            return 1;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellProgramLessonIntroductionBinding;", "(Lapp/dogo/com/dogo_android/trainingprogram/lessonintroduction/LessonIntroductionPagerAdapter;Lapp/dogo/com/dogo_android/databinding/CellProgramLessonIntroductionBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellProgramLessonIntroductionBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class b extends RecyclerView.e0 {

        private final c5 a;
        final app.dogo.com.dogo_android.y.v.d b;
        public b(app.dogo.com.dogo_android.y.v.d d, c5 c52) {
            n.f(d, "this$0");
            n.f(c52, "binding");
            this.b = d;
            super(c52.w());
            this.a = c52;
            final View obj3 = c52.w();
            n.e(obj3, "binding.root");
            d.g(d, obj3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final c5 a() {
            return this.a;
        }
    }
    public d(List<LessonIntroduction> list, app.dogo.com.dogo_android.y.v.d.a d$a2) {
        n.f(list, "lessonIntroductionList");
        n.f(a2, "callback");
        super();
        this.a = list;
        this.b = a2;
    }

    public static final app.dogo.com.dogo_android.y.v.d.a f(app.dogo.com.dogo_android.y.v.d d) {
        return d.b;
    }

    public static final void g(app.dogo.com.dogo_android.y.v.d d, View view2) {
        d.l(view2);
    }

    public static boolean h(d d, View view2, MotionEvent motionEvent3) {
        return d.m(d, view2, motionEvent3);
    }

    private final void l(View view) {
        d.c cVar = new d.c(this);
        d dVar = new d(view.getContext(), cVar);
        b bVar = new b(dVar);
        view.setOnTouchListener(bVar);
    }

    private static final boolean m(d d, View view2, MotionEvent motionEvent3) {
        n.f(d, "$tapGestureDetector");
        n.f(view2, "touchView");
        d.a(motionEvent3);
        view2.performClick();
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void i(app.dogo.com.dogo_android.y.v.d.b d$b, int i2) {
        n.f(b, "holder");
        b.a().V((LessonIntroduction)this.a.get(i2));
        b.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public app.dogo.com.dogo_android.y.v.d.b j(ViewGroup viewGroup, int i2) {
        n.f(viewGroup, "parent");
        final c5 obj2 = c5.T(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        n.e(obj2, "inflate(inflater, parent, false)");
        d.b obj3 = new d.b(this, obj2);
        return obj3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        i((d.b)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return j(viewGroup, i2);
    }
}
