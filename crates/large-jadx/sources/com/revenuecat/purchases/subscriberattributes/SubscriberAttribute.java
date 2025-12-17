package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.j0;
import org.json.JSONObject;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001a\u0008\u0086\u0008\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010 \u001a\u00020\u0016\u0012\u0008\u0008\u0002\u0010!\u001a\u00020\u0019\u0012\u0008\u0008\u0002\u0010\"\u001a\u00020\n¢\u0006\u0004\u0008.\u0010/B9\u0008\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0008\u0002\u0010 \u001a\u00020\u0016\u0012\u0008\u0008\u0002\u0010!\u001a\u00020\u0019\u0012\u0008\u0008\u0002\u0010\"\u001a\u00020\n¢\u0006\u0004\u0008.\u00100B\u0011\u0008\u0016\u0012\u0006\u00101\u001a\u00020\u0002¢\u0006\u0004\u0008.\u00102J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001a\u0010\u000b\u001a\u00020\n2\u0008\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\u0008\u0015\u0010\u0011J\u0010\u0010\u0017\u001a\u00020\u0016HÆ\u0003¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÆ\u0003¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\nHÆ\u0003¢\u0006\u0004\u0008\u001c\u0010\u001dJD\u0010#\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00122\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010 \u001a\u00020\u00162\u0008\u0008\u0002\u0010!\u001a\u00020\u00192\u0008\u0008\u0002\u0010\"\u001a\u00020\nHÆ\u0001¢\u0006\u0004\u0008#\u0010$R\u0019\u0010\u001e\u001a\u00020\u00128\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001e\u0010%\u001a\u0004\u0008&\u0010\u0014R\u0019\u0010!\u001a\u00020\u00198\u0006@\u0006¢\u0006\u000c\n\u0004\u0008!\u0010'\u001a\u0004\u0008(\u0010\u001bR\u0019\u0010 \u001a\u00020\u00168\u0006@\u0006¢\u0006\u000c\n\u0004\u0008 \u0010)\u001a\u0004\u0008*\u0010\u0018R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001f\u0010+\u001a\u0004\u0008,\u0010\u0011R\u0019\u0010\"\u001a\u00020\n8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010-\u001a\u0004\u0008\"\u0010\u001d¨\u00063", d2 = {"Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "", "Lorg/json/JSONObject;", "toJSONObject", "()Lorg/json/JSONObject;", "", "", "toBackendMap", "()Ljava/util/Map;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "component1", "()Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "component2", "Lcom/revenuecat/purchases/common/DateProvider;", "component3", "()Lcom/revenuecat/purchases/common/DateProvider;", "Ljava/util/Date;", "component4", "()Ljava/util/Date;", "component5", "()Z", "key", "value", "dateProvider", "setTime", "isSynced", "copy", "(Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;Ljava/util/Date;Z)Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;", "getKey", "Ljava/util/Date;", "getSetTime", "Lcom/revenuecat/purchases/common/DateProvider;", "getDateProvider", "Ljava/lang/String;", "getValue", "Z", "<init>", "(Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttributeKey;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;Ljava/util/Date;Z)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;Ljava/util/Date;Z)V", "jsonObject", "(Lorg/json/JSONObject;)V", "subscriber-attributes_release"}, k = 1, mv = {1, 4, 0})
public final class SubscriberAttribute {

    private final DateProvider dateProvider;
    private final boolean isSynced;
    private final com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey key;
    private final Date setTime;
    private final String value;
    public SubscriberAttribute(com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey subscriberAttributeKey, String string2, DateProvider dateProvider3, Date date4, boolean z5) {
        n.f(subscriberAttributeKey, "key");
        n.f(dateProvider3, "dateProvider");
        n.f(date4, "setTime");
        super();
        this.key = subscriberAttributeKey;
        this.value = string2;
        this.dateProvider = dateProvider3;
        this.setTime = date4;
        this.isSynced = z5;
    }

    public SubscriberAttribute(com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey subscriberAttributeKey, String string2, DateProvider dateProvider3, Date date4, boolean z5, int i6, g g7) {
        DefaultDateProvider obj9;
        Date obj10;
        int obj11;
        if (i6 & 4 != 0) {
            obj9 = new DefaultDateProvider();
        }
        final DefaultDateProvider date = obj9;
        if (i6 & 8 != 0) {
            obj10 = date.getNow();
        }
        obj11 = i6 & 16 != 0 ? 0 : obj11;
        super(subscriberAttributeKey, string2, date, obj10, obj11);
    }

    public SubscriberAttribute(String string, String string2, DateProvider dateProvider3, Date date4, boolean z5) {
        n.f(string, "key");
        n.f(dateProvider3, "dateProvider");
        n.f(date4, "setTime");
        super(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(string), string2, 0, date4, z5, 4, 0);
    }

