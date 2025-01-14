/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.wireless.v1;

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

import java.util.List;

public class RatePlanCreator extends Creator<RatePlan> {
    private String uniqueName;
    private String friendlyName;
    private Boolean dataEnabled;
    private Integer dataLimit;
    private String dataMetering;
    private Boolean messagingEnabled;
    private Boolean voiceEnabled;
    private Boolean nationalRoamingEnabled;
    private List<String> internationalRoaming;
    private Integer nationalRoamingDataLimit;
    private Integer internationalRoamingDataLimit;

    /**
     * An application-defined string that uniquely identifies the resource. It can
     * be used in place of the resource's `sid` in the URL to address the resource..
     *
     * @param uniqueName An application-defined string that uniquely identifies the
     *                   resource
     * @return this
     */
    public RatePlanCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    /**
     * A descriptive string that you create to describe the resource. It does not
     * have to be unique..
     *
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public RatePlanCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Whether SIMs can use GPRS/3G/4G/LTE data connectivity..
     *
     * @param dataEnabled Whether SIMs can use GPRS/3G/4G/LTE data connectivity
     * @return this
     */
    public RatePlanCreator setDataEnabled(final Boolean dataEnabled) {
        this.dataEnabled = dataEnabled;
        return this;
    }

    /**
     * The total data usage (download and upload combined) in Megabytes that the
     * Network allows during one month on the home network (T-Mobile USA). The
     * metering period begins the day of activation and ends on the same day in the
     * following month. Can be up to 2TB and the default value is `1000`..
     *
     * @param dataLimit The total data usage in Megabytes that the Network allows
     *                  during one month on the home network
     * @return this
     */
    public RatePlanCreator setDataLimit(final Integer dataLimit) {
        this.dataLimit = dataLimit;
        return this;
    }

    /**
     * The model used to meter data usage. Can be: `payg` and `quota-1`, `quota-10`,
     * and `quota-50`. Learn more about the available <a
     * href="https://www.twilio.com/docs/wireless/api/rateplan-resource#payg-vs-quota-data-plans">data
     * metering models</a>..
     *
     * @param dataMetering The model used to meter data usage
     * @return this
     */
    public RatePlanCreator setDataMetering(final String dataMetering) {
        this.dataMetering = dataMetering;
        return this;
    }

    /**
     * Whether SIMs can make, send, and receive SMS using <a
     * href="https://www.twilio.com/docs/wireless/api/command-resource">Commands</a>..
     *
     * @param messagingEnabled Whether SIMs can make, send, and receive SMS using
     *                         Commands
     * @return this
     */
    public RatePlanCreator setMessagingEnabled(final Boolean messagingEnabled) {
        this.messagingEnabled = messagingEnabled;
        return this;
    }

    /**
     * Deprecated..
     *
     * @param voiceEnabled Deprecated
     * @return this
     */
    public RatePlanCreator setVoiceEnabled(final Boolean voiceEnabled) {
        this.voiceEnabled = voiceEnabled;
        return this;
    }

    /**
     * Whether SIMs can roam on networks other than the home network (T-Mobile USA)
     * in the United States. See <a
     * href="https://www.twilio.com/docs/wireless/api/rateplan-resource#national-roaming">national
     * roaming</a>..
     *
     * @param nationalRoamingEnabled Whether SIMs can roam on networks other than
     *                               the home network in the United States
     * @return this
     */
    public RatePlanCreator setNationalRoamingEnabled(final Boolean nationalRoamingEnabled) {
        this.nationalRoamingEnabled = nationalRoamingEnabled;
        return this;
    }

    /**
     * The list of services that SIMs capable of using GPRS/3G/4G/LTE data
     * connectivity can use outside of the United States. Can contain: `data` and
     * `messaging`..
     *
     * @param internationalRoaming The services that SIMs capable of using
     *                             GPRS/3G/4G/LTE data connectivity can use outside
     *                             of the United States
     * @return this
     */
    public RatePlanCreator setInternationalRoaming(final List<String> internationalRoaming) {
        this.internationalRoaming = internationalRoaming;
        return this;
    }

    /**
     * The list of services that SIMs capable of using GPRS/3G/4G/LTE data
     * connectivity can use outside of the United States. Can contain: `data` and
     * `messaging`..
     *
     * @param internationalRoaming The services that SIMs capable of using
     *                             GPRS/3G/4G/LTE data connectivity can use outside
     *                             of the United States
     * @return this
     */
    public RatePlanCreator setInternationalRoaming(final String internationalRoaming) {
        return setInternationalRoaming(Promoter.listOfOne(internationalRoaming));
    }

    /**
     * The total data usage (download and upload combined) in Megabytes that the
     * Network allows during one month on non-home networks in the United States.
     * The metering period begins the day of activation and ends on the same day in
     * the following month. Can be up to 2TB. See <a
     * href="https://www.twilio.com/docs/wireless/api/rateplan-resource#national-roaming">national
     * roaming</a> for more info..
     *
     * @param nationalRoamingDataLimit The total data usage in Megabytes that the
     *                                 Network allows during one month on non-home
     *                                 networks in the United States
     * @return this
     */
    public RatePlanCreator setNationalRoamingDataLimit(final Integer nationalRoamingDataLimit) {
        this.nationalRoamingDataLimit = nationalRoamingDataLimit;
        return this;
    }

    /**
     * The total data usage (download and upload combined) in Megabytes that the
     * Network allows during one month when roaming outside the United States. Can
     * be up to 2TB..
     *
     * @param internationalRoamingDataLimit The total data usage (download and
     *                                      upload combined) in Megabytes that the
     *                                      Network allows during one month when
     *                                      roaming outside the United States
     * @return this
     */
    public RatePlanCreator setInternationalRoamingDataLimit(final Integer internationalRoamingDataLimit) {
        this.internationalRoamingDataLimit = internationalRoamingDataLimit;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created RatePlan
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public RatePlan create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.WIRELESS.toString(),
            "/v1/RatePlans"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("RatePlan creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return RatePlan.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (dataEnabled != null) {
            request.addPostParam("DataEnabled", dataEnabled.toString());
        }

        if (dataLimit != null) {
            request.addPostParam("DataLimit", dataLimit.toString());
        }

        if (dataMetering != null) {
            request.addPostParam("DataMetering", dataMetering);
        }

        if (messagingEnabled != null) {
            request.addPostParam("MessagingEnabled", messagingEnabled.toString());
        }

        if (voiceEnabled != null) {
            request.addPostParam("VoiceEnabled", voiceEnabled.toString());
        }

        if (nationalRoamingEnabled != null) {
            request.addPostParam("NationalRoamingEnabled", nationalRoamingEnabled.toString());
        }

        if (internationalRoaming != null) {
            for (String prop : internationalRoaming) {
                request.addPostParam("InternationalRoaming", prop);
            }
        }

        if (nationalRoamingDataLimit != null) {
            request.addPostParam("NationalRoamingDataLimit", nationalRoamingDataLimit.toString());
        }

        if (internationalRoamingDataLimit != null) {
            request.addPostParam("InternationalRoamingDataLimit", internationalRoamingDataLimit.toString());
        }
    }
}