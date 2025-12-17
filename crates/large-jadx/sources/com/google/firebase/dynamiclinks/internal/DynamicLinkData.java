package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;

/* loaded from: classes2.dex */
public class DynamicLinkData extends a {

    public static final Parcelable.Creator<com.google.firebase.dynamiclinks.internal.DynamicLinkData> CREATOR;
    private long clickTimestamp = 0;
    private String deepLink;
    private String dynamicLink;
    private Bundle extensionBundle = null;
    private int minVersion;
    private Uri redirectUrl;
    static {
        DynamicLinkDataCreator dynamicLinkDataCreator = new DynamicLinkDataCreator();
        DynamicLinkData.CREATOR = dynamicLinkDataCreator;
    }

    public DynamicLinkData(String string, String string2, int i3, long l4, Bundle bundle5, Uri uri6) {
        super();
        int i = 0;
        int i2 = 0;
        this.dynamicLink = string;
        this.deepLink = string2;
        this.minVersion = i3;
        this.clickTimestamp = l4;
        this.extensionBundle = uri6;
        this.redirectUrl = obj9;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public long getClickTimestamp() {
        return this.clickTimestamp;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getDeepLink() {
        return this.deepLink;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getDynamicLink() {
        return this.dynamicLink;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public Bundle getExtensionBundle() {
        Bundle extensionBundle;
        if (this.extensionBundle == null) {
            extensionBundle = new Bundle();
        }
        return extensionBundle;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int getMinVersion() {
        return this.minVersion;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public Uri getRedirectUrl() {
        return this.redirectUrl;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void setClickTimestamp(long l) {
        this.clickTimestamp = l;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void setDeepLink(String string) {
        this.deepLink = string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void setDynamicLink(String string) {
        this.dynamicLink = string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void setExtensionData(Bundle bundle) {
        this.extensionBundle = bundle;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void setMinVersion(int i) {
        this.minVersion = i;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void setRedirectUrl(Uri uri) {
        this.redirectUrl = uri;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        DynamicLinkDataCreator.writeToParcel(this, parcel, i2);
    }
}
