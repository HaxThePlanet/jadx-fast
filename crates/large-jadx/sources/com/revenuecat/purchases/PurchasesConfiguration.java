package com.revenuecat.purchases;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0016\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\u0008\u001f\u0010 R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0004\u001a\u0004\u0008\u0008\u0010\u0006R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\n\u0010\u000b\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u001b\u0010\u001c¨\u0006\"", d2 = {"Lcom/revenuecat/purchases/PurchasesConfiguration;", "", "", "appUserID", "Ljava/lang/String;", "getAppUserID", "()Ljava/lang/String;", "apiKey", "getApiKey", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/revenuecat/purchases/Store;", "store", "Lcom/revenuecat/purchases/Store;", "getStore", "()Lcom/revenuecat/purchases/Store;", "", "observerMode", "Z", "getObserverMode", "()Z", "Ljava/util/concurrent/ExecutorService;", "service", "Ljava/util/concurrent/ExecutorService;", "getService", "()Ljava/util/concurrent/ExecutorService;", "Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;", "builder", "<init>", "(Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;)V", "Builder", "purchases_release"}, k = 1, mv = {1, 4, 0})
public class PurchasesConfiguration {

    private final String apiKey;
    private final String appUserID;
    private final Context context;
    private final boolean observerMode;
    private final ExecutorService service;
    private final com.revenuecat.purchases.Store store;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0014\u0008\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\u0008-\u0010.J\u0017\u0010\u0003\u001a\u00020\u00002\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\t\u0010\nJ\u0017\u0010\u000c\u001a\u00020\u00002\u0006\u0010\u000c\u001a\u00020\u000bH\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00088\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\t\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u001e\u0010\u001fR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0003\u0010\u0018\u001a\u0004\u0008 \u0010\u001a\"\u0004\u0008!\u0010\"R\"\u0010\u000c\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000c\u0010#\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0006\u0010(\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,¨\u0006/", d2 = {"Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;", "", "", "appUserID", "(Ljava/lang/String;)Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;", "", "observerMode", "(Z)Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;", "Ljava/util/concurrent/ExecutorService;", "service", "(Ljava/util/concurrent/ExecutorService;)Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;", "Lcom/revenuecat/purchases/Store;", "store", "store$purchases_release", "(Lcom/revenuecat/purchases/Store;)Lcom/revenuecat/purchases/PurchasesConfiguration$Builder;", "Lcom/revenuecat/purchases/PurchasesConfiguration;", "build", "()Lcom/revenuecat/purchases/PurchasesConfiguration;", "Ljava/util/concurrent/ExecutorService;", "getService$purchases_release", "()Ljava/util/concurrent/ExecutorService;", "setService$purchases_release", "(Ljava/util/concurrent/ExecutorService;)V", "apiKey", "Ljava/lang/String;", "getApiKey$purchases_release", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext$purchases_release", "()Landroid/content/Context;", "getAppUserID$purchases_release", "setAppUserID$purchases_release", "(Ljava/lang/String;)V", "Lcom/revenuecat/purchases/Store;", "getStore$purchases_release", "()Lcom/revenuecat/purchases/Store;", "setStore$purchases_release", "(Lcom/revenuecat/purchases/Store;)V", "Z", "getObserverMode$purchases_release", "()Z", "setObserverMode$purchases_release", "(Z)V", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
    public static class Builder {

        private final String apiKey;
        private String appUserID;
        private final Context context;
        private boolean observerMode;
        private ExecutorService service;
        private com.revenuecat.purchases.Store store;
        public Builder(Context context, String string2) {
            n.f(context, "context");
            n.f(string2, "apiKey");
            super();
            this.context = context;
            this.apiKey = string2;
            this.store = Store.PLAY_STORE;
        }

        public final com.revenuecat.purchases.PurchasesConfiguration.Builder appUserID(String string) {
            this.appUserID = string;
            return this;
        }

        public com.revenuecat.purchases.PurchasesConfiguration build() {
            PurchasesConfiguration purchasesConfiguration = new PurchasesConfiguration(this);
            return purchasesConfiguration;
        }

        public final String getApiKey$purchases_release() {
            return this.apiKey;
        }

        public final String getAppUserID$purchases_release() {
            return this.appUserID;
        }

        public final Context getContext$purchases_release() {
            return this.context;
        }

        public final boolean getObserverMode$purchases_release() {
            return this.observerMode;
        }

        public final ExecutorService getService$purchases_release() {
            return this.service;
        }

        public final com.revenuecat.purchases.Store getStore$purchases_release() {
            return this.store;
        }

        public final com.revenuecat.purchases.PurchasesConfiguration.Builder observerMode(boolean z) {
            this.observerMode = z;
            return this;
        }

        public final com.revenuecat.purchases.PurchasesConfiguration.Builder service(ExecutorService executorService) {
            n.f(executorService, "service");
            this.service = executorService;
            return this;
        }

        public final void setAppUserID$purchases_release(String string) {
            this.appUserID = string;
        }

        public final void setObserverMode$purchases_release(boolean z) {
            this.observerMode = z;
        }

        public final void setService$purchases_release(ExecutorService executorService) {
            this.service = executorService;
        }

        public final void setStore$purchases_release(com.revenuecat.purchases.Store store) {
            n.f(store, "<set-?>");
            this.store = store;
        }

        public final com.revenuecat.purchases.PurchasesConfiguration.Builder store$purchases_release(com.revenuecat.purchases.Store store) {
            n.f(store, "store");
            this.store = store;
            return this;
        }
    }
    public PurchasesConfiguration(com.revenuecat.purchases.PurchasesConfiguration.Builder purchasesConfiguration$Builder) {
        n.f(builder, "builder");
        super();
        this.context = builder.getContext$purchases_release();
        this.apiKey = builder.getApiKey$purchases_release();
        this.appUserID = builder.getAppUserID$purchases_release();
        this.observerMode = builder.getObserverMode$purchases_release();
        this.service = builder.getService$purchases_release();
        this.store = builder.getStore$purchases_release();
    }

    public final String getApiKey() {
        return this.apiKey;
    }

    public final String getAppUserID() {
        return this.appUserID;
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean getObserverMode() {
        return this.observerMode;
    }

    public final ExecutorService getService() {
        return this.service;
    }

    public final com.revenuecat.purchases.Store getStore() {
        return this.store;
    }
}
