package com.appsflyer.oaid;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import com.huawei.hms.ads.identifier.AdvertisingIdClient.Info;
import java.lang.reflect.Field;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class OaidClient {

    private final Context context;
    private final Logger logger;
    private final long timeout;
    private final TimeUnit unit;

    public static class Info {

        private final String id;
        private final Boolean lat;
        public Info(String string) {
            super(string, 0);
        }

        public Info(String string, Boolean boolean2) {
            super();
            this.id = string;
            this.lat = boolean2;
        }

        public String getId() {
            return this.id;
        }

        public Boolean getLat() {
            return this.lat;
        }
    }
    public OaidClient(Context context) {
        super(context, 1, obj2, TimeUnit.SECONDS);
    }

    public OaidClient(Context context, long l2, TimeUnit timeUnit3) {
        super();
        Logger logger = Logger.getLogger("AppsFlyerOaid6.2.4");
        this.logger = logger;
        this.context = context;
        this.timeout = l2;
        this.unit = obj5;
        logger.setLevel(Level.OFF);
    }

    static Context access$000(com.appsflyer.oaid.OaidClient oaidClient) {
        return oaidClient.context;
    }

    private com.appsflyer.oaid.OaidClient.Info fetchHuawei() {
        try {
            OaidClient.1 anon = new OaidClient.1(this);
            FutureTask futureTask = new FutureTask(anon);
            Thread thread = new Thread(futureTask);
            thread.start();
            return (OaidClient.Info)futureTask.get(this.timeout, obj2);
            Throwable th = th.getMessage();
            this.logger.info(th);
            th = null;
            return th;
        }
    }

    private static boolean isHuawei() {
        int i;
        int equalsIgnoreCase;
        int str;
        i = 0;
        if (!Build.BRAND.equalsIgnoreCase("huawei")) {
            try {
                if ((Integer)Class.forName("com.huawei.android.os.BuildEx$VERSION").getDeclaredField("EMUI_SDK_INT").get(0).intValue() > 0) {
                }
                i = 1;
                return i;
            }
        } else {
        }
    }

    private static boolean isMsaAvailableAtRuntime() {
        try {
            Class<com.bun.miitmdid.interfaces.IIdentifierListener> obj = IIdentifierListener.class;
            return 1;
            return 0;
        }
    }

    public com.appsflyer.oaid.OaidClient.Info fetch() {
        com.appsflyer.oaid.OaidClient.Info huawei;
        Logger logger;
        long timeout;
        TimeUnit unit;
        final int i = 0;
        if (Build.VERSION.SDK_INT < 21) {
            return i;
        }
        if (OaidClient.isHuawei()) {
            huawei = fetchHuawei();
        } else {
            if (OaidClient.isMsaAvailableAtRuntime()) {
                huawei = OaidMsaClient.fetchMsa(this.context, this.logger, this.timeout, obj6);
            } else {
                huawei = i;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Fetch ");
        stringBuilder.append(currentTimeMillis2 -= currentTimeMillis);
        stringBuilder.append(" ms");
        this.logger.info(stringBuilder.toString());
        return huawei;
    }

    public void setLogging(boolean z) {
        int obj2;
        obj2 = z ? 0 : Level.OFF;
        this.logger.setLevel(obj2);
    }
}
