package com.facebook.h0;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* loaded from: classes.dex */
@Deprecated
public class b extends Fragment {

    private com.facebook.h0.a a;
    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        super.onActivityResult(i, i2, intent3);
        this.a.f(i, i2, intent3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a obj1 = new a(this);
        this.a = obj1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.a.g();
    }
}
