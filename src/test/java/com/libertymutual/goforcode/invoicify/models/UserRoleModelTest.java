package com.libertymutual.goforcode.invoicify.models;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class UserRoleModelTest {

    @Test
    public void test_all_gets_and_sets() {
        new BeanTester().testBean(UserRole.class);
    }
}
