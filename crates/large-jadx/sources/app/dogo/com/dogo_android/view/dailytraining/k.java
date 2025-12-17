package app.dogo.com.dogo_android.view.dailytraining;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0001R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0004j\u0008\u0012\u0004\u0012\u00020\u0001`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/view/dailytraining/CompositeListener;", "Landroid/view/View$OnClickListener;", "()V", "registeredListeners", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "onClick", "", "v", "Landroid/view/View;", "registerListener", "listener", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k implements View.OnClickListener {

    private final ArrayList<View.OnClickListener> a;
    public k() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    @Override // android.view.View$OnClickListener
    public final void a(View.OnClickListener view$OnClickListener) {
        ArrayList list;
        Object obj2;
        if (onClickListener != null) {
            this.a.add(onClickListener);
        } else {
            this.a.clear();
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        Object next;
        n.f(view, "v");
        Iterator iterator = this.a.iterator();
        for (View.OnClickListener next : iterator) {
            next.onClick(view);
        }
    }
}
