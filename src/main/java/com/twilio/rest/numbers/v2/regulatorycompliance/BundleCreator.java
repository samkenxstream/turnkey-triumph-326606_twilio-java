/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.numbers.v2.regulatorycompliance;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class BundleCreator extends Creator<Bundle> {
    private final String friendlyName;
    private final String email;
    private URI statusCallback;
    private String regulationSid;
    private String isoCountry;
    private Bundle.EndUserType endUserType;
    private String numberType;

    /**
     * Construct a new BundleCreator.
     *
     * @param friendlyName The string that you assigned to describe the resource
     * @param email The email address
     */
    public BundleCreator(final String friendlyName,
                         final String email) {
        this.friendlyName = friendlyName;
        this.email = email;
    }

    /**
     * The URL we call to inform your application of status changes..
     *
     * @param statusCallback The URL we call to inform your application of status
     *                       changes.
     * @return this
     */
    public BundleCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL we call to inform your application of status changes..
     *
     * @param statusCallback The URL we call to inform your application of status
     *                       changes.
     * @return this
     */
    public BundleCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The unique string of a regulation that is associated to the Bundle resource..
     *
     * @param regulationSid The unique string of a regulation.
     * @return this
     */
    public BundleCreator setRegulationSid(final String regulationSid) {
        this.regulationSid = regulationSid;
        return this;
    }

    /**
     * The <a href="https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO country
     * code</a> of the Bundle's phone number country ownership request..
     *
     * @param isoCountry The ISO country code of the country
     * @return this
     */
    public BundleCreator setIsoCountry(final String isoCountry) {
        this.isoCountry = isoCountry;
        return this;
    }

    /**
     * The <a
     * href="https://www.twilio.com/docs/phone-numbers/regulatory/api/end-user-types">type
     * of End User</a> of the Bundle resource..
     *
     * @param endUserType The type of End User of the Bundle resource
     * @return this
     */
    public BundleCreator setEndUserType(final Bundle.EndUserType endUserType) {
        this.endUserType = endUserType;
        return this;
    }

    /**
     * The type of phone number of the Bundle's ownership request. Can be `local`,
     * `mobile`, `national`, or `toll free`..
     *
     * @param numberType The type of phone number
     * @return this
     */
    public BundleCreator setNumberType(final String numberType) {
        this.numberType = numberType;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Bundle
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Bundle create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.NUMBERS.toString(),
            "/v2/RegulatoryCompliance/Bundles"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Bundle creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Bundle.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (email != null) {
            request.addPostParam("Email", email);
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (regulationSid != null) {
            request.addPostParam("RegulationSid", regulationSid);
        }

        if (isoCountry != null) {
            request.addPostParam("IsoCountry", isoCountry);
        }

        if (endUserType != null) {
            request.addPostParam("EndUserType", endUserType.toString());
        }

        if (numberType != null) {
            request.addPostParam("NumberType", numberType);
        }
    }
}