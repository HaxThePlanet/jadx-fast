package com.google.firebase.dynamiclinks.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.d.a;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.h;

/* loaded from: classes2.dex */
public class DynamicLinksClient extends h<com.google.firebase.dynamiclinks.internal.IDynamicLinksService> {

    public static final String ACTION_START_SERVICE = "com.google.firebase.dynamiclinks.service.START";
    private static final int DYNAMIC_LINKS_API_VALUE = 131;
    public static final String SERVICE_DESCRIPTOR = "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
    private static final int V17 = 12451000;
    public DynamicLinksClient(Context context, Looper looper2, d d3, d.a d$a4, d.b d$b5) {
        super(context, looper2, 131, d3, a4, b5);
    }

    @Override // com.google.android.gms.common.internal.h
    protected IInterface createServiceInterface(IBinder iBinder) {
        return createServiceInterface(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h
    protected com.google.firebase.dynamiclinks.internal.IDynamicLinksService createServiceInterface(IBinder iBinder) {
        return IDynamicLinksService.Stub.asInterface(iBinder);
    }

    @Override // com.google.android.gms.common.internal.h
    void createShortDynamicLink(com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks.Stub iDynamicLinksCallbacks$Stub, Bundle bundle2) {
        try {
            (IDynamicLinksService)getService().createShortDynamicLink(stub, bundle2);
        }
    }

    @Override // com.google.android.gms.common.internal.h
    void getDynamicLink(com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks.Stub iDynamicLinksCallbacks$Stub, String string2) {
        try {
            (IDynamicLinksService)getService().getDynamicLink(stub, string2);
        }
    }

    @Override // com.google.android.gms.common.internal.h
    public int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.h
    protected String getServiceDescriptor() {
        return "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
    }

    @Override // com.google.android.gms.common.internal.h
    protected String getStartServiceAction() {
        return "com.google.firebase.dynamiclinks.service.START";
    }

    @Override // com.google.android.gms.common.internal.h
    public boolean usesClientTelemetry() {
        return 1;
    }
}
