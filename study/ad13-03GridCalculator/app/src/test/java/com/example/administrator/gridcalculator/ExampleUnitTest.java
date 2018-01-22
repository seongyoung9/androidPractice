package com.example.administrator.gridcalculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        String infixExp = "(12+3)*2";
        System.out.println("중위 표기법 " + infixExp );

        Calc c = new Calc();

        // 수식 검증
        if (!c.bracketsBalance(infixExp)) {
            System.out.println("괄호를 정확히 하세요~");
            System.exit(1);
        }

        // 중위 표기법을 후위 표기법으로 바꾸기
        String postfixExp = c.postfix(infixExp);
        System.out.println("후위 표기법 : " + postfixExp);

        // 후위 표기법을 이용하여 수식 계산
        Double result = c.result(postfixExp);

        // 결과 출력
        System.out.println("The result = " + result);
    }


    @Test
    public void addition_isCorrect1() throws Exception {

        String infixExp = "(12+3)×2588712";

        Calc c = new Calc();

        String[] array = {"+","-","×","÷"};


        int cnt = c.getLastIndex(infixExp, array);
        assertEquals(6,cnt);
        assertEquals(5,infixExp.length()-cnt-1);

    }
}