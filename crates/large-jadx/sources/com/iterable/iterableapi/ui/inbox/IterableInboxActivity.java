package com.iterable.iterableapi.ui.inbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.iterable.iterableapi.j0;
import com.iterable.iterableapi.j1.c;

/* compiled from: IterableInboxActivity.java */
/* loaded from: classes2.dex */
public class IterableInboxActivity extends androidx.appcompat.app.d {
    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        Intent intent;
        com.iterable.iterableapi.ui.inbox.g gVar;
        String string;
        com.iterable.iterableapi.ui.inbox.a pOPUP2;
        String str2;
        super.onCreate(bundle);
        j0.g();
        setContentView(d.a);
        intent = getIntent();
        if (intent != null) {
            java.io.Serializable serializableExtra = intent.getSerializableExtra("inboxMode");
            pOPUP2 = a.POPUP;
            if (serializableExtra instanceof a) {
            }
            Bundle extras = getIntent().getExtras();
            string = null;
            if (extras != null) {
                str2 = "noMessagesBody";
            } else {
            }
            gVar = g.F1(pOPUP2, intent.getIntExtra("itemLayoutId", 0), string, string);
            str = "activityTitle";
            if (intent.getStringExtra(str) != null) {
                setTitle(intent.getStringExtra(str));
            }
        } else {
            gVar = g.E1();
        }
        if (bundle == null) {
            w wVar = getSupportFragmentManager().n();
            wVar.o(c.a, gVar);
            wVar.i();
        }
    }
}
