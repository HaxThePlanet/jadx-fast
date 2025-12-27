package app.dogo.com.dogo_android.util;

import android.app.ActivityManager.ProcessErrorStateInfo;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: CustomUrl.kt */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/util/CustomUrl;", "", "()V", "getCustomLinkByCountry", "", "challengeId", "countryLocation", "getSponsorLinkForPawshake", "countyCode", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public final class CustomUrl {

    public static final k a = new k();
    private k() {
        super();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final String getCustomLinkByCountry(String challengeId, String countryLocation) {
        String str;
        int i = 0;
        n.f(challengeId, "challengeId");
        n.f(countryLocation, "countryLocation");
        int i2 = challengeId.hashCode();
        if (i2 != -751253308) {
            switch (i2) {
                case -1814016019:
                    str = "id_pawshake1";
                    i = 0;
                    String sponsorLinkForPawshake = CustomUrl.a.getSponsorLinkForPawshake(countryLocation);
                    break;
                case -1814016018:
                    str = "id_pawshake2";
                    i = 0;
                    sponsorLinkForPawshake = CustomUrl.a.getSponsorLinkForPawshake(countryLocation);
                    break;
                case -1814016017:
                    str = "id_pawshake3";
                    i = 0;
                    sponsorLinkForPawshake = CustomUrl.a.getSponsorLinkForPawshake(countryLocation);
                    break;
                case -1814016016:
                    str = "id_pawshake4";
                    i = 0;
                    sponsorLinkForPawshake = CustomUrl.a.getSponsorLinkForPawshake(countryLocation);
                    break;
                default:
                    i = 0;
            }
        }
        return i;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final String getSponsorLinkForPawshake(String countyCode) {
        String str;
        String str2;
        if (countyCode != null) {
            switch (countyCode.hashCode()) {
                case 3123:
                    str = "at";
                    str2 = "https://www.pawshake.at?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3124:
                    str = "au";
                    str2 = "https://www.pawshake.com.au?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3139:
                    str = "be";
                    str2 = "https://nl.pawshake.be?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3166:
                    str = "ca";
                    str2 = "https://en.pawshake.ca?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3173:
                    str = "ch";
                    str2 = "https://de.pawshake.ch?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3201:
                    str = "de";
                    str2 = "https://www.pawshake.de?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3207:
                    str = "dk";
                    str2 = "https://www.pawshake.dk?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3267:
                    str = "fi";
                    str2 = "https://www.pawshake.fi?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3276:
                    str = "fr";
                    str2 = "https://www.pawshake.fr?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3331:
                    str = "hk";
                    str2 = "https://www.pawshake.com.hk?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3356:
                    str = "ie";
                    str2 = "https://www.pawshake.ie?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3371:
                    str = "it";
                    str2 = "https://www.pawshake.it?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3465:
                    str = "lu";
                    str2 = "https://en.pawshake.lu?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3518:
                    str = "nl";
                    str2 = "https://www.pawshake.nl?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3521:
                    str = "no";
                    str2 = "https://www.pawshake.no?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3532:
                    str = "nz";
                    str2 = "https://www.pawshake.co.nz?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3668:
                    str = "sg";
                    str2 = "https://www.pawshake.com.sg?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3684:
                    str = "sw";
                    str2 = "https://www.pawshake.se?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case 3734:
                    str = "uk";
                    str2 = "https://www.pawshake.co.uk?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                default:
                    str2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
            }
        }
        return str2;
    }

}
