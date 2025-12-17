package androidx.core.text.util;

import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
class FindAddress {

    private static final String HOUSE_COMPONENT = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";
    private static final String HOUSE_END = "(?=[,\"'\t                　\n\u000b\u000c\r\u0085  ]|$)";
    private static final String HOUSE_POST_DELIM = ",\"'\t                　\n\u000b\u000c\r\u0085  ";
    private static final String HOUSE_PRE_DELIM = ":,\"'\t                　\n\u000b\u000c\r\u0085  ";
    private static final int MAX_ADDRESS_LINES = 5;
    private static final int MAX_ADDRESS_WORDS = 14;
    private static final int MAX_LOCATION_NAME_DISTANCE = 5;
    private static final int MIN_ADDRESS_WORDS = 4;
    private static final String NL = "\n\u000b\u000c\r\u0085  ";
    private static final String SP = "\t                　";
    private static final String WORD_DELIM = ",*•\t                　\n\u000b\u000c\r\u0085  ";
    private static final String WORD_END = "(?=[,*•\t                　\n\u000b\u000c\r\u0085  ]|$)";
    private static final String WS = "\t                　\n\u000b\u000c\r\u0085  ";
    private static final int kMaxAddressNameWordLength = 25;
    private static final Pattern sHouseNumberRe;
    private static final Pattern sLocationNameRe;
    private static final Pattern sStateRe;
    private static final androidx.core.text.util.FindAddress.ZipRange[] sStateZipCodeRanges;
    private static final Pattern sSuffixedNumberRe;
    private static final Pattern sWordRe;
    private static final Pattern sZipCodeRe;

    private static class ZipRange {

        int mException1;
        int mException2;
        int mHigh;
        int mLow;
        ZipRange(int low, int high, int exception1, int exception2) {
            super();
            this.mLow = low;
            this.mHigh = high;
            this.mException1 = exception1;
            this.mException2 = exception2;
        }

