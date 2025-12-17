package com.revenuecat.purchases.interfaces;

/* loaded from: classes2.dex */
@FunctionalInterface
public interface Callback<T>  {
    public abstract void onReceived(T t);
}
