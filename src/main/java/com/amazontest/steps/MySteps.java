package com.amazontest.steps;

import org.jbehave.core.annotations.*;
import java.util.List;

public class MySteps {
    protected ApacheHttpClientGet apacheHttpClientGet = new ApacheHttpClientGet();

//    @When("I send a search request to the: '$isurl'")
//    public void sendRequest(String isurl)  {
//    apacheHttpClientGet.HTTPGet(isurl);
//}
    @When("I select tab Dashboard $isurl")
    public void selectTabDashboard(String isurl){
        apacheHttpClientGet.HTTPGet(isurl);
    }
}
