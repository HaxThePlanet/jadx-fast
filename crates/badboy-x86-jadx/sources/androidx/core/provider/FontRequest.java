package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import java.util.List;

/* loaded from: classes5.dex */
public final class FontRequest {

    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;
    public FontRequest(String providerAuthority, String providerPackage, String query, int certificates) {
        int i;
        super();
        this.mProviderAuthority = (String)Preconditions.checkNotNull(providerAuthority);
        this.mProviderPackage = (String)Preconditions.checkNotNull(providerPackage);
        this.mQuery = (String)Preconditions.checkNotNull(query);
        this.mCertificates = 0;
        i = certificates != 0 ? 1 : 0;
        Preconditions.checkArgument(i);
        this.mCertificatesArray = certificates;
        this.mIdentifier = createIdentifier(providerAuthority, providerPackage, query);
    }

    public FontRequest(String providerAuthority, String providerPackage, String query, List<List<byte[]>> list4) {
        super();
        this.mProviderAuthority = (String)Preconditions.checkNotNull(providerAuthority);
        this.mProviderPackage = (String)Preconditions.checkNotNull(providerPackage);
        this.mQuery = (String)Preconditions.checkNotNull(query);
        this.mCertificates = (List)Preconditions.checkNotNull(list4);
        this.mCertificatesArray = 0;
        this.mIdentifier = createIdentifier(providerAuthority, providerPackage, query);
    }

    private String createIdentifier(String providerAuthority, String providerPackage, String query) {
        StringBuilder stringBuilder = new StringBuilder();
        final String str = "-";
        return stringBuilder.append(providerAuthority).append(str).append(providerPackage).append(str).append(query).toString();
    }

    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    String getId() {
        return this.mIdentifier;
    }

    @Deprecated
    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String toString() {
        int i;
        String str2;
        String j;
        int j2;
        int size;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder.append(stringBuilder2.append("FontRequest {mProviderAuthority: ").append(this.mProviderAuthority).append(", mProviderPackage: ").append(this.mProviderPackage).append(", mQuery: ").append(this.mQuery).append(", mCertificates:").toString());
        i = 0;
        while (i < this.mCertificates.size()) {
            stringBuilder.append(" [");
            str2 = this.mCertificates.get(i);
            j2 = 0;
            while (j2 < (List)str2.size()) {
                stringBuilder.append(" \"");
                stringBuilder.append(Base64.encodeToString((byte[])str2.get(j2), 0));
                stringBuilder.append("\"");
                j2++;
            }
            stringBuilder.append(" ]");
            i++;
            stringBuilder.append(" \"");
            stringBuilder.append(Base64.encodeToString((byte[])str2.get(j2), 0));
            stringBuilder.append("\"");
            j2++;
        }
        stringBuilder.append("}");
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder.append(stringBuilder3.append("mCertificatesArray: ").append(this.mCertificatesArray).toString());
        return stringBuilder.toString();
    }
}
