package com.appsflyer.oaid;

import android.content.Context;
import android.text.TextUtils;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* loaded from: classes.dex */
class OaidMsaClient {
    static com.appsflyer.oaid.OaidClient.Info fetchMsa(Context context, Logger logger2, long l3, TimeUnit timeUnit4) {
        int i;
        int i2;
        String obj4;
        boolean obj6;
        i = 0;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        if (logger2.getLevel() == null) {
            try {
                i2 = 1;
                i2 = 0;
                OaidMsaClient.1 anon = new OaidMsaClient.1(linkedBlockingQueue, logger2);
                obj4 = MdidSdkHelper.InitSdk(context, i2, anon);
                if (obj4 != null) {
                }
                obj4 = String.valueOf(obj4);
                obj4 = "Reflection call error";
                obj4 = "Callback will be executed in a different thread";
                obj4 = "Error loading configuration file";
                obj4 = "Unsupported device";
                obj4 = "Unsupported manufacturer";
                obj4 = "Init error begin";
                logger2.warning(obj4);
                obj4 = linkedBlockingQueue.poll(l3, timeUnit4);
                if (TextUtils.isEmpty((String)obj4)) {
                } else {
                }
                obj6 = new OaidClient.Info(obj4);
                i = obj6;
                return i;
                context = context.getMessage();
                logger2.info(context);
                return i3;
                obj25570 = obj15;
                int i3 = 1310720;
                return i3;
                i3 = /* result */;
                i3 = i3;
            }
        } else {
        }
    }
}
