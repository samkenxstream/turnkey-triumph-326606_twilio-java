/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.media.v1;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class MediaProcessorUpdater extends Updater<MediaProcessor> {
    private final String pathSid;
    private final MediaProcessor.UpdateStatus status;

    /**
     * Construct a new MediaProcessorUpdater.
     *
     * @param pathSid The SID that identifies the resource to update
     * @param status The status of the MediaProcessor
     */
    public MediaProcessorUpdater(final String pathSid,
                                 final MediaProcessor.UpdateStatus status) {
        this.pathSid = pathSid;
        this.status = status;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated MediaProcessor
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public MediaProcessor update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.MEDIA.toString(),
            "/v1/MediaProcessors/" + this.pathSid + ""
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("MediaProcessor update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return MediaProcessor.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());
        }
    }
}