package com.facebook;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008f\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0015\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"Lcom/facebook/FacebookCallback;", "RESULT", "", "onCancel", "", "onError", "error", "Lcom/facebook/FacebookException;", "onSuccess", "result", "(Ljava/lang/Object;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public interface m<RESULT>  {
    public abstract void a();

    public abstract void b(com.facebook.FacebookException facebookException);

    public abstract void onSuccess(RESULT result);
}
