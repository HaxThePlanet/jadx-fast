package com.revenuecat.purchases;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0004¨\u0006\u0006", d2 = {"Lcom/revenuecat/purchases/LifecycleDelegate;", "", "Lkotlin/w;", "onAppBackgrounded", "()V", "onAppForegrounded", "purchases_release"}, k = 1, mv = {1, 4, 0})
public interface LifecycleDelegate {
    public abstract void onAppBackgrounded();

    public abstract void onAppForegrounded();
}
