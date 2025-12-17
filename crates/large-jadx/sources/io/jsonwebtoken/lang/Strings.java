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

/* loaded from: classes3.dex */
public final class Strings {

    private static final String CURRENT_PATH = ".";
    private static final char EXTENSION_SEPARATOR = '.';
    private static final String FOLDER_SEPARATOR = "/";
    private static final String TOP_PATH = "..";
    public static final Charset UTF_8 = null;
    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";
    static {
        Strings.UTF_8 = Charset.forName("UTF-8");
    }

    public static String[] addStringToArray(String[] stringArr, String string2) {
        int i2 = 1;
        final int i3 = 0;
        if (Objects.isEmpty(stringArr)) {
            String[] obj3 = new String[i2];
            obj3[i3] = string2;
            return obj3;
        }
        String[] strArr = new String[length += i2];
        System.arraycopy(stringArr, i3, strArr, i3, stringArr.length);
        strArr[stringArr.length] = string2;
        return strArr;
    }

    public static String applyRelativePath(String string, String string2) {
        boolean stringBuilder;
        String obj3;
        String str = "/";
        int lastIndexOf = string.lastIndexOf(str);
        if (lastIndexOf != -1 && !string2.startsWith(str)) {
            if (!string2.startsWith(str)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string.substring(0, lastIndexOf));
                stringBuilder.append(str);
                obj3 = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(obj3);
            stringBuilder2.append(string2);
            return stringBuilder2.toString();
        }
        return string2;
    }

    public static String arrayToCommaDelimitedString(Object[] objectArr) {
        return Strings.arrayToDelimitedString(objectArr, ",");
    }

