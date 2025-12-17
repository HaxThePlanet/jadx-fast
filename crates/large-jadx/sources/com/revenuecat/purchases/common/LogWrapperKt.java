package com.revenuecat.purchases.common;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lcom/revenuecat/purchases/common/LogIntent;", "intent", "", "message", "Lkotlin/w;", "log", "(Lcom/revenuecat/purchases/common/LogIntent;Ljava/lang/String;)V", "common_release"}, k = 2, mv = {1, 4, 0})
public final class LogWrapperKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            LogWrapperKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[LogIntent.DEBUG.ordinal()] = 1;
            iArr[LogIntent.GOOGLE_ERROR.ordinal()] = 2;
            iArr[LogIntent.GOOGLE_WARNING.ordinal()] = 3;
            iArr[LogIntent.INFO.ordinal()] = 4;
            iArr[LogIntent.PURCHASE.ordinal()] = 5;
            iArr[LogIntent.RC_ERROR.ordinal()] = 6;
            iArr[LogIntent.RC_PURCHASE_SUCCESS.ordinal()] = 7;
            iArr[LogIntent.RC_SUCCESS.ordinal()] = 8;
            iArr[LogIntent.USER.ordinal()] = 9;
            iArr[LogIntent.WARNING.ordinal()] = 10;
            iArr[LogIntent.AMAZON_WARNING.ordinal()] = 11;
            iArr[LogIntent.AMAZON_ERROR.ordinal()] = 12;
        }
    }
    public static final void log(com.revenuecat.purchases.common.LogIntent logIntent, String string2) {
        n.f(logIntent, "intent");
        n.f(string2, "message");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(p.h0(logIntent.getEmojiList(), "", 0, 0, 0, 0, 0, 62, 0));
        stringBuilder.append(' ');
        stringBuilder.append(string2);
        final String obj11 = stringBuilder.toString();
        switch (obj10) {
            case 1:
                LogUtilsKt.debugLog(obj11);
                break;
            case 2:
                LogUtilsKt.errorLog(obj11);
                break;
            case 3:
                LogUtilsKt.warnLog(obj11);
                break;
            case 4:
                LogUtilsKt.infoLog(obj11);
                break;
            case 5:
                LogUtilsKt.debugLog(obj11);
                break;
            case 6:
                LogUtilsKt.errorLog(obj11);
                break;
            case 7:
                LogUtilsKt.infoLog(obj11);
                break;
            case 8:
                LogUtilsKt.debugLog(obj11);
                break;
            case 9:
                LogUtilsKt.debugLog(obj11);
                break;
            case 10:
                LogUtilsKt.warnLog(obj11);
                break;
            case 11:
                LogUtilsKt.warnLog(obj11);
                break;
            case 12:
                LogUtilsKt.errorLog(obj11);
                break;
            default:
        }
    }
}
