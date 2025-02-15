/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.media.v1.playerstreamer;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class PlaybackGrantFetcher extends Fetcher<PlaybackGrant> {
    private final String pathSid;

    /**
     * Construct a new PlaybackGrantFetcher.
     *
     * @param pathSid The SID that identifies the resource to fetch
     */
    public PlaybackGrantFetcher(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched PlaybackGrant
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public PlaybackGrant fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.MEDIA.toString(),
            "/v1/PlayerStreamers/" + this.pathSid + "/PlaybackGrant"
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("PlaybackGrant fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return PlaybackGrant.fromJson(response.getStream(), client.getObjectMapper());
    }
}