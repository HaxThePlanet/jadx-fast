package com.iterable.iterableapi.ui.inbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import com.iterable.iterableapi.j0;
import com.iterable.iterableapi.j1.c;

/* compiled from: IterableInboxMessageActivity.java */
/* loaded from: classes2.dex */
public class IterableInboxMessageActivity extends androidx.appcompat.app.d {
    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.d);
        j0.g();
        if (bundle == null) {
            w wVar = getSupportFragmentManager().n();
            str = "messageId";
            wVar.o(c.a, h.E1(getIntent().getStringExtra(str)));
            wVar.i();
        }
    }
}
