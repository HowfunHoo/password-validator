package com.haofan.password_validator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Haofan on 2018-02-05.
 */

public class ValidatorTest {

    Validator validator;

    @Before
    public void setup(){
        validator = new Validator();
    }

    @Test
    public void testIfIsValid() throws Exception{
        int passed_num;
        passed_num = validator.ifIsValid("PaSsWord");
        assertEquals(1, passed_num);

        passed_num = validator.ifIsValid("1234567");
        assertEquals(1, passed_num);

        passed_num = validator.ifIsValid("passWord1");
        assertEquals(2, passed_num);


    }


}