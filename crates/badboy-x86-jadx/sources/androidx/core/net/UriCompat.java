package androidx.core.net;

import android.net.Uri;

/* loaded from: classes5.dex */
public final class UriCompat {
    public static String toSafeString(Uri uri) {
        String ssp;
        int i;
        boolean equalsIgnoreCase;
        boolean equalsIgnoreCase2;
        int charAt;
        String host;
        int append;
        int string;
        int i2;
        final String scheme = uri.getScheme();
        ssp = uri.getSchemeSpecificPart();
        i = 58;
        final int i3 = 64;
        if (scheme != null) {
            if (!scheme.equalsIgnoreCase("tel") && !scheme.equalsIgnoreCase("sip") && !scheme.equalsIgnoreCase("sms") && !scheme.equalsIgnoreCase("smsto") && !scheme.equalsIgnoreCase("mailto")) {
                if (!scheme.equalsIgnoreCase("sip")) {
                    if (!scheme.equalsIgnoreCase("sms")) {
                        if (!scheme.equalsIgnoreCase("smsto")) {
                            if (!scheme.equalsIgnoreCase("mailto")) {
                                if (scheme.equalsIgnoreCase("nfc")) {
                                    StringBuilder stringBuilder = new StringBuilder(i3);
                                    stringBuilder.append(scheme);
                                    stringBuilder.append(i);
                                    if (ssp != null) {
                                        i = 0;
                                        while (i < ssp.length()) {
                                            charAt = ssp.charAt(i);
                                            if (charAt != 45 && charAt != i3) {
                                            } else {
                                            }
                                            stringBuilder.append(charAt);
                                            i++;
                                            if (charAt != i3) {
                                            } else {
                                            }
                                            if (charAt == 46) {
                                            } else {
                                            }
                                            stringBuilder.append('x');
                                        }
                                    }
                                }
                                if (!scheme.equalsIgnoreCase("http") && !scheme.equalsIgnoreCase("https") && !scheme.equalsIgnoreCase("ftp")) {
                                    if (!scheme.equalsIgnoreCase("https")) {
                                        if (!scheme.equalsIgnoreCase("ftp")) {
                                            if (scheme.equalsIgnoreCase("rtsp")) {
                                                StringBuilder stringBuilder2 = new StringBuilder();
                                                if (uri.getHost() != null) {
                                                    host = uri.getHost();
                                                } else {
                                                    host = string;
                                                }
                                                if (uri.getPort() != -1) {
                                                    StringBuilder stringBuilder3 = new StringBuilder();
                                                    string = stringBuilder3.append(":").append(uri.getPort()).toString();
                                                }
                                                ssp = stringBuilder2.append("//").append(host).append(string).append("/...").toString();
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return stringBuilder.toString();
        }
        StringBuilder builder = new StringBuilder(i3);
        if (scheme != null) {
            builder.append(scheme);
            builder.append(i);
        }
        if (ssp != null) {
            builder.append(ssp);
        }
        return builder.toString();
    }
}
