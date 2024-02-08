package com.study.programmers.greedy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JoyStickTest {
    JoyStick joyStick = new JoyStick();

    @Test
    void test1() {
        String name = "JEROEN";
        assertThat(joyStick.joystick(name)).isEqualTo(56);
    }

    @Test
    void test2() {
        String name = "JAN";
        assertThat(joyStick.joystick(name)).isEqualTo(23);
    }

    @Test
    void test3() {
        String name = "TAATAAAAAT";
        assertThat(joyStick.joystick(name)).isEqualTo(26);
    }

    @Test
    void test4() {
        String name = "AAAAABBAAAAAAABAAA";
        assertThat(joyStick.joystick(name)).isEqualTo(16);
    }

    @Test
    void test5() {
        String name = "ADASAAAUAAAPAA";
        assertThat(joyStick.joystick(name)).isEqualTo(39);
    }

    @Test
    void test6() {
        String name = "AAAAADBAAELSPUAAAOA";
        assertThat(joyStick.joystick(name)).isEqualTo(70);
    }

    @Test
    void test7() {
        String name = "VJAAIAFNAAAAA";
        assertThat(joyStick.joystick(name)).isEqualTo(47);
    }

    @Test
    void test8() {
        String name = "ABAA";
        assertThat(joyStick.joystick(name)).isEqualTo(2);
    }

    @Test
    void test9() {
        String name = "AABA";
        assertThat(joyStick.joystick(name)).isEqualTo(3);
    }
}
