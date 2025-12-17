package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import com.google.firebase.dynamiclinks.ShortDynamicLink.Warning;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class ShortDynamicLinkImpl extends a implements ShortDynamicLink {

    public static final Parcelable.Creator<com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl> CREATOR;
    private final Uri previewLink;
    private final Uri shortLink;
    private final List<com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl.WarningImpl> warnings;

    public static class WarningImpl extends a implements ShortDynamicLink.Warning {

        public static final Parcelable.Creator<com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl.WarningImpl> CREATOR;
        private final String message;
        static {
            WarningImplCreator warningImplCreator = new WarningImplCreator();
            ShortDynamicLinkImpl.WarningImpl.CREATOR = warningImplCreator;
        }

        public WarningImpl(String string) {
            super();
            this.message = string;
        }

        @Override // com.google.android.gms.common.internal.safeparcel.a
        public String getCode() {
            return null;
        }

        @Override // com.google.android.gms.common.internal.safeparcel.a
        public String getMessage() {
            return this.message;
        }

        @Override // com.google.android.gms.common.internal.safeparcel.a
        public void writeToParcel(Parcel parcel, int i2) {
            WarningImplCreator.writeToParcel(this, parcel, i2);
        }
    }
    static {
        ShortDynamicLinkImplCreator shortDynamicLinkImplCreator = new ShortDynamicLinkImplCreator();
        ShortDynamicLinkImpl.CREATOR = shortDynamicLinkImplCreator;
    }

    public ShortDynamicLinkImpl(Uri uri, Uri uri2, List<com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl.WarningImpl> list3) {
        ArrayList obj3;
        super();
        this.shortLink = uri;
        this.previewLink = uri2;
        if (list3 == null) {
            obj3 = new ArrayList();
        }
        this.warnings = obj3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public Uri getPreviewLink() {
        return this.previewLink;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public Uri getShortLink() {
        return this.shortLink;
    }

    public List<com.google.firebase.dynamiclinks.internal.ShortDynamicLinkImpl.WarningImpl> getWarnings() {
        return this.warnings;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        ShortDynamicLinkImplCreator.writeToParcel(this, parcel, i2);
    }
}
