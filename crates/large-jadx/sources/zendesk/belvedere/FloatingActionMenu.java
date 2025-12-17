package zendesk.belvedere;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d.h.k.d;
import d.h.l.u;
import d.h.l.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.belvedere.b0.a;
import zendesk.belvedere.b0.c;
import zendesk.belvedere.b0.e;
import zendesk.belvedere.b0.f;
import zendesk.belvedere.b0.g;
import zendesk.belvedere.b0.h;
import zendesk.belvedere.b0.i;

/* loaded from: classes3.dex */
public class FloatingActionMenu extends LinearLayout implements View.OnClickListener {

    private FloatingActionButton a;
    private LayoutInflater b;
    private List<d<FloatingActionButton, View.OnClickListener>> c;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private zendesk.belvedere.FloatingActionMenu.c z;

    private abstract class c implements Animation.AnimationListener {
        private c(zendesk.belvedere.FloatingActionMenu floatingActionMenu) {
            super();
        }

        c(zendesk.belvedere.FloatingActionMenu floatingActionMenu, zendesk.belvedere.FloatingActionMenu.a floatingActionMenu$a2) {
            super(floatingActionMenu);
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation$AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    class a extends zendesk.belvedere.FloatingActionMenu.c {

        final d a;
        final zendesk.belvedere.FloatingActionMenu b;
        a(zendesk.belvedere.FloatingActionMenu floatingActionMenu, d d2) {
            this.b = floatingActionMenu;
            this.a = d2;
            super(floatingActionMenu, 0);
        }

        @Override // zendesk.belvedere.FloatingActionMenu$c
        public void onAnimationEnd(Animation animation) {
            FloatingActionMenu.a(this.b, (View)dVar.a, 4);
        }
    }

    class b extends zendesk.belvedere.FloatingActionMenu.c {

        final zendesk.belvedere.FloatingActionMenu a;
        b(zendesk.belvedere.FloatingActionMenu floatingActionMenu) {
            this.a = floatingActionMenu;
            super(floatingActionMenu, 0);
        }

        @Override // zendesk.belvedere.FloatingActionMenu$c
        public void onAnimationEnd(Animation animation) {
            Object obj;
            zendesk.belvedere.FloatingActionMenu num;
            int i;
            Iterator obj4 = FloatingActionMenu.b(this.a).iterator();
            for (d next2 : obj4) {
                FloatingActionMenu.a(this.a, (View)next2.a, 8);
            }
        }
    }
    public FloatingActionMenu(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        FloatingActionMenu.b obj2 = new FloatingActionMenu.b(this);
        this.z = obj2;
        f(context);
    }

    static void a(zendesk.belvedere.FloatingActionMenu floatingActionMenu, View view2, int i3) {
        floatingActionMenu.d(view2, i3);
    }

    static List b(zendesk.belvedere.FloatingActionMenu floatingActionMenu) {
        return floatingActionMenu.c;
    }

    private void d(View view, int i2) {
        if (view != null) {
            view.setVisibility(i2);
        }
    }

    private Drawable e(int i, int i2) {
        final Context context = getContext();
        Drawable obj2 = a.r(a.f(context, i));
        a.n(obj2, a.d(context, i2));
        return obj2;
    }

    private void f(Context context) {
        boolean inEditMode;
        Context obj2;
        LinearLayout.inflate(context, h.a, this);
        if (!isInEditMode()) {
            setOrientation(1);
            setOnClickListener(this);
            View viewById = findViewById(f.g);
            this.a = (FloatingActionButton)viewById;
            viewById.setOnClickListener(this);
            this.b = LayoutInflater.from(context);
            obj2 = new ArrayList();
            this.c = obj2;
            obj2 = getResources();
            this.w = obj2.getInteger(g.b);
            this.x = obj2.getInteger(g.c);
            this.y = getResources().getInteger(g.a);
        }
    }

    private void g(boolean z) {
        float obj4;
        obj4 = z ? (float)obj4 : 0;
        z zVar = u.d(this.a);
        zVar.d(obj4);
        zVar.e((long)obj4);
        zVar.k();
    }

    private void h(boolean z) {
        int i3;
        int i;
        boolean next;
        long l;
        Animation animation;
        Object obj;
        int i2;
        Iterator obj8;
        i3 = 2;
        i = 0;
        if (z) {
            obj8 = this.c.iterator();
            for (d next2 : obj8) {
                animation = AnimationUtils.loadAnimation(getContext(), a.b);
                animation.setRepeatMode(i3);
                animation.setStartOffset(i);
                d((View)next2.a, 0);
                (FloatingActionButton)next2.a.startAnimation(animation);
                i += l;
            }
        } else {
            obj8 = 0;
            size--;
            while (next >= 0) {
                obj8 = this.c.get(next);
                animation = AnimationUtils.loadAnimation(getContext(), a.a);
                animation.setRepeatMode(i3);
                animation.setStartOffset(i);
                FloatingActionMenu.a aVar = new FloatingActionMenu.a(this, (d)obj8);
                animation.setAnimationListener(aVar);
                (FloatingActionButton)obj8.a.startAnimation(animation);
                i += obj;
                next--;
                obj8 = animation;
            }
            if (obj8 != null) {
                obj8.setAnimationListener(this.z);
            }
        }
    }

    @Override // android.widget.LinearLayout
    public void c(int i, int i2, int i3, View.OnClickListener view$OnClickListener4) {
        FloatingActionButton obj4;
        String obj5;
        int obj6;
        int obj7;
        final int i6 = 0;
        View inflate = this.b.inflate(h.b, this, i6);
        (FloatingActionButton)inflate.setOnClickListener(onClickListener4);
        inflate.setImageDrawable(e(i, c.b));
        inflate.setId(i2);
        inflate.setContentDescription(getResources().getString(i3));
        this.c.add(d.a(inflate, onClickListener4));
        if (this.c.size() == 1) {
            this.a.setImageDrawable(e(i, c.a));
            this.a.setContentDescription(getResources().getString(i3));
        } else {
            if (this.c.size() == 2) {
                addView((View)obj4.a, i6);
                addView(inflate, i6);
                this.a.setImageDrawable(e(e.a, c.a));
                this.a.setContentDescription(getResources().getString(i.b));
            } else {
                addView(inflate, i6);
            }
        }
        setVisibility(i6);
    }

    @Override // android.widget.LinearLayout
    public void onClick(View view) {
        Object string;
        int i;
        Object obj3;
        int i2 = 1;
        if (this.c.size() == i2) {
            obj3 = this.c.get(0);
            (View.OnClickListener)obj3.b.onClick((View)obj3.a);
        } else {
            obj3 ^= i2;
            this.v = obj3;
            h(obj3);
            g(this.v);
            if (this.v) {
                this.a.setContentDescription(getResources().getString(i.a));
            } else {
                this.a.setContentDescription(getResources().getString(i.b));
            }
        }
    }
}