    public SubscriberAttribute(String string, String string2, DateProvider dateProvider3, Date date4, boolean z5, int i6, g g7) {
        DefaultDateProvider obj9;
        Date obj10;
        int obj11;
        if (i6 & 4 != 0) {
            obj9 = new DefaultDateProvider();
        }
        final DefaultDateProvider date = obj9;
        if (i6 & 8 != 0) {
            obj10 = date.getNow();
        }
        obj11 = i6 & 16 != 0 ? 0 : obj11;
        super(string, string2, date, obj10, obj11);
    }

    public SubscriberAttribute(JSONObject jSONObject) {
        n.f(jSONObject, "jsonObject");
        String string = jSONObject.getString("key");
        final String str6 = "jsonObject.getString(JSON_NAME_KEY)";
        n.e(string, str6);
        Date date = new Date(jSONObject.getLong("set_time"), str6);
        super(SpecialSubscriberAttributesKt.getSubscriberAttributeKey(string), JSONObjectExtensionsKt.getNullableString(jSONObject, "value"), 0, date, jSONObject.getBoolean("is_synced"), 4, 0);
    }

    public static com.revenuecat.purchases.subscriberattributes.SubscriberAttribute copy$default(com.revenuecat.purchases.subscriberattributes.SubscriberAttribute subscriberAttribute, com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey subscriberAttributeKey2, String string3, DateProvider dateProvider4, Date date5, boolean z6, int i7, Object object8) {
        com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey obj4;
        String obj5;
        DateProvider obj6;
        Date obj7;
        boolean obj8;
        if (i7 & 1 != 0) {
            obj4 = subscriberAttribute.key;
        }
        if (i7 & 2 != 0) {
            obj5 = subscriberAttribute.value;
        }
        if (i7 & 4 != 0) {
            obj6 = subscriberAttribute.dateProvider;
        }
        if (i7 & 8 != 0) {
            obj7 = subscriberAttribute.setTime;
        }
        if (i7 & 16 != 0) {
            obj8 = subscriberAttribute.isSynced;
        }
        return subscriberAttribute.copy(obj4, obj5, obj6, obj7, obj8);
    }

    public final com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey component1() {
        return this.key;
    }

    public final String component2() {
        return this.value;
    }

    public final DateProvider component3() {
        return this.dateProvider;
    }

    public final Date component4() {
        return this.setTime;
    }

    public final boolean component5() {
        return this.isSynced;
    }

    public final com.revenuecat.purchases.subscriberattributes.SubscriberAttribute copy(com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey subscriberAttributeKey, String string2, DateProvider dateProvider3, Date date4, boolean z5) {
        n.f(subscriberAttributeKey, "key");
        n.f(dateProvider3, "dateProvider");
        n.f(date4, "setTime");
        super(subscriberAttributeKey, string2, dateProvider3, date4, z5);
        return subscriberAttribute;
    }

    public boolean equals(Object object) {
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        if (object != null) {
            class = object.getClass();
        } else {
            class = 0;
        }
        int i6 = 0;
        if (z ^= i != 0) {
            return i6;
        }
        Objects.requireNonNull(object, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttribute");
        if (z2 ^= i != 0) {
            return i6;
        }
        if (z3 ^= i != 0) {
            return i6;
        }
        if (z4 ^= i != 0) {
            return i6;
        }
        if (this.isSynced != object.isSynced) {
            return i6;
        }
        return i;
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKey getKey() {
        return this.key;
    }

    public final Date getSetTime() {
        return this.setTime;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i;
        String value = this.value;
        if (value != null) {
            i = value.hashCode();
        } else {
            i = 0;
        }
        return i7 += i10;
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    public final Map<String, Object> toBackendMap() {
        kotlin.o[] arr = new o[2];
        int i2 = 0;
        arr[i2] = u.a("value", this.value);
        arr[1] = u.a("updated_at_ms", Long.valueOf(this.setTime.getTime()));
        return j0.k(arr);
    }

    public final JSONObject toJSONObject() {
        Object nULL;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", this.key.getBackendKey());
        nULL = this.value;
        String str2 = "value";
        if (nULL != null && jSONObject.put(str2, nULL) != null) {
            if (jSONObject.put(str2, nULL) != null) {
            } else {
                jSONObject.put(str2, JSONObject.NULL);
            }
        } else {
        }
        jSONObject.put("set_time", this.setTime.getTime());
        jSONObject.put("is_synced", this.isSynced);
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SubscriberAttribute(key=");
        stringBuilder.append(this.key);
        stringBuilder.append(", value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", setTime=");
        stringBuilder.append(this.setTime);
        stringBuilder.append(", isSynced=");
        stringBuilder.append(this.isSynced);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
