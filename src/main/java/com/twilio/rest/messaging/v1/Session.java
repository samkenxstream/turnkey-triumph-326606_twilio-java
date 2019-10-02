/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Session extends Resource {
    private static final long serialVersionUID = 174532027123268L;

    /**
     * Create a SessionFetcher to execute fetch.
     *
     * @param pathSid The SID that identifies the resource to fetch
     * @return SessionFetcher capable of executing the fetch
     */
    public static SessionFetcher fetcher(final String pathSid) {
        return new SessionFetcher(pathSid);
    }

    /**
     * Create a SessionDeleter to execute delete.
     *
     * @param pathSid The SID that identifies the resource to delete
     * @return SessionDeleter capable of executing the delete
     */
    public static SessionDeleter deleter(final String pathSid) {
        return new SessionDeleter(pathSid);
    }

    /**
     * Create a SessionCreator to execute create.
     *
     * @param messagingServiceSid The SID of the SMS Service the session belongs to
     * @return SessionCreator capable of executing the create
     */
    public static SessionCreator creator(final String messagingServiceSid) {
        return new SessionCreator(messagingServiceSid);
    }

    /**
     * Create a SessionUpdater to execute update.
     *
     * @param pathSid The SID that identifies the resource to update
     * @return SessionUpdater capable of executing the update
     */
    public static SessionUpdater updater(final String pathSid) {
        return new SessionUpdater(pathSid);
    }

    /**
     * Create a SessionReader to execute read.
     *
     * @return SessionReader capable of executing the read
     */
    public static SessionReader reader() {
        return new SessionReader();
    }

    /**
     * Converts a JSON String into a Session object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Session object represented by the provided JSON
     */
    public static Session fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Session.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Session object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Session object represented by the provided JSON
     */
    public static Session fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Session.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String messagingServiceSid;
    private final String friendlyName;
    private final String attributes;
    private final String createdBy;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Session(@JsonProperty("sid")
                    final String sid,
                    @JsonProperty("account_sid")
                    final String accountSid,
                    @JsonProperty("service_sid")
                    final String serviceSid,
                    @JsonProperty("messaging_service_sid")
                    final String messagingServiceSid,
                    @JsonProperty("friendly_name")
                    final String friendlyName,
                    @JsonProperty("attributes")
                    final String attributes,
                    @JsonProperty("created_by")
                    final String createdBy,
                    @JsonProperty("date_created")
                    final String dateCreated,
                    @JsonProperty("date_updated")
                    final String dateUpdated,
                    @JsonProperty("url")
                    final URI url,
                    @JsonProperty("links")
                    final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.messagingServiceSid = messagingServiceSid;
        this.friendlyName = friendlyName;
        this.attributes = attributes;
        this.createdBy = createdBy;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The SID of the Service that the resource is associated with.
     *
     * @return The SID of the Service that the resource is associated with
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The SID of the SMS Service the session belongs to.
     *
     * @return The SID of the SMS Service the session belongs to
     */
    public final String getMessagingServiceSid() {
        return this.messagingServiceSid;
    }

    /**
     * Returns The The string that you assigned to describe the resource.
     *
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The JSON string that stores application-specific data.
     *
     * @return The JSON string that stores application-specific data
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * Returns The The Identity of the session's creator.
     *
     * @return The Identity of the session's creator
     */
    public final String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Returns The The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The ISO 8601 date and time in GMT when the resource was last
     * updated.
     *
     * @return The ISO 8601 date and time in GMT when the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The absolute URL of the session.
     *
     * @return The absolute URL of the session
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The The absolute URLs of the Participants, Interactions, and Messages
     * for the Session.
     *
     * @return The absolute URLs of the Participants, Interactions, and Messages
     *         for the Session
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Session other = (Session) o;

        return Objects.equals(sid, other.sid) &&
               Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(serviceSid, other.serviceSid) &&
               Objects.equals(messagingServiceSid, other.messagingServiceSid) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(attributes, other.attributes) &&
               Objects.equals(createdBy, other.createdBy) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url) &&
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            messagingServiceSid,
                            friendlyName,
                            attributes,
                            createdBy,
                            dateCreated,
                            dateUpdated,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("messagingServiceSid", messagingServiceSid)
                          .add("friendlyName", friendlyName)
                          .add("attributes", attributes)
                          .add("createdBy", createdBy)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}