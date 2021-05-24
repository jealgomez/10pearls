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
public class ActorsControllerTest {

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
        TestWatchman.watchman.registerClass(ActorsControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(ActorsControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests updating avatar url of actor
     */
    @Test
    @Order(1)
    public void updateAvatarUrl() throws Exception {
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
                .andExpect(status().isOk());

        /**
         *
         * Update avatar URL of actor id 2
         *
         * The request body is:
         * {
         *     "id": 2,
         *     "login": "nicole48",
         *     "avatar_url": "https://avatars.com/2/nicole48"
         * }
         */
        json = "{\"id\": 2, \"login\": \"nicole48\", \"avatar_url\": \"https://avatars.com/2/nicole48\"}";

        mockMvc.perform(
                put("/actors")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isOk());

        /**
         *
         * Update avatar URL of actor id 3
         *
         * The request body is:
         * {
         *     "id": 3,
         *     "login": "jade33",
         *     "avatar_url": "https://avatars.com/3/jade33"
         * }
         */
        json = "{\"id\": 3, \"login\": \"jade33\", \"avatar_url\": \"https://avatars.com/3/jade33\"}";

        mockMvc.perform(
                put("/actors")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isOk());
    }

    /**
     *
     * @throws Exception
     *
     * It tests updating avatar url and login of actor
     */
    @Test
    @Order(2)
    public void updateAvatarUrlAndLogin() throws Exception {
        /**
         *
         * Update avatar URL of actor id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "login": "1_davidwright",
         *     "avatar_url": "https://avatars.com/1/davidwright"
         * }
         */
        String json = "{\"id\": 1, \"login\": \"1_davidwright\", \"avatar_url\": \"https://avatars.com/1/davidwright\"}";

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
     * It tests updating avatar url of non-existing actor
     */
    @Test
    @Order(3)
    public void updateAvatarUrlOfNonExistingActor() throws Exception {
        /**
         *
         * Update avatar URL of actor id 8
         *
         * The request body is:
         * {
         *     "id": 8,
         *     "login": 8,
         *     "avatar_url": "https://avatars.com/8"
         * }
         */
        String json = "{\"id\": 8, \"login\": 8, \"avatar_url\": \"https://avatars.com/8\"}";

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
    @Order(4)
    public void findAllActors() throws Exception {
        /**
         *
         * Find all the actors
         *
         * The request response is:
         * [
         *     {
         *         "id": 1,
         *         "login": "davidwright",
         *         "avatar_url": "https://avatars.com/1/davidwright"
         *     },
         *     {
         *         "id": 5,
         *         "login": "christine20",
         *         "avatar_url": "https://avatars.com/christine20"
         *     },
         *     {
         *         "id": 6,
         *         "login": "carolpatterson",
         *         "avatar_url": "https://avatars.com/carolpatterson"
         *     },
         *     {
         *         "id": 4,
         *         "login": "kbass",
         *         "avatar_url": "https://avatars.com/kbass"
         *     },
         *     {
         *         "id": 2,
         *         "login": "nicole48",
         *         "avatar_url": "https://avatars.com/2/nicole48"
         *     },
         *     {
         *         "id": 3,
         *         "login": "jade33",
         *         "avatar_url": "https://avatars.com/3/jade33"
         *     }
         * ]
         */
        String res = "[{\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/1/davidwright\"}, {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, {\"id\": 4, \"login\": \"kbass\", \"avatar_url\": \"https://avatars.com/kbass\"}, {\"id\": 2, \"login\": \"nicole48\", \"avatar_url\": \"https://avatars.com/2/nicole48\"}, {\"id\": 3, \"login\": \"jade33\", \"avatar_url\": \"https://avatars.com/3/jade33\"}]";

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
