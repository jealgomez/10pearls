package com.hackerrank.github.requests;

import com.hackerrank.test.utility.Order;
import com.hackerrank.test.utility.OrderedTestRunner;
import com.hackerrank.test.utility.ResultMatcher;
import com.hackerrank.test.utility.TestWatchman;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoResourcesActorsControllerTest {

    @ClassRule
    public static final SpringClassRule springClassRule = new SpringClassRule();

    @Rule
    public final SpringMethodRule springMethodRule = new SpringMethodRule();
    
    @Rule
    public TestWatcher watchman = TestWatchman.watchman;
    
    @Autowired
    private MockMvc mockMvc;

    @BeforeClass
    public static void setUpClass() {
        TestWatchman.watchman.registerClass(NoResourcesActorsControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(NoResourcesActorsControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests updating avatar url of non-existing actor
     */
    @Test
    @Order(1)
    public void updateAvatarUrlOfNonExistingActor() throws Exception {
        /**
         *
         * Update avatar URL of actor id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "login": "davidwright",
         *     "avatar_url": "https://avatars.com/1/davidwright"
         * }
         */
        String json = "{\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/1/davidwright\"}";

        mockMvc.perform(
                put("/actors")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding all the actors
     */
    @Test
    @Order(2)
    public void findAllActors() throws Exception {
        /**
         *
         * Find all the actors
         *
         * The request response is:
         * []
         */
        String res = "[]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/actors"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }
}
