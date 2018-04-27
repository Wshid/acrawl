package com.wshid.BO;

import org.springframework.stereotype.Service;


/**
 * @author wshid
 * @project acrawl
 * @date 2018. 4. 5. PM 2:08
 */
@Service
public class acrawlBO {
    /**
     * Business Object
     */


    public String printHelloWorld(){
        System.out.println("acrawlBO.HelloWorld!");
        return "Hello World in BO";
    }

    public String crawlingTest(){



        return null;
    }

}
