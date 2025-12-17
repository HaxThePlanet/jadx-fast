package com.iterable.iterableapi.ui.inbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.iterable.iterableapi.j0;
import com.iterable.iterableapi.j1.c;
import com.iterable.iterableapi.j1.d;

/* loaded from: classes2.dex */
public class IterableInboxActivity extends d {
    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        Object stringExtra;
        com.iterable.iterableapi.ui.inbox.g gVar;
        int i2;
        String str2;
        String stringExtra2;
        Object pOPUP;
        int i;
        String string;
        String str;
        Object obj8;
        super.onCreate(bundle);
        j0.g();
        setContentView(d.a);
        stringExtra = getIntent();
        if (stringExtra != null) {
            java.io.Serializable serializableExtra = stringExtra.getSerializableExtra("inboxMode");
            pOPUP = a.POPUP;
            if (serializableExtra instanceof a) {
                pOPUP = serializableExtra;
            }
            Bundle extras = getIntent().getExtras();
            i = 0;
            if (extras != null) {
                i2 = string2;
                i = string;
            } else {
                i2 = i;
            }
            gVar = g.F1(pOPUP, stringExtra.getIntExtra("itemLayoutId", 0), i, i2);
            str2 = "activityTitle";
            if (stringExtra.getStringExtra(str2) != null) {
                setTitle(stringExtra.getStringExtra(str2));
            }
        } else {
            gVar = g.E1();
        }
        if (bundle == null) {
            obj8 = getSupportFragmentManager().n();
            obj8.o(c.a, gVar);
            obj8.i();
        }
    }
}
