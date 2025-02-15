/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.flexapi.v1.interaction;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class InteractionChannelFetcher extends Fetcher<InteractionChannel> {
    private final String pathInteractionSid;
    private final String pathSid;

    /**
     * Construct a new InteractionChannelFetcher.
     *
     * @param pathInteractionSid The Interaction Sid for this channel.
     * @param pathSid The Channel Sid for this Participant.
     */
    public InteractionChannelFetcher(final String pathInteractionSid,
                                     final String pathSid) {
        this.pathInteractionSid = pathInteractionSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched InteractionChannel
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public InteractionChannel fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.FLEXAPI.toString(),
            "/v1/Interactions/" + this.pathInteractionSid + "/Channels/" + this.pathSid + ""
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("InteractionChannel fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return InteractionChannel.fromJson(response.getStream(), client.getObjectMapper());
    }
}