    public static String arrayToDelimitedString(Object[] objectArr, String string2) {
        int i;
        int i2;
        if (Objects.isEmpty(objectArr)) {
            return "";
        }
        if (objectArr.length == 1) {
            return Objects.nullSafeToString(objectArr[0]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Object i2 : objectArr) {
            if (i > 0) {
            }
            stringBuilder.append(i2);
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static String capitalize(String string) {
        return Strings.changeFirstCharacterCase(string, true);
    }

    private static String changeFirstCharacterCase(String string, boolean z2) {
        StringBuilder stringBuilder;
        int i;
        String obj2;
        int obj3;
        if (string != null) {
            if (string.length() == 0) {
            } else {
                stringBuilder = new StringBuilder(string.length());
                i = 0;
                if (z2 != 0) {
                    stringBuilder.append(Character.toUpperCase(string.charAt(i)));
                } else {
                    stringBuilder.append(Character.toLowerCase(string.charAt(i)));
                }
                stringBuilder.append(string.substring(1));
                obj2 = stringBuilder.toString();
            }
        }
        return obj2;
    }

    public static java.lang.CharSequence clean(java.lang.CharSequence charSequence) {
        java.lang.CharSequence obj1;
        if (!Strings.hasLength(Strings.trimWhitespace(charSequence))) {
            obj1 = 0;
        }
        return obj1;
    }

    public static String clean(String string) {
        String obj0;
        obj0 = Strings.clean(string);
        if (obj0 != null) {
            obj0 = obj0.toString();
        } else {
            obj0 = 0;
        }
        return obj0;
    }

    public static String cleanPath(String string) {
        int indexOf;
        boolean stringBuilder;
        String substring;
        int i;
        int i2;
        boolean equals2;
        String str;
        boolean equals;
        String obj9;
        if (string == null) {
            return null;
        }
        final String str4 = "/";
        obj9 = Strings.replace(string, "\\", str4);
        indexOf = obj9.indexOf(":");
        int i4 = 1;
        final int i5 = 0;
        if (indexOf != -1) {
            indexOf += i4;
            substring = obj9.substring(i5, indexOf);
            obj9 = obj9.substring(indexOf);
        } else {
            substring = "";
        }
        if (obj9.startsWith(str4)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(substring);
            stringBuilder.append(str4);
            substring = stringBuilder.toString();
            obj9 = obj9.substring(i4);
        }
        obj9 = Strings.delimitedListToStringArray(obj9, str4);
        LinkedList linkedList = new LinkedList();
        length -= i4;
        i = i5;
        equals2 = "..";
        while (i2 >= 0) {
            str = obj9[i2];
            if (".".equals(str)) {
            } else {
            }
            if (equals2.equals(str)) {
            } else {
            }
            if (i > 0) {
            } else {
            }
            linkedList.add(i5, str);
            i2--;
            equals2 = "..";
            i--;
            i++;
        }
        obj9 = i5;
        while (obj9 < i) {
            linkedList.add(i5, equals2);
            obj9++;
        }
        obj9 = new StringBuilder();
        obj9.append(substring);
        obj9.append(Strings.collectionToDelimitedString(linkedList, str4));
        return obj9.toString();
    }

    public static String collectionToCommaDelimitedString(Collection<?> collection) {
        return Strings.collectionToDelimitedString(collection, ",");
    }

    public static String collectionToDelimitedString(Collection<?> collection, String string2) {
        final String str = "";
        return Strings.collectionToDelimitedString(collection, string2, str, str);
    }

    public static String collectionToDelimitedString(Collection<?> collection, String string2, String string3, String string4) {
        boolean next;
        if (Collections.isEmpty(collection)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator obj2 = collection.iterator();
        while (obj2.hasNext()) {
            stringBuilder.append(string3);
            stringBuilder.append(obj2.next());
            stringBuilder.append(string4);
            if (obj2.hasNext()) {
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static Set<String> commaDelimitedListToSet(String string) {
        int i;
        String str;
        TreeSet treeSet = new TreeSet();
        final String[] obj4 = Strings.commaDelimitedListToStringArray(string);
        i = 0;
        while (i < obj4.length) {
            treeSet.add(obj4[i]);
            i++;
        }
        return treeSet;
    }

    public static String[] commaDelimitedListToStringArray(String string) {
        return Strings.delimitedListToStringArray(string, ",");
    }

    public static String[] concatenateStringArrays(String[] stringArr, String[] string2Arr2) {
        if (Objects.isEmpty(stringArr)) {
            return string2Arr2;
        }
        if (Objects.isEmpty(string2Arr2)) {
            return stringArr;
        }
        String[] strArr = new String[length += length2];
        final int i2 = 0;
        System.arraycopy(stringArr, i2, strArr, i2, stringArr.length);
        System.arraycopy(string2Arr2, i2, strArr, stringArr.length, string2Arr2.length);
        return strArr;
    }

    public static boolean containsWhitespace(java.lang.CharSequence charSequence) {
        int i;
        boolean whitespace;
        final int i2 = 0;
        if (!Strings.hasLength(charSequence)) {
            return i2;
        }
        i = i2;
        while (i < charSequence.length()) {
            i++;
        }
        return i2;
    }

    public static boolean containsWhitespace(String string) {
        return Strings.containsWhitespace(string);
    }

    public static int countOccurrencesOf(String string, String string2) {
        int i2;
        int length;
        int i;
        int length2;
        i2 = 0;
        if (string != null && string2 != null && string.length() != 0) {
            if (string2 != null) {
                if (string.length() != 0) {
                    if (string2.length() == 0) {
                    } else {
                        i = i2;
                        int indexOf = string.indexOf(string2, i2);
                        while (indexOf != -1) {
                            i++;
                            indexOf += length2;
                            indexOf = string.indexOf(string2, i2);
                        }
                    }
                    return i;
                }
            }
        }
        return i2;
    }

    public static String delete(String string, String string2) {
        return Strings.replace(string, string2, "");
    }

    public static String deleteAny(String string, String string2) {
        boolean stringBuilder;
        int i;
        int charAt;
        int indexOf;
        int i2;
        String obj5;
        if (Strings.hasLength(string)) {
            if (!Strings.hasLength(string2)) {
            } else {
                stringBuilder = new StringBuilder();
                i = 0;
                while (i < string.length()) {
                    charAt = string.charAt(i);
                    if (string2.indexOf(charAt) == -1) {
                    }
                    i++;
                    stringBuilder.append(charAt);
                }
                obj5 = stringBuilder.toString();
            }
        }
        return obj5;
    }

    public static String[] delimitedListToStringArray(String string, String string2) {
        return Strings.delimitedListToStringArray(string, string2, 0);
    }

    public static String[] delimitedListToStringArray(String string, String string2, String string3) {
        int i;
        boolean indexOf;
        int i2;
        String obj4;
        Object obj5;
        i = 0;
        if (string == null) {
            return new String[i];
        }
        if (string2 == null) {
            obj5 = new String[1];
            obj5[i] = string;
            return obj5;
        }
        ArrayList arrayList = new ArrayList();
        if ("".equals(string2)) {
        }
        return Strings.toStringArray(arrayList);
    }

    public static boolean endsWithIgnoreCase(String string, String string2) {
        int i = 0;
        if (string != null) {
            if (string2 == null) {
            } else {
                if (string.endsWith(string2)) {
                    return 1;
                }
                if (string.length() < string2.length()) {
                    return i;
                }
            }
            return string.substring(length -= length3).toLowerCase().equals(string2.toLowerCase());
        }
        return i;
    }

    public static String getFilename(String string) {
        int lastIndexOf;
        String obj2;
        if (string == null) {
            return null;
        }
        lastIndexOf = string.lastIndexOf("/");
        if (lastIndexOf != -1) {
            obj2 = string.substring(lastIndexOf++);
        }
        return obj2;
    }

    public static String getFilenameExtension(String string) {
        final int i = 0;
        if (string == null) {
            return i;
        }
        int lastIndexOf = string.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return i;
        }
        if (string.lastIndexOf("/") > lastIndexOf) {
            return i;
        }
        return string.substring(lastIndexOf++);
    }

    public static boolean hasLength(java.lang.CharSequence charSequence) {
        int obj0;
        if (charSequence != null && charSequence.length() > 0) {
            obj0 = charSequence.length() > 0 ? 1 : 0;
        } else {
        }
        return obj0;
    }

    public static boolean hasLength(String string) {
        return Strings.hasLength(string);
    }

    public static boolean hasText(java.lang.CharSequence charSequence) {
        int i;
        boolean whitespace;
        final int i2 = 0;
        if (!Strings.hasLength(charSequence)) {
            return i2;
        }
        i = i2;
        while (i < charSequence.length()) {
            i++;
        }
        return i2;
    }

    public static boolean hasText(String string) {
        return Strings.hasText(string);
    }

    public static String[] mergeStringArrays(String[] stringArr, String[] string2Arr2) {
        int i;
        Object obj;
        boolean contains;
        if (Objects.isEmpty(stringArr)) {
            return string2Arr2;
        }
        if (Objects.isEmpty(string2Arr2)) {
            return stringArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(stringArr));
        i = 0;
        while (i < string2Arr2.length) {
            obj = string2Arr2[i];
            if (!arrayList.contains(obj)) {
            }
            i++;
            arrayList.add(obj);
        }
        return Strings.toStringArray(arrayList);
    }

    public static Locale parseLocaleString(String string) {
        int length;
        String str;
        String str2;
        String trimLeadingWhitespace;
        String obj5;
        int i = 0;
        String[] tokenizeToStringArray = Strings.tokenizeToStringArray(string, "_ ", i, i);
        trimLeadingWhitespace = "";
        str = tokenizeToStringArray.length > 0 ? tokenizeToStringArray[i] : trimLeadingWhitespace;
        int i2 = 1;
        str2 = tokenizeToStringArray.length > i2 ? tokenizeToStringArray[i2] : trimLeadingWhitespace;
        Strings.validateLocalePart(str);
        Strings.validateLocalePart(str2);
        trimLeadingWhitespace = Strings.trimLeadingWhitespace(string.substring(indexOf += length4));
        if (tokenizeToStringArray.length >= 2 && trimLeadingWhitespace.startsWith("_")) {
            trimLeadingWhitespace = Strings.trimLeadingWhitespace(string.substring(indexOf += length4));
            if (trimLeadingWhitespace.startsWith("_")) {
                trimLeadingWhitespace = Strings.trimLeadingCharacter(trimLeadingWhitespace, '_');
            }
        }
        if (str.length() > 0) {
            obj5 = new Locale(str, str2, trimLeadingWhitespace);
        } else {
            obj5 = 0;
        }
        return obj5;
    }

    public static boolean pathEquals(String string, String string2) {
        return Strings.cleanPath(string).equals(Strings.cleanPath(string2));
    }

    public static String quote(String string) {
        StringBuilder stringBuilder;
        String str;
        String obj2;
        if (string != null) {
            stringBuilder = new StringBuilder();
            str = "'";
            stringBuilder.append(str);
            stringBuilder.append(string);
            stringBuilder.append(str);
            obj2 = stringBuilder.toString();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public static Object quoteIfString(Object object) {
        Object obj1;
        if (object instanceof String != null) {
            obj1 = Strings.quote((String)object);
        }
        return obj1;
    }

    public static String[] removeDuplicateStrings(String[] stringArr) {
        int i;
        Object obj;
        if (Objects.isEmpty(stringArr)) {
            return stringArr;
        }
        TreeSet treeSet = new TreeSet();
        i = 0;
        while (i < stringArr.length) {
            treeSet.add(stringArr[i]);
            i++;
        }
        return Strings.toStringArray(treeSet);
    }

    public static String replace(String string, String string2, String string3) {
        boolean stringBuilder;
        int i;
        int indexOf;
        int length;
        String obj4;
        if (Strings.hasLength(string) && Strings.hasLength(string2)) {
            if (Strings.hasLength(string2)) {
                if (string3 == null) {
                } else {
                    stringBuilder = new StringBuilder();
                    i = 0;
                    indexOf = string.indexOf(string2);
                    while (indexOf >= 0) {
                        stringBuilder.append(string.substring(i, indexOf));
                        stringBuilder.append(string3);
                        indexOf = string.indexOf(string2, indexOf + length);
                    }
                    stringBuilder.append(string.substring(i));
                    obj4 = stringBuilder.toString();
                }
            }
        }
        return obj4;
    }

    public static String[] sortStringArray(String[] stringArr) {
        if (Objects.isEmpty(stringArr)) {
            return new String[0];
        }
        Arrays.sort(stringArr);
        return stringArr;
    }

    public static String[] split(String string, String string2) {
        boolean length;
        int i3 = 0;
        if (Strings.hasLength(string)) {
            if (!Strings.hasLength(string2)) {
            } else {
                int indexOf = string.indexOf(string2);
                if (indexOf < 0) {
                    return i3;
                }
            }
            int i4 = 0;
            String[] obj4 = new String[2];
            obj4[i4] = string.substring(i4, indexOf);
            obj4[1] = string.substring(indexOf += obj4);
            return obj4;
        }
        return i3;
    }

    public static Properties splitArrayElementsIntoProperties(String[] stringArr, String string2) {
        return Strings.splitArrayElementsIntoProperties(stringArr, string2, 0);
    }

    public static Properties splitArrayElementsIntoProperties(String[] stringArr, String string2, String string3) {
        int i2;
        String[] split;
        Object any;
        String trim;
        int i;
        if (Objects.isEmpty(stringArr)) {
            return null;
        }
        Properties properties = new Properties();
        final int i3 = 0;
        i2 = i3;
        while (i2 < stringArr.length) {
            if (string3 != null) {
            }
            split = Strings.split(any, string2);
            if (split == null) {
            } else {
            }
            properties.setProperty(split[i3].trim(), split[1].trim());
            i2++;
            any = Strings.deleteAny(stringArr[i2], string3);
        }
        return properties;
    }

    public static boolean startsWithIgnoreCase(String string, String string2) {
        final int i = 0;
        if (string != null) {
            if (string2 == null) {
            } else {
                if (string.startsWith(string2)) {
                    return 1;
                }
                if (string.length() < string2.length()) {
                    return i;
                }
            }
            return string.substring(i, string2.length()).toLowerCase().equals(string2.toLowerCase());
        }
        return i;
    }

    public static String stripFilenameExtension(String string) {
        if (string == null) {
            return null;
        }
        int lastIndexOf = string.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return string;
        }
        if (string.lastIndexOf("/") > lastIndexOf) {
            return string;
        }
        return string.substring(0, lastIndexOf);
    }

    public static boolean substringMatch(java.lang.CharSequence charSequence, int i2, java.lang.CharSequence charSequence3) {
        int i;
        char charAt2;
        char charAt;
        final int i3 = 0;
        i = i3;
        while (i < charSequence3.length()) {
            charAt2 = i2 + i;
            i++;
        }
        return 1;
    }

    public static String toLanguageTag(Locale locale) {
        StringBuilder stringBuilder;
        String str;
        String obj3;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(locale.getLanguage());
        if (Strings.hasText(locale.getCountry())) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("-");
            stringBuilder.append(locale.getCountry());
            obj3 = stringBuilder.toString();
        } else {
            obj3 = "";
        }
        stringBuilder2.append(obj3);
        return stringBuilder2.toString();
    }

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return (String[])collection.toArray(new String[collection.size()]);
    }

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        ArrayList obj1 = Collections.list(enumeration);
        return (String[])obj1.toArray(new String[obj1.size()]);
    }

    public static String[] tokenizeToStringArray(String string, String string2) {
        final int i = 1;
        return Strings.tokenizeToStringArray(string, string2, i, i);
    }

    public static String[] tokenizeToStringArray(String string, String string2, boolean z3, boolean z4) {
        int length;
        String obj3;
        if (string == null) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, string2);
        ArrayList obj2 = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            if (z3) {
            }
            if (z4) {
            } else {
            }
            obj2.add(obj3);
            if (obj3.length() > 0) {
            }
            obj3 = stringTokenizer.nextToken().trim();
        }
        return Strings.toStringArray(obj2);
    }

    public static String trimAllWhitespace(String string) {
        boolean whitespace;
        int obj2;
        if (!Strings.hasLength(string)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        obj2 = 0;
        while (stringBuilder.length() > obj2) {
            if (Character.isWhitespace(stringBuilder.charAt(obj2))) {
            } else {
            }
            obj2++;
            stringBuilder.deleteCharAt(obj2);
        }
        return stringBuilder.toString();
    }

    public static String[] trimArrayElements(String[] stringArr) {
        int i;
        int trim;
        if (Objects.isEmpty(stringArr)) {
            return new String[0];
        }
        String[] strArr = new String[stringArr.length];
        while (i < stringArr.length) {
            Object obj = stringArr[i];
            if (obj != null) {
            } else {
            }
            trim = 0;
            strArr[i] = trim;
            i++;
            trim = obj.trim();
        }
        return strArr;
    }

    public static String trimLeadingCharacter(String string, char c2) {
        char charAt;
        String obj2;
        if (!Strings.hasLength(string)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.length() > 0) {
            obj2 = null;
            if (stringBuilder.charAt(obj2) == c2) {
            }
            stringBuilder.deleteCharAt(obj2);
        }
        return stringBuilder.toString();
    }

    public static String trimLeadingWhitespace(String string) {
        boolean whitespace;
        String obj2;
        if (!Strings.hasLength(string)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.length() > 0) {
            obj2 = null;
            if (Character.isWhitespace(stringBuilder.charAt(obj2))) {
            }
            stringBuilder.deleteCharAt(obj2);
        }
        return stringBuilder.toString();
    }

    public static String trimTrailingCharacter(String string, char c2) {
        String obj1;
        if (!Strings.hasLength(string)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.length() > 0) {
            if (stringBuilder.charAt(obj1--) == c2) {
            }
            stringBuilder.deleteCharAt(obj1--);
        }
        return stringBuilder.toString();
    }

    public static String trimTrailingWhitespace(String string) {
        String obj1;
        if (!Strings.hasLength(string)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.length() > 0) {
            if (Character.isWhitespace(stringBuilder.charAt(obj1--))) {
            }
            stringBuilder.deleteCharAt(obj1--);
        }
        return stringBuilder.toString();
    }

    private static java.lang.CharSequence trimWhitespace(java.lang.CharSequence charSequence) {
        int i;
        boolean whitespace;
        int i2;
        boolean whitespace2;
        java.lang.CharSequence obj4;
        if (!Strings.hasLength(charSequence)) {
            return charSequence;
        }
        int length2 = charSequence.length();
        i = 0;
        while (i < length2) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
            }
            i++;
        }
        i2 = length2;
        while (i < length2) {
            if (Character.isWhitespace(charSequence.charAt(i2 + -1))) {
            }
            i2--;
        }
        if (i <= 0) {
            if (i2 < length2) {
                obj4 = charSequence.subSequence(i, i2);
            }
        } else {
        }
        return obj4;
    }

    public static String trimWhitespace(String string) {
        return (String)Strings.trimWhitespace(string);
    }

    public static String uncapitalize(String string) {
        return Strings.changeFirstCharacterCase(string, false);
    }

    public static String unqualify(String string) {
        return Strings.unqualify(string, '.');
    }

    public static String unqualify(String string, char c2) {
        return string.substring(obj1++);
    }

    private static void validateLocalePart(String string) {
        int i;
        char letterOrDigit;
        int i2;
        i = 0;
        while (i < string.length()) {
            letterOrDigit = string.charAt(i);
            i++;
        }
    }
}
