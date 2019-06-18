package testcases;

import models.Users;
import org.testng.Assert;
import org.testng.annotations.Test;
import resource.ApiResource;

public class TestcaseOne extends TestBaseSetup{

    @Test
    public void testOneGetApi(){
        Users users = ApiResource.getUsersForPageTwo();
        Assert.assertNotNull(users.getPage(), "Page is null");
    }
}
