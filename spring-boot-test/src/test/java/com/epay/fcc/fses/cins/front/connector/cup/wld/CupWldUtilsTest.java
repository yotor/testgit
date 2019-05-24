package com.epay.fcc.fses.cins.front.connector.cup.wld;

import org.junit.Test;

import static org.junit.Assert.*;

public class CupWldUtilsTest {

    @Test
    public void decrypt() throws Exception{
        System.out.println(CupWldUtils.decrypt("E19A2ED1032A706F209665E0C9EC2F1B23367A340A23EF6FE66B3B1735D9B4D7FE059B79BADF9F1595A60B4FC886F97AEB575B8EC7C2519FC09B111FD6F320F9","0gjyrjendVoe1qhe6GRW90AtpgqpANRR"));
    }
}