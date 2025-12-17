package com.google.firebase.database.core.utilities;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Validation {

    private static final Pattern INVALID_KEY_REGEX;
    private static final Pattern INVALID_PATH_REGEX;
    static {
        Validation.INVALID_PATH_REGEX = Pattern.compile("[\\[\\]\\.#$]");
        Validation.INVALID_KEY_REGEX = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");
    }

    private static boolean isValidKey(String string) {
        boolean equals;
        int obj1;
        if (!string.equals(".info") && Validation.INVALID_KEY_REGEX.matcher(string).find() && !string.equals(ChildKey.getMaxName().asString())) {
            if (Validation.INVALID_KEY_REGEX.matcher(string).find()) {
                if (!string.equals(ChildKey.getMaxName().asString())) {
                    if (string.equals(ChildKey.getMinName().asString())) {
                        obj1 = 1;
                    } else {
                        obj1 = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static boolean isValidPathString(String string) {
        return obj1 ^= 1;
    }

    private static boolean isWritableKey(String string) {
        int iNVALID_KEY_REGEX;
        java.lang.CharSequence obj1;
        if (string != null && string.length() > 0) {
            if (string.length() > 0) {
                if (!string.equals(".value") && !string.equals(".priority")) {
                    if (!string.equals(".priority")) {
                        if (!string.startsWith(".") && !Validation.INVALID_KEY_REGEX.matcher(string).find()) {
                            obj1 = !Validation.INVALID_KEY_REGEX.matcher(string).find() ? 1 : 0;
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
        return obj1;
    }

    private static boolean isWritablePath(Path path) {
        String str;
        int obj1;
        obj1 = path.getFront();
        if (obj1 != null) {
            if (!obj1.asString().startsWith(".")) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static Map<Path, Node> parseAndValidateUpdate(Path path, Map<String, Object> map2) {
        Object value;
        boolean next;
        Node priority;
        Path compareTo;
        String string;
        boolean equals;
        int obj6;
        TreeMap treeMap = new TreeMap();
        Iterator obj7 = map2.entrySet().iterator();
        String str2 = "Path '";
        while (obj7.hasNext()) {
            Object next3 = obj7.next();
            compareTo = new Path((String)(Map.Entry)next3.getKey());
            value = next3.getValue();
            ValidationPath.validateWithObject(path.child(compareTo), value);
            if (!compareTo.isEmpty()) {
            } else {
            }
            string = "";
            if (string.equals(".priority")) {
            } else {
            }
            priority = NodeUtilities.NodeFromJSON(value);
            Validation.validateWritableObject(value);
            treeMap.put(compareTo, priority);
            str2 = "Path '";
            priority = PriorityUtilities.parsePriority(compareTo, value);
            string = compareTo.getBack().asString();
        }
        obj6 = 0;
        obj7 = treeMap.keySet().iterator();
        while (obj7.hasNext()) {
            next = obj7.next();
            if (obj6 != null) {
            } else {
            }
            compareTo = 1;
            Utilities.hardAssert(compareTo);
            obj6 = next;
            if (obj6.compareTo(next) < 0) {
            } else {
            }
            compareTo = 0;
        }
        return treeMap;
    }

    private static void validateDoubleValue(double d) {
        boolean obj1;
        if (Double.isInfinite(d)) {
        } else {
            if (Double.isNaN(d)) {
            } else {
            }
        }
        obj1 = new DatabaseException("Invalid value: Value cannot be NaN, Inf or -Inf.");
        throw obj1;
    }

    public static void validateNullableKey(String string) {
        boolean validKey;
        if (string != null) {
            if (!Validation.isValidKey(string)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid key: ");
            stringBuilder.append(string);
            stringBuilder.append(". Keys must not contain '/', '.', '#', '$', '[', or ']'");
            DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
            throw databaseException;
        }
    }

    public static void validatePathString(String string) {
        if (!Validation.isValidPathString(string)) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid Firebase Database path: ");
        stringBuilder.append(string);
        stringBuilder.append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'");
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    public static void validateRootPathString(String string) {
        int startsWith;
        String obj1;
        if (string.startsWith(".info")) {
            Validation.validatePathString(string.substring(5));
        } else {
            if (string.startsWith("/.info")) {
                Validation.validatePathString(string.substring(6));
            } else {
                Validation.validatePathString(string);
            }
        }
    }

    public static void validateWritableKey(String string) {
        if (!Validation.isWritableKey(string)) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid key: ");
        stringBuilder.append(string);
        stringBuilder.append(". Keys must not contain '/', '.', '#', '$', '[', or ']'");
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }

    public static void validateWritableObject(Object object) {
        boolean next;
        boolean doubleValue;
        boolean value;
        double key;
        Object obj2;
        if (object instanceof Map != null) {
            if ((Map)object.containsKey(".sv")) {
            }
            obj2 = object.entrySet().iterator();
            for (Map.Entry next2 : obj2) {
                Validation.validateWritableKey((String)next2.getKey());
                Validation.validateWritableObject(next2.getValue());
            }
        } else {
            if (object instanceof List != null) {
                obj2 = (List)object.iterator();
                for (Object next : obj2) {
                    Validation.validateWritableObject(next);
                }
            } else {
                if (!object instanceof Double) {
                    if (object instanceof Float) {
                        Validation.validateDoubleValue((Double)object.doubleValue());
                    }
                } else {
                }
            }
        }
    }

    public static void validateWritablePath(Path path) {
        if (!Validation.isWritablePath(path)) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid write location: ");
        stringBuilder.append(path.toString());
        DatabaseException databaseException = new DatabaseException(stringBuilder.toString());
        throw databaseException;
    }
}
