package io.jsonwebtoken.lang;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/* compiled from: Strings.java */
/* loaded from: classes3.dex */
public final class Strings {

    private static final String CURRENT_PATH = ".";
    private static final char EXTENSION_SEPARATOR = '.';
    private static final String FOLDER_SEPARATOR = "/";
    private static final String TOP_PATH = "..";
    public static final Charset UTF_8;
    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
    static {
        Strings.UTF_8 = Charset.forName("UTF-8");
    }

    private Strings() {
        super();
    }

    public static String[] addStringToArray(String[] strArr, String str) {
        int i2 = 1;
        final int i3 = 0;
        if (Objects.isEmpty(strArr)) {
            String[] strArr3 = new String[i2];
            return new String[] { str };
        }
        String[] strArr2 = new String[strArr.length + i2];
        System.arraycopy(strArr, i3, strArr2, i3, strArr.length);
        strArr2[strArr.length] = str;
        return strArr2;
    }

    public static String applyRelativePath(String str, String str2) {
        String substring;
        String str3 = "/";
        int lastIndexOf = str.lastIndexOf(str3);
        if (lastIndexOf != -1) {
            substring = str.substring(0, lastIndexOf);
            if (!str2.startsWith(str3)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                substring = substring + str3;
            }
            StringBuilder stringBuilder = new StringBuilder();
            str4 = substring + str2;
            return str4;
        }
        return str2;
    }

    public static String arrayToCommaDelimitedString(Object[] objectArr) {
        return Strings.arrayToDelimitedString(objectArr, ",");
    }

