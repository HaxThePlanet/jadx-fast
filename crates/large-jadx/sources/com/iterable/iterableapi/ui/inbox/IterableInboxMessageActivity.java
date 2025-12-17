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
public class IterableInboxMessageActivity extends d {
    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        int i;
        com.iterable.iterableapi.ui.inbox.h hVar;
        String str;
        Object obj4;
        super.onCreate(bundle);
        setContentView(d.d);
        j0.g();
        if (bundle == null) {
            obj4 = getSupportFragmentManager().n();
            obj4.o(c.a, h.E1(getIntent().getStringExtra("messageId")));
            obj4.i();
        }
    }
}
