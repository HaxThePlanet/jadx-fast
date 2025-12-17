package com.google.android.exoplayer2.util;

import android.accounts.Account;
import android.net.Uri;
import com.google.firebase.inappmessaging.display.ktx.R.styleable;
import com.google.firebase.inappmessaging.internal.RateLimiterClient;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class p {
    public static int a(String string) {
        int i;
        String equals;
        int i2;
        int str;
        final int i3 = -1;
        if (string == null) {
            return i3;
        }
        equals = z.r(string);
        equals.hashCode();
        final int i4 = 14;
        final int i5 = 13;
        final int i6 = 12;
        final int i7 = 11;
        final int i8 = 10;
        final int i9 = 9;
        final int i11 = 8;
        final int i12 = 7;
        final int i14 = 6;
        final int i15 = 5;
        final int i16 = 4;
        final int i17 = 3;
        final int i18 = 1;
        final int i19 = 0;
        switch (equals) {
            case "audio/eac3-joc":
                i2 = i3;
                i2 = i19;
                break;
            case "video/mp2p":
                i2 = i3;
                i2 = i18;
                break;
            case "video/mp2t":
                i2 = i3;
                i2 = 2;
                break;
            case "video/webm":
                i2 = i3;
                i2 = i17;
                break;
            case "audio/amr-wb":
                i2 = i3;
                i2 = i16;
                break;
            case "image/jpeg":
                i2 = i3;
                i2 = i15;
                break;
            case "application/mp4":
                i2 = i3;
                i2 = i14;
                break;
            case "text/vtt":
                i2 = i3;
                i2 = i12;
                break;
            case "audio/x-matroska":
                i2 = i3;
                i2 = i11;
                break;
            case "application/webm":
                i2 = i3;
                i2 = i9;
                break;
            case "video/x-flv":
                i2 = i3;
                i2 = i8;
                break;
            case "audio/ac3":
                i2 = i3;
                i2 = i7;
                break;
            case "audio/ac4":
                i2 = i3;
                i2 = i6;
                break;
            case "audio/amr":
                i2 = i3;
                i2 = i5;
                break;
            case "audio/mp4":
                i2 = i3;
                i2 = i4;
                break;
            case "audio/ogg":
                i2 = i3;
                i2 = 15;
                break;
            case "audio/wav":
                i2 = i3;
                i2 = 16;
                break;
            case "video/mp4":
                i2 = i3;
                i2 = 17;
                break;
            case "audio/3gpp":
                i2 = i3;
                i2 = 18;
                break;
            case "audio/eac3":
                i2 = i3;
                i2 = 19;
                break;
            case "audio/flac":
                i2 = i3;
                i2 = 20;
                break;
            case "audio/mpeg":
                i2 = i3;
                i2 = 21;
                break;
            case "audio/webm":
                i2 = i3;
                i2 = 22;
                break;
            case "video/x-matroska":
                i2 = i3;
                i2 = 23;
                break;
            default:
                i2 = i3;
        }
        switch (i2) {
            case 0:
                return i19;
            case 1:
                return i8;
            case 2:
                return i7;
            case 3:
                return i14;
            case 4:
                return i17;
            case 5:
                return i4;
            case 6:
                return i11;
            case 7:
                return i5;
            case 8:
                return i15;
            case 9:
                return i18;
            case 10:
                return i9;
            case 11:
                return i6;
            case 12:
                return i16;
            case 13:
                return i12;
            default:
                return i3;
        }
    }

    public static int b(Map<String, List<String>> map) {
        int empty;
        Object obj1;
        obj1 = map.get("Content-Type");
        if ((List)obj1 != null) {
            if ((List)obj1.isEmpty()) {
                obj1 = 0;
            } else {
                obj1 = obj1.get(0);
            }
        } else {
        }
        return p.a(obj1);
    }

    public static int c(Uri uri) {
        boolean endsWith7;
        boolean endsWith4;
        String startsWith2;
        boolean endsWith5;
        boolean endsWith3;
        boolean endsWith6;
        boolean endsWith2;
        boolean startsWith5;
        String startsWith3;
        boolean startsWith4;
        boolean endsWith;
        int str;
        boolean startsWith;
        String str2;
        String obj6;
        obj6 = uri.getLastPathSegment();
        final int i = -1;
        if (obj6 == null) {
            return i;
        }
        if (!obj6.endsWith(".ac3")) {
            if (obj6.endsWith(".ec3")) {
            } else {
                if (obj6.endsWith(".ac4")) {
                    return 1;
                }
                if (!obj6.endsWith(".adts")) {
                    if (obj6.endsWith(".aac")) {
                    } else {
                        if (obj6.endsWith(".amr")) {
                            return 3;
                        }
                        final int i5 = 4;
                        if (obj6.endsWith(".flac")) {
                            return i5;
                        }
                        str = 5;
                        if (obj6.endsWith(".flv")) {
                            return str;
                        }
                        if (!obj6.startsWith(".mk", length -= i5)) {
                            if (obj6.endsWith(".webm")) {
                            } else {
                                if (obj6.endsWith(".mp3")) {
                                    return 7;
                                }
                                startsWith3 = ".mp4";
                                if (!obj6.endsWith(startsWith3) && !obj6.startsWith(".m4", length5 -= i5) && !obj6.startsWith(startsWith3, length6 -= str)) {
                                    if (!obj6.startsWith(".m4", length5 -= i5)) {
                                        if (!obj6.startsWith(startsWith3, length6 -= str)) {
                                            if (obj6.startsWith(".cmf", length2 -= str)) {
                                            } else {
                                                if (!obj6.startsWith(".og", length3 -= i5)) {
                                                    if (obj6.endsWith(".opus")) {
                                                    } else {
                                                        if (!obj6.endsWith(".ps") && !obj6.endsWith(".mpeg") && !obj6.endsWith(".mpg")) {
                                                            if (!obj6.endsWith(".mpeg")) {
                                                                if (!obj6.endsWith(".mpg")) {
                                                                    if (obj6.endsWith(".m2p")) {
                                                                    } else {
                                                                        startsWith2 = ".ts";
                                                                        if (!obj6.endsWith(startsWith2)) {
                                                                            if (obj6.startsWith(startsWith2, length4 -= i5)) {
                                                                            } else {
                                                                                if (!obj6.endsWith(".wav")) {
                                                                                    if (obj6.endsWith(".wave")) {
                                                                                    } else {
                                                                                        if (!obj6.endsWith(".vtt")) {
                                                                                            if (obj6.endsWith(".webvtt")) {
                                                                                            } else {
                                                                                                if (!obj6.endsWith(".jpg") && obj6.endsWith(".jpeg")) {
                                                                                                    if (obj6.endsWith(".jpeg")) {
                                                                                                    }
                                                                                                    return i;
                                                                                                }
                                                                                            }
                                                                                            return 14;
                                                                                        }
                                                                                    }
                                                                                    return 13;
                                                                                }
                                                                            }
                                                                            return 12;
                                                                        }
                                                                    }
                                                                    return 11;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    return 10;
                                                }
                                            }
                                            return 9;
                                        }
                                    }
                                }
                            }
                            return 8;
                        }
                    }
                    return 6;
                }
            }
            return 2;
        }
        return 0;
    }
}
