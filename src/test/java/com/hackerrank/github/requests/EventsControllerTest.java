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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(OrderedTestRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventsControllerTest {

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
        TestWatchman.watchman.registerClass(EventsControllerTest.class);
    }

    @AfterClass
    public static void tearDownClass() {
        TestWatchman.watchman.createReport(EventsControllerTest.class);
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating an event
     */
    @Test
    @Order(1)
    public void createEvent() throws Exception {
        /**
         *
         * Create event with id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 1,
         *         "login": "davidwright",
         *         "avatar_url": "https://avatars.com/davidwright"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-28 06:12:46"
         * }
         */
        String json = "{\"id\": 1, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-28 06:12:46\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 2
         *
         * The request body is:
         * {
         *     "id": 2,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 1,
         *         "login": "davidwright",
         *         "avatar_url": "https://avatars.com/davidwright"
         *     },
         *     "repo": {
         *         "id": 2,
         *         "name": "allen/facere",
         *         "url": "https://github.com/allen/facere"
         *     },
         *     "created_at": "2018-12-28 06:24:37"
         * }
         */
        json = "{\"id\": 2, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-28 06:24:37\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 3
         *
         * The request body is:
         * {
         *     "id": 3,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 3,
         *         "login": "jade33",
         *         "avatar_url": "https://avatars.com/jade33"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-28 22:31:59"
         * }
         */
        json = "{\"id\": 3, \"type\": \"PushEvent\", \"actor\": {\"id\": 3, \"login\": \"jade33\", \"avatar_url\": \"https://avatars.com/jade33\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-28 22:31:59\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 4
         *
         * The request body is:
         * {
         *     "id": 4,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 5,
         *         "login": "christine20",
         *         "avatar_url": "https://avatars.com/christine20"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-29 03:38:10"
         * }
         */
        json = "{\"id\": 4, \"type\": \"PushEvent\", \"actor\": {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 03:38:10\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 5
         *
         * The request body is:
         * {
         *     "id": 5,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 6,
         *         "login": "carolpatterson",
         *         "avatar_url": "https://avatars.com/carolpatterson"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-29 12:52:48"
         * }
         */
        json = "{\"id\": 5, \"type\": \"PushEvent\", \"actor\": {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 12:52:48\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 6
         *
         * The request body is:
         * {
         *     "id": 6,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 1,
         *         "login": "davidwright",
         *         "avatar_url": "https://avatars.com/davidwright"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-29 13:51:54"
         * }
         */
        json = "{\"id\": 6, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 13:51:54\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 7
         *
         * The request body is:
         * {
         *     "id": 7,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 6,
         *         "login": "carolpatterson",
         *         "avatar_url": "https://avatars.com/carolpatterson"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-29 15:34:33"
         * }
         */
        json = "{\"id\": 7, \"type\": \"PushEvent\", \"actor\": {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 15:34:33\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 8
         *
         * The request body is:
         * {
         *     "id": 8,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 1,
         *         "login": "davidwright",
         *         "avatar_url": "https://avatars.com/davidwright"
         *     },
         *     "repo": {
         *         "id": 2,
         *         "name": "allen/facere",
         *         "url": "https://github.com/allen/facere"
         *     },
         *     "created_at": "2018-12-29 17:59:41"
         * }
         */
        json = "{\"id\": 8, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-29 17:59:41\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 9
         *
         * The request body is:
         * {
         *     "id": 9,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 6,
         *         "login": "carolpatterson",
         *         "avatar_url": "https://avatars.com/carolpatterson"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-29 19:53:25"
         * }
         */
        json = "{\"id\": 9, \"type\": \"PushEvent\", \"actor\": {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 19:53:25\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 10
         *
         * The request body is:
         * {
         *     "id": 10,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 2,
         *         "login": "nicole48",
         *         "avatar_url": "https://avatars.com/nicole48"
         *     },
         *     "repo": {
         *         "id": 2,
         *         "name": "allen/facere",
         *         "url": "https://github.com/allen/facere"
         *     },
         *     "created_at": "2018-12-29 20:43:02"
         * }
         */
        json = "{\"id\": 10, \"type\": \"PushEvent\", \"actor\": {\"id\": 2, \"login\": \"nicole48\", \"avatar_url\": \"https://avatars.com/nicole48\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-29 20:43:02\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 11
         *
         * The request body is:
         * {
         *     "id": 11,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 5,
         *         "login": "christine20",
         *         "avatar_url": "https://avatars.com/christine20"
         *     },
         *     "repo": {
         *         "id": 2,
         *         "name": "allen/facere",
         *         "url": "https://github.com/allen/facere"
         *     },
         *     "created_at": "2018-12-30 02:17:08"
         * }
         */
        json = "{\"id\": 11, \"type\": \"PushEvent\", \"actor\": {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-30 02:17:08\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 12
         *
         * The request body is:
         * {
         *     "id": 12,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 3,
         *         "login": "jade33",
         *         "avatar_url": "https://avatars.com/jade33"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-30 18:59:20"
         * }
         */
        json = "{\"id\": 12, \"type\": \"PushEvent\", \"actor\": {\"id\": 3, \"login\": \"jade33\", \"avatar_url\": \"https://avatars.com/jade33\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-30 18:59:20\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 13
         *
         * The request body is:
         * {
         *     "id": 13,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 1,
         *         "login": "davidwright",
         *         "avatar_url": "https://avatars.com/davidwright"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-30 19:54:40"
         * }
         */
        json = "{\"id\": 13, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-30 19:54:40\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 14
         *
         * The request body is:
         * {
         *     "id": 14,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 2,
         *         "login": "nicole48",
         *         "avatar_url": "https://avatars.com/nicole48"
         *     },
         *     "repo": {
         *         "id": 2,
         *         "name": "allen/facere",
         *         "url": "https://github.com/allen/facere"
         *     },
         *     "created_at": "2018-12-31 20:21:24"
         * }
         */
        json = "{\"id\": 14, \"type\": \"PushEvent\", \"actor\": {\"id\": 2, \"login\": \"nicole48\", \"avatar_url\": \"https://avatars.com/nicole48\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-31 20:21:24\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 15
         *
         * The request body is:
         * {
         *     "id": 15,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 3,
         *         "login": "jade33",
         *         "avatar_url": "https://avatars.com/jade33"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2019-01-01 03:46:48"
         * }
         */
        json = "{\"id\": 15, \"type\": \"PushEvent\", \"actor\": {\"id\": 3, \"login\": \"jade33\", \"avatar_url\": \"https://avatars.com/jade33\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2019-01-01 03:46:48\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 16
         *
         * The request body is:
         * {
         *     "id": 16,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 2,
         *         "login": "nicole48",
         *         "avatar_url": "https://avatars.com/nicole48"
         *     },
         *     "repo": {
         *         "id": 2,
         *         "name": "allen/facere",
         *         "url": "https://github.com/allen/facere"
         *     },
         *     "created_at": "2019-01-01 15:24:13"
         * }
         */
        json = "{\"id\": 16, \"type\": \"PushEvent\", \"actor\": {\"id\": 2, \"login\": \"nicole48\", \"avatar_url\": \"https://avatars.com/nicole48\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2019-01-01 15:24:13\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 17
         *
         * The request body is:
         * {
         *     "id": 17,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 6,
         *         "login": "carolpatterson",
         *         "avatar_url": "https://avatars.com/carolpatterson"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2019-01-01 15:24:13"
         * }
         */
        json = "{\"id\": 17, \"type\": \"PushEvent\", \"actor\": {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2019-01-01 15:24:13\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 18
         *
         * The request body is:
         * {
         *     "id": 18,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 4,
         *         "login": "kbass",
         *         "avatar_url": "https://avatars.com/kbass"
         *     },
         *     "repo": {
         *         "id": 3,
         *         "name": "cochran/perspiciatis",
         *         "url": "https://github.com/cochran/perspiciatis"
         *     },
         *     "created_at": "2019-01-01 16:57:48"
         * }
         */
        json = "{\"id\": 18, \"type\": \"PushEvent\", \"actor\": {\"id\": 4, \"login\": \"kbass\", \"avatar_url\": \"https://avatars.com/kbass\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-01 16:57:48\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 19
         *
         * The request body is:
         * {
         *     "id": 19,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 5,
         *         "login": "christine20",
         *         "avatar_url": "https://avatars.com/christine20"
         *     },
         *     "repo": {
         *         "id": 3,
         *         "name": "cochran/perspiciatis",
         *         "url": "https://github.com/cochran/perspiciatis"
         *     },
         *     "created_at": "2019-01-01 22:35:59"
         * }
         */
        json = "{\"id\": 19, \"type\": \"PushEvent\", \"actor\": {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-01 22:35:59\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 20
         *
         * The request body is:
         * {
         *     "id": 20,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 4,
         *         "login": "kbass",
         *         "avatar_url": "https://avatars.com/kbass"
         *     },
         *     "repo": {
         *         "id": 3,
         *         "name": "cochran/perspiciatis",
         *         "url": "https://github.com/cochran/perspiciatis"
         *     },
         *     "created_at": "2019-01-02 16:43:12"
         * }
         */
        json = "{\"id\": 20, \"type\": \"PushEvent\", \"actor\": {\"id\": 4, \"login\": \"kbass\", \"avatar_url\": \"https://avatars.com/kbass\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-02 16:43:12\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 21
         *
         * The request body is:
         * {
         *     "id": 21,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 4,
         *         "login": "kbass",
         *         "avatar_url": "https://avatars.com/kbass"
         *     },
         *     "repo": {
         *         "id": 3,
         *         "name": "cochran/perspiciatis",
         *         "url": "https://github.com/cochran/perspiciatis"
         *     },
         *     "created_at": "2019-01-03 13:37:04"
         * }
         */
        json = "{\"id\": 21, \"type\": \"PushEvent\", \"actor\": {\"id\": 4, \"login\": \"kbass\", \"avatar_url\": \"https://avatars.com/kbass\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-03 13:37:04\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());

        /**
         *
         * Create event with id 22
         *
         * The request body is:
         * {
         *     "id": 22,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 5,
         *         "login": "christine20",
         *         "avatar_url": "https://avatars.com/christine20"
         *     },
         *     "repo": {
         *         "id": 3,
         *         "name": "cochran/perspiciatis",
         *         "url": "https://github.com/cochran/perspiciatis"
         *     },
         *     "created_at": "2019-01-03 13:37:04"
         * }
         */
        json = "{\"id\": 22, \"type\": \"PushEvent\", \"actor\": {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-03 13:37:04\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isCreated());
    }

    /**
     *
     * @throws Exception
     *
     * It tests creating an event
     */
    @Test
    @Order(2)
    public void createEventWithExistingId() throws Exception {
        /**
         *
         * Create event with existing id 1
         *
         * The request body is:
         * {
         *     "id": 1,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 1,
         *         "login": "davidwright",
         *         "avatar_url": "https://avatars.com/davidwright"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-28 06:12:46"
         * }
         */
        String json = "{\"id\": 1, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-28 06:12:46\"}";

        mockMvc.perform(
                post("/events")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json)
        )
                .andExpect(status().isBadRequest());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding an event
     */
    @Test
    @Order(3)
    public void findEventById() throws Exception {
        /**
         *
         * Find event by id 1
         *
         * The request response is:
         * {
         *     "id": 1,
         *     "type": "PushEvent",
         *     "actor": {
         *         "id": 1,
         *         "login": "davidwright",
         *         "avatar_url": "https://avatars.com/davidwright"
         *     },
         *     "repo": {
         *         "id": 1,
         *         "name": "smith/neque",
         *         "url": "https://github.com/smith/neque"
         *     },
         *     "created_at": "2018-12-28 06:12:46"
         * }
         */
        String res = "{\"id\": 1, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-28 06:12:46\"}";

        assertTrue(
                ResultMatcher.matchJson(
                        mockMvc.perform(get("/events/1"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding an event
     */
    @Test
    @Order(4)
    public void findEventByNonExistingId() throws Exception {
        /**
         *
         * Find event by non-existing id 23
         */
        mockMvc.perform(get("/events/23"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding events by actor id
     */
    @Test
    @Order(5)
    public void findAllEventsByActorId() throws Exception {
        /**
         *
         * Find all the events by actor id 1
         *
         * The request response is:
         * [
         *     {
         *         "id": 1,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-28 06:12:46"
         *     },
         *     {
         *         "id": 2,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 2,
         *             "name": "allen/facere",
         *             "url": "https://github.com/allen/facere"
         *         },
         *         "created_at": "2018-12-28 06:24:37"
         *     },
         *     {
         *         "id": 6,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-29 13:51:54"
         *     },
         *     {
         *         "id": 8,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 2,
         *             "name": "allen/facere",
         *             "url": "https://github.com/allen/facere"
         *         },
         *         "created_at": "2018-12-29 17:59:41"
         *     },
         *     {
         *         "id": 13,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-30 19:54:40"
         *     }
         * ]
         */
        String res = "[{\"id\": 1, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-28 06:12:46\"}, {\"id\": 2, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-28 06:24:37\"}, {\"id\": 6, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 13:51:54\"}, {\"id\": 8, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-29 17:59:41\"}, {\"id\": 13, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-30 19:54:40\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/events/actors/1"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding events by non-existing actor id
     */
    @Test
    @Order(6)
    public void findAllEventsByNonExistingActorId() throws Exception {
        /**
         *
         * Find all the events by actor id 7
         */
        mockMvc.perform(get("/events/actors/7"))
                .andExpect(status().isNotFound());
    }

    /**
     *
     * @throws Exception
     *
     * It tests finding all the events
     */
    @Test
    @Order(7)
    public void findAllEvents() throws Exception {
        /**
         *
         * Find all the events
         *
         * The request response is:
         * [
         *     {
         *         "id": 1,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-28 06:12:46"
         *     },
         *     {
         *         "id": 2,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 2,
         *             "name": "allen/facere",
         *             "url": "https://github.com/allen/facere"
         *         },
         *         "created_at": "2018-12-28 06:24:37"
         *     },
         *     {
         *         "id": 3,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 3,
         *             "login": "jade33",
         *             "avatar_url": "https://avatars.com/jade33"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-28 22:31:59"
         *     },
         *     {
         *         "id": 4,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 5,
         *             "login": "christine20",
         *             "avatar_url": "https://avatars.com/christine20"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-29 03:38:10"
         *     },
         *     {
         *         "id": 5,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 6,
         *             "login": "carolpatterson",
         *             "avatar_url": "https://avatars.com/carolpatterson"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-29 12:52:48"
         *     },
         *     {
         *         "id": 6,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-29 13:51:54"
         *     },
         *     {
         *         "id": 7,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 6,
         *             "login": "carolpatterson",
         *             "avatar_url": "https://avatars.com/carolpatterson"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-29 15:34:33"
         *     },
         *     {
         *         "id": 8,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 2,
         *             "name": "allen/facere",
         *             "url": "https://github.com/allen/facere"
         *         },
         *         "created_at": "2018-12-29 17:59:41"
         *     },
         *     {
         *         "id": 9,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 6,
         *             "login": "carolpatterson",
         *             "avatar_url": "https://avatars.com/carolpatterson"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-29 19:53:25"
         *     },
         *     {
         *         "id": 10,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 2,
         *             "login": "nicole48",
         *             "avatar_url": "https://avatars.com/nicole48"
         *         },
         *         "repo": {
         *             "id": 2,
         *             "name": "allen/facere",
         *             "url": "https://github.com/allen/facere"
         *         },
         *         "created_at": "2018-12-29 20:43:02"
         *     },
         *     {
         *         "id": 11,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 5,
         *             "login": "christine20",
         *             "avatar_url": "https://avatars.com/christine20"
         *         },
         *         "repo": {
         *             "id": 2,
         *             "name": "allen/facere",
         *             "url": "https://github.com/allen/facere"
         *         },
         *         "created_at": "2018-12-30 02:17:08"
         *     },
         *     {
         *         "id": 12,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 3,
         *             "login": "jade33",
         *             "avatar_url": "https://avatars.com/jade33"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-30 18:59:20"
         *     },
         *     {
         *         "id": 13,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 1,
         *             "login": "davidwright",
         *             "avatar_url": "https://avatars.com/davidwright"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2018-12-30 19:54:40"
         *     },
         *     {
         *         "id": 14,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 2,
         *             "login": "nicole48",
         *             "avatar_url": "https://avatars.com/nicole48"
         *         },
         *         "repo": {
         *             "id": 2,
         *             "name": "allen/facere",
         *             "url": "https://github.com/allen/facere"
         *         },
         *         "created_at": "2018-12-31 20:21:24"
         *     },
         *     {
         *         "id": 15,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 3,
         *             "login": "jade33",
         *             "avatar_url": "https://avatars.com/jade33"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2019-01-01 03:46:48"
         *     },
         *     {
         *         "id": 16,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 2,
         *             "login": "nicole48",
         *             "avatar_url": "https://avatars.com/nicole48"
         *         },
         *         "repo": {
         *             "id": 2,
         *             "name": "allen/facere",
         *             "url": "https://github.com/allen/facere"
         *         },
         *         "created_at": "2019-01-01 15:24:13"
         *     },
         *     {
         *         "id": 17,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 6,
         *             "login": "carolpatterson",
         *             "avatar_url": "https://avatars.com/carolpatterson"
         *         },
         *         "repo": {
         *             "id": 1,
         *             "name": "smith/neque",
         *             "url": "https://github.com/smith/neque"
         *         },
         *         "created_at": "2019-01-01 15:24:13"
         *     },
         *     {
         *         "id": 18,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 4,
         *             "login": "kbass",
         *             "avatar_url": "https://avatars.com/kbass"
         *         },
         *         "repo": {
         *             "id": 3,
         *             "name": "cochran/perspiciatis",
         *             "url": "https://github.com/cochran/perspiciatis"
         *         },
         *         "created_at": "2019-01-01 16:57:48"
         *     },
         *     {
         *         "id": 19,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 5,
         *             "login": "christine20",
         *             "avatar_url": "https://avatars.com/christine20"
         *         },
         *         "repo": {
         *             "id": 3,
         *             "name": "cochran/perspiciatis",
         *             "url": "https://github.com/cochran/perspiciatis"
         *         },
         *         "created_at": "2019-01-01 22:35:59"
         *     },
         *     {
         *         "id": 20,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 4,
         *             "login": "kbass",
         *             "avatar_url": "https://avatars.com/kbass"
         *         },
         *         "repo": {
         *             "id": 3,
         *             "name": "cochran/perspiciatis",
         *             "url": "https://github.com/cochran/perspiciatis"
         *         },
         *         "created_at": "2019-01-02 16:43:12"
         *     },
         *     {
         *         "id": 21,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 4,
         *             "login": "kbass",
         *             "avatar_url": "https://avatars.com/kbass"
         *         },
         *         "repo": {
         *             "id": 3,
         *             "name": "cochran/perspiciatis",
         *             "url": "https://github.com/cochran/perspiciatis"
         *         },
         *         "created_at": "2019-01-03 13:37:04"
         *     },
         *     {
         *         "id": 22,
         *         "type": "PushEvent",
         *         "actor": {
         *             "id": 5,
         *             "login": "christine20",
         *             "avatar_url": "https://avatars.com/christine20"
         *         },
         *         "repo": {
         *             "id": 3,
         *             "name": "cochran/perspiciatis",
         *             "url": "https://github.com/cochran/perspiciatis"
         *         },
         *         "created_at": "2019-01-03 13:37:04"
         *     }
         * ]
         */
        String res = "[{\"id\": 1, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-28 06:12:46\"}, {\"id\": 2, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-28 06:24:37\"}, {\"id\": 3, \"type\": \"PushEvent\", \"actor\": {\"id\": 3, \"login\": \"jade33\", \"avatar_url\": \"https://avatars.com/jade33\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-28 22:31:59\"}, {\"id\": 4, \"type\": \"PushEvent\", \"actor\": {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 03:38:10\"}, {\"id\": 5, \"type\": \"PushEvent\", \"actor\": {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 12:52:48\"}, {\"id\": 6, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 13:51:54\"}, {\"id\": 7, \"type\": \"PushEvent\", \"actor\": {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 15:34:33\"}, {\"id\": 8, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-29 17:59:41\"}, {\"id\": 9, \"type\": \"PushEvent\", \"actor\": {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-29 19:53:25\"}, {\"id\": 10, \"type\": \"PushEvent\", \"actor\": {\"id\": 2, \"login\": \"nicole48\", \"avatar_url\": \"https://avatars.com/nicole48\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-29 20:43:02\"}, {\"id\": 11, \"type\": \"PushEvent\", \"actor\": {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-30 02:17:08\"}, {\"id\": 12, \"type\": \"PushEvent\", \"actor\": {\"id\": 3, \"login\": \"jade33\", \"avatar_url\": \"https://avatars.com/jade33\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-30 18:59:20\"}, {\"id\": 13, \"type\": \"PushEvent\", \"actor\": {\"id\": 1, \"login\": \"davidwright\", \"avatar_url\": \"https://avatars.com/davidwright\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2018-12-30 19:54:40\"}, {\"id\": 14, \"type\": \"PushEvent\", \"actor\": {\"id\": 2, \"login\": \"nicole48\", \"avatar_url\": \"https://avatars.com/nicole48\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2018-12-31 20:21:24\"}, {\"id\": 15, \"type\": \"PushEvent\", \"actor\": {\"id\": 3, \"login\": \"jade33\", \"avatar_url\": \"https://avatars.com/jade33\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2019-01-01 03:46:48\"}, {\"id\": 16, \"type\": \"PushEvent\", \"actor\": {\"id\": 2, \"login\": \"nicole48\", \"avatar_url\": \"https://avatars.com/nicole48\"}, \"repo\": {\"id\": 2, \"name\": \"allen/facere\", \"url\": \"https://github.com/allen/facere\"}, \"created_at\": \"2019-01-01 15:24:13\"}, {\"id\": 17, \"type\": \"PushEvent\", \"actor\": {\"id\": 6, \"login\": \"carolpatterson\", \"avatar_url\": \"https://avatars.com/carolpatterson\"}, \"repo\": {\"id\": 1, \"name\": \"smith/neque\", \"url\": \"https://github.com/smith/neque\"}, \"created_at\": \"2019-01-01 15:24:13\"}, {\"id\": 18, \"type\": \"PushEvent\", \"actor\": {\"id\": 4, \"login\": \"kbass\", \"avatar_url\": \"https://avatars.com/kbass\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-01 16:57:48\"}, {\"id\": 19, \"type\": \"PushEvent\", \"actor\": {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-01 22:35:59\"}, {\"id\": 20, \"type\": \"PushEvent\", \"actor\": {\"id\": 4, \"login\": \"kbass\", \"avatar_url\": \"https://avatars.com/kbass\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-02 16:43:12\"}, {\"id\": 21, \"type\": \"PushEvent\", \"actor\": {\"id\": 4, \"login\": \"kbass\", \"avatar_url\": \"https://avatars.com/kbass\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-03 13:37:04\"}, {\"id\": 22, \"type\": \"PushEvent\", \"actor\": {\"id\": 5, \"login\": \"christine20\", \"avatar_url\": \"https://avatars.com/christine20\"}, \"repo\": {\"id\": 3, \"name\": \"cochran/perspiciatis\", \"url\": \"https://github.com/cochran/perspiciatis\"}, \"created_at\": \"2019-01-03 13:37:04\"}]";

        assertTrue(
                ResultMatcher.matchJsonArray(
                        mockMvc.perform(get("/events"))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString(),
                        res,
                        true));
    }
}
