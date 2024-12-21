package com.stiksy.advent.days;

import java.util.*;

public class Day19 {
    Map<String, Boolean> cache = new LinkedHashMap<>();
    Map<String, Set<String>> possibilities = new LinkedHashMap<>();

    public List<List<String>> parseInput(String lines) {
        List<String> availablePatterns = new ArrayList<>();
        List<String> requestedPatterns = new ArrayList<>();
        String[] inputLines = lines.split("\n");
        availablePatterns.addAll(List.of(inputLines[0].split(", ")));
        for (int i = 2; i < inputLines.length; i++) {
            requestedPatterns.add(inputLines[i]);
        }
        return List.of(availablePatterns, requestedPatterns);
    }

    public boolean createPattern(List<String> availablePatterns, String requestedPattern) {
        if (cache.containsKey(requestedPattern)) {
            return cache.get(requestedPattern);
        }
        for (String availablePattern : availablePatterns) {
            if (requestedPattern.startsWith(availablePattern)) {
                String subPattern = requestedPattern.substring(availablePattern.length());
                if (subPattern.isEmpty()) {
                    return true;
                }
                if (createPattern(availablePatterns, subPattern)) {
                    cache.put(requestedPattern, true);
                    return true;
                }
            }
        }
        cache.put(requestedPattern, false);
        return false;
    }

    public void createAllPossiblePatterns(List<String> availablePatterns, String requestedPattern, int index) {
        if (cache.containsKey(requestedPattern)) {
            System.out.println("Cache hit for " + requestedPattern + ", possibilities: " + possibilities);
            return;
        }
        for (String availablePattern : availablePatterns) {
            if (requestedPattern.startsWith(availablePattern)) {
                String subPattern = requestedPattern.substring(availablePattern.length());
                if (subPattern.isEmpty()) {
                    Set<String> lastItem = possibilities.getOrDefault(requestedPattern, new LinkedHashSet<>());
                    lastItem.add(requestedPattern);
                    possibilities.put(requestedPattern, lastItem);
                    return;
                }
                createAllPossiblePatterns(availablePatterns, subPattern, index + 1);
                cache.put(requestedPattern, true);
                for (String oneSubPattern : possibilities.getOrDefault(subPattern, new LinkedHashSet<>())) {
                    Set<String> possibleCombinations;
                    if (possibilities.containsKey(requestedPattern)) {
                        possibleCombinations = possibilities.get(requestedPattern);
                    } else {
                        possibleCombinations = new LinkedHashSet<>();
                    }
                    possibleCombinations.add(availablePattern + "+" + oneSubPattern);
                    possibilities.put(requestedPattern, possibleCombinations);
                }
            }
        }
    }

    public int runPart1(String input) {
        Day19 day = new Day19();
        List<List<String>> parsedInput = day.parseInput(input);
        List<String> availablePatterns = parsedInput.get(0);
        List<String> requestedPatterns = parsedInput.get(1);
        int validPatterns = 0;
        int count = 0;
        for (String requestedPattern : requestedPatterns) {
            count++;
            System.out.println("Processing pattern " + count + " of " + requestedPatterns.size());
            if (day.createPattern(availablePatterns, requestedPattern)) {
                validPatterns++;
            }
        }
        return validPatterns;
    }

    public int runPart2(String input) {
        Day19 day = new Day19();
        List<List<String>> parsedInput = day.parseInput(input);
        List<String> availablePatterns = parsedInput.get(0);
        List<String> requestedPatterns = parsedInput.get(1);
        int validPatterns = 0;
        int count = 0;
        for (String requestedPattern : requestedPatterns) {
            count++;
            System.out.println("Processing pattern " + count + " of " + requestedPatterns.size());
            day.createAllPossiblePatterns(availablePatterns, requestedPattern, 0);
            if (day.possibilities.containsKey(requestedPattern)) {
                validPatterns += day.possibilities.getOrDefault(requestedPattern, new LinkedHashSet<>()).size();
            }
        }
        return validPatterns;
    }

