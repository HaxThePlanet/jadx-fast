package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.n;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class NavigationMenuView extends RecyclerView implements n {
    public NavigationMenuView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        LinearLayoutManager obj3 = new LinearLayoutManager(context, 1, 0);
        setLayoutManager(obj3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void b(g g) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public int getWindowAnimations() {
        return 0;
    }
}
