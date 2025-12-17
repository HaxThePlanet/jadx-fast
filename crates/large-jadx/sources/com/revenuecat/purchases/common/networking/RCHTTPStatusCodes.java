package com.revenuecat.purchases.common.networking;

import kotlin.Metadata;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0004R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\t\u0010\u0004¨\u0006\u000c", d2 = {"Lcom/revenuecat/purchases/common/networking/RCHTTPStatusCodes;", "", "", "NOT_MODIFIED", "I", "UNSUCCESSFUL", "SUCCESS", "CREATED", "ERROR", "NOT_FOUND", "<init>", "()V", "common_release"}, k = 1, mv = {1, 4, 0})
public final class RCHTTPStatusCodes {

    public static final int CREATED = 201;
    public static final int ERROR = 500;
    public static final com.revenuecat.purchases.common.networking.RCHTTPStatusCodes INSTANCE = null;
    public static final int NOT_FOUND = 404;
    public static final int NOT_MODIFIED = 304;
    public static final int SUCCESS = 200;
    public static final int UNSUCCESSFUL = 300;
    static {
        RCHTTPStatusCodes rCHTTPStatusCodes = new RCHTTPStatusCodes();
        RCHTTPStatusCodes.INSTANCE = rCHTTPStatusCodes;
    }
}
