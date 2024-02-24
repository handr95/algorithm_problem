package com.study.programmers.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

 class PersonalDataExpireDateTest {
    PersonalDataExpireDate personalDataExpireDate = new PersonalDataExpireDate();

    @Test
    void test1() {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        assertThat(personalDataExpireDate.personalDateExpireDate(today, terms, privacies))
                .containsExactly(1, 3);
    }
    @Test
    void test2() {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        assertThat(personalDataExpireDate.personalDateExpireDate(today, terms, privacies))
                .containsExactly(1, 4, 5);
    }
}
