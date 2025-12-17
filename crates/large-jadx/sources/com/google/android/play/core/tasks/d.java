package com.google.android.play.core.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class d<ResultT>  {
    public abstract com.google.android.play.core.tasks.d<ResultT> a(com.google.android.play.core.tasks.a<ResultT> a);

    public abstract com.google.android.play.core.tasks.d<ResultT> b(com.google.android.play.core.tasks.b b);

    public abstract com.google.android.play.core.tasks.d<ResultT> c(Executor executor, com.google.android.play.core.tasks.b b2);

    public abstract com.google.android.play.core.tasks.d<ResultT> d(com.google.android.play.core.tasks.c<? super ResultT> c);

    public abstract com.google.android.play.core.tasks.d<ResultT> e(Executor executor, com.google.android.play.core.tasks.c<? super ResultT> c2);

    public abstract Exception f();

    public abstract ResultT g();

    public abstract boolean h();

    public abstract boolean i();
}
