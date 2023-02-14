package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {

    @Test
    void create() throws Exception {
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55");
        assertThat(queryStrings).isNotNull();
    }
}
