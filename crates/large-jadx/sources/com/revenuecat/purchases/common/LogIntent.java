package com.revenuecat.purchases.common;

import java.util.List;
import kotlin.Metadata;
import kotlin.y.p;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0013\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0008\u0002\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\u0008\u0008\u0010\tR\u001f\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007j\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015¨\u0006\u0016", d2 = {"Lcom/revenuecat/purchases/common/LogIntent;", "", "", "", "emojiList", "Ljava/util/List;", "getEmojiList", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "DEBUG", "GOOGLE_ERROR", "GOOGLE_WARNING", "INFO", "PURCHASE", "RC_ERROR", "RC_PURCHASE_SUCCESS", "RC_SUCCESS", "USER", "WARNING", "AMAZON_WARNING", "AMAZON_ERROR", "common_release"}, k = 1, mv = {1, 4, 0})
public enum LogIntent {

    DEBUG("🤖"),
    GOOGLE_ERROR(false),
    GOOGLE_WARNING("🤖"),
    INFO("ℹ️"),
    PURCHASE("🤖"),
    RC_ERROR("🤖"),
    RC_PURCHASE_SUCCESS("ℹ️"),
    RC_SUCCESS("ℹ️"),
    USER("ℹ️"),
    WARNING("ℹ️"),
    AMAZON_WARNING("🤖"),
    AMAZON_ERROR("ℹ️");

    private final List<String> emojiList;
    public final List<String> getEmojiList() {
        return this.emojiList;
    }
}
