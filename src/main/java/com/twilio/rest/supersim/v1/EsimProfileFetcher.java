/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.supersim.v1;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class EsimProfileFetcher extends Fetcher<EsimProfile> {
    private final String pathSid;

    /**
     * Construct a new EsimProfileFetcher.
     *
     * @param pathSid The SID of the eSIM Profile resource to fetch
     */
    public EsimProfileFetcher(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched EsimProfile
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public EsimProfile fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.SUPERSIM.toString(),
            "/v1/ESimProfiles/" + this.pathSid + ""
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("EsimProfile fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return EsimProfile.fromJson(response.getStream(), client.getObjectMapper());
    }
}