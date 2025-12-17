package androidx.core.text.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public final class LinkifyCompat {

    private static final Comparator<androidx.core.text.util.LinkifyCompat.LinkSpec> COMPARATOR;
    private static final String[] EMPTY_STRING;

    static class Api24Impl {
        static void addLinks(TextView text, Pattern pattern, String defaultScheme, String[] schemes, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            Linkify.addLinks(text, pattern, defaultScheme, schemes, matchFilter, transformFilter);
        }

        static boolean addLinks(Spannable spannable, Pattern pattern, String defaultScheme, String[] schemes, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
            return Linkify.addLinks(spannable, pattern, defaultScheme, schemes, matchFilter, transformFilter);
        }
    }

    private static class LinkSpec {

        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkifyMask {
    }
    static {
        LinkifyCompat.EMPTY_STRING = new String[0];
        LinkifyCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new LinkifyCompat$$ExternalSyntheticLambda0();
        LinkifyCompat.COMPARATOR = externalSyntheticLambda0;
    }

    private static void addLinkMovementMethod(TextView t) {
        boolean linksClickable;
        if (!movementMethod instanceof LinkMovementMethod && t.getLinksClickable()) {
            if (t.getLinksClickable()) {
                t.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    public static void addLinks(TextView text, Pattern pattern, String scheme) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(text, pattern, scheme);
        }
        LinkifyCompat.addLinks(text, pattern, scheme, 0, 0, 0);
    }

    public static void addLinks(TextView text, Pattern pattern, String scheme, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            Linkify.addLinks(text, pattern, scheme, matchFilter, transformFilter);
        }
        LinkifyCompat.addLinks(text, pattern, scheme, 0, matchFilter, transformFilter);
    }

    public static void addLinks(TextView text, Pattern pattern, String defaultScheme, String[] schemes, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            LinkifyCompat.Api24Impl.addLinks(text, pattern, defaultScheme, schemes, matchFilter, transformFilter);
        }
        SpannableString valueOf = SpannableString.valueOf(text.getText());
        if (LinkifyCompat.addLinks(valueOf, pattern, defaultScheme, schemes, matchFilter, transformFilter)) {
            text.setText(valueOf);
            LinkifyCompat.addLinkMovementMethod(text);
        }
    }

    public static boolean addLinks(Spannable text, int mask) {
        int next;
        int i;
        int i3;
        int frameworkAddedSpan;
        Object obj;
        Spannable text2;
        Pattern aUTOLINK_EMAIL_ADDRESS;
        String[] strArr;
        Linkify.MatchFilter sUrlMatchFilter;
        int i2;
        int obj10;
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(text, mask);
        }
        next = 0;
        if (mask == 0) {
            return next;
        }
        Object[] spans = text.getSpans(next, text.length(), URLSpan.class);
        final int i5 = 1;
        length2 -= i5;
        while (i >= 0) {
            text.removeSpan((URLSpan[])spans[i]);
            i--;
        }
        if (mask & 4 != 0) {
            Linkify.addLinks(text, 4);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList list = arrayList;
        if (mask & 1 != 0) {
            strArr = new String[3];
            strArr[next] = "http://";
            strArr[i5] = "https://";
            strArr[2] = "rtsp://";
            LinkifyCompat.gatherLinks(list, text, PatternsCompat.AUTOLINK_WEB_URL, strArr, Linkify.sUrlMatchFilter, 0);
        } else {
            text2 = text;
        }
        if (mask & 2 != 0) {
            strArr = new String[i5];
            strArr[next] = "mailto:";
            LinkifyCompat.gatherLinks(list, text2, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, strArr, 0, 0);
        }
        if (mask & 8 != 0) {
            LinkifyCompat.gatherMapLinks(list, text2);
        }
        LinkifyCompat.pruneOverlaps(list, text2);
        if (list.size() == 0) {
            return next;
        }
        obj10 = list.iterator();
        while (obj10.hasNext()) {
            next = obj10.next();
            if (next.frameworkAddedSpan == null) {
            }
            LinkifyCompat.applyLink(next.url, next.start, next.end, text2);
        }
        return i5;
    }

    public static boolean addLinks(Spannable text, Pattern pattern, String scheme) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(text, pattern, scheme);
        }
        return LinkifyCompat.addLinks(text, pattern, scheme, 0, 0, 0);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String scheme, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(spannable, pattern, scheme, matchFilter, transformFilter);
        }
        return LinkifyCompat.addLinks(spannable, pattern, scheme, 0, matchFilter, transformFilter);
    }

    public static boolean addLinks(Spannable spannable, Pattern pattern, String defaultScheme, String[] schemes, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        int length;
        int index2;
        int index;
        String str;
        int start;
        String lowerCase;
        String group;
        int allowed;
        String url;
        String obj11;
        String[] obj12;
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return LinkifyCompat.Api24Impl.addLinks(spannable, pattern, defaultScheme, schemes, matchFilter, transformFilter);
        }
        if (defaultScheme == null) {
            obj11 = "";
        }
        int i = 1;
        if (schemes != null) {
            if (schemes.length < i) {
                obj12 = LinkifyCompat.EMPTY_STRING;
            }
        } else {
        }
        String[] strArr = new String[length2 += i];
        final int i3 = 0;
        strArr[i3] = obj11.toLowerCase(Locale.ROOT);
        index2 = 0;
        while (index2 < obj12.length) {
            str = obj12[index2];
            if (str == null) {
            } else {
            }
            lowerCase = str.toLowerCase(Locale.ROOT);
            strArr[index2 + 1] = lowerCase;
            index2++;
            lowerCase = "";
        }
        index = 0;
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            start = matcher.start();
            lowerCase = matcher.end();
            group = matcher.group(i3);
            allowed = 1;
            if (matchFilter != null) {
            }
            if (allowed != 0 && group != null) {
            }
            if (group != null) {
            }
            LinkifyCompat.applyLink(LinkifyCompat.makeUrl(group, strArr, matcher, transformFilter), start, lowerCase, spannable);
            index = 1;
            allowed = matchFilter.acceptMatch(spannable, start, lowerCase);
        }
        return index;
    }

    public static boolean addLinks(TextView text, int mask) {
        SpannableString valueOf;
        boolean links;
        if (LinkifyCompat.shouldAddLinksFallbackToFramework()) {
            return Linkify.addLinks(text, mask);
        }
        int i = 0;
        if (mask == 0) {
            return i;
        }
        final java.lang.CharSequence text2 = text.getText();
        final int i2 = 1;
        if (text2 instanceof Spannable) {
            if (LinkifyCompat.addLinks((Spannable)text2, mask)) {
                LinkifyCompat.addLinkMovementMethod(text);
                return i2;
            }
        } else {
            valueOf = SpannableString.valueOf(text2);
            if (LinkifyCompat.addLinks(valueOf, mask)) {
                LinkifyCompat.addLinkMovementMethod(text);
                text.setText(valueOf);
                return i2;
            }
        }
        return i;
    }

    private static void applyLink(String url, int start, int end, Spannable text) {
        URLSpan uRLSpan = new URLSpan(url);
        text.setSpan(uRLSpan, start, end, 33);
    }

    private static String findAddress(String addr) {
        return WebView.findAddress(addr);
    }

    private static void gatherLinks(ArrayList<androidx.core.text.util.LinkifyCompat.LinkSpec> arrayList, Spannable s, Pattern pattern, String[] schemes, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        int start;
        int i;
        String group;
        boolean acceptMatch;
        String url;
        final Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            start = matcher.start();
            i = matcher.end();
            group = matcher.group(0);
            if (matchFilter != null) {
            } else {
            }
            if (group != null) {
            }
            acceptMatch = new LinkifyCompat.LinkSpec();
            acceptMatch.url = LinkifyCompat.makeUrl(group, schemes, matcher, transformFilter);
            acceptMatch.start = start;
            acceptMatch.end = i;
            arrayList.add(acceptMatch);
            if (matchFilter.acceptMatch(s, start, i) && group != null) {
            }
        }
    }

    private static void gatherMapLinks(ArrayList<androidx.core.text.util.LinkifyCompat.LinkSpec> arrayList, Spannable s) {
        String string2;
        int base;
        Throwable indexOf;
        String str;
        androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec;
        int length;
        int i;
        Object encode;
        String string;
        String str2;
        string2 = s.toString();
        base = 0;
        indexOf = LinkifyCompat.findAddress(string2);
        str = indexOf;
        while (indexOf != null) {
            indexOf = string2.indexOf(str);
            if (indexOf < 0) {
                break;
            } else {
            }
            linkSpec = new LinkifyCompat.LinkSpec();
            i = indexOf + length;
            linkSpec.start = base + indexOf;
            linkSpec.end = base + i;
            string2 = substring;
            base += i;
            StringBuilder stringBuilder = new StringBuilder();
            linkSpec.url = stringBuilder.append("geo:0,0?q=").append(URLEncoder.encode(str, "UTF-8")).toString();
            arrayList.add(linkSpec);
            indexOf = LinkifyCompat.findAddress(string2);
            str = indexOf;
        }
    }

    static int lambda$static$0(androidx.core.text.util.LinkifyCompat.LinkSpec a, androidx.core.text.util.LinkifyCompat.LinkSpec b) {
        if (a.start < b.start) {
            return -1;
        }
        if (a.start > b.start) {
            return 1;
        }
        return Integer.compare(b.end, a.end);
    }

    private static String makeUrl(String url, String[] prefixes, Matcher matcher, Linkify.TransformFilter filter) {
        String url2;
        boolean regionMatches;
        int substring;
        Object obj;
        int i2;
        int length;
        int i;
        String obj9;
        if (filter != null) {
            url2 = obj9;
        } else {
            url2 = url;
        }
        obj9 = 0;
        final int i5 = 0;
        i = i5;
        while (i < prefixes.length) {
            obj = prefixes[i];
            if (url2.regionMatches(true, 0, obj, 0, obj.length())) {
                break;
            } else {
            }
            i++;
        }
        if (obj9 == null && prefixes.length > 0) {
            if (prefixes.length > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                url2 = stringBuilder.append(prefixes[i5]).append(url2).toString();
            }
        }
        return url2;
    }

    private static void pruneOverlaps(ArrayList<androidx.core.text.util.LinkifyCompat.LinkSpec> arrayList, Spannable text) {
        int len;
        int i2;
        int i;
        Object obj;
        androidx.core.text.util.LinkifyCompat.LinkSpec linkSpec;
        int remove;
        URLSpan frameworkAddedSpan;
        int end;
        int start;
        int start2;
        Object[] spans = text.getSpans(0, text.length(), URLSpan.class);
        while (i2 < spans.length) {
            obj = (URLSpan[])spans[i2];
            linkSpec = new LinkifyCompat.LinkSpec();
            linkSpec.frameworkAddedSpan = obj;
            linkSpec.start = text.getSpanStart(obj);
            linkSpec.end = text.getSpanEnd(obj);
            arrayList.add(linkSpec);
            i2++;
        }
        Collections.sort(arrayList, LinkifyCompat.COMPARATOR);
        len = arrayList.size();
        i = 0;
        while (i < len + -1) {
            obj = arrayList.get(i);
            linkSpec = arrayList.get(i + 1);
            remove = -1;
            if (obj.start <= linkSpec.start && obj.end > linkSpec.start) {
            } else {
            }
            i++;
            if (obj.end > linkSpec.start) {
            } else {
            }
            if (linkSpec.end <= obj.end) {
            } else {
            }
            if (end2 -= start3 > end4 -= start2) {
            } else {
            }
            if (end3 -= start4 < end5 -= start2) {
            }
            if (remove != -1) {
            } else {
            }
            frameworkAddedSpan = obj3.frameworkAddedSpan;
            if (frameworkAddedSpan != null) {
            }
            arrayList.remove(remove);
            len--;
            text.removeSpan(frameworkAddedSpan);
            remove = i;
            remove = i + 1;
            remove = i + 1;
        }
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return 1;
    }
}
