package androidx.core.net;

import android.net.Uri;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes5.dex */
public final class MailTo {

    private static final String BCC = "bcc";
    private static final String BODY = "body";
    private static final String CC = "cc";
    private static final String MAILTO = "mailto";
    public static final String MAILTO_SCHEME = "mailto:";
    private static final String SUBJECT = "subject";
    private static final String TO = "to";
    private HashMap<String, String> mHeaders;
    private MailTo() {
        super();
        HashMap hashMap = new HashMap();
        this.mHeaders = hashMap;
    }

    public static boolean isMailTo(Uri uri) {
        boolean equals;
        int i;
        String scheme;
        if (uri != null && "mailto".equals(uri.getScheme())) {
            i = "mailto".equals(uri.getScheme()) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static boolean isMailTo(String uri) {
        boolean startsWith;
        int i;
        if (uri != null && uri.startsWith("mailto:")) {
            i = uri.startsWith("mailto:") ? 1 : 0;
        } else {
        }
        return i;
    }

    public static androidx.core.net.MailTo parse(Uri uri) throws androidx.core.net.ParseException {
        return MailTo.parse(uri.toString());
    }

    public static androidx.core.net.MailTo parse(String uri) throws androidx.core.net.ParseException {
        String address;
        int substring;
        String[] append;
        int length;
        int i;
        String str;
        String[] split;
        String lowerCase;
        String decode;
        HashMap mHeaders;
        Object obj14;
        Preconditions.checkNotNull(uri);
        if (!MailTo.isMailTo(uri)) {
        } else {
            int indexOf = uri.indexOf(35);
            int i3 = -1;
            int i4 = 0;
            if (indexOf != i3) {
                obj14 = uri.substring(i4, indexOf);
            }
            int indexOf2 = obj14.indexOf(63);
            String str3 = "mailto:";
            if (indexOf2 == i3) {
                address = Uri.decode(obj14.substring(str3.length()));
                substring = 0;
            } else {
                address = Uri.decode(obj14.substring(str3.length(), indexOf2));
                substring = obj14.substring(indexOf2 + 1);
            }
            MailTo mailTo2 = new MailTo();
            if (substring != null) {
                append = substring.split("&");
                i = i4;
                while (i < append.length) {
                    split = append[i].split("=", 2);
                    if (split.length == 0) {
                    } else {
                    }
                    int i8 = 1;
                    if (split.length > i8) {
                    } else {
                    }
                    decode = 0;
                    mailTo2.mHeaders.put(Uri.decode(split[i4]).toLowerCase(Locale.ROOT), decode);
                    i++;
                    decode = Uri.decode(split[i8]);
                }
            }
            String to = mailTo2.getTo();
            if (to != null) {
                StringBuilder stringBuilder = new StringBuilder();
                address = stringBuilder.append(address).append(", ").append(to).toString();
            }
            mailTo2.mHeaders.put("to", address);
            return mailTo2;
        }
        ParseException fragmentIndex = new ParseException("Not a mailto scheme");
        throw fragmentIndex;
    }

    public String getBcc() {
        return (String)this.mHeaders.get("bcc");
    }

    public String getBody() {
        return (String)this.mHeaders.get("body");
    }

    public String getCc() {
        return (String)this.mHeaders.get("cc");
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getSubject() {
        return (String)this.mHeaders.get("subject");
    }

    public String getTo() {
        return (String)this.mHeaders.get("to");
    }

    public String toString() {
        Object next;
        int i;
        StringBuilder stringBuilder = new StringBuilder("mailto:");
        stringBuilder.append('?');
        Iterator iterator = this.mHeaders.entrySet().iterator();
        for (Map.Entry next : iterator) {
            stringBuilder.append(Uri.encode((String)next.getKey()));
            stringBuilder.append('=');
            stringBuilder.append(Uri.encode((String)next.getValue()));
            stringBuilder.append('&');
        }
        return stringBuilder.toString();
    }
}
