package d.u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class l {

    private Context a;
    private int b = -1;
    private ViewGroup c;
    private View d;
    private Runnable e;
    private Runnable f;
    public l(ViewGroup viewGroup, View view2) {
        super();
        final int i = -1;
        this.c = viewGroup;
        this.d = view2;
    }

    public static d.u.l c(ViewGroup viewGroup) {
        return (l)viewGroup.getTag(j.c);
    }

    static void f(ViewGroup viewGroup, d.u.l l2) {
        viewGroup.setTag(j.c, l2);
    }

    public void a() {
        int from;
        int i;
        ViewGroup view;
        if (this.b <= 0) {
            if (this.d != null) {
                d().removeAllViews();
                if (this.b > 0) {
                    LayoutInflater.from(this.a).inflate(this.b, this.c);
                } else {
                    this.c.addView(this.d);
                }
            }
        } else {
        }
        Runnable runnable = this.e;
        if (runnable != null) {
            runnable.run();
        }
        l.f(this.c, this);
    }

    public void b() {
        Object lVar;
        lVar = this.f;
        if (l.c(this.c) == this && lVar != null) {
            lVar = this.f;
            if (lVar != null) {
                lVar.run();
            }
        }
    }

    public ViewGroup d() {
        return this.c;
    }

    boolean e() {
        int i;
        i = this.b > 0 ? 1 : 0;
        return i;
    }
}
