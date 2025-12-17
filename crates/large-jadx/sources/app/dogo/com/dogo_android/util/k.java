package app.dogo.com.dogo_android.util;

import android.app.ActivityManager.ProcessErrorStateInfo;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/util/CustomUrl;", "", "()V", "getCustomLinkByCountry", "", "challengeId", "countryLocation", "getSponsorLinkForPawshake", "countyCode", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k {

    public static final app.dogo.com.dogo_android.util.k a;
    static {
        k kVar = new k();
        k.a = kVar;
    }

    public static final String a(String string, String string2) {
        String str;
        int obj2;
        n.f(string, "challengeId");
        n.f(string2, "countryLocation");
        str = string.hashCode();
        if (str != -751253308) {
            switch (str) {
                case -1814016019:
                    obj2 = 0;
                    obj2 = k.a.b(string2);
                    break;
                case -1814016018:
                    obj2 = 0;
                    obj2 = k.a.b(string2);
                    break;
                case -1814016017:
                    obj2 = 0;
                    obj2 = k.a.b(string2);
                    break;
                case -1814016016:
                    obj2 = 0;
                    obj2 = k.a.b(string2);
                    break;
                default:
                    obj2 = 0;
            }
        } else {
            if (!string.equals("id_pawshake")) {
            } else {
            }
        }
        return obj2;
    }

    private final String b(String string) {
        String str;
        String obj2;
        if (string != null) {
            switch (string) {
                case "at":
                    obj2 = "https://www.pawshake.at?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "au":
                    obj2 = "https://www.pawshake.com.au?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "be":
                    obj2 = "https://nl.pawshake.be?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "ca":
                    obj2 = "https://en.pawshake.ca?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "ch":
                    obj2 = "https://de.pawshake.ch?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "de":
                    obj2 = "https://www.pawshake.de?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "dk":
                    obj2 = "https://www.pawshake.dk?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "fi":
                    obj2 = "https://www.pawshake.fi?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "fr":
                    obj2 = "https://www.pawshake.fr?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "hk":
                    obj2 = "https://www.pawshake.com.hk?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "ie":
                    obj2 = "https://www.pawshake.ie?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "it":
                    obj2 = "https://www.pawshake.it?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "lu":
                    obj2 = "https://en.pawshake.lu?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "nl":
                    obj2 = "https://www.pawshake.nl?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "no":
                    obj2 = "https://www.pawshake.no?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "nz":
                    obj2 = "https://www.pawshake.co.nz?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "sg":
                    obj2 = "https://www.pawshake.com.sg?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "sw":
                    obj2 = "https://www.pawshake.se?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                case "uk":
                    obj2 = "https://www.pawshake.co.uk?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
                    break;
                default:
                    obj2 = "http://www.pawshake.com?utm_source=dogo&utm_medium=app&utm_campaign=owners";
            }
        } else {
        }
        return obj2;
    }
}
