package zendesk.belvedere;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import zendesk.belvedere.b0.e;
import zendesk.belvedere.b0.f;
import zendesk.belvedere.b0.h;
import zendesk.belvedere.b0.i;

/* loaded from: classes3.dex */
class h {

    private static final int a;
    private static final int b;

    static class a implements View.OnClickListener {

        final zendesk.belvedere.f.b a;
        a(zendesk.belvedere.f.b f$b) {
            this.a = b;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.b();
        }
    }

    static abstract class b {

        private final int a;
        private final long b;
        private final zendesk.belvedere.s c;
        private boolean d = false;
        b(int i, zendesk.belvedere.s s2) {
            super();
            this.a = i;
            this.c = s2;
            this.b = (long)obj1;
            int obj1 = 0;
        }

        abstract void a(View view);

        long b() {
            return this.b;
        }

        int c() {
            return this.a;
        }

        zendesk.belvedere.s d() {
            return this.c;
        }

        boolean e() {
            return this.d;
        }

        void f(boolean z) {
            this.d = z;
        }
    }

    static class c extends zendesk.belvedere.h.b {

        private final int e;
        private final View.OnClickListener f;
        private c(int i, int i2, View.OnClickListener view$OnClickListener3) {
            super(i, 0);
            this.e = i2;
            this.f = onClickListener3;
        }

        c(int i, int i2, View.OnClickListener view$OnClickListener3, zendesk.belvedere.h.a h$a4) {
            super(i, i2, onClickListener3);
        }

        @Override // zendesk.belvedere.h$b
        public void a(View view) {
            (ImageView)view.findViewById(f.s).setImageResource(this.e);
            view.findViewById(f.r).setOnClickListener(this.f);
        }
    }

    static class d extends zendesk.belvedere.h.b {

        private final zendesk.belvedere.s e;
        private final ResolveInfo f;
        private final zendesk.belvedere.f.b g;
        d(zendesk.belvedere.f.b f$b, zendesk.belvedere.s s2, Context context3) {
            super(h.e, s2);
            this.e = s2;
            this.f = h(s2.j(), context3);
            this.g = b;
        }

        static zendesk.belvedere.f.b g(zendesk.belvedere.h.d h$d) {
            return d.g;
        }

        private ResolveInfo h(String string, Context context2) {
            PackageManager packageManager;
            zendesk.belvedere.s obj4 = a.c(context2).d("tmp", string);
            int obj5 = 0;
            if (obj4 == null) {
                return obj5;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(obj4.n());
            obj4 = context2.getPackageManager().queryIntentActivities(intent, 65536);
            if (obj4 != null && obj4.size() > 0) {
                if (obj4.size() > 0) {
                    return (ResolveInfo)obj4.get(0);
                }
            }
            return obj5;
        }

        @Override // zendesk.belvedere.h$b
        void a(View view) {
            android.graphics.drawable.Drawable icon;
            ResolveInfo resolveInfo;
            Context context = view.getContext();
            View viewById = view.findViewById(f.m);
            View viewById3 = view.findViewById(f.n);
            final View obj10 = view.findViewById(f.l);
            int i7 = 1;
            Object[] arr2 = new Object[i7];
            final int i9 = 0;
            arr2[i9] = this.e.j();
            Object[] arr = new Object[i7];
            arr[i9] = this.e.j();
            (SelectableView)obj10.h(context.getString(i.k, arr), context.getString(i.i, arr2));
            (TextView)view.findViewById(f.o).setText(this.e.j());
            if (this.f != null) {
                PackageManager packageManager = context.getPackageManager();
                (TextView)viewById3.setText(this.f.loadLabel(packageManager));
                (ImageView)viewById.setImageDrawable(this.f.loadIcon(packageManager));
            } else {
                viewById3.setText(i.g);
                viewById.setImageResource(17301651);
            }
            obj10.setSelected(e());
            h.d.a aVar = new h.d.a(this);
            obj10.setSelectionListener(aVar);
        }
    }

    static class e extends zendesk.belvedere.h.b {

        private final zendesk.belvedere.s e;
        private final zendesk.belvedere.f.b f;
        private zendesk.belvedere.FixedWidthImageView.b g;
        e(zendesk.belvedere.f.b f$b, zendesk.belvedere.s s2) {
            super(h.d, s2);
            this.f = b;
            this.e = s2;
        }

        static zendesk.belvedere.FixedWidthImageView.b g(zendesk.belvedere.h.e h$e, zendesk.belvedere.FixedWidthImageView.b fixedWidthImageView$b2) {
            e.g = b2;
            return b2;
        }

        static zendesk.belvedere.f.b h(zendesk.belvedere.h.e h$e) {
            return e.f;
        }

        @Override // zendesk.belvedere.h$b
        public void a(View view) {
            Object obj;
            Object string;
            Object obj2;
            int i;
            String str;
            long l;
            zendesk.belvedere.h.e.a aVar;
            Context context = view.getContext();
            final View view3 = viewById;
            final View obj11 = view.findViewById(f.q);
            int i5 = 1;
            Object[] arr2 = new Object[i5];
            final int i6 = 0;
            arr2[i6] = this.e.j();
            Object[] arr = new Object[i5];
            arr[i6] = this.e.j();
            (SelectableView)obj11.h(context.getString(i.l, arr), context.getString(i.j, arr2));
            if (this.g != null) {
                (FixedWidthImageView)view3.d(t.h(), this.e.k(), this.g);
            } else {
                aVar = new h.e.a(this);
                view3.c(t.h(), this.e.k(), this.e.o(), i6, this.e.f());
            }
            obj11.setSelected(e());
            h.e.b bVar = new h.e.b(this);
            obj11.setSelectionListener(bVar);
        }
    }
    static {
        h.a = e.b;
        h.b = h.f;
    }

    static zendesk.belvedere.h.c a(zendesk.belvedere.f.b f$b) {
        h.a aVar = new h.a(b);
        h.c cVar = new h.c(h.b, h.a, aVar, 0);
        return cVar;
    }

    static List<zendesk.belvedere.h.b> b(List<zendesk.belvedere.s> list, zendesk.belvedere.f.b f$b2, Context context3) {
        int size;
        zendesk.belvedere.h.b eVar;
        String startsWith;
        String str;
        ArrayList arrayList = new ArrayList(list.size());
        final Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            size = obj4.next();
            if ((s)size.i() != null && size.i().startsWith("image")) {
            } else {
            }
            eVar = new h.d(b2, size, context3);
            arrayList.add(eVar);
            if (size.i().startsWith("image")) {
            } else {
            }
            eVar = new h.e(b2, size);
            arrayList.add(eVar);
        }
        return arrayList;
    }
}
