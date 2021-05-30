import com.app.brpm.RuleEngineApplication;
import com.app.brpm.model.Order;
import com.app.brpm.model.ProductDetails;
import com.app.brpm.model.ServiceId;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RuleEngineApplication.class)
public class RuleEngineTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;
    private ObjectMapper objectMapper;
    private static final String BASE_URL="http://localhost:8080/api/rule-engine/rules/payments/outcome";
    @Before
    public void setUp() {
        this.objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private MvcResult sendRequest(Order orderDetails) throws Exception {
        return mockMvc.perform(post(BASE_URL)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(orderDetails)))
                .andExpect(status().isOk()
                ).andReturn();
    }


    /*
    rule1  "generate a packing slip for shipping"
     */
    @Test
    public void verifyScenarioProductTypePhysical() throws Exception {
        Order orderDetails = new Order();
        orderDetails.setServiceId(ServiceId.payment);
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("xyz");
        productDetails.setType("physical product");
        orderDetails.setProductDetails(Arrays.asList(productDetails));

        MvcResult mvcResult = sendRequest(orderDetails);

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        productDetails.setActions(Arrays.asList("generate a packing slip for shipping", "generate a commission payment to the agent"));
        String expectedResponseBody = objectMapper.writeValueAsString(orderDetails);
        assertEquals(expectedResponseBody, actualResponseBody);
    }



    /*
    rule2 "create a duplicate packing slip for the royalty department"
     */
    @Test
    public void verifyScenarioProductTypeBook() throws Exception {
        Order orderDetails = new Order();
        orderDetails.setServiceId(ServiceId.payment);
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("xyz");
        productDetails.setType("book");
        orderDetails.setProductDetails(Arrays.asList(productDetails));

        MvcResult mvcResult = sendRequest(orderDetails);

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        productDetails.setActions(Arrays.asList("create duplicate parking slip for the royalty department",
                "generate a commission payment to the agent"));
        String expectedResponseBody = objectMapper.writeValueAsString(orderDetails);
        assertEquals(expectedResponseBody, actualResponseBody);
    }



    /*
    rule3 "activate new membership"
     */
    @Test
    public void verifyScenarioProductTypeActivateMembership() throws Exception {
        Order orderDetails = new Order();
        orderDetails.setServiceId(ServiceId.payment);
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("xyz");
        productDetails.setType("new membership");
        orderDetails.setProductDetails(Arrays.asList(productDetails));
        MvcResult mvcResult = sendRequest(orderDetails);
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        productDetails.setActions(Arrays.asList("Activate new membership",
                "Send Email notification"));
        String expectedResponseBody = objectMapper.writeValueAsString(orderDetails);
        assertEquals(expectedResponseBody, actualResponseBody);
    }

    /*
    rule4 "upgrade membership"
     */
    @Test
    public void verifyScenarioProductTypeUpgradeMembership() throws Exception {
        Order orderDetails = new Order();
        orderDetails.setServiceId(ServiceId.payment);
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("xyz");
        productDetails.setType("upgrade membership");
        orderDetails.setProductDetails(Arrays.asList(productDetails));
        MvcResult mvcResult = sendRequest(orderDetails);
        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        productDetails.setActions(Arrays.asList("Upgrade membership",
                "Send Email notification"));
        String expectedResponseBody = objectMapper.writeValueAsString(orderDetails);
        assertEquals(expectedResponseBody, actualResponseBody);
    }

    /*
    rule5  "Add free videos"
     */
    @Test
    public void verifyScenarioProductTypeVideoWithFreeVideos() throws Exception {
        Order orderDetails = new Order();
        orderDetails.setServiceId(ServiceId.payment);
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("Learning to ski");
        productDetails.setType("video");
        orderDetails.setProductDetails(Arrays.asList(productDetails));

        MvcResult mvcResult = sendRequest(orderDetails);

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        productDetails.setActions(Arrays.asList("Add Free 'First Aid Video' to Packing Slip"));
        String expectedResponseBody = objectMapper.writeValueAsString(orderDetails);
        assertEquals(expectedResponseBody, actualResponseBody);
    }


    /*
    rule6  "Buy videos"
     */
    @Test
    public void verifyScenarioProductTypeVideoWith() throws Exception {
        Order orderDetails = new Order();
        orderDetails.setServiceId(ServiceId.payment);
        ProductDetails productDetails = new ProductDetails();
        productDetails.setName("asdfasdf");
        productDetails.setType("video");
        orderDetails.setProductDetails(Arrays.asList(productDetails));

        MvcResult mvcResult = sendRequest(orderDetails);

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        productDetails.setActions(Arrays.asList("Purchase a video"));
        String expectedResponseBody = objectMapper.writeValueAsString(orderDetails);
        assertEquals(expectedResponseBody, actualResponseBody);
    }
}
