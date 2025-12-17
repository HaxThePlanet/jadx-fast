package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import d.e.b;
import f.c.a.d.e.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class d {

    private final Account a;
    private final Set<Scope> b;
    private final Set<Scope> c;
    private final Map<a<?>, com.google.android.gms.common.internal.c0> d;
    private final String e;
    private final String f;
    private final a g;
    private Integer h;

    public static final class a {

        private Account a;
        private b<Scope> b;
        private String c;
        private String d;
        private a e;
        public a() {
            super();
            this.e = a.B;
        }

        public com.google.android.gms.common.internal.d a() {
            super(this.a, this.b, 0, 0, 0, this.c, this.d, this.e, 0);
            return dVar2;
        }

        public com.google.android.gms.common.internal.d.a b(String string) {
            this.c = string;
            return this;
        }

        public final com.google.android.gms.common.internal.d.a c(Account account) {
            this.a = account;
            return this;
        }

        public final com.google.android.gms.common.internal.d.a d(Collection<Scope> collection) {
            b bVar;
            if (this.b == null) {
                bVar = new b();
                this.b = bVar;
            }
            this.b.addAll(collection);
            return this;
        }

        public final com.google.android.gms.common.internal.d.a e(String string) {
            this.d = string;
            return this;
        }
    }
    public d(Account account, Set<Scope> set2, Map<a<?>, com.google.android.gms.common.internal.c0> map3, int i4, View view5, String string6, String string7, a a8, boolean z9) {
        Set obj1;
        Map obj3;
        a obj8;
        super();
        this.a = account;
        if (set2 == null) {
            obj1 = Collections.emptySet();
        } else {
            obj1 = Collections.unmodifiableSet(set2);
        }
        this.b = obj1;
        if (map3 == null) {
            obj3 = Collections.emptyMap();
        }
        this.d = obj3;
        this.e = string6;
        this.f = string7;
        obj8 = a8 == null ? a.B : obj8;
        this.g = obj8;
        HashSet obj2 = new HashSet(obj1);
        obj1 = obj3.values().iterator();
        for (c0 obj3 : obj1) {
            obj2.addAll(obj3.a);
        }
        this.c = Collections.unmodifiableSet(obj2);
    }

    public Account a() {
        return this.a;
    }

    @Deprecated
    public String b() {
        Account account = this.a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    public Account c() {
        Account account = this.a;
        if (account != null) {
            return account;
        }
        Account account2 = new Account("<<default account>>", "com.google");
        return account2;
    }

    public Set<Scope> d() {
        return this.c;
    }

    public Set<Scope> e(a<?> a) {
        Map empty;
        Object obj3 = this.d.get(a);
        if ((c0)obj3 != null && obj3.a.isEmpty()) {
            if (obj3.a.isEmpty()) {
            }
            HashSet hashSet = new HashSet(this.b);
            hashSet.addAll(obj3.a);
            return hashSet;
        }
        return this.b;
    }

    public String f() {
        return this.e;
    }

    public Set<Scope> g() {
        return this.b;
    }

    public final String h() {
        return this.f;
    }

    public final a i() {
        return this.g;
    }

    public final Integer j() {
        return this.h;
    }

    public final void k(Integer integer) {
        this.h = integer;
    }
}
