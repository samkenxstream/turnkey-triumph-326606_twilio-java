/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.flexapi.v1.interaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class InteractionChannelTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.FLEXAPI.toString(),
                                          "/v1/Interactions/KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Channels/UOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            InteractionChannel.fetcher("KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "UOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1\",\"type\": \"chat\",\"interaction_sid\": \"KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1\",\"links\": {\"participants\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1/Participants\",\"invites\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1/Invites\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(InteractionChannel.fetcher("KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "UOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").fetch());
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.FLEXAPI.toString(),
                                          "/v1/Interactions/KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Channels");

            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            InteractionChannel.reader("KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"channels\": [{\"sid\": \"UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1\",\"type\": \"chat\",\"interaction_sid\": \"KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1\",\"links\": {\"participants\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1/Participants\",\"invites\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1/Invites\"}},{\"sid\": \"UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2\",\"type\": \"sms\",\"interaction_sid\": \"KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"url\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2\",\"links\": {\"participants\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2/Participants\",\"invites\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa2/Invites\"}}],\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels?PageSize=50&Page=0\",\"previous_page_url\": null,\"url\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels?PageSize=50&Page=0\",\"next_page_url\": null,\"key\": \"channels\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        assertNotNull(InteractionChannel.reader("KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX").read());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.FLEXAPI.toString(),
                                          "/v1/Interactions/KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX/Channels/UOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            request.addPostParam("Status", serialize(InteractionChannel.Status.CLOSE));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};

        try {
            InteractionChannel.updater("KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "UOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", InteractionChannel.Status.CLOSE).update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1\",\"interaction_sid\": \"KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"type\": \"chat\",\"url\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1\",\"links\": {\"participants\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1/Participants\",\"invites\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1/Invites\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        InteractionChannel.updater("KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "UOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", InteractionChannel.Status.CLOSE).update();
    }

    @Test
    public void testUpdateStatusClosedResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"sid\": \"UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1\",\"interaction_sid\": \"KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"type\": \"chat\",\"url\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1\",\"links\": {\"participants\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1/Participants\",\"invites\": \"https://flex-api.twilio.com/v1/Interactions/KDaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa/Channels/UOaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa1/Invites\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};

        InteractionChannel.updater("KDXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "UOXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", InteractionChannel.Status.CLOSE).update();
    }
}