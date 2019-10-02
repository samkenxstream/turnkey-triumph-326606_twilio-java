/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1.session;

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

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class WebhookCreator extends Creator<Webhook> {
    private final String pathSessionSid;
    private final Webhook.Target target;
    private String configurationUrl;
    private Webhook.Method configurationMethod;
    private List<String> configurationFilters;
    private List<String> configurationTriggers;
    private String configurationFlowSid;
    private Integer configurationRetryCount;
    private Integer configurationReplayAfter;
    private Boolean configurationBufferMessages;
    private Integer configurationBufferWindow;

    /**
     * Construct a new WebhookCreator.
     *
     * @param pathSessionSid The SID of the Session for the webhook
     * @param target The target of the webhook
     */
    public WebhookCreator(final String pathSessionSid,
                          final Webhook.Target target) {
        this.pathSessionSid = pathSessionSid;
        this.target = target;
    }

    /**
     * The absolute URL the webhook request should be sent to..
     *
     * @param configurationUrl The absolute URL the webhook request should be sent
     *                         to
     * @return this
     */
    public WebhookCreator setConfigurationUrl(final String configurationUrl) {
        this.configurationUrl = configurationUrl;
        return this;
    }

    /**
     * The HTTP method we should use when sending a webhook request to `url`. Can be
     * `POST` or `GET`..
     *
     * @param configurationMethod The HTTP method we should use when sending a
     *                            webhook request to url
     * @return this
     */
    public WebhookCreator setConfigurationMethod(final Webhook.Method configurationMethod) {
        this.configurationMethod = configurationMethod;
        return this;
    }

    /**
     * The list of events that trigger a webhook event for the Session..
     *
     * @param configurationFilters The list of events that trigger a webhook event
     *                             for the Session
     * @return this
     */
    public WebhookCreator setConfigurationFilters(final List<String> configurationFilters) {
        this.configurationFilters = configurationFilters;
        return this;
    }

    /**
     * The list of events that trigger a webhook event for the Session..
     *
     * @param configurationFilters The list of events that trigger a webhook event
     *                             for the Session
     * @return this
     */
    public WebhookCreator setConfigurationFilters(final String configurationFilters) {
        return setConfigurationFilters(Promoter.listOfOne(configurationFilters));
    }

    /**
     * The list of keywords, firing webhook event for the Session..
     *
     * @param configurationTriggers The list of keywords, firing webhook event for
     *                              the Session
     * @return this
     */
    public WebhookCreator setConfigurationTriggers(final List<String> configurationTriggers) {
        this.configurationTriggers = configurationTriggers;
        return this;
    }

    /**
     * The list of keywords, firing webhook event for the Session..
     *
     * @param configurationTriggers The list of keywords, firing webhook event for
     *                              the Session
     * @return this
     */
    public WebhookCreator setConfigurationTriggers(final String configurationTriggers) {
        return setConfigurationTriggers(Promoter.listOfOne(configurationTriggers));
    }

    /**
     * The SID of the studio flow where the webhook should be sent to..
     *
     * @param configurationFlowSid The SID of the studio flow where the webhook
     *                             should be sent to
     * @return this
     */
    public WebhookCreator setConfigurationFlowSid(final String configurationFlowSid) {
        this.configurationFlowSid = configurationFlowSid;
        return this;
    }

    /**
     * The number of times to call the webhook request if the first attempt fails.
     * Can be up to 3 and the default is 0..
     *
     * @param configurationRetryCount The number of times to call the webhook
     *                                request if the first attempt fails
     * @return this
     */
    public WebhookCreator setConfigurationRetryCount(final Integer configurationRetryCount) {
        this.configurationRetryCount = configurationRetryCount;
        return this;
    }

    /**
     * The message index for which and its successors the webhook will be replayed.
     * Not set by default..
     *
     * @param configurationReplayAfter The message index for which and its
     *                                 successors the webhook will be replayed
     * @return this
     */
    public WebhookCreator setConfigurationReplayAfter(final Integer configurationReplayAfter) {
        this.configurationReplayAfter = configurationReplayAfter;
        return this;
    }

    /**
     * Whether buffering should be applied to messages. Not set by default..
     *
     * @param configurationBufferMessages Whether buffering should be applied to
     *                                    messages
     * @return this
     */
    public WebhookCreator setConfigurationBufferMessages(final Boolean configurationBufferMessages) {
        this.configurationBufferMessages = configurationBufferMessages;
        return this;
    }

    /**
     * The period to buffer messages in milliseconds. Default is 3,000 ms..
     *
     * @param configurationBufferWindow The period to buffer messages
     * @return this
     */
    public WebhookCreator setConfigurationBufferWindow(final Integer configurationBufferWindow) {
        this.configurationBufferWindow = configurationBufferWindow;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Webhook
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Webhook create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.MESSAGING.toString(),
            "/v1/Sessions/" + this.pathSessionSid + "/Webhooks",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Webhook creation failed: Unable to connect to server");
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

        return Webhook.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (target != null) {
            request.addPostParam("Target", target.toString());
        }

        if (configurationUrl != null) {
            request.addPostParam("Configuration.Url", configurationUrl);
        }

        if (configurationMethod != null) {
            request.addPostParam("Configuration.Method", configurationMethod.toString());
        }

        if (configurationFilters != null) {
            for (String prop : configurationFilters) {
                request.addPostParam("Configuration.Filters", prop);
            }
        }

        if (configurationTriggers != null) {
            for (String prop : configurationTriggers) {
                request.addPostParam("Configuration.Triggers", prop);
            }
        }

        if (configurationFlowSid != null) {
            request.addPostParam("Configuration.FlowSid", configurationFlowSid);
        }

        if (configurationRetryCount != null) {
            request.addPostParam("Configuration.RetryCount", configurationRetryCount.toString());
        }

        if (configurationReplayAfter != null) {
            request.addPostParam("Configuration.ReplayAfter", configurationReplayAfter.toString());
        }

        if (configurationBufferMessages != null) {
            request.addPostParam("Configuration.BufferMessages", configurationBufferMessages.toString());
        }

        if (configurationBufferWindow != null) {
            request.addPostParam("Configuration.BufferWindow", configurationBufferWindow.toString());
        }
    }
}