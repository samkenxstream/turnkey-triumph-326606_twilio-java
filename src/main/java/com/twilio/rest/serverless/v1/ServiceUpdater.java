/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class ServiceUpdater extends Updater<Service> {
    private final String pathSid;
    private Boolean includeCredentials;
    private String friendlyName;

    /**
     * Construct a new ServiceUpdater.
     *
     * @param pathSid The SID of the Service resource to update
     */
    public ServiceUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Whether to inject Account credentials into a function invocation context..
     *
     * @param includeCredentials Whether to inject Account credentials into a
     *                           function invocation context
     * @return this
     */
    public ServiceUpdater setIncludeCredentials(final Boolean includeCredentials) {
        this.includeCredentials = includeCredentials;
        return this;
    }

    /**
     * A descriptive string that you create to describe the Service resource. It can
     * be up to 255 characters long..
     *
     * @param friendlyName A string to describe the Service resource
     * @return this
     */
    public ServiceUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Service
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Service update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SERVERLESS.toString(),
            "/v1/Services/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Service update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Service.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (includeCredentials != null) {
            request.addPostParam("IncludeCredentials", includeCredentials.toString());
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
    }
}