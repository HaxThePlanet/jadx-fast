package com.appsflyer.internal;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class bd implements com.appsflyer.internal.be {

    private com.appsflyer.internal.bg AFInAppEventParameterName;
    private final int AFInAppEventType;
    public Context AFKeystoreWrapper;
    private com.appsflyer.internal.n AFLogger$LogLevel;
    private com.appsflyer.internal.w AFVersionDeclaration;
    private com.appsflyer.internal.bs AppsFlyer2dXConversionCallback;
    private com.appsflyer.internal.ax valueOf;
    private ExecutorService values;
    public bd() {
        super();
        this.AFInAppEventType = (int)millis;
    }

    private com.appsflyer.internal.w AFKeystoreWrapper() {
        com.appsflyer.internal.w aFVersionDeclaration;
        com.appsflyer.internal.bk bkVar;
        ExecutorService init;
        synchronized (this) {
            try {
                bkVar = new bk(this.AFInAppEventType);
                aFVersionDeclaration = new w(bkVar, init());
                this.AFVersionDeclaration = aFVersionDeclaration;
                return this.AFVersionDeclaration;
                throw th;
            }
        }
    }

    private com.appsflyer.internal.bg AFVersionDeclaration() {
        com.appsflyer.internal.bg aFInAppEventParameterName;
        synchronized (this) {
            try {
                aFInAppEventParameterName = new bg();
                this.AFInAppEventParameterName = aFInAppEventParameterName;
                return this.AFInAppEventParameterName;
                throw th;
            }
        }
    }

    private ExecutorService init() {
        ExecutorService cachedThreadPool;
        synchronized (this) {
            try {
                this.values = Executors.newCachedThreadPool();
                return this.values;
                throw th;
            }
        }
    }

    @Override // com.appsflyer.internal.be
    public final com.appsflyer.internal.bh AFInAppEventParameterName() {
        bh bhVar = new bh(AFKeystoreWrapper(), AFInAppEventType());
        return bhVar;
    }

    @Override // com.appsflyer.internal.be
    public final com.appsflyer.internal.n AFInAppEventType() {
        com.appsflyer.internal.n aFLogger$LogLevel;
        Context aFKeystoreWrapper;
        synchronized (this) {
            try {
                aFKeystoreWrapper = this.AFKeystoreWrapper;
                if (aFKeystoreWrapper == null) {
                } else {
                }
                aFLogger$LogLevel = new n(aFKeystoreWrapper);
                this.AFLogger$LogLevel = aFLogger$LogLevel;
                IllegalStateException illegalStateException = new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                throw illegalStateException;
                return this.AFLogger$LogLevel;
                throw th;
            }
        }
    }

    @Override // com.appsflyer.internal.be
    public final com.appsflyer.internal.bs valueOf() {
        com.appsflyer.internal.bs appsFlyer2dXConversionCallback;
        com.appsflyer.internal.bs bsVar;
        com.appsflyer.internal.bn bnVar;
        com.appsflyer.internal.n nVar2;
        com.appsflyer.internal.bw bwVar;
        com.appsflyer.internal.bh bhVar;
        com.appsflyer.internal.bt btVar;
        ExecutorService singleThreadExecutor;
        com.appsflyer.internal.n nVar;
        synchronized (this) {
            try {
                Context aFKeystoreWrapper = this.AFKeystoreWrapper;
                if (aFKeystoreWrapper == null) {
                } else {
                }
                ay ayVar = new ay(ah.AFKeystoreWrapper(aFKeystoreWrapper));
                bwVar = new bw(ayVar);
                btVar = new bt(AFInAppEventType(), bwVar);
                bnVar = new bn();
                bhVar = new bh(AFKeystoreWrapper(), AFInAppEventType());
                super(bnVar, AFInAppEventType(), bwVar, bhVar, btVar, Executors.newSingleThreadExecutor());
                this.AppsFlyer2dXConversionCallback = appsFlyer2dXConversionCallback;
                IllegalStateException illegalStateException = new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                throw illegalStateException;
                return this.AppsFlyer2dXConversionCallback;
                throw th;
            }
        }
    }

    @Override // com.appsflyer.internal.be
    public final com.appsflyer.internal.ax values() {
        com.appsflyer.internal.ax valueOf;
        com.appsflyer.internal.ax axVar;
        com.appsflyer.internal.bg bgVar;
        com.appsflyer.internal.az azVar;
        com.appsflyer.internal.ay ayVar;
        ExecutorService init;
        com.appsflyer.internal.bh bhVar;
        com.appsflyer.internal.n nVar;
        synchronized (this) {
            try {
                Context aFKeystoreWrapper = this.AFKeystoreWrapper;
                if (aFKeystoreWrapper == null) {
                } else {
                }
                azVar = new az(aFKeystoreWrapper);
                Context aFKeystoreWrapper2 = this.AFKeystoreWrapper;
                if (aFKeystoreWrapper2 == null) {
                } else {
                }
                ayVar = new ay(ah.AFKeystoreWrapper(aFKeystoreWrapper2));
                bhVar = new bh(AFKeystoreWrapper(), AFInAppEventType());
                super(AFVersionDeclaration(), azVar, ayVar, init(), bhVar);
                this.valueOf = valueOf;
                IllegalStateException illegalStateException2 = new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                throw illegalStateException2;
                IllegalStateException illegalStateException = new IllegalStateException("Context must be set via setContext method before calling this dependency.");
                throw illegalStateException;
                return this.valueOf;
                throw th;
            }
        }
    }
}
