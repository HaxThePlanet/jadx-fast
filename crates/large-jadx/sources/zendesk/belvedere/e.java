package zendesk.belvedere;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zendesk.belvedere.b0.i;

/* loaded from: classes3.dex */
public class e extends Fragment {

    private WeakReference<zendesk.belvedere.p> a;
    private List<WeakReference<zendesk.belvedere.e.b>> b;
    private List<WeakReference<zendesk.belvedere.e.c>> c;
    private zendesk.belvedere.n v = null;
    private zendesk.belvedere.b.c w = null;
    private boolean x = false;
    private zendesk.belvedere.u y;
    private zendesk.belvedere.d<List<zendesk.belvedere.s>> z;

    public interface b {
        public abstract void onDismissed();

        public abstract void onMediaDeselected(List<zendesk.belvedere.s> list);

        public abstract void onMediaSelected(List<zendesk.belvedere.s> list);

        public abstract void onVisible();
    }

    public interface c {
        public abstract void onScroll(int i, int i2, float f3);
    }

    class a extends zendesk.belvedere.d<List<zendesk.belvedere.s>> {

        final zendesk.belvedere.e a;
        a(zendesk.belvedere.e e) {
            this.a = e;
            super();
        }

        @Override // zendesk.belvedere.d
        public void success(Object object) {
            success((List)object);
        }

        public void success(List<zendesk.belvedere.s> list) {
            int size;
            Object next2;
            boolean next;
            int cmp;
            int i;
            int obj8;
            ArrayList arrayList = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                next2 = iterator.next();
                if (Long.compare(l, i) > 0) {
                } else {
                }
                arrayList.add(next2);
                if (Long.compare(l2, i) == 0) {
                }
            }
            if (arrayList.size() != list.size()) {
                Toast.makeText(this.a.getContext(), i.e, 0).show();
            }
            this.a.J1(arrayList);
        }
    }
    public e() {
        super();
        WeakReference weakReference = new WeakReference(0);
        this.a = weakReference;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.c = arrayList2;
        int i = 0;
    }

    static zendesk.belvedere.b.c B1(zendesk.belvedere.e e) {
        return e.w;
    }

    @Override // androidx.fragment.app.Fragment
    public void C1(zendesk.belvedere.e.b e$b) {
        WeakReference weakReference = new WeakReference(b);
        this.b.add(weakReference);
    }

    @Override // androidx.fragment.app.Fragment
    public void D1(zendesk.belvedere.e.c e$c) {
        WeakReference weakReference = new WeakReference(c);
        this.c.add(weakReference);
    }

    @Override // androidx.fragment.app.Fragment
    public zendesk.belvedere.p E1() {
        return (p)this.a.get();
    }

    void F1(List<zendesk.belvedere.r> list, zendesk.belvedere.u.d u$d2) {
        this.y.j(this, list, d2);
    }

    @Override // androidx.fragment.app.Fragment
    public boolean G1() {
        int i;
        i = this.v != null ? 1 : 0;
        return i;
    }

    @Override // androidx.fragment.app.Fragment
    void H1() {
        Object obj;
        this.z = 0;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            obj = (WeakReference)iterator.next().get();
            if ((e.b)obj != null) {
            }
            (e.b)obj.onDismissed();
        }
    }

    void I1(List<zendesk.belvedere.s> list) {
        Object obj;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            obj = (WeakReference)iterator.next().get();
            if ((e.b)obj != null) {
            }
            (e.b)obj.onMediaDeselected(list);
        }
    }

    void J1(List<zendesk.belvedere.s> list) {
        Object obj;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            obj = (WeakReference)iterator.next().get();
            if ((e.b)obj != null) {
            }
            (e.b)obj.onMediaSelected(list);
        }
    }

    @Override // androidx.fragment.app.Fragment
    void K1(int i, int i2, float f3) {
        Object obj;
        Iterator iterator = this.c.iterator();
        while (iterator.hasNext()) {
            obj = (WeakReference)iterator.next().get();
            if ((e.c)obj != null) {
            }
            (e.c)obj.onScroll(i, i2, f3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    void L1() {
        Object obj;
        Iterator iterator = this.b.iterator();
        while (iterator.hasNext()) {
            obj = (WeakReference)iterator.next().get();
            if ((e.b)obj != null) {
            }
            (e.b)obj.onVisible();
        }
    }

    @Override // androidx.fragment.app.Fragment
    void M1(zendesk.belvedere.n n, zendesk.belvedere.b.c b$c2) {
        this.v = n;
        if (c2 != null) {
            this.w = c2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    void N1(zendesk.belvedere.p p) {
        WeakReference weakReference = new WeakReference(p);
        this.a = weakReference;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean O1() {
        return this.x;
    }

    @Override // androidx.fragment.app.Fragment
    public void dismiss() {
        boolean z;
        if (G1()) {
            this.v.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        super.onActivityResult(i, i2, intent3);
        e.a aVar = new e.a(this);
        this.z = aVar;
        a.c(requireContext()).e(i, i2, intent3, this.z, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        u obj2 = new u(getContext());
        this.y = obj2;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        int i;
        super.onPause();
        zendesk.belvedere.n nVar = this.v;
        if (nVar != null) {
            nVar.dismiss();
            this.x = true;
        } else {
            this.x = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3) {
        if (!this.y.l(this, i, string2Arr2, i3Arr3)) {
            super.onRequestPermissionsResult(i, string2Arr2, i3Arr3);
        }
    }
}
