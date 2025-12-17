package com.iterable.iterableapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.d;
import androidx.fragment.app.e;

/* loaded from: classes2.dex */
public class IterableTrampolineActivity extends d {
    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j0.h("TrampolineActivity", "Notification Trampoline Activity created");
    }

    @Override // androidx.appcompat.app.d
    protected void onDestroy() {
        super.onDestroy();
        j0.h("TrampolineActivity", "Notification Trampoline Activity destroyed");
    }

    @Override // androidx.appcompat.app.d
    protected void onPause() {
        super.onPause();
        j0.h("TrampolineActivity", "Notification Trampoline Activity on pause");
    }

    @Override // androidx.appcompat.app.d
    protected void onResume() {
        super.onResume();
        String str = "TrampolineActivity";
        j0.h(str, "Notification Trampoline Activity resumed");
        Intent intent = getIntent();
        if (intent == null) {
            j0.a(str, "Intent is null. Doing nothing.");
            finish();
        }
        final String action = intent.getAction();
        if (action == null) {
            j0.a(str, "Intent action is null. Doing nothing.");
            finish();
        }
        p0.a(this, intent);
        p0.b(this);
        if ("com.iterable.push.ACTION_PUSH_ACTION".equalsIgnoreCase(action)) {
            p0.e(this, intent);
        }
        finish();
    }
}