    public static String arrayToDelimitedString(Object[] objectArr, String str) {
        int i = 0;
        if (Objects.isEmpty(objectArr)) {
            return "";
        }
        i = 0;
        int i2 = 1;
        if (objectArr.length == 1) {
            return Objects.nullSafeToString(objectArr[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < objectArr.length) {
            stringBuilder.append(objectArr[i]);
            i = i + 1;
        }
        return stringBuilder.toString();
    }

    public static String capitalize(String str) {
        return Strings.changeFirstCharacterCase(str, true);
    }

    private static String changeFirstCharacterCase(String str, boolean z) {
        String str2;
        return str2;
    }

    public static String clean(String str) {
        String charSequence = null;
        java.lang.CharSequence clean = Strings.clean(str);
        if (clean != null) {
            charSequence = clean.toString();
        } else {
            int i = 0;
        }
        return charSequence;
    }

    public static String cleanPath(String str) {
        String substring;
        int i;
        int i2;
        boolean equals;
        String substring2;
        if (str == null) {
            return null;
        }
        final String str4 = "/";
        substring2 = Strings.replace(str, "\\", str4);
        int indexOf = substring2.indexOf(":");
        int i4 = 1;
        i = 0;
        if (indexOf != -1) {
            indexOf = indexOf + i4;
            substring = substring2.substring(i, indexOf);
            substring2 = substring2.substring(indexOf);
        } else {
            substring = "";
        }
        if (substring2.startsWith(str4)) {
            StringBuilder stringBuilder = new StringBuilder();
            substring = substring + str4;
            substring2 = substring2.substring(i4);
        }
        String[] delimitedListToStringArray = Strings.delimitedListToStringArray(substring2, str4);
        LinkedList linkedList = new LinkedList();
        i2 = delimitedListToStringArray.length - i4;
        String str5 = "..";
        while (i2 >= 0) {
            String str6 = delimitedListToStringArray[i2];
            i2 = i2 - 1;
        }
        while (i < i) {
            linkedList.add(i, "..");
            i = i + 1;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        String collectionToDelimitedString = Strings.collectionToDelimitedString(linkedList, str4);
        str8 = substring + collectionToDelimitedString;
        return str8;
    }

    public static String collectionToCommaDelimitedString(Collection<?> collection) {
        return Strings.collectionToDelimitedString(collection, ",");
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str, String str2, String str3) {
        if (Collections.isEmpty(collection)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            stringBuilder.append(str2);
            stringBuilder.append(it.next());
            stringBuilder.append(str3);
        }
        return stringBuilder.toString();
    }

    public static Set<String> commaDelimitedListToSet(String str) {
        int i = 0;
        final TreeSet treeSet = new TreeSet();
        final String[] commaDelimitedListToStringArray = Strings.commaDelimitedListToStringArray(str);
        i = 0;
        for (String str2 : commaDelimitedListToStringArray) {
            treeSet.add(str2);
        }
        return treeSet;
    }

    public static String[] commaDelimitedListToStringArray(String str) {
        return Strings.delimitedListToStringArray(str, ",");
    }

    public static String[] concatenateStringArrays(String[] strArr, String[] strArr2) {
        if (Objects.isEmpty(strArr)) {
            return strArr2;
        }
        if (Objects.isEmpty(strArr2)) {
            return strArr;
        }
        String[] strArr3 = new String[strArr.length + strArr2.length];
        final int i2 = 0;
        System.arraycopy(strArr, i2, strArr3, i2, strArr.length);
        System.arraycopy(strArr2, i2, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static boolean containsWhitespace(java.lang.CharSequence charSequence) {
        int i;
        i = 0;
        if (!Strings.hasLength(charSequence)) {
            return false;
        }
        while (i < charSequence.length()) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static int countOccurrencesOf(String str, String str2) {
        int i = 0;
        i = 0;
        return i;
    }

    public static String delete(String str, String str2) {
        return Strings.replace(str, str2, "");
    }

    public static String deleteAny(String str, String str2) {
        int i = 0;
        int indexOf;
        int i2 = -1;
        String str3;
        return str3;
    }

    public static String[] delimitedListToStringArray(String str, String str2) {
        return Strings.delimitedListToStringArray(str, str2, null);
    }

    public static boolean endsWithIgnoreCase(String str, String str2) {
        boolean z = false;
        return false;
    }

    public static String getFilename(String str) {
        String substring;
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            lastIndexOf = lastIndexOf + 1;
            substring = str.substring(lastIndexOf);
        }
        return substring;
    }

    public static String getFilenameExtension(String str) {
        final int i = 0;
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return i;
        }
        if (str.lastIndexOf("/") > lastIndexOf) {
            return i;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static boolean hasLength(java.lang.CharSequence charSequence) {
        boolean z = false;
        charSequence = charSequence != null && charSequence.length() > 0 ? 1 : 0;
        return (charSequence != null && charSequence.length() > 0 ? 1 : 0);
    }

    public static boolean hasText(java.lang.CharSequence charSequence) {
        int i;
        i = 0;
        if (!Strings.hasLength(charSequence)) {
            return false;
        }
        while (i < charSequence.length()) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static String[] mergeStringArrays(String[] strArr, String[] strArr2) {
        int i = 0;
        if (Objects.isEmpty(strArr)) {
            return strArr2;
        }
        if (Objects.isEmpty(strArr2)) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        i = 0;
        for (Object obj : strArr2) {
        }
        return Strings.toStringArray(arrayList);
    }

    public static Locale parseLocaleString(String str) {
        String trimLeadingWhitespace;
        int i = 0;
        boolean z = false;
        String[] tokenizeToStringArray = Strings.tokenizeToStringArray(str, "_ ", z, z);
        trimLeadingWhitespace = "";
        String r1 = tokenizeToStringArray.length > 0 ? tokenizeToStringArray[z] : trimLeadingWhitespace;
        int i2 = 1;
        String r2 = tokenizeToStringArray.length > i2 ? tokenizeToStringArray[i2] : trimLeadingWhitespace;
        Strings.validateLocalePart(trimLeadingWhitespace);
        Strings.validateLocalePart(r2);
        length = tokenizeToStringArray.length;
        if (tokenizeToStringArray.length >= 2 && trimLeadingWhitespace.startsWith("_")) {
            trimLeadingWhitespace = Strings.trimLeadingCharacter(trimLeadingWhitespace, '_');
        }
        str = trimLeadingWhitespace.length() > 0 ? new ocale(trimLeadingWhitespace, (tokenizeToStringArray.length > i2 ? tokenizeToStringArray[i2] : trimLeadingWhitespace), trimLeadingWhitespace) : 0;
        return (trimLeadingWhitespace.length() > 0 ? new ocale(trimLeadingWhitespace, (tokenizeToStringArray.length > i2 ? tokenizeToStringArray[i2] : trimLeadingWhitespace), trimLeadingWhitespace) : 0);
    }

    public static boolean pathEquals(String str, String str2) {
        return Strings.cleanPath(str).equals(Strings.cleanPath(str2));
    }

    public static String quote(String str) {
        String str3 = null;
        if (str != null) {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = "'";
            str3 = str2 + str + str2;
        } else {
            int i = 0;
        }
        return str3;
    }

    public static Object quoteIfString(Object object) {
        String quote;
        if (object instanceof String) {
            quote = Strings.quote(object);
        }
        return quote;
    }

    public static String[] removeDuplicateStrings(String[] strArr) {
        int i = 0;
        if (Objects.isEmpty(strArr)) {
            return strArr;
        }
        TreeSet treeSet = new TreeSet();
        i = 0;
        for (Object obj : strArr) {
            treeSet.add(obj);
        }
        return Strings.toStringArray(treeSet);
    }

    public static String replace(String str, String str2, String str3) {
        int i = 0;
        int indexOf;
        String str4;
        return str4;
    }

    public static String[] sortStringArray(String[] strArr) {
        if (Objects.isEmpty(strArr)) {
            return new String[0];
        }
        Arrays.sort(strArr);
        return strArr;
    }

    public static String[] split(String str, String str2) {
        int i3 = 0;
        return null;
    }

    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str) {
        return Strings.splitArrayElementsIntoProperties(strArr, str, null);
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        final int i = 0;
        return false;
    }

    public static String stripFilenameExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        if (str.lastIndexOf("/") > lastIndexOf) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public static boolean substringMatch(java.lang.CharSequence charSequence, int i, java.lang.CharSequence charSequence2) {
        i = 0;
        while (i < charSequence2.length()) {
            i3 = i + i;
        }
        return true;
    }

    public static String toLanguageTag(Locale locale) {
        String str2;
        final StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(locale.getLanguage());
        if (Strings.hasText(locale.getCountry())) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "-";
            String country2 = locale.getCountry();
            str2 = str + country2;
        } else {
            str2 = "";
        }
        stringBuilder2.append(str2);
        return stringBuilder2.toString();
    }

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return (String[])collection.toArray(new String[collection.size()]);
    }

    public static String[] tokenizeToStringArray(String str, String str2) {
        final boolean z = true;
        return Strings.tokenizeToStringArray(str, str2, z, z);
    }

    public static String trimAllWhitespace(String str) {
        int i = 0;
        if (!Strings.hasLength(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        i = 0;
        while (stringBuilder.length() > i) {
        }
        return stringBuilder.toString();
    }

    public static String[] trimArrayElements(String[] strArr) {
        int i = 0;
        int i2 = 0;
        i = 0;
        if (Objects.isEmpty(strArr)) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        while (i < strArr.length) {
            Object obj = strArr[i];
            strArr2[i] = i2;
            i = i + 1;
        }
        return strArr2;
    }

    public static String trimLeadingCharacter(String str, char c) {
        char charAt;
        if (!Strings.hasLength(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() > 0) {
            int length = 0;
        }
        return stringBuilder.toString();
    }

    public static String trimLeadingWhitespace(String str) {
        boolean whitespace;
        if (!Strings.hasLength(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() > 0) {
            int length = 0;
        }
        return stringBuilder.toString();
    }

    public static String trimTrailingCharacter(String str, char c) {
        if (!Strings.hasLength(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() > 0) {
        }
        return stringBuilder.toString();
    }

    public static String trimTrailingWhitespace(String str) {
        if (!Strings.hasLength(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() > 0) {
        }
        return stringBuilder.toString();
    }

    public static String trimWhitespace(String str) {
        return (String)Strings.trimWhitespace(str);
    }

    public static String uncapitalize(String str) {
        return Strings.changeFirstCharacterCase(str, false);
    }

    public static String unqualify(String str) {
        return Strings.unqualify(str, '.');
    }

    private static void validateLocalePart(String str) {
        int i = 0;
        char charAt;
        char c = 95;
        i = 0;
        while (i < str.length()) {
            charAt = str.charAt(i);
            c = '_';
            if (charAt == '_' || charAt != ' ' || Character.isLetterOrDigit(charAt)) {
                c = ' ';
            }
        }
    }

    public static String[] delimitedListToStringArray(String str, String str2, String str3) {
        int str22 = 0;
        str22 = 0;
        if (str == null) {
            return new String[str22];
        }
        if (str2 == null) {
            String[] strArr2 = new String[1];
            return new String[] { str };
        }
        final ArrayList arrayList = new ArrayList();
        if ("".equals(str2)) {
            while (str22 < str.length()) {
                str22 = str22 + 1;
                arrayList.add(Strings.deleteAny(str.substring(str22, str22), str3));
            }
        } else {
            int indexOf = str.indexOf(str2, str22);
            int i = -1;
            while (indexOf != -1) {
                arrayList.add(Strings.deleteAny(str.substring(str22, indexOf), str3));
                str22 = str2.length() + indexOf;
                indexOf = str.indexOf(str2, str22);
                i = -1;
            }
            if (str.length() > 0 && str22 <= str.length()) {
                arrayList.add(Strings.deleteAny(str.substring(str22), str3));
            }
        }
        return Strings.toStringArray(arrayList);
    }

    public static boolean hasLength(String str) {
        return Strings.hasLength(str);
    }

    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str, String str2) {
        int i;
        String any;
        String[] split;
        String trimmed;
        int i2;
        if (Objects.isEmpty(strArr)) {
            return null;
        }
        Properties properties = new Properties();
        i = 0;
        for (Object obj : strArr) {
            split = Strings.split(any, str);
        }
        return properties;
    }

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        ArrayList list = Collections.list(enumeration);
        return (String[])list.toArray(new String[list.size()]);
    }

    public static String[] tokenizeToStringArray(String str, String str2, boolean z, boolean z2) {
        int length;
        Object obj;
        if (str == null) {
            return null;
        }
        final StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
        }
        return Strings.toStringArray(arrayList);
    }

    private static java.lang.CharSequence trimWhitespace(java.lang.CharSequence charSequence) {
        int i = 0;
        boolean whitespace;
        int length;
        boolean whitespace2;
        java.lang.CharSequence subSequence;
        if (!Strings.hasLength(charSequence)) {
            return charSequence;
        }
        length = charSequence.length();
        i = 0;
        while (i < length) {
        }
        while (i < length) {
        }
        if (i > 0 || length < length) {
            subSequence = charSequence.subSequence(i, length);
        }
        return subSequence;
    }

    public static String unqualify(String str, char c) {
        return str.substring(str.lastIndexOf(c) + 1);
    }

    public static java.lang.CharSequence clean(java.lang.CharSequence charSequence) {
        java.lang.CharSequence trimWhitespace = null;
        if (!Strings.hasLength(Strings.trimWhitespace(charSequence))) {
            int i = 0;
        }
        return trimWhitespace;
    }

    public static boolean containsWhitespace(String str) {
        return Strings.containsWhitespace(str);
    }

    public static boolean hasText(String str) {
        return Strings.hasText(str);
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str) {
        str = "";
        return Strings.collectionToDelimitedString(collection, str, str, str);
    }
}
