package com.stiksy.advent.days;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day12Tests {
    String myInput =
            "ABA\n" +
            "AAA";

    String input =
            "AAAA\n" +
            "BBCD\n" +
            "BBCC\n" +
            "EEEC";

    String input2 =
            "OOOOO\n" +
            "OXOXO\n" +
            "OOOOO\n" +
            "OXOXO\n" +
            "OOOOO";

    String input3 =
            "RRRRIICCFF\n" +
            "RRRRIICCCF\n" +
            "VVRRRCCFFF\n" +
            "VVRCCCJFFF\n" +
            "VVVVCJJCFE\n" +
            "VVIVCCJJEE\n" +
            "VVIIICJJEE\n" +
            "MIIIIIJJEE\n" +
            "MIIISIJEEE\n" +
            "MMMISSJEEE";

    String inputEShape =
            "EEEEE\n" +
            "EXXXX\n" +
            "EEEEE\n" +
            "EXXXX\n" +
            "EEEEE";

    String inputABBA =
            "AAAAAA\n" +
            "AAABBA\n" +
            "AAABBA\n" +
            "ABBAAA\n" +
            "ABBAAA\n" +
            "AAAAAA";

    String finalInput = "QQQQQQCCCCCCCCCCCCXXXXXXXXXXXXXXUUUUUUJEEJJJJJQQQQIIISSVVVVVVVVVMMMMMMMMMMMMMMMMMMVVVVVWWWWFFFFFFFFFFFFAFZZZZZZZZZZZMMMMMMMMMMMMMMMMMMVMMQQQ\n" +
            "QQQQQCCCCCCCCCCCCCCCCXXXXXXXXXXUUUUUUUJJJJJJJJIIIQIIIIVVVVVVVVVVMMMMMMFMMMMMMMMMMMMVVVWWWWWFFFFFFFFFFFFFFZZZZZZZZLLZMMMMMMMMMMMMMMMMMMMMQQQQ\n" +
            "QQQQQQCCCCCCCCCCCCCCCCCCCXXXXXXUUUUUUJJJJJJJJJIIIIIIIIIVVVVVVVVMMMFFFFFMMMMMMMMMMMWWWWWWWWFFFFFFFFFFFFFFFZZZZZZZZLLZMMMMMMMMMMMMMMMHMQQMQQQQ\n" +
            "QQQQQCCCCCCCCCCCCCCCCCCCXXXXXXXUUUUUUUJJJJJJJJIIIIIIIIIIVVVVVVVVMMMMFFFMMMMMMMMMMMWWFFWWWWFFFFFFFFFFFFFFFZZZZZZZZMMMMMMMMMMMMMMMHHMHQQQQQQQQ\n" +
            "QQQQQQCCCCCCCCCCCCCCCCCXXZXXXXXXUUUUUUJJJJJJJYIIIIIIIIIIVVVVVVVVVVVFFFBBBMMMMMMMMFFWFFWWWWFFFFFFFFFFFFZZZZZZZZZZZLLMMMMMMMMMHMMHHHHHQQQQQQQQ\n" +
            "QQQQQQCCCCCCCCCCCCCCCZZZZZXXXXXXXUUUUUJJJOJJJYIIIIIIIIIVVVVVVVVVVVBFFFBBBBMMMMMMFFFFFFWZWWWWFFFFFFFFFFZZZZZZZZZZLLMMMMMMMMHHHHHRHHHHHHQQQQQQ\n" +
            "QQQQQQCCCCCCCCCCCCCCCZZZZTTXXXUUUUUUUUUUUOJJJJIIIIIIIIIIVVVVVVVVVVBBFBBBBBMMMMMMFFFFZDZZZWWWFFFFFFFFFFZZZZZZZZZZLLMMMMMMMMMHHHHHHHHHHHQQQQQQ\n" +
            "QQQQQQCCCCCCCCCCCCCCZZZZPTTTXXXXXUXXUUUUUOOJUUUUUIIIIIIIVVVVVVVVVBBBBBBBBBBBMMMFFFFFZZZZWWWAAAFFFFFFFFZZZZZZZZZZZLMMMMMMMMMMMHHHHHHHHHQQQQQQ\n" +
            "QIIIIIICCIWCCCCCCCCZZTTTTTTTTXXXXXXXXUUUUOXJUXUUUIIIQQQQQQQVVVVVVBBBBBBBBBBBMFFFFFFFZZZZAAAAAFFFFFFFDZZZZZZZZLLLZLLLMMMMMMMMMHHHHHHJJQQQQQQQ\n" +
            "IIIIIIICCIIMMQCCCCZZTTTTTTTTXXXXRRXXXUUUGXXXXXUUUIIIQQQQQQQVVVVVVBBBBBBBABMBMFFEFFFFFZZZZAAAAFFFFFFFDAZZZAAAALLLLLLMMMMMMMMMHHHHHHHJJQQQQQQQ\n" +
            "IIIIIIIIIIIMMMCCCCTTTTTTTTTXXXXXRTRXXXRRRXXXKKUUUUIOQQQQQQQVVVVVBBBBBBBBBBMMMFFFFFFFZZZZZAAAAFFFFAAFFAZZAAAAALLLLLLLLLLMMMMMHRHHHHHHJJJQQQQE\n" +
            "IMIIIIIIIIINNNNNNNNTTTTTTTTTTXRRRRRRRRRRRXXXXKKUUKOOQQQQQQQTVVVVBBBBBBBBBMMMFFFFFFFFZZZZZZZAAAAAAAABAAAAAAAAALLLLLLLLLMMMMMRRRRHHHPIJJJJBBBE\n" +
            "GIIIIIIIIIINNNNNNNNTTTTTTTTTTXRRRRRRRRRRXXKXXKKUUKOOQQQQQQQTVVVBBBBBUUUUMMMMFFFFFFFFFZZZZFAAAAAAAAAAAAAAAAAAIILLLLLLLLFMMMMRRRRHHIIIJJJJBBBB\n" +
            "GIIIIIIIIIINNNNNNNNTTTTTTTTTXXRRRRRRRRRXXXKKKKKUUKOOQQQQQQQQQBBBBBBBUUUUMMMMFFFFFFFFFZZZFFFAAAAAAAAAAAAAAAAAAATLLLLLLLFMMMMRRRRIIIIIJJBJBBBB\n" +
            "GIIIIIIIIIINNNNNNNNTTTTTTTTYXYRRRRRRRRRRRRPKKKKKKKOOQQQQQQQQQBBBBUUBUUUVUMMMFFFFFFFFFZZHFAAAAAAAAAAAAAAAAAAAGTTTLLLLJLLJMRRRRRIIIIIIIBBBBBBB\n" +
            "GGGIIIIIIIINNNNNNNNNNNNNTTCYYYRRRRRRRRRRRRPKKKKKKKKKQQQQQQQQQBBUUUUUUUUUUMMMMFFSFFFFFFFFFAAAAAAAAAAAAAAAAAAAATTTLLLLJJLJRRRRRRIIIIIIIBBBBBBB\n" +
            "GGGIIBIIIIINNNNNNNNNNNNNTTCYYYYYRRRRRRRRRRKKKKKKKKKVQQQQQQQTUBBUVUUUUUUUUUUMMMFFFFFFFFFFFAAAAAAAAAAAAAAAAAAATTTTTTTJJJJJRRRRRRRPIIIIIBBBBBBB\n" +
            "GGGGGGIIIKINNNNNNNNNNNNNTTCYYYYYRRRRRRRRRKKKKKKKKKKKQQQQQQQFFFFFFFFFFUUUUJUFFFFFFXXFFFFFFAAAAAAAAAAAAAVAEACATTTTTTTTTJJRRRRRRRRPIIZZIBBBBBBB\n" +
            "GGGGGGIIKKKNNNNNNNNNNNNNTTTYYYYYRRRRRRRRHKKKKKKKKKKKQQQQQQQFFFFFFFFFFUQUUUGGPGFFFFXFFFAFAAAAAAAAAAAAAAAAERCTTTTTTTTTVVVNNNRRRRRPIIZLLPBWBBBB\n" +
            "GGGGGGGKKKKKPPNNNNNNNNNNPPPPPPYYRRRRRRRHHHKKKKKKKKKKTTTTTTTFFFFFFFFFFUUUUHGGGGFXFXXFFFAAAAAAAAAAAAAAAAAARRRTTTSVTTTVVVVNNNNNRRRRNILLLLWWBBBB\n" +
            "GGGGGGKKKKPPPPNNNNNNNNNNPFPPPPPPRRRRRRRRRRKKKKKKKKIIITTTTTTFFFFFFFFFFOUUHHGGGGFXXXXXFFFAAAAAAAAAAAAAAAARRRRTTAVVVVVVVBVVVNNNNVVLLLLLLLWBBBBB\n" +
            "GGGGGIIIKKKKPPNNNNNNNNNNPPPPPPPPPJJJIRRIIIKKKKKKKIIIITTTTTTFFFFFFFFFFODUHHGGGGGXXXXXXRFAAAAAAAAAAAAAAARRRRROTTVVVVVVVVVHVNNVVVVVVLVVLBBBBBBB\n" +
            "GGGGGGIIIKIKPPNNNNNNNNNNPPPPPPPPPJJIIIIIIIIIGIIIKIIIIITTTTFFFFFFFFFFFYDYHGGGGGXXXXXXXXCAAAAAAAAAAAAAAARRRRRRRRRRVVVVVVVHVVVVVVVVVLVVRRBBBBBB\n" +
            "GGGGIIIIIIIKPPNNNNNNNNNNPPPPPPPPPPJIIIIIIIIIIJIIIIIIIIPTTTFFFFFFFFFFFYYYHGGGGGGGXGXXXXCAAAAAAAAAAAAAARRRRRRRRRRVVVVVVVVHYVVVVVVVVVVVRRBBBBBB\n" +
            "GGGHIIIIIIIIPPNNNNNNNNNNPPPPPPPPPPIIIPPPPPPIIJIIIIIIIIIIGTFFFFFFFFFFFYYBBBBGGGGGGGGGCCCCCACAAAAAAAAAARRRRRRRRRRVRRVVVVVHYYVVVVVVVVVVVRRBBBGB\n" +
            "GGGGFFIIIIIIZZNNNNNNNNZPPPPPPPPPPIIPIPPPPPPIIIIIIIIIIIIIITFFFFFFFFFFFYYBBBBGGBGGGGCCCCCCCCCAAAAAAAARRXRRRRRRRRRRRRVVVVVVWYVVVVVVVVVVRRRBBGGG\n" +
            "TGGGIIIIIIIIZYNNNNNNNNZPPPPPPPPPPIIPPPPPPPPIIIIIIIIIIIIIDDFFFFFFFFFFFHHBBBBJGBGGGGCCCCCCCCAAACCCADDRRRRRRRRRRRRRRRRVLYYYYYYYVVVVVVVVRRGGHGGG\n" +
            "GGGIIIIIIIIIIINNNNNNNNPPPPPPPPPPPIIPPPPPPPPIIIIIIIIIIIICCDFFFFFFDDHHHHHBBBBBBBGGGGGGCCCCCCCCCCICDDDRRRRRRRRRRRRRRRXVLLYYYYYYVVVVVVVVVGGGHGGG\n" +
            "GGGIIIDIDIIIIYNNNNNNNNPPPPPPPPPPPPIIIIPPPPPIIIIIIIIIICCCCCFFFFFFDDHHHHBBBBBBBBBGGGGGCCCCCCCJJCCDDDDRRRRRRRRRRRUUUUYYYYYYYYYYYMMVVVVVZZGGGGGG\n" +
            "DGGGDDDDDIIIYYYYYYPPPPPPPPPIPPPPPPPIIIPPXXPPPXIIIIIIIICCCCFFFFFFDDDHHBBBBBBBBBBGGGGGCCCCCJJJJCDDHHHJHNNRRQRRRSSUUUUSYYYYYYYYYYYAVVVVVZGGGGGG\n" +
            "DDDDDDDDDDDYYYYYYYYYPPPPPPPIIPPPIIIIIIXXXXXPXXIIIIICCCCCCVFFFFFFDDDDHBBBBBBBBBBBAAGGCAADDDDDDDDDHHHJHNHHRRRMMSSUUUSSYYYYYYYYYYYQVVXXGGGEGGGG\n" +
            "DDDDDDDDDDYYYYYYYYYPPPIPPIIIIIIIIIIIIIIIXXXPXXXBBXCCCCCCFTFFFFFFDDDDHDBBBBBBBBBAAAAAXAAAAAADDDHHHHHHHHHHHMMMSSSUSSSSYYYYYYYYYYYQQVQQQGGGGGGG\n" +
            "DDDDDDDDYYYYYYYYYYYPPPIIIIIIIIIIIIIIIXXXXXXPXXXXXXCJCCCFFFFFFFDDDDDDDDDBBBBBBBBAAAAAAAAAAAADDDDHHHHHHHHHHMMHDSSSSSSSYYYYYYYYYUYYQQQGGGGGGGGG\n" +
            "DDDDDEDDYYYSYYYYYYYYTYIIIIIIIIIIIIIIIXXXXXXXXXXXXCCJCCCCFFFFFFDDDDDDBBBBBBBBBBBAAAAAAAAAAAAAAHHHHHHHHHHHHHMHHSSSSSSSYYYYYYYYYYYLQQQGGGGGGGGG\n" +
            "DDDDEEDDYYYYYYYYYYYYTYIYIYIIIIIIIIIIIIXXXXXXXXXXYJCJCCFFFFFFFFFDDDDDZZBBBBBBBBBAAAAAAAAAAAAAAHHHHHHHHHHHHHHHJJIBSSSSSYYYCYYQQQFQQQQNGGGGGGGG\n" +
            "DDDEEEEEEEYWYYYYYYYYYYIYYYIIIIIIIIIIXXXXXXXXXXXXJJJJJJFFFFFFFFFDDDDDZZBBBBBBBBAAAAAAAAAAAAANHHHHHHHHHHIIHHHJJIIBSSQYYYYYYQYQXXQQQQAKKGKGGGGG\n" +
            "EEEEEEEEEEEWWYYYYYYYYYYYYYYYIIIIXIXXXXXXXXXXXXXXXJJJJFFFFFFFFFFDDDDDDZZBBBBBBBAAAAAAAAAAAAAATHHHHHHHHHIIIIIIIIIIIQQQQYYYYQQQXXXQQQKAKKKKKKGK\n" +
            "EEEEEEEEEEEWWYWYYYYYYYYYYYYYYYIIXXXXXXXXXXXXXXXXJJJJFFFFFFFFFFFDDDDZZZZZBBBBBBBBAAAAAAAAAAAAAAHHHHHHHIIIIIIIIIIIIIQQQQQYYQQQQXQQQQKKKKKKKKKK\n" +
            "EEEEEEEEEEWWWWWYYDYYYYYYYYYYYYYIIXXXXXXXXXXXKKKJJJJJFFFFFFFFFFFFDDDDDZZZZZZZBBBBAAAAAAAAAAAAAEMHHHHHHIIIIIIIIIIIIIQQQQQQQQQQQQQQQQQQKKKKKKKK\n" +
            "EEEEEEEWWWWWWWWWWYYYYYYYYYYYYYYYIXNNNNXXXXXXXXJJJJJJJFFFFFFFFFFFFDDTZZZZZZBBBBBBAAJAAAAAAAAMMLLLLLLLLIIIXIIIIIIIIIQQQQQQQQQQQQQQQQQQKKKKKKKK\n" +
            "EEEEEEKKWWWWWWWWWYYYYYYYYYYYYYYVAZXXXXXXXXXXXXJJJJJJJFFFFFFFFFFFWDDDZZZZZZBBBBBBAPJJAAAAAAAAMLLLLLLLLIIIIIIIIIIIIIIQQQQQQQQQQQQQQQKKKKKKKKKK\n" +
            "EEEEKKKKKKKKWWWWTJYTYYYYYYYAYYAAAAFFVVVXXXXXXXXXJJJJJJFFFFFJFFBFGGGGDDZZZBBBBBBNPPPAARRRRMAMLLLLLLLLLIIIIIIIIIIIIIQQQQQQQQQQQQQQQQMMMKMBKKKB\n" +
            "EEEKKKKKKKKKWWWTTTTTTTYYYAYAAAAAAAAAVVVXXXXXXXJJJJJJJJJFFFFJJFBBGGGGGGGGGGZBBBBPPPPPARRRRMMMLLLLLLLLIIIIIKKKKKKKKKKKKQQQQQPQQQMQMQIMMKMBBBBB\n" +
            "GKKKKKKKKKKWWTTTTTTTTTYAYAAABAAAAAAAVVVVVXXVVBBJJJCCCJJJFFJJJMBBGGGGGGGGGGZBBBBPPPPPPRRRRMMMLLLLLLLLIIWIVKKKKKKKKKKKKQQQQPPQQQMQMMMMMMMBBBBB\n" +
            "GKKKKKKKKKKWWTTTTTTRTTYAAAAAAAAAAAAAVVVVVVVVVVJJJCCCCCJJJJJJJMMMGGGGGGGGGGBBBBBPPPPPJRRRRLRRRRRRRRLLMMIIIKKKKKKKKKKKKQQPQPNNNQMMMMMMMMMCBBBB\n" +
            "KKKKKKKKKKKKKETTTTTTTTAAAAAAAAAAAAAAAVVVVVVVVNCLJCCCCCJJJJJJJMMMGGGGGGGGGGBBBPBPPPPPJRRRRMRRRRRRRRLLVMMMVKKKKKKKKKKICCCPPPNNNQMMMMMMWWMMMMBB\n" +
            "KKKKKKKKKKKKKEETTTXXTAAAAAAAAAAAAAAAAVVVVVVVVLCCCCCCCJJJJJJJJJMGGGGGGGGGGGBBBPPPPPPPPRRRRRRRRRRRRRLLVVVVVKKKKKKKKKKCCCPPPPPNNNMMMMMMMMMMMMBB\n" +
            "KKKKKKKKKKKKKEEEEMXXXAAAAAAAAAAAAAAMAVVVVVVVLLLLLCCCCJJJJJJJJJMGGGGGGGGGGBBBBPPPPPPPPRRRRRRRRRRRRRLLVVVVVKKKKKKKKKKCCCPPPPPPNUMMMMMMMMMBBBBB\n" +
            "KKKKKKKKKKKKEEEEMMMMXXAAAAAAAAAAAAAAVVVVVVVVLLLCCCCCCJJJJJJJJJJGGGGGGGGGGBBBBPPPPPPPPRRRRRRRRRRRRRLVVVVVVKKKKKKKKKKCCPPPPPPPCMMMMMMMMMMMBBBB\n" +
            "KKKKKKKKYKKKKKKKKMMMMXAAQAAAAAAAAAAAVVVVVVVVLLGGCCCCCJJJJJJJJJJGGGGGGGGGGBBBBBPPPPPPPRRRRJRRRRRRRRLVVVVVVKKKKKKKKKKCCPPPPPMMMMMMMMMMMMMMBBBB\n" +
            "KKKKKKKKKKKKKKKKMMMMKMMQQQAAAAAAAAAAAVVVVVVVVVCCCCCCCJJJJJJJJJJGGGGGGGGGGUBBBPPPPPPPPRRRRJJJMLLLLLLVVVVVVKKKKKKKKKKPPPPPPPPPMMMMMMMMMMMMBBBB\n" +
            "ZKKKTTKKMMKKMMMMMMMMMMMMQQQAQAAAAAAAVVVVVVVVVVCCCCCJJJJJJJJJJJJGGGGGGGGGGUBBBBPPPPPAPPJJJJJJJJVVVZVVVVVVVKKKKKKKKKKKKKKKPPPPPMMMMMMMMMMMMBBB\n" +
            "ZZZTTTKKMMMMMMMMMMMMMMMMMQQQQAAAAAAVVVVVVVVVVCCCCCCJJJJJJJJJJJYGGGGGGGGGGUUBPPPPPPPPEJJJJJJJJJVZZZVVVVVVVVWWKKKKKKKKKKKKPPPPPAAMMMMMMMBMMBBB\n" +
            "ZZZTTTTMMMMMMMMTTTTMMMMQQQQQQAAAAOAAVVVVVVVVVXCKCCCCJJJJJJJJJJYGGGGGGGGGGBBBPPPPPJJJJJJJJJJJJZZZZZZVVVVVVVWWKKKKKKKKKKKKPPPQPAAMMMCMMMBMBBBB\n" +
            "ZZZTZTTMMMMMMMMTTTTMQQMQQRRQQQQAOOOOVVVVVVVVVXVVCCCCCJJJJJJJJJUUUUUUUUUUUBBBBBBBBBBJJJJJJJJJJZZZZZZVVZZZZWWWKKKKKKCCCCPMPPPAPPAAMMCMBMBBBBBB\n" +
            "ZZZZZZTMMMMMMMMTTTTTQQQQQRRQQQQOOOOOOOVOVVVVVVVVGGCCJJJJJJJJJJUUUUUUUUUUUBBBBBBBBBJJJJJJJJJJZZZZZZZZVZZZZZWWKKKKKKBCCCCPPPLAAAAAAABBBBBBBBBB\n" +
            "ZZZZZZZCCMMMMMMTTTTTQQQQQRRQROOOOOOOOOVOVVIIIVRVGGJJJJJJJJJUUVUUUUUUUUUUUUUBBBBBBBBBJDDJJJJJJZZZZZZZZZZZZZZWKKKKKKBBBCPPPPAAAAAAABBBBBBBBBBB\n" +
            "ZZZZZZCCCMMMMMTTTTTTQQQQQRQQRRROOOOOOOOOVVIIIVIGGJJJJJJJJJUUUUUUUUUUUUUUUBBBBBBBBBBJJJJJJJKKJJZZZZZZZZZZZZZWKKKKKKBBBKPKNKAAAAAAABBBBBBBBBBB\n" +
            "ZZZAZZCCCCMMMDTTTTTQQQQQQQRRRRROOOOOOOOOOIIIIIIGGGJJJJJJJJJUUUUUUUUUUUUUVVVVVVVVVBRJJJJJJJKIIIIIIIIIZZZZZWWWKKKKKKBBFKKKKKAAAAAAAABBAABBBBBB\n" +
            "ZZZAZZCCCCCMMDDKTTTQQQQQRRRRRROOOOOOOOOOOOIIIIIGAAJJJJJJJJJUUUUUUUUUVVYVVVVVVVVVVBRRJJJJJUUIIIIIIIIIZZZZZZWWKKKKKKBBBKKKIIIAAAAAAAAAAAAABBBB\n" +
            "ZAAAZZCCCMMMMDTTTTTQQQQQRRRRRRSOOOOOOOOOGOIIIIIAAAAJJJJJJJJMMMUUJUUXVVVVVVVVVVVVVBRRJJJZIIIIIIIIIIIIZZZZZZWWKKKKKKBBKKIIIIHHHZAAAAAAAAAABBBB\n" +
            "AAAROZOMMMMDDDGGTTTTQQRRRRRKRMOOOOOOOOOOOOIIAAAPAAAAAAAJJJJMVVVVVUUUVVVVVVVVVVVVVVRRRPJZIIIIIIIIIIIIZZZZZZWWWWWWWBBBKKKIHHHHHZAAAAAAAAAAAABB\n" +
            "AAOOOOOOMMDDDDDTTTTTQQRTRYRKROOOOOOOOOOOOOIIIAAAAAAAAAJJJJJVVVVVCCCCCVVVVVVVVVVVVVRRPPJZIIIIIIIIIIIIZZZZZWWWWWTWWWWBAAAHHHHHHHHHHAAAAAAAAABB\n" +
            "AAOOOOOODDDDDDQQTTTQQQRYYYRRYYOOOOOOOOOOOIIIIIAAAAAAAAAJJJVVVVVCCCCCCVVVVVVVVVVVVVVVVVWUIIIIIIIIIIIIZZZZZWWWWWTTWWWBBAAHHHHHHHHHMARAAAAOAAOC\n" +
            "AAAOOOOODDDDDDDQQTTQQQQYYYYYYYYOOOOOOOZOOIIIIAAAAAAAAAJJJJJVVVVCVCCCCVVVVVVVVVVVVVVVPUWUIIIIIIIIIIIIZZZZZWWWWZZZZZZZZHAHHHHHHHHHHAAOOOOOOOOC\n" +
            "AAAAAOJJDJDDDDDQQQQQQQQQYYOYYYYYYOOOOZZOZIIIIAAAAAAAAAJJJJJVVVVVVCCCCVVVVVVVVVVVVVVVNUUUIIIIIIIIIUGGZZZZWWWWWZZZZZZZZHHHHHHHHHHHMCOOOOOOOOOO\n" +
            "AAAAAAAJJJJDDDQQQQQQQQQQQYOYYYYYYYDOOZZOZIIIIAAAAAAAAAJJJJJJJVVVVVCCCCVVVVVVVVVVVVVVNNFUIIIIIIIIIUZZZZZZZTTWWZZZZZZZZHHHHHHHHHHHHCOOOOOOOOOO\n" +
            "AAAAAAAAJJDDDDDQQQQQQQQQQOOOWOOOODDOZZZZZZIIAAAAAAAAAAJJJJJJJVJVVDDDCCCVVVVVVVVVVVVNNNNUIIIIIIIIIUUUZZZZZPTTWTTTTWWHHHHHHHHHHHHHCCCCOOOOOOOO\n" +
            "AAAAAAAAAJJJDDQQQQQQQQQQOOOOOOODDDDZZZZZZZIIAAAAAAAAAAAJJJJJJJJJVDDDCCCCDKVVVVVVVVNNNNUUUUIIIIIIIUUUUZZZZTTTTITTTTWHHHHHHHHHHHHHCCCCCCCOOOOO\n" +
            "AAAAAAAAAAJBBQQBBBQQQQQOOOOOOOODZDDDZZZZZZIIAAAAAAAAAAAAJJJJJJJJDDDDDDDDDDDDVVVVVNNNNNNUUUIIIIIIIUUUUUZZZTTTTTTTTTHHHHHHHHHHHHHHCCCCCCCCOOOO\n" +
            "AAAAAAAAAAJBBBBBEBBBQQQOOOOOOOODZZZZZZZZZZZAAAAAAAAAAAAJJJJJJJJDDDDDDDDDDDDVVVVVNNNNNNNUUUIIIIIIIUUUUUUZTTTTTTTTTTTTHHRRHHHHHHHCCCCCCCOOOOOO\n" +
            "AAAAAAAAAAJBBBBBBBBBBOOOOOOOOOOOOOZZZZOZAAAAAAAAAAAAAAAAAJJJJJDDDDDDDDDDDDDVVVVVNNNNNNNNNNIIIIIIIUUUPPPKKKKTTTTTTTTTTHRRRHCCCHCCCCCCCCOOOOOO\n" +
            "AAAAAAAAAABBBBBBBBBBBOOOOOOOOOOOOOZZZZOZAOOAAAAAAAAGGGJJAJJJJJDDDDDDDDDDDDVVVVVVVVNNNNNNNNIIIIIIIUUPPPPKKKKTTTTTTTTTTTTRTTCCCFCCCCCCCCCOOOOO\n" +
            "AAAAPAAAAABBBBBBBBBBBYYOOOOOOOOOPOOOZOOOOOOOAAAAAAGGGGJJJJJJJDDDDDDDDDDDDDVVVVVVVVNNNNNXXNNNNNNNPPPPPPPKKKKTTTTTTTTTTTTTTCCCCCCCCCCCCCCCOOOO\n" +
            "AAAAPAAAAABBBABBBBBBBBYOOOOOOOOOOOOOOOOOOOAAAALALAGGGGGJJJJJDDDDDDDDDDDDDDDVVVVOOVVVXXXXXNNNNNNNPZZZZZZZZZZKTKTTKSTTNLLTTNCCCCCCCCCCCCCCCOOO\n" +
            "AAAAPPPAABBBBABBBBBBBBBBOOOOOOLLOOGGGOOOAAAAAALLLLLGGJJJJJJJDDDDDDDDDDDDDDDDVVOOOVVVWXXXXNNNNNNNPZZZZZZZZZZKKKKYYYYYYYYYYNNCCCCCCCCCCCCCCOOO\n" +
            "AAAAPPAAABBBBABBBBBBBBBBOOOOOOLOOOGGGOOOOAAAAAAALLLLJJJJJJJJJLLLDDDDDDDDDDDDDVOOOOVOWXXXXNNNNNPPPZZZZZZZZZZZZKKYYYYYYYYYYNNCCCCCCCCCBBCCOOOO\n" +
            "AAAPPPAPAAAABABBBBBBBBBPOXOOOOLOOOGGGOOOOOOAAAAALLLLLLJJJJJJJLLLLDDDDDDDDDOOOOOOOOOOWXXXXNNNNNNNPZZZZZZZZZZZZKAYYYYYYYYYYYYCCCCCCCXCBBCYOOOO\n" +
            "APPPPPPPPAAAAABBBBBBBBFZZXZZKKOOOOGGGOOOOOOAAAAALLLLZLJJJLJJJJLLLDDDDDDDDUUOOOOOOOOOOORRRRONOOPPPZZZZZZZZZZZZKAYYYYYYYYYYYYNCCUCCCCVBBCCPOHO\n" +
            "PPPPPPPPPAAAAAABBBBBBBBZZZZMOOOOOGGGGGOOOOOAAALLLLLLLLJJLLLLLLLLLLDDDDDDOOOOOOOOOOSOOOORDDOOOOPPMMMPPPPZZZZZZAAYYYYYYYYYYYYJMCCCCVVVBVPPPVVV\n" +
            "PPPPPPPPPAAAAAABBBBBBZBZZZZMMGGGGGGGGGGGGOOAZALLLLLLLLLLLLLLLLLLLLDDDDDOOOOOOOOOOOOOOOORDOOOOOPPMMMPPPPZZZZZZAAYYYYYYYYYYYYJMMMCCCVVVVVVVVVV\n" +
            "PPPPPPPPPAAAAAABBBBBBZZZZZZMMGGGGGGGGGGGGAAAZALLLZLLLLLLLLLLLLLLLLLDDDOOOOOOOOOOOOOOOOOOOOOOOOOPMMMPPPPPZZZZZAAYYYYYYYYYYYYJMJMMVVVVVVVVVVVV\n" +
            "XPPPPPPPAAAAAABBBTBBYZZZZZZZZYGGGGGGGGGGGGAAZZZLZZZLLLLBBBBLLLLLLLDDDDDOOOOOOOOOOOOOOOOOOOOOMMMMMMMPPPPPZZZZZAOYYYYYYYYYYYJJJJVVVVVVVVVVVVVV\n" +
            "XPPPPPPPAAJJAABAACBBYYZZZZYZYYGGGGGGGGGGGGAAZZZZZZLLBBBBBBBLLLLLBBBBBOOOOOOOOOOOOOOOOOOOOOOMMMMMMMMJJJPLZZZZZAZYYYYYYYYYYYJJJJJJBJVVVVVVVVVV\n" +
            "XPPPPPPPJJJJAAAACCYBYYZYYYYYYYYGGGGGGGGGGGAAZZZZZZZZBBBBBBBLLLLLBBBBBBBBOOOOOOOOOOOOOOOOOOOMMMMMMMMMJJZZZZZZZZZYYYYYYYYYYYJJJJJJJJBVVVVVVVVV\n" +
            "XPPXPPPPJJJJAAACCCYYYYZYHYHYYYHGGGGGGGGGGGAAAZZZZZZZBBBBBBBBBLLBBBBBBBBBOOOOOOOXOOOOOOOOOOOMMMMMMMMMJJZZZZZZZZZZOOOOJJJYYYJJJJJJVJBVVVVVVVVV\n" +
            "XXXPPPPJJJJJJAACCYYHYYYHHHHHHHHGGGGGGGGGGGEAEZZZZZZZBBUBBBBBBBBBIIIBBBBOOOOOOOOOOOOOOOOOOOOOMMMMMMMMJJZZZZZZZZZOOOOOOJJYYYJJJJJJJJVVVVVVVVVV\n" +
            "XXXPPPPPPJJJJPACCCHHHYHHHHHHHHHGGGGGGGGGGEEEEZZZZZZZZUUUUBBBUUBBBIIIBIBBBOOOOOOOOOOOOOOOOOOOMMMMMZZZZZZZZKKZZZZZOOOOCCYYYYYYJJJJJJVVVVVVVVVV\n" +
            "XXXXPPPPPJJJPPAAAAHHHHHHHHHHHHYYYGGGGGEEEEEEZZZZZZZZZZUUUUUUUBBBIIIIIIIBBBOOOOMMMOOOOOOOOOYOMMMMMZZZZZZZZKKZZZZZZZOCCCYYYYYYJJJJJJVVQQVQQVVV\n" +
            "XXXPPPPJJQJJPPPAAHHOHHHHHHHHHHYYYYEEWEEEEEEEEZZZZZZZZUUUUUUUUUUIIIIIIIIIBOOOOOMMMMOMOOSOOOOOOMMMMZZZZZZZZKKZZZZZZZCCCCYYYYYYJJJJJJJJOQQQVVVV\n" +
            "XXXXXPPJJJJPPPPRROOOHHHHHHHHYYYYYYYEEEEEEEEEEEEZZZZUUUUUUUUUUUIIIIIIIIIIMMOOOMMMMMOMNNNOOOONNNNJEZZZZZZZZKKZZZZZZZCCCCYYYYYYJJJJJJJXQQQQQQQQ\n" +
            "XXJXXJJJJJJPPPRRRROOHHHHHHHHYYYYEEEEEEEEEEEEEEEZZZZZUUUUUUIIIIIIIIIIIIBBMMOOMMMMMMMMNNNCNNNNNNJJFZZZZZZZZKKKZZZCCCCCCCYYYYYYJJJJJJJQQQQUQQQQ\n" +
            "XXJJJJJJJJJPPYPVRJJHHPHHHHHHYYYYEEEEEEEEEEEEEEZZZZZZUUUUUTTIIIIIIINIIBBIMMMMMMMMMMMMNNNNNNNNNNFFFKKKKKKKKKKKZZZCCCCCCCYYYYYYJJJJJJCQQQQQQQQQ\n" +
            "XXJJJJJJJJPPJPPPPPJJJPPPHHHHHYYYEEEEEEEEEEEEXPZZZZZZZZUUUTTINNNNINNKIBIIMMMMMMMMMMMMMNNNNNNNNFFFFFKKKKKKKKKKZZZCCCCCCCYYYYYYJJJJJQQQQQQQQQQQ\n" +
            "XJJJJJJJPPPPPPPPPPJJJHHHHHHDHDYYYYYEEEEEEEEXXXZGGZZZZZUUUNNNNNNNNNNIIIIIMMMMMMMMMMMMNNNNNNNNNFFFFKKKKKKKKKKKKKKCCCCCCCYYYYYYYYYZZQQQQQQQQQQQ\n" +
            "JJJJJJJPPPPPPPPPPJJJJJJJJHHDDDDYYYYYEEEEEEEXXGGGGEEZZZUUDNANNNNNNNAIIIIIMMMMMQMMMMMMNNNNNNNNFFFFFKKKKKKKKKKKKKKCCCCCCCYYYYYYYYYZQQQQQQQQQQQQ\n" +
            "JJJJJJJJPPPPPPPPPJJJJJJJJJDDDDDYYYYEEEEEEXXXXXGGGGEEEZEUDNNNNNNNNAAAIIIIMMMMQQQQMMNNNNNNNNNNFFFFFCKKKKKKKKKKKKKKWCCCCIYYYYYYYYYZZZXQXQQQQQQQ\n" +
            "JJJJJJPPPPPPPPPPPJJJJJJJJJDDDDDDDYYEEEEEEXXXXGGSEEEEEEEENNNNNNNNNVVAAIIMMMMQQQQQMMNNNNNNNNNNOFFFFFKKKKKKKKKKKUUKKUCCCCCCCZYYYYYZZZXXXXQQQQQQ\n" +
            "HJJJJJPPPPPPPPPPPPPJJJJJJJJDDDDDDYYYEEEEEXXXSSSSEEEEEEEENNNNNNNNNNVAAAVVMQQQQQQQMMNNNNNNNHNNNFFFFFKKKKKKKKKKKUUUUUCCUUUUCCYYYYYXXXXXXXQQQQQQ\n" +
            "HJJJJNPPPPPPPPPPFPPJJJJJJJJDDDDYYYYXXNNEXXXSSSSSEEEEEEENNNNNNNNNNVVVVAVVQQQQQQQQMNNNHHNNNHNNNFFFFFKKKKKKKKKKKUUUUUUUUUUUUUUUHZZZXXXXXQQQQQQQ\n" +
            "HHJVJRPPPPPPPPPPPPPPLJJJJJJDDDLLLLXXXXXEXXXXXXXSUUUUNNNNNNNNNNNNNVVVVVVVQQQQQQQQMMMNHHHNNHHHHHHHHFHHHKKKKKKKKUUUUUUUUUUUUUHHHHHXXXXXXXQQQQQQ\n" +
            "HRRRRRRPRPUPPPPPPPPLLLLJJJDDDLLLLUUUXXXXXXXXXXXXXXUUUUNNNNNNNNNNNVVVVVVVQQQQQQQQMMMMHHHHHHHHHHHHHHHHHKHHHKKKKUUUUUUUUUUUUHHHHHHHHXXXXXXXQQQQ\n" +
            "HHHHRRRRRRRRRRPPPPWLLLLLLLLLDLLLLUUUVVVXXXCCCXXXXXXXKNNNNNNNNNNNNVVFVVVTTQQQQQQTMMMHHHHHHHHHHHHHHHHHHHHHHHKKUUUUUUUUUUUUUUHHHHHXXXXXHQHXQQQQ\n" +
            "HRRRRRRRRRRRRRRPPBGLLLLLJLLLLLLLLULUVVVXXCCCCCXXXXXXKKNNNNNNNNNNVVVVTTTTTTTTQQQTTTMLLHHHHHHHHHHHHHQQQHHHHUKUUUUUUUUUUUUQUUHHHXXXXXXXHHHHQHAH\n" +
            "RRRRRRRRRRRRRRRRPPGLLLJJJLJLLLLLLLLUVVVXCCCCCCXXXXXKKKNNNNNNNNNNVVVVTTTTTTTTTTTTTMMLLHLHHHHHHHHHHHQQQQHHHUUUUUUUUUUUUUUQUQHSXXXXXXXXXXHHHHHH\n" +
            "RRRRRRRRRRRRRRRRRGGGLJJJJJJLLLLLLLVVVVVECCCCMMMMMMKKKKKKNNNNNNNNNVVTTTTTTTTTTTTTULLLLLLHHHHHHHHHQQQQQHHHUUUUUUUUUUUUUQQQQQQSXXXXXXXXXXXHHHHH\n" +
            "RRRRRRRRRRRRRRRRRGGGGJJJJJJLLLLLLJVVVVVVGCCCMMMMMMKKKKKNNSSNNNNNNVTTTTTTTTTTTTTULLLLLLHHHHGGGGGHHQQQHHHHHUUUUUUUUUUUUQQQQQQSSXXXXXXXXXHHHHHH\n" +
            "VRRRRRRRRRRRRRRRRGGGJJJJJJJLLLLLLJVVVVVVGCCCMMMMMMKKKKNNGSGNNNNNYYTTTTTTTTTTTTLLLLLLLLLHHHGGGGQQQQQQHQHHHUUUUUUUUUUUUQQQQQQQSXXXAXXXXXHHHHHH\n" +
            "VVVRTRRRRRRRRRRRJGGGGQJJJJJJJLLLGVVVVVVGGCCCMMMMMMKKGKGGGGGGGGYYYYDTDTTTTTTTTTLLLLLLLLLHHHGGGGQQQQQQQQHHOOOOUUOOUUUUUQQQQQQQQXUAAXXMHHHHHHHH\n" +
            "VRRRTTTTRFFRRJRRGGGGQQJUJJJJJJGLLGGGGVGGGGGCMMMMMMKKGGGGGGGFFFYYDDDDDDDDTTTTTTTLLLLLLLLLHHGGGGQQQQQQQQQOOOOOUUOOUOUZUQQQQPQQUUUTTTTTHHHHHHHH\n" +
            "VVRAAATTYTFRYDDFGDGGQQJJJJJJGGGGGGGGGGGGGTTTTTTTMMKZGGGGFGGFFFYYDDDDDDDCTTTTTTTLLLLLLLLHHGGGGGGQQQQQQQOOOOOOOUOOOOOUGUUQQQQQUUUTTWTTKKNNHHNN\n" +
            "VVUUATTTTTDDDDDDMDGGQQJJJJJJGDGGGGGGGGGGGTTTTTTTKKZZGIIIFFFFFFYDDDDDDDDDDDTTTTTLLLLLLLLGGGGGGGGQQQQQQQOOOOOOOOOOOOWUUUUUUUUUUUUUUUKKKKKNHNNN\n" +
            "UUUUTTTTTQDDDDDDMDDDQQQQJJJJGDGGGGGGGGGGGTTTTTTTKKZZZIIIIFFFFDDDDDDDDDDHHHHTTTHLLLLLLLLIIGGGGGGQQQQQQOOOOOOOOOOOOOWKWWUUUUUUUUUUUUNNNNNNNNNN\n" +
            "UUUUTTTTTTDDDDDDDDDDDQQJJJCCDDGGGGGGGGTTTTTTTTTTCZZZIIIIIIFFFFDDDDDDDEDHHHHTHHHHLLLLLLLLLGGGGGGQQQQOQOOOOOOOOWOOOWWWWUUUUUUUUUUUUGNNNNNNNNNN\n" +
            "UUUUUTBTTTDDDDDDDDDDDDQJJJCCDDDGGDGGDGTTTTTTTTTTZZTZZIFFIFFFFFFDDDDDDDHHHHHHHHHLLLLLLLLLLGGGGGGQQQQOOOOOOOOOOWWWWWWWWUUUUUUUUUUUUNNNNNNNNNNN\n" +
            "UUUUUUUTTTTDDDDDDDDDDQQQQDDDDDDGDDDDDDTTTTTTTTTTNZZZZIIFFFFFFFFFDDDDDDDHHHHHHHHHHHLLLLLGGGGGGGGGGGOOOOOOOOOOOWWWWWWWWUUUUUUUUUUUUUNNNNNNNNNN\n" +
            "UUUUUUUTUUUDDDDDDDDDQQQQQQDDDDDDDDDDDDTTTTTTTTTTZZZZZFFFFFFFFFFFDFDDDZZZHHHHHHHHHHHHGGGGGGGGGGGGGOOOOOOOOOOOOOWWWWWWWWWWUUUUUUUUUNMNNNNNNNNN\n" +
            "UUUUUUUUUUDQDDDDDDDDQQQQQQDDDDDDDDDDDDTTTTTTTTTTZZZZZZZFFFFFFFFFFFDDDDZZHHHHHHHHHHGGGGGGGGGGGGGGGOOOOOOOOOOOOWWWWWWWWWWUUUUUUUUUUNNNNNNNNNNN\n" +
            "UUUUUUUUUDDDDDDDDDQQQQQQQDDDDDDDDDDDAZTTTTTTTTTTNZZZZFFFFFFFFFFFDDDDJJZZZHHHHFFFFFGGGGGGGGGGGGGGGOOOOOOOOOOOOOWWWWWWWWWUUUUUUUUUUUNNNNNNNNNN\n" +
            "UUUUUUUDDDDDDDDDDDQQQQQQQDDDDDDDDDDDDETTTTTTTTTTNPZZZFFFFFFFFFFFFIIZZZZZZZZFFFFFFFXGGGGGGGGLGGGGGGGOOOAAOOOOOOWWWWWWWWWUUUUUUUUUDUDNNNNNNNNN\n" +
            "UUUUUUUDDDDDDDDDDQQQQQQQQQDDDDDDDDDDDEEEVVVVVVVNNPZZZFFFFFFFFFFFDIDZZZZZZZZIIIIIIFXXXXGGGGGLLGGGGGOOOOOAOOOOOOOWWWWWWWUUUUUUUUDDDDDNNNNNNNNN\n" +
            "UUUUUUUDDDDDDDDQQQQQQQQQQVVVDDDDDDDDEEEEVVVVHHPNPPPZZZZFFFFFFFWWDDDZZZZZZZZZIIIIIIJXXJJGJJLLLLGGLGGOWWFAOAOOAOWWWWWWWWWWUUUUUUDDDDDDNNNNNNNN\n" +
            "UUUUUUUUDIDDDDDQQQQQQQQQQQVDDDDDDDDDDDEEEEVVVHPPPPPZZZZFZZZZZZWWDDDDDZZZZZZZIIIIIIJJJJJJJJLLLLLGLGGOWWFFFAAAAAWWWWWWWWWWUUZZUUUDDDDDDNNCNNNH\n" +
            "UUUUUUUUPDDDDDJJQQQQQQQVVVVDDDDDDDDDDEEEEEEVGPPPPPPZPZZFZZZZZWNWWWDDDDZZZZZZIIIIIIIJJIIILLLLLLLLLGLOWFFFFAAAAAWWWWWWWWWWWUZZUDDDDDDDDDNNNNNN\n" +
            "UUUUUUUUUDDDDDJJJQQQQQQQQQQQDTDDDDDDDDEEEEEPPPPPPPPPPPZZZZZZZWWWWWDDDDDZZZZZZNIIIIIIIIICCLLLLLLLLLLBFFFFFFFAAEWWWWWWWWWZZZZZZDDDDDDDDDDNNNNN\n" +
            "UUUUGGUUEEDDDDJJJJJJJQQQQQQQQDDDQDDDDEEEEEEEKPPPPPPPPPPZZZZWWWWPWDDDDDDZZZZZZNNIIIIIIILLLLLLLLLLLLLLFFFFFFFFFEWWWWWWWWWZZZZZDDDDDDDDDDDNNNNN\n" +
            "UUGUGGGEEEDJJJJJJJJJJJQQQQQQQDDDQQDDEEEEEEEEPPPPPPPPPPPZZWWWWWWWWDWDDDDZZZZZNNNNNIIIIILLLLLLLLLLLLLLLGFFFFFFEEEEEEWWWWZZQZZZDDDDDDDNNDNNNNNN\n" +
            "UGGGGGGGEEEJJJJJJJJJJJQQQQQQQQDQQQEEEEEEEEEEPPPPPPPPPPZZZWWWWWWWWWWWDDDZZZZINNNIIIIIIILLLLLLLLLLLLMGGGFEEEEEEEEEEWWWWWWZZZZZZDDDDNNNNNNNNNNN\n" +
            "UGGGGGGGGEJJJJJJJJQJQQQQQQQQQQQQQEEEEEEEEPPPPPPPPPPPPZZZZWWWWWWWWWWWDDZZNNNINNIIIIIIIILLGHLLLLLLLLLGGEEEEEEEEEEEEWWWWWZZZZZZZDDDDNNNNNNNNNNN\n" +
            "UGGGGGGGGGQJJJJJJJQQQQQQQQQQQQQQQQEEYEEYYYOPPPPPPPPPZZZWWWWWWWWWWWWWDDDNNNNNNNNIIINIIIIAGLLLLLLLLLLLGEEEEEEEEEEECPPPZZZZZZZZZDDNNNNNNNNNNNNN\n" +
            "SGGGGGGGGGJJJJJJJJQGQQQQQQQQQQQQQQQYYYYYYYYPYPPPBPZZZZZZWWWWWWWWWWWWNNNNNNNNNNNNNINIIIIGGLGGLLLLLLGGGGEEEEEEEEEECCPPPPPPZZZOZDNNNNNNNNNNNNNN\n" +
            "GGGGGGGGGGAJJJJJJJJQQQQQQQQQQQQQQQQYYYYYYYYYYPPPPZZZZZZZZZWWWWWWWWWRRRNNNNNNNNNNNNNIGIIIGGGLLLLGGGGGGEEEEEEEEEMMPCPPPPPPPPZZPPPPNNNNNNNNNNNN\n" +
            "GGGGGGGGGGGGJLJJJJJJDQQQTTTQQQQQQQQYYYYYYYYYYPYPYZZZZZZZZZZZWWWWWWWRRRNNNNNNNNNVVGGGGGGGGGGGLLGGGGGGGRNEEEEEEEMMPPPQPPPPPPPPPPPUNNNNNNNNNNNN\n" +
            "GGGGGGGGGGGGLLJJJJJTTDTQTTTQQQQQQEEEEEYYYYYYYYYYYYZZZZJZZWWWWWWWWWWRRRNNNNNNNNNNNRLLGGGGGGGGGGGGGGRRRRRREKKEEEMMPPPPPPPPPPPPPPPPZZZZZNNNNNNN\n" +
            "GGGGGGGGGGGGLYPPJJTTTTTTTQQQQQQQQEEEEEYYYYYYYYYYYYZZJJJJJJMWWWWWWWWWRRRRRNNNNRRRRRLLLGLGGGGGGGGGGGGRRRREEKKKKKKKUUPBPPPPPPPPZZZZZZZZNNNNNNNN\n" +
            "GGGGGGGGGGGGYYPPJJTTTTTTTTTTQQQQQEEEEEYPYYYYYYYYYZZZJJJJJJMMMWWWWWWWRRRRRRRRRRRRRLLLLLLGGGGGGGGGGGGRRRRRERKKKKKKKUPBBPPPPPPPZZZZZZZZZNNNNNNN\n" +
            "GGGGGGGGGGGYYYYYJJTTTTTTTTTQQQQQEOEEEEEYYYYYYYYYYZZZQJJJJJJJMWWWWWWWRRRRRRRRRRRRRLPLLLLLGGGGGGGGGGGRRERRRRRKKKKKKPPPPPPPPPPPZZZZZPZPPPPPNNNN\n" +
            "GGGGGGGGGGGYYYYYYJPTTTTTTTTTQQQQEEEEEEEYYYYYYYYYYYZJJJJJJJJJWWWWWRRWRRRRRRRRRRRRRLLLLLLLLGGGGGGGGGGGGRRRRRRRTKKKKPPPPPPPPPPPZZZZPPPPPPPPNNPP\n" +
            "GGGGGGGGGGYYYYYYYTTTTTTTTTTQQQQQEQEEEEEYYYYYYYYYYYZJJJJJJJJJJJWWRRRRRRRRRRRRRRRRRRRRLLLLLGGGGGGGGGGRRRRRRRRTTTTKTTPRPPPPPPPPZZFZPPPPPPPPNPPP\n" +
            "GGGGGGGGGGKKKKKKKKTTTTTTTTQQQQQQQQEYEEHHHHHHYYYYYYJJJJJJJJJJJJJRRRRRRRRRRRRRRRRRRRRRLLLLGGGGGGGGGGGGGRRRRRRRTTTTTTTPPPPPPPPRZZFZPPPPPPPPPPPP";

    @Test
    void getMap() {
        Day12 day12 = new Day12();
        char[][] map = day12.getMap(input);
        assert map.length == 4;
        assert map[0].length == 4;
        assert map[0][0] == 'A';
        assert map[0][1] == 'A';
        assert map[0][2] == 'A';
        assert map[0][3] == 'A';
        assert map[1][0] == 'B';
        assert map[1][1] == 'B';
        assert map[1][2] == 'C';
        assert map[1][3] == 'D';
        assert map[2][0] == 'B';
        assert map[2][1] == 'B';
        assert map[2][2] == 'C';
        assert map[2][3] == 'C';
        assert map[3][0] == 'E';
        assert map[3][1] == 'E';
        assert map[3][2] == 'E';
        assert map[3][3] == 'C';
    }

    @Test
    void getAreaA() {
        Day12 day12 = new Day12();
        char[][] map = day12.getMap(input);
        List<List<int[]>> areas = day12.getAreas(map);
        assertEquals(4, areas.get(0).size());
    }

    @Test
    void getAreaSecondInput() {
        Day12 day12 = new Day12();
        char[][] map = day12.getMap(input2);
        List<List<int[]>> areas = day12.getAreas(map);
        assertEquals(5, areas.size());
        assertEquals(21, areas.get(0).size());
        assertEquals(1, areas.get(1).size());
        assertEquals(1, areas.get(2).size());
        assertEquals(1, areas.get(3).size());
        assertEquals(1, areas.get(4).size());
    }

    @Test
    void getPerimeter() {
        Day12 day12 = new Day12();
        char[][] map = day12.getMap(input);
        List<List<int[]>> areas = day12.getAreas(map);
        assertEquals(10, day12.getPerimeter(areas.get(0)));
        assertEquals(8, day12.getPerimeter(areas.get(1)));
        assertEquals(10, day12.getPerimeter(areas.get(2)));
        assertEquals(4, day12.getPerimeter(areas.get(3)));
        assertEquals(8, day12.getPerimeter(areas.get(4)));
    }

    @Test
    void getFenceValue() {
        Day12 day12 = new Day12();
        char[][] map = day12.getMap(input);
        List<List<int[]>> areas = day12.getAreas(map);
        assertEquals(40, day12.getFenceValue(areas.get(0)));
        assertEquals(32, day12.getFenceValue(areas.get(1)));
        assertEquals(40, day12.getFenceValue(areas.get(2)));
        assertEquals(4, day12.getFenceValue(areas.get(3)));
        assertEquals(24, day12.getFenceValue(areas.get(4)));
    }

    @Test
    void getTotalFenceValue() {
        Day12 day12 = new Day12();
        assertEquals(64, day12.getTotalFenceValue(myInput));
        assertEquals(140, day12.getTotalFenceValue(input));
        assertEquals(772, day12.getTotalFenceValue(input2));
        assertEquals(1930, day12.getTotalFenceValue(input3));
        assertEquals(1486324, day12.getTotalFenceValue(finalInput));
    }

    @Test
    void getUniqueSides() {
        Day12 day12 = new Day12();
        char[][] map = day12.getMap(input);
        List<List<int[]>> areas = day12.getAreas(map);
        assertEquals(4, day12.getUniqueSides(areas.get(0)));
        assertEquals(4, day12.getUniqueSides(areas.get(1)));
        assertEquals(8, day12.getUniqueSides(areas.get(2)));
        assertEquals(4, day12.getUniqueSides(areas.get(3)));
        assertEquals(4, day12.getUniqueSides(areas.get(4)));
    }

    @Test
    void getTotalFenceValueWithDiscount() {
        Day12 day12 = new Day12();
        assertEquals(80, day12.getTotalFenceValueWithDiscount(input));
        assertEquals(436, day12.getTotalFenceValueWithDiscount(input2));
        assertEquals(236, day12.getTotalFenceValueWithDiscount(inputEShape));
        assertEquals(368, day12.getTotalFenceValueWithDiscount(inputABBA));
        assertEquals(1206, day12.getTotalFenceValueWithDiscount(input3));
        assertEquals(898684, day12.getTotalFenceValueWithDiscount(finalInput));
    }
}
