package com.facebook.e0.q;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.view.View;
import android.widget.TextView;
import com.facebook.e0.r.g.f;
import com.facebook.internal.g0.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.h;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0007J\u0016\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0007J\u0016\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\tH\u0002J\u001e\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010\u000c\u001a\u00020\r2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lcom/facebook/appevents/aam/MetadataMatcher;", "", "()V", "MAX_INDICATOR_LENGTH", "", "getAroundViewIndicators", "", "", "view", "Landroid/view/View;", "getCurrentViewIndicators", "getTextIndicators", "matchIndicator", "", "indicator", "keys", "indicators", "matchValue", "text", "rule", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    public static final com.facebook.e0.q.b a;
    static {
        b bVar = new b();
        b.a = bVar;
    }

    public static final List<String> a(View view) {
        Object iterator;
        boolean next;
        com.facebook.e0.q.b bVar;
        if (a.d(b.class)) {
            return 0;
        }
        n.f(view, "view");
        ArrayList arrayList = new ArrayList();
        iterator = f.j(view);
        if (iterator != null) {
            iterator = f.b(iterator).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (view != (View)next) {
                }
                arrayList.addAll(b.a.c((View)next));
            }
        }
        return arrayList;
    }

    public static final List<String> b(View view) {
        Object string;
        Object contentDescription;
        int lowerCase;
        int length;
        int i;
        Object obj8;
        if (a.d(b.class)) {
            return 0;
        }
        n.f(view, "view");
        ArrayList arrayList = new ArrayList();
        arrayList.add(f.i(view));
        string = view.getTag();
        if (string != null) {
            arrayList.add(string.toString());
        }
        contentDescription = view.getContentDescription();
        if (contentDescription != null) {
            arrayList.add(contentDescription.toString());
        }
        int i3 = 1;
        final int i4 = 0;
        if (view.getId() != -1) {
            obj8 = view.getResources().getResourceName(view.getId());
            n.e(obj8, "resourceName");
            h hVar = new h("/");
            obj8 = hVar.f(obj8, i4).toArray(new String[i4]);
            if (obj8 == null) {
            } else {
                if (obj8.length == 2) {
                    arrayList.add((String[])obj8[i3]);
                }
            }
            try {
                obj8 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                throw obj8;
                obj8 = new ArrayList();
                Iterator iterator = arrayList.iterator();
                while (iterator.hasNext()) {
                    lowerCase = iterator.next();
                    if ((String)lowerCase.length() > 0) {
                    } else {
                    }
                    length = i4;
                    lowerCase = lowerCase.toLowerCase();
                    n.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                    obj8.add(lowerCase);
                    length = i3;
                }
                lowerCase = iterator.next();
                if ((String)lowerCase.length() > 0) {
                } else {
                }
                length = i3;
                length = i4;
                if (length != 0) {
                } else {
                }
                if (lowerCase.length() <= 100) {
                } else {
                }
                if (lowerCase == 0) {
                } else {
                }
                lowerCase = lowerCase.toLowerCase();
                n.e(lowerCase, "(this as java.lang.String).toLowerCase()");
                obj8.add(lowerCase);
                obj8 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                throw obj8;
                return obj8;
                a.b(view, obj0);
                return obj2;
            } catch (android.content.res.Resources.NotFoundException notFound) {
            } catch (Throwable th1) {
            }
        }
    }

    private final List<String> c(View view) {
        boolean z;
        int length;
        int i;
        String obj5;
        if (a.d(this)) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof EditText) {
            return arrayList;
        }
        if (view instanceof TextView != null) {
            obj5 = (TextView)view.getText().toString();
            length = obj5.length() > 0 ? 1 : 0;
            try {
                if (length != 0 && obj5.length() < 100) {
                }
                if (obj5.length() < 100) {
                }
                if (obj5 == null) {
                } else {
                }
                obj5 = obj5.toLowerCase();
                n.e(obj5, "(this as java.lang.String).toLowerCase()");
                arrayList.add(obj5);
                obj5 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
                throw obj5;
                return arrayList;
                obj5 = f.b(view).iterator();
                for (View next2 : obj5) {
                    arrayList.addAll(c(next2));
                }
                arrayList.addAll(c((View)obj5.next()));
                return arrayList;
                a.b(view, this);
                return obj1;
            }
        }
    }

    private final boolean d(String string, List<String> list2) {
        boolean z;
        int i2;
        int i;
        final int i3 = 0;
        if (a.d(this)) {
            return i3;
        }
        final Iterator obj6 = list2.iterator();
        for (String next2 : obj6) {
        }
        return i3;
    }

    public static final boolean e(List<String> list, List<String> list2) {
        String str;
        com.facebook.e0.q.b bVar;
        final int i = 0;
        if (a.d(b.class)) {
            return i;
        }
        n.f(list, "indicators");
        n.f(list2, "keys");
        Iterator obj4 = list.iterator();
        for (String next2 : obj4) {
        }
        return i;
    }

    public static final boolean f(String string, String string2) {
        if (a.d(b.class)) {
            return 0;
        }
        n.f(string, "text");
        n.f(string2, "rule");
        h hVar = new h(string2);
        return hVar.d(string);
    }
}