    public static void main(String[] args) {
        Day19 day = new Day19();
        String finalInput = "brguub, gbb, bgr, uubb, uwg, wrbbuggu, ubg, bbgu, wugw, rbwur, bgbggur, wugguw, guguw, bbgrr, ggg, rwg, wuu, rbwrb, wbw, gbbug, brbbru, brr, wgww, grg, buwu, rubg, rbu, uwuw, rgb, wbrwbwu, rbgur, bgrwg, wwrgw, guw, gru, wbrbgu, brwu, wuw, bgu, wr, bwbbwb, bbbuu, ruru, wubwurru, rrguu, wguuw, gbrg, ubgg, brrw, bwr, bbg, wwwwbrb, ggrrgwg, gwwrwu, gruguw, uurbu, rgu, brb, ugwrgwrr, br, rwurgg, rbggwrw, bgb, uruw, wwr, bgbrgr, w, rbggu, bbbru, grw, guwu, wbwurg, wubwb, ruubr, wurgruw, bggru, gbuw, rbub, wgb, wb, uuuru, wuwwwbu, ruuggb, bubwuur, burrbrgw, bg, wwbuur, rugw, rwwb, wwwwrrru, wrb, grwrwu, wwggbu, ubb, rwgw, wrg, gbgbr, gwg, gbwuw, bgbwg, urrb, uwuwbbrw, uub, bww, wbggu, wuuwgw, guwr, ggww, ugrbb, uwr, buurg, wwuurwu, rbg, gugbw, uw, wurwubb, gbbb, gwru, ruwwrrw, gbrb, gwwgbb, uugr, urr, ugggub, gugw, wbbgb, rwgrwgg, gbw, rgwrrbr, uuubgwgg, wbrrugrw, ubw, bwgggg, bwwurru, wwb, grwug, rugbrr, ubbwggu, grr, ubbu, ggwwgg, uwb, gurrr, uu, gwbr, bbug, wbg, gwu, wgubrbr, gr, bwwrbgrr, bbbr, ru, rbbg, gug, ur, uuu, rbbu, wur, ruw, brggur, wgr, wwbbbwb, uru, gwgbw, gbguu, ggwgbg, buwur, rwb, uwur, bwwr, bburw, rgbwg, wubu, bbw, rbw, rgg, uww, bbb, bwgr, wwwuwg, bwu, bub, bb, buuw, bbrwbg, wrrb, wbguww, grwgwu, wbrww, grb, wurrr, bruubg, grgww, wwbwg, rguw, rug, gbr, rbbb, gbrr, wwbub, bwb, buubg, wbb, bggr, ww, rwrug, wbu, wrr, bgbw, rbr, wurwrg, uuw, rwbww, gbbgbb, wgbwb, b, wwuu, uggwg, wgruuubr, ug, uuwgw, urrw, wrbgu, burwrrr, gww, bbrbbg, bgw, rrwu, rrru, ruug, buurgu, rgw, rrbwu, uwgg, ugb, ugrwur, bgbg, ggwbg, rwbg, bgwu, wgbbbwb, gbu, ggb, wbr, gbur, brw, gb, bru, bwur, gbg, grguwgw, uwbggbrb, rbgb, ggbr, brbbbu, ugw, guu, bur, r, wgugbw, gggrwb, rru, wwbug, gbbbrw, brugwggw, buu, rubwrw, wguwr, urg, gwwbu, rbgg, bggu, brrrggbg, rgwugbww, rwuur, buw, guww, gwr, rwgg, rbgbbg, rugburw, rbgww, wbbwgbrr, ggr, wuuw, uwu, rrr, rrwgg, ggrgu, bruu, rbwuuww, gburbru, bbugw, uuub, gu, uwgurw, uggu, wurw, rrb, uurwbg, gw, wub, wbwrb, wgu, rur, gwrgw, wuww, gurwr, bbwuu, bggbg, brbgw, rrww, ubww, urguugw, uurwb, uugw, rurg, wwuugg, bbr, ubr, uwrbu, wwgbuu, uwrr, wbrwgbb, bwubwb, rgr, wbbuwbwg, ggu, rwuw, ggruww, ubwrrg, wrgg, gwbrr, rrugg, ubuuwgru, uwrbg, bwg, wwgw, urb, gubb, ugg, grwgrw, ruu, wru, ggbbuw, guwwb, ugrgw, gub, u, wrrurbb, uwuguru, rub, grwwg, wgg, wbbbru, gwrrwb, gwb, ubrgw, rr, gburu, urgubru, uwbwrwg, bwrrruuw, grrr, rw, wbubbru, bgg, urgb, wwg, rbugbuu, ggbb, wggr, wrgbu, rgurr, rrg, gubg, rrgrgrg, rwu, bguubg, bbugb, wgw, rrw, wug, wg, wwur, urw, wbubg, www, wwwwrb, rruwggu, bwbb, rwurr, rggg, wwwur, rbuu, uug, grub, rrug, gurr, wwu, wwwwrrr, ubugur, gbbbwrww, ubu, rwrubu, wrrw, gbguw, wbbgrg, wrw, rbwb, bbrrbw, ugu, rbb, rwwr, bwguuuw, bu, rrgwrg, urgrgr, ggwwwgu, grww, bbbwbbu, wbww, ub, wbbwb, gur, wu, gurgrwg, bubw, urug, uuguww, bwrrug, bbbb, rb, bbu, bguw, buug, ruwubg, wgwurrw, gguggrub, rwr, wrbw, ubbgrwu, bug, uuug, ggrgg, gg\n" +
                "\n" +
                "uburuurwgwwbwrurwubgrurrgwrwbuuugrggrgwwbwuggwguubrbg\n" +
                "wbwwgguwrwwwgubrbuuwrwbwrrwgwugbuwrwgwgrgrububurrbbggugu\n" +
                "rbugwrbrgggbwbgrwwrrwrguuurbbuwwwgubrbwbrrrrgwggruurrbrg\n" +
                "rugbgwbwugwuwgrruburwuububwuuwruugrwbuwwgww\n" +
                "rbgbbwrwrwuguggwububrubuguurrurururbrrbbgguuuuggwrubrg\n" +
                "grgwbgrgbgrrgurbgbgrwbbururrwrbrubbrbuuubwgwbubuwgubg\n" +
                "wugrurbwrurrgbbbruwurbwguugwgurrgugrrrwgub\n" +
                "bwwwuwrwwwgwrurrwurrwgbwbgrbrugbbrgbwrrurwubrugbuubwubrg\n" +
                "uwbggbrbwrugbggrruwrwgwbugugrrrgwbbwgwrwubrg\n" +
                "wggrwwgbgbubbbgggbrrbgbrgbwuwwruwubuwgguwugwrrrwrwwwbwbbrg\n" +
                "rurwggrurruuwrbwurbwrbubgurgbwwgwrruugwggbrbbbwuggruwbrg\n" +
                "wuurwubwbbbwrwrwgbgubrgruurbrgbbgrbbbrrbbbugug\n" +
                "grrrugguwgwwbugrwwbwurgurbwgwrwrgwbgrgwrgugbrrurwubrg\n" +
                "ubgrwuwrrbgbwwrurgwwbgwgbbgggbgbbguwrubuuwbwrwbwgbwb\n" +
                "grggrgrgguruwwwuubbrbuwbrgubrwbbwbwrbuguwgwrrwrggb\n" +
                "uugwrbuuurwrwwbguwruwgruggggwbugwbwrbuggwgbbbrbburru\n" +
                "rrgrggbbbbgbgbwbbrgurrubgbugrruwwrrbwugbbbbbbbbgubw\n" +
                "uurgwwrbwurwgggbrugggwbbgbwrgrwbwrwbwbbruwuuguuuwwwwbr\n" +
                "uurguggwgbbbrgrwrggbbugbrbrwbguwggggbuurwb\n" +
                "gbgwrwrubbbggbubgwrwrurbrwrgwrbgbwrrruuwrggrurrwgwuwgg\n" +
                "ugurgggbwwuuwbbbwrwbbbubgwrwbgwgrgubbwubwggrbrg\n" +
                "wugwbuggbwbububgggbrbwgruuwbgwrwrruuuwrgbbbwwburbgruwrbubrg\n" +
                "ubwrggwbugubgwgubwbrgrrwrgrbrbrbrwuuwurbrrw\n" +
                "wwguubrbbguuugbwgbgwrwbwrurrbbrbugrwgbwbrg\n" +
                "brbruwgwgwuwuurrwwrubggwgrwbbbbugbgbrwwggbrurgur\n" +
                "bwrwbgwubwubrgugbrwurwwuwuwubwgrbgrbrrbbgrbrg\n" +
                "gugwbbugrgubbggwugbgbwbugbwrrgrbrrwurwwbgwubbbru\n" +
                "rugggrbbbgbruugggrrwggwrrrggrrbubrguugwubbrbgugwu\n" +
                "ugggwgburwwugbrwgggruwbubuwwwbgbuugurbbrg\n" +
                "wbrwubwwrwrggubrrgbbwrgguuuwwruwwgbrwgwburbuggwbrrbrg\n" +
                "gwbugrwgubgwwrurrwgrurggbuwbwbuwbwrwwgbrrrrrbrrw\n" +
                "ugbgbgrwgguubguugruuwwuwurwrrwbguurwwurbrgwrwwrwwbrg\n" +
                "wwubggrgwugubwbrgbrguurwruruwgbbrgururbbbwrrg\n" +
                "wwbbwgbwrwruuwwuwgbuurbgubururubwwggwrwwwrbbg\n" +
                "bgbwbwgbrwggrbgwrbrgrrgubrwuwrgbrrrrgwrrugbrguwugu\n" +
                "wgbgggurwrrrbwrgggbggubbubrrbbgguwbggbrbguww\n" +
                "wgbrgbbuwrrwugwwguuubbwwbwuggwrgrgrgrugwgggbruguu\n" +
                "urburbbbrwbwuubwubrwbwurbgrrbrwwrgggrburbrg\n" +
                "bwuwugwgwwrbbbwubwgbwuuugugrbwubbbuuguuugurb\n" +
                "rgurguggrgwuuugurbguwurgwruwgubrbgwggggwgrbbbrwwbbbwrbw\n" +
                "guuuwbwggguwrrwwguwrwubbbbwgwuwrgggrbwbrwbwuubwwggbgbbrw\n" +
                "uwrgwugrrbbgwuuwwggwwwuugwwgbwgugwgwuuwruubbwgbuwbwbwgwbbu\n" +
                "wuwuubrgbbbgggwrrrwwrrrgguwgbwuurgbuwugubbwbgr\n" +
                "wwburrgubrurbwugbbuwbbrgwwgrgwwurwwguwrrrwgbwgururbrg\n" +
                "wuguwburwgwuwbrubbbrrwgbuwburrgugwbbuwguurubru\n" +
                "rgrrururrbgburrrubrgrrwwbbwuwrburgwgrbubuwbrubrg\n" +
                "ubwuggrruwrgggwrbubuwububbgbrrgguruggrrwugbg\n" +
                "gwuuwuwuggbrrubuwuuwuruurwguwbwuruwrwggrbubrrr\n" +
                "brgwrbggwuubuwbubggrwubgrbubgwgbuwuuwuwbrbugbgrugbwuurbubw\n" +
                "rwbgbguwbgbuubwggrbbugrrwbbburwwgubwbubwrrgbrgwbwbwwgrr\n" +
                "urwrwguwbgwwbrgbrwrbwgruwwbwrwbwwubrurwwbwwugwgrgu\n" +
                "rgggrubrbrbbggrwruuwwgbgbrwuwurugrbrrububwgbwwuubbrr\n" +
                "wbwrrurwwgwrgrbgrwuwrwuuwwggwbwgwugwrgwrrgguwgrwggwwwbbbbrg\n" +
                "uwrwbrbbgwbgurbbrbwbububrwwugubrwuwubggwwgg\n" +
                "uuwbgrurggurbubuwwbggwrwuruurgwggbubrbrrbubgrrggubu\n" +
                "rwgwwbbrbbgbgbwwbbwbrbubbuggrwbbuwbwgubrwbbrg\n" +
                "bgrruwbruwbrubgbugggbrbwuurrbgbubgrbggubwurguuurgburruw\n" +
                "urwbrwurrwguururugrrrrwuggguubguurwgrgrrbwggw\n" +
                "guuwugwugugruuburbrgubgbugrwgrrwrruwgwrgubrwuurwgguwu\n" +
                "gbrrbuuwgbrbuubgrwbggwwbrubrbubwgbbuwbgwwrrwuurrubbg\n" +
                "bburrrrwwgrbbbwrbwrwbbwuwwwruggbgwgbrugwggwuububwgubgrw\n" +
                "bbgwrggbgrbbgbbwburrubgubbrwrwbbgwbgbruwruugubrggbrwgrwbrg\n" +
                "rubwrburruugguggrrgrbwrgbrbuurwurwbgruwrggggrugbr\n" +
                "ruwwbbburrbgrurrwbugbwwbrgbrrwbugbbbbuuwbrg\n" +
                "rubrbbwgrbwuuruubwwwugurgwubgwugwwwwwurrbubuggubrrrrbb\n" +
                "buurwrgbwrbrwugugggbbrwwwwubururgbbuugrbugwbgugbrwub\n" +
                "bgwgwgrbrbgwururrrurbrurwggbbgrugrrgrgbugrrburbgru\n" +
                "rurruubggubbguugwgrwbuggrgburwuugwruwugugggbwggwwbrub\n" +
                "ugrrbbbwggguwgrbbggugbwbbggwrurubrwrrubrwwrgurwg\n" +
                "wbgggwrguurgrbwuggurbbbwggrurwuuwwrbrbwrburgbbubw\n" +
                "wbgwbuurgrgrgrgbuwbugrruburuwwrbwwuwbgggwwuubbwuugbgrrbbuw\n" +
                "buwbwrgwwrrbrrrgurgbbbrbrggbgrwubugrbrrgrgbuwgbubbwgwbrwbb\n" +
                "buugbrububbgrubguuuwwwwgrbrwubwurruwwugwburuurr\n" +
                "wruurrwbuwwwwgrgurrururuguugubwwbwrwuwbbruruugggbubgggbgbbrg\n" +
                "bwbwuuwwubwruwurubgrrugbrguguuwubgwrggwrrbubbgwwr\n" +
                "rrrbbwwgubwrrbgbwguwruwgrbgbgrbbubrwrrbburggwrug\n" +
                "gbwbubwbwwbuuggbuugwrrbrubgbbrggrbruggwbwbggrrrguggbr\n" +
                "rwrgrrbggrrbgruuwuwwrbgrruubrwgwbgbugbwbwbururbgrbwrbww\n" +
                "bgwruurrurwbuuggwgrrrugrrgwrrbgwbguubbwbgrbwu\n" +
                "rbbuwgrwubwurrrwwwrbwuuuwuwbbrwrurggwbrgugrrwugwwwugb\n" +
                "bwburuwrggbbuggbguwbbuwbwgwwbrwrwrwgwwgguurbguwrwwb\n" +
                "ubruruurwwbwgwbugbwguwbrggbggbwwrbuwrrwgwurwwrwrrbggbwwgu\n" +
                "rbgruuwubbrbwbuugrgbguruggwwbubwuwwuubgwugrrrbwrg\n" +
                "rwwbrrrggwubggwubbgwbbbuggbuuuugggbbugggbrburwb\n" +
                "bwguuugggubuguugwbguwbwuuwrgubggggrgrbggrbgwgrurrrbwuuubrg\n" +
                "bbwgrrgruuugggwrwgwrbwrggbggrwuggbwgurgwbgbbwrruugburgg\n" +
                "uuurwrwbugubrrrrbbrgugubwbuguggugrgrwbuwgbbrgbubgguu\n" +
                "guwggrbbbgbggruubbwgubrguggwwwrbwgwwrgbwrwgruuubrrbwur\n" +
                "brwwwwwuuwgwgbbwbwrwwwggwurgwwrwwrwguwugubuu\n" +
                "uugbrubburgrwbgbwbrrgbbbuubburubrrrubuubbrrwrubbgbug\n" +
                "rgwguugwwrwruubwurrbbbuburuwrwrwugbbuububbbbbwbwgrwbubb\n" +
                "bwbuggrwgwuuwwgrgggbbwrbubrbgurrgurgurrwwrubrrwbguwbrugrbw\n" +
                "ubwbgwwrbrgwguurrburrbrgwwgwugwgurgbrrubuggrguruwrrwuub\n" +
                "gbuwbwbrruwggwgggwbgwuwbrbrgggwuuuuwrbrurbuuwgbguuw\n" +
                "brurugugubggubbrbubbrwurrrwwrrgbuwrgwrgwbbgwurwruwrrbrg\n" +
                "uguurgbbwbwrguwwgrbwwgwrbwbgguwwrwgwggrbbrgrbwrgrbrg\n" +
                "bwgwwruruurgrgggubrwwrbwrwgruwwwggwubuwuwbbrwgurbrg\n" +
                "urburggwwbwrbuwwgurrrwuubrrbwrrrgrwruruwbwwwugwbrwgwrbrg\n" +
                "rubrwbbrbbwbubbbggubbbggurggrrwwwurugubbwrrrgwuurrrgbwbwb\n" +
                "wgbgwbgugrrwbgbrugggbrgwrrbwbgrrugubgbwgrwgrwbgbr\n" +
                "rbwrwrrbgrgugruwrugwbbuwbuurwwuugbrwgbrrbbbuwbgbwrwrrgbgwr\n" +
                "buurugrrgugrgrwwgwrubbwwbugurbbggbbgwgbwrrwbwurwbwr\n" +
                "bwbuwurwguwubwburgwbbbwbubruuururuwbbwgwwwbubg\n" +
                "rrgrgbgwubbugurwwrwbgugwwwgguwrrwruuwurgwbbrg\n" +
                "ruwwrrubrbugburggwbrbwguwrrgwuuwgrbrurggwwububbubrwg\n" +
                "wuwbgwwrguuwgrruuwrwwwururrrrwururwbuwbuwrwgwugbuwu\n" +
                "grrgguurubwbrugrrbwbbrgubugwruuurrruwwrbbwrrrugww\n" +
                "rwubbwubwrbwbwbrrrggbgurwuwwgwugwgbubrrugrwbrg\n" +
                "bwurggbgbrgugwbruggwbgbuguwrwwgurguwgrbwrbrrbubrrbrbu\n" +
                "urbgggwrrugbwrgwrrgurrbwrbwwgrgwrbgwuwububgruubrrwb\n" +
                "wwrrwgbwbbugbwwuwgbrbbgrurbbuugbubgubguuwguggubrg\n" +
                "bgwgbggrgurrbwurgbwurgwwgrbwwruwwuwbwugrbbrg\n" +
                "wbwbuururgrrbrbubrguuugruggbbgbbbguruuwwwwbuurubugururrr\n" +
                "rgrrwbbruwububbrbuuwrrwugrugrugbwwbbwgurrbbwgwwbwrbugwrwbu\n" +
                "bwwwuwbwwuuuubgrgrbuwwugwbgwrgrbgruugbuwur\n" +
                "bgbwggbuuuuguwrrurwrrrrbbggbgrruwubbrrwwwggurbubr\n" +
                "gbguwbubrurwubbgwuwwrbubuuwgugwbwgrbgwurbrrwgbugr\n" +
                "rurruuwrubguuuwugwrburgrgrugbrrbgbbwrbguwbbbwwggwguuu\n" +
                "uuwwggbgbburwwrrrurbgbbubbrubwggwugrrbwrrwbbrg\n" +
                "bwguwurbwbgwuuuwrbwwubrgugwurugwwbbgggrrruburwrgbg\n" +
                "rwugwurwuwbuguwwrbrwrgubwbwruuwgwuurubwrruugwwbwugugubgw\n" +
                "gwurrwrbbbrbuwwubgwgbugwubuwrrwubgugwbbuggrbgwbg\n" +
                "rrwuwwgbugbrwgwuurubwubguruugrgrubrwbguwrugu\n" +
                "uuuugrwbwruggbwwggrwwwwwubwubwruugwuwggrgb\n" +
                "rrbwwrbbuwwgbwguwwwggguwgugwbgwuwrwuruwwbggrrb\n" +
                "rwbgbbgggubwwugbrrwgbruwugrrurwwgrrbruuwgugurgbruugbub\n" +
                "gugrwuugbbrrbbbuuwuggbbrwbgwbrrruurwbrbbrrgwbgrrggbrugrrw\n" +
                "rwuguruwuguwwbrbwwbruuwwgrbrruwbggguwurrbuwwbgbub\n" +
                "bbruruuguwbbrwgrbwuwbrrgbwgwuuwgwuguwbgwgbwbgbuwuggrww\n" +
                "burbgwbbrgwgwbguuwuguwggbubwggbwwgwuburbrbgbb\n" +
                "burbgrbggrwbwurgbggrrgbrbbbgbuurubrbbwwwuwgubbwguuwbubr\n" +
                "grwbwrgrbwwubggguuguguwrrrgwbuubwrbuugbgggubgwuguuruugub\n" +
                "rrbwbrwrggburrburgguburwbgwubrubgugrwrwbwwubgwrwwu\n" +
                "bguwrubbwgrurbbbgrgwwrbugbwwuwgrrurrbrggbww\n" +
                "grbrwbrwbruggbrwbbbgbrgbuurbrbguwgbbwbgwbwwu\n" +
                "bwggrrubrgwbuugrbrwggbgggbgurwuwbbrbugbrubbrg\n" +
                "ubgbwuruuwwgrwwbwwgbwwwrburbwguubbgbrbwbrrgbrb\n" +
                "wgwbgwubguwbbwwwrrrbgbubwwwrbbbgrrbgggubuwrg\n" +
                "uwgwrwuuwugbbruwgubwbgwggubrbwrrggbugrubgubbggrbrgurwwrwgr\n" +
                "bruwbrgbrbrrbwgbrgbbuugrguugrrrbrbwurwgrggggwugwwbuubuu\n" +
                "wrwbwwwbwrwrbwwgugugbbbgwuwbrgwugrubrwgwbwwwgr\n" +
                "wrbgwwbwgrgwugbwwwrgrgwgburbguugururwburrubrg\n" +
                "ugwuruwruubbrgwwrgrwgrrgbgubbgbgrrrubuwurwgwugrbwuugwbrg\n" +
                "rwbwwrgbugbgburwugububwwbbgwrbugbugrrwgrbugwbrgwgu\n" +
                "gubrrwgbgrbgrgrgburwubwbgbrwrbggurrwbbwwurgrb\n" +
                "gwgubuwuwbwgwbrrwrgruruwrbubbguwugubugrrbggwwurbgrbrubg\n" +
                "wwubruuubwwgurbgwggbbgbggrurbbrggbbrgwwrwwbrrwrbgwruwrww\n" +
                "grgbuubrguuguugbwgrburgubuugggggggbuwgbgwrggu\n" +
                "rgubwggrwwuwurbbwugwrggruguuwrruuubuuwgrugwruuubrg\n" +
                "brubrwwwwgwbwuugrbbbrbrgbrrgrgurubrwuubuuggubgbrgbr\n" +
                "wurrrrgurubuwrgwbwgguwrrrwgrbwruugggbuggrr\n" +
                "brruugbwurgrbbruurbggrwuubuwrgugwggurbwbwwggbwu\n" +
                "rgwbrwbbrwuwuuurwugrugbrwwrggrrubuuwguugwg\n" +
                "wwbgbgwwgwrubrwbrbwrgrgguwwguurggbrbgbbgbrwrr\n" +
                "ruwuuwwugrgrgurwurwgbguwgbugbgrbbrrbuwrrbwwbrg\n" +
                "bbubwwbwuwgurwrbbbbburrgruwbgubgrbgrrwuuwrrwg\n" +
                "wburgbgrwgwubwrwwbwwbggbwgrbubwwwwgbrwrrwwbbbgbgbuwgrwbggu\n" +
                "rwubrrrrgugbugbrbwugwbbwbubgbrbguggbguurbbwurruuwrbbruubrg\n" +
                "bwgbwuuggggguuwuguuugbrwgguubrggrgbbrrbbgww\n" +
                "urbwrwbgwbwruwbguugwbugwwrwubbbbgwrwrugrgbbrug\n" +
                "gubguwgwbubwwwurbrgbbuugrwgwwggwubrgwrruurwggrrgrwbuw\n" +
                "guwuwbwgrgrrwrrbrbburgrbuugrgggwgbggbgbguw\n" +
                "grruurwurububbgugbwgwuggrgburruurururburugrrrubbbrg\n" +
                "wgbbuwuwwwbggwwurbgwgrrbubgwwwruuururwuwubbgwbrwubrurubgb\n" +
                "bggrbbrubwguuguwburggggrgbgugrrrgwuwbugrbbgrurbguggwwwgww\n" +
                "wrruggrwuwubwubrbbwbwrguwuugurrbgubrbugrrbwbubguuwwbrg\n" +
                "wuuubuwuuuurugwwbuwubwwbwugrgbubbwuurgwbbgwwbuwwwwubuu\n" +
                "uguwwwbgwuurrwwgguwwugwubrrbgubgwrgwgbbbgrwgbrgr\n" +
                "rwguwuubrwuwrrbbbuuwwubggbwuurubwbbubrbrgrwbgugwbrwrurrb\n" +
                "uwwugbbgubbrrbwbwrgwwwgwgbrrbbrbugwwgwrbggwrwugbbbuug\n" +
                "ugrbgrrrbrbwbguwgbwuugrgburwbwrgbwbrbbubuwubwrwwuwr\n" +
                "wwubwgwbruwrubrbgruwrgwwbwbgwrwubbwwwruruubbrwubbr\n" +
                "gurrubrgguwbgubbrrgbwwggbuwwgbgubwrwugbgbrwbwgggrbrwbbgrwbrg\n" +
                "guwgwgurruwuruwbwubguwgwgrguggguggrubruwrbbbbgu\n" +
                "ggrwrgubuwrruurgwbrugwgwwwrgwwrgurggugbrggrbuu\n" +
                "ggggugbbrgwwgguburrggbwburbrgrgbrurgggwrwbugwgwurur\n" +
                "bbgbbgbrgwrrugbbwrwbrrrwwwrrrubbbbgrgwbbur\n" +
                "ubwrbwgubbbbuwrbbwbwrwrbruuwuwrrrbwwuwbgrwbww\n" +
                "gwwbguuubrbuwrugguuwwbwruuugwrugwguwbuwrgubbbwgbrr\n" +
                "rgubrwwuurwgrugbgbgrbugwrwgbwrwgbbuuuwrwrrbugrwuwrgrg\n" +
                "grwbrwwwbuuwrrrrwbggrrruuruwwwwruwgggwrrgr\n" +
                "bbbrburwguubbbrbgwbwwwwbbbwbrggggurbwruwbrwgbuggbbbbrgrrg\n" +
                "rwwggwurbwgbwgubgbbrwuurwwurwburrburgwugbwwgwgugbubw\n" +
                "bwrugburwrruwrrwwbrrwwuwurwrrwbubuwbuwwbgwruwgbggbgug\n" +
                "bgggbrgugbrwuwubrggwrbggbururwgbwgwrurgrrbb\n" +
                "rwwgwrbwbubrrwbuubwuburrwrwrbrrugggwwrrubbubwgbbrgrbbwwr\n" +
                "uwwgrbwbrwrwgugbrwggwwbbwrgrgwrwwwguuubwuuuuururgbwbuuurgr\n" +
                "bgwbbrwwbbwburwgurguwrwuwguwuwuwwbgbbububwgwbbbrgu\n" +
                "ggbbubbrrwgurbrbubgbrrgbwruwguubrgrwgrrwgugwuuu\n" +
                "buuugggrurwgguwgwwbrbbrbgbbwrwggrubugbrgguuwuuuggwrwwurrw\n" +
                "ggggrwwwbgwbruwrgwgubbbubgubwrrrwwrrbbrruwgrg\n" +
                "wwbuwgbrgwgbgwggwwguuwwwguwurwggrurbrgbgwubuurr\n" +
                "rwrrgrugwbrgrrrwgbrurbbbrbwrbrrrbbbubrruwuwwgwwwrbg\n" +
                "bbwubbgguwwubururggrrbuwgrwwubbwuguggrbrugurbrrugu\n" +
                "rwgguwbgwrgurbubuggrruwbruuuurgrrrbwwurgggw\n" +
                "urwburbgurwurwrbbrrggguuggbrgrwuubbrgrwbrrgguggrbuu\n" +
                "bbwbbuubbuuubbrwbwuruubgbrgwbwrrbwwbwggrgwgru\n" +
                "wbbruwruguwwbrbgububguuurgbgbrbwgbgubbwbwgugrwrrgwurwguggb\n" +
                "wbrruubbguubgguguguuggwubuuubuugwwrugugubrggbrg\n" +
                "uuggwwuggrwwwrgbrgwbgbrrurwbrbuurbbgwbrg\n" +
                "wuggruwwgrrgurwrrgwgrbwgbbwgwgwugwbrbggrbu\n" +
                "wbwrbbwwrbrbbwrwbuguuwbgbrwubuwurrbbbburwbubrrrwbwguggwbr\n" +
                "uwbbwgbrrguwgggbwbgrurwrbuugurgrbgubbbbwgrbrg\n" +
                "gggbuuruwrbgbruuburubbbgrrruwruwrbwwbwwuuuwwwguuguubrg\n" +
                "bugrbgwbrurrgbgwgwgbuwwgrrgrubrbwgbggwrbbbbbbwwbubbu\n" +
                "bwuwwrbuurgruwwrguubwwugrubguwuuburgbwuuuurwwgbrrg\n" +
                "uwgrruruuugrgggbrugubguwbuuugggbbubguuruwbgbbugrubbbwg\n" +
                "ubrgrubwwbuwbruggwgwrgrurwbbgwurbwwrrubrgwru\n" +
                "rwruwurwgubbwuwwgrbbgrbburwwrbwbgbrwrugrwgggwrbrugg\n" +
                "wbubbuubbbwgggrrgrruwgruwwbbgwgbwubbrgrbrurrbwrbugbu\n" +
                "gurubgrrrbwurbbuburwrrgwwrwwwuuwbbuwwbwbwuwrrwwr\n" +
                "guubgbbuwwgwugbwuwrbbuggubuwbbburgwwuwbggugrggwbg\n" +
                "wwwwbrugwggwgrugwgbrbrbburggbwgggwwgwwuwgrgubuguwbgbrgurbrg\n" +
                "bgurguuuwuwrwubwubbgurwbwgbwrwbgbubwrrgwbggwrurrurugruruw\n" +
                "ugguwwugbrgrguruurwrbugbrgrgrugrurugrgrwrgguuuuuwrrg\n" +
                "gbuwuwbrrbrbrgugugurwurwurugubrrgurwwuurrbbuuurru\n" +
                "gwbubwwwbwurrgwrburgrbbgugguugrburbwuugwrgwrrbbgrwbwwg\n" +
                "bbgrrrwbuuguwrubwurgguwururwwrrruwrwrruwgwrbrgwbrrburubrg\n" +
                "ggrbbbgrrgbrgrbubbwbruwurbrbgwbbbrugbrguwwbugbbgbwb\n" +
                "wuwwgggwbrguwwrgbururgrurbwbubwrgurwburbgwugrgwwbubwggurbrg\n" +
                "urwbwbgbwgwgubbgrwubwurruubrrwugrrubggbbwbrg\n" +
                "brbbbrwbrgbuwrwbruugrgbrubbwrrbwggbbbgruuu\n" +
                "wgbgrbrrwuwrwgbgrwgurrgwuuwrgrgrrggrbbrbugwwub\n" +
                "uuurwuwrruugwrruwbrbuwwwuugbwurwbuuurwbrwbgu\n" +
                "rbbguubbwgbwrrruuwbrbgububbggrububurgbgruubrg\n" +
                "wbgwurwurggggwuggbwuubbrrugbuguruwurgburrwur\n" +
                "uwgrrwuugurgbrgrgbgguubrurugwurggbgrwgruruw\n" +
                "ggbwwrwbgugbrgbbwgrwwwgwwuurgwurbwgrbbrg\n" +
                "grwbrubrugburbrubwuruwwrbwbwbwwruubugrbggrgw\n" +
                "rwugurgruwwuuubgwgggwrbwuuguwbbgwrwbugwwubbgwwbrg\n" +
                "ububuwwrwgbuwrgbuurubgrwbuububugrbgrbwububuuw\n" +
                "rbbbrurrgbbwwwwrrruugwggubuuwuuwrggbbuggrrbwwgrurrbuwwbrg\n" +
                "burrbburrbugrggugbrwuubuuruugbgbrrbgbbbbbrg\n" +
                "bggwubbbrrwwurbbrbwbbbgwbgrurbwrugwwwuwbrrgbwrwwgg\n" +
                "grubggggrubbwbrwuubwbbuwrgrwgurbuwruwurwgwgwug\n" +
                "bgbbrgwugrwggbgbuuuguuwggugrurbrggwrruruggg\n" +
                "urwuurwurbburruwubwwuubbwwbrbrruwrggbbbbbrggbgggruwgg\n" +
                "ubbubwurbguburwwgbwuwgwgwuggwbrguwrugrgrgbgrwgu\n" +
                "brubwwurubrbrrgbrubrburbbruwwwggbwwgbgbubbbguruwugbw\n" +
                "ububugurrgrbwbggwrgrrbwbwuubwrbwgubwbgwwuubugurwgwuwrrwbr\n" +
                "wgbrwugwuurbwrbrbbwgrrruwguguuwrruurwuguurrrgwwburwburrgu\n" +
                "wgruwgrbuwrwgwrguwrubgrruwrrrwuggrubbwwubwbbrg\n" +
                "burugrbrubbrwuubgwgggruuugburrbrgwrwwbrg\n" +
                "bbwbuggwbggurrgrggurrbgwrbwuuruuwrrbgwgbbrubuugwugwwbrgr\n" +
                "wgruwgwgbbwwgwugruwuburbwrurgrugguwwrbrg\n" +
                "gwuurggbbuuwrbbugguggugbbrbgwurbbwbguugrrburbrg\n" +
                "wubwuwwwwburbruubrubwugurgbuwuwurggwrrgbrwuu\n" +
                "bgrbgburrrgrwbbbbruwbbuuwwbguugbbgugburrwgwurburbuu\n" +
                "wwrrgwwrwguubuwwggwrwggwwwuubwrburggbrwbrwgur\n" +
                "buuuwguugwbgwwrgrubrgbgbwwrwuubrgrbbguurrbrggggbbugwu\n" +
                "wrrbwgwrwwuwguurruuubgwgrbrrrbburuugwwwbbrur\n" +
                "uubbbrbgurbuwwbwggubrurububrbrrgggguwrgggbr\n" +
                "rgbrwwugrrggbrwbgrbwrgrugbgruubgwbuwbbrg\n" +
                "wwwbuwbbbwgurrwgwrugggwwrgrgubbuwurwrgbwubrg\n" +
                "rbrbubuugggwbbwrggwbwwbuwuuurgbbwwrguurbburwgugrguuwwgubbrg\n" +
                "rburruwwbgbbubgwwrwrwgbburrwgrgbruwbggugrbrwgb\n" +
                "grwbgurgggggrwrwrwguggbwwwwbbbbggubbggubbwwubgrgrbbbrg\n" +
                "gugwrbrugurwwruwuguwbrbugguubuugguwrwubwwg\n" +
                "bubgwrrurgbbbgbgbgwgwuugbubwbgwgbrbuwwrwrg\n" +
                "wugbgrggurbgruwuwwruruguuugbgwbgwwwbuuburuugubguwurubrg\n" +
                "wbuuwgwrugwbggrgbuwgrbrbrgwbrrubgbwbrwbrg\n" +
                "rbbgrwbwgwruuuwggrrggbwgbuubwbrrrrburwuggbgguurww\n" +
                "rurugrgggrbwbrububgwurgbwbbbbuwbbugwurbbgwbuwbrrbgrggubwu\n" +
                "wrgbgbubrbguuwgbrubwruwuurggurrwwbbbrbrrrwbur\n" +
                "rbubuwwrgwrurrwbuwgrrbrbubbrrrugburrbrgwwrwug\n" +
                "rggbbgbwbbuwbrrbrrrrrwbbwbuwbwugggwrubgwwbwbugbgbubrg\n" +
                "gbguugrrwwgugggurggrbgggrrburuwubbrrbrubrwrbwwrrugrgbugbug\n" +
                "rbrwuggurwggwbrguuwugwuwubwrrbgrrwrwruwgwrur\n" +
                "wuggbuguwrbubgurgbrgwrrbwbgrbbbgburrwguugrwwrrbrr\n" +
                "uwwbugbbgwugbgrrrgubrwuwwrwuurgbwrwuwrrggw\n" +
                "wrrugwwrbrwrubrrruuurgbguruubbruwgwrrwguugr\n" +
                "rwbwugrgrbbggruurbrrubgubwuguuugwugrbbrrbrguw\n" +
                "ggrrrwrwwbgrruubrrrgggbugwwbuwbbggbbruwrrr\n" +
                "wwgbwwururuurbrbgrwbuburwurrwruubuuwuwugbrgbwgggwuwguwg\n" +
                "bggruurubbrbbwgbubbruggwwrguuuggrggwgwrbbgbbg\n" +
                "rrbggwgwrugwbubrrgrwwgwurrgggbbrwuwuuuurbr\n" +
                "bgubggbggugwwbwwrbuuubgwggwbrggbugrrgrgwwrgwgbrgbugrgggwb\n" +
                "rwrrwubbubwbwbubbrgwwguuwgrruwbbgbrgwurrugw\n" +
                "rgwuurwgrrwgubuwrwwrrrwgubbggrwburgwburugrwruruwbrbrg\n" +
                "rwrwuwbrrrwrwuguguwwbuugrugguubgubrwbugwuugurrrrburgbb\n" +
                "gwguwbwwrubrrbggrguguwgrrggwbgubbwwbrugruwbgwbbrg\n" +
                "rgurbwrbburgguwggrwgrguwruurwrrbguugbwuuwgbwggwbb\n" +
                "wbbrrgwuuwwgwuwwuwubgwwgbgbrwwuugurwbburbbbggbgrrgrwuwr\n" +
                "rwggwbwurwwwwgwbbbbwwwwuuurbuubrbubggwwwbrwugbwgugbu\n" +
                "rbuwgugurbgwbrbrggwurrwgrggbrwurbguguwgbrrbr\n" +
                "rgbgwbwrwubwwrwbbwrgbbwwggbgbrrrrbwwbgurbbbrwwruwbwrbbuugu\n" +
                "bgrbubbbgbbrbuuguwwggggruwgrrwurrwrbgbgubggwwubbb\n" +
                "bbbrwruwbwbrbgwrbugbwrrrbubgurbbgbwggrrwbgwbrgbwbuuruwub\n" +
                "ugbwuuwwbbwrrgbguguuwbugbuwuuwgbwbrgubrrwuugbrurwwubrgwbwr\n" +
                "wuurbgguuubbubgbuwrrrwgburwurruwbgrwrubwgbwrruruuburrwbbw\n" +
                "urbugrgrugbbrurgrrbbuurbbbgrruwubugurbguug\n" +
                "bwrgrrbrbuuuwgbwgwrbubuwwuguwgwuugwgrugubgbr\n" +
                "buwwrwwwgbwwwuuuuubrbuwwrruuggwubrwuggwbubb\n" +
                "bbgwuwuwrgrgruguugbwwgrgggrgrwwbuugwrwbwbuur\n" +
                "rruguuububuurgwrwwbrguwrgrwuwbwgrrgwgrgggrwwbguubbggugg\n" +
                "rwgubrrrubuuuurwwugbrbuurgrugbgbbbrwbruubw\n" +
                "wgrbgrwuwrubuwwrgrbubgbwubugrwbgggwugbuubgu\n" +
                "rbgwbubwuubuugguugrrwrbubgrwguuubbwgrgbbuuwwbwbwwr\n" +
                "wguuwrgwwbrgbgwwrwgwwwrrbbgrbwuwwgruubruuubwbrgug\n" +
                "rwwwwugwwbwubgugbbbggbwgbwbbrwwwwbbgwuuuwbrg\n" +
                "urwruwuwgbgbgrrgbwgwrgrbrgbgrwgburrbrwuwurrgwurbwwrgu\n" +
                "rubgrrrggbbugggwrrgrrubwbbbbbbrgurbgbwbbrgrwububgwgwgbg\n" +
                "urwwgbwubgrrgbwugrwuggggwgruwbwbwbrwrurugrwbbubrwubugwugwb\n" +
                "rbrburbrwugubugwgrrbgurwbbrrggubwrgrgbrgbrbw\n" +
                "wuwrggwbrrwuwbwgwbbbgrguwgubuwrwurrgrwbwwguwubbuubbrg\n" +
                "gwrrguwwuuuwgggbuburbugggrbbwgbbwuguruguwruwburb\n" +
                "wbgwurgwwbgbrruwurwgurruwrrwuurgbwbwuuwwgrgwrwgbrbubuw\n" +
                "brwwruwrwgbwwrbgrrbwruwgbrgbruuwbgrgrgrrbrg\n" +
                "wwbguwbwwrbgrrbbwuggrburbrururrugwrugbuwgrbgwbwwruuruurww\n" +
                "ggurruuuwugubugbwbgbwgbrrwbrbgrwubrurwurrwurwbwww\n" +
                "ruubgbrwgbbbwgugwbggwwwgwgurubuwbwwrwrgrwuuwuug\n" +
                "ububgwwgwuwrurwwwgrwruruurbwwbwwbuwurwwuwubugrru\n" +
                "rbuuruwugbrrubgrbrwwbrugbwbwggbbrwuggbuuuuwrbwrrgwbgww\n" +
                "wbbbuuuuugubgwbgrbbrrrbuuugwwurwugwgruwrbrg\n" +
                "wuuubrbruurruwwurbgbwwwwgbrbuuuubuwgrbbguugbbb\n" +
                "rubgrrwbuwbguwruuwbuwuwgrbbgggwuugrwwuwbwrwuggwbbgugwwug\n" +
                "gbbrurrgbguuuwgrbgugbgbgrrrrggbrgbgguwgrwbwugwr\n" +
                "gubrbbrguuuwwwwguwrwbbrrgrbbgubwrrwbwurrwgugwgbgbrbbub\n" +
                "uwwuwrrwurubbbwwgwugrgrggubrgbwrwgruuubrbbwuggbwwuwwuwwbrg\n" +
                "rubguuwggguwbwguwbrbwguggrbwbugrrgwbrgwgwgwrrbwbrww\n" +
                "rrbuugrgruugrwbrrugrwwruwwbwubrgrbbgurgurwgbu\n" +
                "bgwbuugwuwbwbbrwubgwrgbuubwruggugburrbbuwwwwrbrg\n" +
                "gwgbuwgggrggwbgrburrrgbbwugbgggrrrbgwbwugubwggwuruggrbrg\n" +
                "urbrbgubggwggrguburrrbruwrrwburwbwgwugruggurgwggwruurg\n" +
                "wgbbgwgubrbuubuwwggururbgubwrbrgrgruurbggbbbwug\n" +
                "ggrbwubwuubbrbrbwrwurrrwbubbbgwrbbguwwwurbrg\n" +
                "wwbgrggrugubwuuurrbguwrrgrbrgrugguggrubrbrbrubuwbrbbrg\n" +
                "rruuwuwbuuwbwrrrruwgguurgurrwgbgrubwrgbuwgrgwwwwbrg\n" +
                "bbrrrwgbubrbrgubwgbwrrgbgwrwbrrrugrbuubuwruwrguww\n" +
                "rwuwbwwrbbwbbggrugbgbubububrgurgugwggubwrgb\n" +
                "guwbuggbbwrrubuwrbrurrgbguuguwrgbrbbubburwrguubwwuggwwggb\n" +
                "wbguwbrbggwruwgugbrbrgubbrwurbbgburrwwwbbbgrbuggwubww\n" +
                "grrwrwuwbrruggwwbburuwwrrbgbwrwugggrugrwbgwbrbuguwruurbrg\n" +
                "rugrguurwrrgubruuuguwwurbgugrwgbwubwurgguguururrbrrggrrwrb\n" +
                "urbwgurwugbuubrwbwbbgubrbbbrrrwurwwrrugwbrrbugggwrrbbrb\n" +
                "gwbruurbrugwwgguugbggbugbgwguwgggruugggbbubbuwgrrgwubbrbrg\n" +
                "wggurbrgrgruguwubbwwwwguggbggggrrgrurubugugbugbrgruwgw\n" +
                "urbuwbrwuubwrwrwuruwggwubuuubburrbbgrwwwrurgbb\n" +
                "wubwuwbrurbrrrrbuuwwuugububwgubrrggggrrrguwrgggrgwrwrbr\n" +
                "wbbwwwubgbbggbbburrguwwrwbwbbgguuuubbggruuwwgur\n" +
                "wbwwwrgurwurrgwwgbwgrgrrugwrguugwuruuwgurgbwr\n" +
                "wwgururrgrwrruguwgwubwuwbuuruuwrgugbwbwggg\n" +
                "wbrggburuwubwrgrugwuubwbrwbwrgurwbrgruwgbubgwg\n" +
                "gwguggwrbrbrugwgggbwubggububugrrbugrrrggguruuubugrwwbw\n" +
                "rwgrbggbrrgbuwbrwwubgbwbrbuwuwwuwrgbrrgbwuurgrrbgwwubrbbrg\n" +
                "gurbwburgrbgbgrruurguuugububuwgguwbwwgwwbwwurbbrrwwgggr\n" +
                "gwrrwrgwrwbgwurburrrwwwwrrrugrugwrgbgwrrrrgwbgrur\n" +
                "urwugwruwgggrbbrrbgguwrwgubrguwugrugrwuuuuuubbguggg\n" +
                "gbgruwwbgggbruggrburrgbrwggrbgbwurgrguuubbbugbubrwrgbuwur\n" +
                "brbbbrbgwbwwbubbbbbgurbuwwrbgwurugbrbgbwuwwgwgbugbr\n" +
                "gwuuugwrwuguburgbwubuwrrugbbrbgwwgrugbwbrg\n" +
                "wwbggwugggbwugubuwwgggrruuwwbrgurbrwuwrwwbwrgubguubbwwuug\n" +
                "rruuggbbbwrwubgbrgwgubwrrwwrrbgururguguuuwrugbwgrbbbuwbwug\n" +
                "wwgwbgrrbugubgurgrubbrgwruurrgbrbrwgrwbrggrruwbrww\n" +
                "buubrwrguruugrrbgguwugwugrruuggbgbwrrbruwuwbggbgur\n" +
                "rwbuwubrbwbwrgwurrrwrrugrurwrbrrbbbguwrwbw\n" +
                "urwrgugggbgruugwbgwuubbruwuurubwggubgbugwbu\n" +
                "gguwrwuruugburrgrwgubrgggrrbgbwruwbrgbggwuuuwubrb\n" +
                "ubwbgbguwuuwwubwrbbgrrrubgbubrbguwbuurguwrwruguwrb\n" +
                "ugrbrwwgbrbuwbrubwggwrwbgwwbuuurugbugwbgubuggwwguwrrruwrbrg\n" +
                "ubruubgurwuwuugurrugwwbrrgubbwwrwrwwgrbgubbbuugburrwgb\n" +
                "wbbugwbwwwuwbwwrbuwwurugwbrguguwggbggurrrwwwbrg\n" +
                "rugguuguwuubgugwggurwgbbbbgwwwggwuuururbruug\n" +
                "rwuugggbugurwubrggubrbwgrbrgwbgwurbubwwurrg\n" +
                "rbguuwbbwrgbruururuurrugwuurubbrwwbwrbuwwr\n" +
                "buuruuurrwgrbbggwgwbuwrugburgbwwrururgggbwgbgr\n" +
                "wguwwrubgrbwurgwgwwrwwwrrrrwwwrggrguurrbbuwubbrguwgubggr\n" +
                "rruruuggbrbbwwwwrbgrgrubbbgwgwrgrrgrrrgurgbwb\n" +
                "bgwgbwbuubwgwwbrggwwbrrugrwbgbrggwuuugbwrbrg\n" +
                "gbwrguwurwrggrgrwwbugbrgbrrrggbgbwrubwuurbgbgur\n" +
                "wbgwugwgurwrwbrbgbrrgbgbuwrrruwgbgugurwrwgwrrgwugu\n" +
                "ruuwbgwwgruguuubwggguuwwrrbburrwbwgbrgugwrugurugbwrguw\n" +
                "rbbbrgbrubggrwgbuuubrrurbwrbrwrguwgbguwuuubgrrurbgwgwugw\n" +
                "bbuuurbuuggwuwbrurggwgbgrrruburruwwrgwwuuuwgruggwgrwb\n" +
                "ruburbbgburuwgbwbgbbwbgwgbbrurbwgwrrwwgguwwuwuwbrbuurw\n" +
                "guwubrwbrgburuwrrrgbwrugurubwwurbbwrggbbbwrwwubbbrg\n" +
                "ugbwggbwrrbbgrrgwuggguuburbgwwugbwbrbwbbbgbgrwwb\n" +
                "buguuwggwwwwrwwrggruuwruurgbrgrrwurbrubgbrwwuurrr\n" +
                "urgbruurgbbbwrwwuggruugrbbbgguurgwbbgbggbu\n" +
                "bwwwrrrbwbururrbuwgrwgbwrgwbbwbgruugwugubrgggwrgbggggu\n" +
                "bguguuwuburuuwwwwubwubruubbggwgurgbgbbubbwuggb\n" +
                "gbgbwrrubgwugbbgburuwwugbrwbgrbbwbrbuubbbbuwbuwburw\n" +
                "buburwgguugbbwwwwgbrrrwgrbrrgbgugwwuuubuwggbbgu\n" +
                "wbwgbrwbgburwggbggrubgubggwbgbrubbbrrubbugbrwgwgwbwguw\n" +
                "rubrrrrbbwugubgrwguuurwrwbwggrrurbrrbrbbwgguggr\n" +
                "uugrrwwwuwwwwgbuubrruwwrgwgwbrrrurrrbwguruurgb\n" +
                "ruuuwbbwbwbrrgrgbwuuguggwbbguuurwgbugrrbwgugwubbwuwrrb\n" +
                "wwrurgbrwrrbugwwrbugugbbubgbrwuubggguuwbww\n" +
                "uwuuwgurwugwrbrurbwbwrggrubrrugbwbgurgwrwgrwgbrrbubbrbgr\n" +
                "uuugwgwrbggrwgbwgwguguguwrurrwwrbrubguurgbb\n" +
                "rwbbwgbrggrwgrrguugwggwuwbwwggbuubbrgbubrg\n" +
                "brbwgwbwwgrrubguwuwuruuuubgrgburwrrbwgbwubrb\n" +
                "brwwrbgbwgguubbuwgwrrgrgbwrwgrwwbbwgbrrrbrggguuuggwguubug\n" +
                "ubbgrwwbbwruwbwgggrggwwgbrugwgwrwrugwwuuruguruggrrrubwrbg\n" +
                "gbwugbbuwurwguwgbbwwgggrubuuwgruuuuwwurbwbgrrwb\n" +
                "gwugrggugwrgwubrurwrwgubuggwbgwwwbbwggwuwugbwgggwbugurrg\n" +
                "rrbwggrggurugburgrbgbgwbgbguugwbwuwugrgguwwggrwrrg\n" +
                "wubwuggwbburwgbguugwwrbrrguguuwrugbbgguwbgwrg\n" +
                "uuubwggurugwrruuugrwgbrwbwgrrgugbrggrrwgrwrbbwgurrbururb\n" +
                "wgbgubbgwggubuggrwwwbrrugwguwrbguuuwurwbrb";
        day.runPart2(finalInput);
    }
}
