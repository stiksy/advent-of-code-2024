package com.stiksy.advent.days;

import com.stiksy.advent.days.Day13.Machine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day13Tests {
    String input =
            "Button A: X+94, Y+34\n" +
                    "Button B: X+22, Y+67\n" +
                    "Prize: X=8400, Y=5400\n" +
                    "\n" +
                    "Button A: X+26, Y+66\n" +
                    "Button B: X+67, Y+21\n" +
                    "Prize: X=12748, Y=12176\n" +
                    "\n" +
                    "Button A: X+17, Y+86\n" +
                    "Button B: X+84, Y+37\n" +
                    "Prize: X=7870, Y=6450\n" +
                    "\n" +
                    "Button A: X+69, Y+23\n" +
                    "Button B: X+27, Y+71\n" +
                    "Prize: X=18641, Y=10279";

    String finalInput = "Button A: X+43, Y+21\n" +
            "Button B: X+16, Y+31\n" +
            "Prize: X=6735, Y=9135\n" +
            "\n" +
            "Button A: X+52, Y+55\n" +
            "Button B: X+69, Y+11\n" +
            "Prize: X=2798, Y=1100\n" +
            "\n" +
            "Button A: X+13, Y+32\n" +
            "Button B: X+68, Y+24\n" +
            "Prize: X=8243, Y=3816\n" +
            "\n" +
            "Button A: X+97, Y+34\n" +
            "Button B: X+72, Y+97\n" +
            "Prize: X=5459, Y=6291\n" +
            "\n" +
            "Button A: X+66, Y+14\n" +
            "Button B: X+81, Y+77\n" +
            "Prize: X=5910, Y=3766\n" +
            "\n" +
            "Button A: X+65, Y+77\n" +
            "Button B: X+82, Y+24\n" +
            "Prize: X=8533, Y=3599\n" +
            "\n" +
            "Button A: X+63, Y+47\n" +
            "Button B: X+16, Y+39\n" +
            "Prize: X=852, Y=798\n" +
            "\n" +
            "Button A: X+55, Y+26\n" +
            "Button B: X+25, Y+43\n" +
            "Prize: X=7660, Y=5943\n" +
            "\n" +
            "Button A: X+67, Y+24\n" +
            "Button B: X+16, Y+39\n" +
            "Prize: X=14214, Y=10004\n" +
            "\n" +
            "Button A: X+48, Y+15\n" +
            "Button B: X+27, Y+74\n" +
            "Prize: X=18569, Y=15096\n" +
            "\n" +
            "Button A: X+21, Y+47\n" +
            "Button B: X+35, Y+14\n" +
            "Prize: X=5744, Y=8521\n" +
            "\n" +
            "Button A: X+17, Y+52\n" +
            "Button B: X+45, Y+24\n" +
            "Prize: X=8468, Y=6452\n" +
            "\n" +
            "Button A: X+21, Y+46\n" +
            "Button B: X+46, Y+29\n" +
            "Prize: X=8178, Y=8364\n" +
            "\n" +
            "Button A: X+27, Y+11\n" +
            "Button B: X+15, Y+37\n" +
            "Prize: X=11861, Y=1287\n" +
            "\n" +
            "Button A: X+17, Y+67\n" +
            "Button B: X+61, Y+21\n" +
            "Prize: X=12721, Y=12321\n" +
            "\n" +
            "Button A: X+44, Y+11\n" +
            "Button B: X+11, Y+74\n" +
            "Prize: X=6249, Y=12411\n" +
            "\n" +
            "Button A: X+43, Y+32\n" +
            "Button B: X+13, Y+53\n" +
            "Prize: X=2683, Y=5636\n" +
            "\n" +
            "Button A: X+20, Y+71\n" +
            "Button B: X+62, Y+19\n" +
            "Prize: X=5542, Y=7049\n" +
            "\n" +
            "Button A: X+65, Y+74\n" +
            "Button B: X+81, Y+12\n" +
            "Prize: X=5962, Y=6226\n" +
            "\n" +
            "Button A: X+45, Y+78\n" +
            "Button B: X+71, Y+28\n" +
            "Prize: X=4747, Y=5186\n" +
            "\n" +
            "Button A: X+32, Y+13\n" +
            "Button B: X+24, Y+54\n" +
            "Prize: X=10280, Y=15794\n" +
            "\n" +
            "Button A: X+40, Y+15\n" +
            "Button B: X+15, Y+46\n" +
            "Prize: X=3525, Y=1689\n" +
            "\n" +
            "Button A: X+98, Y+30\n" +
            "Button B: X+15, Y+24\n" +
            "Prize: X=10374, Y=4806\n" +
            "\n" +
            "Button A: X+84, Y+37\n" +
            "Button B: X+11, Y+52\n" +
            "Prize: X=6398, Y=13946\n" +
            "\n" +
            "Button A: X+20, Y+63\n" +
            "Button B: X+74, Y+28\n" +
            "Prize: X=7852, Y=19121\n" +
            "\n" +
            "Button A: X+56, Y+21\n" +
            "Button B: X+41, Y+77\n" +
            "Prize: X=4084, Y=2755\n" +
            "\n" +
            "Button A: X+24, Y+66\n" +
            "Button B: X+76, Y+48\n" +
            "Prize: X=3704, Y=4068\n" +
            "\n" +
            "Button A: X+23, Y+91\n" +
            "Button B: X+59, Y+21\n" +
            "Prize: X=840, Y=1624\n" +
            "\n" +
            "Button A: X+55, Y+13\n" +
            "Button B: X+58, Y+66\n" +
            "Prize: X=6299, Y=2953\n" +
            "\n" +
            "Button A: X+72, Y+37\n" +
            "Button B: X+11, Y+47\n" +
            "Prize: X=5838, Y=5729\n" +
            "\n" +
            "Button A: X+11, Y+25\n" +
            "Button B: X+47, Y+13\n" +
            "Prize: X=8669, Y=3911\n" +
            "\n" +
            "Button A: X+91, Y+12\n" +
            "Button B: X+41, Y+54\n" +
            "Prize: X=3844, Y=4200\n" +
            "\n" +
            "Button A: X+54, Y+30\n" +
            "Button B: X+27, Y+93\n" +
            "Prize: X=4050, Y=2562\n" +
            "\n" +
            "Button A: X+37, Y+95\n" +
            "Button B: X+78, Y+30\n" +
            "Prize: X=5333, Y=2455\n" +
            "\n" +
            "Button A: X+56, Y+23\n" +
            "Button B: X+15, Y+29\n" +
            "Prize: X=1544, Y=3765\n" +
            "\n" +
            "Button A: X+87, Y+63\n" +
            "Button B: X+14, Y+52\n" +
            "Prize: X=2565, Y=1983\n" +
            "\n" +
            "Button A: X+50, Y+38\n" +
            "Button B: X+29, Y+80\n" +
            "Prize: X=5011, Y=4330\n" +
            "\n" +
            "Button A: X+20, Y+41\n" +
            "Button B: X+72, Y+48\n" +
            "Prize: X=14876, Y=8483\n" +
            "\n" +
            "Button A: X+29, Y+79\n" +
            "Button B: X+62, Y+36\n" +
            "Prize: X=7841, Y=8469\n" +
            "\n" +
            "Button A: X+13, Y+38\n" +
            "Button B: X+49, Y+31\n" +
            "Prize: X=19090, Y=10498\n" +
            "\n" +
            "Button A: X+12, Y+23\n" +
            "Button B: X+57, Y+35\n" +
            "Prize: X=5882, Y=2769\n" +
            "\n" +
            "Button A: X+11, Y+38\n" +
            "Button B: X+99, Y+13\n" +
            "Prize: X=8261, Y=4192\n" +
            "\n" +
            "Button A: X+76, Y+11\n" +
            "Button B: X+18, Y+81\n" +
            "Prize: X=7206, Y=12859\n" +
            "\n" +
            "Button A: X+11, Y+19\n" +
            "Button B: X+49, Y+27\n" +
            "Prize: X=17371, Y=8949\n" +
            "\n" +
            "Button A: X+79, Y+11\n" +
            "Button B: X+56, Y+67\n" +
            "Prize: X=4535, Y=4006\n" +
            "\n" +
            "Button A: X+12, Y+72\n" +
            "Button B: X+71, Y+14\n" +
            "Prize: X=2014, Y=10012\n" +
            "\n" +
            "Button A: X+16, Y+45\n" +
            "Button B: X+79, Y+44\n" +
            "Prize: X=12630, Y=18535\n" +
            "\n" +
            "Button A: X+49, Y+81\n" +
            "Button B: X+43, Y+14\n" +
            "Prize: X=4881, Y=4550\n" +
            "\n" +
            "Button A: X+25, Y+37\n" +
            "Button B: X+34, Y+12\n" +
            "Prize: X=3249, Y=1513\n" +
            "\n" +
            "Button A: X+45, Y+19\n" +
            "Button B: X+24, Y+41\n" +
            "Prize: X=17765, Y=8489\n" +
            "\n" +
            "Button A: X+25, Y+54\n" +
            "Button B: X+49, Y+20\n" +
            "Prize: X=2186, Y=1374\n" +
            "\n" +
            "Button A: X+40, Y+64\n" +
            "Button B: X+48, Y+18\n" +
            "Prize: X=12328, Y=17404\n" +
            "\n" +
            "Button A: X+32, Y+81\n" +
            "Button B: X+96, Y+12\n" +
            "Prize: X=10112, Y=4575\n" +
            "\n" +
            "Button A: X+50, Y+16\n" +
            "Button B: X+25, Y+75\n" +
            "Prize: X=7275, Y=12885\n" +
            "\n" +
            "Button A: X+59, Y+35\n" +
            "Button B: X+17, Y+33\n" +
            "Prize: X=14681, Y=10785\n" +
            "\n" +
            "Button A: X+86, Y+20\n" +
            "Button B: X+34, Y+55\n" +
            "Prize: X=4002, Y=1590\n" +
            "\n" +
            "Button A: X+63, Y+27\n" +
            "Button B: X+14, Y+59\n" +
            "Prize: X=9258, Y=11796\n" +
            "\n" +
            "Button A: X+97, Y+15\n" +
            "Button B: X+52, Y+67\n" +
            "Prize: X=6716, Y=4694\n" +
            "\n" +
            "Button A: X+36, Y+62\n" +
            "Button B: X+29, Y+16\n" +
            "Prize: X=6269, Y=19412\n" +
            "\n" +
            "Button A: X+67, Y+92\n" +
            "Button B: X+86, Y+30\n" +
            "Prize: X=11973, Y=10010\n" +
            "\n" +
            "Button A: X+37, Y+11\n" +
            "Button B: X+16, Y+29\n" +
            "Prize: X=9451, Y=6864\n" +
            "\n" +
            "Button A: X+31, Y+15\n" +
            "Button B: X+52, Y+85\n" +
            "Prize: X=1721, Y=1850\n" +
            "\n" +
            "Button A: X+66, Y+13\n" +
            "Button B: X+25, Y+65\n" +
            "Prize: X=11765, Y=13705\n" +
            "\n" +
            "Button A: X+80, Y+79\n" +
            "Button B: X+21, Y+79\n" +
            "Prize: X=4397, Y=7663\n" +
            "\n" +
            "Button A: X+57, Y+26\n" +
            "Button B: X+22, Y+85\n" +
            "Prize: X=6688, Y=8748\n" +
            "\n" +
            "Button A: X+73, Y+44\n" +
            "Button B: X+19, Y+48\n" +
            "Prize: X=19153, Y=19588\n" +
            "\n" +
            "Button A: X+13, Y+55\n" +
            "Button B: X+71, Y+23\n" +
            "Prize: X=1126, Y=1990\n" +
            "\n" +
            "Button A: X+72, Y+68\n" +
            "Button B: X+95, Y+11\n" +
            "Prize: X=5091, Y=3155\n" +
            "\n" +
            "Button A: X+49, Y+16\n" +
            "Button B: X+25, Y+35\n" +
            "Prize: X=3805, Y=2960\n" +
            "\n" +
            "Button A: X+43, Y+98\n" +
            "Button B: X+90, Y+25\n" +
            "Prize: X=9144, Y=4089\n" +
            "\n" +
            "Button A: X+48, Y+34\n" +
            "Button B: X+23, Y+99\n" +
            "Prize: X=3414, Y=9862\n" +
            "\n" +
            "Button A: X+44, Y+19\n" +
            "Button B: X+22, Y+56\n" +
            "Prize: X=4456, Y=12030\n" +
            "\n" +
            "Button A: X+52, Y+77\n" +
            "Button B: X+30, Y+11\n" +
            "Prize: X=15458, Y=15566\n" +
            "\n" +
            "Button A: X+38, Y+11\n" +
            "Button B: X+12, Y+63\n" +
            "Prize: X=1488, Y=6951\n" +
            "\n" +
            "Button A: X+37, Y+11\n" +
            "Button B: X+33, Y+61\n" +
            "Prize: X=19386, Y=8652\n" +
            "\n" +
            "Button A: X+92, Y+45\n" +
            "Button B: X+25, Y+50\n" +
            "Prize: X=10591, Y=7560\n" +
            "\n" +
            "Button A: X+28, Y+64\n" +
            "Button B: X+32, Y+12\n" +
            "Prize: X=19208, Y=3964\n" +
            "\n" +
            "Button A: X+70, Y+15\n" +
            "Button B: X+87, Y+98\n" +
            "Prize: X=10080, Y=7715\n" +
            "\n" +
            "Button A: X+14, Y+96\n" +
            "Button B: X+16, Y+19\n" +
            "Prize: X=2168, Y=8607\n" +
            "\n" +
            "Button A: X+13, Y+24\n" +
            "Button B: X+29, Y+11\n" +
            "Prize: X=12908, Y=10796\n" +
            "\n" +
            "Button A: X+42, Y+82\n" +
            "Button B: X+53, Y+11\n" +
            "Prize: X=17947, Y=18345\n" +
            "\n" +
            "Button A: X+61, Y+89\n" +
            "Button B: X+84, Y+34\n" +
            "Prize: X=3732, Y=3054\n" +
            "\n" +
            "Button A: X+47, Y+17\n" +
            "Button B: X+11, Y+36\n" +
            "Prize: X=7924, Y=3034\n" +
            "\n" +
            "Button A: X+73, Y+48\n" +
            "Button B: X+37, Y+85\n" +
            "Prize: X=7580, Y=7957\n" +
            "\n" +
            "Button A: X+81, Y+14\n" +
            "Button B: X+98, Y+88\n" +
            "Prize: X=16336, Y=9148\n" +
            "\n" +
            "Button A: X+16, Y+33\n" +
            "Button B: X+98, Y+42\n" +
            "Prize: X=5502, Y=2541\n" +
            "\n" +
            "Button A: X+35, Y+68\n" +
            "Button B: X+34, Y+12\n" +
            "Prize: X=13091, Y=11496\n" +
            "\n" +
            "Button A: X+14, Y+51\n" +
            "Button B: X+76, Y+27\n" +
            "Prize: X=1156, Y=19262\n" +
            "\n" +
            "Button A: X+14, Y+36\n" +
            "Button B: X+63, Y+16\n" +
            "Prize: X=8866, Y=17172\n" +
            "\n" +
            "Button A: X+51, Y+21\n" +
            "Button B: X+23, Y+60\n" +
            "Prize: X=10550, Y=10004\n" +
            "\n" +
            "Button A: X+12, Y+30\n" +
            "Button B: X+67, Y+29\n" +
            "Prize: X=5496, Y=10066\n" +
            "\n" +
            "Button A: X+13, Y+34\n" +
            "Button B: X+58, Y+42\n" +
            "Prize: X=19589, Y=8546\n" +
            "\n" +
            "Button A: X+21, Y+59\n" +
            "Button B: X+51, Y+25\n" +
            "Prize: X=7853, Y=12783\n" +
            "\n" +
            "Button A: X+79, Y+90\n" +
            "Button B: X+62, Y+12\n" +
            "Prize: X=6111, Y=6786\n" +
            "\n" +
            "Button A: X+83, Y+13\n" +
            "Button B: X+23, Y+39\n" +
            "Prize: X=7289, Y=1885\n" +
            "\n" +
            "Button A: X+58, Y+27\n" +
            "Button B: X+17, Y+39\n" +
            "Prize: X=15652, Y=10325\n" +
            "\n" +
            "Button A: X+88, Y+45\n" +
            "Button B: X+19, Y+42\n" +
            "Prize: X=2197, Y=1866\n" +
            "\n" +
            "Button A: X+69, Y+11\n" +
            "Button B: X+16, Y+81\n" +
            "Prize: X=5910, Y=3531\n" +
            "\n" +
            "Button A: X+19, Y+44\n" +
            "Button B: X+22, Y+11\n" +
            "Prize: X=10669, Y=3510\n" +
            "\n" +
            "Button A: X+15, Y+80\n" +
            "Button B: X+97, Y+72\n" +
            "Prize: X=2315, Y=3440\n" +
            "\n" +
            "Button A: X+69, Y+82\n" +
            "Button B: X+66, Y+18\n" +
            "Prize: X=8115, Y=7710\n" +
            "\n" +
            "Button A: X+45, Y+23\n" +
            "Button B: X+15, Y+55\n" +
            "Prize: X=5025, Y=6071\n" +
            "\n" +
            "Button A: X+39, Y+15\n" +
            "Button B: X+19, Y+30\n" +
            "Prize: X=6986, Y=13580\n" +
            "\n" +
            "Button A: X+60, Y+25\n" +
            "Button B: X+20, Y+61\n" +
            "Prize: X=7420, Y=12209\n" +
            "\n" +
            "Button A: X+11, Y+56\n" +
            "Button B: X+69, Y+31\n" +
            "Prize: X=6917, Y=7105\n" +
            "\n" +
            "Button A: X+23, Y+37\n" +
            "Button B: X+52, Y+19\n" +
            "Prize: X=6106, Y=4004\n" +
            "\n" +
            "Button A: X+20, Y+58\n" +
            "Button B: X+70, Y+31\n" +
            "Prize: X=7630, Y=8379\n" +
            "\n" +
            "Button A: X+53, Y+24\n" +
            "Button B: X+16, Y+54\n" +
            "Prize: X=4891, Y=6750\n" +
            "\n" +
            "Button A: X+52, Y+20\n" +
            "Button B: X+12, Y+49\n" +
            "Prize: X=15128, Y=3793\n" +
            "\n" +
            "Button A: X+98, Y+16\n" +
            "Button B: X+29, Y+34\n" +
            "Prize: X=10277, Y=3346\n" +
            "\n" +
            "Button A: X+12, Y+24\n" +
            "Button B: X+28, Y+17\n" +
            "Prize: X=14900, Y=5123\n" +
            "\n" +
            "Button A: X+62, Y+30\n" +
            "Button B: X+25, Y+48\n" +
            "Prize: X=6961, Y=398\n" +
            "\n" +
            "Button A: X+18, Y+29\n" +
            "Button B: X+33, Y+13\n" +
            "Prize: X=899, Y=17953\n" +
            "\n" +
            "Button A: X+82, Y+29\n" +
            "Button B: X+28, Y+94\n" +
            "Prize: X=7116, Y=3694\n" +
            "\n" +
            "Button A: X+13, Y+67\n" +
            "Button B: X+44, Y+15\n" +
            "Prize: X=17930, Y=1539\n" +
            "\n" +
            "Button A: X+11, Y+79\n" +
            "Button B: X+66, Y+46\n" +
            "Prize: X=2497, Y=2525\n" +
            "\n" +
            "Button A: X+91, Y+34\n" +
            "Button B: X+21, Y+47\n" +
            "Prize: X=3892, Y=2433\n" +
            "\n" +
            "Button A: X+36, Y+14\n" +
            "Button B: X+36, Y+70\n" +
            "Prize: X=15812, Y=11526\n" +
            "\n" +
            "Button A: X+66, Y+24\n" +
            "Button B: X+21, Y+63\n" +
            "Prize: X=9731, Y=8597\n" +
            "\n" +
            "Button A: X+67, Y+17\n" +
            "Button B: X+15, Y+59\n" +
            "Prize: X=2779, Y=3199\n" +
            "\n" +
            "Button A: X+38, Y+12\n" +
            "Button B: X+22, Y+74\n" +
            "Prize: X=5802, Y=7362\n" +
            "\n" +
            "Button A: X+57, Y+30\n" +
            "Button B: X+18, Y+46\n" +
            "Prize: X=16124, Y=8992\n" +
            "\n" +
            "Button A: X+13, Y+54\n" +
            "Button B: X+78, Y+42\n" +
            "Prize: X=6435, Y=5298\n" +
            "\n" +
            "Button A: X+11, Y+29\n" +
            "Button B: X+78, Y+45\n" +
            "Prize: X=12589, Y=7519\n" +
            "\n" +
            "Button A: X+48, Y+29\n" +
            "Button B: X+21, Y+51\n" +
            "Prize: X=14339, Y=12317\n" +
            "\n" +
            "Button A: X+12, Y+66\n" +
            "Button B: X+96, Y+37\n" +
            "Prize: X=2076, Y=6508\n" +
            "\n" +
            "Button A: X+49, Y+82\n" +
            "Button B: X+95, Y+46\n" +
            "Prize: X=8784, Y=7808\n" +
            "\n" +
            "Button A: X+14, Y+65\n" +
            "Button B: X+44, Y+12\n" +
            "Prize: X=9392, Y=10074\n" +
            "\n" +
            "Button A: X+27, Y+82\n" +
            "Button B: X+71, Y+52\n" +
            "Prize: X=9077, Y=12186\n" +
            "\n" +
            "Button A: X+25, Y+12\n" +
            "Button B: X+19, Y+31\n" +
            "Prize: X=2732, Y=3851\n" +
            "\n" +
            "Button A: X+64, Y+17\n" +
            "Button B: X+48, Y+83\n" +
            "Prize: X=6960, Y=5572\n" +
            "\n" +
            "Button A: X+11, Y+68\n" +
            "Button B: X+39, Y+13\n" +
            "Prize: X=3654, Y=10406\n" +
            "\n" +
            "Button A: X+26, Y+53\n" +
            "Button B: X+42, Y+15\n" +
            "Prize: X=11440, Y=15652\n" +
            "\n" +
            "Button A: X+19, Y+41\n" +
            "Button B: X+37, Y+14\n" +
            "Prize: X=8177, Y=9083\n" +
            "\n" +
            "Button A: X+33, Y+45\n" +
            "Button B: X+94, Y+40\n" +
            "Prize: X=5578, Y=3550\n" +
            "\n" +
            "Button A: X+93, Y+15\n" +
            "Button B: X+26, Y+45\n" +
            "Prize: X=4456, Y=1290\n" +
            "\n" +
            "Button A: X+15, Y+57\n" +
            "Button B: X+75, Y+17\n" +
            "Prize: X=5165, Y=10327\n" +
            "\n" +
            "Button A: X+47, Y+17\n" +
            "Button B: X+18, Y+65\n" +
            "Prize: X=18606, Y=16972\n" +
            "\n" +
            "Button A: X+57, Y+83\n" +
            "Button B: X+78, Y+14\n" +
            "Prize: X=7539, Y=7393\n" +
            "\n" +
            "Button A: X+29, Y+47\n" +
            "Button B: X+82, Y+29\n" +
            "Prize: X=5318, Y=3424\n" +
            "\n" +
            "Button A: X+47, Y+35\n" +
            "Button B: X+36, Y+84\n" +
            "Prize: X=1306, Y=2002\n" +
            "\n" +
            "Button A: X+58, Y+23\n" +
            "Button B: X+31, Y+59\n" +
            "Prize: X=4304, Y=293\n" +
            "\n" +
            "Button A: X+99, Y+22\n" +
            "Button B: X+27, Y+98\n" +
            "Prize: X=6813, Y=8874\n" +
            "\n" +
            "Button A: X+53, Y+12\n" +
            "Button B: X+23, Y+76\n" +
            "Prize: X=17141, Y=5516\n" +
            "\n" +
            "Button A: X+54, Y+20\n" +
            "Button B: X+36, Y+68\n" +
            "Prize: X=3294, Y=4008\n" +
            "\n" +
            "Button A: X+65, Y+22\n" +
            "Button B: X+20, Y+59\n" +
            "Prize: X=4075, Y=2685\n" +
            "\n" +
            "Button A: X+29, Y+42\n" +
            "Button B: X+28, Y+13\n" +
            "Prize: X=5621, Y=12357\n" +
            "\n" +
            "Button A: X+22, Y+51\n" +
            "Button B: X+32, Y+11\n" +
            "Prize: X=10008, Y=9754\n" +
            "\n" +
            "Button A: X+76, Y+19\n" +
            "Button B: X+14, Y+49\n" +
            "Prize: X=2980, Y=9883\n" +
            "\n" +
            "Button A: X+73, Y+20\n" +
            "Button B: X+15, Y+50\n" +
            "Prize: X=17293, Y=6120\n" +
            "\n" +
            "Button A: X+20, Y+87\n" +
            "Button B: X+87, Y+85\n" +
            "Prize: X=7424, Y=11166\n" +
            "\n" +
            "Button A: X+56, Y+28\n" +
            "Button B: X+13, Y+51\n" +
            "Prize: X=16114, Y=9490\n" +
            "\n" +
            "Button A: X+99, Y+47\n" +
            "Button B: X+39, Y+62\n" +
            "Prize: X=7644, Y=7847\n" +
            "\n" +
            "Button A: X+14, Y+42\n" +
            "Button B: X+72, Y+11\n" +
            "Prize: X=6470, Y=1985\n" +
            "\n" +
            "Button A: X+50, Y+14\n" +
            "Button B: X+16, Y+63\n" +
            "Prize: X=17812, Y=8208\n" +
            "\n" +
            "Button A: X+21, Y+45\n" +
            "Button B: X+56, Y+35\n" +
            "Prize: X=10693, Y=14380\n" +
            "\n" +
            "Button A: X+17, Y+68\n" +
            "Button B: X+52, Y+15\n" +
            "Prize: X=14292, Y=5400\n" +
            "\n" +
            "Button A: X+72, Y+19\n" +
            "Button B: X+15, Y+71\n" +
            "Prize: X=16883, Y=2971\n" +
            "\n" +
            "Button A: X+17, Y+55\n" +
            "Button B: X+77, Y+39\n" +
            "Prize: X=15479, Y=5409\n" +
            "\n" +
            "Button A: X+70, Y+38\n" +
            "Button B: X+17, Y+44\n" +
            "Prize: X=9069, Y=7614\n" +
            "\n" +
            "Button A: X+25, Y+53\n" +
            "Button B: X+47, Y+28\n" +
            "Prize: X=12567, Y=17929\n" +
            "\n" +
            "Button A: X+14, Y+72\n" +
            "Button B: X+65, Y+13\n" +
            "Prize: X=3787, Y=6419\n" +
            "\n" +
            "Button A: X+49, Y+98\n" +
            "Button B: X+69, Y+12\n" +
            "Prize: X=7430, Y=8182\n" +
            "\n" +
            "Button A: X+46, Y+95\n" +
            "Button B: X+51, Y+24\n" +
            "Prize: X=4212, Y=5283\n" +
            "\n" +
            "Button A: X+80, Y+11\n" +
            "Button B: X+36, Y+47\n" +
            "Prize: X=5416, Y=997\n" +
            "\n" +
            "Button A: X+85, Y+28\n" +
            "Button B: X+22, Y+46\n" +
            "Prize: X=1857, Y=1038\n" +
            "\n" +
            "Button A: X+14, Y+37\n" +
            "Button B: X+65, Y+22\n" +
            "Prize: X=7794, Y=6607\n" +
            "\n" +
            "Button A: X+85, Y+14\n" +
            "Button B: X+69, Y+96\n" +
            "Prize: X=10287, Y=6180\n" +
            "\n" +
            "Button A: X+56, Y+13\n" +
            "Button B: X+28, Y+59\n" +
            "Prize: X=2048, Y=7544\n" +
            "\n" +
            "Button A: X+13, Y+39\n" +
            "Button B: X+49, Y+28\n" +
            "Prize: X=7351, Y=13456\n" +
            "\n" +
            "Button A: X+26, Y+95\n" +
            "Button B: X+80, Y+31\n" +
            "Prize: X=8046, Y=10846\n" +
            "\n" +
            "Button A: X+35, Y+75\n" +
            "Button B: X+97, Y+35\n" +
            "Prize: X=5153, Y=5165\n" +
            "\n" +
            "Button A: X+16, Y+86\n" +
            "Button B: X+63, Y+58\n" +
            "Prize: X=2250, Y=5920\n" +
            "\n" +
            "Button A: X+96, Y+25\n" +
            "Button B: X+22, Y+22\n" +
            "Prize: X=10888, Y=4072\n" +
            "\n" +
            "Button A: X+61, Y+13\n" +
            "Button B: X+70, Y+98\n" +
            "Prize: X=5028, Y=3564\n" +
            "\n" +
            "Button A: X+20, Y+71\n" +
            "Button B: X+69, Y+53\n" +
            "Prize: X=6913, Y=9761\n" +
            "\n" +
            "Button A: X+12, Y+27\n" +
            "Button B: X+49, Y+35\n" +
            "Prize: X=1505, Y=9830\n" +
            "\n" +
            "Button A: X+54, Y+22\n" +
            "Button B: X+24, Y+46\n" +
            "Prize: X=18530, Y=1678\n" +
            "\n" +
            "Button A: X+16, Y+50\n" +
            "Button B: X+66, Y+24\n" +
            "Prize: X=2670, Y=4152\n" +
            "\n" +
            "Button A: X+99, Y+86\n" +
            "Button B: X+25, Y+99\n" +
            "Prize: X=8796, Y=10655\n" +
            "\n" +
            "Button A: X+97, Y+28\n" +
            "Button B: X+44, Y+47\n" +
            "Prize: X=6790, Y=5287\n" +
            "\n" +
            "Button A: X+71, Y+13\n" +
            "Button B: X+17, Y+67\n" +
            "Prize: X=15700, Y=18636\n" +
            "\n" +
            "Button A: X+88, Y+35\n" +
            "Button B: X+45, Y+98\n" +
            "Prize: X=9930, Y=9877\n" +
            "\n" +
            "Button A: X+31, Y+57\n" +
            "Button B: X+23, Y+13\n" +
            "Prize: X=14883, Y=17401\n" +
            "\n" +
            "Button A: X+49, Y+11\n" +
            "Button B: X+31, Y+80\n" +
            "Prize: X=1819, Y=18339\n" +
            "\n" +
            "Button A: X+99, Y+38\n" +
            "Button B: X+38, Y+57\n" +
            "Prize: X=3796, Y=3705\n" +
            "\n" +
            "Button A: X+65, Y+30\n" +
            "Button B: X+20, Y+41\n" +
            "Prize: X=16400, Y=2050\n" +
            "\n" +
            "Button A: X+19, Y+41\n" +
            "Button B: X+52, Y+25\n" +
            "Prize: X=2093, Y=11409\n" +
            "\n" +
            "Button A: X+24, Y+84\n" +
            "Button B: X+65, Y+39\n" +
            "Prize: X=6125, Y=5415\n" +
            "\n" +
            "Button A: X+39, Y+81\n" +
            "Button B: X+73, Y+25\n" +
            "Prize: X=7310, Y=2774\n" +
            "\n" +
            "Button A: X+20, Y+48\n" +
            "Button B: X+48, Y+24\n" +
            "Prize: X=11964, Y=6992\n" +
            "\n" +
            "Button A: X+61, Y+64\n" +
            "Button B: X+14, Y+89\n" +
            "Prize: X=5770, Y=12073\n" +
            "\n" +
            "Button A: X+18, Y+86\n" +
            "Button B: X+62, Y+23\n" +
            "Prize: X=1850, Y=2828\n" +
            "\n" +
            "Button A: X+49, Y+11\n" +
            "Button B: X+35, Y+81\n" +
            "Prize: X=9083, Y=2969\n" +
            "\n" +
            "Button A: X+13, Y+82\n" +
            "Button B: X+98, Y+34\n" +
            "Prize: X=7886, Y=10020\n" +
            "\n" +
            "Button A: X+28, Y+39\n" +
            "Button B: X+38, Y+14\n" +
            "Prize: X=14522, Y=15231\n" +
            "\n" +
            "Button A: X+84, Y+12\n" +
            "Button B: X+12, Y+75\n" +
            "Prize: X=2616, Y=1473\n" +
            "\n" +
            "Button A: X+15, Y+81\n" +
            "Button B: X+83, Y+38\n" +
            "Prize: X=2217, Y=2127\n" +
            "\n" +
            "Button A: X+15, Y+40\n" +
            "Button B: X+60, Y+21\n" +
            "Prize: X=14105, Y=14346\n" +
            "\n" +
            "Button A: X+19, Y+74\n" +
            "Button B: X+22, Y+11\n" +
            "Prize: X=3088, Y=5156\n" +
            "\n" +
            "Button A: X+31, Y+23\n" +
            "Button B: X+30, Y+90\n" +
            "Prize: X=792, Y=1536\n" +
            "\n" +
            "Button A: X+29, Y+11\n" +
            "Button B: X+20, Y+35\n" +
            "Prize: X=1254, Y=2076\n" +
            "\n" +
            "Button A: X+15, Y+35\n" +
            "Button B: X+45, Y+26\n" +
            "Prize: X=14120, Y=14699\n" +
            "\n" +
            "Button A: X+18, Y+61\n" +
            "Button B: X+53, Y+17\n" +
            "Prize: X=9368, Y=14132\n" +
            "\n" +
            "Button A: X+58, Y+32\n" +
            "Button B: X+20, Y+50\n" +
            "Prize: X=12594, Y=11016\n" +
            "\n" +
            "Button A: X+75, Y+11\n" +
            "Button B: X+11, Y+67\n" +
            "Prize: X=1837, Y=3029\n" +
            "\n" +
            "Button A: X+15, Y+37\n" +
            "Button B: X+77, Y+53\n" +
            "Prize: X=4675, Y=4685\n" +
            "\n" +
            "Button A: X+91, Y+22\n" +
            "Button B: X+57, Y+67\n" +
            "Prize: X=6699, Y=6090\n" +
            "\n" +
            "Button A: X+18, Y+27\n" +
            "Button B: X+35, Y+11\n" +
            "Prize: X=13285, Y=13945\n" +
            "\n" +
            "Button A: X+11, Y+41\n" +
            "Button B: X+84, Y+50\n" +
            "Prize: X=15364, Y=7098\n" +
            "\n" +
            "Button A: X+17, Y+33\n" +
            "Button B: X+47, Y+24\n" +
            "Prize: X=12428, Y=19232\n" +
            "\n" +
            "Button A: X+51, Y+36\n" +
            "Button B: X+29, Y+87\n" +
            "Prize: X=3586, Y=8652\n" +
            "\n" +
            "Button A: X+13, Y+77\n" +
            "Button B: X+43, Y+32\n" +
            "Prize: X=2319, Y=5496\n" +
            "\n" +
            "Button A: X+52, Y+12\n" +
            "Button B: X+38, Y+72\n" +
            "Prize: X=17922, Y=16052\n" +
            "\n" +
            "Button A: X+37, Y+12\n" +
            "Button B: X+11, Y+42\n" +
            "Prize: X=9216, Y=740\n" +
            "\n" +
            "Button A: X+26, Y+68\n" +
            "Button B: X+66, Y+20\n" +
            "Prize: X=13716, Y=3144\n" +
            "\n" +
            "Button A: X+48, Y+23\n" +
            "Button B: X+35, Y+58\n" +
            "Prize: X=3530, Y=19394\n" +
            "\n" +
            "Button A: X+32, Y+17\n" +
            "Button B: X+11, Y+26\n" +
            "Prize: X=7563, Y=12768\n" +
            "\n" +
            "Button A: X+64, Y+18\n" +
            "Button B: X+11, Y+85\n" +
            "Prize: X=3383, Y=6603\n" +
            "\n" +
            "Button A: X+42, Y+18\n" +
            "Button B: X+33, Y+50\n" +
            "Prize: X=18143, Y=12014\n" +
            "\n" +
            "Button A: X+13, Y+24\n" +
            "Button B: X+46, Y+12\n" +
            "Prize: X=3203, Y=12860\n" +
            "\n" +
            "Button A: X+82, Y+23\n" +
            "Button B: X+11, Y+68\n" +
            "Prize: X=8381, Y=13611\n" +
            "\n" +
            "Button A: X+18, Y+14\n" +
            "Button B: X+21, Y+55\n" +
            "Prize: X=2466, Y=3542\n" +
            "\n" +
            "Button A: X+22, Y+27\n" +
            "Button B: X+41, Y+12\n" +
            "Prize: X=3425, Y=2709\n" +
            "\n" +
            "Button A: X+19, Y+46\n" +
            "Button B: X+59, Y+36\n" +
            "Prize: X=13707, Y=14528\n" +
            "\n" +
            "Button A: X+79, Y+76\n" +
            "Button B: X+81, Y+15\n" +
            "Prize: X=8477, Y=2429\n" +
            "\n" +
            "Button A: X+14, Y+52\n" +
            "Button B: X+51, Y+28\n" +
            "Prize: X=13435, Y=400\n" +
            "\n" +
            "Button A: X+13, Y+90\n" +
            "Button B: X+88, Y+53\n" +
            "Prize: X=3386, Y=2861\n" +
            "\n" +
            "Button A: X+16, Y+48\n" +
            "Button B: X+59, Y+39\n" +
            "Prize: X=2802, Y=5370\n" +
            "\n" +
            "Button A: X+61, Y+39\n" +
            "Button B: X+12, Y+28\n" +
            "Prize: X=3251, Y=14769\n" +
            "\n" +
            "Button A: X+61, Y+32\n" +
            "Button B: X+29, Y+55\n" +
            "Prize: X=15301, Y=11760\n" +
            "\n" +
            "Button A: X+84, Y+67\n" +
            "Button B: X+22, Y+71\n" +
            "Prize: X=2100, Y=6165\n" +
            "\n" +
            "Button A: X+74, Y+13\n" +
            "Button B: X+54, Y+58\n" +
            "Prize: X=3264, Y=2708\n" +
            "\n" +
            "Button A: X+80, Y+86\n" +
            "Button B: X+18, Y+95\n" +
            "Prize: X=6060, Y=11810\n" +
            "\n" +
            "Button A: X+11, Y+80\n" +
            "Button B: X+74, Y+65\n" +
            "Prize: X=4843, Y=4465\n" +
            "\n" +
            "Button A: X+28, Y+49\n" +
            "Button B: X+72, Y+40\n" +
            "Prize: X=3720, Y=4876\n" +
            "\n" +
            "Button A: X+79, Y+41\n" +
            "Button B: X+11, Y+53\n" +
            "Prize: X=17080, Y=3544\n" +
            "\n" +
            "Button A: X+25, Y+11\n" +
            "Button B: X+26, Y+41\n" +
            "Prize: X=10950, Y=19270\n" +
            "\n" +
            "Button A: X+26, Y+50\n" +
            "Button B: X+41, Y+14\n" +
            "Prize: X=6504, Y=18240\n" +
            "\n" +
            "Button A: X+35, Y+64\n" +
            "Button B: X+82, Y+34\n" +
            "Prize: X=7914, Y=4964\n" +
            "\n" +
            "Button A: X+32, Y+14\n" +
            "Button B: X+29, Y+47\n" +
            "Prize: X=3801, Y=9057\n" +
            "\n" +
            "Button A: X+59, Y+17\n" +
            "Button B: X+36, Y+77\n" +
            "Prize: X=16929, Y=16549\n" +
            "\n" +
            "Button A: X+65, Y+89\n" +
            "Button B: X+73, Y+16\n" +
            "Prize: X=5247, Y=6009\n" +
            "\n" +
            "Button A: X+57, Y+22\n" +
            "Button B: X+12, Y+89\n" +
            "Prize: X=1371, Y=2554\n" +
            "\n" +
            "Button A: X+55, Y+66\n" +
            "Button B: X+98, Y+23\n" +
            "Prize: X=9696, Y=4824\n" +
            "\n" +
            "Button A: X+14, Y+41\n" +
            "Button B: X+63, Y+38\n" +
            "Prize: X=5849, Y=337\n" +
            "\n" +
            "Button A: X+30, Y+73\n" +
            "Button B: X+49, Y+17\n" +
            "Prize: X=16159, Y=18772\n" +
            "\n" +
            "Button A: X+23, Y+13\n" +
            "Button B: X+24, Y+42\n" +
            "Prize: X=14243, Y=18635\n" +
            "\n" +
            "Button A: X+72, Y+29\n" +
            "Button B: X+15, Y+44\n" +
            "Prize: X=13301, Y=15812\n" +
            "\n" +
            "Button A: X+32, Y+73\n" +
            "Button B: X+47, Y+13\n" +
            "Prize: X=2757, Y=6163\n" +
            "\n" +
            "Button A: X+29, Y+12\n" +
            "Button B: X+19, Y+38\n" +
            "Prize: X=3796, Y=10482\n" +
            "\n" +
            "Button A: X+14, Y+49\n" +
            "Button B: X+66, Y+25\n" +
            "Prize: X=1790, Y=2557\n" +
            "\n" +
            "Button A: X+69, Y+12\n" +
            "Button B: X+29, Y+48\n" +
            "Prize: X=3831, Y=924\n" +
            "\n" +
            "Button A: X+50, Y+17\n" +
            "Button B: X+47, Y+81\n" +
            "Prize: X=5819, Y=4055\n" +
            "\n" +
            "Button A: X+32, Y+98\n" +
            "Button B: X+30, Y+21\n" +
            "Prize: X=5380, Y=10948\n" +
            "\n" +
            "Button A: X+77, Y+16\n" +
            "Button B: X+48, Y+99\n" +
            "Prize: X=6611, Y=9208\n" +
            "\n" +
            "Button A: X+43, Y+13\n" +
            "Button B: X+26, Y+51\n" +
            "Prize: X=8449, Y=10214\n" +
            "\n" +
            "Button A: X+75, Y+49\n" +
            "Button B: X+16, Y+72\n" +
            "Prize: X=7949, Y=10671\n" +
            "\n" +
            "Button A: X+66, Y+14\n" +
            "Button B: X+15, Y+54\n" +
            "Prize: X=7130, Y=13916\n" +
            "\n" +
            "Button A: X+22, Y+45\n" +
            "Button B: X+61, Y+30\n" +
            "Prize: X=4625, Y=9320\n" +
            "\n" +
            "Button A: X+15, Y+62\n" +
            "Button B: X+58, Y+12\n" +
            "Prize: X=19789, Y=3466\n" +
            "\n" +
            "Button A: X+41, Y+78\n" +
            "Button B: X+53, Y+16\n" +
            "Prize: X=4759, Y=12566\n" +
            "\n" +
            "Button A: X+37, Y+12\n" +
            "Button B: X+24, Y+35\n" +
            "Prize: X=6701, Y=5546\n" +
            "\n" +
            "Button A: X+28, Y+34\n" +
            "Button B: X+53, Y+17\n" +
            "Prize: X=4761, Y=2703\n" +
            "\n" +
            "Button A: X+42, Y+18\n" +
            "Button B: X+27, Y+48\n" +
            "Prize: X=10796, Y=19634\n" +
            "\n" +
            "Button A: X+12, Y+81\n" +
            "Button B: X+66, Y+55\n" +
            "Prize: X=1200, Y=4195\n" +
            "\n" +
            "Button A: X+12, Y+37\n" +
            "Button B: X+69, Y+43\n" +
            "Prize: X=1641, Y=3532\n" +
            "\n" +
            "Button A: X+64, Y+20\n" +
            "Button B: X+23, Y+61\n" +
            "Prize: X=15134, Y=14666\n" +
            "\n" +
            "Button A: X+58, Y+27\n" +
            "Button B: X+20, Y+59\n" +
            "Prize: X=4892, Y=13077\n" +
            "\n" +
            "Button A: X+15, Y+64\n" +
            "Button B: X+77, Y+20\n" +
            "Prize: X=4642, Y=3644\n" +
            "\n" +
            "Button A: X+13, Y+68\n" +
            "Button B: X+35, Y+39\n" +
            "Prize: X=1333, Y=5820\n" +
            "\n" +
            "Button A: X+36, Y+94\n" +
            "Button B: X+90, Y+50\n" +
            "Prize: X=8874, Y=10406\n" +
            "\n" +
            "Button A: X+18, Y+51\n" +
            "Button B: X+64, Y+38\n" +
            "Prize: X=10342, Y=5679\n" +
            "\n" +
            "Button A: X+16, Y+28\n" +
            "Button B: X+35, Y+18\n" +
            "Prize: X=5441, Y=16670\n" +
            "\n" +
            "Button A: X+23, Y+12\n" +
            "Button B: X+41, Y+83\n" +
            "Prize: X=1994, Y=2827\n" +
            "\n" +
            "Button A: X+99, Y+37\n" +
            "Button B: X+24, Y+57\n" +
            "Prize: X=8934, Y=6557\n" +
            "\n" +
            "Button A: X+31, Y+55\n" +
            "Button B: X+56, Y+28\n" +
            "Prize: X=6895, Y=3447\n" +
            "\n" +
            "Button A: X+15, Y+39\n" +
            "Button B: X+60, Y+29\n" +
            "Prize: X=11720, Y=10724\n" +
            "\n" +
            "Button A: X+82, Y+84\n" +
            "Button B: X+21, Y+93\n" +
            "Prize: X=5429, Y=10923\n" +
            "\n" +
            "Button A: X+21, Y+56\n" +
            "Button B: X+66, Y+23\n" +
            "Prize: X=10691, Y=8258\n" +
            "\n" +
            "Button A: X+53, Y+26\n" +
            "Button B: X+25, Y+64\n" +
            "Prize: X=5681, Y=6098\n" +
            "\n" +
            "Button A: X+47, Y+78\n" +
            "Button B: X+40, Y+14\n" +
            "Prize: X=5920, Y=10370\n" +
            "\n" +
            "Button A: X+51, Y+21\n" +
            "Button B: X+15, Y+31\n" +
            "Prize: X=13418, Y=16260\n" +
            "\n" +
            "Button A: X+24, Y+44\n" +
            "Button B: X+52, Y+17\n" +
            "Prize: X=16408, Y=18128\n" +
            "\n" +
            "Button A: X+81, Y+39\n" +
            "Button B: X+13, Y+54\n" +
            "Prize: X=791, Y=4736\n" +
            "\n" +
            "Button A: X+26, Y+12\n" +
            "Button B: X+20, Y+43\n" +
            "Prize: X=17344, Y=15695\n" +
            "\n" +
            "Button A: X+41, Y+79\n" +
            "Button B: X+84, Y+33\n" +
            "Prize: X=4560, Y=5565\n" +
            "\n" +
            "Button A: X+15, Y+60\n" +
            "Button B: X+64, Y+18\n" +
            "Prize: X=10078, Y=16766\n" +
            "\n" +
            "Button A: X+77, Y+34\n" +
            "Button B: X+11, Y+59\n" +
            "Prize: X=6468, Y=7404\n" +
            "\n" +
            "Button A: X+42, Y+63\n" +
            "Button B: X+46, Y+21\n" +
            "Prize: X=7730, Y=7035\n" +
            "\n" +
            "Button A: X+43, Y+17\n" +
            "Button B: X+20, Y+64\n" +
            "Prize: X=14097, Y=11143\n" +
            "\n" +
            "Button A: X+43, Y+16\n" +
            "Button B: X+44, Y+77\n" +
            "Prize: X=11701, Y=5191\n" +
            "\n" +
            "Button A: X+49, Y+21\n" +
            "Button B: X+12, Y+30\n" +
            "Prize: X=9249, Y=5921\n" +
            "\n" +
            "Button A: X+76, Y+27\n" +
            "Button B: X+30, Y+83\n" +
            "Prize: X=4640, Y=3674\n" +
            "\n" +
            "Button A: X+52, Y+75\n" +
            "Button B: X+37, Y+11\n" +
            "Prize: X=17813, Y=19208\n" +
            "\n" +
            "Button A: X+52, Y+36\n" +
            "Button B: X+42, Y+97\n" +
            "Prize: X=7016, Y=9476\n" +
            "\n" +
            "Button A: X+25, Y+67\n" +
            "Button B: X+82, Y+62\n" +
            "Prize: X=1745, Y=3099\n" +
            "\n" +
            "Button A: X+14, Y+54\n" +
            "Button B: X+75, Y+11\n" +
            "Prize: X=6535, Y=19767\n" +
            "\n" +
            "Button A: X+25, Y+75\n" +
            "Button B: X+68, Y+21\n" +
            "Prize: X=9616, Y=1277\n" +
            "\n" +
            "Button A: X+70, Y+89\n" +
            "Button B: X+59, Y+19\n" +
            "Prize: X=10106, Y=8704\n" +
            "\n" +
            "Button A: X+12, Y+46\n" +
            "Button B: X+65, Y+28\n" +
            "Prize: X=5529, Y=13980\n" +
            "\n" +
            "Button A: X+26, Y+72\n" +
            "Button B: X+72, Y+26\n" +
            "Prize: X=12562, Y=10952\n" +
            "\n" +
            "Button A: X+65, Y+39\n" +
            "Button B: X+21, Y+42\n" +
            "Prize: X=8898, Y=5612\n" +
            "\n" +
            "Button A: X+29, Y+11\n" +
            "Button B: X+43, Y+64\n" +
            "Prize: X=13219, Y=16279\n" +
            "\n" +
            "Button A: X+51, Y+12\n" +
            "Button B: X+31, Y+73\n" +
            "Prize: X=8323, Y=9697\n" +
            "\n" +
            "Button A: X+17, Y+38\n" +
            "Button B: X+28, Y+14\n" +
            "Prize: X=3010, Y=4396\n" +
            "\n" +
            "Button A: X+37, Y+26\n" +
            "Button B: X+18, Y+40\n" +
            "Prize: X=16840, Y=5928\n" +
            "\n" +
            "Button A: X+55, Y+26\n" +
            "Button B: X+26, Y+60\n" +
            "Prize: X=5990, Y=13188\n" +
            "\n" +
            "Button A: X+25, Y+50\n" +
            "Button B: X+48, Y+15\n" +
            "Prize: X=4924, Y=2720\n" +
            "\n" +
            "Button A: X+14, Y+33\n" +
            "Button B: X+43, Y+29\n" +
            "Prize: X=8624, Y=18226\n" +
            "\n" +
            "Button A: X+34, Y+11\n" +
            "Button B: X+33, Y+47\n" +
            "Prize: X=6099, Y=19526\n" +
            "\n" +
            "Button A: X+16, Y+61\n" +
            "Button B: X+74, Y+44\n" +
            "Prize: X=6778, Y=4648\n" +
            "\n" +
            "Button A: X+52, Y+11\n" +
            "Button B: X+52, Y+98\n" +
            "Prize: X=6552, Y=5649\n" +
            "\n" +
            "Button A: X+63, Y+14\n" +
            "Button B: X+25, Y+50\n" +
            "Prize: X=6130, Y=5540\n" +
            "\n" +
            "Button A: X+35, Y+91\n" +
            "Button B: X+81, Y+22\n" +
            "Prize: X=7127, Y=4951\n" +
            "\n" +
            "Button A: X+30, Y+57\n" +
            "Button B: X+51, Y+30\n" +
            "Prize: X=11087, Y=7355\n" +
            "\n" +
            "Button A: X+35, Y+18\n" +
            "Button B: X+38, Y+61\n" +
            "Prize: X=17792, Y=16111\n" +
            "\n" +
            "Button A: X+30, Y+14\n" +
            "Button B: X+35, Y+85\n" +
            "Prize: X=2100, Y=3452\n" +
            "\n" +
            "Button A: X+45, Y+11\n" +
            "Button B: X+23, Y+63\n" +
            "Prize: X=17967, Y=17271\n" +
            "\n" +
            "Button A: X+12, Y+35\n" +
            "Button B: X+42, Y+26\n" +
            "Prize: X=13022, Y=9764";

    @Test
    void processInput() {
        Day13 day13 = new Day13();
        List<Machine> machines = day13.processInput(input);
        assertEquals(94, machines.get(0).buttonA.x);
        assertEquals(34, machines.get(0).buttonA.y);
        assertEquals(22, machines.get(0).buttonB.x);
        assertEquals(67, machines.get(0).buttonB.y);
//        assertEquals(8400, machines.get(0).prize.x);
//        assertEquals(5400, machines.get(0).prize.y);
        assertEquals(10000000008400L, machines.get(0).prize.x);
        assertEquals(10000000005400L, machines.get(0).prize.y);
    }

    @Test
    void playMachine() {
        Day13 day13 = new Day13();
        List<Machine> machines = day13.processInput(input);
//        assertEquals(280, day13.play(machines.get(0)));
//        assertEquals(-1, day13.play(machines.get(1)));
//        assertEquals(200, day13.play(machines.get(2)));
//        assertEquals(-1, day13.play(machines.get(3)));
        assertEquals(-1, day13.play(machines.get(0)));
        assertEquals(459236326669L, day13.play(machines.get(1)));
        assertEquals(-1, day13.play(machines.get(2)));
        assertEquals(416082282239L, day13.play(machines.get(3)));
    }

    @Test
    void playAllMachines() {
        Day13 day13 = new Day13();
        long totalCost = day13.playAllMachines(input);
//        assertEquals(480, totalCost);
        assertEquals(875318608908L, totalCost);
    }

    @Test
    void playAllMachinesFinal() {
        Day13 day13 = new Day13();
        long totalCost = day13.playAllMachines(finalInput);
//        assertEquals(29436, totalCost);
        assertEquals(103729094227877L, totalCost);
    }
}
