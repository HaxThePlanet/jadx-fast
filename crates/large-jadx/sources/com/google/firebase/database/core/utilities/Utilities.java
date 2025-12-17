package com.google.firebase.database.core.utilities;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.RepoInfo;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public class Utilities {

    private static final char[] HEX_CHARACTERS;
    static {
        Utilities.HEX_CHARACTERS = "0123456789abcdef".toCharArray();
    }

    public static <C> C castOrNull(Object object, Class<C> class2) {
        if (class2.isAssignableFrom(object.getClass())) {
            return object;
        }
        return 0;
    }

    public static int compareInts(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        if (i == i2) {
            return 0;
        }
        return 1;
    }

    public static int compareLongs(long l, long l2) {
        int obj0 = Long.compare(l, obj2);
        if (obj0 < 0) {
            return -1;
        }
        if (obj0 == null) {
            return 0;
        }
        return 1;
    }

    public static String doubleToHashString(double d) {
        int i;
        char c;
        char c2;
        char[] hEX_CHARACTERS;
        StringBuilder stringBuilder = new StringBuilder(16);
        i = 7;
        while (i >= 0) {
            int i6 = (int)i5;
            hEX_CHARACTERS = Utilities.HEX_CHARACTERS;
            stringBuilder.append(hEX_CHARACTERS[i8 &= 15]);
            stringBuilder.append(hEX_CHARACTERS[i6 &= 15]);
            i--;
        }
        return stringBuilder.toString();
    }

    public static boolean equals(Object object, Object object2) {
        if (object == object2) {
            return 1;
        }
        if (object != null && object2 == null) {
            if (object2 == null) {
            }
            return object.equals(object2);
        }
        return 0;
    }

    private static String extractPathString(String string) {
        int indexOf = string.indexOf("//");
        final int i4 = -1;
        if (indexOf == i4) {
        } else {
            String obj3 = string.substring(indexOf += 2);
            int indexOf2 = obj3.indexOf("/");
            int indexOf3 = obj3.indexOf("?");
            if (indexOf2 != i4 && indexOf3 != i4) {
                indexOf3 = obj3.indexOf("?");
                if (indexOf3 != i4) {
                    return obj3.substring(indexOf2++, indexOf3);
                }
                return obj3.substring(indexOf2++);
            }
            return "";
        }
        obj3 = new DatabaseException("Firebase Database URL is missing URL scheme");
        throw obj3;
    }

    public static <C> C getOrNull(Object object, String string2, Class<C> class3) {
        final int i = 0;
        if (object == null) {
            return i;
        }
        Object obj2 = (Map)Utilities.castOrNull(object, Map.class).get(string2);
        if (obj2 != null) {
            return Utilities.castOrNull(obj2, class3);
        }
        return i;
    }

    public static void hardAssert(boolean z) {
        Utilities.hardAssert(z, "");
    }

    public static void hardAssert(boolean z, String string2) {
        String str;
        String obj1;
        String obj2;
        if (z == null) {
            obj1 = new StringBuilder();
            obj1.append("Assertion failed: ");
            obj1.append(string2);
            Log.w("FirebaseDatabase", obj1.toString());
        }
    }

    public static com.google.firebase.database.core.utilities.ParsedUrl parseUrl(String string) {
        int string2;
        Object stringBuilder;
        int str;
        String queryParameter;
        int i;
        int equals;
        Locale locale;
        try {
            Uri parse = Uri.parse(string);
            stringBuilder = parse.getScheme();
            if (stringBuilder == null) {
            } else {
            }
            String host2 = parse.getHost();
            if (host2 == null) {
            } else {
            }
            equals = -1;
            if (parse.getQueryParameter("ns") == null) {
            }
            queryParameter = host2.split("\\.", equals)[0].toLowerCase(Locale.US);
            RepoInfo repoInfo = new RepoInfo();
            repoInfo.host = host2.toLowerCase(Locale.US);
            string2 = parse.getPort();
            str = 1;
            if (string2 != equals) {
            } else {
            }
            if (!stringBuilder.equals("https")) {
            } else {
            }
            if (stringBuilder.equals("wss")) {
            }
            i = str;
            repoInfo.secure = i;
            stringBuilder = new StringBuilder();
            stringBuilder.append(repoInfo.host);
            stringBuilder.append(":");
            stringBuilder.append(string2);
            repoInfo.host = stringBuilder.toString();
            repoInfo.secure = str;
            repoInfo.internalHost = repoInfo.host;
            repoInfo.namespace = queryParameter;
            String replace = Utilities.extractPathString(string).replace("+", " ");
            Validation.validateRootPathString(replace);
            ParsedUrl parsedUrl = new ParsedUrl();
            Path path = new Path(replace);
            parsedUrl.path = path;
            parsedUrl.repoInfo = repoInfo;
            return parsedUrl;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Database URL does not specify a valid host");
            throw illegalArgumentException;
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Database URL does not specify a URL scheme");
            throw illegalArgumentException2;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid Firebase Database url specified: ");
            stringBuilder2.append(string);
            string = stringBuilder2.toString();
            DatabaseException databaseException = new DatabaseException(string, th);
            throw databaseException;
        }
    }

    public static String sha1HexDigest(String string) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(string.getBytes("UTF-8"));
            return Base64.encodeToString(instance.digest(), 2);
            String runtimeException = "UTF-8 encoding is required for Firebase Database to run!";
            string = new RuntimeException(runtimeException);
            throw string;
            runtimeException = new RuntimeException("Missing SHA-1 MessageDigest provider.", string);
            throw runtimeException;
        }
    }

    public static String stringHashV2Representation(String string) {
        String replace;
        int str2;
        String str;
        int obj3;
        str2 = -1;
        if (string.indexOf(92) != str2) {
            replace = string.replace("\\", "\\\\");
        } else {
            replace = string;
        }
        int i2 = 34;
        if (string.indexOf(i2) != str2) {
            replace = replace.replace("\"", "\\\"");
        }
        obj3 = new StringBuilder();
        obj3.append(i2);
        obj3.append(replace);
        obj3.append(i2);
        return obj3.toString();
    }

    public static Integer tryParseInt(String string) {
        int length;
        int i;
        int i4;
        int i5;
        long l;
        int i3;
        int i2;
        final int i6 = 0;
        if (string.length() <= 11) {
            if (string.length() == 0) {
            } else {
                i = 0;
                i5 = 1;
                if (string.charAt(i) == 45) {
                    if (string.length() == i5) {
                        return i6;
                    }
                    i = i5;
                } else {
                    i5 = i;
                }
                i4 = 0;
                while (i < string.length()) {
                    char charAt2 = string.charAt(i);
                    i9 += l;
                    i++;
                }
                int i8 = -i4;
                if (i5 != 0 && Long.compare(i8, i11) < 0) {
                    i8 = -i4;
                    if (Long.compare(i8, i11) < 0) {
                        return i6;
                    }
                    return Integer.valueOf((int)i8);
                }
                if (Long.compare(i4, i12) > 0) {
                    return i6;
                }
            }
            return Integer.valueOf((int)i4);
        }
        return i6;
    }

    public static com.google.firebase.database.core.utilities.Pair<j<Void>, DatabaseReference.CompletionListener> wrapOnComplete(DatabaseReference.CompletionListener databaseReference$CompletionListener) {
        if (completionListener == null) {
            k obj2 = new k();
            Utilities.1 anon = new Utilities.1(obj2);
            Pair pair2 = new Pair(obj2.a(), anon);
            return pair2;
        }
        Pair pair = new Pair(0, completionListener);
        return pair;
    }
}
