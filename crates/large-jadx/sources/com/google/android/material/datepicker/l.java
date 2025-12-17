package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes2.dex */
public final class l<S>  extends com.google.android.material.datepicker.q<S> {

    private int b;
    private com.google.android.material.datepicker.e<S> c;
    private com.google.android.material.datepicker.a v;

    class a extends com.google.android.material.datepicker.p<S> {

        final com.google.android.material.datepicker.l a;
        a(com.google.android.material.datepicker.l l) {
            this.a = l;
            super();
        }

        @Override // com.google.android.material.datepicker.p
        public void a() {
            Object next;
            Iterator iterator = lVar.a.iterator();
            for (p next : iterator) {
                next.a();
            }
        }

        public void b(S s) {
            Object next;
            Iterator iterator = lVar.a.iterator();
            for (p next : iterator) {
                next.b(s);
            }
        }
    }
    static <T> com.google.android.material.datepicker.l<T> D1(com.google.android.material.datepicker.e<T> e, int i2, com.google.android.material.datepicker.a a3) {
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("DATE_SELECTOR_KEY", e);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", a3);
        lVar.setArguments(bundle);
        return lVar;
    }

    @Override // com.google.android.material.datepicker.q
    public void onCreate(Bundle bundle) {
        Bundle obj2;
        super.onCreate(bundle);
        if (bundle == null) {
            obj2 = getArguments();
        }
        this.b = obj2.getInt("THEME_RES_ID_KEY");
        this.c = (e)obj2.getParcelable("DATE_SELECTOR_KEY");
        this.v = (a)obj2.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // com.google.android.material.datepicker.q
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.b);
        l.a aVar2 = new l.a(this);
        return this.c.G0(layoutInflater.cloneInContext(contextThemeWrapper), viewGroup2, bundle3, this.v, aVar2);
    }

    @Override // com.google.android.material.datepicker.q
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.c);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.v);
    }
}
