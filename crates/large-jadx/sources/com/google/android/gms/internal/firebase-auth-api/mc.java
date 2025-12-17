package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* loaded from: classes2.dex */
public final class mc<T_WRAPPER extends com.google.android.gms.internal.firebase-auth-api.sc<T_ENGINE>, T_ENGINE>  {

    private static final Logger b;
    private static final List<Provider> c;
    private static final boolean d = true;
    public static final com.google.android.gms.internal.firebase-auth-api.mc<com.google.android.gms.internal.firebase-auth-api.nc, Cipher> e;
    public static final com.google.android.gms.internal.firebase-auth-api.mc<com.google.android.gms.internal.firebase-auth-api.rc, Mac> f;
    public static final com.google.android.gms.internal.firebase-auth-api.mc<com.google.android.gms.internal.firebase-auth-api.oc, KeyAgreement> g;
    public static final com.google.android.gms.internal.firebase-auth-api.mc<com.google.android.gms.internal.firebase-auth-api.qc, KeyPairGenerator> h;
    public static final com.google.android.gms.internal.firebase-auth-api.mc<com.google.android.gms.internal.firebase-auth-api.pc, KeyFactory> i;
    private final T_WRAPPER a;
    static {
        ArrayList arrayList;
        ArrayList arrayList2;
        int i;
        int i2;
        int format;
        Logger provider;
        Level iNFO;
        String str;
        String str2;
        mc.b = Logger.getLogger(mc.class.getName());
        if (dd.b()) {
            arrayList2 = new ArrayList();
            i = 0;
            i2 = i;
            while (i2 < 2) {
                format = /* result */[i2];
                provider = Security.getProvider(format);
                if (provider != null) {
                } else {
                }
                Object[] arr = new Object[1];
                arr[i] = format;
                mc.b.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", arr));
                i2++;
                arrayList2.add(provider);
            }
            mc.c = arrayList2;
        } else {
            arrayList = new ArrayList();
            mc.c = arrayList;
        }
        nc ncVar = new nc();
        mc mcVar = new mc(ncVar);
        mc.e = mcVar;
        rc rcVar = new rc();
        mc mcVar2 = new mc(rcVar);
        mc.f = mcVar2;
        oc ocVar = new oc();
        mc mcVar3 = new mc(ocVar);
        mc.g = mcVar3;
        qc qcVar = new qc();
        mc mcVar4 = new mc(qcVar);
        mc.h = mcVar4;
        pc pcVar = new pc();
        mc mcVar5 = new mc(pcVar);
        mc.i = mcVar5;
    }

    public mc(T_WRAPPER t_wrapper) {
        super();
        this.a = t_wrapper;
    }

    public final T_ENGINE a(String string) {
        int i;
        Throwable th;
        Iterator iterator = mc.c.iterator();
        final int i2 = 0;
        i = i2;
        if (iterator.hasNext()) {
            return this.a.a(string, (Provider)iterator.next());
        }
        if (!mc.d) {
        } else {
            return this.a.a(string, i2);
        }
        GeneralSecurityException obj6 = new GeneralSecurityException("No good Provider found.", i);
        throw obj6;
    }
}
