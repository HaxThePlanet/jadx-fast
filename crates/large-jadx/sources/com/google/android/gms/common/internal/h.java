package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class h<T extends android.os.IInterface>  extends com.google.android.gms.common.internal.c<T> implements a.f {

    private final com.google.android.gms.common.internal.d zaa;
    private final Set<Scope> zab;
    private final Account zac;
    protected h(Context context, Handler handler2, int i3, com.google.android.gms.common.internal.d d4) {
        super(context, handler2, i.b(context), e.o(), i3, 0, 0);
        r.j(d4);
        this.zaa = (d)d4;
        this.zac = d4.a();
        this.zab = zaa(d4.d());
    }

    protected h(Context context, Looper looper2, int i3, com.google.android.gms.common.internal.d d4) {
        super(context, looper2, i.b(context), e.o(), i3, d4, 0, 0);
    }

    @Deprecated
    protected h(Context context, Looper looper2, int i3, com.google.android.gms.common.internal.d d4, d.a d$a5, d.b d$b6) {
        super(context, looper2, i3, d4, a5, b6);
    }

    protected h(Context context, Looper looper2, int i3, com.google.android.gms.common.internal.d d4, f f5, m m6) {
        r.j(f5);
        r.j(m6);
        super(context, looper2, i.b(context), e.o(), i3, d4, (f)f5, (m)m6);
    }

    protected h(Context context, Looper looper2, com.google.android.gms.common.internal.i i3, e e4, int i5, com.google.android.gms.common.internal.d d6, f f7, m m8) {
        Object i0Var;
        com.google.android.gms.common.internal.h0 h0Var;
        int i;
        com.google.android.gms.common.internal.i0 i0Var2;
        final Object obj2 = this;
        i0Var = f7;
        m mVar = m8;
        int i2 = 0;
        if (i0Var == null) {
            i = i2;
        } else {
            h0Var = new h0(i0Var);
            i = h0Var;
        }
        if (mVar == null) {
            i0Var2 = i2;
        } else {
            i0Var = new i0(mVar);
            i0Var2 = i0Var;
        }
        super(context, looper2, i3, e4, i5, i, i0Var2, d6.h());
        obj2.zaa = d6;
        obj2.zac = d6.a();
        obj2.zab = zaa(d6.d());
    }

    private final Set<Scope> zaa(Set<Scope> set) {
        boolean contains;
        Set validateScopes = validateScopes(set);
        final Iterator iterator = validateScopes.iterator();
        for (Scope next2 : iterator) {
        }
        return validateScopes;
    }

    public final Account getAccount() {
        return this.zac;
    }

    protected final com.google.android.gms.common.internal.d getClientSettings() {
        return this.zaa;
    }

    public d[] getRequiredFeatures() {
        return new d[0];
    }

    protected final Set<Scope> getScopes() {
        return this.zab;
    }

    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        Set emptySet;
        if (requiresSignIn()) {
            emptySet = this.zab;
        } else {
            emptySet = Collections.emptySet();
        }
        return emptySet;
    }

    protected Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }
}