        boolean matches(String zipCode) {
            int i;
            int mHigh;
            int int = Integer.parseInt(zipCode.substring(0, 2));
            if (this.mLow <= int) {
                if (int > this.mHigh && int != this.mException1) {
                    if (int != this.mException1) {
                        if (int == this.mException2) {
                            i = 1;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
    }
    static {
        androidx.core.text.util.FindAddress.ZipRange[] arr = new FindAddress.ZipRange[59];
        int i2 = 99;
        final int i31 = -1;
        FindAddress.ZipRange zipRange = new FindAddress.ZipRange(i2, i2, i31, i31);
        int i32 = 0;
        arr[i32] = zipRange;
        FindAddress.ZipRange zipRange2 = new FindAddress.ZipRange(35, 36, i31, i31);
        int i53 = 1;
        arr[i53] = zipRange2;
        FindAddress.ZipRange zipRange3 = new FindAddress.ZipRange(71, 72, i31, i31);
        int i86 = 2;
        arr[i86] = zipRange3;
        int i88 = 96;
        FindAddress.ZipRange zipRange4 = new FindAddress.ZipRange(i88, i88, i31, i31);
        int i92 = 3;
        arr[i92] = zipRange4;
        FindAddress.ZipRange zipRange5 = new FindAddress.ZipRange(85, 86, i31, i31);
        int i100 = 4;
        arr[i100] = zipRange5;
        FindAddress.ZipRange zipRange6 = new FindAddress.ZipRange(90, i88, i31, i31);
        arr[5] = zipRange6;
        FindAddress.ZipRange zipRange7 = new FindAddress.ZipRange(80, 81, i31, i31);
        int i111 = 6;
        arr[i111] = zipRange7;
        FindAddress.ZipRange zipRange8 = new FindAddress.ZipRange(i111, i111, i31, i31);
        arr[7] = zipRange8;
        int i114 = 20;
        FindAddress.ZipRange zipRange9 = new FindAddress.ZipRange(i114, i114, i31, i31);
        arr[8] = zipRange9;
        int i117 = 19;
        FindAddress.ZipRange zipRange10 = new FindAddress.ZipRange(i117, i117, i31, i31);
        final int i118 = 9;
        arr[i118] = zipRange10;
        FindAddress.ZipRange zipRange11 = new FindAddress.ZipRange(32, 34, i31, i31);
        arr[10] = zipRange11;
        FindAddress.ZipRange zipRange12 = new FindAddress.ZipRange(i88, i88, i31, i31);
        arr[11] = zipRange12;
        FindAddress.ZipRange zipRange13 = new FindAddress.ZipRange(30, 31, i31, i31);
        arr[12] = zipRange13;
        FindAddress.ZipRange zipRange14 = new FindAddress.ZipRange(i88, i88, i31, i31);
        arr[13] = zipRange14;
        FindAddress.ZipRange zipRange15 = new FindAddress.ZipRange(i88, i88, i31, i31);
        arr[14] = zipRange15;
        FindAddress.ZipRange zipRange16 = new FindAddress.ZipRange(50, 52, i31, i31);
        arr[15] = zipRange16;
        int i12 = 83;
        FindAddress.ZipRange zipRange17 = new FindAddress.ZipRange(i12, i12, i31, i31);
        arr[16] = zipRange17;
        FindAddress.ZipRange zipRange18 = new FindAddress.ZipRange(60, 62, i31, i31);
        arr[17] = zipRange18;
        FindAddress.ZipRange zipRange19 = new FindAddress.ZipRange(46, 47, i31, i31);
        arr[18] = zipRange19;
        FindAddress.ZipRange zipRange20 = new FindAddress.ZipRange(66, 67, 73, i31);
        arr[i117] = zipRange20;
        FindAddress.ZipRange zipRange21 = new FindAddress.ZipRange(40, 42, i31, i31);
        arr[i114] = zipRange21;
        FindAddress.ZipRange zipRange22 = new FindAddress.ZipRange(70, 71, i31, i31);
        arr[21] = zipRange22;
        FindAddress.ZipRange zipRange23 = new FindAddress.ZipRange(i53, i86, i31, i31);
        arr[22] = zipRange23;
        FindAddress.ZipRange zipRange24 = new FindAddress.ZipRange(i114, 21, i31, i31);
        arr[23] = zipRange24;
        FindAddress.ZipRange zipRange25 = new FindAddress.ZipRange(i92, i100, i31, i31);
        arr[24] = zipRange25;
        FindAddress.ZipRange zipRange26 = new FindAddress.ZipRange(i88, i88, i31, i31);
        arr[25] = zipRange26;
        FindAddress.ZipRange zipRange27 = new FindAddress.ZipRange(48, 49, i31, i31);
        arr[26] = zipRange27;
        int i57 = 55;
        int i109 = 56;
        FindAddress.ZipRange zipRange28 = new FindAddress.ZipRange(i57, i109, i31, i31);
        arr[27] = zipRange28;
        FindAddress.ZipRange zipRange29 = new FindAddress.ZipRange(63, 65, i31, i31);
        arr[28] = zipRange29;
        FindAddress.ZipRange zipRange30 = new FindAddress.ZipRange(i88, i88, i31, i31);
        int i27 = 29;
        arr[i27] = zipRange30;
        int i115 = 38;
        FindAddress.ZipRange zipRange31 = new FindAddress.ZipRange(i115, 39, i31, i31);
        arr[30] = zipRange31;
        FindAddress.ZipRange zipRange32 = new FindAddress.ZipRange(i57, i109, i31, i31);
        arr[31] = zipRange32;
        FindAddress.ZipRange zipRange33 = new FindAddress.ZipRange(27, 28, i31, i31);
        arr[32] = zipRange33;
        int i60 = 58;
        FindAddress.ZipRange zipRange34 = new FindAddress.ZipRange(i60, i60, i31, i31);
        arr[33] = zipRange34;
        FindAddress.ZipRange zipRange35 = new FindAddress.ZipRange(68, 69, i31, i31);
        arr[34] = zipRange35;
        FindAddress.ZipRange zipRange36 = new FindAddress.ZipRange(i92, i100, i31, i31);
        arr[35] = zipRange36;
        FindAddress.ZipRange zipRange37 = new FindAddress.ZipRange(7, 8, i31, i31);
        arr[36] = zipRange37;
        int i101 = 88;
        FindAddress.ZipRange zipRange38 = new FindAddress.ZipRange(87, i101, 86, i31);
        arr[37] = zipRange38;
        FindAddress.ZipRange zipRange39 = new FindAddress.ZipRange(i101, 89, i88, i31);
        arr[i115] = zipRange39;
        FindAddress.ZipRange zipRange40 = new FindAddress.ZipRange(10, 14, i32, i111);
        arr[39] = zipRange40;
        FindAddress.ZipRange zipRange41 = new FindAddress.ZipRange(43, 45, i31, i31);
        arr[40] = zipRange41;
        FindAddress.ZipRange zipRange42 = new FindAddress.ZipRange(73, 74, i31, i31);
        arr[41] = zipRange42;
        FindAddress.ZipRange zipRange43 = new FindAddress.ZipRange(97, 97, i31, i31);
        arr[42] = zipRange43;
        FindAddress.ZipRange zipRange44 = new FindAddress.ZipRange(15, i117, i31, i31);
        arr[43] = zipRange44;
        FindAddress.ZipRange zipRange45 = new FindAddress.ZipRange(i111, i111, i32, i118);
        arr[44] = zipRange45;
        FindAddress.ZipRange zipRange46 = new FindAddress.ZipRange(i88, i88, i31, i31);
        arr[45] = zipRange46;
        FindAddress.ZipRange zipRange47 = new FindAddress.ZipRange(i86, i86, i31, i31);
        arr[46] = zipRange47;
        FindAddress.ZipRange zipRange48 = new FindAddress.ZipRange(i27, i27, i31, i31);
        arr[47] = zipRange48;
        int i29 = 57;
        FindAddress.ZipRange zipRange49 = new FindAddress.ZipRange(i29, i29, i31, i31);
        arr[48] = zipRange49;
        FindAddress.ZipRange zipRange50 = new FindAddress.ZipRange(37, i115, i31, i31);
        arr[49] = zipRange50;
        FindAddress.ZipRange zipRange51 = new FindAddress.ZipRange(75, 79, 87, i101);
        arr[50] = zipRange51;
        FindAddress.ZipRange zipRange52 = new FindAddress.ZipRange(84, 84, i31, i31);
        arr[51] = zipRange52;
        FindAddress.ZipRange zipRange53 = new FindAddress.ZipRange(22, 24, 20, i31);
        arr[52] = zipRange53;
        FindAddress.ZipRange zipRange54 = new FindAddress.ZipRange(i111, i118, i31, i31);
        arr[53] = zipRange54;
        int i46 = 5;
        FindAddress.ZipRange zipRange55 = new FindAddress.ZipRange(i46, i46, i31, i31);
        arr[54] = zipRange55;
        FindAddress.ZipRange zipRange56 = new FindAddress.ZipRange(98, 99, i31, i31);
        arr[i57] = zipRange56;
        FindAddress.ZipRange zipRange57 = new FindAddress.ZipRange(53, 54, i31, i31);
        arr[i109] = zipRange57;
        FindAddress.ZipRange zipRange58 = new FindAddress.ZipRange(24, 26, i31, i31);
        arr[i29] = zipRange58;
        FindAddress.ZipRange zipRange59 = new FindAddress.ZipRange(82, 83, i31, i31);
        arr[i60] = zipRange59;
        FindAddress.sStateZipCodeRanges = arr;
        FindAddress.sWordRe = Pattern.compile("[^,*•\t                　\n\u000b\u000c\r\u0085  ]+(?=[,*•\t                　\n\u000b\u000c\r\u0085  ]|$)", i86);
        FindAddress.sHouseNumberRe = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t                　\n\u000b\u000c\r\u0085  ]|$)", i86);
        FindAddress.sStateRe = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t                　]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t                　]+of[\t                　]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t                　]+states[\t                　]+of[\t                　]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t                　]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t                　]+mariana[\t                　]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t                　]+carolina)|(nd|north[\t                　]+dakota)|(ne|nebraska)|(nh|new[\t                　]+hampshire)|(nj|new[\t                　]+jersey)|(nm|new[\t                　]+mexico)|(nv|nevada)|(ny|new[\t                　]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t                　]+rico)|(pw|palau)|(ri|rhode[\t                　]+island)|(sc|south[\t                　]+carolina)|(sd|south[\t                　]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t                　]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t                　]+virginia)|(wy|wyoming))(?=[,*•\t                　\n\u000b\u000c\r\u0085  ]|$)", i86);
        FindAddress.sLocationNameRe = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t                　\n\u000b\u000c\r\u0085  ]|$)", i86);
        FindAddress.sSuffixedNumberRe = Pattern.compile("([0-9]+)(st|nd|rd|th)", i86);
        FindAddress.sZipCodeRe = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t                　\n\u000b\u000c\r\u0085  ]|$)", i86);
    }

    private static int attemptMatch(String content, MatchResult houseNumberMatch) {
        int restartPos;
        int nonZipMatch;
        int it;
        int numLines;
        int consecutiveHouseNumbers;
        int foundLocationName;
        int wordCount;
        String lastWord;
        int it2;
        int i2;
        int i3;
        int validLocationName;
        MatchResult matchHouseNumber;
        int i;
        restartPos = -1;
        nonZipMatch = -1;
        it = houseNumberMatch.end();
        numLines = 1;
        consecutiveHouseNumbers = 1;
        foundLocationName = 0;
        wordCount = 1;
        lastWord = "";
        Matcher matcher = FindAddress.sWordRe.matcher(content);
        while (it < content.length()) {
            validLocationName = -1;
            while (it < matcher.start()) {
                if ("\n\u000b\u000c\r\u0085  ".indexOf(content.charAt(it)) != validLocationName) {
                }
                it = i2;
                validLocationName = -1;
                numLines++;
            }
            it2 = 5;
            wordCount++;
            i = 0;
            consecutiveHouseNumbers = 0;
            lastWord = matcher.group(i);
            it = matcher.end();
            it2 = FindAddress.matchState(content, it);
            validLocationName = FindAddress.sWordRe.matcher(content);
            nonZipMatch = it2.end();
            foundLocationName = 1;
            if (restartPos == validLocationName) {
            }
            restartPos = it;
            if ("\n\u000b\u000c\r\u0085  ".indexOf(content.charAt(it)) != validLocationName) {
            }
            it = i2;
            numLines++;
        }
        if (nonZipMatch > 0) {
            return nonZipMatch;
        }
        i3 = restartPos > 0 ? restartPos : it;
        return -i3;
    }

    private static boolean checkHouseNumber(String houseNumber) {
        int digitCount;
        int i;
        boolean digit;
        String str;
        digitCount = 0;
        i = 0;
        while (i < houseNumber.length()) {
            if (Character.isDigit(houseNumber.charAt(i))) {
            }
            i++;
            digitCount++;
        }
        int i3 = 0;
        if (digitCount > 5) {
            return i3;
        }
        Matcher matcher = FindAddress.sSuffixedNumberRe.matcher(houseNumber);
        int i5 = 1;
        int int = Integer.parseInt(matcher.group(i5));
        if (matcher.find() && int == 0) {
            int = Integer.parseInt(matcher.group(i5));
            if (int == 0) {
                return i3;
            }
            String lowerCase = matcher.group(2).toLowerCase(Locale.getDefault());
            switch (i6) {
                case 1:
                    str = "st";
                    return lowerCase.equals(str);
                case 2:
                    str = "nd";
                    return lowerCase.equals(str);
                case 3:
                    str = "rd";
                    return lowerCase.equals(str);
                default:
                    return lowerCase.equals("th");
            }
        }
        return i5;
    }

    static String findAddress(String content) {
        int start;
        int checkHouseNumber;
        Matcher matcher = FindAddress.sHouseNumberRe.matcher(content);
        start = 0;
        while (matcher.find(start)) {
            start = matcher.end();
            checkHouseNumber = FindAddress.attemptMatch(content, matcher);
            start = -checkHouseNumber;
        }
        return null;
    }

    public static boolean isValidLocationName(String location) {
        return FindAddress.sLocationNameRe.matcher(location).matches();
    }

    public static boolean isValidZipCode(String zipCode) {
        return FindAddress.sZipCodeRe.matcher(zipCode).matches();
    }

    public static boolean isValidZipCode(String zipCode, String state) {
        return FindAddress.isValidZipCode(zipCode, FindAddress.matchState(state, 0));
    }

    private static boolean isValidZipCode(String zipCode, MatchResult stateMatch) {
        int i;
        int groupCount;
        int i2;
        boolean matches;
        if (stateMatch == null) {
            return 0;
        }
        groupCount = stateMatch.groupCount();
        while (groupCount > 0) {
            i2 = groupCount + -1;
            if (stateMatch.group(groupCount) != null) {
                break;
            } else {
            }
            groupCount = i2;
        }
        if (FindAddress.sZipCodeRe.matcher(zipCode).matches() && FindAddress.sStateZipCodeRanges[groupCount].matches(zipCode)) {
            if (FindAddress.sStateZipCodeRanges[groupCount].matches(zipCode)) {
                i = 1;
            } else {
            }
        } else {
        }
        return i;
    }

    public static MatchResult matchHouseNumber(String content, int offset) {
        int indexOf;
        int i;
        boolean matchResult;
        boolean checkHouseNumber;
        final int i2 = 0;
        if (offset > 0 && ":,\"'\t                　\n\u000b\u000c\r\u0085  ".indexOf(content.charAt(offset + -1)) == -1) {
            if (":,\"'\t                　\n\u000b\u000c\r\u0085  ".indexOf(content.charAt(offset + -1)) == -1) {
                return i2;
            }
        }
        Matcher region = FindAddress.sHouseNumberRe.matcher(content).region(offset, content.length());
        matchResult = region.toMatchResult();
        if (region.lookingAt() && FindAddress.checkHouseNumber(matchResult.group(0))) {
            matchResult = region.toMatchResult();
            if (FindAddress.checkHouseNumber(matchResult.group(0))) {
                return matchResult;
            }
        }
        return i2;
    }

    public static MatchResult matchState(String content, int offset) {
        int matchResult;
        int indexOf;
        int i;
        if (offset > 0 && ",*•\t                　\n\u000b\u000c\r\u0085  ".indexOf(content.charAt(offset + -1)) == -1) {
            if (",*•\t                　\n\u000b\u000c\r\u0085  ".indexOf(content.charAt(offset + -1)) == -1) {
                return null;
            }
        }
        Matcher region = FindAddress.sStateRe.matcher(content).region(offset, content.length());
        if (region.lookingAt()) {
            matchResult = region.toMatchResult();
        }
        return matchResult;
    }
}
